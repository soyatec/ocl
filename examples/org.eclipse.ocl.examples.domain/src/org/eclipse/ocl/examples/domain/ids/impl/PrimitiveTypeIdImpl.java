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
import org.eclipse.ocl.examples.domain.ids.IdVisitor;
import org.eclipse.ocl.examples.domain.ids.PrimitiveTypeId;

public class PrimitiveTypeIdImpl extends UnscopedId implements PrimitiveTypeId
{
	public PrimitiveTypeIdImpl(@NonNull String name) {
		super(name);
	}

	public @Nullable <R> R accept(@NonNull IdVisitor<R> visitor) {
		return visitor.visitPrimitiveTypeId(this);
	}

	@Override
	public @NonNull String getMetaTypeName() {
		return PRIMITIVE_TYPE_NAME;
	}
}