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
 * $Id: OclVoidOrOperation.java,v 1.2 2011/01/24 19:56:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.oclvoid;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractSimpleBinaryOperation;

/**
 * OclVoidOrOperation realises the OclVoid::or() library operation.
 */
public class OclVoidOrOperation extends AbstractSimpleBinaryOperation
{
	public static final @NonNull OclVoidOrOperation INSTANCE = new OclVoidOrOperation();

	@Override
	@Deprecated
	public @Nullable Boolean evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object left, @Nullable Object right) {
		return evaluate(left, right);
	}

	@Override
	public @Nullable Boolean evaluate(@Nullable Object left, @Nullable Object right) {
		if (right == TRUE_VALUE) {
			return asBoolean(right);		// Simple type cast
		}
		else {
			return asBoolean(left);			// Guaranteed exception
		}
	}
}
