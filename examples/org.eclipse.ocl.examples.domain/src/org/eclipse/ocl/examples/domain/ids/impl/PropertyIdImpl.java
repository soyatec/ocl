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
import org.eclipse.ocl.examples.domain.ids.IdVisitor;
import org.eclipse.ocl.examples.domain.ids.PropertyId;
import org.eclipse.ocl.examples.domain.ids.TypeId;

public class PropertyIdImpl extends AbstractElementId implements PropertyId //, ElementId.Internal
{
	protected final @NonNull TypeId parentId;
	protected final @NonNull String name;
	protected final @NonNull Integer hashCode;
//	protected final @Nullable EStructuralFeature eFeature;
	

	public PropertyIdImpl(@NonNull TypeId parentId, @NonNull String name/*, @Nullable EStructuralFeature eFeature*/) {
		this.parentId = parentId;
		this.name = name;
		this.hashCode = parentId.hashCode() * 31 + name.hashCode();
//		this.eFeature = eFeature;
	}

	public @Nullable <R> R accept(@NonNull IdVisitor<R> visitor) {
		return visitor.visitPropertyId(this);
	}

	public @NonNull String getDisplayName() {
		StringBuilder s = new StringBuilder();
		s.append(parentId);
		s.append("::");
		s.append(name);
		@SuppressWarnings("null")@NonNull String string2 = s.toString();
		return string2;
	}
	
//	public @Nullable EStructuralFeature getEFeature() {
//		return eFeature;
//	}

	public @NonNull String getMetaTypeName() {
		return TypeId.PROPERTY_NAME;
	}

	public @NonNull String getName() {
		return name;
	}

	public @NonNull TypeId getParent() {
		return parentId;
	}

	@Override
	public final int hashCode() {
		return hashCode;
	}
}