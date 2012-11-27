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
package org.eclipse.ocl.examples.codegen.generator.java;

import java.lang.reflect.TypeVariable;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.common.PivotQueries;
import org.eclipse.ocl.examples.codegen.generator.AbstractCodeGenText;
import org.eclipse.ocl.examples.codegen.generator.CodeGenSnippet;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrintOptions;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrinter;
import org.eclipse.xtext.util.Strings;

public class JavaText extends AbstractCodeGenText
{ 
	public JavaText(@NonNull CodeGenSnippet snippet, @NonNull String indentation) {
		super(snippet, indentation);
	}

	public void appendClassReference(@NonNull Class<?> javaClass) {
		append(snippet.getImportedName(javaClass));
		TypeVariable<?>[] typeParameters = javaClass.getTypeParameters();
		if (typeParameters.length > 0) {
			append("<");
			for (int i = 0; i < typeParameters.length; i++) {
				if (i != 0) {
					append(",");
				}
				append("?");
			}
			append(">");
		}
	}

	public void appendCommentWithOCL(@Nullable String title, @NonNull Element element) {
		String combinedIndentation = indentation + " * ";
		append("/**\n");
		if (title != null) {
			appendWithIndentation(title + "\n", combinedIndentation);
		}
		PrettyPrintOptions.Global createOptions = PivotQueries.createOptions(element);
		appendWithIndentation(PrettyPrinter.print(element, createOptions) + "\n", combinedIndentation);
		append(" */\n");
	}
	
	public void appendDeclaration(@NonNull CodeGenSnippet snippet) {
		if (snippet.isFinal()) {
			append("final ");
		}
		if (snippet.isNonNull()) {
			if (snippet.isSuppressNonNullWarnings()) {
				append("@SuppressWarnings(\"null\")");
			}
			append(snippet.atNonNull());
		}
		else {
			append(snippet.atNullable());
		}
		append(" ");
		appendClassReference(snippet.getJavaClass());
		append(" ");
		append(snippet.getName());
	}

	public void appendString(@NonNull String string) {
		@SuppressWarnings("null")@NonNull String javaString = Strings.convertToJavaString(string);
		append("\"");
		append(javaString);
		append("\"");
	}
	
	public void close() {
		append(";\n");
	}
}