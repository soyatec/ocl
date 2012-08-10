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
 *************************************************************************
 * This code is 100% auto-generated
 * from: pivot
 * using: org.eclipse.ocl.examples.codegen.tables.model2tables.mtl
 *
 * Do not edit it.
 */
package org.eclipse.ocl.examples.pivot.bodies;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.library.AbstractUnaryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryBinaryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryProperty;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.domain.values.ValueFactory;
import org.eclipse.ocl.examples.library.executor.ExecutorOperation;
import org.eclipse.ocl.examples.library.executor.ExecutorProperty;
import org.eclipse.ocl.examples.library.executor.ExecutorType;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.examples.pivot.PivotTables;

/**
 * IntegerLiteralExpBodies provides the Java implementation bodies of OCL-defined IntegerLiteralExp operations and properties.
 */
@SuppressWarnings("nls")
public class IntegerLiteralExpBodies
{

	/** 
	 * Implementation of the IntegerLiteralExp 'TypeIsInteger' invariant.
	 */
	public static class _invariant_TypeIsInteger extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_TypeIsInteger INSTANCE = new _invariant_TypeIsInteger();
	
		/*
		self.type = Integer
		*/
		public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Value self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
			final @NonNull ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final @NonNull ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final @NonNull LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final @NonNull Value T_ClassClassifier_Integer_ = valueFactory.createTypeValue(OCLstdlibTables.Types._Integer);
			
			
			Value A_symbol_0 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
			
			DomainType static_A_symbol_1 = valueFactory.typeOf(A_symbol_0, T_ClassClassifier_Integer_);
			LibraryBinaryOperation dynamic_A_symbol_1 = (LibraryBinaryOperation)static_A_symbol_1.lookupImplementation(standardLibrary, O_OclAny__eq_);
			Value A_symbol_1 = dynamic_A_symbol_1.evaluate(evaluator, T_Boolean, A_symbol_0, T_ClassClassifier_Integer_);
			return A_symbol_1;
		}
	}

}

