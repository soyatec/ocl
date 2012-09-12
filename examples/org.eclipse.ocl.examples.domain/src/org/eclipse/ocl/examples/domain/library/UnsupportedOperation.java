/**
 * <copyright>
 *
 * Copyright (c) 2009,2010 E.D.Willink and others.
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
 * $Id: OclAnyUnsupportedOperation.java,v 1.2 2011/01/24 19:56:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.domain.library;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainCallExp;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;

/**
 * OclIsUndefinedOperation realises the oclIsUndefined() library operation.
 */
public class UnsupportedOperation extends AbstractOperation implements LibraryUnaryOperation, LibraryBinaryOperation, LibraryTernaryOperation
{
	public static final @NonNull UnsupportedOperation INSTANCE = new UnsupportedOperation();

	public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainCallExp callExp, @NonNull Object sourceValue)
			throws InvalidValueException {
		throw new UnsupportedOperationException();
	}

	public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainCallExp callExp, @NonNull Object sourceValue,
			Object... argumentValues) {
		throw new UnsupportedOperationException();
	}

	public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainCallExp callExp, @NonNull Object sourceValue,
			@NonNull Object argumentValue) throws InvalidValueException {
		throw new UnsupportedOperationException();
	}

	public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainCallExp callExp, @NonNull Object sourceValue,
			@NonNull Object firstArgumentValue, @NonNull Object secondArgumentValue) throws InvalidValueException {
		throw new UnsupportedOperationException();
	}

	public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, @NonNull Object sourceValue) throws InvalidValueException {
		throw new UnsupportedOperationException();
	}

	public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, @NonNull Object sourceValue,
			@NonNull Object argumentValue) throws InvalidValueException {
		throw new UnsupportedOperationException();
	}

	public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, @NonNull Object sourceValue,
			@NonNull Object firstArgumentValue, @NonNull Object secondArgumentValue) throws InvalidValueException {
		throw new UnsupportedOperationException();
	}
}
