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
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.LambdaType;
import org.eclipse.ocl.examples.pivot.Package;
import org.eclipse.ocl.examples.pivot.TupleType;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.executor.PivotReflectivePackage;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;

/**
 * A PackageServer adapts the primary Package to coordinate the coherent behavior of a primary and one or more
 * secondary Packages as required for Complete OCL package extension.
 */
public abstract class PackageServer implements PackageServerParent
{
	public static Function<PackageServer, org.eclipse.ocl.examples.pivot.Package> server2package = new Function<PackageServer, org.eclipse.ocl.examples.pivot.Package>()
	{
		public org.eclipse.ocl.examples.pivot.Package apply(PackageServer packageServer) {
			return packageServer.getPrimaryPackage();
		}
	};

	/**
	 * Map of (nested) package-name to package server.
	 */
	private @Nullable Map<String, PackageServer> packageServers = null;

	protected final @NonNull String name;	
	protected final @Nullable String nsURI;

	protected final @NonNull PackageManager packageManager;
	
	private org.eclipse.ocl.examples.pivot.Package primaryPackage;
	
	
	
	/**
	 * List of all package extensions including this.
	 */
	private final @NonNull List<PackageTracker> trackers = new ArrayList<PackageTracker>();
	
	/**
	 * Lazily created map of nested class-name to multi-class server.
	 */
	private @Nullable Map<String, TypeServer> typeServers = null;

	/**
	 * The Executor package containing the dispatch table representation.
	 */
	private @Nullable PivotReflectivePackage executorPackage = null;
	
	protected PackageServer(@NonNull PackageManager packageManager, @NonNull String name, @Nullable String nsURI) {
//		this.packageServerParent = packageServerParent;
		this.packageManager = packageManager;
		this.name = name;
		this.nsURI = nsURI;
	}
	
	void addedMemberType(@NonNull Type pivotType) {
		if ((pivotType instanceof LambdaType) || (pivotType instanceof TupleType)) {	// FIXME parent not necessarily in place
			return;
		}
		if (typeServers != null) {
			getTypeTracker(pivotType);
		}
	}
	
	public @NonNull PackageTracker addTrackedPackage(@NonNull org.eclipse.ocl.examples.pivot.Package pivotPackage) {
		PackageTracker packageTracker = (PackageTracker)EcoreUtil.getAdapter(pivotPackage.eAdapters(), packageManager);		// FIXME redundant
		if (packageTracker == null) {
			packageTracker = new PackageTracker(this, pivotPackage);
			packageManager.addPackageTracker(pivotPackage, packageTracker);
			if (typeServers != null) {
				initMemberTypes(pivotPackage);
			}	
			initMemberPackages(pivotPackage);
		}
		if (!trackers.contains(packageTracker)) {
			trackers.add(packageTracker);
			if (trackers.size() == 1) {
				setPrimaryPackage();
			}
		}
		return packageTracker;
	}

	public void addedMemberPackage(@NonNull org.eclipse.ocl.examples.pivot.Package pivotPackage) {
		PackageServer packageServer = getMemberPackageServer(pivotPackage);
		packageServer.addTrackedPackage(pivotPackage);
	}

	protected void dispose() {
		if (!trackers.isEmpty()) {
			Collection<PackageTracker> savedPackageTrackers = new ArrayList<PackageTracker>(trackers);
			trackers.clear();
			for (PackageTracker tracker : savedPackageTrackers) {
				tracker.dispose();
			}
		}
		Map<String, TypeServer> typeServers2 = typeServers;
		if (typeServers2 != null) {
			Collection<TypeServer> savedTypeServers = new ArrayList<TypeServer>(typeServers2.values());
			typeServers2.clear();
			for (TypeServer typeServer : savedTypeServers) {
				typeServer.dispose();
			}
			typeServers = null;
		}
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
		getPackageManager().disposedPackageServer(packageServer.getNsURI());
	}

	void disposedPackageTracker(@NonNull PackageTracker packageTracker) {
		trackers.remove(packageTracker);
		setPrimaryPackage();
		if (trackers.size() <= 0) {
			dispose();
		}	// FIXME else trash types and other caches
		packageManager.disposedPackageTracker(packageTracker);
	}

	void disposedTypeServer(@NonNull TypeServer typeServer) {
		Map<String, TypeServer> typeServers2 = typeServers;
		if (typeServers2 != null) {
			typeServers2.remove(typeServer.getName());
		}
	}
	
