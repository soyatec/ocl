/**
 * <copyright>
 *
 * Copyright (c) 2010, 2011 E.D.Willink and others.
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
package org.eclipse.ocl.examples.pivot.resource;

import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.PivotConstants;
import org.eclipse.ocl.examples.pivot.PivotPackage;

/**
 * A resource for an OCL Abstract Syntax (Pivot) Model
 */
public interface ASResource extends XMIResource
{
	/**
	 * The file extension for OCL Abstract Syntax resources.
	 */
	@NonNull String FILE_EXTENSION = PivotConstants.OCL_AS_FILE_EXTENSION;

	/**
	 * The default encoding for OCL Abstract Syntax resources.
	 */
	@NonNull String DEFAULT_ENCODING = "UTF-8"; //$NON-NLS-1$

	@NonNull String CONTENT_TYPE = PivotPackage.eCONTENT_TYPE;

	@NonNull String COMPLETE_OCL_CONTENT_TYPE = CONTENT_TYPE + ".ocl";
	@NonNull String ECORE_CONTENT_TYPE = CONTENT_TYPE + ".ecore";
	@NonNull String ESSENTIALOCL_CONTENT_TYPE = CONTENT_TYPE + ".essentialocl";
	@NonNull String LIBRARY_CONTENT_TYPE = CONTENT_TYPE + ".library";
	@NonNull String OCLINECORE_CONTENT_TYPE = CONTENT_TYPE + ".oclinecore";
	@NonNull String OCLSTDLIB_CONTENT_TYPE = CONTENT_TYPE + ".oclstdlib";
	@NonNull String UML_CONTENT_TYPE = CONTENT_TYPE + ".uml";
	
	/**
	 * Return the ASResourceFactory that created this ASResource and which may be used
	 * to create further artefacts.
	 */
	@NonNull ASResourceFactory getASResourceFactory();
}