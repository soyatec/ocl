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
import org.eclipse.ocl.examples.domain.library.AbstractBinaryOperation;
import org.eclipse.ocl.examples.domain.library.AbstractUnaryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryBinaryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryIteration;
import org.eclipse.ocl.examples.domain.library.LibraryProperty;
import org.eclipse.ocl.examples.domain.library.LibraryUnaryOperation;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.domain.values.ValueFactory;
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
		public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Value self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
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
			
			
			Value A_symbol_ = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_pivot__Variable_, self, P_LoopExp_iterator);
			
			
			/** 
			 * Implementation of the iterator body.
			 */
			AbstractBinaryOperation body_A_symbol__1 = new AbstractBinaryOperation()
			{
			/*
			initExpression->isEmpty()
			*/
				public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, @NonNull Value sourceValue, @NonNull Value iterator1) throws InvalidValueException {
					final @NonNull Value V_1_ = iterator1;	// iterator: 1_
					
					Value A_symbol__2 = IP_Variable_initExpression.evaluate(evaluator, T_pivot__OCLExpression, V_1_, P_Variable_initExpression);
					
					DomainType static_A_symbol__3 = valueFactory.typeOf(A_symbol__2);
					LibraryUnaryOperation dynamic_A_symbol__3 = (LibraryUnaryOperation)static_A_symbol__3.lookupImplementation(standardLibrary, O_OclAny_oclAsSet);
					Value A_symbol__3 = dynamic_A_symbol__3.evaluate(evaluator, T_Set_pivot__OCLExpression_, A_symbol__2);
					DomainType static_A_symbol__4 = valueFactory.typeOf(A_symbol__3);
					LibraryUnaryOperation dynamic_A_symbol__4 = (LibraryUnaryOperation)static_A_symbol__4.lookupImplementation(standardLibrary, O_Collection_isEmpty);
					Value A_symbol__4 = dynamic_A_symbol__4.evaluate(evaluator, T_Boolean, A_symbol__3);
					return A_symbol__4;
				}
			};
			DomainType static_A_symbol__1 = A_symbol_.getType();
			LibraryIteration dynamic_A_symbol__1 = (LibraryIteration)static_A_symbol__1.lookupImplementation(standardLibrary, O_Collection_forAll);
			Value acc_A_symbol__1 = dynamic_A_symbol__1.createAccumulatorValue(evaluator, T_Boolean, T_Boolean);
			ExecutorSingleIterationManager manager_A_symbol__1 = new ExecutorSingleIterationManager(evaluator, T_Boolean, body_A_symbol__1, (CollectionValue)A_symbol_, acc_A_symbol__1);
			Value A_symbol__1 = dynamic_A_symbol__1.evaluateIteration(manager_A_symbol__1);
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
		public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Value self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
			final @NonNull ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final @NonNull ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final @NonNull LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final @NonNull ExecutorType T_pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final @NonNull ExecutorProperty P_CallExp_source = PivotTables.Properties._CallExp__source;
			final @NonNull LibraryProperty IP_CallExp_source = P_CallExp_source.getImplementation();
			final @NonNull Value T_Metaclass_pivot__CollectionType_ = valueFactory.createTypeValue(PivotTables.Types._CollectionType);
			
			
			Value A_symbol__5 = IP_CallExp_source.evaluate(evaluator, T_pivot__OCLExpression, self, P_CallExp_source);
			
			Value A_symbol__6 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol__5, P_TypedElement_type);
			
			DomainType static_A_symbol__7 = valueFactory.typeOf(A_symbol__6);
			LibraryBinaryOperation dynamic_A_symbol__7 = (LibraryBinaryOperation)static_A_symbol__7.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
			Value A_symbol__7 = dynamic_A_symbol__7.evaluate(evaluator, T_Boolean, A_symbol__6, T_Metaclass_pivot__CollectionType_);
			return A_symbol__7;
		}
	}



}

