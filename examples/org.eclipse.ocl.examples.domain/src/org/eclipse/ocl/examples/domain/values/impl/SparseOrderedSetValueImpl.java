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
import org.eclipse.ocl.examples.domain.ids.CollectedTypeId;
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
		public Accumulator(@NonNull CollectedTypeId typeId) {
			super(typeId, new OrderedSetImpl<Object>());
		}

		@SuppressWarnings("unchecked")
		public boolean add(@NonNull Object value) {
			return ((Collection<Object>)elements).add(value);			
		}		
	}
    
	public SparseOrderedSetValueImpl(@NonNull CollectedTypeId typeId, Object... values) {
		super(typeId, createValues(values));
	}

	public SparseOrderedSetValueImpl(@NonNull CollectedTypeId typeId, @NonNull Iterable<? extends Object> values) {
		super(typeId, createValues(values));
	}

	public SparseOrderedSetValueImpl(@NonNull CollectedTypeId typeId, @NonNull OrderedSet<? extends Object> values) {
		super(typeId, values);
	}

    public @NonNull OrderedSetValue append(@NonNull Object object) {
		if (object instanceof InvalidValue) {
        	return createInvalidValue(EvaluatorMessages.InvalidSource, "append");
		}
    	OrderedSet<Object> result = new OrderedSetImpl<Object>(elements);
        result.remove(object);  // appended object must be last
        result.add(object);
        return new SparseOrderedSetValueImpl(getTypeId(), result);
    }

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof SparseOrderedSetValueImpl) {
			SparseOrderedSetValueImpl that = (SparseOrderedSetValueImpl)obj;
			return this.elements.equals(that.elements);
		}
		else {
			return super.equals(obj);
		}
	}

    public @NonNull Object first() {
        if (elements.size() <= 0) {
        	return createInvalidValue(EvaluatorMessages.EmptyCollection, "OrderedSet", "first");
        }
        Object result = elements.iterator().next();
        if (result == null) {
        	return createInvalidValue("Null collection element");
        }
		return result;
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

	public @NonNull OrderedSetValue including(@NonNull Object value) {
		if (value instanceof InvalidValue) {
			return createInvalidValue(EvaluatorMessages.InvalidSource, "including");
		}
		OrderedSet<Object> result = new OrderedSetImpl<Object>(elements);
		result.add(value);
		return new SparseOrderedSetValueImpl(getTypeId(), result);
	}

    public @NonNull Object last() {
        if (elements.size() <= 0) {
        	return createInvalidValue(EvaluatorMessages.EmptyCollection, "OrderedSet", "last");
        }
        Object result = null;
        for (Object next : elements) {
            result = next;
        }
        if (result == null) {
        	return createInvalidValue("Null collection element");
        }
        return result;
    }

    public @NonNull OrderedSetValue prepend(@NonNull Object object) {
		if (object instanceof InvalidValue) {
			return createInvalidValue(EvaluatorMessages.InvalidSource, "prepend");
		}
    	OrderedSet<Object> result = new OrderedSetImpl<Object>();
        result.add(object);
        result.addAll(elements);
        return new SparseOrderedSetValueImpl(getTypeId(), result);
    }

	@Override
	public void toString(@NonNull StringBuilder s, int lengthLimit) {
		s.append("OrderedSet");
		super.toString(s, lengthLimit);
	}
}
