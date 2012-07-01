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
 * $Id: CollectionValue.java,v 1.6 2011/04/25 09:49:15 ewillink Exp $
 */
package org.eclipse.ocl.examples.domain.values;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.ocl.examples.domain.elements.DomainCollectionType;
import org.eclipse.ocl.examples.domain.elements.DomainTupleType;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.library.LibraryBinaryOperation;

public interface CollectionValue extends Value, Iterable<Value>
{
	/**
	 * @generated NOT
	 */
	interface Accumulator extends CollectionValue {
		boolean add(Value value);	
	}

	/**
	 * @generated NOT
	 */
	Collection<Value> asCollection();	

	/**
	 * @generated NOT
	 */
	List<Value> asList();

	/**
	 * @generated NOT
	 */
    IntegerValue count(Value value) throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	BooleanValue excludes(Value value) throws InvalidValueException;	

	/**
	 * @generated NOT
	 */
	BooleanValue excludesAll(CollectionValue c) throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	CollectionValue excluding(Value value) throws InvalidValueException;

	/**
	 * @generated NOT
	 */
    CollectionValue flatten() throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	boolean flatten(Collection<Value> flattenedElements) throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	DomainCollectionType getCollectionType();

	/**
	 * @generated NOT
	 */
	String getKind();

	/**
	 * @generated NOT
	 */
    BooleanValue includes(Value value) throws InvalidValueException;	

	/**
	 * @generated NOT
	 */
    BooleanValue includesAll(CollectionValue c) throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	CollectionValue including(Value value) throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	int intSize();

	/**
	 * @generated NOT
	 */
	CollectionValue intersection(CollectionValue c) throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	BooleanValue isEmpty() throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	Iterator<Value> iterator();

	/**
	 * @generated NOT
	 */
	Value maxMin(DomainEvaluator evaluator, DomainType returnType, LibraryBinaryOperation binaryOperation) throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	BooleanValue notEmpty() throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	Set<TupleValue> product(CollectionValue c, DomainTupleType tupleType) throws InvalidValueException;   	

	/**
	 * @generated NOT
	 */
	CollectionValue selectByKind(DomainType typeValue) throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	CollectionValue selectByType(DomainType typeValue) throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	IntegerValue size() throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	SequenceValue sort(Comparator<Value> comparator) throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	Value sum(DomainEvaluator evaluator, DomainType returnType, LibraryBinaryOperation binaryOperation, Value zero) throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	SequenceValue toSequenceValue() throws InvalidValueException;

	/**
	 * @generated NOT
	 */
    CollectionValue union(CollectionValue c) throws InvalidValueException;
}
