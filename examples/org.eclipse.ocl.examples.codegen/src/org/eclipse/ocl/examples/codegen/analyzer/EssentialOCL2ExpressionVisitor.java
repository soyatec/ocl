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

import java.math.BigInteger;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.impl.IntIntegerValueImpl;
import org.eclipse.ocl.examples.domain.values.impl.LongIntegerValueImpl;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.pivot.BooleanLiteralExp;
import org.eclipse.ocl.examples.pivot.IntegerLiteralExp;
import org.eclipse.ocl.examples.pivot.InvalidLiteralExp;
import org.eclipse.ocl.examples.pivot.NullLiteralExp;
import org.eclipse.ocl.examples.pivot.RealLiteralExp;
import org.eclipse.ocl.examples.pivot.StringLiteralExp;
import org.eclipse.ocl.examples.pivot.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.examples.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.examples.pivot.util.Visitable;
import org.eclipse.xtext.util.Strings;

/**
 * A CodeGenAnalysisVisitor handles the Pivot AST visits on behalf of a CodeGenAnalyzer.
 * Derived visitors may support an extended AST.
 */
public class EssentialOCL2ExpressionVisitor extends AbstractExtendingVisitor<String, OCLCodeGenerator>
{
	public EssentialOCL2ExpressionVisitor(@NonNull OCLCodeGenerator codeGenerator) {
		super(codeGenerator);
	}
	
	protected @NonNull String integerValueOfInitializer(Number number) {
		IntegerValue value;
		if (number instanceof Integer){
			 value = ValuesUtil.integerValueOf(number.intValue());
		}
		else if (number instanceof Long) {
			 value = ValuesUtil.integerValueOf(number.longValue());
		}
		else if (number instanceof BigInteger) {
			 value = ValuesUtil.integerValueOf((BigInteger)number);
		}
		else {
			 return "\"\"";
		}
		String string = value.toString();
		assert string != null;
		if (value instanceof IntIntegerValueImpl) {
			return string;
		}
		else if (value instanceof LongIntegerValueImpl) {
			return string + "L";
		}
		else {
			return "\"" + string + "\"";
		}
	}
	
	public @NonNull String realValueOfInitializer(Number number) {
		if (number instanceof Double) {
			return number.toString() + "d";
		}
		return "\"" + number.toString() + "\"";
	}
	
	@Nullable
	public String visiting(@NonNull Visitable visitable) {
		throw new UnsupportedOperationException(visitable.getClass().getName());
	}

	@Override
	public @Nullable String visitBooleanLiteralExp(@NonNull BooleanLiteralExp element) {
		return element.isBooleanSymbol() ? "Boolean.TRUE" : "Boolean.FALSE";
	}

	@Override
	public @Nullable String visitIntegerLiteralExp(@NonNull IntegerLiteralExp element) {
		Number integerSymbol = element.getIntegerSymbol();
		return "integerValueOf(" + integerValueOfInitializer(integerSymbol) + ")";
	}

	@Override
	public @Nullable String visitInvalidLiteralExp(@NonNull InvalidLiteralExp element) {
		return "throwInvalidValueException()";
	}

	@Override
	public @Nullable String visitNullLiteralExp(@NonNull NullLiteralExp element) {
		return "null";
	}

/*	@Override
	public @Nullable String visitPrimitiveType(@NonNull PrimitiveType element) {
		if ("String".equals(element.getName())) {
			return context.getImportedName(TypeId.class) + ".STRING";
		}
		return element.getName();
	} */

	@Override
	public @Nullable String visitRealLiteralExp(@NonNull RealLiteralExp element) {
		Number realSymbol = element.getRealSymbol();
		return "realValueOf(" + realValueOfInitializer(realSymbol) + ")";
	}

	@Override
	public @Nullable String visitStringLiteralExp(@NonNull StringLiteralExp element) {
		String stringSymbol = element.getStringSymbol();
		return "\"" + Strings.convertToJavaString(stringSymbol) + "\"";
	}

	@Override
	public @Nullable String visitUnlimitedNaturalLiteralExp(@NonNull UnlimitedNaturalLiteralExp element) {
		Number unlimitedNaturalSymbol = element.getUnlimitedNaturalSymbol();
		if (unlimitedNaturalSymbol != null) {
			return "integerValueOf(" + integerValueOfInitializer(unlimitedNaturalSymbol) + ")";
		}
		else {
			return "UNLIMITED_VALUE";
		}
	}
}
