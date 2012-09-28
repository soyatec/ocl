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
import org.eclipse.ocl.examples.domain.ids.OperationId;
import org.eclipse.ocl.examples.domain.ids.TemplateBindings;
import org.eclipse.ocl.examples.domain.ids.TemplateParameterId;
import org.eclipse.ocl.examples.domain.ids.TypeId;

public class GeneralizedOperationIdImpl extends AbstractGeneralizedIdImpl<OperationId> implements OperationId, WeakHashMapOfListOfWeakReference3.MatchableId<String, DomainParameterTypes>
{
	protected final @NonNull TypeId parentId;
	protected final @NonNull DomainParameterTypes parameterTypes;		// NB functions arguments, not the template parameters
	
	public GeneralizedOperationIdImpl(@NonNull Integer hashCode, @NonNull TypeId parentId, @NonNull TemplateParameterId[] templateParameters, @NonNull String name, @NonNull DomainParameterTypes parameterTypes) {
		super(hashCode, templateParameters, name);
		this.parentId = parentId;
		this.parameterTypes = parameterTypes;
	}

	public @Nullable <R> R accept(@NonNull IdVisitor<R> visitor) {
		return visitor.visitOperationId(this);
	}

	@Override
	protected @NonNull OperationId createSpecializedId(@NonNull TemplateBindings templateBindings) {
		return new SpecializedOperationIdImpl(this, templateBindings);
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
		s.append(parentId);
		s.append("::");
		s.append(name);
		s.append(parameterTypes);
		String string2 = s.toString();
		assert string2 != null;
		return string2;
	}

	public @NonNull OperationId getGeneralizedId() {
		return this;
	}

	public @NonNull String getMetaTypeName() {
		return TypeId.OPERATION_NAME;
	}

	public @NonNull DomainParameterTypes getParameterTypes() {
		return parameterTypes;
	}

	public @NonNull TypeId getParent() {
		return parentId;
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
}