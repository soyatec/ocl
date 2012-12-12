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


import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Set;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalysis;
import org.eclipse.ocl.examples.codegen.generator.AbstractCodeGenSnippet;
import org.eclipse.ocl.examples.codegen.generator.CodeGenSnippet;
import org.eclipse.ocl.examples.codegen.generator.CodeGenText;
import org.eclipse.ocl.examples.codegen.generator.CodeGenerator;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.EnumerationLiteralValue;
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
	protected void appendInvalidGuard(@NonNull CodeGenSnippet referredSnippet) {
		CodeGenText text = append("if (");
		text.appendReferenceTo(referredSnippet);
		text.append(" instanceof ");
		text.appendClassReference(InvalidValue.class);
		text.append(") throw ");
		text.appendReferenceTo(InvalidValue.class, referredSnippet, true);
		text.append(".getException();\n");
	}

	@Override
	protected void appendNullGuard(@NonNull CodeGenSnippet referredSnippet) {
		CodeGenText text = append("if (");
		text.appendReferenceTo(referredSnippet);
		text.append(" == null) throw ");
		text.appendReferenceTo(InvalidValue.class, referredSnippet, true);
		text.append(".getException();\n");
	}

	public @NonNull CodeGenSnippet appendText(@Nullable String indentation, @NonNull TextAppender textAppender) {
		boolean isCaught = isCaught();
		if (!isCaught) {
			CodeGenText head = appendIndentedText(indentation);
			if (!isLocal()) {
				assert !isCaught;
				codeGenerator.addDependency(CodeGenerator.GLOBAL_ROOT, this);
				head.append("private static ");
			}
			else {
				codeGenerator.addDependency(CodeGenerator.LOCAL_ROOT, this);
			}
			if (!isUnassigned()) {
				head.appendDeclaration(this);
				head.append(" = ");
			}
			textAppender.appendTo(head);
			head.append(";\n");
			return this;
		}
		else {
			CodeGenSnippet wrapper = new JavaSnippet(this, "", Object.class, CAUGHT | LOCAL, FINAL | THROWN);
			assert !isFinal();
			assert isLocal();
			codeGenerator.addDependency(CodeGenerator.LOCAL_ROOT, wrapper);
			CodeGenText head = wrapper.appendIndentedText(indentation);
			head.appendDeclaration(wrapper);
			head.append(";\n");
			//
			head.append("try {\n");
				CodeGenSnippet tryBody = wrapper.appendIndentedNodes(null, 0);
				tryBody.appendContentsOf(this);
				CodeGenText tryBodyText = tryBody.append("");
				tryBodyText.append(getName());
				tryBodyText.append(" = ");
				textAppender.appendTo(tryBodyText);
				tryBodyText.append(";\n");
			CodeGenText catchText =  wrapper.append("}\n");
			//
			catchText.append("catch (Exception e) {\n");
				CodeGenText catchBodyText =  wrapper.appendIndentedText(null);
				catchBodyText.append(getName());
				catchBodyText.append(" = new ");
				catchBodyText.appendClassReference(InvalidValueImpl.class);
				catchBodyText.append("(e);\n");
			wrapper.append("}\n");
			Set<CodeGenSnippet> dependsOn = tryBody.getDependsOn();
			if (dependsOn != null) {
				for (CodeGenSnippet cgNode : dependsOn) {
					wrapper.addDependsOn(cgNode);
				}
			}
			return wrapper;
		}
	}

	@Override
	protected @NonNull CodeGenSnippet createBoxedSnippet() {
		Class<?> boxedClass = codeGenerator.getBoxedClass(typeId);
		Class<?> unboxedClass = codeGenerator.getUnboxedClass(typeId);
		if (boxedClass == unboxedClass) {
			return this;
		}
		int setFlags = BOXED | FINAL;
		int resetFlags = UNBOXED;
		if (isNonNull()) {
			setFlags |= NON_NULL;
			resetFlags |= SUPPRESS_NON_NULL_WARNINGS;
		}
		@NonNull CodeGenSnippet boxedSnippet = new JavaSnippet(this, "BOXED_", boxedClass, setFlags, resetFlags);
		return boxedSnippet.appendText("", new TextAppender()
		{			
			public void appendTo(@NonNull CodeGenText text) {
				if (!isNonNull()) {
					text.appendReferenceTo(JavaSnippet.this);
					text.append(" == null ? null : ");
				}
				if (Iterable.class.isAssignableFrom(javaClass)) {
					text.append("createCollectionValue(");
					text.appendReferenceTo(typeId);
					text.append(", ");
					text.appendReferenceTo(JavaSnippet.this);
					text.append(")");
				}
				else if (BigInteger.class.isAssignableFrom(javaClass)
					  || Long.class.isAssignableFrom(javaClass)
					  || Integer.class.isAssignableFrom(javaClass)
					  || Short.class.isAssignableFrom(javaClass)
					  || Byte.class.isAssignableFrom(javaClass)
					  || Character.class.isAssignableFrom(javaClass)) {
					text.append("integerValueOf(");
					text.appendReferenceTo(JavaSnippet.this);
					text.append(")");
				}
				else if (BigDecimal.class.isAssignableFrom(javaClass)
						  || Double.class.isAssignableFrom(javaClass)
						  || Float.class.isAssignableFrom(javaClass)) {
					text.append("realValueOf(");
					text.appendReferenceTo(JavaSnippet.this);
					text.append(")");
				}
				else if (EEnumLiteral.class.isAssignableFrom(javaClass)) {
					text.append("createEnumerationLiteralValue(");
					text.appendReferenceTo(JavaSnippet.this);
					text.append(")");
				}
				else if (Enumerator.class.isAssignableFrom(javaClass)) {
					text.append("createEnumerationLiteralValue(");
					text.appendReferenceTo(codeGenerator.getIdResolver());
					text.append(".getEnumerationLiteral(");
					text.appendReferenceTo(typeId);
					text.append(".getEnumerationLiteralId(");
					text.appendReferenceTo(JavaSnippet.this);
					text.append(".getName()), null))");
				}
				else {//if (ObjectValue.class.isAssignableFrom(javaClass)) {
					text.append("createObjectValue(");
					text.appendReferenceTo(typeId);
					text.append(", ");
					text.appendReferenceTo(JavaSnippet.this);
					text.append(")");
				}
			}
		});
	}

