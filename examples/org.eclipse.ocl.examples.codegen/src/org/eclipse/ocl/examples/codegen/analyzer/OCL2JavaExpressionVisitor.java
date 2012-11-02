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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.BooleanLiteralExp;
import org.eclipse.ocl.examples.pivot.InvalidLiteralExp;
import org.eclipse.ocl.examples.pivot.NullLiteralExp;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.StringLiteralExp;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypeExp;
import org.eclipse.ocl.examples.pivot.TypedElement;
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
	
	@Override
	public @NonNull String visit(@Nullable Visitable element) {
		TypedElement element2 = (TypedElement)DomainUtil.nonNullModel(element);
		CodeGenAnalysis analysis = context.getAnalysis(element2);			// FIXME cast
		if (!analysis.isConstant()) {
			String string = element2.accept(this);
			assert string != null;
			return string;
		}
		else if (analysis.isInlineable()) {
			String literalText = context.getConstantHelper().getInlineValue(analysis.getConstantValue());
			return literalText;	
		}
		else {
			return "/*BAD*/";
		}
	}

	@Override
	public @Nullable String visitBooleanLiteralExp(@NonNull BooleanLiteralExp element) {
		return element.isBooleanSymbol() ? "Boolean.TRUE" : "Boolean.FALSE";
	}

//	@Override
//	public @Nullable String visitIntegerLiteralExp(@NonNull IntegerLiteralExp element) {
//		Number integerSymbol = element.getIntegerSymbol();
//		return context.getConstantHelper().getIntegerLiteral(integerSymbol);
//	}

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

/*	@Override
	public @Nullable String visitRealLiteralExp(@NonNull RealLiteralExp element) {
		Number realSymbol = element.getRealSymbol();
		return context.getConstantHelper().getRealLiteral(realSymbol);
	} */

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

//	@Override
//	public @Nullable String visitUnlimitedNaturalLiteralExp(@NonNull UnlimitedNaturalLiteralExp element) {
//		Number unlimitedNaturalSymbol = element.getUnlimitedNaturalSymbol();
//		if (unlimitedNaturalSymbol == Unlimited.INSTANCE) {
//			return "UNLIMITED_VALUE";
//		}
//		else {
//			return context.getConstantHelper().getIntegerLiteral(unlimitedNaturalSymbol);
//		}
//	}

	@Override
	public @Nullable String visitVariable(@NonNull Variable element) {
		OCLExpression initExpression = element.getInitExpression();
		if (initExpression != null) {
			CodeGenAnalysis initAnalysis = context.getAnalysis(initExpression);
			if (initAnalysis.isInlineable()) {
				return visit(initExpression);
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
		return visit(referredVariable);
	}
	
	public @NonNull String visiting(@NonNull Visitable visitable) {
		throw new UnsupportedOperationException("Expression: " + visitable.getClass().getName());
	}
}
