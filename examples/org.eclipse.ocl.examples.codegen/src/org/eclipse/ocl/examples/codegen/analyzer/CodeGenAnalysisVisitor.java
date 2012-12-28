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
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.Unlimited;
import org.eclipse.ocl.examples.pivot.AssociationClassCallExp;
import org.eclipse.ocl.examples.pivot.BooleanLiteralExp;
import org.eclipse.ocl.examples.pivot.CollectionItem;
import org.eclipse.ocl.examples.pivot.CollectionLiteralExp;
import org.eclipse.ocl.examples.pivot.CollectionLiteralPart;
import org.eclipse.ocl.examples.pivot.CollectionRange;
import org.eclipse.ocl.examples.pivot.ConstructorExp;
import org.eclipse.ocl.examples.pivot.ConstructorPart;
import org.eclipse.ocl.examples.pivot.EnumLiteralExp;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.IfExp;
import org.eclipse.ocl.examples.pivot.IntegerLiteralExp;
import org.eclipse.ocl.examples.pivot.InvalidLiteralExp;
import org.eclipse.ocl.examples.pivot.IterateExp;
import org.eclipse.ocl.examples.pivot.IteratorExp;
import org.eclipse.ocl.examples.pivot.LetExp;
import org.eclipse.ocl.examples.pivot.MessageExp;
import org.eclipse.ocl.examples.pivot.NullLiteralExp;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.PropertyCallExp;
import org.eclipse.ocl.examples.pivot.RealLiteralExp;
import org.eclipse.ocl.examples.pivot.StateExp;
import org.eclipse.ocl.examples.pivot.StringLiteralExp;
import org.eclipse.ocl.examples.pivot.TupleLiteralExp;
import org.eclipse.ocl.examples.pivot.TupleLiteralPart;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypeExp;
import org.eclipse.ocl.examples.pivot.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.examples.pivot.UnspecifiedValueExp;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.VariableDeclaration;
import org.eclipse.ocl.examples.pivot.VariableExp;
import org.eclipse.ocl.examples.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.examples.pivot.util.Visitable;

/**
 * A CodeGenAnalysisVisitor handles the Pivot AST visits on behalf of a CodeGenAnalyzer.
 * Derived visitors may support an extended AST.
 */
public class CodeGenAnalysisVisitor extends AbstractExtendingVisitor<CodeGenAnalysis, CodeGenAnalyzer>
{
	public CodeGenAnalysisVisitor(@NonNull CodeGenAnalyzer analyzer) {
		super(analyzer);
	}

	@Override
	public @Nullable CodeGenAnalysis visitAssociationClassCallExp(@NonNull AssociationClassCallExp element) {
//		CodeGenAnalysis thisAnalysis = context.getCurrentAnalysis();
		// TODO Auto-generated method stub
		return super.visitAssociationClassCallExp(element);
	}

	@Override
	public @Nullable CodeGenAnalysis visitBooleanLiteralExp(@NonNull BooleanLiteralExp element) {
		CodeGenAnalysis thisAnalysis = context.getCurrentAnalysis();
		thisAnalysis.initHashSource(DomainUtil.nonNullModel(Boolean.valueOf(element.isBooleanSymbol())));
		thisAnalysis.setInlineable();
		return thisAnalysis;
	}

	@Override
	public @Nullable CodeGenAnalysis visitCollectionItem(@NonNull CollectionItem element) {
		OCLExpression item = DomainUtil.nonNullModel(element.getItem());
		CodeGenAnalysis thisAnalysis = context.getCurrentAnalysis();
		CodeGenAnalysis itemAnalysis = context.descend(item);
		thisAnalysis.setDelegateTo(itemAnalysis);
		return thisAnalysis;
	}

	@Override
	public @Nullable CodeGenAnalysis visitCollectionLiteralExp(@NonNull CollectionLiteralExp element) {
		CodeGenAnalysis thisAnalysis = context.getCurrentAnalysis();
		for (CollectionLiteralPart part : element.getPart()) {
			assert part != null;
			CodeGenAnalysis partAnalysis = context.descend(part);
			if (partAnalysis.isInvalid()) {
				thisAnalysis.setInvalid();
			}
		}
		return thisAnalysis;
	}

