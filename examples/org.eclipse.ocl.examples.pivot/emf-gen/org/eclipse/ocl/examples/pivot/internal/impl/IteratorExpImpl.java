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
import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainInheritance;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.PrimitiveTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.LibraryFeature;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.validation.ValidationWarning;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.library.LibraryConstants;
import org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager;
import org.eclipse.ocl.examples.library.iterator.ClosureIteration;
import org.eclipse.ocl.examples.library.iterator.SortedByIteration;
import org.eclipse.ocl.examples.library.oclany.OclComparableCompareToOperation;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.IteratorExp;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.PivotTables;
import org.eclipse.ocl.examples.pivot.ReferringElement;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.bodies.IteratorExpBodies;
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
	public boolean validateAnyHasOneIterator(DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		/*
		name = 'any' implies iterator->size() = 1
		*/
		final @NonNull DomainEvaluator evaluator = new EcoreExecutorManager(this, PivotTables.LIBRARY);
		final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		
		final Object result = IteratorExpBodies._invariant_AnyHasOneIterator.INSTANCE.evaluate(evaluator, T_Boolean, this);
		final boolean resultIsNull = ValuesUtil.isNull(result);
		if (!resultIsNull && ValuesUtil.asBoolean(result)) {	// true => true, false/null => dropthrough, invalid => exception
			return true;
		}
		if (diagnostics != null) {
			int severity = resultIsNull ? Diagnostic.ERROR : Diagnostic.WARNING;
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
	public boolean validateAnyTypeIsSourceElementType(DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		/*
		name = 'any' implies type = source.type.oclAsType(CollectionType).elementType
		*/
		final @NonNull DomainEvaluator evaluator = new EcoreExecutorManager(this, PivotTables.LIBRARY);
		final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		
		final Object result = IteratorExpBodies._invariant_AnyTypeIsSourceElementType.INSTANCE.evaluate(evaluator, T_Boolean, this);
		final boolean resultIsNull = ValuesUtil.isNull(result);
		if (!resultIsNull && ValuesUtil.asBoolean(result)) {	// true => true, false/null => dropthrough, invalid => exception
			return true;
		}
		if (diagnostics != null) {
			int severity = resultIsNull ? Diagnostic.ERROR : Diagnostic.WARNING;
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
	public boolean validateAnyBodyTypeIsBoolean(DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		/*
		name = 'any' implies body.type = 'Boolean'
		*/
		final @NonNull DomainEvaluator evaluator = new EcoreExecutorManager(this, PivotTables.LIBRARY);
		final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		
		final Object result = IteratorExpBodies._invariant_AnyBodyTypeIsBoolean.INSTANCE.evaluate(evaluator, T_Boolean, this);
		final boolean resultIsNull = ValuesUtil.isNull(result);
		if (!resultIsNull && ValuesUtil.asBoolean(result)) {	// true => true, false/null => dropthrough, invalid => exception
			return true;
		}
		if (diagnostics != null) {
			int severity = resultIsNull ? Diagnostic.ERROR : Diagnostic.WARNING;
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
	public boolean validateClosureHasOneIterator(DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		/*
		name = 'closure' implies iterator->size() = 1
		*/
		final @NonNull DomainEvaluator evaluator = new EcoreExecutorManager(this, PivotTables.LIBRARY);
		final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		
		final Object result = IteratorExpBodies._invariant_ClosureHasOneIterator.INSTANCE.evaluate(evaluator, T_Boolean, this);
		final boolean resultIsNull = ValuesUtil.isNull(result);
		if (!resultIsNull && ValuesUtil.asBoolean(result)) {	// true => true, false/null => dropthrough, invalid => exception
			return true;
		}
		if (diagnostics != null) {
			int severity = resultIsNull ? Diagnostic.ERROR : Diagnostic.WARNING;
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
	public boolean validateClosureTypeIsUniqueCollection(DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		/*
		name = 'closure' implies
		if
		  source.type.oclIsKindOf(SequenceType) or
		  source.type.oclIsKindOf(OrderedSetType)
		then type.oclIsKindOf(OrderedSetType)
		else type.oclIsKindOf(SetType)
		endif
		*/
		final @NonNull DomainEvaluator evaluator = new EcoreExecutorManager(this, PivotTables.LIBRARY);
		final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		
		final Object result = IteratorExpBodies._invariant_ClosureTypeIsUniqueCollection.INSTANCE.evaluate(evaluator, T_Boolean, this);
		final boolean resultIsNull = ValuesUtil.isNull(result);
		if (!resultIsNull && ValuesUtil.asBoolean(result)) {	// true => true, false/null => dropthrough, invalid => exception
			return true;
		}
		if (diagnostics != null) {
			int severity = resultIsNull ? Diagnostic.ERROR : Diagnostic.WARNING;
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
	public boolean validateClosureSourceElementTypeIsBodyElementType(DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		/*
		name = 'closure' implies
		source.type.oclAsType(CollectionType).elementType =
		if body.type.oclIsKindOf(CollectionType)
		then body.type.oclAsType(CollectionType).elementType
		else body.type
		endif
		*/
		final @NonNull DomainEvaluator evaluator = new EcoreExecutorManager(this, PivotTables.LIBRARY);
		final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		
		final Object result = IteratorExpBodies._invariant_ClosureSourceElementTypeIsBodyElementType.INSTANCE.evaluate(evaluator, T_Boolean, this);
		final boolean resultIsNull = ValuesUtil.isNull(result);
		if (!resultIsNull && ValuesUtil.asBoolean(result)) {	// true => true, false/null => dropthrough, invalid => exception
			return true;
		}
		if (diagnostics != null) {
			int severity = resultIsNull ? Diagnostic.ERROR : Diagnostic.WARNING;
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
	public boolean validateClosureElementTypeIsSourceElementType(DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		/*
		name = 'closure' implies
		type.oclAsType(CollectionType).elementType =
		source.type.oclAsType(CollectionType).elementType
		*/
		final @NonNull DomainEvaluator evaluator = new EcoreExecutorManager(this, PivotTables.LIBRARY);
		final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		
		final Object result = IteratorExpBodies._invariant_ClosureElementTypeIsSourceElementType.INSTANCE.evaluate(evaluator, T_Boolean, this);
		final boolean resultIsNull = ValuesUtil.isNull(result);
		if (!resultIsNull && ValuesUtil.asBoolean(result)) {	// true => true, false/null => dropthrough, invalid => exception
			return true;
		}
		if (diagnostics != null) {
			int severity = resultIsNull ? Diagnostic.ERROR : Diagnostic.WARNING;
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
	public boolean validateCollectHasOneIterator(DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		/*
		name = 'collect' implies iterator->size() = 1
		*/
		final @NonNull DomainEvaluator evaluator = new EcoreExecutorManager(this, PivotTables.LIBRARY);
		final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		
		final Object result = IteratorExpBodies._invariant_CollectHasOneIterator.INSTANCE.evaluate(evaluator, T_Boolean, this);
		final boolean resultIsNull = ValuesUtil.isNull(result);
		if (!resultIsNull && ValuesUtil.asBoolean(result)) {	// true => true, false/null => dropthrough, invalid => exception
			return true;
		}
		if (diagnostics != null) {
			int severity = resultIsNull ? Diagnostic.ERROR : Diagnostic.WARNING;
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
	public boolean validateCollectTypeIsUnordered(DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		/*
		name = 'collect' implies
		if
		  source.type.oclIsKindOf(SequenceType) or
		  source.type.oclIsKindOf(OrderedSetType)
		then type.oclIsKindOf(SequenceType)
		else type.oclIsKindOf(BagType)
		endif
		*/
		final @NonNull DomainEvaluator evaluator = new EcoreExecutorManager(this, PivotTables.LIBRARY);
		final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		
		final Object result = IteratorExpBodies._invariant_CollectTypeIsUnordered.INSTANCE.evaluate(evaluator, T_Boolean, this);
		final boolean resultIsNull = ValuesUtil.isNull(result);
		if (!resultIsNull && ValuesUtil.asBoolean(result)) {	// true => true, false/null => dropthrough, invalid => exception
			return true;
		}
		if (diagnostics != null) {
			int severity = resultIsNull ? Diagnostic.ERROR : Diagnostic.WARNING;
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
	public boolean validateCollectElementTypeIsSourceElementType(DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		/*
		name = 'collect' implies
		type.oclAsType(CollectionType).elementType =
		body.type.oclAsType(CollectionType).elementType
		*/
		final @NonNull DomainEvaluator evaluator = new EcoreExecutorManager(this, PivotTables.LIBRARY);
		final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		
		final Object result = IteratorExpBodies._invariant_CollectElementTypeIsSourceElementType.INSTANCE.evaluate(evaluator, T_Boolean, this);
		final boolean resultIsNull = ValuesUtil.isNull(result);
		if (!resultIsNull && ValuesUtil.asBoolean(result)) {	// true => true, false/null => dropthrough, invalid => exception
			return true;
		}
		if (diagnostics != null) {
			int severity = resultIsNull ? Diagnostic.ERROR : Diagnostic.WARNING;
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
	public boolean validateCollectNestedHasOneIterator(DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		/*
		name = 'collectNested' implies iterator->size() = 1
		*/
		final @NonNull DomainEvaluator evaluator = new EcoreExecutorManager(this, PivotTables.LIBRARY);
		final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		
		final Object result = IteratorExpBodies._invariant_CollectNestedHasOneIterator.INSTANCE.evaluate(evaluator, T_Boolean, this);
		final boolean resultIsNull = ValuesUtil.isNull(result);
		if (!resultIsNull && ValuesUtil.asBoolean(result)) {	// true => true, false/null => dropthrough, invalid => exception
			return true;
		}
		if (diagnostics != null) {
			int severity = resultIsNull ? Diagnostic.ERROR : Diagnostic.WARNING;
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
	public boolean validateCollectNestedTypeIsBag(DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		/*
		name = 'collectNested' implies type.oclIsKindOf(BagType)
		*/
		final @NonNull DomainEvaluator evaluator = new EcoreExecutorManager(this, PivotTables.LIBRARY);
		final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		
		final Object result = IteratorExpBodies._invariant_CollectNestedTypeIsBag.INSTANCE.evaluate(evaluator, T_Boolean, this);
		final boolean resultIsNull = ValuesUtil.isNull(result);
		if (!resultIsNull && ValuesUtil.asBoolean(result)) {	// true => true, false/null => dropthrough, invalid => exception
			return true;
		}
		if (diagnostics != null) {
			int severity = resultIsNull ? Diagnostic.ERROR : Diagnostic.WARNING;
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
	public boolean validateCollectNestedTypeIsBodyType(DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		/*
		name = 'collectNested' implies type = body.type
		*/
		final @NonNull DomainEvaluator evaluator = new EcoreExecutorManager(this, PivotTables.LIBRARY);
		final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		
		final Object result = IteratorExpBodies._invariant_CollectNestedTypeIsBodyType.INSTANCE.evaluate(evaluator, T_Boolean, this);
		final boolean resultIsNull = ValuesUtil.isNull(result);
		if (!resultIsNull && ValuesUtil.asBoolean(result)) {	// true => true, false/null => dropthrough, invalid => exception
			return true;
		}
		if (diagnostics != null) {
			int severity = resultIsNull ? Diagnostic.ERROR : Diagnostic.WARNING;
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
	public boolean validateExistsTypeIsBoolean(DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		/*
		name = 'exists' implies type = Boolean
		*/
		final @NonNull DomainEvaluator evaluator = new EcoreExecutorManager(this, PivotTables.LIBRARY);
		final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		
		final Object result = IteratorExpBodies._invariant_ExistsTypeIsBoolean.INSTANCE.evaluate(evaluator, T_Boolean, this);
		final boolean resultIsNull = ValuesUtil.isNull(result);
		if (!resultIsNull && ValuesUtil.asBoolean(result)) {	// true => true, false/null => dropthrough, invalid => exception
			return true;
		}
		if (diagnostics != null) {
			int severity = resultIsNull ? Diagnostic.ERROR : Diagnostic.WARNING;
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
	public boolean validateExistsBodyTypeIsBoolean(DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		/*
		name = 'exists' implies body.type = Boolean
		*/
		final @NonNull DomainEvaluator evaluator = new EcoreExecutorManager(this, PivotTables.LIBRARY);
		final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		
		final Object result = IteratorExpBodies._invariant_ExistsBodyTypeIsBoolean.INSTANCE.evaluate(evaluator, T_Boolean, this);
		final boolean resultIsNull = ValuesUtil.isNull(result);
		if (!resultIsNull && ValuesUtil.asBoolean(result)) {	// true => true, false/null => dropthrough, invalid => exception
			return true;
		}
		if (diagnostics != null) {
			int severity = resultIsNull ? Diagnostic.ERROR : Diagnostic.WARNING;
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
	public boolean validateForAllTypeIsBoolean(DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		/*
		name = 'forAll' implies type = Boolean
		*/
		final @NonNull DomainEvaluator evaluator = new EcoreExecutorManager(this, PivotTables.LIBRARY);
		final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		
		final Object result = IteratorExpBodies._invariant_ForAllTypeIsBoolean.INSTANCE.evaluate(evaluator, T_Boolean, this);
		final boolean resultIsNull = ValuesUtil.isNull(result);
		if (!resultIsNull && ValuesUtil.asBoolean(result)) {	// true => true, false/null => dropthrough, invalid => exception
			return true;
		}
		if (diagnostics != null) {
			int severity = resultIsNull ? Diagnostic.ERROR : Diagnostic.WARNING;
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
	public boolean validateForAllBodyTypeIsBoolean(DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		/*
		name = 'forAll' implies body.type = Boolean
		*/
		final @NonNull DomainEvaluator evaluator = new EcoreExecutorManager(this, PivotTables.LIBRARY);
		final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		
		final Object result = IteratorExpBodies._invariant_ForAllBodyTypeIsBoolean.INSTANCE.evaluate(evaluator, T_Boolean, this);
		final boolean resultIsNull = ValuesUtil.isNull(result);
		if (!resultIsNull && ValuesUtil.asBoolean(result)) {	// true => true, false/null => dropthrough, invalid => exception
			return true;
		}
		if (diagnostics != null) {
			int severity = resultIsNull ? Diagnostic.ERROR : Diagnostic.WARNING;
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
	public boolean validateIsUniqueHasOneIterator(DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		/*
		name = 'isUnique' implies iterator->size() = 1
		*/
		final @NonNull DomainEvaluator evaluator = new EcoreExecutorManager(this, PivotTables.LIBRARY);
		final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		
		final Object result = IteratorExpBodies._invariant_IsUniqueHasOneIterator.INSTANCE.evaluate(evaluator, T_Boolean, this);
		final boolean resultIsNull = ValuesUtil.isNull(result);
		if (!resultIsNull && ValuesUtil.asBoolean(result)) {	// true => true, false/null => dropthrough, invalid => exception
			return true;
		}
		if (diagnostics != null) {
			int severity = resultIsNull ? Diagnostic.ERROR : Diagnostic.WARNING;
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
	public boolean validateIsUniqueTypeIsBoolean(DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		/*
		name = 'isUnique' implies type = Boolean
		*/
		final @NonNull DomainEvaluator evaluator = new EcoreExecutorManager(this, PivotTables.LIBRARY);
		final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		
		final Object result = IteratorExpBodies._invariant_IsUniqueTypeIsBoolean.INSTANCE.evaluate(evaluator, T_Boolean, this);
		final boolean resultIsNull = ValuesUtil.isNull(result);
		if (!resultIsNull && ValuesUtil.asBoolean(result)) {	// true => true, false/null => dropthrough, invalid => exception
			return true;
		}
		if (diagnostics != null) {
			int severity = resultIsNull ? Diagnostic.ERROR : Diagnostic.WARNING;
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
	public boolean validateOneHasOneIterator(DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		/*
		name = 'one' implies iterator->size() = 1
		*/
		final @NonNull DomainEvaluator evaluator = new EcoreExecutorManager(this, PivotTables.LIBRARY);
		final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		
		final Object result = IteratorExpBodies._invariant_OneHasOneIterator.INSTANCE.evaluate(evaluator, T_Boolean, this);
		final boolean resultIsNull = ValuesUtil.isNull(result);
		if (!resultIsNull && ValuesUtil.asBoolean(result)) {	// true => true, false/null => dropthrough, invalid => exception
			return true;
		}
		if (diagnostics != null) {
			int severity = resultIsNull ? Diagnostic.ERROR : Diagnostic.WARNING;
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
	public boolean validateOneTypeIsBoolean(DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		/*
		name = 'one' implies type = Boolean
		*/
		final @NonNull DomainEvaluator evaluator = new EcoreExecutorManager(this, PivotTables.LIBRARY);
		final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		
		final Object result = IteratorExpBodies._invariant_OneTypeIsBoolean.INSTANCE.evaluate(evaluator, T_Boolean, this);
		final boolean resultIsNull = ValuesUtil.isNull(result);
		if (!resultIsNull && ValuesUtil.asBoolean(result)) {	// true => true, false/null => dropthrough, invalid => exception
			return true;
		}
		if (diagnostics != null) {
			int severity = resultIsNull ? Diagnostic.ERROR : Diagnostic.WARNING;
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
	public boolean validateOneBodyTypeIsBoolean(DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		/*
		name = 'one' implies body.type = Boolean
		*/
		final @NonNull DomainEvaluator evaluator = new EcoreExecutorManager(this, PivotTables.LIBRARY);
		final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		
		final Object result = IteratorExpBodies._invariant_OneBodyTypeIsBoolean.INSTANCE.evaluate(evaluator, T_Boolean, this);
		final boolean resultIsNull = ValuesUtil.isNull(result);
		if (!resultIsNull && ValuesUtil.asBoolean(result)) {	// true => true, false/null => dropthrough, invalid => exception
			return true;
		}
		if (diagnostics != null) {
			int severity = resultIsNull ? Diagnostic.ERROR : Diagnostic.WARNING;
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
	public boolean validateRejectOrSelectHasOneIterator(DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		/*
		name = 'reject' or name = 'select' implies iterator->size() = 1
		*/
		final @NonNull DomainEvaluator evaluator = new EcoreExecutorManager(this, PivotTables.LIBRARY);
		final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		
		final Object result = IteratorExpBodies._invariant_RejectOrSelectHasOneIterator.INSTANCE.evaluate(evaluator, T_Boolean, this);
		final boolean resultIsNull = ValuesUtil.isNull(result);
		if (!resultIsNull && ValuesUtil.asBoolean(result)) {	// true => true, false/null => dropthrough, invalid => exception
			return true;
		}
		if (diagnostics != null) {
			int severity = resultIsNull ? Diagnostic.ERROR : Diagnostic.WARNING;
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
	public boolean validateRejectOrSelectTypeIsSourceType(DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		/*
		name = 'reject' or name = 'select' implies type = source.type
		*/
		final @NonNull DomainEvaluator evaluator = new EcoreExecutorManager(this, PivotTables.LIBRARY);
		final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		
		final Object result = IteratorExpBodies._invariant_RejectOrSelectTypeIsSourceType.INSTANCE.evaluate(evaluator, T_Boolean, this);
		final boolean resultIsNull = ValuesUtil.isNull(result);
		if (!resultIsNull && ValuesUtil.asBoolean(result)) {	// true => true, false/null => dropthrough, invalid => exception
			return true;
		}
		if (diagnostics != null) {
			int severity = resultIsNull ? Diagnostic.ERROR : Diagnostic.WARNING;
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
	public boolean validateRejectOrSelectTypeIsBoolean(DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		/*
		name = 'reject' or name = 'select' implies type = Boolean
		*/
		final @NonNull DomainEvaluator evaluator = new EcoreExecutorManager(this, PivotTables.LIBRARY);
		final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		
		final Object result = IteratorExpBodies._invariant_RejectOrSelectTypeIsBoolean.INSTANCE.evaluate(evaluator, T_Boolean, this);
		final boolean resultIsNull = ValuesUtil.isNull(result);
		if (!resultIsNull && ValuesUtil.asBoolean(result)) {	// true => true, false/null => dropthrough, invalid => exception
			return true;
		}
		if (diagnostics != null) {
			int severity = resultIsNull ? Diagnostic.ERROR : Diagnostic.WARNING;
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
	public boolean validateSortedByHasOneIterator(DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		/*
		name = 'sortedBy' implies iterator->size() = 1
		*/
		final @NonNull DomainEvaluator evaluator = new EcoreExecutorManager(this, PivotTables.LIBRARY);
		final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		
		final Object result = IteratorExpBodies._invariant_SortedByHasOneIterator.INSTANCE.evaluate(evaluator, T_Boolean, this);
		final boolean resultIsNull = ValuesUtil.isNull(result);
		if (!resultIsNull && ValuesUtil.asBoolean(result)) {	// true => true, false/null => dropthrough, invalid => exception
			return true;
		}
		if (diagnostics != null) {
			int severity = resultIsNull ? Diagnostic.ERROR : Diagnostic.WARNING;
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
	public boolean validateSortedByIsOrderedIfSourceIsOrdered(DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		/*
		name = 'sortedBy' implies
		if
		  source.type.oclIsKindOf(SequenceType) or
		  source.type.oclIsKindOf(BagType)
		then type.oclIsKindOf(SequenceType)
		else type.oclIsKindOf(OrderedSetType)
		endif
		*/
		final @NonNull DomainEvaluator evaluator = new EcoreExecutorManager(this, PivotTables.LIBRARY);
		final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		
		final Object result = IteratorExpBodies._invariant_SortedByIsOrderedIfSourceIsOrdered.INSTANCE.evaluate(evaluator, T_Boolean, this);
		final boolean resultIsNull = ValuesUtil.isNull(result);
		if (!resultIsNull && ValuesUtil.asBoolean(result)) {	// true => true, false/null => dropthrough, invalid => exception
			return true;
		}
		if (diagnostics != null) {
			int severity = resultIsNull ? Diagnostic.ERROR : Diagnostic.WARNING;
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
	public boolean validateSortedByElementTypeIsSourceElementType(DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		/*
		name = 'sortedBy' implies
		type.oclAsType(CollectionType).elementType =
		body.type.oclAsType(CollectionType).elementType
		*/
		final @NonNull DomainEvaluator evaluator = new EcoreExecutorManager(this, PivotTables.LIBRARY);
		final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		
		final Object result = IteratorExpBodies._invariant_SortedByElementTypeIsSourceElementType.INSTANCE.evaluate(evaluator, T_Boolean, this);
		final boolean resultIsNull = ValuesUtil.isNull(result);
		if (!resultIsNull && ValuesUtil.asBoolean(result)) {	// true => true, false/null => dropthrough, invalid => exception
			return true;
		}
		if (diagnostics != null) {
			int severity = resultIsNull ? Diagnostic.ERROR : Diagnostic.WARNING;
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
	public boolean validateIteratorTypeIsSourceElementType(DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		/*
		self.iterator->forAll(type =
		  source.type.oclAsType(CollectionType).elementType)
		*/
		final @NonNull DomainEvaluator evaluator = new EcoreExecutorManager(this, PivotTables.LIBRARY);
		final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		
		final Object result = IteratorExpBodies._invariant_IteratorTypeIsSourceElementType.INSTANCE.evaluate(evaluator, T_Boolean, this);
		final boolean resultIsNull = ValuesUtil.isNull(result);
		if (!resultIsNull && ValuesUtil.asBoolean(result)) {	// true => true, false/null => dropthrough, invalid => exception
			return true;
		}
		if (diagnostics != null) {
			int severity = resultIsNull ? Diagnostic.ERROR : Diagnostic.WARNING;
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
