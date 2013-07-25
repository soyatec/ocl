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
import org.eclipse.ocl.examples.codegen.cgmodel.CGConstant;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CG Global Constant</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class CGConstantImpl extends CGValuedElementImpl implements CGConstant {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CGConstantImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CGModelPackage.Literals.CG_CONSTANT;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	// Generated from org.eclipse.ocl.examples.build.cgmodel.CGModelSpec$4
	@Override
	public @NonNull CGValuedElement getValue() {
		return this;
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
	// Generated from org.eclipse.ocl.examples.build.cgmodel.CGModelSpec$8
	@Override
	public boolean isConstant() {
		return true;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	// Generated from org.eclipse.ocl.examples.build.cgmodel.CGModelSpec$9
	@Override
	public boolean isFalse() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	// Generated from org.eclipse.ocl.examples.build.cgmodel.CGModelSpec$10
	@Override
	public boolean isGlobal() {
		return true;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	// Generated from org.eclipse.ocl.examples.build.cgmodel.CGModelSpec$11
	@Override
	public boolean isInlineable() {
		return false;
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
		return false;
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
} //CGGlobalConstantImpl
