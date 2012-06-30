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
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;

/**
 * A TypeTracker adapts a Type to coordinate the coherent behaviour of one or more
 * merged Types as required for Complete OCL type extension.
 */
public class TypeTracker implements Adapter.Internal
{
	protected final PackageManager packageManager;
	protected final TypeServer typeServer;

	/**
	 * The Type tracked by this tracker.
	 */
	private final Type target;
	
	protected TypeTracker(TypeServer typeServer, Type target) {
		this.packageManager = typeServer.getPackageManager();
		this.typeServer = typeServer;
		this.target = target;
		target.eAdapters().add(this);
		packageManager.addTypeTracker(target, this);
		initializeContents();
	}

	public void dispose() {
		typeServer.removedTracker(this);
		packageManager.removeTypeTracker(this);
		target.eAdapters().remove(this);
	}

	public final PackageManager getPackageManager() {
		return packageManager;
	}

	public Type getPrimaryType() {
		return typeServer.getPrimaryType();
	}

	public final Type getTarget() {
		return target;
	}
	
	public TypeServer getTypeServer() {
		return typeServer;
	}

	protected void initializeContents() {
		TypeServer typeServer = getTypeServer();
		for (Operation pivotOperation : target.getOwnedOperation()) {
			typeServer.addOperation(pivotOperation);
		}
		for (Property pivotProperty : target.getOwnedAttribute()) {
			typeServer.addProperty(pivotProperty);
		}
	}		
	
	public final boolean isAdapterForType(Object type) {
		return type == packageManager;
	}

	/**
	 * Observe any superclass changes and uninstall all affected Inheritances.
	 */
	public void notifyChanged(Notification notification) {
		if (notification.getNotifier() != target) {
			return;
		}
		int eventType = notification.getEventType();
		Object feature = notification.getFeature();
		if (feature == PivotPackage.Literals.TYPE__OWNED_OPERATION) {
			switch (eventType) {
				case Notification.ADD: {
					Object value = notification.getNewValue();
					typeServer.addedOperation(value);
					break;
				}
				case Notification.ADD_MANY: {
					@SuppressWarnings("unchecked")
					List<Object> values = (List<Object>)notification.getNewValue();
					for (Object value : values) {
						typeServer.addedOperation(value);
					}
					break;
				}
				case Notification.REMOVE: {
					Object value = notification.getOldValue();
					typeServer.removedOperation(value);
					break;
				}
				case Notification.REMOVE_MANY: {
					@SuppressWarnings("unchecked")
					List<Object> values = (List<Object>)notification.getOldValue();
					for (Object value : values) {
						typeServer.removedOperation(value);
					}
					break;
				}
			}
		}
		else if (feature == PivotPackage.Literals.TYPE__OWNED_ATTRIBUTE) {
			switch (eventType) {
				case Notification.ADD: {
					Object value = notification.getNewValue();
					typeServer.addedProperty(value);
					break;
				}
				case Notification.ADD_MANY: {
					@SuppressWarnings("unchecked")
					List<Object> values = (List<Object>)notification.getNewValue();
					for (Object value : values) {
						typeServer.addedProperty(value);
					}
					break;
				}
				case Notification.REMOVE: {
					Object value = notification.getOldValue();
					typeServer.removedProperty(value);
					break;
				}
				case Notification.REMOVE_MANY: {
					@SuppressWarnings("unchecked")
					List<Object> values = (List<Object>)notification.getOldValue();
					for (Object value : values) {
						typeServer.removedProperty(value);
					}
					break;
				}
			}
		}
		else if (feature == PivotPackage.Literals.TYPE__SUPER_CLASS) {
			switch (eventType) {
				case Notification.ADD:
				case Notification.ADD_MANY:
				case Notification.REMOVE:
				case Notification.REMOVE_MANY:
				case Notification.RESOLVE:
				case Notification.SET:
				case Notification.UNSET:
					typeServer.changedInheritance();
					break;
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