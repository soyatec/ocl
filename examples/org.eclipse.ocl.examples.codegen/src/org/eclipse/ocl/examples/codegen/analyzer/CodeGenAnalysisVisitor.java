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

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.Unlimited;
import org.eclipse.ocl.examples.pivot.AssociationClassCallExp;
import org.eclipse.ocl.examples.pivot.BooleanLiteralExp;
import org.eclipse.ocl.examples.pivot.CollectionItem;
import org.eclipse.ocl.examples.pivot.CollectionLiteralExp;
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
import org.eclipse.ocl.examples.pivot.OperationCallExp;
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

import com.google.common.collect.Iterables;

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
		thisAnalysis.setHashSource(Boolean.valueOf(element.isBooleanSymbol()));
		thisAnalysis.setInlineable();
		context.addStaticConstant();
		return thisAnalysis;
	}

	@Override
	public @Nullable CodeGenAnalysis visitCollectionItem(@NonNull CollectionItem element) {
		OCLExpression item = DomainUtil.nonNullModel(element.getItem());
		CodeGenAnalysis thisAnalysis = context.getCurrentAnalysis();
		CodeGenAnalysis itemAnalysis = context.descend(item);
//		if (item != null) {
			if (itemAnalysis.isStaticConstant()) {
				context.addStaticConstant();
			} else if (itemAnalysis.isLocalConstant()) {
				context.addLocalConstant();
			}
			thisAnalysis.addInvalidSources(itemAnalysis.getInvalidSources());
//		}
		return thisAnalysis;
	}

	@Override
	public @Nullable CodeGenAnalysis visitCollectionLiteralExp(@NonNull CollectionLiteralExp element) {
		CodeGenAnalysis thisAnalysis = context.getCurrentAnalysis();
		context.descendAll(element.getPart());
		return thisAnalysis;
	}

	@Override
	public @Nullable CodeGenAnalysis visitCollectionRange(@NonNull CollectionRange element) {
		OCLExpression first = DomainUtil.nonNullModel(element.getFirst());
		OCLExpression last = DomainUtil.nonNullModel(element.getLast());
		CodeGenAnalysis thisAnalysis = context.getCurrentAnalysis();
		CodeGenAnalysis firstAnalysis = context.descend(first);
		CodeGenAnalysis lastAnalysis = context.descend(last);		// FIXME first..first optimization
//		if ((first != null) && (last != null)) {
			if (firstAnalysis.isStaticConstant() && lastAnalysis.isStaticConstant()) {
				context.addStaticConstant();
			}
			if (firstAnalysis.isConstant() && lastAnalysis.isConstant()) {
				context.addLocalConstant();
			}
			thisAnalysis.addInvalidSources(firstAnalysis.getInvalidSources());
			thisAnalysis.addInvalidSources(lastAnalysis.getInvalidSources());
//		}
		return thisAnalysis;
	}

	@Override
	public @Nullable CodeGenAnalysis visitConstructorExp(@NonNull ConstructorExp element) {
//		CodeGenAnalysis thisAnalysis = context.getCurrentAnalysis();
//		context.addNamedElement(element.getReferredIteration());
	// TODO Auto-generated method stub
		return super.visitConstructorExp(element);
	}

	@Override
	public @Nullable CodeGenAnalysis visitConstructorPart(@NonNull ConstructorPart element) {
//		CodeGenAnalysis thisAnalysis = context.getCurrentAnalysis();
	//	context.addNamedElement(element.getName());
		// TODO Auto-generated method stub
		return super.visitConstructorPart(element);
	}

	@Override
	public @Nullable CodeGenAnalysis visitEnumLiteralExp(@NonNull EnumLiteralExp element) {
		CodeGenAnalysis thisAnalysis = context.getCurrentAnalysis();
		thisAnalysis.setHashSource(element.getReferredEnumLiteral());
		context.addStaticConstant();
		return thisAnalysis;
	}

	@Override
	public @Nullable
	CodeGenAnalysis visitExpressionInOCL(@NonNull ExpressionInOCL element) {
		OCLExpression bodyExpression = DomainUtil.nonNullModel(element.getBodyExpression());
		CodeGenAnalysis thisAnalysis = context.getCurrentAnalysis();
		CodeGenAnalysis bodyAnalysis = context.descend(bodyExpression);
//		if (body != null) {
			if (bodyAnalysis.isStaticConstant()) {
				context.addStaticConstant();
			}
			else if (bodyAnalysis.isLocalConstant()) {
				context.addLocalConstant();
			}
			thisAnalysis.addInvalidSources(bodyAnalysis.getInvalidSources());
//		}
		return thisAnalysis;
	}

	@Override
	public @Nullable CodeGenAnalysis visitIfExp(@NonNull IfExp element) {
		OCLExpression condition = DomainUtil.nonNullModel(element.getCondition());
		OCLExpression thenExpression = DomainUtil.nonNullModel(element.getThenExpression());
		OCLExpression elseExpression = DomainUtil.nonNullModel(element.getElseExpression());
		CodeGenAnalysis thisAnalysis = context.getCurrentAnalysis();
		CodeGenAnalysis conditionAnalysis = context.descend(condition);
		CodeGenAnalysis thenAnalysis = context.descend(thenExpression);
		CodeGenAnalysis elseAnalysis = context.descend(elseExpression);
//		CodeGenAssignment assignment = thisAnalysis.createAssignment();
//		CodeGenAssignment conditionAssignment = conditionAnalysis.getAssignment();
//		CodeGenAssignment thenAssignment = thenAnalysis.getAssignment();
//		CodeGenAssignment elseAssignment = elseAnalysis.getAssignment();
//		assignment.addDependency(conditionAssignment);
//		assignment.addDependency(thenAssignment);
//		assignment.addDependency(elseAssignment);
//		thenAssignment.addConditionalDependency(conditionAssignment);
//		elseAssignment.addConditionalDependency(conditionAssignment);
		Set<CodeGenAnalysis> invalidConditionSources = conditionAnalysis.getInvalidSources();
		if (invalidConditionSources != null) {
			thisAnalysis.addInvalidSources(invalidConditionSources);
		}
		Set<CodeGenAnalysis> invalidThenSources = thenAnalysis.getInvalidSources();
		Set<CodeGenAnalysis> invalidElseSources = elseAnalysis.getInvalidSources();
		if ((invalidThenSources != null) || (invalidElseSources != null)) {
			if ((invalidThenSources != null) && (invalidElseSources != null)) {
				Set<CodeGenAnalysis> invalidCommonSources = new HashSet<CodeGenAnalysis>(invalidThenSources);
				invalidCommonSources.retainAll(invalidElseSources);
				thisAnalysis.addInvalidSources(invalidCommonSources);
				Set<CodeGenAnalysis> invalidUncommonSources = new HashSet<CodeGenAnalysis>(invalidThenSources);
				invalidUncommonSources.addAll(invalidElseSources);
				invalidUncommonSources.removeAll(invalidCommonSources);
				thisAnalysis.addInvalidSource(thisAnalysis);
			}
		}
		return thisAnalysis;
	}

	@Override
	public @Nullable CodeGenAnalysis visitIntegerLiteralExp(@NonNull IntegerLiteralExp element) {
		CodeGenAnalysis thisAnalysis = context.getCurrentAnalysis();
		thisAnalysis.setHashSource(element.getIntegerSymbol());
		context.addStaticConstant();
		return thisAnalysis;
	}

	@Override
	public @Nullable CodeGenAnalysis visitInvalidLiteralExp(@NonNull InvalidLiteralExp element) {
		CodeGenAnalysis thisAnalysis = context.getCurrentAnalysis();
		thisAnalysis.addInvalidSource(thisAnalysis);
		thisAnalysis.setInlineable();
		context.addStaticConstant();
		return thisAnalysis;
	}

	@Override
	public @Nullable CodeGenAnalysis visitIterateExp(@NonNull IterateExp element) {
//		CodeGenAnalysis thisAnalysis = context.getCurrentAnalysis();
		context.addNamedElement(element.getReferredIteration());
		// TODO Auto-generated method stub
		return super.visitIterateExp(element);
	}

	@Override
	public @Nullable CodeGenAnalysis visitIteratorExp(@NonNull IteratorExp element) {
//		CodeGenAnalysis thisAnalysis = context.getCurrentAnalysis();
		context.addNamedElement(element.getReferredIteration());
		// TODO Auto-generated method stub
		return super.visitIteratorExp(element);
	}

	@Override
	public @Nullable CodeGenAnalysis visitLetExp(@NonNull LetExp element) {
		Variable letVariable = DomainUtil.nonNullModel(element.getVariable());
		OCLExpression initExpression = DomainUtil.nonNullModel(letVariable.getInitExpression());
		OCLExpression in = DomainUtil.nonNullModel(element.getIn());
		CodeGenAnalysis thisAnalysis = context.getCurrentAnalysis();
		CodeGenAnalysis initAnalysis = context.descend(initExpression);
		CodeGenAnalysis inAnalysis = context.descend(in);
//		CodeGenAssignment initAssignment = initAnalysis.getAssignment();
//		CodeGenAssignment inAssignment = inAnalysis.getAssignment();
//		thisAnalysis.setAssignment(inAssignment);
//		inAssignment.addDependency(initAssignment);
//		if ((initAnalysis != null) && (inAnalysis != null)) {
			if (initAnalysis.isStaticConstant() && inAnalysis.isStaticConstant()) {
				context.addStaticConstant();
			} else if (initAnalysis.isConstant() && inAnalysis.isConstant()) {
				context.addLocalConstant();
			}
			thisAnalysis.addInvalidSources(inAnalysis.getInvalidSources());
//		}
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
		thisAnalysis.addNullSource(thisAnalysis);
		thisAnalysis.setInlineable();
		context.addStaticConstant();
		return thisAnalysis;
	}

	@Override
	public @Nullable CodeGenAnalysis visitOperationCallExp(@NonNull OperationCallExp element) {
		CodeGenAnalysis thisAnalysis = context.getCurrentAnalysis();
		thisAnalysis.setHashSource(element.getReferredOperation());
//		context.addNamedElement(element.getReferredOperation());
		OCLExpression source = element.getSource();
		if (source != null) {
			context.descendAll(Iterables.concat(Collections.singletonList(source), element.getArgument()));
		}
		else {
			context.descendAll(element.getArgument());
		}
		thisAnalysis.resetConstant();					// FIXME test aid to force CG of deep constants
		return thisAnalysis;
	}

	@Override
	public @Nullable CodeGenAnalysis visitPropertyCallExp(@NonNull PropertyCallExp element) {
		OCLExpression source = DomainUtil.nonNullModel(element.getSource());
		CodeGenAnalysis thisAnalysis = context.getCurrentAnalysis();
		thisAnalysis.setHashSource(element.getReferredProperty());
		context.addNamedElement(element.getReferredProperty());
		context.descend(source);
		thisAnalysis.addInvalidSource(thisAnalysis);
		thisAnalysis.addNullSource(thisAnalysis);
		return thisAnalysis;
	}

	@Override
	public @Nullable CodeGenAnalysis visitRealLiteralExp(@NonNull RealLiteralExp element) {
		CodeGenAnalysis thisAnalysis = context.getCurrentAnalysis();
		thisAnalysis.setHashSource(element.getRealSymbol());
		context.addStaticConstant();
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
		thisAnalysis.setHashSource(element.getStringSymbol());
		context.addStaticConstant();
		return thisAnalysis;
	}

	@Override
	public @Nullable CodeGenAnalysis visitTupleLiteralExp(@NonNull TupleLiteralExp element) {
		CodeGenAnalysis thisAnalysis = context.getCurrentAnalysis();
		context.addNamedElement(element.getType());
		context.descendAll(element.getPart());
		return thisAnalysis;
	}

	@Override
	public @Nullable CodeGenAnalysis visitTupleLiteralPart(@NonNull TupleLiteralPart element) {
		CodeGenAnalysis thisAnalysis = context.getCurrentAnalysis();
		context.addNamedElement(element);
		OCLExpression initExpression = DomainUtil.nonNullModel(element.getInitExpression());
		CodeGenAnalysis itemAnalysis = context.descend(initExpression);
//		if (itemAnalysis != null) {
			if (itemAnalysis.isStaticConstant()) {
				context.addStaticConstant();
			} else if (itemAnalysis.isLocalConstant()) {
				context.addLocalConstant();
			}
			thisAnalysis.addInvalidSources(itemAnalysis.getInvalidSources());
//		}
		return thisAnalysis;
	}

	@Override
	public @Nullable CodeGenAnalysis visitTypeExp(@NonNull TypeExp element) {
		CodeGenAnalysis thisAnalysis = context.getCurrentAnalysis();
		Type referredType = element.getType();
		if (referredType != null) {
			thisAnalysis.setHashSource(referredType);
//			context.addNamedElement(referredType);
		}
		context.addLocalConstant();
		return thisAnalysis;
	}

	@Override
	public @Nullable CodeGenAnalysis visitUnlimitedNaturalLiteralExp(@NonNull UnlimitedNaturalLiteralExp element) {
		CodeGenAnalysis thisAnalysis = context.getCurrentAnalysis();
		thisAnalysis.setHashSource(element.getUnlimitedNaturalSymbol());
		if (element.getUnlimitedNaturalSymbol() == Unlimited.INSTANCE) {
			thisAnalysis.setInlineable();
		}
		context.addStaticConstant();
		return thisAnalysis;
	}

	@Override
	public @Nullable CodeGenAnalysis visitUnspecifiedValueExp(@NonNull UnspecifiedValueExp element) {
//		CodeGenAnalysis thisAnalysis = context.getCurrentAnalysis();
		// TODO Auto-generated method stub
		return super.visitUnspecifiedValueExp(element);
	}

	@Override
	public @Nullable CodeGenAnalysis visitVariableExp(@NonNull VariableExp element) {
		CodeGenAnalysis thisAnalysis = context.getCurrentAnalysis();
//		CodeGenAnalysis init = safeAccept(element.getVariable().getInitExpression());
//		CodeGenAnalysis in = safeAccept(element.getIn());
		VariableDeclaration referredVariable = element.getReferredVariable();
		if (referredVariable != null) {
			thisAnalysis.setHashSource(referredVariable);
			context.addNamedElement(referredVariable);
			thisAnalysis.addDependency(referredVariable);
		}
//		if (init.isStaticConstant() && in.isStaticConstant()) {
//			addStaticConstant();
//		}
//		else if ((init.isLocalConstant() || init.isStaticConstant()) && (in.isLocalConstant() || in.isStaticConstant())) {
//			addLocalConstant();
//		}
//		thisAnalysis.addInvalidSources(in.getInvalidSources());
		return thisAnalysis;
	}

	@Nullable
	public CodeGenAnalysis visiting(@NonNull Visitable visitable) {
		throw new UnsupportedOperationException("Analyzer: " + visitable.getClass().getSimpleName());
	}
}
