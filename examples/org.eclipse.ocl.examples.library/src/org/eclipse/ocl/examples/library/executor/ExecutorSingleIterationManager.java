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
 * $Id: IterationManager.java,v 1.5 2011/05/07 16:41:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.executor;

import java.util.Iterator;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.DomainIterationManager;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractIterationManager;
import org.eclipse.ocl.examples.domain.library.LibraryBinaryOperation;
import org.eclipse.ocl.examples.domain.values.CollectionValue;

public class ExecutorSingleIterationManager extends AbstractIterationManager
{	
	protected final @NonNull TypeId returnTypeId;
	protected final @NonNull LibraryBinaryOperation body;
	protected final int depth;
	private @Nullable Object accumulatorValue;
	protected final @NonNull Iterator<? extends Object> iteratorValue;
	private Object currentValue;		// 'null' is a valid value so 'iteratorValue' is used as end of iteration
	
	@Deprecated
	public ExecutorSingleIterationManager(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, @NonNull LibraryBinaryOperation body,
			@NonNull CollectionValue collectionValue, @Nullable Object accumulatorValue) {
		this(evaluator, returnType.getTypeId(), body, collectionValue, accumulatorValue);
	}
	
	public ExecutorSingleIterationManager(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @NonNull LibraryBinaryOperation body,
			@NonNull CollectionValue collectionValue, @Nullable Object accumulatorValue) {
		super(evaluator);
		this.returnTypeId = returnTypeId;
		this.body = body;
		this.depth = 0;
		updateAccumulator(accumulatorValue);
		this.iteratorValue = collectionValue.iterator();
		advanceIterators();
	}

	protected ExecutorSingleIterationManager(@NonNull ExecutorSingleIterationManager iterationManager, @NonNull CollectionValue value) {
		super(iterationManager.getEvaluator());
		this.returnTypeId = iterationManager.returnTypeId;
		this.body = iterationManager.body;
		this.depth = iterationManager.depth + 1;
		this.accumulatorValue = iterationManager.accumulatorValue;
		this.iteratorValue = value.iterator();
		advanceIterators();
	}
	
	public boolean advanceIterators() {
		currentValue = iteratorValue.hasNext() ? iteratorValue.next() : iteratorValue;
		return currentValue != iteratorValue;
	}

	@Override
	public @NonNull DomainIterationManager createNestedIterationManager(@NonNull CollectionValue value) {
		return new ExecutorSingleIterationManager(this, value);
	}

	public @Nullable Object evaluateBody() throws Exception {
		return body.evaluate(evaluator, returnTypeId, accumulatorValue, get());
	}

	@Override
	public @Nullable Object get() {
		return currentValue;
	}

	public @Nullable Object getAccumulatorValue() {
		return accumulatorValue;
	}
	
	public boolean hasCurrent() {
		return currentValue != iteratorValue;
	}

	@Override
	public boolean isOuterIteration() {
		return depth == 0;
	}

	public @Nullable Object updateAccumulator(Object newValue) {
		this.accumulatorValue = newValue;
		return null;					// carry on
	}
}