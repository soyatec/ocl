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
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.Unlimited;
import org.eclipse.ocl.examples.domain.values.impl.IntIntegerValueImpl;
import org.eclipse.ocl.examples.domain.values.impl.LongIntegerValueImpl;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.pivot.BooleanLiteralExp;
import org.eclipse.ocl.examples.pivot.IntegerLiteralExp;
import org.eclipse.ocl.examples.pivot.InvalidLiteralExp;
import org.eclipse.ocl.examples.pivot.NullLiteralExp;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.RealLiteralExp;
import org.eclipse.ocl.examples.pivot.StringLiteralExp;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypeExp;
import org.eclipse.ocl.examples.pivot.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.VariableDeclaration;
import org.eclipse.ocl.examples.pivot.VariableExp;
import org.eclipse.ocl.examples.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.examples.pivot.util.Visitable;
import org.eclipse.xtext.util.Strings;

/**
 * An OCL2JavaExpressionVisitor generates and returns a simple Java expression for a Pivot AST element.
 * <p>
 * The OCL2JavaStatementVisitor should be used for complex scenarios that require statements.
 */
public class OCL2JavaExpressionVisitor extends AbstractExtendingVisitor<String, OCLCodeGenerator>
{
	protected final @NonNull NameManager nameManager;
	
	public OCL2JavaExpressionVisitor(@NonNull OCLCodeGenerator codeGenerator) {
		super(codeGenerator);
		nameManager = codeGenerator.getNameManager();
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
	
	@Override
	public @NonNull String visit(@NonNull org.eclipse.ocl.examples.pivot.util.Visitable v) {
		String string = v.accept(this);
		assert string != null;
		return string;
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
		return "INVALID_VALUE";
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
	public @Nullable String visitTypeExp(@NonNull TypeExp element) {
		Type referredType = element.getReferredType();
		TypeId typeId = referredType.getTypeId();
		return typeId.accept(context.getIdVisitor());
	}

	@Override
	public @Nullable String visitUnlimitedNaturalLiteralExp(@NonNull UnlimitedNaturalLiteralExp element) {
		Number unlimitedNaturalSymbol = element.getUnlimitedNaturalSymbol();
		if (unlimitedNaturalSymbol == Unlimited.INSTANCE) {
			return "UNLIMITED_VALUE";
		}
		else {
			return "integerValueOf(" + integerValueOfInitializer(unlimitedNaturalSymbol) + ")";
		}
	}

	@Override
	public @Nullable String visitVariable(@NonNull Variable element) {
		OCLExpression initExpression = element.getInitExpression();
		if (initExpression != null) {
			CodeGenAnalysis initAnalysis = context.getNode(initExpression);
			if (initAnalysis.isInlineable()) {
				return initExpression.accept(this);
			}
		}
		return nameManager.getSymbolName(element);
	}

	@Override
	public @Nullable String visitVariableDeclaration(@NonNull VariableDeclaration element) {
		return nameManager.getSymbolName(element);
	}

	@Override
	public @Nullable String visitVariableExp(@NonNull VariableExp element) {
		VariableDeclaration referredVariable = element.getReferredVariable();
		if (referredVariable == null) {
			return nameManager.getSymbolName(element);
		}
		return referredVariable.accept(this);
	}
	
	public @NonNull String visiting(@NonNull Visitable visitable) {
		throw new UnsupportedOperationException("Expression: " + visitable.getClass().getName());
	}
}
