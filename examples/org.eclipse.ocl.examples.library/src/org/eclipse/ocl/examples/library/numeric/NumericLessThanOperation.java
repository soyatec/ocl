/**
 * <copyright>
 *
 * Copyright (c) 2009,2010 E.D.Willink and others.
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
 * $Id: NumericLessThanOperation.java,v 1.2 2011/01/24 19:56:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.numeric;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.RealValue;

/**
 * LessThanOperation realises the <() library operation.
 */
public class NumericLessThanOperation extends AbstractNumericBinaryOperation
{
	public static final @NonNull NumericLessThanOperation INSTANCE = new NumericLessThanOperation();

	@Override
	protected @Nullable Object evaluateInteger(@NonNull DomainEvaluator evaluator, @NonNull IntegerValue left, @NonNull IntegerValue right) {
		return left.compareTo(right) < 0;
	}

	@Override
	protected @Nullable Object evaluateReal(@NonNull DomainEvaluator evaluator, @NonNull RealValue left, @NonNull RealValue right) {
		return left.compareTo(right) < 0;
	}

	@Override
	protected @Nullable Object evaluateUnlimited(@NonNull DomainEvaluator evaluator, @Nullable Object left, @Nullable Object right) {
		return !isUnlimited(left) && isUnlimited(right);
	}
}
