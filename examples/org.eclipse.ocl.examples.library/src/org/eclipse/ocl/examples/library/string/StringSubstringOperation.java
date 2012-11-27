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
 * $Id: StringSubstringOperation.java,v 1.4 2011/05/07 16:41:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.string;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractTernaryOperation;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;

/**
 * StringSubstringOperation realises the String::substring() library operation.
 */
public class StringSubstringOperation extends AbstractTernaryOperation
{
	public static final @NonNull StringSubstringOperation INSTANCE = new StringSubstringOperation();

	public @NonNull String evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue, @Nullable Object firstArgumentValue, @Nullable Object secondArgumentValue) {
		String sourceString = asString(sourceValue);
		Integer startInteger = asInteger(firstArgumentValue);
		Integer endInteger = asInteger(secondArgumentValue);
		int size = sourceString.length();
		int lower = startInteger.intValue();
		int upper = endInteger.intValue();
		if ((0 < lower) && (lower <= upper) && (upper <= size)) {
			@SuppressWarnings("null")@NonNull String result = sourceString.substring(lower-1, upper);
			return result;
		}
		else {
			throw new InvalidValueException(DomainUtil.bind(EvaluatorMessages.IndexesOutOfRange, lower, upper, size));
		}
	}
}
