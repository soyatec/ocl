/**
 * <copyright>
 *
 * Copyright (c) 2012, 2013 E.D.Willink and others.
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
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.ids.BindingsId;
import org.eclipse.ocl.examples.domain.ids.ElementId;
import org.eclipse.ocl.examples.domain.ids.EnumerationLiteralId;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.OperationId;
import org.eclipse.ocl.examples.domain.ids.ParametersId;
import org.eclipse.ocl.examples.domain.ids.PropertyId;
import org.eclipse.ocl.examples.domain.ids.TemplateParameterId;
import org.eclipse.ocl.examples.domain.ids.TemplateableId;

public abstract class AbstractTemplateableIdImpl<T extends TemplateableId> extends AbstractElementId implements TemplateableId
{
	protected final @NonNull Integer hashCode;

	/**
	 * Map from template bindings to the corresponding specialization. 
	 */
	private @Nullable WeakHashMapOfWeakReference<BindingsId, T> specializations = null;
	protected final int templateParameters;

	protected AbstractTemplateableIdImpl(@NonNull Integer hashCode, int templateParameters) {
		this.hashCode = hashCode;
		this.templateParameters = templateParameters;
	}

	protected abstract @NonNull T createSpecializedId(@NonNull BindingsId templateBindings);

	public @NonNull EnumerationLiteralId getEnumerationLiteralId(@NonNull String name) {
    	throw new UnsupportedOperationException();		// Only NestableTypeIds may have enumeration literals.
    }

    public @NonNull OperationId getOperationId(int templateParameters, @NonNull String name, @NonNull ParametersId parametersId) {
    	throw new UnsupportedOperationException();		// Only NestableTypeIds may nest.
    }

    public @NonNull PropertyId getPropertyId(@NonNull String name) {
    	throw new UnsupportedOperationException();
    }

	public @NonNull T getSpecializedId(@NonNull BindingsId templateBindings) {
    	WeakHashMapOfWeakReference<BindingsId, T> specializations2 = specializations;
		if (specializations2 == null) {
    		synchronized (this) {
    			specializations2 = specializations;
    	    	if (specializations2 == null) {
	    			specializations = specializations2 = new WeakHashMapOfWeakReference<BindingsId, T>()
	        		{
	    				@Override
	    				protected @NonNull T newId(@NonNull BindingsId templateBindings) {
	    					return createSpecializedId(templateBindings);
	    				}
					};
     	    	}
    		}
    	}
		return specializations2.getId(templateBindings);
    }

	public @NonNull T getSpecializedId(@NonNull ElementId... templateBindings) {
		assert templateBindings.length == templateParameters;
		return getSpecializedId(IdManager.getBindingsId(templateBindings));
	}

	public @NonNull TemplateParameterId getTemplateParameterId(int index) {
		return IdManager.getTemplateParameterId(index);
	}

	public int getTemplateParameters() {
		return templateParameters;
	}

	@Override
	public final int hashCode() {
		return hashCode;
	}
}