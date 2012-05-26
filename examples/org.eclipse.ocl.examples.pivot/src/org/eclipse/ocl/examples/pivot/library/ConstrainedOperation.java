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

import org.eclipse.ocl.examples.domain.elements.DomainCallExp;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.InvalidEvaluationException;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.library.AbstractOperation;
import org.eclipse.ocl.examples.domain.library.LibraryBinaryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryTernaryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryUnaryOperation;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.OclExpression;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitor;

/**
 * An instance of ConstrainedOperation supports evaluation of
 * an operation defined by constraints.
 */
public class ConstrainedOperation extends AbstractOperation implements LibraryUnaryOperation, LibraryBinaryOperation, LibraryTernaryOperation
{
	protected final ExpressionInOCL expressionInOCL;
	
	public ConstrainedOperation(ExpressionInOCL expressionInOCL) {
		this.expressionInOCL = expressionInOCL;
	}

	public Value evaluate(DomainEvaluator evaluator, DomainCallExp callExp, Value sourceValue, Value... argumentValues) throws InvalidEvaluationException, InvalidValueException {
		EvaluationVisitor evaluationVisitor = (EvaluationVisitor)evaluator;
		EvaluationVisitor nestedVisitor = evaluationVisitor.createNestedEvaluator();
		EvaluationEnvironment nestedEvaluationEnvironment = nestedVisitor.getEvaluationEnvironment();
		nestedEvaluationEnvironment.add(expressionInOCL.getContextVariable(), sourceValue);
		List<Variable> parameters = expressionInOCL.getParameterVariable();
		if (!parameters.isEmpty()) {
			List<OclExpression> arguments = ((OperationCallExp)callExp).getArgument();
			for (int i = 0; i < parameters.size(); i++) {
				OclExpression argument = arguments.get(i);
				Value value = argument.accept(evaluationVisitor);
				nestedEvaluationEnvironment.add(parameters.get(i).getRepresentedParameter(), value);
			}
		}
		return expressionInOCL.accept(nestedVisitor);
	}

	public Value evaluate(DomainEvaluator evaluator, DomainType returnType, Value sourceValue) throws InvalidValueException {
		EvaluationVisitor evaluationVisitor = (EvaluationVisitor)evaluator;
		EvaluationVisitor nestedVisitor = evaluationVisitor.createNestedEvaluator();
		EvaluationEnvironment nestedEvaluationEnvironment = nestedVisitor.getEvaluationEnvironment();
		nestedEvaluationEnvironment.add(expressionInOCL.getContextVariable(), sourceValue);
		return expressionInOCL.accept(nestedVisitor);
	}

	public Value evaluate(DomainEvaluator evaluator, DomainType returnType, Value sourceValue, Value argumentValue) throws InvalidValueException {
		EvaluationVisitor evaluationVisitor = (EvaluationVisitor)evaluator;
		EvaluationVisitor nestedVisitor = evaluationVisitor.createNestedEvaluator();
		EvaluationEnvironment nestedEvaluationEnvironment = nestedVisitor.getEvaluationEnvironment();
		nestedEvaluationEnvironment.add(expressionInOCL.getContextVariable(), sourceValue);
		List<Variable> parameters = expressionInOCL.getParameterVariable();
		nestedEvaluationEnvironment.add(parameters.get(0).getRepresentedParameter(), argumentValue);
		return expressionInOCL.accept(nestedVisitor);
	}

	public Value evaluate(DomainEvaluator evaluator, DomainType returnType, Value sourceValue, Value firstArgumentValue, Value secondArgumentValue) throws InvalidValueException {
		EvaluationVisitor evaluationVisitor = (EvaluationVisitor)evaluator;
		EvaluationVisitor nestedVisitor = evaluationVisitor.createNestedEvaluator();
		EvaluationEnvironment nestedEvaluationEnvironment = nestedVisitor.getEvaluationEnvironment();
		nestedEvaluationEnvironment.add(expressionInOCL.getContextVariable(), sourceValue);
		List<Variable> parameters = expressionInOCL.getParameterVariable();
		nestedEvaluationEnvironment.add(parameters.get(0).getRepresentedParameter(), firstArgumentValue);
		nestedEvaluationEnvironment.add(parameters.get(1).getRepresentedParameter(), secondArgumentValue);
		return expressionInOCL.accept(nestedVisitor);
	}
}