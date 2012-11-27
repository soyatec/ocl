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
import org.eclipse.ocl.examples.domain.ids.ElementId;
import org.eclipse.ocl.examples.domain.ids.MetaclassId;
import org.eclipse.ocl.examples.domain.ids.TypeId;

public class GeneralizedMetaclassIdImpl extends AbstractMetaclassId
{
	
	/**
	 * Map from template bindings to the corresponding specialization. 
	 */
	private @NonNull WeakHashMapOfWeakReference<ElementId, MetaclassId> specializations =
			new WeakHashMapOfWeakReference<ElementId, MetaclassId>() {
				@Override
				protected @NonNull MetaclassId newId(@NonNull ElementId elementId) {
					return new SpecializedMetaclassIdImpl(elementId);
				}
			};
	private @NonNull TypeTemplateParameterIdImpl elementId = new TypeTemplateParameterIdImpl(null);

	public GeneralizedMetaclassIdImpl() {
		super(0x87654345);
	}

	public @NonNull String getDisplayName() {
		return TypeId.METACLASS_NAME;
	}

	public @NonNull ElementId getElementId() {
		return elementId;
	}

//	public @NonNull MetaclassId getGeneralizedId() {
//		return this;
//	}

	public @NonNull MetaclassId getSpecializedId(@NonNull ElementId elementId) {
		return specializations.getId(elementId);
    }

//	@Override
//	public void resolveTemplateBindings(@NonNull Map<DomainTemplateParameter, List<TemplateBinding>> bindings) {
//		((ElementId.Internal)elementTypeId).resolveTemplateBindings(bindings);
//	}

//    public @NonNull CollectionTypeId specialize(@NonNull ElementId elementId) {
//    	return createSpecializedId(elementId);
//	}
}