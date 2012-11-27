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
import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.generator.ImportManager;

public class JavaImportManager implements ImportManager
{
	private Map<String, Class<?>> known2external = null;
	/*
	 * Map of full external name to short internal name. The short internal name is the full name if
	 * there is any ambiguity.
	 */
	private @NonNull Map<String, String> external2internal = new HashMap<String, String>();
	/*
	 * Map of short internal name to full external name or null if there is an ambiguity.
	 */
	private @NonNull Map<String, String> internal2external = new HashMap<String, String>();

	public JavaImportManager(@NonNull Class<?>[] knownClasses) {
		known2external = new HashMap<String, Class<?>>();
		for (Class<?> knownClass : knownClasses) {
			known2external.put(knownClass.getName().replace('$', '.'), knownClass);
			known2external.put(knownClass.getSimpleName(), knownClass);
		}
	}

	protected void addImport(@NonNull String importedClassName) {
		String lastSegment = importedClassName.substring(importedClassName.lastIndexOf(".")+1);
		Class<?> knownClass = known2external.get(importedClassName);
		if (knownClass != null) {
			if (knownClass.getName().replace('$', '.').equals(importedClassName) || lastSegment.equals(importedClassName)) {
				internal2external.put(lastSegment, knownClass.getName().replace('$', '.'));
				external2internal.put(knownClass.getName().replace('$', '.'), lastSegment);
				external2internal.put(lastSegment, lastSegment);
			}
			else {
				external2internal.put(importedClassName, importedClassName);
			}
		}
		else {
			if (!internal2external.containsKey(lastSegment)) {
				internal2external.put(lastSegment, importedClassName);
				external2internal.put(importedClassName, lastSegment);
			}
			else {
				String oldExternal = internal2external.get(lastSegment);
				if (oldExternal != null) {
					external2internal.put(oldExternal, oldExternal);
					internal2external.put(lastSegment, null);
				}
				external2internal.put(importedClassName, importedClassName);
			}
		}
	}
	
	@SuppressWarnings("null")
	public @NonNull Collection<String> getAllImports() {
		return internal2external.values();
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
			String actualClassName = className.substring(1);
			assert actualClassName != null;
			String known = external2internal.get(actualClassName);
			if (known == null) {
				addImport(actualClassName);
				known = external2internal.get(actualClassName);
			}
			return "@" + (known != null ? known : actualClassName);
		}
		else {
			String known = external2internal.get(className);
			if (known == null) {
				addImport(className);
				known = external2internal.get(className);
			}
			return known != null ? known : className;
		}
	}
}
