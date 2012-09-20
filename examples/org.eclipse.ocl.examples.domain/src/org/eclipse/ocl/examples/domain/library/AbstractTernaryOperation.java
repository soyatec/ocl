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
 * $Id: AbstractTernaryOperation.java,v 1.3 2011/02/21 08:37:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.domain.library;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainCallExp;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;

/**
 * AbstractBinaryOperation dispatches a binary library operation to
 * matching-type-specific call-backs.
 * 
 */
public abstract class AbstractTernaryOperation extends AbstractOperation implements LibraryTernaryOperation
{
	public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainCallExp callExp, @NonNull Object sourceValue, Object... argumentValues) {
		DomainType returnType = DomainUtil.nonNullPivot(callExp.getType());
		Object argumentValue0 = DomainUtil.nonNullState(argumentValues[0]);
		Object argumentValue1 = DomainUtil.nonNullState(argumentValues[1]);
		return evaluate(evaluator, returnType.getTypeId(), sourceValue, argumentValue0, argumentValue1);
	}

	public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainCallExp callExp, @NonNull Object sourceValue, @NonNull Object firstArgumentValue, @NonNull Object secondArgumentValue) {
		DomainType returnType = DomainUtil.nonNullPivot(callExp.getType());
		return evaluate(evaluator, returnType.getTypeId(), sourceValue, firstArgumentValue, secondArgumentValue);
	}
}
