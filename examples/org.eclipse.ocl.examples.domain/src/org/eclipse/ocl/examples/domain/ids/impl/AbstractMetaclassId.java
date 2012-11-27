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
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainParameterTypes;
import org.eclipse.ocl.examples.domain.ids.IdVisitor;
import org.eclipse.ocl.examples.domain.ids.MetaclassId;
import org.eclipse.ocl.examples.domain.ids.OperationId;
import org.eclipse.ocl.examples.domain.ids.PropertyId;
import org.eclipse.ocl.examples.domain.ids.TemplateBindings;
import org.eclipse.ocl.examples.domain.ids.TemplateParameterId;
import org.eclipse.ocl.examples.domain.ids.TypeId;

public abstract class AbstractMetaclassId extends AbstractElementId implements MetaclassId
{
	protected final int hashCode;

	protected AbstractMetaclassId(int hashCode) {
		this.hashCode = hashCode;
	}

	public @Nullable <R> R accept(@NonNull IdVisitor<R> visitor) {
		return visitor.visitMetaclassId(this);
	}

	public @NonNull MetaclassId getGeneralizedId() {
		return TypeId.METACLASS;
	}

	public @NonNull String getMetaTypeName() {
		return TypeId.METACLASS_NAME;
	}

	public @NonNull String getName() {
		return TypeId.METACLASS_NAME;
	}

	@NonNull
	public OperationId getOperationId(@NonNull TemplateParameterId[] templateParameters,
			@NonNull String name, @NonNull DomainParameterTypes parameterTypes) {
		throw new UnsupportedOperationException();
	}

    public @NonNull PropertyId getPropertyId(@NonNull String name) {
    	throw new UnsupportedOperationException();
    }

	@NonNull
	public TemplateParameterId getTemplateParameterId(int index) {
    	throw new UnsupportedOperationException();
	}

	@NonNull
	public TemplateParameterId[] getTemplateParameters() {
    	throw new UnsupportedOperationException();
	}

	@Override
	public final int hashCode() {
		return hashCode;
	}

	@NonNull
	public TypeId specialize(@NonNull TemplateBindings templateBindings) {
    	throw new UnsupportedOperationException();
	}
}