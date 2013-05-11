/**
 * <copyright>
 * 
 * Copyright (c) 2013 CEA LIST and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink(CEA LIST) - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.ocl.examples.codegen.analyzer;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGCollectionExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGConstructorExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorType;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIfExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIsInvalidExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIsUndefinedExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIterationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGLetExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPropertyCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTupleExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTypeExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariableExp;
import org.eclipse.ocl.examples.codegen.cgmodel.util.AbstractExtendingCGModelVisitor;
import org.eclipse.ocl.examples.codegen.generator.LocalContext;
import org.eclipse.ocl.examples.domain.ids.ElementId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.pivot.ConstructorExp;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypeExp;

/**
 * A CGElementVisitor handles the Pivot AST visits on behalf of a CodeGenAnalyzer.
 * Derived visitors may support an extended AST.
 */
public class AnalysisVisitor extends AbstractExtendingCGModelVisitor<Object, CodeGenAnalyzer>
{
	public AnalysisVisitor(@NonNull CodeGenAnalyzer analyzer) {
		super(analyzer);
	}

	@Override
	public @Nullable Object visitCGCollectionExp(@NonNull CGCollectionExp cgCollectionExp) {
		super.visitCGCollectionExp(cgCollectionExp);
		if (cgCollectionExp.isInvalid()) {
			context.setConstant(cgCollectionExp, cgCollectionExp.getValue());
		}
		return null;
	}

	@Override
	public @Nullable Object visitCGConstructorExp(@NonNull CGConstructorExp cgConstructorExp) {
		ConstructorExp pConstructorExp = (ConstructorExp) cgConstructorExp.getPivot();
		Type pType = pConstructorExp.getType();
		if (pType != null) {
			EObject eTarget = pType.getETarget();
			if (eTarget instanceof EClass) {
				LocalContext localContext = context.getCodeGenerator().getGlobalContext().getLocalContext(cgConstructorExp);
				if (localContext != null) {
					CGExecutorType cgExecutorType = localContext.getExecutorType(pType);
//					cgConstructorExp.setReferredType(cgExecutorType);
					cgConstructorExp.getDependsOn().add(cgExecutorType);
				}
			}
		}
		if (cgConstructorExp.isInvalid()) {
			context.setConstant(cgConstructorExp, cgConstructorExp.getValue());
		}
		return null;
	}

	@Override
	public @Nullable Object visitCGElement(@NonNull CGElement cgElement) {
		for (CGElement cgChild : cgElement.getChildren()) {
			cgChild.accept(this);
		}
		return null;
	}

/*	@Override
	public void visitEnumLiteralExp(@NonNull EnumLiteralExp element) {
		CGElement thisAnalysis = context.getCurrentAnalysis();
		thisAnalysis.initHashSource(DomainUtil.nonNullModel(element.getReferredEnumLiteral()));
		return thisAnalysis;
	}*/

	@Override
	public @Nullable Object visitCGIfExp(@NonNull CGIfExp cgIfExp) {
		super.visitCGIfExp(cgIfExp);
		CGValuedElement condition = context.getExpression(cgIfExp.getCondition());
		CGValuedElement thenExpression = context.getExpression(cgIfExp.getThenExpression());
		CGValuedElement elseExpression = context.getExpression(cgIfExp.getElseExpression());
		if (condition.isInvalid()) {
			CGUtils.replace(cgIfExp, condition);
		}
		else if (condition.isNull()) {
			context.setConstant(cgIfExp, context.getInvalid("Null condition"));
		}
		else if (thenExpression.isInvalid() && elseExpression.isInvalid()) {
			CGUtils.replace(cgIfExp, thenExpression);
		}
		else if (condition.isConstant()) {
			if (condition.isTrue()) {
				CGUtils.replace(cgIfExp, thenExpression);
			}
			else if (condition.isFalse()) {
				CGUtils.replace(cgIfExp, elseExpression);
			}
			else {
				ElementId pivotTypeId = condition.getTypeId().getElementId();
				context.setConstant(cgIfExp, context.getInvalid(EvaluatorMessages.TypedValueRequired, "Boolean", pivotTypeId));
			}
		}
		return null;
	}

	@Override
	public @Nullable Object visitCGIsInvalidExp(@NonNull CGIsInvalidExp cgIsInvalidExp) {
		super.visitCGIsInvalidExp(cgIsInvalidExp);
		if (cgIsInvalidExp.isConstant()) {
			context.setConstant(cgIsInvalidExp, context.getBoolean(cgIsInvalidExp.isTrue()));
		}
		return null;
	}

	@Override
	public @Nullable Object visitCGIsUndefinedExp(@NonNull CGIsUndefinedExp cgIsUndefinedExp) {
		super.visitCGIsUndefinedExp(cgIsUndefinedExp);
		if (cgIsUndefinedExp.isConstant()) {
			context.setConstant(cgIsUndefinedExp, context.getBoolean(cgIsUndefinedExp.isTrue()));
		}
		return null;
	}

	@Override
	public @Nullable Object visitCGLetExp(@NonNull CGLetExp cgLetExp) {
		super.visitCGLetExp(cgLetExp);
		CGValuedElement in = context.getExpression(cgLetExp.getIn());
		if (cgLetExp.getInit().isConstant()) {
			CGUtils.replace(cgLetExp, in);
		}
		else {
			if (in.isConstant()) {
				context.setConstant(cgLetExp, in.getValue());
			}
		}
		return null;
	}

