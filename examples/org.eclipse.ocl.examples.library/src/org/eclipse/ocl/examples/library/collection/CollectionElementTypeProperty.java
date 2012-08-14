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
 * $Id$
 */
package org.eclipse.ocl.examples.library.collection;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainCollectionType;
import org.eclipse.ocl.examples.domain.elements.DomainProperty;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.library.AbstractProperty;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.CollectionTypeValue;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.domain.values.ValueFactory;

/**
 * CollectionElementTypeProperty realizes the Collection::elementType() library property.
 */
public class CollectionElementTypeProperty extends AbstractProperty
{
	public static final CollectionElementTypeProperty INSTANCE = new CollectionElementTypeProperty();

	public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, @NonNull Value sourceValue, @NonNull DomainProperty property) throws InvalidValueException {
		ValueFactory valueFactory = evaluator.getValueFactory();
		DomainCollectionType sourceType;
		CollectionValue sourceCollectionValue = sourceValue.isCollectionValue();
		if (sourceCollectionValue == null) {
			CollectionTypeValue sourceCollectionTypeValue = sourceValue.asCollectionTypeValue();
			sourceType = sourceCollectionTypeValue.getInstanceType();
		}
		else {
			sourceType = sourceCollectionValue.getCollectionType();
		}
		DomainType elementType = DomainUtil.nonNullModel(sourceType.getElementType());
		return valueFactory.createTypeValue(elementType);
	}
}
