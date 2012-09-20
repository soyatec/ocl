/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D.Willink and others.
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
package org.eclipse.ocl.examples.library.executor;

import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainEnumeration;
import org.eclipse.ocl.examples.domain.elements.DomainEnumerationLiteral;

public class ExecutorEnumerationLiteral implements DomainEnumerationLiteral
{
	protected final @NonNull String name;
	protected final @NonNull DomainEnumeration enumeration;
	protected final int ordinal;
	
	public ExecutorEnumerationLiteral(@NonNull String name, @NonNull DomainEnumeration enumeration, int ordinal) {
		this.name = name;
		this.enumeration = enumeration;
		this.ordinal = ordinal;
	}

	public EEnumLiteral asEcoreObject() {
		throw new UnsupportedOperationException();
//		return this;
	}

	public @NonNull DomainEnumeration getEnumeration() {
		return enumeration;
	}

	public @NonNull String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return String.valueOf(enumeration) + "::" + String.valueOf(name); //$NON-NLS-1$
	}

	public EEnumLiteral getEEnumLiteral() {
		// TODO Auto-generated method stub
		return null;
	}
}