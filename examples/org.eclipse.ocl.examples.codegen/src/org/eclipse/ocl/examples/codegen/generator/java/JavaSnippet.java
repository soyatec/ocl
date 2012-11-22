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
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalysis;
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
import org.eclipse.ocl.examples.domain.values.TypeValue;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueImpl;
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

		public void appendClassReference(@NonNull Class<?> javaClass) {
			append(codeGenerator.getImportedName(javaClass));
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
				append(codeGenerator.atNonNull());
			}
			else {
				append(codeGenerator.atNullable());
			}
			append(" ");
			appendClassReference(snippet.getJavaClass());
			append(" ");
			append(snippet.getName());
		}

		public void close() {
			append(";\n");
		}
	}

	/**
	 * Create an indented implementation of an analysis with an implicit Java implementation class.
	 *
	public JavaSnippet(@NonNull String indentation, @NonNull CodeGenAnalysis analysis, int flags) {
		super(indentation, analysis, analysis.getCodeGenerator().getBoxedClass(((TypedElement) analysis.getExpression()).getTypeId()), flags);
	} */

	/**
	 * Create an indented implementation of an analysis with an explicit Java implementation class.
	 */
	public JavaSnippet(@NonNull String indentation, @NonNull CodeGenAnalysis analysis, @NonNull Class<?> javaClass, int flags) {
		super(indentation, analysis, javaClass, flags);
	}

	/**
	 * Create a dummy node.
	 */
	public JavaSnippet(@NonNull String indentation, @NonNull CodeGenerator codeGenerator) {
		super(indentation, codeGenerator);
	}

	/**
	 * Create a clone of a snippet with a given name prefix.
	 */
	public JavaSnippet(@NonNull JavaSnippet snippet, @NonNull String prefix, @NonNull Class<?> javaClass, int setFlags, int resetFlags) {
		super(snippet, prefix, javaClass, setFlags, resetFlags);
	}

	/**
	 * Create an inline implementation.
	 */
	public JavaSnippet(@NonNull String indentation, @NonNull CodeGenerator codeGenerator, @NonNull TypeId typeId, @NonNull Class<?> javaClass, @NonNull Object element, int flags) {
		super(indentation, codeGenerator, typeId, javaClass, element, flags);
	}

	public JavaSnippet(@NonNull String name, @NonNull TypeId typeId, @NonNull Class<?> javaClass, @NonNull CodeGenerator codeGenerator, @NonNull String indentation, int flags) {
		super(name, typeId, javaClass, codeGenerator, indentation, flags);
	}

	protected @NonNull CodeGenText configureGlobalDependency(@NonNull CodeGenSnippet snippet, @NonNull Class<?> boxedClass) {
		if (snippet.isLocal()) {
			return configureLocalDependency(snippet, boxedClass);
		}
		codeGenerator.addDependency(CodeGenerator.GLOBAL_ROOT, snippet);
		String atNonNull = codeGenerator.atNonNull();
		String javaClassName = codeGenerator.getImportedName(boxedClass);
		String name = snippet.getName();
		return snippet.append("private static final " + atNonNull + " " + javaClassName + " " + name + " = ");
	}

	protected @NonNull CodeGenText configureLocalDependency(@NonNull CodeGenSnippet snippet, @NonNull Class<?> boxedClass) {
		codeGenerator.addDependency(CodeGenerator.LOCAL_ROOT, snippet);
		String atNonNull = codeGenerator.atNonNull();
		String javaClassName = codeGenerator.getImportedName(boxedClass);
		String name = snippet.getName();
		return snippet.append("final " + atNonNull + " " + javaClassName + " " + name + " = ");
	}

	@Override
	protected @NonNull CodeGenSnippet createBoxedSnippet() {
		Class<?> boxedClass = codeGenerator.getBoxedClass(typeId);
		Class<?> unboxedClass = codeGenerator.getUnboxedClass(typeId);
		assert boxedClass != unboxedClass;
		@NonNull CodeGenSnippet boxedSnippet = new JavaSnippet(this, "BOXED_", boxedClass, BOXED, UNBOXED);
//		String boxedClassName = codeGenerator.getImportedName(boxedClass);
		CodeGenText text;
		if (Iterable.class.isAssignableFrom(javaClass)) {
			text = configureGlobalDependency(boxedSnippet, boxedClass);
			String typeIdName = getSnippetName(typeId);
			text.append("createCollectionValue(" + typeIdName + ", ");
//			if (!Iterable.class.isAssignableFrom(javaClass)) {
//				String listName = codeGenerator.getImportedName(Iterable.class);
//				text.append("(" + listName + "<?>)");
//			}
			text.append(getName() + ")");
		}
/*		else if (CollectionValue.class.isAssignableFrom(javaClass)) {
			text = configureGlobalDependency(boxedSnippet, boxedClass);
			String typeIdName = getSnippetName(typeId);
			text.append("createCollectionValue(" + typeIdName + ", ");
			if (!List.class.isAssignableFrom(javaClass)) {
				String listName = codeGenerator.getImportedName(List.class);
				text.append("(" + listName + "<?>)");
			}
			text.append(getName() + ")");
		} */
		else if (IntegerValue.class.isAssignableFrom(javaClass)) {
			text = configureGlobalDependency(boxedSnippet, boxedClass);
			text.append("createIntegerValueOf(" + getName() + ")");
		}
		else if (RealValue.class.isAssignableFrom(javaClass)) {
			text = configureGlobalDependency(boxedSnippet, boxedClass);
			text.append("createRealValueOf(" + getName() + ")");
		}
		else {//if (ObjectValue.class.isAssignableFrom(javaClass)) {
			text = configureGlobalDependency(boxedSnippet, boxedClass);
			String typeIdName = getSnippetName(typeId);
			text.append("createObjectValue(" + typeIdName + ", " + getName() + ")");
		}
		text.append(";\n");
		return boxedSnippet;
	}

	@Override
	public @NonNull CodeGenSnippet createCaughtSnippet() {
		CodeGenSnippet caughtSnippet = new JavaSnippet(this, "CAUGHT_", javaClass, CAUGHT, THROWN);
		CodeGenSnippet referencedSnippet = getBoxedSnippet();
		String innerName = referencedSnippet.getName();
		String outerName = "TRY_" + innerName;
		if ((analysis != null) && analysis.mayBeException()) {
			CodeGenText head = caughtSnippet.appendIndentedText("");
			head.append("Object " + outerName + ";\n");
			head.append("try {\n");
			CodeGenSnippet tryBody = caughtSnippet.appendIndentedNodes(null);
			tryBody.append("/*tryBody*/\n");
			CodeGenSnippet tryNodes = tryBody.appendIndentedNodes("");
			tryNodes.append("/*tryNodes*/\n");
			tryBody.appendContentsOf(referencedSnippet);
//			nestedSnippet.addDependsOn(tryNodes);
			tryBody.append(outerName + " = " + innerName + ";\n");
			CodeGenText catchText = caughtSnippet.append("}\n");
			catchText.append("catch (Exception e) {\n");
			CodeGenText catchBody = caughtSnippet.appendIndentedText(null);
			catchBody.append(outerName + " = new " + codeGenerator.getImportedName(InvalidValueImpl.class) + "(e);\n");
			CodeGenText tail = caughtSnippet.append("}\n");
			tail.append("final Object " + innerName + " = " + outerName + ";\n");
		}
		else {
			caughtSnippet.addDependsOn(referencedSnippet);
		}
		return caughtSnippet;
	}

	@Override
	protected @NonNull AbstractCodeGenText createCodeGenText(@NonNull String indentation) {
		return new JavaText(this, indentation);
	}

	@Override
	protected @NonNull CodeGenSnippet createFinalSnippet() {
		@NonNull CodeGenSnippet finalSnippet = new JavaSnippet(this, "FINAL_", javaClass, FINAL, 0);
		finalSnippet.append("CreateFinal\n");
		return finalSnippet;
	}

	@Override
	protected @NonNull CodeGenSnippet createUnboxedSnippet() {
		Class<?> boxedClass = codeGenerator.getBoxedClass(typeId);
		Class<?> unboxedClass = codeGenerator.getUnboxedClass(typeId);
		assert boxedClass != unboxedClass;
		CodeGenSnippet unboxedSnippet = new JavaSnippet(this, "UNBOXED_", unboxedClass, UNBOXED | FINAL, BOXED);
		CodeGenText text;
		if (CollectionValue.class.isAssignableFrom(javaClass)) {
			text = configureGlobalDependency(unboxedSnippet, unboxedClass);
			text.append(getName() + ".getElements()");
		}
		else if (IntegerValue.class.isAssignableFrom(javaClass)) {
			text = configureGlobalDependency(unboxedSnippet, unboxedClass);
			text.append(getName() + ".asNumber()");
		}
		else if (RealValue.class.isAssignableFrom(javaClass)) {
			text = configureGlobalDependency(unboxedSnippet, unboxedClass);
			text.append(getName() + ".asNumber()");
		}
		else if (TypeValue.class.isAssignableFrom(javaClass)) {
			text = configureGlobalDependency(unboxedSnippet, unboxedClass);
			text.append(getName() + ".getInstanceType()");
		}
		else {//if (ObjectValue.class.isAssignableFrom(javaClass)) {
			text = configureGlobalDependency(unboxedSnippet, unboxedClass);
			String typeIdName = getSnippetName(typeId);
			text.append(getName() + ".GET_UNBOXED_VALUE(" + typeIdName + ", " + javaClass.getName() + ")");
		}
		text.append(";\n");
		return unboxedSnippet;
	}

	public @NonNull CodeGenText open(@Nullable String indentation) {
		CodeGenText text = appendIndentedText(indentation);
		if (!isLocal()) {
			codeGenerator.addDependency(CodeGenerator.GLOBAL_ROOT, this);
			text.append("private static ");
		}
		else {
			codeGenerator.addDependency(CodeGenerator.LOCAL_ROOT, this);
		}
		text.appendDeclaration(this);
/*		if (isFinal()) {
			text.append("final ");
		}
		if (isNonNull()) {
			text.append(codeGenerator.atNonNull());
			text.append(" ");
		}
		text.appendClassReference(javaClass);
		text.append(" ");
		text.append(getName()); */
		text.append(" = ");
		return text;
	}
}
