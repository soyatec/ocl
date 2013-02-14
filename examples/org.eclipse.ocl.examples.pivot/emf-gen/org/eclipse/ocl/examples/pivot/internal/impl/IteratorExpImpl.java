/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: IteratorExpImpl.java,v 1.2 2011/01/24 20:42:32 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.internal.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainCallExp;
import org.eclipse.ocl.examples.domain.elements.DomainCollectionType;
import org.eclipse.ocl.examples.domain.elements.DomainExpression;
import org.eclipse.ocl.examples.domain.elements.DomainInheritance;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.elements.DomainTypedElement;
import org.eclipse.ocl.examples.domain.elements.Nameable;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.LibraryFeature;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.types.IdResolver;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.validation.ValidationWarning;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.OrderedSetValue;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.library.LibraryConstants;
import org.eclipse.ocl.examples.library.collection.CollectionSizeOperation;
import org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager;
import org.eclipse.ocl.examples.library.iterator.ClosureIteration;
import org.eclipse.ocl.examples.library.iterator.SortedByIteration;
import org.eclipse.ocl.examples.library.logical.BooleanImpliesOperation;
import org.eclipse.ocl.examples.library.logical.BooleanOrOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyOclAsTypeOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.examples.library.oclany.OclComparableCompareToOperation;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.IteratorExp;
import org.eclipse.ocl.examples.pivot.LoopExp;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.PivotTables;
import org.eclipse.ocl.examples.pivot.ReferringElement;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
import org.eclipse.ocl.examples.pivot.util.PivotValidator;
import org.eclipse.ocl.examples.pivot.util.Visitor;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.osgi.util.NLS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Iterator Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
@SuppressWarnings("cast")
public class IteratorExpImpl extends LoopExpImpl implements IteratorExp
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IteratorExpImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return PivotPackage.Literals.ITERATOR_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateClosureBodyTypeIsConformanttoIteratorType(DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		if (getReferredIteration().getImplementation() != ClosureIteration.INSTANCE) {
			return true;
		}
		Diagnostic diagnostic = null;
		MetaModelManager metaModelManager = PivotUtil.getMetaModelManager(DomainUtil.nonNullState(eResource()));
		Type bodyType = getBody().getType();
		if (bodyType instanceof CollectionType) {
			bodyType = ((CollectionType)bodyType).getElementType();
		}
		Type bodyType2 = DomainUtil.nonNullState(bodyType);
		Type iteratorType = DomainUtil.nonNullState(getIterator().get(0).getType());
		Map<TemplateParameter, ParameterableElement> bindings = new HashMap<TemplateParameter, ParameterableElement>();
		if (!metaModelManager.conformsTo(bodyType2, iteratorType, bindings)) {
			if (diagnostics == null) {
				return false;
			}
			diagnostic = new ValidationWarning(OCLMessages.IncompatibleBodyType_WARNING_, bodyType2, iteratorType);
		}
		if (diagnostic == null) {
			return true;
		}
	    diagnostics.add(diagnostic);
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateSortedByIteratorTypeIsComparable(DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		if (getReferredIteration().getImplementation() != SortedByIteration.INSTANCE) {
			return true;
		}
		Diagnostic diagnostic = null;
		MetaModelManager metaModelManager = PivotUtil.getMetaModelManager(DomainUtil.nonNullState(eResource()));
		try {
			@NonNull Type type = DomainUtil.nonNullPivot(getBody().getType());
			TemplateParameter templateParameter = type.getOwningTemplateParameter();
			if (templateParameter != null) {
				Map<TemplateParameter, ParameterableElement> templateParameterSubstitutions = PivotUtil.getAllTemplateParameterSubstitutions(null, (TemplateableElement) getSource().getType());
				if (templateParameterSubstitutions != null) {
					ParameterableElement resolvedTemplateParameter = templateParameterSubstitutions.get(templateParameter);
					if (resolvedTemplateParameter instanceof Type) {
						type = (Type) resolvedTemplateParameter;
					}
				}
			}
			type = PivotUtil.getBehavioralType(type);			// FIXME make this a general facility
			DomainInheritance comparableType = metaModelManager.getOclComparableType().getInheritance(metaModelManager);
			DomainInheritance selfType = metaModelManager.getOclSelfType().getInheritance(metaModelManager);
			DomainOperation staticOperation = comparableType.lookupLocalOperation(metaModelManager, LibraryConstants.COMPARE_TO, selfType);
			if (staticOperation == null) {
				if (diagnostics == null) {
					return false;
				}
				diagnostic = new ValidationWarning(OCLMessages.UnresolvedOperation_ERROR_, LibraryConstants.COMPARE_TO, String.valueOf(comparableType));
			}
			else {
				LibraryFeature implementation = type.lookupImplementation(metaModelManager, staticOperation);
				if (implementation == OclComparableCompareToOperation.INSTANCE) {
					if (diagnostics == null) {
						return false;
					}
					diagnostic = new ValidationWarning(OCLMessages.UnresolvedOperation_ERROR_, LibraryConstants.COMPARE_TO, String.valueOf(type));
				}
			}
		} catch (Exception e) {
			if (diagnostics == null) {
				return false;
			}
			diagnostic = new ValidationWarning(e.getLocalizedMessage());
		}
		if (diagnostic == null) {
			return true;
		}
	    diagnostics.add(diagnostic);
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAnyHasOneIterator(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * name = 'any' implies iterator->size() = 1
		 */
		final @NonNull /*@NonInvalid*/ Object self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(self, PivotTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		@NonNull /*@Caught*/ Object _q;
		try {
		    final @Nullable /*@Thrown*/ String name = ((Nameable)self).getName();
		    _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, PivotTables.STR_any);
		} catch (Exception e) { _q = ValuesUtil.createInvalidValue(e); }
		@NonNull /*@Caught*/ Object _q_0;
		try {
		    final @SuppressWarnings("null")@NonNull /*@Thrown*/ List<?> iterator = ((LoopExp)self).getIterator();
		    final @NonNull /*@Thrown*/ OrderedSetValue BOXED_iterator = idResolver.createOrderedSetOfAll(PivotTables.ORD_CLSSid_Variable, iterator);
		    final @NonNull /*@Thrown*/ IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(evaluator, TypeId.INTEGER, BOXED_iterator);
		    _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, size, PivotTables.INT_1);
		} catch (Exception e_0) { _q_0 = ValuesUtil.createInvalidValue(e_0); }
		final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
		if (implies == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = implies == null ? Diagnostic.ERROR : Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "AnyHasOneIterator", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__ANY_HAS_ONE_ITERATOR, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAnyTypeIsSourceElementType(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * name = 'any' implies type = source.type.oclAsType(CollectionType).elementType
		 */
		final @NonNull /*@NonInvalid*/ Object self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(self, PivotTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@NonInvalid*/ DomainType TYP_pivot_c_c_CollectionType = idResolver.getType(PivotTables.CLSSid_CollectionType, null);
		@NonNull /*@Caught*/ Object _q;
		try {
		    final @Nullable /*@Thrown*/ String name = ((Nameable)self).getName();
		    _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, PivotTables.STR_any);
		} catch (Exception e) { _q = ValuesUtil.createInvalidValue(e); }
		@NonNull /*@Caught*/ Object _q_0;
		try {
		    final @Nullable /*@Thrown*/ DomainType type = ((DomainTypedElement)self).getType();
		    final @Nullable /*@Thrown*/ DomainExpression source = ((DomainCallExp)self).getSource();
		    if (source == null) throw new InvalidValueException("Null Literal");
		    final @Nullable /*@Thrown*/ DomainType type_0 = source.getType();
		    final @Nullable /*@Thrown*/ Object oclAsType = OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, PivotTables.CLSSid_CollectionType, type_0, TYP_pivot_c_c_CollectionType);
		    if (oclAsType == null) throw new InvalidValueException("Null Literal");
		    final @Nullable /*@Thrown*/ DomainType elementType = ((DomainCollectionType)oclAsType).getElementType();
		    _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type, elementType);
		} catch (Exception e_0) { _q_0 = ValuesUtil.createInvalidValue(e_0); }
		final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
		if (implies == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = implies == null ? Diagnostic.ERROR : Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "AnyTypeIsSourceElementType", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__ANY_TYPE_IS_SOURCE_ELEMENT_TYPE, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAnyBodyTypeIsBoolean(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * name = 'any' implies body.type = 'Boolean'
		 */
		final @NonNull /*@NonInvalid*/ Object self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(self, PivotTables.LIBRARY);
		@NonNull /*@Caught*/ Object _q;
		try {
		    final @Nullable /*@Thrown*/ String name = ((Nameable)self).getName();
		    _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, PivotTables.STR_any);
		} catch (Exception e) { _q = ValuesUtil.createInvalidValue(e); }
		@NonNull /*@Caught*/ Object _q_0;
		try {
		    final @Nullable /*@Thrown*/ OCLExpression body = ((LoopExp)self).getBody();
		    if (body == null) throw new InvalidValueException("Null Literal");
		    final @Nullable /*@Thrown*/ DomainType type = body.getType();
		    _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type, PivotTables.STR_Boolean);
		} catch (Exception e_0) { _q_0 = ValuesUtil.createInvalidValue(e_0); }
		final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
		if (implies == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = implies == null ? Diagnostic.ERROR : Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "AnyBodyTypeIsBoolean", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__ANY_BODY_TYPE_IS_BOOLEAN, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClosureHasOneIterator(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * name = 'closure' implies iterator->size() = 1
		 */
		final @NonNull /*@NonInvalid*/ Object self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(self, PivotTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		@NonNull /*@Caught*/ Object _q;
		try {
		    final @Nullable /*@Thrown*/ String name = ((Nameable)self).getName();
		    _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, PivotTables.STR_closure);
		} catch (Exception e) { _q = ValuesUtil.createInvalidValue(e); }
		@NonNull /*@Caught*/ Object _q_0;
		try {
		    final @SuppressWarnings("null")@NonNull /*@Thrown*/ List<?> iterator = ((LoopExp)self).getIterator();
		    final @NonNull /*@Thrown*/ OrderedSetValue BOXED_iterator = idResolver.createOrderedSetOfAll(PivotTables.ORD_CLSSid_Variable, iterator);
		    final @NonNull /*@Thrown*/ IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(evaluator, TypeId.INTEGER, BOXED_iterator);
		    _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, size, PivotTables.INT_1);
		} catch (Exception e_0) { _q_0 = ValuesUtil.createInvalidValue(e_0); }
		final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
		if (implies == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = implies == null ? Diagnostic.ERROR : Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "ClosureHasOneIterator", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__CLOSURE_HAS_ONE_ITERATOR, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClosureTypeIsUniqueCollection(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * name = 'closure' implies
		 * if
		 *   source.type.oclIsKindOf(SequenceType) or
		 *   source.type.oclIsKindOf(OrderedSetType)
		 * then type.oclIsKindOf(OrderedSetType)
		 * else type.oclIsKindOf(SetType)
		 * endif
		 */
		final @NonNull /*@NonInvalid*/ Object self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(self, PivotTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@NonInvalid*/ DomainType TYP_pivot_c_c_OrderedSetType = idResolver.getType(PivotTables.CLSSid_OrderedSetType, null);
		final @NonNull /*@NonInvalid*/ DomainType TYP_pivot_c_c_SequenceType = idResolver.getType(PivotTables.CLSSid_SequenceType, null);
		final @NonNull /*@NonInvalid*/ DomainType TYP_pivot_c_c_SetType = idResolver.getType(PivotTables.CLSSid_SetType, null);
		@NonNull /*@Caught*/ Object _q;
		try {
		    final @Nullable /*@Thrown*/ String name = ((Nameable)self).getName();
		    _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, PivotTables.STR_closure);
		} catch (Exception e) { _q = ValuesUtil.createInvalidValue(e); }
		@Nullable /*@Caught*/ Object symbol_0;
		try {
		    @NonNull /*@Caught*/ Object oclIsKindOf;
		    try {
		        final @Nullable /*@Thrown*/ DomainExpression source = ((DomainCallExp)self).getSource();
		        if (source == null) throw new InvalidValueException("Null Literal");
		        final @Nullable /*@Thrown*/ DomainType type = source.getType();
		        oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type, TYP_pivot_c_c_SequenceType);
		    } catch (Exception e_1) { oclIsKindOf = ValuesUtil.createInvalidValue(e_1); }
		    @NonNull /*@Caught*/ Object oclIsKindOf_0;
		    try {
		        final @Nullable /*@Thrown*/ DomainExpression source_0 = ((DomainCallExp)self).getSource();
		        if (source_0 == null) throw new InvalidValueException("Null Literal");
		        final @Nullable /*@Thrown*/ DomainType type_0 = source_0.getType();
		        oclIsKindOf_0 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type_0, TYP_pivot_c_c_OrderedSetType);
		    } catch (Exception e_2) { oclIsKindOf_0 = ValuesUtil.createInvalidValue(e_2); }
		    final @Nullable /*@Thrown*/ Boolean or = BooleanOrOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, oclIsKindOf, oclIsKindOf_0);
		    if (or == ValuesUtil.TRUE_VALUE) {
		        final @Nullable /*@Thrown*/ DomainType type_1 = ((DomainTypedElement)self).getType();
		        final @NonNull /*@Thrown*/ Boolean oclIsKindOf_1 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type_1, TYP_pivot_c_c_OrderedSetType);
		        symbol_0 = oclIsKindOf_1;
		    }
		    else if (or == ValuesUtil.FALSE_VALUE) {
		        final @Nullable /*@Thrown*/ DomainType type_2 = ((DomainTypedElement)self).getType();
		        final @NonNull /*@Thrown*/ Boolean oclIsKindOf_2 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type_2, TYP_pivot_c_c_SetType);
		        symbol_0 = oclIsKindOf_2;
		    }
		    else {
		        throw ValuesUtil.INVALID_VALUE;
		    }
		    ;
		} catch (Exception e_0) { symbol_0 = ValuesUtil.createInvalidValue(e_0); }
		final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, symbol_0);
		if (implies == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = implies == null ? Diagnostic.ERROR : Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "ClosureTypeIsUniqueCollection", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__CLOSURE_TYPE_IS_UNIQUE_COLLECTION, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClosureSourceElementTypeIsBodyElementType(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * name = 'closure' implies
		 * source.type.oclAsType(CollectionType).elementType =
		 * if body.type.oclIsKindOf(CollectionType)
		 * then body.type.oclAsType(CollectionType).elementType
		 * else body.type
		 * endif
		 */
		final @NonNull /*@NonInvalid*/ Object self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(self, PivotTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@NonInvalid*/ DomainType TYP_pivot_c_c_CollectionType = idResolver.getType(PivotTables.CLSSid_CollectionType, null);
		@NonNull /*@Caught*/ Object _q;
		try {
		    final @Nullable /*@Thrown*/ String name = ((Nameable)self).getName();
		    _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, PivotTables.STR_closure);
		} catch (Exception e) { _q = ValuesUtil.createInvalidValue(e); }
		@NonNull /*@Caught*/ Object _q_0;
		try {
		    final @Nullable /*@Thrown*/ DomainExpression source = ((DomainCallExp)self).getSource();
		    if (source == null) throw new InvalidValueException("Null Literal");
		    final @Nullable /*@Thrown*/ DomainType type = source.getType();
		    final @Nullable /*@Thrown*/ Object oclAsType = OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, PivotTables.CLSSid_CollectionType, type, TYP_pivot_c_c_CollectionType);
		    if (oclAsType == null) throw new InvalidValueException("Null Literal");
		    final @Nullable /*@Thrown*/ DomainType elementType = ((DomainCollectionType)oclAsType).getElementType();
		    @Nullable /*@Thrown*/ Object symbol_0;
		    final @Nullable /*@Thrown*/ OCLExpression body = ((LoopExp)self).getBody();
		    if (body == null) throw new InvalidValueException("Null Literal");
		    final @Nullable /*@Thrown*/ DomainType type_0 = body.getType();
		    final @NonNull /*@Thrown*/ Boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type_0, TYP_pivot_c_c_CollectionType);
		    if (oclIsKindOf == ValuesUtil.TRUE_VALUE) {
		        final @Nullable /*@Thrown*/ OCLExpression body_0 = ((LoopExp)self).getBody();
		        if (body_0 == null) throw new InvalidValueException("Null Literal");
		        final @Nullable /*@Thrown*/ DomainType type_1 = body_0.getType();
		        final @Nullable /*@Thrown*/ Object oclAsType_0 = OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, PivotTables.CLSSid_CollectionType, type_1, TYP_pivot_c_c_CollectionType);
		        if (oclAsType_0 == null) throw new InvalidValueException("Null Literal");
		        final @Nullable /*@Thrown*/ DomainType elementType_0 = ((DomainCollectionType)oclAsType_0).getElementType();
		        symbol_0 = elementType_0;
		    }
		    else if (oclIsKindOf == ValuesUtil.FALSE_VALUE) {
		        final @Nullable /*@Thrown*/ OCLExpression body_1 = ((LoopExp)self).getBody();
		        if (body_1 == null) throw new InvalidValueException("Null Literal");
		        final @Nullable /*@Thrown*/ DomainType type_2 = body_1.getType();
		        symbol_0 = type_2;
		    }
		    else {
		        throw ValuesUtil.INVALID_VALUE;
		    }
		    _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, elementType, symbol_0);
		} catch (Exception e_0) { _q_0 = ValuesUtil.createInvalidValue(e_0); }
		final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
		if (implies == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = implies == null ? Diagnostic.ERROR : Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "ClosureSourceElementTypeIsBodyElementType", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__CLOSURE_SOURCE_ELEMENT_TYPE_IS_BODY_ELEMENT_TYPE, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClosureElementTypeIsSourceElementType(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * name = 'closure' implies
		 * type.oclAsType(CollectionType).elementType =
		 * source.type.oclAsType(CollectionType).elementType
		 */
		final @NonNull /*@NonInvalid*/ Object self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(self, PivotTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@NonInvalid*/ DomainType TYP_pivot_c_c_CollectionType = idResolver.getType(PivotTables.CLSSid_CollectionType, null);
		@NonNull /*@Caught*/ Object _q;
		try {
		    final @Nullable /*@Thrown*/ String name = ((Nameable)self).getName();
		    _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, PivotTables.STR_closure);
		} catch (Exception e) { _q = ValuesUtil.createInvalidValue(e); }
		@NonNull /*@Caught*/ Object _q_0;
		try {
		    final @Nullable /*@Thrown*/ DomainType type = ((DomainTypedElement)self).getType();
		    final @Nullable /*@Thrown*/ Object oclAsType = OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, PivotTables.CLSSid_CollectionType, type, TYP_pivot_c_c_CollectionType);
		    if (oclAsType == null) throw new InvalidValueException("Null Literal");
		    final @Nullable /*@Thrown*/ DomainType elementType = ((DomainCollectionType)oclAsType).getElementType();
		    final @Nullable /*@Thrown*/ DomainExpression source = ((DomainCallExp)self).getSource();
		    if (source == null) throw new InvalidValueException("Null Literal");
		    final @Nullable /*@Thrown*/ DomainType type_0 = source.getType();
		    final @Nullable /*@Thrown*/ Object oclAsType_0 = OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, PivotTables.CLSSid_CollectionType, type_0, TYP_pivot_c_c_CollectionType);
		    if (oclAsType_0 == null) throw new InvalidValueException("Null Literal");
		    final @Nullable /*@Thrown*/ DomainType elementType_0 = ((DomainCollectionType)oclAsType_0).getElementType();
		    _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, elementType, elementType_0);
		} catch (Exception e_0) { _q_0 = ValuesUtil.createInvalidValue(e_0); }
		final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
		if (implies == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = implies == null ? Diagnostic.ERROR : Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "ClosureElementTypeIsSourceElementType", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__CLOSURE_ELEMENT_TYPE_IS_SOURCE_ELEMENT_TYPE, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectHasOneIterator(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * name = 'collect' implies iterator->size() = 1
		 */
		final @NonNull /*@NonInvalid*/ Object self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(self, PivotTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		@NonNull /*@Caught*/ Object _q;
		try {
		    final @Nullable /*@Thrown*/ String name = ((Nameable)self).getName();
		    _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, PivotTables.STR_collect);
		} catch (Exception e) { _q = ValuesUtil.createInvalidValue(e); }
		@NonNull /*@Caught*/ Object _q_0;
		try {
		    final @SuppressWarnings("null")@NonNull /*@Thrown*/ List<?> iterator = ((LoopExp)self).getIterator();
		    final @NonNull /*@Thrown*/ OrderedSetValue BOXED_iterator = idResolver.createOrderedSetOfAll(PivotTables.ORD_CLSSid_Variable, iterator);
		    final @NonNull /*@Thrown*/ IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(evaluator, TypeId.INTEGER, BOXED_iterator);
		    _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, size, PivotTables.INT_1);
		} catch (Exception e_0) { _q_0 = ValuesUtil.createInvalidValue(e_0); }
		final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
		if (implies == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = implies == null ? Diagnostic.ERROR : Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "CollectHasOneIterator", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__COLLECT_HAS_ONE_ITERATOR, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectTypeIsUnordered(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * name = 'collect' implies
		 * if
		 *   source.type.oclIsKindOf(SequenceType) or
		 *   source.type.oclIsKindOf(OrderedSetType)
		 * then type.oclIsKindOf(SequenceType)
		 * else type.oclIsKindOf(BagType)
		 * endif
		 */
		final @NonNull /*@NonInvalid*/ Object self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(self, PivotTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@NonInvalid*/ DomainType TYP_pivot_c_c_BagType = idResolver.getType(PivotTables.CLSSid_BagType, null);
		final @NonNull /*@NonInvalid*/ DomainType TYP_pivot_c_c_OrderedSetType = idResolver.getType(PivotTables.CLSSid_OrderedSetType, null);
		final @NonNull /*@NonInvalid*/ DomainType TYP_pivot_c_c_SequenceType = idResolver.getType(PivotTables.CLSSid_SequenceType, null);
		@NonNull /*@Caught*/ Object _q;
		try {
		    final @Nullable /*@Thrown*/ String name = ((Nameable)self).getName();
		    _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, PivotTables.STR_collect);
		} catch (Exception e) { _q = ValuesUtil.createInvalidValue(e); }
		@Nullable /*@Caught*/ Object symbol_0;
		try {
		    @NonNull /*@Caught*/ Object oclIsKindOf;
		    try {
		        final @Nullable /*@Thrown*/ DomainExpression source = ((DomainCallExp)self).getSource();
		        if (source == null) throw new InvalidValueException("Null Literal");
		        final @Nullable /*@Thrown*/ DomainType type = source.getType();
		        oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type, TYP_pivot_c_c_SequenceType);
		    } catch (Exception e_1) { oclIsKindOf = ValuesUtil.createInvalidValue(e_1); }
		    @NonNull /*@Caught*/ Object oclIsKindOf_0;
		    try {
		        final @Nullable /*@Thrown*/ DomainExpression source_0 = ((DomainCallExp)self).getSource();
		        if (source_0 == null) throw new InvalidValueException("Null Literal");
		        final @Nullable /*@Thrown*/ DomainType type_0 = source_0.getType();
		        oclIsKindOf_0 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type_0, TYP_pivot_c_c_OrderedSetType);
		    } catch (Exception e_2) { oclIsKindOf_0 = ValuesUtil.createInvalidValue(e_2); }
		    final @Nullable /*@Thrown*/ Boolean or = BooleanOrOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, oclIsKindOf, oclIsKindOf_0);
		    if (or == ValuesUtil.TRUE_VALUE) {
		        final @Nullable /*@Thrown*/ DomainType type_1 = ((DomainTypedElement)self).getType();
		        final @NonNull /*@Thrown*/ Boolean oclIsKindOf_1 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type_1, TYP_pivot_c_c_SequenceType);
		        symbol_0 = oclIsKindOf_1;
		    }
		    else if (or == ValuesUtil.FALSE_VALUE) {
		        final @Nullable /*@Thrown*/ DomainType type_2 = ((DomainTypedElement)self).getType();
		        final @NonNull /*@Thrown*/ Boolean oclIsKindOf_2 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type_2, TYP_pivot_c_c_BagType);
		        symbol_0 = oclIsKindOf_2;
		    }
		    else {
		        throw ValuesUtil.INVALID_VALUE;
		    }
		    ;
		} catch (Exception e_0) { symbol_0 = ValuesUtil.createInvalidValue(e_0); }
		final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, symbol_0);
		if (implies == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = implies == null ? Diagnostic.ERROR : Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "CollectTypeIsUnordered", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__COLLECT_TYPE_IS_UNORDERED, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectElementTypeIsSourceElementType(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * name = 'collect' implies
		 * type.oclAsType(CollectionType).elementType =
		 * body.type.oclAsType(CollectionType).elementType
		 */
		final @NonNull /*@NonInvalid*/ Object self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(self, PivotTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@NonInvalid*/ DomainType TYP_pivot_c_c_CollectionType = idResolver.getType(PivotTables.CLSSid_CollectionType, null);
		@NonNull /*@Caught*/ Object _q;
		try {
		    final @Nullable /*@Thrown*/ String name = ((Nameable)self).getName();
		    _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, PivotTables.STR_collect);
		} catch (Exception e) { _q = ValuesUtil.createInvalidValue(e); }
		@NonNull /*@Caught*/ Object _q_0;
		try {
		    final @Nullable /*@Thrown*/ DomainType type = ((DomainTypedElement)self).getType();
		    final @Nullable /*@Thrown*/ Object oclAsType = OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, PivotTables.CLSSid_CollectionType, type, TYP_pivot_c_c_CollectionType);
		    if (oclAsType == null) throw new InvalidValueException("Null Literal");
		    final @Nullable /*@Thrown*/ DomainType elementType = ((DomainCollectionType)oclAsType).getElementType();
		    final @Nullable /*@Thrown*/ OCLExpression body = ((LoopExp)self).getBody();
		    if (body == null) throw new InvalidValueException("Null Literal");
		    final @Nullable /*@Thrown*/ DomainType type_0 = body.getType();
		    final @Nullable /*@Thrown*/ Object oclAsType_0 = OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, PivotTables.CLSSid_CollectionType, type_0, TYP_pivot_c_c_CollectionType);
		    if (oclAsType_0 == null) throw new InvalidValueException("Null Literal");
		    final @Nullable /*@Thrown*/ DomainType elementType_0 = ((DomainCollectionType)oclAsType_0).getElementType();
		    _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, elementType, elementType_0);
		} catch (Exception e_0) { _q_0 = ValuesUtil.createInvalidValue(e_0); }
		final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
		if (implies == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = implies == null ? Diagnostic.ERROR : Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "CollectElementTypeIsSourceElementType", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__COLLECT_ELEMENT_TYPE_IS_SOURCE_ELEMENT_TYPE, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectNestedHasOneIterator(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * name = 'collectNested' implies iterator->size() = 1
		 */
		final @NonNull /*@NonInvalid*/ Object self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(self, PivotTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		@NonNull /*@Caught*/ Object _q;
		try {
		    final @Nullable /*@Thrown*/ String name = ((Nameable)self).getName();
		    _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, PivotTables.STR_collectNested);
		} catch (Exception e) { _q = ValuesUtil.createInvalidValue(e); }
		@NonNull /*@Caught*/ Object _q_0;
		try {
		    final @SuppressWarnings("null")@NonNull /*@Thrown*/ List<?> iterator = ((LoopExp)self).getIterator();
		    final @NonNull /*@Thrown*/ OrderedSetValue BOXED_iterator = idResolver.createOrderedSetOfAll(PivotTables.ORD_CLSSid_Variable, iterator);
		    final @NonNull /*@Thrown*/ IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(evaluator, TypeId.INTEGER, BOXED_iterator);
		    _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, size, PivotTables.INT_1);
		} catch (Exception e_0) { _q_0 = ValuesUtil.createInvalidValue(e_0); }
		final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
		if (implies == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = implies == null ? Diagnostic.ERROR : Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "CollectNestedHasOneIterator", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__COLLECT_NESTED_HAS_ONE_ITERATOR, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectNestedTypeIsBag(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * name = 'collectNested' implies type.oclIsKindOf(BagType)
		 */
		final @NonNull /*@NonInvalid*/ Object self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(self, PivotTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@NonInvalid*/ DomainType TYP_pivot_c_c_BagType = idResolver.getType(PivotTables.CLSSid_BagType, null);
		@NonNull /*@Caught*/ Object _q;
		try {
		    final @Nullable /*@Thrown*/ String name = ((Nameable)self).getName();
		    _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, PivotTables.STR_collectNested);
		} catch (Exception e) { _q = ValuesUtil.createInvalidValue(e); }
		@NonNull /*@Caught*/ Object oclIsKindOf;
		try {
		    final @Nullable /*@Thrown*/ DomainType type = ((DomainTypedElement)self).getType();
		    oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type, TYP_pivot_c_c_BagType);
		} catch (Exception e_0) { oclIsKindOf = ValuesUtil.createInvalidValue(e_0); }
		final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, oclIsKindOf);
		if (implies == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = implies == null ? Diagnostic.ERROR : Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "CollectNestedTypeIsBag", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__COLLECT_NESTED_TYPE_IS_BAG, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectNestedTypeIsBodyType(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * name = 'collectNested' implies type = body.type
		 */
		final @NonNull /*@NonInvalid*/ Object self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(self, PivotTables.LIBRARY);
		@NonNull /*@Caught*/ Object _q;
		try {
		    final @Nullable /*@Thrown*/ String name = ((Nameable)self).getName();
		    _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, PivotTables.STR_collectNested);
		} catch (Exception e) { _q = ValuesUtil.createInvalidValue(e); }
		@NonNull /*@Caught*/ Object _q_0;
		try {
		    final @Nullable /*@Thrown*/ DomainType type = ((DomainTypedElement)self).getType();
		    final @Nullable /*@Thrown*/ OCLExpression body = ((LoopExp)self).getBody();
		    if (body == null) throw new InvalidValueException("Null Literal");
		    final @Nullable /*@Thrown*/ DomainType type_0 = body.getType();
		    _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type, type_0);
		} catch (Exception e_0) { _q_0 = ValuesUtil.createInvalidValue(e_0); }
		final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
		if (implies == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = implies == null ? Diagnostic.ERROR : Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "CollectNestedTypeIsBodyType", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__COLLECT_NESTED_TYPE_IS_BODY_TYPE, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExistsTypeIsBoolean(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * name = 'exists' implies type = Boolean
		 */
		final @NonNull /*@NonInvalid*/ Object self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(self, PivotTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@NonInvalid*/ DomainType TYP_Boolean = idResolver.getType(TypeId.BOOLEAN, null);
		@NonNull /*@Caught*/ Object _q;
		try {
		    final @Nullable /*@Thrown*/ String name = ((Nameable)self).getName();
		    _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, PivotTables.STR_exists);
		} catch (Exception e) { _q = ValuesUtil.createInvalidValue(e); }
		@NonNull /*@Caught*/ Object _q_0;
		try {
		    final @Nullable /*@Thrown*/ DomainType type = ((DomainTypedElement)self).getType();
		    _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type, TYP_Boolean);
		} catch (Exception e_0) { _q_0 = ValuesUtil.createInvalidValue(e_0); }
		final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
		if (implies == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = implies == null ? Diagnostic.ERROR : Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "ExistsTypeIsBoolean", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__EXISTS_TYPE_IS_BOOLEAN, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExistsBodyTypeIsBoolean(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * name = 'exists' implies body.type = Boolean
		 */
		final @NonNull /*@NonInvalid*/ Object self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(self, PivotTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@NonInvalid*/ DomainType TYP_Boolean = idResolver.getType(TypeId.BOOLEAN, null);
		@NonNull /*@Caught*/ Object _q;
		try {
		    final @Nullable /*@Thrown*/ String name = ((Nameable)self).getName();
		    _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, PivotTables.STR_exists);
		} catch (Exception e) { _q = ValuesUtil.createInvalidValue(e); }
		@NonNull /*@Caught*/ Object _q_0;
		try {
		    final @Nullable /*@Thrown*/ OCLExpression body = ((LoopExp)self).getBody();
		    if (body == null) throw new InvalidValueException("Null Literal");
		    final @Nullable /*@Thrown*/ DomainType type = body.getType();
		    _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type, TYP_Boolean);
		} catch (Exception e_0) { _q_0 = ValuesUtil.createInvalidValue(e_0); }
		final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
		if (implies == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = implies == null ? Diagnostic.ERROR : Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "ExistsBodyTypeIsBoolean", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__EXISTS_BODY_TYPE_IS_BOOLEAN, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateForAllTypeIsBoolean(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * name = 'forAll' implies type = Boolean
		 */
		final @NonNull /*@NonInvalid*/ Object self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(self, PivotTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@NonInvalid*/ DomainType TYP_Boolean = idResolver.getType(TypeId.BOOLEAN, null);
		@NonNull /*@Caught*/ Object _q;
		try {
		    final @Nullable /*@Thrown*/ String name = ((Nameable)self).getName();
		    _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, PivotTables.STR_forAll);
		} catch (Exception e) { _q = ValuesUtil.createInvalidValue(e); }
		@NonNull /*@Caught*/ Object _q_0;
		try {
		    final @Nullable /*@Thrown*/ DomainType type = ((DomainTypedElement)self).getType();
		    _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type, TYP_Boolean);
		} catch (Exception e_0) { _q_0 = ValuesUtil.createInvalidValue(e_0); }
		final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
		if (implies == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = implies == null ? Diagnostic.ERROR : Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "ForAllTypeIsBoolean", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__FOR_ALL_TYPE_IS_BOOLEAN, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateForAllBodyTypeIsBoolean(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * name = 'forAll' implies body.type = Boolean
		 */
		final @NonNull /*@NonInvalid*/ Object self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(self, PivotTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@NonInvalid*/ DomainType TYP_Boolean = idResolver.getType(TypeId.BOOLEAN, null);
		@NonNull /*@Caught*/ Object _q;
		try {
		    final @Nullable /*@Thrown*/ String name = ((Nameable)self).getName();
		    _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, PivotTables.STR_forAll);
		} catch (Exception e) { _q = ValuesUtil.createInvalidValue(e); }
		@NonNull /*@Caught*/ Object _q_0;
		try {
		    final @Nullable /*@Thrown*/ OCLExpression body = ((LoopExp)self).getBody();
		    if (body == null) throw new InvalidValueException("Null Literal");
		    final @Nullable /*@Thrown*/ DomainType type = body.getType();
		    _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type, TYP_Boolean);
		} catch (Exception e_0) { _q_0 = ValuesUtil.createInvalidValue(e_0); }
		final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
		if (implies == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = implies == null ? Diagnostic.ERROR : Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "ForAllBodyTypeIsBoolean", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__FOR_ALL_BODY_TYPE_IS_BOOLEAN, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIsUniqueHasOneIterator(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * name = 'isUnique' implies iterator->size() = 1
		 */
		final @NonNull /*@NonInvalid*/ Object self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(self, PivotTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		@NonNull /*@Caught*/ Object _q;
		try {
		    final @Nullable /*@Thrown*/ String name = ((Nameable)self).getName();
		    _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, PivotTables.STR_isUnique);
		} catch (Exception e) { _q = ValuesUtil.createInvalidValue(e); }
		@NonNull /*@Caught*/ Object _q_0;
		try {
		    final @SuppressWarnings("null")@NonNull /*@Thrown*/ List<?> iterator = ((LoopExp)self).getIterator();
		    final @NonNull /*@Thrown*/ OrderedSetValue BOXED_iterator = idResolver.createOrderedSetOfAll(PivotTables.ORD_CLSSid_Variable, iterator);
		    final @NonNull /*@Thrown*/ IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(evaluator, TypeId.INTEGER, BOXED_iterator);
		    _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, size, PivotTables.INT_1);
		} catch (Exception e_0) { _q_0 = ValuesUtil.createInvalidValue(e_0); }
		final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
		if (implies == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = implies == null ? Diagnostic.ERROR : Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "IsUniqueHasOneIterator", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__IS_UNIQUE_HAS_ONE_ITERATOR, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIsUniqueTypeIsBoolean(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * name = 'isUnique' implies type = Boolean
		 */
		final @NonNull /*@NonInvalid*/ Object self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(self, PivotTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@NonInvalid*/ DomainType TYP_Boolean = idResolver.getType(TypeId.BOOLEAN, null);
		@NonNull /*@Caught*/ Object _q;
		try {
		    final @Nullable /*@Thrown*/ String name = ((Nameable)self).getName();
		    _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, PivotTables.STR_isUnique);
		} catch (Exception e) { _q = ValuesUtil.createInvalidValue(e); }
		@NonNull /*@Caught*/ Object _q_0;
		try {
		    final @Nullable /*@Thrown*/ DomainType type = ((DomainTypedElement)self).getType();
		    _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type, TYP_Boolean);
		} catch (Exception e_0) { _q_0 = ValuesUtil.createInvalidValue(e_0); }
		final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
		if (implies == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = implies == null ? Diagnostic.ERROR : Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "IsUniqueTypeIsBoolean", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__IS_UNIQUE_TYPE_IS_BOOLEAN, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOneHasOneIterator(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * name = 'one' implies iterator->size() = 1
		 */
		final @NonNull /*@NonInvalid*/ Object self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(self, PivotTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		@NonNull /*@Caught*/ Object _q;
		try {
		    final @Nullable /*@Thrown*/ String name = ((Nameable)self).getName();
		    _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, PivotTables.STR_one);
		} catch (Exception e) { _q = ValuesUtil.createInvalidValue(e); }
		@NonNull /*@Caught*/ Object _q_0;
		try {
		    final @SuppressWarnings("null")@NonNull /*@Thrown*/ List<?> iterator = ((LoopExp)self).getIterator();
		    final @NonNull /*@Thrown*/ OrderedSetValue BOXED_iterator = idResolver.createOrderedSetOfAll(PivotTables.ORD_CLSSid_Variable, iterator);
		    final @NonNull /*@Thrown*/ IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(evaluator, TypeId.INTEGER, BOXED_iterator);
		    _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, size, PivotTables.INT_1);
		} catch (Exception e_0) { _q_0 = ValuesUtil.createInvalidValue(e_0); }
		final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
		if (implies == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = implies == null ? Diagnostic.ERROR : Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "OneHasOneIterator", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__ONE_HAS_ONE_ITERATOR, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOneTypeIsBoolean(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * name = 'one' implies type = Boolean
		 */
		final @NonNull /*@NonInvalid*/ Object self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(self, PivotTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@NonInvalid*/ DomainType TYP_Boolean = idResolver.getType(TypeId.BOOLEAN, null);
		@NonNull /*@Caught*/ Object _q;
		try {
		    final @Nullable /*@Thrown*/ String name = ((Nameable)self).getName();
		    _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, PivotTables.STR_one);
		} catch (Exception e) { _q = ValuesUtil.createInvalidValue(e); }
		@NonNull /*@Caught*/ Object _q_0;
		try {
		    final @Nullable /*@Thrown*/ DomainType type = ((DomainTypedElement)self).getType();
		    _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type, TYP_Boolean);
		} catch (Exception e_0) { _q_0 = ValuesUtil.createInvalidValue(e_0); }
		final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
		if (implies == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = implies == null ? Diagnostic.ERROR : Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "OneTypeIsBoolean", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__ONE_TYPE_IS_BOOLEAN, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOneBodyTypeIsBoolean(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * name = 'one' implies body.type = Boolean
		 */
		final @NonNull /*@NonInvalid*/ Object self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(self, PivotTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@NonInvalid*/ DomainType TYP_Boolean = idResolver.getType(TypeId.BOOLEAN, null);
		@NonNull /*@Caught*/ Object _q;
		try {
		    final @Nullable /*@Thrown*/ String name = ((Nameable)self).getName();
		    _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, PivotTables.STR_one);
		} catch (Exception e) { _q = ValuesUtil.createInvalidValue(e); }
		@NonNull /*@Caught*/ Object _q_0;
		try {
		    final @Nullable /*@Thrown*/ OCLExpression body = ((LoopExp)self).getBody();
		    if (body == null) throw new InvalidValueException("Null Literal");
		    final @Nullable /*@Thrown*/ DomainType type = body.getType();
		    _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type, TYP_Boolean);
		} catch (Exception e_0) { _q_0 = ValuesUtil.createInvalidValue(e_0); }
		final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
		if (implies == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = implies == null ? Diagnostic.ERROR : Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "OneBodyTypeIsBoolean", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__ONE_BODY_TYPE_IS_BOOLEAN, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRejectOrSelectHasOneIterator(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * name = 'reject' or name = 'select' implies iterator->size() = 1
		 */
		final @NonNull /*@NonInvalid*/ Object self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(self, PivotTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		@Nullable /*@Caught*/ Object or;
		try {
		    @NonNull /*@Caught*/ Object _q;
		    try {
		        final @Nullable /*@Thrown*/ String name = ((Nameable)self).getName();
		        _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, PivotTables.STR_reject);
		    } catch (Exception e) { _q = ValuesUtil.createInvalidValue(e); }
		    @NonNull /*@Caught*/ Object _q_0;
		    try {
		        final @Nullable /*@Thrown*/ String name_0 = ((Nameable)self).getName();
		        _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name_0, PivotTables.STR_select);
		    } catch (Exception e_0) { _q_0 = ValuesUtil.createInvalidValue(e_0); }
		    or = BooleanOrOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
		} catch (Exception e_1) { or = ValuesUtil.createInvalidValue(e_1); }
		@NonNull /*@Caught*/ Object _q_1;
		try {
		    final @SuppressWarnings("null")@NonNull /*@Thrown*/ List<?> iterator = ((LoopExp)self).getIterator();
		    final @NonNull /*@Thrown*/ OrderedSetValue BOXED_iterator = idResolver.createOrderedSetOfAll(PivotTables.ORD_CLSSid_Variable, iterator);
		    final @NonNull /*@Thrown*/ IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(evaluator, TypeId.INTEGER, BOXED_iterator);
		    _q_1 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, size, PivotTables.INT_1);
		} catch (Exception e_2) { _q_1 = ValuesUtil.createInvalidValue(e_2); }
		final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, or, _q_1);
		if (implies == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = implies == null ? Diagnostic.ERROR : Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "RejectOrSelectHasOneIterator", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__REJECT_OR_SELECT_HAS_ONE_ITERATOR, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRejectOrSelectTypeIsSourceType(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * name = 'reject' or name = 'select' implies type = source.type
		 */
		final @NonNull /*@NonInvalid*/ Object self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(self, PivotTables.LIBRARY);
		@Nullable /*@Caught*/ Object or;
		try {
		    @NonNull /*@Caught*/ Object _q;
		    try {
		        final @Nullable /*@Thrown*/ String name = ((Nameable)self).getName();
		        _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, PivotTables.STR_reject);
		    } catch (Exception e) { _q = ValuesUtil.createInvalidValue(e); }
		    @NonNull /*@Caught*/ Object _q_0;
		    try {
		        final @Nullable /*@Thrown*/ String name_0 = ((Nameable)self).getName();
		        _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name_0, PivotTables.STR_select);
		    } catch (Exception e_0) { _q_0 = ValuesUtil.createInvalidValue(e_0); }
		    or = BooleanOrOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
		} catch (Exception e_1) { or = ValuesUtil.createInvalidValue(e_1); }
		@NonNull /*@Caught*/ Object _q_1;
		try {
		    final @Nullable /*@Thrown*/ DomainType type = ((DomainTypedElement)self).getType();
		    final @Nullable /*@Thrown*/ DomainExpression source = ((DomainCallExp)self).getSource();
		    if (source == null) throw new InvalidValueException("Null Literal");
		    final @Nullable /*@Thrown*/ DomainType type_0 = source.getType();
		    _q_1 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type, type_0);
		} catch (Exception e_2) { _q_1 = ValuesUtil.createInvalidValue(e_2); }
		final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, or, _q_1);
		if (implies == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = implies == null ? Diagnostic.ERROR : Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "RejectOrSelectTypeIsSourceType", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__REJECT_OR_SELECT_TYPE_IS_SOURCE_TYPE, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRejectOrSelectTypeIsBoolean(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * name = 'reject' or name = 'select' implies type = Boolean
		 */
		final @NonNull /*@NonInvalid*/ Object self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(self, PivotTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@NonInvalid*/ DomainType TYP_Boolean = idResolver.getType(TypeId.BOOLEAN, null);
		@Nullable /*@Caught*/ Object or;
		try {
		    @NonNull /*@Caught*/ Object _q;
		    try {
		        final @Nullable /*@Thrown*/ String name = ((Nameable)self).getName();
		        _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, PivotTables.STR_reject);
		    } catch (Exception e) { _q = ValuesUtil.createInvalidValue(e); }
		    @NonNull /*@Caught*/ Object _q_0;
		    try {
		        final @Nullable /*@Thrown*/ String name_0 = ((Nameable)self).getName();
		        _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name_0, PivotTables.STR_select);
		    } catch (Exception e_0) { _q_0 = ValuesUtil.createInvalidValue(e_0); }
		    or = BooleanOrOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
		} catch (Exception e_1) { or = ValuesUtil.createInvalidValue(e_1); }
		@NonNull /*@Caught*/ Object _q_1;
		try {
		    final @Nullable /*@Thrown*/ DomainType type = ((DomainTypedElement)self).getType();
		    _q_1 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type, TYP_Boolean);
		} catch (Exception e_2) { _q_1 = ValuesUtil.createInvalidValue(e_2); }
		final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, or, _q_1);
		if (implies == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = implies == null ? Diagnostic.ERROR : Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "RejectOrSelectTypeIsBoolean", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__REJECT_OR_SELECT_TYPE_IS_BOOLEAN, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSortedByHasOneIterator(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * name = 'sortedBy' implies iterator->size() = 1
		 */
		final @NonNull /*@NonInvalid*/ Object self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(self, PivotTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		@NonNull /*@Caught*/ Object _q;
		try {
		    final @Nullable /*@Thrown*/ String name = ((Nameable)self).getName();
		    _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, PivotTables.STR_sortedBy);
		} catch (Exception e) { _q = ValuesUtil.createInvalidValue(e); }
		@NonNull /*@Caught*/ Object _q_0;
		try {
		    final @SuppressWarnings("null")@NonNull /*@Thrown*/ List<?> iterator = ((LoopExp)self).getIterator();
		    final @NonNull /*@Thrown*/ OrderedSetValue BOXED_iterator = idResolver.createOrderedSetOfAll(PivotTables.ORD_CLSSid_Variable, iterator);
		    final @NonNull /*@Thrown*/ IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(evaluator, TypeId.INTEGER, BOXED_iterator);
		    _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, size, PivotTables.INT_1);
		} catch (Exception e_0) { _q_0 = ValuesUtil.createInvalidValue(e_0); }
		final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
		if (implies == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = implies == null ? Diagnostic.ERROR : Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "SortedByHasOneIterator", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__SORTED_BY_HAS_ONE_ITERATOR, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSortedByIsOrderedIfSourceIsOrdered(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * name = 'sortedBy' implies
		 * if
		 *   source.type.oclIsKindOf(SequenceType) or
		 *   source.type.oclIsKindOf(BagType)
		 * then type.oclIsKindOf(SequenceType)
		 * else type.oclIsKindOf(OrderedSetType)
		 * endif
		 */
		final @NonNull /*@NonInvalid*/ Object self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(self, PivotTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@NonInvalid*/ DomainType TYP_pivot_c_c_BagType = idResolver.getType(PivotTables.CLSSid_BagType, null);
		final @NonNull /*@NonInvalid*/ DomainType TYP_pivot_c_c_OrderedSetType = idResolver.getType(PivotTables.CLSSid_OrderedSetType, null);
		final @NonNull /*@NonInvalid*/ DomainType TYP_pivot_c_c_SequenceType = idResolver.getType(PivotTables.CLSSid_SequenceType, null);
		@NonNull /*@Caught*/ Object _q;
		try {
		    final @Nullable /*@Thrown*/ String name = ((Nameable)self).getName();
		    _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, PivotTables.STR_sortedBy);
		} catch (Exception e) { _q = ValuesUtil.createInvalidValue(e); }
		@Nullable /*@Caught*/ Object symbol_0;
		try {
		    @NonNull /*@Caught*/ Object oclIsKindOf;
		    try {
		        final @Nullable /*@Thrown*/ DomainExpression source = ((DomainCallExp)self).getSource();
		        if (source == null) throw new InvalidValueException("Null Literal");
		        final @Nullable /*@Thrown*/ DomainType type = source.getType();
		        oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type, TYP_pivot_c_c_SequenceType);
		    } catch (Exception e_1) { oclIsKindOf = ValuesUtil.createInvalidValue(e_1); }
		    @NonNull /*@Caught*/ Object oclIsKindOf_0;
		    try {
		        final @Nullable /*@Thrown*/ DomainExpression source_0 = ((DomainCallExp)self).getSource();
		        if (source_0 == null) throw new InvalidValueException("Null Literal");
		        final @Nullable /*@Thrown*/ DomainType type_0 = source_0.getType();
		        oclIsKindOf_0 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type_0, TYP_pivot_c_c_BagType);
		    } catch (Exception e_2) { oclIsKindOf_0 = ValuesUtil.createInvalidValue(e_2); }
		    final @Nullable /*@Thrown*/ Boolean or = BooleanOrOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, oclIsKindOf, oclIsKindOf_0);
		    if (or == ValuesUtil.TRUE_VALUE) {
		        final @Nullable /*@Thrown*/ DomainType type_1 = ((DomainTypedElement)self).getType();
		        final @NonNull /*@Thrown*/ Boolean oclIsKindOf_1 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type_1, TYP_pivot_c_c_SequenceType);
		        symbol_0 = oclIsKindOf_1;
		    }
		    else if (or == ValuesUtil.FALSE_VALUE) {
		        final @Nullable /*@Thrown*/ DomainType type_2 = ((DomainTypedElement)self).getType();
		        final @NonNull /*@Thrown*/ Boolean oclIsKindOf_2 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type_2, TYP_pivot_c_c_OrderedSetType);
		        symbol_0 = oclIsKindOf_2;
		    }
		    else {
		        throw ValuesUtil.INVALID_VALUE;
		    }
		    ;
		} catch (Exception e_0) { symbol_0 = ValuesUtil.createInvalidValue(e_0); }
		final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, symbol_0);
		if (implies == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = implies == null ? Diagnostic.ERROR : Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "SortedByIsOrderedIfSourceIsOrdered", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__SORTED_BY_IS_ORDERED_IF_SOURCE_IS_ORDERED, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSortedByElementTypeIsSourceElementType(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * name = 'sortedBy' implies
		 * type.oclAsType(CollectionType).elementType =
		 * body.type.oclAsType(CollectionType).elementType
		 */
		final @NonNull /*@NonInvalid*/ Object self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(self, PivotTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@NonInvalid*/ DomainType TYP_pivot_c_c_CollectionType = idResolver.getType(PivotTables.CLSSid_CollectionType, null);
		@NonNull /*@Caught*/ Object _q;
		try {
		    final @Nullable /*@Thrown*/ String name = ((Nameable)self).getName();
		    _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, PivotTables.STR_sortedBy);
		} catch (Exception e) { _q = ValuesUtil.createInvalidValue(e); }
		@NonNull /*@Caught*/ Object _q_0;
		try {
		    final @Nullable /*@Thrown*/ DomainType type = ((DomainTypedElement)self).getType();
		    final @Nullable /*@Thrown*/ Object oclAsType = OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, PivotTables.CLSSid_CollectionType, type, TYP_pivot_c_c_CollectionType);
		    if (oclAsType == null) throw new InvalidValueException("Null Literal");
		    final @Nullable /*@Thrown*/ DomainType elementType = ((DomainCollectionType)oclAsType).getElementType();
		    final @Nullable /*@Thrown*/ OCLExpression body = ((LoopExp)self).getBody();
		    if (body == null) throw new InvalidValueException("Null Literal");
		    final @Nullable /*@Thrown*/ DomainType type_0 = body.getType();
		    final @Nullable /*@Thrown*/ Object oclAsType_0 = OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, PivotTables.CLSSid_CollectionType, type_0, TYP_pivot_c_c_CollectionType);
		    if (oclAsType_0 == null) throw new InvalidValueException("Null Literal");
		    final @Nullable /*@Thrown*/ DomainType elementType_0 = ((DomainCollectionType)oclAsType_0).getElementType();
		    _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, elementType, elementType_0);
		} catch (Exception e_0) { _q_0 = ValuesUtil.createInvalidValue(e_0); }
		final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
		if (implies == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = implies == null ? Diagnostic.ERROR : Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "SortedByElementTypeIsSourceElementType", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__SORTED_BY_ELEMENT_TYPE_IS_SOURCE_ELEMENT_TYPE, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIteratorTypeIsSourceElementType(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * self.iterator->forAll(type =
		 *   source.type.oclAsType(CollectionType).elementType)
		 */
		final @NonNull /*@NonInvalid*/ Object self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(self, PivotTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@NonInvalid*/ DomainType TYP_pivot_c_c_CollectionType = idResolver.getType(PivotTables.CLSSid_CollectionType, null);
		final @SuppressWarnings("null")@NonNull /*@Thrown*/ List<?> iterator = ((LoopExp)self).getIterator();
		final @NonNull /*@Thrown*/ OrderedSetValue BOXED_iterator = idResolver.createOrderedSetOfAll(PivotTables.ORD_CLSSid_Variable, iterator);
		final @NonNull /*@NonInvalid*/ Iterator<?> iterator_iterator = BOXED_iterator.iterator();
		@Nullable /*@Thrown*/ Boolean forAll;
		while (true) {
		    if (!iterator_iterator.hasNext()) {
		        forAll = ValuesUtil.TRUE_VALUE;
		        break;
		    }
		    final @Nullable /*@NonInvalid*/ Object _49__ = iterator_iterator.next();
		    /**
		     * type = source.type.oclAsType(CollectionType).elementType
		     */
		    if (_49__ == null) throw new InvalidValueException("Null Literal");
		    final @Nullable /*@Thrown*/ DomainType type = ((DomainTypedElement)_49__).getType();
		    final @Nullable /*@Thrown*/ DomainExpression source = ((DomainCallExp)self).getSource();
		    if (source == null) throw new InvalidValueException("Null Literal");
		    final @Nullable /*@Thrown*/ DomainType type_0 = source.getType();
		    final @Nullable /*@Thrown*/ Object oclAsType = OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, PivotTables.CLSSid_CollectionType, type_0, TYP_pivot_c_c_CollectionType);
		    if (oclAsType == null) throw new InvalidValueException("Null Literal");
		    final @Nullable /*@Thrown*/ DomainType elementType = ((DomainCollectionType)oclAsType).getElementType();
		    final @NonNull /*@Thrown*/ Boolean _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type, elementType);
		    /**/
		    if (_q != ValuesUtil.TRUE_VALUE) {			// Carry unless something not found
		        forAll = ValuesUtil.FALSE_VALUE;			// Abort after a fail
		        break;
		    }
		}
		if (forAll == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = forAll == null ? Diagnostic.ERROR : Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IteratorExp", "IteratorTypeIsSourceElementType", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATOR_EXP__ITERATOR_TYPE_IS_SOURCE_ELEMENT_TYPE, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass)
	{
		if (baseClass == ReferringElement.class)
		{
			switch (baseOperationID)
			{
				case PivotPackage.REFERRING_ELEMENT___GET_REFERRED_ELEMENT: return PivotPackage.ITERATOR_EXP___GET_REFERRED_ELEMENT;
				default: return -1;
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException
	{
		switch (operationID)
		{
			case PivotPackage.ITERATOR_EXP___ALL_OWNED_ELEMENTS:
				return allOwnedElements();
			case PivotPackage.ITERATOR_EXP___GET_VALUE__TYPE_STRING:
				return getValue((Type)arguments.get(0), (String)arguments.get(1));
			case PivotPackage.ITERATOR_EXP___VALIDATE_NOT_OWN_SELF__DIAGNOSTICCHAIN_MAP:
				return validateNotOwnSelf((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.ITERATOR_EXP___VALIDATE_SOURCE_IS_COLLECTION__DIAGNOSTICCHAIN_MAP:
				return validateSourceIsCollection((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.ITERATOR_EXP___VALIDATE_NO_INITIALIZERS__DIAGNOSTICCHAIN_MAP:
				return validateNoInitializers((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.ITERATOR_EXP___GET_REFERRED_ELEMENT:
				return getReferredElement();
			case PivotPackage.ITERATOR_EXP___VALIDATE_CLOSURE_BODY_TYPE_IS_CONFORMANTTO_ITERATOR_TYPE__DIAGNOSTICCHAIN_MAP:
				return validateClosureBodyTypeIsConformanttoIteratorType((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.ITERATOR_EXP___VALIDATE_SORTED_BY_ITERATOR_TYPE_IS_COMPARABLE__DIAGNOSTICCHAIN_MAP:
				return validateSortedByIteratorTypeIsComparable((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.ITERATOR_EXP___VALIDATE_ANY_HAS_ONE_ITERATOR__DIAGNOSTICCHAIN_MAP:
				return validateAnyHasOneIterator((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.ITERATOR_EXP___VALIDATE_ANY_TYPE_IS_SOURCE_ELEMENT_TYPE__DIAGNOSTICCHAIN_MAP:
				return validateAnyTypeIsSourceElementType((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.ITERATOR_EXP___VALIDATE_ANY_BODY_TYPE_IS_BOOLEAN__DIAGNOSTICCHAIN_MAP:
				return validateAnyBodyTypeIsBoolean((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.ITERATOR_EXP___VALIDATE_CLOSURE_HAS_ONE_ITERATOR__DIAGNOSTICCHAIN_MAP:
				return validateClosureHasOneIterator((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.ITERATOR_EXP___VALIDATE_CLOSURE_TYPE_IS_UNIQUE_COLLECTION__DIAGNOSTICCHAIN_MAP:
				return validateClosureTypeIsUniqueCollection((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.ITERATOR_EXP___VALIDATE_CLOSURE_SOURCE_ELEMENT_TYPE_IS_BODY_ELEMENT_TYPE__DIAGNOSTICCHAIN_MAP:
				return validateClosureSourceElementTypeIsBodyElementType((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.ITERATOR_EXP___VALIDATE_CLOSURE_ELEMENT_TYPE_IS_SOURCE_ELEMENT_TYPE__DIAGNOSTICCHAIN_MAP:
				return validateClosureElementTypeIsSourceElementType((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.ITERATOR_EXP___VALIDATE_COLLECT_HAS_ONE_ITERATOR__DIAGNOSTICCHAIN_MAP:
				return validateCollectHasOneIterator((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.ITERATOR_EXP___VALIDATE_COLLECT_TYPE_IS_UNORDERED__DIAGNOSTICCHAIN_MAP:
				return validateCollectTypeIsUnordered((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.ITERATOR_EXP___VALIDATE_COLLECT_ELEMENT_TYPE_IS_SOURCE_ELEMENT_TYPE__DIAGNOSTICCHAIN_MAP:
				return validateCollectElementTypeIsSourceElementType((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.ITERATOR_EXP___VALIDATE_COLLECT_NESTED_HAS_ONE_ITERATOR__DIAGNOSTICCHAIN_MAP:
				return validateCollectNestedHasOneIterator((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.ITERATOR_EXP___VALIDATE_COLLECT_NESTED_TYPE_IS_BAG__DIAGNOSTICCHAIN_MAP:
				return validateCollectNestedTypeIsBag((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.ITERATOR_EXP___VALIDATE_COLLECT_NESTED_TYPE_IS_BODY_TYPE__DIAGNOSTICCHAIN_MAP:
				return validateCollectNestedTypeIsBodyType((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.ITERATOR_EXP___VALIDATE_EXISTS_TYPE_IS_BOOLEAN__DIAGNOSTICCHAIN_MAP:
				return validateExistsTypeIsBoolean((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.ITERATOR_EXP___VALIDATE_EXISTS_BODY_TYPE_IS_BOOLEAN__DIAGNOSTICCHAIN_MAP:
				return validateExistsBodyTypeIsBoolean((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.ITERATOR_EXP___VALIDATE_FOR_ALL_TYPE_IS_BOOLEAN__DIAGNOSTICCHAIN_MAP:
				return validateForAllTypeIsBoolean((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.ITERATOR_EXP___VALIDATE_FOR_ALL_BODY_TYPE_IS_BOOLEAN__DIAGNOSTICCHAIN_MAP:
				return validateForAllBodyTypeIsBoolean((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.ITERATOR_EXP___VALIDATE_IS_UNIQUE_HAS_ONE_ITERATOR__DIAGNOSTICCHAIN_MAP:
				return validateIsUniqueHasOneIterator((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.ITERATOR_EXP___VALIDATE_IS_UNIQUE_TYPE_IS_BOOLEAN__DIAGNOSTICCHAIN_MAP:
				return validateIsUniqueTypeIsBoolean((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.ITERATOR_EXP___VALIDATE_ONE_HAS_ONE_ITERATOR__DIAGNOSTICCHAIN_MAP:
				return validateOneHasOneIterator((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.ITERATOR_EXP___VALIDATE_ONE_TYPE_IS_BOOLEAN__DIAGNOSTICCHAIN_MAP:
				return validateOneTypeIsBoolean((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.ITERATOR_EXP___VALIDATE_ONE_BODY_TYPE_IS_BOOLEAN__DIAGNOSTICCHAIN_MAP:
				return validateOneBodyTypeIsBoolean((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.ITERATOR_EXP___VALIDATE_REJECT_OR_SELECT_HAS_ONE_ITERATOR__DIAGNOSTICCHAIN_MAP:
				return validateRejectOrSelectHasOneIterator((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.ITERATOR_EXP___VALIDATE_REJECT_OR_SELECT_TYPE_IS_SOURCE_TYPE__DIAGNOSTICCHAIN_MAP:
				return validateRejectOrSelectTypeIsSourceType((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.ITERATOR_EXP___VALIDATE_REJECT_OR_SELECT_TYPE_IS_BOOLEAN__DIAGNOSTICCHAIN_MAP:
				return validateRejectOrSelectTypeIsBoolean((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.ITERATOR_EXP___VALIDATE_SORTED_BY_HAS_ONE_ITERATOR__DIAGNOSTICCHAIN_MAP:
				return validateSortedByHasOneIterator((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.ITERATOR_EXP___VALIDATE_SORTED_BY_IS_ORDERED_IF_SOURCE_IS_ORDERED__DIAGNOSTICCHAIN_MAP:
				return validateSortedByIsOrderedIfSourceIsOrdered((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.ITERATOR_EXP___VALIDATE_SORTED_BY_ELEMENT_TYPE_IS_SOURCE_ELEMENT_TYPE__DIAGNOSTICCHAIN_MAP:
				return validateSortedByElementTypeIsSourceElementType((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.ITERATOR_EXP___VALIDATE_ITERATOR_TYPE_IS_SOURCE_ELEMENT_TYPE__DIAGNOSTICCHAIN_MAP:
				return validateIteratorTypeIsSourceElementType((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return eDynamicInvoke(operationID, arguments);
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitIteratorExp(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Element getReferredElement()
	{
		return getReferredIteration();
	}

} //IteratorExpImpl
