/**
 * <copyright>
 *
 * Copyright (c) 2010, 2013 E.D.Willink and others.
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
 * $Id: Precedence.java,v 1.2 2011/01/24 20:49:36 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot;



/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Precedence</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Precedence#getAssociativity <em>Associativity</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Precedence#getOrder <em>Order</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getPrecedence()
 * @generated
 */
public interface Precedence
		extends NamedElement {

	/**
	 * Returns the value of the '<em><b>Associativity</b></em>' attribute.
	 * The default value is <code>"Left"</code>.
	 * The literals are from the enumeration {@link org.eclipse.ocl.examples.pivot.AssociativityKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Associativity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Associativity</em>' attribute.
	 * @see org.eclipse.ocl.examples.pivot.AssociativityKind
	 * @see #setAssociativity(AssociativityKind)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getPrecedence_Associativity()
	 * @generated
	 */
	AssociativityKind getAssociativity();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Precedence#getAssociativity <em>Associativity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Associativity</em>' attribute.
	 * @see org.eclipse.ocl.examples.pivot.AssociativityKind
	 * @see #getAssociativity()
	 * @generated
	 */
	void setAssociativity(AssociativityKind value);

	/**
	 * Returns the value of the '<em><b>Order</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Order</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Order</em>' attribute.
	 * @see #setOrder(Number)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getPrecedence_Order()
	 * @generated
	 */
	Number getOrder();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Precedence#getOrder <em>Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Order</em>' attribute.
	 * @see #getOrder()
	 * @generated
	 */
	void setOrder(Number value);

} // Precedence