	@Override
	public @Nullable CodeGenAnalysis visitCollectionRange(@NonNull CollectionRange element) {
		OCLExpression first = DomainUtil.nonNullModel(element.getFirst());
		OCLExpression last = DomainUtil.nonNullModel(element.getLast());
		CodeGenAnalysis thisAnalysis = context.getCurrentAnalysis();
		CodeGenAnalysis firstAnalysis = context.descend(first);
		CodeGenAnalysis lastAnalysis = context.descend(last);		// FIXME first..first optimization
		if (firstAnalysis.isInvalid() || lastAnalysis.isInvalid()) {
			thisAnalysis.setInvalid();
		}
		return thisAnalysis;
	}

	@Override
	public @Nullable CodeGenAnalysis visitConstructorExp(@NonNull ConstructorExp element) {
		CodeGenAnalysis thisAnalysis = context.getCurrentAnalysis();
//		context.addNamedElement(element.getType());
		for (ConstructorPart part : element.getPart()) {
			assert part != null;
			CodeGenAnalysis partAnalysis = context.descend(part);
			if (partAnalysis.isInvalid()) {
				thisAnalysis.setInvalid();
			}
		}
		return thisAnalysis;
	}

	@Override
	public @Nullable CodeGenAnalysis visitConstructorPart(@NonNull ConstructorPart element) {
		CodeGenAnalysis thisAnalysis = context.getCurrentAnalysis();
//		context.addNamedElement(element);
		OCLExpression initExpression = DomainUtil.nonNullModel(element.getInitExpression());
		CodeGenAnalysis itemAnalysis = context.descend(initExpression);
		if (itemAnalysis.isInvalid()) {
			thisAnalysis.setInvalid();
		}
		return thisAnalysis;
	}

	@Override
	public @Nullable CodeGenAnalysis visitEnumLiteralExp(@NonNull EnumLiteralExp element) {
		CodeGenAnalysis thisAnalysis = context.getCurrentAnalysis();
		thisAnalysis.initHashSource(DomainUtil.nonNullModel(element.getReferredEnumLiteral()));
		return thisAnalysis;
	}

	@Override
	public @Nullable
	CodeGenAnalysis visitExpressionInOCL(@NonNull ExpressionInOCL element) {
		OCLExpression bodyExpression = DomainUtil.nonNullModel(element.getBodyExpression());
		CodeGenAnalysis thisAnalysis = context.getCurrentAnalysis();
		CodeGenAnalysis contextVariableAnalysis = context.descend(DomainUtil.nonNullModel(element.getContextVariable()));
		if (contextVariableAnalysis.isInvalid()) {
			thisAnalysis.setInvalid();
		}
		for (Variable parameterVariable : element.getParameterVariable()) {
			assert parameterVariable != null;
			CodeGenAnalysis parameterVariableAnalysis = context.descend(parameterVariable);
			if (parameterVariableAnalysis.isInvalid()) {
				thisAnalysis.setInvalid();
			}
		}
		CodeGenAnalysis bodyAnalysis = context.descend(bodyExpression);
		if (bodyAnalysis.isInvalid()) {
			thisAnalysis.setInvalid();
		}
		return thisAnalysis;
	}

	@Override
	public @Nullable CodeGenAnalysis visitIfExp(@NonNull IfExp element) {
		OCLExpression condition = DomainUtil.nonNullModel(element.getCondition());
		OCLExpression thenExpression = DomainUtil.nonNullModel(element.getThenExpression());
		OCLExpression elseExpression = DomainUtil.nonNullModel(element.getElseExpression());
		CodeGenAnalysis thisAnalysis = context.getCurrentAnalysis();
		CodeGenAnalysis conditionAnalysis = context.descend(condition);
		if (conditionAnalysis.isInvalid() || conditionAnalysis.isNull()) {
			thisAnalysis.setInvalid();
		}
		CodeGenAnalysis thenAnalysis = context.descend(thenExpression);
		CodeGenAnalysis elseAnalysis = context.descend(elseExpression);
		if (thenAnalysis.isInvalid() && (elseAnalysis.isInvalid() || (conditionAnalysis.isConstant() && (conditionAnalysis.getConstantValue() == Boolean.TRUE)))) {
			thisAnalysis.setInvalid();
		}
		if (elseAnalysis.isInvalid() && (thenAnalysis.isInvalid() || (conditionAnalysis.isConstant() && (conditionAnalysis.getConstantValue() == Boolean.FALSE)))) {
			thisAnalysis.setInvalid();
		}
		return thisAnalysis;
	}

