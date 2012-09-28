/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
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
 * $Id$
 */
package org.eclipse.ocl.examples.domain.ids;

import org.eclipse.jdt.annotation.NonNull;


/**
 * A TypeId provides a unique hierarchical for type which may have many 'actual' type variants.
 * <p>
 * For instance 'Boolean' is a well-understood conceptual, but it may have many 'actual' as a result of Complete OCL
 * definitions merging additional features in to the 'actual' type.
 */
public interface TemplateableId extends ElementId
{
	public static final @NonNull TemplateableId[] NULL_TEMPLATEABLE_ID_ARRAY = new TemplateableId[0];	

//	@NonNull ElementId getParent();
	@NonNull TemplateableId getGeneralizedId();
	@NonNull String getMetaTypeName();
	@NonNull String getName();

	/**
	 * Return the typeId for this typeId specialized by typeParameters.
	 * <p>
	 * Throws UnsupportedException for typeIds such as Primitive Types that may not be specialized.
	 */
	@NonNull TemplateableId getSpecializedId(@NonNull TemplateBindings bindings);

	/**
	 * Return the typeId for the index'th parameter of this templateableId.
	 */
	@NonNull TemplateParameterId getTemplateParameterId(int index);

	@NonNull TemplateParameterId[] getTemplateParameters();
}