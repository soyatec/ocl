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
import org.eclipse.ocl.examples.domain.library.AbstractSimpleTernaryOperation;

/**
 * StringReplaceFirstOperation realises the String::replaceFirst() library operation.
 */
public class StringReplaceFirstOperation extends AbstractSimpleTernaryOperation
{
	public static final @NonNull StringReplaceFirstOperation INSTANCE = new StringReplaceFirstOperation();

	@Override
	public @NonNull String evaluate(@Nullable Object sourceValue, @Nullable Object firstArgumentValue, @Nullable Object secondArgumentValue) {
		String sourceString = asString(sourceValue);
		String regex = asString(firstArgumentValue);
		String replacement = asString(secondArgumentValue);
		@SuppressWarnings("null")@NonNull String result = sourceString.replaceFirst(regex, replacement);
		return result;
	}
}
