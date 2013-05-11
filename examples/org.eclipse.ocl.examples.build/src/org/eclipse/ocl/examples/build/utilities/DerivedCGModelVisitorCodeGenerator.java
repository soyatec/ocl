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
 *     Adolfo Sanchez-Barbudo Herrera (Univeristy of York) - Bug 397429
 *
 * </copyright>
 *
 * $Id: XtextVisitorCodeGenerator.java,v 1.4 2011/03/17 20:01:45 ewillink Exp $
 */
package org.eclipse.ocl.examples.build.utilities;

import org.eclipse.emf.mwe.core.issues.Issues;

/**
 * Generates the javaFolder/'javaPackageName'/visitorClassName.java file providing
 * a static Java-creation of the libraryFile OCL standard library definition.
 */
public class DerivedCGModelVisitorCodeGenerator extends CGModelVisitorCodeGenerator
{
	
	protected String superVisitorPackageName;
	protected String superVisitorClassName;
	

	protected String ecoreFile;

	@Override
	public void checkConfiguration(Issues issues) {
		super.checkConfiguration(issues);
		if (superVisitorClassName == null) {
			issues.addError(this, "superVisitorClassName not specified.");
		}
	}
	
	public void setSuperVisitorPackageName(String superVisitorPackageName) {
		this.superVisitorPackageName = superVisitorPackageName;
	}
	
	public void setSuperVisitorClassName(String superVisitorClassName) {
		this.superVisitorClassName = superVisitorClassName;
	}
	
	@Override
	protected String getSuperVisitorPackageName() {
		return superVisitorPackageName;
	}
	
	@Override
	protected String getSuperVisitorClassName() {		
		return superVisitorClassName;
	}
}
