/**
 * <copyright>
 *
 * Copyright (c) 2013 Willink Transformations ltd, University of York and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Adolfo Sanchez-Barbudo Herrera (University of York) - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.build.utilities;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.m2m.qvt.oml.ExecutionContextImpl;
import org.eclipse.ocl.examples.pivot.utilities.ToStringVisitor;

/**
 * extra input:
 *    - visitorInterfaceName: A mandatory name of the visitor interface which will be
 *    weaved into the ecore model
 *    - visitorInterfaceQaulifiedName: the corresponding type instance qualified name 
 *    of the visitor.
 *    
 * @author adolfosbh
 *
 */
public class ToStringWeaver extends PredefinedQVToTransformationExecutor
{
	private String toStringVisitorQualifiedName = null;

	@Override
	public void checkConfiguration(Issues issues) {
	}
	
	@Override
	protected String  getPredefinedTransformationURI() {
		return "platform:/resource/org.eclipse.ocl.examples.build/src/org/eclipse/ocl/examples/build/qvto/ToStringWeaver.qvto";
	}

	public String getToStringVisitorQualifiedName() {
		return toStringVisitorQualifiedName != null ? toStringVisitorQualifiedName : ToStringVisitor.class.getName();
	}
	
	@Override
	protected void initializeConfigurationProperties(ExecutionContextImpl context) {
		context.setConfigProperty("toStringVisitorQualifiedName", getToStringVisitorQualifiedName());
		context.setConfigProperty("eStringClass", EcorePackage.Literals.ESTRING);
	}

	public void setToStringVisitorQualifiedName(String toStringVisitorQualifiedName) {
		this.toStringVisitorQualifiedName = toStringVisitorQualifiedName;
	}
}