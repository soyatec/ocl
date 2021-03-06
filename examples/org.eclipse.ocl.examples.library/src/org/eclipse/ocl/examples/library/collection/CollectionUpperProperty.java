/**
 * <copyright>
 *
 * Copyright (c) 2009, 2012 E.D.Willink and others.
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
import org.eclipse.ocl.examples.domain.elements.DomainCollectionType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractProperty;
import org.eclipse.ocl.examples.domain.values.IntegerValue;

/**
 * CollectionUpperProperty realizes the Collection::upper() library property.
 */
public class CollectionUpperProperty extends AbstractProperty
{
	public static final @NonNull CollectionUpperProperty INSTANCE = new CollectionUpperProperty();

	public @NonNull IntegerValue evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue) {
		DomainCollectionType sourceType = asCollectionType(sourceValue);
		return sourceType.getUpperValue();
	}
}
