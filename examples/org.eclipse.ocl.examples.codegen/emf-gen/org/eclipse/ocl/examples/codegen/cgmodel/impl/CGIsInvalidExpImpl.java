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
package org.eclipse.ocl.examples.codegen.cgmodel.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIsInvalidExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.util.CGModelVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CG Is Invalid Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class CGIsInvalidExpImpl extends CGCallExpImpl implements CGIsInvalidExp {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CGIsInvalidExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CGModelPackage.Literals.CG_IS_INVALID_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @Nullable <R> R accept(@NonNull CGModelVisitor<R> visitor) {
		return visitor.visitCGIsInvalidExp(this);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	// Generated from org.eclipse.ocl.examples.build.cgmodel.CGModelSpec$3
	public @Override
	@NonNull CGValuedElement getReferredValuedElement() {
		return source != null ? source : this;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	// Generated from org.eclipse.ocl.examples.build.cgmodel.CGModelSpec$6
	@Override
	public boolean isBoxed() {
		return true;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	// Generated from org.eclipse.ocl.examples.build.cgmodel.CGModelSpec$7
	@Override
	public boolean isCaught() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	// Generated from org.eclipse.ocl.examples.build.cgmodel.CGModelSpec$8
	@Override
	public boolean isConstant() {
		return isFalse() || isTrue();
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	// Generated from org.eclipse.ocl.examples.build.cgmodel.CGModelSpec$9
	@Override
	public boolean isFalse() {
		return (source != null) && source.isNonInvalid();
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	// Generated from org.eclipse.ocl.examples.build.cgmodel.CGModelSpec$11
	@Override
	public boolean isInlineable() {
		return isConstant();
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	// Generated from org.eclipse.ocl.examples.build.cgmodel.CGModelSpec$12
	@Override
	public boolean isInvalid() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	// Generated from org.eclipse.ocl.examples.build.cgmodel.CGModelSpec$13
	@Override
	public boolean isNonInvalid() {
		return true;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	// Generated from org.eclipse.ocl.examples.build.cgmodel.CGModelSpec$14
	@Override
	public boolean isNonNull() {
		return true;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	// Generated from org.eclipse.ocl.examples.build.cgmodel.CGModelSpec$15
	@Override
	public boolean isNull() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	// Generated from org.eclipse.ocl.examples.build.cgmodel.CGModelSpec$18
	@Override
	public boolean isTrue() {
		return (source != null) && source.isInvalid();
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	// Generated from org.eclipse.ocl.examples.build.cgmodel.CGModelSpec$19
	@Override
	public boolean isUnboxed() {
		return true;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	// Generated from org.eclipse.ocl.examples.build.cgmodel.CGModelSpec$20
	@Override
	public void setCaught(boolean isCaught) {
		assert !isCaught;
	}

	@Override
	public boolean isValidating() {
		return true;
	}
} //CGIsInvalidExpImpl
