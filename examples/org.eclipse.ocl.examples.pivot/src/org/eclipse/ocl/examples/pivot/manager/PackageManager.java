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
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.pivot.PivotConstants;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

/**
 * PackageManager encapsulates the knowledge about known packages and their nsURIs.
 */
public class PackageManager implements PackageServerParent
{
	/**
	 * The MetaModelManager for which this PackageManager manages the packages.
	 */
	protected final @NonNull MetaModelManager metaModelManager;

	/**
	 * Map of (nested) package-name to package server.
	 */
	private final @NonNull Map<String, RootPackageServer> packageServers = new HashMap<String, RootPackageServer>();

	private final @NonNull Set<RootTracker> rootTrackers = new HashSet<RootTracker>();

	/**
	 * Map from package URI to primary package. 
	 */
	private final @NonNull Map<String, PackageServer> uri2package = new HashMap<String, PackageServer>();

	/**
	 * Map from each merged package to the PackageTracker that supervises its merge. PackageTrackers are only
	 * created for merged packages, so a missing entry just denotes an unmerged package. 
	 */
	private final @NonNull Map<DomainPackage, PackageTracker> package2tracker = new HashMap<DomainPackage, PackageTracker>();

	/**
	 * Map from each merged type to the TypeTracker that supervises its merge. TypeTrackers are only
	 * created for merged types, so a missing entry just denotes an unmerged type. 
	 */
	private final @NonNull Map<DomainType, TypeTracker> type2tracker = new WeakHashMap<DomainType, TypeTracker>();
	
	protected PackageManager(@NonNull MetaModelManager metaModelManager) {
		this.metaModelManager = metaModelManager;
	}

	void addPackage(@NonNull PackageServerParent parentPackageServer, @NonNull DomainPackage pivotPackage) {
		PackageServer packageServer = null;
		String name = pivotPackage.getName();
		String nsURI = pivotPackage.getNsURI();
		if (nsURI != null) {										// Explicit nsURI for explicit package (merge)
			packageServer = uri2package.get(nsURI);
		}
		else if (name != null) {										// Null nsURI can merge into same named package
			packageServer = getMemberPackage(name);
		}
		if (packageServer == null) {
			packageServer = parentPackageServer.getMemberPackageServer(pivotPackage);
		}
		packageServer.addTrackedPackage(pivotPackage);
		for (DomainPackage nestedPackage : pivotPackage.getNestedPackage()) {
			if (nestedPackage != null) {
				addPackage(packageServer, nestedPackage);
			}
		}
	}

	void addPackageServer(@NonNull PackageServer packageServer) {
		String nsURI = packageServer.getNsURI();
		uri2package.put(nsURI, packageServer);
	}

	void addPackageTracker(@NonNull DomainPackage pivotPackage, @NonNull PackageTracker packageTracker) {
		PackageTracker oldTracker = package2tracker.put(pivotPackage, packageTracker);
		assert oldTracker == null;
	}
	
	public synchronized void addRoot(@NonNull Root pivotRoot) {
		rootTrackers.add(new RootTracker(this, pivotRoot));
		for (DomainPackage pivotPackage : pivotRoot.getNestedPackage()) {
			if (pivotPackage != null) {
				addPackage(this, pivotPackage);
			}
		}
	}

	void addTypeTracker(@NonNull DomainType pivotType, @NonNull TypeTracker typeTracker) {
		TypeTracker oldTracker = type2tracker.put(pivotType, typeTracker);
		assert oldTracker == null;
	}

	public void addedMemberPackage(@NonNull DomainPackage pivotPackage) {
		PackageServer packageServer = getMemberPackageServer(pivotPackage);
		packageServer.addTrackedPackage(pivotPackage);
	}

	void addedNestedPrimaryPackage(@NonNull DomainPackage pivotPackage) {
		String nsURI = PivotUtil.getNsURI(pivotPackage);
		DomainPackage primaryPackage = null;
		if (nsURI != null) {
			primaryPackage = getPackageByURI(nsURI);
		}
		if (primaryPackage == pivotPackage) {
			// Recursive call
		}
		else if (primaryPackage != null) {
			throw new IllegalArgumentException("Duplicate nsURI '" + nsURI + "'");
		}
		else {
			getPackageTracker(pivotPackage);
		}
	}

