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
 * $Id: CollectionMaxOperation.java,v 1.3 2011/02/21 08:37:46 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.collection;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractUnaryOperation;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.library.numeric.NumericMaxOperation;

/**
 * CollectionMaxOperation realises the Collection::max() library operation.
 */
public class CollectionMaxOperation extends AbstractUnaryOperation
{
	public static final @NonNull CollectionMaxOperation INSTANCE = new CollectionMaxOperation();

	public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceVal) {
		CollectionValue collectionValue = asCollectionValue(sourceVal);
		// FIXME Bug 301351 Look for user-defined max
		Object result = null;
        for (Object element : collectionValue.iterable()) {
        	if (result == null) {
        		result = element;
        	}
        	else if (element != null) {
        		result = NumericMaxOperation.INSTANCE.evaluate(evaluator, returnTypeId, result, element);
        		if (ValuesUtil.isNull(result)) {
                	throw new InvalidValueException(EvaluatorMessages.UndefinedResult, "max"); //$NON-NLS-1$
        		}
        	}
        }
		if (result == null) {
        	throw new InvalidValueException(EvaluatorMessages.EmptyCollection, collectionValue.getKind(), "max"); //$NON-NLS-1$
		}
		return result;
    }
}
