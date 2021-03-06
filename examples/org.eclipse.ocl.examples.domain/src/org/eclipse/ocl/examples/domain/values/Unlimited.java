/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D.Willink and others.
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
 * $Id: Nameable.java,v 1.2 2011/01/24 20:49:36 ewillink Exp $
 */
package org.eclipse.ocl.examples.domain.values;

import org.eclipse.jdt.annotation.NonNull;

/**
 * Unlimited represents the unlimited value as a distinct java.lang.Number derived class that can be identified by instanceof.
 */
public class Unlimited extends Number
{
	private static final long serialVersionUID = 1L;

	public static @NonNull Unlimited INSTANCE = new Unlimited();

	private Unlimited() {}

	@Override
	public double doubleValue() {
		throw new UnsupportedOperationException("Unlimited has no doubleValue()");
	}

	@Override
	public float floatValue() {
		throw new UnsupportedOperationException("Unlimited has no floatValue()");
	}
	
	@Override
	public int intValue() {
		throw new UnsupportedOperationException("Unlimited has no intValue()");
	}

	@Override
	public long longValue() {
		throw new UnsupportedOperationException("Unlimited has no longValue()");
	}

	@Override
	public String toString() {
		return "*";
	}
}
