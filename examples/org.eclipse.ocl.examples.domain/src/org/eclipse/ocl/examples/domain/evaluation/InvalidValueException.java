/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: InvalidValueException.java,v 1.1 2011/02/21 08:37:53 ewillink Exp $
 */

package org.eclipse.ocl.examples.domain.evaluation;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.InvalidValue;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueImpl;

/**
 * An InvalidValueException wraps an InvalidValue and is used to return the InvalidValue
 * to the caller. Exceptions are a
 * is thrown when an Invalid Value arises during
 * an evaluation, and when no EvaluationEnvironment is available to support
 * throwing an InvalidEvaluationException. When such an environment is
 * available the InvalidValueException is rethrown as an 
 * InvalidEvaluationException.
 */
public class InvalidValueException extends DomainException
{
	private static final long serialVersionUID = 1L;

	private /*@LazyNonNull*/ InvalidValue value = null;
	
	public InvalidValueException(@Nullable Exception exception, /*@NonNull*/ String message) {
		super(message, exception);
	}

	public InvalidValueException(/*@NonNull*/ String messageTemplate, Object... bindings) {
		this(null, DomainUtil.bind(messageTemplate, bindings));
	}

	public InvalidValueException(@Nullable Exception exception) {
		super(exception);
	}

	public InvalidValueException(@Nullable Exception exception, /*@NonNull*/ String messageTemplate, Object... bindings) {
		this(exception, DomainUtil.bind(messageTemplate, bindings));
	}
		
	public synchronized @NonNull InvalidValue getValue() {
		InvalidValue value2 = value;
		if (value2 == null) {
			value = value2 = new InvalidValueImpl(this);
		}
		return value2;
	}
}
