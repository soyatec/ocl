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

import org.eclipse.emf.ecore.EOperation;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainCallExp;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluationEnvironment;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.library.AbstractPolyOperation;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.OpaqueExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.ParserException;
import org.eclipse.ocl.examples.pivot.ValueSpecification;
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
	protected final @NonNull EOperation eFeature;
	protected @NonNull ValueSpecification specification;
	private ExpressionInOCL expressionInOCL = null;

	public EObjectOperation(@NonNull EOperation eFeature, @NonNull ValueSpecification specification) {
		this.eFeature = eFeature;
		this.specification = specification;
	}

	@Override
	public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainCallExp callExp, @NonNull Value sourceValue) throws InvalidValueException {
		if (expressionInOCL == null) {		
			resolveExpressionInOCL(evaluator, callExp, sourceValue);
		}
		return evaluate(evaluator, DomainUtil.nonNullPivot(callExp.getType()), sourceValue);
	}

	public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, @NonNull Value sourceValue) throws InvalidValueException {
		DomainEvaluator nestedEvaluator = evaluator.createNestedEvaluator();
		DomainEvaluationEnvironment nestedEvaluationEnvironment = nestedEvaluator.getEvaluationEnvironment();
		nestedEvaluationEnvironment.add(expressionInOCL.getContextVariable(), sourceValue);
		return nestedEvaluator.evaluate(expressionInOCL.getBodyExpression());
	}

	@Override
	public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainCallExp callExp, @NonNull Value sourceValue, @NonNull Value argumentValue) throws InvalidValueException {
		if (expressionInOCL == null) {		
			resolveExpressionInOCL(evaluator, callExp, sourceValue);
		}
		return evaluate(evaluator, DomainUtil.nonNullPivot(callExp.getType()), sourceValue, argumentValue);
	}

	public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, @NonNull Value sourceValue, @NonNull Value argumentValue) throws InvalidValueException {
		DomainEvaluator nestedEvaluator = evaluator.createNestedEvaluator();
		DomainEvaluationEnvironment nestedEvaluationEnvironment = nestedEvaluator.getEvaluationEnvironment();
		nestedEvaluationEnvironment.add(expressionInOCL.getContextVariable(), sourceValue);
		List<Variable> parameterVariables = expressionInOCL.getParameterVariable();
		nestedEvaluationEnvironment.add(parameterVariables.get(0).getRepresentedParameter(), argumentValue);
		return nestedEvaluator.evaluate(expressionInOCL.getBodyExpression());
	}

	@Override
	public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainCallExp callExp, @NonNull Value sourceValue, @NonNull Value firstArgumentValue, @NonNull Value secondArgumentValue) throws InvalidValueException {
		if (expressionInOCL == null) {		
			resolveExpressionInOCL(evaluator, callExp, sourceValue);
		}
		return evaluate(evaluator, DomainUtil.nonNullPivot(callExp.getType()), sourceValue, firstArgumentValue, secondArgumentValue);
	}

	public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, @NonNull Value sourceValue, @NonNull Value firstArgumentValue, @NonNull Value secondArgumentValue) throws InvalidValueException {
		DomainEvaluator nestedEvaluator = evaluator.createNestedEvaluator();
		DomainEvaluationEnvironment nestedEvaluationEnvironment = nestedEvaluator.getEvaluationEnvironment();
		nestedEvaluationEnvironment.add(expressionInOCL.getContextVariable(), sourceValue);
		List<Variable> parameterVariables = expressionInOCL.getParameterVariable();
		nestedEvaluationEnvironment.add(parameterVariables.get(0).getRepresentedParameter(), firstArgumentValue);
		nestedEvaluationEnvironment.add(parameterVariables.get(1).getRepresentedParameter(), secondArgumentValue);
		return nestedEvaluator.evaluate(expressionInOCL.getBodyExpression());
	}

	public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainCallExp callExp, @NonNull Value sourceValue, Value... argumentValues) throws InvalidValueException {
		if (expressionInOCL == null) {		
			resolveExpressionInOCL(evaluator, callExp, sourceValue);
		}
		DomainEvaluator nestedEvaluator = evaluator.createNestedEvaluator();
		DomainEvaluationEnvironment nestedEvaluationEnvironment = nestedEvaluator.getEvaluationEnvironment();
		nestedEvaluationEnvironment.add(expressionInOCL.getContextVariable(), sourceValue);
		List<Variable> parameterVariables = expressionInOCL.getParameterVariable();
		int iMax = Math.min(parameterVariables.size(), argumentValues.length);
		for (int i = 0; i < iMax; i++) {
			nestedEvaluationEnvironment.add(parameterVariables.get(i).getRepresentedParameter(), argumentValues[i]);
		}
		return nestedEvaluator.evaluate(expressionInOCL.getBodyExpression());
	}

	protected void resolveExpressionInOCL(@NonNull DomainEvaluator evaluator, @NonNull DomainCallExp callExp, @NonNull Value sourceValue) {
		if (specification instanceof ExpressionInOCL) {
			expressionInOCL = (ExpressionInOCL) specification;
		}
		else {
			if (specification instanceof OpaqueExpression) {
				Operation operation = ((OperationCallExp)callExp).getReferredOperation();
				if (operation != null) {
					String string = PivotUtil.getBody((OpaqueExpression) specification);
					if (string != null) {
						EvaluationVisitor evaluationVisitor = (EvaluationVisitor)evaluator;
						MetaModelManager metaModelManager = evaluationVisitor.getMetaModelManager();
						try {
							ParserContext operationContext = new OperationContext(metaModelManager, null, operation, null);
							expressionInOCL = operationContext.parse(string);
						} catch (ParserException e) {
							evaluator.throwInvalidEvaluation(e, callExp, sourceValue, "parse failure");
						}
					}
				}
			}
			if (expressionInOCL == null) {
				Operation operation = ((OperationCallExp)callExp).getReferredOperation();
				evaluator.throwInvalidEvaluation(null, callExp, sourceValue, "No specification for '" + operation + "'");
			}
		}
	}
}