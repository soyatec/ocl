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
import org.eclipse.ocl.examples.domain.values.NullValue;
import org.eclipse.ocl.examples.domain.values.StringValue;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.domain.values.ValueFactory;
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
		public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Value self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final @NonNull ExecutorProperty P_Property_isDerived = PivotTables.Properties._Property__isDerived;
			final @NonNull LibraryProperty IP_Property_isDerived = P_Property_isDerived.getImplementation();
			final @NonNull ExecutorOperation O_Boolean_and = OCLstdlibTables.Operations._Boolean__and;
			final @NonNull ExecutorOperation O_OclAny__lt__gt_ = OCLstdlibTables.Operations._OclAny___lt__gt_;
			final @NonNull NullValue Null = valueFactory.getNull();
			final @NonNull ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
			final @NonNull Value T_ClassClassifier_pivot__ExpressionInOCL_ = valueFactory.createTypeValue(PivotTables.Types._ExpressionInOCL);
			final @NonNull ExecutorOperation O_TypedMultiplicityElement_CompatibleBody = PivotTables.Operations._TypedMultiplicityElement__CompatibleBody;
			final @NonNull ExecutorType T_pivot__ValueSpecification = PivotTables.Types._ValueSpecification;
			final @NonNull ExecutorProperty P_Constraint_specification = PivotTables.Properties._Constraint__specification;
			final @NonNull LibraryProperty IP_Constraint_specification = P_Constraint_specification.getImplementation();
			final @NonNull ExecutorType T_pivot__Constraint = PivotTables.Types._Constraint;
			final @NonNull ExecutorOperation O_Collection_any = OCLstdlibTables.Operations._Collection__any;
			final @NonNull DomainCollectionType T_OrderedSet_pivot__Constraint_ = standardLibrary.getOrderedSetType(T_pivot__Constraint);
			final @NonNull ExecutorProperty P_NamedElement_ownedRule = PivotTables.Properties._NamedElement__ownedRule;
			final @NonNull LibraryProperty IP_NamedElement_ownedRule = P_NamedElement_ownedRule.getImplementation();
			final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final @NonNull ExecutorType T_String = OCLstdlibTables.Types._String;
			final @NonNull ExecutorProperty P_Constraint_stereotype = PivotTables.Properties._Constraint__stereotype;
			final @NonNull LibraryProperty IP_Constraint_stereotype = P_Constraint_stereotype.getImplementation();
			final @NonNull StringValue S_initial = valueFactory.stringValueOf("initial");
			final @NonNull StringValue S_derivati___ = valueFactory.stringValueOf("derivation");
			
			Value leftA_symbol_30;
			try {
				
				Value A_symbol_31 = IP_Property_isDerived.evaluate(evaluator, T_Boolean, self, P_Property_isDerived);
				
				leftA_symbol_30 = A_symbol_31;
			} catch (InvalidValueException e) {
				leftA_symbol_30 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_31 = leftA_symbol_30;
			Value rightA_symbol_30;
			try {
				
				Value A_symbol_32 = IP_NamedElement_ownedRule.evaluate(evaluator, T_OrderedSet_pivot__Constraint_, self, P_NamedElement_ownedRule);
				
				
				/** 
				 * Implementation of the iterator body.
				 */
				AbstractBinaryOperation body_A_symbol_33 = new AbstractBinaryOperation()
				{
				/*
				stereotype = 'derivation'
				*/
					public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, @NonNull Value sourceValue, @NonNull Value iterator1) throws InvalidValueException {
						final @NonNull Value V_1_ = iterator1;	// iterator: 1_
						
						Value A_symbol_34 = IP_Constraint_stereotype.evaluate(evaluator, T_String, V_1_, P_Constraint_stereotype);
						
						DomainType static_A_symbol_35 = valueFactory.typeOf(A_symbol_34, S_derivati___);
						LibraryBinaryOperation dynamic_A_symbol_35 = (LibraryBinaryOperation)static_A_symbol_35.lookupImplementation(standardLibrary, O_String__eq_);
						Value A_symbol_35 = dynamic_A_symbol_35.evaluate(evaluator, T_Boolean, A_symbol_34, S_derivati___);
						return A_symbol_35;
					}
				};
				DomainType static_A_symbol_33 = A_symbol_32.getType();
				LibraryIteration dynamic_A_symbol_33 = (LibraryIteration)static_A_symbol_33.lookupImplementation(standardLibrary, O_Collection_any);
				Value acc_A_symbol_33 = dynamic_A_symbol_33.createAccumulatorValue(evaluator, T_pivot__Constraint, T_Boolean);
				ExecutorSingleIterationManager manager_A_symbol_33 = new ExecutorSingleIterationManager(evaluator, T_pivot__Constraint, body_A_symbol_33, (CollectionValue)A_symbol_32, acc_A_symbol_33);
				Value A_symbol_33 = dynamic_A_symbol_33.evaluateIteration(manager_A_symbol_33);
				final @NonNull Value V_derivedConstraint = A_symbol_33;
				
				Value A_symbol_36 = IP_NamedElement_ownedRule.evaluate(evaluator, T_OrderedSet_pivot__Constraint_, self, P_NamedElement_ownedRule);
				
				
				/** 
				 * Implementation of the iterator body.
				 */
				AbstractBinaryOperation body_A_symbol_37 = new AbstractBinaryOperation()
				{
				/*
				stereotype = 'initial'
				*/
					public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, @NonNull Value sourceValue, @NonNull Value iterator1) throws InvalidValueException {
						final @NonNull Value V_1_1 = iterator1;	// iterator: 1_
						
						Value A_symbol_38 = IP_Constraint_stereotype.evaluate(evaluator, T_String, V_1_1, P_Constraint_stereotype);
						
						DomainType static_A_symbol_39 = valueFactory.typeOf(A_symbol_38, S_initial);
						LibraryBinaryOperation dynamic_A_symbol_39 = (LibraryBinaryOperation)static_A_symbol_39.lookupImplementation(standardLibrary, O_String__eq_);
						Value A_symbol_39 = dynamic_A_symbol_39.evaluate(evaluator, T_Boolean, A_symbol_38, S_initial);
						return A_symbol_39;
					}
				};
				DomainType static_A_symbol_37 = A_symbol_36.getType();
				LibraryIteration dynamic_A_symbol_37 = (LibraryIteration)static_A_symbol_37.lookupImplementation(standardLibrary, O_Collection_any);
				Value acc_A_symbol_37 = dynamic_A_symbol_37.createAccumulatorValue(evaluator, T_pivot__Constraint, T_Boolean);
				ExecutorSingleIterationManager manager_A_symbol_37 = new ExecutorSingleIterationManager(evaluator, T_pivot__Constraint, body_A_symbol_37, (CollectionValue)A_symbol_36, acc_A_symbol_37);
				Value A_symbol_37 = dynamic_A_symbol_37.evaluateIteration(manager_A_symbol_37);
				final @NonNull Value V_initialConstraint = A_symbol_37;
					
					DomainType static_A_symbol_40 = valueFactory.typeOf(V_derivedConstraint, Null);
					LibraryBinaryOperation dynamic_A_symbol_40 = (LibraryBinaryOperation)static_A_symbol_40.lookupImplementation(standardLibrary, O_OclAny__lt__gt_);
					Value A_symbol_40 = dynamic_A_symbol_40.evaluate(evaluator, T_Boolean, V_derivedConstraint, Null);
				Value A_symbol_41;
				if (A_symbol_40.isTrue()) {
					
					Value A_symbol_42 = IP_Constraint_specification.evaluate(evaluator, T_pivot__ValueSpecification, V_derivedConstraint, P_Constraint_specification);
					
					A_symbol_41 = A_symbol_42;
				}
				else if (A_symbol_40.isFalse()) {
					A_symbol_41 = Null;
				}
				else if (A_symbol_40.isNull()) {
					A_symbol_41 = valueFactory.throwInvalidValueException("null if condition");
				}
				else {
					A_symbol_41 = valueFactory.throwInvalidValueException("invalid if condition");
				}
				final @NonNull Value V_derivedSpecification = A_symbol_41;
					
					DomainType static_A_symbol_43 = valueFactory.typeOf(V_initialConstraint, Null);
					LibraryBinaryOperation dynamic_A_symbol_43 = (LibraryBinaryOperation)static_A_symbol_43.lookupImplementation(standardLibrary, O_OclAny__lt__gt_);
					Value A_symbol_43 = dynamic_A_symbol_43.evaluate(evaluator, T_Boolean, V_initialConstraint, Null);
				Value A_symbol_44;
				if (A_symbol_43.isTrue()) {
					
					Value A_symbol_45 = IP_Constraint_specification.evaluate(evaluator, T_pivot__ValueSpecification, V_initialConstraint, P_Constraint_specification);
					
					A_symbol_44 = A_symbol_45;
				}
				else if (A_symbol_43.isFalse()) {
					A_symbol_44 = Null;
				}
				else if (A_symbol_43.isNull()) {
					A_symbol_44 = valueFactory.throwInvalidValueException("null if condition");
				}
				else {
					A_symbol_44 = valueFactory.throwInvalidValueException("invalid if condition");
				}
				final @NonNull Value V_initialSpecification = A_symbol_44;
					
					DomainType static_A_symbol_46 = valueFactory.typeOf(V_derivedSpecification, Null);
					LibraryBinaryOperation dynamic_A_symbol_46 = (LibraryBinaryOperation)static_A_symbol_46.lookupImplementation(standardLibrary, O_OclAny__lt__gt_);
					Value A_symbol_46 = dynamic_A_symbol_46.evaluate(evaluator, T_Boolean, V_derivedSpecification, Null);
				Value A_symbol_47;
				if (A_symbol_46.isTrue()) {
					
					A_symbol_47 = V_derivedSpecification;
				}
				else if (A_symbol_46.isFalse()) {
					
					A_symbol_47 = V_initialSpecification;
				}
				else if (A_symbol_46.isNull()) {
					A_symbol_47 = valueFactory.throwInvalidValueException("null if condition");
				}
				else {
					A_symbol_47 = valueFactory.throwInvalidValueException("invalid if condition");
				}
				final @NonNull Value V_initialiser = A_symbol_47;
				Value leftA_symbol_48;
				try {
					Value leftA_symbol_49;
					try {
						
						DomainType static_A_symbol_50 = valueFactory.typeOf(V_initialiser, Null);
						LibraryBinaryOperation dynamic_A_symbol_50 = (LibraryBinaryOperation)static_A_symbol_50.lookupImplementation(standardLibrary, O_OclAny__lt__gt_);
						Value A_symbol_50 = dynamic_A_symbol_50.evaluate(evaluator, T_Boolean, V_initialiser, Null);
						leftA_symbol_49 = A_symbol_50;
					} catch (InvalidValueException e) {
						leftA_symbol_49 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_50 = leftA_symbol_49;
					Value rightA_symbol_49;
					try {
						
						DomainType static_A_symbol_51 = valueFactory.typeOf(V_initialiser);
						LibraryBinaryOperation dynamic_A_symbol_51 = (LibraryBinaryOperation)static_A_symbol_51.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Value A_symbol_51 = dynamic_A_symbol_51.evaluate(evaluator, T_Boolean, V_initialiser, T_ClassClassifier_pivot__ExpressionInOCL_);
						rightA_symbol_49 = A_symbol_51;
					} catch (InvalidValueException e) {
						rightA_symbol_49 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_51 = rightA_symbol_49;
					DomainType static_A_symbol_49 = valueFactory.typeOf(A_symbol_50);
					LibraryBinaryOperation dynamic_A_symbol_49 = (LibraryBinaryOperation)static_A_symbol_49.lookupImplementation(standardLibrary, O_Boolean_and);
					Value A_symbol_49 = dynamic_A_symbol_49.evaluate(evaluator, T_Boolean, A_symbol_50, A_symbol_51);
					leftA_symbol_48 = A_symbol_49;
				} catch (InvalidValueException e) {
					leftA_symbol_48 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_49 = leftA_symbol_48;
				Value rightA_symbol_48;
				try {
					
					
					DomainType static_A_symbol_52 = valueFactory.typeOf(self);
					LibraryBinaryOperation dynamic_A_symbol_52 = (LibraryBinaryOperation)static_A_symbol_52.lookupImplementation(standardLibrary, O_TypedMultiplicityElement_CompatibleBody);
					Value A_symbol_52 = dynamic_A_symbol_52.evaluate(evaluator, T_Boolean, self, V_initialiser);
					rightA_symbol_48 = A_symbol_52;
				} catch (InvalidValueException e) {
					rightA_symbol_48 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_52 = rightA_symbol_48;
				DomainType static_A_symbol_48 = valueFactory.typeOf(A_symbol_49);
				LibraryBinaryOperation dynamic_A_symbol_48 = (LibraryBinaryOperation)static_A_symbol_48.lookupImplementation(standardLibrary, O_Boolean_implies);
				Value A_symbol_48 = dynamic_A_symbol_48.evaluate(evaluator, T_Boolean, A_symbol_49, A_symbol_52);
				final @NonNull Value A_symbol_53 = A_symbol_48;
				final @NonNull Value A_symbol_54 = A_symbol_53;
				final @NonNull Value A_symbol_55 = A_symbol_54;
				final @NonNull Value A_symbol_56 = A_symbol_55;
				final @NonNull Value A_symbol_57 = A_symbol_56;
				rightA_symbol_30 = A_symbol_57;
			} catch (InvalidValueException e) {
				rightA_symbol_30 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_57 = rightA_symbol_30;
			DomainType static_A_symbol_30 = valueFactory.typeOf(A_symbol_31);
			LibraryBinaryOperation dynamic_A_symbol_30 = (LibraryBinaryOperation)static_A_symbol_30.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_30 = dynamic_A_symbol_30.evaluate(evaluator, T_Boolean, A_symbol_31, A_symbol_57);
			return A_symbol_30;
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
		public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Value self, final @NonNull Value p) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Boolean_and = OCLstdlibTables.Operations._Boolean__and;
			final @NonNull ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
			final @NonNull Value T_ClassClassifier_Type_ = valueFactory.createTypeValue(OCLstdlibTables.Types._Type);
			final @NonNull ExecutorOperation O_Collection_includes = OCLstdlibTables.Operations._Collection__includes;
			final @NonNull ExecutorType T_pivot__Property = PivotTables.Types._Property;
			final @NonNull DomainCollectionType T_OrderedSet_pivot__Property_ = standardLibrary.getOrderedSetType(T_pivot__Property);
			final @NonNull ExecutorProperty P_Type_ownedAttribute = PivotTables.Properties._Type__ownedAttribute;
			final @NonNull LibraryProperty IP_Type_ownedAttribute = P_Type_ownedAttribute.getImplementation();
			final @NonNull ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final @NonNull ExecutorOperation O_OclAny_oclAsType = OCLstdlibTables.Operations._OclAny__oclAsType;
			final @NonNull ExecutorType T_OclElement = OCLstdlibTables.Types._OclElement;
			final @NonNull ExecutorOperation O_OclElement_oclContainer = OCLstdlibTables.Operations._OclElement__oclContainer;
			
			
			DomainType static_A_symbol_58 = valueFactory.typeOf(self);
			LibraryUnaryOperation dynamic_A_symbol_58 = (LibraryUnaryOperation)static_A_symbol_58.lookupImplementation(standardLibrary, O_OclElement_oclContainer);
			Value A_symbol_58 = dynamic_A_symbol_58.evaluate(evaluator, T_OclElement, self);
			final @NonNull Value V_container = A_symbol_58;
			Value leftA_symbol_59;
			try {
				
				DomainType static_A_symbol_60 = valueFactory.typeOf(V_container);
				LibraryBinaryOperation dynamic_A_symbol_60 = (LibraryBinaryOperation)static_A_symbol_60.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
				Value A_symbol_60 = dynamic_A_symbol_60.evaluate(evaluator, T_Boolean, V_container, T_ClassClassifier_Type_);
				leftA_symbol_59 = A_symbol_60;
			} catch (InvalidValueException e) {
				leftA_symbol_59 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_60 = leftA_symbol_59;
			Value rightA_symbol_59;
			try {
				
				DomainType static_A_symbol_61 = valueFactory.typeOf(V_container);
				LibraryBinaryOperation dynamic_A_symbol_61 = (LibraryBinaryOperation)static_A_symbol_61.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_61 = dynamic_A_symbol_61.evaluate(evaluator, T_Type, V_container, T_ClassClassifier_Type_);
				Value A_symbol_62 = IP_Type_ownedAttribute.evaluate(evaluator, T_OrderedSet_pivot__Property_, A_symbol_61, P_Type_ownedAttribute);
				
				
				DomainType static_A_symbol_63 = valueFactory.typeOf(A_symbol_62);
				LibraryBinaryOperation dynamic_A_symbol_63 = (LibraryBinaryOperation)static_A_symbol_63.lookupImplementation(standardLibrary, O_Collection_includes);
				Value A_symbol_63 = dynamic_A_symbol_63.evaluate(evaluator, T_Boolean, A_symbol_62, self);
				rightA_symbol_59 = A_symbol_63;
			} catch (InvalidValueException e) {
				rightA_symbol_59 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_63 = rightA_symbol_59;
			DomainType static_A_symbol_59 = valueFactory.typeOf(A_symbol_60);
			LibraryBinaryOperation dynamic_A_symbol_59 = (LibraryBinaryOperation)static_A_symbol_59.lookupImplementation(standardLibrary, O_Boolean_and);
			Value A_symbol_59 = dynamic_A_symbol_59.evaluate(evaluator, T_Boolean, A_symbol_60, A_symbol_63);
			final @NonNull Value A_symbol_64 = A_symbol_59;
			return A_symbol_64;
		}
	}






















}

