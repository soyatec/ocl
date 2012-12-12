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
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalysis;
import org.eclipse.ocl.examples.codegen.common.PivotQueries;
import org.eclipse.ocl.examples.codegen.generator.CodeGenSnippet;
import org.eclipse.ocl.examples.codegen.generator.CodeGenText;
import org.eclipse.ocl.examples.codegen.generator.GenModelException;
import org.eclipse.ocl.examples.codegen.generator.GenModelHelper;
import org.eclipse.ocl.examples.codegen.generator.CodeGenSnippet.TextAppender;
import org.eclipse.ocl.examples.codegen.generator.java.JavaCodeGenerator;
import org.eclipse.ocl.examples.codegen.generator.java.JavaSnippet;
import org.eclipse.ocl.examples.codegen.inliner.AbstractInliner;
import org.eclipse.ocl.examples.codegen.inliner.PropertyInliner;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.ids.PropertyId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractProperty;
import org.eclipse.ocl.examples.domain.library.LibraryFeature;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.TupleValue;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueImpl;
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
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrintOptions;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrinter;

public class JavaInliners
{
	protected final @NonNull JavaCodeGenerator codeGenerator;
	protected final @NonNull Map<PropertyId, CodeGenSnippet> propertyInstances = new HashMap<PropertyId, CodeGenSnippet>();
	
	public JavaInliners(@NonNull JavaCodeGenerator codeGenerator) {
		this.codeGenerator = codeGenerator;
		codeGenerator.addInliner(CompositionProperty.class, new _CompositionProperty(codeGenerator));
		codeGenerator.addInliner(ExplicitNavigationProperty.class, new _ExplicitNavigationProperty(codeGenerator));
		codeGenerator.addInliner(TuplePartProperty.class, new _TuplePartProperty(codeGenerator));
	}

	public static abstract class AbstractJavaPropertyInliner extends AbstractInliner implements PropertyInliner
	{
		public AbstractJavaPropertyInliner(@NonNull JavaCodeGenerator codeGenerator) {
			super(codeGenerator);
		}

		protected @NonNull CodeGenSnippet createGenModelGetAccessorCall(@NonNull PropertyCallExp element) throws GenModelException {
			CodeGenAnalysis analysis = codeGenerator.getAnalysis(element);
			Property referredProperty = DomainUtil.nonNullModel(element.getReferredProperty());
			Type returnType = DomainUtil.nonNullModel(referredProperty.getType());
			OCLExpression source = element.getSource();
			GenModelHelper genModelHelper = codeGenerator.getGenModelHelper();
			final String getAccessor = genModelHelper.getGetAccessor(referredProperty);
			Type owningType = DomainUtil.nonNullModel(referredProperty.getOwningType());
			final Class<?> requiredClass = genModelHelper.getEcoreInterfaceClass(owningType);
			final Class<?> leastDerivedClass = getLeastDerivedClass(requiredClass, getAccessor);
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
			final CodeGenSnippet sourceSnippet = codeGenerator.getSnippet(source, false, false);
			@NonNull CodeGenSnippet snippet = new JavaSnippet("", analysis, returnClass !=  null ? returnClass : Object.class, flags);
			if (!sourceSnippet.isNonNull()) {
				CodeGenText ifText = snippet.append("if (");
				ifText.appendReferenceTo(sourceSnippet);
				ifText.append(" == null) throw new ");
				ifText.appendClassReference(InvalidValueException.class);
				ifText.append("(\"Null source for property: ");
				PrettyPrintOptions.Global createOptions = PivotQueries.createOptions(element);
				ifText.append(PrettyPrinter.print(element, createOptions));
				ifText.append("\");\n");
			}
			return snippet.appendText("", new TextAppender()
			{			
				public void appendTo(@NonNull CodeGenText text) {
					text.appendReferenceTo(leastDerivedClass != null ? leastDerivedClass : requiredClass, sourceSnippet, true);
					text.append(".");
					text.append(getAccessor);
					text.append("()");
				}
			});
		}

