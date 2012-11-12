/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D.Willink and others.
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
package org.eclipse.ocl.examples.codegen.generator;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * A AbstractCodeGenNode captures a contribution to the generated output.
 */
public abstract class AbstractCodeGenNode implements CodeGenNode
{
	protected final @NonNull CodeGenerator codeGenerator;
	
	public AbstractCodeGenNode(@NonNull CodeGenerator codeGenerator) {
		this.codeGenerator = codeGenerator;
	}

	public AbstractCodeGenNode(@NonNull String name, @Nullable Class<?> javaClass, @NonNull CodeGenerator codeGenerator, @NonNull String indentation) {
		this.codeGenerator = codeGenerator;
	}

	public void appendException(@NonNull Exception e) {
		codeGenerator.addProblem(e);
	}

	public final @NonNull CodeGenerator getCodeGenerator() {
		return codeGenerator;
	}
}
