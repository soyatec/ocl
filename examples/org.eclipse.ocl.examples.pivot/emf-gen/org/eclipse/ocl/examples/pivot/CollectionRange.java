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
 * $Id: CollectionRange.java,v 1.4 2011/05/19 16:55:39 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Range</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.CollectionRange#getFirst <em>First</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.CollectionRange#getLast <em>Last</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getCollectionRange()
 * @generated
 */
public interface CollectionRange
		extends CollectionLiteralPart {

	/**
	 * Returns the value of the '<em><b>First</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>First</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>First</em>' containment reference.
	 * @see #setFirst(OCLExpression)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getCollectionRange_First()
	 * @generated
	 */
	OCLExpression getFirst();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.CollectionRange#getFirst <em>First</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First</em>' containment reference.
	 * @see #getFirst()
	 * @generated
	 */
	void setFirst(OCLExpression value);

	/**
	 * Creates a new {@link org.eclipse.ocl.examples.pivot.OCLExpression} and sets the '<em><b>First</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param eClass The Ecore class of the {@link org.eclipse.ocl.examples.pivot.OCLExpression} to create.
	 * @return The new {@link org.eclipse.ocl.examples.pivot.OCLExpression}.
	 * @see #getFirst()
	 * @generated
	 */
	OCLExpression createFirst(EClass eClass);

	/**
	 * Returns the value of the '<em><b>Last</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last</em>' containment reference.
	 * @see #setLast(OCLExpression)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getCollectionRange_Last()
	 * @generated
	 */
	OCLExpression getLast();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.CollectionRange#getLast <em>Last</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last</em>' containment reference.
	 * @see #getLast()
	 * @generated
	 */
	void setLast(OCLExpression value);

	/**
	 * Creates a new {@link org.eclipse.ocl.examples.pivot.OCLExpression} and sets the '<em><b>Last</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param eClass The Ecore class of the {@link org.eclipse.ocl.examples.pivot.OCLExpression} to create.
	 * @return The new {@link org.eclipse.ocl.examples.pivot.OCLExpression}.
	 * @see #getLast()
	 * @generated
	 */
	OCLExpression createLast(EClass eClass);

} // CollectionRange
