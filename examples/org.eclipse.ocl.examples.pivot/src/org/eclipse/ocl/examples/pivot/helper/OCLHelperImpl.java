/**
 * <copyright>
 *
 * Copyright (c) 2007,2011 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: OCLHelperImpl.java,v 1.6 2011/04/20 19:02:47 ewillink Exp $
 */

package org.eclipse.ocl.examples.pivot.helper;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.ocl.examples.pivot.Environment;
import org.eclipse.ocl.examples.pivot.EnvironmentFactory;
import org.eclipse.ocl.examples.pivot.ExpressionInOcl;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.ParserException;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.model.OclMetaModel;
import org.eclipse.ocl.examples.pivot.utilities.PivotEnvironment;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

/**
 * Implementation of the {@link OclMetaModel.Helper} convenience interface.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class OCLHelperImpl implements OCLHelper
{
    private final OCL ocl;
	private final EnvironmentFactory environmentFactory;
	private Environment env;

	private boolean validating = true;
    
    private Diagnostic problems;
    
	/**
	 * Initializes me with my environment.
	 * 
	 * @param ocl the OCL environment
	 */
    public OCLHelperImpl(OCL ocl) {
        this.ocl = ocl;
		environmentFactory = ocl.getEnvironment().getFactory();
	}

	public ExpressionInOcl createBodyCondition(String expression) throws ParserException {
		return createSpecification(expression);
	}

	public ExpressionInOcl createDerivedValueExpression(String expression) throws ParserException {
		return createSpecification(expression);
	}

	public ExpressionInOcl createInvariant(String expression) throws ParserException {
		return createSpecification(expression);
	}

	public ExpressionInOcl createPostcondition(String expression) throws ParserException {
		return createSpecification(expression);
	}

	public ExpressionInOcl createPrecondition(String expression) throws ParserException {
		return createSpecification(expression);
	}

	public ExpressionInOcl createQuery(String expression) throws ParserException {
		return createSpecification(expression);
	}

	protected ExpressionInOcl createSpecification(String expression) throws ParserException {
		PivotEnvironment environment = (PivotEnvironment) getEnvironment();
		MetaModelManager metaModelManager = environment.getMetaModelManager();
		Type contextClassifier = environment.getContextClassifier();
		URI uri = metaModelManager.getResourceIdentifier(expression, null);
		return PivotUtil.resolveSpecification(metaModelManager, uri, contextClassifier, expression);
	}
	
	public Property getContextAttribute() {
		return env.getContextProperty();
	}
	
	public Type getContextClassifier() {
		return env.getContextClassifier();
	}
	
	public Operation getContextOperation() {
		return env.getContextOperation();
	}
	
	public Environment getEnvironment() {
		return env == null ? ocl.getEnvironment() : env;
	}
	
    public OCL getOCL() {
        return ocl;
    }
	
	public Diagnostic getProblems() {
		return problems;
	}
    
	public boolean isValidating() {
		return validating;
	}
	
	public void setAttributeContext(Type context, Property property) {
        setContext(context);
		setEnvironment(environmentFactory.createAttributeContext(getEnvironment(), property));
	}
	
	public void setContext(Type context) {
		setEnvironment(environmentFactory.createClassifierContext(getEnvironment(), context));
	}
	
	private void setEnvironment(Environment env) {
		this.env = env;
	}
    
    public void setInstanceAttributeContext(Object instance, Property property) {
        setInstanceContext(instance);
        setEnvironment(environmentFactory.createAttributeContext(getEnvironment(), property));
    }
    
    public void setInstanceContext(Object instance) {
        setEnvironment(environmentFactory.createInstanceContext(getEnvironment(), instance));
    }
    
    public void setInstanceOperationContext(Object instance, Operation operation) {
        setInstanceContext(instance);
        setEnvironment(environmentFactory.createOperationContext(getEnvironment(), operation));
    }
	
	public void setOperationContext(Type context, Operation operation) {
        setContext(context);
		setEnvironment(environmentFactory.createOperationContext(getEnvironment(), operation));
	}
	
	void setProblems(Diagnostic problems) {
		this.problems = problems;
	}
	
	public void setValidating(boolean validating) {
		this.validating = validating;
	}
}
