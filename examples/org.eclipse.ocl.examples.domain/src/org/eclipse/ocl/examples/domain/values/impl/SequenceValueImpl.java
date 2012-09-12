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
import org.eclipse.ocl.examples.domain.elements.DomainCollectionType;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.InvalidValue;
import org.eclipse.ocl.examples.domain.values.OrderedSetValue;
import org.eclipse.ocl.examples.domain.values.SequenceValue;
import org.eclipse.ocl.examples.domain.values.ValueFactory;
import org.eclipse.ocl.examples.domain.values.ValuesPackage;

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

	public SequenceValueImpl(@NonNull ValueFactory valueFactory, @NonNull DomainCollectionType type, @NonNull List<? extends Object> elements) {
		super(valueFactory, type, elements);
	}
	
	@Override
	public @NonNull List<? extends Object> asList() {
		return getElements();
	}

    @Override
	public @NonNull SequenceValue asSequenceValue() {
        return this;
    }

    public @NonNull SequenceValue append(@NonNull Object object) throws InvalidValueException {
		if (object instanceof InvalidValue) {
        	valueFactory.throwInvalidValueException(EvaluatorMessages.InvalidSource, "append");
		}
    	List<Object> result = new ArrayList<Object>(elements);
        result.add(object);
        return valueFactory.createSequenceValue(getCollectionType(), result);
    }

    public @NonNull Object at(int index) throws InvalidValueException {
        index = index - 1;        
        if (index < 0 || elements.size() <= index) {
        	valueFactory.throwInvalidValueException(EvaluatorMessages.IndexOutOfRange, index + 1, size());
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
			return valueFactory.createSequenceValue(getCollectionType(), result);
		}
		else {
			return this;
		}
	}

    public @NonNull Object first() throws InvalidValueException {
        if (elements.size() <= 0) {
        	valueFactory.throwInvalidValueException(EvaluatorMessages.EmptyCollection, "Sequence", "first");
        }
        return DomainUtil.nonNullState(getElements().get(0));
    }

    public @NonNull SequenceValue flatten() throws InvalidValueException {
    	List<Object> flattened = new ArrayList<Object>();
    	if (flatten(flattened)) {
    		return valueFactory.createSequenceValue(getCollectionType(), flattened);
    	}
    	else {
    		return this;
    	}
    }
    
	@Override
	protected @NonNull List<? extends Object> getElements() {
		return (List<? extends Object>) elements;
	}
	
	public @NonNull String getKind() {
	    return "Sequence";
	}
	   
	public @NonNull SequenceValue including(@NonNull Object value) throws InvalidValueException {
		if (value instanceof InvalidValue) {
			valueFactory.throwInvalidValueException(EvaluatorMessages.InvalidSource, "including");
		}
		List<Object> result = new ArrayList<Object>(elements);
		result.add(value);
		return valueFactory.createSequenceValue(getCollectionType(), result);
	}

    public @NonNull IntegerValue indexOf(@NonNull Object object) throws InvalidValueException {
        int index = getElements().indexOf(object);
        if (index < 0) {
			valueFactory.throwInvalidValueException(EvaluatorMessages.MissingValue, "indexOf");
        }
    	return valueFactory.integerValueOf(index+1);
    }

    public @NonNull SequenceValue insertAt(int index, @NonNull Object object) throws InvalidValueException {
		if (object instanceof InvalidValue) {
			valueFactory.throwInvalidValueException(EvaluatorMessages.InvalidSource, "insertAt");
		}
        index = index - 1;        
        if (index < 0 || index > elements.size()) {
        	valueFactory.throwInvalidValueException(EvaluatorMessages.IndexOutOfRange, index + 1, size());
        }        
		List<Object> result = new ArrayList<Object>(elements);
		result.add(index, object);
		return valueFactory.createSequenceValue(getCollectionType(), result);
    }
    
    public @NonNull Object last() throws InvalidValueException {
        int size = elements.size();
		if (size <= 0) {
        	valueFactory.throwInvalidValueException(EvaluatorMessages.EmptyCollection, "Sequence", "last");
        }
        return DomainUtil.nonNullState(getElements().get(size-1));
    }
    
    public @NonNull SequenceValue prepend(@NonNull Object object) throws InvalidValueException {
		if (object instanceof InvalidValue) {
			valueFactory.throwInvalidValueException(EvaluatorMessages.InvalidSource, "prepend");
		}
    	List<Object> result = new ArrayList<Object>();
        result.add(object);
        result.addAll(elements);
        return valueFactory.createSequenceValue(getCollectionType(), result);
    }

	public @NonNull SequenceValue reverse() throws InvalidValueException {
		List<Object> elements = new ArrayList<Object>(this.elements);
		Collections.reverse(elements);
        return valueFactory.createSequenceValue(getCollectionType(), elements);
    }
	   
    public @NonNull SequenceValue sort(@NonNull Comparator<Object> comparator) {
    	List<Object> values = new ArrayList<Object>(elements);
    	Collections.sort(values, comparator);
    	return valueFactory.createSequenceValue(getCollectionType(), values);
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
        return valueFactory.createSequenceValue(getCollectionType(), result);
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
