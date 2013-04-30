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
 * A representation of the model object '<em><b>CG Type Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A CGTypeExp is a non-constant expression that references a type.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.CGTypeExp#getReferredType <em>Referred Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage#getCGTypeExp()
 * @model
 * @generated
 */
public interface CGTypeExp extends CGValuedElement {
	/**
	 * Returns the value of the '<em><b>Referred Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The shared type.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Referred Type</em>' reference.
	 * @see #setReferredType(CGExecutorType)
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage#getCGTypeExp_ReferredType()
	 * @model resolveProxies="false" required="true"
	 * @generated
	 */
	CGExecutorType getReferredType();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGTypeExp#getReferredType <em>Referred Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Type</em>' reference.
	 * @see #getReferredType()
	 * @generated
	 */
	void setReferredType(CGExecutorType value);

} // CGTypeExp
