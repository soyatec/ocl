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
 * $Id: ExistsIteration.java,v 1.4 2011/05/07 16:41:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.iterator;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.DomainIterationManager;
import org.eclipse.ocl.examples.domain.library.AbstractIteration;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.values.BooleanValue;
import org.eclipse.ocl.examples.domain.values.Value;

/**
 * ExistsIteration realises the Collection::exists() library iteration.
 */
public class ExistsIteration extends AbstractIteration
{
	public static final @NonNull ExistsIteration INSTANCE = new ExistsIteration();

	public @NonNull BooleanValue.Accumulator createAccumulatorValue(@NonNull DomainEvaluator evaluator, @NonNull DomainType accumulatorType, @NonNull DomainType bodyType) {
		return evaluator.getValueFactory().createBooleanAccumulatorValue();
	}

	@Override
	protected @NonNull Value resolveTerminalValue(@NonNull DomainIterationManager iterationManager) {
		return iterationManager.getValueFactory().getFalse();
	}
	
	@Override
    protected @Nullable Value updateAccumulator(@NonNull DomainIterationManager iterationManager) {
		Value bodyVal = iterationManager.evaluateBody();
		if (bodyVal.isUndefined()) {
			return iterationManager.throwInvalidEvaluation(EvaluatorMessages.UndefinedBody, "exists"); 	// Null body is invalid //$NON-NLS-1$
		}
		else if (bodyVal.isFalse()) {
			return null;							// Carry on for nothing found
		}
		else {
			return iterationManager.getValueFactory().getTrue();		// Abort after a find
		}
	}
}
