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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.examples.domain.elements.DomainCollectionType;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.NullValue;
import org.eclipse.ocl.examples.domain.values.OrderedSet;
import org.eclipse.ocl.examples.domain.values.OrderedSetValue;
import org.eclipse.ocl.examples.domain.values.SequenceValue;
import org.eclipse.ocl.examples.domain.values.UniqueCollectionValue;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.domain.values.ValueFactory;
import org.eclipse.ocl.examples.domain.values.ValuesPackage;

/**
 * @generated NOT
 */
public abstract class OrderedSetValueImpl extends CollectionValueImpl implements OrderedSetValue
{    
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ValuesPackage.Literals.ORDERED_SET_VALUE;
	}

    public static OrderedSetValue intersection(ValueFactory valueFactory, DomainCollectionType type, CollectionValue left, CollectionValue right) throws InvalidValueException
    {
    	assert !left.isUndefined() && !right.isUndefined();
		Collection<Value> leftElements = left.asCollection();
        Collection<Value> rightElements = right.asCollection();
        int leftSize = leftElements.size();
        int rightSize = rightElements.size();
    	if ((leftSize == 0) || (rightSize == 0)) {
            return valueFactory.createOrderedSetValue(type);
        }    	
        OrderedSet<Value> results = new OrderedSetImpl<Value>(leftElements);
        // loop over the left collection and add only elements
        // that are in the right collection
        results.retainAll(rightElements);
     	return results.size() > 0 ? valueFactory.createOrderedSetValue(type, results) : valueFactory.createOrderedSetValue(type);
    }

    public static OrderedSetValue union(ValueFactory valueFactory, DomainCollectionType type, CollectionValue left, CollectionValue right) throws InvalidValueException {
    	assert !left.isUndefined() && !right.isUndefined();
		Collection<Value> leftElements = left.asCollection();
        Collection<Value> rightElements = right.asCollection();
    	if (leftElements.isEmpty()) {
            return right.asOrderedSetValue();
        }
    	else if (rightElements.isEmpty()) {
            return left.asOrderedSetValue();
        }    	
    	else {
			OrderedSet<Value> result = new OrderedSetImpl<Value>(leftElements);
			result.addAll(rightElements);
    		return valueFactory.createOrderedSetValue(type, result);
        } 
    }
	public OrderedSetValueImpl(ValueFactory valueFactory,
			DomainCollectionType type, Collection<Value> elements) {
		super(valueFactory, type, elements);
	}

	@Override
	public OrderedSetValueImpl asOrderedSetValue() {
		return this;
	}

	@Override
	public SequenceValue asSequenceValue() {
		return this;
	}

	@Override
	public UniqueCollectionValue asUniqueCollectionValue() {
        return this;
	}
	
    public Value at(int index) throws InvalidValueException {
        index = index - 1;        
        if (index < 0 || index >= elements.size()) {
			valueFactory.throwInvalidValueException(EvaluatorMessages.IndexOutOfRange, index + 1, size());
		}        
        int curr = 0;
        for (Iterator<Value> it = iterator(); it.hasNext();) {
        	Value object = it.next();
            if (curr++ == index) {
                return object;
            }
        }
        return null; // undefined
    }

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof OrderedSetValue) || (obj instanceof NullValue)) {
			return false;
		}
		Iterator<Value> theseElements = iterator();
		Iterator<Value> thoseElements = ((OrderedSetValue)obj).iterator();
		while (theseElements.hasNext() && thoseElements.hasNext()) {
			Value thisValue = theseElements.next();
			Value thatValue = thoseElements.next();
			if (!thisValue.equals(thatValue)) {
				return false;
			}
		}
		return !theseElements.hasNext() && !thoseElements.hasNext();
	}

	public OrderedSetValue excluding(Value value) {
		OrderedSet<Value> result = new OrderedSetImpl<Value>();
		for (Value element : elements) {
			if (!element.equals(value)) {
				result.add(element);
			}
		}
		if (result.size() < elements.size()) {
			return new SparseOrderedSetValueImpl(valueFactory, getCollectionType(), result);
		}
		else {
			return this;
		}
	}

	public String getKind() {
	    return "OrderedSet";
	}

    public IntegerValue indexOf(Value object) throws InvalidValueException {
        int index = 1;        
        for (Value next : elements) {
            if (object.equals(next)) {
                return valueFactory.integerValueOf(index);
            }
            index++;
        }        
		valueFactory.throwInvalidValueException(EvaluatorMessages.MissingValue, "indexOf");
		return null;
    }

    public OrderedSetValue insertAt(int index, Value object) throws InvalidValueException {
		if (object.isInvalid()) {
			valueFactory.throwInvalidValueException(EvaluatorMessages.InvalidSource, "insertAt");
		}
        index = index - 1;
        boolean isContained = elements.contains(object);
        int effectiveSize = elements.size() - (isContained ? 1 : 0);
        if ((index < 0) || (effectiveSize < index)) {
        	valueFactory.throwInvalidValueException(EvaluatorMessages.IndexOutOfRange, index + 1, size());
        }
        
        OrderedSet<Value> result = new OrderedSetImpl<Value>();
        int curr = 0;
        for (Iterator<Value> it = iterator(); it.hasNext();) {
            if (curr == index) {
                result.add(object);
            }
            Value next = it.next();
            if (!next.equals(object)) {
				result.add(next);
	            curr++;
            }
        }
        
        if (index == effectiveSize) {
        	// the loop finished before we could add the object
        	result.add(object);
        }
        return valueFactory.createOrderedSetValue(getCollectionType(), result);
    }

    public OrderedSetValue minus(UniqueCollectionValue set) throws InvalidValueException {
    	OrderedSet<Value> result = new OrderedSetImpl<Value>(elements);
        result.removeAll(set.asCollection());
        return valueFactory.createOrderedSetValue(getCollectionType(), result);
    }

	public OrderedSetValue reverse() {
		List<Value> elements = asList();
		Collections.reverse(elements);
        return valueFactory.createOrderedSetValue(getCollectionType(), elements);
    }
    
    public OrderedSetValue sort(Comparator<Value> comparator) {
    	List<Value> values = new ArrayList<Value>(elements);
    	Collections.sort(values, comparator);
    	return valueFactory.createOrderedSetValue(getCollectionType(), values);
    }

    public OrderedSetValue subOrderedSet(int lower, int upper) {
        lower = lower - 1;
        upper = upper - 1;
        
        if (lower < 0) {
			throw new IndexOutOfBoundsException("lower: " + (lower + 1)); //$NON-NLS-1$
        } else if (upper >= elements.size()) {
			throw new IndexOutOfBoundsException(
				"upper: " + (upper + 1) + ", size: " //$NON-NLS-1$ //$NON-NLS-2$
					+ size());
        } else if (upper < lower) {
			throw new IllegalArgumentException(
				"lower: " + (lower + 1) + ", upper: " //$NON-NLS-1$ //$NON-NLS-2$
					+ (upper + 1));
        }
        
        OrderedSet<Value> result = new OrderedSetImpl<Value>();
        int curr = 0;
        for (Iterator<Value> it = elements.iterator(); it.hasNext();) {
        	Value object = it.next();
            if (curr >= lower && curr <= upper) {
                result.add(object);
            }
            curr++;
        }
        return valueFactory.createOrderedSetValue(getCollectionType(), result);
    }

	public SequenceValue subSequence(int lower, int upper) throws InvalidValueException {
		return subOrderedSet(lower, upper);
	}

    public OrderedSetValue symmetricDifference(UniqueCollectionValue set) {       
    	OrderedSet<Value> result = new OrderedSetImpl<Value>(elements);       
        for (Value e : set) {
            if (result.contains(e)) {
                result.remove(e);
            } else {
                result.add(e);
            }
        }        
        return valueFactory.createOrderedSetValue(getCollectionType(), result);
    }

	public SequenceValue toSequenceValue() {
		return this;
	}
}
