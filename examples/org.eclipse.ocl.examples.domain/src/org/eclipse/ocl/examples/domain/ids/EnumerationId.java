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
 * A EnumerationId provides a unique hierarchical for an enumeration which may have many 'actual' type variants.
 */
public interface EnumerationId extends TypeId
{
	/**
     * Return the typeId for anEnumerationLiteral of this typeId.
	 * <p>
	 * Throws UnsupportedException for typeIds such as Primitive Types that may not have enumeration literals.
     */
	@NonNull EnumerationLiteralId getEnumerationLiteralId(@NonNull String name);
}