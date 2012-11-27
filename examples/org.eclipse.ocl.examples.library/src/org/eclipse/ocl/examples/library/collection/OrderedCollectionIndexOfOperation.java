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
 * $Id: OrderedCollectionIndexOfOperation.java,v 1.3 2011/02/21 08:37:46 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.collection;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractBinaryOperation;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.SequenceValue;

/**
 * OrderedCollectionIndexOfOperation realises the OrderedCollection::indexOf() library operation.
 */
public class OrderedCollectionIndexOfOperation extends AbstractBinaryOperation
{
	public static final @NonNull OrderedCollectionIndexOfOperation INSTANCE = new OrderedCollectionIndexOfOperation();

	public @NonNull IntegerValue evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object left, @Nullable Object right) {
		SequenceValue leftOrderedCollectionValue = asSequenceValue(left);
		return leftOrderedCollectionValue.indexOf(right);
	}
}
