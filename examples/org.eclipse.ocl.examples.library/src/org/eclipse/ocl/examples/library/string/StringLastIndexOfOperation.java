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
 *
 * $Id: StringIndexOfOperation.java,v 1.4 2011/02/21 08:37:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.string;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractSimpleBinaryOperation;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;

/**
 * StringLastIndexOfOperation realises the String::lastIndexOf() library operation.
 */
public class StringLastIndexOfOperation extends AbstractSimpleBinaryOperation
{
	public static final @NonNull StringLastIndexOfOperation INSTANCE = new StringLastIndexOfOperation();

	@Override
	@Deprecated
	public @NonNull IntegerValue evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object left, @Nullable Object right) {
		return evaluate(left, right);
	}

	@Override
	public @NonNull IntegerValue evaluate(@Nullable Object left, @Nullable Object right) {
		String leftString = asString(left);
		String rightString = asString(right);
		/*if (leftString.length() <= 0) {
			return ValuesUtil.integerValueOf(0);
		}
		else*/ if (rightString.length() <= 0) {
			return ValuesUtil.integerValueOf(leftString.length()+1);
		}
		else {
			int index = leftString.lastIndexOf(rightString);
			if (index >= 0) {
				return ValuesUtil.integerValueOf(index+1);
			}
			else {
				return ValuesUtil.integerValueOf(0);
			}
		}
	}
}
