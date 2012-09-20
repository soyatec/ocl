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
 * $Id: NumericPlusOperation.java,v 1.3 2011/02/21 08:37:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.integer;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractBinaryOperation;
import org.eclipse.ocl.examples.domain.values.IntegerValue;

/**
 * IntegerMinusOperation realizes the Integer::-() library operation.
 */
public class IntegerMinusOperation extends AbstractBinaryOperation
{
	public static final @NonNull IntegerMinusOperation INSTANCE = new IntegerMinusOperation();

	public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @NonNull Object left, @NonNull Object right) {
		IntegerValue leftValue = asIntegerValue(left);
		IntegerValue rightValue = asIntegerValue(right);
		return leftValue.subtract(rightValue);
	}
}
