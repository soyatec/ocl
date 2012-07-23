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
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.library.AbstractBinaryOperation;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.RealValue;
import org.eclipse.ocl.examples.domain.values.Value;

/**
 * AbstractNumericBinaryOperation dispatches a binary library operation to
 * matching-type-specific call-backs.
 */
public abstract class AbstractNumericBinaryOperation extends AbstractBinaryOperation
{
	public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, @NonNull Value left, @NonNull Value right) throws InvalidValueException {
		if (left.isUnlimited() || right.isUnlimited()) {
			return evaluateUnlimited(evaluator, left, right);
		}
		IntegerValue leftInteger = left.isIntegerValue();
		IntegerValue rightInteger = right.isIntegerValue();
		if ((leftInteger != null) && (rightInteger != null)) {
			return evaluateInteger(evaluator, leftInteger, rightInteger);
		}
		RealValue leftReal = left.asRealValue();
		RealValue rightReal = right.asRealValue();
		return evaluateReal(evaluator, leftReal, rightReal);
	}
	
	/**
	 * Evaluate an operation for which both left and right are Integer.
	 * @param left argument
	 * @param right argument
	 * @return result
	 * @throws InvalidValueException 
	 */
	protected abstract @NonNull Value evaluateInteger(@NonNull DomainEvaluator evaluator, @NonNull IntegerValue left, @NonNull IntegerValue right) throws InvalidValueException;

	/**
	 * Evaluate an operation for which both left and right are Real.
	 * @param left argument
	 * @param right argument
	 * @return result
	 * @throws InvalidValueException 
	 */
	protected @NonNull Value evaluateReal(@NonNull DomainEvaluator evaluator, @NonNull RealValue left, @NonNull RealValue right) throws InvalidValueException {
		return evaluator.getValueFactory().throwInvalidValueException(EvaluatorMessages.TypedValueRequired, "Real"); //$NON-NLS-1$
	}
	
	/**
	 * Evaluate an operation for which at least one of left and right are unlimited
	 * and for which neither left nor right are invalid or null.
	 * @param left argument
	 * @param right argument
	 * @return result
	 */
	protected @NonNull Value evaluateUnlimited(@NonNull DomainEvaluator evaluator, @NonNull Value left, @NonNull Value right) throws InvalidValueException {
		return evaluator.getValueFactory().throwInvalidValueException(EvaluatorMessages.TypedValueRequired, "Unlimited"); //$NON-NLS-1$
	}
}
