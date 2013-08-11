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



/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CG Real</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * CGReal represents a real value.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.CGReal#getRealValue <em>Real Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage#getCGReal()
 * @generated
 */
public interface CGReal extends CGConstant {

	/**
	 * Returns the value of the '<em><b>Real Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Real Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * the real value
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Real Value</em>' attribute.
	 * @see #setRealValue(Number)
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage#getCGReal_RealValue()
	 * @generated
	 */
	Number getRealValue();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGReal#getRealValue <em>Real Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Real Value</em>' attribute.
	 * @see #getRealValue()
	 * @generated
	 */
	void setRealValue(Number value);
} // CGReal
