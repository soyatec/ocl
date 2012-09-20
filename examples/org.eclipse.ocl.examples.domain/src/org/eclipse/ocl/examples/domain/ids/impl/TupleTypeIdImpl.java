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
package org.eclipse.ocl.examples.domain.ids.impl;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainTypedElement;
import org.eclipse.ocl.examples.domain.ids.IdVisitor;
import org.eclipse.ocl.examples.domain.ids.TupleTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;

public class TupleTypeIdImpl extends AbstractTypeId implements TupleTypeId, MatchableId<List<? extends DomainTypedElement>>
{
	protected final @NonNull Integer hashCode;			// Avoids the key getting prematurely garbage collected
	protected final @NonNull String name;
	protected final @NonNull String[] partNames;
	protected final @NonNull TypeId[] partTypeIds;
	
	public TupleTypeIdImpl(@NonNull String name, @NonNull List<? extends DomainTypedElement> orderedParts, @NonNull Integer hashCode) {
		this.hashCode = hashCode;
		this.name = name;
		int size = orderedParts.size();
		this.partNames = new String[size];
		this.partTypeIds = new TypeId[size];
		for (int i = 0; i < size; i++) {
			DomainTypedElement part = orderedParts.get(i);
			this.partNames[i] = part.getName();
			this.partTypeIds[i] = part.getType().getTypeId();
		}
	}

	public @Nullable <R> R accept(@NonNull IdVisitor<R> visitor) {
		return visitor.visitTupleId(this);
	}
	
	public @NonNull String getDisplayName() {
		StringBuilder s = new StringBuilder();
		s.append(name);
		s.append("{");
		for (int i = 0; i < partNames.length; i++) {
			if (i != 0) {
				s.append(",");
			}
			s.append(partNames[i]);
			s.append(":");
			s.append(partTypeIds[i]);
		}
		s.append("}");
		String string2 = s.toString();
		assert string2 != null;
		return string2;
	}
	
	@Override
	public @NonNull String getMetaTypeName() {
		return TUPLE_TYPE_NAME;
	}

	public @NonNull String getName() {
		return name;
	}
	
	public @NonNull String[] getPartNames() {
		return partNames;
	}
	
	public @NonNull TypeId[] getPartTypeIds() {
		return partTypeIds;
	}

	@Override
	public final int hashCode() {
		return hashCode;
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
			if (!this.partTypeIds[i].equals(thatPart.getType().getTypeId())) {
				return false;
			}
			if (!this.partNames[i].equals(thatPart.getName())) {
				return false;
			}
		}
		return true;
	}
}