		protected @NonNull CodeGenSnippet createCaughtPropertyInstanceCall(@NonNull CodeGenAnalysis analysis, @NonNull PropertyCallExp element) {
			Property referredProperty = DomainUtil.nonNullModel(element.getReferredProperty());
			OCLExpression source = element.getSource();
			int flags = CodeGenSnippet.CAUGHT | CodeGenSnippet.ERASED | CodeGenSnippet.LOCAL | CodeGenSnippet.UNBOXED;
			if (referredProperty.getType() instanceof CollectionType) {
				flags |= CodeGenSnippet.NON_NULL | CodeGenSnippet.SUPPRESS_NON_NULL_WARNINGS;
			}
			@NonNull CodeGenSnippet snippet = new JavaSnippet("", analysis, Object.class, flags);
			//
			CodeGenText decl = snippet.append("");
			decl.appendDeclaration(snippet);
			decl.append(";\n");
			//
			decl.append("try {\n");
			//
			CodeGenText text = snippet.appendIndentedText(null);
			text.append(snippet.getName());
			text.append(" = ");
			text.appendReferenceTo(getPropertyInstance(referredProperty));
			text.append(".evaluate(");
			text.appendEvaluatorReference();
			text.append(", ");
			text.appendReferenceTo(element.getTypeId());
			text.append(", ");
			if (source != null) {
				text.appendBoxedReferenceTo(Object.class, source);
			}
			else {
				text.append("null");
			}
			text.append(");\n");
			//
			CodeGenText tail = snippet.append("}\n");
			tail.append("catch (");
			tail.appendClassReference(Exception.class);
			tail.append(" e) {\n");
			//
			CodeGenText throwText = snippet.appendIndentedText(null);
			throwText.append(snippet.getName());
			throwText.append(" = new ");
			throwText.appendClassReference(InvalidValueImpl.class);
			throwText.append("(e);\n");
			//
			snippet.append("}\n");
			return snippet;
		}

		protected @NonNull CodeGenSnippet createPropertyInstanceCall(@NonNull PropertyCallExp element) {
			CodeGenAnalysis analysis = codeGenerator.getAnalysis(element);
			boolean isCatching = analysis.isCatching();
			if (isCatching) {
				return createCaughtPropertyInstanceCall(analysis, element);
			}
			else {
				return createThrownPropertyInstanceCall(analysis, element);
			}
		}
		
		protected @NonNull CodeGenSnippet createThrownPropertyInstanceCall(@NonNull CodeGenAnalysis analysis, final @NonNull PropertyCallExp element) {
			final Property referredProperty = DomainUtil.nonNullModel(element.getReferredProperty());
			Type returnType = DomainUtil.nonNullModel(referredProperty.getType());
			final OCLExpression source = element.getSource();
			Type elementType = DomainUtil.nonNullModel(element.getType());
			Class<?> knownResultClass = codeGenerator.getUnboxedClass(elementType);
			final Class<?> computedResultClass = codeGenerator.getUnboxedClass(returnType);
			int flags = CodeGenSnippet.FINAL | CodeGenSnippet.LOCAL | CodeGenSnippet.THROWN | CodeGenSnippet.UNBOXED;
			if (!knownResultClass.isAssignableFrom(computedResultClass)) {		// e.g return is a templated type that is statically known
				flags |= CodeGenSnippet.ERASED;
			}
			if (referredProperty.getType() instanceof CollectionType) {
				flags |= CodeGenSnippet.NON_NULL | CodeGenSnippet.SUPPRESS_NON_NULL_WARNINGS;
			}
			@NonNull CodeGenSnippet snippet = new JavaSnippet("", analysis, computedResultClass, flags);
			final Class<?> returnClass = getReturnClass(referredProperty);
			//
			return snippet.appendText("", new TextAppender()
			{			
				public void appendTo(@NonNull CodeGenText text) {
					text.appendResultCast(returnClass, computedResultClass, "");
					text.appendReferenceTo(getPropertyInstance(referredProperty));
					text.append(".evaluate(");
					text.appendEvaluatorReference();
					text.append(", ");
					text.appendReferenceTo(element.getTypeId());
					text.append(", ");
					if (source != null) {
						text.appendBoxedReferenceTo(Object.class, source);
					}
					else {
						text.append("null");
					}
					text.append(")");
				}
			});
		}

		protected abstract @NonNull CodeGenSnippet getPropertyInstance(@NonNull Property referredProperty);
		
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
	
	public static class UnboxedCompositionProperty extends AbstractProperty
	{
		protected @NonNull String containmentFeatureName;
		
