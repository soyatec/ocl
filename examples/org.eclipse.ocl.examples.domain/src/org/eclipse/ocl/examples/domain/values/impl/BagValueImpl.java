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
 * $Id: BagValueImpl.java,v 1.5 2011/05/07 16:41:20 ewillink Exp $
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
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.values.Bag;
import org.eclipse.ocl.examples.domain.values.BagValue;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.InvalidValue;
import org.eclipse.ocl.examples.domain.values.SequenceValue;
import org.eclipse.ocl.examples.domain.values.SetValue;
import org.eclipse.ocl.examples.domain.values.ValuesPackage;

/**
 * @generated NOT
 */
public class BagValueImpl extends CollectionValueImpl implements BagValue
{   
	public static final @NonNull Bag<Object> EMPTY_BAG = new BagImpl<Object>();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ValuesPackage.Literals.BAG_VALUE;
	}

	private static @NonNull Bag<Object> createValues(Object... values) {
		Bag<Object> result = new BagImpl<Object>();
		for (Object value : values) {
			result.add(value);
		}
		return result;
	}

	private static @NonNull Bag<Object> createValues(@NonNull Iterable<? extends Object> values) {
		Bag<Object> result = new BagImpl<Object>();
		for (Object value : values) {
			result.add(value);
		}
		return result;
	}

	public static @NonNull BagValue intersection(@NonNull CollectionTypeId typeId, @NonNull CollectionValue left, @NonNull CollectionValue right)
    {
    	assert !left.isUndefined() && !right.isUndefined();
		Collection<? extends Object> leftElements = left.asCollection();
        Collection<? extends Object> rightElements = right.asCollection();
        int leftSize = leftElements.size();
        int rightSize = rightElements.size();
    	if ((leftSize == 0) || (rightSize == 0)) {
            return new BagValueImpl(typeId, EMPTY_BAG);
        }    	
        Bag<Object> results = new BagImpl<Object>();
        // loop over the smaller collection and add only elements
        // that are in the larger collection
        Set<Object> minElements = new HashSet<Object>(leftSize < rightSize ? leftElements : rightElements);
        for (Object e : minElements) {
        	if (e != null) {
        		IntegerValue leftCount = left.count(e);
            	IntegerValue rightCount = right.count(e);
            	for (int i = Math.min(leftCount.asInteger(), rightCount.asInteger()); i > 0; i--) {
            		results.add(e);
            	}
        	}
        }
    	return results.size() > 0 ? new BagValueImpl(typeId, results) : new BagValueImpl(typeId, EMPTY_BAG);
    }

    public static @NonNull BagValue union(@NonNull CollectionTypeId typeId, @NonNull CollectionValue left, @NonNull CollectionValue right) {
    	assert !left.isUndefined() && !right.isUndefined();
		Collection<? extends Object> leftElements = left.asCollection();
        Collection<? extends Object> rightElements = right.asCollection();
    	if (leftElements.isEmpty()) {
            return right.asBagValue();
        }
    	else if (rightElements.isEmpty()) {
            return left.asBagValue();
        }    	
    	else {
			Bag<Object> result = new BagImpl<Object>(leftElements);
			result.addAll(rightElements);
    		return new BagValueImpl(typeId, result);
        } 
    }
	
	public static class Accumulator extends BagValueImpl implements CollectionValue.Accumulator
	{
		public Accumulator(@NonNull CollectionTypeId typeId) {
			super(typeId, new BagImpl<Object>());
		}

		@SuppressWarnings("unchecked")
		public boolean add(@NonNull Object value) {
			return ((Collection<Object>)elements).add(value);			
		}		
	}
	
	public BagValueImpl(@NonNull CollectionTypeId typeId, Object... values) {
		super(typeId, createValues(values));
	}

	public BagValueImpl(@NonNull CollectionTypeId typeId, @NonNull Iterable<? extends Object> values) {
		super(typeId, createValues(values));
	}

	public BagValueImpl(@NonNull CollectionTypeId typeId, @NonNull Bag<? extends Object> values) {
		super(typeId, values);
	}

    @Override
	public @NonNull BagValue asBagValue() {
        return this;
    }

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof BagValueImpl) || (obj instanceof SetValue)) {
			return false;
		}
		return elements.equals(((BagValueImpl)obj).elements);
	}

	public @NonNull BagValue excluding(@NonNull Object value) {
		Bag<Object> result = new BagImpl<Object>();
		for (Object element : elements) {
			if (!element.equals(value)) {
				result.add(element);
			}
		}
		if (result.size() < elements.size()) {
			return new BagValueImpl(getTypeId(), result);
		}
		else {
			return this;
		}
	}

    public @NonNull BagValue flatten() {
    	Bag<Object> flattened = new BagImpl<Object>();
    	if (flatten(flattened)) {
    		return new BagValueImpl(getTypeId(), flattened);
    	}
    	else {
    		return this;
    	}
    }

//    @Override
//	public @NonNull CollectionTypeId getCollectionTypeId() {
//		return TypeId.BAG;
//	}
    
	@Override
	protected @NonNull Bag<? extends Object> getElements() {
		return (Bag<? extends Object>) elements;
	}

	public @NonNull String getKind() {
	    return "Bag";
	}

	public @NonNull BagValue including(@NonNull Object value) {
		assert !(value instanceof InvalidValue);
		Bag<Object> result = new BagImpl<Object>(elements);
		result.add(value);
		return new BagValueImpl(getTypeId(), result);
	}

	public boolean isOrdered() {
		return false;
	}

	public boolean isUnique() {
		return false;
	}
	   
    public @NonNull SequenceValue sort(@NonNull Comparator<Object> comparator) {
    	List<Object> values = new ArrayList<Object>(elements);
    	Collections.sort(values, comparator);
    	return new SparseSequenceValueImpl(getSequenceTypeId(), values);
    }
    
	public @NonNull SequenceValue toSequenceValue() {
		return new SparseSequenceValueImpl(getSequenceTypeId(), elements);
	}

	@Override
	public void toString(@NonNull StringBuilder s, int lengthLimit) {
		s.append("Bag");
		super.toString(s, lengthLimit);
	}
}
