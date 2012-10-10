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
 * $Id: NumericNegateOperation.java,v 1.3 2011/02/21 08:37:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.numeric;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.RealValue;
import org.eclipse.ocl.examples.domain.values.Value;

/**
 * NegateOperation realises the unary -() library operation.
 */
public class NumericNegateOperation extends AbstractNumericUnaryOperation
{
	public static final @NonNull NumericNegateOperation INSTANCE = new NumericNegateOperation();

	@Override
	protected @Nullable Value evaluateInteger(@NonNull IntegerValue left) {
		return left.negate();
	}
	
	@Override
	protected @Nullable Value evaluateReal(@NonNull RealValue left) {
		return left.negate();
	}
}
