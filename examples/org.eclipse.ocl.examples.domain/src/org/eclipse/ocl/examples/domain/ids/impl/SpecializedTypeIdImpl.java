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
import org.eclipse.ocl.examples.domain.elements.DomainTypeParameters;
import org.eclipse.ocl.examples.domain.ids.IdVisitor;
import org.eclipse.ocl.examples.domain.ids.SpecializedTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;

public class SpecializedTypeIdImpl extends NestableId implements SpecializedTypeId
{
	protected final @NonNull TypeId parent;
	protected final @NonNull DomainTypeParameters typeParameters;

	public SpecializedTypeIdImpl(@NonNull TypeId parent, @NonNull DomainTypeParameters typeParameters) {
		super(97 * parent.hashCode() + typeParameters.hashCode());
		this.parent = parent;
		this.typeParameters = typeParameters;
	}

	public @Nullable <R> R accept(@NonNull IdVisitor<R> visitor) {
		return visitor.visitSpecializedTypeId(this);
	}

	public @NonNull String getDisplayName() {
		return parent + "::" + typeParameters;
	}
}