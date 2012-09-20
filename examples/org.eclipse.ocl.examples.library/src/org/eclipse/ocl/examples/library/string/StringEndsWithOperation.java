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
 * $Id: StringConcatOperation.java,v 1.3 2011/02/21 08:37:46 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.string;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractBinaryOperation;

/**
 * StringEndsWithOperation realises the String::endsWith() library operation.
 */
public class StringEndsWithOperation extends AbstractBinaryOperation
{
	public static final @NonNull StringEndsWithOperation INSTANCE = new StringEndsWithOperation();

	public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @NonNull Object left, @NonNull Object right) {
		String leftString = asString(left);
		String rightString = asString(right);
		return leftString.endsWith(rightString) != false;			// FIXME redundant test to suppress warning
	}
}
