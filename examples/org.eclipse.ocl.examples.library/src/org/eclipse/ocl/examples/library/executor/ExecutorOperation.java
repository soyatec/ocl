/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainInheritance;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainParameterTypes;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.elements.DomainTypeParameters;
import org.eclipse.ocl.examples.domain.ids.OperationId;
import org.eclipse.ocl.examples.domain.library.LibraryFeature;
import org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation;

public class ExecutorOperation implements DomainOperation
{
	protected final @NonNull String name;
	protected final @NonNull DomainInheritance inheritance;
	protected final int index;
	protected final @NonNull LibraryFeature implementation;
	protected final @NonNull DomainParameterTypes parameterTypes;	
	protected final @NonNull DomainTypeParameters typeParameters;
	
	public ExecutorOperation(@NonNull String name, @NonNull DomainParameterTypes parameterTypes, @NonNull DomainInheritance inheritance, int index, @NonNull DomainTypeParameters typeParameters, @Nullable LibraryFeature implementation) {
		this.name = name;
		this.inheritance = inheritance;
		this.index = index;
		this.implementation = implementation != null ? implementation : OclAnyUnsupportedOperation.INSTANCE;		// FIXME
		this.parameterTypes = parameterTypes;
		this.typeParameters = typeParameters;
	}
	
/*	@Deprecated
	public ExecutorOperation(@NonNull String name, @NonNull DomainParameterTypes parameterTypes, @NonNull DomainInheritance inheritance, int index, @Nullable LibraryFeature implementation) {
		this.name = name;
		this.inheritance = inheritance;
		this.index = index;
		this.implementation = implementation != null ? implementation : OclAnyUnsupportedOperation.INSTANCE;		// FIXME
		this.parameterTypes = parameterTypes;
		this.typeParameters = DomainTypeParameters.EMPTY_LIST;
	}
	
	@Deprecated
	public ExecutorOperation(@NonNull String name, @NonNull DomainInheritance inheritance, int index, @Nullable LibraryFeature implementation, ExecutorTypeArgument... parameterTypes) {
		this.name = name;
		this.inheritance = inheritance;
		this.index = index;
		this.implementation = implementation != null ? implementation : OclAnyUnsupportedOperation.INSTANCE;		// FIXME
		@SuppressWarnings("null") @NonNull ExecutorTypeArgument[] parameterTypes2 = parameterTypes;
		this.parameterTypes = new DomainParameterTypes(parameterTypes2);
		this.typeParameters = DomainTypeParameters.EMPTY_LIST;			// FIXME
	} */

	public @NonNull LibraryFeature getImplementation() {
		return implementation;
	}

	public final int getIndex() {
		return index;
	}

	public final @NonNull DomainInheritance getInheritance(@NonNull DomainStandardLibrary standardLibrary) {
		return inheritance;
	}

	public final String getName() {
		return name;
	}

	public @NonNull OperationId getOperationId() {
		throw new UnsupportedOperationException();			// FIXME
	}

	public @NonNull DomainType getOwningType() {
		throw new UnsupportedOperationException();			// FIXME
	}

	public @NonNull DomainParameterTypes getParameterTypes() {
		return parameterTypes;
	}

	public @NonNull DomainType getType() {
//		return executorType;
		throw new UnsupportedOperationException(); // WIP FIXME
	}

	public @NonNull DomainTypeParameters getTypeParameters() {
		return typeParameters;
	}

	public boolean isStatic() {
		return false;								// WIP FIXME
	}

	@Override
	public String toString() {
		return inheritance.toString() + "::" + name; //$NON-NLS-1$
	}
}