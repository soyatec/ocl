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

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

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
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.resource.ASResource;
import org.eclipse.ocl.examples.pivot.resource.ASResourceFactory;
import org.eclipse.ocl.examples.pivot.resource.ASResourceFactoryRegistry;

public class AS2XMIid
{
	/**
	 * Create an AS2ID conversion primed with the xmi:id values obtained by loading uri. 
	 */
	public static @NonNull AS2XMIid load(@NonNull URI uri) {
		Map<String, String> moniker2id = new HashMap<String, String>();
		ResourceSet resourceSet = new ResourceSetImpl();
		ASResourceFactoryRegistry.INSTANCE.configureResourceSet(resourceSet);
//		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(PivotConstants.OCL_AS_FILE_EXTENSION, OCLASResourceFactory.INSTANCE);
		try {
			Resource resource = resourceSet.getResource(uri, true);
			if (resource instanceof XMLResource) {
				@SuppressWarnings("null")@NonNull List<Adapter> eAdapters = resource.eAdapters();
				AS2MonikerVisitor monikerVisitor = PivotUtil.getAdapter(AS2MonikerVisitor.class, eAdapters);
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
		return new AS2XMIid(moniker2id);
	}

	protected final @NonNull Map<String, String> moniker2id;
	
	public AS2XMIid() {
		this.moniker2id = new HashMap<String, String>();
	}
	
	protected AS2XMIid(@NonNull Map<String, String> moniker2id) {
		this.moniker2id = moniker2id;
	}

	/**
	 * Assign xmi:id values to referenceable elements in asResource re-using the xmi:id
	 * values read when this AS2ID was constructed.
	 */
	public void assignIds(@NonNull ASResource asResource) {
		List<WeakReference<EObject>> debugOldEObjects = new ArrayList<WeakReference<EObject>>();
		Map<Thread, StackTraceElement[]> oldStackTraces = Thread.getAllStackTraces();
		try {
			for (TreeIterator<EObject> tit = asResource.getAllContents(); tit.hasNext(); ) {
				EObject eObject = tit.next();
				assert eObject != null;
				debugOldEObjects.add(new WeakReference<EObject>(eObject));
			}
		}
		catch (Throwable e) {	// Bug 417663 an Intermittent NoSuchElementException may occur in the above
			Map<Thread, StackTraceElement[]> newStackTraces = Thread.getAllStackTraces();
			Set<Thread> oldThreads = new HashSet<Thread>(oldStackTraces.keySet());
			Set<Thread> newThreads = new HashSet<Thread>(newStackTraces.keySet());
			Set<Thread> stableThreads = new HashSet<Thread>(oldThreads);
			oldThreads.removeAll(stableThreads);
			newThreads.removeAll(stableThreads);
			for (Thread t : newThreads) {
				System.err.println("New thread : " + t);
			}
			for (Thread t : oldThreads) {
				System.err.println("Old thread : " + t);
			}
			for (Thread t : stableThreads) {
				System.err.println("Stable thread : " + t);
			}
			for (WeakReference<EObject> wr : debugOldEObjects) {
				EObject eObject = wr.get();
				if (eObject !=  null) {
					System.err.println("Old object : " + DomainUtil.debugFullName(eObject));
				}
				else {
					System.err.println("Garbage collected object");
				}
			}
		}
		StringBuilder s = null;
		Map<String, EObject> allIds = new HashMap<String, EObject>();
		ASResourceFactory resourceFactory = asResource.getASResourceFactory();
		EObject debugEObject = null;
		try {
			for (TreeIterator<EObject> tit = asResource.getAllContents(); tit.hasNext(); ) {
				EObject eObject = tit.next();
				debugEObject = eObject;
				if (eObject instanceof Element) {
					Element element = (Element)eObject;
					AS2XMIidVisitor idVisitor = resourceFactory.createAS2XMIidVisitor(this);
					String id = idVisitor.getID(element);
					if (id != null) {
						assert id.length() > 0 : "Zero length id for '" + element.eClass().getName() + "'";
						EObject oldElement = allIds.put(id, element);
						if (oldElement != null) {
							if (s == null) {
								s = new StringBuilder();
								s.append("Duplicate xmi:id values generated for ");
							}
							s.append("\n '" + id + "' for '" + element.eClass().getName() + "'");
						}
						//						System.out.println(DomainUtil.debugSimpleName(element) + " => " + xmi);
						// Move to separate pass to try to avoid intertmittent NoSuchElementException from TreeIterator
	//					asResource.setID(element, id);
					}
				}
			}
		}
		catch (NoSuchElementException e) {
			System.err.println("Previous EObject : " + DomainUtil.debugFullName(debugEObject));		
			int iSize = debugOldEObjects.size();
			for (int i = 0; i < iSize; i++) {
				EObject eObject = debugOldEObjects.get(i).get();
				if (debugEObject == eObject) {
					System.err.println("Previous EObject at " + i + "/" + iSize);
					if (i + 1 < iSize) {
						System.err.println("Next EObject : " + DomainUtil.debugFullName(debugOldEObjects.get(i+1)));
					}
					break;
				}
				else if (eObject == null) {
					System.err.println("EObject at " + i + "has been garbage collected");
				}
			}
			int i = 0;
			int messages = 0;
			for (TreeIterator<EObject> tit = asResource.getAllContents(); tit.hasNext(); i++) {
				EObject oldEObject = debugOldEObjects.get(i).get();
				EObject eObject = tit.next();
				assert eObject != null;
				if (eObject != oldEObject) {
					System.err.println("At " + i + " now " + DomainUtil.debugFullName(eObject) + " was " + DomainUtil.debugFullName(oldEObject));
					messages++;
					if (messages > 100) {
						break;
					}
				}
				else if (debugEObject == eObject) {
					System.err.println("Found previous EObject at " + i);
					if (tit.hasNext()) {
						eObject = tit.next();
						System.err.println("Next EObject now : " + DomainUtil.debugFullName(eObject));
					}
					else {
						System.err.println("No next EObject ");
					}
				}
			}
			throw e;
		}
		int i = 0;
		int messages = 0;
		for (TreeIterator<EObject> tit = asResource.getAllContents(); tit.hasNext(); i++) {
			EObject oldEObject = debugOldEObjects.get(i).get();
			EObject eObject = tit.next();
			assert eObject != null;
			if (eObject != oldEObject) {
				System.err.println("At " + i + " now " + DomainUtil.debugFullName(eObject) + " was " + DomainUtil.debugFullName(oldEObject));
				messages++;
				if (messages > 100) {
					break;
				}
			}
		}
		for (String id : allIds.keySet()) {
			asResource.setID(allIds.get(id), id);
		}
		if (s != null) {
			throw new IllegalStateException(s.toString());
		}
	}

	/**
	 * Assign xmi:id values to referenceable elements in asResourceSet re-using the xmi:id
	 * values read when this AS2ID was constructed.
	 */
	public void assignIds(@NonNull ResourceSet asResourceSet) {
		for (@SuppressWarnings("null")@NonNull Resource resource : asResourceSet.getResources()) {
			if (resource instanceof ASResource) {
				assignIds((ASResource)resource);
			}
		}
	}

	public String getID(@NonNull Element element) {
		String moniker = AS2Moniker.toString(element);
		String id = moniker2id.get(moniker);
		if (id != null) {
			return id;
		}
		return EcoreUtil.generateUUID();
	}
}