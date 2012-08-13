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
package org.eclipse.ocl.examples.pivot;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Applied Stereotype</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.AppliedStereotype#getReferredType <em>Referred Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.AppliedStereotype#getStereotypedProperty <em>Stereotyped Property</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getAppliedStereotype()
 * @model
 * @generated
 */
public interface AppliedStereotype extends Element
{
	/**
	 * Returns the value of the '<em><b>Referred Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Type</em>' reference.
	 * @see #setReferredType(Type)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getAppliedStereotype_ReferredType()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/ocl/3.1.0/Pivot!AppliedStereotype!referredType'"
	 * @generated
	 */
	Type getReferredType();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.AppliedStereotype#getReferredType <em>Referred Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Type</em>' reference.
	 * @see #getReferredType()
	 * @generated
	 */
	void setReferredType(Type value);

	/**
	 * Returns the value of the '<em><b>Stereotyped Property</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.StereotypedProperty}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stereotyped Property</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stereotyped Property</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getAppliedStereotype_StereotypedProperty()
	 * @model containment="true" ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/ocl/3.1.0/Pivot!AppliedStereotype!stereotypedProperty'"
	 * @generated
	 */
	EList<StereotypedProperty> getStereotypedProperty();

	/**
	 * Creates a new {@link org.eclipse.ocl.examples.pivot.StereotypedProperty} and appends it to the '<em><b>Stereotyped Property</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.eclipse.ocl.examples.pivot.StereotypedProperty}.
	 * @see #getStereotypedProperty()
	 * @generated
	 */
	StereotypedProperty createStereotypedProperty();

} // AppliedStereotype
