/**
 * <copyright>
 *
 * Copyright (c) 2009,2011 E.D.Willink and others.
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
 * $Id: BooleanOrOperation.java,v 1.3 2011/02/21 08:37:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.logical;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractBinaryOperation;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.values.InvalidValue;

/**
 * OrOperation realises the or() library operation.
 */
public class BooleanOrOperation extends AbstractBinaryOperation
{
	public static final @NonNull BooleanOrOperation INSTANCE = new BooleanOrOperation();

	@Override
	public boolean argumentsMayBeInvalid() {
		return true;
	}

	public @Nullable Boolean evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object left, @Nullable Object right) {
		if ((left == Boolean.TRUE) || (right == Boolean.TRUE)) {
			return TRUE_VALUE;
		}
		else if ((left == Boolean.FALSE) && (right == Boolean.FALSE)) {
			return FALSE_VALUE;
		}
		else if (left instanceof InvalidValue) {
			throw ((InvalidValue)left).getException();
		}
		else if (right instanceof InvalidValue) {
			throw ((InvalidValue)right).getException();
		}
		else if (!(left instanceof Boolean)) {
			throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, TypeId.BOOLEAN_NAME, getTypeName(left));
		}
		else {
			throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, TypeId.BOOLEAN_NAME, getTypeName(right));
		}
	}
}
