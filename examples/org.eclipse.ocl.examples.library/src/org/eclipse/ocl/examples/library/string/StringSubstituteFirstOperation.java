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
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;

/**
 * StringSubstituteFirstOperation realises the String::substituteFirst() library operation.
 */
public class StringSubstituteFirstOperation extends AbstractSimpleTernaryOperation
{
	public static final @NonNull StringSubstituteFirstOperation INSTANCE = new StringSubstituteFirstOperation();

	@Override
	public @NonNull String evaluate(@Nullable Object sourceValue, @Nullable Object firstArgumentValue, @Nullable Object secondArgumentValue) {
		String sourceString = asString(sourceValue);
		String oldSubstring = asString(firstArgumentValue);
		String newSubstring = asString(secondArgumentValue);
		int index = sourceString.indexOf(oldSubstring);
		if (index < 0) {
			throw new InvalidValueException(EvaluatorMessages.MissingSubstring, oldSubstring, sourceString);
		}
		else {
			return sourceString.substring(0, index) + newSubstring + sourceString.substring(index + oldSubstring.length(), sourceString.length());
		}
	}
}