	public @NonNull PivotReflectivePackage getExecutorPackage() {
		PivotReflectivePackage executorPackage2 = executorPackage;
		if (executorPackage2 == null) {
			executorPackage2 = executorPackage = new PivotReflectivePackage(getMetaModelManager(), getPrimaryPackage());
		}
		return executorPackage2;
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
			packageServer = new NestedPackageServer(this, name, nsURI);
			packageServers2.put(name, packageServer);
			if (nsURI != null) {
				getPackageManager().addPackageServer(packageServer);
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

	public Type getMemberType(String typeName) {
		Map<String, TypeServer> typeServers2 = typeServers;
		if (typeServers2 == null) {
			typeServers2 = initMemberTypes();
		}
		TypeServer typeServer = typeServers2.get(typeName);
		return typeServer != null ? typeServer.getPrimaryType() : null;
	}

	public Iterable<Type> getMemberTypes() {
		Map<String, TypeServer> typeServers2 = typeServers;
		if (typeServers2 == null) {
			typeServers2 = initMemberTypes();
		}
		return Iterables.transform(typeServers2.values(), TypeServer.server2type);
	}

	public @NonNull MetaModelManager getMetaModelManager() {
		return getPackageManager().getMetaModelManager();
	}

	public @NonNull String getName() {
		return name;
	}

	public @Nullable String getNsURI() {
		return nsURI;
	}

	public final @NonNull PackageManager getPackageManager() {
		return packageManager;
	}

	public @NonNull PackageTracker getPackageTracker(@NonNull org.eclipse.ocl.examples.pivot.Package pivotPackage) {
		for (PackageTracker packageTracker : trackers) {
			if (packageTracker.getTarget() == pivotPackage) {
				return packageTracker;
			}
		}
		return addTrackedPackage(pivotPackage);
	}

	@NonNull PackageServerParent getParentPackageServer(@NonNull org.eclipse.ocl.examples.pivot.Package pivotPackage) {
		org.eclipse.ocl.examples.pivot.Package pivotPackageParent = pivotPackage.getNestingPackage();
		if (pivotPackageParent == null) {
			return this;
		}
		PackageTracker parentTracker = getPackageTracker(pivotPackageParent);
		return parentTracker.getPackageServer();
	}

	/**
	 * Return the primary Package of this package merge.
	 */
	@NonNull org.eclipse.ocl.examples.pivot.Package getPrimaryPackage() {
		org.eclipse.ocl.examples.pivot.Package thePrimaryPackage = primaryPackage;
		if (thePrimaryPackage == null) {
			throw new IllegalStateException("Missing primary package");
		}
		return thePrimaryPackage;
	}

	@SuppressWarnings("null")
	public @NonNull Iterable<org.eclipse.ocl.examples.pivot.Package> getTrackedPackages() {
		return Iterables.transform(trackers, PackageTracker.tracker2package);
	}

	@NonNull TypeTracker getTypeTracker(@NonNull Type pivotType) {
		Map<String, TypeServer> typeServers2 = typeServers;
		if (typeServers2 == null) {
			typeServers2 = initMemberTypes();
		}
		String name = pivotType.getName();
		if (name == null) {
			throw new IllegalStateException("Unnamed type");
		}
		TypeServer typeServer = typeServers2.get(name);
		if (typeServer == null) {
			typeServer = new TypeServer(this, name);
			if (pivotType.getUnspecializedElement() == null) {
				typeServers2.put(name, typeServer);
			}
		}
		return typeServer.getTypeTracker(pivotType);
	}

	private void initMemberPackages(@NonNull org.eclipse.ocl.examples.pivot.Package pivotPackage) {
		for (org.eclipse.ocl.examples.pivot.Package nestedPackage : pivotPackage.getNestedPackage()) {
			if (nestedPackage != null) {
				addedMemberPackage(nestedPackage);
			}
		}
	}		
	
	private @NonNull Map<String, TypeServer> initMemberTypes() {
		Map<String, TypeServer> typeServers2 = typeServers;
		if (typeServers2 == null) {
			typeServers2 = typeServers = new HashMap<String, TypeServer>();
			for (PackageTracker packageTracker : trackers) {
				initMemberTypes(packageTracker.getTarget());
			}
		}
		return typeServers2;
	}

	private void initMemberTypes(@NonNull org.eclipse.ocl.examples.pivot.Package pivotPackage) {
		for (Type pivotType : pivotPackage.getOwnedType()) {
			if (pivotType != null) {
				addedMemberType(pivotType);
			}
		}
	}		

	void removedMemberPackage(@NonNull org.eclipse.ocl.examples.pivot.Package pivotPackage) {
		PackageTracker packageTracker = getPackageManager().findPackageTracker(pivotPackage);
		if (packageTracker != null) {
			packageTracker.dispose();
		}
	}

	void removedMemberType(@NonNull Type pivotType) {
		if (typeServers != null) {
			TypeTracker typeTracker = packageManager.findTypeTracker(pivotType);
			if (typeTracker != null) {
				typeTracker.dispose();
			}
		}
	}

	void setPrimaryPackage() {
		if (trackers.size() > 0) {
			primaryPackage = trackers.get(0).getTarget();
		}
		else {
			primaryPackage = null;
		}
	}	

	@Override
	public String toString() {
		return String.valueOf(primaryPackage);
	}
}