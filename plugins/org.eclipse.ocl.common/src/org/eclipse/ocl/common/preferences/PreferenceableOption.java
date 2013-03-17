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
package org.eclipse.ocl.common.preferences;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * A PreferenceableOption identifies a configurable behavior suitable for use in a Preference
 * or Property Page.
 * <p>
 * The behavior is identified by a <i>key</i> and has a value with a type <i>T</i> and a <i>defaultValue</i>.
 * <p>
 * The value may be persisted as a string and reconstructed by {@link #getValueOf()}.
 * 
 * @param <T> the type of the option's value
 */
public interface PreferenceableOption<T>
{	
	/**
	 * Obtains the option's default value.
	 * 
	 * @return my default value, which default-default is <code>null</code>
	 */
	@Nullable T getDefaultValue();

	/**
	 * Obtains my string key, which may be used for persistence in a
	 * preference store.
	 * 
	 * @return my key.  Is never <code>null</code>
	 */
	@NonNull String getKey();

	/**
	 * Returns the plugin qualifier for the key.
	 */
	@NonNull String getPluginId();

	/**
	 * Get the preferred value of this option. When running standalone this is the built-in default.
	 * When running in Eclipse, the built-in default may be overridden by a user preference.
	 *
	 * @since Next major version
	 */
//	@Nullable T getPreferredValue();

	/**
	 * Returns an option value from a String typically obtained from an Eclipse Preference file.
	 */
	@Nullable T getValueOf(@Nullable String string);
}
