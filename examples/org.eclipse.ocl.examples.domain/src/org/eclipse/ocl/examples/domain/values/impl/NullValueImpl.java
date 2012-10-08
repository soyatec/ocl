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
 * $Id: NullValueImpl.java,v 1.4 2011/02/21 08:37:52 ewillink Exp $
 */
package org.eclipse.ocl.examples.domain.values.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainElement;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.ids.OclVoidTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.values.NullValue;
import org.eclipse.ocl.examples.domain.values.ValuesPackage;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;

/**
 * @generated NOT
 */
public class NullValueImpl extends UndefinedCollectionValueImpl implements NullValue
{

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ValuesPackage.Literals.NULL_VALUE;
	}

	public NullValueImpl() {}

	@Override
	public Object asEcoreObject() {
		return null;
	}

	@Override
	public DomainElement asElement() {
		return null;
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof NullValue;
	}

	public @NonNull OclVoidTypeId getCollectionTypeId() {
		return TypeId.OCL_VOID;
	}

	public @NonNull DomainType getType(@NonNull DomainStandardLibrary standardLibrary) {
		return standardLibrary.getOclVoidType();
	}

	public @NonNull OclVoidTypeId getTypeId() {
		return TypeId.OCL_VOID;
	}

	@Override
	public int hashCode() {
		return 0x11111111;
	}

	public int intValue() {
    	toInvalidValue();		// throws rather than returns
    	return 0;
	}

//	@Override
//	public boolean isNull() {
//		return true;
//	}

	@Override
	public String toString() {
		return ValuesUtil.NULL_STRING;
	}
}
