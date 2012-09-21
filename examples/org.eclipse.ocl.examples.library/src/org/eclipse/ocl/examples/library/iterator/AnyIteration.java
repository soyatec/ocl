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
 * $Id: AnyIteration.java,v 1.4 2011/05/07 16:41:47 ewillink Exp $
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
 * AnyIteration realizes the Collection::any() library iteration.
 */
public class AnyIteration extends AbstractIteration
{
	public static final @NonNull AnyIteration INSTANCE = new AnyIteration();

	public static class MutableObject 
	{
		private Object value = null;
		
		public Object get() {
			return value;
		}
		
		public void set(Object value) {
			this.value = value;
		}
	}


	public @NonNull Object createAccumulatorValue(@NonNull DomainEvaluator evaluator, @NonNull TypeId accumulatorTypeId, @NonNull TypeId bodyTypeId) {
		return new MutableObject();
	}
	
	@Override
	protected @NonNull Object resolveTerminalValue(@NonNull DomainIterationManager iterationManager) {
		MutableObject accumulatorValue = (MutableObject)iterationManager.getAccumulatorValue();
		Object object = accumulatorValue.get();
		if (object != null) {
			return object;		// Normal something found result.
		}
		else {
			return NULL_VALUE;
		}
	}
	
	@Override
    protected @Nullable Object updateAccumulator(@NonNull DomainIterationManager iterationManager) {
		Object bodyVal = iterationManager.evaluateBody();		
		if (isUndefined(bodyVal)) {
			return createInvalidValue(EvaluatorMessages.UndefinedBody, "any"); 	// Null body is invalid //$NON-NLS-1$
		}
		else if (isFalse(bodyVal)) {
			return null;									// Carry on for nothing found
		}
		else {
			MutableObject accumulatorValue = (MutableObject)iterationManager.getAccumulatorValue();
			Object object = accumulatorValue.get();
			if (object != null) {
				return Boolean.FALSE;				// Abort after second find
			}
			else {
				Object value = iterationManager.get();		
				accumulatorValue.set(value);
				return null;									// Carry on after first find
			}
		}
	}
}
