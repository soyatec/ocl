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
 * $Id: StringToRealOperation.java,v 1.3 2011/02/21 08:37:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.string;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractUnaryOperation;

/**
 * StringTrimOperation realizes the String::trim() library operation.
 */
public class StringTrimOperation extends AbstractUnaryOperation
{
	public static final @NonNull StringTrimOperation INSTANCE = new StringTrimOperation();

	public @NonNull String evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceVal) {
		String sourceString = asString(sourceVal);
		@SuppressWarnings("null")@NonNull String result = sourceString.trim();
		return result;
	}
}
