/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
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
 * $Id: SpecificationCS.java,v 1.1 2011/03/01 08:47:46 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.basecs;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Specification CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.basecs.SpecificationCS#getExprString <em>Expr String</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage#getSpecificationCS()
 * @model
 * @generated
 */
public interface SpecificationCS extends ModelElementCS
{
	/**
	 * Returns the value of the '<em><b>Expr String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expr String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expr String</em>' attribute.
	 * @see #setExprString(String)
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage#getSpecificationCS_ExprString()
	 * @model
	 * @generated
	 */
	String getExprString();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.base.basecs.SpecificationCS#getExprString <em>Expr String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expr String</em>' attribute.
	 * @see #getExprString()
	 * @generated
	 */
	void setExprString(String value);

} // SpecificationCS