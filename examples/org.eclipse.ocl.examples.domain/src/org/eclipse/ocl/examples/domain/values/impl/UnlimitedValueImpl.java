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
 * $Id: UnlimitedValueImpl.java,v 1.5 2011/05/07 16:41:16 ewillink Exp $
 */
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
 * $Id: UnlimitedValueImpl.java,v 1.5 2011/05/07 16:41:16 ewillink Exp $
 */
package org.eclipse.ocl.examples.domain.values.impl;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.NumericValue;
import org.eclipse.ocl.examples.domain.values.RealValue;
import org.eclipse.ocl.examples.domain.values.Unlimited;
import org.eclipse.ocl.examples.domain.values.UnlimitedValue;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.domain.values.ValueFactory;
import org.eclipse.ocl.examples.domain.values.ValuesPackage;

/**
 * @generated NOT
 */
public class UnlimitedValueImpl extends ValueImpl implements UnlimitedValue
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ValuesPackage.Literals.UNLIMITED_VALUE;
	}

	public UnlimitedValueImpl(@NonNull ValueFactory valueFactory) {
		super(valueFactory);
	}

	public @NonNull UnlimitedValueImpl abs() {
		return this;
	}

	public @NonNull IntegerValue add(@NonNull IntegerValue right) throws InvalidValueException {
		return valueFactory.throwInvalidValueException(EvaluatorMessages.InvalidOperation, "add", "UnlimitedValue");
	}

	public @NonNull RealValue add(@NonNull RealValue right) throws InvalidValueException {
		return valueFactory.throwInvalidValueException(EvaluatorMessages.InvalidOperation, "add", "UnlimitedValue");
	}

	public @NonNull Object asObject() {
		return Unlimited.INSTANCE;
	}

	@Override
	public @NonNull Value asUnlimitedNaturalValue() {
		return this;
	}

	public @NonNull Value asValidValue() {
		return this;
	}

	public @NonNull BigDecimal bigDecimalValue() throws InvalidValueException {
		return valueFactory.throwInvalidValueException(EvaluatorMessages.InvalidOperation, "bigDecimalValue", "UnlimitedValue");
	}

	public @NonNull BigInteger bigIntegerValue() throws InvalidValueException {
		return valueFactory.throwInvalidValueException(EvaluatorMessages.InvalidOperation, "bigIntegerValue", "UnlimitedValue");
	}

	public int compareTo(NumericValue o) {
		if (o.isInvalid()) {
			throw new UnsupportedOperationException("UnlimitedValueImpl.compareTo");
		}
		else if (o.isUnlimited()) {
			return 0;
		}
		else {
			return 1;
		}
	}

	public @NonNull IntegerValue div(@NonNull IntegerValue right) throws InvalidValueException {
		return valueFactory.throwInvalidValueException(EvaluatorMessages.InvalidOperation, "div", "UnlimitedValue");
	}

	public @NonNull RealValue divide(@NonNull IntegerValue right) throws InvalidValueException {
		return valueFactory.throwInvalidValueException(EvaluatorMessages.InvalidOperation, "divide", "UnlimitedValue");
	}

	public @NonNull RealValue divide(@NonNull RealValue right) throws InvalidValueException {
		return valueFactory.throwInvalidValueException(EvaluatorMessages.InvalidOperation, "divide", "UnlimitedValue");
	}

	public double doubleValue() {
		throw new UnsupportedOperationException(getClass().getName()+ ".doubleValue");
	}

	public @NonNull IntegerValue floor() throws InvalidValueException {
		return valueFactory.throwInvalidValueException(EvaluatorMessages.InvalidOperation, "floor", "UnlimitedValue");
	}

	public @NonNull DomainType getType() {
		return valueFactory.getStandardLibrary().getUnlimitedNaturalType();
	}

	public int intValue() throws InvalidValueException {
		return valueFactory.throwInvalidValueException(EvaluatorMessages.InvalidOperation, "intValue", "UnlimitedValue");
	}

	@Override
	public boolean isUnlimited() {
		return true;
	}

	@Override
	public boolean isUnlimitedNatural() {
		return true;
	}

	public @NonNull IntegerValue max(@NonNull IntegerValue right) throws InvalidValueException {
		return valueFactory.throwInvalidValueException(EvaluatorMessages.InvalidOperation, "max", "UnlimitedValue");
	}

	public @NonNull RealValue max(@NonNull RealValue right) throws InvalidValueException {
		return valueFactory.throwInvalidValueException(EvaluatorMessages.InvalidOperation, "max", "UnlimitedValue");
	}

	public @NonNull IntegerValue min(@NonNull IntegerValue right) throws InvalidValueException {
		return valueFactory.throwInvalidValueException(EvaluatorMessages.InvalidOperation, "min", "UnlimitedValue");
	}

	public @NonNull RealValue min(@NonNull RealValue right) throws InvalidValueException {
		return valueFactory.throwInvalidValueException(EvaluatorMessages.InvalidOperation, "min", "UnlimitedValue");
	}

	public @NonNull IntegerValue mod(@NonNull IntegerValue right) throws InvalidValueException {
		return valueFactory.throwInvalidValueException(EvaluatorMessages.InvalidOperation, "mod", "UnlimitedValue");
	}

	public @NonNull IntegerValue multiply(@NonNull IntegerValue right) throws InvalidValueException {
		return valueFactory.throwInvalidValueException(EvaluatorMessages.InvalidOperation, "multiply", "UnlimitedValue");
	}

	public @NonNull RealValue multiply(@NonNull RealValue right) throws InvalidValueException {
		return valueFactory.throwInvalidValueException(EvaluatorMessages.InvalidOperation, "multiply", "UnlimitedValue");
	}

	public @NonNull UnlimitedValue negate() throws InvalidValueException {
		return valueFactory.throwInvalidValueException(EvaluatorMessages.InvalidOperation, "negate", "UnlimitedValue");
	}

	public @NonNull IntegerValue round() throws InvalidValueException {
		return valueFactory.throwInvalidValueException(EvaluatorMessages.InvalidOperation, "round", "UnlimitedValue");
	}

	public int signum() {
		return 1;
	}

	public @NonNull IntegerValue subtract(@NonNull IntegerValue right) throws InvalidValueException {
		return valueFactory.throwInvalidValueException(EvaluatorMessages.InvalidOperation, "subtract", "UnlimitedValue");
	}

	public @NonNull RealValue subtract(@NonNull RealValue right) throws InvalidValueException {
		return valueFactory.throwInvalidValueException(EvaluatorMessages.InvalidOperation, "subtract", "UnlimitedValue");
	}

	@Override
	public String toString() {
		return "*";
	}
}
