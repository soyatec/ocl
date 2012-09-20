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
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;

/**
 * AbstractPolyOperation supports arguments with a variety of argument lengths operations.
 */
public abstract class AbstractPolyOperation extends AbstractOperation implements LibraryUnaryOperation, LibraryBinaryOperation, LibraryTernaryOperation 
{
	public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainCallExp callExp, @NonNull Object sourceValue, @NonNull Object argumentValue) {
		return evaluate(evaluator, DomainUtil.nonNullPivot(callExp.getType()).getTypeId(), sourceValue, argumentValue);
	}

	public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainCallExp callExp, @NonNull Object sourceValue) {
		return evaluate(evaluator, DomainUtil.nonNullPivot(callExp.getType()).getTypeId(), sourceValue);
	}

	public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainCallExp callExp, @NonNull Object sourceValue, @NonNull Object firstArgumentValue, @NonNull Object secondArgumentValue) {
		return evaluate(evaluator, DomainUtil.nonNullPivot(callExp.getType()).getTypeId(), sourceValue, firstArgumentValue, secondArgumentValue);
	}
}
