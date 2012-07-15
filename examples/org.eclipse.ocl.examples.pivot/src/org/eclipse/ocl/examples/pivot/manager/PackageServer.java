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
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.examples.pivot.LambdaType;
import org.eclipse.ocl.examples.pivot.TupleType;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.executor.PivotReflectivePackage;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;

/**
 * A PackageServer adapts the primary Package to coordinate the coherent behaviour of a primary and one or more
 * secondary Packages as required for Complete OCL package extension.
 */
public class PackageServer extends PackageServerParent
{
	public static Function<PackageServer, org.eclipse.ocl.examples.pivot.Package> server2package = new Function<PackageServer, org.eclipse.ocl.examples.pivot.Package>()
	{
		public org.eclipse.ocl.examples.pivot.Package apply(PackageServer packageServer) {
			return packageServer.getPrimaryPackage();
		}
	};

	protected final PackageServerParent packageServerParent;
	
	protected final String nsURI;

	protected final PackageManager packageManager;
	
	private org.eclipse.ocl.examples.pivot.Package primaryPackage;
	
	
	
	/**
	 * List of all package extensions including this.
	 */
	private final List<PackageTracker> trackers = new ArrayList<PackageTracker>();
	
	/**
	 * Lazily created map of nested class-name to multi-class server.
	 */
	private Map<String, TypeServer> typeServers = null;

	/**
	 * The Executor package containing the dispatch table representation.
	 */
	private PivotReflectivePackage executorPackage = null;
	
	protected PackageServer(PackageServerParent packageServerParent, String nsURI) {
		this.packageServerParent = packageServerParent;
		this.packageManager = packageServerParent.getPackageManager();
		this.nsURI = nsURI;
//		packageManager.addedPackageServer(this);
//		this.primaryPackage = primaryPackage;
//		trackers.add(this);
//		initContents(this);
	}
	
	void addedMemberType(Type pivotType) {
		if ((pivotType instanceof LambdaType) || (pivotType instanceof TupleType)) {	// FIXME parent not necessarily in place
			return;
		}
		if (typeServers != null) {
			getTypeTracker(pivotType);
		}
	}
	
	public PackageTracker addTrackedPackage(org.eclipse.ocl.examples.pivot.Package pivotPackage) {
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

	@Override
	public void dispose() {
		if (!trackers.isEmpty()) {
			Collection<PackageTracker> savedPackageTrackers = new ArrayList<PackageTracker>(trackers);
			trackers.clear();
			for (PackageTracker tracker : savedPackageTrackers) {
				tracker.dispose();
			}
		}
		if (typeServers != null) {
			Collection<TypeServer> savedTypeServers = new ArrayList<TypeServer>(typeServers.values());
			typeServers.clear();
			for (TypeServer typeServer : savedTypeServers) {
				typeServer.dispose();
			}
			typeServers = null;
		}
		packageServerParent.removePackageServer(this);
		super.dispose();
	}

	public PivotReflectivePackage getExecutorPackage() {
		if (executorPackage == null) {
			executorPackage = new PivotReflectivePackage(getMetaModelManager(), primaryPackage);
		}
		return executorPackage;
	}

	public Type getMemberType(String typeName) {
		if (typeServers == null) {
			initMemberTypes();
		}
		TypeServer typeServer = typeServers.get(typeName);
		return typeServer != null ? typeServer.getPrimaryType() : null;
	}

	public Iterable<Type> getMemberTypes() {
		if (typeServers == null) {
			initMemberTypes();
		}
		return Iterables.transform(typeServers.values(), TypeServer.server2type);
	}

/*	TypeTracker getNestedPackageTracker(org.eclipse.ocl.examples.pivot.Package nestedPackage) {
		if (nestedPackageServers == null) {
			nestedPackageServers = new HashMap<String, PackageServer>();
		}
		String nestedPackageName = nestedPackage.getName();
		PackageServer nestedPackageServer = nestedPackageServers.get(nestedPackageName);
		if (nestedPackageServer == null) {
			nestedPackageServer = new PackageServer(packageManager);
			nestedPackageServers.put(nestedPackageName, nestedPackageServer);
		}
		return nestedPackageServer.getPackageTracker(nestedPackage);
	} */

	public String getNsURI() {
		return nsURI;
	}

	@Override
	public final PackageManager getPackageManager() {
		return packageManager;
	}

	@Override
	public PackageTracker getPackageTracker(org.eclipse.ocl.examples.pivot.Package pivotPackage) {
		for (PackageTracker packageTracker : trackers) {
			if (packageTracker.getTarget() == pivotPackage) {
				return packageTracker;
			}
		}
		return addTrackedPackage(pivotPackage);
//		packageTracker.initializeContents();
	}

//	public Iterator<Package> getPackagesIterator() {
//		if (typeServers == null) {
//			initTypeServers();
//		}
//		return Iterators.transform(trackers.iterator(), tracker2package);
//	}

	/**
	 * Return the primary Package of this package merge.
	 */
	org.eclipse.ocl.examples.pivot.Package getPrimaryPackage() {
		return primaryPackage;
	}

	public Iterable<org.eclipse.ocl.examples.pivot.Package> getTrackedPackages() {
//		if (typeServers == null) {
//			initTypeServers();
//		}
		return Iterables.transform(trackers, PackageTracker.tracker2package);
	}

	TypeTracker getTypeTracker(Type pivotType) {
		if (typeServers == null) {
			initMemberTypes();
		}
		String name = pivotType.getName();
		TypeServer typeServer = typeServers.get(name);
		if (typeServer == null) {
			typeServer = new TypeServer(this);
			if (pivotType.getUnspecializedElement() == null) {
				typeServers.put(name, typeServer);
			}
		}
		return typeServer.getTypeTracker(pivotType);
	}

	private void initMemberPackages(org.eclipse.ocl.examples.pivot.Package pivotPackage) {
		for (org.eclipse.ocl.examples.pivot.Package nestedPackage : pivotPackage.getNestedPackage()) {
			addedMemberPackage(nestedPackage);
		}
	}		
	
	private void initMemberTypes() {
		if (typeServers == null) {
			typeServers = new HashMap<String, TypeServer>();
			for (PackageTracker packageTracker : trackers) {
				initMemberTypes(packageTracker.getTarget());
			}
		}
	}

	private void initMemberTypes(org.eclipse.ocl.examples.pivot.Package pivotPackage) {
		for (Type pivotType : pivotPackage.getOwnedType()) {
			addedMemberType(pivotType);
		}
	}		
	
	void removePackageTracker(PackageTracker packageTracker) {
		trackers.remove(packageTracker);
		packageManager.removePackageTracker(packageTracker);
	}

	void removedPackageTracker(PackageTracker packageTracker) {
		packageTracker.dispose();
		setPrimaryPackage();
		if (trackers.size() <= 0) {
			dispose();
		}
	}

	void removedMemberType(Type pivotType) {
		if (typeServers != null) {
			TypeTracker typeTracker = packageManager.findTypeTracker(pivotType);
			if (typeTracker != null) {
				TypeServer typeServer = typeTracker.getTypeServer();
				typeServer.removedTypeTracker(typeTracker);
			}
		}
	}

	void removedTypeServer(TypeServer typeServer) {
		if (typeServers != null) {
			typeServers.remove(typeServer);
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