	@Override
	public @Nullable CodeGenAnalysis visitIntegerLiteralExp(@NonNull IntegerLiteralExp element) {
		CodeGenAnalysis thisAnalysis = context.getCurrentAnalysis();
		thisAnalysis.initHashSource(DomainUtil.nonNullModel(element.getIntegerSymbol()));
		return thisAnalysis;
	}

	@Override
	public @Nullable CodeGenAnalysis visitInvalidLiteralExp(@NonNull InvalidLiteralExp element) {
		CodeGenAnalysis thisAnalysis = context.getCurrentAnalysis();
		thisAnalysis.setInlineable();
		thisAnalysis.setInvalid();
		return thisAnalysis;
	}

	@Override
	public @Nullable CodeGenAnalysis visitIterateExp(@NonNull IterateExp element) {
		CodeGenAnalysis thisAnalysis = context.getCurrentAnalysis();
//		context.addNamedElement(element.getReferredIteration());
		CodeGenAnalysis sourceAnalysis = context.descend(DomainUtil.nonNullModel(element.getSource()));
		if (sourceAnalysis.isInvalid()) {
			thisAnalysis.setInvalid();
		}
		for (Variable iterator : element.getIterator()) {
			assert iterator != null;
			CodeGenAnalysis iteratorAnalysis = context.descend(iterator);
			if (iteratorAnalysis.isInvalid()) {
				thisAnalysis.setInvalid();
			}
		}
		CodeGenAnalysis resultAnalysis = context.descend(DomainUtil.nonNullModel(element.getResult()));
		if (resultAnalysis.isInvalid()) {
			thisAnalysis.setInvalid();
		}
		CodeGenAnalysis bodyAnalysis = context.descend(DomainUtil.nonNullModel(element.getBody()));
		thisAnalysis.setDelegateTo(resultAnalysis);
		if (bodyAnalysis.isInvalid()) {
			thisAnalysis.setInvalid();
		}
		return thisAnalysis;
	}

	@Override
	public @Nullable CodeGenAnalysis visitIteratorExp(@NonNull IteratorExp element) {
		CodeGenAnalysis thisAnalysis = context.getCurrentAnalysis();
		thisAnalysis.initHashSource(DomainUtil.nonNullModel(element.getReferredIteration()));
		CodeGenAnalysis sourceAnalysis = context.descend(DomainUtil.nonNullModel(element.getSource()));
		if (sourceAnalysis.isInvalid()) {
			thisAnalysis.setInvalid();
		}
		for (Variable iterator : element.getIterator()) {
			assert iterator != null;
			CodeGenAnalysis iteratorAnalysis = context.descend(iterator);
			if (iteratorAnalysis.isInvalid()) {
				thisAnalysis.setInvalid();
			}
		}
		CodeGenAnalysis bodyAnalysis = context.descend(DomainUtil.nonNullModel(element.getBody()));
		if (bodyAnalysis.isInvalid()) {
			thisAnalysis.setInvalid();
		}
		return thisAnalysis;
	}

	@Override
	public @Nullable CodeGenAnalysis visitLetExp(@NonNull LetExp element) {
		Variable letVariable = DomainUtil.nonNullModel(element.getVariable());
		OCLExpression initExpression = DomainUtil.nonNullModel(letVariable.getInitExpression());
		OCLExpression in = DomainUtil.nonNullModel(element.getIn());
		CodeGenAnalysis thisAnalysis = context.getCurrentAnalysis();
		CodeGenAnalysis initAnalysis = context.descend(initExpression);
		CodeGenAnalysis inAnalysis = context.descend(in);
		thisAnalysis.initHashSource(letVariable);
		thisAnalysis.setDelegateTo(inAnalysis);
		initAnalysis.setVariable(letVariable);
		if (inAnalysis.isInvalid()) {
			thisAnalysis.setInvalid();
		}
		return thisAnalysis;
	}

