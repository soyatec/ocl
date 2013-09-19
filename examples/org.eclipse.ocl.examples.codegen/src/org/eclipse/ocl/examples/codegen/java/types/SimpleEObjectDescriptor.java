/**
 * <copyright>
 * 
 * Copyright (c) 2013 CEA LIST and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink(CEA LIST) - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.ocl.examples.codegen.java.types;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.ids.ElementId;

/**
 * A SimpleEObjectDescriptor describes a data type whose boxed and unboxed representations are the same. It has a pivot ElementId, a Java class name and an EClass.
 * <p>
 * This descriptor is appropriate for most Ecore types.
 */
public class SimpleEObjectDescriptor extends SimpleValueDescriptor implements SimpleDescriptor
{
	protected final @NonNull EClass eClass;
	
	public SimpleEObjectDescriptor(@NonNull ElementId elementId, @NonNull Class<?> javaClass, @NonNull EClass eClass) {
		super(elementId, reClass(javaClass));
		this.eClass = eClass;
	}

	@Override
	public @NonNull EClassifier getEClassifier() {
		return eClass;
	}
}