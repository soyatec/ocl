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
package org.eclipse.ocl.examples.library.ecore;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainInheritance;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.domain.ids.PackageId;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.library.executor.ExecutorPackage;
import org.eclipse.ocl.examples.library.executor.ExecutorStandardLibrary;

public class EcoreReflectivePackage extends ExecutorPackage
{
	protected final @NonNull ExecutorStandardLibrary standardLibrary;
	protected final EPackage ePackage;
	protected @Nullable Map<EClassifier, DomainInheritance> types = null;
	
	public EcoreReflectivePackage(@NonNull EPackage ePackage, @NonNull ExecutorStandardLibrary standardLibrary, @NonNull PackageId packageId) {
		super(DomainUtil.nonNullEMF(ePackage.getName()), ePackage.getNsPrefix(), ePackage.getNsURI(), packageId);
		this.standardLibrary = standardLibrary;
		this.ePackage = ePackage;
	}
	
	protected synchronized @NonNull Map<EClassifier, DomainInheritance> computeClasses() {
		Map<EClassifier, DomainInheritance> types2 = types = new HashMap<EClassifier, DomainInheritance>();
		for (EClassifier eClassifier : ePackage.getEClassifiers()) {
			if (eClassifier != null) {
				DomainInheritance executorType = new EcoreReflectiveType(this, 0, eClassifier);
				types2.put(eClassifier, executorType);
			}
		}
		return types2;
	}

//	@Override
//	protected @NonNull DomainInheritance createExecutorType(@NonNull DomainType domainType) {
//		throw new UnsupportedOperationException();		// FIXME
//	}

//	@Override
//	protected @NonNull Iterable<? extends DomainType> getDomainTypes() {
//		throw new UnsupportedOperationException();		// FIXME
//	}

	public Iterable<? extends DomainPackage> getNestedPackage() {
		throw new UnsupportedOperationException();		// FIXME
	}

	public DomainPackage getNestingPackage() {
		throw new UnsupportedOperationException();		// FIXME
	}

	public Iterable<DomainInheritance> getOwnedType() {
		Map<EClassifier, DomainInheritance> types2 = types;
		if (types2 == null) {
			types2 = computeClasses();
		}
		@SuppressWarnings("null")
		@NonNull Collection<DomainInheritance> values2 = types2.values();
		return values2;
	}

	public @NonNull ExecutorStandardLibrary getStandardLibrary() {
		return standardLibrary;
	}
}
