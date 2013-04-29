/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
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
 * $Id: Constraint.java,v 1.4 2011/05/19 16:55:39 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constraint</b></em>'.
 * @extends org.eclipse.ocl.examples.domain.elements.DomainConstraint
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A constraint is a condition or restriction expressed in natural language text or in a machine readable language for the purpose of declaring some of the semantics of an element.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Constraint#getConstrainedElement <em>Constrained Element</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Constraint#getSpecification <em>Specification</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Constraint#getStereotype <em>Stereotype</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Constraint#isCallable <em>Is Callable</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Constraint#getContext <em>Context</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getConstraint()
 * @generated
 */
public interface Constraint
		extends NamedElement, org.eclipse.ocl.examples.domain.elements.DomainConstraint {

	/**
	 * Returns the value of the '<em><b>Constrained Element</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Element}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ordered set of Elements referenced by this Constraint.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Constrained Element</em>' reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getConstraint_ConstrainedElement()
	 * @generated
	 */
	List<Element> getConstrainedElement();

	/**
	 * Returns the value of the '<em><b>Specification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A condition that must be true when evaluated in order for the constraint to be satisfied.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Specification</em>' containment reference.
	 * @see #setSpecification(ValueSpecification)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getConstraint_Specification()
	 * @generated
	 */
	ValueSpecification getSpecification();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Constraint#getSpecification <em>Specification</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Specification</em>' containment reference.
	 * @see #getSpecification()
	 * @generated
	 */
	void setSpecification(ValueSpecification value);

	/**
	 * Creates a new {@link org.eclipse.ocl.examples.pivot.ValueSpecification} and sets the '<em><b>Specification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param eClass The Ecore class of the {@link org.eclipse.ocl.examples.pivot.ValueSpecification} to create.
	 * @return The new {@link org.eclipse.ocl.examples.pivot.ValueSpecification}.
	 * @see #getSpecification()
	 * @generated
	 */
	ValueSpecification createSpecification(EClass eClass);

	/**
	 * Returns the value of the '<em><b>Context</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.NamedElement#getOwnedRule <em>Owned Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context</em>' container reference.
	 * @see #setContext(NamedElement)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getConstraint_Context()
	 * @see org.eclipse.ocl.examples.pivot.NamedElement#getOwnedRule
	 * @generated
	 */
	NamedElement getContext();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Constraint#getContext <em>Context</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context</em>' container reference.
	 * @see #getContext()
	 * @generated
	 */
	void setContext(NamedElement value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateUniqueName(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * Returns the value of the '<em><b>Stereotype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stereotype</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stereotype</em>' attribute.
	 * @see #setStereotype(String)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getConstraint_Stereotype()
	 * @generated
	 */
	String getStereotype();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Constraint#getStereotype <em>Stereotype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stereotype</em>' attribute.
	 * @see #getStereotype()
	 * @generated
	 */
	void setStereotype(String value);

	/**
	 * Returns the value of the '<em><b>Is Callable</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Callable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Callable</em>' attribute.
	 * @see #setIsCallable(boolean)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getConstraint_IsCallable()
	 * @generated
	 */
	boolean isCallable();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Constraint#isCallable <em>Is Callable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Callable</em>' attribute.
	 * @see #isCallable()
	 * @generated
	 */
	void setIsCallable(boolean value);

} // Constraint
