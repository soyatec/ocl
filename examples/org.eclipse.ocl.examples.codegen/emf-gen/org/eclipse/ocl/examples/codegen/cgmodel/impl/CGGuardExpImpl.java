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
import org.eclipse.ocl.examples.codegen.cgmodel.CGGuardExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.util.CGModelVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CG Guard Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class CGGuardExpImpl extends CGCallExpImpl implements CGGuardExp {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CGGuardExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CGModelPackage.Literals.CG_GUARD_EXP;
	}

	@Override
	public <R> R accept(@NonNull CGModelVisitor<R> visitor) {
		return visitor.visitCGGuardExp(this);
	}

	@Override
	public @NonNull CGValuedElement getReferredValuedElement() {
		return source != null ? source : this;
	}

	@Override
	public @NonNull CGValuedElement getValue() {
		return getReferredValuedElement();
	}

	@Override
	public boolean isNonNull() {
		return true;
	}

	@Override
	public boolean isNull() {
		return false;
	}
} //CGGuardExpImpl
