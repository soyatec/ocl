/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.ocl.examples.library.executor;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.domain.typeids.Typeid;

public abstract class ExecutorPackage implements DomainPackage
{
	protected final @NonNull String name;
	protected final @Nullable String nsPrefix;
	protected final @Nullable String nsURI;
	protected final @NonNull Typeid typeid;

	protected ExecutorPackage(@NonNull String name, @Nullable String nsPrefix, @Nullable String nsURI, @NonNull Typeid typeid) {
		this.name = name;
		this.nsPrefix = nsPrefix;
		this.nsURI = nsURI;
		this.typeid = typeid;
	}

	public final @NonNull String getName() {
		return name;
	}

	public final @Nullable String getNsPrefix() {
		return nsPrefix;
	}

	public final @Nullable String getNsURI() {
		return nsURI;
	}

	public @NonNull Typeid getTypeid() {
		return typeid;
	}

	@Override
	public String toString() {
		return name;
	}
}