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
import org.eclipse.ocl.examples.domain.elements.DomainEnumeration;
import org.eclipse.ocl.examples.domain.elements.DomainEnumerationLiteral;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.EnumerationLiteralValue;
import org.eclipse.ocl.examples.domain.values.ValueFactory;
import org.eclipse.ocl.examples.domain.values.ValuesPackage;

/**
 * @generated NOT
 */
public class EnumerationLiteralValueImpl extends ObjectValueImpl implements EnumerationLiteralValue
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ValuesPackage.Literals.ENUMERATION_LITERAL_VALUE;
	}

	protected final @NonNull DomainEnumerationLiteral object;
	protected DomainEnumeration type = null;			// Lazily computed

	public EnumerationLiteralValueImpl(@NonNull ValueFactory valueFactory, @NonNull DomainEnumerationLiteral object) {
		super(valueFactory);
		this.object = object;
	}

	@Override
	public Object asEcoreObject() {
		return object.asEcoreObject(valueFactory.getStandardLibrary());
	}

	@Override
	public DomainEnumerationLiteral asElement() {
		return object;
	}

	@Override
	public @NonNull EnumerationLiteralValue asElementValue() {
		return this;
	}

	@Override
	public Object asObject() {
		return object;
	}

	@Override
	public boolean equals(Object that) {
		if (this == that) {
			return true;
		}
		if (!(that instanceof EnumerationLiteralValue)) {
			return false;
		}
		DomainEnumeration thisEnumeration = getType();
		DomainEnumeration thatEnumeration = ((EnumerationLiteralValue)that).getType();
		if (!(thisEnumeration.equals(thatEnumeration))) {
			return false;
		}
		try {
			String thisName = getName();
			String thatName = ((EnumerationLiteralValue)that).getName();
			return thisName.equals(thatName);
		} catch (InvalidValueException e) {
			return false;
		}
	}

	public DomainEnumerationLiteral getElement() {
		return object;
	}

	public @NonNull String getName() throws InvalidValueException {
		String name = object.getName();
		if (name == null) {
			return valueFactory.throwInvalidValueException("null-named EnumerationLiteral");
		}
		return name;
	}

	@Override
	public @NonNull DomainEnumerationLiteral getObject() {
		return object;
	}

	public @NonNull DomainEnumeration getType() {
		DomainEnumeration type2 = type;
		if (type2 == null) {
			type2 = type = DomainUtil.nonNullState(object.getEnumeration());
		}
		return type2;
	}

	@Override
	public int hashCode() {
		return object.hashCode();
	}
}
