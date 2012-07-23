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
 * $Id: NumericGreaterThanEqualOperation.java,v 1.2 2011/01/24 19:56:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.oclany;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainInheritance;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.library.AbstractBinaryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryBinaryOperation;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.domain.values.ValueFactory;
import org.eclipse.ocl.examples.library.LibraryConstants;

/**
 * OclComparableComparisonOperation provides the abstract support for a comparison operation.
 */
public abstract class OclComparableComparisonOperation extends AbstractBinaryOperation
{
	public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, @NonNull Value left, @NonNull Value right) throws InvalidValueException {
		ValueFactory valueFactory = evaluator.getValueFactory();
		DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
		DomainInheritance leftType = left.getType().getInheritance(standardLibrary);
		DomainInheritance rightType = right.getType().getInheritance(standardLibrary);
		DomainInheritance commonType = leftType.getCommonInheritance(rightType);
		DomainInheritance comparableType = standardLibrary.getOclComparableType().getInheritance(standardLibrary);
		DomainInheritance selfType = standardLibrary.getOclSelfType().getInheritance(standardLibrary);
		DomainOperation staticOperation = comparableType.lookupLocalOperation(standardLibrary, LibraryConstants.COMPARE_TO, selfType);
		int intComparison;
		LibraryBinaryOperation implementation = null;
		try {
			if (staticOperation != null) {
				implementation = (LibraryBinaryOperation) commonType.lookupImplementation(standardLibrary, staticOperation);
			}
		} catch (Exception e) {
			throw new InvalidValueException(e);
		}
		if (implementation != null) {
			Value comparison = implementation.evaluate(evaluator, standardLibrary.getIntegerType(), left, right);
			intComparison = comparison.asInteger();
			return valueFactory.booleanValueOf(getResultValue(intComparison));
		}
		else {
			return valueFactory.throwInvalidValueException("Unsupported compareTo for ''{0}''", left.getClass().getName()); //$NON-NLS-1$
		}
	}

	protected abstract boolean getResultValue(Integer comparison);
}
