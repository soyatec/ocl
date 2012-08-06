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
import org.eclipse.ocl.examples.domain.library.AbstractOperation;
import org.eclipse.ocl.examples.domain.library.LibraryBinaryOperation;
import org.eclipse.ocl.examples.domain.values.Value;

/**
 * OclIsUndefinedOperation realises the oclIsUndefined() library operation.
 */
public class UnsupportedOperation extends AbstractOperation implements LibraryBinaryOperation
{
	public static final @NonNull UnsupportedOperation INSTANCE = new UnsupportedOperation();

	public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainCallExp callExp, @NonNull Value sourceValue, Value... argumentValues) {
		throw new UnsupportedOperationException();
	}

	public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainCallExp callExp, @NonNull Value sourceValue, @NonNull Value argumentValue) throws InvalidValueException {
		throw new UnsupportedOperationException();
	}

	public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, @NonNull Value sourceValue, @NonNull Value argumentValue) throws InvalidValueException {
		throw new UnsupportedOperationException();
	}
}
