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
		public static _invariant_CompatibleInitialiser INSTANCE = new _invariant_CompatibleInitialiser();
	
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
		public Value evaluate(DomainEvaluator evaluator, DomainType returnType, final Value self) throws InvalidValueException {
			final ValueFactory valueFactory = evaluator.getValueFactory();
			final DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final ExecutorProperty P_Property_isDerived = PivotTables.Properties._Property__isDerived;
			final LibraryProperty IP_Property_isDerived = P_Property_isDerived.getImplementation();
			final ExecutorOperation O_Boolean_and = OCLstdlibTables.Operations._Boolean__and;
			final ExecutorOperation O_OclAny__lt__gt_ = OCLstdlibTables.Operations._OclAny___lt__gt_;
			final NullValue Null = valueFactory.getNull();
			final ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
			final Value T_ClassClassifier_Pivot_ecore__pivot__ExpressionInOCL_ = valueFactory.createTypeValue(PivotTables.Types._ExpressionInOCL);
			final ExecutorOperation O_TypedMultiplicityElement_CompatibleBody = PivotTables.Operations._TypedMultiplicityElement__CompatibleBody;
			final ExecutorType T_Pivot_ecore__pivot__ValueSpecification = PivotTables.Types._ValueSpecification;
			final ExecutorProperty P_Constraint_specification = PivotTables.Properties._Constraint__specification;
			final LibraryProperty IP_Constraint_specification = P_Constraint_specification.getImplementation();
			final ExecutorType T_Pivot_ecore__pivot__Constraint = PivotTables.Types._Constraint;
			final ExecutorOperation O_Collection_any = OCLstdlibTables.Operations._Collection__any;
			final DomainCollectionType T_OrderedSet_Pivot_ecore__pivot__Constraint_ = standardLibrary.getOrderedSetType(T_Pivot_ecore__pivot__Constraint);
			final ExecutorProperty P_NamedElement_ownedRule = PivotTables.Properties._NamedElement__ownedRule;
			final LibraryProperty IP_NamedElement_ownedRule = P_NamedElement_ownedRule.getImplementation();
			final ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final ExecutorType T_String = OCLstdlibTables.Types._String;
			final ExecutorProperty P_Constraint_stereotype = PivotTables.Properties._Constraint__stereotype;
			final LibraryProperty IP_Constraint_stereotype = P_Constraint_stereotype.getImplementation();
			final StringValue S_initial = valueFactory.stringValueOf("initial");
			final StringValue S_derivati___ = valueFactory.stringValueOf("derivation");
			
			Value leftA_symbol_352;
			try {
				
				Value A_symbol_353 = IP_Property_isDerived.evaluate(evaluator, T_Boolean, self, P_Property_isDerived);
				
				leftA_symbol_352 = A_symbol_353;
			} catch (InvalidValueException e) {
				leftA_symbol_352 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_353 = leftA_symbol_352;
			Value rightA_symbol_352;
			try {
				
				Value A_symbol_354 = IP_NamedElement_ownedRule.evaluate(evaluator, T_OrderedSet_Pivot_ecore__pivot__Constraint_, self, P_NamedElement_ownedRule);
				
				
				/** 
				 * Implementation of the iterator body.
				 */
				AbstractBinaryOperation body_A_symbol_355 = new AbstractBinaryOperation()
				{
				/*
				stereotype = 'derivation'
				*/
					public Value evaluate(DomainEvaluator evaluator, DomainType returnType, Value sourceValue, Value iterator1) throws InvalidValueException {
						final Value V_1_ = iterator1;	// iterator: 1_
						
						Value A_symbol_356 = IP_Constraint_stereotype.evaluate(evaluator, T_String, V_1_, P_Constraint_stereotype);
						
						DomainType static_A_symbol_357 = valueFactory.typeOf(A_symbol_356, S_derivati___);
						LibraryBinaryOperation dynamic_A_symbol_357 = (LibraryBinaryOperation)static_A_symbol_357.lookupImplementation(standardLibrary, O_String__eq_);
						Value A_symbol_357 = dynamic_A_symbol_357.evaluate(evaluator, T_Boolean, A_symbol_356, S_derivati___);
						return A_symbol_357;
					}
				};
				DomainType static_A_symbol_355 = A_symbol_354.getType();
				LibraryIteration dynamic_A_symbol_355 = (LibraryIteration)static_A_symbol_355.lookupImplementation(standardLibrary, O_Collection_any);
				Value acc_A_symbol_355 = dynamic_A_symbol_355.createAccumulatorValue(evaluator, T_Pivot_ecore__pivot__Constraint, T_Boolean);
				ExecutorSingleIterationManager manager_A_symbol_355 = new ExecutorSingleIterationManager(evaluator, T_Pivot_ecore__pivot__Constraint, body_A_symbol_355, (CollectionValue)A_symbol_354, acc_A_symbol_355);
				Value A_symbol_355 = dynamic_A_symbol_355.evaluateIteration(manager_A_symbol_355);
				final Value V_derivedConstraint = A_symbol_355;
				
				Value A_symbol_358 = IP_NamedElement_ownedRule.evaluate(evaluator, T_OrderedSet_Pivot_ecore__pivot__Constraint_, self, P_NamedElement_ownedRule);
				
				
				/** 
				 * Implementation of the iterator body.
				 */
				AbstractBinaryOperation body_A_symbol_359 = new AbstractBinaryOperation()
				{
				/*
				stereotype = 'initial'
				*/
					public Value evaluate(DomainEvaluator evaluator, DomainType returnType, Value sourceValue, Value iterator1) throws InvalidValueException {
						final Value V_1_1 = iterator1;	// iterator: 1_
						
						Value A_symbol_360 = IP_Constraint_stereotype.evaluate(evaluator, T_String, V_1_1, P_Constraint_stereotype);
						
						DomainType static_A_symbol_361 = valueFactory.typeOf(A_symbol_360, S_initial);
						LibraryBinaryOperation dynamic_A_symbol_361 = (LibraryBinaryOperation)static_A_symbol_361.lookupImplementation(standardLibrary, O_String__eq_);
						Value A_symbol_361 = dynamic_A_symbol_361.evaluate(evaluator, T_Boolean, A_symbol_360, S_initial);
						return A_symbol_361;
					}
				};
				DomainType static_A_symbol_359 = A_symbol_358.getType();
				LibraryIteration dynamic_A_symbol_359 = (LibraryIteration)static_A_symbol_359.lookupImplementation(standardLibrary, O_Collection_any);
				Value acc_A_symbol_359 = dynamic_A_symbol_359.createAccumulatorValue(evaluator, T_Pivot_ecore__pivot__Constraint, T_Boolean);
				ExecutorSingleIterationManager manager_A_symbol_359 = new ExecutorSingleIterationManager(evaluator, T_Pivot_ecore__pivot__Constraint, body_A_symbol_359, (CollectionValue)A_symbol_358, acc_A_symbol_359);
				Value A_symbol_359 = dynamic_A_symbol_359.evaluateIteration(manager_A_symbol_359);
				final Value V_initialConstraint = A_symbol_359;
					
					DomainType static_A_symbol_362 = valueFactory.typeOf(V_derivedConstraint, Null);
					LibraryBinaryOperation dynamic_A_symbol_362 = (LibraryBinaryOperation)static_A_symbol_362.lookupImplementation(standardLibrary, O_OclAny__lt__gt_);
					Value A_symbol_362 = dynamic_A_symbol_362.evaluate(evaluator, T_Boolean, V_derivedConstraint, Null);
				Value A_symbol_363;
				if (A_symbol_362.isTrue()) {
					
					Value A_symbol_364 = IP_Constraint_specification.evaluate(evaluator, T_Pivot_ecore__pivot__ValueSpecification, V_derivedConstraint, P_Constraint_specification);
					
					A_symbol_363 = A_symbol_364;
				}
				else if (A_symbol_362.isFalse()) {
					A_symbol_363 = Null;
				}
				else if (A_symbol_362.isNull()) {
					A_symbol_363 = valueFactory.throwInvalidValueException("null if condition");
				}
				else {
					A_symbol_363 = valueFactory.throwInvalidValueException("invalid if condition");
				}
				final Value V_derivedSpecification = A_symbol_363;
					
					DomainType static_A_symbol_365 = valueFactory.typeOf(V_initialConstraint, Null);
					LibraryBinaryOperation dynamic_A_symbol_365 = (LibraryBinaryOperation)static_A_symbol_365.lookupImplementation(standardLibrary, O_OclAny__lt__gt_);
					Value A_symbol_365 = dynamic_A_symbol_365.evaluate(evaluator, T_Boolean, V_initialConstraint, Null);
				Value A_symbol_366;
				if (A_symbol_365.isTrue()) {
					
					Value A_symbol_367 = IP_Constraint_specification.evaluate(evaluator, T_Pivot_ecore__pivot__ValueSpecification, V_initialConstraint, P_Constraint_specification);
					
					A_symbol_366 = A_symbol_367;
				}
				else if (A_symbol_365.isFalse()) {
					A_symbol_366 = Null;
				}
				else if (A_symbol_365.isNull()) {
					A_symbol_366 = valueFactory.throwInvalidValueException("null if condition");
				}
				else {
					A_symbol_366 = valueFactory.throwInvalidValueException("invalid if condition");
				}
				final Value V_initialSpecification = A_symbol_366;
					
					DomainType static_A_symbol_368 = valueFactory.typeOf(V_derivedSpecification, Null);
					LibraryBinaryOperation dynamic_A_symbol_368 = (LibraryBinaryOperation)static_A_symbol_368.lookupImplementation(standardLibrary, O_OclAny__lt__gt_);
					Value A_symbol_368 = dynamic_A_symbol_368.evaluate(evaluator, T_Boolean, V_derivedSpecification, Null);
				Value A_symbol_369;
				if (A_symbol_368.isTrue()) {
					
					A_symbol_369 = V_derivedSpecification;
				}
				else if (A_symbol_368.isFalse()) {
					
					A_symbol_369 = V_initialSpecification;
				}
				else if (A_symbol_368.isNull()) {
					A_symbol_369 = valueFactory.throwInvalidValueException("null if condition");
				}
				else {
					A_symbol_369 = valueFactory.throwInvalidValueException("invalid if condition");
				}
				final Value V_initialiser = A_symbol_369;
				Value leftA_symbol_370;
				try {
					Value leftA_symbol_371;
					try {
						
						DomainType static_A_symbol_372 = valueFactory.typeOf(V_initialiser, Null);
						LibraryBinaryOperation dynamic_A_symbol_372 = (LibraryBinaryOperation)static_A_symbol_372.lookupImplementation(standardLibrary, O_OclAny__lt__gt_);
						Value A_symbol_372 = dynamic_A_symbol_372.evaluate(evaluator, T_Boolean, V_initialiser, Null);
						leftA_symbol_371 = A_symbol_372;
					} catch (InvalidValueException e) {
						leftA_symbol_371 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_372 = leftA_symbol_371;
					Value rightA_symbol_371;
					try {
						
						DomainType static_A_symbol_373 = valueFactory.typeOf(V_initialiser);
						LibraryBinaryOperation dynamic_A_symbol_373 = (LibraryBinaryOperation)static_A_symbol_373.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Value A_symbol_373 = dynamic_A_symbol_373.evaluate(evaluator, T_Boolean, V_initialiser, T_ClassClassifier_Pivot_ecore__pivot__ExpressionInOCL_);
						rightA_symbol_371 = A_symbol_373;
					} catch (InvalidValueException e) {
						rightA_symbol_371 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_373 = rightA_symbol_371;
					DomainType static_A_symbol_371 = valueFactory.typeOf(A_symbol_372);
					LibraryBinaryOperation dynamic_A_symbol_371 = (LibraryBinaryOperation)static_A_symbol_371.lookupImplementation(standardLibrary, O_Boolean_and);
					Value A_symbol_371 = dynamic_A_symbol_371.evaluate(evaluator, T_Boolean, A_symbol_372, A_symbol_373);
					leftA_symbol_370 = A_symbol_371;
				} catch (InvalidValueException e) {
					leftA_symbol_370 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_371 = leftA_symbol_370;
				Value rightA_symbol_370;
				try {
					
					
					DomainType static_A_symbol_374 = valueFactory.typeOf(self);
					LibraryBinaryOperation dynamic_A_symbol_374 = (LibraryBinaryOperation)static_A_symbol_374.lookupImplementation(standardLibrary, O_TypedMultiplicityElement_CompatibleBody);
					Value A_symbol_374 = dynamic_A_symbol_374.evaluate(evaluator, T_Boolean, self, V_initialiser);
					rightA_symbol_370 = A_symbol_374;
				} catch (InvalidValueException e) {
					rightA_symbol_370 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_374 = rightA_symbol_370;
				DomainType static_A_symbol_370 = valueFactory.typeOf(A_symbol_371);
				LibraryBinaryOperation dynamic_A_symbol_370 = (LibraryBinaryOperation)static_A_symbol_370.lookupImplementation(standardLibrary, O_Boolean_implies);
				Value A_symbol_370 = dynamic_A_symbol_370.evaluate(evaluator, T_Boolean, A_symbol_371, A_symbol_374);
				final Value A_symbol_375 = A_symbol_370;
				final Value A_symbol_376 = A_symbol_375;
				final Value A_symbol_377 = A_symbol_376;
				final Value A_symbol_378 = A_symbol_377;
				final Value A_symbol_379 = A_symbol_378;
				rightA_symbol_352 = A_symbol_379;
			} catch (InvalidValueException e) {
				rightA_symbol_352 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_379 = rightA_symbol_352;
			DomainType static_A_symbol_352 = valueFactory.typeOf(A_symbol_353);
			LibraryBinaryOperation dynamic_A_symbol_352 = (LibraryBinaryOperation)static_A_symbol_352.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_352 = dynamic_A_symbol_352.evaluate(evaluator, T_Boolean, A_symbol_353, A_symbol_379);
			return A_symbol_352;
		}
	}

	/** 
	 * Implementation of the Property::isAttribute '' <body>.
	 */
	public static class _isAttribute_body_ extends AbstractBinaryOperation
	{
		public static _isAttribute_body_ INSTANCE = new _isAttribute_body_();
	
		/*
		let container : OclElement = oclContainer()
	in
	  container.oclIsKindOf(Type) and
	  container.oclAsType(Type)
	  .ownedAttribute->includes(self)
		*/
		public Value evaluate(DomainEvaluator evaluator, DomainType returnType, final Value self, final Value p) throws InvalidValueException {
			final ValueFactory valueFactory = evaluator.getValueFactory();
			final DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final ExecutorOperation O_Boolean_and = OCLstdlibTables.Operations._Boolean__and;
			final ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
			final Value T_ClassClassifier_Type_ = valueFactory.createTypeValue(OCLstdlibTables.Types._Type);
			final ExecutorOperation O_Collection_includes = OCLstdlibTables.Operations._Collection__includes;
			final ExecutorType T_Pivot_ecore__pivot__Property = PivotTables.Types._Property;
			final DomainCollectionType T_OrderedSet_Pivot_ecore__pivot__Property_ = standardLibrary.getOrderedSetType(T_Pivot_ecore__pivot__Property);
			final ExecutorProperty P_Type_ownedAttribute = PivotTables.Properties._Type__ownedAttribute;
			final LibraryProperty IP_Type_ownedAttribute = P_Type_ownedAttribute.getImplementation();
			final ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final ExecutorOperation O_OclAny_oclAsType = OCLstdlibTables.Operations._OclAny__oclAsType;
			final ExecutorType T_OclElement = OCLstdlibTables.Types._OclElement;
			final ExecutorOperation O_OclElement_oclContainer = OCLstdlibTables.Operations._OclElement__oclContainer;
			
			
			DomainType static_A_symbol_380 = valueFactory.typeOf(self);
			LibraryUnaryOperation dynamic_A_symbol_380 = (LibraryUnaryOperation)static_A_symbol_380.lookupImplementation(standardLibrary, O_OclElement_oclContainer);
			Value A_symbol_380 = dynamic_A_symbol_380.evaluate(evaluator, T_OclElement, self);
			final Value V_container = A_symbol_380;
			Value leftA_symbol_381;
			try {
				
				DomainType static_A_symbol_382 = valueFactory.typeOf(V_container);
				LibraryBinaryOperation dynamic_A_symbol_382 = (LibraryBinaryOperation)static_A_symbol_382.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
				Value A_symbol_382 = dynamic_A_symbol_382.evaluate(evaluator, T_Boolean, V_container, T_ClassClassifier_Type_);
				leftA_symbol_381 = A_symbol_382;
			} catch (InvalidValueException e) {
				leftA_symbol_381 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_382 = leftA_symbol_381;
			Value rightA_symbol_381;
			try {
				
				DomainType static_A_symbol_383 = valueFactory.typeOf(V_container);
				LibraryBinaryOperation dynamic_A_symbol_383 = (LibraryBinaryOperation)static_A_symbol_383.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_383 = dynamic_A_symbol_383.evaluate(evaluator, T_Type, V_container, T_ClassClassifier_Type_);
				Value A_symbol_384 = IP_Type_ownedAttribute.evaluate(evaluator, T_OrderedSet_Pivot_ecore__pivot__Property_, A_symbol_383, P_Type_ownedAttribute);
				
				
				DomainType static_A_symbol_385 = valueFactory.typeOf(A_symbol_384);
				LibraryBinaryOperation dynamic_A_symbol_385 = (LibraryBinaryOperation)static_A_symbol_385.lookupImplementation(standardLibrary, O_Collection_includes);
				Value A_symbol_385 = dynamic_A_symbol_385.evaluate(evaluator, T_Boolean, A_symbol_384, self);
				rightA_symbol_381 = A_symbol_385;
			} catch (InvalidValueException e) {
				rightA_symbol_381 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_385 = rightA_symbol_381;
			DomainType static_A_symbol_381 = valueFactory.typeOf(A_symbol_382);
			LibraryBinaryOperation dynamic_A_symbol_381 = (LibraryBinaryOperation)static_A_symbol_381.lookupImplementation(standardLibrary, O_Boolean_and);
			Value A_symbol_381 = dynamic_A_symbol_381.evaluate(evaluator, T_Boolean, A_symbol_382, A_symbol_385);
			final Value A_symbol_386 = A_symbol_381;
			return A_symbol_386;
		}
	}






















}

