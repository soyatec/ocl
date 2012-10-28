/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.library.ecore;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.library.LibraryProperty;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.library.executor.ExecutorProperty;

public class EcoreExecutorProperty extends ExecutorProperty
{
	protected EStructuralFeature eFeature;
	
	public EcoreExecutorProperty(@NonNull String name, @NonNull EcoreExecutorType executorType, int propertyIndex, @NonNull LibraryProperty implementation) {
		super(name, executorType, propertyIndex, implementation);
	}

	@Override
	public void initValue(@NonNull DomainStandardLibrary standardLibrary, @NonNull Object objectValue, @Nullable Object propertyValue) {
		EObject eObject = (EObject) objectValue; //.asNavigableObject();
		Object eValue;
		if (propertyValue instanceof Value) {
			eValue = ((Value)propertyValue).asEcoreObject();
		}
		else {
			eValue = propertyValue;
		}
		eObject.eSet(eFeature, eValue);
	}
}