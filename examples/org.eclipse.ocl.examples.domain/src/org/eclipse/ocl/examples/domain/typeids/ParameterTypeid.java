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
 * A ParameterTypeid provides a unique identifier for a 'conceptual' type parameter such as Set.T.
 */
class ParameterTypeid extends AbstractTypeid
{
	protected final @NonNull Typeid parent;
	protected final @NonNull String name;

	ParameterTypeid(@NonNull Typeid parent, @NonNull String name) {
		super(67 * parent.hashCode() + name.hashCode());
		this.parent = parent;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return parent + "::" + name;
	}
}