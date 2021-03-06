/**
 * <copyright>
 *
 * Copyright (c) 2012, 2013 E.D.Willink and others.
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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * A TupleTypeid provides a unique hierarchical identifier a Tuple such as Tuple{first:String,second:Integer}.
 */
public interface TupleTypeId extends TypeId
{
	@NonNull String getName();
	@Nullable TuplePartId getPartId(@NonNull String name);
	@NonNull TuplePartId[] getPartIds();
}