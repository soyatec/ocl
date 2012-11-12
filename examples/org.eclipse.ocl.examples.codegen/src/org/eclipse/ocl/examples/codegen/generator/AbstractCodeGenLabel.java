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

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import org.eclipse.jdt.annotation.NonNull;

public class AbstractCodeGenLabel implements CodeGenLabel
{ 
	protected final @NonNull String label;
	private @NonNull Stack<CodeGenSnippet> stack = new Stack<CodeGenSnippet>();
	private /*@LazyNonNull*/ Set<CodeGenSnippet> dependencies = null;		// That require this Snippet to be emitted before them.
	
	public AbstractCodeGenLabel(@NonNull String label) {
		this.label = label;
	}

	public void addDependency(@NonNull CodeGenSnippet cgNode) {
		if (stack.isEmpty()) {
			if (dependencies == null) {
				dependencies = new HashSet<CodeGenSnippet>();
			}
			dependencies.add(cgNode);
		}
		else {
			@SuppressWarnings("null") @NonNull CodeGenSnippet peek = stack.peek();
			cgNode.addDependsOn(peek);
		}
	}

	@SuppressWarnings("null")
	public @NonNull CodeGenSnippet pop() {
		return stack.pop();
	}

	public void push(@NonNull CodeGenSnippet cgNode) {
		if (stack.isEmpty()) {
			if (dependencies != null) {
				for (CodeGenSnippet aDependency : dependencies) {
					assert aDependency != null;
					aDependency.addDependsOn(cgNode);
				}
			}
		}
		stack.push(cgNode);
	}

	@Override
	public String toString() {
		return "<" + label + ">";
	}

//	public void toString(@NonNull StringBuilder s, @NonNull String indentation) {
//		stack.peek().toString(s, indentation);
//	}
}