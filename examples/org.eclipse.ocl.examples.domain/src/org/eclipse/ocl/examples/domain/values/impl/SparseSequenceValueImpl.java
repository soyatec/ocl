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
 * $Id: SequenceValueImpl.java,v 1.4 2011/02/21 08:37:52 ewillink Exp $
 */
package org.eclipse.ocl.examples.domain.values.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.InvalidValue;
import org.eclipse.ocl.examples.domain.values.SequenceValue;

/**
 * @generated NOT
 */
public class SparseSequenceValueImpl extends SequenceValueImpl
{
	private static @NonNull List<Object> createValues(Object... values) {
		List<Object> result = new ArrayList<Object>();
		for (Object value : values) {
			result.add(value);
		}
		return result;
	}

	private static @NonNull List<Object> createValues(@NonNull Iterable<? extends Object> values) {
		List<Object> result = new ArrayList<Object>();
		for (Object value : values) {
			result.add(value);
		}
		return result;
	}

	public static @NonNull SequenceValue union(@NonNull CollectionTypeId typeId, @NonNull CollectionValue left, @NonNull CollectionValue right) {
    	assert !left.isUndefined() && !right.isUndefined();
		Collection<? extends Object> leftElements = left.asCollection();
        Collection<? extends Object> rightElements = right.asCollection();
    	if (leftElements.isEmpty()) {
            return right.asSequenceValue();
        }
    	else if (rightElements.isEmpty()) {
            return left.asSequenceValue();
        }    	
    	else {
    		List<Object> result = new ArrayList<Object>(leftElements);
			result.addAll(rightElements);
    		return new SparseSequenceValueImpl(typeId, result);
        } 
    }
	
	public static class Accumulator extends SparseSequenceValueImpl implements SequenceValue.Accumulator
	{
		public Accumulator(@NonNull CollectionTypeId typeId) {
			super(typeId, new ArrayList<Object>());
		}

		public Accumulator(@NonNull CollectionTypeId typeId, @NonNull List<? extends Object> values) {
			super(typeId, values);
		}

		@SuppressWarnings("unchecked")
		public boolean add(@Nullable Object value) {
			return ((Collection<Object>)elements).add(value);			
		}		

	    @Override
		public @NonNull SequenceValue append(@Nullable Object value) {
			assert !(value instanceof InvalidValue);
			add(value);
	        return this;
	    }
	}
    
	public SparseSequenceValueImpl(@NonNull CollectionTypeId typeId, Object... values) {
		super(typeId, createValues(values));
	}

	public SparseSequenceValueImpl(@NonNull CollectionTypeId typeId, @NonNull Iterable<? extends Object> values) {
		super(typeId, createValues(values));
	}

	public SparseSequenceValueImpl(@NonNull CollectionTypeId typeId, @NonNull List<? extends Object> values) {
		super(typeId, values);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof SparseSequenceValueImpl) {
			return elements.equals(((SparseSequenceValueImpl)obj).elements);
		}
		else {
			return super.equals(obj);
		}
	}
}
