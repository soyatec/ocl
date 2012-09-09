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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainMetaclass;
import org.eclipse.ocl.examples.domain.elements.DomainInheritance;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.values.TypeValue;
import org.eclipse.ocl.examples.domain.values.ValueFactory;
import org.eclipse.ocl.examples.domain.values.ValuesPackage;

/**
 * @generated NOT
 */
public abstract class TypeValueImpl extends ObjectValueImpl implements TypeValue
{
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
	private DomainMetaclass metaclass;

	public TypeValueImpl(@NonNull ValueFactory valueFactory, @NonNull DomainType object) {
		super(valueFactory);
		this.object = object;
		this.metaclass = null;
	}

	@Override
	public DomainType asElement() {
		return object;
	}

	@Override
	public @NonNull TypeValue asElementValue() {
		return this;
	}

	@Override
	public @NonNull EObject asNavigableObject() throws InvalidValueException {
		if (object instanceof EObject) {
			return (EObject) object;
		} else {
			return (EObject) valueFactory.throwInvalidValueException(
				EvaluatorMessages.TypedValueRequired, "Object", getType());
		}
	}

	@Override
	public Object asObject() {
		return object;
	}

	@Override
	public @NonNull TypeValueImpl asTypeValue() {
		return this;
	}

	@Override
	public boolean equals(Object that) {
		if (this == that) {
			return true;
		}
		if (!(that instanceof TypeValue)) {
			return false;
		}
		DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
		DomainInheritance thisInheritance = object.getInheritance(standardLibrary);
		try {
			DomainType thatInstanceType = ((TypeValue) that).getInstanceType();
			DomainInheritance thatInheritance = thatInstanceType.getInheritance(standardLibrary);
			return thisInheritance == thatInheritance;
		} catch (InvalidValueException e) {
			return false;
		}
	}

	public @NonNull DomainType getElement() {
		return object;
	}

	public @NonNull DomainType getInstanceType() {
		return object;
	}

	@Override
	public @NonNull DomainType getObject() {
		return object;
	}

	public @NonNull DomainMetaclass getType() {
		DomainMetaclass metaclass2 = metaclass;
		if (metaclass2 == null) {
			metaclass2 = metaclass = valueFactory.getStandardLibrary().getMetaclass(object);
		}
		return metaclass2;
	}

	@Override
	public int hashCode() {
		return object.hashCode();
	}
}
