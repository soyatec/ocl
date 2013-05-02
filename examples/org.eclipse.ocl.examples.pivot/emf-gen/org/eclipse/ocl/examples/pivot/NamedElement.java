/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: NamedElement.java,v 1.3 2011/05/19 16:55:39 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot;

import java.util.List;

import org.eclipse.ocl.examples.domain.elements.Nameable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Named Element</b></em>'.
 * @extends org.eclipse.ocl.examples.domain.elements.DomainNamedElement
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A named element represents an element with a name.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.NamedElement#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.NamedElement#isStatic <em>Is Static</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.NamedElement#getOwnedAnnotation <em>Owned Annotation</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getNamedElement()
 * @generated
 */
public interface NamedElement
		extends Element, Nameable, org.eclipse.ocl.examples.domain.elements.DomainNamedElement {

	/**
	 * Creates a new {@link org.eclipse.ocl.examples.pivot.Annotation} and appends it to the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.eclipse.ocl.examples.pivot.Annotation}.
	 * @see #getOwnedAnnotation()
	 * @generated
	 */
	Annotation createOwnedAnnotation();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The name of the NamedElement.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getNamedElement_Name()
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.NamedElement#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Static</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Static</em>' attribute.
	 * @see #setIsStatic(boolean)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getNamedElement_IsStatic()
	 * @generated
	 */
	boolean isStatic();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.NamedElement#isStatic <em>Is Static</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Static</em>' attribute.
	 * @see #isStatic()
	 * @generated
	 */
	void setIsStatic(boolean value);

	/**
	 * Returns the value of the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Annotation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Annotation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Annotation</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getNamedElement_OwnedAnnotation()
	 * @generated
	 */
	List<Annotation> getOwnedAnnotation();

} // NamedElement
