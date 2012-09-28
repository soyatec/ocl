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
 * $Id: CollectionProductOperation.java,v 1.3 2011/02/21 08:37:46 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.collection;

import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.TupleTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractBinaryOperation;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.TupleValue;

/**
 * CollectionProductOperation realises the Collection::product() library operation.
 */
public class CollectionProductOperation extends AbstractBinaryOperation
{
	public static final @NonNull CollectionProductOperation INSTANCE = new CollectionProductOperation();

	public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @NonNull Object sourceVal, @NonNull Object argVal) {
		CollectionValue sourceValue = asCollectionValue(sourceVal);
		CollectionValue argumentValue = asCollectionValue(argVal);
		CollectionTypeId collTypeId = (CollectionTypeId)returnTypeId;
		TupleTypeId tupleTypeId = (TupleTypeId) collTypeId.getElementTypeId();
		Set<TupleValue> product = sourceValue.product(argumentValue, tupleTypeId);
        if (product != null) {
        	return createSetValue(collTypeId, product);
        }
        else {
        	return createInvalidValue(EvaluatorMessages.MissingResult, "product"); //$NON-NLS-1$
        }
	}
}
