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
package org.eclipse.ocl.examples.domain.ids;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;


/**
 * ElementBindings provides a hashable list of elementIds suitable for use when indexing specializations.
 */
public class TemplateBindings
{
	public static final @NonNull TemplateBindings EMPTY_LIST = new TemplateBindings();
	
	private final @NonNull ElementId[] elementIds;
	private final int hashCode;

	public TemplateBindings(@NonNull ElementId... elementIds) {
		this.elementIds = elementIds;
		int hash = 0;
		for (int i = 0; i < elementIds.length; i++) {
			hash = 111 * hash + elementIds[i].hashCode();
		}
		hashCode = hash;
	}
	
	public TemplateBindings(List<? extends ElementId> elementIds) {
		this.elementIds = new ElementId[elementIds.size()];
		int hash = 0;
		for (int i = 0; i < this.elementIds.length; i++) {
			ElementId elementId = elementIds.get(i);
			hash = 111 * hash + elementId.hashCode();
			this.elementIds[i] = elementId;
		}
		hashCode = hash;
	}
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof TemplateBindings)) {
			return false;
		}
		TemplateBindings that = (TemplateBindings)o;
		if (this.hashCode != that.hashCode){
			return false;
		}
		int iMax = elementIds.length;
		if (iMax != that.elementIds.length) {
			return false;
		}
		for (int i = 0; i < iMax; i++) {
			Object thisParameter = this.elementIds[i];
			Object thatParameter = that.elementIds[i];
			if (thisParameter != null) {
				if (thatParameter != null) {
					if (!thisParameter.equals(thatParameter)) {
						return false;
					}
				}
				else {
					return false;
				}				
			}
			else {
				if (thatParameter != null) {
					return false;
				}
				else {
				}				
			}
		}
		return true;
	}

	public ElementId get(int i) {
		return elementIds[i];
	}		

	@Override
	public int hashCode() {
		return hashCode;
	}

	public int parametersSize() {
		return elementIds.length;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append('(');
		for (int i = 0; i < elementIds.length; i++) {
			if (i > 0) {
				s.append(',');
			}
			s.append(String.valueOf(elementIds[i]));
		}
		s.append(')');
		return s.toString();
	}
}
