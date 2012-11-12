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
import java.util.Collection;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.generator.CodeGenSnippet;
import org.eclipse.ocl.examples.codegen.generator.CodeGenText;
import org.eclipse.ocl.examples.codegen.generator.CodeGenerator;
import org.eclipse.ocl.examples.codegen.generator.ConstantHelper;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.ids.TupleTypeId;
import org.eclipse.ocl.examples.domain.values.BagValue;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.EnumerationLiteralValue;
import org.eclipse.ocl.examples.domain.values.IntegerRange;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.InvalidValue;
import org.eclipse.ocl.examples.domain.values.NumericValue;
import org.eclipse.ocl.examples.domain.values.OrderedSetValue;
import org.eclipse.ocl.examples.domain.values.RealValue;
import org.eclipse.ocl.examples.domain.values.SequenceValue;
import org.eclipse.ocl.examples.domain.values.SetValue;
import org.eclipse.ocl.examples.domain.values.TupleValue;
import org.eclipse.ocl.examples.domain.values.TypeValue;
import org.eclipse.ocl.examples.domain.values.Unlimited;
import org.eclipse.ocl.examples.domain.values.UnlimitedValue;
import org.eclipse.ocl.examples.domain.values.impl.IntIntegerValueImpl;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueImpl;
import org.eclipse.ocl.examples.domain.values.impl.LongIntegerValueImpl;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.xtext.util.Strings;

/**
 * A ConstantHelper provides textual representations of constant values.
 */
public class JavaConstantHelper implements ConstantHelper
{
	protected final @NonNull CodeGenerator codeGenerator;
	
	public JavaConstantHelper(@NonNull CodeGenerator codeGenerator) {
		this.codeGenerator = codeGenerator;
	}

	protected @NonNull CodeGenText configureLocalDependency(@NonNull CodeGenSnippet snippet, @NonNull Class<?> javaClass) {
		snippet.setIsLocal();
		snippet.setJavaClass(javaClass);
		codeGenerator.addDependency(CodeGenerator.LOCAL_ROOT, snippet);
		String atNonNull = codeGenerator.atNonNull();
		String javaClassName = snippet.getJavaClassName();
		String name = snippet.getName();
		return snippet.append("final " + atNonNull + " " + javaClassName + " " + name + " = ");
	}

	protected @NonNull CodeGenText configureGlobalDependency(@NonNull CodeGenSnippet snippet, @NonNull Class<?> javaClass) {
		snippet.setIsStatic();
		snippet.setJavaClass(javaClass);
		codeGenerator.addDependency(CodeGenerator.GLOBAL_ROOT, snippet);
		String atNonNull = codeGenerator.atNonNull();
		String javaClassName = snippet.getJavaClassName();
		String name = snippet.getName();
		return snippet.append("private static final " + atNonNull + " " + javaClassName + " " + name + " = ");
	}

	public @NonNull CodeGenSnippet createSnippet(@Nullable Object anObject) {
		CodeGenSnippet snippet;
		if (anObject == null) {
			snippet = new JavaSnippet("null", null, codeGenerator, "");
			snippet.setIsInlined();
			snippet.setIsStatic();
		}
		else if (anObject instanceof Boolean) {
			snippet = new JavaSnippet(((Boolean)anObject).booleanValue() ? "Boolean.TRUE" : "Boolean.FALSE", Boolean.class, codeGenerator, "");
			snippet.setIsInlined();
			snippet.setIsStatic();
		}
		else if (anObject == ValuesUtil.UNLIMITED_VALUE) {
			snippet = new JavaSnippet("UNLIMITED_VALUE", UnlimitedValue.class, codeGenerator, "");
			snippet.setIsInlined();
			snippet.setIsStatic();
		}
		else if (anObject instanceof InvalidValue) {
			String text;
			InvalidValueException exception = ((InvalidValue)anObject).getException();
			if (exception == ValuesUtil.INVALID_VALUE.getException()) {
				text = "INVALID_VALUE";
			}
			else {
				text = "new " + codeGenerator.getImportedName(InvalidValueImpl.class) + "(" + Strings.convertToJavaString(exception.getMessage()) + ")";
			}
			snippet = new JavaSnippet(text, InvalidValue.class, codeGenerator, "");
			snippet.setIsInlined();
			snippet.setIsStatic();
		}
		else {
			snippet = new JavaSnippet(codeGenerator, "", anObject);
			CodeGenText cgText = getNonInlineValueAndType(snippet, anObject);			// Type is set on snippet as a side-effect
			cgText.append(";\n");
		}
		return snippet;
	}

