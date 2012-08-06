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
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.pivot.Type;

/**
 * The OrphanageServer ensures that orphan types have their own servers. (Numerous Collection and Tuple types have the
 * same basic name but are not the same type at all.)
 */
public class OrphanPackageServer extends RootPackageServer
{	
	public OrphanPackageServer(@NonNull PackageManager packageManager, @NonNull String name, @Nullable String nsPrefix, @Nullable String nsURI) {
		super(packageManager, name, nsPrefix, nsURI);
	}

	@Override
	@NonNull OrphanTypeServer getTypeServer(@NonNull DomainType pivotType) {
		return new OrphanTypeServer(this, (Type)pivotType);
	}
}