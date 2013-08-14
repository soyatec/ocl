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
package org.eclipse.ocl.examples.codegen.oclinecore;

import org.eclipse.emf.codegen.ecore.genmodel.GenParameter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalyzer;
import org.eclipse.ocl.examples.codegen.analyzer.Pivot2CGVisitor;
import org.eclipse.ocl.examples.codegen.cgmodel.CGParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.VariableDeclaration;
import org.eclipse.ocl.examples.pivot.VariableExp;

public final class OCLinEcorePivot2CGVisitor extends Pivot2CGVisitor
{
	protected final @NonNull OCLinEcoreGlobalContext globalContext;
	
	public OCLinEcorePivot2CGVisitor(@NonNull CodeGenAnalyzer analyzer, @NonNull OCLinEcoreGlobalContext globalContext) {
		super(analyzer);
		this.globalContext = globalContext;
	}

	@Override
	protected void addParameter(@NonNull Variable aParameter, @NonNull CGParameter cgParameter) {
		super.addParameter(aParameter, cgParameter);
		Parameter representedParameter = aParameter.getRepresentedParameter();
		if (representedParameter != null) {
			GenParameter genParameter = genModelHelper.getGenParameter(representedParameter);
			if (genParameter != null) {
				String name = DomainUtil.nonNullState(genParameter.getName());
				cgParameter.setValueName(name);
				// reserve name
			}
		}
	}

	@Override
	public @Nullable CGValuedElement visitVariableExp(@NonNull VariableExp pVariableExp) {
		VariableDeclaration referredVariable = pVariableExp.getReferredVariable();
		if (referredVariable != null) {
			EObject eContainer = referredVariable.eContainer();
			if (eContainer instanceof ExpressionInOCL) {
				Variable contextVariable = ((ExpressionInOCL)eContainer).getContextVariable();
				if (referredVariable == contextVariable) {
					return globalContext.createSelfParameter(contextVariable);
				}
			}
		}
		return super.visitVariableExp(pVariableExp);
	}
}
