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
 * $Id: IntegerValueImpl.java,v 1.4 2011/02/21 08:37:52 ewillink Exp $
 */
package org.eclipse.ocl.examples.domain.values.impl;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.NumericValue;
import org.eclipse.ocl.examples.domain.values.RealValue;

/**
 * @generated NOT
 */
public class BigIntegerValueImpl extends IntegerValueImpl
{
	private final @NonNull BigInteger value;
	
	@SuppressWarnings("null")
	public BigIntegerValueImpl(long value) {
		this(BigInteger.valueOf(value));
	}

	public BigIntegerValueImpl(@NonNull BigInteger value) {
		this.value = value;
		assert value != null;
	}

	public @NonNull IntegerValue abs() {
		@SuppressWarnings("null") @NonNull BigInteger result = value.abs();
		return integerValueOf(result);
	}

	public @NonNull IntegerValue add(@NonNull IntegerValue right) {
		@SuppressWarnings("null") @NonNull BigInteger result = value.add(right.bigIntegerValue());
		return integerValueOf(result);
	}

	@Override
	public @NonNull Double asDouble() {
		@SuppressWarnings("null") @NonNull Double result = value.doubleValue();
		return result;
	}
	
	@Override
	public @NonNull Integer asInteger() {
		@SuppressWarnings("null") @NonNull Integer result = Integer.valueOf(intValue());
		return result;
	}
	
	public @NonNull Number asNumber() {
		return value;
	}

	public @NonNull Object asObject() {
		return value;
	}

	public @NonNull BigDecimal bigDecimalValue() {
		return new BigDecimal(value);
	}

	public @NonNull BigInteger bigIntegerValue() {
		return value;
	}

	public int compareTo(NumericValue o) {
		try {
			if (o instanceof IntegerValue) {
				return value.compareTo(((IntegerValue)o).bigIntegerValue());
			}
			else {
				return bigDecimalValue().compareTo(o.bigDecimalValue());
			}
		} catch (InvalidValueException e) {
			return this.hashCode() - o.hashCode();
		}
	}

	public @NonNull IntegerValue div(@NonNull IntegerValue right) {
		if (right.bigIntegerValue().signum() == 0) {
			throw new InvalidValueException("div zero");
		}
		@SuppressWarnings("null") @NonNull BigInteger result = value.divide(right.bigIntegerValue());
		return integerValueOf(result);
	}

	public @NonNull RealValue divide(@NonNull IntegerValue right) {
		BigDecimal bigLeft = bigDecimalValue();
		BigDecimal bigRight = right.bigDecimalValue();
		return RealValueImpl.divideBigDecimal(bigLeft, bigRight);
	}

	public double doubleValue() {
		return value.doubleValue();
	}

	@Override
	public boolean equals(Object obj) {
		try {
			if (obj instanceof IntegerValue) {
				BigInteger bigIntegerValue = ((IntegerValue)obj).bigIntegerValue();
				return value.compareTo(bigIntegerValue) == 0;
			}
			if (obj instanceof RealValue) {
				BigDecimal bigDecimalValue = ((RealValue)obj).bigDecimalValue();
				return bigDecimalValue().compareTo(bigDecimalValue) == 0;
			}
		} catch (InvalidValueException e) {
		}
		return this == obj;
	}

	@Override
	public int hashCode() {
		return value.hashCode();
	}
	
	public int intValue() {
		int intValue = value.intValue();
		if (!BigInteger.valueOf(intValue).equals(value)) {
			throw new InvalidValueException("intValue() overflow");
		}
		return intValue;
	}

	@Override
	public boolean isUnlimitedNatural() {
		return signum() >= 0;
	}

	public @NonNull IntegerValue max(@NonNull IntegerValue right) {
		return value.compareTo(right.bigIntegerValue()) >= 0 ? this : right;
	}

	public @NonNull IntegerValue min(@NonNull IntegerValue right) {
		return value.compareTo(right.bigIntegerValue()) <= 0 ? this : right;
	}

	public @NonNull IntegerValue mod(@NonNull IntegerValue right) {
		if (right.bigIntegerValue().signum() == 0) {
			throw new InvalidValueException("mod zero");
		}
		@SuppressWarnings("null") @NonNull BigInteger result = value.remainder(right.bigIntegerValue());
		return integerValueOf(result);
	}

	public @NonNull IntegerValue multiply(@NonNull IntegerValue right) {
		@SuppressWarnings("null") @NonNull BigInteger result = value.multiply(right.bigIntegerValue());
		return integerValueOf(result);
	}

	public @NonNull IntegerValue negate() {
		@SuppressWarnings("null") @NonNull BigInteger result = value.negate();
		return integerValueOf(result);
	}

	public int signum() {
		return value.signum();
	}

	public @NonNull IntegerValue subtract(@NonNull IntegerValue right) {
		@SuppressWarnings("null") @NonNull BigInteger result = value.subtract(right.bigIntegerValue());
		return integerValueOf(result);
	}

	@Override
	public String toString() {
		return value.toString();
	}
}
