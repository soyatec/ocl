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

import java.util.Iterator;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.utilities.IndexableIterable;

/**
 * DomainParameterTypesIterable provides a hashable indexable list of operation
 * parameters suitable for use whebn indexing operation overloads.
 */
public class DomainTypeParameters implements IndexableIterable<DomainNamedElement>
{
public static final @NonNull DomainTypeParameters EMPTY_LIST = new DomainTypeParameters();

	//	private final @NonNull String name;
	private final @NonNull DomainNamedElement[] typeParameters;
	private Integer hashCode = null;
	
	public @NonNull Iterator<DomainNamedElement> iterator()
	{
		return new Iterator<DomainNamedElement>()
		{
			private int curr = 0;
			
			public boolean hasNext() {
				return curr < size();
			}

			public DomainNamedElement next() {
				if (curr < size()) {
					return get(curr++);
				}
				else {
					return null;
				}
			}

			public void remove() {
				throw new UnsupportedOperationException(); 		// Unimplemented optional operation
			}
		};
	}

	public DomainTypeParameters(DomainNamedElement... typeParameters) {
		this.typeParameters = typeParameters;
	}

	public DomainTypeParameters(List<? extends DomainNamedElement> typeParameters) {
		this.typeParameters = typeParameters.toArray(new DomainNamedElement[typeParameters.size()]);
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof DomainTypeParameters)) {
			return false;
		}
		DomainTypeParameters that = (DomainTypeParameters)obj;
		if (hashCode() != that.hashCode()) {
			return false;
		}
//		if (!name.equals(that.name)) {
//			return false;
//		}
		DomainNamedElement[] thoseParameters = that.typeParameters;
		if (typeParameters.length != thoseParameters.length) {
			return false;
		}
		for (int i = 0; i < typeParameters.length; i++) {
			if (!typeParameters[i].equals(thoseParameters[i])) {
				return false;
			}
		}
		return true;
	}

	public @NonNull DomainNamedElement get(int index) {
		return DomainUtil.nonNullEMF(typeParameters[index]);
	}

	@Override
	public int hashCode() {
		if (hashCode == null) {
			int hash = 0; //name.hashCode();
			for (DomainNamedElement typeParameter : typeParameters) {
				hash = 111*hash + typeParameter.hashCode();
			}
			hashCode = Integer.valueOf(hash);
		}
		return hashCode;
	}

	public int size() {
		return typeParameters.length;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
//		s.append(name);
		s.append('(');
		for (int i = 0; i < typeParameters.length; i++) {
			if (i > 0) {
				s.append(',');
			}
			s.append(typeParameters[i].toString());
		}
		s.append(')');
		return s.toString();
	}
}