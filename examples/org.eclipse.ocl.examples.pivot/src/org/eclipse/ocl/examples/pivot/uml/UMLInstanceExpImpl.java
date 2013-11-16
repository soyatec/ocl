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
package org.eclipse.ocl.examples.pivot.uml;

import org.eclipse.ocl.examples.pivot.internal.impl.VariableExpImpl;

/**
 * This is an experimental stub for the use of a UML InstanceValue as a default value in
 * a pivot model.
 */
public class UMLInstanceExpImpl extends VariableExpImpl implements UMLInstanceExp
{
	private org.eclipse.uml2.uml.InstanceSpecification umlInstance = null;

	public org.eclipse.uml2.uml.InstanceSpecification getReferredInstance() {
		return umlInstance;
	}

	public void setReferredInstance(org.eclipse.uml2.uml.InstanceSpecification umlInstance) {
		this.umlInstance = umlInstance;
	}
}
