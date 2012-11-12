/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.codegen.generator;

public class GenModelException extends CodeGenException
{
	private static final long serialVersionUID = 1L;

	public GenModelException(String message) {
		super(message);
	}

	public GenModelException(Throwable cause) {
		super(cause);
	}
	
	public GenModelException(String message, Throwable cause) {
		super(message, cause);
	}
}