/**
 * <copyright>
 *
 * Copyright (c) 2009,2010 E.D.Willink and others.
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
 * $Id: OclVoidAndOperation.java,v 1.2 2011/01/24 19:56:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.oclvoid;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.library.AbstractBinaryOperation;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;

/**
 * OclVoidAndOperation realises the OclVoid::and() library operation.
 */
public class OclVoidAndOperation extends AbstractBinaryOperation
{
	public static final @NonNull OclVoidAndOperation INSTANCE = new OclVoidAndOperation();

	public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, @NonNull Object left, @NonNull Object right) throws InvalidValueException {
		if (isFalse(right)) {
			return ValuesUtil.asBoolean(right);			// Simple type cast
		}
		else {
			return ValuesUtil.asBoolean(left);			// Guaranteed exception
		}
	}
}
