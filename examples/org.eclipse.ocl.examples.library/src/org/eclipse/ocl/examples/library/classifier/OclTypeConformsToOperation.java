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
 * $Id$
 */
package org.eclipse.ocl.examples.library.classifier;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainMetaclass;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractBinaryOperation;

/**
 * OclTypeConformsToOperation realises the OclType::conformsTo(OclType) library operation.
 */
public class OclTypeConformsToOperation extends AbstractBinaryOperation
{
	public static final @NonNull OclTypeConformsToOperation INSTANCE = new OclTypeConformsToOperation();

	@Override
	public @NonNull Boolean evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceVal, @Nullable Object argVal) {
		DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
		DomainType thisType = asType(sourceVal);
		DomainType thatType = asType(argVal);
		//
		//	Give a MetaClass(X) a chance to match against OclType
		//
		boolean result = thisType.conformsTo(standardLibrary, thatType);
		if (result) {
			return true;
		}
		if (!(thisType instanceof DomainMetaclass)) {
			return false;
		}
		thisType = ((DomainMetaclass) thisType).getInstanceType();
//		if (thatType instanceof DomainMetaclass) {
//			thatType = ((DomainMetaclass) thatType).getInstanceType();
//		}
		result = thisType.conformsTo(standardLibrary, thatType);
		return result;
	}
}
