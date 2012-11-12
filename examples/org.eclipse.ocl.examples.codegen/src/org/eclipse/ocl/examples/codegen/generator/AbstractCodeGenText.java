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
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Type;

public abstract class AbstractCodeGenText extends AbstractCodeGenNode implements CodeGenText
{ 
	protected static boolean appendWithIndentation(@NonNull StringBuilder s, @NonNull String string, @NonNull String indentation, boolean indentPending) {
		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);
			if (c == '\n') {
				if (indentPending) {
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
					s.append(indentation);
				}
				s.append(c);
			}
		}
		return indentPending;
	}

	protected final @NonNull CodeGenSnippet snippet;
	protected final @NonNull String indentation;
	private @NonNull StringBuilder s = new StringBuilder();
	private boolean indentPending = true;
	
	public AbstractCodeGenText(@NonNull CodeGenSnippet snippet, @NonNull String indentation) {
		super(snippet.getCodeGenerator());
		this.snippet = snippet;
		this.indentation = indentation;
	}

	public void append(@NonNull String string) {
		indentPending = appendWithIndentation(s, string, "", indentPending);
	}

	@Override
	public void appendException(@NonNull Exception e) {
		super.appendException(e);
		append("<<" + e.getClass().getSimpleName() + ">>");
	}

	public void appendReferenceTo(@NonNull Object element) {
		CodeGenSnippet s = codeGenerator.getSnippet(element);
		snippet.addDependsOn(s);
		append(s.getName());
	}

	public void appendReferenceTo(@NonNull OCLExpression element, @NonNull Type requiredType) {
		try {
			Class<?> requiredClass = codeGenerator.getGenModelHelper().getEcoreInterfaceClass(requiredType);
			CodeGenSnippet s = codeGenerator.getSnippet(element);
			snippet.addDependsOn(s);
			Class<?> actualClass = s.getJavaClass();
			if (!requiredClass.isAssignableFrom(actualClass)) {
				append("((" + codeGenerator.getImportedName(requiredClass) + ')' + s.getName() + ')');
			}
			else {
				append(s.getName());
			}
		} catch (GenModelException e) {
			appendException(e);
		}
	}

	protected void appendWithIndentation(@NonNull String string, @NonNull String indentation) {
		indentPending = appendWithIndentation(s, string, indentation, indentPending);
	}
	
	public boolean flatten(@NonNull Set<CodeGenSnippet> knownSnippets, @NonNull LinkedHashMap<CodeGenText, String> textContents, @NonNull String outerIndentation) {
		String innerIndentation = outerIndentation + getIndentation();
		textContents.put(this, innerIndentation);
		return true;
	}

	public @NonNull String getIndentation() {
		return indentation;
	}

	public @NonNull CodeGenSnippet getSnippet() {
		return snippet;
	}

	@Override
	public String toString() {
		return s.toString();
	}

	public void toString(@NonNull StringBuilder sb, @NonNull String indentation) {
		@SuppressWarnings("null") @NonNull String string = s.toString();
		appendWithIndentation(sb, string, indentation, true);
//		s.append('"' + Strings.convertToJavaString(s.toString()) + '"');
	}
}