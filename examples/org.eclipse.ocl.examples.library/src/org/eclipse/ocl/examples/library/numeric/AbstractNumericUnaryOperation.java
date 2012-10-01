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
 * $Id: AbstractNumericUnaryOperation.java,v 1.3 2011/02/21 08:37:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.numeric;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractUnaryOperation;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.RealValue;
import org.eclipse.ocl.examples.domain.values.Value;

/**
 * AbstractNumericUnaryOperation dispatches a unary library operation to
 * matching-type-specific call-backs.
 */
public abstract class AbstractNumericUnaryOperation extends AbstractUnaryOperation
{
	public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @NonNull Object sourceVal) {
		if (isUnlimited(sourceVal)) {
			throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, "Unlimited"); //$NON-NLS-1$
		}
		IntegerValue integerValue = isIntegerValue(sourceVal); 
		if (integerValue != null) {
			return evaluateInteger(integerValue);			
		}
		RealValue realValue = asRealValue(sourceVal); 
		return evaluateReal(realValue);
	}

	protected abstract @NonNull Value evaluateReal(@NonNull RealValue left);
	
	protected abstract @NonNull Value evaluateInteger(@NonNull IntegerValue left);
}
