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
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.library.AbstractTernaryOperation;
import org.eclipse.ocl.examples.domain.values.ValueFactory;

/**
 * StringSubstituteAllOperation realises the String::substituteAll() library operation.
 */
public class StringSubstituteAllOperation extends AbstractTernaryOperation
{
	public static final @NonNull StringSubstituteAllOperation INSTANCE = new StringSubstituteAllOperation();

	public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, @NonNull Object sourceValue, @NonNull Object firstArgumentValue, @NonNull Object secondArgumentValue) throws InvalidValueException {
		ValueFactory valueFactory = evaluator.getValueFactory();
		String sourceString = asString(sourceValue);
		String oldSubstring = asString(firstArgumentValue);
		String newSubstring = asString(secondArgumentValue);
		@SuppressWarnings("null") @NonNull String result = sourceString.replace(oldSubstring, newSubstring);
		return valueFactory.stringValueOf(result);
	}
}
