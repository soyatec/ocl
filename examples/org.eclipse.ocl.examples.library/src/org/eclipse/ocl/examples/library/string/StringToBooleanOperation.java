/**
 * <copyright>
 *
 * Copyright (c) 2009, 2013 E.D.Willink and others.
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
 * $Id: StringToBooleanOperation.java,v 1.3 2011/02/21 08:37:46 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.string;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractSimpleUnaryOperation;

/**
 * StringToBooleanOperation realises the String::toBoolean() library operation.
 */
public class StringToBooleanOperation extends AbstractSimpleUnaryOperation
{
	public static final @NonNull StringToBooleanOperation INSTANCE = new StringToBooleanOperation();

	@Override
	@Deprecated
	public @NonNull Boolean evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue) {
		return evaluate(sourceValue);
	}

	@Override
	public @NonNull Boolean evaluate(@Nullable Object sourceVal) {
		String sourceString = asString(sourceVal);
		boolean result = "true".equals(sourceString); //$NON-NLS-1$
		return result;
	}
}
