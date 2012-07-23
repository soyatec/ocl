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
import org.eclipse.ocl.examples.domain.elements.DomainCollectionType;
import org.eclipse.ocl.examples.domain.elements.DomainInheritance;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.values.CollectionTypeValue;
import org.eclipse.ocl.examples.domain.values.ValueFactory;
import org.eclipse.ocl.examples.domain.values.ValuesPackage;

/**
 * @generated NOT
 */
public class CollectionTypeValueImpl extends TypeValueImpl implements CollectionTypeValue
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ValuesPackage.Literals.COLLECTION_TYPE_VALUE;
	}

	public CollectionTypeValueImpl(@NonNull ValueFactory valueFactory, @NonNull DomainCollectionType object) {
		super(valueFactory, object);
	}
	
	@Override
	public boolean equals(Object that) {
		if (!super.equals(that)) {
			return false;
		}
		if (!(that instanceof CollectionTypeValue)) {
			return false;
		}
		DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
		DomainInheritance thisInheritance = getObject().getElementType().getInheritance(standardLibrary); 
		DomainInheritance thatInheritance = ((CollectionTypeValue)that).getInstanceType().getElementType().getInheritance(standardLibrary); 
		return thisInheritance == thatInheritance;
	}

	@Override
	public @NonNull DomainCollectionType getInstanceType() {
		return getObject();
	}

	@Override
	public @NonNull DomainCollectionType getObject() {
		return (DomainCollectionType) object;
	}
}
