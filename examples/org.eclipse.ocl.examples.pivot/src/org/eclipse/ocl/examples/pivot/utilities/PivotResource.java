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
 *
 * $Id: PivotResource.java,v 1.2 2011/01/24 20:42:33 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.utilities;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.PivotConstants;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.utilities.PivotSaver.LocateVisitor;
import org.eclipse.ocl.examples.pivot.utilities.PivotSaver.ResolveVisitor;

/**
 * The resource associated with the '<em><b>pivot</b></em>' package.
 */
public interface PivotResource extends XMIResource
{
	/**
	 * The factory for '<em><b>pivot</b></em>' resources.
	 */
	public interface Factory extends Resource.Factory
	{
		public static final Factory INSTANCE = new PivotResourceFactoryImpl();
	}

	/**
	 * The file extension for '<em><b>pivot</b></em>' resources.
	 */
	public static final String FILE_EXTENSION = PivotConstants.OCL_AS_FILE_EXTENSION;

	/**
	 * The default encoding for '<em><b>pivot</b></em>' resources.
	 */
	public static final String DEFAULT_ENCODING = "UTF-8"; //$NON-NLS-1$

	public static final String CONTENT_TYPE = PivotPackage.eCONTENT_TYPE;
	
	/**
	 * Create a visitor to compute the xmi:id value of an element. 
	 */
	@NonNull AS2IDVisitor createIDVisitor(@NonNull AS2ID as2id);

	/**
	 * Create a visitor to locate orphan specializations. 
	 */
	@NonNull LocateVisitor createLocateVisitor(@NonNull AbstractPivotSaver saver);
	
	/**
	 * Create a visitor to compute a structural descriptor for an element. 
	 */
	@NonNull Pivot2MonikerVisitor createMonikerVisitor(@NonNull Abstract2Moniker as2moniker);

	/**
	 * Create a visitor to resolve orphan specializations. 
	 */
	@NonNull ResolveVisitor createResolveVisitor(@NonNull AbstractPivotSaver saver);
}