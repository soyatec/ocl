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

import org.eclipse.ocl.examples.domain.ids.TypeId;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CG Typed Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.CGTypedElement#getPivotTypeId <em>Pivot Type Id</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.CGTypedElement#getTypeId <em>Type Id</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.CGTypedElement#isRequired <em>Required</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage#getCGTypedElement()
 * @model abstract="true"
 * @generated
 */
public interface CGTypedElement extends CGNamedElement {
	/**
	 * Returns the value of the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pivot Type Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pivot Type Id</em>' attribute.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage#getCGTypedElement_PivotTypeId()
	 * @model dataType="org.eclipse.ocl.examples.codegen.cgmodel.TypeId" required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	TypeId getPivotTypeId();

	/**
	 * Returns the value of the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Id</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Id</em>' reference.
	 * @see #setTypeId(CGTypeId)
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage#getCGTypedElement_TypeId()
	 * @model resolveProxies="false" required="true"
	 * @generated
	 */
	CGTypeId getTypeId();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGTypedElement#getTypeId <em>Type Id</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Id</em>' reference.
	 * @see #getTypeId()
	 * @generated
	 */
	void setTypeId(CGTypeId value);

	/**
	 * Returns the value of the '<em><b>Required</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required</em>' attribute.
	 * @see #setRequired(boolean)
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage#getCGTypedElement_Required()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isRequired();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGTypedElement#isRequired <em>Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Required</em>' attribute.
	 * @see #isRequired()
	 * @generated
	 */
	void setRequired(boolean value);

} // CGTypedElement