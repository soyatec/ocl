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
import org.eclipse.ocl.examples.domain.values.NullValue;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.library.executor.ExecutorOperation;
import org.eclipse.ocl.examples.library.executor.ExecutorProperty;
import org.eclipse.ocl.examples.library.executor.ExecutorSingleIterationManager;
import org.eclipse.ocl.examples.library.executor.ExecutorType;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.examples.pivot.PivotTables;

/**
 * PropertyBodies provides the Java implementation bodies of OCL-defined Property operations and properties.
 */
@SuppressWarnings("nls")
public class PropertyBodies
{

	/** 
	 * Implementation of the Property 'CompatibleInitialiser' invariant.
	 */
	public static class _invariant_CompatibleInitialiser extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_CompatibleInitialiser INSTANCE = new _invariant_CompatibleInitialiser();
	
		/*
		isDerived implies
	let
	  derivedConstraint : Constraint = ownedRule->any(stereotype = 'derivation')
	in
	  let
	    initialConstraint : Constraint = ownedRule->any(stereotype = 'initial')
	  in
	    let
	      derivedSpecification : ValueSpecification = if derivedConstraint <> null
	      then derivedConstraint.specification
	      else null
	      endif
	    in
	      let
	        initialSpecification : ValueSpecification = if initialConstraint <> null
	        then initialConstraint.specification
	        else null
	        endif
	      in
	        let
	          initialiser : ValueSpecification = if derivedSpecification <> null
	          then derivedSpecification
	          else initialSpecification
	          endif
	        in initialiser <> null and
	          initialiser.oclIsKindOf(ExpressionInOCL) implies
	          CompatibleBody(initialiser)
		*/
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @NonNull Object self) throws InvalidValueException {
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final @NonNull ExecutorProperty P_Property_isDerived = PivotTables.Properties._Property__isDerived;
			final @NonNull LibraryProperty IP_Property_isDerived = P_Property_isDerived.getImplementation();
			final @NonNull ExecutorOperation O_Boolean_and = OCLstdlibTables.Operations._Boolean__and;
			final @NonNull ExecutorOperation O_OclAny__lt__gt_ = OCLstdlibTables.Operations._OclAny___lt__gt_;
			final @NonNull NullValue Null = NULL_VALUE;
			final @NonNull ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
			final @NonNull Object T_Metaclass_pivot__ExpressionInOCL_ = createTypeValue(PivotTables.Types._ExpressionInOCL);
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
			final @NonNull ExecutorProperty P_Constraint_stereotype = PivotTables.Properties._Constraint__stereotype;
			final @NonNull LibraryProperty IP_Constraint_stereotype = P_Constraint_stereotype.getImplementation();
			final @NonNull Object S_initial = "initial";
			final @NonNull Object S_derivati___ = "derivation";
			
			Object leftA_symbol_;
			try {
				
				Object A_symbol__1 = IP_Property_isDerived.evaluate(evaluator, TypeId.BOOLEAN, self, P_Property_isDerived);
				
				leftA_symbol_ = A_symbol__1;
			} catch (InvalidValueException e) {
				leftA_symbol_ = createInvalidValue(e);
			}
			Object A_symbol__1 = leftA_symbol_;
			Object rightA_symbol_;
			try {
				
				Object A_symbol__2 = IP_NamedElement_ownedRule.evaluate(evaluator, T_OrderedSet_pivot__Constraint_.getTypeId(), self, P_NamedElement_ownedRule);
				
				
				/** 
				 * Implementation of the iterator body.
				 */
				AbstractBinaryOperation body_A_symbol__3 = new AbstractBinaryOperation()
				{
				/*
				stereotype = 'derivation'
				*/
					public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @NonNull Object sourceValue, @NonNull Object iterator1) throws InvalidValueException {
						final @NonNull Object V_1_ = iterator1;	// iterator: 1_
						
						Object A_symbol__4 = IP_Constraint_stereotype.evaluate(evaluator, TypeId.STRING, V_1_, P_Constraint_stereotype);
						
						DomainType static_A_symbol__5 = evaluator.getStaticTypeOf(A_symbol__4, S_derivati___);
						LibraryBinaryOperation dynamic_A_symbol__5 = (LibraryBinaryOperation)static_A_symbol__5.lookupImplementation(standardLibrary, O_String__eq_);
						Object A_symbol__5 = dynamic_A_symbol__5.evaluate(evaluator, TypeId.BOOLEAN, A_symbol__4, S_derivati___);
						return A_symbol__5;
					}
				};
				DomainType static_A_symbol__3 = evaluator.getStaticTypeOf(A_symbol__2);
				LibraryIteration dynamic_A_symbol__3 = (LibraryIteration)static_A_symbol__3.lookupImplementation(standardLibrary, O_Collection_any);
				Object acc_A_symbol__3 = dynamic_A_symbol__3.createAccumulatorValue(evaluator, T_pivot__Constraint.getTypeId(), TypeId.BOOLEAN);
				ExecutorSingleIterationManager manager_A_symbol__3 = new ExecutorSingleIterationManager(evaluator, T_pivot__Constraint.getTypeId(), body_A_symbol__3, (CollectionValue)A_symbol__2, acc_A_symbol__3);
				Object A_symbol__3 = dynamic_A_symbol__3.evaluateIteration(manager_A_symbol__3);
				final @NonNull Object V_derivedConstraint = A_symbol__3;
				
				Object A_symbol__6 = IP_NamedElement_ownedRule.evaluate(evaluator, T_OrderedSet_pivot__Constraint_.getTypeId(), self, P_NamedElement_ownedRule);
				
				
				/** 
				 * Implementation of the iterator body.
				 */
				AbstractBinaryOperation body_A_symbol__7 = new AbstractBinaryOperation()
				{
				/*
				stereotype = 'initial'
				*/
					public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @NonNull Object sourceValue, @NonNull Object iterator1) throws InvalidValueException {
						final @NonNull Object V_1_1 = iterator1;	// iterator: 1_
						
						Object A_symbol__8 = IP_Constraint_stereotype.evaluate(evaluator, TypeId.STRING, V_1_1, P_Constraint_stereotype);
						
						DomainType static_A_symbol__9 = evaluator.getStaticTypeOf(A_symbol__8, S_initial);
						LibraryBinaryOperation dynamic_A_symbol__9 = (LibraryBinaryOperation)static_A_symbol__9.lookupImplementation(standardLibrary, O_String__eq_);
						Object A_symbol__9 = dynamic_A_symbol__9.evaluate(evaluator, TypeId.BOOLEAN, A_symbol__8, S_initial);
						return A_symbol__9;
					}
				};
				DomainType static_A_symbol__7 = evaluator.getStaticTypeOf(A_symbol__6);
				LibraryIteration dynamic_A_symbol__7 = (LibraryIteration)static_A_symbol__7.lookupImplementation(standardLibrary, O_Collection_any);
				Object acc_A_symbol__7 = dynamic_A_symbol__7.createAccumulatorValue(evaluator, T_pivot__Constraint.getTypeId(), TypeId.BOOLEAN);
				ExecutorSingleIterationManager manager_A_symbol__7 = new ExecutorSingleIterationManager(evaluator, T_pivot__Constraint.getTypeId(), body_A_symbol__7, (CollectionValue)A_symbol__6, acc_A_symbol__7);
				Object A_symbol__7 = dynamic_A_symbol__7.evaluateIteration(manager_A_symbol__7);
				final @NonNull Object V_initialConstraint = A_symbol__7;
					
					DomainType static_A_symbol__10 = evaluator.getStaticTypeOf(V_derivedConstraint, Null);
					LibraryBinaryOperation dynamic_A_symbol__10 = (LibraryBinaryOperation)static_A_symbol__10.lookupImplementation(standardLibrary, O_OclAny__lt__gt_);
					Object A_symbol__10 = dynamic_A_symbol__10.evaluate(evaluator, TypeId.BOOLEAN, V_derivedConstraint, Null);
				Object A_symbol__11;
				if (A_symbol__10 == ValuesUtil.TRUE_VALUE) {
					
					Object A_symbol__12 = IP_Constraint_specification.evaluate(evaluator, T_pivot__ValueSpecification.getTypeId(), V_derivedConstraint, P_Constraint_specification);
					
					A_symbol__11 = A_symbol__12;
				}
				else if (A_symbol__10 == ValuesUtil.FALSE_VALUE) {
					A_symbol__11 = Null;
				}
				else {
					A_symbol__11 = createInvalidValue("non-Boolean if condition");
				}
				final @NonNull Object V_derivedSpecification = A_symbol__11;
					
					DomainType static_A_symbol__13 = evaluator.getStaticTypeOf(V_initialConstraint, Null);
					LibraryBinaryOperation dynamic_A_symbol__13 = (LibraryBinaryOperation)static_A_symbol__13.lookupImplementation(standardLibrary, O_OclAny__lt__gt_);
					Object A_symbol__13 = dynamic_A_symbol__13.evaluate(evaluator, TypeId.BOOLEAN, V_initialConstraint, Null);
				Object A_symbol__14;
				if (A_symbol__13 == ValuesUtil.TRUE_VALUE) {
					
					Object A_symbol__15 = IP_Constraint_specification.evaluate(evaluator, T_pivot__ValueSpecification.getTypeId(), V_initialConstraint, P_Constraint_specification);
					
					A_symbol__14 = A_symbol__15;
				}
				else if (A_symbol__13 == ValuesUtil.FALSE_VALUE) {
					A_symbol__14 = Null;
				}
				else {
					A_symbol__14 = createInvalidValue("non-Boolean if condition");
				}
				final @NonNull Object V_initialSpecification = A_symbol__14;
					
					DomainType static_A_symbol__16 = evaluator.getStaticTypeOf(V_derivedSpecification, Null);
					LibraryBinaryOperation dynamic_A_symbol__16 = (LibraryBinaryOperation)static_A_symbol__16.lookupImplementation(standardLibrary, O_OclAny__lt__gt_);
					Object A_symbol__16 = dynamic_A_symbol__16.evaluate(evaluator, TypeId.BOOLEAN, V_derivedSpecification, Null);
				Object A_symbol__17;
				if (A_symbol__16 == ValuesUtil.TRUE_VALUE) {
					
					A_symbol__17 = V_derivedSpecification;
				}
				else if (A_symbol__16 == ValuesUtil.FALSE_VALUE) {
					
					A_symbol__17 = V_initialSpecification;
				}
				else {
					A_symbol__17 = createInvalidValue("non-Boolean if condition");
				}
				final @NonNull Object V_initialiser = A_symbol__17;
				Object leftA_symbol__18;
				try {
					Object leftA_symbol__19;
					try {
						
						DomainType static_A_symbol__20 = evaluator.getStaticTypeOf(V_initialiser, Null);
						LibraryBinaryOperation dynamic_A_symbol__20 = (LibraryBinaryOperation)static_A_symbol__20.lookupImplementation(standardLibrary, O_OclAny__lt__gt_);
						Object A_symbol__20 = dynamic_A_symbol__20.evaluate(evaluator, TypeId.BOOLEAN, V_initialiser, Null);
						leftA_symbol__19 = A_symbol__20;
					} catch (InvalidValueException e) {
						leftA_symbol__19 = createInvalidValue(e);
					}
					Object A_symbol__20 = leftA_symbol__19;
					Object rightA_symbol__19;
					try {
						
						DomainType static_A_symbol__21 = evaluator.getStaticTypeOf(V_initialiser);
						LibraryBinaryOperation dynamic_A_symbol__21 = (LibraryBinaryOperation)static_A_symbol__21.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Object A_symbol__21 = dynamic_A_symbol__21.evaluate(evaluator, TypeId.BOOLEAN, V_initialiser, T_Metaclass_pivot__ExpressionInOCL_);
						rightA_symbol__19 = A_symbol__21;
					} catch (InvalidValueException e) {
						rightA_symbol__19 = createInvalidValue(e);
					}
					Object A_symbol__21 = rightA_symbol__19;
					DomainType static_A_symbol__19 = evaluator.getStaticTypeOf(A_symbol__20);
					LibraryBinaryOperation dynamic_A_symbol__19 = (LibraryBinaryOperation)static_A_symbol__19.lookupImplementation(standardLibrary, O_Boolean_and);
					Object A_symbol__19 = dynamic_A_symbol__19.evaluate(evaluator, TypeId.BOOLEAN, A_symbol__20, A_symbol__21);
					leftA_symbol__18 = A_symbol__19;
				} catch (InvalidValueException e) {
					leftA_symbol__18 = createInvalidValue(e);
				}
				Object A_symbol__19 = leftA_symbol__18;
				Object rightA_symbol__18;
				try {
					
					
					DomainType static_A_symbol__22 = evaluator.getStaticTypeOf(self);
					LibraryBinaryOperation dynamic_A_symbol__22 = (LibraryBinaryOperation)static_A_symbol__22.lookupImplementation(standardLibrary, O_TypedMultiplicityElement_CompatibleBody);
					Object A_symbol__22 = dynamic_A_symbol__22.evaluate(evaluator, TypeId.BOOLEAN, self, V_initialiser);
					rightA_symbol__18 = A_symbol__22;
				} catch (InvalidValueException e) {
					rightA_symbol__18 = createInvalidValue(e);
				}
				Object A_symbol__22 = rightA_symbol__18;
				DomainType static_A_symbol__18 = evaluator.getStaticTypeOf(A_symbol__19);
				LibraryBinaryOperation dynamic_A_symbol__18 = (LibraryBinaryOperation)static_A_symbol__18.lookupImplementation(standardLibrary, O_Boolean_implies);
				Object A_symbol__18 = dynamic_A_symbol__18.evaluate(evaluator, TypeId.BOOLEAN, A_symbol__19, A_symbol__22);
				final @NonNull Object A_symbol__23 = A_symbol__18;
				final @NonNull Object A_symbol__24 = A_symbol__23;
				final @NonNull Object A_symbol__25 = A_symbol__24;
				final @NonNull Object A_symbol__26 = A_symbol__25;
				final @NonNull Object A_symbol__27 = A_symbol__26;
				rightA_symbol_ = A_symbol__27;
			} catch (InvalidValueException e) {
				rightA_symbol_ = createInvalidValue(e);
			}
			Object A_symbol__27 = rightA_symbol_;
			DomainType static_A_symbol_ = evaluator.getStaticTypeOf(A_symbol__1);
			LibraryBinaryOperation dynamic_A_symbol_ = (LibraryBinaryOperation)static_A_symbol_.lookupImplementation(standardLibrary, O_Boolean_implies);
			Object A_symbol_ = dynamic_A_symbol_.evaluate(evaluator, TypeId.BOOLEAN, A_symbol__1, A_symbol__27);
			return A_symbol_;
		}
	}

	/** 
	 * Implementation of the Property::isAttribute '' <body>.
	 */
	public static class _isAttribute_body_ extends AbstractBinaryOperation
	{
		public static @NonNull _isAttribute_body_ INSTANCE = new _isAttribute_body_();
	
		/*
		let container : OclElement = oclContainer()
	in
	  container.oclIsKindOf(Type) and
	  container.oclAsType(Type)
	  .ownedAttribute->includes(self)
		*/
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @NonNull Object self, final @NonNull Object p) throws InvalidValueException {
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			final @NonNull ExecutorOperation O_Boolean_and = OCLstdlibTables.Operations._Boolean__and;
			final @NonNull ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
			final @NonNull Object T_Metaclass_Type_ = createTypeValue(OCLstdlibTables.Types._Type);
			final @NonNull ExecutorOperation O_Collection_includes = OCLstdlibTables.Operations._Collection__includes;
			final @NonNull ExecutorType T_pivot__Property = PivotTables.Types._Property;
			final @NonNull DomainCollectionType T_OrderedSet_pivot__Property_ = standardLibrary.getOrderedSetType(T_pivot__Property, null, null);
			final @NonNull ExecutorProperty P_Type_ownedAttribute = PivotTables.Properties._Type__ownedAttribute;
			final @NonNull LibraryProperty IP_Type_ownedAttribute = P_Type_ownedAttribute.getImplementation();
			final @NonNull ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final @NonNull ExecutorOperation O_OclAny_oclAsType = OCLstdlibTables.Operations._OclAny__oclAsType;
			final @NonNull ExecutorType T_OclElement = OCLstdlibTables.Types._OclElement;
			final @NonNull ExecutorOperation O_OclElement_oclContainer = OCLstdlibTables.Operations._OclElement__oclContainer;
			
			
			DomainType static_A_symbol__28 = evaluator.getStaticTypeOf(self);
			LibraryUnaryOperation dynamic_A_symbol__28 = (LibraryUnaryOperation)static_A_symbol__28.lookupImplementation(standardLibrary, O_OclElement_oclContainer);
			Object A_symbol__28 = dynamic_A_symbol__28.evaluate(evaluator, T_OclElement.getTypeId(), self);
			final @NonNull Object V_container = A_symbol__28;
			Object leftA_symbol__29;
			try {
				
				DomainType static_A_symbol__30 = evaluator.getStaticTypeOf(V_container);
				LibraryBinaryOperation dynamic_A_symbol__30 = (LibraryBinaryOperation)static_A_symbol__30.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
				Object A_symbol__30 = dynamic_A_symbol__30.evaluate(evaluator, TypeId.BOOLEAN, V_container, T_Metaclass_Type_);
				leftA_symbol__29 = A_symbol__30;
			} catch (InvalidValueException e) {
				leftA_symbol__29 = createInvalidValue(e);
			}
			Object A_symbol__30 = leftA_symbol__29;
			Object rightA_symbol__29;
			try {
				
				DomainType static_A_symbol__31 = evaluator.getStaticTypeOf(V_container);
				LibraryBinaryOperation dynamic_A_symbol__31 = (LibraryBinaryOperation)static_A_symbol__31.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Object A_symbol__31 = dynamic_A_symbol__31.evaluate(evaluator, T_Type.getTypeId(), V_container, T_Metaclass_Type_);
				Object A_symbol__32 = IP_Type_ownedAttribute.evaluate(evaluator, T_OrderedSet_pivot__Property_.getTypeId(), A_symbol__31, P_Type_ownedAttribute);
				
				
				DomainType static_A_symbol__33 = evaluator.getStaticTypeOf(A_symbol__32);
				LibraryBinaryOperation dynamic_A_symbol__33 = (LibraryBinaryOperation)static_A_symbol__33.lookupImplementation(standardLibrary, O_Collection_includes);
				Object A_symbol__33 = dynamic_A_symbol__33.evaluate(evaluator, TypeId.BOOLEAN, A_symbol__32, self);
				rightA_symbol__29 = A_symbol__33;
			} catch (InvalidValueException e) {
				rightA_symbol__29 = createInvalidValue(e);
			}
			Object A_symbol__33 = rightA_symbol__29;
			DomainType static_A_symbol__29 = evaluator.getStaticTypeOf(A_symbol__30);
			LibraryBinaryOperation dynamic_A_symbol__29 = (LibraryBinaryOperation)static_A_symbol__29.lookupImplementation(standardLibrary, O_Boolean_and);
			Object A_symbol__29 = dynamic_A_symbol__29.evaluate(evaluator, TypeId.BOOLEAN, A_symbol__30, A_symbol__33);
			final @NonNull Object A_symbol__34 = A_symbol__29;
			return A_symbol__34;
		}
	}






















}

