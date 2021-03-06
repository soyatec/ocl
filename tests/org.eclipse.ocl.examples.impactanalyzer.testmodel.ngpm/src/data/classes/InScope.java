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
 * $Id: InScope.java,v 1.2 2011/03/05 21:37:37 auhl Exp $
 */
package data.classes;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>In Scope</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see data.classes.ClassesPackage#getInScope()
 * @model abstract="true"
 * @generated
 */
public interface InScope extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Used to build up a scope of named values, proceeding "inside-out." The first argument is the already computed set of NamedValues, all of which end up in the resulting set of NamedValues. NamedValues from the second argument are added to the result set if the first NamedValue set does not contain any NamedValue with an equal name.
	 * <!-- end-model-doc -->
	 * @model ordered="false" innerMany="true" innerOrdered="false" outerMany="true" outerOrdered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='inner->union(outer->select(o | not inner->exists(i | i.name = o.name))->asSet())'"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
	 * @generated
	 */
	EList<NamedValue> addNamedValuesWithNewNames(EList<NamedValue> inner, EList<NamedValue> outer);

} // InScope
