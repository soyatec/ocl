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
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.domain.values.ValueFactory;
import org.eclipse.ocl.examples.library.executor.ExecutorOperation;
import org.eclipse.ocl.examples.library.executor.ExecutorProperty;
import org.eclipse.ocl.examples.library.executor.ExecutorType;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.examples.pivot.PivotTables;

/**
 * IterateExpBodies provides the Java implementation bodies of OCL-defined IterateExp operations and properties.
 */
@SuppressWarnings("nls")
public class IterateExpBodies
{

	/** 
	 * Implementation of the IterateExp 'BodyTypeConformsToResultType' invariant.
	 */
	public static class _invariant_BodyTypeConformsToResultType extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_BodyTypeConformsToResultType INSTANCE = new _invariant_BodyTypeConformsToResultType();
	
		/*
		body.type.conformsTo(result.type)
		*/
		public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Value self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_OclType_conformsTo = OCLstdlibTables.Operations._OclType__conformsTo;
			final @NonNull ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final @NonNull ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final @NonNull LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final @NonNull ExecutorType T_pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final @NonNull ExecutorProperty P_LoopExp_body = PivotTables.Properties._LoopExp__body;
			final @NonNull LibraryProperty IP_LoopExp_body = P_LoopExp_body.getImplementation();
			final @NonNull ExecutorType T_pivot__Variable = PivotTables.Types._Variable;
			final @NonNull ExecutorProperty P_IterateExp_result = PivotTables.Properties._IterateExp__result;
			final @NonNull LibraryProperty IP_IterateExp_result = P_IterateExp_result.getImplementation();
			
			
			Value A_symbol_367 = IP_LoopExp_body.evaluate(evaluator, T_pivot__OCLExpression, self, P_LoopExp_body);
			
			Value A_symbol_368 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_367, P_TypedElement_type);
			
			
			Value A_symbol_369 = IP_IterateExp_result.evaluate(evaluator, T_pivot__Variable, self, P_IterateExp_result);
			
			Value A_symbol_370 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_369, P_TypedElement_type);
			
			DomainType static_A_symbol_371 = valueFactory.typeOf(A_symbol_368);
			LibraryBinaryOperation dynamic_A_symbol_371 = (LibraryBinaryOperation)static_A_symbol_371.lookupImplementation(standardLibrary, O_OclType_conformsTo);
			Value A_symbol_371 = dynamic_A_symbol_371.evaluate(evaluator, T_Boolean, A_symbol_368, A_symbol_370);
			return A_symbol_371;
		}
	}

	/** 
	 * Implementation of the IterateExp 'OneInitializer' invariant.
	 */
	public static class _invariant_OneInitializer extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_OneInitializer INSTANCE = new _invariant_OneInitializer();
	
		/*
		self.result.initExpression->size() = 1
		*/
		public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Value self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Real__eq_ = OCLstdlibTables.Operations._Real___eq_;
			final @NonNull ExecutorType T_Integer = OCLstdlibTables.Types._Integer;
			final @NonNull ExecutorOperation O_Collection_size = OCLstdlibTables.Operations._Collection__size;
			final @NonNull ExecutorType T_pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final @NonNull DomainCollectionType T_Set_pivot__OCLExpression_ = standardLibrary.getSetType(T_pivot__OCLExpression);
			final @NonNull ExecutorOperation O_OclAny_oclAsSet = OCLstdlibTables.Operations._OclAny__oclAsSet;
			final @NonNull ExecutorProperty P_Variable_initExpression = PivotTables.Properties._Variable__initExpression;
			final @NonNull LibraryProperty IP_Variable_initExpression = P_Variable_initExpression.getImplementation();
			final @NonNull ExecutorType T_pivot__Variable = PivotTables.Types._Variable;
			final @NonNull ExecutorProperty P_IterateExp_result = PivotTables.Properties._IterateExp__result;
			final @NonNull LibraryProperty IP_IterateExp_result = P_IterateExp_result.getImplementation();
			final @NonNull IntegerValue I_1 = valueFactory.integerValueOf(1);
			
			
			Value A_symbol_372 = IP_IterateExp_result.evaluate(evaluator, T_pivot__Variable, self, P_IterateExp_result);
			
			Value A_symbol_373 = IP_Variable_initExpression.evaluate(evaluator, T_pivot__OCLExpression, A_symbol_372, P_Variable_initExpression);
			
			DomainType static_A_symbol_374 = valueFactory.typeOf(A_symbol_373);
			LibraryUnaryOperation dynamic_A_symbol_374 = (LibraryUnaryOperation)static_A_symbol_374.lookupImplementation(standardLibrary, O_OclAny_oclAsSet);
			Value A_symbol_374 = dynamic_A_symbol_374.evaluate(evaluator, T_Set_pivot__OCLExpression_, A_symbol_373);
			DomainType static_A_symbol_375 = valueFactory.typeOf(A_symbol_374);
			LibraryUnaryOperation dynamic_A_symbol_375 = (LibraryUnaryOperation)static_A_symbol_375.lookupImplementation(standardLibrary, O_Collection_size);
			Value A_symbol_375 = dynamic_A_symbol_375.evaluate(evaluator, T_Integer, A_symbol_374);
			DomainType static_A_symbol_376 = valueFactory.typeOf(A_symbol_375, I_1);
			LibraryBinaryOperation dynamic_A_symbol_376 = (LibraryBinaryOperation)static_A_symbol_376.lookupImplementation(standardLibrary, O_Real__eq_);
			Value A_symbol_376 = dynamic_A_symbol_376.evaluate(evaluator, T_Boolean, A_symbol_375, I_1);
			return A_symbol_376;
		}
	}

	/** 
	 * Implementation of the IterateExp 'TypeIsResultType' invariant.
	 */
	public static class _invariant_TypeIsResultType extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_TypeIsResultType INSTANCE = new _invariant_TypeIsResultType();
	
		/*
		type = result.type
		*/
		public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Value self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
			final @NonNull ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final @NonNull ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final @NonNull LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final @NonNull ExecutorType T_pivot__Variable = PivotTables.Types._Variable;
			final @NonNull ExecutorProperty P_IterateExp_result = PivotTables.Properties._IterateExp__result;
			final @NonNull LibraryProperty IP_IterateExp_result = P_IterateExp_result.getImplementation();
			
			
			Value A_symbol_377 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
			
			
			Value A_symbol_378 = IP_IterateExp_result.evaluate(evaluator, T_pivot__Variable, self, P_IterateExp_result);
			
			Value A_symbol_379 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_378, P_TypedElement_type);
			
			DomainType static_A_symbol_380 = valueFactory.typeOf(A_symbol_377, A_symbol_379);
			LibraryBinaryOperation dynamic_A_symbol_380 = (LibraryBinaryOperation)static_A_symbol_380.lookupImplementation(standardLibrary, O_OclAny__eq_);
			Value A_symbol_380 = dynamic_A_symbol_380.evaluate(evaluator, T_Boolean, A_symbol_377, A_symbol_379);
			return A_symbol_380;
		}
	}

}

