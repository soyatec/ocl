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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.common.PivotQueries;
import org.eclipse.ocl.examples.codegen.generator.AbstractCodeGenSnippet;
import org.eclipse.ocl.examples.codegen.generator.AbstractCodeGenText;
import org.eclipse.ocl.examples.codegen.generator.CodeGenSnippet;
import org.eclipse.ocl.examples.codegen.generator.CodeGenText;
import org.eclipse.ocl.examples.codegen.generator.CodeGenerator;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.RealValue;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrintOptions;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrinter;

public class JavaSnippet extends AbstractCodeGenSnippet
{
	public static class JavaText extends AbstractCodeGenText
	{ 
		public JavaText(@NonNull CodeGenSnippet snippet, @NonNull String indentation) {
			super(snippet, indentation);
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
	}

	public JavaSnippet(@NonNull CodeGenerator codeGenerator, @NonNull String indentation, @NonNull TypeId typeId, @NonNull Object... elements) {
		super(codeGenerator, indentation, typeId, elements);
	}

	public JavaSnippet(@NonNull String name, @NonNull TypeId typeId, @Nullable Class<?> javaClass, @NonNull CodeGenerator codeGenerator, @NonNull String indentation) {
		super(name, typeId, javaClass, codeGenerator, indentation);
	}

	@Override
	protected @NonNull CodeGenSnippet createBoxedSnippet() {
		@NonNull CodeGenSnippet snippet = new JavaSnippet(codeGenerator, "", typeId, elements);
		snippet.addDependsOn(this);
		Class<?> boxedClass = codeGenerator.getBoxedClass(typeId);
		String boxedClassName = codeGenerator.getImportedName(boxedClass);
		CodeGenText text = snippet.append("final " + codeGenerator.atNonNull() + " " + boxedClassName + " " + snippet.getName() + " = ");
		if (CollectionValue.class.isAssignableFrom(boxedClass)) {
			String typeIdName = getSnippetName(typeId);
			text.append("createCollectionValue(" + typeIdName + ", " + getName() + ")");
		}
		else if (IntegerValue.class.isAssignableFrom(boxedClass)) {
			text.append("createIntegerValueOf(" + getName() + ")");
		}
		else if (RealValue.class.isAssignableFrom(boxedClass)) {
			text.append("createRealValueOf(" + getName() + ")");
		}
		text.append(";\n");
		snippet.setIsFinal();
		return snippet;
	}

	@Override
	protected @NonNull AbstractCodeGenText createCodeGenText(@NonNull String indentation) {
		return new JavaText(this, indentation);
	}

	@Override
	protected @NonNull CodeGenSnippet createFinalSnippet() {
		@NonNull CodeGenSnippet snippet = new JavaSnippet(codeGenerator, "", getTypeId(), elements);
		snippet.append("CreateFinal\n");
		return snippet;
	}

	@Override
	protected @NonNull CodeGenSnippet createUnboxedSnippet() {
		@NonNull CodeGenSnippet snippet = new JavaSnippet(codeGenerator, "", getTypeId(), elements);
		snippet.append("CreateUnbox\n");
		return snippet;
	}
}
