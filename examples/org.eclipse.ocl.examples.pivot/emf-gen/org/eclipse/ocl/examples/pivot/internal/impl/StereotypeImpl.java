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
package org.eclipse.ocl.examples.pivot.internal.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Stereotype;
import org.eclipse.ocl.examples.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stereotype</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class StereotypeImpl extends ClassImpl implements Stereotype
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StereotypeImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return PivotPackage.Literals.STEREOTYPE;
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitStereotype(this);
	}
} //StereotypeImpl