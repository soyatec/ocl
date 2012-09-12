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
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainCollectionType;
import org.eclipse.ocl.examples.domain.elements.DomainTupleType;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.library.LibraryBinaryOperation;

public interface CollectionValue extends Value
{
	/**
	 * @generated NOT
	 */
	interface Accumulator extends CollectionValue {
		boolean add(@NonNull Object value);	
	}

	/**
	 * @generated NOT
	 */
	@NonNull Collection<? extends Object> asCollection() throws InvalidValueException;	

	/**
	 * @generated NOT
	 */
	//@NonNull List<Object> asList() throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	@NonNull IntegerValue count(@NonNull Object value) throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	@NonNull BooleanValue excludes(@NonNull Object value) throws InvalidValueException;	

	/**
	 * @generated NOT
	 */
	@NonNull BooleanValue excludesAll(@NonNull CollectionValue c) throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	@NonNull CollectionValue excluding(@NonNull Object value) throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	@NonNull CollectionValue flatten() throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	boolean flatten(@NonNull Collection<Object> flattenedElements) throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	@NonNull DomainCollectionType getCollectionType();

	/**
	 * @generated NOT
	 */
	String getKind();

	/**
	 * @generated NOT
	 */
	@NonNull BooleanValue includes(@NonNull Object value) throws InvalidValueException;	

	/**
	 * @generated NOT
	 */
	@NonNull BooleanValue includesAll(@NonNull CollectionValue c) throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	@NonNull CollectionValue including(@NonNull Object value) throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	int intSize();

	/**
	 * @generated NOT
	 */
	@NonNull CollectionValue intersection(@NonNull CollectionValue c) throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	@NonNull BooleanValue isEmpty() throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	@NonNull Iterable<? extends Object> iterable();

	/**
	 * @generated NOT
	 */
	@NonNull Iterator<? extends Object> iterator();

	/**
	 * @generated NOT
	 */
	@NonNull Object maxMin(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, @NonNull LibraryBinaryOperation binaryOperation) throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	@NonNull BooleanValue notEmpty() throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	@Nullable Set<TupleValue> product(@NonNull CollectionValue c, @NonNull DomainTupleType tupleType) throws InvalidValueException;   	

	/**
	 * @generated NOT
	 */
	@NonNull CollectionValue selectByKind(@NonNull DomainType typeValue) throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	@NonNull CollectionValue selectByType(@NonNull DomainType typeValue) throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	@NonNull IntegerValue size() throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	@NonNull SequenceValue sort(@NonNull Comparator<Object> comparator) throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	@NonNull Object sum(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, @NonNull LibraryBinaryOperation binaryOperation, @NonNull Object zero) throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	@Nullable SequenceValue toSequenceValue() throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	@NonNull CollectionValue union(@NonNull CollectionValue c) throws InvalidValueException;
}
