/**
 * <copyright>
 *
 * Copyright (c) 2011,2012 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.ocl.examples.library.executor;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;

/**
 * A ReflectivePackage builds a dispatch table representative of a model package at run-time using a minimal reflective API.
 */
public abstract class ReflectivePackage extends ExecutorPackage
{
	protected @Nullable Map<DomainType, ReflectiveType> types = null;

	public ReflectivePackage(@NonNull String name, @Nullable String nsPrefix, @Nullable String nsURI) {
		super(name, nsPrefix, nsURI);
	}
	
	protected @NonNull Map<DomainType, ReflectiveType> computeClasses() {
		Map<DomainType, ReflectiveType> types2 = types = new HashMap<DomainType, ReflectiveType>();
		for (DomainType domainType : getDomainTypes()) {
			ReflectiveType executorType = createExecutorType(DomainUtil.nonNullEntry(domainType));
			types2.put(domainType, executorType);
		}
		return types2;
	}

	protected abstract @NonNull ReflectiveType createExecutorType(@NonNull DomainType domainType);

	protected abstract @NonNull Iterable<? extends DomainType> getDomainTypes();

	public @NonNull ReflectiveType getInheritance(@NonNull DomainType type) {
		Map<DomainType, ReflectiveType> types2 = types;
		if (types2 == null) {
			types2 = computeClasses();
		}
		return DomainUtil.nonNullState(types2.get(type));
	}

	public @NonNull Iterable<? extends DomainType> getOwnedType() {
		Map<DomainType, ReflectiveType> types2 = types;
		if (types2 == null) {
			types2 = computeClasses();
		}
		return DomainUtil.nonNullJDT(types2.values());
	}

	protected abstract @NonNull DomainStandardLibrary getStandardLibrary();
}