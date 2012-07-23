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
 * $Id: AbstractUndefinedValue.java,v 1.6 2011/05/07 16:41:20 ewillink Exp $
 */
package org.eclipse.ocl.examples.domain.values.impl;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.values.BooleanValue;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.NullValue;
import org.eclipse.ocl.examples.domain.values.NumericValue;
import org.eclipse.ocl.examples.domain.values.RealValue;
import org.eclipse.ocl.examples.domain.values.ValueFactory;

/**
 * @generated NOT
 */
public abstract class UndefinedValueImpl extends ValueImpl implements NullValue
{	
	protected UndefinedValueImpl(@NonNull ValueFactory valueFactory) {
		super(valueFactory);
	}

	public @NonNull NullValue abs() throws InvalidValueException {
		return toInvalidValue();
	}

	public @NonNull NullValue add(@NonNull IntegerValue right) throws InvalidValueException {
		return toInvalidValue();
	}

	public @NonNull NullValue add(@NonNull RealValue right) throws InvalidValueException {
		return toInvalidValue();
	}

	public @NonNull BooleanValue asFalse() {
		return this;
	}

//	public Double asDouble() {
//		return null;
//	}

	public Object asObject() {
		return null;
	}

	public @NonNull BooleanValue asTrue() {
		return this;
	}

	public @NonNull BigDecimal bigDecimalValue() throws InvalidValueException {
		return valueFactory.throwInvalidValueException("undefined value has no BigDecimal value");
	}

	public @NonNull BigInteger bigIntegerValue() throws InvalidValueException {
		return valueFactory.throwInvalidValueException("undefined value has no BigInteger value");
	}

	public int compareTo(NumericValue o) {
		throw new UnsupportedOperationException("AbstractUndefinedValue.compareTo");
	}

	public @NonNull NullValue div(@NonNull IntegerValue right) throws InvalidValueException {
		return toInvalidValue();
	}

	public @NonNull NullValue divide(@NonNull IntegerValue right) throws InvalidValueException {
		return toInvalidValue();
	}

	public @NonNull NullValue divide(@NonNull RealValue right) throws InvalidValueException {
		return toInvalidValue();
	}

	public double doubleValue() {
		throw new UnsupportedOperationException("InvalidValue.compareTo");
	}

	public @NonNull NullValue floor() throws InvalidValueException {
		return toInvalidValue();
	}

	public DomainType getElement() {
		return null;
	}

	public @NonNull DomainType getInstanceType() throws InvalidValueException {
		return valueFactory.throwInvalidValueException("undefined value has no instance type");
	}

	public Object getObject() {
		return null;
	}

	@Override
	public boolean isUndefined() {
		return true;
	}

	public @NonNull NullValue max(@NonNull IntegerValue right) throws InvalidValueException {
		return toInvalidValue();
	}

	public @NonNull NullValue max(@NonNull RealValue right) throws InvalidValueException {
		return toInvalidValue();
	}

	public @NonNull NullValue min(@NonNull IntegerValue right) throws InvalidValueException {
		return toInvalidValue();
	}

	public @NonNull NullValue min(@NonNull RealValue right) throws InvalidValueException {
		return toInvalidValue();
	}

	public @NonNull NullValue mod(@NonNull IntegerValue right) throws InvalidValueException {
		return toInvalidValue();
	}

	public @NonNull NullValue multiply(@NonNull IntegerValue right) throws InvalidValueException {
		return toInvalidValue();
	}

	public @NonNull NullValue multiply(@NonNull RealValue right) throws InvalidValueException {
		return toInvalidValue();
	}

	public @NonNull NullValue negate() throws InvalidValueException {
		return toInvalidValue();
	}

	public @NonNull NullValue round() throws InvalidValueException {
		return toInvalidValue();
	}

	public int signum() {
		throw new UnsupportedOperationException("InvalidValue.compareTo");
	}

	public @NonNull String stringValue() throws InvalidValueException {
		return valueFactory.throwInvalidValueException("undefined value has no String value");
	}

	public @NonNull NullValue subtract(@NonNull IntegerValue right) throws InvalidValueException {
		return toInvalidValue();
	}

	public @NonNull NullValue subtract(@NonNull RealValue right) throws InvalidValueException {
		return toInvalidValue();
	}

	protected @NonNull NullValue toInvalidValue() throws InvalidValueException {
		return valueFactory.throwInvalidValueException(EvaluatorMessages.ConvertibleValueRequired, "Invalid");
	}
}
