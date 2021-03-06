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
 * $Id: OclAnyUnsupportedOperation.java,v 1.2 2011/01/24 19:56:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.domain.library;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainCallExp;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;

/**
 * OclIsUndefinedOperation realises the oclIsUndefined() library operation.
 */
public class UnsupportedOperation extends AbstractPolyOperation implements LibraryProperty
{
	public static final @NonNull UnsupportedOperation INSTANCE = new UnsupportedOperation();

	@Override
	public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainCallExp callExp, @Nullable Object sourceValue)
			throws InvalidValueException {
		throw new UnsupportedOperationException();
	}

	public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainCallExp callExp, @Nullable Object sourceValue,
			@NonNull Object... argumentValues) {
		throw new UnsupportedOperationException();
	}

	@Override
	public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainCallExp callExp, @Nullable Object sourceValue,
			@Nullable Object argumentValue) {
		throw new UnsupportedOperationException();
	}

	@Override
	public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainCallExp callExp, @Nullable Object sourceValue,
			@Nullable Object firstArgumentValue, @Nullable Object secondArgumentValue) {
		throw new UnsupportedOperationException();
	}

	public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue) {
		throw new UnsupportedOperationException();
	}

	public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue,
			@Nullable Object argumentValue) {
		throw new UnsupportedOperationException();
	}

	public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue,
			@Nullable Object firstArgumentValue, @Nullable Object secondArgumentValue) {
		throw new UnsupportedOperationException();
	}
}
