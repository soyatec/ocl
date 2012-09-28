/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.domain.elements;

import org.eclipse.jdt.annotation.NonNull;

/**
 * DomainParameterTypesIterable provides a hashable list of operation
 * parameters suitable for use when indexing operation overloads.
 */
public class DomainParameterTypes
{
	public static final @NonNull DomainParameterTypes EMPTY_LIST = new DomainParameterTypes();
	
	private final @NonNull DomainType[] parameterTypes;
	private final int hashCode;
	
	public DomainParameterTypes(@NonNull DomainType... parameterTypes) {
		this.parameterTypes = parameterTypes;
		int hash = 0;
		for (DomainType parameterType : parameterTypes) {
			hash = 111 * hash + parameterType.hashCode();
		}
		hashCode = hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof DomainParameterTypes)) {
			return false;
		}
		DomainParameterTypes that = (DomainParameterTypes)obj;
		if (hashCode() != that.hashCode()) {
			return false;
		}
		DomainType[] thoseParameters = that.parameterTypes;
		if (parameterTypes.length != thoseParameters.length) {
			return false;
		}
		for (int i = 0; i < parameterTypes.length; i++) {
			if (!parameterTypes[i].equals(thoseParameters[i])) {
				return false;
			}
		}
		return true;
	}

	public @NonNull DomainType get(int index) {
		DomainType parameterType = parameterTypes[index];
		assert parameterType != null;
		return parameterType;
	}

	public @NonNull DomainType[] get() {
		return parameterTypes;
	}

	@Override
	public int hashCode() {
		return hashCode;
	}

	public int size() {
		return parameterTypes.length;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append('(');
		for (int i = 0; i < parameterTypes.length; i++) {
			if (i > 0) {
				s.append(',');
			}
			s.append(parameterTypes[i].toString());
		}
		s.append(')');
		return s.toString();
	}
}