	@Override
	public @Nullable CodeGenAnalysis visitMessageExp(@NonNull MessageExp element) {
//		CodeGenAnalysis thisAnalysis = context.getCurrentAnalysis();
		// TODO Auto-generated method stub
		return super.visitMessageExp(element);
	}

	@Override
	public @Nullable CodeGenAnalysis visitNullLiteralExp(@NonNull NullLiteralExp element) {
		CodeGenAnalysis thisAnalysis = context.getCurrentAnalysis();
		thisAnalysis.setInlineable();
		thisAnalysis.setNull();
		return thisAnalysis;
	}

	@Override
	public @Nullable CodeGenAnalysis visitOperationCallExp(@NonNull OperationCallExp element) {
		CodeGenAnalysis thisAnalysis = context.getCurrentAnalysis();
		Operation referredOperation = DomainUtil.nonNullModel(element.getReferredOperation());
		boolean isValidating = referredOperation.isValidating();
		thisAnalysis.initHashSource(referredOperation);
		OCLExpression source = element.getSource();
		if (source != null) {
			CodeGenAnalysis sourceAnalysis = context.descend(source);
			if (isValidating) {
				sourceAnalysis.setCatching();
			}
			else if (sourceAnalysis.isInvalid()) {
				thisAnalysis.setInvalid();
			}
		}
		for (OCLExpression argument : element.getArgument()) {
			CodeGenAnalysis argumentAnalysis = context.descend(DomainUtil.nonNullModel(argument));
			if (isValidating) {
				argumentAnalysis.setCatching();
			}
			else if (argumentAnalysis.isInvalid()) {
				thisAnalysis.setInvalid();
			}
		}
		return thisAnalysis;
	}

	@Override
	public @Nullable CodeGenAnalysis visitPropertyCallExp(@NonNull PropertyCallExp element) {
		CodeGenAnalysis thisAnalysis = context.getCurrentAnalysis();
		Property referredProperty = DomainUtil.nonNullModel(element.getReferredProperty());
		thisAnalysis.initHashSource(referredProperty);
//		context.addNamedElement(referredProperty);
		CodeGenAnalysis sourceAnalysis = context.descend(DomainUtil.nonNullModel(element.getSource()));
		if (sourceAnalysis.isInvalid()) {
			thisAnalysis.setInvalid();
		}
		if (sourceAnalysis.isNull()) {
			thisAnalysis.setInvalid();
		}
		return thisAnalysis;
	}

	@Override
	public @Nullable CodeGenAnalysis visitRealLiteralExp(@NonNull RealLiteralExp element) {
		CodeGenAnalysis thisAnalysis = context.getCurrentAnalysis();
		thisAnalysis.initHashSource(DomainUtil.nonNullModel(element.getRealSymbol()));
		return thisAnalysis;
	}

	@Override
	public @Nullable CodeGenAnalysis visitStateExp(@NonNull StateExp element) {
//		CodeGenAnalysis thisAnalysis = context.getCurrentAnalysis();
		// TODO Auto-generated method stub
		return super.visitStateExp(element);
	}

	@Override
	public @Nullable CodeGenAnalysis visitStringLiteralExp(@NonNull StringLiteralExp element) {
		CodeGenAnalysis thisAnalysis = context.getCurrentAnalysis();
		thisAnalysis.initHashSource(DomainUtil.nonNullModel(element.getStringSymbol()));
		return thisAnalysis;
	}

	@Override
	public @Nullable CodeGenAnalysis visitTupleLiteralExp(@NonNull TupleLiteralExp element) {
		CodeGenAnalysis thisAnalysis = context.getCurrentAnalysis();
//		context.addNamedElement(element.getType());
		for (TupleLiteralPart part : element.getPart()) {
			assert part != null;
			CodeGenAnalysis partAnalysis = context.descend(part);
			if (partAnalysis.isInvalid()) {
				thisAnalysis.setInvalid();
			}
		}
		return thisAnalysis;
	}

