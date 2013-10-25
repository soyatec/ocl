/**
 * <copyright>
 *
 * Copyright (c) 2010, 2011 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: PackageCS.java,v 1.4 2011/01/24 20:59:31 ewillink Exp $
 */

package org.eclipse.ocl.examples.xtext.base.basecs;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Package CS</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage#getPackageCS()
 * @model
 * @generated
 */
public interface PackageCS extends AbstractPackageCS {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='ocl::Package{\n\t\t\t\t-- TODO\n\t\t\t\tname = name,\n\t\t\t\tnestedPackage = ownedNestedPackage.ast()\n\t\t\t}'"
	 * @generated
	 */
	org.eclipse.ocl.examples.pivot.Package ast();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ClassifierCS getClassifier(String name);

} // PackageCS
