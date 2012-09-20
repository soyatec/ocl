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
 * $Id: ConstrainedOperation.java,v 1.1 2011/04/27 06:19:59 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.library;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainCallExp;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractPolyOperation;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitor;

/**
 * An instance of ConstrainedOperation supports evaluation of
 * an operation defined by constraints.
 */
public class ConstrainedOperation extends AbstractPolyOperation
{
	protected final @NonNull ExpressionInOCL expressionInOCL;
	
	public ConstrainedOperation(@NonNull ExpressionInOCL expressionInOCL) {
		this.expressionInOCL = expressionInOCL;
	}

	public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainCallExp callExp, @NonNull Object sourceValue, Object... argumentValues) {
		EvaluationVisitor evaluationVisitor = (EvaluationVisitor)evaluator;
		EvaluationVisitor nestedVisitor = evaluationVisitor.createNestedEvaluator();
		EvaluationEnvironment nestedEvaluationEnvironment = nestedVisitor.getEvaluationEnvironment();
		nestedEvaluationEnvironment.add(expressionInOCL.getContextVariable(), sourceValue);
		List<Variable> parameters = expressionInOCL.getParameterVariable();
		if (!parameters.isEmpty()) {
			List<OCLExpression> arguments = ((OperationCallExp)callExp).getArgument();
			for (int i = 0; i < parameters.size(); i++) {
				OCLExpression argument = arguments.get(i);
				Object value = argument.accept(evaluationVisitor);
				nestedEvaluationEnvironment.add(parameters.get(i).getRepresentedParameter(), value);
			}
		}
		return nestedVisitor.evaluate(expressionInOCL);
	}

	public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @NonNull Object sourceValue) {
		EvaluationVisitor evaluationVisitor = (EvaluationVisitor)evaluator;
		EvaluationVisitor nestedVisitor = evaluationVisitor.createNestedEvaluator();
		EvaluationEnvironment nestedEvaluationEnvironment = nestedVisitor.getEvaluationEnvironment();
		nestedEvaluationEnvironment.add(expressionInOCL.getContextVariable(), sourceValue);
		return nestedVisitor.evaluate(expressionInOCL);
	}

	public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @NonNull Object sourceValue, @NonNull Object argumentValue) {
		EvaluationVisitor evaluationVisitor = (EvaluationVisitor)evaluator;
		EvaluationVisitor nestedVisitor = evaluationVisitor.createNestedEvaluator();
		EvaluationEnvironment nestedEvaluationEnvironment = nestedVisitor.getEvaluationEnvironment();
		nestedEvaluationEnvironment.add(expressionInOCL.getContextVariable(), sourceValue);
		List<Variable> parameters = expressionInOCL.getParameterVariable();
		nestedEvaluationEnvironment.add(parameters.get(0).getRepresentedParameter(), argumentValue);
		return nestedVisitor.evaluate(expressionInOCL);
	}

	public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @NonNull Object sourceValue, @NonNull Object firstArgumentValue, @NonNull Object secondArgumentValue) {
		EvaluationVisitor evaluationVisitor = (EvaluationVisitor)evaluator;
		EvaluationVisitor nestedVisitor = evaluationVisitor.createNestedEvaluator();
		EvaluationEnvironment nestedEvaluationEnvironment = nestedVisitor.getEvaluationEnvironment();
		nestedEvaluationEnvironment.add(expressionInOCL.getContextVariable(), sourceValue);
		List<Variable> parameters = expressionInOCL.getParameterVariable();
		nestedEvaluationEnvironment.add(parameters.get(0).getRepresentedParameter(), firstArgumentValue);
		nestedEvaluationEnvironment.add(parameters.get(1).getRepresentedParameter(), secondArgumentValue);
		return nestedVisitor.evaluate(expressionInOCL);
	}
}