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
import org.eclipse.ocl.examples.domain.ids.TemplateParameterId;
import org.eclipse.ocl.examples.domain.ids.TypeId;

public class GeneralizedLambdaTypeIdImpl extends AbstractGeneralizedIdImpl<LambdaTypeId> implements LambdaTypeId, WeakHashMapOfListOfWeakReference3.MatchableId<String, DomainParameterTypes>
{
	protected final @NonNull DomainParameterTypes parameterTypes;		// NB functions arguments, not the template parameters
	
	public GeneralizedLambdaTypeIdImpl(@NonNull Integer hashCode, @NonNull TemplateParameterId[] templateParameters, @NonNull String name, @NonNull DomainParameterTypes parameterTypes) {
		super(hashCode, templateParameters, name);
		this.parameterTypes = parameterTypes;
	}

	public @Nullable <R> R accept(@NonNull IdVisitor<R> visitor) {
		return visitor.visitLambdaTypeId(this);
	}

	@Override
	protected @NonNull LambdaTypeId createSpecializedId(@NonNull TemplateBindings templateBindings) {
		return new SpecializedLambdaTypeIdImpl(this, templateBindings);
	}

	public @NonNull String getDisplayName() {
		StringBuilder s = new StringBuilder();
		if (templateParameters.length > 0) {
			s.append("<");
			boolean isFirst = true;
			for (TemplateParameterId templateParameter : templateParameters) {
				if (!isFirst) {
					s.append(",");
				}
				s.append(templateParameter.getName());
				isFirst = false;
			}
			s.append(">");
		}
		s.append(name);
		s.append("(");
		s.append(parameterTypes);
		s.append(")");
		String string2 = s.toString();
		assert string2 != null;
		return string2;
	}

	public @NonNull LambdaTypeId getGeneralizedId() {
		return this;
	}

	public @NonNull String getMetaTypeName() {
		return TypeId.LAMBDA_TYPE_NAME;
	}

	public @NonNull DomainParameterTypes getParameterTypes() {
		return parameterTypes;
	}

	public boolean matches(@NonNull String thatName, @NonNull DomainParameterTypes thoseParameterTypes) {
		if (!this.name.equals(thatName)) {
			return false;
		}
		if (!this.parameterTypes.equals(thoseParameterTypes)) {
			return false;
		}
		return true;
	}

    public @NonNull LambdaTypeId specialize(@NonNull TemplateBindings templateBindings) {
    	return createSpecializedId(templateBindings);
	}
}