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
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainCollectionType;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.InvalidValue;
import org.eclipse.ocl.examples.domain.values.NullValue;
import org.eclipse.ocl.examples.domain.values.OrderedSet;
import org.eclipse.ocl.examples.domain.values.OrderedSetValue;
import org.eclipse.ocl.examples.domain.values.SequenceValue;
import org.eclipse.ocl.examples.domain.values.UniqueCollectionValue;
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

    public static @NonNull OrderedSetValue intersection(@NonNull ValueFactory valueFactory, @NonNull DomainCollectionType type, @NonNull CollectionValue left, @NonNull CollectionValue right) throws InvalidValueException
    {
    	assert !left.isUndefined() && !right.isUndefined();
		Collection<? extends Object> leftElements = left.asCollection();
        Collection<? extends Object> rightElements = right.asCollection();
        int leftSize = leftElements.size();
        int rightSize = rightElements.size();
    	if ((leftSize == 0) || (rightSize == 0)) {
            return valueFactory.createOrderedSetValue(type);
        }    	
        OrderedSet<Object> results = new OrderedSetImpl<Object>(leftElements);
        // loop over the left collection and add only elements
        // that are in the right collection
        results.retainAll(rightElements);
     	return results.size() > 0 ? valueFactory.createOrderedSetValue(type, results) : valueFactory.createOrderedSetValue(type);
    }

    public static @NonNull OrderedSetValue union(@NonNull ValueFactory valueFactory, @NonNull DomainCollectionType type, @NonNull CollectionValue left, @NonNull CollectionValue right) throws InvalidValueException {
    	assert !left.isUndefined() && !right.isUndefined();
		Collection<? extends Object> leftElements = left.asCollection();
        Collection<? extends Object> rightElements = right.asCollection();
    	if (leftElements.isEmpty()) {
            return right.asOrderedSetValue();
        }
    	else if (rightElements.isEmpty()) {
            return left.asOrderedSetValue();
        }    	
    	else {
			OrderedSet<Object> result = new OrderedSetImpl<Object>(leftElements);
			result.addAll(rightElements);
    		return valueFactory.createOrderedSetValue(type, result);
        } 
    }
	public OrderedSetValueImpl(@NonNull ValueFactory valueFactory, @NonNull DomainCollectionType type, @NonNull Collection<? extends Object> elements) {
		super(valueFactory, type, elements);
	}

	@Override
	public @NonNull OrderedSetValueImpl asOrderedSetValue() {
		return this;
	}

	@Override
	public @NonNull SequenceValue asSequenceValue() {
		return this;
	}

	@Override
	public @NonNull UniqueCollectionValue asUniqueCollectionValue() {
        return this;
	}
	
    public @NonNull Object at(int index) throws InvalidValueException {
        index = index - 1;        
        if (index < 0 || index >= elements.size()) {
			valueFactory.throwInvalidValueException(EvaluatorMessages.IndexOutOfRange, index + 1, size());
		}        
        int curr = 0;
        for (Iterator<? extends Object> it = iterator(); it.hasNext();) {
        	Object object = it.next();
            if (curr++ == index) {
                if (object != null) {
                	return object;
                }
                break;
            }
        }
		return valueFactory.throwInvalidValueException("Null collection content");
    }

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof OrderedSetValue) || (obj instanceof NullValue)) {
			return false;
		}
		Iterator<? extends Object> theseElements = iterator();
		Iterator<? extends Object> thoseElements = ((OrderedSetValue)obj).iterator();
		while (theseElements.hasNext() && thoseElements.hasNext()) {
			Object thisValue = theseElements.next();
			Object thatValue = thoseElements.next();
			if (!thisValue.equals(thatValue)) {
				return false;
			}
		}
		return !theseElements.hasNext() && !thoseElements.hasNext();
	}

	public @NonNull OrderedSetValue excluding(@NonNull Object value) {
		OrderedSet<Object> result = new OrderedSetImpl<Object>();
		for (Object element : elements) {
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

	public @NonNull String getKind() {
	    return "OrderedSet";
	}

    public @NonNull IntegerValue indexOf(@NonNull Object object) throws InvalidValueException {
        int index = 1;        
        for (Object next : elements) {
            if (object.equals(next)) {
                return valueFactory.integerValueOf(index);
            }
            index++;
        }        
		return valueFactory.throwInvalidValueException(EvaluatorMessages.MissingValue, "indexOf");
    }

    public @NonNull OrderedSetValue insertAt(int index, @NonNull Object object) throws InvalidValueException {
		if (object instanceof InvalidValue) {
			valueFactory.throwInvalidValueException(EvaluatorMessages.InvalidSource, "insertAt");
		}
        index = index - 1;
        boolean isContained = elements.contains(object);
        int effectiveSize = elements.size() - (isContained ? 1 : 0);
        if ((index < 0) || (effectiveSize < index)) {
        	valueFactory.throwInvalidValueException(EvaluatorMessages.IndexOutOfRange, index + 1, size());
        }
        
        OrderedSet<Object> result = new OrderedSetImpl<Object>();
        int curr = 0;
        for (Iterator<? extends Object> it = iterator(); it.hasNext();) {
            if (curr == index) {
                result.add(object);
            }
            Object next = it.next();
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

    public @NonNull OrderedSetValue minus(@NonNull UniqueCollectionValue set) throws InvalidValueException {
    	OrderedSet<Object> result = new OrderedSetImpl<Object>(elements);
        result.removeAll(set.asCollection());
        return valueFactory.createOrderedSetValue(getCollectionType(), result);
    }

	public @NonNull OrderedSetValue reverse() {
		List<? extends Object> elements = asList();
		Collections.reverse(elements);
        return valueFactory.createOrderedSetValue(getCollectionType(), elements);
    }
    
    public @NonNull OrderedSetValue sort(@NonNull Comparator<Object> comparator) {
    	List<Object> values = new ArrayList<Object>(elements);
    	Collections.sort(values, comparator);
    	return valueFactory.createOrderedSetValue(getCollectionType(), values);
    }

    public @NonNull OrderedSetValue subOrderedSet(int lower, int upper) {
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
        
        OrderedSet<Object> result = new OrderedSetImpl<Object>();
        int curr = 0;
        for (Iterator<? extends Object> it = elements.iterator(); it.hasNext();) {
        	Object object = it.next();
            if (curr >= lower && curr <= upper) {
                result.add(object);
            }
            curr++;
        }
        return valueFactory.createOrderedSetValue(getCollectionType(), result);
    }

	public @NonNull SequenceValue subSequence(int lower, int upper) throws InvalidValueException {
		return subOrderedSet(lower, upper);
	}

    public @NonNull OrderedSetValue symmetricDifference(@NonNull UniqueCollectionValue set) {       
    	OrderedSet<Object> result = new OrderedSetImpl<Object>(elements);       
        for (Object e : set.iterable()) {
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
