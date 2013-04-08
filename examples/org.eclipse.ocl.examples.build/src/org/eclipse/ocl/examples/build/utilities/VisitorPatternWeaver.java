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

import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.m2m.qvt.oml.ExecutionContextImpl;

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
public class VisitorPatternWeaver extends PredefinedQVToTransformationExecutor {
	private String visitorInterfaceName;
	private String visitorInterfaceQualifiedName;
	
	public String getVisitorInterfaceName() {
		return visitorInterfaceName;
	}
	
	public void setVisitorInterfaceName(String visitorInterfaceName) {
		this.visitorInterfaceName = visitorInterfaceName;
	}
	
	public String getVisitorInterfaceQualifiedName() {
		return visitorInterfaceQualifiedName;
	}

	public void setVisitorInterfaceQualifiedName(
			String visitorInterfaceQualifiedName) {
		this.visitorInterfaceQualifiedName = visitorInterfaceQualifiedName;
	}

	@Override
	public void checkConfiguration(Issues issues) {
		if (getVisitorInterfaceName() == null) {
			issues.addError(this, "visitorInterfaceName not specified.");
		}
		if (getVisitorInterfaceQualifiedName() == null) {
			issues.addError(this, "visitorInterfaceQualifiedName not specified.");
		}
	}
	
	@Override
	protected void initializeConfigurationProperties(ExecutionContextImpl context) {
		context.setConfigProperty("visitorInterfaceName", getVisitorInterfaceName());
		context.setConfigProperty("visitorInterfaceQualifiedName", getVisitorInterfaceQualifiedName());
	
	}
	
	@Override
	protected String  getPredefinedTransformationURI() {
		return "platform:/plugin/org.eclipse.ocl.examples.build/src/org/eclipse/ocl/examples/build/qvto/VisitorPatternTransf.qvto";
	}
}