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
package org.eclipse.ocl.examples.codegen.oclinecore;

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.cgmodel.CGElement;
import org.eclipse.ocl.examples.codegen.java.JavaCodeGenerator;
import org.eclipse.ocl.examples.codegen.java.JavaGlobalContext;

/**
 * A JavaGlobalContext maintains the Java-specific global context for generation of code.
 */
public class OCLinEcoreGlobalContext extends JavaGlobalContext
{
	protected final @NonNull GenPackage genPackage;
	
	public OCLinEcoreGlobalContext(@NonNull JavaCodeGenerator codeGenerator, @NonNull GenPackage genPackage) {
		super(codeGenerator);
		this.genPackage = genPackage;
	}

	@Override
	public @NonNull OCLinEcoreLocalContext createNestedContext(@NonNull CGElement cgScope) {
		return new OCLinEcoreLocalContext(this, cgScope);
	}

	public @NonNull String getTablesClassName() {
		return codeGenerator.getGenModelHelper().getTablesClassName(genPackage);
	}
}