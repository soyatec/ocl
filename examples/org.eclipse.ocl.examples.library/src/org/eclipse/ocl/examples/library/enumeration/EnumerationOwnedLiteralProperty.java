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
package org.eclipse.ocl.examples.library.enumeration;

import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainElement;
import org.eclipse.ocl.examples.domain.elements.DomainEnumeration;
import org.eclipse.ocl.examples.domain.elements.DomainProperty;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.CollectedTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractProperty;
import org.eclipse.ocl.examples.domain.values.impl.OrderedSetImpl;

/**
 * EnumerationOwnedLiteralProperty realizes the Enumeration::ownedLiteral() library property.
 */
public class EnumerationOwnedLiteralProperty extends AbstractProperty
{
	public static final @NonNull EnumerationOwnedLiteralProperty INSTANCE = new EnumerationOwnedLiteralProperty();

	public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @NonNull Object sourceValue, @NonNull DomainProperty property) {
		DomainType sourceType = asType(sourceValue);
		Set<Object> results = new OrderedSetImpl<Object>();
		for (DomainElement instance : ((DomainEnumeration)sourceType).getEnumerationLiterals()) {
			if (instance != null) {
				results.add(valueOf(instance));
			}
		}
		return createOrderedSetValue((CollectedTypeId)returnTypeId, results);
	}
}