	@Override
	public @Nullable CodeGenAnalysis visitTupleLiteralPart(@NonNull TupleLiteralPart element) {
		CodeGenAnalysis thisAnalysis = context.getCurrentAnalysis();
//		context.addNamedElement(element);
		OCLExpression initExpression = DomainUtil.nonNullModel(element.getInitExpression());
		CodeGenAnalysis itemAnalysis = context.descend(initExpression);
		if (itemAnalysis.isInvalid()) {
			thisAnalysis.setInvalid();
		}
		return thisAnalysis;
	}

	@Override
	public @Nullable CodeGenAnalysis visitTypeExp(@NonNull TypeExp element) {
		CodeGenAnalysis thisAnalysis = context.getCurrentAnalysis();
		Type referredType = element.getType();
		if (referredType != null) {
			thisAnalysis.initHashSource(referredType);
//			context.addNamedElement(referredType);
		}
		return thisAnalysis;
	}

	@Override
	public @Nullable CodeGenAnalysis visitUnlimitedNaturalLiteralExp(@NonNull UnlimitedNaturalLiteralExp element) {
		CodeGenAnalysis thisAnalysis = context.getCurrentAnalysis();
		thisAnalysis.initHashSource(DomainUtil.nonNullModel(element.getUnlimitedNaturalSymbol()));
		if (element.getUnlimitedNaturalSymbol() == Unlimited.INSTANCE) {
			thisAnalysis.setInlineable();
		}
		return thisAnalysis;
	}

	@Override
	public @Nullable CodeGenAnalysis visitUnspecifiedValueExp(@NonNull UnspecifiedValueExp element) {
//		CodeGenAnalysis thisAnalysis = context.getCurrentAnalysis();
		// TODO Auto-generated method stub
		return super.visitUnspecifiedValueExp(element);
	}

	@Override
	public @Nullable CodeGenAnalysis visitVariable(@NonNull Variable element) {
		// LoopExp iterator, IterateExp result, but not LetExp
		CodeGenAnalysis thisAnalysis = context.getCurrentAnalysis();
		thisAnalysis.initHashSource(element);
//		context.addNamedElement(element);
		OCLExpression initExpression = element.getInitExpression();
		if (initExpression != null) {
			CodeGenAnalysis initAnalysis = context.descend(initExpression);
			thisAnalysis.setDelegateTo(initAnalysis);
			if (initAnalysis.isInvalid()) {
				thisAnalysis.setInvalid();
			}
		}
		return thisAnalysis;
	}

	@Override
	public @Nullable CodeGenAnalysis visitVariableExp(@NonNull VariableExp element) {
		CodeGenAnalysis thisAnalysis = context.getCurrentAnalysis();
		VariableDeclaration referredVariable = element.getReferredVariable();
		if (referredVariable != null) {
			thisAnalysis.initHashSource(referredVariable);
//			context.addNamedElement(referredVariable);
			thisAnalysis.addDependency(referredVariable);
			if (referredVariable instanceof Variable) {
				OCLExpression initExpression = ((Variable)referredVariable).getInitExpression();
				if (initExpression != null) {
					CodeGenAnalysis initAnalysis = context.getAnalysis(initExpression);
					thisAnalysis.setDelegateTo(initAnalysis);
					if (initAnalysis.isInvalid()) {
						thisAnalysis.setInvalid();
					}
				}
				else {
					CodeGenAnalysis variableAnalysis = context.getAnalysis(referredVariable);
					thisAnalysis.setDelegateTo(variableAnalysis);
					if (variableAnalysis.isInvalid()) {
						thisAnalysis.setInvalid();
					}
				}
			}
		}
		return thisAnalysis;
	}

	@Nullable
	public CodeGenAnalysis visiting(@NonNull Visitable visitable) {
		throw new UnsupportedOperationException("Analyzer: " + visitable.getClass().getSimpleName());
	}
}
