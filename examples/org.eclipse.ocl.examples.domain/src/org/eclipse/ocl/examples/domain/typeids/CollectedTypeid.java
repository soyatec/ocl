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
package org.eclipse.ocl.examples.domain.typeids;

import org.eclipse.jdt.annotation.NonNull;

/**
 * A CollectedTypeid provides a unique identifier for a specialized 'conceptual' colection type.
 */
class CollectedTypeid extends AbstractTypeid
{
	protected final @NonNull Typeid parent;
	protected final @NonNull Typeid elementTypeid;

	CollectedTypeid(@NonNull Typeid parent, @NonNull Typeid elementTypeid) {
		super(83 * parent.hashCode() + elementTypeid.hashCode());
		this.parent = parent;
		this.elementTypeid = elementTypeid;
	}
	
	@Override
	public String toString() {
		return parent + "(" + elementTypeid + ")";
	}
}