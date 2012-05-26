/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
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
 * $Id: AbstractConversion.java,v 1.4 2011/05/11 19:46:40 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.context;

import java.util.List;
import java.util.Map;

import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.Type;

public interface Base2PivotConversion
{
	void setContextVariable(ExpressionInOCL pivotSpecification, String selfVariableName, Type contextType);
	void setClassifierContext(ExpressionInOCL pivotSpecification, Type contextType);
	void setParameterVariables(ExpressionInOCL pivotSpecification, List<Parameter> parameters);
	void setParameterVariables(ExpressionInOCL pivotSpecification, Map<String, Type> parameters);
	void setResultVariable(ExpressionInOCL pivotSpecification, Operation contextOperation, String resultName);
}