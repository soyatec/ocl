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
 * $Id: OrderedCollectionInsertAtOperation.java,v 1.3 2011/02/21 08:37:46 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.collection;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractTernaryOperation;
import org.eclipse.ocl.examples.domain.values.SequenceValue;

/**
 * OrderedCollectionInsertAtOperation realises the OrderedCollection::insertAt() library operation.
 */
public class OrderedCollectionInsertAtOperation extends AbstractTernaryOperation
{
	public static final @NonNull OrderedCollectionInsertAtOperation INSTANCE = new OrderedCollectionInsertAtOperation();

	public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @NonNull Object sourceValue, @NonNull Object firstArgumentValue, @NonNull Object secondArgumentValue) {
		SequenceValue selfValue = asSequenceValue(sourceValue);
		Integer indexValue = asInteger(firstArgumentValue);
		Object insertValue = asValidValue(secondArgumentValue);
		return selfValue.insertAt(indexValue, insertValue);
	}
}
