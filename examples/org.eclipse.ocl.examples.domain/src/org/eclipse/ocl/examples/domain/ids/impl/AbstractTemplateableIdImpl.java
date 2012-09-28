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

import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainParameterTypes;
import org.eclipse.ocl.examples.domain.elements.DomainTemplateParameter;
import org.eclipse.ocl.examples.domain.ids.ElementId;
import org.eclipse.ocl.examples.domain.ids.EnumerationLiteralId;
import org.eclipse.ocl.examples.domain.ids.OperationId;
import org.eclipse.ocl.examples.domain.ids.TemplateBinding;
import org.eclipse.ocl.examples.domain.ids.TemplateBindings;
import org.eclipse.ocl.examples.domain.ids.TemplateParameterId;
import org.eclipse.ocl.examples.domain.ids.TemplateableId;

public abstract class AbstractTemplateableIdImpl<T extends TemplateableId> extends AbstractElementId implements TemplateableId
{
	protected final @NonNull Integer hashCode;

	/**
	 * Map from template bindings to the corresponding specialization. 
	 */
	private @Nullable WeakHashMapOfWeakReference<TemplateBindings, T> specializations = null;
	protected final @NonNull TemplateParameterId[] templateParameters;

	public AbstractTemplateableIdImpl(@NonNull Integer hashCode, @NonNull TemplateParameterId[] templateParameters) {
		this.hashCode = hashCode;
		this.templateParameters = templateParameters;
		for (int i = 0; i < templateParameters.length; i++) {
			templateParameters[i].install(this, i);
		}
	}

	protected abstract @NonNull T createSpecializedId(@NonNull TemplateBindings templateBindings);

	public @NonNull EnumerationLiteralId getEnumerationLiteralId(@NonNull String name) {
    	throw new UnsupportedOperationException();		// Only NestableTypeIds may have enumeration literals.
    }

    public @NonNull OperationId getOperationId(@NonNull TemplateParameterId[] templateParameters, @NonNull String name, @NonNull DomainParameterTypes parameterTypes) {
    	throw new UnsupportedOperationException();		// Only NestableTypeIds may nest.
    }

	public @NonNull T getSpecializedId(@NonNull TemplateBindings templateBindings) {
    	WeakHashMapOfWeakReference<TemplateBindings, T> specializations2 = specializations;
		if (specializations2 == null) {
    		synchronized (this) {
    			specializations2 = specializations;
    	    	if (specializations2 == null) {
    	    		synchronized (this) {
    	    			specializations = specializations2 = new WeakHashMapOfWeakReference<TemplateBindings, T>()
    	        		{
    	    				@Override
    	    				protected @NonNull T newTypeId(@NonNull TemplateBindings templateBindings) {
    	    					return createSpecializedId(templateBindings);
    	    				}
    					};
    	    		}
    	    	}
    		}
    	}
		return specializations2.getElementId(templateBindings);
    }

	public @NonNull T getSpecializedId(@NonNull ElementId... templateBindings) {
		assert templateBindings.length == getTemplateParameters().length;
		return getSpecializedId(new TemplateBindings(templateBindings));
	}

	@SuppressWarnings("null")
	public @NonNull TemplateParameterId getTemplateParameterId(int index) {
		return templateParameters[index];
	}

	public @NonNull TemplateParameterId[] getTemplateParameters() {
		return templateParameters;
	}

	@Override
	public final int hashCode() {
		return hashCode;
	}

	public void resolveTemplateBindings(@NonNull Map<DomainTemplateParameter, List<TemplateBinding>> bindings) {}
}