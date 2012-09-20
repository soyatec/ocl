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
import org.eclipse.ocl.examples.domain.library.AbstractTernaryOperation;

/**
 * StringReplaceAllOperation realises the String::replaceAll() library operation.
 */
public class StringReplaceAllOperation extends AbstractTernaryOperation
{
	public static final @NonNull StringReplaceAllOperation INSTANCE = new StringReplaceAllOperation();

	public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @NonNull Object sourceValue, @NonNull Object firstArgumentValue, @NonNull Object secondArgumentValue) {
		String sourceString = asString(sourceValue);
		String regex = asString(firstArgumentValue);
		String replacement = asString(secondArgumentValue);
		@SuppressWarnings("null") @NonNull String result = sourceString.replaceAll(regex, replacement);
		return result;
	}
}
