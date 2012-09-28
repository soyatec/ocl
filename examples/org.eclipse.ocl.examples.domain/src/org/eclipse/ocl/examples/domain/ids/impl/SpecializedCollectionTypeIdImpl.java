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
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.IdVisitor;
import org.eclipse.ocl.examples.domain.ids.TemplateBinding;
import org.eclipse.ocl.examples.domain.ids.TemplateBindings;
import org.eclipse.ocl.examples.domain.ids.TypeId;

public class SpecializedCollectionTypeIdImpl extends AbstractSpecializedIdImpl<CollectionTypeId> implements CollectionTypeId
{
	private @Nullable TypeId elementTypeId;

	public SpecializedCollectionTypeIdImpl(@NonNull CollectionTypeId generalizedId, @NonNull TemplateBindings templateBindings) {
		super(generalizedId, templateBindings);
	}

	public @Nullable <R> R accept(@NonNull IdVisitor<R> visitor) {
		return visitor.visitCollectionId(this);
	}

	@Override
	protected @NonNull CollectionTypeId createSpecializedId(@NonNull TemplateBindings templateBindings) {
		return new SpecializedCollectionTypeIdImpl(this, templateBindings);
	}

	@Deprecated
	public @NonNull CollectionTypeId getCollectionTypeId() {
		return this;
	}

	public @NonNull TypeId getElementTypeId() {
		TypeId elementTypeId2 = elementTypeId;
		if (elementTypeId2 == null) {
			elementTypeId = elementTypeId2 = generalizedId.getElementTypeId().specialize(templateBindings);
		}
		return elementTypeId2;
	}

	@Override
	public void resolveTemplateBindings(@NonNull Map<DomainTemplateParameter, List<TemplateBinding>> bindings) {
    	getElementTypeId().resolveTemplateBindings(bindings);
	}

    public @NonNull CollectionTypeId specialize(@NonNull TemplateBindings templateBindings) {
    	return createSpecializedId(templateBindings);
	}
}