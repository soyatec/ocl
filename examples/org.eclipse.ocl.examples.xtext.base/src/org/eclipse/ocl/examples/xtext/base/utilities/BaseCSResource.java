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
 * $Id: BaseCSResource.java,v 1.4 2011/03/03 20:09:18 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.utilities;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.utilities.BaseResource;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2Pivot;

/**
 * BaseResource defines the Xtext-dependent extended interface for a Concrete Syntax resource.
 */
public interface BaseCSResource extends BaseResource
{
	@NonNull CS2Pivot createCS2Pivot(@NonNull Map<? extends Resource, ? extends Resource> cs2pivotResourceMap, @NonNull MetaModelManager metaModelManager);
	@NonNull MetaModelManager createMetaModelManager();
	@NonNull String getEditorName();
	@NonNull URI resolve(@NonNull URI uri);
}
