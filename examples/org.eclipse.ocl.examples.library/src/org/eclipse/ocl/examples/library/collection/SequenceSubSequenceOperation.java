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
 * $Id: SequenceSubSequenceOperation.java,v 1.3 2011/02/21 08:37:46 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.collection;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.library.AbstractSimpleTernaryOperation;
import org.eclipse.ocl.examples.domain.values.SequenceValue;

/**
 * SequenceSubSequenceOperation realises the OrderedSet::subSequence() library operation.
 */
public class SequenceSubSequenceOperation extends AbstractSimpleTernaryOperation
{
	public static final @NonNull SequenceSubSequenceOperation INSTANCE = new SequenceSubSequenceOperation();

	@Override
	public @NonNull SequenceValue evaluate(@Nullable Object sourceValue, @Nullable Object firstArgumentValue, @Nullable Object secondArgumentValue) {
		SequenceValue selfValue = asSequenceValue(sourceValue);
		Integer fromValue = asInteger(firstArgumentValue);
		Integer toValue = asInteger(secondArgumentValue);
		return selfValue.subSequence(fromValue, toValue);
	}
}
