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
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.DomainIterationManager;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractIteration;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;

/**
 * ExistsIteration realises the Collection::exists() library iteration.
 */
public class ExistsIteration extends AbstractIteration
{
	public static final @NonNull ExistsIteration INSTANCE = new ExistsIteration();

	public @NonNull Object createAccumulatorValue(@NonNull DomainEvaluator evaluator, @NonNull TypeId accumulatorTypeId, @NonNull TypeId bodyTypeId) {
		return false;
	}
	
	@Override
    protected @Nullable Object updateAccumulator(@NonNull DomainIterationManager iterationManager) throws Exception {
		Object bodyVal = iterationManager.evaluateBody();
		if (isNull(bodyVal)) {
			throw new InvalidValueException(EvaluatorMessages.UndefinedBody, "exists"); 	// Null body is invalid //$NON-NLS-1$
		}
		else if (isFalse(bodyVal)) {
			return null;							// Carry on for nothing found
		}
		else {
			return true;		// Abort after a find
		}
	}
}
