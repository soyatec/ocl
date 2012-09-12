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
import org.eclipse.ocl.examples.domain.elements.DomainTypeParameters;

/**
 * A SpecializedTypeid provides a unique identifier for a specialized 'conceptual' type or package.
 */
class SpecializedTypeid extends NestableTypeid
{
	protected final @NonNull Typeid parent;
	protected final @NonNull DomainTypeParameters typeParameters;

	SpecializedTypeid(@NonNull Typeid parent, @NonNull DomainTypeParameters typeParameters) {
		super(97 * parent.hashCode() + typeParameters.hashCode());
		this.parent = parent;
		this.typeParameters = typeParameters;
	}
	
	@Override
	public String toString() {
		return parent + "::" + typeParameters;
	}
}