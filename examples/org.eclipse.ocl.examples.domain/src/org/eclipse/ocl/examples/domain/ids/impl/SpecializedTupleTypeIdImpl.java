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
import org.eclipse.ocl.examples.domain.ids.TuplePartId;
import org.eclipse.ocl.examples.domain.ids.TupleTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;

public class SpecializedTupleTypeIdImpl extends AbstractSpecializedIdImpl<TupleTypeId> implements TupleTypeId
{
	protected final @NonNull TuplePartId[] partIds;

	public SpecializedTupleTypeIdImpl(@NonNull TupleTypeId generalizedId, @NonNull TemplateBindings templateBindings) {
		super(generalizedId, templateBindings);
		TuplePartId[] generalizedPartIds = generalizedId.getPartIds();
		this.partIds = new TuplePartId[generalizedPartIds.length];
		for (int i = 0; i < generalizedPartIds.length; i++) {
			TuplePartId generalizedPartId = generalizedPartIds[i];
			TypeId generalizedTypeId = generalizedPartId.getTypeId();
			TypeId specializedTypeId = generalizedTypeId.specialize(templateBindings);
			TuplePartId specializedPartId = new TuplePartIdImpl(generalizedPartId.getName(), specializedTypeId);
			specializedPartId.install(this, i);
			partIds[i] = specializedPartId;
		}
	}

	public @Nullable <R> R accept(@NonNull IdVisitor<R> visitor) {
		return visitor.visitTupleTypeId(this);
	}

	@Override
	protected @NonNull TupleTypeId createSpecializedId(@NonNull TemplateBindings templateBindings) {
		return new SpecializedTupleTypeIdImpl(this, templateBindings);
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

    public @NonNull TupleTypeId specialize(@NonNull TemplateBindings templateBindings) {
    	return createSpecializedId(templateBindings);
	}
}