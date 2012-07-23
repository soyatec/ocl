/**
 * <copyright>
 *
 * Copyright (c) 2009,2011 E.D.Willink and others.
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
 * $Id: RejectIteration.java,v 1.5 2011/05/07 16:41:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.iterator;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainCollectionType;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.DomainIterationManager;
import org.eclipse.ocl.examples.domain.library.AbstractIteration;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.Value;

/**
 * RejectIteration realizes the Collection::reject() library iteration.
 */
public class RejectIteration extends AbstractIteration
{
	public static final @NonNull RejectIteration INSTANCE = new RejectIteration();

	public @NonNull CollectionValue.Accumulator createAccumulatorValue(@NonNull DomainEvaluator evaluator, @NonNull DomainType accumulatorType, @NonNull DomainType bodyType) {
		return evaluator.getValueFactory().createCollectionAccumulatorValue((DomainCollectionType) accumulatorType);
	}
	
	@Override
    protected @Nullable Value updateAccumulator(@NonNull DomainIterationManager iterationManager) {
		Value bodyVal = iterationManager.evaluateBody();		
		if (bodyVal.isUndefined()) {
			return iterationManager.throwInvalidEvaluation(EvaluatorMessages.UndefinedBody, "reject"); 	// Null body is invalid //$NON-NLS-1$
		}
		else if (bodyVal.isFalse()) {
			Value value = iterationManager.get();		
			((CollectionValue.Accumulator)iterationManager.getAccumulatorValue()).add(value);
		}
		return null;
	}
}
