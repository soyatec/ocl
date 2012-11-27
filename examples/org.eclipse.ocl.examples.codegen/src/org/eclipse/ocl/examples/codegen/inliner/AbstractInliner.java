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
package org.eclipse.ocl.examples.codegen.inliner;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.generator.CodeGenerator;

public abstract class AbstractInliner implements Inliner
{
	protected final @NonNull CodeGenerator codeGenerator;
	
	public AbstractInliner(@NonNull CodeGenerator codeGenerator) {
		this.codeGenerator = codeGenerator;
	}

	public final @NonNull CodeGenerator getCodeGenerator() {
		return codeGenerator;
	}
}
