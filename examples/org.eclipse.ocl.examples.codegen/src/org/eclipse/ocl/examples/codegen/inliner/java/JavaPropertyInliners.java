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
import org.eclipse.ocl.examples.codegen.generator.CodeGenSnippet;
import org.eclipse.ocl.examples.codegen.generator.CodeGenSnippet.AbstractTextAppender;
import org.eclipse.ocl.examples.codegen.generator.CodeGenText;
import org.eclipse.ocl.examples.codegen.generator.GenModelException;
import org.eclipse.ocl.examples.codegen.generator.GenModelHelper;
import org.eclipse.ocl.examples.codegen.generator.java.Id2UnboxedJavaClassVisitor;
import org.eclipse.ocl.examples.codegen.generator.java.JavaCodeGenerator;
import org.eclipse.ocl.examples.codegen.generator.java.JavaSnippet;
import org.eclipse.ocl.examples.codegen.generator.java.JavaText;
import org.eclipse.ocl.examples.codegen.inliner.PropertyInliner;
import org.eclipse.ocl.examples.codegen.inliner.java.JavaInliners.AbstractJavaInliner;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.PropertyId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractProperty;
import org.eclipse.ocl.examples.domain.library.LibraryFeature;
import org.eclipse.ocl.examples.domain.messages.DomainMessage;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.TupleValue;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.DataType;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.PropertyCallExp;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.TupleType;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.ecore.EObjectProperty;
import org.eclipse.ocl.examples.pivot.library.CompositionProperty;
import org.eclipse.ocl.examples.pivot.library.ConstrainedProperty;
import org.eclipse.ocl.examples.pivot.library.ExplicitNavigationProperty;
import org.eclipse.ocl.examples.pivot.library.TuplePartProperty;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrintOptions;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrinter;

public class JavaPropertyInliners
{
	protected final @NonNull Map<PropertyId, CodeGenSnippet> propertyInstances = new HashMap<PropertyId, CodeGenSnippet>();
	
	public JavaPropertyInliners(@NonNull JavaCodeGenerator codeGenerator) {
		codeGenerator.addInliner(CompositionProperty.class, new _CompositionProperty(codeGenerator));
		codeGenerator.addInliner(ConstrainedProperty.class, new _ConstrainedProperty(codeGenerator));
		codeGenerator.addInliner(EObjectProperty.class, new _EObjectProperty(codeGenerator));
		codeGenerator.addInliner(ExplicitNavigationProperty.class, new _ExplicitUnboxedNavigationProperty(codeGenerator));
		codeGenerator.addInliner(TuplePartProperty.class, new _TuplePartProperty(codeGenerator));
	}

	public static abstract class AbstractJavaPropertyInliner extends AbstractJavaInliner implements PropertyInliner
	{
		public AbstractJavaPropertyInliner(@NonNull JavaCodeGenerator codeGenerator) {
			super(codeGenerator);
		}

