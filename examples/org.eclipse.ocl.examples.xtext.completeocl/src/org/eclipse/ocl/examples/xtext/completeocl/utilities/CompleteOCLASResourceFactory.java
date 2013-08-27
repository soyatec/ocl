/**
 * <copyright>
 *
 * Copyright (c) 2013 E.D.Willink and others.
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
package org.eclipse.ocl.examples.xtext.completeocl.utilities;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.resource.ASResource;
import org.eclipse.ocl.examples.pivot.resource.AbstractASResourceFactory;

public class CompleteOCLASResourceFactory extends AbstractASResourceFactory
{
	public static final @NonNull CompleteOCLASResourceFactory INSTANCE = new CompleteOCLASResourceFactory();
	
	protected CompleteOCLASResourceFactory() {
		super(ASResource.COMPLETE_OCL_CONTENT_TYPE, null);
	}

	@Override
	public int getHandlerPriority(@NonNull Resource resource) {
		return resource instanceof CompleteOCLCSResource ? CAN_HANDLE : CANNOT_HANDLE;
	}

	@Override
	public @Nullable Element importFromResource(@NonNull MetaModelManager metaModelManager, @NonNull Resource resource, @Nullable URI uri) {
		Resource asResource = ((CompleteOCLCSResource)resource).getASResource(metaModelManager);
		List<EObject> contents = asResource.getContents();
		if (contents.size() <= 0) {
			return null;
		}
		if ((uri != null) && (uri.fragment() == null)) {
			return (Element) contents.get(0);
		}
		else {
			throw new UnsupportedOperationException();	// FIXME
		}
	}
}