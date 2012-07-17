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
package org.eclipse.ocl.examples.pivot.manager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Package;

import com.google.common.collect.Iterables;


/**
 * A PackageServerParent defines the common parent of PackageServer behaviour for the PackageManager and a PackageServer.
 */
abstract class PackageServerParent
{
	/**
	 * Map of (nested) package-name to package server.
	 */
	private Map<String, PackageServer> packageServers = null;

	protected PackageServerParent() {}

	public void addedMemberPackage(@NonNull org.eclipse.ocl.examples.pivot.Package pivotPackage) {
		PackageServer packageServer = getMemberPackageServer(pivotPackage);
		packageServer.addTrackedPackage(pivotPackage);
	}

	public void dispose() {
		if (packageServers != null) {
			Collection<PackageServer> savedPackageServers = new ArrayList<PackageServer>(packageServers.values());
			packageServers.clear();
			for (PackageServer packageServer : savedPackageServers) {
				packageServer.dispose();
			}
			packageServers = null;
		}
	}
	
	void disposedPackageServer(@NonNull PackageServer packageServer) {
		if (packageServers != null) {
			packageServers.remove(packageServer.getName());
		}
		getPackageManager().disposedPackageServer(packageServer.getNsURI());
	}

	public @Nullable org.eclipse.ocl.examples.pivot.Package getMemberPackage(@NonNull String memberPackageName) {
		if (packageServers == null) {
			return null;
		}
		PackageServer memberPackageServer = packageServers.get(memberPackageName);
		if (memberPackageServer == null) {
			return null;
		}
		return memberPackageServer.getPrimaryPackage();
	}

	@NonNull PackageServer getMemberPackageServer(@NonNull org.eclipse.ocl.examples.pivot.Package pivotPackage) {
		if (packageServers == null) {
			packageServers = new HashMap<String, PackageServer>();
		}
		String name = pivotPackage.getName();
		if (name == null) {
			throw new IllegalStateException("Unnamed package");
		}
		PackageServer packageServer = packageServers.get(name);
		if (packageServer == null) {
			String nsURI = pivotPackage.getNsURI();
			packageServer = new PackageServer(this, name, nsURI);
			packageServers.put(name, packageServer);
			if (nsURI != null) {
				getPackageManager().addPackageServer(packageServer);
			}
		}
		return packageServer;
	}

	public @Nullable PackageServer getMemberPackageServer(@NonNull String name) {
		return packageServers != null ? packageServers.get(name) : null;
	}

	public @NonNull Iterable<Package> getMemberPackages() {
		if (packageServers == null) {
			@SuppressWarnings("null")
			@NonNull Iterable<Package> emptyList = Collections.emptyList();
			return emptyList;
		}
		else {
			@SuppressWarnings("null")
			@NonNull Iterable<Package> transform = Iterables.transform(packageServers.values(), PackageServer.server2package);
			return transform;
		}
	}

	public @NonNull MetaModelManager getMetaModelManager() {
		return getPackageManager().getMetaModelManager();
	}

	public abstract @NonNull PackageManager getPackageManager();

	abstract @NonNull PackageTracker getPackageTracker(@NonNull org.eclipse.ocl.examples.pivot.Package pivotPackage);

	@NonNull PackageServerParent getParentPackageServer(@NonNull org.eclipse.ocl.examples.pivot.Package pivotPackage) {
		org.eclipse.ocl.examples.pivot.Package pivotPackageParent = pivotPackage.getNestingPackage();
		if (pivotPackageParent == null) {
			return this;
		}
		PackageTracker parentTracker = getPackageTracker(pivotPackageParent);
		return parentTracker.getPackageServer();
	}

	void removedMemberPackage(@NonNull org.eclipse.ocl.examples.pivot.Package pivotPackage) {
		PackageTracker packageTracker = getPackageManager().findPackageTracker(pivotPackage);
		if (packageTracker != null) {
			packageTracker.dispose();
		}
	}
}