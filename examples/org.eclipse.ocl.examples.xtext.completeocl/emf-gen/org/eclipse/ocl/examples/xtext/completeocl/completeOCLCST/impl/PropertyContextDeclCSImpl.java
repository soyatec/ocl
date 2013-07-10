/**
 * <copyright>
 *
 * Copyright (c) 2010, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: PropertyContextDeclCSImpl.java,v 1.7 2011/02/08 17:53:05 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.xtext.base.baseCST.ConstraintCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PathNameCS;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2Pivot;
import org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLCSTPackage;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PropertyContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.util.CompleteOCLCSVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpSpecificationCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Context Decl CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.PropertyContextDeclCSImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.PropertyContextDeclCSImpl#getDefaultExpressions <em>Default Expressions</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.PropertyContextDeclCSImpl#getDerivedInvariants <em>Derived Invariants</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PropertyContextDeclCSImpl extends FeatureContextDeclCSImpl implements PropertyContextDeclCS {
	/**
	 * The cached value of the '{@link #getDefaultExpressions() <em>Default Expressions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultExpressions()
	 * @generated
	 * @ordered
	 */
	protected EList<ExpSpecificationCS> defaultExpressions;
	/**
	 * The cached value of the '{@link #getDerivedInvariants() <em>Derived Invariants</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDerivedInvariants()
	 * @generated
	 * @ordered
	 */
	protected EList<ConstraintCS> derivedInvariants;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertyContextDeclCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CompleteOCLCSTPackage.Literals.PROPERTY_CONTEXT_DECL_CS;
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
			case CompleteOCLCSTPackage.PROPERTY_CONTEXT_DECL_CS__PROPERTY:
				return getProperty();
			case CompleteOCLCSTPackage.PROPERTY_CONTEXT_DECL_CS__DEFAULT_EXPRESSIONS:
				return getDefaultExpressions();
			case CompleteOCLCSTPackage.PROPERTY_CONTEXT_DECL_CS__DERIVED_INVARIANTS:
				return getDerivedInvariants();
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
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case CompleteOCLCSTPackage.PROPERTY_CONTEXT_DECL_CS__DEFAULT_EXPRESSIONS:
				getDefaultExpressions().clear();
				getDefaultExpressions().addAll((Collection<? extends ExpSpecificationCS>)newValue);
				return;
			case CompleteOCLCSTPackage.PROPERTY_CONTEXT_DECL_CS__DERIVED_INVARIANTS:
				getDerivedInvariants().clear();
				getDerivedInvariants().addAll((Collection<? extends ConstraintCS>)newValue);
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
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case CompleteOCLCSTPackage.PROPERTY_CONTEXT_DECL_CS__DEFAULT_EXPRESSIONS:
				getDefaultExpressions().clear();
				return;
			case CompleteOCLCSTPackage.PROPERTY_CONTEXT_DECL_CS__DERIVED_INVARIANTS:
				getDerivedInvariants().clear();
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
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case CompleteOCLCSTPackage.PROPERTY_CONTEXT_DECL_CS__PROPERTY:
				return getProperty() != null;
			case CompleteOCLCSTPackage.PROPERTY_CONTEXT_DECL_CS__DEFAULT_EXPRESSIONS:
				return defaultExpressions != null && !defaultExpressions.isEmpty();
			case CompleteOCLCSTPackage.PROPERTY_CONTEXT_DECL_CS__DERIVED_INVARIANTS:
				return derivedInvariants != null && !derivedInvariants.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull BaseCSVisitor<R> visitor) {
		return (R) ((CompleteOCLCSVisitor<?>)visitor).visitPropertyContextDeclCS(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Property getProperty()
	{
		PathNameCS pathName2 = pathName;
		if (pathName2 == null) {
			return null;
		}
		CS2Pivot.setElementType(pathName2, PivotPackage.Literals.PROPERTY, this, null);
		return (Property) pathName2.getElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExpSpecificationCS> getDefaultExpressions()
	{
		if (defaultExpressions == null)
		{
			defaultExpressions = new EObjectContainmentEList<ExpSpecificationCS>(ExpSpecificationCS.class, this, CompleteOCLCSTPackage.PROPERTY_CONTEXT_DECL_CS__DEFAULT_EXPRESSIONS);
		}
		return defaultExpressions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConstraintCS> getDerivedInvariants()
	{
		if (derivedInvariants == null)
		{
			derivedInvariants = new EObjectContainmentEList<ConstraintCS>(ConstraintCS.class, this, CompleteOCLCSTPackage.PROPERTY_CONTEXT_DECL_CS__DERIVED_INVARIANTS);
		}
		return derivedInvariants;
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
			case CompleteOCLCSTPackage.PROPERTY_CONTEXT_DECL_CS__DEFAULT_EXPRESSIONS:
				return ((InternalEList<?>)getDefaultExpressions()).basicRemove(otherEnd, msgs);
			case CompleteOCLCSTPackage.PROPERTY_CONTEXT_DECL_CS__DERIVED_INVARIANTS:
				return ((InternalEList<?>)getDerivedInvariants()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}
} //PropertyContextDeclCSImpl
