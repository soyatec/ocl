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
		public static _invariant_NoInitializers INSTANCE = new _invariant_NoInitializers();
	
		/*
		self.iterator->forAll(initExpression->isEmpty())
		*/
		public Value evaluate(DomainEvaluator evaluator, DomainType returnType, final Value self) throws InvalidValueException {
			final ValueFactory valueFactory = evaluator.getValueFactory();
			final DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final ExecutorOperation O_Collection_forAll = OCLstdlibTables.Operations._Collection__1_forAll;
			final ExecutorType T_pivot__Variable = PivotTables.Types._Variable;
			final DomainCollectionType T_OrderedSet_pivot__Variable_ = standardLibrary.getOrderedSetType(T_pivot__Variable);
			final ExecutorProperty P_LoopExp_iterator = PivotTables.Properties._LoopExp__iterator;
			final LibraryProperty IP_LoopExp_iterator = P_LoopExp_iterator.getImplementation();
			final ExecutorOperation O_Collection_isEmpty = OCLstdlibTables.Operations._Collection__isEmpty;
			final ExecutorType T_pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final DomainCollectionType T_Set_pivot__OCLExpression_ = standardLibrary.getSetType(T_pivot__OCLExpression);
			final ExecutorOperation O_OclAny_oclAsSet = OCLstdlibTables.Operations._OclAny__oclAsSet;
			final ExecutorProperty P_Variable_initExpression = PivotTables.Properties._Variable__initExpression;
			final LibraryProperty IP_Variable_initExpression = P_Variable_initExpression.getImplementation();
			
			
			Value A_symbol_407 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_pivot__Variable_, self, P_LoopExp_iterator);
			
			
			/** 
			 * Implementation of the iterator body.
			 */
			AbstractBinaryOperation body_A_symbol_408 = new AbstractBinaryOperation()
			{
			/*
			initExpression->isEmpty()
			*/
				public Value evaluate(DomainEvaluator evaluator, DomainType returnType, Value sourceValue, Value iterator1) throws InvalidValueException {
					final Value V_1_ = iterator1;	// iterator: 1_
					
					Value A_symbol_409 = IP_Variable_initExpression.evaluate(evaluator, T_pivot__OCLExpression, V_1_, P_Variable_initExpression);
					
					DomainType static_A_symbol_410 = valueFactory.typeOf(A_symbol_409);
					LibraryUnaryOperation dynamic_A_symbol_410 = (LibraryUnaryOperation)static_A_symbol_410.lookupImplementation(standardLibrary, O_OclAny_oclAsSet);
					Value A_symbol_410 = dynamic_A_symbol_410.evaluate(evaluator, T_Set_pivot__OCLExpression_, A_symbol_409);
					DomainType static_A_symbol_411 = valueFactory.typeOf(A_symbol_410);
					LibraryUnaryOperation dynamic_A_symbol_411 = (LibraryUnaryOperation)static_A_symbol_411.lookupImplementation(standardLibrary, O_Collection_isEmpty);
					Value A_symbol_411 = dynamic_A_symbol_411.evaluate(evaluator, T_Boolean, A_symbol_410);
					return A_symbol_411;
				}
			};
			DomainType static_A_symbol_408 = A_symbol_407.getType();
			LibraryIteration dynamic_A_symbol_408 = (LibraryIteration)static_A_symbol_408.lookupImplementation(standardLibrary, O_Collection_forAll);
			Value acc_A_symbol_408 = dynamic_A_symbol_408.createAccumulatorValue(evaluator, T_Boolean, T_Boolean);
			ExecutorSingleIterationManager manager_A_symbol_408 = new ExecutorSingleIterationManager(evaluator, T_Boolean, body_A_symbol_408, (CollectionValue)A_symbol_407, acc_A_symbol_408);
			Value A_symbol_408 = dynamic_A_symbol_408.evaluateIteration(manager_A_symbol_408);
			return A_symbol_408;
		}
	}

	/** 
	 * Implementation of the LoopExp 'SourceIsCollection' invariant.
	 */
	public static class _invariant_SourceIsCollection extends AbstractUnaryOperation
	{
		public static _invariant_SourceIsCollection INSTANCE = new _invariant_SourceIsCollection();
	
		/*
		source.type.oclIsKindOf(CollectionType)
		*/
		public Value evaluate(DomainEvaluator evaluator, DomainType returnType, final Value self) throws InvalidValueException {
			final ValueFactory valueFactory = evaluator.getValueFactory();
			final DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
			final ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final ExecutorType T_pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final ExecutorProperty P_CallExp_source = PivotTables.Properties._CallExp__source;
			final LibraryProperty IP_CallExp_source = P_CallExp_source.getImplementation();
			final Value T_ClassClassifier_pivot__CollectionType_ = valueFactory.createTypeValue(PivotTables.Types._CollectionType);
			
			
			Value A_symbol_412 = IP_CallExp_source.evaluate(evaluator, T_pivot__OCLExpression, self, P_CallExp_source);
			
			Value A_symbol_413 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_412, P_TypedElement_type);
			
			DomainType static_A_symbol_414 = valueFactory.typeOf(A_symbol_413);
			LibraryBinaryOperation dynamic_A_symbol_414 = (LibraryBinaryOperation)static_A_symbol_414.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
			Value A_symbol_414 = dynamic_A_symbol_414.evaluate(evaluator, T_Boolean, A_symbol_413, T_ClassClassifier_pivot__CollectionType_);
			return A_symbol_414;
		}
	}



}

