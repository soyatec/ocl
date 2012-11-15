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
 * $Id: IterateExpImpl.java,v 1.4 2011/05/19 16:55:39 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.internal.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.ids.PrimitiveTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager;
import org.eclipse.ocl.examples.pivot.Annotation;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ElementExtension;
import org.eclipse.ocl.examples.pivot.IterateExp;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.PivotTables;
import org.eclipse.ocl.examples.pivot.ReferringElement;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.bodies.IterateExpBodies;
import org.eclipse.ocl.examples.pivot.util.PivotValidator;
import org.eclipse.ocl.examples.pivot.util.Visitor;
import org.eclipse.osgi.util.NLS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Iterate Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.IterateExpImpl#getResult <em>Result</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IterateExpImpl extends LoopExpImpl implements IterateExp
{
	/**
	 * The cached value of the '{@link #getResult() <em>Result</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResult()
	 * @generated
	 * @ordered
	 */
	protected Variable result;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IterateExpImpl()
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
		return PivotPackage.Literals.ITERATE_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable getResult()
	{
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResult(Variable newResult, NotificationChain msgs)
	{
		Variable oldResult = result;
		result = newResult;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PivotPackage.ITERATE_EXP__RESULT, oldResult, newResult);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResult(Variable newResult)
	{
		if (newResult != result)
		{
			NotificationChain msgs = null;
			if (result != null)
				msgs = ((InternalEObject)result).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PivotPackage.ITERATE_EXP__RESULT, null, msgs);
			if (newResult != null)
				msgs = ((InternalEObject)newResult).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PivotPackage.ITERATE_EXP__RESULT, null, msgs);
			msgs = basicSetResult(newResult, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.ITERATE_EXP__RESULT, newResult, newResult));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable createResult()
	{
		Variable newResult = (Variable) create(PivotPackage.Literals.VARIABLE);
		setResult(newResult);
		return newResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypeIsResultType(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/*
		type = result.type
		*/
		final @NonNull DomainEvaluator evaluator = new EcoreExecutorManager(this, PivotTables.LIBRARY);
		final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		try {
			final Object result = IterateExpBodies._invariant_TypeIsResultType.INSTANCE.evaluate(evaluator, T_Boolean, this);
			final boolean resultIsNull = ValuesUtil.isNull(result);
			if (!resultIsNull && ValuesUtil.asBoolean(result)) {	// true => true, false/null => dropthrough, invalid => exception
				return true;
			}
			if (diagnostics != null) {
				int severity = resultIsNull ? Diagnostic.ERROR : Diagnostic.WARNING;
				String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IterateExp", "TypeIsResultType", EObjectValidator.getObjectLabel(this, context)});
			    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATE_EXP__TYPE_IS_RESULT_TYPE, message, new Object [] { this }));
			}
		} catch (InvalidValueException e) {
				throw e;
		} catch (Exception e) {
			throw new InvalidValueException(e);
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBodyTypeConformsToResultType(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/*
		body.type.conformsTo(result.type)
		*/
		final @NonNull DomainEvaluator evaluator = new EcoreExecutorManager(this, PivotTables.LIBRARY);
		final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		try {
			final Object result = IterateExpBodies._invariant_BodyTypeConformsToResultType.INSTANCE.evaluate(evaluator, T_Boolean, this);
			final boolean resultIsNull = ValuesUtil.isNull(result);
			if (!resultIsNull && ValuesUtil.asBoolean(result)) {	// true => true, false/null => dropthrough, invalid => exception
				return true;
			}
			if (diagnostics != null) {
				int severity = resultIsNull ? Diagnostic.ERROR : Diagnostic.WARNING;
				String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IterateExp", "BodyTypeConformsToResultType", EObjectValidator.getObjectLabel(this, context)});
			    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATE_EXP__BODY_TYPE_CONFORMS_TO_RESULT_TYPE, message, new Object [] { this }));
			}
		} catch (InvalidValueException e) {
				throw e;
		} catch (Exception e) {
			throw new InvalidValueException(e);
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOneInitializer(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/*
		self.result.initExpression->size() = 1
		*/
		final @NonNull DomainEvaluator evaluator = new EcoreExecutorManager(this, PivotTables.LIBRARY);
		final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		try {
			final Object result = IterateExpBodies._invariant_OneInitializer.INSTANCE.evaluate(evaluator, T_Boolean, this);
			final boolean resultIsNull = ValuesUtil.isNull(result);
			if (!resultIsNull && ValuesUtil.asBoolean(result)) {	// true => true, false/null => dropthrough, invalid => exception
				return true;
			}
			if (diagnostics != null) {
				int severity = resultIsNull ? Diagnostic.ERROR : Diagnostic.WARNING;
				String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"IterateExp", "OneInitializer", EObjectValidator.getObjectLabel(this, context)});
			    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.ITERATE_EXP__ONE_INITIALIZER, message, new Object [] { this }));
			}
		} catch (InvalidValueException e) {
				throw e;
		} catch (Exception e) {
			throw new InvalidValueException(e);
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case PivotPackage.ITERATE_EXP__OWNED_COMMENT:
				return ((InternalEList<?>)getOwnedComment()).basicRemove(otherEnd, msgs);
			case PivotPackage.ITERATE_EXP__EXTENSION:
				return ((InternalEList<?>)getExtension()).basicRemove(otherEnd, msgs);
			case PivotPackage.ITERATE_EXP__OWNED_RULE:
				return ((InternalEList<?>)getOwnedRule()).basicRemove(otherEnd, msgs);
			case PivotPackage.ITERATE_EXP__OWNED_ANNOTATION:
				return ((InternalEList<?>)getOwnedAnnotation()).basicRemove(otherEnd, msgs);
			case PivotPackage.ITERATE_EXP__SOURCE:
				return basicSetSource(null, msgs);
			case PivotPackage.ITERATE_EXP__BODY:
				return basicSetBody(null, msgs);
			case PivotPackage.ITERATE_EXP__ITERATOR:
				return ((InternalEList<?>)getIterator()).basicRemove(otherEnd, msgs);
			case PivotPackage.ITERATE_EXP__RESULT:
				return basicSetResult(null, msgs);
		}
		return eDynamicInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case PivotPackage.ITERATE_EXP__OWNED_COMMENT:
				return getOwnedComment();
			case PivotPackage.ITERATE_EXP__EXTENSION:
				return getExtension();
			case PivotPackage.ITERATE_EXP__NAME:
				return getName();
			case PivotPackage.ITERATE_EXP__OWNED_RULE:
				return getOwnedRule();
			case PivotPackage.ITERATE_EXP__IS_STATIC:
				return isStatic();
			case PivotPackage.ITERATE_EXP__OWNED_ANNOTATION:
				return getOwnedAnnotation();
			case PivotPackage.ITERATE_EXP__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case PivotPackage.ITERATE_EXP__SOURCE:
				return getSource();
			case PivotPackage.ITERATE_EXP__IMPLICIT:
				return isImplicit();
			case PivotPackage.ITERATE_EXP__BODY:
				return getBody();
			case PivotPackage.ITERATE_EXP__ITERATOR:
				return getIterator();
			case PivotPackage.ITERATE_EXP__REFERRED_ITERATION:
				if (resolve) return getReferredIteration();
				return basicGetReferredIteration();
			case PivotPackage.ITERATE_EXP__RESULT:
				return getResult();
		}
		return eDynamicGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case PivotPackage.ITERATE_EXP__OWNED_COMMENT:
				getOwnedComment().clear();
				getOwnedComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.ITERATE_EXP__EXTENSION:
				getExtension().clear();
				getExtension().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.ITERATE_EXP__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.ITERATE_EXP__OWNED_RULE:
				getOwnedRule().clear();
				getOwnedRule().addAll((Collection<? extends Constraint>)newValue);
				return;
			case PivotPackage.ITERATE_EXP__IS_STATIC:
				setIsStatic((Boolean)newValue);
				return;
			case PivotPackage.ITERATE_EXP__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				getOwnedAnnotation().addAll((Collection<? extends Annotation>)newValue);
				return;
			case PivotPackage.ITERATE_EXP__TYPE:
				setType((Type)newValue);
				return;
			case PivotPackage.ITERATE_EXP__SOURCE:
				setSource((OCLExpression)newValue);
				return;
			case PivotPackage.ITERATE_EXP__IMPLICIT:
				setImplicit((Boolean)newValue);
				return;
			case PivotPackage.ITERATE_EXP__BODY:
				setBody((OCLExpression)newValue);
				return;
			case PivotPackage.ITERATE_EXP__ITERATOR:
				getIterator().clear();
				getIterator().addAll((Collection<? extends Variable>)newValue);
				return;
			case PivotPackage.ITERATE_EXP__REFERRED_ITERATION:
				setReferredIteration((Iteration)newValue);
				return;
			case PivotPackage.ITERATE_EXP__RESULT:
				setResult((Variable)newValue);
				return;
		}
		eDynamicSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case PivotPackage.ITERATE_EXP__OWNED_COMMENT:
				getOwnedComment().clear();
				return;
			case PivotPackage.ITERATE_EXP__EXTENSION:
				getExtension().clear();
				return;
			case PivotPackage.ITERATE_EXP__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.ITERATE_EXP__OWNED_RULE:
				getOwnedRule().clear();
				return;
			case PivotPackage.ITERATE_EXP__IS_STATIC:
				setIsStatic(IS_STATIC_EDEFAULT);
				return;
			case PivotPackage.ITERATE_EXP__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				return;
			case PivotPackage.ITERATE_EXP__TYPE:
				setType((Type)null);
				return;
			case PivotPackage.ITERATE_EXP__SOURCE:
				setSource((OCLExpression)null);
				return;
			case PivotPackage.ITERATE_EXP__IMPLICIT:
				setImplicit(IMPLICIT_EDEFAULT);
				return;
			case PivotPackage.ITERATE_EXP__BODY:
				setBody((OCLExpression)null);
				return;
			case PivotPackage.ITERATE_EXP__ITERATOR:
				getIterator().clear();
				return;
			case PivotPackage.ITERATE_EXP__REFERRED_ITERATION:
				setReferredIteration((Iteration)null);
				return;
			case PivotPackage.ITERATE_EXP__RESULT:
				setResult((Variable)null);
				return;
		}
		eDynamicUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case PivotPackage.ITERATE_EXP__OWNED_COMMENT:
				return ownedComment != null && !ownedComment.isEmpty();
			case PivotPackage.ITERATE_EXP__EXTENSION:
				return extension != null && !extension.isEmpty();
			case PivotPackage.ITERATE_EXP__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.ITERATE_EXP__OWNED_RULE:
				return ownedRule != null && !ownedRule.isEmpty();
			case PivotPackage.ITERATE_EXP__IS_STATIC:
				return ((eFlags & IS_STATIC_EFLAG) != 0) != IS_STATIC_EDEFAULT;
			case PivotPackage.ITERATE_EXP__OWNED_ANNOTATION:
				return ownedAnnotation != null && !ownedAnnotation.isEmpty();
			case PivotPackage.ITERATE_EXP__TYPE:
				return type != null;
			case PivotPackage.ITERATE_EXP__SOURCE:
				return source != null;
			case PivotPackage.ITERATE_EXP__IMPLICIT:
				return ((eFlags & IMPLICIT_EFLAG) != 0) != IMPLICIT_EDEFAULT;
			case PivotPackage.ITERATE_EXP__BODY:
				return body != null;
			case PivotPackage.ITERATE_EXP__ITERATOR:
				return iterator != null && !iterator.isEmpty();
			case PivotPackage.ITERATE_EXP__REFERRED_ITERATION:
				return referredIteration != null;
			case PivotPackage.ITERATE_EXP__RESULT:
				return result != null;
		}
		return eDynamicIsSet(featureID);
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
				case PivotPackage.REFERRING_ELEMENT___GET_REFERRED_ELEMENT: return PivotPackage.ITERATE_EXP___GET_REFERRED_ELEMENT;
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
			case PivotPackage.ITERATE_EXP___ALL_OWNED_ELEMENTS:
				return allOwnedElements();
			case PivotPackage.ITERATE_EXP___GET_VALUE__TYPE_STRING:
				return getValue((Type)arguments.get(0), (String)arguments.get(1));
			case PivotPackage.ITERATE_EXP___VALIDATE_NOT_OWN_SELF__DIAGNOSTICCHAIN_MAP:
				return validateNotOwnSelf((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.ITERATE_EXP___VALIDATE_SOURCE_IS_COLLECTION__DIAGNOSTICCHAIN_MAP:
				return validateSourceIsCollection((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.ITERATE_EXP___VALIDATE_NO_INITIALIZERS__DIAGNOSTICCHAIN_MAP:
				return validateNoInitializers((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.ITERATE_EXP___GET_REFERRED_ELEMENT:
				return getReferredElement();
			case PivotPackage.ITERATE_EXP___VALIDATE_TYPE_IS_RESULT_TYPE__DIAGNOSTICCHAIN_MAP:
				return validateTypeIsResultType((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.ITERATE_EXP___VALIDATE_BODY_TYPE_CONFORMS_TO_RESULT_TYPE__DIAGNOSTICCHAIN_MAP:
				return validateBodyTypeConformsToResultType((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.ITERATE_EXP___VALIDATE_ONE_INITIALIZER__DIAGNOSTICCHAIN_MAP:
				return validateOneInitializer((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return eDynamicInvoke(operationID, arguments);
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitIterateExp(this);
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

} //IterateExpImpl
