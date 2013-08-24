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
package org.eclipse.ocl.examples.pivot.utilities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.PivotConstants;

public class AS2ID
{
	/**
	 * Create an AS2ID conversion primed with the xmi:id values obtained by loading uri. 
	 */
	public static @NonNull AS2ID load(@NonNull URI uri) {
		Map<String, String> moniker2id = new HashMap<String, String>();
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(PivotConstants.OCL_AS_FILE_EXTENSION, new PivotResourceFactoryImpl());
		try {
			Resource resource = resourceSet.getResource(uri, true);
			if (resource instanceof XMLResource) {
				@SuppressWarnings("null")@NonNull List<Adapter> eAdapters = resource.eAdapters();
				Pivot2MonikerVisitor monikerVisitor = PivotUtil.getAdapter(Pivot2MonikerVisitor.class, eAdapters);
				if (monikerVisitor != null) {
					XMLResource xmlResource = (XMLResource) resource;
					for (TreeIterator<EObject> tit = xmlResource.getAllContents(); tit.hasNext(); ) {
						EObject eObject = tit.next();
						if (eObject instanceof Element) {
							Element element = (Element) eObject;
							String oldID = xmlResource.getID(element);
							if (oldID != null) {
								Object moniker = element.accept(monikerVisitor);
								if (moniker instanceof String) {
									moniker2id.put((String) moniker, oldID);
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {}
		return new AS2ID(moniker2id);
	}

	protected final @NonNull Map<String, String> moniker2id;
	
	public AS2ID() {
		this.moniker2id = new HashMap<String, String>();
	}
	
	protected AS2ID(@NonNull Map<String, String> moniker2id) {
		this.moniker2id = moniker2id;
	}

	/**
	 * Assign xmi:id values to referenceable elements in asResource re-using the xmi:id
	 * values read when this AS2ID was constructed.
	 */
	public void assignIds(@NonNull PivotResource asResource) {
		Map<String, EObject> allIds = new HashMap<String, EObject>();
		for (TreeIterator<EObject> tit = asResource.getAllContents(); tit.hasNext(); ) {
			EObject eObject = tit.next();
			if (eObject instanceof Element) {
				Element element = (Element)eObject;
				AS2IDVisitor idVisitor = asResource.createIDVisitor(this);
				String id = idVisitor.getID(element);
				if (id != null) {
					assert id.length() > 0 : "Zero length id for '" + element.eClass().getName() + "'";
					EObject oldElement = allIds.put(id, element);
					assert oldElement == null : "Duplicate id '" + id + "' for '" + element.eClass().getName() + "'";
					//						System.out.println(DomainUtil.debugSimpleName(element) + " => " + xmi);
					asResource.setID(element, id);
				}
			}
		}
	}

	/**
	 * Assign xmi:id values to referenceable elements in asResourceSet re-using the xmi:id
	 * values read when this AS2ID was constructed.
	 */
	public void assignIds(@NonNull ResourceSet asResourceSet) {
		for (@SuppressWarnings("null")@NonNull Resource resource : asResourceSet.getResources()) {
			if (resource instanceof PivotResource) {
				assignIds((PivotResource)resource);
			}
		}
	}

	public String getID(@NonNull Element element) {
		String moniker = Pivot2Moniker.toString(element);
		String id = moniker2id.get(moniker);
		if (id != null) {
			return id;
		}
		return EcoreUtil.generateUUID();
	}
}