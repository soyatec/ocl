/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.common.preferences;

/**
 * A configurable preference with a Class value.
 */
public class ClassPreference<T> extends Preference<Class<? extends T>>
{
	public final Class<?> type;

	public ClassPreference(String pluginId, String key, Class<? extends T> defaultValue, Class<? extends T> type) {
		super(pluginId, key, defaultValue);
		this.type = type;
	}

	public Class<? extends T> getValueOf(String string) {
		if (string == null) {
			return null;
		}
		try {
			@SuppressWarnings("unchecked")
			Class<? extends T> loadClass = (Class<? extends T>) type.getClassLoader().loadClass(string);
			return loadClass;
		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
			return getDefaultValue();
		}
	}		
}