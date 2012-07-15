/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
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
 * $Id$
 */
package org.eclipse.ocl.examples.pivot.manager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;

/**
 * PackageManager encapsulates the knowledge about known packages and their nsURIs.
 */
public class PackageManager extends PackageServerParent
{
	public static Function<PackageServer, org.eclipse.ocl.examples.pivot.Package> server2package = new Function<PackageServer, org.eclipse.ocl.examples.pivot.Package>()
	{
		public org.eclipse.ocl.examples.pivot.Package apply(PackageServer packageServer) {
			return packageServer.getPrimaryPackage();
		}
	};

	/**
	 * The MetaModelManager for which this PackageManager manages the packages.
	 */
	protected final MetaModelManager metaModelManager;

	private final Set<Root> roots = new HashSet<Root>();

	/**
	 * Map from package URI to primary package. 
	 */
	private final Map<String, PackageServer> uri2package = new HashMap<String, PackageServer>();
//	private final Map<String, org.eclipse.ocl.examples.pivot.Package> uri2package = new HashMap<String, org.eclipse.ocl.examples.pivot.Package>();
	
	/**
	 * Map from package name to package URIs, used solely to support merge of an nsURI-less package such as an OCL stdlib enhancement
	 * into an nsURI-full package without knowledge of a particular nsURI version.
	 */
	private final Map<String, List<String>> name2uris = new HashMap<String, List<String>>();

	/**
	 * Map from each merged package to the PackageTracker that supervises its merge. PackageTrackers are only
	 * created for merged packages, so a missing entry just denotes an unmerged package. 
	 */
	private final Map<org.eclipse.ocl.examples.pivot.Package, PackageTracker> package2tracker = new HashMap<org.eclipse.ocl.examples.pivot.Package, PackageTracker>();

	/**
	 * Map from each merged type to the TypeTracker that supervises its merge. TypeTrackers are only
	 * created for merged types, so a missing entry just denotes an unmerged type. 
	 */
	private final Map<Type, TypeTracker> type2tracker = new HashMap<Type, TypeTracker>();
	
	protected PackageManager(MetaModelManager metaModelManager) {
		this.metaModelManager = metaModelManager;
	}

	void addPackage(PackageServerParent parentPackageServer, org.eclipse.ocl.examples.pivot.Package pivotPackage) {
		PackageServer packageServer = null;
		String name = pivotPackage.getName();
		String nsURI = pivotPackage.getNsURI();
//		org.eclipse.ocl.examples.pivot.Package primaryPackage = null;
		if (nsURI != null) {										// Explicit nsURI for explicit package (merge)
			packageServer = uri2package.get(nsURI);
//			primaryPackage = getPackageByURI(nsURI);
		}
		else if (name != null) {										// Null nsURI can merge into same named package
//			primaryPackage = getPackageByName(name);
			packageServer = getMemberPackageServer(name);
		}
//			if (primaryPackage == null) {							// Null URI distinct package, so invent a default nsURI
//				nsURI = PivotUtil.getNsURI(pivotPackage);
//				primaryPackage = getPackageByURI(nsURI);
//			}
		if (packageServer == null) {
			packageServer = parentPackageServer.getMemberPackageServer(pivotPackage);
		}
		packageServer.addTrackedPackage(pivotPackage);
		
		
//		if (primaryPackage != pivotPackage) {						// Skip recursive call
//			if (primaryPackage != null) {
//				PackageTracker packageTracker = getPackageTracker(primaryPackage);
//				packageTracker.getPackageServer().addTrackedPackage(pivotPackage);
//			}
//			else {
//				putPackage(nsURI, pivotPackage);
//				getPackageTracker(pivotPackage);
//			}
//		}
		for (org.eclipse.ocl.examples.pivot.Package nestedPackage : pivotPackage.getNestedPackage()) {
			addPackage(packageServer, nestedPackage);
		}
	}

	void addPackageServer(PackageServer packageServer) {
		String nsURI = packageServer.getNsURI();
		if (nsURI != null) {
			uri2package.put(nsURI, packageServer);
		}
	}

	void addPackageTracker(org.eclipse.ocl.examples.pivot.Package pivotPackage, PackageTracker packageTracker) {
		PackageTracker oldTracker = package2tracker.put(pivotPackage, packageTracker);
		assert oldTracker == null;
	}
	