	protected @NonNull CodeGenText getCollectionValueAndType(@NonNull CodeGenSnippet snippet, @NonNull CollectionValue collectionValue) {
		Class<? extends CollectionValue> javaClass;
		if (collectionValue instanceof SetValue) {
			javaClass = SetValue.class;
		}
		else if (collectionValue instanceof BagValue) {
			javaClass = BagValue.class;
		}
		else if (collectionValue instanceof OrderedSetValue) {
			javaClass = OrderedSetValue.class;
		}
		else if (collectionValue instanceof SequenceValue) {
			javaClass = SequenceValue.class;
		}
		else {
			javaClass = CollectionValue.class;
		}
		CodeGenText s = configureGlobalDependency(snippet, javaClass);
		String kind = collectionValue.getKind();
		String collectionTypeIdName = snippet.getSnippetName(collectionValue.getTypeId());
		Collection<? extends Object> elements = collectionValue.getElements();
		if ((elements instanceof IntegerRange) && (elements.size() > 1)){
			String rangeText = snippet.getSnippetName(elements);
			s.append("create" + kind + "Range(" + collectionTypeIdName + ", " + rangeText);
		}
		else {
			s.append("create" + kind + "Value(" + collectionTypeIdName);
			for (Object element : elements) {
				String elementText = snippet.getSnippetName(element);
				s.append(", ");
				if ((element == null) && (elements.size() == 1)) {
					s.append("(Object)");						// Disambiguate Object... from Iterable<?> 
				}
				s.append(elementText);
			}
		}
		s.append(")");
		return s;
	}

	protected @NonNull CodeGenText getEnumerationLiteralValueAndType(@NonNull CodeGenSnippet snippet, @NonNull EnumerationLiteralValue enumerationLiteralValue) {
		CodeGenText s = configureLocalDependency(snippet, EnumerationLiteralValue.class);
		String evaluatorName = codeGenerator.getEvaluatorName();
		String typeIdName = snippet.getSnippetName(enumerationLiteralValue.getEnumerationLiteralId());
		s.append("createEnumerationLiteralValue(" + evaluatorName + ".getIdResolver().getEnumerationLiteral(" + typeIdName + ", null))");	
		return s;
	}
	
	protected @NonNull CodeGenText getIntegerLiteralAndType(@NonNull CodeGenSnippet snippet, @NonNull IntegerValue integerValue) {
		CodeGenText s = configureGlobalDependency(snippet, IntegerValue.class);
		s.append("integerValueOf(");
		String valueString = integerValue.toString();
		assert valueString != null;
		if (integerValue instanceof IntIntegerValueImpl) {
			s.append(valueString);
		}
		else if (integerValue instanceof LongIntegerValueImpl) {
			s.append(valueString + "L");
		}
		else {
			s.append("\"" + valueString + "\"");
		}
		s.append(")");
		return s;
	}

	protected @NonNull CodeGenText getIntegerRangeAndType(@NonNull CodeGenSnippet snippet, @NonNull IntegerRange integerRange) {
		CodeGenText s = configureGlobalDependency(snippet, IntegerRange.class);
		String firstName = snippet.getSnippetName(integerRange.getFirst());
		String lastName = snippet.getSnippetName(integerRange.getLast());
		s.append("createRange(" + firstName + ", " + lastName + ")");
		return s;
	}
	
	protected @NonNull CodeGenText getNonInlineValueAndType(@NonNull CodeGenSnippet snippet, @Nullable Object aConstant) {
		if (aConstant instanceof NumericValue) {
			return getNumericValueAndType(snippet, (NumericValue)aConstant);
		}
		else if (aConstant instanceof CollectionValue) {
			return getCollectionValueAndType(snippet, (CollectionValue) aConstant);
		}
		else if (aConstant instanceof EnumerationLiteralValue) {
			return getEnumerationLiteralValueAndType(snippet, (EnumerationLiteralValue)aConstant);
		}
		else if (aConstant instanceof IntegerRange) {
			return getIntegerRangeAndType(snippet, (IntegerRange) aConstant);
		}
		else if (aConstant instanceof Number) {
			return getNumberLiteralAndType(snippet, (Number)aConstant);
		}
		else  if (aConstant instanceof String) {
			return getStringLiteralAndType(snippet, (String)aConstant);
		}
		else if (aConstant instanceof TupleValue) {
			return getTupleValueAndType(snippet, (TupleValue)aConstant);
		}
		else if (aConstant instanceof TypeValue) {
			return getTypeValueAndType(snippet, (TypeValue)aConstant);
		}
		else if (aConstant != null) {
			throw new IllegalArgumentException("Unknown " + aConstant.getClass().getName() + " for ConstantHelper.getNonInlineValueAndType()");
		}
		else {
			throw new IllegalArgumentException("Unknown null for ConstantHelper.getNonInlineValueAndType()");
		}
	}

