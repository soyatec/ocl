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
import org.eclipse.ocl.examples.domain.elements.DomainTypeParameters;
import org.eclipse.ocl.examples.domain.ids.IdVisitor;
import org.eclipse.ocl.examples.domain.ids.LambdaTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;

public class LambdaTypeIdImpl extends AbstractTypeId implements LambdaTypeId, MatchableId<DomainTypeParameters>
{
	protected final @NonNull Integer hashCode;			// Avoids the key getting prematurely garbage collected
	protected final @NonNull String name;
	protected final @NonNull DomainTypeParameters typeParameters;
	
	public LambdaTypeIdImpl(@NonNull String name, @NonNull DomainTypeParameters typeParameters, @NonNull Integer hashCode) {
		this.hashCode = hashCode;
		this.name = name;;
		this.typeParameters = typeParameters;
	}

	public @Nullable <R> R accept(@NonNull IdVisitor<R> visitor) {
		return visitor.visitLambdaId(this);
	}
	
	public @NonNull String getDisplayName() {
		StringBuilder s = new StringBuilder();
		s.append(name);
		s.append(typeParameters);
		String string2 = s.toString();
		assert string2 != null;
		return string2;
	}

	@Override public @NonNull String getMetaTypeName() {
		return TypeId.LAMBDA_TYPE_NAME;
	}

	@Override
	public final int hashCode() {
		return hashCode;
	}

	public boolean matches(@NonNull String thatName, @NonNull DomainTypeParameters thoseTypeParameters) {
		if (!this.name.equals(thatName)) {
			return false;
		}
		if (!this.typeParameters.equals(thoseTypeParameters)) {
			return false;
		}
		return true;
	}
}