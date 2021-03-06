/**
 * <copyright>
 *
 * Copyright (c) 2010, 2012 E.D.Willink and others.
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
 * $Id: Value.java,v 1.6 2011/05/07 16:41:16 ewillink Exp $
 */
package org.eclipse.ocl.examples.domain.values;


import org.eclipse.jdt.annotation.NonNull;

/**
 * The OCLValue interface must be implemented by any datatype for which Java's Object.equals is inappropriate
 * when OCL datatype equivalence is required.
 */
public interface OCLValue
{
	/**
	 * Return true if this is an equivalent OCL value to thatValue.
	 * <p>
	 * Note that the caller must check that the argument is an OCLValue and should also
	 * check for the shortcut case that this == thatValue. Implementations are therefore
	 * wasting time if they re-implement the shortcut.
	 */
	boolean oclEquals(@NonNull OCLValue thatValue);
	int oclHashCode();
}
