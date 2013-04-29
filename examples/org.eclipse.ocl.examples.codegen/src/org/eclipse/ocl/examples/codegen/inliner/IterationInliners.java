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
package org.eclipse.ocl.examples.codegen.inliner;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.analyzer.Pivot2CGAnalysisVisitor;
import org.eclipse.ocl.examples.codegen.cgmodel.CGConstantExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGLocalVariable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelFactory;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGWhileExp;
import org.eclipse.ocl.examples.codegen.generator.CodeGenerator;
import org.eclipse.ocl.examples.library.iterator.AnyIteration;
import org.eclipse.ocl.examples.pivot.LoopExp;

public class IterationInliners
{
	public IterationInliners(@NonNull CodeGenerator codeGenerator) { // FIXME IterateIteration
		codeGenerator.addInliner(AnyIteration.class, new AnyIterationInliner());
//		codeGenerator.addInliner(CollectIteration.class, new CollectIterationInliner(codeGenerator));
//		codeGenerator.addInliner(CollectNestedIteration.class, new CollectNestedIterationInliner(codeGenerator));
//		codeGenerator.addInliner(ExistsIteration.class, new ExistsIterationInliner(codeGenerator)); // FIXME exists2
//		codeGenerator.addInliner(ForAllIteration.class, new ForAllIterationInliner(codeGenerator)); // FIXME forAll2
//		codeGenerator.addInliner(IsUniqueIteration.class, new IsUniqueIterationInliner(codeGenerator));
//		codeGenerator.addInliner(OneIteration.class, new OneIterationInliner(codeGenerator));
//		codeGenerator.addInliner(RejectIteration.class, new RejectIterationInliner(codeGenerator));
//		codeGenerator.addInliner(SelectIteration.class, new SelectIterationInliner(codeGenerator));
	}

	public static abstract class AbstractIterationInliner extends AbstractInliner implements IterationInliner
	{
	}
	
	public static class AnyIterationInliner extends AbstractIterationInliner
	{
		public @NonNull CGWhileExp analyzeLoopExp(@NonNull Pivot2CGAnalysisVisitor visitor, @NonNull LoopExp loopExp) {
			CGWhileExp cgWhileExp = CGModelFactory.eINSTANCE.createCGWhileExp();
			//
			CGLocalVariable cgLoopVariable = CGModelFactory.eINSTANCE.createCGLocalVariable();
			// type, name
//			cgWhileExp.setVariableValue(cgLoopVariable);
			//
			CGValuedElement bodyExpression = visitor.getExpression(loopExp);
//			bodyExpression.setVariableValue(cgLoopVariable);
			cgWhileExp.setBodyExpression(bodyExpression);
			//
			CGValuedElement condition = CGModelFactory.eINSTANCE.createCGIfExp();
//			cgWhileExp.getLocalVariables().add(cgLoopVariable);
			cgWhileExp.setCondition(condition);
			//
			CGConstantExp finallyExpression = CGModelFactory.eINSTANCE.createCGConstantExp();
			finallyExpression.setReferredConstant(visitor.getAnalyzer().getInvalid("No matching content for 'any'"));
			cgWhileExp.setFinallyExpression(finallyExpression);
			//
			return cgWhileExp;
		}
		
//		@Override
		public @NonNull String getName() { return "any"; }
	}
}
