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

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Root#getNestedPackage <em>Nested Package</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Root#getExternalURI <em>External URI</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getRoot()
 * @model
 * @generated
 */
public interface Root extends Namespace
{

	/**
	 * Returns the value of the '<em><b>Nested Package</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Package}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nested Package</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nested Package</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getRoot_NestedPackage()
	 * @model containment="true" ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/ocl/3.1.0/Pivot!Root!nestedPackage'"
	 * @generated
	 */
	EList<org.eclipse.ocl.examples.pivot.Package> getNestedPackage();

	/**
	 * Creates a new {@link org.eclipse.ocl.examples.pivot.Package} and appends it to the '<em><b>Nested Package</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param eClass The Ecore class of the {@link org.eclipse.ocl.examples.pivot.Package} to create.
	 * @return The new {@link org.eclipse.ocl.examples.pivot.Package}.
	 * @see #getNestedPackage()
	 * @generated
	 */
	org.eclipse.ocl.examples.pivot.Package createNestedPackage(EClass eClass);

	/**
	 * Creates a new {@link org.eclipse.ocl.examples.pivot.Package} and appends it to the '<em><b>Nested Package</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.eclipse.ocl.examples.pivot.Package}.
	 * @see #getNestedPackage()
	 * @generated
	 */
	org.eclipse.ocl.examples.pivot.Package createNestedPackage();

	/**
	 * Returns the value of the '<em><b>External URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>External URI</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>External URI</em>' attribute.
	 * @see #setExternalURI(String)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getRoot_ExternalURI()
	 * @model dataType="org.eclipse.ocl.examples.pivot.String" ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/ocl/3.1.0/Pivot!Root!externalURI'"
	 * @generated
	 */
	String getExternalURI();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Root#getExternalURI <em>External URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>External URI</em>' attribute.
	 * @see #getExternalURI()
	 * @generated
	 */
	void setExternalURI(String value);

} // Root