	protected @NonNull CodeGenText getNumberLiteralAndType(@NonNull CodeGenSnippet snippet, @NonNull Number number) {
		if (number instanceof BigInteger) {
			return getIntegerLiteralAndType(snippet, ValuesUtil.integerValueOf((BigInteger)number));
		}
		else if ((number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
			assert number != null;
			return getIntegerLiteralAndType(snippet, ValuesUtil.integerValueOf(number.longValue()));
		}
		else if (number instanceof BigDecimal) {
			return getRealLiteralAndType(snippet, ValuesUtil.realValueOf((BigDecimal)number));
		}
		else if ((number instanceof Double) || (number instanceof Float)) {
			assert number != null;
			return getRealLiteralAndType(snippet, ValuesUtil.realValueOf(number.doubleValue()));
		}
		else if (number instanceof Unlimited) {
			CodeGenText s = configureGlobalDependency(snippet, UnlimitedValue.class);
			s.append("UNLIMITED_VALUE");
			return s;
		}
		else {
			throw new IllegalArgumentException("Unknown " + number.getClass().getName() + " for ConstantHelper.getNumberLiteralAndType()");
		}
	}

	protected @NonNull CodeGenText getNumericValueAndType(@NonNull CodeGenSnippet snippet, @NonNull NumericValue numericValue) {
		if (numericValue instanceof IntegerValue) {
			return getIntegerLiteralAndType(snippet, (IntegerValue) numericValue);
		}
		else if (numericValue instanceof RealValue) {
			return getRealLiteralAndType(snippet, (RealValue) numericValue);
		}
		else {
			throw new IllegalArgumentException("Unknown " + numericValue.getClass().getName() + " for ConstantHelper.getNumericValueAndType()");
		}
	}

	protected @NonNull CodeGenText getRealLiteralAndType(@NonNull CodeGenSnippet snippet, @NonNull RealValue realValue) {
		CodeGenText s = configureGlobalDependency(snippet, RealValue.class);
		s.append("realValueOf(");
		Number realNumber = realValue.asNumber();
		String valueString = realNumber.toString();
		if (realNumber instanceof Double) {
			s.append(valueString + "d");
		}
		else {
			s.append("\"" + valueString + "\"");
		}
		s.append(")");
		return s;
	}
	
	protected @NonNull CodeGenText getStringLiteralAndType(@NonNull CodeGenSnippet snippet, @NonNull String aString) {
		CodeGenText s = configureGlobalDependency(snippet, String.class);
		s.append('"' + Strings.convertToJavaString(aString) + '"');
		return s;
	}

	protected @NonNull CodeGenText getTupleValueAndType(@NonNull CodeGenSnippet snippet, @NonNull TupleValue tupleValue) {
		CodeGenText s = configureGlobalDependency(snippet, TupleValue.class);
		TupleTypeId tupleTypeId = tupleValue.getTypeId();
		int iSize = tupleTypeId.getPartIds().length;
		String tupleTypeIdName = snippet.getSnippetName(tupleTypeId);
		s.append("createTupleValue(" + tupleTypeIdName);
		for (int i = 0; i < iSize; i++) {
			Object tuplePart = tupleValue.getValue(i);
			String elementText = snippet.getSnippetName(tuplePart);
			s.append(", ");
			if ((tuplePart == null) && (iSize == 1)) {
				s.append("(Object)");						// Disambiguate Object... from Map<?> 
			}
			s.append(elementText);
		}
		s.append(")");
		return s;
	}

	protected @NonNull CodeGenText getTypeValueAndType(@NonNull CodeGenSnippet snippet, @NonNull TypeValue typeValue) {
		CodeGenText s = configureLocalDependency(snippet, TypeValue.class);
		String evaluatorName = codeGenerator.getEvaluatorName();
		String typeIdName = snippet.getSnippetName(typeValue.getInstanceType().getTypeId());
		s.append("createTypeValue(" + evaluatorName + ".getIdResolver().getType(" + typeIdName + ", null))");	
		return s;
	}
}
