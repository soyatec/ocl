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
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGWhileExp;
import org.eclipse.ocl.examples.codegen.cgmodel.util.CGModelVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CG While Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGWhileExpImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGWhileExpImpl#getBodyExpression <em>Body Expression</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGWhileExpImpl#getFinallyExpression <em>Finally Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CGWhileExpImpl extends CGValuedElementImpl implements CGWhileExp {
	/**
	 * The cached value of the '{@link #getCondition() <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected CGValuedElement condition;

	/**
	 * The cached value of the '{@link #getBodyExpression() <em>Body Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBodyExpression()
	 * @generated
	 * @ordered
	 */
	protected CGValuedElement bodyExpression;

	/**
	 * The cached value of the '{@link #getFinallyExpression() <em>Finally Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFinallyExpression()
	 * @generated
	 * @ordered
	 */
	protected CGValuedElement finallyExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CGWhileExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CGModelPackage.Literals.CG_WHILE_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGValuedElement getCondition() {
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCondition(CGValuedElement newCondition, NotificationChain msgs) {
		CGValuedElement oldCondition = condition;
		condition = newCondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CGModelPackage.CG_WHILE_EXP__CONDITION, oldCondition, newCondition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCondition(CGValuedElement newCondition) {
		if (newCondition != condition) {
			NotificationChain msgs = null;
			if (condition != null)
				msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CGModelPackage.CG_WHILE_EXP__CONDITION, null, msgs);
			if (newCondition != null)
				msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CGModelPackage.CG_WHILE_EXP__CONDITION, null, msgs);
			msgs = basicSetCondition(newCondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CGModelPackage.CG_WHILE_EXP__CONDITION, newCondition, newCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGValuedElement getBodyExpression() {
		return bodyExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBodyExpression(CGValuedElement newBodyExpression, NotificationChain msgs) {
		CGValuedElement oldBodyExpression = bodyExpression;
		bodyExpression = newBodyExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CGModelPackage.CG_WHILE_EXP__BODY_EXPRESSION, oldBodyExpression, newBodyExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBodyExpression(CGValuedElement newBodyExpression) {
		if (newBodyExpression != bodyExpression) {
			NotificationChain msgs = null;
			if (bodyExpression != null)
				msgs = ((InternalEObject)bodyExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CGModelPackage.CG_WHILE_EXP__BODY_EXPRESSION, null, msgs);
			if (newBodyExpression != null)
				msgs = ((InternalEObject)newBodyExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CGModelPackage.CG_WHILE_EXP__BODY_EXPRESSION, null, msgs);
			msgs = basicSetBodyExpression(newBodyExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CGModelPackage.CG_WHILE_EXP__BODY_EXPRESSION, newBodyExpression, newBodyExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGValuedElement getFinallyExpression() {
		return finallyExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFinallyExpression(CGValuedElement newFinallyExpression, NotificationChain msgs) {
		CGValuedElement oldFinallyExpression = finallyExpression;
		finallyExpression = newFinallyExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CGModelPackage.CG_WHILE_EXP__FINALLY_EXPRESSION, oldFinallyExpression, newFinallyExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFinallyExpression(CGValuedElement newFinallyExpression) {
		if (newFinallyExpression != finallyExpression) {
			NotificationChain msgs = null;
			if (finallyExpression != null)
				msgs = ((InternalEObject)finallyExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CGModelPackage.CG_WHILE_EXP__FINALLY_EXPRESSION, null, msgs);
			if (newFinallyExpression != null)
				msgs = ((InternalEObject)newFinallyExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CGModelPackage.CG_WHILE_EXP__FINALLY_EXPRESSION, null, msgs);
			msgs = basicSetFinallyExpression(newFinallyExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CGModelPackage.CG_WHILE_EXP__FINALLY_EXPRESSION, newFinallyExpression, newFinallyExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CGModelPackage.CG_WHILE_EXP__CONDITION:
				return basicSetCondition(null, msgs);
			case CGModelPackage.CG_WHILE_EXP__BODY_EXPRESSION:
				return basicSetBodyExpression(null, msgs);
			case CGModelPackage.CG_WHILE_EXP__FINALLY_EXPRESSION:
				return basicSetFinallyExpression(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CGModelPackage.CG_WHILE_EXP__CONDITION:
				return getCondition();
			case CGModelPackage.CG_WHILE_EXP__BODY_EXPRESSION:
				return getBodyExpression();
			case CGModelPackage.CG_WHILE_EXP__FINALLY_EXPRESSION:
				return getFinallyExpression();
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
			case CGModelPackage.CG_WHILE_EXP__CONDITION:
				setCondition((CGValuedElement)newValue);
				return;
			case CGModelPackage.CG_WHILE_EXP__BODY_EXPRESSION:
				setBodyExpression((CGValuedElement)newValue);
				return;
			case CGModelPackage.CG_WHILE_EXP__FINALLY_EXPRESSION:
				setFinallyExpression((CGValuedElement)newValue);
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
			case CGModelPackage.CG_WHILE_EXP__CONDITION:
				setCondition((CGValuedElement)null);
				return;
			case CGModelPackage.CG_WHILE_EXP__BODY_EXPRESSION:
				setBodyExpression((CGValuedElement)null);
				return;
			case CGModelPackage.CG_WHILE_EXP__FINALLY_EXPRESSION:
				setFinallyExpression((CGValuedElement)null);
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
			case CGModelPackage.CG_WHILE_EXP__CONDITION:
				return condition != null;
			case CGModelPackage.CG_WHILE_EXP__BODY_EXPRESSION:
				return bodyExpression != null;
			case CGModelPackage.CG_WHILE_EXP__FINALLY_EXPRESSION:
				return finallyExpression != null;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public <R> R accept(@NonNull CGModelVisitor<R> visitor) {
		return visitor.visitCGWhileExp(this);
	}

	@Override
	public @NonNull CGValuedElement getValue() {
		return this;		// FIXME folding
	}

	@Override
	public boolean isBoxed() {
		return true;
	}

	@Override
	public boolean isUnboxed() {
		return false;
	}
} //CGWhileExpImpl
