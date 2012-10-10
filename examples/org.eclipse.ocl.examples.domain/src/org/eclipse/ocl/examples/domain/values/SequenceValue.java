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
 * $Id: SequenceValue.java,v 1.3 2011/02/21 08:37:52 ewillink Exp $
 */
package org.eclipse.ocl.examples.domain.values;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

public interface SequenceValue extends CollectionValue
{
	/**
	 * @generated NOT
	 */
	interface Accumulator extends CollectionValue.Accumulator, SequenceValue {}
	
	/**
	 * @generated NOT
	 */
	@NonNull SequenceValue append(@Nullable Object object);

	/**
	 * @generated NOT
	 */
	@Nullable Object at(int index);

	/**
	 * @generated NOT
	 */
	@Nullable Object first();

	/**
	 * @generated NOT
	 */
	@NonNull SequenceValue insertAt(int index, @Nullable Object object);

	/**
	 * @generated NOT
	 */
	@NonNull IntegerValue indexOf(@Nullable Object object);

	/**
	 * @generated NOT
	 */
	@Nullable Object last();

	/**
	 * @generated NOT
	 */
    @NonNull SequenceValue prepend(@Nullable Object object);

	/**
	 * @generated NOT
	 */
    @NonNull SequenceValue reverse();

	/**
	 * @generated NOT
	 */
    @NonNull SequenceValue subSequence(int lower, int upper);
}
