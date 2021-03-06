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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractTernaryOperation;

/**
 * StringReplaceAllOperation realises the String::replaceAll() library operation.
 */
public class StringReplaceAllOperation extends AbstractTernaryOperation
{
	public static final @NonNull StringReplaceAllOperation INSTANCE = new StringReplaceAllOperation();

	@Override
	public @NonNull String evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue, @Nullable Object firstArgumentValue, @Nullable Object secondArgumentValue) {
		String sourceString = asString(sourceValue);
		String regex = asString(firstArgumentValue);
		String replacement = asString(secondArgumentValue);
		Pattern pattern = evaluator.getRegexPattern(regex);
		Matcher matcher = pattern.matcher(sourceString);
		@SuppressWarnings("null")@NonNull String result = matcher.replaceAll(replacement);
		return result;
	}
}