		protected @NonNull CodeGenSnippet createGenModelGetAccessorCall(final @NonNull PropertyCallExp element) throws GenModelException {
			final OCLExpression source = DomainUtil.nonNullModel(element.getSource());
			final CodeGenSnippet sourceSnippet = codeGenerator.getSnippet(source, false, false);
			if (sourceSnippet.isNull()) {
				final @NonNull CodeGenSnippet throwSnippet = new JavaSnippet("", codeGenerator, TypeId.OCL_INVALID, Throwable.class, element,
					CodeGenSnippet.INLINE | CodeGenSnippet.INVALID | CodeGenSnippet.THROWN);
				CodeGenText text = throwSnippet.append("throw new ");
				text.appendClassReference(InvalidValueException.class);
				text.append("(\"Null source for property: ");
				PrettyPrintOptions.Global createOptions = JavaText.createOptions(element);
				text.append(PrettyPrinter.print(element, createOptions));
				text.append("\");\n");
				return throwSnippet;
			}
			CodeGenAnalysis analysis = codeGenerator.getAnalysis(element);
			Property referredProperty = DomainUtil.nonNullModel(element.getReferredProperty());
			Type returnType = DomainUtil.nonNullModel(referredProperty.getType());
			GenModelHelper genModelHelper = codeGenerator.getGenModelHelper();
			final String getAccessor = genModelHelper.getGetAccessor(referredProperty);
			Type owningType = DomainUtil.nonNullModel(referredProperty.getOwningType());
			final Class<?> requiredClass = genModelHelper.getEcoreInterfaceClass(owningType);
			final Class<?> leastDerivedClass = getLeastDerivedClass(requiredClass, getAccessor);
			Method leastDerivedMethod = getLeastDerivedMethod(requiredClass, getAccessor);
			Class<?> returnClass = leastDerivedMethod != null ? leastDerivedMethod.getReturnType() : genModelHelper.getEcoreInterfaceClass(returnType);
			int flags = CodeGenSnippet.ERASED | getBoxingFlags();
			if (EObject.class.isAssignableFrom(requiredClass) && !(returnType instanceof DataType)) {	// FIXME Generalize ?? PrimitiveTypes half and half
				flags |= CodeGenSnippet.BOXED;
			}
			if (analysis.isCatching()) {
				flags |= CodeGenSnippet.CAUGHT | CodeGenSnippet.MUTABLE;
			}
			else {
				flags |= CodeGenSnippet.THROWN;
			}
			if (Iterable.class.isAssignableFrom(returnClass)) {
				flags |= CodeGenSnippet.NON_NULL;
				if (codeGenerator.getOptions().suppressNonNullWarningsForEMFCollections()) {
					flags |= CodeGenSnippet.SUPPRESS_NON_NULL_WARNINGS;
				}
			}
			@NonNull CodeGenSnippet snippet = new JavaSnippet("", analysis, returnClass !=  null ? returnClass : Object.class, flags);
			return snippet.appendText("", new AbstractTextAppender()
			{			
				@Override
				public boolean appendAtHead(@NonNull CodeGenSnippet snippet) {
/*					if (!sourceSnippet.isNonNull()) {
						CodeGenText ifText = snippet.append("if (");
						ifText.appendReferenceTo(null, sourceSnippet);
						ifText.append(" == null) throw new ");
						ifText.appendClassReference(InvalidValueException.class);
						ifText.append("(\"Null source for property: ");
						PrettyPrintOptions.Global createOptions = PivotQueries.createOptions(element);
						ifText.append(PrettyPrinter.print(element, createOptions));
						ifText.append("\");\n");
					}
//					if (!isValidating) {
						snippet.appendInvalidGuard(sourceSnippet);
//					} */
					snippet.appendUnboxedGuardedChild(source, DomainMessage.NULL, DomainMessage.INVALID);
					return true;
				}

				@Override
				public void appendToBody(@NonNull CodeGenText text) {
					CodeGenSnippet sourceSnippet = codeGenerator.getSnippet(source, false, false);
					text.appendAtomicReferenceTo(leastDerivedClass != null ? leastDerivedClass : requiredClass, sourceSnippet);
					text.append(".");
					text.append(getAccessor);
					text.append("()");
				}
			});
		}

		protected @NonNull CodeGenSnippet createCaughtPropertyInstanceCall(@NonNull CodeGenAnalysis analysis, @NonNull PropertyCallExp element) {
			Property referredProperty = DomainUtil.nonNullModel(element.getReferredProperty());
			OCLExpression source = element.getSource();
			int flags = CodeGenSnippet.CAUGHT | CodeGenSnippet.ERASED | CodeGenSnippet.MUTABLE | getBoxingFlags();
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
			CodeGenSnippet sourceSnippet = source != null ? snippet.appendBoxedGuardedChild(source, DomainMessage.NULL, DomainMessage.INVALID) : null;
			CodeGenText text = snippet.appendIndentedText(null);
			text.append(snippet.getName());
			text.append(" = ");
			text.appendReferenceTo(null, getPropertyInstance(referredProperty));
			text.append(".evaluate(");
			text.appendEvaluatorReference();
			text.append(", ");
			text.appendReferenceTo(element.getTypeId());
			text.append(", ");
			if (sourceSnippet != null) {
				text.appendReferenceTo(null, sourceSnippet);
			}
			else {
				text.append("null");
			}
			text.append(");\n");
			//
			CodeGenText tail = snippet.append("}\n");
			Object exceptionObject = tail;			// A convenient object that would otherwise be nameless
			String exceptionName = codeGenerator.getNameManager().getSymbolName(exceptionObject, "e");
			tail.append("catch (");
			tail.appendClassReference(Exception.class);
			tail.append(" " + exceptionName + ") {\n");
			//
			CodeGenText throwText = snippet.appendIndentedText(null);
			throwText.append(snippet.getName());
			throwText.append(" = ");
			throwText.appendClassReference(ValuesUtil.class);
			throwText.append(".createInvalidValue(" + exceptionName + ");\n");
			//
			snippet.append("}\n");
			return snippet;
		}
		
