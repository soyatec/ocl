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
package org.eclipse.ocl.examples.codegen.analyzer;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.InvalidValue;
import org.eclipse.ocl.examples.domain.values.RealValue;
import org.eclipse.ocl.examples.domain.values.TypeValue;
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

	public @NonNull String getBooleanLiteral(@NonNull Boolean booleanValue) {
		return booleanValue.booleanValue() ? "Boolean.TRUE" : "Boolean.FALSE";
	}

	public @NonNull String getInlineValue(@Nullable Object aConstant) {
		if (aConstant == null) {
			 return "null";
		}
		else if (aConstant instanceof Boolean) {
			return getBooleanLiteral((Boolean)aConstant);
		}
		else if (aConstant == ValuesUtil.UNLIMITED_VALUE) {
			return "UNLIMITED_VALUE";
		}
		else if (aConstant instanceof InvalidValue) {
			InvalidValueException exception = ((InvalidValue)aConstant).getException();
			if (exception == ValuesUtil.INVALID_VALUE.getException()) {
				return "INVALID_VALUE";
			}
			else {
				return "new " + codeGenerator.getImportedName(InvalidValueImpl.class) + "(" + Strings.convertToJavaString(exception.getMessage()) + ")";
			}
		}
		else {
			 throw new IllegalArgumentException("Unknown " + aConstant.getClass().getName() + " for ConstantHelper.getInlineValue()");
		}
	}
	
	public @NonNull String getIntegerLiteral(@NonNull IntegerValue integerValue) {
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
	
	public @NonNull String getNonInlineValue(@Nullable Object aConstant) {
		if (aConstant instanceof IntegerValue) {
			return getIntegerLiteral((IntegerValue) aConstant);
		}
		else if (aConstant instanceof RealValue) {
			return getRealLiteral((RealValue) aConstant);
		}
		else if (aConstant instanceof BigInteger) {
			return getIntegerLiteral(ValuesUtil.integerValueOf((BigInteger)aConstant));
		}
		else if ((aConstant instanceof Long) || (aConstant instanceof Integer) || (aConstant instanceof Short) || (aConstant instanceof Byte)) {
			assert aConstant != null;
			return getIntegerLiteral(ValuesUtil.integerValueOf(((Number)aConstant).longValue()));
		}
		else if (aConstant instanceof BigDecimal) {
			return getRealLiteral(ValuesUtil.realValueOf((BigDecimal)aConstant));
		}
		else if ((aConstant instanceof Double) || (aConstant instanceof Float)) {
			assert aConstant != null;
			return getRealLiteral(ValuesUtil.realValueOf(((Number)aConstant).doubleValue()));
		}
		else if (aConstant instanceof String) {
			return getStringLiteral((String)aConstant);
		}
		else if (aConstant instanceof TypeValue) {
//			String symbolName = getSymbolName(element);
//			String typeValueName = context.getImportedName(TypeValue.class);
			String evaluatorName = codeGenerator.getEvaluatorName();
			String typeIdName = ((TypeValue)aConstant).getInstanceType().getTypeId().accept(codeGenerator.getIdVisitor());
//			context.append("final " + atNonNull() + " " + typeValueName + " " + symbolName + " = createTypeValue(" + evaluatorName + ".getIdResolver().getType(" + typeIdName + ", null));\n");	
			return "createTypeValue(" + evaluatorName + ".getIdResolver().getType(" + typeIdName + ", null))";	
			
		}
//		else if (aConstant == ValuesUtil.INVALID_VALUE) {
//			return getStringLiteral((String)aConstant);
//		}
		else if (aConstant != null) {
			throw new IllegalArgumentException("Unknown " + aConstant.getClass().getName() + " for ConstantHelper.getNonInlineValue()");
		}
		else {
			throw new IllegalArgumentException("Unknown null for ConstantHelper.getNonInlineValue()");
		}
	}

	public @NonNull String getRealLiteral(@NonNull RealValue realValue) {
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
	
	public @NonNull String getStringLiteral(@NonNull String aString) {
		return '"' + Strings.convertToJavaString(aString) + '"';
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
}
