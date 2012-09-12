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
 * $Id: NumericLessThanEqualOperation.java,v 1.2 2011/01/24 19:56:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.numeric;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.values.BooleanValue;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.RealValue;
import org.eclipse.ocl.examples.domain.values.ValueFactory;

/**
 * LessThanEqualOperation realises the <=() library operation.
 */
public class NumericLessThanEqualOperation extends AbstractNumericBinaryOperation
{
	public static final @NonNull NumericLessThanEqualOperation INSTANCE = new NumericLessThanEqualOperation();

	@Override
	protected @NonNull BooleanValue evaluateInteger(@NonNull DomainEvaluator evaluator, @NonNull IntegerValue left, @NonNull IntegerValue right) {
		ValueFactory valueFactory = evaluator.getValueFactory();
		return valueFactory.booleanValueOf(left.compareTo(right) <= 0);
	}

	@Override
	protected @NonNull BooleanValue evaluateReal(@NonNull DomainEvaluator evaluator, @NonNull RealValue left, @NonNull RealValue right) {
		ValueFactory valueFactory = evaluator.getValueFactory();
		return valueFactory.booleanValueOf(left.compareTo(right) <= 0);
	}

	@Override
	protected @NonNull BooleanValue evaluateUnlimited(@NonNull DomainEvaluator evaluator, @NonNull Object left, @NonNull Object right) {
		ValueFactory valueFactory = evaluator.getValueFactory();
		return valueFactory.booleanValueOf(isUnlimited(right));
	}
}
