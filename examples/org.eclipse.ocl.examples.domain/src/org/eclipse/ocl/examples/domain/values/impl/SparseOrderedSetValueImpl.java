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
 * $Id: OrderedSetValueImpl.java,v 1.6 2011/05/07 16:41:18 ewillink Exp $
 */
package org.eclipse.ocl.examples.domain.values.impl;

import java.util.Collection;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.InvalidValue;
import org.eclipse.ocl.examples.domain.values.OrderedSet;
import org.eclipse.ocl.examples.domain.values.OrderedSetValue;

/**
 * @generated NOT
 */
public class SparseOrderedSetValueImpl extends OrderedSetValueImpl
{    	
	private static @NonNull OrderedSet<Object> createValues(Object... values) {
		OrderedSet<Object> result = new OrderedSetImpl<Object>();
		for (Object value : values) {
			result.add(value);
		}
		return result;
	}

	private static @NonNull OrderedSet<Object> createValues(@NonNull Iterable<? extends Object> values) {
		OrderedSet<Object> result = new OrderedSetImpl<Object>();
		for (Object value : values) {
			result.add(value);
		}
		return result;
	}

	public static class Accumulator extends SparseOrderedSetValueImpl implements CollectionValue.Accumulator
	{
		public Accumulator(@NonNull CollectionTypeId typeId) {
			super(typeId, new OrderedSetImpl<Object>());
		}

		@SuppressWarnings("unchecked")
		public boolean add(@Nullable Object value) {
			return ((Collection<Object>)elements).add(value);			
		}		
	}
    
	public SparseOrderedSetValueImpl(@NonNull CollectionTypeId typeId, Object... values) {
		super(typeId, createValues(values));
	}

	public SparseOrderedSetValueImpl(@NonNull CollectionTypeId typeId, @NonNull Iterable<? extends Object> values) {
		super(typeId, createValues(values));
	}

	public SparseOrderedSetValueImpl(@NonNull CollectionTypeId typeId, @NonNull OrderedSet<? extends Object> values) {
		super(typeId, values);
	}

    public @NonNull OrderedSetValue append(@Nullable Object object) {
		if (object instanceof InvalidValue) {
        	throw new InvalidValueException(EvaluatorMessages.InvalidSource, "append");
		}
    	OrderedSet<Object> result = new OrderedSetImpl<Object>(elements);
        result.remove(object);  // appended object must be last
        result.add(object);
        return new SparseOrderedSetValueImpl(getTypeId(), result);
    }

    public @Nullable Object first() {
        if (elements.size() <= 0) {
        	throw new InvalidValueException(EvaluatorMessages.EmptyCollection, TypeId.ORDERED_SET_NAME, "first");
        }
        return elements.iterator().next();
    }

    public @NonNull OrderedSetValue flatten() {
    	OrderedSet<Object> flattened = new OrderedSetImpl<Object>();
    	if (flatten(flattened)) {
    		return new SparseOrderedSetValueImpl(getTypeId(), flattened);
    	}
    	else {
    		return this;
    	}
    }
    
	@Override
	protected @NonNull OrderedSet<? extends Object> getElements() {
		return (OrderedSet<? extends Object>) elements;
	}

	public @NonNull OrderedSetValue including(@Nullable Object value) {
		if (value instanceof InvalidValue) {
			throw new InvalidValueException(EvaluatorMessages.InvalidSource, "including");
		}
		OrderedSet<Object> result = new OrderedSetImpl<Object>(elements);
		result.add(value);
		return new SparseOrderedSetValueImpl(getTypeId(), result);
	}

    public @Nullable Object last() {
        if (elements.size() <= 0) {
        	throw new InvalidValueException(EvaluatorMessages.EmptyCollection, TypeId.ORDERED_SET_NAME, "last");
        }
        Object result = null;
        for (Object next : elements) {
            result = next;
        }
        return result;
    }

    public @NonNull OrderedSetValue prepend(@Nullable Object object) {
		if (object instanceof InvalidValue) {
			throw new InvalidValueException(EvaluatorMessages.InvalidSource, "prepend");
		}
    	OrderedSet<Object> result = new OrderedSetImpl<Object>();
        result.add(object);
        result.addAll(elements);
        return new SparseOrderedSetValueImpl(getTypeId(), result);
    }

	@Override
	public void toString(@NonNull StringBuilder s, int lengthLimit) {
		s.append(TypeId.ORDERED_SET_NAME);
		super.toString(s, lengthLimit);
	}
}
