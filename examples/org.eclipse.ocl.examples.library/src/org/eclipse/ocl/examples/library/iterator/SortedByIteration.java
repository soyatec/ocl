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
 * $Id: SortedByIteration.java,v 1.9 2011/05/20 15:26:37 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.iterator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainInheritance;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.DomainIterationManager;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.library.AbstractIteration;
import org.eclipse.ocl.examples.domain.library.LibraryBinaryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryFeature;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.domain.values.impl.ValueImpl;
import org.eclipse.ocl.examples.library.LibraryConstants;
import org.eclipse.osgi.util.NLS;

/**
 * SelectIteration realizes the Collection::sortedBy() library iteration.
 */
public class SortedByIteration extends AbstractIteration
{
	protected static class SortingValue extends ValueImpl implements Comparator<Value>
	{
		protected final @NonNull DomainType type;
		private final @NonNull DomainEvaluator evaluator;
		private final @NonNull DomainType iteratorType;
		private final @NonNull LibraryBinaryOperation implementation;
		private final @NonNull Map<Value, Value> content = new HashMap<Value, Value>();	// User object to sortedBy value
		private Map<Value, Integer> repeatCounts = null;						// Repeat counts for non-unique content

		public SortingValue(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, @NonNull LibraryBinaryOperation implementation) {
			super(evaluator.getValueFactory());
			this.type = returnType;
			this.evaluator = evaluator;
			this.iteratorType = valueFactory.getStandardLibrary().getIntegerType();
			this.implementation = implementation;
		}

		public @NonNull Object asObject() {
			return content;
		}

		public @NonNull Value asValidValue() {
			return this;
		}
		
		public int compare(Value o1, Value o2) {
			if (o1 == o2) {
				return 0;
			}
			Value v1 = content.get(o1);
			Value v2 = content.get(o2);
			if (v1 == v2) {
				return 0;
			}
			else if (v1 == null) {
				return -1;
			}
			else if (v2 == null) {
				return 1;
			}
			try {
				IntegerValue comparison = implementation.evaluate(evaluator, iteratorType, v1, v2).asIntegerValue();
				return comparison.signum();
			} catch (InvalidValueException e) {
				evaluator.throwInvalidEvaluation(e);
			}
			return 0;
		}

		public @NonNull Value createSortedValue() {
			List<Value> result = new ArrayList<Value>(content.keySet());
			Collections.sort(result, this);
			boolean isUnique = type.isUnique();
			if (isUnique || (repeatCounts == null)) {
				return valueFactory.createCollectionValue(true, isUnique, type, result);
			}
			else {
				List<Value> nonUniqueResult = new ArrayList<Value>();
				for (Value resultValue : result) {
					nonUniqueResult.add(resultValue);
					Integer repeatCount = repeatCounts.get(resultValue);
					if (repeatCount != null) {
						for (int i = repeatCount; i > 0; i--) {
							nonUniqueResult.add(resultValue);
						}
					}
				}
				return valueFactory.createCollectionValue(true, false, type, nonUniqueResult);
			}
		}

		public @NonNull DomainType getType() {
			return type;
		}

		public void put(@NonNull Value iterVal, @NonNull Value comparable) {
			if (content.put(iterVal, comparable) != null) {
				if (!type.isUnique()) {
					if (repeatCounts == null) {
						repeatCounts = new HashMap<Value, Integer>();
					}
					Integer repeatCount = repeatCounts.get(iterVal);
					if (repeatCount == null) {
						repeatCount = 1;
					}
					else {
						repeatCount++;
					}
					repeatCounts.put(iterVal, repeatCount);
				}
			}
		}

		@Override
		public String toString() {
			return content.toString();
		}
	}

	public static final @NonNull SortedByIteration INSTANCE = new SortedByIteration();

	public @NonNull SortedByIteration.SortingValue createAccumulatorValue(@NonNull DomainEvaluator evaluator, @NonNull DomainType accumulatorType, @NonNull DomainType bodyType) throws InvalidValueException {
		DomainStandardLibrary standardLibrary = evaluator.getValueFactory().getStandardLibrary();
		DomainInheritance comparableType = standardLibrary.getOclComparableType().getInheritance(standardLibrary);
		DomainInheritance selfType = standardLibrary.getOclSelfType().getInheritance(standardLibrary);
		DomainOperation staticOperation = comparableType.lookupLocalOperation(standardLibrary, LibraryConstants.COMPARE_TO, selfType);
		try {
			if (staticOperation != null) {
				LibraryFeature implementation = bodyType.lookupImplementation(standardLibrary, staticOperation);
				return new SortingValue(evaluator, accumulatorType, (LibraryBinaryOperation) implementation);
			}
		} catch (Exception e) {
			throw new InvalidValueException(e);
		}
		throw new InvalidValueException(NLS.bind(EvaluatorMessages.UndefinedOperation, String.valueOf(comparableType) + "::" + LibraryConstants.COMPARE_TO)); //$NON-NLS-1$
	}
	
	@Override
	protected @NonNull Value resolveTerminalValue(@NonNull DomainIterationManager iterationManager) {
		SortingValue accumulatorValue = (SortingValue) iterationManager.getAccumulatorValue();
		return accumulatorValue.createSortedValue();
	}

	@Override
    protected @Nullable Value updateAccumulator(@NonNull DomainIterationManager iterationManager) {
		Value bodyVal = iterationManager.evaluateBody();		
		if (bodyVal.isUndefined()) {
			return iterationManager.throwInvalidEvaluation(EvaluatorMessages.UndefinedBody, "sortedBy"); 	// Null body is invalid //$NON-NLS-1$
		}
		Value iterValue = iterationManager.get();		
		SortingValue accumulatorValue = (SortingValue) iterationManager.getAccumulatorValue();
		accumulatorValue.put(iterValue, bodyVal);
		return null;										// Carry on
	}
}
