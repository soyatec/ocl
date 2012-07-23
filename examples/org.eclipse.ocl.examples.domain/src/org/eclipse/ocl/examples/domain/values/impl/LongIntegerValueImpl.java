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

import java.math.BigDecimal;
import java.math.BigInteger;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.NumericValue;
import org.eclipse.ocl.examples.domain.values.RealValue;
import org.eclipse.ocl.examples.domain.values.ValueFactory;

/**
 * LongIntegerValueImpl provides an implementation of an IntegerValue using a Java
 * long representation. Operations resulting in numeric growth may return
 * BigIntegerValueImpl that uses BigInteger.
 * @generated NOT
 */
public class LongIntegerValueImpl extends IntegerValueImpl
{
	private final long value;			// The value.
	private BigInteger bigValue = null;	// Lazily computed BigInteger counterpart.
	
	public LongIntegerValueImpl(@NonNull ValueFactory valueFactory, long value) {
		super(valueFactory);
		this.value = value;
	}

	public @NonNull IntegerValue abs() {
		if (value >= 0) {
			return this;
		}
		else if (value > Long.MIN_VALUE) {
			return valueFactory.integerValueOf(-value);
		}
		else {
			BigInteger result = DomainUtil.nonNullJava(BigInteger.ONE.shiftLeft(Long.SIZE-1));
			return valueFactory.integerValueOf(result);
		}
	}

	public @NonNull IntegerValue add(@NonNull IntegerValue right) {
		try {
			if (right instanceof LongIntegerValueImpl) {
				long thatValue = ((LongIntegerValueImpl)right).longValue();
				long sum = value + thatValue;
				if (value >= 0) {
					if ((thatValue >= 0) && (sum >= 0)) {
						return valueFactory.integerValueOf(sum);
					}
				}
				else {
					if ((thatValue <= 0) && (sum <= 0)) {
						return valueFactory.integerValueOf(sum);
					}
				}
			}
			BigInteger result = DomainUtil.nonNullJava(bigIntegerValue().add(right.bigIntegerValue()));
			return valueFactory.integerValueOf(result);
		} catch (InvalidValueException e) {
			return valueFactory.createInvalidValue(e);
		}
	}

	@Override
	public @NonNull Double asDouble() {
		return DomainUtil.nonNullJava(Double.valueOf(value));
	}
	
	@Override
	public @NonNull Integer asInteger() throws InvalidValueException {
		return DomainUtil.nonNullJava(Integer.valueOf(intValue()));
	}

	public @NonNull Object asObject() {
		return DomainUtil.nonNullJava(Long.valueOf(value));
	}

	public @NonNull BigDecimal bigDecimalValue() {
		return new BigDecimal(value);
	}

	public @NonNull BigInteger bigIntegerValue() {
		if (bigValue == null) {
			bigValue = BigInteger.valueOf(value);
		}
		return DomainUtil.nonNullJDT(bigValue);
	}

	public int compareTo(NumericValue o) {
		try {
			if (o instanceof IntIntegerValueImpl) {
				int thatValue = ((IntIntegerValueImpl)o).intValue();
				return (value < thatValue ? -1 : (value == thatValue ? 0 : 1));
			}
			if (o instanceof LongIntegerValueImpl) {
				long thatValue = ((LongIntegerValueImpl)o).longValue();
				return (value < thatValue ? -1 : (value == thatValue ? 0 : 1));
			}
			if (o instanceof IntegerValue) {
				return bigIntegerValue().compareTo(((IntegerValue)o).bigIntegerValue());
			}
			else {
				return bigDecimalValue().compareTo(o.bigDecimalValue());
			}
		} catch (InvalidValueException e) {
			return this.hashCode() - o.hashCode();
		}
	}

	public @NonNull IntegerValue div(@NonNull IntegerValue right) throws InvalidValueException {
		if (right.bigIntegerValue().signum() == 0) {
			return valueFactory.throwInvalidValueException("div zero");
		}
		BigInteger result = DomainUtil.nonNullJava(bigIntegerValue().divide(right.bigIntegerValue()));
		return valueFactory.integerValueOf(result);
	}

	public @NonNull RealValue divide(@NonNull IntegerValue right) throws InvalidValueException {
		BigDecimal bigLeft = bigDecimalValue();
		BigDecimal bigRight = right.bigDecimalValue();
		return RealValueImpl.divideBigDecimal(valueFactory, bigLeft, bigRight);
	}

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
	public int hashCode() {
		return (int)(value ^ (value >>> 32));
	}
	
	public int intValue() throws InvalidValueException {
		int intValue = (int) value;
		if (intValue != value) {
			throw new InvalidValueException("intValue() overflow");
		}
		return intValue;
	}

	@Override
	public boolean isUnlimitedNatural() {
		return value >= 0;
	}
	
	public long longValue() {
		return value;
	}

	public @NonNull IntegerValue max(@NonNull IntegerValue right) throws InvalidValueException {
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

	public @NonNull IntegerValue min(@NonNull IntegerValue right) throws InvalidValueException {
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

	public @NonNull IntegerValue mod(@NonNull IntegerValue right) throws InvalidValueException {
		if (right.bigIntegerValue().signum() == 0) {
			return valueFactory.throwInvalidValueException("mod zero");
		}
		BigInteger result = DomainUtil.nonNullJava(bigIntegerValue().remainder(right.bigIntegerValue()));
		return valueFactory.integerValueOf(result);
	}

	public @NonNull IntegerValue multiply(@NonNull IntegerValue right) throws InvalidValueException {
		BigInteger result = DomainUtil.nonNullJava(bigIntegerValue().multiply(right.bigIntegerValue()));
		return valueFactory.integerValueOf(result);
	}

	public @NonNull IntegerValue negate() {
		if (value > Long.MIN_VALUE) {
			return valueFactory.integerValueOf(-value);
		}
		else {
			BigInteger result = DomainUtil.nonNullJava(BigInteger.ONE.shiftLeft(Long.SIZE-1));
			return valueFactory.integerValueOf(result);
		}
	}

	public int signum() {
		return Long.signum(value);
	}

	public @NonNull IntegerValue subtract(@NonNull IntegerValue right) throws InvalidValueException {
		if (right instanceof LongIntegerValueImpl) {
			long thatValue = ((LongIntegerValueImpl)right).longValue();
			long diff = value - thatValue;
			if (value >= 0) {
				if ((thatValue <= 0) && (diff >= 0)) {
					return valueFactory.integerValueOf(diff);
				}
			}
			else {
				if ((thatValue >= 0) && (diff <= 0)) {
					return valueFactory.integerValueOf(diff);
				}
			}
		}
		BigInteger result = DomainUtil.nonNullJava(bigIntegerValue().subtract(right.bigIntegerValue()));
		return valueFactory.integerValueOf(result);
	}

	@Override
	public String toString() {
		return Long.toString(value);
	}
}
