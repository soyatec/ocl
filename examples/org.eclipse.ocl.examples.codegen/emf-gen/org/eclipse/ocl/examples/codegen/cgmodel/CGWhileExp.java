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
 * A representation of the model object '<em><b>CG While Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.CGWhileExp#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.CGWhileExp#getBodyExpression <em>Body Expression</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.CGWhileExp#getFinallyExpression <em>Finally Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage#getCGWhileExp()
 * @model
 * @generated
 */
public interface CGWhileExp extends CGComputedExp {
	/**
	 * Returns the value of the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' containment reference.
	 * @see #setCondition(CGValuedElement)
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage#getCGWhileExp_Condition()
	 * @model containment="true" required="true"
	 * @generated
	 */
	CGValuedElement getCondition();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGWhileExp#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(CGValuedElement value);

	/**
	 * Returns the value of the '<em><b>Body Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body Expression</em>' containment reference.
	 * @see #setBodyExpression(CGValuedElement)
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage#getCGWhileExp_BodyExpression()
	 * @model containment="true" required="true"
	 * @generated
	 */
	CGValuedElement getBodyExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGWhileExp#getBodyExpression <em>Body Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body Expression</em>' containment reference.
	 * @see #getBodyExpression()
	 * @generated
	 */
	void setBodyExpression(CGValuedElement value);

	/**
	 * Returns the value of the '<em><b>Finally Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Finally Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Finally Expression</em>' containment reference.
	 * @see #setFinallyExpression(CGValuedElement)
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage#getCGWhileExp_FinallyExpression()
	 * @model containment="true" required="true"
	 * @generated
	 */
	CGValuedElement getFinallyExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGWhileExp#getFinallyExpression <em>Finally Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Finally Expression</em>' containment reference.
	 * @see #getFinallyExpression()
	 * @generated
	 */
	void setFinallyExpression(CGValuedElement value);

} // CGWhileExp
