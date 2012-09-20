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
 * $Id: NumericMaxOperation.java,v 1.3 2011/02/21 08:37:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.numeric;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.RealValue;
import org.eclipse.ocl.examples.domain.values.Value;

/**
 * MaxOperation realises the max() library operation.
 */
public class NumericMaxOperation extends AbstractNumericBinaryOperation
{
	public static final @NonNull NumericMaxOperation INSTANCE = new NumericMaxOperation();

	@Override
	protected @NonNull IntegerValue evaluateInteger(@NonNull DomainEvaluator evaluator, @NonNull IntegerValue left, @NonNull IntegerValue right) {
		return left.max(right);
	}

	@Override
	protected @NonNull RealValue evaluateReal(@NonNull DomainEvaluator evaluator, @NonNull RealValue left, @NonNull RealValue right) {
		return left.max(right);
	}

	@Override
	protected @NonNull Object evaluateUnlimited(@NonNull DomainEvaluator evaluator, @NonNull Object left, @NonNull Object right) {
		Value leftValue = asUnlimitedNaturalValue(left);
		Value rightValue = asUnlimitedNaturalValue(right);
		return isUnlimited(left) ? leftValue : rightValue;
	}
}
