/*******************************************************************************
 * Copyright (c) 2009, 2011 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************
 * $Id: Freelance.java,v 1.2 2011/03/09 14:45:50 auhl Exp $
 */
package company;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Freelance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link company.Freelance#getAssignment <em>Assignment</em>}</li>
 * </ul>
 * </p>
 *
 * @see company.CompanyPackage#getFreelance()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL ValidAssignment='self.assignment >= 5 and self.assignment <= 30' ValidAssignmentWarning='self.assignment >= 5 and self.assignment <= 40' StudentAndFreelancesAge='self.age < 40'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='ValidAssignment ValidAssignmentWarning StudentAndFreelancesAge'"
 * @generated
 */
public interface Freelance extends Employee {
    /**
	 * Returns the value of the '<em><b>Assignment</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Assignment</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Assignment</em>' attribute.
	 * @see #setAssignment(int)
	 * @see company.CompanyPackage#getFreelance_Assignment()
	 * @model dataType="primitivetypes.Integer"
	 * @generated
	 */
    int getAssignment();

    /**
	 * Sets the value of the '{@link company.Freelance#getAssignment <em>Assignment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Assignment</em>' attribute.
	 * @see #getAssignment()
	 * @generated
	 */
	void setAssignment(int value);

} // Freelance
