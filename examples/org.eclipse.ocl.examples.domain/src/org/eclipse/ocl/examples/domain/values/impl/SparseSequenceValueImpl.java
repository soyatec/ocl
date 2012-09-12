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
import org.eclipse.ocl.examples.domain.elements.DomainCollectionType;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.InvalidValue;
import org.eclipse.ocl.examples.domain.values.SequenceValue;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.domain.values.ValueFactory;

/**
 * @generated NOT
 */
public class SparseSequenceValueImpl extends SequenceValueImpl
{
	private static @NonNull List<Object> createValue(Object... elements) {
		List<Object> result = new ArrayList<Object>();
		for (Object element : elements) {
			result.add(element);
		}
		return result;
	}

	private static @NonNull List<Object> createValue(@NonNull Iterable<? extends Object> elements) {
		List<Object> result = new ArrayList<Object>();
		for (Object element : elements) {
			result.add(element);
		}
		return result;
	}

	public static @NonNull SequenceValue union(@NonNull ValueFactory valueFactory, @NonNull DomainCollectionType type, @NonNull CollectionValue left, @NonNull CollectionValue right) throws InvalidValueException {
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
    		return new SparseSequenceValueImpl(valueFactory, type, result);
        } 
    }
	
	public static class Accumulator extends SparseSequenceValueImpl implements SequenceValue.Accumulator
	{
		public Accumulator(@NonNull ValueFactory valueFactory, @NonNull DomainCollectionType type) {
			super(valueFactory, type);
		}

		public Accumulator(@NonNull ValueFactory valueFactory, @NonNull DomainCollectionType type, @NonNull List<Value> elements) {
			super(valueFactory, type, elements);
		}

		@SuppressWarnings("unchecked")
		public boolean add(@NonNull Object value) {
			return ((Collection<Object>)elements).add(value);			
		}		

	    @Override
		public @NonNull SequenceValue append(@NonNull Object object) throws InvalidValueException {
			if (object instanceof InvalidValue) {
	        	valueFactory.throwInvalidValueException(EvaluatorMessages.InvalidSource, "append");
			}
			add(object);
	        return this;
	    }
	}
    
	public SparseSequenceValueImpl(@NonNull ValueFactory valueFactory, @NonNull DomainCollectionType type, Object... elements) {
		super(valueFactory, type, createValue(elements));
	}

	public SparseSequenceValueImpl(@NonNull ValueFactory valueFactory, @NonNull DomainCollectionType type, @NonNull Iterable<? extends Object> elements) {
		super(valueFactory, type, createValue(elements));
	}

	public SparseSequenceValueImpl(@NonNull ValueFactory valueFactory, @NonNull DomainCollectionType type, @NonNull List<Object> elements) {
		super(valueFactory, type, elements);
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
