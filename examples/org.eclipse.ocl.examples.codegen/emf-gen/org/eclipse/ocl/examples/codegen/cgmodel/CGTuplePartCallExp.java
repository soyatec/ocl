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

import org.eclipse.ocl.examples.domain.ids.TuplePartId;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CG Tuple Part Call Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.CGTuplePartCallExp#getPivotTuplePartId <em>Pivot Tuple Part Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage#getCGTuplePartCallExp()
 * @model
 * @generated
 */
public interface CGTuplePartCallExp extends CGPropertyCallExp {
	/**
	 * Returns the value of the '<em><b>Pivot Tuple Part Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pivot Tuple Part Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pivot Tuple Part Id</em>' attribute.
	 * @see #setPivotTuplePartId(TuplePartId)
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage#getCGTuplePartCallExp_PivotTuplePartId()
	 * @model dataType="org.eclipse.ocl.examples.codegen.cgmodel.TuplePartId" required="true"
	 * @generated
	 */
	TuplePartId getPivotTuplePartId();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGTuplePartCallExp#getPivotTuplePartId <em>Pivot Tuple Part Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pivot Tuple Part Id</em>' attribute.
	 * @see #getPivotTuplePartId()
	 * @generated
	 */
	void setPivotTuplePartId(TuplePartId value);

} // CGTuplePartCallExp
