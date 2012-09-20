/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
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
 * $Id$
 */
package org.eclipse.ocl.examples.domain.values.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.RealValue;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.domain.values.ValuesPackage;

/**
 * @generated NOT
 */
public abstract class IntegerValueImpl extends ValueImpl implements IntegerValue
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ValuesPackage.Literals.INTEGER_VALUE;
	}
	
	@Override
	public @NonNull IntegerValue asIntegerValue() {
		return this;
	}

	@Override
	public @NonNull RealValue asRealValue() {
		return realValueOf(this);
	}

	@Override
	public @NonNull Value asUnlimitedNaturalValue() {
		if (isUnlimitedNatural()) {
			return this;
		}
		else {
			return super.asUnlimitedNaturalValue();
		}
	}

	public @NonNull DomainType getType(@NonNull DomainStandardLibrary standardLibrary) {
		return isUnlimitedNatural() ? standardLibrary.getUnlimitedNaturalType() : standardLibrary.getIntegerType();
	}

	public @NonNull TypeId getTypeId() {
		return isUnlimitedNatural() ? TypeId.UNLIMITED_NATURAL : TypeId.INTEGER;
	}

	public boolean isUnlimited() {
		return false;
	}
	
	public boolean isUnlimitedNatural() {
		return false;
	}
}
