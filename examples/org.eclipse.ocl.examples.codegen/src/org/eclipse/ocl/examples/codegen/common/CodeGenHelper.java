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

public class CodeGenHelper
{
	/**
	 * Return a copyright notice using indentation to indent intermediate lines.
	 */
	public static @NonNull String getCopyright(@NonNull CodeGenHelper codeGenHelper, @NonNull String indentation) {
		return codeGenHelper.getCopyright(indentation);
	}
	
	/**
	 * Return the <%...%> escaped name for a type.
	 */
	public static @NonNull String getEscapedName(@NonNull CodeGenHelper codeGenHelper, @NonNull Type type) {
		return codeGenHelper.getEscapedName(type);
	}
	
	public LibraryOperation loadClass(ExpressionInOCL query, File targetFolder,
			String packageName, String className, boolean saveSource) throws Exception {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Return the GenPackage for a type.
	 */
	public static @NonNull GenPackage getGenPackage(@NonNull CodeGenHelper codeGenHelper, @NonNull Type type) {
		return codeGenHelper.getGenPackage(type);
	}

	protected @NonNull String getCopyright(@NonNull String indentation) {
		throw new UnsupportedOperationException();
	}
	
	protected @NonNull String getEscapedName(@NonNull Type type) {
		throw new UnsupportedOperationException();
	}
	
	protected @NonNull GenPackage getGenPackage(@NonNull Type type) {
		throw new UnsupportedOperationException();
	}
}
