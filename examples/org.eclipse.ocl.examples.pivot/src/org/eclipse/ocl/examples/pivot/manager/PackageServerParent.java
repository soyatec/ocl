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

	public void addedMemberPackage(org.eclipse.ocl.examples.pivot.Package pivotPackage) {
		PackageServer packageServer = getMemberPackageServer(pivotPackage);
		packageServer.addTrackedPackage(pivotPackage);
/*			String nsURI = pivotPackage.getNsURI();
			org.eclipse.ocl.examples.pivot.Package primaryPackage = null;
			if (nsURI != null) {										// Explicit nsURI for explicit package (merge)
				primaryPackage = packageManager.getPackageByURI(nsURI);
				if (primaryPackage != null) {
					PackageServer packageServer = packageManager.getPackageTracker(primaryPackage).getPackageServer();
					if (primaryPackage != pivotPackage) {
						packageServer.addServedPackage(pivotPackage);
					}
					packageServers.put(packageName, packageServer);
					return;
				}
			} */
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

	public org.eclipse.ocl.examples.pivot.Package getMemberPackage(String memberPackageName) {
		if (packageServers == null) {
			return null;
		}
		PackageServer memberPackageServer = packageServers.get(memberPackageName);
		if (memberPackageServer == null) {
			return null;
		}
		return memberPackageServer.getPrimaryPackage();
	}

	PackageServer getMemberPackageServer(org.eclipse.ocl.examples.pivot.Package pivotPackage) {
		if (packageServers == null) {
			packageServers = new HashMap<String, PackageServer>();
		}
		String name = pivotPackage.getName();
		PackageServer packageServer = packageServers.get(name);
		if (packageServer == null) {
			String nsURI = pivotPackage.getNsURI();
			packageServer = new PackageServer(this, nsURI);
			packageServers.put(name, packageServer);
//			packageServer.addTrackedPackage(pivotPackage);
			if (nsURI != null) {
				getPackageManager().addPackageServer(packageServer);
			}
//			List<String> uriList = name2uris.get(name);
//			if ((uriList != null) && (uriList.size() == 1)) {
//				nsURI = uriList.get(0);
//				addPackage(nsURI, pivotPackage);
//			}
//			else {
//				logger.error("URI-less root package");
//			}
		}
		return packageServer;
	}

	public PackageServer getMemberPackageServer(String name) {
		return packageServers != null ? packageServers.get(name) : null;
	}

	public Iterable<Package> getMemberPackages() {
		if (packageServers == null) {
			return Collections.emptyList();
		}
		else {
			return Iterables.transform(packageServers.values(), PackageServer.server2package);
		}
	}

	public MetaModelManager getMetaModelManager() {
		return getPackageManager().getMetaModelManager();
	}

	public abstract PackageManager getPackageManager();

	abstract PackageTracker getPackageTracker(org.eclipse.ocl.examples.pivot.Package pivotPackage);

	PackageServerParent getParentPackageServer(org.eclipse.ocl.examples.pivot.Package pivotPackage) {
		org.eclipse.ocl.examples.pivot.Package pivotPackageParent = pivotPackage.getNestingPackage();
		if (pivotPackageParent == null) {
			return this;
		}
		else {
			PackageTracker parentTracker = getPackageTracker(pivotPackageParent);
			return parentTracker.getPackageServer();
		}
	}

	void removedMemberPackage(org.eclipse.ocl.examples.pivot.Package pivotPackage) {
		PackageTracker packageTracker = getPackageManager().findPackageTracker(pivotPackage);
		if (packageTracker != null) {
			PackageServer packageServer = packageTracker.getPackageServer();
			packageServer.removedPackageTracker(packageTracker);
		}
	}
	
	void removePackageServer(PackageServer packageServer) {
		if (packageServers != null) {
			packageServers.remove(packageServer);
		}
		String nsURI = packageServer.getNsURI();
		if (nsURI != null) {
			getPackageManager().removePackageServer(nsURI);
		}
	}
}