/*	@Override
	public @NonNull CodeGenSnippet createCaughtSnippet() {
		if ((analysis != null) && analysis.mayBeException()) {
			CodeGenSnippet caughtSnippet = new JavaSnippet(this, "CAUGHT_", Object.class, CAUGHT | ERASED, FINAL | INLINE | SUPPRESS_NON_NULL_WARNINGS | THROWN);
			CodeGenText head = caughtSnippet.appendIndentedText("");
			head.appendDeclaration(caughtSnippet);
			head.append(";\n");
			//
			head.append("try {\n");
				CodeGenSnippet tryBody = caughtSnippet.appendIndentedNodes(null, 0);
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
	} */

	@Override
	protected @NonNull CodeGenText createCodeGenText(@NonNull String indentation) {
		return new JavaText(this, indentation);
	}

	@Override
	protected @NonNull CodeGenSnippet createFinalSnippet() {
		@NonNull CodeGenSnippet finalSnippet = new JavaSnippet(this, "FINAL_", javaClass, FINAL, INLINE | SUPPRESS_NON_NULL_WARNINGS);
		finalSnippet = finalSnippet.appendText("", new TextAppender()
		{			
			public void appendTo(@NonNull CodeGenText text) {
				text.appendReferenceTo(JavaSnippet.this);
			}
		});
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
		text.append("(\"\");\n");
		nonNullSnippet.addDependsOn(this);
		return nonNullSnippet;
	}

/*	@Override
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
	} */

	@Override
	protected @NonNull CodeGenSnippet createUnboxedSnippet() {
		final JavaSnippet boxedSnippet = this;
		final Class<?> boxedClass = codeGenerator.getBoxedClass(typeId);
		final Class<?> unboxedClass = codeGenerator.getUnboxedClass(typeId);
		assert boxedClass != unboxedClass;
		int setFlags = FINAL | LOCAL | UNBOXED;
		int resetFlags = BOXED | INLINE;
		if (isNonNull()) {
			setFlags |= NON_NULL;
			resetFlags |= SUPPRESS_NON_NULL_WARNINGS;
		}
		final CodeGenSnippet unboxedSnippet = new JavaSnippet(boxedSnippet, "UNBOXED_", unboxedClass, setFlags, resetFlags);
		final Class<?> javaClass = boxedSnippet.getJavaClass();
		return unboxedSnippet.appendText("", new TextAppender()
		{			
			public void appendTo(@NonNull CodeGenText text) {
				if (CollectionValue.class.isAssignableFrom(javaClass)) {		// FIXME if boxing is right, should always use boxedClass and optional cast
					text.append(getName() + ".getElements()");
				}
				else if (IntegerValue.class.isAssignableFrom(javaClass)) {
					text.append(getName() + ".asNumber()");
				}
				else if (RealValue.class.isAssignableFrom(javaClass)) {
					text.append(getName() + ".asNumber()");
				}
//				else if (TypeValue.class.isAssignableFrom(javaClass)) {
//					text.appendReferenceTo(codeGenerator.getEvaluatorSnippet());
//					text.append(".getInstanceType(");
//					text.append(getName());
//					text.append(")");
//				}
				else if (EnumerationLiteralValue.class.isAssignableFrom(javaClass)) {
					text.append("(");
					text.appendClassReference(EEnumLiteral.class);
					text.append(")");
					text.append(getName());
					text.append(".asEcoreObject()");
				}
				else if (TypeValue.class.isAssignableFrom(boxedClass)) {			// javaClass is probably just an Object.class parameter
					text.appendReferenceTo(codeGenerator.getEvaluatorSnippet());
//					text.append(".getInstanceType((");
//					text.appendClassReference(TypeValue.class);
//					text.append(")");
//					text.append(getName());
					text.append(".getInstanceType(");
					text.appendReferenceTo(TypeValue.class, boxedSnippet);
					text.append(")");
				}
				else {
					String typeIdName = unboxedSnippet.getSnippetName(typeId);
					text.append(getName() + ".GET_UNBOXED_VALUE(" + typeIdName + ", \"" + boxedClass.getName() + "\")");
				}
			}
		});
	}

/*	@Deprecated
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
	} */
}
