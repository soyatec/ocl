/**
 * <copyright>
 *
 * Copyright (c) 2010,2011 E.D.Willink and others.
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
 * $Id: StringValueImpl.java,v 1.4 2011/02/21 08:37:52 ewillink Exp $
 */
package org.eclipse.ocl.examples.domain.values.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.values.StringValue;
import org.eclipse.ocl.examples.domain.values.ValueFactory;
import org.eclipse.ocl.examples.domain.values.ValuesPackage;

/**
 * @generated NOT
 */
public class StringValueImpl extends ValueImpl implements StringValue
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ValuesPackage.Literals.STRING_VALUE;
	}

	private final @NonNull String value;
	
	public StringValueImpl(@NonNull ValueFactory valueFactory, @NonNull String value) {
		super(valueFactory);
		this.value = value;
	}

	public @NonNull Object asObject() {
		return value;
	}

	@Override
	public @NonNull String asString() {
		return value;
	}

	@Override
	public @NonNull StringValue asStringValue() {
		return this;
	}

	public int compareTo(StringValue o) {
		try {
			return value.compareTo(o.stringValue());
		} catch (InvalidValueException e) {
			return -1;		// o is a NullValue/InvalidValue
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof StringValue) {
			try {
				return value.equals(((StringValue)obj).stringValue());
			} catch (InvalidValueException e) { /* obj is a NullValue/InvalidValue */ }
		}
		return false;
	}

	public @NonNull DomainType getType() {
		return valueFactory.getStandardLibrary().getStringType();
	}

	@Override
	public int hashCode() {
		return value.hashCode();
	}

//	@Override
//	public StringValue isStringValue() {
//		return this;
//	}

	public @NonNull String stringValue() {
		return value;
	}

	@Override
	public @NonNull String toString() {
		return "'" + value + "'";
	}

	@Override
	public void toString(@NonNull StringBuilder s, int sizeLimit) {
		s.append("'");
		int length = value.length();
		int available = sizeLimit - (length + 1);
		if (length <= available) {
			s.append(value);
		}
		else {
			if (available > 0) {
				s.append(value.substring(0, available));
			}
			s.append("...");
		}
		s.append("'");
	}
}
