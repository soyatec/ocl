/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.domain.typeids;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainTypedElement;

/**
 * A TupleTypeid identifies a Tuple
 */
class TupleTypeid extends AbstractTypeid implements MatchableTypeid<List<? extends DomainTypedElement>>
{
	protected final @NonNull String name;
	protected final @NonNull String[] partNames;
	protected final @NonNull Typeid[] partTypeids;
	
	TupleTypeid(@NonNull String name, @NonNull List<? extends DomainTypedElement> orderedParts, int hashCode) {
		super(hashCode);
		this.name = name;;
		int size = orderedParts.size();
		this.partNames = new String[size];
		this.partTypeids = new Typeid[size];
		for (int i = 0; i < size; i++) {
			DomainTypedElement part = orderedParts.get(i);
			this.partNames[i] = part.getName();
			this.partTypeids[i] = part.getType().getTypeid();
		}
	}

	public boolean matches(@NonNull String thatName, @NonNull List<? extends DomainTypedElement> thoseOrderedParts) {
		if (!this.name.equals(thatName)) {
			return false;
		}
		if (this.partNames.length != thoseOrderedParts.size()) {
			return false;
		}
		for (int i = 0; i < partNames.length; i++) {
			DomainTypedElement thatPart = thoseOrderedParts.get(i);
			if (!this.partTypeids[i].equals(thatPart.getType().getTypeid())) {
				return false;
			}
			if (!this.partNames[i].equals(thatPart.getName())) {
				return false;
			}
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(name);
		s.append("{");
		for (int i = 0; i < partNames.length; i++) {
			if (i != 0) {
				s.append(",");
			}
			s.append(partNames[i]);
			s.append(":");
			s.append(partTypeids[i]);
		}
		s.append("}");
		return s.toString();
	}
}