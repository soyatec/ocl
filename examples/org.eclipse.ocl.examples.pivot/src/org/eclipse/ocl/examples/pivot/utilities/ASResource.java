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
package org.eclipse.ocl.examples.pivot.utilities;

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

	/**
	 * Create a visitor to compute a structural descriptor for an element. 
	 */
	@NonNull AS2MonikerVisitor createAS2MonikerVisitor(@NonNull AS2Moniker as2moniker);

	/**
	 * Create a visitor to compute the xmi:id value of an element. 
	 */
	@NonNull AS2XMIidVisitor createAS2XMIidVisitor(@NonNull AS2XMIid as2id);

	/**
	 * Create a visitor to locate orphan specializations. 
	 */
	@NonNull ASSaverLocateVisitor createASSaverLocateVisitor(@NonNull ASSaver saver);

	/**
	 * Create a visitor to resolve orphan specializations. 
	 */
	@NonNull ASSaverResolveVisitor createASSaverResolveVisitor(@NonNull ASSaver saver);
}