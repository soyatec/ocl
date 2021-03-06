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
import java.util.Iterator;
import java.util.WeakHashMap;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.ids.ElementId;

public abstract class WeakHashMapOfWeakReference<K,V extends ElementId> extends WeakHashMap<K,WeakReference<V>> 
{
	public @NonNull V getId(@NonNull K key) {
		WeakReference<V> ref = get(key);
		if (ref != null) {
			V oldId = ref.get();
			if (oldId != null) {
				return oldId;
			}
		}
		synchronized (this) {
			ref = get(key);
			if (ref != null) {
				V oldId = ref.get();
				if (oldId != null) {
					return oldId;
				}
			}
			V newId = newId(key);
			put(key, new WeakReference<V>(newId));
			return newId;
		}
	}
	
	protected abstract @NonNull V newId(@NonNull K key);

	@Override public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append("{");
		Iterator<java.util.Map.Entry<K, WeakReference<V>>> i = entrySet().iterator();
		boolean hasNext = i.hasNext();
		while (hasNext) {
			java.util.Map.Entry<K, WeakReference<V>> e = i.next();
			WeakReference<V> ref = e.getValue();
			if (ref != null) {
				V value = ref.get();
				if (value != null) {
					K key = e.getKey();
					if (key == this)
						buf.append("(this Map)");
					else
						buf.append(key);
					buf.append("=");
					if (value == this)
						buf.append("(this Map)");
					else
						buf.append(value);
					hasNext = i.hasNext();
					if (hasNext)
						buf.append(", ");
				}
			}
		}

		buf.append("}");
		return buf.toString();
	}
	
	
}