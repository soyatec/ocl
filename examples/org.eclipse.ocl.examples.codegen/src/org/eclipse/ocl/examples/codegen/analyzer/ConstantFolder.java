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

import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainExpression;
import org.eclipse.ocl.examples.domain.evaluation.DomainModelManager;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.TypeValue;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueImpl;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.pivot.CallExp;
import org.eclipse.ocl.examples.pivot.CollectionRange;
import org.eclipse.ocl.examples.pivot.Environment;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.LetExp;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.TypedElement;
import org.eclipse.ocl.examples.pivot.VariableDeclaration;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitorImpl;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.utilities.PivotEnvironmentFactory;

/**
 * A ConstantFolder annotates the constant analysis nodes in an analyzed tree with their constant values.
 */
public class ConstantFolder
{	
	protected final @NonNull CodeGenAnalyzer analyzer;
	protected final @NonNull CodeGenAnalysis rootAnalysis;
	protected final @Nullable Set<VariableDeclaration> knownConstants;
	protected final @NonNull EvaluationVisitor evaluator; 
	
	public ConstantFolder(@NonNull CodeGenAnalyzer analyzer, @NonNull CodeGenAnalysis rootAnalysis, @Nullable Set<VariableDeclaration> knownConstants) {
		this.analyzer = analyzer;
		this.rootAnalysis = rootAnalysis;
		this.knownConstants = knownConstants;
		MetaModelManager metaModelManager = analyzer.getMetaModelManager();
		PivotEnvironmentFactory factory = new PivotEnvironmentFactory(null, metaModelManager);
		Environment env = factory.createEnvironment();
		EvaluationEnvironment evalEnv = factory.createEvaluationEnvironment();
		DomainModelManager modelManager = evalEnv.createModelManager(null);
		evaluator = new EvaluationVisitorImpl(env, evalEnv, modelManager);
	}

	/**
	 * Return true if expression is an expression that can be evaluated.
	 */
	protected boolean canBeConstant(@NonNull TypedElement expression) {
		if (expression instanceof ExpressionInOCL) {
			return false;									// Need to generate at least return
		}
		if (expression instanceof CallExp) {
			return false;									// FIXME CG test aid to prevent all JUnit tests being folded to constants
		}
		if (expression instanceof LetExp) {
			return false;									// FIXME CG test aid to prevent all JUnit tests being folded to constants
		}
		if ((expression instanceof OperationCallExp) && (((OperationCallExp)expression).getArgument().size() > 0)) {
			return false;
		}
		return (expression instanceof DomainExpression) || (expression instanceof CollectionRange) /*|| (expression instanceof ExpressionInOCL)*/;
	}
	
	/**
	 * Traverse the analysis tree rooted at thisAnalysis bottom up assigning constant values.
	 * <p>
	 * Returns true if thisAnalysis is a constant.
	 */
	protected boolean foldConstants(@NonNull CodeGenAnalysis thisAnalysis) {
		TypedElement expression = thisAnalysis.getExpression();
		boolean allChildrenAreConstant = true;
		CodeGenAnalysis[] childAnalyses = thisAnalysis.getChildren();
		if (childAnalyses != null) {
			for (CodeGenAnalysis childAnalysis : childAnalyses) {
				assert childAnalysis != null;
				boolean childIsConstant = foldConstants(childAnalysis);
				if (!childIsConstant) {
					allChildrenAreConstant = false;		// thisAnalysis not constant but must continue to analyze all children
				}
			}
		}
		CodeGenAnalysis delegatesTo = thisAnalysis.getDelegatesTo();
		if (delegatesTo != null) {
			return knownConstants == null ? delegatesTo.isStaticConstant() : delegatesTo.isLocalConstant();
		}
		if (!allChildrenAreConstant) {
			return false;
		}
		if (!canBeConstant(expression)) {
			return false;
		}
		Set<VariableDeclaration> directDependencies = thisAnalysis.getDirectDependencies();
		if ((directDependencies != null) && (directDependencies.size() > 0)) {
			Set<VariableDeclaration> knownConstants2 = knownConstants;
			if ((knownConstants2 != null) && (knownConstants2.size() > 0)) {
				if (!knownConstants2.containsAll(directDependencies)) {
					return false;
				}
			}
		}
		Object constantValue;
		try {
			if (expression instanceof DomainExpression) {
				constantValue = evaluator.evaluate((DomainExpression) expression);
			}
			else if (expression instanceof CollectionRange) {
				CollectionRange collectionRange = (CollectionRange) expression;
				Object firstValue = evaluator.evaluate(DomainUtil.nonNullModel(collectionRange.getFirst()));
				Object lastValue = evaluator.evaluate(DomainUtil.nonNullModel(collectionRange.getLast()));
				if ((firstValue instanceof IntegerValue) && (lastValue instanceof IntegerValue)) {
					if (firstValue.equals(lastValue)) {
						constantValue = firstValue;
					}
					else {
						constantValue = ValuesUtil.createRange((IntegerValue)firstValue, (IntegerValue)lastValue);
					}
				}
				else {
					return false;
				}
			}
//			else if (expression instanceof ExpressionInOCL) {
//				constantValue = evaluator.evaluate((ExpressionInOCL) expression);
//			}
			else {
				return false;
			}
		}
		catch (Exception e) {
			constantValue = new InvalidValueImpl(e);
		}
//		if (constantValue != null) {					// null may not be used as an explicit constant
			if (knownConstants == null) {
				if (constantValue instanceof TypeValue) {
					thisAnalysis.setLocalConstantValue(constantValue);
//					thisAnalysis.setStaticConstantValue(((TypeValue)constantValue).getTypeId());					
//					analyzer.getCodeGenerator().getIdName(((TypeValue)constantValue).getTypeId());					
				}
				else {
					thisAnalysis.setStaticConstantValue(constantValue);
				}
			}
			else {
				thisAnalysis.setLocalConstantValue(constantValue);
			}
//		}
		return true;
	}

	/**
	 * Optimize the rootAnalysis tree by eliminating common subexpressions.
	 */
	public void optimize() {
		foldConstants(rootAnalysis);
	}
}
