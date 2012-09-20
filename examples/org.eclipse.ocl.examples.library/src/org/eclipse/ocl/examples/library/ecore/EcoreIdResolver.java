/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
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
package org.eclipse.ocl.examples.library.ecore;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.ExternalCrossReferencer;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.domain.elements.DomainRoot;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.ids.NsURIPackageId;
import org.eclipse.ocl.examples.domain.ids.RootPackageId;
import org.eclipse.ocl.examples.domain.types.IdResolver;

/**
 * EcoreIdResolver provides a package discovery capability so that package identifiers can be resolved.
 * <p>
 * Given an initial seed of a standard library and one or more root EObjects, packages are discovered
 * by locating all packages and nested packages directly contained by the seed roots or by the roots of
 * any object referenced by any contained by the seed roots.
 */
class EcoreIdResolver extends IdResolver implements Adapter
{
	protected final @NonNull Collection<? extends EObject> directRoots;
//	protected @NonNull Map<ElementId, DomainElement> id2element = new HashMap<ElementId, DomainElement>();
	private Map<String, DomainPackage> nsURI2package = new HashMap<String, DomainPackage>();
	private Map<String, DomainPackage> roots2package = new HashMap<String, DomainPackage>();
	private boolean directRootsProcessed = false;
	private boolean crossReferencedRootsProcessed = false;
	
	EcoreIdResolver(@NonNull Collection<? extends EObject> roots, @NonNull DomainStandardLibrary standardLibrary) {
		super(standardLibrary);
		this.directRoots = roots;
	}

	private void addPackage(@NonNull DomainPackage userPackage) {
		String nsURI = userPackage.getNsURI();
		if (nsURI != null) {
			nsURI2package.put(nsURI, userPackage);
		}
		else {
			String name = userPackage.getName();
			if (name != null) {
				roots2package.put(name, userPackage);
			}
		}
		addPackages(userPackage.getNestedPackage());
	}

	private void addPackages(/*@NonNull*/ Iterable<? extends DomainPackage> userPackages) {
		for (DomainPackage userPackage : userPackages) {
			assert userPackage != null;
			addPackage(userPackage);
		}
	}

	public void notifyChanged(Notification notification) {}			// FIXME ?? invalidate

	public Notifier getTarget() {
		return null;
	}

	public boolean isAdapterForType(Object type) {
		return false;
	}

	protected synchronized void processCrossReferencedRoots() {
		if (crossReferencedRootsProcessed ) {
			return;
		}
		crossReferencedRootsProcessed = true;
		new ExternalCrossReferencer(directRoots)
		{
			private static final long serialVersionUID = 1L;
			
			private Set<EObject> moreRoots = new HashSet<EObject>();

			{ findExternalCrossReferences(); }

			@Override
			protected boolean crossReference(EObject eObject, EReference eReference, EObject crossReferencedEObject) {
				EObject root = EcoreUtil.getRootContainer(crossReferencedEObject);
				if (moreRoots.add(root) && !directRoots.contains(root)) {
					if (root instanceof DomainRoot) {
						addPackages(((DomainRoot)root).getNestedPackage());
					}
					else if (root instanceof DomainPackage) {					// Perhaps this is only needed for a lazy JUnit test
						addPackage((DomainPackage)root);
					}
				}
				return false;
			}
		};
	}

	protected synchronized void processDirectRoots() {
		if (directRootsProcessed) {
			return;
		}
		directRootsProcessed = true;
		for (EObject eObject : directRoots) {
			if (eObject instanceof DomainRoot) {
				addPackages(((DomainRoot)eObject).getNestedPackage());
			}
//			else if (eObject instanceof DomainPackage) {							// Perhaps this is only needed for a lazy JUnit test
//				addPackage((DomainPackage)eObject);
//			}
		}
	}

	public void setTarget(Notifier newTarget) {
//			assert newTarget == resource;
	}

	@Override
	public synchronized @NonNull DomainPackage visitNsURIPackageId(@NonNull NsURIPackageId id) {
		String nsURI = id.getNsURI();
		DomainPackage knownPackage = nsURI2package.get(nsURI);
		if (knownPackage != null) {
			return knownPackage;
		}
		DomainPackage libraryPackage = standardLibrary.getNsURIPackage(nsURI);
		if (libraryPackage != null) {
			nsURI2package.put(nsURI, libraryPackage);
			return libraryPackage;
		}
		if (!directRootsProcessed) {
			processDirectRoots();
			knownPackage = nsURI2package.get(nsURI);
			if (knownPackage != null) {
				return knownPackage;
			}
		}
		if (!crossReferencedRootsProcessed) {
			processCrossReferencedRoots();
			knownPackage = nsURI2package.get(nsURI);
			if (knownPackage != null) {
				return knownPackage;
			}
		}
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull
	DomainPackage visitRootPackageId(@NonNull RootPackageId id) {
		String name = id.getName();
		DomainPackage knownPackage = roots2package.get(name);
		if (knownPackage != null) {
			return knownPackage;
		}
//		DomainPackage libraryPackage = standardLibrary.getNsURIPackage(nsURI);
//		if (libraryPackage != null) {
//			nsURI2package.put(nsURI, libraryPackage);
//			return libraryPackage;
//		}
		if (!directRootsProcessed) {
			processDirectRoots();
			knownPackage = roots2package.get(name);
			if (knownPackage != null) {
				return knownPackage;
			}
		}
		if (!crossReferencedRootsProcessed) {
			processCrossReferencedRoots();
			knownPackage = roots2package.get(name);
			if (knownPackage != null) {
				return knownPackage;
			}
		}
		throw new UnsupportedOperationException();
	}
}