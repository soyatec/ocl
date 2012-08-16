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
import org.eclipse.ocl.examples.domain.elements.DomainCollectionType;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.library.AbstractUnaryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryBinaryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryProperty;
import org.eclipse.ocl.examples.domain.library.LibraryUnaryOperation;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.domain.values.ValueFactory;
import org.eclipse.ocl.examples.library.executor.ExecutorOperation;
import org.eclipse.ocl.examples.library.executor.ExecutorProperty;
import org.eclipse.ocl.examples.library.executor.ExecutorType;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.examples.pivot.PivotTables;

/**
 * OperationCallExpBodies provides the Java implementation bodies of OCL-defined OperationCallExp operations and properties.
 */
@SuppressWarnings("nls")
public class OperationCallExpBodies
{

	/** 
	 * Implementation of the OperationCallExp 'ArgumentCount' invariant.
	 */
	public static class _invariant_ArgumentCount extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_ArgumentCount INSTANCE = new _invariant_ArgumentCount();
	
		/*
		argument->size() = referredOperation.ownedParameter->size()
		*/
		public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Value self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Real__eq_ = OCLstdlibTables.Operations._Real___eq_;
			final @NonNull ExecutorType T_Integer = OCLstdlibTables.Types._Integer;
			final @NonNull ExecutorOperation O_Collection_size = OCLstdlibTables.Operations._Collection__size;
			final @NonNull ExecutorType T_pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final @NonNull DomainCollectionType T_OrderedSet_pivot__OCLExpression_ = standardLibrary.getOrderedSetType(T_pivot__OCLExpression, null, null);
			final @NonNull ExecutorProperty P_OperationCallExp_argument = PivotTables.Properties._OperationCallExp__argument;
			final @NonNull LibraryProperty IP_OperationCallExp_argument = P_OperationCallExp_argument.getImplementation();
			final @NonNull ExecutorType T_pivot__Parameter = PivotTables.Types._Parameter;
			final @NonNull DomainCollectionType T_OrderedSet_pivot__Parameter_ = standardLibrary.getOrderedSetType(T_pivot__Parameter, null, null);
			final @NonNull ExecutorProperty P_Operation_ownedParameter = PivotTables.Properties._Operation__ownedParameter;
			final @NonNull LibraryProperty IP_Operation_ownedParameter = P_Operation_ownedParameter.getImplementation();
			final @NonNull ExecutorType T_pivot__Operation = PivotTables.Types._Operation;
			final @NonNull ExecutorProperty P_OperationCallExp_referredOperation = PivotTables.Properties._OperationCallExp__referredOperation;
			final @NonNull LibraryProperty IP_OperationCallExp_referredOperation = P_OperationCallExp_referredOperation.getImplementation();
			
			
			Value A_symbol_0 = IP_OperationCallExp_argument.evaluate(evaluator, T_OrderedSet_pivot__OCLExpression_, self, P_OperationCallExp_argument);
			
			DomainType static_A_symbol_1 = valueFactory.typeOf(A_symbol_0);
			LibraryUnaryOperation dynamic_A_symbol_1 = (LibraryUnaryOperation)static_A_symbol_1.lookupImplementation(standardLibrary, O_Collection_size);
			Value A_symbol_1 = dynamic_A_symbol_1.evaluate(evaluator, T_Integer, A_symbol_0);
			
			Value A_symbol_2 = IP_OperationCallExp_referredOperation.evaluate(evaluator, T_pivot__Operation, self, P_OperationCallExp_referredOperation);
			
			Value A_symbol_3 = IP_Operation_ownedParameter.evaluate(evaluator, T_OrderedSet_pivot__Parameter_, A_symbol_2, P_Operation_ownedParameter);
			
			DomainType static_A_symbol_4 = valueFactory.typeOf(A_symbol_3);
			LibraryUnaryOperation dynamic_A_symbol_4 = (LibraryUnaryOperation)static_A_symbol_4.lookupImplementation(standardLibrary, O_Collection_size);
			Value A_symbol_4 = dynamic_A_symbol_4.evaluate(evaluator, T_Integer, A_symbol_3);
			DomainType static_A_symbol_5 = valueFactory.typeOf(A_symbol_1, A_symbol_4);
			LibraryBinaryOperation dynamic_A_symbol_5 = (LibraryBinaryOperation)static_A_symbol_5.lookupImplementation(standardLibrary, O_Real__eq_);
			Value A_symbol_5 = dynamic_A_symbol_5.evaluate(evaluator, T_Boolean, A_symbol_1, A_symbol_4);
			return A_symbol_5;
		}
	}


}

