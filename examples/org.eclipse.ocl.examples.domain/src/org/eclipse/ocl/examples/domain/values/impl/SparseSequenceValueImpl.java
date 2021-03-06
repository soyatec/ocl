/**
 * <copyright>
 *
 * Copyright (c) 2010, 2013 E.D.Willink and others.
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
import org.eclipse.ocl.examples.domain.values.SequenceValue;

/**
 * @generated NOT
 */
public class SparseSequenceValueImpl extends SequenceValueImpl
{
	public static @NonNull List<Object> createSequenceOfEach(@NonNull Object[] boxedValues) {
		List<Object> result = new ArrayList<Object>();
		for (Object boxedValue : boxedValues) {
			result.add(boxedValue);
		}
		return result;
	}

	public static @NonNull List<?> createSequenceOfEach(@NonNull Collection<? extends Object> elements) {
		List<?> list = elements instanceof List<?> ? (List<?>)elements : new ArrayList<Object>(elements);
		return list;
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
			assert !(value instanceof InvalidValueException);
			add(value);
	        return this;
	    }
	}

	public SparseSequenceValueImpl(@NonNull CollectionTypeId typeId, @NonNull List<? extends Object> boxedValues) {
		super(typeId, boxedValues);
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
