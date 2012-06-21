/**
 * <copyright>
 * 
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.ocl.examples.pivot.internal.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.examples.pivot.AppliedStereotype;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.StereotypedProperty;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Applied Stereotype</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.AppliedStereotypeImpl#getReferredType <em>Referred Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.AppliedStereotypeImpl#getStereotypedProperty <em>Stereotyped Property</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AppliedStereotypeImpl extends ElementImpl implements AppliedStereotype
{
	/**
	 * The cached value of the '{@link #getReferredType() <em>Referred Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredType()
	 * @generated
	 * @ordered
	 */
	protected Type referredType;

	/**
	 * The cached value of the '{@link #getStereotypedProperty() <em>Stereotyped Property</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStereotypedProperty()
	 * @generated
	 * @ordered
	 */
	protected EList<StereotypedProperty> stereotypedProperty;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AppliedStereotypeImpl()
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
		return PivotPackage.Literals.APPLIED_STEREOTYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type getReferredType()
	{
		if (referredType != null && ((EObject)referredType).eIsProxy())
		{
			InternalEObject oldReferredType = (InternalEObject)referredType;
			referredType = (Type)eResolveProxy(oldReferredType);
			if (referredType != oldReferredType)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PivotPackage.APPLIED_STEREOTYPE__REFERRED_TYPE, oldReferredType, referredType));
			}
		}
		return referredType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type basicGetReferredType()
	{
		return referredType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferredType(Type newReferredType)
	{
		Type oldReferredType = referredType;
		referredType = newReferredType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.APPLIED_STEREOTYPE__REFERRED_TYPE, oldReferredType, referredType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StereotypedProperty> getStereotypedProperty()
	{
		if (stereotypedProperty == null)
		{
			stereotypedProperty = new EObjectContainmentEList<StereotypedProperty>(StereotypedProperty.class, this, PivotPackage.APPLIED_STEREOTYPE__STEREOTYPED_PROPERTY);
		}
		return stereotypedProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StereotypedProperty createStereotypedProperty()
	{
		StereotypedProperty newStereotypedProperty = (StereotypedProperty) create(PivotPackage.Literals.STEREOTYPED_PROPERTY);
		getStereotypedProperty().add(newStereotypedProperty);
		return newStereotypedProperty;
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
			case PivotPackage.APPLIED_STEREOTYPE__OWNED_COMMENT:
				return ((InternalEList<?>)getOwnedComment()).basicRemove(otherEnd, msgs);
			case PivotPackage.APPLIED_STEREOTYPE__APPLIED_STEREOTYPE:
				return ((InternalEList<?>)getAppliedStereotype()).basicRemove(otherEnd, msgs);
			case PivotPackage.APPLIED_STEREOTYPE__STEREOTYPED_PROPERTY:
				return ((InternalEList<?>)getStereotypedProperty()).basicRemove(otherEnd, msgs);
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
			case PivotPackage.APPLIED_STEREOTYPE__OWNED_COMMENT:
				return getOwnedComment();
			case PivotPackage.APPLIED_STEREOTYPE__APPLIED_STEREOTYPE:
				return getAppliedStereotype();
			case PivotPackage.APPLIED_STEREOTYPE__REFERRED_TYPE:
				if (resolve) return getReferredType();
				return basicGetReferredType();
			case PivotPackage.APPLIED_STEREOTYPE__STEREOTYPED_PROPERTY:
				return getStereotypedProperty();
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
			case PivotPackage.APPLIED_STEREOTYPE__OWNED_COMMENT:
				getOwnedComment().clear();
				getOwnedComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.APPLIED_STEREOTYPE__APPLIED_STEREOTYPE:
				getAppliedStereotype().clear();
				getAppliedStereotype().addAll((Collection<? extends AppliedStereotype>)newValue);
				return;
			case PivotPackage.APPLIED_STEREOTYPE__REFERRED_TYPE:
				setReferredType((Type)newValue);
				return;
			case PivotPackage.APPLIED_STEREOTYPE__STEREOTYPED_PROPERTY:
				getStereotypedProperty().clear();
				getStereotypedProperty().addAll((Collection<? extends StereotypedProperty>)newValue);
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
			case PivotPackage.APPLIED_STEREOTYPE__OWNED_COMMENT:
				getOwnedComment().clear();
				return;
			case PivotPackage.APPLIED_STEREOTYPE__APPLIED_STEREOTYPE:
				getAppliedStereotype().clear();
				return;
			case PivotPackage.APPLIED_STEREOTYPE__REFERRED_TYPE:
				setReferredType((Type)null);
				return;
			case PivotPackage.APPLIED_STEREOTYPE__STEREOTYPED_PROPERTY:
				getStereotypedProperty().clear();
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
			case PivotPackage.APPLIED_STEREOTYPE__OWNED_COMMENT:
				return ownedComment != null && !ownedComment.isEmpty();
			case PivotPackage.APPLIED_STEREOTYPE__APPLIED_STEREOTYPE:
				return appliedStereotype != null && !appliedStereotype.isEmpty();
			case PivotPackage.APPLIED_STEREOTYPE__REFERRED_TYPE:
				return referredType != null;
			case PivotPackage.APPLIED_STEREOTYPE__STEREOTYPED_PROPERTY:
				return stereotypedProperty != null && !stereotypedProperty.isEmpty();
		}
		return eDynamicIsSet(featureID);
	}

	@Override
	public <R> R accept(Visitor<R> visitor) {
		return visitor.visitAppliedStereotype(this);
	}
} //AppliedStereotypeImpl
