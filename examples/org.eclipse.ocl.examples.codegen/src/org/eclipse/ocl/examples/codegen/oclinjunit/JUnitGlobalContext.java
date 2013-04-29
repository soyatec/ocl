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
package org.eclipse.ocl.examples.codegen.oclinjunit;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.cgmodel.CGElement;
import org.eclipse.ocl.examples.codegen.java.JavaCodeGenerator;
import org.eclipse.ocl.examples.codegen.java.JavaGlobalContext;

/**
 * A JUnitGlobalContext maintains the Java-specific global context for generation of code.
 */
public class JUnitGlobalContext extends JavaGlobalContext
{
	public JUnitGlobalContext(@NonNull JavaCodeGenerator codeGenerator) {
		super(codeGenerator);
	}

	@Override
	public @NonNull JUnitLocalContext createNestedContext(@NonNull CGElement cgScope) {
		return new JUnitLocalContext(this, cgScope);
	}
}