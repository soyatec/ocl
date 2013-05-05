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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalyzer;
import org.eclipse.ocl.examples.codegen.analyzer.Pivot2CGAnalysisVisitor;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariable;
import org.eclipse.ocl.examples.pivot.Variable;

public final class OCLinEcorePivot2CGAnalysisVisitor extends Pivot2CGAnalysisVisitor
{
	protected final @NonNull OCLinEcoreGlobalContext globalContext;
	
	public OCLinEcorePivot2CGAnalysisVisitor(@NonNull CodeGenAnalyzer analyzer, @NonNull OCLinEcoreGlobalContext globalContext) {
		super(analyzer);
		this.globalContext = globalContext;
	}

	@Override
	public @NonNull CGVariable getSelfParameter(@NonNull Variable aParameter) {
		return super.getSelfParameter(aParameter);
/*		CGVariable cgParameter = basicGetParameter(aParameter);
		if (cgParameter == null) {
			cgParameter = CGModelFactory.eINSTANCE.createCGFinalVariable();
			context.setNames(cgParameter, aParameter);
			setPivot(cgParameter, aParameter);
//			cgParameter.setTypeId(context.getTypeId(TypeId.OCL_VOID));			// FIXME Java-specific
//			addParameter(aParameter, cgParameter);
//			cgParameter = CGModelFactory.eINSTANCE.createCGParameter();
//			String selfName = globalContext.getSelfName();
//			if (selfName.equals(aParameter.getName())) {
//				cgParameter.setName(selfName);
//				cgParameter.setValueName("this");
				cgParameter.setNonInvalid();
				cgParameter.setNonNull();
//			}
//			else {
				context.setNames(cgParameter, aParameter);
//			}
//			setPivot(cgParameter, aParameter); * /
//				cgParameter.setTypeId(context.getTypeId(TypeId.OCL_VOID));			// FIXME Java-specific
			Type pivotType = PivotUtil.getContainingType(aParameter);
			if (pivotType != null) {
				Class<?> javaClass = globalContext.getCodeGenerator().getGenModelHelper().getEcoreInterfaceClass(pivotType);
				cgParameter.setTypeId(context.getTypeId(JavaConstants.getJavaTypeId(javaClass)));
			}
			addParameter(aParameter, cgParameter);
			CGText thisText = CGModelFactory.eINSTANCE.createCGText();
//			setNames(thisText, JavaConstants.EVALUATOR_NAME, JavaConstants.EVALUATOR_TYPE_ID);
			thisText.setTextValue("this");
			cgParameter.setInit(thisText);
		}
		return cgParameter; */
	}
}
