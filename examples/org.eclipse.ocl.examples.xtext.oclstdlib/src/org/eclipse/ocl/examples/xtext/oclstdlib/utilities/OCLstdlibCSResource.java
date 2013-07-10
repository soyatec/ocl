/**
 * <copyright>
 *
 * Copyright (c) 2010, 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: OCLstdlibCSResource.java,v 1.3 2011/05/22 16:42:11 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclstdlib.utilities;

import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2Pivot;
import org.eclipse.ocl.examples.xtext.essentialocl.utilities.EssentialOCLCSResource;
import org.eclipse.ocl.examples.xtext.oclstdlib.cs2as.OCLstdlibCS2Pivot;

public class OCLstdlibCSResource extends EssentialOCLCSResource
{
	@Override
	public @NonNull CS2Pivot createCS2Pivot(@NonNull Map<? extends Resource, ? extends Resource> cs2pivotResourceMap,
			@NonNull MetaModelManager metaModelManager) {
		return new OCLstdlibCS2Pivot(cs2pivotResourceMap, metaModelManager);
	}

//	@Override
//	public Pivot2CS createPivot2CS(Map<? extends Resource, ? extends Resource> cs2pivotResourceMap,
//			MetaModelManager metaModelManager) {
//		return new OCLstdlibPivot2CS(cs2pivotResourceMap, metaModelManager);		// FIXME
//	}

	@Override
	public @NonNull String getEditorName() {
		return "OCL Standard Library";
	}
}
