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
 * $Id: CollectionNotEmptyOperation.java,v 1.3 2011/02/21 08:37:46 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.collection;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractUnaryOperation;
import org.eclipse.ocl.examples.domain.values.CollectionValue;

/**
 * CollectionNotEmptyOperation realises the Collection::notEmpty() library operation.
 */
public class CollectionNotEmptyOperation extends AbstractUnaryOperation
{
	public static final @NonNull CollectionNotEmptyOperation INSTANCE = new CollectionNotEmptyOperation();

	public @NonNull Boolean evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object argument) {
		CollectionValue collectionValue = asCollectionValue(argument);
		return collectionValue.notEmpty();
	}
}
