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
 * $Id: OneIteration.java,v 1.4 2011/05/07 16:41:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.iterator;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.DomainIterationManager;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractIteration;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;

/**
 * OneIteration realizes the Collection::one() library iteration.
 */
public class OneIteration extends AbstractIteration
{
	public static class MutableBoolean 
	{
		private boolean value = false;
		
		public boolean isSet() {
			return value;
		}
		
		public void set() {
			this.value = true;
		}
	}

	public static final @NonNull OneIteration INSTANCE = new OneIteration();

	public @NonNull MutableBoolean createAccumulatorValue(@NonNull DomainEvaluator evaluator, @NonNull TypeId accumulatorTypeId, @NonNull TypeId bodyTypeId) {
		return new MutableBoolean();
	}

	@Override
	protected @NonNull
	Object resolveTerminalValue(@NonNull DomainIterationManager iterationManager) {
		MutableBoolean accumulatorValue = (MutableBoolean) iterationManager.getAccumulatorValue();
		return accumulatorValue.isSet() != false;			// FIXME redundant test to suppress warning
	}

	@Override
    protected @Nullable Object updateAccumulator(@NonNull DomainIterationManager iterationManager) {
		Object bodyVal = iterationManager.evaluateBody();		
		if (isUndefined(bodyVal)) {
			return createInvalidValue(EvaluatorMessages.UndefinedBody, "one"); 	// Null body is invalid //$NON-NLS-1$
		}
		else if (isFalse(bodyVal)) {
			return null;									// Carry on for nothing found
		}
		else {
			MutableBoolean accumulatorValue = (MutableBoolean) iterationManager.getAccumulatorValue();
			if (accumulatorValue.isSet()) {
				return Boolean.FALSE;				// Abort after second find
			}
			else {
				accumulatorValue.set();
				return null;									// Carry on after first find
			}
		}
	}
}
