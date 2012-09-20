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
import org.eclipse.ocl.examples.domain.ids.NsURIPackageId;

public class NsURIPackageIdImpl extends PackageIdImpl implements NsURIPackageId
{
	protected final @NonNull String nsURI;

	public NsURIPackageIdImpl(@NonNull String nsURI) {
		super(nsURI.hashCode());
		this.nsURI = nsURI;
	}

	public @Nullable <R> R accept(@NonNull IdVisitor<R> visitor) {
		return visitor.visitNsURIPackageId(this);
	}

	public @NonNull String getDisplayName() {
		return nsURI;
	}

	public @NonNull String getNsURI() {
		return nsURI;
	}
}