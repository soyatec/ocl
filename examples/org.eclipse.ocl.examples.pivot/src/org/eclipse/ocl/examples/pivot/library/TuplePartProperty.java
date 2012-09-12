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
import org.eclipse.ocl.examples.domain.elements.DomainProperty;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.library.AbstractProperty;
import org.eclipse.ocl.examples.domain.library.LibraryFeature;
import org.eclipse.ocl.examples.domain.values.TupleValue;

public class TuplePartProperty extends AbstractProperty
{
	public static final @NonNull LibraryFeature INSTANCE = new TuplePartProperty();

	public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, @NonNull Object sourceValue, @NonNull DomainProperty property) throws InvalidValueException {
		TupleValue tupleValue = asTupleValue(sourceValue);
		Object resultValue = tupleValue.getValue(property);
		if (resultValue != null) {
			return resultValue;		// null is a static type error so no need to diagnose dynamically
		}
		else {
			return evaluator.getValueFactory().throwInvalidValueException("part '" + property + "' is not a part of '" + sourceValue);
		}
	}
}