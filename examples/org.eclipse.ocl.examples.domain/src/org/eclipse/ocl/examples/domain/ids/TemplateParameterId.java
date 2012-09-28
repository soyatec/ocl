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
package org.eclipse.ocl.examples.domain.ids;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainElement;


/**
 * A TemplateParameterId provides a unique identifier for a template parameter such as Set<T> or product<T>(...).
 */
public interface TemplateParameterId extends ElementId
{
	public static final @NonNull TemplateParameterId[] NULL_TEMPLATE_PARAMETER_ID_ARRAY = new TemplateParameterId[0];	

	int getIndex();

	@NonNull String getName();

	@Nullable DomainElement getOrigin();

	@NonNull ElementId getParent();

	void install(@NonNull TemplateableId templateableId, int index);
}