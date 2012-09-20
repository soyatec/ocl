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
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.library.executor.ExecutorOperation;
import org.eclipse.ocl.examples.library.executor.ExecutorProperty;
import org.eclipse.ocl.examples.library.executor.ExecutorSingleIterationManager;
import org.eclipse.ocl.examples.library.executor.ExecutorType;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.examples.pivot.PivotTables;

/**
 * ConstraintBodies provides the Java implementation bodies of OCL-defined Constraint operations and properties.
 */
@SuppressWarnings("nls")
public class ConstraintBodies
{

	/** 
	 * Implementation of the Constraint 'UniqueName' invariant.
	 */
	public static class _invariant_UniqueName extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_UniqueName INSTANCE = new _invariant_UniqueName();
	
		/*
		context.ownedRule->excluding(self)
	->forAll(name <> self.name or stereotype <> self.stereotype)
		*/
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @NonNull Object self) throws InvalidValueException {
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Collection_forAll = OCLstdlibTables.Operations._Collection__1_forAll;
			final @NonNull ExecutorType T_pivot__Constraint = PivotTables.Types._Constraint;
			final @NonNull DomainCollectionType T_OrderedSet_pivot__Constraint_ = standardLibrary.getOrderedSetType(T_pivot__Constraint, null, null);
			final @NonNull ExecutorOperation O_OrderedSet_excluding = OCLstdlibTables.Operations._OrderedSet__excluding;
			final @NonNull ExecutorProperty P_NamedElement_ownedRule = PivotTables.Properties._NamedElement__ownedRule;
			final @NonNull LibraryProperty IP_NamedElement_ownedRule = P_NamedElement_ownedRule.getImplementation();
			final @NonNull ExecutorType T_pivot__NamedElement = PivotTables.Types._NamedElement;
			final @NonNull ExecutorProperty P_Constraint_context = PivotTables.Properties._Constraint__context;
			final @NonNull LibraryProperty IP_Constraint_context = P_Constraint_context.getImplementation();
			final @NonNull ExecutorOperation O_Boolean_or = OCLstdlibTables.Operations._Boolean__or;
			final @NonNull ExecutorOperation O_String__lt__gt_ = OCLstdlibTables.Operations._String___lt__gt_;
			final @NonNull ExecutorType T_String = OCLstdlibTables.Types._String;
			final @NonNull ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final @NonNull LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final @NonNull ExecutorProperty P_Constraint_stereotype = PivotTables.Properties._Constraint__stereotype;
			final @NonNull LibraryProperty IP_Constraint_stereotype = P_Constraint_stereotype.getImplementation();
			
			
			Object A_symbol__2 = IP_Constraint_context.evaluate(evaluator, T_pivot__NamedElement.getTypeId(), self, P_Constraint_context);
			
			Object A_symbol__3 = IP_NamedElement_ownedRule.evaluate(evaluator, T_OrderedSet_pivot__Constraint_.getTypeId(), A_symbol__2, P_NamedElement_ownedRule);
			
			
			DomainType static_A_symbol_ = evaluator.getStaticTypeOf(A_symbol__3);
			LibraryBinaryOperation dynamic_A_symbol_ = (LibraryBinaryOperation)static_A_symbol_.lookupImplementation(standardLibrary, O_OrderedSet_excluding);
			Object A_symbol_ = dynamic_A_symbol_.evaluate(evaluator, T_OrderedSet_pivot__Constraint_.getTypeId(), A_symbol__3, self);
			
			/** 
			 * Implementation of the iterator body.
			 */
			AbstractBinaryOperation body_A_symbol__1 = new AbstractBinaryOperation()
			{
			/*
			name <> self.name or stereotype <> self.stereotype
			*/
				public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @NonNull Object sourceValue, @NonNull Object iterator1) throws InvalidValueException {
					final @NonNull Object V_1_ = iterator1;	// iterator: 1_
					Object leftA_symbol__4;
					try {
						
						Object A_symbol__5 = IP_NamedElement_name.evaluate(evaluator, T_String.getTypeId(), V_1_, P_NamedElement_name);
						
						
						Object A_symbol__6 = IP_NamedElement_name.evaluate(evaluator, T_String.getTypeId(), self, P_NamedElement_name);
						
						DomainType static_A_symbol__7 = evaluator.getStaticTypeOf(A_symbol__5, A_symbol__6);
						LibraryBinaryOperation dynamic_A_symbol__7 = (LibraryBinaryOperation)static_A_symbol__7.lookupImplementation(standardLibrary, O_String__lt__gt_);
						Object A_symbol__7 = dynamic_A_symbol__7.evaluate(evaluator, T_Boolean.getTypeId(), A_symbol__5, A_symbol__6);
						leftA_symbol__4 = A_symbol__7;
					} catch (InvalidValueException e) {
						leftA_symbol__4 = createInvalidValue(e);
					}
					Object A_symbol__7 = leftA_symbol__4;
					Object rightA_symbol__4;
					try {
						
						Object A_symbol__8 = IP_Constraint_stereotype.evaluate(evaluator, T_String.getTypeId(), V_1_, P_Constraint_stereotype);
						
						
						Object A_symbol__9 = IP_Constraint_stereotype.evaluate(evaluator, T_String.getTypeId(), self, P_Constraint_stereotype);
						
						DomainType static_A_symbol__10 = evaluator.getStaticTypeOf(A_symbol__8, A_symbol__9);
						LibraryBinaryOperation dynamic_A_symbol__10 = (LibraryBinaryOperation)static_A_symbol__10.lookupImplementation(standardLibrary, O_String__lt__gt_);
						Object A_symbol__10 = dynamic_A_symbol__10.evaluate(evaluator, T_Boolean.getTypeId(), A_symbol__8, A_symbol__9);
						rightA_symbol__4 = A_symbol__10;
					} catch (InvalidValueException e) {
						rightA_symbol__4 = createInvalidValue(e);
					}
					Object A_symbol__10 = rightA_symbol__4;
					DomainType static_A_symbol__4 = evaluator.getStaticTypeOf(A_symbol__7);
					LibraryBinaryOperation dynamic_A_symbol__4 = (LibraryBinaryOperation)static_A_symbol__4.lookupImplementation(standardLibrary, O_Boolean_or);
					Object A_symbol__4 = dynamic_A_symbol__4.evaluate(evaluator, T_Boolean.getTypeId(), A_symbol__7, A_symbol__10);
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





}

