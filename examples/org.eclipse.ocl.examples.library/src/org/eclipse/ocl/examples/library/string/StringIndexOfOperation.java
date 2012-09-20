/**
 * <copyright>
 *
 * Copyright (c) 2010,2012 E.D.Willink and others.
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
 * $Id: StringIndexOfOperation.java,v 1.4 2011/02/21 08:37:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.string;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractBinaryOperation;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;

/**
 * StringIndexOfOperation realises the String::indexOf() library operation.
 */
public class StringIndexOfOperation extends AbstractBinaryOperation
{
	public static final @NonNull StringIndexOfOperation INSTANCE = new StringIndexOfOperation();

	public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @NonNull Object left, @NonNull Object right) {
		String leftString = asString(left);
		String rightString = asString(right);
		/*if (leftString.length() <= 0) {
			return ValuesUtil.integerValueOf(0);
		}
		else*/ if (rightString.length() <= 0) {
			return ValuesUtil.integerValueOf(1);
		}
		else {
			int index = leftString.indexOf(rightString);
			if (index >= 0) {
				return ValuesUtil.integerValueOf(index+1);
			}
			else {
				return ValuesUtil.integerValueOf(0);
			}
		}
	}
}
