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

public class CollectedTypeIdImpl extends FeatureableId implements CollectedTypeId
{
	protected final @NonNull CollectionTypeId collectionTypeId;
	protected final @NonNull TypeId elementTypeId;

	CollectedTypeIdImpl(@NonNull CollectionTypeId collectionTypeId, @NonNull TypeId elementTypeId) {
		super(83 * collectionTypeId.hashCode() + elementTypeId.hashCode());
		this.collectionTypeId = collectionTypeId;
		this.elementTypeId = elementTypeId;
	}

	public @Nullable <R> R accept(@NonNull IdVisitor<R> visitor) {
		return visitor.visitCollectedId(this);
	}

	public @NonNull CollectionTypeId getCollectionTypeId() {
		return collectionTypeId;
	}
	
	public @NonNull String getDisplayName() {
		return collectionTypeId + "(" + elementTypeId + ")";
	}

	public @NonNull TypeId getElementTypeId() {
		return elementTypeId;
	}

	@Override
	public @NonNull String getMetaTypeName() {
		return collectionTypeId.getMetaTypeName();
	}
}