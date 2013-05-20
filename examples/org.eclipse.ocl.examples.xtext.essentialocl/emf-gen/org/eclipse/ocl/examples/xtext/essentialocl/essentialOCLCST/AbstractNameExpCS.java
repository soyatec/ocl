/**
 * <copyright>
 *
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 */

package org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST;

import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.xtext.base.baseCST.PathNameCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Name Exp CS</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage#getAbstractNameExpCS()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface AbstractNameExpCS extends ExpCS
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	NamedElement getNamedElement();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	AbstractNameExpCS getNameExp();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	PathNameCS getPathName();

} // AbstractNameExpCS
