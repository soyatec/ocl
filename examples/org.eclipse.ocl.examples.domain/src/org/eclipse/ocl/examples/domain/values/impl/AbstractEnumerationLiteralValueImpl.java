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

import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainEnumerationLiteral;
import org.eclipse.ocl.examples.domain.ids.EnumerationLiteralId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.EnumerationLiteralValue;
import org.eclipse.ocl.examples.domain.values.InvalidValue;
import org.eclipse.ocl.examples.domain.values.NullValue;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.domain.values.ValuesPackage;

/**
 * @generated NOT
 */
public abstract class AbstractEnumerationLiteralValueImpl extends ValueImpl implements EnumerationLiteralValue
{
	@Override
	protected EClass eStaticClass() {
		return ValuesPackage.Literals.ENUMERATION_LITERAL_VALUE;
	}

	protected final @NonNull EnumerationLiteralId enumerationLiteralId;

	public AbstractEnumerationLiteralValueImpl(@NonNull EnumerationLiteralId enumerationLiteralId) {
		this.enumerationLiteralId = enumerationLiteralId;
	}
	
	@Override
	public boolean equals(Object that) {
		if (this == that) {
			return true;
		}
		if (!(that instanceof EnumerationLiteralValue)) {
			return false;
		}
		return this.enumerationLiteralId == ((EnumerationLiteralValue)that).getEnumerationLiteralId();
	}

	public @NonNull EnumerationLiteralId getEnumerationLiteralId() {
		return enumerationLiteralId;
	}

	public @NonNull String getName() {
		String name = enumerationLiteralId.getName();
		return name;
	}

	public @NonNull DomainEnumerationLiteral getObject() {
//		return object;
		throw new UnsupportedOperationException();
	}

	public @NonNull TypeId getTypeId() {
		return enumerationLiteralId.getParentId();
	}

	@Override
	public int hashCode() {
		return enumerationLiteralId.hashCode();
	}
}
