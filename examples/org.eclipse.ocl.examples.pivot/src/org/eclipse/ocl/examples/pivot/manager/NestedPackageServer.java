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
 *
 * $Id$
 */
package org.eclipse.ocl.examples.pivot.manager;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * A RootPackageServer adapts the primary nested Package to coordinate the coherent behavior of a primary and one or more
 * secondary Packages as required for Complete OCL package extension.
 */
public class NestedPackageServer extends PackageServer
{	
	private final @NonNull PackageServer parentPackageServer;
	
	public NestedPackageServer(@NonNull PackageServer parentPackageServer, @NonNull String name, @Nullable String nsURI) {
		super(parentPackageServer.getPackageManager(), name, nsURI);
		this.parentPackageServer = parentPackageServer;
	}

	@Override
	public void dispose() {
		super.dispose();
		parentPackageServer.disposedPackageServer(this);
	}
}