/**
 * <copyright>
 *
 * Copyright (c) 2009, 2013 E.D.Willink and others.
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
 * $Id: LibraryBinaryOperation.java,v 1.3 2011/02/21 08:37:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.domain.library;

import org.eclipse.jdt.annotation.Nullable;

/**
 * LibrarySimpleBinaryOperation extends the invocation API of a binary operation to support using just
 * <br>
 * arguments.
 */
public interface LibrarySimpleBinaryOperation extends LibraryUntypedBinaryOperation, LibrarySimpleOperation
{
	@Nullable Object evaluate(@Nullable Object sourceValue, @Nullable Object argumentValue);
}
