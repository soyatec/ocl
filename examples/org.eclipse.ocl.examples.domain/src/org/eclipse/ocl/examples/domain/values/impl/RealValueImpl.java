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
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.NumericValue;
import org.eclipse.ocl.examples.domain.values.RealValue;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.domain.values.ValueFactory;
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

	protected static @NonNull RealValue divideBigDecimal(@NonNull ValueFactory valueFactory, @NonNull BigDecimal left, @NonNull BigDecimal right) throws InvalidValueException {
		try {
			if (right.signum() == 0) {
				return valueFactory.throwInvalidValueException("divide by zero");
			}
			int scale = Math.max(left.scale() - right.scale(), MINIMUM_SCALE);
			BigDecimal result = DomainUtil.nonNullJava(left.divide(right, scale, RoundingMode.HALF_EVEN));
			return valueFactory.realValueOf(result);
		} catch (ArithmeticException e) {
			throw new InvalidValueException(e);
		}
	}

	private final @NonNull BigDecimal value;
	private Object integerValue = null;	// Lazily computed exact IntegerValue or Exception
	
	public RealValueImpl(@NonNull ValueFactory valueFactory, double value) {
		this(valueFactory, DomainUtil.nonNullJava(BigDecimal.valueOf(value)));
	}

	public RealValueImpl(@NonNull ValueFactory valueFactory, @NonNull BigDecimal value) {
		super(valueFactory);
		this.value = value;
		assert value != null;
	}

	public @NonNull RealValue abs() {
		BigDecimal result = DomainUtil.nonNullJava(value.abs());
		return valueFactory.realValueOf(result);
	}

	public @NonNull RealValue add(@NonNull RealValue rightValue) {
		try {
			BigDecimal result = DomainUtil.nonNullJava(value.add(rightValue.bigDecimalValue()));
			return valueFactory.realValueOf(result);
		} catch (InvalidValueException e) {
			return valueFactory.createInvalidValue(EvaluatorMessages.InvalidReal, e, null, rightValue);
		}
	}

	@Override
	public @NonNull Double asDouble() {
		return DomainUtil.nonNullJava(value.doubleValue());
	}

	public @NonNull Object asObject() {
		return value;
	}

	@Override
	public @NonNull RealValue asRealValue() {
		return this;
	}

	public @NonNull Value asValidValue() {
		return this;
	}

	public @NonNull BigDecimal bigDecimalValue() {
		return value;
	}

	public @NonNull BigInteger bigIntegerValue() throws InvalidValueException {
		Object intValue = getIntegerValue();
		if (integerValue instanceof Exception) {
			throw new InvalidValueException((Exception)intValue);			
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

	public @NonNull RealValue divide(@NonNull RealValue right) throws InvalidValueException {
		return divideBigDecimal(valueFactory, value, right.bigDecimalValue());
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
		BigInteger result = DomainUtil.nonNullJava(value.setScale(0, RoundingMode.FLOOR).toBigInteger());
		return valueFactory.integerValueOf(result);
	}

	protected Object getIntegerValue() {
		if (integerValue == null) {
			try {
				BigInteger intValue = DomainUtil.nonNullJava(value.toBigIntegerExact());
				integerValue = valueFactory.integerValueOf(intValue);
			}
			catch (ArithmeticException e) {
				integerValue = e;			
			}
		}
		return integerValue;
	}

	public @NonNull DomainType getType() {
		return valueFactory.getStandardLibrary().getRealType();
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

	@Override
	public RealValue isRealValue() {
		return this;
	}

	public @NonNull RealValue max(@NonNull RealValue rightValue) {
		try {
			BigDecimal result = DomainUtil.nonNullJava(value.max(rightValue.bigDecimalValue()));
			return valueFactory.realValueOf(result);
		} catch (InvalidValueException e) {
			return valueFactory.createInvalidValue(EvaluatorMessages.InvalidReal, e, null, rightValue);
		}
	}

	public @NonNull RealValue min(@NonNull RealValue rightValue) {
		try {
			BigDecimal result = DomainUtil.nonNullJava(value.min(rightValue.bigDecimalValue()));
			return valueFactory.realValueOf(result);
		} catch (InvalidValueException e) {
			return valueFactory.createInvalidValue(EvaluatorMessages.InvalidReal, e, null, rightValue);
		}
	}

	public @NonNull RealValue multiply(@NonNull RealValue rightValue) {
		try {
			BigDecimal result = DomainUtil.nonNullJava(value.multiply(rightValue.bigDecimalValue()));
			return valueFactory.realValueOf(result);
		} catch (InvalidValueException e) {
			return valueFactory.createInvalidValue(EvaluatorMessages.InvalidReal, e, null, rightValue);
		}
	}

	public @NonNull RealValue negate() {
		BigDecimal result = DomainUtil.nonNullJava(value.negate());
		return valueFactory.realValueOf(result);
	}
	
	public @NonNull IntegerValue round() {
		BigDecimal rounded;
		if (value.signum() >= 0) {
			rounded = value.setScale(0, RoundingMode.HALF_UP);		// functions as HALF_AWAY
		}
		else {
			rounded = value.negate().setScale(0, RoundingMode.HALF_DOWN).negate();
		}
		BigInteger result = DomainUtil.nonNullJava(rounded.toBigInteger());
		return valueFactory.integerValueOf(result);
	}

	public int signum() {
		return value.signum();
	}

	public @NonNull RealValue subtract(@NonNull RealValue rightValue) {
		try {
			BigDecimal result = DomainUtil.nonNullJava(value.subtract(rightValue.bigDecimalValue()));
			return valueFactory.realValueOf(result);
		} catch (InvalidValueException e) {
			return valueFactory.createInvalidValue(EvaluatorMessages.InvalidReal, e, null, rightValue);
		}
	}

	@Override
	public String toString() {
		return value.toString();
	}
}
