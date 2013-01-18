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
import org.eclipse.ocl.examples.domain.ids.ClassId;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.ElementId;
import org.eclipse.ocl.examples.domain.ids.EnumerationId;
import org.eclipse.ocl.examples.domain.ids.EnumerationLiteralId;
import org.eclipse.ocl.examples.domain.ids.MetaclassId;
import org.eclipse.ocl.examples.domain.ids.PackageId;
import org.eclipse.ocl.examples.domain.ids.PropertyId;
import org.eclipse.ocl.examples.domain.values.InvalidValue;
import org.eclipse.ocl.examples.domain.values.RealValue;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;

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

	public void appendAtomicReferenceTo(@Nullable Class<?> requiredClass, @NonNull CodeGenSnippet referredSnippet) {
		appendReferenceTo(requiredClass, referredSnippet, true);
	}

	public void appendEvaluatorReference() {
//		codeGenerator.addDependency(CodeGenerator.LOCAL_ROOT, snippet);
//		append(codeGenerator.getEvaluatorName());
		appendReferenceTo(null, codeGenerator.getEvaluatorSnippet(snippet));
	}

	@Override
	public void appendException(@NonNull Exception e) {
		super.appendException(e);
		append("<<" + e.getClass().getSimpleName() + ">>");
	}

	public void appendReferenceTo(@NonNull ElementId elementId) {
//		appendScope(elementId);
		appendReferenceTo(null, codeGenerator.getSnippet(elementId));
	}

//	public void appendReferenceTo(@NonNull CodeGenSnippet s) {
//		snippet.addDependsOn(s);
//		append(s.getName());
//	}

	public void appendReferenceTo(@Nullable Class<?> requiredClass, @NonNull CodeGenSnippet referredSnippet) {
		appendReferenceTo(requiredClass, referredSnippet, false);
	}

	protected void appendReferenceTo(@Nullable Class<?> requiredClass, @NonNull CodeGenSnippet referredSnippet, boolean isAtomic) {
		if (referredSnippet.isSynthesized()) {
			assert referredSnippet.getParent() == null;
			if (referredSnippet.isCaught()) {
				codeGenerator.addDependency(CodeGenerator.LOCAL_ROOT, referredSnippet);
			}
			else if (referredSnippet.isThrown()) {
				codeGenerator.addDependency(CodeGenerator.SCOPE_ROOT, referredSnippet);
			}
			snippet.addDependsOn(referredSnippet);			// Redundant ancestral dependencies are pruned by gatherLiveSnippets
		}
		else if (referredSnippet.isGlobal()){
			snippet.addDependsOn(referredSnippet);			// Redundant ancestral dependencies are pruned by gatherLiveSnippets
		}
		else if (!referredSnippet.isInline()){
// Let vars not contained when inSnippet created			assert (referredSnippet.getParent() != null);
		}
		Class<?> actualClass = referredSnippet.getJavaClass();
		boolean needsCast = (requiredClass != null) && !requiredClass.isAssignableFrom(actualClass) && !referredSnippet.isNull();
		if (needsCast) {
			if (isAtomic) {
				append("(");
			}
			append("(");
			assert requiredClass != null;
			appendClassReference(requiredClass);
			append(")");
			if (referredSnippet.isGlobal()) {
				appendScope(referredSnippet.getConstantValue());
			}
			appendScope(referredSnippet);
			append(referredSnippet.getName());
			if (isAtomic) {
				append(")");
			}
		}
		else {
			if (referredSnippet.isGlobal()) {
				appendScope(referredSnippet.getConstantValue());
			}
			append(referredSnippet.getName());
		}
	}

	public void appendResultCast(Class<?> actualClass, @NonNull Class<?> requiredClass, String className) {
		if ((actualClass == null) || !requiredClass.isAssignableFrom(actualClass)) {
//			String actualClassName = actualClass != null ? actualClass.getName() : "<unknown-class>";
//			System.out.println("Cast from " + actualClassName + " to " + requiredClass.getName() + " needed for " + className);
			append("(");
			appendClassReference(requiredClass);
			append(")");
		}
	}

	protected void appendScope(Object value) {
		if ((value instanceof RealValue)
		 || (value instanceof String)
		 || (value instanceof ClassId)
		 || (value instanceof CollectionTypeId)
		 || (value instanceof EnumerationId)
		 || (value instanceof EnumerationLiteralId)
		 || (value instanceof MetaclassId)
		 || (value instanceof PackageId)
		 || (value instanceof PropertyId)) {
			String constantsClass = codeGenerator.getConstantsClass();
			if (constantsClass !=  null) {
				appendClassReference(constantsClass);
				append(".");
			}
		}
		else if ((value instanceof Boolean)
		 || (value instanceof InvalidValue)) {
			appendClassReference(ValuesUtil.class);
			append(".");
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
	}
}