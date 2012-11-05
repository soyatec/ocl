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

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.ids.TupleTypeId;
import org.eclipse.ocl.examples.domain.values.BagValue;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
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
import org.eclipse.ocl.examples.domain.values.UnlimitedValue;
import org.eclipse.ocl.examples.domain.values.impl.IntIntegerValueImpl;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueImpl;
import org.eclipse.ocl.examples.domain.values.impl.LongIntegerValueImpl;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.xtext.util.Strings;

/**
 * A ConstantHelper provides textual representations of constant values.
 */
public class ConstantHelper
{
	protected final @NonNull OCLCodeGenerator codeGenerator;
	
	public ConstantHelper(@NonNull OCLCodeGenerator codeGenerator) {
		this.codeGenerator = codeGenerator;
	}

	protected @NonNull String getCollectionValueAndType(@NonNull CodeGenSnippet snippet, @NonNull CollectionValue collectionValue) {
		String kind = collectionValue.getKind();
		String collectionTypeIdName = snippet.getConstantName(collectionValue.getTypeId());
		StringBuilder s = new StringBuilder();
		Collection<? extends Object> elements = collectionValue.getElements();
		if ((elements instanceof IntegerRange) && (elements.size() > 1)){
			String rangeText = snippet.getConstantName(elements);
			s.append("create" + kind + "Range(" + collectionTypeIdName + ", " + rangeText);
		}
		else {
			s.append("create" + kind + "Value(" + collectionTypeIdName);
			for (Object element : elements) {
				String elementText = snippet.getConstantName(element);
				s.append(", ");
				if ((element == null) && (elements.size() == 1)) {
					s.append("(Object)");						// Disambiguate Object... from Iterable<?> 
				}
				s.append(elementText);
			}
		}
		s.append(")");
		if (collectionValue instanceof SetValue) {
			snippet.setJavaClass(CollectionValue.class);
		}
		else if (collectionValue instanceof BagValue) {
			snippet.setJavaClass(BagValue.class);
		}
		else if (collectionValue instanceof OrderedSetValue) {
			snippet.setJavaClass(OrderedSetValue.class);
		}
		else if (collectionValue instanceof SequenceValue) {
			snippet.setJavaClass(SequenceValue.class);
		}
		else {
			snippet.setJavaClass(CollectionValue.class);
		}
		snippet.setIsStatic();
		@SuppressWarnings("null") @NonNull String string = s.toString();
		return string;
	}

	protected @NonNull CodeGenSnippet getInlineValueAndType(@Nullable Object aConstant) {
		if (aConstant == null) {
			return new CodeGenSnippet("null", null, codeGenerator);
		}
		else if (aConstant instanceof Boolean) {
			return new CodeGenSnippet(((Boolean)aConstant).booleanValue() ? "Boolean.TRUE" : "Boolean.FALSE", Boolean.class, codeGenerator);
		}
		else if (aConstant == ValuesUtil.UNLIMITED_VALUE) {
			return new CodeGenSnippet("UNLIMITED_VALUE", UnlimitedValue.class, codeGenerator);
		}
		else if (aConstant instanceof InvalidValue) {
			String text;
			InvalidValueException exception = ((InvalidValue)aConstant).getException();
			if (exception == ValuesUtil.INVALID_VALUE.getException()) {
				text = "INVALID_VALUE";
			}
			else {
				text = "new " + codeGenerator.getImportedName(InvalidValueImpl.class) + "(" + Strings.convertToJavaString(exception.getMessage()) + ")";
			}
			return new CodeGenSnippet(text, InvalidValue.class, codeGenerator);
		}
		else {
			 throw new IllegalArgumentException("Unknown " + aConstant.getClass().getName() + " for ConstantHelper.getInlineValue()");
		}
	}
	
	protected @NonNull String getIntegerLiteralAndType(@NonNull CodeGenSnippet snippet, @NonNull IntegerValue integerValue) {
		snippet.setIsStatic();
		snippet.setJavaClass(IntegerValue.class);
		StringBuilder s = new StringBuilder();
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
		@SuppressWarnings("null") @NonNull String string = s.toString();
		return string;
	}

	protected @NonNull String getIntegerRangeAndType(@NonNull CodeGenSnippet snippet, @NonNull IntegerRange integerRange) {
		snippet.setIsStatic();
		snippet.setJavaClass(IntegerRange.class);
		String firstName = snippet.getConstantName(integerRange.getFirst());
		String lastName = snippet.getConstantName(integerRange.getLast());
		return "createRange(" + firstName + ", " + lastName + ")";
	}
	
	protected @NonNull String getNonInlineValueAndType(@NonNull CodeGenSnippet snippet, @Nullable Object aConstant) {
		if (aConstant instanceof NumericValue) {
			return getNumericValueAndType(snippet, (NumericValue)aConstant);
		}
		else if (aConstant instanceof CollectionValue) {
			return getCollectionValueAndType(snippet, (CollectionValue) aConstant);
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
			throw new IllegalArgumentException("Unknown " + aConstant.getClass().getName() + " for ConstantHelper.getNonInlineValue()");
		}
		else {
			throw new IllegalArgumentException("Unknown null for ConstantHelper.getNonInlineValue()");
		}
	}

