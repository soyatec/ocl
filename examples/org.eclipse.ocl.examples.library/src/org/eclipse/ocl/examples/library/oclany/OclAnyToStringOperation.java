/**
 * <copyright>
 *
 * Copyright (c) 2010,2011 E.D.Willink and others.
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
 * $Id: OclAnyToStringOperation.java,v 1.4 2011/05/07 16:41:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.oclany;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractUnaryOperation;
import org.eclipse.ocl.examples.domain.values.InvalidValue;

/**
 * OclAnyToStringOperation realises the OclAny::toString() library operation.
 */
public class OclAnyToStringOperation extends AbstractUnaryOperation
{
	public static final @NonNull OclAnyToStringOperation INSTANCE = new OclAnyToStringOperation();

	public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceVal) {
		if (sourceVal instanceof InvalidValue)	{				// FIXME Remove this once CG has proper invalid analysis
			throw ((InvalidValue)sourceVal).getException();
		}
		return sourceVal != null ? oclToString(sourceVal) : NULL_STRING;
	}
}
