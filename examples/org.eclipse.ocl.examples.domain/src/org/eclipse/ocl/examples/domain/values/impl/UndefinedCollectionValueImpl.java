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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.ids.TupleTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.NullValue;
import org.eclipse.ocl.examples.domain.values.SequenceValue;
import org.eclipse.ocl.examples.domain.values.TupleValue;
import org.eclipse.ocl.examples.domain.values.UniqueCollectionValue;
import org.eclipse.ocl.examples.domain.values.Value;
//import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;

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

	protected UndefinedCollectionValueImpl() {}

	public @NonNull SequenceValue append(@Nullable Object object) {
		return toInvalidValue();
	}

	public @NonNull Collection<Object> asCollection() {
		throw new InvalidValueException("Collection value required");
	}

	public @NonNull List<Object> asList() {
		throw new InvalidValueException("List value required");
	}

	public @Nullable Value at(int index) {
		return toInvalidValue();
	}

    public @NonNull IntegerValue count(@Nullable Object value) {
        return toInvalidValue();
    }

	public @NonNull CollectionValue createNew() {
		return toInvalidValue();
	}

    public @NonNull Object excludes(@Nullable Object value) {
    	return toInvalidValue();
    }


    public @NonNull Object excludesAll(@NonNull CollectionValue c) {
    	return toInvalidValue();
    }

	public @NonNull CollectionValue excluding(@Nullable Object value) {
		return toInvalidValue();
	}

    public @Nullable Value first() {
		return toInvalidValue();
	}

	public @NonNull CollectionValue flatten() {
    	return toInvalidValue();
    }

	public boolean flatten(@NonNull Collection<Object> flattenedElements) {
		return false;
	}

//	public @NonNull DomainCollectionType getCollectionType(@NonNull DomainStandardLibrary standardLibrary) {
//		return (DomainCollectionType) getType(standardLibrary);
//	}
    
	public @NonNull List<? extends Object> getElements() {
		throw new InvalidValueException("bad getElements()");
	}
	
	public String getKind() {
	    return TypeId.COLLECTION_NAME;		// FIXME UOE ??
	}

    public @NonNull Object includes(@Nullable Object value) {
    	return toInvalidValue();
    }

    public @NonNull Object includesAll(@NonNull CollectionValue c) {
    	return toInvalidValue();
   }

	public @NonNull CollectionValue including(@Nullable Object value) {
		return toInvalidValue();
	}

	public @NonNull IntegerValue indexOf(@Nullable Object object) {
		return toInvalidValue();
	}

	public @NonNull SequenceValue insertAt(int index, @Nullable Object object) {
		return toInvalidValue();
	}

	public int intSize() {
		return 0;
	}

	public @NonNull CollectionValue intersection(@NonNull CollectionValue c) {
		return toInvalidValue();
	}

	public @NonNull Object isEmpty() {
    	return toInvalidValue();
	}

	public boolean isOrdered() {
		return false;
	}

	public boolean isUnique() {
		return false;
	}

	@SuppressWarnings("null")
	public @NonNull Iterable<? extends Object> iterable() {
		return Collections.<Object>emptyList();
	}

	public @NonNull Iterator iterator() {
		return new Iterator();
	}
	
	public @Nullable Value last() {
		return toInvalidValue();
	}

	public @NonNull NullValue minus(@NonNull UniqueCollectionValue set) {
		return toInvalidValue();
	}

	public @NonNull Object notEmpty() {
    	return toInvalidValue();
	}

	public @NonNull SequenceValue prepend(@Nullable Object object) {
		return toInvalidValue();
	}

	public @Nullable Set<TupleValue> product(@NonNull CollectionValue c, @NonNull TupleTypeId tupleTypeId) {
		return null;
	}

	public @NonNull SequenceValue reverse() {
		return toInvalidValue();
	}

	public @NonNull IntegerValue size() {
    	return toInvalidValue();
	}

    public @NonNull SequenceValue sort(@NonNull Comparator<Object> comparator) {
		return toInvalidValue();
	}

	public @NonNull NullValue subOrderedSet(int lower, int upper) {
		return toInvalidValue();
	}

	public @NonNull NullValue subSequence(int lower, int upper) {
		return toInvalidValue();
	}

	public @NonNull NullValue symmetricDifference(@NonNull UniqueCollectionValue set) {
		return toInvalidValue();
	}
    
	public @NonNull SequenceValue toSequenceValue() {
		return this;
	}

	public @NonNull CollectionValue union(@NonNull CollectionValue c) {
        return this;
    }
}
