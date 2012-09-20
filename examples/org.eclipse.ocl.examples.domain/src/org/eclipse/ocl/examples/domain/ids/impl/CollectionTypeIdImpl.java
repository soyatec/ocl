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
import org.eclipse.ocl.examples.domain.ids.CollectedTypeId;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.IdVisitor;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.ids.TypeTemplateParameterId;

public class CollectionTypeIdImpl extends UnscopedId implements CollectionTypeId
{
	/**
	 * Map from a parameter specialization to the corresponding CollectedTypeId. 
	 */
	private @NonNull WeakHashMapOfWeakReference<TypeId, CollectedTypeId> specializations = new WeakHashMapOfWeakReference<TypeId, CollectedTypeId>()
		{
			@Override
			protected @NonNull CollectedTypeId newTypeId(@NonNull TypeId elementTypeId) {
				return new CollectedTypeIdImpl(CollectionTypeIdImpl.this, elementTypeId);
			}
		};
	
	protected final @NonNull TypeTemplateParameterId elementTypeId;

	public CollectionTypeIdImpl(@NonNull String name) {
		super(name);
		elementTypeId = new TypeTemplateParameterIdImpl(this, 0);
	}

	public @Nullable <R> R accept(@NonNull IdVisitor<R> visitor) {
		return visitor.visitCollectionId(this);
	}

	public @NonNull CollectionTypeId getCollectedTypeId() {
    	return this;
    }

	public @NonNull CollectionTypeId getCollectionTypeId() {
		return this;
	}

	public @NonNull CollectedTypeId getCollectedTypeId(@NonNull TypeId elementTypeId) {
    	return specializations.getElementId(elementTypeId);
    }

	public @NonNull TypeTemplateParameterId getElementTypeId() {
		return elementTypeId;
	}

	@Override
	public @NonNull String getMetaTypeName() {
		return name + "Type";
	}
	
    @Override
	public @NonNull TypeTemplateParameterId getTemplateParameterId(int index) {
    	if (index == 0) {
    		return elementTypeId;
    	}
    	throw new UnsupportedOperationException();
    }
}