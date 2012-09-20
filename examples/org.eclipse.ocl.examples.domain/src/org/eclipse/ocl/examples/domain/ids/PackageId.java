/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
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
package org.eclipse.ocl.examples.domain.ids;

import org.eclipse.jdt.annotation.NonNull;


/**
 * A PackageId provides a unique hierarchical identifier for a package.
 *
 * @see NestedPackageId
 * @see NsURIPackageId
 * @see RootPackageId
 */
public interface PackageId extends ElementId
{
	@NonNull PackageId getNestedPackageId(@NonNull String name);

 	/**
	 * Return the typeId for the named child of this typeId.
	 * <p>
	 * Throws UnsupportedException for typeIds such as Primitive Types that may not have nested types.
	 */
	@NonNull TypeId getNestedTypeId(@NonNull String name);
}