	protected @NonNull String getNumberLiteralAndType(@NonNull CodeGenSnippet snippet, @NonNull Number number) {
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
		else {
			throw new IllegalArgumentException("Unknown " + number.getClass().getName() + " for ConstantHelper.getNonInlineValue()");
		}
	}

	protected @NonNull String getNumericValueAndType(@NonNull CodeGenSnippet snippet, @NonNull NumericValue numericValue) {
		if (numericValue instanceof IntegerValue) {
			return getIntegerLiteralAndType(snippet, (IntegerValue) numericValue);
		}
		else if (numericValue instanceof RealValue) {
			return getRealLiteralAndType(snippet, (RealValue) numericValue);
		}
		else {
			throw new IllegalArgumentException("Unknown " + numericValue.getClass().getName() + " for ConstantHelper.getNumericValue()");
		}
	}

	protected @NonNull String getRealLiteralAndType(@NonNull CodeGenSnippet snippet, @NonNull RealValue realValue) {
		snippet.setIsStatic();
		snippet.setJavaClass(RealValue.class);
		StringBuilder s = new StringBuilder();
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
		@SuppressWarnings("null") @NonNull String string = s.toString();
		return string;
	}
	
	protected @NonNull String getStringLiteralAndType(@NonNull CodeGenSnippet snippet, @NonNull String aString) {
		snippet.setIsStatic();
		snippet.setJavaClass(String.class);
		return '"' + Strings.convertToJavaString(aString) + '"';
	}

	protected @NonNull String getTupleValueAndType(@NonNull CodeGenSnippet snippet, @NonNull TupleValue tupleValue) {
		TupleTypeId tupleTypeId = tupleValue.getTypeId();
		int iSize = tupleTypeId.getPartIds().length;
		String tupleTypeIdName = snippet.getConstantName(tupleTypeId);
		StringBuilder s = new StringBuilder();
		s.append("createTupleValue(" + tupleTypeIdName);
		for (int i = 0; i < iSize; i++) {
			Object tuplePart = tupleValue.getValue(i);
			String elementText = snippet.getConstantName(tuplePart);
			s.append(", ");
			if ((tuplePart == null) && (iSize == 1)) {
				s.append("(Object)");						// Disambiguate Object... from Map<?> 
			}
			s.append(elementText);
		}
		s.append(")");
		snippet.setJavaClass(TupleValue.class);
		snippet.setIsStatic();
		@SuppressWarnings("null") @NonNull String string = s.toString();
		return string;
	}

	protected @NonNull String getTypeValueAndType(@NonNull CodeGenSnippet snippet, @NonNull TypeValue typeValue) {
		snippet.setIsLocal();
		snippet.setJavaClass(TypeValue.class);
//		String symbolName = getSymbolName(element);
//		String typeValueName = context.getImportedName(TypeValue.class);
		String evaluatorName = codeGenerator.getEvaluatorName();
		String typeIdName = snippet.getConstantName(typeValue.getInstanceType().getTypeId());
//		context.append("final " + atNonNull() + " " + typeValueName + " " + symbolName + " = createTypeValue(" + evaluatorName + ".getIdResolver().getType(" + typeIdName + ", null));\n");	
		return "createTypeValue(" + evaluatorName + ".getIdResolver().getType(" + typeIdName + ", null))";	
	}

	/**
	 * Return true if constantValue should be used inline rather than being cached in a shared variable.
	 */
	public boolean isInlineable(@Nullable Object constantValue) {
		return (constantValue == null)
			|| (constantValue instanceof Boolean) /*|| (constantValue == Unlimited.INSTANCE)*/
			|| (constantValue == ValuesUtil.UNLIMITED_VALUE)
			|| ((constantValue instanceof InvalidValue) && (((InvalidValue)constantValue).getException() == ValuesUtil.INVALID_VALUE.getException()));
	}

	public @NonNull CodeGenSnippet visit(@Nullable Object anObject) {		// Constants are unfortunately of diverse types without a Visitor interface
		CodeGenSnippet snippet;
		if (isInlineable(anObject)) {
			snippet = getInlineValueAndType(anObject);
			snippet.setIsInlined();
			snippet.setIsStatic();
		}
		else {
			snippet = new CodeGenSnippet(codeGenerator, anObject);
			String valueText = getNonInlineValueAndType(snippet, anObject);			// Type is set on snippet as a side-effect
			String javaClassName = snippet.getJavaClassName();
			String name = snippet.getName();
			String atNonNull = codeGenerator.atNonNull();
			if (snippet.isStatic()) {
				snippet.append("private static ");
			}
			snippet.append("final " + atNonNull + " " + javaClassName + " " + name + " = " + valueText + ";\n");
		}
		return snippet;
	}
}
