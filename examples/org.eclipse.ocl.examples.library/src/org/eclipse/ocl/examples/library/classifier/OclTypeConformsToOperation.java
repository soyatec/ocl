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

	public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @NonNull Object sourceVal, @NonNull Object argVal) {
		DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
		DomainType thisType = asType(sourceVal);
		DomainType thatType = asType(argVal);
		return thisType.conformsTo(standardLibrary, thatType) != false;			// FIXME redundant test to suppress warning
	}
}
