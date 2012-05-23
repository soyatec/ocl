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

import java.io.IOException;

import org.eclipse.ocl.examples.pivot.ExpressionInOcl;
import org.eclipse.ocl.examples.pivot.ParserException;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.utilities.BaseResource;

/**
 * A ParserContext captures the context in which source text is parsed.
 * 
 * A derived context is constructed with the relevant context, then createBaseResource
 * creates a Concrete Syntax resource for a Concrete Syntax expression string. Then parse creates
 * a corresponding Abstract Syntax ExpressionInOcl. initialize is invoked during the parse to
 * install the derived context into the ExpressionInOcl.
 */
public interface ParserContext // extends Adapter
{
	/**
	 * Create a Concrete Syntax resource containing the parsed expression.
	 * 
	 * Semantic errors may be found at the Resource.errors
	 * and may be converted to ParseExceptions by invoking
	 * PivitUtil.checkResourceErrors.
	 * 
	 * @throws IOException if resource loading fails
	 */
	BaseResource createBaseResource(String expression) throws IOException;
	
	/**
	 * Return the type of the self variable.
	 */
	Type getClassContext();

	/**
	 * Extract an Abstract Syntax ExpressionInOcl fronm a Concrete Syntax resource.
	 * 
	 * @throws ParserException if parsing fails
	 */
	ExpressionInOcl getExpression(BaseResource resource) throws ParserException;

	/**
	 * Returbn the MetaModelManager in use.
	 */
	MetaModelManager getMetaModelManager();

	/**
	 * Callback to initialize the ExpressionInOcl with the derived context such as
	 * a contextvariable for the self type, parameter and result variables.
	 */
	void initialize(Base2PivotConversion conversion, ExpressionInOcl expression);
	
	/**
	 * Create an Abstract Syntax ExpressionInOcl containing the parsed expression.
	 * 
	 * @throws ParserException if parsing fails
	 */
	ExpressionInOcl parse(String expression) throws ParserException;
}
