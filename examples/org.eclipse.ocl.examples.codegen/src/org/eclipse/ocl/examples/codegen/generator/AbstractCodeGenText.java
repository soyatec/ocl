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
import org.eclipse.ocl.examples.pivot.Element;

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

	public void appendCaughtBoxedReferenceTo(@NonNull Class<?> requiredClass, @NonNull Element element) {
		CodeGenSnippet snippet = codeGenerator.getSnippet(element, true, true);
		appendReferenceTo(requiredClass, snippet, false);
	}

	public void appendCaughtUnboxedReferenceTo(@NonNull Class<?> requiredClass, @NonNull Element element) {
		CodeGenSnippet snippet = codeGenerator.getSnippet(element, true, false);
		appendReferenceTo(requiredClass, snippet, false);
	}

	public void appendEvaluatorReference() {
		codeGenerator.addDependency(CodeGenerator.LOCAL_ROOT, snippet);
		append(codeGenerator.getEvaluatorName());
	}

	@Override
	public void appendException(@NonNull Exception e) {
		super.appendException(e);
		append("<<" + e.getClass().getSimpleName() + ">>");
	}

	public void appendReferenceTo(@NonNull Object element) {
		appendReferenceTo(codeGenerator.getSnippet(element));
	}

	public void appendReferenceTo(@NonNull CodeGenSnippet s) {
		snippet.addDependsOn(s);
		append(s.getName());
	}

	public void appendReferenceTo(@NonNull Class<?> requiredClass, @NonNull CodeGenSnippet referredSnippet) {
		appendReferenceTo(requiredClass, referredSnippet, false);
	}

	public void appendReferenceTo(@NonNull Class<?> requiredClass, @NonNull CodeGenSnippet referredSnippet, boolean asPrimary) {
		snippet.addDependsOn(referredSnippet);
		Class<?> actualClass = referredSnippet.getJavaClass();
		boolean needsCast = !requiredClass.isAssignableFrom(actualClass) && !referredSnippet.isNull();
		if (needsCast) {
			if (asPrimary) {
				append("(");
			}
			append("(");
			appendClassReference(requiredClass);
			append(")");
			append(referredSnippet.getName());
			if (asPrimary) {
				append(")");
			}
		}
		else {
			append(referredSnippet.getName());
		}
	}

	public void appendResultCast(Class<?> actualClass, @NonNull Class<?> requiredClass, String className) {
		if ((actualClass == null) || !requiredClass.isAssignableFrom(actualClass)) {
			String actualClassName = actualClass != null ? actualClass.getName() : "<unknown-class>";
			System.out.println("Cast from " + actualClassName + " to " + requiredClass.getName() + " needed for " + className);
			append("(");
			appendClassReference(requiredClass);
			append(")");
		}
	}

	public void appendThrownBoxedReferenceTo(@NonNull Class<?> requiredClass, @NonNull Element element) {
		CodeGenSnippet snippet = codeGenerator.getSnippet(element, false, true);
		appendReferenceTo(requiredClass, snippet, false);
	}

	public void appendThrownReferenceTo(@NonNull Class<?> requiredClass, @NonNull Element element) {
		CodeGenSnippet originalSnippet = codeGenerator.getSnippet(element);
		CodeGenSnippet thrownSnippet = originalSnippet.getThrownSnippet();
		appendReferenceTo(requiredClass, thrownSnippet, false);
	}

	public void appendThrownUnboxedReferenceTo(@NonNull Class<?> requiredClass, @NonNull Element element) {
		CodeGenSnippet snippet = codeGenerator.getSnippet(element, false, false);
		appendReferenceTo(requiredClass, snippet, false);
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
	}
}