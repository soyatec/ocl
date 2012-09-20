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
 * $Id: BooleanAndOperation.java,v 1.3 2011/02/21 08:37:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.logical;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractBinaryOperation;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.values.InvalidValue;

/**
 * AndOperation realises the and() library operation.
 */
public class BooleanAndOperation extends AbstractBinaryOperation
{
	public static final @NonNull BooleanAndOperation INSTANCE = new BooleanAndOperation();

	@Override
	public boolean argumentsMayBeInvalid() {
		return true;
	}

	public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @NonNull Object left, @NonNull Object right) {
		if ((left == Boolean.FALSE) || (right == Boolean.FALSE)) {
			return FALSE_VALUE;
		}
		else if ((left == Boolean.TRUE) && (right == Boolean.TRUE)) {
			return TRUE_VALUE;
		}
		else if (left instanceof InvalidValue) {
			return left;
		}
		else if (right instanceof InvalidValue) {
			return right;
		}
		else if (!(left instanceof Boolean)) {
			return createInvalidValue(EvaluatorMessages.TypedValueRequired, TypeId.BOOLEAN_NAME, getTypeName(left));
		}
		else {
			return createInvalidValue(EvaluatorMessages.TypedValueRequired, TypeId.BOOLEAN_NAME, getTypeName(right));
		}
	}
}
