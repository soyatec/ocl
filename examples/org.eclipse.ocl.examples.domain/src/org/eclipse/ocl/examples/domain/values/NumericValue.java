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
	@NonNull NumericValue addInteger(@NonNull IntegerValue right);

	/**
	 * @generated NOT
	 */
	@NonNull NumericValue addReal(@NonNull RealValue right);
	
	/**
	 * @generated NOT
	 */
	@NonNull Number asNumber();

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
	@NonNull NumericValue commutatedAdd(@NonNull NumericValue left);

	/**
	 * @generated NOT
	 */
	@NonNull NumericValue commutatedDivide(@NonNull NumericValue left);

	/**
	 * @generated NOT
	 */
	@NonNull NumericValue commutatedMultiply(@NonNull NumericValue left);

	/**
	 * @generated NOT
	 */
	@NonNull NumericValue commutatedSubtract(@NonNull NumericValue left);

	/**
	 * @generated NOT
	 */
	int compareToInteger(@NonNull IntegerValue right);

	/**
	 * @generated NOT
	 */
	int compareToReal(@NonNull RealValue right);

	/**
	 * @generated NOT
	 */
	int compareToUnlimited(@NonNull UnlimitedValue right);

	/**
	 * @generated NOT
	 */
	@NonNull NumericValue divideInteger(@NonNull IntegerValue right);

	/**
	 * @generated NOT
	 */
	@NonNull NumericValue divideReal(@NonNull RealValue right);

	/**
	 * @generated NOT
	 */
	double doubleValue();

	/**
	 * @generated NOT
	 */
	@NonNull IntegerValue floor();
	
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
	@NonNull NumericValue max(@NonNull NumericValue right);

	/**
	 * @generated NOT
	 */
	@NonNull NumericValue maxInteger(@NonNull IntegerValue right);

	/**
	 * @generated NOT
	 */
	@NonNull NumericValue maxReal(@NonNull RealValue right);

	/**
	 * @generated NOT
	 */
	@NonNull NumericValue maxUnlimited(@NonNull UnlimitedValue right);

	/**
	 * @generated NOT
	 */
	@NonNull NumericValue min(@NonNull NumericValue right);

	/**
	 * @generated NOT
	 */
	@NonNull NumericValue minInteger(@NonNull IntegerValue right);

	/**
	 * @generated NOT
	 */
	@NonNull NumericValue minReal(@NonNull RealValue right);

	/**
	 * @generated NOT
	 */
	@NonNull NumericValue minUnlimited(@NonNull UnlimitedValue right);

	/**
	 * @generated NOT
	 */
	@NonNull NumericValue multiplyInteger(@NonNull IntegerValue right);

	/**
	 * @generated NOT
	 */
	@NonNull NumericValue multiplyReal(@NonNull RealValue right);

	/**
	 * @generated NOT
	 */
	@NonNull NumericValue negate();

	/**
	 * @generated NOT
	 */
	@NonNull IntegerValue round();

	/**
	 * @generated NOT
	 */
	int signum();

	/**
	 * @generated NOT
	 */
	@NonNull NumericValue subtractInteger(@NonNull IntegerValue right);

	/**
	 * @generated NOT
	 */
	@NonNull NumericValue subtractReal(@NonNull RealValue right);
}
