/**
 * <copyright>
 *
 * Copyright (c) 2011, 2013 E.D.Willink and others.
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

import java.math.BigDecimal;
import java.math.BigInteger;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.types.IdResolver;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.RealValue;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;

/**
 * LongIntegerValueImpl provides an implementation of an IntegerValue using a Java
 * long representation. Operations resulting in numeric growth may return
 * BigIntegerValueImpl that uses BigInteger.
 * @generated NOT
 */
public class LongIntegerValueImpl extends IntegerValueImpl
{
	private static final long serialVersionUID = -5237294941641660020L;

	private final long value;			// The value.
	private BigInteger bigValue = null;	// Lazily computed BigInteger counterpart.
	
	public LongIntegerValueImpl(long value) {
		this.value = value;
	}

	public @NonNull IntegerValue abs() {
		if (value >= 0) {
			return this;
		}
		else if (value > Long.MIN_VALUE) {
			return ValuesUtil.integerValueOf(-value);
		}
		else {
			@SuppressWarnings("null") @NonNull BigInteger result = BigInteger.ONE.shiftLeft(Long.SIZE-1);
			return ValuesUtil.integerValueOf(result);
		}
	}

	public @NonNull IntegerValue addInteger(@NonNull IntegerValue right) {
		if (right instanceof LongIntegerValueImpl) {
			long thatValue = ((LongIntegerValueImpl)right).longValue();
			long sum = value + thatValue;
			if (value >= 0) {
				if ((thatValue >= 0) && (sum >= 0)) {
					return ValuesUtil.integerValueOf(sum);
				}
			}
			else {
				if ((thatValue <= 0) && (sum <= 0)) {
					return ValuesUtil.integerValueOf(sum);
				}
			}
		}
		@SuppressWarnings("null") @NonNull BigInteger result = bigIntegerValue().add(right.bigIntegerValue());
		return ValuesUtil.integerValueOf(result);
	}

	@Override
	public @NonNull Double asDouble() {
		@SuppressWarnings("null") @NonNull Double result = Double.valueOf(value);
		return result;
	}

	public @NonNull Object asEcoreObject(@NonNull IdResolver idResolver) {
		@SuppressWarnings("null") @NonNull Long result = Long.valueOf(value);
		return result;
	}
	
	@Override
	public @NonNull Integer asInteger() {
		@SuppressWarnings("null") @NonNull Integer result = Integer.valueOf(intValue());
		return result;
	}
	
	@SuppressWarnings("null")
	public @NonNull Number asNumber() {
		return Long.valueOf(value);
	}

	public @NonNull Object asObject() {
		@SuppressWarnings("null") @NonNull Long result = Long.valueOf(value);
		return result;
	}

	public @NonNull BigDecimal bigDecimalValue() {
		return new BigDecimal(value);
	}

	public @NonNull BigInteger bigIntegerValue() {
		BigInteger bigValue2 = bigValue;
		if (bigValue2 != null) {
			return bigValue2;
		}
		@SuppressWarnings("null")
		@NonNull BigInteger bigValue3 = bigValue = BigInteger.valueOf(value);
		return bigValue3;
	}

	public int compareToInteger(@NonNull IntegerValue o) {
		try {
			if (o instanceof IntIntegerValueImpl) {
				int thatValue = ((IntIntegerValueImpl)o).intValue();
				return (value < thatValue ? -1 : (value == thatValue ? 0 : 1));
			}
			else if (o instanceof LongIntegerValueImpl) {
				long thatValue = ((LongIntegerValueImpl)o).longValue();
				return (value < thatValue ? -1 : (value == thatValue ? 0 : 1));
			}
			else {
				return bigIntegerValue().compareTo(o.bigIntegerValue());
			}
		} catch (InvalidValueException e) {
			return this.hashCode() - o.hashCode();
		}
	}

	public @NonNull IntegerValue divInteger(@NonNull IntegerValue right) {
		if (right.bigIntegerValue().signum() == 0) {
			throw new InvalidValueException("div zero");
		}
		@SuppressWarnings("null") @NonNull BigInteger result = bigIntegerValue().divide(right.bigIntegerValue());
		return ValuesUtil.integerValueOf(result);
	}

