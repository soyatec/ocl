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
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainCollectionType;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.ValueFactory;

public class AbstractCollectionType extends AbstractSpecializedType implements DomainCollectionType
{
	protected final @NonNull DomainType elementType;
	protected final @NonNull IntegerValue lower;
	protected final @NonNull IntegerValue upper;
	
	public AbstractCollectionType(@NonNull DomainStandardLibrary standardLibrary, @NonNull String name,
			@NonNull DomainType containerType, @NonNull DomainType elementType, @Nullable IntegerValue lower, @Nullable IntegerValue upper) {
		super(standardLibrary, name, containerType);
		this.elementType = elementType;
		ValueFactory valueFactory = standardLibrary.getValueFactory();
		this.lower = lower != null ? lower : valueFactory.getZero();
		this.upper = upper != null ? upper : valueFactory.getUnlimited();
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
					return standardLibrary.getOrderedSetType(commonElementClass, null, null);
				}
				else {
					return standardLibrary.getSequenceType(commonElementClass, null, null);
				}
			}
			else {
				if (commonContainerClass.isUnique()) {
					return standardLibrary.getSetType(commonElementClass, null, null);
				}
				else {
					return standardLibrary.getBagType(commonElementClass, null, null);
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

	public @NonNull IntegerValue getLowerValue(@NonNull ValueFactory valueFactory) {
		return lower;
	}

	public @NonNull IntegerValue getUpperValue(@NonNull ValueFactory valueFactory) {
		return upper;
	}

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