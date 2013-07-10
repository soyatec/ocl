/**
 * <copyright>
 *
 * Copyright (c) 2011, 2012 E.D.Willink and others.
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
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2Pivot;
import org.eclipse.ocl.examples.xtext.base.pivot2cs.Pivot2CS;
import org.eclipse.ocl.examples.xtext.completeocl.cs2as.CompleteOCLCS2Pivot;
import org.eclipse.ocl.examples.xtext.completeocl.pivot2cs.CompleteOCLPivot2CS;
import org.eclipse.ocl.examples.xtext.essentialocl.utilities.EssentialOCLCSResource;

public class CompleteOCLCSResource extends EssentialOCLCSResource
{
	@Override
	public @NonNull CS2Pivot createCS2Pivot(@NonNull Map<? extends Resource, ? extends Resource> cs2pivotResourceMap,
			@NonNull MetaModelManager metaModelManager) {
		return new CompleteOCLCS2Pivot(cs2pivotResourceMap, metaModelManager);
	}

	@Override
	public Pivot2CS createPivot2CS(@NonNull Map<? extends Resource, ? extends Resource> cs2pivotResourceMap,
			@NonNull MetaModelManager metaModelManager) {
		return new CompleteOCLPivot2CS(cs2pivotResourceMap, metaModelManager);
	}

	@Override
	public @NonNull String getEditorName() {
		return "Complete OCL";
	}
}
