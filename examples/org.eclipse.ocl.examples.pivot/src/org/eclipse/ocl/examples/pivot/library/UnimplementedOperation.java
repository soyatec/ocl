/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: UnimplementedOperation.java,v 1.2 2011/05/07 16:41:20 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.library;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractUnaryOperation;

/**
 * The static instance of UnimplementedOperation supports evaluation of
 * an operation that has not been implemented.
 */
public class UnimplementedOperation extends AbstractUnaryOperation //implements LibraryBinaryOperation
{
	public static final @NonNull UnimplementedOperation INSTANCE = new UnimplementedOperation();

	public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @NonNull Object sourceValue) {
		return createInvalidValue("No implementation");
	}

//	public Object evaluate(DomainEvaluator evaluator, DomainType returnType, Object sourceValue, Object argumentValue) {
//		ValueFactory valueFactory = evaluator.getValueFactory();
//		return valueFactory.throwInvalidValueException("No implementation");
//	}
}