/**
 * <copyright>
 *
 * Copyright (c) 2013 CEA LIST and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink (CEA LIST) - initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.library.executor;

import java.util.Collection;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.TuplePartId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.LibraryFeature;
import org.eclipse.ocl.examples.domain.types.AbstractType;
import org.eclipse.ocl.examples.domain.types.IdResolver;

public class ExecutorTupleType extends AbstractType implements ExecutorTypeArgument
{
	protected final @NonNull TypeId typeId;

	public ExecutorTupleType(@NonNull DomainStandardLibrary standardLibrary, @NonNull String name, @NonNull Collection<? extends TuplePartId> parts) {
		super(standardLibrary, name);
		typeId = IdManager.getTupleTypeId(name, parts);
	}

	public boolean conformsTo(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainType type) {
		throw new UnsupportedOperationException();			// WIP fixme
	}

	public boolean isEqualTo(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainType type) {
		throw new UnsupportedOperationException();			// WIP fixme
	}

	public @NonNull LibraryFeature lookupImplementation(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainOperation staticOperation) {
		throw new UnsupportedOperationException();			// WIP fixme
	}

	public DomainOperation lookupOperation(DomainStandardLibrary standardLibrary, @NonNull String operationName, DomainType... argumentTypes) {
		throw new UnsupportedOperationException();			// WIP fixme
	}

	@Override
	public @NonNull DomainType getCommonType(@NonNull IdResolver idResolver, @NonNull DomainType type) {
		throw new UnsupportedOperationException();			// WIP fixme
	}

	public @NonNull TypeId getTypeId() {
		return typeId;
	}
}