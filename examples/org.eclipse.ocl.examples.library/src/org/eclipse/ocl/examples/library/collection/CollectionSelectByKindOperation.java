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
 */
package org.eclipse.ocl.examples.library.collection;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractBinaryOperation;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;

/**
 * CollectionSelectByKindOperation realises the Collection::selectByType() library operation.
 */
public class CollectionSelectByKindOperation extends AbstractBinaryOperation
{
	public static final @NonNull CollectionSelectByKindOperation INSTANCE = new CollectionSelectByKindOperation();

	public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @NonNull Object sourceVal, @NonNull Object argVal) {
		CollectionValue collectionValue = asCollectionValue(sourceVal);
		DomainType requiredElementType = asType(argVal);
    	DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
		boolean changedContents = false;
		Collection<Object> newElements = new ArrayList<Object>();
        for (Object element : collectionValue.iterable()) {
        	assert element != null;
			if (ValuesUtil.isNull(element)) {
        		changedContents = true;
			}
			else {
				DomainType elementType = evaluator.getStaticTypeOf(element);
				if (elementType.conformsTo(standardLibrary, requiredElementType)) {
	        		newElements.add(element);
	        	}
	        	else {
	        		changedContents = true;
	        	}
			}
        }
        if (changedContents) {
        	return createCollectionValue(collectionValue.isOrdered(), collectionValue.isUnique(), collectionValue.getTypeId(), newElements);
        }
        else {
        	return collectionValue;
        }
	}
}
