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
 * $Id: InvalidValueImpl.java,v 1.6 2011/05/07 16:41:18 ewillink Exp $
 */
package org.eclipse.ocl.examples.domain.values.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainElement;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.elements.DomainTypedElement;
import org.eclipse.ocl.examples.domain.evaluation.InvalidEvaluationException;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.values.BagValue;
import org.eclipse.ocl.examples.domain.values.BooleanValue;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.InvalidValue;
import org.eclipse.ocl.examples.domain.values.ObjectValue;
import org.eclipse.ocl.examples.domain.values.OrderedSetValue;
import org.eclipse.ocl.examples.domain.values.RealValue;
import org.eclipse.ocl.examples.domain.values.SequenceValue;
import org.eclipse.ocl.examples.domain.values.SetValue;
import org.eclipse.ocl.examples.domain.values.UniqueCollectionValue;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.domain.values.ValueFactory;
import org.eclipse.ocl.examples.domain.values.ValuesPackage;

/**
 * @generated NOT
 */
public class InvalidValueImpl extends UndefinedCollectionValueImpl implements InvalidValue
{	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ValuesPackage.Literals.INVALID_VALUE;
	}

	protected final InvalidEvaluationException exception;

	public InvalidValueImpl(@NonNull ValueFactory valueFactory) {
		super(valueFactory);
		this.exception = null;
	}

	public InvalidValueImpl(@NonNull ValueFactory valueFactory, @NonNull InvalidEvaluationException exception) {
		super(valueFactory);
		this.exception = exception;
	}

	@Override
	public Object asEcoreObject() throws InvalidValueException {
		if (exception != null) {
			throw exception;
		}
		return super.asEcoreObject();
	}

	@Override
	public @NonNull BagValue asBagValue() throws InvalidValueException {
		if (exception != null) {
			throw exception;
		}
		return super.asBagValue();
	}

	@Override
	public boolean asBoolean() throws InvalidValueException {
		if (exception != null) {
			throw exception;
		}
		return super.asBoolean();
	}

	@Override
	public @NonNull BooleanValue asBooleanValue() throws InvalidValueException {
		if (exception != null) {
			throw exception;
		}
		return super.asBooleanValue();
	}

	@Override
	public @NonNull CollectionValue asCollectionValue() throws InvalidValueException {
		if (exception != null) {
			throw exception;
		}
		return super.asCollectionValue();
	}

	@Override
	public @NonNull Double asDouble() throws InvalidValueException {
		if (exception != null) {
			throw exception;
		}
		return super.asDouble();
	}

	@Override
	public DomainElement asElement() {
		if (exception != null) {
			throw exception;
		}
		return super.asElement();
	}

	@Override
	public @NonNull Integer asInteger() throws InvalidValueException {
		if (exception != null) {
			throw exception;
		}
		return super.asInteger();
	}

	@Override
	public @NonNull IntegerValue asIntegerValue() throws InvalidValueException {
		if (exception != null) {
			throw exception;
		}
		return super.asIntegerValue();
	}

	@Override
	public @NonNull EObject asNavigableObject() throws InvalidValueException {
		if (exception != null) {
			throw exception;
		}
		return super.asNavigableObject();
	}

	@Override
	public @NonNull ObjectValue asObjectValue() throws InvalidValueException {
		if (exception != null) {
			throw exception;
		}
		return super.asObjectValue();
	}

	@Override
	public @NonNull OrderedSetValue asOrderedSetValue() throws InvalidValueException {
		if (exception != null) {
			throw exception;
		}
		return super.asOrderedSetValue();
	}

	@Override
	public @NonNull RealValue asRealValue() throws InvalidValueException {
		if (exception != null) {
			throw exception;
		}
		return super.asRealValue();
	}

	@Override
	public @NonNull SequenceValue asSequenceValue() throws InvalidValueException {
		if (exception != null) {
			throw exception;
		}
		return super.asSequenceValue();
	}

	@Override
	public @NonNull SetValue asSetValue() throws InvalidValueException {
		if (exception != null) {
			throw exception;
		}
		return super.asSetValue();
	}

	@Override
	public @NonNull String asString() throws InvalidValueException {
		if (exception != null) {
			throw exception;
		}
		return super.asString();
	}

	@Override
	public @NonNull UniqueCollectionValue asUniqueCollectionValue() throws InvalidValueException {
		if (exception != null) {
			throw exception;
		}
		return super.asUniqueCollectionValue();
	}

	@Override
	public @NonNull Value asValidValue() throws InvalidValueException {
		if (exception != null) {
			throw exception;
		}
		else {
			return valueFactory.throwInvalidValueException(EvaluatorMessages.TypedValueRequired, "valid", getType());
		}
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof InvalidValue;
	}
	
	public Exception getException() {
		return exception;
	}

	public @NonNull DomainType getType() {
		return valueFactory.getStandardLibrary().getOclInvalidType();
	}

	public @Nullable Value getValue(@NonNull String partName) throws InvalidValueException {
    	return toInvalidValue();
	}

	public @Nullable Value getValue(@NonNull DomainTypedElement part) throws InvalidValueException {
    	return toInvalidValue();
	}

	public int intValue() throws InvalidValueException {
    	toInvalidValue();		// throws rather than returns
    	return 0;
	}

	@Override
	public int hashCode() {
		return 0x22222222;
	}

	@Override
	public boolean isInvalid() {
		return true;
	}

	@Override
	public String toString() {
//		if (exception != null) {
//			return Value.INVALID_NAME + "<" + exception.getMessage() + ">";
//		}
//		else {
			return Value.INVALID_NAME;
//		}
	}
}
