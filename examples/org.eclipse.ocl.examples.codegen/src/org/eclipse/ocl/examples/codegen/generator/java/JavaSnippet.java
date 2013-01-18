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
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.messages.DomainMessage;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.EnumerationLiteralValue;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.RealValue;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;

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
	public JavaSnippet(@NonNull String indentation, @NonNull CodeGenerator codeGenerator, @NonNull TypeId typeId, @NonNull Class<?> javaClass, @Nullable Object element, int flags) {
		super(indentation, codeGenerator, typeId, javaClass, element, flags);
	}

/*	public JavaSnippet(@NonNull String name, @Nullable TypeId typeId, @NonNull Class<?> javaClass, @NonNull CodeGenerator codeGenerator, @NonNull String indentation, int flags) {
		super(name, typeId, javaClass, codeGenerator, indentation, flags);
	} */

	public JavaSnippet(@NonNull String name, @Nullable TypeId typeId, @NonNull Class<?> javaClass, @NonNull CodeGenerator codeGenerator, @NonNull String indentation, int flags) {
		super(name, typeId, javaClass, null, codeGenerator, indentation, flags);
		assert !isConstant();
	}

	public JavaSnippet(@NonNull String name, @Nullable TypeId typeId, @NonNull Class<?> javaClass, @Nullable Object constantValue, @NonNull CodeGenerator codeGenerator, @NonNull String indentation, int flags) {
		super(name, typeId, javaClass, constantValue, codeGenerator, indentation, flags);
//		assert isConstant();
	}

	public boolean appendInvalidGuard(@NonNull CodeGenSnippet referredSnippet, @NonNull DomainMessage message) {
//		if (referredSnippet.isInvalid() && !referredSnippet.isCaught() && !referredSnippet.isInline()) {
//			return false;			// Already thrown.
//		}
		if (!referredSnippet.isCaught()) {
			if (referredSnippet.isInvalid() && !referredSnippet.isInline()) {
				return false;		// Already thrown.
			}
			return true;			// Any exception already thrown
		}
		boolean returns = true;
		CodeGenText text = append("");
		if (!referredSnippet.isNonInvalid()) {
			Class<?> referredJavaClass = referredSnippet.getJavaClass();
			boolean isSubInvalidValueException = InvalidValueException.class.isAssignableFrom(referredJavaClass);
			boolean isSuperInvalidValueException = referredJavaClass.isAssignableFrom(InvalidValueException.class);
			if (isSubInvalidValueException || isSuperInvalidValueException) {
				if (/*!referredSnippet.isInvalid() ||*/ !isSubInvalidValueException) {
					text.append("if (");
					text.appendReferenceTo(null, referredSnippet);
					text.append(" instanceof ");
					text.appendClassReference(InvalidValueException.class);
					text.append(") ");
				}
				else {
					returns = false;
					setInvalid();
				}
				text.append("throw ");
				text.appendReferenceTo(InvalidValueException.class, referredSnippet);
				text.append(";\n");
			}
		}
		return returns;
	}

	public boolean appendNullGuard(@NonNull CodeGenSnippet referredSnippet, @NonNull DomainMessage message) {
		if (referredSnippet.isNonNull()) {
			return true;
		}
		boolean returns = true;
		CodeGenText text = append("");
		if (!referredSnippet.isNull()) {
			text.append("if (");
			text.appendReferenceTo(null, referredSnippet);
			text.append(" == null) ");
		}
		else {
			returns = false;
			setInvalid();
		}
		text.append("throw new ");
		text.appendClassReference(InvalidValueException.class);
		text.append("(");
		text.appendString(message.getTemplate());
		for (Object binding : message.getBindings()) {
			text.append(", ");
			@SuppressWarnings("null")@NonNull String string = String.valueOf(binding);
			text.appendString(string);
		}
		text.append(");\n");
		return returns;
	}

	public @NonNull CodeGenSnippet appendText(@Nullable String indentation, @NonNull TextAppender textAppender) {
//		assert contentsIsEmpty();
		if (!isCaught() || isInvalid()) {			
			if (textAppender.appendAtHead(this)) {
				CodeGenText head = appendIndentedText(indentation);
				if (!isUnassigned()) {
					if (isGlobal()) {
						assert isFinal();
						assert !isThrown();
						codeGenerator.addGlobalSnippet(this);
	//					head.append("private static ");
					}
					else if (!isThrown()) {
						assert isFinal();
						codeGenerator.addDependency(CodeGenerator.LOCAL_ROOT, this);
					}
					else {
	//					assert isFinal();
	//					codeGenerator.addDependency(CodeGenerator.SCOPE_ROOT, this);
					}
					head.appendDeclaration(this);
					head.append(" = ");
				}
				textAppender.appendToBody(head);
				head.append(";\n");
				textAppender.appendAtTail(this);
			}
			return this;
		}
		else {
			CodeGenSnippet wrapper = new JavaSnippet(this, "", Object.class, CAUGHT | MUTABLE, GLOBAL | THROWN | UNASSIGNED);
			assert !isFinal();
			assert !isGlobal();
			CodeGenLabel scopeLabel = codeGenerator.getSnippetLabel(CodeGenerator.SCOPE_ROOT);
//			codeGenerator.addDependency(CodeGenerator.SCOPE_ROOT, wrapper);
			CodeGenText head = wrapper.appendIndentedText(indentation);
			head.appendDeclaration(wrapper);
			head.append(";\n");
			//
			head.append("try {\n");
				CodeGenSnippet tryBody = wrapper.appendIndentedNodes(null, CodeGenSnippet.UNASSIGNED);
				scopeLabel.push(tryBody);
				tryBody.appendContentsOf(this);
				textAppender.appendAtHead(tryBody);
//				tryBody.appendContentsOf(this);
				CodeGenText tryBodyText = tryBody.append("");
				if (!isUnassigned()) {
					tryBodyText.append(getName());
					tryBodyText.append(" = ");
					textAppender.appendToBody(tryBodyText);
				}
				tryBodyText.append(";\n");
				textAppender.appendAtTail(tryBody);
				scopeLabel.pop();
			CodeGenText catchText = wrapper.append("} catch (");
			String exceptionName = codeGenerator.getNameManager().getSymbolName(catchText, "e");
			catchText.appendClassReference(Exception.class);
			catchText.append(" " + exceptionName + ") { ");
			catchText.append(getName());
			catchText.append(" = ");
			catchText.appendClassReference(ValuesUtil.class);
			catchText.append(".createInvalidValue(" + exceptionName + "); }\n");
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
		Class<?> boxedClass = getBoxedClass();
		Class<?> unboxedClass = getUnboxedClass();
		if (boxedClass == unboxedClass) {
			return this;
		}
		int setFlags = BOXED;
		int resetFlags = MUTABLE | UNBOXED;
		if (isNonNull()) {
			setFlags |= NON_NULL;
			resetFlags |= SUPPRESS_NON_NULL_WARNINGS;
		}
		@NonNull CodeGenSnippet boxedSnippet = new JavaSnippet(this, "BOXED_", boxedClass, setFlags, resetFlags);
		return boxedSnippet.appendText("", new AbstractTextAppender()
		{			
			@Override
			public void appendToBody(@NonNull CodeGenText text) {
				if (!isNonNull()) {
					text.appendReferenceTo(null, JavaSnippet.this);
					text.append(" == null ? null : ");
				}
				@NonNull TypeId typeId2 = DomainUtil.nonNullState(typeId);
				if (Iterable.class.isAssignableFrom(javaClass)) {
					@NonNull String collectionName = "Collection";
					if (typeId2 instanceof CollectionTypeId) {
						collectionName = ((CollectionTypeId)typeId2).getGeneralizedId().getName();
					}
					text.appendReferenceTo(null, codeGenerator.getIdResolver());
					text.append(".create" + collectionName + "ValueOf(");
					text.appendReferenceTo(typeId2);
					text.append(", ");
					text.appendReferenceTo(null, JavaSnippet.this);
					text.append(")");
				}
				else if (BigInteger.class.isAssignableFrom(javaClass)
					  || Long.class.isAssignableFrom(javaClass)
					  || Integer.class.isAssignableFrom(javaClass)
					  || Short.class.isAssignableFrom(javaClass)
					  || Byte.class.isAssignableFrom(javaClass)
					  || Character.class.isAssignableFrom(javaClass)) {
					text.appendClassReference(ValuesUtil.class);
					text.append(".integerValueOf(");
					text.appendReferenceTo(null, JavaSnippet.this);
					text.append(")");
				}
				else if (BigDecimal.class.isAssignableFrom(javaClass)
					  || Double.class.isAssignableFrom(javaClass)
					  || Float.class.isAssignableFrom(javaClass)) {
					text.appendClassReference(ValuesUtil.class);
					text.append(".realValueOf(");
					text.appendReferenceTo(null, JavaSnippet.this);
					text.append(")");
				}
				else if (EEnumLiteral.class.isAssignableFrom(javaClass)) {
					text.appendClassReference(ValuesUtil.class);
					text.append(".createEnumerationLiteralValue(");
					text.appendReferenceTo(null, JavaSnippet.this);
					text.append(")");
				}
				else if (Enumerator.class.isAssignableFrom(javaClass)) {
					text.appendClassReference(ValuesUtil.class);
					text.append(".createEnumerationLiteralValue(");
					text.appendReferenceTo(null, codeGenerator.getIdResolver());
					text.append(".getEnumerationLiteral(");
					text.appendReferenceTo(typeId2);
					text.append(".getEnumerationLiteralId(");
					text.appendReferenceTo(null, JavaSnippet.this);
					text.append(".getName()), null))");
				}
				else {//if (ObjectValue.class.isAssignableFrom(javaClass)) {
					text.appendClassReference(ValuesUtil.class);
					text.append(".createObjectValue(");
					text.appendReferenceTo(typeId2);
					text.append(", ");
					text.appendReferenceTo(null, JavaSnippet.this);
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
		@NonNull CodeGenSnippet finalSnippet = new JavaSnippet(this, "FINAL_", javaClass, 0, INLINE | MUTABLE | SUPPRESS_NON_NULL_WARNINGS);
		finalSnippet = finalSnippet.appendText("", new AbstractTextAppender()
		{			
			@Override
			public void appendToBody(@NonNull CodeGenText text) {
				text.appendReferenceTo(null, JavaSnippet.this);
			}
		});
		finalSnippet.addDependsOn(this);
		return finalSnippet;
	}

	@Override
	public @NonNull CodeGenSnippet createNonNullSnippet() {
		CodeGenSnippet nonNullSnippet = new JavaSnippet(this, "", javaClass, NON_NULL, CAUGHT | INLINE | MUTABLE | SUPPRESS_NON_NULL_WARNINGS);
		CodeGenText text = nonNullSnippet.append("if (");
		text.appendReferenceTo(null, this);
		text.append(" == null) throw new ");
		text.appendClassReference(InvalidValueException.class);
		text.append("(\"\");\n");
		nonNullSnippet.addDependsOn(this);
		return nonNullSnippet;
	}

	@Override
	protected @NonNull CodeGenSnippet createUnboxedSnippet() {
		final JavaSnippet boxedSnippet = this;
		final Class<?> boxedClass = getBoxedClass();
		Class<?> unboxedClass = getUnboxedClass();
		assert boxedClass != unboxedClass;
		int setFlags = UNBOXED;
		int resetFlags = BOXED | GLOBAL | INLINE | MUTABLE;
		if (isNonNull()) {
			setFlags |= NON_NULL;
			resetFlags |= SUPPRESS_NON_NULL_WARNINGS;
		}
		final CodeGenSnippet unboxedSnippet = new JavaSnippet(boxedSnippet, "UNBOXED_", unboxedClass, setFlags, resetFlags);
		return unboxedSnippet.appendText("", new AbstractTextAppender()
		{			
			@Override
			public void appendToBody(@NonNull CodeGenText text) {
				if (CollectionValue.class.isAssignableFrom(boxedClass)) {
					text.appendAtomicReferenceTo(CollectionValue.class, boxedSnippet);
					text.append(".asEcoreObject()");
				}
				else if (IntegerValue.class.isAssignableFrom(boxedClass)) {
					text.appendAtomicReferenceTo(IntegerValue.class, boxedSnippet);
					text.append(".asNumber()");
				}
				else if (RealValue.class.isAssignableFrom(boxedClass)) {
					text.appendAtomicReferenceTo(RealValue.class, boxedSnippet);
					text.append(".asNumber()");
				}
				else if (EnumerationLiteralValue.class.isAssignableFrom(boxedClass)) {
					text.append("(");
					text.appendClassReference(EEnumLiteral.class);
					text.append(")");
					text.appendAtomicReferenceTo(EnumerationLiteralValue.class, boxedSnippet);
					text.append(".asEcoreObject()");
				}
				else {
					String typeIdName = unboxedSnippet.getSnippetName(typeId);
					text.append(getName() + ".GET_UNBOXED_VALUE(" + typeIdName + ", \"" + boxedClass.getName() + "\")");
				}
			}
		});
	}
}
