/**
 * <copyright>
 * 
 * Copyright (c) 2013 E.D.Willink and others.
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
package org.eclipse.ocl.examples.autogen.autocgmodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import org.eclipse.ocl.examples.autogen.autocgmodel.AutoCGModelPackage;
import org.eclipse.ocl.examples.autogen.autocgmodel.CGContainmentPart;
import org.eclipse.ocl.examples.autogen.autocgmodel.CGContainmentVisit;

import org.eclipse.ocl.examples.autogen.autocgmodel.util.AutoCGModelVisitor;

import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.impl.CGValuedElementImpl;

import org.eclipse.ocl.examples.codegen.cgmodel.util.CGModelVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CG Containment Part</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.autogen.autocgmodel.impl.CGContainmentPartImpl#getContainmentVisit <em>Containment Visit</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.autogen.autocgmodel.impl.CGContainmentPartImpl#getInit <em>Init</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CGContainmentPartImpl extends CGValuedElementImpl implements CGContainmentPart {
	/**
	 * The cached value of the '{@link #getInit() <em>Init</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInit()
	 * @generated
	 * @ordered
	 */
	protected CGValuedElement init;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CGContainmentPartImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AutoCGModelPackage.Literals.CG_CONTAINMENT_PART;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGContainmentVisit getContainmentVisit() {
		if (eContainerFeatureID() != AutoCGModelPackage.CG_CONTAINMENT_PART__CONTAINMENT_VISIT) return null;
		return (CGContainmentVisit)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContainmentVisit(CGContainmentVisit newContainmentVisit, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newContainmentVisit, AutoCGModelPackage.CG_CONTAINMENT_PART__CONTAINMENT_VISIT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainmentVisit(CGContainmentVisit newContainmentVisit) {
		if (newContainmentVisit != eInternalContainer() || (eContainerFeatureID() != AutoCGModelPackage.CG_CONTAINMENT_PART__CONTAINMENT_VISIT && newContainmentVisit != null)) {
			if (EcoreUtil.isAncestor(this, newContainmentVisit))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newContainmentVisit != null)
				msgs = ((InternalEObject)newContainmentVisit).eInverseAdd(this, AutoCGModelPackage.CG_CONTAINMENT_VISIT__PARTS, CGContainmentVisit.class, msgs);
			msgs = basicSetContainmentVisit(newContainmentVisit, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AutoCGModelPackage.CG_CONTAINMENT_PART__CONTAINMENT_VISIT, newContainmentVisit, newContainmentVisit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGValuedElement getInit() {
		return init;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInit(CGValuedElement newInit, NotificationChain msgs) {
		CGValuedElement oldInit = init;
		init = newInit;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AutoCGModelPackage.CG_CONTAINMENT_PART__INIT, oldInit, newInit);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInit(CGValuedElement newInit) {
		if (newInit != init) {
			NotificationChain msgs = null;
			if (init != null)
				msgs = ((InternalEObject)init).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AutoCGModelPackage.CG_CONTAINMENT_PART__INIT, null, msgs);
			if (newInit != null)
				msgs = ((InternalEObject)newInit).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AutoCGModelPackage.CG_CONTAINMENT_PART__INIT, null, msgs);
			msgs = basicSetInit(newInit, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AutoCGModelPackage.CG_CONTAINMENT_PART__INIT, newInit, newInit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AutoCGModelPackage.CG_CONTAINMENT_PART__CONTAINMENT_VISIT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetContainmentVisit((CGContainmentVisit)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AutoCGModelPackage.CG_CONTAINMENT_PART__CONTAINMENT_VISIT:
				return basicSetContainmentVisit(null, msgs);
			case AutoCGModelPackage.CG_CONTAINMENT_PART__INIT:
				return basicSetInit(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case AutoCGModelPackage.CG_CONTAINMENT_PART__CONTAINMENT_VISIT:
				return eInternalContainer().eInverseRemove(this, AutoCGModelPackage.CG_CONTAINMENT_VISIT__PARTS, CGContainmentVisit.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AutoCGModelPackage.CG_CONTAINMENT_PART__CONTAINMENT_VISIT:
				return getContainmentVisit();
			case AutoCGModelPackage.CG_CONTAINMENT_PART__INIT:
				return getInit();
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
			case AutoCGModelPackage.CG_CONTAINMENT_PART__CONTAINMENT_VISIT:
				setContainmentVisit((CGContainmentVisit)newValue);
				return;
			case AutoCGModelPackage.CG_CONTAINMENT_PART__INIT:
				setInit((CGValuedElement)newValue);
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
			case AutoCGModelPackage.CG_CONTAINMENT_PART__CONTAINMENT_VISIT:
				setContainmentVisit((CGContainmentVisit)null);
				return;
			case AutoCGModelPackage.CG_CONTAINMENT_PART__INIT:
				setInit((CGValuedElement)null);
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
			case AutoCGModelPackage.CG_CONTAINMENT_PART__CONTAINMENT_VISIT:
				return getContainmentVisit() != null;
			case AutoCGModelPackage.CG_CONTAINMENT_PART__INIT:
				return init != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public @Nullable <R> R accept(@NonNull CGModelVisitor<R> visitor) {
		return (R) ((AutoCGModelVisitor<?>)visitor).visitCGContainmentPart(this);
	}

} //CGContainmentPartImpl
