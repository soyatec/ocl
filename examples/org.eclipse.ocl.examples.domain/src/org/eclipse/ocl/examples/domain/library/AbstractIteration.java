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
 * $Id: AbstractIteration.java,v 1.4 2011/02/21 08:37:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.domain.library;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.evaluation.DomainIterationManager;

/**
 * AbstractIteration realizes shared characteristics of library iterations by providing a
 * default iteration algorithm with a call-back at each iteration step.
 */
public abstract class AbstractIteration extends AbstractFeature implements LibraryIteration
{	
	/**
	 * The default iteration algorithm steps through the iteration domain by invoking
	 * {@link DomainIterationManager.hasCurrent()} and {@link DomainIterationManager.advanceIterators()}.
	 * At each step {@link updateAccumulator(DomainIterationManager)} is invoked to update the
	 * accumulator for that step. A non-null return causes a premature exit and forms the
	 * return from the overall evaluation. If all steps complete {@link resolveTerminalValue(DomainIterationManager)}
	 * is invoked to provide the return value.
	 * <p>
	 * Derived classes may override this method to change the iteration algorithm or override
	 * the call-backs to customize the default iteration.
	 */
	public @NonNull Object evaluateIteration(@NonNull DomainIterationManager iterationManager) {
		while (true) {
			if (!iterationManager.hasCurrent()) {
				return resolveTerminalValue(iterationManager);			
			}
			Object resultVal = updateAccumulator(iterationManager);
			if (resultVal != null) {
				return resultVal;
			}
			iterationManager.advanceIterators();
		}
	}

	/**
	 * Return the final result at the end of an iteration over all the source elements. The
	 * default implementation just returns the accumulator. Derived iterations should
	 * override.
	 * <br>
	 * This method is bypassed if the iteration ends prematurely.
	 * 
	 * @param iterationManager the iteration context
	 * @return the result
	 */
	protected @NonNull Object resolveTerminalValue(@NonNull DomainIterationManager iterationManager) {
		return iterationManager.getAccumulatorValue();
	}
	
	/**
	 * Update the accumulatorValue with the bodyValue resulting from the current iteration
	 * for which the iterators define the context in the environment.
	 * 
	 * @param iterationManager the iteration context
	 * @return non-null premature result of iteration, or null if complete
	 */
	protected abstract @Nullable Object updateAccumulator(@NonNull DomainIterationManager iterationManager);
}
