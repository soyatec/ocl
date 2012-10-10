/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: TuplePartProperty.java,v 1.1 2011/04/27 06:19:59 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.library;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainProperty;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.TuplePartId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractProperty;
import org.eclipse.ocl.examples.domain.library.LibraryFeature;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.TupleValue;

public class TuplePartProperty extends AbstractProperty
{
	public static final @NonNull LibraryFeature INSTANCE = new TuplePartProperty();

	public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue, @NonNull DomainProperty property) {
		TupleValue tupleValue = asTupleValue(sourceValue);
		TuplePartId tuplePartId = tupleValue.getTypeId().getPartId(property.getName());	// FIXME pre-compute
		Object resultValue = tupleValue.getValue(tuplePartId);
		if (resultValue != null) {
			return resultValue;		// null is a static type error so no need to diagnose dynamically
		}
		else {
			return createInvalidValue(DomainUtil.bind("part '" + property + "' is not a part of '" + sourceValue));
		}
	}
}