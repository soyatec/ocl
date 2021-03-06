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
 * $Id: FpFactory.java,v 1.2 2011/03/05 21:37:37 auhl Exp $
 */
package dataaccess.expressions.fp;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see dataaccess.expressions.fp.FpPackage
 * @generated
 */
public interface FpFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FpFactory eINSTANCE = dataaccess.expressions.fp.impl.FpFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Anonymous Function Expr</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Anonymous Function Expr</em>'.
	 * @generated
	 */
	AnonymousFunctionExpr createAnonymousFunctionExpr();

	/**
	 * Returns a new object of class '<em>Function From Method Expr</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Function From Method Expr</em>'.
	 * @generated
	 */
	FunctionFromMethodExpr createFunctionFromMethodExpr();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	FpPackage getFpPackage();

} //FpFactory
