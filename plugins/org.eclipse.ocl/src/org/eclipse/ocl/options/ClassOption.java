/**
 * <copyright>
 *
 * Copyright (c) 2011,2012 E.D.Willink and others.
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
package org.eclipse.ocl.options;

import org.eclipse.ocl.common.preferences.PreferenceableOption;

/**
 * Implementation of the {@link PreferenceableOption} interface for class OCL options.
 *
 * @since 3.2
 */
public class ClassOption<T> extends BasicOption<Class<? extends T>> implements PreferenceableOption<Class<? extends T>>
{
	protected final Class<?> classType;
	
	public ClassOption(String pluginId, String key, Class<? extends T> defaultValue, Class<? extends T> classType) {
		super(pluginId, key, defaultValue);
		this.classType = classType;
	}

	@SuppressWarnings("unchecked")
	public Class<? extends T> getValueOf(String string) {
		if ((string == null) || (string.length() <= 0)) {
			return null;
		}
		try {
			return (Class<T>) classType.getClassLoader().loadClass(string);
		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
			return getDefaultValue();
		}
	}		
}