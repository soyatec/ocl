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

import java.util.LinkedHashMap;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

public interface CodeGenNode
{ 
	void appendException(@NonNull Exception e);
	boolean flatten(@NonNull LinkedHashMap<CodeGenText, String> emittedTexts, @NonNull Set<CodeGenSnippet> emittedSnippets, @NonNull Set<CodeGenSnippet> startedSnippets, @NonNull String outerIndentation);
	@NonNull CodeGenerator getCodeGenerator();
	@NonNull String getIndentation();
	@Nullable CodeGenText getLastText();
	void toString(@NonNull StringBuilder s, @NonNull String indentation);
}