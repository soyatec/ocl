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
 * $Id: TypedMultiplicityElementImpl.java,v 1.2 2011/01/24 20:42:33 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.internal.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager;
import org.eclipse.ocl.examples.library.executor.ExecutorType;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.examples.pivot.Annotation;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.ElementExtension;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.PivotTables;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypedMultiplicityElement;
import org.eclipse.ocl.examples.pivot.ValueSpecification;
import org.eclipse.ocl.examples.pivot.bodies.TypedMultiplicityElementBodies;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Typed Multiplicity Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.TypedMultiplicityElementImpl#isRequired <em>Is Required</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class TypedMultiplicityElementImpl
		extends TypedElementImpl
		implements TypedMultiplicityElement {

	/**
	 * The default value of the '{@link #isRequired() <em>Is Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRequired()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_REQUIRED_EDEFAULT = true;

	/**
	 * The flag representing the value of the '{@link #isRequired() <em>Is Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRequired()
	 * @generated
	 * @ordered
	 */
	protected static final int IS_REQUIRED_EFLAG = 1 << 9;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TypedMultiplicityElementImpl() {
		super();
		eFlags |= IS_REQUIRED_EFLAG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.TYPED_MULTIPLICITY_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRequired()
	{
		return (eFlags & IS_REQUIRED_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsRequired(boolean newIsRequired)
	{
		boolean oldIsRequired = (eFlags & IS_REQUIRED_EFLAG) != 0;
		if (newIsRequired) eFlags |= IS_REQUIRED_EFLAG; else eFlags &= ~IS_REQUIRED_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.TYPED_MULTIPLICITY_ELEMENT__IS_REQUIRED, oldIsRequired, newIsRequired));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean CompatibleBody(ValueSpecification bodySpecification)
	{
		/*
		bodySpecification.type.conformsTo(self.type)
		*/
		try {
			final @NonNull DomainEvaluator evaluator = new EcoreExecutorManager(this, PivotTables.LIBRARY);
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull TypeId returnTypeId = T_Boolean.getTypeId();
			final @NonNull Object result = TypedMultiplicityElementBodies._CompatibleBody_body_.INSTANCE.evaluate(evaluator, returnTypeId, this, ValuesUtil.valueOf(bodySpecification));
			return evaluator.asEcoreObject((Boolean)null, result);
		} catch (InvalidValueException e) {
			throw new WrappedException("Failed to evaluate org.eclipse.ocl.examples.pivot.bodies.TypedMultiplicityElementBodies", e);
		}
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter makeParameter()
	{
		/*
		Parameter{name = 'name'}
		*/
		try {
			final @NonNull DomainEvaluator evaluator = new EcoreExecutorManager(this, PivotTables.LIBRARY);
			final @NonNull ExecutorType T_pivot__Parameter = PivotTables.Types._Parameter;
			final @NonNull TypeId returnTypeId = T_pivot__Parameter.getTypeId();
			final @NonNull Object result = TypedMultiplicityElementBodies._makeParameter_body_.INSTANCE.evaluate(evaluator, returnTypeId, this);
			return evaluator.asEcoreObject((Parameter)null, result);
		} catch (InvalidValueException e) {
			throw new WrappedException("Failed to evaluate org.eclipse.ocl.examples.pivot.bodies.TypedMultiplicityElementBodies", e);
		}
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__OWNED_COMMENT:
				return getOwnedComment();
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__EXTENSION:
				return getExtension();
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__NAME:
				return getName();
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__OWNED_RULE:
				return getOwnedRule();
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__IS_STATIC:
				return isStatic();
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__OWNED_ANNOTATION:
				return getOwnedAnnotation();
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__IS_REQUIRED:
				return isRequired();
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
	public void eSet(int featureID, Object newValue) {
		switch (featureID)
		{
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__OWNED_COMMENT:
				getOwnedComment().clear();
				getOwnedComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__EXTENSION:
				getExtension().clear();
				getExtension().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__OWNED_RULE:
				getOwnedRule().clear();
				getOwnedRule().addAll((Collection<? extends Constraint>)newValue);
				return;
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__IS_STATIC:
				setIsStatic((Boolean)newValue);
				return;
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				getOwnedAnnotation().addAll((Collection<? extends Annotation>)newValue);
				return;
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__TYPE:
				setType((Type)newValue);
				return;
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__IS_REQUIRED:
				setIsRequired((Boolean)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID)
		{
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__OWNED_COMMENT:
				getOwnedComment().clear();
				return;
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__EXTENSION:
				getExtension().clear();
				return;
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__OWNED_RULE:
				getOwnedRule().clear();
				return;
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__IS_STATIC:
				setIsStatic(IS_STATIC_EDEFAULT);
				return;
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				return;
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__TYPE:
				setType((Type)null);
				return;
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__IS_REQUIRED:
				setIsRequired(IS_REQUIRED_EDEFAULT);
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
	public boolean eIsSet(int featureID) {
		switch (featureID)
		{
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__OWNED_COMMENT:
				return ownedComment != null && !ownedComment.isEmpty();
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__EXTENSION:
				return extension != null && !extension.isEmpty();
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__OWNED_RULE:
				return ownedRule != null && !ownedRule.isEmpty();
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__IS_STATIC:
				return ((eFlags & IS_STATIC_EFLAG) != 0) != IS_STATIC_EDEFAULT;
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__OWNED_ANNOTATION:
				return ownedAnnotation != null && !ownedAnnotation.isEmpty();
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__TYPE:
				return type != null;
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT__IS_REQUIRED:
				return ((eFlags & IS_REQUIRED_EFLAG) != 0) != IS_REQUIRED_EDEFAULT;
		}
		return eDynamicIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments)
			throws InvocationTargetException {
		switch (operationID)
		{
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT___ALL_OWNED_ELEMENTS:
				return allOwnedElements();
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT___GET_VALUE__TYPE_STRING:
				return getValue((Type)arguments.get(0), (String)arguments.get(1));
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT___VALIDATE_NOT_OWN_SELF__DIAGNOSTICCHAIN_MAP:
				return validateNotOwnSelf((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT___COMPATIBLE_BODY__VALUESPECIFICATION:
				return CompatibleBody((ValueSpecification)arguments.get(0));
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT___MAKE_PARAMETER:
				return makeParameter();
		}
		return eDynamicInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		return super.toString();
	}
} //TypedMultiplicityElementImpl
