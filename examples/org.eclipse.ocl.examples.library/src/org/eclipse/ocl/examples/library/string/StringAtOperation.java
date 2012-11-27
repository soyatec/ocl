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
 * $Id: StringAtOperation.java,v 1.3 2011/02/21 08:37:46 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.string;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractBinaryOperation;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;

/**
 * StringAtOperation realises the String::at() library operation.
 */
public class StringAtOperation extends AbstractBinaryOperation
{
	public static final @NonNull StringAtOperation INSTANCE = new StringAtOperation();

	public @NonNull String evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object left, @Nullable Object right) {
		String leftString = asString(left);
		Integer rightInteger = asInteger(right);
		int size = leftString.length();
		int index = rightInteger.intValue();
		if ((0 < index) && (index <= size)) {
			char c = leftString.charAt(index-1);
			@SuppressWarnings("null") @NonNull String result = String.valueOf(c);
			return result;
		}
		else {
			throw new InvalidValueException(EvaluatorMessages.IndexOutOfRange, index, size);
		}
	}
}
