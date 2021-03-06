/**
 * <copyright>
 * 
 * Copyright (c) 2007,2010 E.D.Willink and others.
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
 * $Id: DefaultLabelGeneratorBuilder.java,v 1.2 2010/04/08 06:27:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.common.label;

import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * DefaultLabelGeneratorBuilder builds the label on behalf of a
 * ILabelGenerator.Registry using a StringBuilder.
 */
public class DefaultLabelGeneratorBuilder extends AbstractLabelGeneratorBuilder
{	
	protected final @NonNull StringBuilder s = new StringBuilder();
	
	public DefaultLabelGeneratorBuilder(@NonNull ILabelGenerator.Registry registry, @Nullable Map<ILabelGenerator.Option<?>, Object> options) {
		super(registry, options);
	}

	public void appendString(@Nullable String string) {
		if (string != null) {
			s.append(string);
		}
	}

	@Override
	public @NonNull String toString() {
		@SuppressWarnings("null")@NonNull String string = s.toString();
		return string;
	}
}