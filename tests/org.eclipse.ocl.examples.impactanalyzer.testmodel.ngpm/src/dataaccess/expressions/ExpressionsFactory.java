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
 * $Id: ExpressionsFactory.java,v 1.2 2011/03/05 21:51:23 auhl Exp $
 */
package dataaccess.expressions;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see dataaccess.expressions.ExpressionsPackage
 * @generated
 */
public interface ExpressionsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExpressionsFactory eINSTANCE = dataaccess.expressions.impl.ExpressionsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Variable Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable Expression</em>'.
	 * @generated
	 */
	VariableExpression createVariableExpression();

	/**
	 * Returns a new object of class '<em>Method Call Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Method Call Expression</em>'.
	 * @generated
	 */
	MethodCallExpression createMethodCallExpression();

	/**
	 * Returns a new object of class '<em>Object Creation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Object Creation Expression</em>'.
	 * @generated
	 */
	ObjectCreationExpression createObjectCreationExpression();

	/**
	 * Returns a new object of class '<em>Function Call Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Function Call Expression</em>'.
	 * @generated
	 */
	FunctionCallExpression createFunctionCallExpression();

	/**
	 * Returns a new object of class '<em>This</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>This</em>'.
	 * @generated
	 */
	This createThis();

	/**
	 * Returns a new object of class '<em>Equals</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Equals</em>'.
	 * @generated
	 */
	Equals createEquals();

	/**
	 * Returns a new object of class '<em>Association End Navigation Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Association End Navigation Expression</em>'.
	 * @generated
	 */
	AssociationEndNavigationExpression createAssociationEndNavigationExpression();

	/**
	 * Returns a new object of class '<em>Object Count</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Object Count</em>'.
	 * @generated
	 */
	ObjectCount createObjectCount();

	/**
	 * Returns a new object of class '<em>Replace</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Replace</em>'.
	 * @generated
	 */
	Replace createReplace();

	/**
	 * Returns a new object of class '<em>Navigation Step</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Navigation Step</em>'.
	 * @generated
	 */
	NavigationStep createNavigationStep();

	/**
	 * Returns a new object of class '<em>Head</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Head</em>'.
	 * @generated
	 */
	Head createHead();

	/**
	 * Returns a new object of class '<em>Tail</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tail</em>'.
	 * @generated
	 */
	Tail createTail();

	/**
	 * Returns a new object of class '<em>As List</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>As List</em>'.
	 * @generated
	 */
	AsList createAsList();

	/**
	 * Returns a new object of class '<em>Ternary</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ternary</em>'.
	 * @generated
	 */
	Ternary createTernary();

	/**
	 * Returns a new object of class '<em>Content Equals</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Content Equals</em>'.
	 * @generated
	 */
	ContentEquals createContentEquals();

	/**
	 * Returns a new object of class '<em>Map</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Map</em>'.
	 * @generated
	 */
	Map createMap();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ExpressionsPackage getExpressionsPackage();

} //ExpressionsFactory
