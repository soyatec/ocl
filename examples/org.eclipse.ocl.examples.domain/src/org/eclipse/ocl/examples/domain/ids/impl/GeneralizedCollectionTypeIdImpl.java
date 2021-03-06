/**
 * <copyright>
 *
 * Copyright (c) 2012, 2013 E.D.Willink and others.
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
import org.eclipse.ocl.examples.domain.ids.BindingsId;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.IdHash;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.IdVisitor;
import org.eclipse.ocl.examples.domain.ids.TemplateParameterId;
import org.eclipse.ocl.examples.domain.ids.TypeId;

public class GeneralizedCollectionTypeIdImpl extends GeneralizedTypeIdImpl<CollectionTypeId> implements CollectionTypeId
{
	public GeneralizedCollectionTypeIdImpl(@NonNull IdManager idManager, @NonNull String name) {
		super(IdHash.createGlobalHash(CollectionTypeId.class, name), 1, name);
	}

	public @Nullable <R> R accept(@NonNull IdVisitor<R> visitor) {
		return visitor.visitCollectionTypeId(this);
	}

	@Override
	protected @NonNull CollectionTypeId createSpecializedId(@NonNull BindingsId templateBindings) {
		return new SpecializedCollectionTypeIdImpl(this, templateBindings);
	}

	public @NonNull String getDisplayName() {
		return name;
	}

	public @NonNull TemplateParameterId getElementTypeId() {
		return TypeId.T_1;
	}

	public @NonNull CollectionTypeId getGeneralizedId() {
		return this;
	}

	@Override
	public @Nullable String getLiteralName() {
		if (this == TypeId.BAG) {
			return "BAG";
		}
		else if (this == TypeId.COLLECTION) {
			return "COLLECTION";
		}
		else if (this == TypeId.ORDERED_SET) {
			return "ORDERED_SET";
		}
		else if (this == TypeId.SEQUENCE) {
			return "SEQUENCE";
		}
		else if (this == TypeId.SET) {
			return "SET";
		}
		else if (this == TypeId.UNIQUE_COLLECTION) {
			return "UNIQUE_COLLECTION";
		}
		else {
			return null;
		}
	}

	public @NonNull String getMetaTypeName() {
		return name + "Type";
	}

    public @NonNull CollectionTypeId specialize(@NonNull BindingsId templateBindings) {
    	return getSpecializedId(templateBindings);
	}
}