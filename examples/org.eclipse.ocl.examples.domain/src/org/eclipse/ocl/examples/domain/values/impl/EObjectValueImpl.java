/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
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
package org.eclipse.ocl.examples.domain.values.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.ValueFactory;

/**
 * @generated NOT
 */
public class EObjectValueImpl extends ObjectValueImpl
{
	protected final @NonNull EObject object;
	protected DomainType type = null;			// Lazily computed
	
	public EObjectValueImpl(@NonNull ValueFactory valueFactory, @NonNull EObject object) {
		super(valueFactory);
		this.object = object;
	}

	@Override
	public @NonNull EObject asNavigableObject() {
		return object;
	}

	@Override
	public Object asObject() {
		return object;
	}

	@Override
	public @NonNull EObject getObject() {
		return object;
	}

	public @NonNull DomainType getType() {
		DomainType type2 = type;
		if (type2 == null) {
			type2 = type = valueFactory.getStandardLibrary().getType(DomainUtil.nonNullEMF(object.eClass()));
		}
		return type2;
	}

	@Override
	public int hashCode() {
		return object.hashCode();
	}

	@Override
	public String toString() {
		return DomainUtil.getLabel(object);
	}
}
