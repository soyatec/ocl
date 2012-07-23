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
 * $Id: AbstractUndefinedCollectionValue.java,v 1.5 2011/04/25 09:49:14 ewillink Exp $
 */
package org.eclipse.ocl.examples.domain.values.impl;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainCollectionType;
import org.eclipse.ocl.examples.domain.elements.DomainTupleType;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.library.LibraryBinaryOperation;
import org.eclipse.ocl.examples.domain.values.BooleanValue;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.NullValue;
import org.eclipse.ocl.examples.domain.values.SequenceValue;
import org.eclipse.ocl.examples.domain.values.TupleValue;
import org.eclipse.ocl.examples.domain.values.UniqueCollectionValue;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.domain.values.ValueFactory;

/**
 * @generated NOT
 */
public abstract class UndefinedCollectionValueImpl extends UndefinedValueImpl
{	
	private static class Iterator implements java.util.Iterator<Value>
	{
		public boolean hasNext() {
			return false;
		}

		public Value next() {
			return null;
		}

		public void remove() {
		}
	}

	protected UndefinedCollectionValueImpl(@NonNull ValueFactory valueFactory) {
		super(valueFactory);
	}

	public @NonNull SequenceValue append(@NonNull Value object) throws InvalidValueException {
		return toInvalidValue();
	}

	public @NonNull Collection<Value> asCollection() throws InvalidValueException {
		throw new InvalidValueException("Collection value required");
	}

	public @NonNull List<Value> asList() throws InvalidValueException {
		throw new InvalidValueException("List value required");
	}

	public @NonNull Value at(int index) throws InvalidValueException {
		return toInvalidValue();
	}

    public @NonNull IntegerValue count(@NonNull Value value) throws InvalidValueException {
        return toInvalidValue();
    }

	public @NonNull CollectionValue createNew() throws InvalidValueException {
		return toInvalidValue();
	}

//	@Override
//	public int hashCode() {
//		return elements.hashCode();
//	}

    public @NonNull BooleanValue excludes(@NonNull Value value) throws InvalidValueException {
    	return toInvalidValue();
    }


    public @NonNull BooleanValue excludesAll(@NonNull CollectionValue c) throws InvalidValueException {
    	return toInvalidValue();
    }

	public @NonNull CollectionValue excluding(@NonNull Value value) throws InvalidValueException {
		return toInvalidValue();
	}

    public @NonNull Value first() throws InvalidValueException {
		return toInvalidValue();
	}

	public @NonNull CollectionValue flatten() throws InvalidValueException {
    	return toInvalidValue();
    }

	public boolean flatten(@NonNull Collection<Value> flattenedElements) {
		return false;
	}

	public @NonNull DomainCollectionType getCollectionType() {
		return (DomainCollectionType) getType();
	}
	
	public String getKind() {
	    return "Collection";		// FIXME UOE ??
	}

    public @NonNull BooleanValue includes(@NonNull Value value) throws InvalidValueException {
    	return toInvalidValue();
    }

    public @NonNull BooleanValue includesAll(@NonNull CollectionValue c) throws InvalidValueException {
    	return toInvalidValue();
   }

	public @NonNull CollectionValue including(@NonNull Value value) throws InvalidValueException {
		return toInvalidValue();
	}

	public @NonNull IntegerValue indexOf(@NonNull Value object) throws InvalidValueException {
		return toInvalidValue();
	}

	public @NonNull SequenceValue insertAt(int index, @NonNull Value object) throws InvalidValueException {
		return toInvalidValue();
	}

	public int intSize() {
		return 0;
	}

	public @NonNull CollectionValue intersection(@NonNull CollectionValue c) throws InvalidValueException {
		return toInvalidValue();
	}

	public @NonNull BooleanValue isEmpty() throws InvalidValueException {
    	return toInvalidValue();
	}

	public @NonNull Iterator iterator() {
		return new Iterator();
	}
	
	public @NonNull Value last() throws InvalidValueException {
		return toInvalidValue();
	}

	public @NonNull Value maxMin(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, @NonNull LibraryBinaryOperation binaryOperation) throws InvalidValueException {
    	return toInvalidValue();
	}

	public @NonNull NullValue minus(@NonNull UniqueCollectionValue set) throws InvalidValueException {
		return toInvalidValue();
	}

	public @NonNull BooleanValue notEmpty() throws InvalidValueException {
    	return toInvalidValue();
	}

	public @NonNull SequenceValue prepend(@NonNull Value object) throws InvalidValueException {
		return toInvalidValue();
	}

	public @Nullable Set<TupleValue> product(@NonNull CollectionValue c, @NonNull DomainTupleType tupleType) {
		return null;
	}

	public @NonNull SequenceValue reverse() throws InvalidValueException {
		return toInvalidValue();
	}

	public @NonNull CollectionValue selectByKind(@NonNull DomainType elementType) throws InvalidValueException {
    	return toInvalidValue();
	}

	public @NonNull CollectionValue selectByType(@NonNull DomainType elementType) throws InvalidValueException {
    	return toInvalidValue();
	}

	public @NonNull IntegerValue size() throws InvalidValueException {
    	return toInvalidValue();
	}

    public @NonNull SequenceValue sort(@NonNull Comparator<Value> comparator) throws InvalidValueException {
		return toInvalidValue();
	}

	public @NonNull NullValue subOrderedSet(int lower, int upper) throws InvalidValueException {
		return toInvalidValue();
	}

	public @NonNull NullValue subSequence(int lower, int upper) throws InvalidValueException {
		return toInvalidValue();
	}

	public @NonNull Value sum(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, @NonNull LibraryBinaryOperation binaryOperation, @NonNull Value zero) throws InvalidValueException {
    	return toInvalidValue();
	}

	public @NonNull NullValue symmetricDifference(@NonNull UniqueCollectionValue set) throws InvalidValueException {
		return toInvalidValue();
	}
    
	public @NonNull SequenceValue toSequenceValue() {
		return this;
	}

	public @NonNull CollectionValue union(@NonNull CollectionValue c) {
        return this;
    }
}
