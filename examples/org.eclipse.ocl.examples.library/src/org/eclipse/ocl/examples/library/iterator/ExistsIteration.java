/**
 * <copyright>
 *
 * Copyright (c) 2009, 2013 E.D.Willink and others.
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
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractIteration;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;

/**
 * ExistsIteration realises the Collection::exists() library iteration.
 */
public class ExistsIteration extends AbstractIteration
{
	public static final @NonNull ExistsIteration INSTANCE = new ExistsIteration();

	public static class ExistsResult 
	{
		private Exception exception = null;
		private boolean isNull = false;
		
		public Object get() throws InvalidValueException {
			if (isNull) {
				return null;
			}
			else if (exception instanceof InvalidValueException) {
				throw (InvalidValueException)exception;
			}
			else if (exception != null) {
				throw new InvalidValueException(exception);
			}
			return false;
		}
		
		public void setException(Exception exception) {
			this.exception = exception;
		}
		
		public void setIsNull() {
			this.isNull = true;
		}
	}

	public @NonNull Object createAccumulatorValue(@NonNull DomainEvaluator evaluator, @NonNull TypeId accumulatorTypeId, @NonNull TypeId bodyTypeId) {
		return new ExistsResult();
	}

	@Override
	protected @Nullable Object resolveTerminalValue(@NonNull DomainIterationManager iterationManager) {
		ExistsResult accumulatorValue = (ExistsResult) iterationManager.getAccumulatorValue();
		assert accumulatorValue != null;
		return accumulatorValue.get();
	}

	@Override
    protected @Nullable Object updateAccumulator(@NonNull DomainIterationManager iterationManager) {
		try {
			Object bodyVal = iterationManager.evaluateBody();
			if (bodyVal == null) {
				ExistsResult accumulatorValue = (ExistsResult) iterationManager.getAccumulatorValue();
				assert accumulatorValue != null;
				accumulatorValue.setIsNull();
				return CARRY_ON;						// Carry on for nothing found
			}
			else if (bodyVal == Boolean.FALSE) {
				return CARRY_ON;						// Carry on for nothing found
			}
			else if (bodyVal != Boolean.TRUE) {
				throw new InvalidValueException(EvaluatorMessages.NonBooleanBody, "exists"); 	// Non boolean body is invalid //$NON-NLS-1$
			}
			else {
				return true;							// Abort after a find
			}
		}
		catch (Exception e) {
			ExistsResult accumulatorValue = (ExistsResult) iterationManager.getAccumulatorValue();
			assert accumulatorValue != null;
			accumulatorValue.setException(e);
			return CARRY_ON;							// Carry on for nothing found
		}
	}
}
