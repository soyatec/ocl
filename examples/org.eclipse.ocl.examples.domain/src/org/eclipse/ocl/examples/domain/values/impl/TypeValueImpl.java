/**
 * <copyright>
 *
 * Copyright (c) 2010,2012 E.D.Willink and others.
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
package org.eclipse.ocl.examples.domain.values.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.values.TypeValue;
import org.eclipse.ocl.examples.domain.values.ValuesPackage;

/**
 * @generated NOT
 */
public class TypeValueImpl extends ValueImpl implements TypeValue {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ValuesPackage.Literals.TYPE_VALUE;
	}

	protected final @NonNull DomainType object;
	private TypeId typeId = null;

	public TypeValueImpl(@NonNull DomainType object) {
		this.object = object;
	}

	@Override
	public DomainType asElement() {
		return object;
	}

	@Override
	public @NonNull EObject asNavigableObject() {
		if (object instanceof EObject) {
			return (EObject) object;
		} else {
			throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, "Object", getTypeName());
		}
	}

	public @NonNull Object asObject() {
		return object;
	}

	@Override
	public boolean equals(Object that) {
		if (this == that) {
			return true;
		}
		if (!(that instanceof TypeValue)) {
			return false;
		}
		return getTypeId() == ((TypeValue)that).getTypeId();
	}

	public @NonNull DomainType getElement() {
		return object;
	}

	public @NonNull DomainType getInstanceType() {
		return object;
	}

	public @NonNull DomainType getObject() {
		return object;
	}

//	public @NonNull DomainMetaclass getType(@NonNull DomainStandardLibrary standardLibrary) {
//		return standardLibrary.getMetaclass(object);
//	}

	public @NonNull TypeId getTypeId() {
		TypeId typeId2 = typeId;
		if (typeId2 == null) {
			typeId = typeId2 = TypeId.METACLASS.getCollectedTypeId(object.getTypeId());
		}
		return typeId2;
	}

	@Override
	public int hashCode() {
		return object.hashCode();
	}

	@Override
	public String toString() {
		return String.valueOf(object);
	}
}
