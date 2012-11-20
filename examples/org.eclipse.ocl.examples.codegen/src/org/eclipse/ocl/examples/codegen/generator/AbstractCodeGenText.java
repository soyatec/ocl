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

	public void appendBoxedReferenceTo(@NonNull OCLExpression element) {
		CodeGenSnippet referredSnippet = codeGenerator.getSnippet(element);
		CodeGenSnippet boxedSnippet = referredSnippet.getBoxedSnippet();
		snippet.addDependsOn(boxedSnippet);
		append(boxedSnippet.getName());
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

	public void appendUnboxedReferenceTo(@NonNull OCLExpression element, @NonNull Type requiredType) {
		try {
			Class<?> requiredClass = codeGenerator.getGenModelHelper().getEcoreInterfaceClass(requiredType);
			appendUnboxedReferenceTo(element, requiredClass);
		} catch (GenModelException e) {
			appendException(e);
		}
	}

	public void appendUnboxedReferenceTo(@NonNull OCLExpression element, @NonNull Class<?> requiredClass) {
		CodeGenSnippet referredSnippet = codeGenerator.getSnippet(element);
		CodeGenSnippet unboxedSnippet = referredSnippet.getUnboxedSnippet();
		snippet.addDependsOn(unboxedSnippet);
		Class<?> actualClass = unboxedSnippet.getJavaClass();
		if (!requiredClass.isAssignableFrom(actualClass)) {
			append("((" + codeGenerator.getImportedName(requiredClass) + ')' + unboxedSnippet.getName() + ')');
		}
		else {
			append(unboxedSnippet.getName());
		}
	}

	protected void appendWithIndentation(@NonNull String string, @NonNull String indentation) {
		indentPending = appendWithIndentation(s, string, indentation, indentPending);
	}
	
	public boolean flatten(@NonNull LinkedHashMap<CodeGenText, String> emittedTexts, @NonNull Set<CodeGenSnippet> emittedSnippets, @NonNull Set<CodeGenSnippet> startedSnippets, @NonNull String outerIndentation) {
		String innerIndentation = outerIndentation + getIndentation();
		emittedTexts.put(this, innerIndentation);
		return true;
	}

	public @NonNull String getIndentation() {
		return indentation;
	}

	public @NonNull CodeGenText getLastText() {
		return this;
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