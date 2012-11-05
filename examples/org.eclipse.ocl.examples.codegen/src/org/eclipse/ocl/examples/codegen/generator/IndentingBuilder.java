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

import java.util.Stack;

import org.eclipse.jdt.annotation.NonNull;

public class IndentingBuilder
{
	protected final StringBuilder s = new StringBuilder();						// Partial text contribution awaiting addition to contents
	private @NonNull Stack<String> indentationStack = new Stack<String>();
	private boolean indentPending = false;
	private @NonNull String defaultIndent = "    ";
	
	public IndentingBuilder(@NonNull String defaultIndent) {
		this.defaultIndent = defaultIndent;
	}

	public void append(@NonNull String string) {
		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);
			if (c == '\n') {
				if (indentPending && !indentationStack.isEmpty()) {
					String indentation = indentationStack.peek();
					boolean isWhite = true;
					for (int j = 0; j < indentation.length(); j++) {
						if (!Character.isWhitespace(indentation.charAt(j))) {
							isWhite = false;
							break;
						}
					}
					if (!isWhite) {
						s.append(indentation);
					}
				}
				s.append(c);
				indentPending = true;
			}
			else {
				if (indentPending) {
					indentPending = false;
					if (!indentationStack.isEmpty()) {
						s.append(indentationStack.peek());
					}
				}
				s.append(c);
			}
		}
	}

	public void popIndentation() {
		if (!indentationStack.isEmpty()) {
			indentationStack.pop();
		}
	}

	public void pushIndentation() {
		pushIndentation(defaultIndent);
	}

	public void pushIndentation(@NonNull String moreIndentation) {
		if (indentationStack.isEmpty()) {
			indentationStack.push(moreIndentation);
		}
		else {
			indentationStack.push(indentationStack.peek() + moreIndentation);
		}
	}

	@Override
	public String toString() {
		return s.toString();
	}
}
