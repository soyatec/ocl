/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.codegen.inliner.java;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalysis;
import org.eclipse.ocl.examples.codegen.generator.CodeGenSnippet;
import org.eclipse.ocl.examples.codegen.generator.CodeGenText;
import org.eclipse.ocl.examples.codegen.generator.GenModelException;
import org.eclipse.ocl.examples.codegen.generator.GenModelHelper;
import org.eclipse.ocl.examples.codegen.generator.java.JavaCodeGenerator;
import org.eclipse.ocl.examples.codegen.generator.java.JavaSnippet;
import org.eclipse.ocl.examples.codegen.inliner.AbstractInliner;
import org.eclipse.ocl.examples.codegen.inliner.PropertyInliner;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.PropertyId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractProperty;
import org.eclipse.ocl.examples.domain.library.LibraryFeature;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.TupleValue;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.DataType;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.PropertyCallExp;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.TupleType;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.library.CompositionProperty;
import org.eclipse.ocl.examples.pivot.library.ExplicitNavigationProperty;
import org.eclipse.ocl.examples.pivot.library.TuplePartProperty;

public class JavaInliners
{
	protected final @NonNull JavaCodeGenerator codeGenerator;
	protected final @NonNull Map<PropertyId, CodeGenSnippet> propertyInstances = new HashMap<PropertyId, CodeGenSnippet>();
	
	public JavaInliners(@NonNull JavaCodeGenerator codeGenerator) {
		this.codeGenerator = codeGenerator;
		codeGenerator.addInliner(CompositionProperty.class, new _ExplicitNavigationProperty(codeGenerator));
		codeGenerator.addInliner(ExplicitNavigationProperty.class, new _ExplicitNavigationProperty(codeGenerator));
		codeGenerator.addInliner(TuplePartProperty.class, new _TuplePartProperty(codeGenerator));
	}

	public static abstract class AbstractJavaPropertyInliner extends AbstractInliner implements PropertyInliner
	{
		public AbstractJavaPropertyInliner(@NonNull JavaCodeGenerator codeGenerator) {
			super(codeGenerator);
		}

		protected @Nullable Class<?> getReturnClass(@NonNull Property referredProperty) {		// FIXME share
			try {
				LibraryFeature implementation = codeGenerator.getMetaModelManager().getImplementation(referredProperty);
				@SuppressWarnings("null") @NonNull Class<? extends LibraryFeature> implementationClass = implementation.getClass();
				Method method = implementationClass.getMethod("evaluate", DomainEvaluator.class, TypeId.class, Object.class);
				return method.getReturnType();
			} catch (Exception e) {
				return null;
			}
		}
	}
	
	public static class UnboxedExplicitNavigationProperty extends AbstractProperty
	{
		protected @NonNull PropertyId propertyId;
//		protected @NonNull DomainProperty property;
		private EStructuralFeature eFeature = null;
		
