/**
 * <copyright>
 *
 * Copyright (c) 2010, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: OpaqueExpression.java,v 1.3 2011/03/01 08:47:19 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Opaque Expression</b></em>'.
 * @extends org.eclipse.ocl.examples.domain.elements.DomainExpression
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An opaque expression is an uninterpreted textual statement that denotes a (possibly empty) set of values when evaluated in a context.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.OpaqueExpression#getBody <em>Body</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.OpaqueExpression#getExpressionInOCL <em>Expression In OCL</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.OpaqueExpression#getLanguage <em>Language</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getOpaqueExpression()
 * @generated
 */
public interface OpaqueExpression
		extends ValueSpecification, org.eclipse.ocl.examples.domain.elements.DomainExpression {

	/**
	 * Returns the value of the '<em><b>Body</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The text of the expression, possibly in multiple languages.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Body</em>' attribute list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getOpaqueExpression_Body()
	 * @generated
	 */
	List<String> getBody();

	/**
	 * Returns the value of the '<em><b>Expression In OCL</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression In OCL</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression In OCL</em>' containment reference.
	 * @see #setExpressionInOCL(ExpressionInOCL)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getOpaqueExpression_ExpressionInOCL()
	 * @generated
	 */
	@Nullable ExpressionInOCL getExpressionInOCL();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.OpaqueExpression#getExpressionInOCL <em>Expression In OCL</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression In OCL</em>' containment reference.
	 * @see #getExpressionInOCL()
	 * @generated
	 */
	void setExpressionInOCL(ExpressionInOCL value);

	/**
	 * Returns the value of the '<em><b>Language</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specifies the languages in which the expression is stated. The interpretation of the expression body depends on the languages. If the languages are unspecified, they might be implicit from the expression body or the context. Languages are matched to body strings by order.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Language</em>' attribute list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getOpaqueExpression_Language()
	 * @generated
	 */
	List<String> getLanguage();
	
	/**
	 * @generated NOT
	 */
	@NonNull ExpressionInOCL getValidExpressionInOCL() throws ParserException;
} // OpaqueExpression
