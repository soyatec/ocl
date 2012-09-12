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
 * $Id: ForAllIteration.java,v 1.4 2011/05/07 16:41:47 ewillink Exp $
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

/**
 * ForAllIteration realizes the Collection::forAll() library iteration.
 */
public class ForAllIteration extends AbstractIteration
{
	public static final @NonNull ForAllIteration INSTANCE = new ForAllIteration();

	public @NonNull BooleanValue.Accumulator createAccumulatorValue(@NonNull DomainEvaluator evaluator, @NonNull DomainType accumulatorType, @NonNull DomainType bodyType) {
		return evaluator.getValueFactory().createBooleanAccumulatorValue();
	}
	
	@Override
	protected @NonNull Object resolveTerminalValue(@NonNull DomainIterationManager iterationManager) {
		return iterationManager.getValueFactory().getTrue();
	}

	@Override
    protected @Nullable Object updateAccumulator(@NonNull DomainIterationManager iterationManager) {
		Object bodyVal = iterationManager.evaluateBody();		
		if (isUndefined(bodyVal)) {
			return iterationManager.throwInvalidEvaluation(EvaluatorMessages.UndefinedBody, "forAll"); 	// Null body is invalid //$NON-NLS-1$
		}
		else if (isTrue(bodyVal)) {
			return null;							// Carry on for nothing found
		}
		else {
			return iterationManager.getValueFactory().getFalse();			// Abort after a fail
		}
	}
}
