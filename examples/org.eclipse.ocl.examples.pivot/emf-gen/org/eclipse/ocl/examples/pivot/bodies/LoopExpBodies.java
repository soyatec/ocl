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
import org.eclipse.ocl.examples.domain.library.AbstractBinaryOperation;
import org.eclipse.ocl.examples.domain.library.AbstractUnaryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryBinaryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryIteration;
import org.eclipse.ocl.examples.domain.library.LibraryProperty;
import org.eclipse.ocl.examples.domain.library.LibraryUnaryOperation;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.library.executor.ExecutorOperation;
import org.eclipse.ocl.examples.library.executor.ExecutorProperty;
import org.eclipse.ocl.examples.library.executor.ExecutorSingleIterationManager;
import org.eclipse.ocl.examples.library.executor.ExecutorType;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.examples.pivot.PivotTables;

/**
 * LoopExpBodies provides the Java implementation bodies of OCL-defined LoopExp operations and properties.
 */
@SuppressWarnings("nls")
public class LoopExpBodies
{

	/** 
	 * Implementation of the LoopExp 'NoInitializers' invariant.
	 */
	public static class _invariant_NoInitializers extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_NoInitializers INSTANCE = new _invariant_NoInitializers();
	
		/*
		self.iterator->forAll(initExpression->isEmpty())
		*/
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @NonNull Object self) throws InvalidValueException {
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Collection_forAll = OCLstdlibTables.Operations._Collection__1_forAll;
			final @NonNull ExecutorType T_pivot__Variable = PivotTables.Types._Variable;
			final @NonNull DomainCollectionType T_OrderedSet_pivot__Variable_ = standardLibrary.getOrderedSetType(T_pivot__Variable, null, null);
			final @NonNull ExecutorProperty P_LoopExp_iterator = PivotTables.Properties._LoopExp__iterator;
			final @NonNull LibraryProperty IP_LoopExp_iterator = P_LoopExp_iterator.getImplementation();
			final @NonNull ExecutorOperation O_Collection_isEmpty = OCLstdlibTables.Operations._Collection__isEmpty;
			final @NonNull ExecutorType T_pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final @NonNull DomainCollectionType T_Set_pivot__OCLExpression_ = standardLibrary.getSetType(T_pivot__OCLExpression, null, null);
			final @NonNull ExecutorOperation O_OclAny_oclAsSet = OCLstdlibTables.Operations._OclAny__oclAsSet;
			final @NonNull ExecutorProperty P_Variable_initExpression = PivotTables.Properties._Variable__initExpression;
			final @NonNull LibraryProperty IP_Variable_initExpression = P_Variable_initExpression.getImplementation();
			
			
			Object A_symbol_ = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_pivot__Variable_.getTypeId(), self, P_LoopExp_iterator);
			
			
			/** 
			 * Implementation of the iterator body.
			 */
			AbstractBinaryOperation body_A_symbol__1 = new AbstractBinaryOperation()
			{
			/*
			initExpression->isEmpty()
			*/
				public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @NonNull Object sourceValue, @NonNull Object iterator1) throws InvalidValueException {
					final @NonNull Object V_1_ = iterator1;	// iterator: 1_
					
					Object A_symbol__2 = IP_Variable_initExpression.evaluate(evaluator, T_pivot__OCLExpression.getTypeId(), V_1_, P_Variable_initExpression);
					
					DomainType static_A_symbol__3 = evaluator.getStaticTypeOf(A_symbol__2);
					LibraryUnaryOperation dynamic_A_symbol__3 = (LibraryUnaryOperation)static_A_symbol__3.lookupImplementation(standardLibrary, O_OclAny_oclAsSet);
					Object A_symbol__3 = dynamic_A_symbol__3.evaluate(evaluator, T_Set_pivot__OCLExpression_.getTypeId(), A_symbol__2);
					DomainType static_A_symbol__4 = evaluator.getStaticTypeOf(A_symbol__3);
					LibraryUnaryOperation dynamic_A_symbol__4 = (LibraryUnaryOperation)static_A_symbol__4.lookupImplementation(standardLibrary, O_Collection_isEmpty);
					Object A_symbol__4 = dynamic_A_symbol__4.evaluate(evaluator, T_Boolean.getTypeId(), A_symbol__3);
					return A_symbol__4;
				}
			};
			DomainType static_A_symbol__1 = evaluator.getStaticTypeOf(A_symbol_);
			LibraryIteration dynamic_A_symbol__1 = (LibraryIteration)static_A_symbol__1.lookupImplementation(standardLibrary, O_Collection_forAll);
			Object acc_A_symbol__1 = dynamic_A_symbol__1.createAccumulatorValue(evaluator, T_Boolean.getTypeId(), T_Boolean);
			ExecutorSingleIterationManager manager_A_symbol__1 = new ExecutorSingleIterationManager(evaluator, T_Boolean.getTypeId(), body_A_symbol__1, (CollectionValue)A_symbol_, acc_A_symbol__1);
			Object A_symbol__1 = dynamic_A_symbol__1.evaluateIteration(manager_A_symbol__1);
			return A_symbol__1;
		}
	}

	/** 
	 * Implementation of the LoopExp 'SourceIsCollection' invariant.
	 */
	public static class _invariant_SourceIsCollection extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_SourceIsCollection INSTANCE = new _invariant_SourceIsCollection();
	
		/*
		source.type.oclIsKindOf(CollectionType)
		*/
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @NonNull Object self) throws InvalidValueException {
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
			final @NonNull ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final @NonNull ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final @NonNull LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final @NonNull ExecutorType T_pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final @NonNull ExecutorProperty P_CallExp_source = PivotTables.Properties._CallExp__source;
			final @NonNull LibraryProperty IP_CallExp_source = P_CallExp_source.getImplementation();
			final @NonNull Object T_Metaclass_pivot__CollectionType_ = createTypeValue(PivotTables.Types._CollectionType);
			
			
			Object A_symbol__5 = IP_CallExp_source.evaluate(evaluator, T_pivot__OCLExpression.getTypeId(), self, P_CallExp_source);
			
			Object A_symbol__6 = IP_TypedElement_type.evaluate(evaluator, T_Type.getTypeId(), A_symbol__5, P_TypedElement_type);
			
			DomainType static_A_symbol__7 = evaluator.getStaticTypeOf(A_symbol__6);
			LibraryBinaryOperation dynamic_A_symbol__7 = (LibraryBinaryOperation)static_A_symbol__7.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
			Object A_symbol__7 = dynamic_A_symbol__7.evaluate(evaluator, T_Boolean.getTypeId(), A_symbol__6, T_Metaclass_pivot__CollectionType_);
			return A_symbol__7;
		}
	}



}

