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
 * $Id: ClosureIteration.java,v 1.7 2011/05/07 16:41:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.iterator;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.DomainIterationManager;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractIteration;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;

/**
 * ClosureIteration realizes the Collection::closure() library iteration.
 */
public class ClosureIteration extends AbstractIteration
{
	public static final @NonNull ClosureIteration INSTANCE = new ClosureIteration();

	public @NonNull CollectionValue.Accumulator createAccumulatorValue(@NonNull DomainEvaluator evaluator, @NonNull TypeId accumulatorTypeId, @NonNull TypeId bodyTypeId) {
		return createCollectionAccumulatorValue((CollectionTypeId) accumulatorTypeId);
	}

	/**
	 * Recursively evaluates the iterator body expression.
	 * @throws Exception 
	 */
    @Override
	protected @Nullable Object updateAccumulator(@NonNull DomainIterationManager iterationManager) throws Exception {
		if (!iterationManager.isOuterIteration()) {
			// If there is the parent is the iterator
			Object value = iterationManager.get();
			CollectionValue.Accumulator accumulatorValue = (CollectionValue.Accumulator)iterationManager.getAccumulatorValue();
			assert accumulatorValue != null;
			if (!accumulatorValue.add(value)) {
				return null;
			}
			CollectionValue sourceCollection = iterationManager.getSourceCollection();
			if (sourceCollection.includes(value)) {
				return null;						// FIXME avoid redundant revisit of source domain element
			}
		}
		Object bodyVal = iterationManager.evaluateBody();		
		if (bodyVal instanceof InvalidValueException) { throw (InvalidValueException)bodyVal; }	// FIXME Analyze away
		if (bodyVal == null) {
			return iterationManager.getAccumulatorValue();		// Null body is termination
		}
		else {
//			try {
				CollectionValue collectionValue;
				if (bodyVal instanceof CollectionValue) {
					collectionValue = (CollectionValue) bodyVal;
				}
				else {
					DomainEvaluator evaluator = iterationManager.getEvaluator();
					DomainType elementType = evaluator.getStaticTypeOf(bodyVal);
					CollectionTypeId sequenceId = TypeId.SEQUENCE.getSpecializedId(elementType.getTypeId());
					collectionValue = evaluator.getIdResolver().createSequenceOfEach(sequenceId, bodyVal);
				}
				evaluateIteration(iterationManager.createNestedIterationManager(collectionValue));
//			} catch (InvalidValueException e) {
//				iterationManager.throwInvalidEvaluation(e);
//			}
			return null;
		}
	}
}
