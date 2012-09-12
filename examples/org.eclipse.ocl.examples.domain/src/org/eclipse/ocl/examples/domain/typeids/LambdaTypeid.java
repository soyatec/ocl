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
package org.eclipse.ocl.examples.domain.typeids;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainTypeParameters;

/**
 * A LambdaTypeid identifies a Lambda function name and parameters.
 */
class LambdaTypeid extends AbstractTypeid implements MatchableTypeid<DomainTypeParameters>
{
	protected final @NonNull String name;
	protected final @NonNull DomainTypeParameters typeParameters;
	
	LambdaTypeid(@NonNull String name, @NonNull DomainTypeParameters typeParameters, int hashCode) {
		super(hashCode);
		this.name = name;;
		this.typeParameters = typeParameters;
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

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(name);
		s.append(typeParameters);
		return s.toString();
	}
}