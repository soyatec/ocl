/**
 * <copyright>
 *
 * Copyright (c) 2011, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.library.oclstdlib;

import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.library.LibraryConstants;

/**
 * This is a pale imitation of an EMF Package declaration for the OCL Standard Library.
 * <p>
 * The OCL Standard Library is normally loaded as a pivot model by constructing an OCLstdlib instance.
 * <p>
 * The OCL Standard Library is dynamically loaded from OCL-2.5.ecore when required in an Ecore context.
 * <p>
 * Usage of this pcakacge is solely to support code generation.
 */
public class OCLstdlibPackage extends EPackageImpl {
	/**
	 * The package name.
	 */
	public static final @NonNull String eNAME = "oclstdlib"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 */
	public static final @NonNull String eNS_URI = LibraryConstants.STDLIB_URI;

	/**
	 * The package namespace name.
	 */
	public static final @NonNull String eNS_PREFIX = "oclstdlib"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 */
	public static final @NonNull OCLstdlibPackage eINSTANCE =  new OCLstdlibPackage();

	private OCLstdlibPackage() {
		setName(eNAME);
		setNsURI(eNS_URI);
		setNsPrefix(eNS_PREFIX);
	}
}
