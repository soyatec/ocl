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
 * $Id: RealValue.java,v 1.4 2011/02/21 08:37:52 ewillink Exp $
 */
package org.eclipse.ocl.examples.domain.values;

import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;

public interface RealValue extends NumericValue
{
	/**
	 * @generated NOT
	 */
	RealValue abs() throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	RealValue add(RealValue right) throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	RealValue divide(RealValue right) throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	IntegerValue floor() throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	RealValue max(RealValue right) throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	RealValue min(RealValue right) throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	RealValue multiply(RealValue right) throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	RealValue negate() throws InvalidValueException;	

	/**
	 * @generated NOT
	 */
	IntegerValue round() throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	int signum() throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	RealValue subtract(RealValue right) throws InvalidValueException;
}
