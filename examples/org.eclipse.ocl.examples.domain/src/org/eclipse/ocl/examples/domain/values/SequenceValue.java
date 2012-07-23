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
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;

public interface SequenceValue extends CollectionValue
{
	/**
	 * @generated NOT
	 */
	interface Accumulator extends CollectionValue.Accumulator, SequenceValue {}
	
	/**
	 * @generated NOT
	 */
	@NonNull SequenceValue append(@NonNull Value object) throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	@NonNull Value at(int index) throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	@NonNull Value first() throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	@NonNull SequenceValue insertAt(int index, @NonNull Value object) throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	@NonNull IntegerValue indexOf(@NonNull Value object) throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	@NonNull Value last() throws InvalidValueException;

	/**
	 * @generated NOT
	 */
    @NonNull SequenceValue prepend(@NonNull Value object) throws InvalidValueException;

	/**
	 * @generated NOT
	 */
    @NonNull SequenceValue reverse() throws InvalidValueException;

	/**
	 * @generated NOT
	 */
    @NonNull SequenceValue subSequence(int lower, int upper) throws InvalidValueException;
}
