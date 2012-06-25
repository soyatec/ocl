/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
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
 * $Id: CompleteOCLCSResource.java,v 1.1 2011/02/08 17:53:05 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl.utilities;

import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.pivot.library.StandardLibraryContribution;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.model.OCLstdlib;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2Pivot;
import org.eclipse.ocl.examples.xtext.base.pivot2cs.Pivot2CS;
import org.eclipse.ocl.examples.xtext.completeocl.cs2pivot.CompleteOCLCS2Pivot;
import org.eclipse.ocl.examples.xtext.completeocl.pivot2cs.CompleteOCLPivot2CS;
import org.eclipse.ocl.examples.xtext.essentialocl.utilities.EssentialOCLCSResource;

public class CompleteOCLCSResource extends EssentialOCLCSResource
{
	@Override
	public CS2Pivot createCS2Pivot(Map<? extends Resource, ? extends Resource> cs2pivotResourceMap,
			MetaModelManager metaModelManager) {
		return new CompleteOCLCS2Pivot(cs2pivotResourceMap, metaModelManager);
	}

	@Override
	public MetaModelManager createMetaModelManager() {
		StandardLibraryContribution.REGISTRY.put(MetaModelManager.DEFAULT_OCL_STDLIB_URI, new OCLstdlib.Cloner());
		return super.createMetaModelManager();
	}

	@Override
	public Pivot2CS createPivot2CS(Map<? extends Resource, ? extends Resource> cs2pivotResourceMap,
			MetaModelManager metaModelManager) {
		return new CompleteOCLPivot2CS(cs2pivotResourceMap, metaModelManager);
	}

	@Override
	public String getEditorName() {
		return "Complete OCL";
	}
}
