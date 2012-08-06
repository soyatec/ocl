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
import org.eclipse.ocl.examples.domain.elements.DomainCallExp;
import org.eclipse.ocl.examples.domain.elements.DomainCollectionType;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.InvalidEvaluationException;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.library.AbstractPolyOperation;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.StringValue;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.domain.values.ValueFactory;

/**
 * StringTokenizeOperation realises the String::tokenize() library operations.
 */
public class StringTokenizeOperation extends AbstractPolyOperation 
{
	public static final StringTokenizeOperation INSTANCE = new StringTokenizeOperation();
	private static final String DELIMS = " \t\n\r\f"; //$NON-NLS-1$

	public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, @NonNull Value sourceValue) throws InvalidValueException {
		return evaluate(evaluator, (DomainCollectionType)returnType, sourceValue, DELIMS, false);
	}

	public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, @NonNull Value sourceValue, @NonNull Value argumentValue) throws InvalidValueException {
		boolean returnDelims = argumentValue.asBoolean();
		return evaluate(evaluator, (DomainCollectionType)returnType, sourceValue, DELIMS, returnDelims);
	}

	public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, @NonNull Value sourceValue, @NonNull Value firstArgumentValue, @NonNull Value secondArgumentValue) throws InvalidValueException {
		String delims = firstArgumentValue.asString();
		boolean returnDelims = secondArgumentValue.asBoolean();
		return evaluate(evaluator, (DomainCollectionType)returnType, sourceValue, delims, returnDelims);
	}

	public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainCallExp callExp, @NonNull Value sourceValue, Value... argumentValues) throws InvalidEvaluationException, InvalidValueException {
		String delims = DELIMS;
		boolean returnDelims = false;
		if (argumentValues.length > 0) {
			if (argumentValues.length > 1) {
				if (argumentValues.length > 2) {
					return evaluator.getValueFactory().throwInvalidValueException(EvaluatorMessages.InvalidArgument, argumentValues[2]);
				}
				returnDelims = argumentValues[1].asBoolean();
			}
			delims = argumentValues[0].asString();
		}
		return evaluate(evaluator, DomainUtil.nonNullPivot((DomainCollectionType)callExp.getType()), sourceValue, delims, returnDelims);
	}

	public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainCollectionType returnType, @NonNull Value sourceValue, @NonNull String delims, boolean returnDelims) throws InvalidValueException {
		ValueFactory valueFactory = evaluator.getValueFactory();
		String sourceString = sourceValue.asString();
		StringTokenizer tokenizer = new StringTokenizer(sourceString, delims, returnDelims);
		List<StringValue> results = new ArrayList<StringValue>();
		while (tokenizer.hasMoreTokens()) {
			@SuppressWarnings("null") @NonNull String nextToken = tokenizer.nextToken();
			results.add(valueFactory.stringValueOf(nextToken));
		}
		return valueFactory.createSequenceValue(returnType, results);
	}
}
