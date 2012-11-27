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
 * $Id: StringSubstringOperation.java,v 1.4 2011/05/07 16:41:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.string;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainCallExp;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractPolyOperation;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.SequenceValue;

/**
 * StringTokenizeOperation realises the String::tokenize() library operations.
 */
public class StringTokenizeOperation extends AbstractPolyOperation 
{
	public static final @NonNull StringTokenizeOperation INSTANCE = new StringTokenizeOperation();
	private static final @NonNull String DELIMS = " \t\n\r\f"; //$NON-NLS-1$

	public @NonNull SequenceValue evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue) {
		return evaluate(evaluator, (CollectionTypeId)returnTypeId, sourceValue, DELIMS, false);
	}

	public @NonNull SequenceValue evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue, @Nullable Object argumentValue) {
		boolean returnDelims = asBoolean(argumentValue);
		return evaluate(evaluator, (CollectionTypeId)returnTypeId, sourceValue, DELIMS, returnDelims);
	}

	public @NonNull SequenceValue evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue, @Nullable Object firstArgumentValue, @Nullable Object secondArgumentValue) {
		String delims = asString(firstArgumentValue);
		boolean returnDelims = asBoolean(secondArgumentValue);
		return evaluate(evaluator, (CollectionTypeId)returnTypeId, sourceValue, delims, returnDelims);
	}

	public @NonNull SequenceValue evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainCallExp callExp, @Nullable Object sourceValue, Object... argumentValues) {
		String delims = DELIMS;
		boolean returnDelims = false;
		if (argumentValues.length > 0) {
			if (argumentValues.length > 1) {
				if (argumentValues.length > 2) {
					throw new InvalidValueException(EvaluatorMessages.InvalidArgument, argumentValues[2]);
				}
				Object argumentValue1 = argumentValues[1];
				assert argumentValue1 != null;
				returnDelims = asBoolean(argumentValue1);
			}
			Object argumentValue0 = argumentValues[0];
			assert argumentValue0 != null;
			delims = asString(argumentValue0);
		}
		return evaluate(evaluator, (CollectionTypeId)DomainUtil.nonNullPivot(callExp.getType()).getTypeId(), sourceValue, delims, returnDelims);
	}

	public @NonNull SequenceValue evaluate(@NonNull DomainEvaluator evaluator, @NonNull CollectionTypeId returnTypeId, @Nullable Object sourceValue, @NonNull String delims, boolean returnDelims) {
		String sourceString = asString(sourceValue);
		StringTokenizer tokenizer = new StringTokenizer(sourceString, delims, returnDelims);
		List<Object> results = new ArrayList<Object>();
		while (tokenizer.hasMoreTokens()) {
			@SuppressWarnings("null") @NonNull String nextToken = tokenizer.nextToken();
			results.add(nextToken);
		}
		return createSequenceValue(returnTypeId, results);
	}
}