	@Override
	public @Nullable Object visitCGIterationCallExp(@NonNull CGIterationCallExp cgIterationCallExp) {
		super.visitCGIterationCallExp(cgIterationCallExp);
		CGValuedElement source = context.getExpression(cgIterationCallExp.getSource());
//		if (!cgIterationCallExp.isValidating()) {
			if (source.isInvalid()) {
				context.setConstant(cgIterationCallExp, source.getValue());
				return null;
			}
			else if (source.isNull()) {
				context.setConstant(cgIterationCallExp, context.getInvalid(EvaluatorMessages.TypedValueRequired, TypeId.COLLECTION_NAME, ValuesUtil.getTypeName(null)));
				return null;
			}
//			for (@SuppressWarnings("null")@NonNull CGValuedElement cgArgument : cgIterationCallExp.getArguments()) {
//				CGConstant constantArgument = cgArgument.getConstantValue();
//				if ((constantArgument != null) && constantArgument.isInvalid()) {
//					context.setConstant(cgIterationCallExp, constantArgument);
//					return null;
//				}
//			}
//		}
		return null;
	}

	@Override
	public @Nullable Object visitCGOperation(@NonNull CGOperation cgOperation) {
		super.visitCGOperation(cgOperation);
		CGValuedElement cgBody = context.getExpression(cgOperation.getBody());
		for (@SuppressWarnings("null")@NonNull CGVariable cgParameter : cgOperation.getParameters()) {
			if (cgParameter.isInvalid()) {
				context.setConstant(cgBody, cgParameter.getValue());
				return null;
			}
		}
		return null;
	}

	@Override
	public @Nullable Object visitCGOperationCallExp(@NonNull CGOperationCallExp cgOperationCallExp) {
		super.visitCGOperationCallExp(cgOperationCallExp);
		CGValuedElement source = context.getExpression(cgOperationCallExp.getSource());
		if (!cgOperationCallExp.isValidating()) {
			if (source.isInvalid()) {
				context.setConstant(cgOperationCallExp, source.getValue());
				return null;
			}
			for (@SuppressWarnings("null")@NonNull CGValuedElement cgArgument : cgOperationCallExp.getArguments()) {
				if (cgArgument.isInvalid()) {
					context.setConstant(cgOperationCallExp, cgArgument.getValue());
					return null;
				}
			}
		}
		return null;
	}

	@Override
	public @Nullable Object visitCGParameter(@NonNull CGParameter object) {
		return null;
	}

	@Override
	public @Nullable Object visitCGPropertyCallExp(@NonNull CGPropertyCallExp cgPropertyCallExp) {
		super.visitCGPropertyCallExp(cgPropertyCallExp);
//		Property referredProperty = DomainUtil.nonNullModel(element.getReferredProperty());
//		thisAnalysis.initHashSource(referredProperty);
//		context.addNamedElement(referredProperty);
		CGValuedElement source = context.getExpression(cgPropertyCallExp.getSource());
		if (source.isInvalid()) {
			context.setConstant(cgPropertyCallExp, source.getValue());
		}
		else if (source.isNull()) {
			context.setConstant(cgPropertyCallExp, context.getInvalid());
		}
		return null;
	}

	@Override
	public @Nullable Object visitCGTupleExp(@NonNull CGTupleExp cgTupleExp) {
		if (cgTupleExp.isInvalid()) {
			context.setConstant(cgTupleExp, cgTupleExp.getValue());
		}
		return null;
	}

	@Override
	public @Nullable Object visitCGTypeExp(@NonNull CGTypeExp cgTypeExp) {
		TypeExp pTypeExp = (TypeExp) cgTypeExp.getPivot();
		Type referredType = pTypeExp.getReferredType();
		if (referredType != null) {
			LocalContext localContext = context.getCodeGenerator().getGlobalContext().getLocalContext(cgTypeExp);
			if (localContext != null) {
				CGExecutorType cgExecutorType = localContext.getExecutorType(referredType);
				cgTypeExp.setReferredType(cgExecutorType);
				cgTypeExp.setTypeId(cgExecutorType.getUnderlyingTypeId());
				cgTypeExp.getDependsOn().add(cgExecutorType);
			}
		}
		return super.visitCGTypeExp(cgTypeExp);
	}

	@Override
	public @Nullable Object visitCGVariable(@NonNull CGVariable cgVariable) {
		CGValuedElement init = cgVariable.getInit();
		if (init != null) {
			init.accept(this);
		}
		return null;
	}

	@Override
	public @Nullable Object visitCGVariableExp(@NonNull CGVariableExp cgVariableExp) {
		super.visitCGVariableExp(cgVariableExp);
		if (cgVariableExp.isConstant() && !(cgVariableExp.getReferredVariable() instanceof CGParameter)) {
			context.setConstant(cgVariableExp, cgVariableExp.getValue());
		}
//		else if (cgVariableExp.isConstant()) {
//			context.replace(cgVariableExp, cgVariableExp.getReferredVariable().getInit());
//		}
		return null;
	}

	public @Nullable CGElement visiting(@NonNull CGElement visitable) {
		throw new UnsupportedOperationException(getClass().getSimpleName() + ": " + visitable.getClass().getSimpleName());
	}
}
