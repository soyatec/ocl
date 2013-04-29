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
 * A representation of the model object '<em><b>CG Global Constant</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A CGConstant represents a constant value that may be shared by may CGConstantExp. The shared
 * value may be generated as a global constant. Inlineable constants need no global declaration.
 * 
 * Derived classes support distinct forms of constants.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.CGConstant#getConstantValue <em>Constant Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage#getCGConstant()
 * @model abstract="true"
 * @generated
 */
public interface CGConstant extends CGValuedElement {

	/**
	 * Returns the value of the '<em><b>Constant Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Zzvalue</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constant Value</em>' attribute.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage#getCGConstant_ConstantValue()
	 * @model dataType="org.eclipse.ocl.examples.codegen.cgmodel.Object" required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	Object getConstantValue();
} // CGGlobalConstant
