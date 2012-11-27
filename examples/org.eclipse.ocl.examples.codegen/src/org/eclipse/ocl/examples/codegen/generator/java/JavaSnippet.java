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
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalysis;
import org.eclipse.ocl.examples.codegen.generator.AbstractCodeGenSnippet;
import org.eclipse.ocl.examples.codegen.generator.AbstractCodeGenText;
import org.eclipse.ocl.examples.codegen.generator.CodeGenSnippet;
import org.eclipse.ocl.examples.codegen.generator.CodeGenText;
import org.eclipse.ocl.examples.codegen.generator.CodeGenerator;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.InvalidValue;
import org.eclipse.ocl.examples.domain.values.RealValue;
import org.eclipse.ocl.examples.domain.values.TypeValue;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueImpl;

public class JavaSnippet extends AbstractCodeGenSnippet
{
	/**
	 * Create an indented implementation of an analysis with an explicit Java implementation class.
	 */
	public JavaSnippet(@NonNull String indentation, @NonNull CodeGenAnalysis analysis, @NonNull Class<?> javaClass, int flags) {
		super(indentation, analysis, javaClass, flags);
	}

	/**
	 * Create a dummy node.
	 */
	public JavaSnippet(@NonNull String indentation, @NonNull CodeGenerator codeGenerator, int flags) {
		super(indentation, codeGenerator, flags);
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

	@Override
	protected @NonNull CodeGenSnippet createBoxedSnippet() {
		Class<?> boxedClass = codeGenerator.getBoxedClass(typeId);
		Class<?> unboxedClass = codeGenerator.getUnboxedClass(typeId);
		assert boxedClass != unboxedClass;
		@NonNull CodeGenSnippet boxedSnippet = new JavaSnippet(this, "BOXED_", boxedClass, BOXED | FINAL | NON_NULL, SUPPRESS_NON_NULL_WARNINGS | UNBOXED);
		CodeGenText text = boxedSnippet.open("");
		if (Iterable.class.isAssignableFrom(javaClass)) {
			text.append("createCollectionValue(");
			text.appendReferenceTo(typeId);
			text.append(", ");
			text.appendReferenceTo(this);
			text.append(")");
		}
		else if (IntegerValue.class.isAssignableFrom(javaClass)) {
			text.append("createIntegerValueOf(");
			text.appendReferenceTo(this);
			text.append(")");
		}
		else if (RealValue.class.isAssignableFrom(javaClass)) {
			text.append("createRealValueOf(");
			text.appendReferenceTo(this);
			text.append(")");
		}
		else {//if (ObjectValue.class.isAssignableFrom(javaClass)) {
			text.append("createObjectValue(");
			text.appendReferenceTo(typeId);
			text.append(", ");
			text.appendReferenceTo(this);
			text.append(")");
		}
		text.close();
		return boxedSnippet;
	}

	@Override
	public @NonNull CodeGenSnippet createCaughtSnippet() {
		if ((analysis != null) && analysis.mayBeException()) {
			CodeGenSnippet caughtSnippet = new JavaSnippet(this, "CAUGHT_", Object.class, CAUGHT | ERASED, FINAL | INLINE | SUPPRESS_NON_NULL_WARNINGS | THROWN);
			CodeGenText head = caughtSnippet.appendIndentedText("");
			head.appendDeclaration(caughtSnippet);
			head.append(";\n");
			//
			head.append("try {\n");
				CodeGenSnippet tryBody = caughtSnippet.appendIndentedNodes(null, 0);
//				tryBody.append("/*tryBody*/\n");
//				CodeGenSnippet tryNodes = tryBody.appendIndentedNodes("");
//				tryNodes.append("/*tryNodes*/\n");
				tryBody.appendContentsOf(this);
				CodeGenText tryBodyText = tryBody.append("");
				tryBodyText.append(caughtSnippet.getName());
				tryBodyText.append(" = ");
				tryBodyText.appendReferenceTo(this);
				tryBodyText.append(";\n");
			CodeGenText catchText = caughtSnippet.append("}\n");
			//
			catchText.append("catch (Exception e) {\n");
				CodeGenText catchBodyText = caughtSnippet.appendIndentedText(null);
				catchBodyText.append(caughtSnippet.getName());
				catchBodyText.append(" = new ");
				catchBodyText.appendClassReference(InvalidValueImpl.class);
				catchBodyText.append("(e);\n");
			caughtSnippet.append("}\n");
			return caughtSnippet;
		}
		else {
			return this;
		}
	}

	@Override
	protected @NonNull AbstractCodeGenText createCodeGenText(@NonNull String indentation) {
		return new JavaText(this, indentation);
	}

	@Override
	protected @NonNull CodeGenSnippet createFinalSnippet() {
		@NonNull CodeGenSnippet finalSnippet = new JavaSnippet(this, "FINAL_", javaClass, FINAL, INLINE | SUPPRESS_NON_NULL_WARNINGS);
		CodeGenText text = finalSnippet.open("");
		text.appendReferenceTo(this);
		text.close();
		finalSnippet.addDependsOn(this);
		return finalSnippet;
	}

	@Override
	public @NonNull CodeGenSnippet createNonNullSnippet() {
		CodeGenSnippet nonNullSnippet = new JavaSnippet(this, "", javaClass, FINAL | NON_NULL, CAUGHT | INLINE | SUPPRESS_NON_NULL_WARNINGS);
		CodeGenText text = nonNullSnippet.append("if (");
		text.appendReferenceTo(this);
		text.append(" == null) throw new ");
		text.appendClassReference(InvalidValueException.class);
		text.append("(\"\")");
		text.close();
		nonNullSnippet.addDependsOn(this);
		return nonNullSnippet;
	}

	@Override
	public @NonNull CodeGenSnippet createThrownSnippet() {
		CodeGenSnippet thrownSnippet = new JavaSnippet(this, "THROWN_", javaClass, THROWN, CAUGHT | INLINE | SUPPRESS_NON_NULL_WARNINGS);
		CodeGenText text = thrownSnippet.append("if (");
		text.appendReferenceTo(this);
		text.append(" instanceof ");
		text.appendClassReference(InvalidValue.class);
		text.append(") throw ");
		text.appendReferenceTo(InvalidValue.class, this, true);
		text.append(".getException()");
		text.close();
		thrownSnippet.addDependsOn(this);
		return thrownSnippet;
	}

	@Override
	protected @NonNull CodeGenSnippet createUnboxedSnippet() {
		Class<?> boxedClass = codeGenerator.getBoxedClass(typeId);
		Class<?> unboxedClass = codeGenerator.getUnboxedClass(typeId);
		assert boxedClass != unboxedClass;
		CodeGenSnippet unboxedSnippet = new JavaSnippet(this, "UNBOXED_", unboxedClass, FINAL | NON_NULL | UNBOXED, BOXED | SUPPRESS_NON_NULL_WARNINGS);
		CodeGenText text;
		if (CollectionValue.class.isAssignableFrom(javaClass)) {
			text = unboxedSnippet.open("");
			text.append(getName() + ".getElements()");
		}
		else if (IntegerValue.class.isAssignableFrom(javaClass)) {
			text = unboxedSnippet.open("");
			text.append(getName() + ".asNumber()");
		}
		else if (RealValue.class.isAssignableFrom(javaClass)) {
			text = unboxedSnippet.open("");
			text.append(getName() + ".asNumber()");
		}
		else if (TypeValue.class.isAssignableFrom(javaClass)) {
			text = unboxedSnippet.open("");
			text.append(getName() + ".getInstanceType()");
		}
		else {
			text = unboxedSnippet.open("");
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
		text.append(" = ");
		return text;
	}
}
