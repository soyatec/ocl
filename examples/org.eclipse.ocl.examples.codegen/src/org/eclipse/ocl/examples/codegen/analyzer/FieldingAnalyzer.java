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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.CallExp;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.PropertyCallExp;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.VariableDeclaration;
import org.eclipse.ocl.examples.pivot.VariableExp;

/**
 * A FieldingAnalyzer identifies the necessary catches and throws.
 */
public class FieldingAnalyzer
{	
	protected final @NonNull CodeGenAnalyzer analyzer;
	protected final @NonNull CodeGenAnalysis rootAnalysis;
	private final List<VariableExp> variables = new ArrayList<VariableExp>();
	private final List<OperationCallExp> validators = new ArrayList<OperationCallExp>();
	private final List<CallExp> invalidators = new ArrayList<CallExp>();
	private final Set<VariableDeclaration> caughtVariables = new HashSet<VariableDeclaration>();
	private final Set<VariableDeclaration> thrownVariables = new HashSet<VariableDeclaration>();
	
	public FieldingAnalyzer(@NonNull CodeGenAnalyzer analyzer, @NonNull CodeGenAnalysis rootAnalysis) {
		this.analyzer = analyzer;
		this.rootAnalysis = rootAnalysis;
	}

	public void analyze() {
		buildLists(rootAnalysis);
		for (VariableExp variableExp : variables) {
			CodeGenAnalysis thisAnalysis = analyzer.getAnalysis(variableExp);
			
			VariableDeclaration referredVariable = variableExp.getReferredVariable();
//			if (caughtVariables.contains(referredVariable)) {
				if (thisAnalysis.isCatching() && thisAnalysis.isThrowing()) {
					CodeGenAnalysis child = thisAnalysis;
					for (CodeGenAnalysis parent; (parent = child.getParent()) != null; child = parent) {
						if (!parent.isValidating()) {
							OCLExpression initExpression = ((Variable)referredVariable).getInitExpression();
//							parent.addInvalidGuard(analyzer.getAnalysis(initExpression));
							break;
						}
					}
				}
//			}
			if (referredVariable instanceof Variable) {
				OCLExpression initExpression = ((Variable)referredVariable).getInitExpression();
/*				if (initExpression != null) {
					CodeGenAnalysis initAnalysis = analyzer.getAnalysis(initExpression);
					if (!caughtVariables.contains(referredVariable)) {
//					if (!thisAnalysis.isCatching()) {
						thisAnalysis.setDelegateTo(initAnalysis);
					}
					if (initAnalysis.isInvalid()) {
						thisAnalysis.setInvalid();
					}
				}
				else {
					CodeGenAnalysis variableAnalysis = analyzer.getAnalysis(referredVariable);
					thisAnalysis.setDelegateTo(variableAnalysis);
					if (variableAnalysis.isInvalid()) {
						thisAnalysis.setInvalid();
					}
				} */
			}
		}
	}

	public void buildLists(@NonNull CodeGenAnalysis thisAnalysis) {
		Element expression = thisAnalysis.getExpression();
		if (expression instanceof VariableExp) {
			VariableExp variableExp = (VariableExp)expression;
			variables.add(variableExp);
			if (isValidating(variableExp.eContainer())) {
				thisAnalysis.setCatching();
				caughtVariables.add(variableExp.getReferredVariable());
			}
			else {
				thisAnalysis.setThrowing();
				thrownVariables.add(variableExp.getReferredVariable());
			}
		}
		else if (expression instanceof OperationCallExp) {
			OperationCallExp operationCall = (OperationCallExp)expression;
			Operation operation = operationCall.getReferredOperation();
			if (operation.isValidating()) {
				thisAnalysis.setValidating();
				validators.add(operationCall);
			}
			if (operation.isInvalidating()) {
				thisAnalysis.setInvalidating();
				invalidators.add(operationCall);
			}
//			if (operation.isRequired()) {
//				
//			}
		}
		else if (expression instanceof PropertyCallExp) {
			PropertyCallExp propertyCall = (PropertyCallExp)expression;
			Property property = propertyCall.getReferredProperty();
//			if (property.isValidating()) {
//				validators.add(operationCall);
//			}
			if (true /*property.isInvalidating()*/) {
				thisAnalysis.setInvalidating();
//				invalidators.add(operationCall);
			}
//			if (operation.isRequired()) {
//				
//			}
		}
		CodeGenAnalysis[] childAnalyses = thisAnalysis.getChildren();
		if (childAnalyses != null) {
			for (CodeGenAnalysis childAnalysis : childAnalyses) {
				assert childAnalysis != null;
				buildLists(childAnalysis);
			}
		}
	}

	protected boolean isValidating(EObject eObject) {
		if (eObject instanceof OperationCallExp) {
			OperationCallExp operationCall = (OperationCallExp)eObject;
			Operation operation = operationCall.getReferredOperation();
			if (operation.isValidating()) {
				return true;
			}
		}
		return false;
	}
}
