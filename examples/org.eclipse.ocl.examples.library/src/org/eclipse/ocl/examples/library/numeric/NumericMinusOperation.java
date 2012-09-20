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
 * $Id: NumericMinusOperation.java,v 1.3 2011/02/21 08:37:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.numeric;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.RealValue;
import org.eclipse.ocl.examples.domain.values.Value;

/**
 * MinusOperation realises the -() library operation.
 */
@Deprecated
public class NumericMinusOperation extends AbstractNumericBinaryOperation
{
	public static final @NonNull NumericMinusOperation INSTANCE = new NumericMinusOperation();

	@Override
	protected @NonNull Value evaluateInteger(@NonNull DomainEvaluator evaluator, @NonNull IntegerValue left, @NonNull IntegerValue right) {
		return left.subtract(right);
	}

	@Override
	protected @NonNull Value evaluateReal(@NonNull DomainEvaluator evaluator, @NonNull RealValue left, @NonNull RealValue right) {
		return left.subtract(right);
	}
}
