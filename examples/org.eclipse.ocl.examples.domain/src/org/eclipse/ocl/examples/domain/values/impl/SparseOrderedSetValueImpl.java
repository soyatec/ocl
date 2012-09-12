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
import org.eclipse.ocl.examples.domain.elements.DomainCollectionType;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.InvalidValue;
import org.eclipse.ocl.examples.domain.values.OrderedSet;
import org.eclipse.ocl.examples.domain.values.OrderedSetValue;
import org.eclipse.ocl.examples.domain.values.ValueFactory;

/**
 * @generated NOT
 */
public class SparseOrderedSetValueImpl extends OrderedSetValueImpl
{    	
	private static @NonNull OrderedSet<Object> createValue(Object... elements) {
		OrderedSet<Object> result = new OrderedSetImpl<Object>();
		for (Object element : elements) {
			result.add(element);
		}
		return result;
	}

	private static @NonNull OrderedSet<Object> createValue(@NonNull Iterable<? extends Object> elements) {
		OrderedSet<Object> result = new OrderedSetImpl<Object>();
		for (Object element : elements) {
			result.add(element);
		}
		return result;
	}

	public static class Accumulator extends SparseOrderedSetValueImpl implements CollectionValue.Accumulator
	{
		public Accumulator(@NonNull ValueFactory valueFactory, @NonNull DomainCollectionType type) {
			super(valueFactory, type);
		}

		@SuppressWarnings("unchecked")
		public boolean add(@NonNull Object value) {
			return ((Collection<Object>)elements).add(value);			
		}		
	}
    
	public SparseOrderedSetValueImpl(@NonNull ValueFactory valueFactory, @NonNull DomainCollectionType type, Object... elements) {
		super(valueFactory, type, createValue(elements));
	}

	public SparseOrderedSetValueImpl(@NonNull ValueFactory valueFactory, @NonNull DomainCollectionType type, @NonNull Iterable<? extends Object> elements) {
		super(valueFactory, type, createValue(elements));
	}

	public SparseOrderedSetValueImpl(@NonNull ValueFactory valueFactory, @NonNull DomainCollectionType type, @NonNull OrderedSet<Object> elements) {
		super(valueFactory, type, elements);
	}

    public @NonNull OrderedSetValue append(@NonNull Object object) throws InvalidValueException {
		if (object instanceof InvalidValue) {
			valueFactory.throwInvalidValueException(EvaluatorMessages.InvalidSource, "append");
		}
    	OrderedSet<Object> result = new OrderedSetImpl<Object>(elements);
        result.remove(object);  // appended object must be last
        result.add(object);
        return new SparseOrderedSetValueImpl(valueFactory, getCollectionType(), result);
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

    public @NonNull Object first() throws InvalidValueException {
        if (elements.size() <= 0) {
        	valueFactory.throwInvalidValueException(EvaluatorMessages.EmptyCollection, "OrderedSet", "first");
        }
        Object result = elements.iterator().next();
        if (result == null) {
        	return valueFactory.throwInvalidValueException("Null collection element");
        }
		return result;
    }

    public @NonNull OrderedSetValue flatten() throws InvalidValueException {
    	OrderedSet<Object> flattened = new OrderedSetImpl<Object>();
    	if (flatten(flattened)) {
    		return new SparseOrderedSetValueImpl(valueFactory, getCollectionType(), flattened);
    	}
    	else {
    		return this;
    	}
    }
    
	@Override
	protected @NonNull OrderedSet<? extends Object> getElements() {
		return (OrderedSet<? extends Object>) elements;
	}

	public @NonNull OrderedSetValue including(@NonNull Object value) throws InvalidValueException {
		if (value instanceof InvalidValue) {
			valueFactory.throwInvalidValueException(EvaluatorMessages.InvalidSource, "including");
		}
		OrderedSet<Object> result = new OrderedSetImpl<Object>(elements);
		result.add(value);
		return new SparseOrderedSetValueImpl(valueFactory, getCollectionType(), result);
	}

    public @NonNull Object last() throws InvalidValueException {
        if (elements.size() <= 0) {
        	return valueFactory.throwInvalidValueException(EvaluatorMessages.EmptyCollection, "OrderedSet", "last");
        }
        Object result = null;
        for (Object next : elements) {
            result = next;
        }
        if (result == null) {
        	return valueFactory.throwInvalidValueException("Null collection element");
        }
        return result;
    }

    public @NonNull OrderedSetValue prepend(@NonNull Object object) throws InvalidValueException {
		if (object instanceof InvalidValue) {
			valueFactory.throwInvalidValueException(EvaluatorMessages.InvalidSource, "prepend");
		}
    	OrderedSet<Object> result = new OrderedSetImpl<Object>();
        result.add(object);
        result.addAll(elements);
        return new SparseOrderedSetValueImpl(valueFactory, getCollectionType(), result);
    }

	@Override
	public void toString(@NonNull StringBuilder s, int lengthLimit) {
		s.append("OrderedSet");
		super.toString(s, lengthLimit);
	}
}
