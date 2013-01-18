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
package org.eclipse.ocl.examples.codegen.generator;

import java.util.Collection;

import org.eclipse.jdt.annotation.NonNull;

public interface ImportManager
{	
	@NonNull Collection<String> getAllImports();	
	@NonNull String getImportedClass(@NonNull String qualifiedClassName);
	@NonNull String getImportedName(@NonNull Class<?> className, boolean isAnnotation);
	@NonNull String getImportedName(@NonNull String qualifiedClassName);
}
