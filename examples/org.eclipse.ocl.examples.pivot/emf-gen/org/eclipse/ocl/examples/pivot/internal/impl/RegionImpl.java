/**
 * <copyright>
 * 
 * Copyright (c) 2012, 2013 E.D.Willink and others.
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
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Annotation;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.ElementExtension;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Region;
import org.eclipse.ocl.examples.pivot.State;
import org.eclipse.ocl.examples.pivot.StateMachine;
import org.eclipse.ocl.examples.pivot.Transition;
import org.eclipse.ocl.examples.pivot.Vertex;
import org.eclipse.ocl.examples.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Region</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.RegionImpl#getExtendedRegion <em>Extended Region</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.RegionImpl#getState <em>State</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.RegionImpl#getStateMachine <em>State Machine</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.RegionImpl#getSubvertex <em>Subvertex</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.RegionImpl#getTransition <em>Transition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RegionImpl extends NamespaceImpl implements Region
{
	/**
	 * The cached value of the '{@link #getExtendedRegion() <em>Extended Region</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtendedRegion()
	 * @generated
	 * @ordered
	 */
	protected Region extendedRegion;

	/**
	 * The cached value of the '{@link #getState() <em>State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected State state;

	/**
	 * The cached value of the '{@link #getStateMachine() <em>State Machine</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStateMachine()
	 * @generated
	 * @ordered
	 */
	protected StateMachine stateMachine;

	/**
	 * The cached value of the '{@link #getSubvertex() <em>Subvertex</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubvertex()
	 * @generated
	 * @ordered
	 */
	protected EList<Vertex> subvertex;

	/**
	 * The cached value of the '{@link #getTransition() <em>Transition</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransition()
	 * @generated
	 * @ordered
	 */
	protected EList<Transition> transition;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RegionImpl()
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
		return PivotPackage.Literals.REGION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<Vertex> getSubvertex()
	{
		if (subvertex == null)
		{
			subvertex = new EObjectContainmentWithInverseEList<Vertex>(Vertex.class, this, PivotPackage.REGION__SUBVERTEX, PivotPackage.VERTEX__CONTAINER);
		}
		return subvertex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case PivotPackage.REGION__EXTENSION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getExtension()).basicAdd(otherEnd, msgs);
			case PivotPackage.REGION__SUBVERTEX:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSubvertex()).basicAdd(otherEnd, msgs);
			case PivotPackage.REGION__TRANSITION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getTransition()).basicAdd(otherEnd, msgs);
		}
		return eDynamicInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<Transition> getTransition()
	{
		if (transition == null)
		{
			transition = new EObjectContainmentWithInverseEList<Transition>(Transition.class, this, PivotPackage.REGION__TRANSITION, PivotPackage.TRANSITION__CONTAINER);
		}
		return transition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateMachine getStateMachine()
	{
		if (stateMachine != null && ((EObject)stateMachine).eIsProxy())
		{
			InternalEObject oldStateMachine = (InternalEObject)stateMachine;
			stateMachine = (StateMachine)eResolveProxy(oldStateMachine);
			if (stateMachine != oldStateMachine)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PivotPackage.REGION__STATE_MACHINE, oldStateMachine, stateMachine));
			}
		}
		return stateMachine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateMachine basicGetStateMachine()
	{
		return stateMachine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStateMachine(StateMachine newStateMachine)
	{
		StateMachine oldStateMachine = stateMachine;
		stateMachine = newStateMachine;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.REGION__STATE_MACHINE, oldStateMachine, stateMachine));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State getState()
	{
		if (state != null && ((EObject)state).eIsProxy())
		{
			InternalEObject oldState = (InternalEObject)state;
			state = (State)eResolveProxy(oldState);
			if (state != oldState)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PivotPackage.REGION__STATE, oldState, state));
			}
		}
		return state;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State basicGetState()
	{
		return state;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setState(State newState)
	{
		State oldState = state;
		state = newState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.REGION__STATE, oldState, state));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Region getExtendedRegion()
	{
		if (extendedRegion != null && ((EObject)extendedRegion).eIsProxy())
		{
			InternalEObject oldExtendedRegion = (InternalEObject)extendedRegion;
			extendedRegion = (Region)eResolveProxy(oldExtendedRegion);
			if (extendedRegion != oldExtendedRegion)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PivotPackage.REGION__EXTENDED_REGION, oldExtendedRegion, extendedRegion));
			}
		}
		return extendedRegion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Region basicGetExtendedRegion()
	{
		return extendedRegion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtendedRegion(Region newExtendedRegion)
	{
		Region oldExtendedRegion = extendedRegion;
		extendedRegion = newExtendedRegion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.REGION__EXTENDED_REGION, oldExtendedRegion, extendedRegion));
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
			case PivotPackage.REGION__EXTENSION:
				return ((InternalEList<?>)getExtension()).basicRemove(otherEnd, msgs);
			case PivotPackage.REGION__OWNED_COMMENT:
				return ((InternalEList<?>)getOwnedComment()).basicRemove(otherEnd, msgs);
			case PivotPackage.REGION__OWNED_ANNOTATION:
				return ((InternalEList<?>)getOwnedAnnotation()).basicRemove(otherEnd, msgs);
			case PivotPackage.REGION__OWNED_RULE:
				return ((InternalEList<?>)getOwnedRule()).basicRemove(otherEnd, msgs);
			case PivotPackage.REGION__SUBVERTEX:
				return ((InternalEList<?>)getSubvertex()).basicRemove(otherEnd, msgs);
			case PivotPackage.REGION__TRANSITION:
				return ((InternalEList<?>)getTransition()).basicRemove(otherEnd, msgs);
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
			case PivotPackage.REGION__EXTENSION:
				return getExtension();
			case PivotPackage.REGION__OWNED_COMMENT:
				return getOwnedComment();
			case PivotPackage.REGION__IS_STATIC:
				return isStatic();
			case PivotPackage.REGION__NAME:
				return getName();
			case PivotPackage.REGION__OWNED_ANNOTATION:
				return getOwnedAnnotation();
			case PivotPackage.REGION__OWNED_RULE:
				return getOwnedRule();
			case PivotPackage.REGION__EXTENDED_REGION:
				if (resolve) return getExtendedRegion();
				return basicGetExtendedRegion();
			case PivotPackage.REGION__STATE:
				if (resolve) return getState();
				return basicGetState();
			case PivotPackage.REGION__STATE_MACHINE:
				if (resolve) return getStateMachine();
				return basicGetStateMachine();
			case PivotPackage.REGION__SUBVERTEX:
				return getSubvertex();
			case PivotPackage.REGION__TRANSITION:
				return getTransition();
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
			case PivotPackage.REGION__EXTENSION:
				getExtension().clear();
				getExtension().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.REGION__OWNED_COMMENT:
				getOwnedComment().clear();
				getOwnedComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.REGION__IS_STATIC:
				setIsStatic((Boolean)newValue);
				return;
			case PivotPackage.REGION__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.REGION__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				getOwnedAnnotation().addAll((Collection<? extends Annotation>)newValue);
				return;
			case PivotPackage.REGION__OWNED_RULE:
				getOwnedRule().clear();
				getOwnedRule().addAll((Collection<? extends Constraint>)newValue);
				return;
			case PivotPackage.REGION__EXTENDED_REGION:
				setExtendedRegion((Region)newValue);
				return;
			case PivotPackage.REGION__STATE:
				setState((State)newValue);
				return;
			case PivotPackage.REGION__STATE_MACHINE:
				setStateMachine((StateMachine)newValue);
				return;
			case PivotPackage.REGION__SUBVERTEX:
				getSubvertex().clear();
				getSubvertex().addAll((Collection<? extends Vertex>)newValue);
				return;
			case PivotPackage.REGION__TRANSITION:
				getTransition().clear();
				getTransition().addAll((Collection<? extends Transition>)newValue);
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
			case PivotPackage.REGION__EXTENSION:
				getExtension().clear();
				return;
			case PivotPackage.REGION__OWNED_COMMENT:
				getOwnedComment().clear();
				return;
			case PivotPackage.REGION__IS_STATIC:
				setIsStatic(IS_STATIC_EDEFAULT);
				return;
			case PivotPackage.REGION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.REGION__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				return;
			case PivotPackage.REGION__OWNED_RULE:
				getOwnedRule().clear();
				return;
			case PivotPackage.REGION__EXTENDED_REGION:
				setExtendedRegion((Region)null);
				return;
			case PivotPackage.REGION__STATE:
				setState((State)null);
				return;
			case PivotPackage.REGION__STATE_MACHINE:
				setStateMachine((StateMachine)null);
				return;
			case PivotPackage.REGION__SUBVERTEX:
				getSubvertex().clear();
				return;
			case PivotPackage.REGION__TRANSITION:
				getTransition().clear();
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
			case PivotPackage.REGION__EXTENSION:
				return extension != null && !extension.isEmpty();
			case PivotPackage.REGION__OWNED_COMMENT:
				return ownedComment != null && !ownedComment.isEmpty();
			case PivotPackage.REGION__IS_STATIC:
				return ((eFlags & IS_STATIC_EFLAG) != 0) != IS_STATIC_EDEFAULT;
			case PivotPackage.REGION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.REGION__OWNED_ANNOTATION:
				return ownedAnnotation != null && !ownedAnnotation.isEmpty();
			case PivotPackage.REGION__OWNED_RULE:
				return ownedRule != null && !ownedRule.isEmpty();
			case PivotPackage.REGION__EXTENDED_REGION:
				return extendedRegion != null;
			case PivotPackage.REGION__STATE:
				return state != null;
			case PivotPackage.REGION__STATE_MACHINE:
				return stateMachine != null;
			case PivotPackage.REGION__SUBVERTEX:
				return subvertex != null && !subvertex.isEmpty();
			case PivotPackage.REGION__TRANSITION:
				return transition != null && !transition.isEmpty();
		}
		return eDynamicIsSet(featureID);
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitRegion(this);
	}
} //RegionImpl