	public synchronized void dispose() {
		if (!rootTrackers.isEmpty()) {
			Collection<RootTracker> savedRootTrackers = new ArrayList<RootTracker>(rootTrackers);
			rootTrackers.clear();
			for (RootTracker rootTracker : savedRootTrackers) {
				rootTracker.dispose();
			}
		}
		if (!package2tracker.isEmpty()) {
			Collection<PackageTracker> savedPackageTrackers = new ArrayList<PackageTracker>(package2tracker.values());
			package2tracker.clear();
			for (PackageTracker packageTracker : savedPackageTrackers) {
				packageTracker.dispose();
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
		Collection<RootPackageServer> savedPackageServers = new ArrayList<RootPackageServer>(packageServers.values());
		packageServers.clear();
		for (RootPackageServer packageServer : savedPackageServers) {
			packageServer.dispose();
		}
	}

	public void disposedRootPackageServer(@NonNull RootPackageServer packageServer) {
		packageServers.remove(packageServer.getName());
		disposedPackageServer(packageServer.getNsURI());
	}

	void disposedPackageServer(@Nullable String nsURI) {
		if (nsURI != null) {
			uri2package.remove(nsURI);
		}
	}

	void disposedPackageTracker(@NonNull PackageTracker packageTracker) {
		if (!package2tracker.isEmpty()) {						// Empty if disposing
			package2tracker.remove(packageTracker.getPackage());
		}
	}

	void disposedRootTracker(@NonNull RootTracker rootTracker) {
		rootTrackers.remove(rootTracker);
	}

	void disposedTypeTracker(@NonNull TypeTracker typeTracker) {
		type2tracker.remove(typeTracker.getTarget());
	}

	@Nullable PackageTracker findPackageTracker(@NonNull DomainPackage pivotPackage) {
		return package2tracker.get(pivotPackage);
	}
	
	public @Nullable ExtensibleTypeServer findTypeServer(@NonNull DomainType pivotType) {
		TypeTracker typeTracker = type2tracker.get(pivotType);
		return typeTracker != null ? typeTracker.getTypeServer() : null;
	}
	
	@SuppressWarnings("unused")
	private final @Nullable TypeTracker findTypeTracker(@NonNull DomainType pivotType) {		
		throw new UnsupportedOperationException("Not implemented since specializations have a TypeServer but no TypeTracker");
		//return type2tracker.get(pivotType);
	}

	@SuppressWarnings("null")
	public @NonNull Iterable<PackageServer> getAllPackages() {
		return uri2package.values();
	}

	@SuppressWarnings("null")
	public @NonNull Iterable<PackageServer> getAllPackagesWithUris() {
		return uri2package.values();
	}

	public @Nullable RootPackageServer getMemberPackage(@NonNull String memberPackageName) {
		return packageServers.get(memberPackageName);
	}

	public @NonNull RootPackageServer getMemberPackageServer(@NonNull DomainPackage pivotPackage) {
		String name = pivotPackage.getName();
		if (name == null) {
			throw new IllegalStateException("Unnamed package");
		}
		RootPackageServer packageServer = packageServers.get(name);
		if (packageServer == null) {
			String nsPrefix = pivotPackage.getNsPrefix();
			String nsURI = pivotPackage.getNsURI();
			if (PivotConstants.ORPHANAGE_URI.equals(nsURI)) {
				packageServer = new OrphanPackageServer(this, name, nsPrefix, nsURI);
			}
			else {
				packageServer = new RootPackageServer(this, name, nsPrefix, nsURI);
			}
			packageServers.put(name, packageServer);
			if (nsURI != null) {
				addPackageServer(packageServer);
			}
		}
		return packageServer;
	}

	public @NonNull Iterable<RootPackageServer> getMemberPackages() {
		@SuppressWarnings("null")
		@NonNull Collection<RootPackageServer> values = packageServers.values();
		return values;
	}

	public @NonNull MetaModelManager getMetaModelManager() {
		return metaModelManager;
	}

	public @Nullable PackageServer getPackageByURI(@NonNull String nsURI) {
		return uri2package.get(nsURI);
	}

	public @NonNull PackageServer getPackageServer(@NonNull DomainPackage pivotPackage) {
		if (pivotPackage instanceof PackageServer) {
			return (PackageServer)pivotPackage;
		}
		String nsURI = pivotPackage.getNsURI();
		PackageServer packageServer = null;
		if (nsURI != null) {
			packageServer = uri2package.get(nsURI);
		}
		if (packageServer == null) {
			PackageServerParent packageServerParent = getParentPackageServer(pivotPackage);
			packageServer = packageServerParent.getMemberPackageServer(pivotPackage);
		}
		return packageServer;
	}

	public @NonNull PackageTracker getPackageTracker(@NonNull DomainPackage pivotPackage) {	// FIXME Review wrt getMemberPackageServer()
		String name = pivotPackage.getName();
		if (name == null) {
			throw new IllegalStateException("Unnamed package");
		}
		PackageTracker packageTracker = package2tracker.get(pivotPackage);
		if (packageTracker == null) {
			String nsPrefix = pivotPackage.getNsPrefix();
			String nsURI = pivotPackage.getNsURI();
			PackageServer packageServer = new RootPackageServer(this, name, nsPrefix, nsURI);
			packageTracker = packageServer.getPackageTracker(pivotPackage);
		}
		return packageTracker;
	}

/*	public synchronized Iterable<DomainPackage> getPartialPackages(DomainPackage pkg) {
		PackageTracker packageTracker = findPackageTracker(pkg);
		Set<DomainPackage> allPackages = new HashSet<DomainPackage>();
		if (packageTracker != null) {
			for (DomainPackage aPackage : packageTracker.getPackageServer().getTrackedPackages()) {
				allPackages.add(aPackage);
			}
		}
		else {
			allPackages.add(pkg);
		}
		getAllPartialPackages(allPackages, allPackages);		// FIXME Inconsistent name/functionality
		return allPackages;
	} */

/*	private void getAllPartialPackages(Set<DomainPackage> knownPackages, Set<DomainPackage> newPackages) {
		Set<DomainPackage> morePackages = null;
		for (DomainPackage newPackage : newPackages) {
			for (DomainPackage importedPackage : newPackage.getImportedPackage()) {
				if (morePackages == null) {
					morePackages = new HashSet<DomainPackage>();
				}
				PackageTracker packageTracker = findPackageTracker(importedPackage);
				if (packageTracker != null) {
					for (DomainPackage aPackage : packageTracker.getPackageServer().getTrackedPackages()) {
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

	@NonNull PackageServerParent getParentPackageServer(@NonNull DomainPackage pivotPackage) {
		DomainPackage pivotPackageParent = pivotPackage.getNestingPackage();
		if (pivotPackageParent == null) {
			return this;
		}
		PackageTracker parentTracker = getPackageTracker(pivotPackageParent);
		return parentTracker.getPackageServer();
	}

//	@SuppressWarnings("null")
//	public @NonNull Iterable<Root> getRoots() {
//		return Iterables.transform(rootTrackers, RootTracker.tracker2root);
//	}
	
	public @NonNull TypeServer getTypeServer(@NonNull DomainType pivotType) {
		if (pivotType instanceof TypeServer) {
			return (TypeServer)pivotType;
		}
		assert metaModelManager.isTypeServeable(pivotType);
		TypeTracker typeTracker = type2tracker.get(pivotType);
		if (typeTracker != null) {
			return typeTracker.getTypeServer();
		}
		else {
			DomainPackage pivotPackage = pivotType.getPackage();
			if (pivotPackage == null) {
				throw new IllegalStateException("type has no package");
			}
			PackageServer packageServer = getPackageServer(pivotPackage);
			return packageServer.getTypeServer(pivotType);
		}
	}

//	public void installAs(@NonNull String nsURI, @NonNull EcoreExecutorPackage tablesPackage) {
//		PackageServer packageServer = uri2package.get(nsURI);
//		if (packageServer != null) {
//			packageServer.addTrackedPackage(tablesPackage);
//			for (DomainPackage nestedPackage : tablesPackage.getNestedPackage()) {
//				if (nestedPackage != null) {
//					addPackage(packageServer, nestedPackage);
//				}
//			}
//		}
//	}

	void removedPackage(@NonNull DomainPackage pivotPackage) {
		PackageTracker packageTracker = package2tracker.get(pivotPackage);
		if (packageTracker != null) {
			packageTracker.dispose();
		}
	}

	void removedType(@NonNull DomainType pivotType) {
		TypeTracker typeTracker = type2tracker.get(pivotType);
		if (typeTracker != null) {
			typeTracker.dispose();
		}
	}
}