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
import java.util.HashSet;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.generator.ImportManager;

public class JavaImportManager implements ImportManager
{
	/*
	 * Map of partial classnames to the required import name, or to null if the partial name is ambiguous.
	 */
	private final Map<String, String> known2import = new HashMap<String, String>();
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
		for (Class<?> knownClass : knownClasses) {
			String fullyQualifiedClassName = knownClass.getName();
//			int dollarIndex = fullyQualifiedClassName.lastIndexOf("$");
//			String partiallyQualifiedClassName = dollarIndex >= 0 ? fullyQualifiedClassName.substring(0, dollarIndex) : null;
//			String unqualifiedClassName = fullyQualifiedClassName.substring(fullyQualifiedClassName.lastIndexOf(".")+1);
			String simpleClassName = knownClass.getSimpleName();

			if (!known2import.containsKey(simpleClassName)) {
				known2import.put(simpleClassName, fullyQualifiedClassName);
			}
			else {
				known2import.put(simpleClassName, null);
			}
//			if (!known2import.containsKey(unqualifiedClassName)) {
//				known2import.put(unqualifiedClassName, partiallyQualifiedClassName);
//			}
//			else {
//				known2import.put(unqualifiedClassName, null);
//			}
			
			
/*			known2import.put(fullyQualifiedClassName, fullyQualifiedClassName.replace('$', '.'));
			//
			String lastSegment = fullyQualifiedClassName.substring(fullyQualifiedClassName.lastIndexOf(".")+1);
			if (known2import.containsKey(lastSegment)) {
				known2import.put(fullyQualifiedClassName, null);
				known2import.put(lastSegment, null);
			}
			else {
				known2import.put(lastSegment, fullyQualifiedClassName);
			}
			String simpleKey = knownClass.getSimpleName();
			if (known2import.containsKey(simpleKey)) {
				known2import.put(fullyQualifiedClassName, null);
//				known2external.put(lastSegment, null);
				known2import.put(simpleKey, null);
			}
			else {
				known2import.put(simpleKey, fullyQualifiedClassName);
			} */
		}
	}

	protected void addImport(@NonNull String fullyQualifiedClassName) {
		if (fullyQualifiedClassName.contains("$")) {
			System.out.println(fullyQualifiedClassName);
		}
		else if (fullyQualifiedClassName.endsWith("Accumulator")) {
			System.out.println(fullyQualifiedClassName);
		}
		int dollarIndex = fullyQualifiedClassName.lastIndexOf("$");
		String partiallyQualifiedClassName = dollarIndex >= 0 ? fullyQualifiedClassName.substring(0, dollarIndex) : null;
		String unqualifiedClassName = fullyQualifiedClassName.substring(fullyQualifiedClassName.lastIndexOf(".")+1);

		String fullyQualifiedImportName = dollarIndex >= 0 ? fullyQualifiedClassName.substring(0, dollarIndex) : fullyQualifiedClassName;
		
		String lastSegment = unqualifiedClassName;
		
		
//		String dollarFree = fullyQualifiedClassName.replace('$', '.');
//		String lastSegment = fullyQualifiedClassName.substring(dollarFree.lastIndexOf(".")+1);
		String knownImport = known2import.get(fullyQualifiedClassName);
		if (knownImport != null) {
			if (knownImport.equals(fullyQualifiedClassName) || lastSegment.equals(fullyQualifiedClassName)) {
				internal2external.put(lastSegment, knownImport.replace('$', '.'));
				external2internal.put(knownImport.replace('$', '.'), lastSegment);
				external2internal.put(lastSegment, lastSegment);
			}
			else {
				external2internal.put(fullyQualifiedClassName, fullyQualifiedClassName);
			}
		}
		else if (known2import.containsKey(fullyQualifiedClassName)) {
			external2internal.put(fullyQualifiedClassName, fullyQualifiedClassName);
		}
		else {
			if (!internal2external.containsKey(lastSegment)) {
				internal2external.put(lastSegment, partiallyQualifiedClassName);
				external2internal.put(fullyQualifiedClassName, lastSegment);
			}
			else {
				String oldExternal = internal2external.get(lastSegment);
				if (oldExternal != null) {
					external2internal.put(oldExternal, oldExternal);
					internal2external.put(lastSegment, null);
				}
				external2internal.put(fullyQualifiedClassName, fullyQualifiedClassName);
			}
		}
	}
	
	@SuppressWarnings("null")
	public @NonNull Collection<String> getAllImports() {
		return new HashSet<String>(internal2external.values());
	}
	
	public @NonNull String getImportedClass(@NonNull String qualifiedClassName) {
		if (qualifiedClassName.startsWith("@")) {
			qualifiedClassName = qualifiedClassName.substring(1);
		}
		int dollarIndex = qualifiedClassName.lastIndexOf("$");
		String partiallyQualifiedClassName = dollarIndex >= 0 ? qualifiedClassName.substring(0, dollarIndex) : qualifiedClassName;
		return partiallyQualifiedClassName;
	}
	
	@SuppressWarnings("null")
	public @NonNull String getImportedName(@NonNull Class<?> className, boolean isAnnotation) {
		if (isAnnotation) {
			return getImportedName("@" + className.getSimpleName());			// FIXME use full name
		}
		else {
			return getImportedName(className.getName()/*.replace('$', '.')*/);
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
			return "@" + (known != null ? known : actualClassName).replace('$', '.');
		}
		else {
			String known = external2internal.get(className);
			if (known == null) {
				addImport(className);
				known = external2internal.get(className);
			}
			return (known != null ? known : className).replace('$', '.');
		}
	}
}
