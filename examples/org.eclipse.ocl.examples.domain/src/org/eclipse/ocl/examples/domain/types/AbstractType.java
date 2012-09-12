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
package org.eclipse.ocl.examples.domain.types;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainInheritance;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.domain.elements.DomainProperty;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.elements.DomainTypeParameters;
import org.eclipse.ocl.examples.domain.values.ObjectValue;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.domain.values.ValueFactory;

public abstract class AbstractType implements DomainType	// FIXME rename as perhaps DerivativeType
{
	protected final @NonNull DomainStandardLibrary standardLibrary;

	protected final @NonNull String name;

	public AbstractType(@NonNull DomainStandardLibrary standardLibrary, @NonNull String name) {
		this.standardLibrary = standardLibrary;
		this.name = name;
	}

	public @NonNull ObjectValue createInstance(@NonNull ValueFactory valueFactory) {
		throw new UnsupportedOperationException();
	}

	public @NonNull Value createInstance(@NonNull ValueFactory valueFactory, @NonNull String value) {
		throw new UnsupportedOperationException();
	}

	public abstract @NonNull DomainType getCommonType(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainType type);

	public @NonNull DomainInheritance getInheritance(@NonNull DomainStandardLibrary standardLibrary) {
		throw new UnsupportedOperationException();			// WIP fixme / DerivativeType should not be used as full types
	}

	public @NonNull Iterable<? extends DomainOperation> getLocalOperations() {
		throw new UnsupportedOperationException();			// WIP fixme / DerivativeType should not be used as full types
	}

	public @NonNull Iterable<? extends DomainProperty> getLocalProperties() {
		throw new UnsupportedOperationException();			// WIP fixme / DerivativeType should not be used as full types
	}

	public @NonNull Iterable<? extends DomainType> getLocalSuperTypes() {
		throw new UnsupportedOperationException();			// WIP fixme / DerivativeType should not be used as full types
	}

	public @NonNull String getMetaTypeName() {
		throw new UnsupportedOperationException();			// WIP fixme / DerivativeType should not be used as full types
	}
	
	public final String getName() {
		return name;
	}

	public @NonNull DomainType getNormalizedType(@NonNull DomainStandardLibrary standardLibrary) {
		return getInheritance(standardLibrary);
	}

	public DomainPackage getPackage() {
		throw new UnsupportedOperationException();			// WIP fixme / DerivativeType should not be used as full types
	}
	
	public final DomainStandardLibrary getStandardLibrary() {
		return standardLibrary;
	}

	public @NonNull DomainTypeParameters getTypeParameters() {
		return DomainTypeParameters.EMPTY_LIST;
	}

	public boolean isEqualToUnspecializedType(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainType type) {
		if (this == type) {
			return true;
		}
		return false;
	}

	public boolean isInvalid() {
		return false;
	}

	public boolean isOrdered() {
		return false;
	}

	public boolean isUnique() {
		return false;
	}
}