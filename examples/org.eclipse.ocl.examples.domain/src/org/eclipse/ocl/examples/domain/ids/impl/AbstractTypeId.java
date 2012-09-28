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
import org.eclipse.ocl.examples.domain.elements.DomainParameterTypes;
import org.eclipse.ocl.examples.domain.elements.DomainTemplateParameter;
import org.eclipse.ocl.examples.domain.ids.EnumerationLiteralId;
import org.eclipse.ocl.examples.domain.ids.OperationId;
import org.eclipse.ocl.examples.domain.ids.TemplateBinding;
import org.eclipse.ocl.examples.domain.ids.TemplateBindings;
import org.eclipse.ocl.examples.domain.ids.TemplateParameterId;
import org.eclipse.ocl.examples.domain.ids.TypeId;

public abstract class AbstractTypeId extends AbstractElementId implements TypeId
{
	public @NonNull EnumerationLiteralId getEnumerationLiteralId(@NonNull String name) {
    	throw new UnsupportedOperationException();
    }

	public @NonNull String getMetaTypeName() {
		return TypeId.CLASS_NAME;
	}

    public @NonNull OperationId getOperationId(@NonNull TemplateParameterId[] templateParameters, @NonNull String name, @NonNull DomainParameterTypes parameterTypes) {
    	throw new UnsupportedOperationException();
    }
	
    public @NonNull TemplateParameterId getTemplateParameterId(int index) {
    	throw new UnsupportedOperationException();
    }
	
    public @NonNull TemplateParameterId[] getTemplateParameters() {
    	throw new UnsupportedOperationException();
    }

	public void resolveTemplateBindings(@NonNull Map<DomainTemplateParameter, List<TemplateBinding>> bindings) {}
   
    public @NonNull TypeId specialize(@NonNull TemplateBindings templateBindings) {
    	throw new UnsupportedOperationException();
	}
}