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
 * $Id: AbstractBinaryOperation.java,v 1.3 2011/02/21 08:37:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.domain.library;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainCallExp;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.Value;

/**
 * AbstractBinaryOperation dispatches a binary library operation to
 * matching-type-specific call-backs.
 */
public abstract class AbstractBinaryOperation extends AbstractOperation implements LibraryBinaryOperation
{
	public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainCallExp callExp, @NonNull Value sourceValue, Value... argumentValues) throws InvalidValueException {
		DomainType returnType = DomainUtil.nonNullPivot(callExp.getType());
		Value argumentValue0 = DomainUtil.nonNullState(argumentValues[0]);
		return evaluate(evaluator, returnType, sourceValue, argumentValue0);
	}

	public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainCallExp callExp, @NonNull Value sourceValue, @NonNull Value argumentValue) throws InvalidValueException {
		DomainType returnType = DomainUtil.nonNullPivot(callExp.getType());
		return evaluate(evaluator, returnType, sourceValue, argumentValue);
	}
}
