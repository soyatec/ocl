/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D.Willink and others.
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
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractBinaryOperation;

/**
 * StringMatchesOperation realises the String::matches() library operation.
 */
public class StringMatchesOperation extends AbstractBinaryOperation
{
	public static final @NonNull StringMatchesOperation INSTANCE = new StringMatchesOperation();

	public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @NonNull Object left, @NonNull Object right) {
		String leftString = asString(left);
		String rightString = asString(right);
		return leftString.matches(rightString) != false;			// FIXME redundant test to suppress warning
	}
}
