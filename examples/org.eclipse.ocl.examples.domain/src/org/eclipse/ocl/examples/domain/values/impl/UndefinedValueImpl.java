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
 * $Id: UndefinedValueImpl.java,v 1.6 2011/05/07 16:41:20 ewillink Exp $
 */
package org.eclipse.ocl.examples.domain.values.impl;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.ids.TuplePartId;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.NullValue;
import org.eclipse.ocl.examples.domain.values.NumericValue;
import org.eclipse.ocl.examples.domain.values.RealValue;
import org.eclipse.ocl.examples.domain.values.Value;

/**
 * @generated NOT
 */
public abstract class UndefinedValueImpl extends ValueImpl implements NullValue
{	
	protected UndefinedValueImpl() {}

	public @NonNull NullValue abs() {
		return toInvalidValue();
	}

	public @NonNull NullValue add(@NonNull IntegerValue right) {
		return toInvalidValue();
	}

	public @NonNull NullValue add(@NonNull RealValue right) {
		return toInvalidValue();
	}

	public @NonNull Number asNumber() {
		throw new InvalidValueException("undefined value has no Number value");
	}

	public @NonNull Object asObject() {
		return toInvalidValue();
	}

	public @NonNull BigDecimal bigDecimalValue() {
		throw new InvalidValueException("undefined value has no BigDecimal value");
	}

	public @NonNull BigInteger bigIntegerValue() {
		throw new InvalidValueException("undefined value has no BigInteger value");
	}

	public int compareTo(NumericValue o) {
		throw new UnsupportedOperationException("UndefinedValueImpl.compareTo");
	}

	public @NonNull NullValue div(@NonNull IntegerValue right) {
		return toInvalidValue();
	}

	public @NonNull NullValue divide(@NonNull IntegerValue right) {
		return toInvalidValue();
	}

	public @NonNull NullValue divide(@NonNull RealValue right) {
		return toInvalidValue();
	}

	public double doubleValue() {
		throw new UnsupportedOperationException("InvalidValue.compareTo");
	}

	public @NonNull NullValue floor() {
		return toInvalidValue();
	}

	public DomainType getElement() {
		return null;
	}

	public @NonNull DomainType getInstanceType() {
		throw new InvalidValueException("undefined value has no instance type");
	}

	public Object getObject() {
		return null;
	}

	public @NonNull Value getValue(@NonNull TuplePartId partId) {
    	return toInvalidValue();
	}

	public @NonNull Object getValue(int index) {
    	return toInvalidValue();
	}

	public boolean isFalse() {
		return false;
	}
	
	public @Nullable IntegerValue isIntegerValue() {
		return null;
	}

	public boolean isTrue() {
		return false;
	}

	@Override
	public boolean isUndefined() {
		return true;
	}

	public boolean isUnlimited() {
		return false;
	}
	
	public boolean isUnlimitedNatural() {
		return false;
	}

	public @NonNull NullValue max(@NonNull IntegerValue right) {
		return toInvalidValue();
	}

	public @NonNull NullValue max(@NonNull RealValue right) {
		return toInvalidValue();
	}

	public @NonNull NullValue min(@NonNull IntegerValue right) {
		return toInvalidValue();
	}

	public @NonNull NullValue min(@NonNull RealValue right) {
		return toInvalidValue();
	}

	public @NonNull NullValue mod(@NonNull IntegerValue right) {
		return toInvalidValue();
	}

	public @NonNull NullValue multiply(@NonNull IntegerValue right) {
		return toInvalidValue();
	}

	public @NonNull NullValue multiply(@NonNull RealValue right) {
		return toInvalidValue();
	}

	public @NonNull NullValue negate() {
		return toInvalidValue();
	}
	

	public @NonNull NullValue round() {
		return toInvalidValue();
	}

	public int signum() {
		throw new UnsupportedOperationException("InvalidValue.compareTo");
	}

	public @NonNull String stringValue() {
		throw new InvalidValueException("undefined value has no String value");
	}

	public @NonNull NullValue subtract(@NonNull IntegerValue right) {
		return toInvalidValue();
	}

	public @NonNull NullValue subtract(@NonNull RealValue right) {
		return toInvalidValue();
	}

	protected @NonNull NullValue toInvalidValue() {
		throw new InvalidValueException(EvaluatorMessages.ConvertibleValueRequired, "Invalid");
	}
}
