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
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Package;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;

/**
 * PackageManager encapsulates the knowledge about known packages and their nsURIs.
 */
public class PackageManager implements PackageServerParent
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
	protected final @NonNull MetaModelManager metaModelManager;

	/**
	 * Map of (nested) package-name to package server.
	 */
	private @Nullable Map<String, PackageServer> packageServers = null;

	private final @NonNull Set<RootTracker> rootTrackers = new HashSet<RootTracker>();

	/**
	 * Map from package URI to primary package. 
	 */
	private final @NonNull Map<String, PackageServer> uri2package = new HashMap<String, PackageServer>();

	/**
	 * Map from each merged package to the PackageTracker that supervises its merge. PackageTrackers are only
	 * created for merged packages, so a missing entry just denotes an unmerged package. 
	 */
	private final @NonNull Map<org.eclipse.ocl.examples.pivot.Package, PackageTracker> package2tracker = new HashMap<org.eclipse.ocl.examples.pivot.Package, PackageTracker>();

	/**
	 * Map from each merged type to the TypeTracker that supervises its merge. TypeTrackers are only
	 * created for merged types, so a missing entry just denotes an unmerged type. 
	 */
	private final @NonNull Map<Type, TypeTracker> type2tracker = new HashMap<Type, TypeTracker>();
	
	protected PackageManager(@NonNull MetaModelManager metaModelManager) {
		this.metaModelManager = metaModelManager;
	}

	void addPackage(@NonNull PackageServerParent parentPackageServer, @NonNull org.eclipse.ocl.examples.pivot.Package pivotPackage) {
		PackageServer packageServer = null;
		String name = pivotPackage.getName();
		String nsURI = pivotPackage.getNsURI();
		if (nsURI != null) {										// Explicit nsURI for explicit package (merge)
			packageServer = uri2package.get(nsURI);
		}
		else if (name != null) {										// Null nsURI can merge into same named package
			packageServer = getMemberPackageServer(name);
		}
		if (packageServer == null) {
			packageServer = parentPackageServer.getMemberPackageServer(pivotPackage);
		}
		packageServer.addTrackedPackage(pivotPackage);
		for (org.eclipse.ocl.examples.pivot.Package nestedPackage : pivotPackage.getNestedPackage()) {
			if (nestedPackage != null) {
				addPackage(packageServer, nestedPackage);
			}
		}
	}

	void addPackageServer(@NonNull PackageServer packageServer) {
		String nsURI = packageServer.getNsURI();
		uri2package.put(nsURI, packageServer);
	}

	void addPackageTracker(@NonNull org.eclipse.ocl.examples.pivot.Package pivotPackage, @NonNull PackageTracker packageTracker) {
		PackageTracker oldTracker = package2tracker.put(pivotPackage, packageTracker);
		assert oldTracker == null;
	}
	
	public synchronized void addRoot(@NonNull Root pivotRoot) {
		rootTrackers.add(new RootTracker(this, pivotRoot));
		for (org.eclipse.ocl.examples.pivot.Package pivotPackage : pivotRoot.getNestedPackage()) {
			if (pivotPackage != null) {
				addPackage(this, pivotPackage);
			}
		}
	}

	void addTypeTracker(@NonNull Type pivotType, @NonNull TypeTracker typeTracker) {
		TypeTracker oldTracker = type2tracker.put(pivotType, typeTracker);
		assert oldTracker == null;
	}

	public void addedMemberPackage(@NonNull org.eclipse.ocl.examples.pivot.Package pivotPackage) {
		PackageServer packageServer = getMemberPackageServer(pivotPackage);
		packageServer.addTrackedPackage(pivotPackage);
	}

	void addedNestedPrimaryPackage(@NonNull org.eclipse.ocl.examples.pivot.Package pivotPackage) {
		String nsURI = PivotUtil.getNsURI(pivotPackage);
		org.eclipse.ocl.examples.pivot.Package primaryPackage = null;
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
		Map<String, PackageServer> packageServers2 = packageServers;
		if (packageServers2 != null) {
			Collection<PackageServer> savedPackageServers = new ArrayList<PackageServer>(packageServers2.values());
			packageServers2.clear();
			for (PackageServer packageServer : savedPackageServers) {
				packageServer.dispose();
			}
			packageServers = null;
		}
	}

	public void disposedPackageServer(@NonNull PackageServer packageServer) {
		Map<String, PackageServer> packageServers2 = packageServers;
		if (packageServers2 != null) {
			packageServers2.remove(packageServer.getName());
		}
		disposedPackageServer(packageServer.getNsURI());
	}

	void disposedPackageServer(@Nullable String nsURI) {
		if (nsURI != null) {
			uri2package.remove(nsURI);
		}
	}

	void disposedPackageTracker(@NonNull PackageTracker packageTracker) {
		if (!package2tracker.isEmpty()) {						// Empty if disposing
			package2tracker.remove(packageTracker.getTarget());
		}
	}

	void disposedRootTracker(@NonNull RootTracker rootTracker) {
		rootTrackers.remove(rootTracker);
	}

	void disposedTypeTracker(@NonNull TypeTracker typeTracker) {
		type2tracker.remove(typeTracker.getTarget());
	}

	public PackageTracker findPackageTracker(@NonNull org.eclipse.ocl.examples.pivot.Package pivotPackage) {
		return package2tracker.get(pivotPackage);
	}
	
	public TypeTracker findTypeTracker(@NonNull Type pivotType) {
		return type2tracker.get(pivotType);
	}

	@SuppressWarnings("null")
	public @NonNull Iterable<org.eclipse.ocl.examples.pivot.Package> getAllPackages() {
		return Iterables.transform(uri2package.values(), server2package);		// FIXME
	}

	@SuppressWarnings("null")
	public @NonNull Iterable<org.eclipse.ocl.examples.pivot.Package> getAllPackagesWithUris() {
		return Iterables.transform(uri2package.values(), server2package);
	}

	public @Nullable org.eclipse.ocl.examples.pivot.Package getMemberPackage(@NonNull String memberPackageName) {
		Map<String, PackageServer> packageServers2 = packageServers;
		if (packageServers2 == null) {
			return null;
		}
		PackageServer memberPackageServer = packageServers2.get(memberPackageName);
		if (memberPackageServer == null) {
			return null;
		}
		return memberPackageServer.getPrimaryPackage();
	}

	public @NonNull PackageServer getMemberPackageServer(@NonNull org.eclipse.ocl.examples.pivot.Package pivotPackage) {
		Map<String, PackageServer> packageServers2 = packageServers;
		if (packageServers2 == null) {
			packageServers2 = packageServers = new HashMap<String, PackageServer>();
		}
		String name = pivotPackage.getName();
		if (name == null) {
			throw new IllegalStateException("Unnamed package");
		}
		PackageServer packageServer = packageServers2.get(name);
		if (packageServer == null) {
			String nsURI = pivotPackage.getNsURI();
			packageServer = new RootPackageServer(this, name, nsURI);
			packageServers2.put(name, packageServer);
			if (nsURI != null) {
				addPackageServer(packageServer);
			}
		}
		return packageServer;
	}

	public @Nullable PackageServer getMemberPackageServer(@NonNull String name) {
		Map<String, PackageServer> packageServers2 = packageServers;
		return packageServers2 != null ? packageServers2.get(name) : null;
	}

	public @NonNull Iterable<Package> getMemberPackages() {
		Map<String, PackageServer> packageServers2 = packageServers;
		if (packageServers2 == null) {
			@SuppressWarnings("null")
			@NonNull Iterable<Package> emptyList = Collections.emptyList();
			return emptyList;
		}
		else {
			@SuppressWarnings("null")
			@NonNull Iterable<Package> transform = Iterables.transform(packageServers2.values(), PackageServer.server2package);
			return transform;
		}
	}

	public @NonNull MetaModelManager getMetaModelManager() {
		return metaModelManager;
	}

	public @Nullable org.eclipse.ocl.examples.pivot.Package getPackageByURI(@NonNull String nsURI) {
		PackageServer packageServer = uri2package.get(nsURI);
		return packageServer != null ? packageServer.getPrimaryPackage() : null;
	}

	public @NonNull PackageServer getPackageServer(@NonNull org.eclipse.ocl.examples.pivot.Package pivotPackage) {
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

	public @NonNull PackageTracker getPackageTracker(@NonNull org.eclipse.ocl.examples.pivot.Package pivotPackage) {
		String name = pivotPackage.getName();
		if (name == null) {
			throw new IllegalStateException("Unnamed package");
		}
		PackageTracker packageTracker = findPackageTracker(pivotPackage);
		if (packageTracker == null) {
			packageTracker = (PackageTracker) EcoreUtil.getAdapter(pivotPackage.eAdapters(), this);
			if (packageTracker == null) {
				PackageServer packageServer = new RootPackageServer(this, name, pivotPackage.getNsURI());
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

	@NonNull PackageServerParent getParentPackageServer(@NonNull org.eclipse.ocl.examples.pivot.Package pivotPackage) {
		org.eclipse.ocl.examples.pivot.Package pivotPackageParent = pivotPackage.getNestingPackage();
		if (pivotPackageParent == null) {
			return this;
		}
		PackageTracker parentTracker = getPackageTracker(pivotPackageParent);
		return parentTracker.getPackageServer();
	}

	@SuppressWarnings("null")
	public @NonNull Iterable<Root> getRoots() {
		return Iterables.transform(rootTrackers, RootTracker.tracker2root);
	}
	
	public @NonNull TypeServer getTypeServer(@NonNull Type pivotType) {
		TypeTracker typeTracker = findTypeTracker(pivotType);
		if (typeTracker == null) {
			org.eclipse.ocl.examples.pivot.Package pivotPackage = pivotType.getPackage();
			if (pivotPackage == null) {
				throw new IllegalStateException("type has no package");
			}
			PackageServer packageServer = getPackageServer(pivotPackage);
			typeTracker = packageServer.getTypeTracker(pivotType);
		}
		return typeTracker.getTypeServer();
	}

	void removedMemberPackage(@NonNull org.eclipse.ocl.examples.pivot.Package pivotPackage) {
		PackageTracker packageTracker = findPackageTracker(pivotPackage);
		if (packageTracker != null) {
			packageTracker.dispose();
		}
	}
}