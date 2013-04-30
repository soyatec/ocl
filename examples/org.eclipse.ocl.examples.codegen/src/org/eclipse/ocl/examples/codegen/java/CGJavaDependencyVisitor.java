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
package org.eclipse.ocl.examples.codegen.java;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.CGDependencyVisitor;
import org.eclipse.ocl.examples.codegen.cgmodel.CGBoxExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorType;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTypeExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.domain.ids.TypeId;

public class CGJavaDependencyVisitor extends CGDependencyVisitor
{	
	protected final @NonNull JavaGlobalContext globalContext;
	protected final JavaLocalContext localContext;

//	public CGJavaDependencyVisitor(@NonNull JavaGlobalContext globalContext) {
//        super(globalContext.getAnalyzer());
//        this.globalContext = globalContext;
//        this.localContext = null;
//	}
	
	public CGJavaDependencyVisitor(@NonNull JavaLocalContext localContext) {
        super(localContext.getAnalyzer());
        this.globalContext = localContext.getGlobalContext();
        this.localContext = localContext;
	}

	@Override
	public @Nullable Object visitCGBoxExp(@NonNull CGBoxExp cgBoxExp) {
		TypeId typeId = cgBoxExp.getSource().getPivotTypeId();
		addDependency(cgBoxExp, context.getElementId(typeId));
		typeId.accept(id2DependencyVisitor);						// FIXME this should be automatic (needed for OclAny testNotEqual)
		return super.visitCGBoxExp(cgBoxExp);
	}

	@Override
	public @Nullable Object visitCGExecutorType(@NonNull CGExecutorType cgTypeWithReflection) {
		addDependency(cgTypeWithReflection, localContext.getIdResolverVariable());
		cgTypeWithReflection.setTypeId(context.getTypeId(JavaConstants.DOMAIN_TYPE_TYPE_ID));		// FIXME
		return super.visitCGExecutorType(cgTypeWithReflection);
	}

	@Override
	public @Nullable Object visitCGTypeExp(@NonNull CGTypeExp cgTypeExp) {
		CGValuedElement variableValue = cgTypeExp.getValue();
		variableValue.accept(this);
		addDependency(cgTypeExp, variableValue);
//		addDependency(cgVariable, cgVariable.getTypeId());
//		ElementId elementId = ((CGType)cgTypeVariable.getVariableValue()).getElementId();
//		CGElementId cgElementId = context.getElementId(elementId);
//		addDependency(cgTypeVariable, cgElementId);
		addDependency(cgTypeExp, cgTypeExp.getReferredType());
		return super.visitCGTypeExp(cgTypeExp);
	}
}
