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
import org.eclipse.ocl.examples.domain.ids.OclVoidTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.ids.TypeTemplateParameterId;

public class OclVoidTypeIdImpl extends UnscopedId implements OclVoidTypeId
{
	public OclVoidTypeIdImpl(@NonNull String name) {
		super(name);
	}

	public @Nullable <R> R accept(@NonNull IdVisitor<R> visitor) {
		return visitor.visitNullId(this);
	}

	public @NonNull CollectionTypeId getCollectedTypeId() {
		return this;
	}

	public @NonNull CollectedTypeId getCollectedTypeId(@NonNull TypeId elementTypeId) {
		return this;
	}

	public @NonNull CollectionTypeId getCollectionTypeId() {
		return this;
	}

	public @NonNull TypeTemplateParameterId getElementTypeId() {
		return this;
	}

	public int getIndex() {
		return 0;
	}

	@Override
	public @NonNull String getMetaTypeName() {
		return "VoidType";
	}

	public @NonNull TypeId getParent() {
		return this;									// FIXME Is this safe?
	}

	public @NonNull String[] getPartNames() {
		return NULL_STRING_ARRAY;
	}

	public @NonNull TypeId[] getPartTypeIds() {
		return NULL_TYPE_ID_ARRAY;
	}
}