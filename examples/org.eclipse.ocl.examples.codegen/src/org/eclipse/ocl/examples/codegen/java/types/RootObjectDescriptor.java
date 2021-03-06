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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.generator.TypeDescriptor;
import org.eclipse.ocl.examples.codegen.java.JavaStream;
import org.eclipse.ocl.examples.domain.ids.ElementId;

/**
 * A RootObjectDescriptor describes the java.lang.Object type when that is precisely the type in use, as opposed to the usage of Object as the pragmatic
 * usage when a Java class cannot be determined.
 */
public class RootObjectDescriptor extends AbstractDescriptor implements SimpleDescriptor
{
	public RootObjectDescriptor(@NonNull ElementId elementId) {
		super(elementId);
	}

	@Override
	public void append(@NonNull JavaStream javaStream) {
		javaStream.appendClassReference(Object.class);
	}

	@Override
	@SuppressWarnings("null")
	public @NonNull String getClassName() {
		return Object.class.getName();
	}

	@Override
	public @NonNull Class<?> getJavaClass() {
		return Object.class;
	}

	@Override
	public @NonNull UnboxedDescriptor getUnboxedDescriptor() {
		return this;
	}

	@Override
	public @Nullable Class<?> hasJavaClass() {
		return Object.class;
	}

	@Override
	public boolean isAssignableFrom(@NonNull TypeDescriptor typeDescriptor) {
		return true;
	}
}