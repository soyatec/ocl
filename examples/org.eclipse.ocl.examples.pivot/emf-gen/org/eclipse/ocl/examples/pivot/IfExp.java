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
 * $Id: IfExp.java,v 1.4 2011/05/19 16:55:39 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>If Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.IfExp#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.IfExp#getThenExpression <em>Then Expression</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.IfExp#getElseExpression <em>Else Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getIfExp()
 * @generated
 */
public interface IfExp
		extends OCLExpression {

	/**
	 * Returns the value of the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' containment reference.
	 * @see #setCondition(OCLExpression)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getIfExp_Condition()
	 * @generated
	 */
	OCLExpression getCondition();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.IfExp#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(OCLExpression value);

	/**
	 * Creates a new {@link org.eclipse.ocl.examples.pivot.OCLExpression} and sets the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param eClass The Ecore class of the {@link org.eclipse.ocl.examples.pivot.OCLExpression} to create.
	 * @return The new {@link org.eclipse.ocl.examples.pivot.OCLExpression}.
	 * @see #getCondition()
	 * @generated
	 */
	OCLExpression createCondition(EClass eClass);

	/**
	 * Returns the value of the '<em><b>Then Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Then Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Then Expression</em>' containment reference.
	 * @see #setThenExpression(OCLExpression)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getIfExp_ThenExpression()
	 * @generated
	 */
	OCLExpression getThenExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.IfExp#getThenExpression <em>Then Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Then Expression</em>' containment reference.
	 * @see #getThenExpression()
	 * @generated
	 */
	void setThenExpression(OCLExpression value);

	/**
	 * Creates a new {@link org.eclipse.ocl.examples.pivot.OCLExpression} and sets the '<em><b>Then Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param eClass The Ecore class of the {@link org.eclipse.ocl.examples.pivot.OCLExpression} to create.
	 * @return The new {@link org.eclipse.ocl.examples.pivot.OCLExpression}.
	 * @see #getThenExpression()
	 * @generated
	 */
	OCLExpression createThenExpression(EClass eClass);

	/**
	 * Returns the value of the '<em><b>Else Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Else Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Else Expression</em>' containment reference.
	 * @see #setElseExpression(OCLExpression)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getIfExp_ElseExpression()
	 * @generated
	 */
	OCLExpression getElseExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.IfExp#getElseExpression <em>Else Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Else Expression</em>' containment reference.
	 * @see #getElseExpression()
	 * @generated
	 */
	void setElseExpression(OCLExpression value);

	/**
	 * Creates a new {@link org.eclipse.ocl.examples.pivot.OCLExpression} and sets the '<em><b>Else Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param eClass The Ecore class of the {@link org.eclipse.ocl.examples.pivot.OCLExpression} to create.
	 * @return The new {@link org.eclipse.ocl.examples.pivot.OCLExpression}.
	 * @see #getElseExpression()
	 * @generated
	 */
	OCLExpression createElseExpression(EClass eClass);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateConditionTypeIsBoolean(DiagnosticChain diagnostics, Map<Object, Object> context);

} // IfExp
