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
import org.eclipse.ocl.examples.domain.elements.DomainTypeTemplateParameter;
import org.eclipse.ocl.examples.domain.ids.ElementId;
import org.eclipse.ocl.examples.domain.ids.EnumerationLiteralId;
import org.eclipse.ocl.examples.domain.ids.OperationId;
import org.eclipse.ocl.examples.domain.ids.TemplateBinding;
import org.eclipse.ocl.examples.domain.ids.TemplateBindings;
import org.eclipse.ocl.examples.domain.ids.TemplateParameterId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.ids.TypeTemplateParameterId;

public class TypeTemplateParameterIdImpl extends TemplateParameterIdImpl implements TypeTemplateParameterId, ElementId.Internal
{
	public TypeTemplateParameterIdImpl(@Nullable DomainTypeTemplateParameter origin) {
		super(origin);
	}

	public @NonNull EnumerationLiteralId getEnumerationLiteralId(@NonNull String name) {
    	throw new UnsupportedOperationException();
    }

	public @NonNull String getMetaTypeName() {
    	throw new UnsupportedOperationException();
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

	public void resolveTemplateBindings(@NonNull Map<DomainTemplateParameter, List<TemplateBinding>> bindings) {
//    	throw new UnsupportedOperationException();
	}

    @Override
	public @NonNull TypeId specialize(@NonNull TemplateBindings templateBindings) {
    	return (TypeId) super.specialize(templateBindings);
	}
}