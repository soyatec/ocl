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

import org.eclipse.ocl.examples.domain.elements.DomainCollectionType;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.OrderedSet;
import org.eclipse.ocl.examples.domain.values.OrderedSetValue;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.domain.values.ValueFactory;

/**
 * @generated NOT
 */
public class SparseOrderedSetValueImpl extends OrderedSetValueImpl
{    	
	public static class Accumulator extends SparseOrderedSetValueImpl implements CollectionValue.Accumulator
	{
		public Accumulator(ValueFactory valueFactory, DomainCollectionType type) {
			super(valueFactory, type);
		}

		public boolean add(Value value) {
			return elements.add(value);			
		}		
	}
    
	public SparseOrderedSetValueImpl(ValueFactory valueFactory, DomainCollectionType type, Value... elements) {
		super(valueFactory, type, new OrderedSetImpl<Value>());
		if (elements != null) {
			for (Value element : elements) {
				this.elements.add(element);
			}
		}
	}

	public SparseOrderedSetValueImpl(ValueFactory valueFactory, DomainCollectionType type, Collection<? extends Value> elements) {
		super(valueFactory, type, new OrderedSetImpl<Value>(elements));
	}

	public SparseOrderedSetValueImpl(ValueFactory valueFactory, DomainCollectionType type, OrderedSet<Value> elements) {
		super(valueFactory, type, elements);
	}

    public OrderedSetValue append(Value object) throws InvalidValueException {
		if (object.isInvalid()) {
			valueFactory.throwInvalidValueException(EvaluatorMessages.InvalidSource, "append");
		}
    	OrderedSet<Value> result = new OrderedSetImpl<Value>(elements);
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

    public Value first() throws InvalidValueException {
        if ((elements == null) || (elements.size() <= 0)) {
        	valueFactory.throwInvalidValueException(EvaluatorMessages.EmptyCollection, "OrderedSet", "first");
        }
        return elements.iterator().next();
    }

    public OrderedSetValue flatten() throws InvalidValueException {
    	OrderedSet<Value> flattened = new OrderedSetImpl<Value>();
    	if (flatten(flattened)) {
    		return new SparseOrderedSetValueImpl(valueFactory, getCollectionType(), flattened);
    	}
    	else {
    		return this;
    	}
    }
    
	@Override
	protected OrderedSet<Value> getElements() {
		return (OrderedSet<Value>) elements;
	}

	public OrderedSetValue including(Value value) throws InvalidValueException {
		if (value.isInvalid()) {
			valueFactory.throwInvalidValueException(EvaluatorMessages.InvalidSource, "including");
		}
		OrderedSet<Value> result = new OrderedSetImpl<Value>(elements);
		result.add(value);
		return new SparseOrderedSetValueImpl(valueFactory, getCollectionType(), result);
	}

    public Value last() throws InvalidValueException {
        if ((elements == null) || (elements.size() <= 0)) {
        	valueFactory.throwInvalidValueException(EvaluatorMessages.EmptyCollection, "OrderedSet", "last");
        }
        Value result = null;
        for (Value next : elements) {
            result = next;
        }
        return result;
    }

    public OrderedSetValue prepend(Value object) throws InvalidValueException {
		if (object.isInvalid()) {
			valueFactory.throwInvalidValueException(EvaluatorMessages.InvalidSource, "prepend");
		}
    	OrderedSet<Value> result = new OrderedSetImpl<Value>();
        result.add(object);
        result.addAll(elements);
        return new SparseOrderedSetValueImpl(valueFactory, getCollectionType(), result);
    }

	@Override
	public void toString(StringBuilder s, int lengthLimit) {
		s.append("OrderedSet");
		super.toString(s, lengthLimit);
	}
}