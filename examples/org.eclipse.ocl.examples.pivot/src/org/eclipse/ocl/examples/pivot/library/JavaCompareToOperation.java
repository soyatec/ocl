/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: JavaGreaterThanOperation.java,v 1.1 2011/02/08 17:51:46 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.library;

import java.lang.reflect.Method;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.library.AbstractBinaryOperation;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.domain.values.ValueFactory;

public class JavaCompareToOperation extends AbstractBinaryOperation
{
	protected final @NonNull Method method;

	public JavaCompareToOperation(@NonNull Method method) {
		this.method = method;
	}

	public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, @NonNull Value leftValue, @NonNull Value rightValue) throws InvalidValueException {
		ValueFactory valueFactory = evaluator.getValueFactory();
		Object leftObject = leftValue.asObject();
		Object rightObject = rightValue.asObject();
		try {
			Object result = method.invoke(leftObject, rightObject);
			if (!(result instanceof Integer)) {
				return valueFactory.throwInvalidValueException(EvaluatorMessages.TypedResultRequired, "Integer");
			}
			return valueFactory.integerValueOf((Integer) result);
		} catch (Exception e) {
			throw new InvalidValueException(e);
		}
	}
}