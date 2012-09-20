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
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractIterationManager;
import org.eclipse.ocl.examples.domain.library.LibraryBinaryOperation;
import org.eclipse.ocl.examples.domain.values.CollectionValue;

public class ExecutorSingleIterationManager extends AbstractIterationManager
{	
	protected final @NonNull TypeId returnTypeId;
	protected final @NonNull LibraryBinaryOperation body;
	private @NonNull Object accumulatorValue;
	protected final @NonNull Iterator<? extends Object> iteratorValue;
	private Object currentValue;
	
	@Deprecated
	public ExecutorSingleIterationManager(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, @NonNull LibraryBinaryOperation body,
			@NonNull CollectionValue collectionValue, @NonNull Object accumulatorValue) {
		this(evaluator, returnType.getTypeId(), body, collectionValue, accumulatorValue);
	}
	
	public ExecutorSingleIterationManager(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @NonNull LibraryBinaryOperation body,
			@NonNull CollectionValue collectionValue, @NonNull Object accumulatorValue) {
		super(evaluator);
		this.returnTypeId = returnTypeId;
		this.body = body;
		this.accumulatorValue = accumulatorValue;
		this.iteratorValue = collectionValue.iterator();
		advanceIterators();
	}
	
	public boolean advanceIterators() {
		currentValue = iteratorValue.hasNext() ? iteratorValue.next() : null;
		return currentValue != null;
	}

	@Override
	public @NonNull Object get() {
		Object currentValue2 = currentValue;
		if (currentValue2 == null) {
			throw new IllegalStateException("cannot get() after iteration complete"); //$NON-NLS-1$
		}
		return currentValue2;
	}

	public @NonNull Object getAccumulatorValue() {
		return accumulatorValue;
	}

	public @NonNull Object evaluateBody() {
//		try {
			return body.evaluate(evaluator, returnTypeId, accumulatorValue, get());
//		} catch (InvalidValueException e) {
//			return throwInvalidEvaluation(e);
//		}
	}
	
	public boolean hasCurrent() {
		return currentValue != null;
	}

//	public NullValue throwInvalidEvaluation(String message, Object... bindings) {
//		String boundMessage = NLS.bind(message, bindings);
//		throw new InvalidEvaluationException(null, boundMessage, null, null, null);
//	}

	public @Nullable Object updateBody() {
		@NonNull Object newValue = body.evaluate(evaluator, returnTypeId, accumulatorValue, get());
		this.accumulatorValue = newValue;
		return null;					// carry on
	}
}