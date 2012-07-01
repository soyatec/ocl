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
 * $Id: IntegerValue.java,v 1.3 2011/02/21 08:37:52 ewillink Exp $
 */
package org.eclipse.ocl.examples.domain.values;

import java.math.BigInteger;

import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;

public interface IntegerValue extends NumericValue
{	
	/**
	 * @generated NOT
	 */
	interface Accumulator extends IntegerValue {
		void setValue(Integer value);	
	}
	
	/**
	 * @generated NOT
	 */
	BigInteger bigIntegerValue();

	/**
	 * @generated NOT
	 */
	IntegerValue add(IntegerValue right) throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	IntegerValue div(IntegerValue right) throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	RealValue divide(IntegerValue right) throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	IntegerValue max(IntegerValue right) throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	IntegerValue min(IntegerValue right) throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	IntegerValue mod(IntegerValue right) throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	IntegerValue multiply(IntegerValue right) throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	IntegerValue negate() throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	IntegerValue subtract(IntegerValue right) throws InvalidValueException;
}
