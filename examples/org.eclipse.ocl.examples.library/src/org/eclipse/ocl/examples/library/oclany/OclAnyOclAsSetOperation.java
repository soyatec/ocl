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
 * $Id: OclAnyOclAsSetOperation.java,v 1.4 2011/05/07 16:41:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.oclany;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractUnaryOperation;
import org.eclipse.ocl.examples.domain.values.InvalidValue;
import org.eclipse.ocl.examples.domain.values.SetValue;

/**
 * OclAnyOclAsSetOperation realises the OclAny::oclAsSet() library operation.
 */
public class OclAnyOclAsSetOperation extends AbstractUnaryOperation
{
	public static final @NonNull OclAnyOclAsSetOperation INSTANCE = new OclAnyOclAsSetOperation();

	public @NonNull SetValue evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceVal) {
		if (sourceVal instanceof InvalidValue) {
			throw ((InvalidValue)sourceVal).getException();
		}
		else if (isNull(sourceVal)) {
			return createSetValue((CollectionTypeId)returnTypeId);
		}
		else {
			return createSetValue((CollectionTypeId)returnTypeId, sourceVal);
		}
	}
}
