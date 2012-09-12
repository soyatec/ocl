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
import java.util.WeakHashMap;

import org.eclipse.jdt.annotation.NonNull;

abstract class WeakHashMapOfWeakReference<K,V extends Typeid> extends WeakHashMap<K,WeakReference<V>> 
{
	public @NonNull Typeid getTypeid(@NonNull K name) {
		WeakReference<V> ref = get(name);
		if (ref != null) {
			V oldTypeid = ref.get();
			if (oldTypeid != null) {
				return oldTypeid;
			}
		}
		synchronized (this) {
			ref = get(name);
			if (ref != null) {
				V oldTypeid = ref.get();
				if (oldTypeid != null) {
					return oldTypeid;
				}
			}
			V newTypeid = newTypeid(name);
			put(name, new WeakReference<V>(newTypeid));
			return newTypeid;
		}
	}
	
	protected abstract @NonNull V newTypeid(@NonNull K name);
}