/**
 * <copyright>
 *
 * Copyright (c) 2009, 2013 E.D.Willink and others.
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
package org.eclipse.ocl.examples.library.numeric;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.library.AbstractSimpleBinaryOperation;
import org.eclipse.ocl.examples.domain.values.RealValue;

/**
 * NumericPlusOperation realises the +() library operation.
 */
public class NumericPlusOperation extends AbstractSimpleBinaryOperation
{
	public static final @NonNull NumericPlusOperation INSTANCE = new NumericPlusOperation();

	@Override
	public @NonNull RealValue evaluate(@Nullable Object left, @Nullable Object right) {
		RealValue leftNumeric = asRealValue(left);
		RealValue rightNumeric = asRealValue(right);
		return rightNumeric.commutatedAdd(leftNumeric);
	}
}
