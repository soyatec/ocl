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
 * $Id: SetValueImpl.java,v 1.5 2011/05/07 16:41:20 ewillink Exp $
 */
package org.eclipse.ocl.examples.domain.values.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainCollectionType;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.values.BagValue;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.InvalidValue;
import org.eclipse.ocl.examples.domain.values.OrderedSetValue;
import org.eclipse.ocl.examples.domain.values.SequenceValue;
import org.eclipse.ocl.examples.domain.values.SetValue;
import org.eclipse.ocl.examples.domain.values.UniqueCollectionValue;
import org.eclipse.ocl.examples.domain.values.ValueFactory;
import org.eclipse.ocl.examples.domain.values.ValuesPackage;

//
//	Note that it is not necessary to adjust set uniqueness for OCL value equivalence
//	since Value.equals realises OCL equivalence, and so Collection operations that
//	inherently use Object.equals automatically observe OCL uniqueness.
//
/**
 * @generated NOT
 */
public class SetValueImpl extends CollectionValueImpl implements SetValue
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ValuesPackage.Literals.SET_VALUE;
	}

	private static @NonNull Set<Object> createValue(Object... elements) {
		Set<Object> result = new HashSet<Object>();
		for (Object element : elements) {
			result.add(element);
		}
		return result;
	}

	private static @NonNull Set<Object> createValue(@NonNull Iterable<? extends Object> elements) {
		Set<Object> result = new HashSet<Object>();
		for (Object element : elements) {
			result.add(element);
		}
		return result;
	}

    public static @NonNull SetValue intersection(@NonNull ValueFactory valueFactory, @NonNull DomainCollectionType type, @NonNull CollectionValue left, @NonNull CollectionValue right) throws InvalidValueException
    {
    	assert !left.isUndefined() && !right.isUndefined();
		Collection<? extends Object> leftElements = left.asCollection();
        Collection<? extends Object> rightElements = right.asCollection();
        int leftSize = leftElements.size();
        int rightSize = rightElements.size();
    	if ((leftSize == 0) || (rightSize == 0)) {
            return valueFactory.createSetValue(type);
        }    	
        Set<Object> results;
        // loop over the smaller collection and add only elements
        // that are in the larger collection
        if (leftSize <= rightSize) {
            results = new HashSet<Object>(leftElements);
        	results.retainAll(rightElements);
        }
        else {
            results = new HashSet<Object>(rightElements);
        	results.retainAll(leftElements);
        }
    	return results.size() > 0 ? valueFactory.createSetValue(type, results) : valueFactory.createSetValue(type);
    }

	public static @NonNull SetValue union(@NonNull ValueFactory valueFactory, @NonNull DomainCollectionType type, @NonNull CollectionValue left, @NonNull CollectionValue right) throws InvalidValueException {
    	assert !left.isUndefined() && !right.isUndefined();
		Collection<? extends Object> leftElements = left.asCollection();
        Collection<? extends Object> rightElements = right.asCollection();
    	if (leftElements.isEmpty()) {
            return right.asSetValue();
        }
    	else if (rightElements.isEmpty()) {
            return left.asSetValue();
        }    	
    	else {
			Set<Object> result = new HashSet<Object>(leftElements);
			result.addAll(rightElements);
    		return new SetValueImpl(valueFactory, type, result);
        } 
    }   
	
	public static class Accumulator extends SetValueImpl implements CollectionValue.Accumulator
	{
		public Accumulator(@NonNull ValueFactory valueFactory, @NonNull DomainCollectionType type) {
			super(valueFactory, type);
		}

		@SuppressWarnings("unchecked")
		public boolean add(@NonNull Object value) {
			return ((Collection<Object>)elements).add(value);			
		}		
	}
	
	public SetValueImpl(@NonNull ValueFactory valueFactory, @NonNull DomainCollectionType type, Object... elements) {
		super(valueFactory, type, createValue(elements));
	}

	public SetValueImpl(@NonNull ValueFactory valueFactory, @NonNull DomainCollectionType type, @NonNull Iterable<? extends Object> elements) {
		super(valueFactory, type, createValue(elements));
	}

//	public SetValue(CollectionValue c) {
//		this(c.asCollection());
//	}

	public SetValueImpl(@NonNull ValueFactory valueFactory, @NonNull DomainCollectionType type, @NonNull Set<? extends Object> elements) {
		super(valueFactory, type, elements);
	}

    @Override
	public @NonNull BagValue asBagValue() {
        return this;
    }

    @Override
	public @NonNull UniqueCollectionValue asUniqueCollectionValue() {
        return this;
	}

    @Override
	public @NonNull SetValue asSetValue() {
        return this;
    }

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof SetValueImpl)) {
			return false;
		}
		return elements.equals(((SetValueImpl)obj).elements);
	}

	public @NonNull SetValue excluding(@NonNull Object value) {
		Set<Object> result = new HashSet<Object>();
		for (Object element : elements) {
			if (!element.equals(value)) {
				result.add(element);
			}
		}
		if (result.size() < elements.size()) {
			return new SetValueImpl(valueFactory, getCollectionType(), result);
		}
		else {
			return this;
		}
	}

    public @NonNull SetValue flatten() throws InvalidValueException {
    	Set<Object> flattened = new HashSet<Object>();
    	if (flatten(flattened)) {
    		return new SetValueImpl(valueFactory, getCollectionType(), flattened);
    	}
    	else {
    		return this;
    	}
    }
	
	@Override
	protected @NonNull Set<? extends Object> getElements() {
		return (Set<? extends Object>) elements;
	}

	public @NonNull String getKind() {
	    return "Set";
	}

	public @NonNull SetValue including(@NonNull Object value) throws InvalidValueException {
		if (value instanceof InvalidValue) {
			valueFactory.throwInvalidValueException(EvaluatorMessages.InvalidSource, "including");
		}
		Set<Object> result = new HashSet<Object>(elements);
		result.add(value);
		return new SetValueImpl(valueFactory, getCollectionType(), result);
	}

    public @NonNull SetValue minus(@NonNull UniqueCollectionValue set) throws InvalidValueException {
    	Set<Object> result = new HashSet<Object>(elements);
        result.removeAll(set.asCollection());
        return new SetValueImpl(valueFactory, getCollectionType(), result);
    }
    
    public @NonNull OrderedSetValue sort(@NonNull Comparator<Object> comparator) {
    	List<Object> values = new ArrayList<Object>(elements);
    	Collections.sort(values, comparator);
    	return valueFactory.createOrderedSetValue(getOrderedSetType(), values);
    }

    public @NonNull SetValue symmetricDifference(@NonNull UniqueCollectionValue set) {       
    	Set<Object> result = new HashSet<Object>(elements);       
        for (Object e : set.iterable()) {
            if (result.contains(e)) {
                result.remove(e);
            } else {
                result.add(e);
            }
        }        
        return new SetValueImpl(valueFactory, getCollectionType(), result);
    }
    
	public SequenceValue toSequenceValue() {
		return valueFactory.createOrderedSetValue(getOrderedSetType(), elements);
	}

	@Override
	public void toString(@NonNull StringBuilder s, int lengthLimit) {
		s.append("Set");
		super.toString(s, lengthLimit);
	}
}
