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
 * $Id: StringSubstringOperation.java,v 1.4 2011/05/07 16:41:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.domain.library;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainCallExp;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.Value;

/**
 * AbstractPolyOperation supports arguments with a variety of argument lengths operations.
 */
public abstract class AbstractPolyOperation extends AbstractOperation implements LibraryUnaryOperation, LibraryBinaryOperation, LibraryTernaryOperation 
{
	public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainCallExp callExp, @NonNull Value sourceValue, @NonNull Value argumentValue) throws InvalidValueException {
		return evaluate(evaluator, DomainUtil.nonNullPivot(callExp.getType()), sourceValue, argumentValue);
	}

	public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainCallExp callExp, @NonNull Value sourceValue) throws InvalidValueException {
		return evaluate(evaluator, DomainUtil.nonNullPivot(callExp.getType()), sourceValue);
	}

	public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainCallExp callExp, @NonNull Value sourceValue, @NonNull Value firstArgumentValue, @NonNull Value secondArgumentValue) throws InvalidValueException {
		return evaluate(evaluator, DomainUtil.nonNullPivot(callExp.getType()), sourceValue, firstArgumentValue, secondArgumentValue);
	}
}
