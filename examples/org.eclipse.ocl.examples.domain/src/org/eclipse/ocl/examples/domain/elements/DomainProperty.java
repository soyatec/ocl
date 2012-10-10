/**
 * <copyright>
 *
 * Copyright (c) 2011,2012 E.D.Willink and others.
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
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.values.ObjectValue;

public interface DomainProperty extends DomainFeature
{
	/**
	 * Return the Inheritance dispatch table for the owning type, or null for an orphan property owned by an Annotation.
	 */
	@Nullable DomainInheritance getInheritance(@NonNull DomainStandardLibrary standardLibrary);

	/**
	 * Return the opposite Property if there is one, else null.
	 */
	/*@NonNull*/ DomainProperty getOpposite();
	
	void setValue(@NonNull DomainStandardLibrary standardLibrary, @NonNull ObjectValue objectValue, @Nullable Object propertyValue);
}
