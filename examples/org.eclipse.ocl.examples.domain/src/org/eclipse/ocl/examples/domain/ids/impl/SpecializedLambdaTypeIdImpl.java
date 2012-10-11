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
import org.eclipse.ocl.examples.domain.ids.LambdaTypeId;
import org.eclipse.ocl.examples.domain.ids.TemplateBindings;

public class SpecializedLambdaTypeIdImpl extends AbstractSpecializedIdImpl<LambdaTypeId> implements LambdaTypeId
{
	public SpecializedLambdaTypeIdImpl(@NonNull LambdaTypeId generalizedId, @NonNull TemplateBindings templateBindings) {
		super(generalizedId, templateBindings);
	}

	public @Nullable <R> R accept(@NonNull IdVisitor<R> visitor) {
		return visitor.visitLambdaTypeId(this);
	}

	@Override
	protected @NonNull LambdaTypeId createSpecializedId(@NonNull TemplateBindings templateBindings) {
		return new SpecializedLambdaTypeIdImpl(this, templateBindings);
	}

	public @NonNull DomainParameterTypes getParameterTypes() {
		return generalizedId.getParameterTypes();
	}

    public @NonNull LambdaTypeId specialize(@NonNull TemplateBindings templateBindings) {
    	return createSpecializedId(templateBindings);
	}
}