	public synchronized void addRoot(Root pivotRoot) {
		roots.add(pivotRoot);
		for (org.eclipse.ocl.examples.pivot.Package pivotPackage : pivotRoot.getNestedPackage()) {
			addPackage(this, pivotPackage);
		}
	}

	void addTypeTracker(Type pivotType, TypeTracker typeTracker) {
		TypeTracker oldTracker = type2tracker.put(pivotType, typeTracker);
		assert oldTracker == null;
	}

	void addedNestedPrimaryPackage(org.eclipse.ocl.examples.pivot.Package pivotPackage) {
		String nsURI = PivotUtil.getNsURI(pivotPackage);
		org.eclipse.ocl.examples.pivot.Package primaryPackage = getPackageByURI(nsURI);
		if (primaryPackage == pivotPackage) {
			// Recursive call
		}
		else if (primaryPackage != null) {
			throw new IllegalArgumentException("Duplicate nsURI '" + nsURI + "'");
		}
		else {
//			putPackage(nsURI, pivotPackage);
			getPackageTracker(pivotPackage);
		}
	}

	@Override
	public synchronized void dispose() {
		if (!package2tracker.isEmpty()) {
			Collection<PackageTracker> savedPackageTrackers = new ArrayList<PackageTracker>(package2tracker.values());
			package2tracker.clear();
			for (PackageTracker packageTracker : savedPackageTrackers) {
//				if (packageTracker instanceof PackageServer) {
					packageTracker.dispose();
//				}
			}
		}
		if (!type2tracker.isEmpty()) {
			Collection<TypeTracker> savedTypeTrackers = new ArrayList<TypeTracker>(type2tracker.values());
			type2tracker.clear();
			for (TypeTracker typeTracker : savedTypeTrackers) {
				typeTracker.dispose();
			}
		}
		uri2package.clear();
		name2uris.clear();
		super.dispose();
	}

	public PackageTracker findPackageTracker(org.eclipse.ocl.examples.pivot.Package pivotPackage) {
		return package2tracker.get(pivotPackage);
	}
	
	public TypeTracker findTypeTracker(Type pivotType) {
		return type2tracker.get(pivotType);
	}

	public Iterable<org.eclipse.ocl.examples.pivot.Package> getAllPackages() {
		return Iterables.transform(uri2package.values(), server2package);		// FIXME
	}

	public Iterable<org.eclipse.ocl.examples.pivot.Package> getAllPackagesWithUris() {
		return Iterables.transform(uri2package.values(), server2package);
	}

	@Override
	public MetaModelManager getMetaModelManager() {
		return metaModelManager;
	}

	public org.eclipse.ocl.examples.pivot.Package getPackageByName(String name) {
		List<String> uriList = name2uris.get(name);
		if ((uriList == null) || uriList.isEmpty()) {
			return null;
		}
		org.eclipse.ocl.examples.pivot.Package selectedPackage = getPackageByURI(uriList.get(0));
		for (int i = 1; i < uriList.size(); i++) {
			org.eclipse.ocl.examples.pivot.Package anotherPackage = getPackageByURI(uriList.get(i));
			if (anotherPackage != selectedPackage) {
				throw new IllegalArgumentException("Ambiguous package name '" + name + "'");
			}
		}
		return selectedPackage;
	}

	public org.eclipse.ocl.examples.pivot.Package getPackageByURI(String nsURI) {
		PackageServer packageServer = uri2package.get(nsURI);
		return packageServer != null ? packageServer.getPrimaryPackage() : null;
	}

	@Override
	public final PackageManager getPackageManager() {
		return this;
	}

	public PackageServer getPackageServer(org.eclipse.ocl.examples.pivot.Package pivotPackage) {
		String nsURI = pivotPackage.getNsURI();
		PackageServer packageServer = uri2package.get(nsURI);
		if (packageServer == null) {
			PackageServerParent packageServerParent = getParentPackageServer(pivotPackage);
			packageServer = packageServerParent.getMemberPackageServer(pivotPackage);
		}
		return packageServer;
	}