		protected @NonNull CodeGenSnippet createThrownPropertyInstanceCall(@NonNull CodeGenAnalysis analysis, final @NonNull PropertyCallExp element) {
			final Property referredProperty = DomainUtil.nonNullModel(element.getReferredProperty());
			Type returnType = DomainUtil.nonNullModel(referredProperty.getType());
			final OCLExpression source = element.getSource();
			Type elementType = DomainUtil.nonNullModel(element.getType());
			Class<?> knownResultClass = codeGenerator.getUnboxedClass(elementType);
			final Class<?> computedResultClass = codeGenerator.getUnboxedClass(returnType);
			int flags = CodeGenSnippet.THROWN | getBoxingFlags();
			if (!knownResultClass.isAssignableFrom(computedResultClass)) {		// e.g return is a templated type that is statically known
				flags |= CodeGenSnippet.ERASED;
			}
			if (referredProperty.getType() instanceof CollectionType) {
				flags |= CodeGenSnippet.NON_NULL | CodeGenSnippet.SUPPRESS_NON_NULL_WARNINGS;
			}
//			if (referredProperty.isRequired()) {  -- properties are not trust worthy
//				flags |= CodeGenSnippet.NON_NULL;
//			}
			@NonNull CodeGenSnippet snippet = new JavaSnippet("", analysis, computedResultClass, flags);
			final Class<?> returnClass = getReturnClass(referredProperty);
			//
			return snippet.appendText("", new AbstractTextAppender()
			{
				private CodeGenSnippet sourceSnippet;
				
				@Override
				public boolean appendAtHead(@NonNull CodeGenSnippet snippet) {
					sourceSnippet = source != null ? snippet.appendUnboxedGuardedChild(source, DomainMessage.NULL, DomainMessage.INVALID) : null;
					return true;
				}

				@Override
				public void appendToBody(@NonNull CodeGenText text) {
					text.appendResultCast(returnClass, computedResultClass, "");
					text.appendReferenceTo(null, getPropertyInstance(referredProperty));
					text.append(".evaluate(");
					text.appendEvaluatorReference();
					text.append(", ");
					text.appendReferenceTo(element.getTypeId());
					text.append(", ");
					if (sourceSnippet != null) {
						text.appendReferenceTo(null, sourceSnippet);
					}
					else {
						text.append("null");
					}
					text.append(")");
				}
			});
		}

		protected int getBoxingFlags() {
			return CodeGenSnippet.UNBOXED;
		}

		protected abstract @NonNull CodeGenSnippet getPropertyInstance(@NonNull Property referredProperty);

		protected @Nullable Class<?> getReturnClass(@NonNull Property referredProperty) {		// FIXME share
			try {
				LibraryFeature implementation = codeGenerator.getMetaModelManager().getImplementation(referredProperty);
				@SuppressWarnings("null") @NonNull Class<? extends LibraryFeature> implementationClass = implementation.getClass();
				TypeId typeId = referredProperty.getTypeId();
				Class<?> propertyTypeClass = typeId.accept(Id2UnboxedJavaClassVisitor.INSTANCE);
				Method method = implementationClass.getMethod("evaluate", DomainEvaluator.class, TypeId.class, propertyTypeClass);
				return method.getReturnType();
			} catch (Exception e) {
				return null;
			}
		}
		
