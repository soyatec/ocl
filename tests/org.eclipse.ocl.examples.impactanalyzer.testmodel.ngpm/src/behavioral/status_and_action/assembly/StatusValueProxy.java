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
 * $Id: StatusValueProxy.java,v 1.2 2011/03/05 21:48:54 auhl Exp $
 */
package behavioral.status_and_action.assembly;

import behavioral.status_and_action.design.AbstractStatusValue;
import behavioral.status_and_action.design.StatusValue;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Status Value Proxy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link behavioral.status_and_action.assembly.StatusValueProxy#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see behavioral.status_and_action.assembly.AssemblyPackage#getStatusValueProxy()
 * @model
 * @generated
 */
public interface StatusValueProxy extends AbstractStatusValue, StatusValue, ConnectableElement {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' reference.
	 * @see #setValue(StatusValue)
	 * @see behavioral.status_and_action.assembly.AssemblyPackage#getStatusValueProxy_Value()
	 * @model annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName='proxy'"
	 * @generated
	 */
	StatusValue getValue();

	/**
	 * Sets the value of the '{@link behavioral.status_and_action.assembly.StatusValueProxy#getValue <em>Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(StatusValue value);

} // StatusValueProxy
