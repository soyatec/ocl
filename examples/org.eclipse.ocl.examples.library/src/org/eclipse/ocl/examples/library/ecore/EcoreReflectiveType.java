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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainInheritance;
import org.eclipse.ocl.examples.domain.elements.DomainNamedElement;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainProperty;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.elements.DomainTypeParameters;
import org.eclipse.ocl.examples.domain.types.AbstractFragment;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.ObjectValue;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.library.executor.ReflectiveType;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibTables;

public class EcoreReflectiveType extends ReflectiveType
{
	protected final @NonNull EClassifier eClassifier;
	protected final @NonNull DomainTypeParameters typeParameters;
	
	public EcoreReflectiveType(@NonNull EcoreExecutorPackage evaluationPackage, int flags, @NonNull EClassifier eClassifier, @NonNull DomainNamedElement... typeParameters) {
		super(DomainUtil.nonNullEMF(eClassifier.getName()), evaluationPackage, flags);
		this.eClassifier = eClassifier;
		this.typeParameters = new DomainTypeParameters(typeParameters);
	}

	@Override
	protected @NonNull AbstractFragment createFragment(@NonNull DomainInheritance baseInheritance) {
		return new EcoreReflectiveFragment(this, baseInheritance);
	}

	@Override
	public @NonNull ObjectValue createInstance(@NonNull DomainStandardLibrary standardLibrary) {
		if (eClassifier instanceof EClass) {
			EClass eClass = (EClass)eClassifier;
			EObject element = eClass.getEPackage().getEFactoryInstance().create(eClass);
			return ValuesUtil.createObjectValue(DomainUtil.nonNullEMF(element));
		}
		return super.createInstance(standardLibrary);
	}

	public final @NonNull EClassifier getEClassifier() {
		return eClassifier;
	}

	@Override
	public @NonNull Iterable<? extends DomainInheritance> getInitialSuperInheritances() {
		throw new UnsupportedOperationException();		// FIXME
	}

	public @NonNull Iterable<? extends DomainOperation> getLocalOperations() {
		throw new UnsupportedOperationException();		// FIXME
	}

	public @NonNull Iterable<? extends DomainProperty> getLocalProperties() {
		throw new UnsupportedOperationException();		// FIXME
	}

	public @NonNull Iterable<? extends DomainType> getLocalSuperTypes() {
		throw new UnsupportedOperationException();		// FIXME
	}

	public @NonNull String getMetaTypeName() {
		return DomainUtil.nonNullPivot(eClassifier.getName());
	}

	public @NonNull DomainStandardLibrary getStandardLibrary() {
		return OCLstdlibTables.LIBRARY;
	}

	public @NonNull DomainTypeParameters getTypeParameters() {
		return typeParameters;
	}
}
