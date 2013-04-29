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
package org.eclipse.ocl.examples.codegen.cgmodel;

import org.eclipse.ocl.examples.domain.library.LibraryIteration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CG Library Iterate Call Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryIterateCallExp#getLibraryIteration <em>Library Iteration</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryIterateCallExp#getResult <em>Result</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage#getCGLibraryIterateCallExp()
 * @model
 * @generated
 */
public interface CGLibraryIterateCallExp extends CGIterationCallExp {
	/**
	 * Returns the value of the '<em><b>Library Iteration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Library Iteration</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Library Iteration</em>' attribute.
	 * @see #setLibraryIteration(LibraryIteration)
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage#getCGLibraryIterateCallExp_LibraryIteration()
	 * @model dataType="org.eclipse.ocl.examples.codegen.cgmodel.LibraryIteration" required="true"
	 * @generated
	 */
	LibraryIteration getLibraryIteration();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryIterateCallExp#getLibraryIteration <em>Library Iteration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Library Iteration</em>' attribute.
	 * @see #getLibraryIteration()
	 * @generated
	 */
	void setLibraryIteration(LibraryIteration value);

	/**
	 * Returns the value of the '<em><b>Result</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result</em>' containment reference.
	 * @see #setResult(CGIterator)
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage#getCGLibraryIterateCallExp_Result()
	 * @model containment="true"
	 * @generated
	 */
	CGIterator getResult();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryIterateCallExp#getResult <em>Result</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result</em>' containment reference.
	 * @see #getResult()
	 * @generated
	 */
	void setResult(CGIterator value);

} // CGLibraryIterateCallExp
