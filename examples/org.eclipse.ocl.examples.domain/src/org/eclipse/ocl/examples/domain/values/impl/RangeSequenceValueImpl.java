/**
 * <copyright>
 *
 * Copyright (c) 2005,2011 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   E.D.Willink - split off from EvaluationVisitor
 *
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.ocl.examples.domain.values.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.ocl.examples.domain.elements.DomainCollectionType;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.values.IntegerRange;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.SequenceValue;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.domain.values.ValueFactory;

/**
 * @generated NOT
 */
public class RangeSequenceValueImpl extends SequenceValueImpl
{
	public RangeSequenceValueImpl(ValueFactory valueFactory, DomainCollectionType type, IntegerRange range) {
		super(valueFactory, type, range);
	}

	@Override
	public SequenceValue append(Value value) throws InvalidValueException {
		IntegerRange theElements = getElements();
		IntegerValue nextValue = theElements.getLast().add(valueFactory.getOne());
		if (value.equals(nextValue)) {
			IntegerRange range = valueFactory.createRange(theElements.getFirst(), nextValue);
			return new RangeSequenceValueImpl(valueFactory, getCollectionType(), range);
		}
		else {
			List<Value> elements = createElements();
			elements.add(value);
			return valueFactory.createSequenceValue(getCollectionType(), elements);
		}
	}

	@Override
	public IntegerValue count(Value value) throws InvalidValueException {
		IntegerValue integerValue = value.isIntegerValue();
		if ((integerValue != null) && !integerValue.isUndefined()) {
			if (elements.contains(integerValue)) {
				return valueFactory.getOne();
			}
		}
		return valueFactory.getZero();
	}

	protected List<Value> createElements() {
		List<Value> elements = new ArrayList<Value>(intSize());
		for (Value value : this) {
			elements.add(value);
		}
		return elements;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof RangeSequenceValueImpl) {
			RangeSequenceValueImpl that = (RangeSequenceValueImpl)obj;
			return this.elements.equals(that.elements);
		}
		else {
			return super.equals(obj);
		}
	}

	@Override
	public Value first() {
		return getElements().getFirst();
	}

	@Override
	public SequenceValue flatten() {
		return this;
	}

	@Override
	public IntegerRange getElements() {
		if (elements == null) {
			createElements();
		}
		return (IntegerRange) elements;
	}

	@Override
	public SequenceValue including(Value value) throws InvalidValueException {
		return append(value);
	}

	@Override
	public Value last() {
		return getElements().getLast();
	}

	@Override
	public SequenceValue prepend(Value value) throws InvalidValueException {
		IntegerRange theElements = getElements();
		IntegerValue previousValue = theElements.getFirst().subtract(valueFactory.getOne());
		if (value.equals(previousValue)) {
			IntegerRange range = valueFactory.createRange(previousValue, theElements.getLast());
			return new RangeSequenceValueImpl(valueFactory, getCollectionType(), range);
		}
		else {
			List<Value> elements = createElements();
			elements.add(0, value);
			return valueFactory.createSequenceValue(getCollectionType(), elements);
		}
	}

	@Override
	public Iterator<Value> toIteratorValue() throws InvalidValueException {
		return getElements().iterator();
	}

	@Override
	public void toString(StringBuilder s, int lengthLimit) {
		s.append("Sequence{");
		IntegerRange theElements = getElements();
		s.append(theElements.getFirst());
		s.append("..");
		s.append(theElements.getLast());
		s.append("}");
		s.toString();
	}
}