	@Override
	public PackageTracker getPackageTracker(org.eclipse.ocl.examples.pivot.Package pivotPackage) {
		PackageTracker packageTracker = findPackageTracker(pivotPackage);
		if (packageTracker == null) {
			packageTracker = (PackageTracker) EcoreUtil.getAdapter(pivotPackage.eAdapters(), this);
			if (packageTracker == null) {
				PackageServer packageServer = new PackageServer(this, pivotPackage.getNsURI());
				packageTracker = packageServer.getPackageTracker(pivotPackage);
			}
		}
		return packageTracker;
	}

/*	public synchronized Iterable<org.eclipse.ocl.examples.pivot.Package> getPartialPackages(org.eclipse.ocl.examples.pivot.Package pkg) {
		PackageTracker packageTracker = findPackageTracker(pkg);
		Set<org.eclipse.ocl.examples.pivot.Package> allPackages = new HashSet<org.eclipse.ocl.examples.pivot.Package>();
		if (packageTracker != null) {
			for (org.eclipse.ocl.examples.pivot.Package aPackage : packageTracker.getPackageServer().getTrackedPackages()) {
				allPackages.add(aPackage);
			}
		}
		else {
			allPackages.add(pkg);
		}
		getAllPartialPackages(allPackages, allPackages);		// FIXME Inconsistent name/functionality
		return allPackages;
	} */

/*	private void getAllPartialPackages(Set<org.eclipse.ocl.examples.pivot.Package> knownPackages, Set<org.eclipse.ocl.examples.pivot.Package> newPackages) {
		Set<org.eclipse.ocl.examples.pivot.Package> morePackages = null;
		for (org.eclipse.ocl.examples.pivot.Package newPackage : newPackages) {
			for (org.eclipse.ocl.examples.pivot.Package importedPackage : newPackage.getImportedPackage()) {
				if (morePackages == null) {
					morePackages = new HashSet<org.eclipse.ocl.examples.pivot.Package>();
				}
				PackageTracker packageTracker = findPackageTracker(importedPackage);
				if (packageTracker != null) {
					for (org.eclipse.ocl.examples.pivot.Package aPackage : packageTracker.getPackageServer().getTrackedPackages()) {
						morePackages.add(aPackage);
					}
				}
				else {
					morePackages.add(importedPackage);
				}
			}
		}
		if (morePackages != null) {
			morePackages.removeAll(knownPackages);
			if (morePackages.size() > 0) {
				knownPackages.addAll(morePackages);
				getAllPartialPackages(knownPackages, morePackages);
			}
		}
	} */

	public Iterable<Root> getRoots() {
		return roots;
	}
	
	public TypeServer getTypeServer(Type pivotType) {
		TypeTracker typeTracker = findTypeTracker(pivotType);
		if (typeTracker == null) {
			PackageServer packageServer = getPackageServer(pivotType.getPackage());
			typeTracker = packageServer.getTypeTracker(pivotType);
		}
		return typeTracker.getTypeServer();
	}

/*	protected void putPackage(String nsURI, org.eclipse.ocl.examples.pivot.Package pivotPackage) {
		uri2package.put(nsURI, pivotPackage);
		String name = pivotPackage.getName();
		if (name != null) {
			List<String> uriList = name2uris.get(name);
			if (uriList == null) {
				uriList = new ArrayList<String>();
				name2uris.put(name, uriList);
			}
			if (!uriList.contains(nsURI)) {
				uriList.add(nsURI);
			}
		}
	} */

/*	void reassignPackageServer(PackageServer packageServer, org.eclipse.ocl.examples.pivot.Package toPackage) {
		removePackageTracker(packageServer);
		package2tracker.put(toPackage, packageServer);
		String nsURI = toPackage.getNsURI();
		if (nsURI != null) {
			putPackage(nsURI, toPackage);
		}
	} */

	void removePackageTracker(PackageTracker packageTracker) {
		if (!package2tracker.isEmpty()) {						// Empty if disposing
			org.eclipse.ocl.examples.pivot.Package trackedPackage = packageTracker.getTarget();
			if (trackedPackage != null) {
				package2tracker.remove(trackedPackage);
				String nsURI = trackedPackage.getNsURI();
//				@SuppressWarnings("unused")
//				org.eclipse.ocl.examples.pivot.Package removedPackage = uri2package.remove(nsURI);
				String name = trackedPackage.getName();
				List<String> uriList = name2uris.get(name);
				if (uriList != null) {
					uriList.remove(nsURI);
				}
			}
		}
	}

	void removeTypeTracker(TypeTracker typeTracker) {
		type2tracker.remove(typeTracker.getTarget());
	}

	void removePackageServer(String nsURI) {
		uri2package.remove(nsURI);
	}
}