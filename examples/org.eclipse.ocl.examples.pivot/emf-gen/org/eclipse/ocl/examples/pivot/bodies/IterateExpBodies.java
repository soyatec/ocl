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
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractUnaryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryBinaryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryProperty;
import org.eclipse.ocl.examples.domain.library.LibraryUnaryOperation;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
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
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @NonNull Object self) throws InvalidValueException {
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
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
			
			
			Object A_symbol_ = IP_LoopExp_body.evaluate(evaluator, T_pivot__OCLExpression.getTypeId(), self, P_LoopExp_body);
			
			Object A_symbol__1 = IP_TypedElement_type.evaluate(evaluator, T_Type.getTypeId(), A_symbol_, P_TypedElement_type);
			
			
			Object A_symbol__2 = IP_IterateExp_result.evaluate(evaluator, T_pivot__Variable.getTypeId(), self, P_IterateExp_result);
			
			Object A_symbol__3 = IP_TypedElement_type.evaluate(evaluator, T_Type.getTypeId(), A_symbol__2, P_TypedElement_type);
			
			DomainType static_A_symbol__4 = evaluator.getStaticTypeOf(A_symbol__1);
			LibraryBinaryOperation dynamic_A_symbol__4 = (LibraryBinaryOperation)static_A_symbol__4.lookupImplementation(standardLibrary, O_OclType_conformsTo);
			Object A_symbol__4 = dynamic_A_symbol__4.evaluate(evaluator, T_Boolean.getTypeId(), A_symbol__1, A_symbol__3);
			return A_symbol__4;
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
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @NonNull Object self) throws InvalidValueException {
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Real__eq_ = OCLstdlibTables.Operations._Real___eq_;
			final @NonNull ExecutorType T_Integer = OCLstdlibTables.Types._Integer;
			final @NonNull ExecutorOperation O_Collection_size = OCLstdlibTables.Operations._Collection__size;
			final @NonNull ExecutorType T_pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final @NonNull DomainCollectionType T_Set_pivot__OCLExpression_ = standardLibrary.getSetType(T_pivot__OCLExpression, null, null);
			final @NonNull ExecutorOperation O_OclAny_oclAsSet = OCLstdlibTables.Operations._OclAny__oclAsSet;
			final @NonNull ExecutorProperty P_Variable_initExpression = PivotTables.Properties._Variable__initExpression;
			final @NonNull LibraryProperty IP_Variable_initExpression = P_Variable_initExpression.getImplementation();
			final @NonNull ExecutorType T_pivot__Variable = PivotTables.Types._Variable;
			final @NonNull ExecutorProperty P_IterateExp_result = PivotTables.Properties._IterateExp__result;
			final @NonNull LibraryProperty IP_IterateExp_result = P_IterateExp_result.getImplementation();
			final @NonNull IntegerValue I_1 = integerValueOf(1);
			
			
			Object A_symbol__5 = IP_IterateExp_result.evaluate(evaluator, T_pivot__Variable.getTypeId(), self, P_IterateExp_result);
			
			Object A_symbol__6 = IP_Variable_initExpression.evaluate(evaluator, T_pivot__OCLExpression.getTypeId(), A_symbol__5, P_Variable_initExpression);
			
			DomainType static_A_symbol__7 = evaluator.getStaticTypeOf(A_symbol__6);
			LibraryUnaryOperation dynamic_A_symbol__7 = (LibraryUnaryOperation)static_A_symbol__7.lookupImplementation(standardLibrary, O_OclAny_oclAsSet);
			Object A_symbol__7 = dynamic_A_symbol__7.evaluate(evaluator, T_Set_pivot__OCLExpression_.getTypeId(), A_symbol__6);
			DomainType static_A_symbol__8 = evaluator.getStaticTypeOf(A_symbol__7);
			LibraryUnaryOperation dynamic_A_symbol__8 = (LibraryUnaryOperation)static_A_symbol__8.lookupImplementation(standardLibrary, O_Collection_size);
			Object A_symbol__8 = dynamic_A_symbol__8.evaluate(evaluator, T_Integer.getTypeId(), A_symbol__7);
			DomainType static_A_symbol__9 = evaluator.getStaticTypeOf(A_symbol__8, I_1);
			LibraryBinaryOperation dynamic_A_symbol__9 = (LibraryBinaryOperation)static_A_symbol__9.lookupImplementation(standardLibrary, O_Real__eq_);
			Object A_symbol__9 = dynamic_A_symbol__9.evaluate(evaluator, T_Boolean.getTypeId(), A_symbol__8, I_1);
			return A_symbol__9;
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
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @NonNull Object self) throws InvalidValueException {
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
			final @NonNull ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final @NonNull ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final @NonNull LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final @NonNull ExecutorType T_pivot__Variable = PivotTables.Types._Variable;
			final @NonNull ExecutorProperty P_IterateExp_result = PivotTables.Properties._IterateExp__result;
			final @NonNull LibraryProperty IP_IterateExp_result = P_IterateExp_result.getImplementation();
			
			
			Object A_symbol__10 = IP_TypedElement_type.evaluate(evaluator, T_Type.getTypeId(), self, P_TypedElement_type);
			
			
			Object A_symbol__11 = IP_IterateExp_result.evaluate(evaluator, T_pivot__Variable.getTypeId(), self, P_IterateExp_result);
			
			Object A_symbol__12 = IP_TypedElement_type.evaluate(evaluator, T_Type.getTypeId(), A_symbol__11, P_TypedElement_type);
			
			DomainType static_A_symbol__13 = evaluator.getStaticTypeOf(A_symbol__10, A_symbol__12);
			LibraryBinaryOperation dynamic_A_symbol__13 = (LibraryBinaryOperation)static_A_symbol__13.lookupImplementation(standardLibrary, O_OclAny__eq_);
			Object A_symbol__13 = dynamic_A_symbol__13.evaluate(evaluator, T_Boolean.getTypeId(), A_symbol__10, A_symbol__12);
			return A_symbol__13;
		}
	}

}

