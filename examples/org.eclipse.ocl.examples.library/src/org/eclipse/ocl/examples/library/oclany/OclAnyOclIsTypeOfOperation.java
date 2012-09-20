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
 * $Id: OclAnyOclIsTypeOfOperation.java,v 1.6 2011/04/25 09:48:57 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.oclany;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractBinaryOperation;

/**
 * OclAnyOclIsTypeOfOperation realises the OclAny::oclIsTypeOf() library operation.
 */
public class OclAnyOclIsTypeOfOperation extends AbstractBinaryOperation
{
	public static final @NonNull OclAnyOclIsTypeOfOperation INSTANCE = new OclAnyOclIsTypeOfOperation();

	public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @NonNull Object sourceVal, @NonNull Object argVal) {
		DomainType sourceType = evaluator.getStaticTypeOf(sourceVal);
		DomainType argType = asType(argVal);
		return sourceType.isEqualTo(evaluator.getStandardLibrary(), argType) != false;			// FIXME redundant test to suppress warning
	}
}
