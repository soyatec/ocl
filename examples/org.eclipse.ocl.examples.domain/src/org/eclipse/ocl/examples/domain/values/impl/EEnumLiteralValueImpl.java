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
import org.eclipse.ocl.examples.domain.ids.EnumerationLiteralId;

/**
 * @generated NOT
 */
public class EEnumLiteralValueImpl extends AbstractEnumerationLiteralValueImpl
{
	protected final @NonNull EEnumLiteral eEnumLiteral;

	public EEnumLiteralValueImpl(@NonNull EnumerationLiteralId enumerationLiteralId, @NonNull EEnumLiteral eEnumLiteral) {
		super(enumerationLiteralId);
		this.eEnumLiteral = eEnumLiteral;
	}

	@Override
	public Enumerator asEcoreObject() {
		return eEnumLiteral.getInstance();
	}

//	@Override
//	public DomainEnumerationLiteral asElement() {
//		return enumerationLiteral;
//	}

	public @NonNull Object asObject() {
		return eEnumLiteral;
	}

//	public DomainEnumerationLiteral getElement() {
//		return enumerationLiteral;
//	}

	@Override
	public String toString() {
		return String.valueOf(eEnumLiteral);
	}
}
