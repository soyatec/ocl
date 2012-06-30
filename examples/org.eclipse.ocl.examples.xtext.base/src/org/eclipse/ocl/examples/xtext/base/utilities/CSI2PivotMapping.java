/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D.Willink and others.
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
package org.eclipse.ocl.examples.xtext.base.utilities;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManagerListener;
import org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS;

/**
 * The CSI2PivotMapping maintains the mapping between CS elements or rather their CSIs
 * that remain stable after recreation and the Pivot elements. This mapping may be used
 * repeatedly while editing (CS2Pivot conversions) to associate changing CS elements with
 * stable Pivot elements.
 * The mapping is also created during a Pivot2CS conversion to allow subsequent CS2Pivot
 * conversions to reuse the original Pivot elements.  
 */
public class CSI2PivotMapping extends AdapterImpl implements MetaModelManagerListener
{
	public static CSI2PivotMapping getAdapter(MetaModelManager metaModelManager) {
		if (metaModelManager == null) {
			return null;
		}
		List<Adapter> eAdapters = metaModelManager.getPivotResourceSet().eAdapters();
		for (Adapter adapter : eAdapters) {
			if (adapter instanceof CSI2PivotMapping) {
				return (CSI2PivotMapping) adapter;
			}
		}
		CSI2PivotMapping adapter = new CSI2PivotMapping();
		eAdapters.add(adapter);
		return adapter;
	}

	/**
	 * Mapping of each CS resource's URI to a short alias used in URI maps.
	 */
	private Map<String, String> csURI2aliasMap = new HashMap<String, String>();

	/**
	 * The map from CS element (identified by URI) to pivot element at the end of the last update. This map enables
	 * the next update from a potentially different CS Resource and elements but the same URIs to re-use the pivot elements
	 * and to kill off the obsolete elements. 
	 */
	private Map<String, Element> csi2pivot = new HashMap<String, Element>();
	
	private int nextAlias = 0;
	
	private CSI2PivotMapping() {}

	public void clear() {
		csURI2aliasMap.clear();
		csi2pivot.clear();
	}
	
	public Set<String> computeCSIs(Collection<? extends Resource> csResources) {
		Set<String> map = new HashSet<String>();
		for (Resource csResource : csResources) {
			for (Iterator<EObject> it = csResource.getAllContents(); it.hasNext(); ) {
				EObject eObject = it.next();
				if (eObject instanceof ModelElementCS) {
					ModelElementCS csElement = (ModelElementCS)eObject;
					String csURI = getCSI(csElement);
					map.add(csURI);
				}
			}
		}
		return map;
	}

	/**
	 * Return the Pivot element corresponding to a given CS element.
	 */
	public Element get(ModelElementCS csElement) {
		String csi = getCSI(csElement);
		return csi2pivot.get(csi);
	}

	/**
	 * Get the Concrete Syntax Identifier for a CS element. This is a form of URI. It is significantly compacted to
	 * save on memory.
	 * @param csResource2aliasMap 
	 */
	private String getCSI(ModelElementCS csElement) {
		String csi = csElement.getCsi();
		if (csi == null) {
			Resource csResource = csElement.eResource();
			String csResourceURI = csResource.getURI().toString();
			String fragment = csResource.getURIFragment(csElement);		// FIXME Use more optimized compressing algorithm
			String alias = csURI2aliasMap.get(csResourceURI);
			if (alias == null) {
				alias = Integer.toString(nextAlias++);
				csURI2aliasMap.put(csResourceURI, alias);
			}
			csi = alias + '#' + fragment;
			csElement.setCsi(csi);
		}
		return csi;
	}

	public Map<String, Element> getMapping() {
		return csi2pivot;
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return type == CSI2PivotMapping.class;
	}

	public void metaModelManagerDisposed(MetaModelManager metaModelManager) {
		clear();
	}

	/**
	 * Install the Pivot element corresponding to a given CS element.
	 */
	public void put(ModelElementCS csElement, Element pivotElement) {
		String csi = getCSI(csElement);
		csi2pivot.put(csi, pivotElement);
	}

	/**
	 * Update the mapping to cache the Pivot elements with respect to the CSIs for all CS elements in csResources.
	 */
	public void update(Collection<? extends Resource> csResources) {
		csi2pivot.clear();
		Set<String> deadURIs = new HashSet<String>(csURI2aliasMap.keySet());
		for (Resource csResource : csResources) {
			deadURIs.remove(csResource.getURI().toString());
			for (Iterator<EObject> it = csResource.getAllContents(); it.hasNext(); ) {
				EObject eObject = it.next();
				if (eObject instanceof ModelElementCS) {
					ModelElementCS csElement = (ModelElementCS)eObject;
					Element pivotElement = csElement.getPivot();
					put(csElement, pivotElement);
				}
			}
		}
		for (String deadURI : deadURIs) {
			csURI2aliasMap.remove(deadURI);
		}
	}
}
