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
 * $Id: SetMinusOperation.java,v 1.3 2011/02/21 08:37:46 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.collection;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractBinaryOperation;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.UniqueCollectionValue;

/**
 * SetMinusOperation realises the Set::-() library operation.
 */
public class SetMinusOperation extends AbstractBinaryOperation
{
	public static final @NonNull SetMinusOperation INSTANCE = new SetMinusOperation();

	public @NonNull CollectionValue evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object left, @Nullable Object right) {
		UniqueCollectionValue leftValue = asUniqueCollectionValue(left);
		UniqueCollectionValue rightValue = asUniqueCollectionValue(right);
		return leftValue.minus(rightValue);
	}
}
