/**
 * <copyright>
 *
 * Copyright (c) 2011,2012 E.D.Willink and others.
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
 * $Id$
 */
package org.eclipse.ocl.examples.pivot.executor;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManageable;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;

public class PivotEcoreExecutorManager extends EcoreExecutorManager implements MetaModelManageable
{
	protected final MetaModelManager metaModelManager;

	public PivotEcoreExecutorManager(@NonNull EObject contextObject, @Nullable Map<Object, Object> contextMap, @NonNull DomainStandardLibrary standardLibrary, @NonNull MetaModelManager metaModelManager) {
		super(contextObject, contextMap, standardLibrary);
		this.metaModelManager = metaModelManager;
	}

	@SuppressWarnings("null")
	public @NonNull MetaModelManager getMetaModelManager() {
		return metaModelManager;
	}
}