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
 * $Id: CS2PivotResourceAdapter.java,v 1.12 2011/05/15 20:20:22 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.utilities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.manager.AbstractMetaModelManagerResourceAdapter;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2Pivot;
import org.eclipse.xtext.diagnostics.IDiagnosticConsumer;

/**
 * A CS2PivotResourceAdapter enhances the Resource for a Concrete Syntax model
 * to support synchronization with a Pivot model representation.
 */
public class CS2PivotResourceAdapter extends AbstractMetaModelManagerResourceAdapter<BaseCSResource>
{
	@Deprecated  // Use BaseCSResource.findCS2ASAdapter
	public static @Nullable CS2PivotResourceAdapter findAdapter(@NonNull BaseCSResource csResource) {
		return csResource.findCS2ASAdapter();
	}
	
	@Deprecated  // Use BaseCSResource.getCS2ASAdapter
	public static @NonNull CS2PivotResourceAdapter getAdapter(@NonNull BaseCSResource csResource, @Nullable MetaModelManager metaModelManager) {
		return csResource.getCS2ASAdapter(metaModelManager);
	}
	
	private final @NonNull CS2Pivot converter;
	
	public CS2PivotResourceAdapter(@NonNull BaseCSResource csResource, @NonNull MetaModelManager metaModelManager) {
		super(csResource, metaModelManager);
		Map<Resource, Resource> cs2pivotResourceMap = computeCS2PivotResourceMap(
			csResource, metaModelManager);
		converter = csResource.createCS2Pivot(cs2pivotResourceMap, metaModelManager);
	}

	public @NonNull Map<Resource, Resource> computeCS2PivotResourceMap(@NonNull BaseCSResource csResource, @NonNull MetaModelManager metaModelManager) {
		ResourceSet pivotResourceSet = metaModelManager.getTarget();
		Map<Resource,Resource> cs2pivotResourceMap = new HashMap<Resource,Resource>();
	//	ResourceSet csResourceSet = csResource.getResourceSet();
	//	if (csResourceSet != null) {
//		for (Resource acsResource : csResourceSet.getResources()) {
			Resource acsResource = csResource;
				URI uri = acsResource.getURI();
				if (uri != null) {
					List<EObject> contents = acsResource.getContents();
		//			if (!"java".equals(uri.scheme())) { //$NON-NLS-1$
					if ((contents.size() > 0) && (contents.get(0) instanceof ModelElementCS)) { //$NON-NLS-1$
						URI pivotURI = PivotUtil.getASURI(uri);
						Resource pivotResource = pivotResourceSet.getResource(pivotURI, false);
						if (pivotResource == null) {
							pivotResource = pivotResourceSet.createResource(pivotURI, csResource.getASContentType());
						}
						cs2pivotResourceMap.put(acsResource, pivotResource);
					}
				}
	//		}
	//	}
		return cs2pivotResourceMap;
	}
	
	public CS2Pivot getConverter() {
		return converter;
	}

	public Resource getPivotResource(@NonNull BaseCSResource csResource) {
		return converter.getPivotResource(csResource);
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return super.isAdapterForType(type) || (type == CS2PivotResourceAdapter.class);
	}	
	
	public void refreshPivotMappings(@NonNull IDiagnosticConsumer diagnosticsConsumer) throws Exception {
		try {
			converter.update(diagnosticsConsumer);
		}
		catch (Exception e) {
			dispose();
			throw e;
		}
	}
}