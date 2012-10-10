/**
 * <copyright>
 *
 * Copyright (c) 2009,2012 E.D.Willink and others.
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
package org.eclipse.ocl.examples.library.collection;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractBinaryOperation;
import org.eclipse.ocl.examples.domain.values.CollectionValue;

/**
 * CollectionIntersectionOperation realises the Collection::intersection() library operation.
 */
public class CollectionIntersectionOperation extends AbstractBinaryOperation
{
	public static final @NonNull CollectionIntersectionOperation INSTANCE = new CollectionIntersectionOperation();

	public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object left, @Nullable Object right) {
		CollectionValue leftCollectionValue = asCollectionValue(left);
		CollectionValue rightCollectionValue = asCollectionValue(right);
		return leftCollectionValue.intersection(rightCollectionValue);
	}
}
