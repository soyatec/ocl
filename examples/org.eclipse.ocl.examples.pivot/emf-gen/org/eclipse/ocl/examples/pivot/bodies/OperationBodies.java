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
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.NullValue;
import org.eclipse.ocl.examples.domain.values.ValueFactory;
import org.eclipse.ocl.examples.library.executor.ExecutorOperation;
import org.eclipse.ocl.examples.library.executor.ExecutorProperty;
import org.eclipse.ocl.examples.library.executor.ExecutorSingleIterationManager;
import org.eclipse.ocl.examples.library.executor.ExecutorType;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.examples.pivot.PivotTables;

/**
 * OperationBodies provides the Java implementation bodies of OCL-defined Operation operations and properties.
 */
@SuppressWarnings("nls")
public class OperationBodies
{

	/** 
	 * Implementation of the Operation 'CompatibleReturn' invariant.
	 */
	public static class _invariant_CompatibleReturn extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_CompatibleReturn INSTANCE = new _invariant_CompatibleReturn();
	
		/*
		let
	  bodyConstraint : Constraint = ownedRule->any(stereotype = 'body')
	in bodyConstraint <> null implies
	  let bodySpecification : ValueSpecification = bodyConstraint.specification
	  in bodySpecification <> null and
	    bodySpecification.oclIsKindOf(ExpressionInOCL) implies
	    CompatibleBody(bodySpecification)
		*/
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Object self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final @NonNull ExecutorOperation O_OclAny__lt__gt_ = OCLstdlibTables.Operations._OclAny___lt__gt_;
			final @NonNull NullValue Null = valueFactory.getNull();
			final @NonNull ExecutorOperation O_Boolean_and = OCLstdlibTables.Operations._Boolean__and;
			final @NonNull ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
			final @NonNull Object T_Metaclass_pivot__ExpressionInOCL_ = valueFactory.createTypeValue(PivotTables.Types._ExpressionInOCL);
			final @NonNull ExecutorOperation O_TypedMultiplicityElement_CompatibleBody = PivotTables.Operations._TypedMultiplicityElement__CompatibleBody;
			final @NonNull ExecutorType T_pivot__ValueSpecification = PivotTables.Types._ValueSpecification;
			final @NonNull ExecutorProperty P_Constraint_specification = PivotTables.Properties._Constraint__specification;
			final @NonNull LibraryProperty IP_Constraint_specification = P_Constraint_specification.getImplementation();
			final @NonNull ExecutorType T_pivot__Constraint = PivotTables.Types._Constraint;
			final @NonNull ExecutorOperation O_Collection_any = OCLstdlibTables.Operations._Collection__any;
			final @NonNull DomainCollectionType T_OrderedSet_pivot__Constraint_ = standardLibrary.getOrderedSetType(T_pivot__Constraint, null, null);
			final @NonNull ExecutorProperty P_NamedElement_ownedRule = PivotTables.Properties._NamedElement__ownedRule;
			final @NonNull LibraryProperty IP_NamedElement_ownedRule = P_NamedElement_ownedRule.getImplementation();
			final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final @NonNull ExecutorType T_String = OCLstdlibTables.Types._String;
			final @NonNull ExecutorProperty P_Constraint_stereotype = PivotTables.Properties._Constraint__stereotype;
			final @NonNull LibraryProperty IP_Constraint_stereotype = P_Constraint_stereotype.getImplementation();
			final @NonNull Object S_body = "body";
			
			
			Object A_symbol_ = IP_NamedElement_ownedRule.evaluate(evaluator, T_OrderedSet_pivot__Constraint_, self, P_NamedElement_ownedRule);
			
			
			/** 
			 * Implementation of the iterator body.
			 */
			AbstractBinaryOperation body_A_symbol__1 = new AbstractBinaryOperation()
			{
			/*
			stereotype = 'body'
			*/
				public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, @NonNull Object sourceValue, @NonNull Object iterator1) throws InvalidValueException {
					final @NonNull Object V_1_ = iterator1;	// iterator: 1_
					
					Object A_symbol__2 = IP_Constraint_stereotype.evaluate(evaluator, T_String, V_1_, P_Constraint_stereotype);
					
					DomainType static_A_symbol__3 = valueFactory.typeOf(A_symbol__2, S_body);
					LibraryBinaryOperation dynamic_A_symbol__3 = (LibraryBinaryOperation)static_A_symbol__3.lookupImplementation(standardLibrary, O_String__eq_);
					Object A_symbol__3 = dynamic_A_symbol__3.evaluate(evaluator, T_Boolean, A_symbol__2, S_body);
					return A_symbol__3;
				}
			};
			DomainType static_A_symbol__1 = valueFactory.typeOf(A_symbol_);
			LibraryIteration dynamic_A_symbol__1 = (LibraryIteration)static_A_symbol__1.lookupImplementation(standardLibrary, O_Collection_any);
			Object acc_A_symbol__1 = dynamic_A_symbol__1.createAccumulatorValue(evaluator, T_pivot__Constraint, T_Boolean);
			ExecutorSingleIterationManager manager_A_symbol__1 = new ExecutorSingleIterationManager(evaluator, T_pivot__Constraint, body_A_symbol__1, (CollectionValue)A_symbol_, acc_A_symbol__1);
			Object A_symbol__1 = dynamic_A_symbol__1.evaluateIteration(manager_A_symbol__1);
			final @NonNull Object V_bodyConstraint = A_symbol__1;
			Object leftA_symbol__4;
			try {
				
				DomainType static_A_symbol__5 = valueFactory.typeOf(V_bodyConstraint, Null);
				LibraryBinaryOperation dynamic_A_symbol__5 = (LibraryBinaryOperation)static_A_symbol__5.lookupImplementation(standardLibrary, O_OclAny__lt__gt_);
				Object A_symbol__5 = dynamic_A_symbol__5.evaluate(evaluator, T_Boolean, V_bodyConstraint, Null);
				leftA_symbol__4 = A_symbol__5;
			} catch (InvalidValueException e) {
				leftA_symbol__4 = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__5 = leftA_symbol__4;
			Object rightA_symbol__4;
			try {
				
				Object A_symbol__6 = IP_Constraint_specification.evaluate(evaluator, T_pivot__ValueSpecification, V_bodyConstraint, P_Constraint_specification);
				
				final @NonNull Object V_bodySpecification = A_symbol__6;
				Object leftA_symbol__7;
				try {
					Object leftA_symbol__8;
					try {
						
						DomainType static_A_symbol__9 = valueFactory.typeOf(V_bodySpecification, Null);
						LibraryBinaryOperation dynamic_A_symbol__9 = (LibraryBinaryOperation)static_A_symbol__9.lookupImplementation(standardLibrary, O_OclAny__lt__gt_);
						Object A_symbol__9 = dynamic_A_symbol__9.evaluate(evaluator, T_Boolean, V_bodySpecification, Null);
						leftA_symbol__8 = A_symbol__9;
					} catch (InvalidValueException e) {
						leftA_symbol__8 = valueFactory.createInvalidValue(e);
					}
					Object A_symbol__9 = leftA_symbol__8;
					Object rightA_symbol__8;
					try {
						
						DomainType static_A_symbol__10 = valueFactory.typeOf(V_bodySpecification);
						LibraryBinaryOperation dynamic_A_symbol__10 = (LibraryBinaryOperation)static_A_symbol__10.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Object A_symbol__10 = dynamic_A_symbol__10.evaluate(evaluator, T_Boolean, V_bodySpecification, T_Metaclass_pivot__ExpressionInOCL_);
						rightA_symbol__8 = A_symbol__10;
					} catch (InvalidValueException e) {
						rightA_symbol__8 = valueFactory.createInvalidValue(e);
					}
					Object A_symbol__10 = rightA_symbol__8;
					DomainType static_A_symbol__8 = valueFactory.typeOf(A_symbol__9);
					LibraryBinaryOperation dynamic_A_symbol__8 = (LibraryBinaryOperation)static_A_symbol__8.lookupImplementation(standardLibrary, O_Boolean_and);
					Object A_symbol__8 = dynamic_A_symbol__8.evaluate(evaluator, T_Boolean, A_symbol__9, A_symbol__10);
					leftA_symbol__7 = A_symbol__8;
				} catch (InvalidValueException e) {
					leftA_symbol__7 = valueFactory.createInvalidValue(e);
				}
				Object A_symbol__8 = leftA_symbol__7;
				Object rightA_symbol__7;
				try {
					
					
					DomainType static_A_symbol__11 = valueFactory.typeOf(self);
					LibraryBinaryOperation dynamic_A_symbol__11 = (LibraryBinaryOperation)static_A_symbol__11.lookupImplementation(standardLibrary, O_TypedMultiplicityElement_CompatibleBody);
					Object A_symbol__11 = dynamic_A_symbol__11.evaluate(evaluator, T_Boolean, self, V_bodySpecification);
					rightA_symbol__7 = A_symbol__11;
				} catch (InvalidValueException e) {
					rightA_symbol__7 = valueFactory.createInvalidValue(e);
				}
				Object A_symbol__11 = rightA_symbol__7;
				DomainType static_A_symbol__7 = valueFactory.typeOf(A_symbol__8);
				LibraryBinaryOperation dynamic_A_symbol__7 = (LibraryBinaryOperation)static_A_symbol__7.lookupImplementation(standardLibrary, O_Boolean_implies);
				Object A_symbol__7 = dynamic_A_symbol__7.evaluate(evaluator, T_Boolean, A_symbol__8, A_symbol__11);
				final @NonNull Object A_symbol__12 = A_symbol__7;
				rightA_symbol__4 = A_symbol__12;
			} catch (InvalidValueException e) {
				rightA_symbol__4 = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__12 = rightA_symbol__4;
			DomainType static_A_symbol__4 = valueFactory.typeOf(A_symbol__5);
			LibraryBinaryOperation dynamic_A_symbol__4 = (LibraryBinaryOperation)static_A_symbol__4.lookupImplementation(standardLibrary, O_Boolean_implies);
			Object A_symbol__4 = dynamic_A_symbol__4.evaluate(evaluator, T_Boolean, A_symbol__5, A_symbol__12);
			final @NonNull Object A_symbol__13 = A_symbol__4;
			return A_symbol__13;
		}
	}

	/** 
	 * Implementation of the Operation 'LoadableImplementation' invariant.
	 */
	public static class _invariant_LoadableImplementation extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_LoadableImplementation INSTANCE = new _invariant_LoadableImplementation();
	
		/*
		true
		*/
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Object self) throws InvalidValueException {
			final @NonNull Object True = true;
			
			
			return True;
		}
	}










}

