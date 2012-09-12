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
package org.eclipse.ocl.examples.domain.library;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.DomainIterationManager;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.NullValue;
import org.eclipse.ocl.examples.domain.values.ValueFactory;

public abstract class AbstractIterationManager implements DomainIterationManager
{
	protected final @NonNull DomainEvaluator evaluator;

	public AbstractIterationManager(@NonNull DomainEvaluator evaluator) {
		this.evaluator = evaluator;
	}

	public @NonNull DomainIterationManager createNestedIterationManager(@NonNull CollectionValue value) {
		throw new UnsupportedOperationException();	// Only required for single iterator managers
	}

	public @NonNull Object get() {
		throw new UnsupportedOperationException();	// Only required for single iterator managers
	}

	public @NonNull ValueFactory getValueFactory() {
		return evaluator.getValueFactory();
	}

	public boolean isOuterIteration() {
		throw new UnsupportedOperationException();	// Only required for single iterator managers
	}

	public @NonNull NullValue throwInvalidEvaluation(InvalidValueException e) {
		return evaluator.throwInvalidEvaluation(e);
	}
}