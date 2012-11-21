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

import org.eclipse.jdt.annotation.NonNull;

public interface RealValue extends NumericValue
{
	/**
	 * @generated NOT
	 */
	@NonNull RealValue abs();

	/**
	 * @generated NOT
	 */
	@NonNull RealValue addReal(@NonNull RealValue right);

	/**
	 * @generated NOT
	 */
	int compareToReal(@NonNull RealValue right);

	/**
	 * @generated NOT
	 */
	@NonNull RealValue divideReal(@NonNull RealValue right);

	/**
	 * @generated NOT
	 */
	@NonNull RealValue maxReal(@NonNull RealValue right);

	/**
	 * @generated NOT
	 */
	@NonNull RealValue minReal(@NonNull RealValue right);

	/**
	 * @generated NOT
	 */
	@NonNull RealValue multiplyReal(@NonNull RealValue right);

	/**
	 * @generated NOT
	 */
	@NonNull RealValue negate();	

	/**
	 * @generated NOT
	 */
	int signum();

	/**
	 * @generated NOT
	 */
	@NonNull RealValue subtractReal(@NonNull RealValue right);
}
