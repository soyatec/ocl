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
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.ids.TypeTemplateParameterId;

public class TypeTemplateParameterIdImpl extends AbstractTypeId implements TypeTemplateParameterId
{
	protected final @NonNull TypeId parent;
	protected final int index;
	protected final int hashCode;

	TypeTemplateParameterIdImpl(@NonNull TypeId parent, int index) {
		this.parent = parent;
		this.index = index;
		this.hashCode = 67 * parent.hashCode() + index;
	}

	public @Nullable <R> R accept(@NonNull IdVisitor<R> visitor) {
		return visitor.visitTypeTemplateParameterId(this);
	}

	public @NonNull String getDisplayName() {
		return parent + "::" + index;
	}

	public int getIndex() {
		return index;
	}

	public @NonNull TypeId getParent() {
		return parent;
	}

	@Override
	public final int hashCode() {
		return hashCode;
	}
}