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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.cgmodel.CGConstant;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.util.CGModelVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CG Global Constant</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGConstantImpl#getConstantValue <em>Constant Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class CGConstantImpl extends CGValuedElementImpl implements CGConstant {
	/**
	 * The default value of the '{@link #getConstantValue() <em>Constant Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstantValue()
	 * @generated
	 * @ordered
	 */
	protected static final Object CONSTANT_VALUE_EDEFAULT = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CGConstantImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CGModelPackage.Literals.CG_CONSTANT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getConstantValue() {
		// TODO: implement this method to return the 'Constant Value' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CGModelPackage.CG_CONSTANT__CONSTANT_VALUE:
				return getConstantValue();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CGModelPackage.CG_CONSTANT__CONSTANT_VALUE:
				return CONSTANT_VALUE_EDEFAULT == null ? getConstantValue() != null : !CONSTANT_VALUE_EDEFAULT.equals(getConstantValue());
		}
		return super.eIsSet(featureID);
	}

	@Override
	public <R> R accept(@NonNull CGModelVisitor<R> visitor) {
		return visitor.visitCGConstant(this);
	}

	@Override
	public final @NonNull CGValuedElement getReferredValuedElement() {
		return this;
	}

	@Override
	public final @NonNull CGValuedElement getValue() {
		return this;
	}

	@Override
	public boolean isBoxed() {
		return true;
	}

	@Override
	public final boolean isConstant() {
		return true;
	}

	@Override
	public boolean isFalse() {
		return false;
	}

	@Override
	public boolean isGlobal() {
		return true;
	}

	@Override
	public boolean isInlineable() {
		return false;
	}

	@Override
	public boolean isInvalid() {
		return false;
	}

	@Override
	public final boolean isNonInvalid() {
		return !isInvalid();
	}

	@Override
	public final boolean isNonNull() {
		return !isNull();
	}

	@Override
	public boolean isNull() {
		return false;
	}

	@Override
	public boolean isTrue() {
		return false;
	}

	@Override
	public boolean isUnboxed() {
		return true;
	}
} //CGGlobalConstantImpl
