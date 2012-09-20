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
import org.eclipse.ocl.examples.domain.elements.DomainExpression;
import org.eclipse.ocl.examples.domain.values.InvalidValue;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;

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

	protected final @NonNull InvalidValue value;

	public InvalidValueException(@NonNull InvalidValue value) {
		super(value.getMessage(), value.getException());
		this.value = value;
	}

	public InvalidValueException(@NonNull String message) {
		this(ValuesUtil.createInvalidValue(message));
	}

	public InvalidValueException(/*@NonNull*/ String messageTemplate, Object... bindings) {
		this(ValuesUtil.createInvalidValue(messageTemplate, bindings));
	}

	public InvalidValueException(@NonNull String message,
			@NonNull DomainEvaluationEnvironment evaluationEnvironment, @Nullable Object context, @Nullable DomainExpression expression) {
		this(ValuesUtil.createInvalidValue(message, evaluationEnvironment, context, expression));
	}

	public InvalidValueException(@NonNull String message, @Nullable Exception exception,
			@Nullable DomainEvaluationEnvironment evaluationEnvironment, @Nullable Object context, @Nullable DomainExpression expression) {
		this(ValuesUtil.createInvalidValue(message, exception, evaluationEnvironment, context, expression));
	}

	public InvalidValueException(@NonNull String message, @Nullable InvalidValue nestedValue,
			@Nullable DomainEvaluationEnvironment evaluationEnvironment, @Nullable Object context, @Nullable DomainExpression expression) {
		this(ValuesUtil.createInvalidValue(message, nestedValue, evaluationEnvironment, context, expression));
	}
		
	public @NonNull InvalidValue getValue() {
		return value;
	}
}
