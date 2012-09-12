/**
 * <copyright>
 *
 * Copyright (c) 2010,2011 E.D.Willink and others.
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
 * $Id: ObjectValueImpl.java,v 1.9 2011/04/20 19:02:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.domain.values.impl;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.values.ValueFactory;

/**
 * @generated NOT
 */
public class JavaObjectValueImpl extends ObjectValueImpl
{
	protected final @NonNull Object object;
	protected DomainType type = null;
	
	public JavaObjectValueImpl(@NonNull ValueFactory valueFactory, @NonNull Object object) {
		super(valueFactory);
		this.object = object;
	}

	@Override
	public @NonNull Object asObject() {
		return object;
	}

	@Override
	public @NonNull Object getObject() {
		return object;
	}

	public @NonNull DomainType getType() {
		DomainType type2 = type;
		if (type2 == null) {										// WIP A better type
			DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			if (object instanceof Comparable) {
				type2 = type = standardLibrary.getOclComparableType();
			}
			else {
				type2 = type = standardLibrary.getMetaclassType();
			}
		}
		return type2;
	}

	@Override
	public int hashCode() {
		return object.hashCode();
	}
}
