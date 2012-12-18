/**
 * <copyright>
 * 
 * Copyright (c) 2012 E.D.Willink and others.
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
package org.eclipse.ocl.examples.pivot;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State Machine</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * State machines can be used to express the behavior of part of a system. Behavior is modeled as a traversal of a graph of state nodes interconnected by one or more joined transition arcs that are triggered by the dispatching of series of (event) occurrences. During this traversal, the state machine executes a series of activities associated with various elements of the state machine.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.StateMachine#getRegion <em>Region</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.StateMachine#getConnectionPoint <em>Connection Point</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.StateMachine#getSubmachineState <em>Submachine State</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.StateMachine#getExtendedStateMachine <em>Extended State Machine</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getStateMachine()
 * @model
 * @generated
 */
public interface StateMachine extends Behavior
{
	/**
	 * Returns the value of the '<em><b>Region</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Region}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The regions owned directly by the state machine.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Region</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getStateMachine_Region()
	 * @model containment="true" required="true" ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/ocl/3.1.0/Pivot!StateMachine!region'"
	 * @generated
	 */
	EList<Region> getRegion();

	/**
	 * Creates a new {@link org.eclipse.ocl.examples.pivot.Region} and appends it to the '<em><b>Region</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.eclipse.ocl.examples.pivot.Region}.
	 * @see #getRegion()
	 * @generated
	 */
	Region createRegion();

	/**
	 * Returns the value of the '<em><b>Connection Point</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Pseudostate}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The connection points defined for this state machine. They represent the interface of the state machine when used as part of submachine state.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Connection Point</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getStateMachine_ConnectionPoint()
	 * @model containment="true" ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/ocl/3.1.0/Pivot!StateMachine!connectionPoint'"
	 * @generated
	 */
	EList<Pseudostate> getConnectionPoint();

	/**
	 * Creates a new {@link org.eclipse.ocl.examples.pivot.Pseudostate} and appends it to the '<em><b>Connection Point</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.eclipse.ocl.examples.pivot.Pseudostate}.
	 * @see #getConnectionPoint()
	 * @generated
	 */
	Pseudostate createConnectionPoint();

	/**
	 * Returns the value of the '<em><b>Extended State Machine</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.StateMachine}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The state machines of which this is an extension.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Extended State Machine</em>' reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getStateMachine_ExtendedStateMachine()
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/ocl/3.1.0/Pivot!StateMachine!extendedStateMachine'"
	 * @generated
	 */
	EList<StateMachine> getExtendedStateMachine();

	/**
	 * Returns the value of the '<em><b>Submachine State</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.State}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.State#getSubmachine <em>Submachine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * References the submachine(s) in case of a submachine state. Multiple machines are referenced in case of a concurrent state.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Submachine State</em>' reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getStateMachine_SubmachineState()
	 * @see org.eclipse.ocl.examples.pivot.State#getSubmachine
	 * @model opposite="submachine" ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/ocl/3.1.0/Pivot!StateMachine!submachineState'"
	 * @generated
	 */
	EList<State> getSubmachineState();

} // StateMachine
