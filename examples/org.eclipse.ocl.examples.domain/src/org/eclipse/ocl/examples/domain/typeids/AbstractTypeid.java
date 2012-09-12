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
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainTypeParameters;

/**
 * A NsURITypeid provides a unique identifier for a 'conceptual' type or package which has an nsURI. In practice this is usually a package.
 */
abstract class AbstractTypeid implements Typeid
{
	protected final int hashCode;

	AbstractTypeid(int hashCode) {
		this.hashCode = hashCode;
	}

	@Override
	public final boolean equals(Object that) {
		return this == that;
	}
	
	public @NonNull Typeid getCollectedTypeid(@NonNull Typeid elementTypeid) {
    	throw new UnsupportedOperationException();		// Only CollectionTypeids may be collected.
    }
	
    public @NonNull Typeid getNestedTypeid(@NonNull String name) {
    	throw new UnsupportedOperationException();		// Only NestableTypeids may nest.
    }

    public @NonNull Typeid getOperationTypeid(@NonNull DomainOperation anOperation) {
    	throw new UnsupportedOperationException();		// Only NestableTypeids may nest.
    }
	
    public @NonNull Typeid getParameterTypeid(@NonNull String name) {
    	throw new UnsupportedOperationException();		// Only NestableTypeids may be parameterized.
    }
    
	public @NonNull Typeid getSpecializedTypeid(@NonNull DomainTypeParameters typeParameters) {
    	throw new UnsupportedOperationException();		// Only NestableTypeids may specialize.
    }

	@Override
	public final int hashCode() {
		return hashCode;
	}
}