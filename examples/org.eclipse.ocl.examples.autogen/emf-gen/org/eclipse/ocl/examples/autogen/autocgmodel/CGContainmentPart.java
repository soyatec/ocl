/**
 * <copyright>
 * 
 * Copyright (c) 2013 E.D.Willink and others.
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
package org.eclipse.ocl.examples.autogen.autocgmodel;

import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CG Containment Part</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.autogen.autocgmodel.CGContainmentPart#getContainmentVisit <em>Containment Visit</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.autogen.autocgmodel.CGContainmentPart#getInit <em>Init</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.autogen.autocgmodel.AutoCGModelPackage#getCGContainmentPart()
 * @model
 * @generated
 */
public interface CGContainmentPart extends CGValuedElement {
	/**
	 * Returns the value of the '<em><b>Containment Visit</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.autogen.autocgmodel.CGContainmentVisit#getParts <em>Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Containment Visit</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Containment Visit</em>' container reference.
	 * @see #setContainmentVisit(CGContainmentVisit)
	 * @see org.eclipse.ocl.examples.autogen.autocgmodel.AutoCGModelPackage#getCGContainmentPart_ContainmentVisit()
	 * @see org.eclipse.ocl.examples.autogen.autocgmodel.CGContainmentVisit#getParts
	 * @model opposite="parts" resolveProxies="false" required="true" transient="false"
	 * @generated
	 */
	CGContainmentVisit getContainmentVisit();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.autogen.autocgmodel.CGContainmentPart#getContainmentVisit <em>Containment Visit</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Containment Visit</em>' container reference.
	 * @see #getContainmentVisit()
	 * @generated
	 */
	void setContainmentVisit(CGContainmentVisit value);

	/**
	 * Returns the value of the '<em><b>Init</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The shared value.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Init</em>' containment reference.
	 * @see #setInit(CGValuedElement)
	 * @see org.eclipse.ocl.examples.autogen.autocgmodel.AutoCGModelPackage#getCGContainmentPart_Init()
	 * @model containment="true"
	 * @generated
	 */
	CGValuedElement getInit();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.autogen.autocgmodel.CGContainmentPart#getInit <em>Init</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Init</em>' containment reference.
	 * @see #getInit()
	 * @generated
	 */
	void setInit(CGValuedElement value);

} // CGContainmentPart
