/**
 * <copyright>
 *
 * Copyright (c) 2013 E.D.Willink and others.
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
package org.eclipse.ocl.examples.library.classifier;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainMetaclass;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractProperty;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;

/**
 * MetaclassInstanceTypeProperty realizes the Metaclass::instanceType library property.
 */
public class MetaclassInstanceTypeProperty extends AbstractProperty
{
	public static final @NonNull MetaclassInstanceTypeProperty INSTANCE = new MetaclassInstanceTypeProperty();

	public @NonNull DomainType evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue) {
		DomainMetaclass sourceType = asMetaclass(sourceValue);
		return DomainUtil.nonNullModel(sourceType.getInstanceType());
	}
}
