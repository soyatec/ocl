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
package org.eclipse.ocl.examples.domain.ids.impl;

import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.ids.ElementId;

public abstract class WeakHashMapOfWeakReference<K,V extends ElementId> extends WeakHashMap<K,WeakReference<V>> 
{
	public @NonNull V getElementId(@NonNull K key) {
		WeakReference<V> ref = get(key);
		if (ref != null) {
			V oldTypeId = ref.get();
			if (oldTypeId != null) {
				return oldTypeId;
			}
		}
		synchronized (this) {
			ref = get(key);
			if (ref != null) {
				V oldTypeId = ref.get();
				if (oldTypeId != null) {
					return oldTypeId;
				}
			}
			V newTypeId = newTypeId(key);
			put(key, new WeakReference<V>(newTypeId));
			return newTypeId;
		}
	}
	
	protected abstract @NonNull V newTypeId(@NonNull K key);
}