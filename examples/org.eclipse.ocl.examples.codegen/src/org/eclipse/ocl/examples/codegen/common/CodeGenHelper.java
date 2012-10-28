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
package org.eclipse.ocl.examples.codegen.common;

import java.io.File;

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.library.LibraryOperation;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.Type;

public interface CodeGenHelper
{
	/**
	 * Return a copyright notice using indentation to indent intermediate lines.
	 */
	@NonNull String getCopyright(@NonNull String indentation);
	
	/**
	 * Return the <%...%> escaped name for a type.
	 */
	LibraryOperation loadClass(ExpressionInOCL query, File targetFolder,
			String packageName, String className, boolean saveSource) throws Exception;
	
	/**
	 * Return the GenPackage for a type.
	 */
	@NonNull GenPackage getGenPackage(@NonNull Type type);
}
