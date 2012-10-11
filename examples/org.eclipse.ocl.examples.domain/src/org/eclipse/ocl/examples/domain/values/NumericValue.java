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
 * $Id: NumericValue.java,v 1.3 2011/02/21 08:37:52 ewillink Exp $
 */
package org.eclipse.ocl.examples.domain.values;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

public interface NumericValue extends Value, Comparable<NumericValue>
{
	/**
	 * @generated NOT
	 */
	@NonNull NumericValue abs();

	/**
	 * @generated NOT
	 */
	@NonNull BigDecimal bigDecimalValue();
	
	/**
	 * @generated NOT
	 */
	@NonNull BigInteger bigIntegerValue();
	
	/**
	 * @generated NOT
	 */
	@Nullable IntegerValue isIntegerValue();

	/**
	 * @generated NOT
	 */
	boolean isUnlimited();

	/**
	 * @generated NOT
	 */
	@NonNull NumericValue negate();

	/**
	 * @generated NOT
	 */
	double doubleValue();

	/**
	 * @generated NOT
	 */
	int signum();
}
