/**
 * <copyright>
 *
 * Copyright (c) 2009,2011 E.D.Willink and others.
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
 * $Id: AbstractFeature.java,v 1.2 2011/01/24 19:56:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.domain.library;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;

/**
 */
public abstract class AbstractFeature implements LibraryFeature
{
	public static @Nullable LibraryValidator getLibraryValidator(@NonNull Object contextObject, @NonNull String validatorClassName) {
		try {
			Class<?> validatorClass = contextObject.getClass().getClassLoader().loadClass(validatorClassName);
			return (LibraryValidator) validatorClass.newInstance();
		} catch (Exception e) {
			e.printStackTrace();		// WIP FIXME
			return null;
		}
	}
	
	public @Nullable LibraryValidator getValidator(@NonNull DomainStandardLibrary standardLibrary) {
		return null;
	}
}
