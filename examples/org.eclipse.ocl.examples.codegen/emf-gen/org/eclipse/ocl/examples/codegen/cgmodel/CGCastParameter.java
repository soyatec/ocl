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
 * A representation of the model object '<em><b>CG Cast Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A cast parameter wraps a passed parameter to apply the known type to the much weaker type
 * available as part of some polymorphic API.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.CGCastParameter#getReferredParameter <em>Referred Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage#getCGCastParameter()
 * @model
 * @generated
 */
public interface CGCastParameter extends CGParameter {
	/**
	 * Returns the value of the '<em><b>Referred Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Parameter</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Parameter</em>' reference.
	 * @see #setReferredParameter(CGParameter)
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage#getCGCastParameter_ReferredParameter()
	 * @model resolveProxies="false" required="true"
	 * @generated
	 */
	CGParameter getReferredParameter();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGCastParameter#getReferredParameter <em>Referred Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Parameter</em>' reference.
	 * @see #getReferredParameter()
	 * @generated
	 */
	void setReferredParameter(CGParameter value);

} // CGCastParameter
