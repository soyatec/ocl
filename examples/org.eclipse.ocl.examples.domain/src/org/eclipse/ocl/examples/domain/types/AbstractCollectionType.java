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

import java.math.BigInteger;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainCollectionType;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;

public class AbstractCollectionType extends AbstractSpecializedType implements DomainCollectionType
{
	protected final @NonNull DomainType elementType;
	protected final @NonNull BigInteger lower;
	protected final @NonNull BigInteger upper;
	
	public AbstractCollectionType(@NonNull DomainStandardLibrary standardLibrary, @NonNull String name,
			@NonNull DomainType containerType, @NonNull DomainType elementType, @Nullable BigInteger lower, @Nullable BigInteger upper) {
		super(standardLibrary, name, containerType);
		this.elementType = elementType;
		@SuppressWarnings("null") @NonNull BigInteger lower2 = lower != null ? lower : BigInteger.valueOf(0);
		@SuppressWarnings("null") @NonNull BigInteger upper2 = upper != null ? upper : BigInteger.valueOf(-1);
		this.lower = lower2;
		this.upper = upper2;
	}

	public boolean conformsTo(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainType type) {
		if (this == type) {
			return true;
		}
		if (!(type instanceof DomainCollectionType)) {
			return false;
		}
		return standardLibrary.conformsToCollectionType(this, (DomainCollectionType)type);
	}

	@Override
	public @NonNull DomainType getCommonType(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainType type) {
		if (!(type instanceof AbstractCollectionType)) {
			return standardLibrary.getOclAnyType();
		}
		AbstractCollectionType thatClass = (AbstractCollectionType) type;
		// FIXME kind
		DomainType commonContainerClass = containerType;		// FIXME WIP
		DomainType commonElementClass = elementType.getCommonType(standardLibrary, thatClass.getElementType());
		if ((commonContainerClass == containerType) && (commonElementClass == elementType)) {
			return this;
		}
		else if ((commonContainerClass == thatClass.containerType) && (commonElementClass == thatClass.elementType)) {
			return thatClass;
		}
		else {
			if (commonContainerClass.isOrdered()) {
				if (commonContainerClass.isUnique()) {
					return standardLibrary.getOrderedSetType(commonElementClass);
				}
				else {
					return standardLibrary.getSequenceType(commonElementClass);
				}
			}
			else {
				if (commonContainerClass.isUnique()) {
					return standardLibrary.getSetType(commonElementClass);
				}
				else {
					return standardLibrary.getBagType(commonElementClass);
				}
			}
		}
	}

	@Override
	public DomainCollectionType getContainerType() {
		return (DomainCollectionType)containerType;
	}

	public @NonNull DomainType getElementType() {
		return elementType;
	}

	public @NonNull BigInteger getLower() {
		return lower;
	}

	public @NonNull BigInteger getUpper() {
		return upper;
	}

/*	public DomainType getMetaType(DomainStandardLibrary standardLibrary) {
		if (containerType.isOrdered()) {
			if (containerType.isUnique()) {
				return standardLibrary.getOrderedSetType(elementType);
			}
			else {
				return standardLibrary.getSequenceType(elementType);
			}
		}
		else {
			if (containerType.isUnique()) {
				return standardLibrary.getSetType(elementType);
			}
			else {
				return standardLibrary.getBagType(elementType);
			}
		}
	} */

	public boolean isEqualTo(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainType type) {
		if (this == type) {
			return true;
		}
		if (!(type instanceof DomainCollectionType)) {
			return false;
		}
		return standardLibrary.isEqualToCollectionType(this, (DomainCollectionType)type);
	}

	@Override
	public String toString() {
		return String.valueOf(containerType) + "(" + String.valueOf(elementType) + ")"; //$NON-NLS-1$ //$NON-NLS-2$
	}
}