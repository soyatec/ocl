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
 * $Id$
 */
package org.eclipse.ocl.examples.library.executor;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainExpression;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.elements.DomainTypedElement;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluationEnvironment;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.Value;

public abstract class ExecutorManager implements DomainEvaluator
{	
	protected final @NonNull DomainStandardLibrary standardLibrary;

    /**
     * Set true by {@link #setCanceled} to terminate execution at next call to {@link #getValuefactory()}.
     */
	private boolean isCanceled = false;

	
	public ExecutorManager(@NonNull DomainStandardLibrary standardLibrary) {
		this.standardLibrary = standardLibrary;
	}

	public @NonNull Value evaluate(@NonNull DomainExpression body) {
		throw new UnsupportedOperationException();
//		try {
//			return ((LibraryUnaryOperation)body).evaluate(this, null, null);		// WIP
//		} catch (InvalidValueException e) {
//			return throwInvalidEvaluation(e);
//		}
	}

	public Value evaluateIteration(DomainType returnType, CollectionValue sourceVal, DomainTypedElement accumulator,
			DomainExpression body, DomainTypedElement[] iterators) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	public @NonNull DomainType getDynamicTypeOf(@Nullable Object value) {
		return getIdResolver().getDynamicTypeOf(value);
	}

	public @NonNull DomainEvaluationEnvironment getEvaluationEnvironment() {
		throw new UnsupportedOperationException();
	}

//	public @NonNull IdResolver getIdResolver() {
//		return standardLibrary.getIdResolver();
//	}

	public @NonNull DomainStandardLibrary getStandardLibrary() {
		return standardLibrary;
	}

	public @NonNull DomainType getStaticTypeOf(@Nullable Object value) {
		return getIdResolver().getStaticTypeOf(value);
	}

	public @NonNull DomainType getStaticTypeOf(@Nullable Object value, @NonNull Object... values) {
		return getIdResolver().getStaticTypeOf(value, values);
	}

	public @NonNull DomainType getStaticTypeOf(@Nullable Object value, @NonNull Iterable<?> values) {
		return getIdResolver().getStaticTypeOf(value, values);
	}

//	public @NonNull ValueFactory getValueFactory() {
//		if (isCanceled) {
//			throw new EvaluationHaltedException("Canceled"); //$NON-NLS-1$
//		}
//		return valueFactory;
//	}

	public boolean isCanceled() {
		return isCanceled;
	}

	public void setCanceled(boolean isCanceled) {
		this.isCanceled = isCanceled;
	}
	
/*	public DomainType typeOf(Value value, Value... values) {
		DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
		DomainType type = value.getType(standardLibrary);
		for (Value anotherValue : values) {
			DomainType anotherType = anotherValue.getType(standardLibrary);
			type = type.getCommonType(standardLibrary, anotherType);
		}
		return type;
	} */

//	public @NonNull NullValue throwInvalidEvaluation(InvalidValueException e) {
//		throw new InvalidEvaluationException(null, e);
//	}

//	public @NonNull NullValue throwInvalidEvaluation(Throwable e, DomainExpression expression, Object context,
//			String message, Object... bindings) {
//		throw new InvalidEvaluationException(null, NLS.bind(message, bindings), e, expression, context);
//	}
}
