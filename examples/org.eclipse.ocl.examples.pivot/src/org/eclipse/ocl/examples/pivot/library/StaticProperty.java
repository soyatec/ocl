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
 * $Id: ExplicitNavigationProperty.java,v 1.2 2011/05/07 16:41:20 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.library;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainProperty;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.library.AbstractProperty;
import org.eclipse.ocl.examples.domain.values.ValueFactory;

/**
 * The static instance of ExplicitNavigationProperty supports evaluation of
 * a property call that navigates a relationship.
 */
public class StaticProperty extends AbstractProperty
{
	public static final @NonNull StaticProperty INSTANCE = new StaticProperty();
	
	public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, @NonNull Object sourceValue, @NonNull DomainProperty property) throws InvalidValueException {
		ValueFactory valueFactory = evaluator.getValueFactory();
		DomainType type = property.getType(); 
		if (type != null) {
			return valueFactory.createTypeValue(type);
		}
		else {
			return valueFactory.getNull();
		}
	}
}