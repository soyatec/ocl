/**
 * <copyright>
 *
 * Copyright (c) 2010,2011 E.D.Willink and others.
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
 * $Id: TypeValueImpl.java,v 1.5 2011/04/25 09:49:14 ewillink Exp $
 */
package org.eclipse.ocl.examples.domain.values.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainMetaclass;
import org.eclipse.ocl.examples.domain.values.MetaclassValue;
import org.eclipse.ocl.examples.domain.values.ValueFactory;
import org.eclipse.ocl.examples.domain.values.ValuesPackage;

/**
 * @generated NOT
 */
public class MetaclassValueImpl extends TypeValueImpl implements MetaclassValue
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ValuesPackage.Literals.METACLASS_VALUE;
	}

	public MetaclassValueImpl(@NonNull ValueFactory valueFactory, @NonNull DomainMetaclass object) {
		super(valueFactory, object);
	}

	@Override
	public @NonNull MetaclassValue asMetaclassValue() {
		return this;
	}
	
	@Override
	public boolean equals(Object that) {
		if (!super.equals(that)) {
			return false;
		}
		if (!(that instanceof MetaclassValue)) {
			return false;
		}
		return object.equals(((MetaclassValue)that).getInstanceType());
//		DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
//		DomainInheritance thisInheritance = object.getInstanceType().getInheritance(standardLibrary); 
//		DomainInheritance thatInheritance = ((MetaclassValue)that).getInstanceType().getInheritance(standardLibrary); 
//		return thisInheritance == thatInheritance;
	}

	@Override
	public @NonNull DomainMetaclass getInstanceType() {
		return getObject();
	}

	@Override
	public @NonNull DomainMetaclass getObject() {
		return (DomainMetaclass) object;
	}
}
