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

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalysis;
import org.eclipse.ocl.examples.codegen.generator.AbstractCodeGenSnippet;
import org.eclipse.ocl.examples.codegen.generator.CodeGenLabel;
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

	public void appendInvalidGuard(@NonNull CodeGenSnippet referredSnippet) {
		if (referredSnippet.isCaught() /*|| referredSnippet.isThrown()*/) {
			Class<?> referredJavaClass = referredSnippet.getJavaClass();
			if (referredJavaClass == Object.class) { 
				CodeGenText text = append("if (");
				text.appendReferenceTo(referredSnippet);
				text.append(" instanceof ");
				text.appendClassReference(InvalidValue.class);
				text.append(") throw ");
				text.appendReferenceTo(InvalidValue.class, referredSnippet, true);
				text.append(".getException();\n");
			}
			else if (InvalidValue.class.isAssignableFrom(referredJavaClass)) { 
				CodeGenText text = append("throw ");
				text.appendReferenceTo(InvalidValue.class, referredSnippet, true);
				text.append(".getException();\n");
			}
		}
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
		if (!isCaught()) {			
			textAppender.appendAtHead(this);
			CodeGenText head = appendIndentedText(indentation);
			if (!isUnassigned()) {
				if (!isLocal()) {
					assert isFinal();
					assert !isThrown();
					codeGenerator.addDependency(CodeGenerator.GLOBAL_ROOT, this);
//					head.append("private static ");
				}
				else if (!isThrown()) {
					assert isFinal();
					codeGenerator.addDependency(CodeGenerator.LOCAL_ROOT, this);
				}
				else {
					assert isFinal();
//					codeGenerator.addDependency(CodeGenerator.SCOPE_ROOT, this);
				}
				head.appendDeclaration(this);
				head.append(" = ");
			}
			textAppender.appendToBody(head);
			head.append(";\n");
			return this;
		}
		else {
			CodeGenSnippet wrapper = new JavaSnippet(this, "", Object.class, CAUGHT | LOCAL, FINAL | THROWN);
			assert !isFinal();
			assert isLocal();
			CodeGenLabel scopeLabel = codeGenerator.getSnippetLabel(CodeGenerator.SCOPE_ROOT);
//			codeGenerator.addDependency(CodeGenerator.SCOPE_ROOT, wrapper);
			CodeGenText head = wrapper.appendIndentedText(indentation);
			head.appendDeclaration(wrapper);
			head.append(";\n");
			//
			head.append("try {\n");
				CodeGenSnippet tryBody = wrapper.appendIndentedNodes(null, 0);
				scopeLabel.push(tryBody);
				textAppender.appendAtHead(tryBody);
				tryBody.appendContentsOf(this);
				CodeGenText tryBodyText = tryBody.append("");
				tryBodyText.append(getName());
				tryBodyText.append(" = ");
				textAppender.appendToBody(tryBodyText);
				tryBodyText.append(";\n");
				scopeLabel.pop();
			CodeGenText catchText = wrapper.append("} catch (Exception e) { ");
			catchText.append(getName());
			catchText.append(" = createInvalidValue(e); }\n");
			//
			//	Promote internal dependencies to avoid excessively local placement 
			//
			Iterable<CodeGenSnippet> dependsOn = tryBody.getDependsOn();
			if (dependsOn != null) {
				for (/*@NonNull*/ CodeGenSnippet cgNode : dependsOn) {
					if ((cgNode != null) && cgNode.isCaught()) {
						wrapper.addDependsOn(cgNode);
					}
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
		return boxedSnippet.appendText("", new AbstractTextAppender()
		{			
			public void appendToBody(@NonNull CodeGenText text) {
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

	@Override
	protected @NonNull CodeGenText createCodeGenText(@NonNull String indentation) {
		return new JavaText(this, indentation);
	}

	@Override
	protected @NonNull CodeGenSnippet createFinalSnippet() {
		@NonNull CodeGenSnippet finalSnippet = new JavaSnippet(this, "FINAL_", javaClass, FINAL, INLINE | SUPPRESS_NON_NULL_WARNINGS);
		finalSnippet = finalSnippet.appendText("", new AbstractTextAppender()
		{			
			public void appendToBody(@NonNull CodeGenText text) {
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

	@Override
	protected @NonNull CodeGenSnippet createUnboxedSnippet() {
		final JavaSnippet boxedSnippet = this;
		final Class<?> boxedClass = codeGenerator.getBoxedClass(typeId);
		Class<?> unboxedClass = codeGenerator.getUnboxedClass(typeId);
		assert boxedClass != unboxedClass;
		int setFlags = FINAL | LOCAL | UNBOXED;
		int resetFlags = BOXED | INLINE;
		if (isNonNull()) {
			setFlags |= NON_NULL;
			resetFlags |= SUPPRESS_NON_NULL_WARNINGS;
		}
		final CodeGenSnippet unboxedSnippet = new JavaSnippet(boxedSnippet, "UNBOXED_", unboxedClass, setFlags, resetFlags);
		return unboxedSnippet.appendText("", new AbstractTextAppender()
		{			
			public void appendToBody(@NonNull CodeGenText text) {
				if (CollectionValue.class.isAssignableFrom(boxedClass)) {
					text.appendReferenceTo(CollectionValue.class, boxedSnippet, true);
					text.append(".getElements()");
				}
				else if (IntegerValue.class.isAssignableFrom(boxedClass)) {
					text.appendReferenceTo(IntegerValue.class, boxedSnippet, true);
					text.append(".asNumber()");
				}
				else if (RealValue.class.isAssignableFrom(boxedClass)) {
					text.appendReferenceTo(RealValue.class, boxedSnippet, true);
					text.append(".asNumber()");
				}
				else if (EnumerationLiteralValue.class.isAssignableFrom(boxedClass)) {
					text.append("(");
					text.appendClassReference(EEnumLiteral.class);
					text.append(")");
					text.appendReferenceTo(EnumerationLiteralValue.class, boxedSnippet, true);
					text.append(".asEcoreObject()");
				}
				else if (TypeValue.class.isAssignableFrom(boxedClass)) {
//					text.appendReferenceTo(codeGenerator.getEvaluatorSnippet());
//					text.append(".getInstanceType(");
//					text.appendReferenceTo(TypeValue.class, boxedSnippet);
//					text.append(")");
					text.append("((");		// FIXME make type boxing deterministic
					text.appendReferenceTo(boxedSnippet);
					text.append(" instanceof ");
					text.appendClassReference(TypeValue.class);
					text.append(") ? ");
					text.appendReferenceTo(codeGenerator.getEvaluatorSnippet());
					text.append(".getInstanceType(");
					text.appendReferenceTo(TypeValue.class, boxedSnippet);
					text.append(") : ");
					text.appendReferenceTo(DomainType.class, boxedSnippet);
					text.append(")");
				}
				else {
					String typeIdName = unboxedSnippet.getSnippetName(typeId);
					text.append(getName() + ".GET_UNBOXED_VALUE(" + typeIdName + ", \"" + boxedClass.getName() + "\")");
				}
			}
		});
	}
}
