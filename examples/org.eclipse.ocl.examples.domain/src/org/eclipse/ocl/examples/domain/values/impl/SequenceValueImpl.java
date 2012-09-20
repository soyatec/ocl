/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
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
 * $Id: AbstractSequenceValue.java,v 1.4 2011/05/07 16:41:18 ewillink Exp $
 */
package org.eclipse.ocl.examples.domain.values.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.ids.CollectedTypeId;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.InvalidValue;
import org.eclipse.ocl.examples.domain.values.OrderedSetValue;
import org.eclipse.ocl.examples.domain.values.SequenceValue;
import org.eclipse.ocl.examples.domain.values.ValuesPackage;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;

/**
 * @generated NOT
 */
public abstract class SequenceValueImpl extends CollectionValueImpl implements SequenceValue
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ValuesPackage.Literals.SEQUENCE_VALUE;
	}

	public SequenceValueImpl(@NonNull CollectedTypeId typeId, @NonNull List<? extends Object> values) {
		super(typeId, values);
	}
	
	@Override
	public @NonNull List<? extends Object> asList() {
		return getElements();
	}

    @Override
	public @NonNull SequenceValue asSequenceValue() {
        return this;
    }

    public @NonNull SequenceValue append(@NonNull Object object) {
		if (object instanceof InvalidValue) {
			return createInvalidValue(EvaluatorMessages.InvalidSource, "append");
		}
    	List<Object> result = new ArrayList<Object>(elements);
        result.add(object);
        return createSequenceValue(getTypeId(), result);
    }

    public @NonNull Object at(int index) {
        index = index - 1;        
        if (index < 0 || elements.size() <= index) {
        	return createInvalidValue(EvaluatorMessages.IndexOutOfRange, index + 1, size());
		}        
        return DomainUtil.nonNullState(getElements().get(index));
    }

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof SequenceValue) || (obj instanceof OrderedSetValue)) {
			return false;
		}
		Iterator<? extends Object> theseElements = iterator();
		Iterator<? extends Object> thoseElements = ((SequenceValue)obj).iterator();
		while (theseElements.hasNext() && thoseElements.hasNext()) {
			Object thisValue = theseElements.next();
			Object thatValue = thoseElements.next();
			if (!thisValue.equals(thatValue)) {
				return false;
			}
		}
		return !theseElements.hasNext() && !thoseElements.hasNext();
	}

	public @NonNull SequenceValue excluding(@NonNull Object value) {
		List<Object> result = new ArrayList<Object>();
		for (Object element : elements) {
			if (!element.equals(value)) {
				result.add(element);
			}
		}
		if (result.size() < elements.size()) {
			return createSequenceValue(getTypeId(), result);
		}
		else {
			return this;
		}
	}

    public @NonNull Object first() {
        if (elements.size() <= 0) {
        	return createInvalidValue(EvaluatorMessages.EmptyCollection, "Sequence", "first");
        }
        return DomainUtil.nonNullState(getElements().get(0));
    }

    public @NonNull SequenceValue flatten() {
    	List<Object> flattened = new ArrayList<Object>();
    	if (flatten(flattened)) {
    		return createSequenceValue(getTypeId(), flattened);
    	}
    	else {
    		return this;
    	}
    }

    @Override
	public @NonNull CollectionTypeId getCollectionTypeId() {
		return TypeId.SEQUENCE;
	}
    
	@Override
	protected @NonNull List<? extends Object> getElements() {
		return (List<? extends Object>) elements;
	}
	
	public @NonNull String getKind() {
	    return "Sequence";
	}
	   
	public @NonNull SequenceValue including(@NonNull Object value) {
		if (value instanceof InvalidValue) {
			return createInvalidValue(EvaluatorMessages.InvalidSource, "including");
		}
		List<Object> result = new ArrayList<Object>(elements);
		result.add(value);
		return createSequenceValue(getTypeId(), result);
	}

    public @NonNull IntegerValue indexOf(@NonNull Object object) {
        int index = getElements().indexOf(object);
        if (index < 0) {
        	return createInvalidValue(EvaluatorMessages.MissingValue, "indexOf");
        }
    	return ValuesUtil.integerValueOf(index+1);
    }

    public @NonNull SequenceValue insertAt(int index, @NonNull Object object) {
		if (object instanceof InvalidValue) {
			return createInvalidValue(EvaluatorMessages.InvalidSource, "insertAt");
		}
        index = index - 1;        
        if (index < 0 || index > elements.size()) {
        	return createInvalidValue(EvaluatorMessages.IndexOutOfRange, index + 1, size());
        }        
		List<Object> result = new ArrayList<Object>(elements);
		result.add(index, object);
		return createSequenceValue(getTypeId(), result);
    }

	public boolean isOrdered() {
		return true;
	}

	public boolean isUnique() {
		return false;
	}
   
    public @NonNull Object last() {
        int size = elements.size();
		if (size <= 0) {
			return createInvalidValue(EvaluatorMessages.EmptyCollection, "Sequence", "last");
        }
        return DomainUtil.nonNullState(getElements().get(size-1));
    }
    
    public @NonNull SequenceValue prepend(@NonNull Object object) {
		if (object instanceof InvalidValue) {
			return createInvalidValue(EvaluatorMessages.InvalidSource, "prepend");
		}
    	List<Object> result = new ArrayList<Object>();
        result.add(object);
        result.addAll(elements);
        return createSequenceValue(getTypeId(), result);
    }

	public @NonNull SequenceValue reverse() {
		List<Object> elements = new ArrayList<Object>(this.elements);
		Collections.reverse(elements);
        return createSequenceValue(getTypeId(), elements);
    }
	   
    public @NonNull SequenceValue sort(@NonNull Comparator<Object> comparator) {
    	List<Object> values = new ArrayList<Object>(elements);
    	Collections.sort(values, comparator);
    	return createSequenceValue(getTypeId(), values);
    }
	
    /**
     * Implementation of the OCL
     * <tt>Sequence::subSequence(lower : Integer, upper : Integer) : Sequence(T)</tt></li>
     * operation.
     * 
     * @param self the source sequence
     * @param lower the 1-based (in OCL fashion) inclusive lower bound
     * @param upper the 1-based (in OCL fashion) inclusive upper bound
     * @return the source collection with the object inserted at the index
     * 
     * @throws IndexOutOfBoundsException if an index is out of bounds
     * @throws IllegalArgumentException if the lower bound is greater than the upper
     */
    public @NonNull SequenceValue subSequence(int lower, int upper) {
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
        
		List<Object> result = new ArrayList<Object>();
        int curr = 0;
        for (Object object : iterable()) {
            if (curr >= lower && curr <= upper) {
                result.add(object);
            }
            curr++;
        }
        return createSequenceValue(getTypeId(), result);
    }

	public @NonNull SequenceValue toSequenceValue() {
		return this;
	}

	@Override
	public void toString(@NonNull StringBuilder s, int lengthLimit) {
		s.append("Sequence");
		super.toString(s, lengthLimit);
	}
}
