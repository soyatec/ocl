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
 * A NsURITypeid provides a unique identifier for a 'conceptual' type or package which has an nsURI. In practice this is usually a package.
 */
class NsURITypeid extends NestableTypeid
{
	protected final @NonNull String nsURI;

	NsURITypeid(@NonNull String nsURI) {
		super(nsURI.hashCode());
		this.nsURI = nsURI;
	}
	
	@Override
	public String toString() {
		return nsURI;
	}
}