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

import java.util.Iterator;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.utilities.SingletonIterator;
import org.eclipse.ocl.examples.pivot.Type;

/**
 * A TypeServer serves coordinated behaviour of one or more
 * merged Types as required for Complete OCL type extension.
 * 
 * For specializeable types, a TypeServer keeps track of zero or more specializations
 * using WeakReferences so that the specializations vanish once no longer required.
 */
public class OrphanTypeServer extends AbstractTypeServer implements Adapter, Iterable<Type>
{
 	protected final @NonNull Type target;
	
	protected OrphanTypeServer(@NonNull OrphanPackageServer packageServer, @NonNull Type type) {
		super(packageServer, type);
		this.target = type;
	}

	public void notifyChanged(Notification notification) {}

	public @NonNull Iterable<Type> getPartialTypes() {
		return this;			// 'this' is pragmatically an Iterable
	}
	
	public @NonNull Type getPivotType() {
		return target;
	}

	public Notifier getTarget() {
		return target;
	}

	public boolean isAdapterForType(Object type) {
		return type == packageManager;
	}

	public @NonNull Iterator<Type> iterator() {
		return new SingletonIterator<Type>(target);
	}

	public void setTarget(Notifier newTarget) {
		assert newTarget == target;
	}

	@Override
	public String toString() {
		return String.valueOf(target);
	}
}
