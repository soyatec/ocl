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
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.pivot.Environment;
import org.eclipse.ocl.examples.pivot.EnvironmentFactory;
import org.eclipse.ocl.examples.pivot.ExpressionInOcl;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.ParserException;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.context.ClassContext;
import org.eclipse.ocl.examples.pivot.context.OperationContext;
import org.eclipse.ocl.examples.pivot.context.ParserContext;
import org.eclipse.ocl.examples.pivot.context.PropertyContext;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.model.OclMetaModel;
import org.eclipse.ocl.examples.pivot.utilities.PivotEnvironment;

/**
 * Implementation of the {@link OclMetaModel.Helper} convenience interface.
 */
public class OCLHelperImpl implements OCLHelper
{
    private final OCL ocl;
	protected final Environment rootEnvironment;
	protected final MetaModelManager metaModelManager;
	protected final EnvironmentFactory environmentFactory;
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
		this.rootEnvironment = ocl.getEnvironment();
		this.metaModelManager = rootEnvironment.getMetaModelManager();
		this.environmentFactory = rootEnvironment.getFactory();
	}

	public ExpressionInOcl createBodyCondition(String expression) throws ParserException {
		PivotEnvironment environment = (PivotEnvironment) getEnvironment();
		MetaModelManager metaModelManager = environment.getMetaModelManager();
		Operation contextOperation = environment.getContextOperation();
		URI uri = metaModelManager.getResourceIdentifier(expression, null);
		ParserContext parserContext = new OperationContext(metaModelManager, uri, contextOperation, null);
		return parserContext.parse(expression);
	}

	public ExpressionInOcl createDerivedValueExpression(String expression) throws ParserException {
		Property contextProperty = getEnvironment().getContextProperty();
		URI uri = metaModelManager.getResourceIdentifier(expression, null);
		ParserContext parserContext = new PropertyContext(metaModelManager, uri, contextProperty);
		return parserContext.parse(expression);
	}

	public ExpressionInOcl createInvariant(String expression) throws ParserException {
		Type contextClassifier = getEnvironment().getContextClassifier();
		URI uri = metaModelManager.getResourceIdentifier(expression, null);
		ParserContext parserContext = new ClassContext(metaModelManager, uri, contextClassifier);
		return parserContext.parse(expression);
	}

	public ExpressionInOcl createPostcondition(String expression) throws ParserException {
		Operation contextOperation = getEnvironment().getContextOperation();
		URI uri = metaModelManager.getResourceIdentifier(expression, null);
		ParserContext parserContext = new OperationContext(metaModelManager, uri, contextOperation, Environment.RESULT_VARIABLE_NAME);
		return parserContext.parse(expression);
	}

	public ExpressionInOcl createPrecondition(String expression) throws ParserException {
		Operation contextOperation = getEnvironment().getContextOperation();
		URI uri = metaModelManager.getResourceIdentifier(expression, null);
		ParserContext parserContext = new OperationContext(metaModelManager, uri, contextOperation, null);
		return parserContext.parse(expression);
	}

	public ExpressionInOcl createQuery(String expression) throws ParserException {
		Type contextClassifier = getEnvironment().getContextClassifier();
		URI uri = metaModelManager.getResourceIdentifier(expression, null);
		ParserContext parserContext = new ClassContext(metaModelManager, uri, contextClassifier);
		return parserContext.parse(expression);
	}

	protected ExpressionInOcl createSpecification(String expression) throws ParserException {
		Type contextClassifier = getEnvironment().getContextClassifier();
		URI uri = metaModelManager.getResourceIdentifier(expression, null);
		ParserContext parserContext = new ClassContext(metaModelManager, uri, contextClassifier);
		return parserContext.parse(expression);
	}
	
	public Property getContextAttribute() {
		return getEnvironment().getContextProperty();
	}
	
	public Type getContextClassifier() {
		return getEnvironment().getContextClassifier();
	}
	
	public Operation getContextOperation() {
		return getEnvironment().getContextOperation();
	}
	
	public Environment getEnvironment() {
		return env == null ? rootEnvironment : env;
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
	
	public void setAttributeContext(EClassifier context, EStructuralFeature property) {
		Type pContext = metaModelManager.getPivotOfEcore(Type.class, context);
		Property pProperty = metaModelManager.getPivotOfEcore(Property.class, property);
		setAttributeContext(pContext, pProperty);
	}
	
	public void setAttributeContext(Type context, Property property) {
        setContext(context);
		setEnvironment(environmentFactory.createAttributeContext(getEnvironment(), property));
	}

	public void setContext(EClassifier context) {
		Type pContext = metaModelManager.getPivotOfEcore(Type.class, context);
		setContext(pContext);
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

	public void setOperationContext(EClassifier context, EOperation operation) {
		Type pContext = metaModelManager.getPivotOfEcore(Type.class, context);
		Operation pOperation = metaModelManager.getPivotOfEcore(Operation.class, operation);
		setOperationContext(pContext, pOperation);
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
