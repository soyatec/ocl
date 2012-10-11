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
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainTemplateParameter;
import org.eclipse.ocl.examples.domain.ids.IdVisitor;
import org.eclipse.ocl.examples.domain.ids.TemplateBinding;
import org.eclipse.ocl.examples.domain.ids.TuplePartId;
import org.eclipse.ocl.examples.domain.ids.TupleTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;

public class TuplePartIdImpl implements TuplePartId
{
	protected final @NonNull String name;
	protected final @NonNull TypeId typeId;
	private @Nullable TupleTypeId parent;
	private int index;							
	private int hashCode;							
	
	public TuplePartIdImpl(@NonNull String name, @NonNull TypeId typeId) {
		this.parent = null;
		this.index = -1;
		this.name = name;
		this.typeId = typeId;
		this.hashCode = name.hashCode() + 7 * typeId.hashCode();
	}

	public @Nullable <R> R accept(@NonNull IdVisitor<R> visitor) {
		return visitor.visitTuplePartId(this);
	}

	public int compareTo(TuplePartId o) {
		String n1 = name;
		String n2 = o.getName();
		if (n1 == n2) {
			return 0;
		}
		return n1.compareTo(n2);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (hashCode != obj.hashCode()) {
			return false;
		}
		if (!(obj instanceof TuplePartId)) {
			return false;
		}
		TuplePartId that = (TuplePartId)obj;
		if (!name.equals(that.getName())) {
			return false;
		}
		if (typeId != that.getTypeId()) {
			return false;
		}
		return true;
	}

	public @NonNull String getDisplayName() {
		return String.valueOf(name) + " : " + String.valueOf(typeId);
	}

	public int getIndex() {
		return index;
	}

	public @NonNull String getName() {
		return name;
	}

	public @NonNull TypeId getTypeId() {
		return typeId;
	}
	
	@Override
	public int hashCode() {
		return hashCode;
	}

	public void install(@NonNull TupleTypeId tupleTypeId, int index) {
		assert parent == null;
		this.parent = tupleTypeId;
		this.index = index;
	}

	public void resolveTemplateBindings(@NonNull Map<DomainTemplateParameter, List<TemplateBinding>> bindings) {
		typeId.resolveTemplateBindings(bindings);
	}

	@Override
	public String toString() {
		return String.valueOf(name) + " : " + String.valueOf(typeId);
	}
}