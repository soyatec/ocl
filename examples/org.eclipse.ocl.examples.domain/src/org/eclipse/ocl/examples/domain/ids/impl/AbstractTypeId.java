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
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainTypeParameters;
import org.eclipse.ocl.examples.domain.ids.EnumerationLiteralId;
import org.eclipse.ocl.examples.domain.ids.OperationId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.ids.TypeTemplateParameterId;

public abstract class AbstractTypeId extends AbstractElementId implements TypeId
{
	public @NonNull EnumerationLiteralId getEnumerationLiteralId(@NonNull String name) {
    	throw new UnsupportedOperationException();		// Only NestableTypeIds may have enumeration literals.
    }

	public @NonNull String getMetaTypeName() {
		return TypeId.CLASS_NAME;
	}

    public @NonNull OperationId getOperationId(@NonNull DomainOperation anOperation) {
    	throw new UnsupportedOperationException();		// Only NestableTypeIds may nest.
    }
	
    public @NonNull TypeTemplateParameterId getTemplateParameterId(int index) {
    	throw new UnsupportedOperationException();		// Only NestableTypeIds may be parameterized.
    }
    
	public @NonNull TypeId getSpecializedTypeId(@NonNull DomainTypeParameters typeParameters) {
    	throw new UnsupportedOperationException();		// Only NestableTypeIds may specialize.
    }
}