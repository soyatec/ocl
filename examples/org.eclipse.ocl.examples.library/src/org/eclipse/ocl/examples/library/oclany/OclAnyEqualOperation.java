/**
 * <copyright>
 *
 * Copyright (c) 2009, 2013 E.D.Willink and others.
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
 * $Id: OclAnyEqualOperation.java,v 1.4 2011/05/07 16:41:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.oclany;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.library.AbstractSimpleBinaryOperation;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;

/**
 * OclAnyEqualOperation realises the OCLAny::=() library operation and
 * regular derived implementations since the Value classes exhibit
 * OCL value semantics.
 */
public class OclAnyEqualOperation extends AbstractSimpleBinaryOperation
{
	public static final @NonNull OclAnyEqualOperation INSTANCE = new OclAnyEqualOperation();

	@Override
	public @NonNull Boolean evaluate(@Nullable Object left, @Nullable Object right) {
		//
		//	A.2.2 is clear. 11.3.1 is vague.
		//
		if (left instanceof InvalidValueException) {
			throw (InvalidValueException)left;
		}
		if (right instanceof InvalidValueException) {
			throw (InvalidValueException)right;
		}
		if (left == null) {
			return right == null;
		}
		else if ((left instanceof DomainType) && (right instanceof DomainType)){
			boolean result = ((DomainType) left).getTypeId().equals(((DomainType) right).getTypeId());		// FIXME is this a sound/efficient tradeoff for not boxing?
			return result;
		}
		else {
			boolean result = left.equals(right);
			return result;
		}
	}
}
