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
package org.eclipse.ocl.examples.domain.ids;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An NsURIPackageId provides a unique hierarchical identifier for a package which has an nsURI.
 */
public interface NsURIPackageId extends PackageId
{
	@Nullable EPackage getEPackage();
	@Nullable String getNsPrefix();
	@NonNull String getNsURI();
	void setEPackage(@NonNull EPackage ePackage);
}