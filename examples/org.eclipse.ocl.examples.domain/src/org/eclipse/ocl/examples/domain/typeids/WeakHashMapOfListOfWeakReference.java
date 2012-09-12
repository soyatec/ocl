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
package org.eclipse.ocl.examples.domain.typeids;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

import org.eclipse.jdt.annotation.NonNull;

abstract class WeakHashMapOfListOfWeakReference<K1, K2, V extends MatchableTypeid<K2>> extends WeakHashMap<K1,List<WeakReference<V>>> 
{
	public synchronized @NonNull Typeid getTypeid(@NonNull K1 key1, @NonNull K2 key2, @NonNull String name) {
		List<WeakReference<V>> typeids = get(key1);
		if (typeids == null) {
			typeids = new ArrayList<WeakReference<V>>();
			put(key1, typeids);
		}
		for (WeakReference<V> ref : typeids) {
			V oldTypeid = ref.get();
			if (oldTypeid != null) {
				if (oldTypeid.matches(name, key2)) {
					return oldTypeid;
				}
			}
		}
		V newTypeid = newTypeid(key1, key2, name);
		typeids.add(new WeakReference<V>(newTypeid));
		return newTypeid;
	}

	protected abstract @NonNull V newTypeid(@NonNull K1 key1, @NonNull K2 key2, @NonNull String name);
}