		public UnboxedCompositionProperty(@NonNull String containmentFeatureName) {
			this.containmentFeatureName = containmentFeatureName;
		}
		
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue) {
			assert sourceValue != null;
			EObject eObject = (EObject)sourceValue; 
			EObject eContainer = eObject.eContainer();
			if (eContainer == null) {
				return null;				// No container
			}
			EReference eContainmentFeature = eObject.eContainmentFeature();
			if (!containmentFeatureName.equals(eContainmentFeature.getName())) {
				return null;				// Contained but by some other property
			}
			return eContainer;
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

	public class _CompositionProperty extends AbstractJavaPropertyInliner
	{
		public _CompositionProperty(@NonNull JavaCodeGenerator codeGenerator) {
			super(codeGenerator);
		}	
		
		@Override
		public @NonNull CodeGenSnippet getPropertyInstance(@NonNull Property referredProperty) {
			PropertyId propertyId = referredProperty.getPropertyId();
			Property oppositeProperty = DomainUtil.nonNullModel(referredProperty.getOpposite());
			final String oppositePropertyName = DomainUtil.nonNullModel(oppositeProperty.getName());
			CodeGenSnippet snippet = propertyInstances.get(propertyId);
			if (snippet == null) {
				CodeGenSnippet propertyIdSnippet = codeGenerator.getSnippet(propertyId);
				int flags = CodeGenSnippet.BOXED | CodeGenSnippet.ERASED | CodeGenSnippet.FINAL | CodeGenSnippet.NON_NULL | CodeGenSnippet.UNBOXED;
				snippet = new JavaSnippet((JavaSnippet)propertyIdSnippet, "IMP_", UnboxedCompositionProperty.class, flags, 0);
				snippet = snippet.appendText("", new TextAppender()
				{			
					public void appendTo(@NonNull CodeGenText text) {
						text.append("new ");
						text.appendClassReference(UnboxedCompositionProperty.class);
						text.append("(");
						text.appendString(oppositePropertyName);
						text.append(")");
					}
				});
				propertyInstances.put(propertyId, snippet);
			}
			return snippet;
		}
			
		public @NonNull CodeGenSnippet visitPropertyCallExp(@NonNull PropertyCallExp element) {
			try {
				return createGenModelGetAccessorCall(element);
			} catch (GenModelException e) {
				return createPropertyInstanceCall(element);
			}
		}
	}

	public class _ExplicitNavigationProperty extends AbstractJavaPropertyInliner
	{
		public _ExplicitNavigationProperty(@NonNull JavaCodeGenerator codeGenerator) {
			super(codeGenerator);
		}	
		
		@Override
		public @NonNull CodeGenSnippet getPropertyInstance(@NonNull Property referredProperty) {
			final @NonNull PropertyId propertyId = referredProperty.getPropertyId();
			CodeGenSnippet snippet = propertyInstances.get(propertyId);
			if (snippet == null) {
				CodeGenSnippet propertyIdSnippet = codeGenerator.getSnippet(propertyId);
				int flags = CodeGenSnippet.BOXED | CodeGenSnippet.ERASED | CodeGenSnippet.FINAL | CodeGenSnippet.NON_NULL | CodeGenSnippet.UNBOXED;
				snippet = new JavaSnippet((JavaSnippet)propertyIdSnippet, "IMP_", UnboxedExplicitNavigationProperty.class, flags, 0);
				snippet = snippet.appendText("", new TextAppender()
				{			
					public void appendTo(@NonNull CodeGenText text) {
						text.append("new ");
						text.appendClassReference(UnboxedExplicitNavigationProperty.class);
						text.append("(");
						text.appendReferenceTo(propertyId);
						text.append(")");
					}
				});
				propertyInstances.put(propertyId, snippet);
			}
			return snippet;
		}
			
		public @NonNull CodeGenSnippet visitPropertyCallExp(@NonNull PropertyCallExp element) {
			try {
				return createGenModelGetAccessorCall(element);
			} catch (GenModelException e) {
				return createPropertyInstanceCall(element);
			}
		}
	}

	public class _TuplePartProperty extends AbstractJavaPropertyInliner
	{
		public _TuplePartProperty(@NonNull JavaCodeGenerator codeGenerator) {
			super(codeGenerator);
		}	

		@Override
		protected @NonNull CodeGenSnippet getPropertyInstance(@NonNull Property referredProperty) {
			throw new UnsupportedOperationException();
		}
		
		public @NonNull CodeGenSnippet visitPropertyCallExp(@NonNull PropertyCallExp element) {
			CodeGenAnalysis analysis = codeGenerator.getAnalysis(element);
			Class<?> resultClass = codeGenerator.getBoxedClass(element.getTypeId());
			@NonNull CodeGenSnippet snippet = new JavaSnippet("", analysis, resultClass, CodeGenSnippet.FINAL | CodeGenSnippet.NON_NULL |CodeGenSnippet.THROWN | CodeGenSnippet.UNBOXED);
			Property referredProperty = DomainUtil.nonNullModel(element.getReferredProperty());
			final OCLExpression source = DomainUtil.nonNullModel(element.getSource());
			String tuplePartName = referredProperty.getName();
			TupleType tupleType = (TupleType) source.getType();
			List<String> names = new ArrayList<String>(tupleType.getOwnedAttribute().size());
			for (Property tuplePart : tupleType.getOwnedAttribute()) {
				names.add(tuplePart.getName());
			}
			Collections.sort(names);										// FIXME maintain sorted list in TupleType
			final int tuplePartIndex = names.indexOf(tuplePartName);
			return snippet.appendText("", new TextAppender()
			{			
				public void appendTo(@NonNull CodeGenText text) {
					CodeGenSnippet sourceSnippet = codeGenerator.getSnippet(source, false, false);
					text.appendReferenceTo(TupleValue.class, sourceSnippet, true);
					text.append(".getValue(" + tuplePartIndex + ")");
				}
			});
		}
	}
	
}
