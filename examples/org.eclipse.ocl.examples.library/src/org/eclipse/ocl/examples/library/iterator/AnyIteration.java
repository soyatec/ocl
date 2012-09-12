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
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.DomainIterationManager;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.library.AbstractIteration;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.SequenceValue;
import org.eclipse.ocl.examples.domain.values.ValueFactory;

/**
 * AnyIteration realizes the Collection::any() library iteration.
 */
public class AnyIteration extends AbstractIteration
{
	public static final @NonNull AnyIteration INSTANCE = new AnyIteration();

	public @NonNull SequenceValue.Accumulator createAccumulatorValue(@NonNull DomainEvaluator evaluator, @NonNull DomainType accumulatorType, @NonNull DomainType bodyType) {
		ValueFactory valueFactory = evaluator.getValueFactory();
		DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
		return valueFactory.createSequenceAccumulatorValue(standardLibrary.getSequenceType(accumulatorType, null, null));
	}
	
	@Override
	protected @NonNull Object resolveTerminalValue(@NonNull DomainIterationManager iterationManager) {
		try {
			SequenceValue.Accumulator accumulatorValue = (SequenceValue.Accumulator)iterationManager.getAccumulatorValue();
			if (accumulatorValue.intSize() > 0) {
				return accumulatorValue.at(1);		// Normal something found result.
			}
			else {
				return iterationManager.getValueFactory().getNull();
			}
		} catch (InvalidValueException e) {			// Cannot happen
			return iterationManager.getValueFactory().createInvalidValue(e);
		} 
	}
	
	@Override
    protected @Nullable Object updateAccumulator(@NonNull DomainIterationManager iterationManager) {
		Object bodyVal = iterationManager.evaluateBody();		
		if (isUndefined(bodyVal)) {
			return iterationManager.throwInvalidEvaluation(EvaluatorMessages.UndefinedBody, "any"); 	// Null body is invalid //$NON-NLS-1$
		}
		else if (isFalse(bodyVal)) {
			return null;									// Carry on for nothing found
		}
		else {
			CollectionValue.Accumulator accumulatorValue = (CollectionValue.Accumulator)iterationManager.getAccumulatorValue();
			if (accumulatorValue.intSize() > 0) {
				return iterationManager.getValueFactory().getFalse();				// Abort after second find
			}
			else {
				Object value = iterationManager.get();		
				accumulatorValue.add(value);
				return null;									// Carry on after first find
			}
		}
	}
}
