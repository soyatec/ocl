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
import org.eclipse.ocl.examples.pivot.Iteration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CG Iteration Call Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.CGIterationCallExp#getReferredIteration <em>Referred Iteration</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.CGIterationCallExp#getIterators <em>Iterators</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.CGIterationCallExp#getBody <em>Body</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage#getCGIterationCallExp()
 * @model abstract="true"
 * @generated
 */
public interface CGIterationCallExp extends CGCallExp {
	/**
	 * Returns the value of the '<em><b>Referred Iteration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Iteration</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Iteration</em>' attribute.
	 * @see #setReferredIteration(Iteration)
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage#getCGIterationCallExp_ReferredIteration()
	 * @model dataType="org.eclipse.ocl.examples.codegen.cgmodel.Iteration" required="true"
	 * @generated
	 */
	Iteration getReferredIteration();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGIterationCallExp#getReferredIteration <em>Referred Iteration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Iteration</em>' attribute.
	 * @see #getReferredIteration()
	 * @generated
	 */
	void setReferredIteration(Iteration value);

	/**
	 * Returns the value of the '<em><b>Iterators</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.codegen.cgmodel.CGIterator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Iterators</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Iterators</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage#getCGIterationCallExp_Iterators()
	 * @model containment="true"
	 * @generated
	 */
	List<CGIterator> getIterators();

	/**
	 * Returns the value of the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' containment reference.
	 * @see #setBody(CGValuedElement)
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage#getCGIterationCallExp_Body()
	 * @model containment="true" required="true"
	 * @generated
	 */
	CGValuedElement getBody();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGIterationCallExp#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(CGValuedElement value);

} // CGIterationCallExp