/**
 * <copyright>
 *
 * Copyright (c) 2009,2010 E.D.Willink and others.
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
 * $Id: NumericGreaterThanEqualOperation.java,v 1.2 2011/01/24 19:56:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.oclany;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractBinaryOperation;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;

/**
 * OclComparableCompareToOperation realizes the abstract compareTo library operation using intrinsic Java functionality.
 */
public class OclComparableCompareToOperation extends AbstractBinaryOperation
{
	public static final @NonNull OclComparableCompareToOperation INSTANCE = new OclComparableCompareToOperation();

	public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object left, @Nullable Object right) {
		Object leftObject = asObject(left);
		Object rightObject = asObject(right);
		if (left == null) {
			return right == null;
		}
		if (!(leftObject instanceof Comparable<?>)) {
			throw new InvalidValueException("Unsupported compareTo for ''{0}''", left.getClass().getName()); //$NON-NLS-1$
		}
		@SuppressWarnings("unchecked")
		int intComparison = ((Comparable<Object>)leftObject).compareTo(rightObject);
		return ValuesUtil.integerValueOf(intComparison);
	}
}
