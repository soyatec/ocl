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
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractIterationManager;
import org.eclipse.ocl.examples.domain.library.LibraryTernaryOperation;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.CollectionValue;

public class ExecutorDoubleIterationManager extends AbstractIterationManager
{	
	protected final @NonNull TypeId returnTypeId;
	protected final @NonNull LibraryTernaryOperation body;
	private @NonNull Object accumulatorValue;
	protected final @NonNull CollectionValue collectionValue;
	private @NonNull Iterator<? extends Object> iteratorValue1;
	private final @NonNull Iterator<? extends Object> iteratorValue2;
	private Object currentValue1;
	private Object currentValue2;
	
	public ExecutorDoubleIterationManager(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @NonNull LibraryTernaryOperation body,
			@NonNull CollectionValue collectionValue, @NonNull Object accumulatorValue) {
		super(evaluator);
		this.returnTypeId = returnTypeId;
		this.body = body;
		this.accumulatorValue = accumulatorValue;
		this.collectionValue = collectionValue;
		this.iteratorValue1 = collectionValue.iterator();
		this.iteratorValue2 = collectionValue.iterator();
		currentValue1 = iteratorValue1.hasNext() ? iteratorValue1.next() : null;
		currentValue2 = iteratorValue2.hasNext() ? iteratorValue2.next() : null;
	}
	
	public boolean advanceIterators() {
		if (iteratorValue1.hasNext()) {
			currentValue1 = iteratorValue1.next();
		}
		else if (iteratorValue2.hasNext()) {
			currentValue2 = iteratorValue2.next();
			iteratorValue1 = collectionValue.iterator();
			currentValue1 = iteratorValue1.hasNext() ? iteratorValue1.next() : null;
		}
		else {
			currentValue1 = null;
			currentValue2 = null;
		}
		return currentValue1 != null;
	}

	public @NonNull Object evaluateBody() {
//		try {
			return internalEvaluate();
//		} catch (InvalidValueException e) {
//			return throwInvalidEvaluation(e);
//		}
	}

	public @NonNull Object getAccumulatorValue() {
		return accumulatorValue;
	}
	
	public boolean hasCurrent() {
		return currentValue1 != null;
	}

	private @NonNull Object internalEvaluate() {
		return body.evaluate(evaluator, returnTypeId, accumulatorValue,
			DomainUtil.nonNullState(currentValue1), DomainUtil.nonNullState(currentValue2));
	}

//	public NullValue throwInvalidEvaluation(String message, Object... bindings) {
//		String boundMessage = NLS.bind(message, bindings);
//		throw new InvalidEvaluationException(null, boundMessage, null, null, null);
//	}

	public @Nullable Object updateBody() {
		this.accumulatorValue = internalEvaluate();
		return null;					// carry on
	}
}