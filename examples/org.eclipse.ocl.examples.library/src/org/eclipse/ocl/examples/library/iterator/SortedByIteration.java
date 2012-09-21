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
import org.eclipse.ocl.examples.domain.ids.CollectedTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractIteration;
import org.eclipse.ocl.examples.domain.library.LibraryBinaryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryFeature;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.domain.values.impl.ValueImpl;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.library.LibraryConstants;

/**
 * SelectIteration realizes the Collection::sortedBy() library iteration.
 */
public class SortedByIteration extends AbstractIteration
{
	protected static class SortingValue extends ValueImpl implements Comparator<Object>
	{
		protected final @NonNull CollectedTypeId typeId;
		private final @NonNull DomainEvaluator evaluator;
		private final boolean isUnique;
		private final @NonNull LibraryBinaryOperation implementation;
		private final @NonNull Map<Object, Object> content = new HashMap<Object, Object>();	// User object to sortedBy value
		private Map<Object, Integer> repeatCounts = null;						// Repeat counts for non-unique content

		public SortingValue(@NonNull DomainEvaluator evaluator, @NonNull CollectedTypeId returnTypeId, @NonNull LibraryBinaryOperation implementation) {
			this.typeId = returnTypeId;
			this.evaluator = evaluator;
			this.implementation = implementation;
			isUnique = (typeId.getCollectionTypeId() == TypeId.SET) || (typeId.getCollectionTypeId() == TypeId.ORDERED_SET);
		}

		public @NonNull Object asObject() {
			return content;
		}
		
		public int compare(Object o1, Object o2) {
			if (o1 == o2) {
				return 0;
			}
			Object v1 = content.get(o1);
			Object v2 = content.get(o2);
			if (v1 == v2) {
				return 0;
			}
			else if (v1 == null) {
				return -1;
			}
			else if (v2 == null) {
				return 1;
			}
//			try {
				IntegerValue comparison = ValuesUtil.asIntegerValue(implementation.evaluate(evaluator, TypeId.INTEGER, v1, v2));
				return comparison.signum();
//			} catch (InvalidValueException e) {
//				evaluator.throwInvalidEvaluation(e);
//			}
//			return 0;
		}

		public @NonNull Value createSortedValue() {
			List<Object> result = new ArrayList<Object>(content.keySet());
			Collections.sort(result, this);
			if (isUnique || (repeatCounts == null)) {
				return createCollectionValue(true, isUnique, typeId, result);
			}
			else {
				List<Object> nonUniqueResult = new ArrayList<Object>();
				for (Object resultValue : result) {
					nonUniqueResult.add(resultValue);
					Integer repeatCount = repeatCounts.get(resultValue);
					if (repeatCount != null) {
						for (int i = repeatCount; i > 0; i--) {
							nonUniqueResult.add(resultValue);
						}
					}
				}
				return createCollectionValue(true, false, typeId, nonUniqueResult);
			}
		}

//		public @NonNull DomainType getType(@NonNull DomainStandardLibrary standardLibrary) {
//			return type;
//		}

		public @NonNull TypeId getTypeId() {
			return typeId;
		}

		public void put(@NonNull Object iterVal, @NonNull Object comparable) {
			if (content.put(iterVal, comparable) != null) {
				if (!isUnique) {
					if (repeatCounts == null) {
						repeatCounts = new HashMap<Object, Integer>();
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

	public @NonNull SortedByIteration.SortingValue createAccumulatorValue(@NonNull DomainEvaluator evaluator, @NonNull TypeId accumulatorTypeId, @NonNull TypeId bodyTypeId) {
		DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
		DomainInheritance comparableType = standardLibrary.getOclComparableType().getInheritance(standardLibrary);
		DomainInheritance selfType = standardLibrary.getOclSelfType().getInheritance(standardLibrary);
		DomainOperation staticOperation = comparableType.lookupLocalOperation(standardLibrary, LibraryConstants.COMPARE_TO, selfType);
		try {
			if (staticOperation != null) {
				DomainType bodyType = standardLibrary.getType(bodyTypeId);
				LibraryFeature implementation = bodyType.lookupImplementation(standardLibrary, staticOperation);
				return new SortingValue(evaluator, (CollectedTypeId)accumulatorTypeId, (LibraryBinaryOperation) implementation);
			}
		} catch (Exception e) {
			throw new InvalidValueException(createInvalidValue(e));
		}
		throw new InvalidValueException(createInvalidValue(EvaluatorMessages.UndefinedOperation, String.valueOf(comparableType) + "::" + LibraryConstants.COMPARE_TO)); //$NON-NLS-1$
	}
	
	@Override
	protected @NonNull Object resolveTerminalValue(@NonNull DomainIterationManager iterationManager) {
		SortingValue accumulatorValue = (SortingValue) iterationManager.getAccumulatorValue();
		return accumulatorValue.createSortedValue();
	}

	@Override
    protected @Nullable Object updateAccumulator(@NonNull DomainIterationManager iterationManager) {
		Object bodyVal = iterationManager.evaluateBody();		
		if (isUndefined(bodyVal)) {
			return createInvalidValue(EvaluatorMessages.UndefinedBody, "sortedBy"); 	// Null body is invalid //$NON-NLS-1$
		}
		Object iterValue = iterationManager.get();		
		SortingValue accumulatorValue = (SortingValue) iterationManager.getAccumulatorValue();
		accumulatorValue.put(iterValue, bodyVal);
		return null;										// Carry on
	}
}
