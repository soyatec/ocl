/**
 * <copyright>
 *
 * Copyright (c) 2011, 2013 E.D.Willink and others.
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
 	/**
	 * Return the classId for the named child of this packageId.
	 * <p>
	 * Throws UnsupportedException for typeIds such as Primitive Types that may not have nested types.
	 */
	@NonNull ClassId getClassId(@NonNull String name, int templateParameters);

 	/**
	 * Return the dataTypeId for the named child of this packageId.
	 * <p>
	 * Throws UnsupportedException for typeIds such as Primitive Types that may not have nested types.
	 */
	@NonNull DataTypeId getDataTypeId(@NonNull String name, int templateParameters);

 	/**
	 * Return the enumerationId for the named child of this packageId.
	 * <p>
	 * Throws UnsupportedException for typeIds such as Primitive Types that may not have nested types.
	 */
	@NonNull EnumerationId getEnumerationId(@NonNull String name);
	@NonNull NestedPackageId getNestedPackageId(@NonNull String name);
}