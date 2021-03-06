/*******************************************************************************
 * Copyright (c) 2009, 2011 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************
 * $Id: FunctionFromMethodExpr.java,v 1.2 2011/03/05 21:37:37 auhl Exp $
 */
package dataaccess.expressions.fp;

import data.classes.MethodSignature;

import dataaccess.expressions.ObjectBasedExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function From Method Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The getType() implementation for this expression type could infer the function type definition from the method signature. However, this would require constructing such a value from within OCL.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link dataaccess.expressions.fp.FunctionFromMethodExpr#getMethod <em>Method</em>}</li>
 * </ul>
 * </p>
 *
 * @see dataaccess.expressions.fp.FpPackage#getFunctionFromMethodExpr()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL SignatureAvailableOnObjectsClass='self.object.getType().oclIsKindOf(data::classes::ClassTypeDefinition) and\r\n  self.object.getType().oclAsType(data::classes::ClassTypeDefinition).clazz.conformsTo(self.method.owner.oclAsType(data::classes::SapClass))' MethodSignatureConformsToFunctionSignature='self.getType().oclIsKindOf(data::classes::FunctionSignatureTypeDefinition) and\r\n    self.method.conformsTo(self.getType().oclAsType(data::classes::FunctionSignatureTypeDefinition).signature)'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='SignatureAvailableOnObjectsClass MethodSignatureConformsToFunctionSignature'"
 * @generated
 */
public interface FunctionFromMethodExpr extends ObjectBasedExpression {
	/**
	 * Returns the value of the '<em><b>Method</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Method</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Method</em>' reference.
	 * @see #setMethod(MethodSignature)
	 * @see dataaccess.expressions.fp.FpPackage#getFunctionFromMethodExpr_Method()
	 * @model required="true"
	 * @generated
	 */
	MethodSignature getMethod();

	/**
	 * Sets the value of the '{@link dataaccess.expressions.fp.FunctionFromMethodExpr#getMethod <em>Method</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Method</em>' reference.
	 * @see #getMethod()
	 * @generated
	 */
	void setMethod(MethodSignature value);

} // FunctionFromMethodExpr
