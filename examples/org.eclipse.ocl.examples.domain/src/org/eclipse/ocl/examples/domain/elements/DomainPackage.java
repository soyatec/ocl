/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
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
 * $Id$
 */
package org.eclipse.ocl.examples.domain.elements;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.typeids.Typeid;

public interface DomainPackage extends DomainNamespace
{
	/*@NonNull*/ Iterable<? extends DomainPackage>  getNestedPackage();
	/*@Nullable*/ DomainPackage getNestingPackage();
	/*@Nullable*/ String getNsPrefix();
	/*@Nullable*/ String getNsURI();
	/*@NonNull*/ Iterable<? extends DomainType> getOwnedType();
	@NonNull Typeid getTypeid();
}
