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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.IdVisitor;
import org.eclipse.ocl.examples.domain.ids.TemplateBindings;
import org.eclipse.ocl.examples.domain.ids.TemplateParameterId;
import org.eclipse.ocl.examples.domain.ids.TuplePartId;
import org.eclipse.ocl.examples.domain.ids.TupleTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;

public class GeneralizedTupleTypeIdImpl extends AbstractGeneralizedIdImpl<TupleTypeId> implements TupleTypeId, WeakHashMapOfListOfWeakReference3.MatchableId<String, TuplePartId[]>
{
	protected final @NonNull TuplePartId[] partIds;
	
	public GeneralizedTupleTypeIdImpl(@NonNull Integer hashCode, @NonNull TemplateParameterId[] templateParameters, @NonNull String name, @NonNull TuplePartId[] orderedPartIds) {
		super(hashCode, templateParameters, name);
		this.partIds = orderedPartIds;
		assert partsAreOrdered();
		for (int i = 0; i < partIds.length; i++) {
			partIds[i].install(this, i);
		}
	}

	public @Nullable <R> R accept(@NonNull IdVisitor<R> visitor) {
		return visitor.visitTupleTypeId(this);
	}

	@Override
	protected @NonNull TupleTypeId createSpecializedId(@NonNull TemplateBindings templateBindings) {
		return new SpecializedTupleTypeIdImpl(this, templateBindings);
	}
	
	public @NonNull String getDisplayName() {
		StringBuilder s = new StringBuilder();
		s.append(name);
		s.append("{");
		boolean isFirst = true;
		for (TuplePartId partId : partIds) {
			if (!isFirst) {
				s.append(", ");
			}
			s.append(partId.getDisplayName());
			isFirst = false;
		}
		s.append("}");
		String string2 = s.toString();
		assert string2 != null;
		return string2;
	}

	public @NonNull TupleTypeId getGeneralizedId() {
		return this;
	}
	
	public @NonNull String getMetaTypeName() {
		return TUPLE_TYPE_NAME;
	}

	public TuplePartId getPartId(@NonNull String name) {
		for (TuplePartId partId : partIds) {
			if (name.equals(partId.getName())) {
				return partId;
			}
		}
		return null;
	}
	
	public @NonNull TuplePartId[] getPartIds() {
		return partIds;
	}

	public boolean matches(@NonNull String thatName, @NonNull TuplePartId[] thoseOrderedParts) {
		if (!this.name.equals(thatName)) {
			return false;
		}
		for (int i = 0; i < partIds.length; i++) {
			if (!partIds[i].equals(thoseOrderedParts[i])) {
				return false;
			}
		}
		return true;
	}

	private boolean partsAreOrdered() {
		for (int i = 0; i < partIds.length-1; i++) {
			TuplePartId earlierPartId = partIds[i];
			TuplePartId laterPartId = partIds[i+1];
			if (earlierPartId.compareTo(laterPartId) >= 0) {
				return false;
			}
		}
		return true;
	}

    public @NonNull TupleTypeId specialize(@NonNull TemplateBindings templateBindings) {
    	return createSpecializedId(templateBindings);
	}
}