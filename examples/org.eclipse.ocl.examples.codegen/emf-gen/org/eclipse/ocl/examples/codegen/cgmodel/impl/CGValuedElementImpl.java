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

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.util.CGModelVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CG Valued Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGValuedElementImpl#isBoxed <em>Boxed</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGValuedElementImpl#isCaught <em>Caught</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGValuedElementImpl#isConstant <em>Constant</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGValuedElementImpl#getDependsOn <em>Depends On</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGValuedElementImpl#isFalse <em>False</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGValuedElementImpl#isGlobal <em>Global</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGValuedElementImpl#isInlineable <em>Inlineable</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGValuedElementImpl#isInvalid <em>Invalid</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGValuedElementImpl#isNull <em>Null</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGValuedElementImpl#isNonInvalid <em>Non Invalid</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGValuedElementImpl#isNonNull <em>Non Null</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGValuedElementImpl#getReferredValuedElement <em>Referred Valued Element</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGValuedElementImpl#isSettable <em>Settable</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGValuedElementImpl#isTrue <em>True</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGValuedElementImpl#isUnboxed <em>Unboxed</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGValuedElementImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGValuedElementImpl#getValueName <em>Value Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class CGValuedElementImpl extends CGTypedElementImpl implements CGValuedElement {
	/**
	 * The default value of the '{@link #isBoxed() <em>Boxed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBoxed()
	 * @generated
	 * @ordered
	 */
	protected static final boolean BOXED_EDEFAULT = false;

	/**
	 * The default value of the '{@link #isCaught() <em>Caught</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCaught()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CAUGHT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCaught() <em>Caught</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCaught()
	 * @generated
	 * @ordered
	 */
	protected boolean caught = CAUGHT_EDEFAULT;

	/**
	 * The default value of the '{@link #isConstant() <em>Constant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isConstant()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CONSTANT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #getDependsOn() <em>Depends On</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependsOn()
	 * @generated
	 * @ordered
	 */
	protected EList<CGValuedElement> dependsOn;

	/**
	 * The default value of the '{@link #isFalse() <em>False</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFalse()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FALSE_EDEFAULT = false;

	/**
	 * The default value of the '{@link #isGlobal() <em>Global</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isGlobal()
	 * @generated
	 * @ordered
	 */
	protected static final boolean GLOBAL_EDEFAULT = false;

	/**
	 * The default value of the '{@link #isInlineable() <em>Inlineable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInlineable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INLINEABLE_EDEFAULT = false;

	/**
	 * The default value of the '{@link #isInvalid() <em>Invalid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInvalid()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INVALID_EDEFAULT = false;

	/**
	 * The default value of the '{@link #isNull() <em>Null</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNull()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NULL_EDEFAULT = false;

	/**
	 * The default value of the '{@link #isNonInvalid() <em>Non Invalid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNonInvalid()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NON_INVALID_EDEFAULT = false;

	/**
	 * The default value of the '{@link #isNonNull() <em>Non Null</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNonNull()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NON_NULL_EDEFAULT = false;

	/**
	 * The default value of the '{@link #isSettable() <em>Settable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSettable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SETTABLE_EDEFAULT = false;

	/**
	 * The default value of the '{@link #isTrue() <em>True</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTrue()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TRUE_EDEFAULT = false;

	/**
	 * The default value of the '{@link #isUnboxed() <em>Unboxed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUnboxed()
	 * @generated
	 * @ordered
	 */
	protected static final boolean UNBOXED_EDEFAULT = false;

	/**
	 * The default value of the '{@link #getValueName() <em>Value Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueName()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValueName() <em>Value Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueName()
	 * @generated
	 * @ordered
	 */
	protected String valueName = VALUE_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CGValuedElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CGModelPackage.Literals.CG_VALUED_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CGModelPackage.CG_VALUED_ELEMENT__BOXED:
				return isBoxed();
			case CGModelPackage.CG_VALUED_ELEMENT__CAUGHT:
				return isCaught();
			case CGModelPackage.CG_VALUED_ELEMENT__CONSTANT:
				return isConstant();
			case CGModelPackage.CG_VALUED_ELEMENT__DEPENDS_ON:
				return getDependsOn();
			case CGModelPackage.CG_VALUED_ELEMENT__FALSE:
				return isFalse();
			case CGModelPackage.CG_VALUED_ELEMENT__GLOBAL:
				return isGlobal();
			case CGModelPackage.CG_VALUED_ELEMENT__INLINEABLE:
				return isInlineable();
			case CGModelPackage.CG_VALUED_ELEMENT__INVALID:
				return isInvalid();
			case CGModelPackage.CG_VALUED_ELEMENT__NULL:
				return isNull();
			case CGModelPackage.CG_VALUED_ELEMENT__NON_INVALID:
				return isNonInvalid();
			case CGModelPackage.CG_VALUED_ELEMENT__NON_NULL:
				return isNonNull();
			case CGModelPackage.CG_VALUED_ELEMENT__REFERRED_VALUED_ELEMENT:
				return getReferredValuedElement();
			case CGModelPackage.CG_VALUED_ELEMENT__SETTABLE:
				return isSettable();
			case CGModelPackage.CG_VALUED_ELEMENT__TRUE:
				return isTrue();
			case CGModelPackage.CG_VALUED_ELEMENT__UNBOXED:
				return isUnboxed();
			case CGModelPackage.CG_VALUED_ELEMENT__VALUE:
				return getValue();
			case CGModelPackage.CG_VALUED_ELEMENT__VALUE_NAME:
				return getValueName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CGModelPackage.CG_VALUED_ELEMENT__CAUGHT:
				setCaught((Boolean)newValue);
				return;
			case CGModelPackage.CG_VALUED_ELEMENT__DEPENDS_ON:
				getDependsOn().clear();
				getDependsOn().addAll((Collection<? extends CGValuedElement>)newValue);
				return;
			case CGModelPackage.CG_VALUED_ELEMENT__VALUE_NAME:
				setValueName((String)newValue);
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
			case CGModelPackage.CG_VALUED_ELEMENT__CAUGHT:
				setCaught(CAUGHT_EDEFAULT);
				return;
			case CGModelPackage.CG_VALUED_ELEMENT__DEPENDS_ON:
				getDependsOn().clear();
				return;
			case CGModelPackage.CG_VALUED_ELEMENT__VALUE_NAME:
				setValueName(VALUE_NAME_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("null")
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CGModelPackage.CG_VALUED_ELEMENT__BOXED:
				return isBoxed() != BOXED_EDEFAULT;
			case CGModelPackage.CG_VALUED_ELEMENT__CAUGHT:
				return caught != CAUGHT_EDEFAULT;
			case CGModelPackage.CG_VALUED_ELEMENT__CONSTANT:
				return isConstant() != CONSTANT_EDEFAULT;
			case CGModelPackage.CG_VALUED_ELEMENT__DEPENDS_ON:
				return dependsOn != null && !dependsOn.isEmpty();
			case CGModelPackage.CG_VALUED_ELEMENT__FALSE:
				return isFalse() != FALSE_EDEFAULT;
			case CGModelPackage.CG_VALUED_ELEMENT__GLOBAL:
				return isGlobal() != GLOBAL_EDEFAULT;
			case CGModelPackage.CG_VALUED_ELEMENT__INLINEABLE:
				return isInlineable() != INLINEABLE_EDEFAULT;
			case CGModelPackage.CG_VALUED_ELEMENT__INVALID:
				return isInvalid() != INVALID_EDEFAULT;
			case CGModelPackage.CG_VALUED_ELEMENT__NULL:
				return isNull() != NULL_EDEFAULT;
			case CGModelPackage.CG_VALUED_ELEMENT__NON_INVALID:
				return isNonInvalid() != NON_INVALID_EDEFAULT;
			case CGModelPackage.CG_VALUED_ELEMENT__NON_NULL:
				return isNonNull() != NON_NULL_EDEFAULT;
			case CGModelPackage.CG_VALUED_ELEMENT__REFERRED_VALUED_ELEMENT:
				return getReferredValuedElement() != null;
			case CGModelPackage.CG_VALUED_ELEMENT__SETTABLE:
				return isSettable() != SETTABLE_EDEFAULT;
			case CGModelPackage.CG_VALUED_ELEMENT__TRUE:
				return isTrue() != TRUE_EDEFAULT;
			case CGModelPackage.CG_VALUED_ELEMENT__UNBOXED:
				return isUnboxed() != UNBOXED_EDEFAULT;
			case CGModelPackage.CG_VALUED_ELEMENT__VALUE:
				return getValue() != null;
			case CGModelPackage.CG_VALUED_ELEMENT__VALUE_NAME:
				return VALUE_NAME_EDEFAULT == null ? valueName != null : !VALUE_NAME_EDEFAULT.equals(valueName);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case CGModelPackage.CG_VALUED_ELEMENT___SET_NON_INVALID:
				setNonInvalid();
				return null;
			case CGModelPackage.CG_VALUED_ELEMENT___SET_NON_NULL:
				setNonNull();
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValueName(String newValueName) {
		String oldValueName = valueName;
		valueName = newValueName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CGModelPackage.CG_VALUED_ELEMENT__VALUE_NAME, oldValueName, valueName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("null")
	public @NonNull List<CGValuedElement> getDependsOn() {
		if (dependsOn == null) {
			dependsOn = new EObjectEList<CGValuedElement>(CGValuedElement.class, this, CGModelPackage.CG_VALUED_ELEMENT__DEPENDS_ON);
		}
		return dependsOn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCaught() {
		return caught;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCaught(boolean newCaught) {
		boolean oldCaught = caught;
		caught = newCaught;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CGModelPackage.CG_VALUED_ELEMENT__CAUGHT, oldCaught, caught));
	}

	@Override
	public <R> R accept(@NonNull CGModelVisitor<R> visitor) {
		return visitor.visitCGValuedElement(this);
	}

	public @NonNull CGValuedElement getReferredValuedElement() {
		return this;
	}

	public @NonNull CGValuedElement getValue() {
		CGValuedElement referredValue = getReferredValuedElement();
		if (referredValue == this) {
			return this;
		}
		else {
			return referredValue.getValue();
		}
	}

	public String getValueName() {
		if (valueName != null) {
			return valueName;
		}
		CGValuedElement value = getValue();
		if (value != this) {
			return value.getValueName();
		}
		return null;
	}

	public boolean isBoxed() {
		CGValuedElement referredValue = getReferredValuedElement();
//		CGValuedElement value = getValue();
		assert referredValue != this;
		return referredValue.isBoxed();
	}

	public boolean isConstant() {
		CGValuedElement referredValue = getReferredValuedElement();
		return (referredValue != this) && referredValue.isConstant();
	}

	public boolean isFalse() {
		CGValuedElement referredValue = getReferredValuedElement();
		return (referredValue != this) && referredValue.isFalse();
	}

	public boolean isGlobal() {
		for (CGValuedElement cgElement : getDependsOn()) {
			if (!cgElement.isGlobal()) {
				return false;
			}
		};
		CGValuedElement referredValue = getReferredValuedElement();
		return (referredValue != this) && referredValue.isGlobal();
	}

	public boolean isInlineable() {
		CGValuedElement referredValue = getReferredValuedElement();
		return (referredValue != this) && referredValue.isInlineable();
	}

	public boolean isInvalid() {
		CGValuedElement referredValue = getReferredValuedElement();
		return (referredValue != this) && referredValue.isInvalid();
	}

	public boolean isNonInvalid() {
		CGValuedElement referredValue = getReferredValuedElement();
		return (referredValue != this) && referredValue.isNonInvalid();
	}

	public boolean isNonNull() {
		CGValuedElement referredValue = getReferredValuedElement();
		return (referredValue != this) && referredValue.isNonNull();
	}

	public boolean isNull() {
		CGValuedElement referredValue = getReferredValuedElement();
		return (referredValue != this) && referredValue.isNull();
	}

	public boolean isSettable() {
		return false;
	}

	public boolean isTrue() {
		CGValuedElement referredValue = getReferredValuedElement();
		return (referredValue != this) && referredValue.isTrue();
	}

	public boolean isUnboxed() {
		CGValuedElement referredValue = getReferredValuedElement();
//		CGValuedElement value = getValue();
		assert referredValue != this;
		return referredValue.isUnboxed();
	}

	public void setNonInvalid() {
		throw new UnsupportedOperationException();
	}

	public void setNonNull() {
		throw new UnsupportedOperationException();
	}

	@Override
	public String toString() {
		return super.toString();
	}
} //CGValuedElementImpl
