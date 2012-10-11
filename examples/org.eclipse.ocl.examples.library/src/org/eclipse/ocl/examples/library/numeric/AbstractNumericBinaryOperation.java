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
 * $Id: AbstractNumericBinaryOperation.java,v 1.3 2011/02/21 08:37:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.numeric;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractBinaryOperation;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.NumericValue;
import org.eclipse.ocl.examples.domain.values.RealValue;

/**
 * AbstractNumericBinaryOperation dispatches a binary library operation to
 * matching-type-specific call-backs.
 */
public abstract class AbstractNumericBinaryOperation extends AbstractBinaryOperation
{
	public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object left, @Nullable Object right) {
		if (!(left instanceof NumericValue)) {
			throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, "Numeric Value", getTypeName(left)); //$NON-NLS-1$
		}
		if (!(right instanceof NumericValue)) {
			throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, "Numeric Value", getTypeName(right)); //$NON-NLS-1$
		}
		NumericValue leftValue = (NumericValue)left;
		NumericValue rightValue = (NumericValue)right;
		if (leftValue.isUnlimited() || rightValue.isUnlimited()) {
			return evaluateUnlimited(evaluator, left, right);
		}
		IntegerValue leftInteger = leftValue.isIntegerValue();
		if (leftInteger != null) {
			IntegerValue rightInteger = rightValue.isIntegerValue();
			if (rightInteger != null) {
				return evaluateInteger(evaluator, leftInteger, rightInteger);
			}
		}
		RealValue leftReal = leftValue.asRealValue();
		RealValue rightReal = rightValue.asRealValue();
		return evaluateReal(evaluator, leftReal, rightReal);
	}

	/**
	 * Evaluate an operation for which both left and right are Integer.
	 * @param left argument
	 * @param right argument
	 * @return result
	 * @throws InvalidValueException 
	 */
	protected abstract @Nullable Object evaluateInteger(@NonNull DomainEvaluator evaluator, @NonNull IntegerValue left, @NonNull IntegerValue right);

	/**
	 * Evaluate an operation for which both left and right are Real.
	 * @param left argument
	 * @param right argument
	 * @return result
	 * @throws InvalidValueException 
	 */
	protected @Nullable Object evaluateReal(@NonNull DomainEvaluator evaluator, @NonNull RealValue left, @NonNull RealValue right) {
		throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, TypeId.REAL_NAME);
	}
	
	/**
	 * Evaluate an operation for which at least one of left and right are unlimited
	 * and for which neither left nor right are invalid or null.
	 * @param left argument
	 * @param right argument
	 * @return result
	 */
	protected @Nullable Object evaluateUnlimited(@NonNull DomainEvaluator evaluator, @Nullable Object left, @Nullable Object right) {
		throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, "Unlimited"); //$NON-NLS-1$
	}
}