	public @NonNull RealValue divideInteger(@NonNull IntegerValue right) {
		BigDecimal bigLeft = bigDecimalValue();
		BigDecimal bigRight = right.bigDecimalValue();
		return RealValueImpl.divideBigDecimal(bigLeft, bigRight);
	}

	@Override
	public double doubleValue() {
		return value;
	}

	@Override
	public boolean equals(Object obj) {
		try {
			if (obj instanceof IntIntegerValueImpl) {
				int thatValue = ((IntIntegerValueImpl)obj).intValue();
				return value == thatValue;
			}
			if (obj instanceof LongIntegerValueImpl) {
				long thatValue = ((LongIntegerValueImpl)obj).longValue();
				return value == thatValue;
			}
			if (obj instanceof IntegerValue) {
				BigInteger bigIntegerValue = ((IntegerValue)obj).bigIntegerValue();
				return bigIntegerValue().compareTo(bigIntegerValue) == 0;
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
	public float floatValue() {
		return value;
	}

	@Override
	public int hashCode() {
		return (int)(value ^ (value >>> 32));
	}
	
	@Override
	public int intValue() {
		int intValue = (int) value;
//		if (intValue != value) {
//			throw new InvalidValueException("intValue() overflow");
//		}
		return intValue;
	}

	@Override
	public boolean isUnlimitedNatural() {
		return value >= 0;
	}
	
	@Override
	public long longValue() {
		return value;
	}

	public @NonNull IntegerValue maxInteger(@NonNull IntegerValue right) {
		if (right instanceof IntIntegerValueImpl) {
			int thatValue = ((IntIntegerValueImpl)right).intValue();
			return value >= thatValue ? this : right;
		}
		else if (right instanceof LongIntegerValueImpl) {
			long thatValue = ((LongIntegerValueImpl)right).longValue();
			return value >= thatValue ? this : right;
		}
		else {
			return bigIntegerValue().compareTo(right.bigIntegerValue()) >= 0 ? this : right;
		}
	}

	public @NonNull IntegerValue minInteger(@NonNull IntegerValue right) {
		if (right instanceof IntIntegerValueImpl) {
			int thatValue = ((IntIntegerValueImpl)right).intValue();
			return value <= thatValue ? this : right;
		}
		else if (right instanceof LongIntegerValueImpl) {
			long thatValue = ((LongIntegerValueImpl)right).longValue();
			return value <= thatValue ? this : right;
		}
		else {
			return bigIntegerValue().compareTo(right.bigIntegerValue()) <= 0 ? this : right;
		}
	}

	public @NonNull IntegerValue modInteger(@NonNull IntegerValue right) {
		if (right.bigIntegerValue().signum() == 0) {
			throw new InvalidValueException("mod zero");
		}
		@SuppressWarnings("null") @NonNull BigInteger result = bigIntegerValue().remainder(right.bigIntegerValue());
		return ValuesUtil.integerValueOf(result);
	}

	public @NonNull IntegerValue multiplyInteger(@NonNull IntegerValue right) {
		@SuppressWarnings("null") @NonNull BigInteger result = bigIntegerValue().multiply(right.bigIntegerValue());
		return ValuesUtil.integerValueOf(result);
	}

	public @NonNull IntegerValue negate() {
		if (value > Long.MIN_VALUE) {
			return ValuesUtil.integerValueOf(-value);
		}
		else {
			@SuppressWarnings("null") @NonNull BigInteger result = BigInteger.ONE.shiftLeft(Long.SIZE-1);
			return ValuesUtil.integerValueOf(result);
		}
	}

	public int signum() {
		return Long.signum(value);
	}

	public @NonNull IntegerValue subtractInteger(@NonNull IntegerValue right) {
		if (right instanceof LongIntegerValueImpl) {
			long thatValue = ((LongIntegerValueImpl)right).longValue();
			long diff = value - thatValue;
			if (value >= 0) {
				if ((thatValue <= 0) && (diff >= 0)) {
					return ValuesUtil.integerValueOf(diff);
				}
			}
			else {
				if ((thatValue >= 0) && (diff <= 0)) {
					return ValuesUtil.integerValueOf(diff);
				}
			}
		}
		@SuppressWarnings("null") @NonNull BigInteger result = bigIntegerValue().subtract(right.bigIntegerValue());
		return ValuesUtil.integerValueOf(result);
	}

	@Override
	public String toString() {
		return Long.toString(value);
	}
}
