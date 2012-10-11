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
 * $Id: RealValueImpl.java,v 1.5 2011/02/21 08:37:52 ewillink Exp $
 */
package org.eclipse.ocl.examples.domain.values.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.NumericValue;
import org.eclipse.ocl.examples.domain.values.RealValue;
import org.eclipse.ocl.examples.domain.values.ValuesPackage;

/**
 * @generated NOT
 */
public class RealValueImpl extends ValueImpl implements RealValue
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ValuesPackage.Literals.REAL_VALUE;
	}

	private static final int MINIMUM_SCALE = Double.SIZE/2;		// Gives nearly twice the precision of Double

	protected static @NonNull RealValue divideBigDecimal(@NonNull BigDecimal left, @NonNull BigDecimal right) {
		try {
			if (right.signum() == 0) {
				throw new InvalidValueException("divide by zero");
			}
			int scale = Math.max(left.scale() - right.scale(), MINIMUM_SCALE);
			@SuppressWarnings("null") @NonNull BigDecimal result = left.divide(right, scale, RoundingMode.HALF_EVEN);
			return realValueOf(result);
		} catch (ArithmeticException e) {
			throw new InvalidValueException(e, "divideBigDecimal");
		}
	}

	private final @NonNull BigDecimal value;
	private Object integerValue = null;	// Lazily computed exact IntegerValue or Exception
	
	@SuppressWarnings("null")
	public RealValueImpl(double value) {
		this(BigDecimal.valueOf(value));
	}

	public RealValueImpl(@NonNull BigDecimal value) {
		this.value = value;
		assert value != null;
	}

	public @NonNull RealValue abs() {
		@SuppressWarnings("null") @NonNull BigDecimal result = value.abs();
		return realValueOf(result);
	}

	public @NonNull RealValue add(@NonNull RealValue rightValue) {
		try {
			@SuppressWarnings("null") @NonNull BigDecimal result = value.add(rightValue.bigDecimalValue());
			return realValueOf(result);
		} catch (InvalidValueException e) {
			throw new InvalidValueException(EvaluatorMessages.InvalidReal, e, null, rightValue);
		}
	}

	@Override
	public @NonNull Double asDouble() {
		@SuppressWarnings("null") @NonNull Double result = value.doubleValue();
		return result;
	}

	public @NonNull Object asObject() {
		return value;
	}

	@Override
	public @NonNull RealValue asRealValue() {
		return this;
	}

	public @NonNull BigDecimal bigDecimalValue() {
		return value;
	}

	public @NonNull BigInteger bigIntegerValue() {
		Object intValue = getIntegerValue();
		if (intValue instanceof Exception) {
			throw new InvalidValueException((Exception) intValue, "bigIntegerValue");			
		}
		else {
			return ((IntegerValue) intValue).bigIntegerValue();
		}
	}

	public int compareTo(NumericValue o) {
		try {
			RealValue that = o.asRealValue();
			return value.compareTo(that.bigDecimalValue());
		} catch (InvalidValueException e) {
			throw new IllegalArgumentException(e);
		}
	}

	public @NonNull RealValue divide(@NonNull RealValue right) {
		return divideBigDecimal(value, right.bigDecimalValue());
	}

	public double doubleValue() {
		return value.doubleValue();
	}

	@Override
	public boolean equals(Object obj) {
		try {
			if (obj instanceof RealValue) {
				BigDecimal bigDecimalValue = ((RealValue)obj).bigDecimalValue();
				return value.compareTo(bigDecimalValue) == 0;
			}
			if (obj instanceof IntegerValue) {
				BigDecimal bigDecimalValue = ((IntegerValue)obj).bigDecimalValue();
				return value.compareTo(bigDecimalValue) == 0;
			}
		} catch (InvalidValueException e) {
		}
		return this == obj;
	}

	public @NonNull IntegerValue floor() {
		@SuppressWarnings("null") @NonNull BigInteger result = value.setScale(0, RoundingMode.FLOOR).toBigInteger();
		return integerValueOf(result);
	}

	protected Object getIntegerValue() {
		if (integerValue == null) {
			try {
				@SuppressWarnings("null") @NonNull BigInteger intValue = value.toBigIntegerExact();
				integerValue = integerValueOf(intValue);
			}
			catch (ArithmeticException e) {
				integerValue = e;			
			}
		}
		return integerValue;
	}

	public @NonNull DomainType getType(@NonNull DomainStandardLibrary standardLibrary) {
		return standardLibrary.getRealType();
	}

	public @NonNull TypeId getTypeId() {
		return TypeId.REAL;
	}

	@Override
	public int hashCode() {
		Object intValue = getIntegerValue();
		if (intValue instanceof IntegerValue) {
			return intValue.hashCode();
		} 
		else {
			return value.hashCode();
		}
	}
	
	public @Nullable IntegerValue isIntegerValue() {
		return null;
	}

	public boolean isUnlimited() {
		return false;
	}

	public @NonNull RealValue max(@NonNull RealValue rightValue) {
		try {
			@SuppressWarnings("null") @NonNull BigDecimal result = value.max(rightValue.bigDecimalValue());
			return realValueOf(result);
		} catch (InvalidValueException e) {
			throw new InvalidValueException(EvaluatorMessages.InvalidReal, e, null, rightValue);
		}
	}

	public @NonNull RealValue min(@NonNull RealValue rightValue) {
		try {
			@SuppressWarnings("null") @NonNull BigDecimal result = value.min(rightValue.bigDecimalValue());
			return realValueOf(result);
		} catch (InvalidValueException e) {
			throw new InvalidValueException(EvaluatorMessages.InvalidReal, e, null, rightValue);
		}
	}

	public @NonNull RealValue multiply(@NonNull RealValue rightValue) {
		try {
			@SuppressWarnings("null") @NonNull BigDecimal result = value.multiply(rightValue.bigDecimalValue());
			return realValueOf(result);
		} catch (InvalidValueException e) {
			throw new InvalidValueException(EvaluatorMessages.InvalidReal, e, null, rightValue);
		}
	}

	public @NonNull RealValue negate() {
		@SuppressWarnings("null") @NonNull BigDecimal result = value.negate();
		return realValueOf(result);
	}
	
	public @NonNull IntegerValue round() {
		BigDecimal rounded;
		if (value.signum() >= 0) {
			rounded = value.setScale(0, RoundingMode.HALF_UP);		// functions as HALF_AWAY
		}
		else {
			rounded = value.negate().setScale(0, RoundingMode.HALF_DOWN).negate();
		}
		@SuppressWarnings("null") @NonNull BigInteger result = rounded.toBigInteger();
		return integerValueOf(result);
	}

	public int signum() {
		return value.signum();
	}

	public @NonNull RealValue subtract(@NonNull RealValue rightValue) {
		try {
			@SuppressWarnings("null") @NonNull BigDecimal result = value.subtract(rightValue.bigDecimalValue());
			return realValueOf(result);
		} catch (InvalidValueException e) {
			throw new InvalidValueException(EvaluatorMessages.InvalidReal, e, null, rightValue);
		}
	}

	@Override
	public String toString() {
		return value.toString();
	}
}
