/**
 * <copyright>
 * 
 * Copyright (c) 2013 CEA LIST and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink(CEA LIST) - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.ocl.examples.codegen.java.types;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.java.JavaStream;
import org.eclipse.ocl.examples.domain.ids.ElementId;

public abstract class AbstractCollectionDescriptor extends AbstractValueDescriptor implements CollectionDescriptor
{
	public AbstractCollectionDescriptor(@NonNull ElementId elementId, @NonNull Class<?> javaClass) {
		super(elementId, javaClass);
	}

	public void append(@NonNull JavaStream javaStream, boolean reClass) {
		throw new UnsupportedOperationException();
	}

	public void appendElement(@NonNull JavaStream javaStream, boolean reClass) {
		throw new UnsupportedOperationException();
	}

	@Override
	public @Nullable CollectionDescriptor asCollectionDescriptor() {
		return this;
	}
}