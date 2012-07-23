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
import org.eclipse.ocl.examples.domain.elements.DomainClassifierType;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;

public class AbstractClassifierType extends AbstractSpecializedType implements DomainClassifierType
{
	protected final @NonNull DomainType instanceType;
	protected DomainType metaType = null;
	private DomainType normalizedInstanceType = null;
	private int hashCode;
	
	public AbstractClassifierType(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainType containerType, @NonNull DomainType instanceType) {
		super(standardLibrary, DomainUtil.nonNullModel(containerType.getName()), containerType);
		this.instanceType = instanceType;
	}

	public boolean conformsTo(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainType type) {
		if (this == type) {
			return true;
		}
		DomainType thisMetaType = getMetaType();
		DomainType thatMetaType = type;
		return thisMetaType != null ? thisMetaType.conformsTo(standardLibrary, thatMetaType) : false;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof DomainClassifierType)) {
			return false;
		}
		DomainType thisInstanceType = getNormalizedInstanceType();
		DomainType thatInstanceType = ((DomainClassifierType)obj).getInstanceType().getNormalizedType(standardLibrary);
		return thisInstanceType.isEqualTo(standardLibrary, thatInstanceType);
	} 

	@Override
	public @NonNull DomainType getCommonType(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainType type) {
		if (!(type instanceof DomainClassifierType)) {
			return standardLibrary.getOclAnyType();
		}
		DomainType thatInstanceType = DomainUtil.nonNullModel(((DomainClassifierType)type).getInstanceType());
		DomainType commonInstanceType = instanceType.getCommonType(standardLibrary, thatInstanceType);
		if (commonInstanceType == instanceType) {
			return this;
		}
		else if (commonInstanceType == thatInstanceType) {
			return type;
		}
		else {
			return standardLibrary.getClassifierType(commonInstanceType);
		}
	}

	public DomainType getInstanceType() {
		return instanceType;
	}
	
	protected @Nullable DomainType getMetaType() {
		if (metaType == null) {
			String metaTypeName = instanceType.getMetaTypeName();
			metaType = standardLibrary.getOclType(metaTypeName);
		}
		return metaType;
	}
	
	protected @NonNull DomainType getNormalizedInstanceType() {
		if (normalizedInstanceType == null) {
			normalizedInstanceType = instanceType.getNormalizedType(standardLibrary);
			hashCode = normalizedInstanceType.hashCode();
		}
		return DomainUtil.nonNullJDT(normalizedInstanceType);
	}

	@Override
	public int hashCode() {
		if (normalizedInstanceType == null) {
			getNormalizedInstanceType();
		}
		return hashCode;
	}

	public boolean isEqualTo(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainType type) {
		if (this == type) {
			return true;
		}
		if (!(type instanceof DomainClassifierType)) {
			return false;
		}
		DomainType thisInstanceType = getNormalizedInstanceType();
		DomainType thatInstanceType = ((DomainClassifierType)type).getInstanceType().getNormalizedType(standardLibrary);
		return thisInstanceType.isEqualTo(standardLibrary, thatInstanceType);
	}

	@Override
	public String toString() {
		return String.valueOf(containerType) + "(" + String.valueOf(instanceType) + ")"; //$NON-NLS-1$ //$NON-NLS-2$
	}
}