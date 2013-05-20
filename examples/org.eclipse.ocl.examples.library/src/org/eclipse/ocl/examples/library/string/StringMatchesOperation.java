/**
 * <copyright>
 *
 * Copyright (c) 2012, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.library.string;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractSimpleBinaryOperation;

/**
 * StringMatchesOperation realises the String::matches() library operation.
 */
public class StringMatchesOperation extends AbstractSimpleBinaryOperation
{
	public static final @NonNull StringMatchesOperation INSTANCE = new StringMatchesOperation();

	@Override
	@Deprecated
	public @NonNull Boolean evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object left, @Nullable Object right) {
		return evaluate(left, right);
	}

	@Override
	public @NonNull Boolean evaluate(@Nullable Object left, @Nullable Object right) {
		String leftString = asString(left);
		String rightString = asString(right);
		boolean result = leftString.matches(rightString);
		return result;
	}
}
