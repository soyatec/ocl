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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.ids.TemplateParameterId;
import org.eclipse.ocl.examples.domain.ids.TemplateableId;

public abstract class AbstractGeneralizedIdImpl<T extends TemplateableId> extends AbstractTemplateableIdImpl<T>
{
	protected final @NonNull String name;

	public AbstractGeneralizedIdImpl(@NonNull Integer hashCode, @NonNull TemplateParameterId[] templateParameters, @NonNull String name) {
		super(hashCode, templateParameters);
		this.name = name;
	}

	public @NonNull String getName() {
		return name;
	}
}