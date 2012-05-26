/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.pivot.context;

import org.eclipse.emf.common.util.URI;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;

/**
 * OperationContext supports parsing OCL expressions in the context of an Operation.
 */
public class OperationContext extends ClassContext
{
	private final Operation operationContext;
	private final String resultVariableName;		// Null for none
	
	public OperationContext(MetaModelManager metaModelManager, URI uri, Operation operationContext, String resultVariableName) {
		super(metaModelManager, uri, operationContext.getOwningType());
		this.operationContext = operationContext;
		this.resultVariableName = resultVariableName;
	}

	@Override
	public void initialize(Base2PivotConversion conversion, ExpressionInOCL expression) {
		super.initialize(conversion, expression);
		conversion.setParameterVariables(expression, operationContext.getOwnedParameter());
		if (resultVariableName != null) {
			conversion.setResultVariable(expression, operationContext, resultVariableName);
		}
	}
}
