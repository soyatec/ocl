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
import org.eclipse.ocl.examples.domain.elements.DomainParameterTypes;
import org.eclipse.ocl.examples.domain.elements.DomainTemplateParameter;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.IdVisitor;
import org.eclipse.ocl.examples.domain.ids.TemplateBinding;
import org.eclipse.ocl.examples.domain.ids.TemplateBindings;
import org.eclipse.ocl.examples.domain.ids.TemplateParameterId;
import org.eclipse.ocl.examples.domain.ids.TypeId;

public class GeneralizedCollectionTypeIdImpl extends GeneralizedTypeIdImpl<CollectionTypeId> implements CollectionTypeId
{
	protected final @NonNull TypeId elementTypeId;
	
	/**
	 * Map from the operation hashCode to the operationIds with the same hash. 
	 */
	private @Nullable WeakHashMapOfListOfWeakReference3<Integer, String, DomainParameterTypes, GeneralizedOperationIdImpl> memberOperations = null;

	public GeneralizedCollectionTypeIdImpl(@NonNull TemplateParameterId[] templateParameters, @NonNull String name, @NonNull TypeId elementTypeId) {
		super(77 * name.hashCode() + elementTypeId.hashCode(), templateParameters, name);
		this.elementTypeId = elementTypeId;
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
		return getGeneralizedId();
	}

	public @NonNull String getDisplayName() {
		return name;
	}

	public @NonNull TypeId getElementTypeId() {
		return elementTypeId;
	}

	public @NonNull CollectionTypeId getGeneralizedId() {
		return this;
	}

	public @NonNull String getMetaTypeName() {
		return name + "Type";
	}

	@Override
	public void resolveTemplateBindings(@NonNull Map<DomainTemplateParameter, List<TemplateBinding>> bindings) {
		elementTypeId.resolveTemplateBindings(bindings);
	}

    public @NonNull CollectionTypeId specialize(@NonNull TemplateBindings templateBindings) {
    	return createSpecializedId(templateBindings);
	}
}