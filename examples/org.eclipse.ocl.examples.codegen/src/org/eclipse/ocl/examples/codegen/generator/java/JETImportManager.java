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
package org.eclipse.ocl.examples.codegen.generator.java;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.generator.ImportManager;

public class JETImportManager implements ImportManager
{
	public JETImportManager() {}
	
	@SuppressWarnings("null")
	public @NonNull Collection<String> getAllImports() {
		return Collections.emptyList();
	}
	
	public @NonNull String getImportedClass(@NonNull String qualifiedClassName) {
		return qualifiedClassName;
	}
	
	@SuppressWarnings("null")
	public @NonNull String getImportedName(@NonNull Class<?> className, boolean isAnnotation) {
		if (isAnnotation) {
			return getImportedName("@" + className.getSimpleName());			// FIXME use full name
		}
		else {
			return getImportedName(className.getName().replace('$', '.'));
		}
	}
	
	public @NonNull String getImportedName(@NonNull String className) {
		if (className.startsWith("@")) {
			return "@<%" + className.substring(1) + "%>";
		}
		else {
			return "<%" + className + "%>";
		}
	}
}
