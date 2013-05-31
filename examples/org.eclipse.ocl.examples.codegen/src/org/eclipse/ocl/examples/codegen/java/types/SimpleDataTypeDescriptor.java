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

public class SimpleDataTypeDescriptor extends AbstractDescriptor implements SimpleDescriptor
{
	private static class NamedFuture {}
	
	protected final @NonNull String className;
	
	public SimpleDataTypeDescriptor(@NonNull ElementId elementId, @NonNull String className) {
		super(elementId);
		this.className = className;
	}

	public void append(@NonNull JavaStream javaStream) {
		javaStream.appendClassReference(className);
	}

	public @NonNull Class<?> getJavaClass() {
		return NamedFuture.class;
	}

	@NonNull
	public String getClassName() {
		return className;
	}

	public @Nullable Class<?> hasJavaClass() {
		return null;
	}

	public final boolean isAssignableFrom(@NonNull TypeDescriptor typeDescriptor) {
		return typeDescriptor == this;
	}
}