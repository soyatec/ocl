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
 *   C.Damus - Initial API and implementation
 * 
 * </copyright>
 *
 * $Id: OCLDelegateException.java,v 1.1 2011/01/30 11:16:29 ewillink Exp $
 */
package org.eclipse.ocl.common.delegate;

import org.eclipse.emf.common.util.WrappedException;

/**
 */
public class OCLDelegateException extends WrappedException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OCLDelegateException(String message) {
		super(message, null);
	}

	public OCLDelegateException(String message, Exception cause) {
		super(message, cause);
	}
}