/**
 * <copyright>
 * 
 * Copyright (c) 2013 CEA LIST and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink(CEA LIST) - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.ocl.examples.codegen.cgmodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.cgmodel.CGCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.util.CGModelVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CG Call Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGCallExpImpl#isInvalidating <em>Invalidating</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGCallExpImpl#isValidating <em>Validating</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class CGCallExpImpl extends CGComputedExpImpl implements CGCallExp {
	/**
	 * The default value of the '{@link #isInvalidating() <em>Invalidating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInvalidating()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INVALIDATING_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isInvalidating() <em>Invalidating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInvalidating()
	 * @generated
	 * @ordered
	 */
	protected boolean invalidating = INVALIDATING_EDEFAULT;
	/**
	 * The default value of the '{@link #isValidating() <em>Validating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isValidating()
	 * @generated
	 * @ordered
	 */
	protected static final boolean VALIDATING_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isValidating() <em>Validating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isValidating()
	 * @generated
	 * @ordered
	 */
	protected boolean validating = VALIDATING_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CGCallExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CGModelPackage.Literals.CG_CALL_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isInvalidating() {
		return invalidating;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInvalidating(boolean newInvalidating) {
		boolean oldInvalidating = invalidating;
		invalidating = newInvalidating;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CGModelPackage.CG_CALL_EXP__INVALIDATING, oldInvalidating, invalidating));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isValidating() {
		return validating;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValidating(boolean newValidating) {
		boolean oldValidating = validating;
		validating = newValidating;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CGModelPackage.CG_CALL_EXP__VALIDATING, oldValidating, validating));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CGModelPackage.CG_CALL_EXP__INVALIDATING:
				return isInvalidating();
			case CGModelPackage.CG_CALL_EXP__VALIDATING:
				return isValidating();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CGModelPackage.CG_CALL_EXP__INVALIDATING:
				setInvalidating((Boolean)newValue);
				return;
			case CGModelPackage.CG_CALL_EXP__VALIDATING:
				setValidating((Boolean)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case CGModelPackage.CG_CALL_EXP__INVALIDATING:
				setInvalidating(INVALIDATING_EDEFAULT);
				return;
			case CGModelPackage.CG_CALL_EXP__VALIDATING:
				setValidating(VALIDATING_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CGModelPackage.CG_CALL_EXP__INVALIDATING:
				return invalidating != INVALIDATING_EDEFAULT;
			case CGModelPackage.CG_CALL_EXP__VALIDATING:
				return validating != VALIDATING_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public <R> R accept(@NonNull CGModelVisitor<R> visitor) {
		return visitor.visitCGCallExp(this);
	}

	@Override
	public @NonNull CGValuedElement getValue() {
		return this;
	}

	@Override
	public boolean isGlobal() {
		return false;
	}

	@Override
	public String toString() {
		return super.toString();
	}
} //CGCallExpImpl
