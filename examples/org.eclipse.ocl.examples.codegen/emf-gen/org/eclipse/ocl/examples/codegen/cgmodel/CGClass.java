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

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CG Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.CGClass#getContainingPackage <em>Containing Package</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.CGClass#getOperations <em>Operations</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.CGClass#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.CGClass#getInvariants <em>Invariants</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage#getCGClass()
 * @model
 * @generated
 */
public interface CGClass extends CGNamedElement {
	/**
	 * Returns the value of the '<em><b>Operations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.codegen.cgmodel.CGOperation}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGOperation#getContainingClass <em>Containing Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operations</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage#getCGClass_Operations()
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGOperation#getContainingClass
	 * @model opposite="containingClass" containment="true" ordered="false"
	 * @generated
	 */
	@NonNull List<CGOperation> getOperations();

	/**
	 * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.codegen.cgmodel.CGProperty}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGProperty#getContainingClass <em>Containing Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage#getCGClass_Properties()
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGProperty#getContainingClass
	 * @model opposite="containingClass" containment="true" ordered="false"
	 * @generated
	 */
	@NonNull List<CGProperty> getProperties();

	/**
	 * Returns the value of the '<em><b>Invariants</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.codegen.cgmodel.CGConstraint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Invariant constraints on instances of this class.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Invariants</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage#getCGClass_Invariants()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	List<CGConstraint> getInvariants();

	/**
	 * Returns the value of the '<em><b>Containing Package</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGPackage#getClasses <em>Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Containing Package</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Containing Package</em>' container reference.
	 * @see #setContainingPackage(CGPackage)
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage#getCGClass_ContainingPackage()
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGPackage#getClasses
	 * @model opposite="classes" resolveProxies="false" required="true" transient="false"
	 * @generated
	 */
	CGPackage getContainingPackage();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGClass#getContainingPackage <em>Containing Package</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Containing Package</em>' container reference.
	 * @see #getContainingPackage()
	 * @generated
	 */
	void setContainingPackage(CGPackage value);

} // CGClass