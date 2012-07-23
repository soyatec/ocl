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
import org.eclipse.ocl.examples.domain.elements.DomainPackage;

public abstract class ExecutorPackage implements DomainPackage
{
	protected final @NonNull String name;
	protected final String nsURI;

	protected ExecutorPackage(@NonNull String name, String nsURI) {
		this.name = name;
		this.nsURI = nsURI;
	}

	public final @NonNull String getName() {
		return name;
	}

	public final String getNsURI() {
		return nsURI;
	}

	@Override
	public @NonNull String toString() {
		return name;
	}
}