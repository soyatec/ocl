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

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainEnumerationLiteral;
import org.eclipse.ocl.examples.domain.ids.IdManager;

/**
 * @generated NOT
 */
public class EnumerationLiteralValueImpl extends AbstractEnumerationLiteralValueImpl
{
	protected final @NonNull DomainEnumerationLiteral enumerationLiteral;
//	private EEnumLiteral eEnumLiteral;

	public EnumerationLiteralValueImpl(@NonNull DomainEnumerationLiteral enumerationLiteral) {
		super(IdManager.INSTANCE.getEnumerationLiteralId(enumerationLiteral));
		this.enumerationLiteral = enumerationLiteral;
	}

//	public EnumerationLiteralValueImpl(@NonNull DomainEnumerationLiteral enumerationLiteral, @NonNull EEnum eEnum) {
//		super(IdManager.INSTANCE.getEnumerationLiteralId(enumerationLiteral));
//		this.enumerationLiteral = enumerationLiteral;
//		this.eEnumLiteral = eEnum.getEEnumLiteral(enumerationLiteral.getName());
//	}

	@Override
	public Enumerator asEcoreObject() {
//		if (eEnumLiteral == null) {
		EEnumLiteral eEnumLiteral = enumerationLiteral.asEcoreObject();
//		}
		return eEnumLiteral != null ? eEnumLiteral.getInstance() : null;
	}
	
//	@Override
//	public DomainEnumerationLiteral asElement() {
//		return enumerationLiteral;
//	}

	public @NonNull Object asObject() {
		return enumerationLiteral;
	}

//	public DomainEnumerationLiteral getElement() {
//		return enumerationLiteral;
//	}

	@Override
	public String toString() {
		return String.valueOf(enumerationLiteral);
	}
}
