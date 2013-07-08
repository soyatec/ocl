/**
 * <copyright>
 *
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.build.utilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.emf.mwe.utils.Mapping;
import org.eclipse.jdt.annotation.NonNull;

/**
 * Copies one platform: resource to another.
 */
public class ResourceCopier extends AbstractWorkflowComponent
{
	protected Logger log = Logger.getLogger(getClass());	
	private ResourceSet resourceSet = null;	
	protected Map<URI, URI> fileMap = new HashMap<URI, URI>();

	public void addFile(Mapping mapping) {
		URI fromURI = URI.createPlatformResourceURI(mapping.getFrom(), true);
		URI toURI = URI.createPlatformResourceURI(mapping.getTo(), true);
		fileMap.put(fromURI, toURI);
	}

	public void checkConfiguration(Issues issues) {
	}
	
	public @NonNull ResourceSet getResourceSet() {
		ResourceSet resourceSet2 = resourceSet;
		if (resourceSet2 == null) {
			resourceSet = resourceSet2 = new ResourceSetImpl();
		}
		return resourceSet2;
	}

	@Override
	public void invokeInternal(WorkflowContext ctx, ProgressMonitor arg1, Issues arg2) {
		ResourceSet resourceSet = getResourceSet();
		Collection<EObject> oldObjects = new ArrayList<EObject>();
		for (Map.Entry<URI,URI> entry : fileMap.entrySet()) {
			URI fromURI = entry.getKey();
			log.info("Reading from '" + fromURI + "'");
			Resource fromResource = resourceSet.getResource(fromURI, true);
			oldObjects.addAll(fromResource.getContents());
		}
		EcoreUtil.resolveAll(resourceSet);
		ResourceUtils.checkResourceSet(resourceSet);
	    Copier copier = new Copier();
	    copier.copyAll(oldObjects);
	    copier.copyReferences();
		for (Map.Entry<URI,URI> entry : fileMap.entrySet()) {
			URI fromURI = entry.getKey();
			URI toURI = entry.getValue();
			Resource fromResource = resourceSet.getResource(fromURI, false);
			Resource toResource = resourceSet.createResource(toURI);
			for (EObject oldObject : fromResource.getContents()) {
				EObject newObject = copier.get(oldObject);
				toResource.getContents().add(newObject);
			}
		}
		for (Map.Entry<URI,URI> entry : fileMap.entrySet()) {
			URI toURI = entry.getValue();
			Resource toResource = resourceSet.getResource(toURI, false);
			log.info("Saving to '" + toResource.getURI() + "'");
			try {
				toResource.save(getSaveOptions());
			} catch (IOException e) {
				throw new RuntimeException("Problems running " + getClass().getSimpleName(), e);
			}
		}
	}

	protected Map<?, ?> getSaveOptions() {
		Map<Object, Object> result = new HashMap<Object, Object>();
		result.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED, Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);
		result.put(XMLResource.OPTION_LINE_WIDTH, Integer.valueOf(132));
		result.put(XMLResource.OPTION_LINE_DELIMITER, "\n");
		return result;
	}
	
	public void setResourceSet(@NonNull ResourceSet resourceSet) {
		this.resourceSet = resourceSet;
	}
}
