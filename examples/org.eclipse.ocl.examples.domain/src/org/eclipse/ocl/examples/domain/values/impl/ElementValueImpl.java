/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
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
package org.eclipse.ocl.examples.domain.values.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainElement;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.values.ElementValue;
import org.eclipse.ocl.examples.domain.values.ValueFactory;
import org.eclipse.ocl.examples.domain.values.ValuesPackage;

/**
 * @generated NOT
 */
public class ElementValueImpl extends ObjectValueImpl implements ElementValue
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ValuesPackage.Literals.ELEMENT_VALUE;
	}

	protected final @NonNull DomainElement object;
	protected DomainType type = null;
	
	public ElementValueImpl(@NonNull ValueFactory valueFactory, @NonNull DomainElement object) {
		super(valueFactory);
		this.object = object;
	}

	@Override
	public @NonNull DomainElement asElement() {
		return object;
	}

	@Override
	public @NonNull ElementValue asElementValue() {
		return this;
	}

	@Override
	public Object asObject() {
		return object;
	}

	public @NonNull DomainElement getElement() {
		return object;
	}

	@Override
	public @NonNull DomainElement getObject() {
		return object;
	}

	public @NonNull DomainType getType() {
		DomainType type2 = type;
		if (type2 == null) {
			type2 = type = valueFactory.getStandardLibrary().getType(object);
		}
		return type2;
	}

	@Override
	public int hashCode() {
		return object.hashCode();
	}
}
