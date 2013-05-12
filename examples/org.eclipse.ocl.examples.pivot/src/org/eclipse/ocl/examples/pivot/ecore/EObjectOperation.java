/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: EObjectOperation.java,v 1.6 2011/05/07 16:41:22 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.ecore;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainCallExp;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluationEnvironment;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractPolyOperation;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.OpaqueExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.ParserException;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.context.OperationContext;
import org.eclipse.ocl.examples.pivot.context.ParserContext;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

/** 
 * An EObjectOperation provides the standard LibraryOperation to implement an
 * OperationCallExp. When constructed with a null specification, the call returns
 * an invalid. When constructed with a non-null specification,
 * the specification defines the operation body, which if provided as an OpaqueExpression
 * is lazily compiled from OCL source text.
 */
public class EObjectOperation extends AbstractPolyOperation
{
	protected final @NonNull Operation operation;
	protected final @NonNull EOperation eFeature;
	protected @NonNull OpaqueExpression specification;
	private ExpressionInOCL expressionInOCL = null;

	public EObjectOperation(@NonNull Operation operation, @NonNull EOperation eFeature, @NonNull OpaqueExpression specification) {
		this.operation = operation;
		this.eFeature = eFeature;
		this.specification = specification;
	}

	@Deprecated
	public EObjectOperation(@NonNull EOperation eFeature, @NonNull OpaqueExpression specification) {
		this.eFeature = eFeature;
		this.specification = specification;
		EObject constraint = specification.eContainer();
		EObject dynamicOperation = constraint.eContainer();
		assert dynamicOperation instanceof Operation;
		operation = (Operation) dynamicOperation;
	}

	@Override
	public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainCallExp callExp, @Nullable Object sourceValue) {
		if (expressionInOCL == null) {		
			resolveExpressionInOCL(evaluator, callExp, sourceValue);
		}
		return evaluate(evaluator, DomainUtil.nonNullPivot(callExp.getType()).getTypeId(), sourceValue);
	}

	public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue) {
		DomainEvaluator nestedEvaluator = evaluator.createNestedEvaluator();
		DomainEvaluationEnvironment nestedEvaluationEnvironment = nestedEvaluator.getEvaluationEnvironment();
		nestedEvaluationEnvironment.add(DomainUtil.nonNullModel(expressionInOCL.getContextVariable()), sourceValue);
		return nestedEvaluator.evaluate(DomainUtil.nonNullPivot(expressionInOCL.getBodyExpression()));
	}

	@Override
	public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainCallExp callExp, @Nullable Object sourceValue, @Nullable Object argumentValue) {
		if (expressionInOCL == null) {		
			resolveExpressionInOCL(evaluator, callExp, sourceValue);
		}
		return evaluate(evaluator, DomainUtil.nonNullPivot(callExp.getType()).getTypeId(), sourceValue, argumentValue);
	}

	public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue, @Nullable Object argumentValue) {
		DomainEvaluator nestedEvaluator = evaluator.createNestedEvaluator();
		DomainEvaluationEnvironment nestedEvaluationEnvironment = nestedEvaluator.getEvaluationEnvironment();
		nestedEvaluationEnvironment.add(DomainUtil.nonNullModel(expressionInOCL.getContextVariable()), sourceValue);
		List<Variable> parameterVariables = expressionInOCL.getParameterVariable();
		nestedEvaluationEnvironment.add(DomainUtil.nonNullModel(parameterVariables.get(0)), argumentValue);
		return nestedEvaluator.evaluate(DomainUtil.nonNullPivot(expressionInOCL.getBodyExpression()));
	}

	@Override
	public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainCallExp callExp, @Nullable Object sourceValue, @Nullable Object firstArgumentValue, @Nullable Object secondArgumentValue) {
		if (expressionInOCL == null) {		
			resolveExpressionInOCL(evaluator, callExp, sourceValue);
		}
		return evaluate(evaluator, DomainUtil.nonNullPivot(callExp.getType()).getTypeId(), sourceValue, firstArgumentValue, secondArgumentValue);
	}

	public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue, @Nullable Object firstArgumentValue, @Nullable Object secondArgumentValue) {
		DomainEvaluator nestedEvaluator = evaluator.createNestedEvaluator();
		DomainEvaluationEnvironment nestedEvaluationEnvironment = nestedEvaluator.getEvaluationEnvironment();
		nestedEvaluationEnvironment.add(DomainUtil.nonNullModel(expressionInOCL.getContextVariable()), sourceValue);
		List<Variable> parameterVariables = expressionInOCL.getParameterVariable();
		nestedEvaluationEnvironment.add(DomainUtil.nonNullModel(parameterVariables.get(0)), firstArgumentValue);
		nestedEvaluationEnvironment.add(DomainUtil.nonNullModel(parameterVariables.get(1)), secondArgumentValue);
		return nestedEvaluator.evaluate(DomainUtil.nonNullPivot(expressionInOCL.getBodyExpression()));
	}

	public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainCallExp callExp, @Nullable Object sourceValue, Object... argumentValues) {
		if (expressionInOCL == null) {		
			resolveExpressionInOCL(evaluator, callExp, sourceValue);
		}
		DomainEvaluator nestedEvaluator = evaluator.createNestedEvaluator();
		DomainEvaluationEnvironment nestedEvaluationEnvironment = nestedEvaluator.getEvaluationEnvironment();
		nestedEvaluationEnvironment.add(DomainUtil.nonNullModel(expressionInOCL.getContextVariable()), sourceValue);
		List<Variable> parameterVariables = expressionInOCL.getParameterVariable();
		int iMax = Math.min(parameterVariables.size(), argumentValues.length);
		for (int i = 0; i < iMax; i++) {
			nestedEvaluationEnvironment.add(DomainUtil.nonNullModel(parameterVariables.get(i)), argumentValues[i]);
		}
		return nestedEvaluator.evaluate(DomainUtil.nonNullPivot(expressionInOCL.getBodyExpression()));
	}

	protected void resolveExpressionInOCL(@NonNull DomainEvaluator evaluator, @NonNull DomainCallExp callExp, @Nullable Object sourceValue) {
		if (specification instanceof ExpressionInOCL) {
			expressionInOCL = (ExpressionInOCL) specification;
		}
		else {
			String string = PivotUtil.getBody(specification);
			if (string != null) {
				try {
					EvaluationVisitor evaluationVisitor = (EvaluationVisitor)evaluator;
					MetaModelManager metaModelManager = evaluationVisitor.getMetaModelManager();
					ParserContext operationContext = new OperationContext(metaModelManager, null, operation, null);
					expressionInOCL = operationContext.parse(string);
				} catch (ParserException e) {
					throw new InvalidValueException(e, "parse failure", evaluator.getEvaluationEnvironment(), sourceValue, callExp);
				}
			}
			if (expressionInOCL == null) {
				Operation operation = ((OperationCallExp)callExp).getReferredOperation();
				throw new InvalidValueException("No specification for '" + operation + "'", evaluator.getEvaluationEnvironment(), sourceValue, callExp);
			}
		}
	}
}