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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.ConnectionPointReference;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ElementExtension;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Pseudostate;
import org.eclipse.ocl.examples.pivot.Region;
import org.eclipse.ocl.examples.pivot.State;
import org.eclipse.ocl.examples.pivot.Transition;
import org.eclipse.ocl.examples.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connection Point Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.ConnectionPointReferenceImpl#getEntry <em>Entry</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.ConnectionPointReferenceImpl#getExit <em>Exit</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.ConnectionPointReferenceImpl#getState <em>State</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConnectionPointReferenceImpl extends VertexImpl implements ConnectionPointReference
{
	/**
	 * The cached value of the '{@link #getEntry() <em>Entry</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntry()
	 * @generated
	 * @ordered
	 */
	protected EList<Pseudostate> entry;

	/**
	 * The cached value of the '{@link #getExit() <em>Exit</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExit()
	 * @generated
	 * @ordered
	 */
	protected EList<Pseudostate> exit;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConnectionPointReferenceImpl()
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
		return PivotPackage.Literals.CONNECTION_POINT_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<Pseudostate> getEntry()
	{
		if (entry == null)
		{
			entry = new EObjectResolvingEList<Pseudostate>(Pseudostate.class, this, PivotPackage.CONNECTION_POINT_REFERENCE__ENTRY);
		}
		return entry;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PivotPackage.CONNECTION_POINT_REFERENCE__STATE, oldState, state));
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
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.CONNECTION_POINT_REFERENCE__STATE, oldState, state));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<Pseudostate> getExit()
	{
		if (exit == null)
		{
			exit = new EObjectResolvingEList<Pseudostate>(Pseudostate.class, this, PivotPackage.CONNECTION_POINT_REFERENCE__EXIT);
		}
		return exit;
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
			case PivotPackage.CONNECTION_POINT_REFERENCE__EXTENSION:
				return getExtension();
			case PivotPackage.CONNECTION_POINT_REFERENCE__OWNED_ANNOTATION:
				return getOwnedAnnotation();
			case PivotPackage.CONNECTION_POINT_REFERENCE__OWNED_COMMENT:
				return getOwnedComment();
			case PivotPackage.CONNECTION_POINT_REFERENCE__IS_STATIC:
				return isStatic();
			case PivotPackage.CONNECTION_POINT_REFERENCE__NAME:
				return getName();
			case PivotPackage.CONNECTION_POINT_REFERENCE__CONTAINER:
				return getContainer();
			case PivotPackage.CONNECTION_POINT_REFERENCE__INCOMING:
				return getIncoming();
			case PivotPackage.CONNECTION_POINT_REFERENCE__OUTGOING:
				return getOutgoing();
			case PivotPackage.CONNECTION_POINT_REFERENCE__ENTRY:
				return getEntry();
			case PivotPackage.CONNECTION_POINT_REFERENCE__EXIT:
				return getExit();
			case PivotPackage.CONNECTION_POINT_REFERENCE__STATE:
				if (resolve) return getState();
				return basicGetState();
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
			case PivotPackage.CONNECTION_POINT_REFERENCE__EXTENSION:
				getExtension().clear();
				getExtension().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.CONNECTION_POINT_REFERENCE__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				getOwnedAnnotation().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.CONNECTION_POINT_REFERENCE__OWNED_COMMENT:
				getOwnedComment().clear();
				getOwnedComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.CONNECTION_POINT_REFERENCE__IS_STATIC:
				setIsStatic((Boolean)newValue);
				return;
			case PivotPackage.CONNECTION_POINT_REFERENCE__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.CONNECTION_POINT_REFERENCE__CONTAINER:
				setContainer((Region)newValue);
				return;
			case PivotPackage.CONNECTION_POINT_REFERENCE__INCOMING:
				getIncoming().clear();
				getIncoming().addAll((Collection<? extends Transition>)newValue);
				return;
			case PivotPackage.CONNECTION_POINT_REFERENCE__OUTGOING:
				getOutgoing().clear();
				getOutgoing().addAll((Collection<? extends Transition>)newValue);
				return;
			case PivotPackage.CONNECTION_POINT_REFERENCE__ENTRY:
				getEntry().clear();
				getEntry().addAll((Collection<? extends Pseudostate>)newValue);
				return;
			case PivotPackage.CONNECTION_POINT_REFERENCE__EXIT:
				getExit().clear();
				getExit().addAll((Collection<? extends Pseudostate>)newValue);
				return;
			case PivotPackage.CONNECTION_POINT_REFERENCE__STATE:
				setState((State)newValue);
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
			case PivotPackage.CONNECTION_POINT_REFERENCE__EXTENSION:
				getExtension().clear();
				return;
			case PivotPackage.CONNECTION_POINT_REFERENCE__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				return;
			case PivotPackage.CONNECTION_POINT_REFERENCE__OWNED_COMMENT:
				getOwnedComment().clear();
				return;
			case PivotPackage.CONNECTION_POINT_REFERENCE__IS_STATIC:
				setIsStatic(IS_STATIC_EDEFAULT);
				return;
			case PivotPackage.CONNECTION_POINT_REFERENCE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.CONNECTION_POINT_REFERENCE__CONTAINER:
				setContainer((Region)null);
				return;
			case PivotPackage.CONNECTION_POINT_REFERENCE__INCOMING:
				getIncoming().clear();
				return;
			case PivotPackage.CONNECTION_POINT_REFERENCE__OUTGOING:
				getOutgoing().clear();
				return;
			case PivotPackage.CONNECTION_POINT_REFERENCE__ENTRY:
				getEntry().clear();
				return;
			case PivotPackage.CONNECTION_POINT_REFERENCE__EXIT:
				getExit().clear();
				return;
			case PivotPackage.CONNECTION_POINT_REFERENCE__STATE:
				setState((State)null);
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
			case PivotPackage.CONNECTION_POINT_REFERENCE__EXTENSION:
				return extension != null && !extension.isEmpty();
			case PivotPackage.CONNECTION_POINT_REFERENCE__OWNED_ANNOTATION:
				return ownedAnnotation != null && !ownedAnnotation.isEmpty();
			case PivotPackage.CONNECTION_POINT_REFERENCE__OWNED_COMMENT:
				return ownedComment != null && !ownedComment.isEmpty();
			case PivotPackage.CONNECTION_POINT_REFERENCE__IS_STATIC:
				return ((eFlags & IS_STATIC_EFLAG) != 0) != IS_STATIC_EDEFAULT;
			case PivotPackage.CONNECTION_POINT_REFERENCE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.CONNECTION_POINT_REFERENCE__CONTAINER:
				return getContainer() != null;
			case PivotPackage.CONNECTION_POINT_REFERENCE__INCOMING:
				return incoming != null && !incoming.isEmpty();
			case PivotPackage.CONNECTION_POINT_REFERENCE__OUTGOING:
				return outgoing != null && !outgoing.isEmpty();
			case PivotPackage.CONNECTION_POINT_REFERENCE__ENTRY:
				return entry != null && !entry.isEmpty();
			case PivotPackage.CONNECTION_POINT_REFERENCE__EXIT:
				return exit != null && !exit.isEmpty();
			case PivotPackage.CONNECTION_POINT_REFERENCE__STATE:
				return state != null;
		}
		return eDynamicIsSet(featureID);
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitConnectionPointReference(this);
	}
} //ConnectionPointReferenceImpl
