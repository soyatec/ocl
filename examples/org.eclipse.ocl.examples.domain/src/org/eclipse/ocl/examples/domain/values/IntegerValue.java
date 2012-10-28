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

import org.eclipse.jdt.annotation.NonNull;

public interface IntegerValue extends NumericValue
{	
	/**
	 * @generated NOT
	 */
	interface Accumulator extends IntegerValue {
		void setValue(@NonNull Integer value);	
	}

	/**
	 * @generated NOT
	 */
	@NonNull IntegerValue add(@NonNull IntegerValue right);

	/**
	 * @generated NOT
	 */
	@NonNull IntegerValue div(@NonNull IntegerValue right);

	/**
	 * @generated NOT
	 */
	@NonNull RealValue divide(@NonNull IntegerValue right);

	/**
	 * @generated NOT
	 */
	int intValue();

	/**
	 * @generated NOT
	 */
	boolean isUnlimitedNatural();

	/**
	 * @generated NOT
	 */
	@NonNull IntegerValue max(@NonNull IntegerValue right);

	/**
	 * @generated NOT
	 */
	@NonNull IntegerValue min(@NonNull IntegerValue right);

	/**
	 * @generated NOT
	 */
	@NonNull IntegerValue mod(@NonNull IntegerValue right);

	/**
	 * @generated NOT
	 */
	@NonNull IntegerValue multiply(@NonNull IntegerValue right);

	/**
	 * @generated NOT
	 */
	@NonNull IntegerValue negate();

	/**
	 * @generated NOT
	 */
	@NonNull IntegerValue subtract(@NonNull IntegerValue right);
}