		public UnboxedExplicitNavigationProperty(@NonNull PropertyId propertyId) {
			this.propertyId = propertyId;
			// DFIXME static attempt at eFeature
		}
		
//		public ExplicitNavigationProperty(@NonNull DomainProperty property) {
//			this.property = property;
//		}
		
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue) {
			assert sourceValue != null;
			EObject eObject = (EObject)sourceValue; 
			EStructuralFeature eFeature2 = eFeature;
			if (eFeature2 == null) {
				EClass eClass = eObject.eClass();
				eFeature = eFeature2 = eClass.getEStructuralFeature(propertyId.getName());
			}
			// A specialized property such as CollectionType.elementType is returned from the specialized type
			// An unspecialized property such as CollectionType.ownedOperation is returned from the unspecialized type
			if ((eObject instanceof Type) && !eObject.eIsSet(eFeature2)) {
				TemplateableElement rawType = ((Type)eObject).getUnspecializedElement();
				if (rawType != null) {
					eObject = rawType;
				}
			}
			if (eFeature2 != null) {
				Object eValue = eObject.eGet(eFeature2);
//				if (eValue != null) {
//					return valueOf(eValue, eFeature2, returnTypeId);
//				}
				return eValue;
			}
			return null;
		}
	}

	public class _ExplicitNavigationProperty extends AbstractJavaPropertyInliner
	{
		public _ExplicitNavigationProperty(@NonNull JavaCodeGenerator codeGenerator) {
			super(codeGenerator);
		}	

		protected @Nullable Class<?> getLeastDerivedClass(Class<?> requiredClass, @NonNull String getAccessor) {
			Class<?> superClass = requiredClass.getSuperclass();
			if (superClass != null) {
				try {
					Class<?> lessDerivedSuperClass = getLeastDerivedClass(superClass, getAccessor);
					if (lessDerivedSuperClass != null) {
						return lessDerivedSuperClass;
					}
					Method method = superClass.getMethod(getAccessor);
					if (method != null) {
						return superClass;
					}
				} catch (Exception e) {
				}
			}
			for (Class<?> superInterface : requiredClass.getInterfaces()) {
				Class<?> lessDerivedSuperInterface = getLeastDerivedClass(superInterface, getAccessor);
				if (lessDerivedSuperInterface != null) {
					return lessDerivedSuperInterface;
				}
				try {
					Method method = superInterface.getMethod(getAccessor);
					if (method != null) {
						return superInterface;
					}
				} catch (Exception e) {
				}
			}
			return null;
		}

		protected @Nullable Method getLeastDerivedMethod(Class<?> requiredClass, @NonNull String getAccessor) {
			Method leastDerivedMethod = getLeastDerivedMethodInternal(requiredClass, getAccessor);
			if (leastDerivedMethod != null) {
				return leastDerivedMethod;
			}
			else {
				try {
					return requiredClass.getMethod(getAccessor);
				} catch (Exception e) {
					return null;
				}
			}
		}
		private @Nullable Method getLeastDerivedMethodInternal(Class<?> requiredClass, @NonNull String getAccessor) {
			Class<?> superClass = requiredClass.getSuperclass();
			if (superClass != null) {
				try {
					Method lessDerivedSuperMethod = getLeastDerivedMethodInternal(superClass, getAccessor);
					if (lessDerivedSuperMethod != null) {
						return lessDerivedSuperMethod;
					}
					Method method = superClass.getMethod(getAccessor);
					if (method != null) {
						return method;
					}
				} catch (Exception e) {
				}
			}
			for (Class<?> superInterface : requiredClass.getInterfaces()) {
				Method lessDerivedSuperMethod = getLeastDerivedMethodInternal(superInterface, getAccessor);
				if (lessDerivedSuperMethod != null) {
					return lessDerivedSuperMethod;
				}
				try {
					Method method = superInterface.getMethod(getAccessor);
					if (method != null) {
						return method;
					}
				} catch (Exception e) {
				}
			}
			return null;
		}
		
		public @NonNull CodeGenSnippet getPropertyInstance(@NonNull PropertyId propertyId) {
			CodeGenSnippet codeGenSnippet = propertyInstances.get(propertyId);
			if (codeGenSnippet == null) {
				CodeGenSnippet propertyIdSnippet = codeGenerator.getSnippet(propertyId);
				int flags = CodeGenSnippet.BOXED | CodeGenSnippet.ERASED | CodeGenSnippet.FINAL | CodeGenSnippet.NON_NULL | CodeGenSnippet.UNBOXED;
				CodeGenSnippet s = new JavaSnippet((JavaSnippet)propertyIdSnippet, "IMP_", UnboxedExplicitNavigationProperty.class, flags, 0);
				CodeGenText text = s.open("");
				text.append("new ");
				text.appendClassReference(UnboxedExplicitNavigationProperty.class);
				text.append("(");
				text.appendReferenceTo(propertyId);
				text.append(")");
				text.close();
				codeGenSnippet = text.getSnippet();
				propertyInstances.put(propertyId, codeGenSnippet);
			}
			return codeGenSnippet;
		}
			
		public @NonNull CodeGenSnippet visitPropertyCallExp(@NonNull PropertyCallExp element) {
			CodeGenAnalysis analysis = codeGenerator.getAnalysis(element);
			Property referredProperty = DomainUtil.nonNullModel(element.getReferredProperty());
			Type returnType = DomainUtil.nonNullModel(referredProperty.getType());
			OCLExpression source = element.getSource();
			try {
				GenModelHelper genModelHelper = codeGenerator.getGenModelHelper();
				String getAccessor = genModelHelper.getGetAccessor(referredProperty);
				Type owningType = DomainUtil.nonNullModel(referredProperty.getOwningType());
				Class<?> requiredClass = genModelHelper.getEcoreInterfaceClass(owningType);
				Class<?> leastDerivedClass = getLeastDerivedClass(requiredClass, getAccessor);
				Method leastDerivedMethod = getLeastDerivedMethod(requiredClass, getAccessor);
				Class<?> returnClass = leastDerivedMethod != null ? leastDerivedMethod.getReturnType() : genModelHelper.getEcoreInterfaceClass(returnType);
				int flags = CodeGenSnippet.ERASED | CodeGenSnippet.FINAL | CodeGenSnippet.LOCAL | CodeGenSnippet.THROWN | CodeGenSnippet.UNBOXED;
				if (EObject.class.isAssignableFrom(requiredClass) && !(returnType instanceof DataType)) {	// FIXME Generalize ?? PrimitiveTypes half and half
					flags |= CodeGenSnippet.BOXED;
				}
				if (Iterable.class.isAssignableFrom(returnClass)) {
					flags |= CodeGenSnippet.NON_NULL;
					if (codeGenerator.getOptions().suppressNonNullWarningsForEMFCollections()) {
						flags |= CodeGenSnippet.SUPPRESS_NON_NULL_WARNINGS;
					}
				}
				@NonNull CodeGenSnippet snippet = new JavaSnippet("", analysis, returnClass !=  null ? returnClass : Object.class, flags);
				CodeGenText text = snippet.open("");
				CodeGenSnippet sourceSnippet = codeGenerator.getSnippet(source, false, false).getNonNullSnippet();
				text.appendReferenceTo(leastDerivedClass != null ? leastDerivedClass : requiredClass, sourceSnippet, true);
				text.append(".");
				text.append(getAccessor);
				text.append("()");
				text.close();
				return snippet;
			} catch (GenModelException e) {
				try {
					Type elementType = DomainUtil.nonNullModel(element.getType());
					Class<?> knownResultClass = codeGenerator.getUnboxedClass(elementType);
					Class<?> computedResultClass = codeGenerator.getUnboxedClass(returnType);
					int flags = CodeGenSnippet.LOCAL | CodeGenSnippet.FINAL | CodeGenSnippet.THROWN | CodeGenSnippet.UNBOXED;
					if (!knownResultClass.isAssignableFrom(computedResultClass)) {		// e.g return is a templated type that is statically known
						flags |= CodeGenSnippet.ERASED;
					}
					if (referredProperty.getType() instanceof CollectionType) {
						flags |= CodeGenSnippet.NON_NULL | CodeGenSnippet.SUPPRESS_NON_NULL_WARNINGS;
					}
					@NonNull CodeGenSnippet snippet = new JavaSnippet("", analysis, computedResultClass, flags);
					Class<?> returnClass = getReturnClass(referredProperty);
					//
					CodeGenText text = snippet.open("");
					text.appendResultCast(returnClass, computedResultClass, "");
					text.appendReferenceTo(getPropertyInstance(referredProperty.getPropertyId()));
					text.append(".evaluate(");
					text.appendEvaluatorReference();
					text.append(", ");
					text.appendReferenceTo(element.getTypeId());
					text.append(", ");
					if (source != null) {
						text.appendThrownBoxedReferenceTo(Object.class, source);
					}
					else {
						text.append("null");
					}
					text.append(")");
					text.close();
					return snippet;
				} catch (Exception e1) {
					@NonNull CodeGenSnippet snippet = new JavaSnippet("", analysis, Object.class, CodeGenSnippet.FINAL | CodeGenSnippet.LOCAL | CodeGenSnippet.UNBOXED);
					snippet.appendException(e1);		
					return snippet;
				}
			}
		}
	}

	public class _TuplePartProperty extends AbstractJavaPropertyInliner
	{
		public _TuplePartProperty(@NonNull JavaCodeGenerator codeGenerator) {
			super(codeGenerator);
		}	
		
		public @NonNull CodeGenSnippet visitPropertyCallExp(@NonNull PropertyCallExp element) {
			CodeGenAnalysis analysis = codeGenerator.getAnalysis(element);
			Class<?> resultClass = codeGenerator.getBoxedClass(element.getTypeId());
			@NonNull CodeGenSnippet snippet = new JavaSnippet("", analysis, resultClass, CodeGenSnippet.FINAL | CodeGenSnippet.NON_NULL |CodeGenSnippet.THROWN | CodeGenSnippet.UNBOXED);
			Property referredProperty = DomainUtil.nonNullModel(element.getReferredProperty());
			OCLExpression source = DomainUtil.nonNullModel(element.getSource());
			String tuplePartName = referredProperty.getName();
			TupleType tupleType = (TupleType) source.getType();
			List<String> names = new ArrayList<String>(tupleType.getOwnedAttribute().size());
			for (Property tuplePart : tupleType.getOwnedAttribute()) {
				names.add(tuplePart.getName());
			}
			Collections.sort(names);										// FIXME maintain sorted list in TupleType
			int tuplePartIndex = names.indexOf(tuplePartName);
			CodeGenText text = snippet.open("");
			CodeGenSnippet sourceSnippet = codeGenerator.getSnippet(source, false, false);
			text.appendReferenceTo(TupleValue.class, sourceSnippet, true);
			text.append(".getValue(" + tuplePartIndex + ");/n");
			return snippet;
		}
	}
	
}
