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
import org.eclipse.ocl.examples.domain.ids.ClassId;
import org.eclipse.ocl.examples.domain.ids.IdVisitor;
import org.eclipse.ocl.examples.domain.ids.PackageId;
import org.eclipse.ocl.examples.domain.ids.TypeId;

public class GeneralizedClassIdImpl extends GeneralizedNestedTypeIdImpl implements ClassId
{
	public GeneralizedClassIdImpl(@NonNull PackageId parent, int templateParameters, @NonNull String name) {
		super(parent, templateParameters, name);
	}

	public @Nullable <R> R accept(@NonNull IdVisitor<R> visitor) {
		return visitor.visitClassId(this);
	}

	public @NonNull String getMetaTypeName() {
		return TypeId.CLASS_NAME;
	}
}