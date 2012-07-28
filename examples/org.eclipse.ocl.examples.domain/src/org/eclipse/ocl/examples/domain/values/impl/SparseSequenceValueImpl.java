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
import org.eclipse.ocl.examples.domain.values.SequenceValue;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.domain.values.ValueFactory;

/**
 * @generated NOT
 */
public class SparseSequenceValueImpl extends SequenceValueImpl
{
	private static @NonNull List<Value> createValue(@NonNull Iterable<? extends Value> elements) {
		List<Value> result = new ArrayList<Value>();
		for (Value element : elements) {
			result.add(element);
		}
		return result;
	}

	public static @NonNull SequenceValue union(@NonNull ValueFactory valueFactory, @NonNull DomainCollectionType type, @NonNull CollectionValue left, @NonNull CollectionValue right) throws InvalidValueException {
    	assert !left.isUndefined() && !right.isUndefined();
		Collection<Value> leftElements = left.asCollection();
        Collection<Value> rightElements = right.asCollection();
    	if (leftElements.isEmpty()) {
            return right.asSequenceValue();
        }
    	else if (rightElements.isEmpty()) {
            return left.asSequenceValue();
        }    	
    	else {
    		List<Value> result = new ArrayList<Value>(leftElements);
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

		public boolean add(@NonNull Value value) {
			return elements.add(value);			
		}		

	    @Override
		public @NonNull SequenceValue append(@NonNull Value object) throws InvalidValueException {
			if (object.isInvalid()) {
	        	valueFactory.throwInvalidValueException(EvaluatorMessages.InvalidSource, "append");
			}
			elements.add(object);
	        return this;
	    }
	}
    
	public SparseSequenceValueImpl(@NonNull ValueFactory valueFactory, @NonNull DomainCollectionType type, Value... elements) {
		super(valueFactory, type, new ArrayList<Value>());
		if (elements != null) {
			for (Value element : elements) {
				this.elements.add(element);
			}
		}
	}

	public SparseSequenceValueImpl(@NonNull ValueFactory valueFactory, @NonNull DomainCollectionType type, @NonNull Iterable<? extends Value> elements) {
		super(valueFactory, type, createValue(elements));
	}

	public SparseSequenceValueImpl(@NonNull ValueFactory valueFactory, @NonNull DomainCollectionType type, @NonNull List<Value> elements) {
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
