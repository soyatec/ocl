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
 * $Id: AbstractValue.java,v 1.5 2011/05/07 16:41:18 ewillink Exp $
 */
package org.eclipse.ocl.examples.domain.values.impl;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainElement;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.values.BagValue;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.ObjectValue;
import org.eclipse.ocl.examples.domain.values.OrderedSetValue;
import org.eclipse.ocl.examples.domain.values.RealValue;
import org.eclipse.ocl.examples.domain.values.SequenceValue;
import org.eclipse.ocl.examples.domain.values.SetValue;
import org.eclipse.ocl.examples.domain.values.TupleValue;
import org.eclipse.ocl.examples.domain.values.UniqueCollectionValue;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.domain.values.ValueFactory;
import org.eclipse.ocl.examples.domain.values.ValuesPackage;

/**
 * @generated NOT
 */
public abstract class ValueImpl implements Value
{
    static class EmptyIterator implements Iterator<Value>
    {
        public boolean hasNext() {
            return false;
        }
        public Value next() {
            throw new NoSuchElementException();
        }
        public void remove() {
            throw new IllegalStateException();
        }
    }
    
    @SuppressWarnings("null")
	protected static @NonNull Double NULL_DOUBLE = Double.valueOf(0);
    @SuppressWarnings("null")
	protected static @NonNull Integer NULL_INTEGER = Integer.valueOf(0);
    @SuppressWarnings("null")
	protected static @NonNull String NULL_STRING = String.valueOf("");    

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ValuesPackage.Literals.VALUE;
	}

	protected final @NonNull ValueFactory valueFactory;

	protected ValueImpl(@NonNull ValueFactory valueFactory) {
		this.valueFactory = valueFactory;
	}

	public @NonNull BagValue asBagValue() throws InvalidValueException {
		return valueFactory.throwInvalidValueException(EvaluatorMessages.TypedValueRequired, "Bag", getType());
	}

//	public boolean asBoolean() throws InvalidValueException {
//		valueFactory.throwInvalidValueException(EvaluatorMessages.TypedValueRequired, "Boolean", getType());
//		return false;
//	}

	public @NonNull CollectionValue asCollectionValue() throws InvalidValueException {
		return valueFactory.throwInvalidValueException(EvaluatorMessages.TypedValueRequired, "Collection", getType());
	}

	public @NonNull Double asDouble() throws InvalidValueException {
		valueFactory.throwInvalidValueException(EvaluatorMessages.TypedValueRequired, "Double", getType());
		return NULL_DOUBLE;			// Unreachable code
	}

	public Object asEcoreObject() throws InvalidValueException {
		return asObject();
	}

	public DomainElement asElement() {
		return null;
	}

	public @NonNull Integer asInteger() throws InvalidValueException {
		valueFactory.throwInvalidValueException(EvaluatorMessages.TypedValueRequired, "Integer", getType());
		return NULL_INTEGER;			// Unreachable code
	}

	public @NonNull IntegerValue asIntegerValue() throws InvalidValueException {
		return valueFactory.throwInvalidValueException(EvaluatorMessages.TypedValueRequired, "Integer", getType());
	}

	public @NonNull EObject asNavigableObject() throws InvalidValueException {
		Object object = asObject();
		if (object instanceof EObject) {
			return (EObject) object;
		}
		else {
			return (EObject) valueFactory.throwInvalidValueException(EvaluatorMessages.TypedValueRequired, "Object", getType());
		}
	}

	public @NonNull ObjectValue asObjectValue() throws InvalidValueException {
		return valueFactory.throwInvalidValueException(EvaluatorMessages.TypedValueRequired, "Object", getType());
	}

	public @NonNull OrderedSetValue asOrderedSetValue() throws InvalidValueException {
		return valueFactory.throwInvalidValueException(EvaluatorMessages.TypedValueRequired, "OrderedSet", getType());
	}

	public @NonNull RealValue asRealValue() throws InvalidValueException {
		return valueFactory.throwInvalidValueException(EvaluatorMessages.TypedValueRequired, "Real", getType());
	}

	public @NonNull SequenceValue asSequenceValue() throws InvalidValueException {
		return valueFactory.throwInvalidValueException(EvaluatorMessages.TypedValueRequired, "Sequence", getType());
	}

	public @NonNull SetValue asSetValue() throws InvalidValueException {
		return valueFactory.throwInvalidValueException(EvaluatorMessages.TypedValueRequired, "Set", getType());
	}

//	public @NonNull String asString() throws InvalidValueException {
//		valueFactory.throwInvalidValueException(EvaluatorMessages.TypedValueRequired, "String", getType());
//		return NULL_STRING;			// Unreachable code
//	}

	public @NonNull TupleValue asTupleValue() throws InvalidValueException {
		return valueFactory.throwInvalidValueException(EvaluatorMessages.TypedValueRequired, "Tuple", getType());
	}

	public @NonNull UniqueCollectionValue asUniqueCollectionValue() throws InvalidValueException {
		return valueFactory.throwInvalidValueException(EvaluatorMessages.TypedValueRequired, "Unique Collection", getType());
	}

	public @NonNull Value asUnlimitedNaturalValue() throws InvalidValueException {
		return valueFactory.throwInvalidValueException(EvaluatorMessages.TypedValueRequired, "UnlimitedNatural", getType());
	}

	public @NonNull Value asValidValue() throws InvalidValueException {
		return this;
	}

	public @NonNull DomainType getActualType() throws InvalidValueException {
		return getType();
	}
	
	public final @NonNull ValueFactory getValueFactory() {
		return valueFactory;
	}

	public boolean isInvalid() {
		return false;
	}

	public boolean isUndefined() {
		return false;
	}

	public void toString(@NonNull StringBuilder s, int sizeLimit) {
		s.append(toString());
	}
}