		public @NonNull CodeGenSnippet visitPropertyCallExp(@NonNull PropertyCallExp element) {
			try {
				return createGenModelGetAccessorCall(element);
			} catch (GenModelException e) {
				CodeGenAnalysis analysis = codeGenerator.getAnalysis(element);
				boolean isCatching = analysis.isCatching();
				if (isCatching) {
					return createCaughtPropertyInstanceCall(analysis, element);
				}
				else {
					return createThrownPropertyInstanceCall(analysis, element);
				}
			}
		}
	}
	
	public static class BoxedExplicitNavigationProperty extends AbstractProperty
	{
		protected @NonNull PropertyId propertyId;
//		protected @NonNull DomainProperty property;
		private EStructuralFeature eFeature = null;
		
		public BoxedExplicitNavigationProperty(@NonNull PropertyId propertyId) {
			this.propertyId = propertyId;
			// FIXME static attempt at eFeature
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
				if (eValue != null) {
					return evaluator.getIdResolver().boxedValueOf(eValue, eFeature2, returnTypeId);
//					return evaluator.getIdResolver().valueOf(eValue)
				}
				return eValue;
			}
			return null;
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
			// FIXME static attempt at eFeature
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
				int flags = propertyIdSnippet.getFlags() | CodeGenSnippet.BOXED | CodeGenSnippet.ERASED | CodeGenSnippet.NON_NULL | CodeGenSnippet.UNBOXED;
//				snippet = new JavaSnippet((JavaSnippet)propertyIdSnippet, "IMP_", UnboxedCompositionProperty.class, flags, 0);
				snippet = new JavaSnippet("IMP_"+propertyIdSnippet.getName(), propertyIdSnippet.getTypeId(), UnboxedCompositionProperty.class, propertyId, codeGenerator, "", flags);
				snippet = snippet.appendText("", new AbstractTextAppender()
				{			
					@Override
					public void appendToBody(@NonNull CodeGenText text) {
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
	}

	public class _ConstrainedProperty extends AbstractJavaPropertyInliner
	{
		private final AbstractJavaPropertyInliner compositionInliner;
		private final AbstractJavaPropertyInliner navigationInliner;
		
		public _ConstrainedProperty(@NonNull JavaCodeGenerator codeGenerator) {
			super(codeGenerator);
			compositionInliner = new _CompositionProperty(codeGenerator);
			navigationInliner = new _ExplicitBoxedNavigationProperty(codeGenerator);
		}	

		@Override
		protected int getBoxingFlags() {
			return CodeGenSnippet.BOXED;
		}
		
		@Override
		public @NonNull CodeGenSnippet getPropertyInstance(@NonNull Property referredProperty) {
			Property oppositeProperty = referredProperty.getOpposite();
			if ((oppositeProperty != null) && oppositeProperty.isComposite()) {
				return compositionInliner.getPropertyInstance(referredProperty);
			}
			else {
				return navigationInliner.getPropertyInstance(referredProperty);
			}
		}
	}

	public class _EObjectProperty extends AbstractJavaPropertyInliner
	{
		private final AbstractJavaPropertyInliner compositionInliner;
		private final AbstractJavaPropertyInliner navigationInliner;
		
		public _EObjectProperty(@NonNull JavaCodeGenerator codeGenerator) {
			super(codeGenerator);
			compositionInliner = new _CompositionProperty(codeGenerator);
			navigationInliner = new _ExplicitUnboxedNavigationProperty(codeGenerator);
		}	
		
		@Override
		public @NonNull CodeGenSnippet getPropertyInstance(@NonNull Property referredProperty) {
			Property oppositeProperty = referredProperty.getOpposite();
			if ((oppositeProperty != null) && oppositeProperty.isComposite()) {
				return compositionInliner.getPropertyInstance(referredProperty);
			}
			else {
				return navigationInliner.getPropertyInstance(referredProperty);
			}
		}
	}

	public class _ExplicitBoxedNavigationProperty extends AbstractJavaPropertyInliner
	{
		public _ExplicitBoxedNavigationProperty(@NonNull JavaCodeGenerator codeGenerator) {
			super(codeGenerator);
		}	
		
		@Override
		public @NonNull CodeGenSnippet getPropertyInstance(@NonNull Property referredProperty) {
			final @NonNull PropertyId propertyId = referredProperty.getPropertyId();
			CodeGenSnippet snippet = propertyInstances.get(propertyId);
			if (snippet == null) {
				CodeGenSnippet propertyIdSnippet = codeGenerator.getSnippet(propertyId);
				int flags = propertyIdSnippet.getFlags() | CodeGenSnippet.BOXED | CodeGenSnippet.ERASED | CodeGenSnippet.NON_NULL | CodeGenSnippet.UNBOXED;
//				snippet = new JavaSnippet((JavaSnippet)propertyIdSnippet, "IMP_", BoxedExplicitNavigationProperty.class, flags, 0);
				snippet = new JavaSnippet("IMP_"+propertyIdSnippet.getName(), propertyIdSnippet.getTypeId(), BoxedExplicitNavigationProperty.class, propertyId, codeGenerator, "", flags);
				snippet = snippet.appendText("", new AbstractTextAppender()
				{			
					@Override
					public void appendToBody(@NonNull CodeGenText text) {
						text.append("new ");
						text.appendClassReference(BoxedExplicitNavigationProperty.class);
						text.append("(");
						text.appendReferenceTo(propertyId);
						text.append(")");
					}
				});
				propertyInstances.put(propertyId, snippet);
			}
			return snippet;
		}
	}

	public class _ExplicitUnboxedNavigationProperty extends AbstractJavaPropertyInliner
	{
		public _ExplicitUnboxedNavigationProperty(@NonNull JavaCodeGenerator codeGenerator) {
			super(codeGenerator);
		}	
		
		@Override
		public @NonNull CodeGenSnippet getPropertyInstance(@NonNull Property referredProperty) {
			final @NonNull PropertyId propertyId = referredProperty.getPropertyId();
			CodeGenSnippet snippet = propertyInstances.get(propertyId);
			if (snippet == null) {
				CodeGenSnippet propertyIdSnippet = codeGenerator.getSnippet(propertyId);
				int flags = propertyIdSnippet.getFlags() | CodeGenSnippet.BOXED | CodeGenSnippet.ERASED | CodeGenSnippet.NON_NULL | CodeGenSnippet.UNBOXED;
//				snippet = new JavaSnippet((JavaSnippet)propertyIdSnippet, "IMP_", UnboxedExplicitNavigationProperty.class, flags, 0);
				snippet = new JavaSnippet("IMP_"+propertyIdSnippet.getName(), propertyIdSnippet.getTypeId(), UnboxedExplicitNavigationProperty.class, propertyId, codeGenerator, "", flags);
				snippet = snippet.appendText("", new AbstractTextAppender()
				{			
					@Override
					public void appendToBody(@NonNull CodeGenText text) {
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
		
		@Override
		public @NonNull CodeGenSnippet visitPropertyCallExp(@NonNull PropertyCallExp element) {
			CodeGenAnalysis analysis = codeGenerator.getAnalysis(element);
			final Class<?> resultClass = codeGenerator.getBoxedClass(element.getTypeId());
			@NonNull CodeGenSnippet snippet = new JavaSnippet("", analysis, resultClass, CodeGenSnippet.THROWN | CodeGenSnippet.BOXED);
			Property referredProperty = DomainUtil.nonNullModel(element.getReferredProperty());
			final OCLExpression source = DomainUtil.nonNullModel(element.getSource());
			final String tuplePartName = referredProperty.getName();
			TupleType tupleType = (TupleType) source.getType();
			List<String> names = new ArrayList<String>(tupleType.getOwnedAttribute().size());
			for (Property tuplePart : tupleType.getOwnedAttribute()) {
				names.add(tuplePart.getName());
			}
			Collections.sort(names);										// FIXME maintain sorted list in TupleType
			final int tuplePartIndex = names.indexOf(tuplePartName);
			final CodeGenSnippet sourceSnippet = codeGenerator.getSnippet(source, false, false);
			return snippet.appendText("", new AbstractTextAppender()
			{			
				@Override
				public void appendToBody(@NonNull CodeGenText text) {
					text.append("(");
					text.appendClassReference(resultClass);
					text.append(")");
					text.appendAtomicReferenceTo(TupleValue.class, sourceSnippet);
					text.append(".getValue(" + tuplePartIndex + "/*" + tuplePartName + "*/)");
				}
			});
		}
	}
	
}
