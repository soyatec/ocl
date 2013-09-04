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
 * $Id: ForAllIteration.java,v 1.4 2011/05/07 16:41:47 ewillink Exp $
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
import org.eclipse.ocl.examples.library.LibraryConstants;

/**
 * ForAllIteration realizes the Collection::forAll() library iteration.
 */
public class ForAllIteration extends AbstractIteration
{
	public static final @NonNull ForAllIteration INSTANCE = new ForAllIteration();

	public static class ForAllResult 
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
			return true;
		}
		
		public void setException(Exception exception) {
			this.exception = exception;
		}
		
		public void setIsNull() {
			this.isNull = true;
		}
	}

	public @NonNull Object createAccumulatorValue(@NonNull DomainEvaluator evaluator, @NonNull TypeId accumulatorTypeId, @NonNull TypeId bodyTypeId) {
		return LibraryConstants.NULL_SATISFIES_INVOLUTION ? new ForAllResult() : true;
	}

	@Override
	protected @Nullable Object resolveTerminalValue(@NonNull DomainIterationManager iterationManager) {
		if (LibraryConstants.NULL_SATISFIES_INVOLUTION) {
			ForAllResult accumulatorValue = (ForAllResult) iterationManager.getAccumulatorValue();
			assert accumulatorValue != null;
			return accumulatorValue.get();
		}
		else {
			return true;
		}
	}

	@Override
    protected @Nullable Object updateAccumulator(@NonNull DomainIterationManager iterationManager) {
		if (LibraryConstants.NULL_SATISFIES_INVOLUTION) {
			try {
				Object bodyVal = iterationManager.evaluateBody();
				if (bodyVal == null) {
					ForAllResult accumulatorValue = (ForAllResult) iterationManager.getAccumulatorValue();
					assert accumulatorValue != null;
					accumulatorValue.setIsNull();
					return CARRY_ON;						// Carry on for nothing found
				}
				else if (bodyVal == TRUE_VALUE) {
					return CARRY_ON;						// Carry on for nothing found
				}
				else {
					return false;							// Abort after a fail
				}
			}
			catch (Exception e) {
				ForAllResult accumulatorValue = (ForAllResult) iterationManager.getAccumulatorValue();
				assert accumulatorValue != null;
				accumulatorValue.setException(e);
				return CARRY_ON;							// Carry on for nothing found
			}
		}
		else if (bodyVal != Boolean.FALSE) {
			throw new InvalidValueException(EvaluatorMessages.NonBooleanBody, "forAll"); 	// Non boolean body is invalid //$NON-NLS-1$
		}
		else {
			Object bodyVal = iterationManager.evaluateBody();		
			if (bodyVal == null) {
				throw new InvalidValueException(EvaluatorMessages.UndefinedBody, "forAll"); 	// Null body is invalid //$NON-NLS-1$
			}
			else if (bodyVal == TRUE_VALUE) {
				return CARRY_ON;						// Carry on for nothing found
			}
			else {
				return false;							// Abort after a fail
			}
		}
	}
}
