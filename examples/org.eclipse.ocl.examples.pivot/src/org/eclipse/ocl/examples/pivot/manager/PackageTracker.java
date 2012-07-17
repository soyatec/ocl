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

import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Type;

import com.google.common.base.Function;

/**
 * A PackageTracker adapts a Package to keep the overall managed meta-model in tune with any changes.
 */
class PackageTracker implements Adapter.Internal
{	
	public static Function<PackageTracker, org.eclipse.ocl.examples.pivot.Package> tracker2package = new Function<PackageTracker, org.eclipse.ocl.examples.pivot.Package>()
	{
		public org.eclipse.ocl.examples.pivot.Package apply(PackageTracker packageTracker) {
			return packageTracker.getTarget();
		}
	};

	protected final PackageServer packageServer;
	
	/**
	 * The Package tracked by this tracker.
	 */
	private final org.eclipse.ocl.examples.pivot.Package target;

	PackageTracker(@NonNull PackageServer packageServer, @NonNull org.eclipse.ocl.examples.pivot.Package target) {
		this.packageServer = packageServer;
		this.target = target;
		target.eAdapters().add(this);
	}

	void dispose() {
		PackageManager packageManager = packageServer.getPackageManager();
		for (Type type : target.getOwnedType()) {
			if (type != null) {
				TypeTracker typeTracker = packageManager.findTypeTracker(type);
				if (typeTracker != null) {
					typeTracker.dispose();
				}
			}
		}
		packageServer.disposedPackageTracker(this);
		target.eAdapters().remove(this);
	}

	/**
	 * Return the PackageServer supervising this package merge.
	 */
	@SuppressWarnings("null")
	final @NonNull PackageServer getPackageServer() {
		return packageServer;
	}

	/**
	 * Return the primary Package of this package merge.
	 */
	@NonNull org.eclipse.ocl.examples.pivot.Package getPrimaryPackage() {
		return packageServer.getPrimaryPackage();
	}

	@SuppressWarnings("null")
	public @NonNull org.eclipse.ocl.examples.pivot.Package getTarget() {
		return target;
	}

	public boolean isAdapterForType(Object type) {
		return type == packageServer.getPackageManager();
	}

	public void notifyChanged(Notification notification) {
		int eventType = notification.getEventType();
		Object feature = notification.getFeature();
		if (feature == PivotPackage.Literals.PACKAGE__OWNED_TYPE) {
			switch (eventType) {
				case Notification.ADD: {
					Object value = notification.getNewValue();
					if (value instanceof Type) {
						packageServer.addedMemberType((Type)value);
					}
					break;
				}
				case Notification.ADD_MANY: {
					@SuppressWarnings("unchecked")
					List<Object> values = (List<Object>)notification.getNewValue();
					for (Object value : values) {
						if (value instanceof Type) {
							packageServer.addedMemberType((Type)value);
						}
					}
					break;
				}
				case Notification.REMOVE: {
					Object value = notification.getOldValue();
					if (value instanceof Type) {
						packageServer.removedMemberType((Type) value);
					}
					break;
				}
				case Notification.REMOVE_MANY: {
					@SuppressWarnings("unchecked")
					List<Object> values = (List<Object>)notification.getOldValue();
					for (Object value : values) {
						if (value instanceof Type) {
							packageServer.removedMemberType((Type) value);
						}
					}
					break;
				}
			}
		}
		else if (feature == PivotPackage.Literals.PACKAGE__NESTED_PACKAGE) {
			switch (eventType) {
				case Notification.ADD: {
					Object value = notification.getNewValue();
					if (value instanceof org.eclipse.ocl.examples.pivot.Package) {
						packageServer.addedMemberPackage((org.eclipse.ocl.examples.pivot.Package)value);
					}
					break;
				}
				case Notification.ADD_MANY: {
					@SuppressWarnings("unchecked")
					List<Object> values = (List<Object>)notification.getNewValue();
					for (Object value : values) {
						if (value instanceof org.eclipse.ocl.examples.pivot.Package) {
							packageServer.addedMemberPackage((org.eclipse.ocl.examples.pivot.Package)value);
						}
					}
					break;
				}
				case Notification.REMOVE: {
					Object value = notification.getOldValue();
					if (value instanceof org.eclipse.ocl.examples.pivot.Package) {
						packageServer.removedMemberPackage((org.eclipse.ocl.examples.pivot.Package)value);
					}
					break;
				}
				case Notification.REMOVE_MANY: {
					@SuppressWarnings("unchecked")
					List<Object> values = (List<Object>)notification.getOldValue();
					for (Object value : values) {
						if (value instanceof org.eclipse.ocl.examples.pivot.Package) {
							packageServer.removedMemberPackage((org.eclipse.ocl.examples.pivot.Package)value);
						}
					}
					break;
				}
			}
		}
	}

	public void setTarget(Notifier newTarget) {
		assert target == newTarget;
	}

	@Override
	public String toString() {
		return String.valueOf(target);
	}

	public void unsetTarget(Notifier oldTarget) {
		assert target == oldTarget;
	}
}