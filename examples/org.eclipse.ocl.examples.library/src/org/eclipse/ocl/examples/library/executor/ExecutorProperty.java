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
import org.eclipse.ocl.examples.domain.elements.DomainInheritance;
import org.eclipse.ocl.examples.domain.elements.DomainProperty;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.LibraryProperty;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.ObjectValue;

public class ExecutorProperty implements DomainProperty
{
	protected final @NonNull String name;
	protected final @NonNull DomainInheritance executorType;
	protected final int propertyIndex;
	protected final @NonNull LibraryProperty implementation;
	protected ExecutorProperty opposite;
	
	public ExecutorProperty(@NonNull String name, @NonNull DomainInheritance executorType, int propertyIndex, @NonNull LibraryProperty implementation) {
		this.name = name;
		this.executorType = executorType;
		this.propertyIndex = propertyIndex;
		this.implementation = implementation;
		this.opposite = null;
	}

	public @NonNull LibraryProperty getImplementation() {
		return implementation;
	}

	public @NonNull DomainInheritance getInheritance(@NonNull DomainStandardLibrary standardLibrary) {
		return executorType;
	}

	public @NonNull String getName() {
		return name;
	}

	public @NonNull DomainProperty getOpposite() {
		return DomainUtil.nonNullState(opposite);
	}

	public DomainType getOwningType() {
		throw new UnsupportedOperationException();			// FIXME
	}

	public @NonNull DomainType getType() {
		return executorType;
	}

	public @NonNull TypeId getTypeId() {
		DomainType type2 = getType();
		return type2.getTypeId();
	}

	void initOpposite(@NonNull ExecutorProperty opposite) {
		this.opposite = opposite;
	}

	public boolean isStatic() {
		return false;								// WIP FIXME
	}

	public void setValue(@NonNull DomainStandardLibrary standardLibrary, @NonNull ObjectValue objectValue, @NonNull Object propertyValue) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public String toString() {
		return String.valueOf(executorType) + "::" + String.valueOf(name); //$NON-NLS-1$
	}
}