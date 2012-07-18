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
			final Value T_ClassClassifier_pivot__ExpressionInOCL_ = valueFactory.createTypeValue(PivotTables.Types._ExpressionInOCL);
			final ExecutorOperation O_TypedMultiplicityElement_CompatibleBody = PivotTables.Operations._TypedMultiplicityElement__CompatibleBody;
			final ExecutorType T_pivot__ValueSpecification = PivotTables.Types._ValueSpecification;
			final ExecutorProperty P_Constraint_specification = PivotTables.Properties._Constraint__specification;
			final LibraryProperty IP_Constraint_specification = P_Constraint_specification.getImplementation();
			final ExecutorType T_pivot__Constraint = PivotTables.Types._Constraint;
			final ExecutorOperation O_Collection_any = OCLstdlibTables.Operations._Collection__any;
			final DomainCollectionType T_OrderedSet_pivot__Constraint_ = standardLibrary.getOrderedSetType(T_pivot__Constraint);
			final ExecutorProperty P_NamedElement_ownedRule = PivotTables.Properties._NamedElement__ownedRule;
			final LibraryProperty IP_NamedElement_ownedRule = P_NamedElement_ownedRule.getImplementation();
			final ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final ExecutorType T_String = OCLstdlibTables.Types._String;
			final ExecutorProperty P_Constraint_stereotype = PivotTables.Properties._Constraint__stereotype;
			final LibraryProperty IP_Constraint_stereotype = P_Constraint_stereotype.getImplementation();
			final StringValue S_initial = valueFactory.stringValueOf("initial");
			final StringValue S_derivati___ = valueFactory.stringValueOf("derivation");
			
			Value leftA_symbol_370;
			try {
				
				Value A_symbol_371 = IP_Property_isDerived.evaluate(evaluator, T_Boolean, self, P_Property_isDerived);
				
				leftA_symbol_370 = A_symbol_371;
			} catch (InvalidValueException e) {
				leftA_symbol_370 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_371 = leftA_symbol_370;
			Value rightA_symbol_370;
			try {
				
				Value A_symbol_372 = IP_NamedElement_ownedRule.evaluate(evaluator, T_OrderedSet_pivot__Constraint_, self, P_NamedElement_ownedRule);
				
				
				/** 
				 * Implementation of the iterator body.
				 */
				AbstractBinaryOperation body_A_symbol_373 = new AbstractBinaryOperation()
				{
				/*
				stereotype = 'derivation'
				*/
					public Value evaluate(DomainEvaluator evaluator, DomainType returnType, Value sourceValue, Value iterator1) throws InvalidValueException {
						final Value V_1_ = iterator1;	// iterator: 1_
						
						Value A_symbol_374 = IP_Constraint_stereotype.evaluate(evaluator, T_String, V_1_, P_Constraint_stereotype);
						
						DomainType static_A_symbol_375 = valueFactory.typeOf(A_symbol_374, S_derivati___);
						LibraryBinaryOperation dynamic_A_symbol_375 = (LibraryBinaryOperation)static_A_symbol_375.lookupImplementation(standardLibrary, O_String__eq_);
						Value A_symbol_375 = dynamic_A_symbol_375.evaluate(evaluator, T_Boolean, A_symbol_374, S_derivati___);
						return A_symbol_375;
					}
				};
				DomainType static_A_symbol_373 = A_symbol_372.getType();
				LibraryIteration dynamic_A_symbol_373 = (LibraryIteration)static_A_symbol_373.lookupImplementation(standardLibrary, O_Collection_any);
				Value acc_A_symbol_373 = dynamic_A_symbol_373.createAccumulatorValue(evaluator, T_pivot__Constraint, T_Boolean);
				ExecutorSingleIterationManager manager_A_symbol_373 = new ExecutorSingleIterationManager(evaluator, T_pivot__Constraint, body_A_symbol_373, (CollectionValue)A_symbol_372, acc_A_symbol_373);
				Value A_symbol_373 = dynamic_A_symbol_373.evaluateIteration(manager_A_symbol_373);
				final Value V_derivedConstraint = A_symbol_373;
				
				Value A_symbol_376 = IP_NamedElement_ownedRule.evaluate(evaluator, T_OrderedSet_pivot__Constraint_, self, P_NamedElement_ownedRule);
				
				
				/** 
				 * Implementation of the iterator body.
				 */
				AbstractBinaryOperation body_A_symbol_377 = new AbstractBinaryOperation()
				{
				/*
				stereotype = 'initial'
				*/
					public Value evaluate(DomainEvaluator evaluator, DomainType returnType, Value sourceValue, Value iterator1) throws InvalidValueException {
						final Value V_1_1 = iterator1;	// iterator: 1_
						
						Value A_symbol_378 = IP_Constraint_stereotype.evaluate(evaluator, T_String, V_1_1, P_Constraint_stereotype);
						
						DomainType static_A_symbol_379 = valueFactory.typeOf(A_symbol_378, S_initial);
						LibraryBinaryOperation dynamic_A_symbol_379 = (LibraryBinaryOperation)static_A_symbol_379.lookupImplementation(standardLibrary, O_String__eq_);
						Value A_symbol_379 = dynamic_A_symbol_379.evaluate(evaluator, T_Boolean, A_symbol_378, S_initial);
						return A_symbol_379;
					}
				};
				DomainType static_A_symbol_377 = A_symbol_376.getType();
				LibraryIteration dynamic_A_symbol_377 = (LibraryIteration)static_A_symbol_377.lookupImplementation(standardLibrary, O_Collection_any);
				Value acc_A_symbol_377 = dynamic_A_symbol_377.createAccumulatorValue(evaluator, T_pivot__Constraint, T_Boolean);
				ExecutorSingleIterationManager manager_A_symbol_377 = new ExecutorSingleIterationManager(evaluator, T_pivot__Constraint, body_A_symbol_377, (CollectionValue)A_symbol_376, acc_A_symbol_377);
				Value A_symbol_377 = dynamic_A_symbol_377.evaluateIteration(manager_A_symbol_377);
				final Value V_initialConstraint = A_symbol_377;
					
					DomainType static_A_symbol_380 = valueFactory.typeOf(V_derivedConstraint, Null);
					LibraryBinaryOperation dynamic_A_symbol_380 = (LibraryBinaryOperation)static_A_symbol_380.lookupImplementation(standardLibrary, O_OclAny__lt__gt_);
					Value A_symbol_380 = dynamic_A_symbol_380.evaluate(evaluator, T_Boolean, V_derivedConstraint, Null);
				Value A_symbol_381;
				if (A_symbol_380.isTrue()) {
					
					Value A_symbol_382 = IP_Constraint_specification.evaluate(evaluator, T_pivot__ValueSpecification, V_derivedConstraint, P_Constraint_specification);
					
					A_symbol_381 = A_symbol_382;
				}
				else if (A_symbol_380.isFalse()) {
					A_symbol_381 = Null;
				}
				else if (A_symbol_380.isNull()) {
					A_symbol_381 = valueFactory.throwInvalidValueException("null if condition");
				}
				else {
					A_symbol_381 = valueFactory.throwInvalidValueException("invalid if condition");
				}
				final Value V_derivedSpecification = A_symbol_381;
					
					DomainType static_A_symbol_383 = valueFactory.typeOf(V_initialConstraint, Null);
					LibraryBinaryOperation dynamic_A_symbol_383 = (LibraryBinaryOperation)static_A_symbol_383.lookupImplementation(standardLibrary, O_OclAny__lt__gt_);
					Value A_symbol_383 = dynamic_A_symbol_383.evaluate(evaluator, T_Boolean, V_initialConstraint, Null);
				Value A_symbol_384;
				if (A_symbol_383.isTrue()) {
					
					Value A_symbol_385 = IP_Constraint_specification.evaluate(evaluator, T_pivot__ValueSpecification, V_initialConstraint, P_Constraint_specification);
					
					A_symbol_384 = A_symbol_385;
				}
				else if (A_symbol_383.isFalse()) {
					A_symbol_384 = Null;
				}
				else if (A_symbol_383.isNull()) {
					A_symbol_384 = valueFactory.throwInvalidValueException("null if condition");
				}
				else {
					A_symbol_384 = valueFactory.throwInvalidValueException("invalid if condition");
				}
				final Value V_initialSpecification = A_symbol_384;
					
					DomainType static_A_symbol_386 = valueFactory.typeOf(V_derivedSpecification, Null);
					LibraryBinaryOperation dynamic_A_symbol_386 = (LibraryBinaryOperation)static_A_symbol_386.lookupImplementation(standardLibrary, O_OclAny__lt__gt_);
					Value A_symbol_386 = dynamic_A_symbol_386.evaluate(evaluator, T_Boolean, V_derivedSpecification, Null);
				Value A_symbol_387;
				if (A_symbol_386.isTrue()) {
					
					A_symbol_387 = V_derivedSpecification;
				}
				else if (A_symbol_386.isFalse()) {
					
					A_symbol_387 = V_initialSpecification;
				}
				else if (A_symbol_386.isNull()) {
					A_symbol_387 = valueFactory.throwInvalidValueException("null if condition");
				}
				else {
					A_symbol_387 = valueFactory.throwInvalidValueException("invalid if condition");
				}
				final Value V_initialiser = A_symbol_387;
				Value leftA_symbol_388;
				try {
					Value leftA_symbol_389;
					try {
						
						DomainType static_A_symbol_390 = valueFactory.typeOf(V_initialiser, Null);
						LibraryBinaryOperation dynamic_A_symbol_390 = (LibraryBinaryOperation)static_A_symbol_390.lookupImplementation(standardLibrary, O_OclAny__lt__gt_);
						Value A_symbol_390 = dynamic_A_symbol_390.evaluate(evaluator, T_Boolean, V_initialiser, Null);
						leftA_symbol_389 = A_symbol_390;
					} catch (InvalidValueException e) {
						leftA_symbol_389 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_390 = leftA_symbol_389;
					Value rightA_symbol_389;
					try {
						
						DomainType static_A_symbol_391 = valueFactory.typeOf(V_initialiser);
						LibraryBinaryOperation dynamic_A_symbol_391 = (LibraryBinaryOperation)static_A_symbol_391.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Value A_symbol_391 = dynamic_A_symbol_391.evaluate(evaluator, T_Boolean, V_initialiser, T_ClassClassifier_pivot__ExpressionInOCL_);
						rightA_symbol_389 = A_symbol_391;
					} catch (InvalidValueException e) {
						rightA_symbol_389 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_391 = rightA_symbol_389;
					DomainType static_A_symbol_389 = valueFactory.typeOf(A_symbol_390);
					LibraryBinaryOperation dynamic_A_symbol_389 = (LibraryBinaryOperation)static_A_symbol_389.lookupImplementation(standardLibrary, O_Boolean_and);
					Value A_symbol_389 = dynamic_A_symbol_389.evaluate(evaluator, T_Boolean, A_symbol_390, A_symbol_391);
					leftA_symbol_388 = A_symbol_389;
				} catch (InvalidValueException e) {
					leftA_symbol_388 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_389 = leftA_symbol_388;
				Value rightA_symbol_388;
				try {
					
					
					DomainType static_A_symbol_392 = valueFactory.typeOf(self);
					LibraryBinaryOperation dynamic_A_symbol_392 = (LibraryBinaryOperation)static_A_symbol_392.lookupImplementation(standardLibrary, O_TypedMultiplicityElement_CompatibleBody);
					Value A_symbol_392 = dynamic_A_symbol_392.evaluate(evaluator, T_Boolean, self, V_initialiser);
					rightA_symbol_388 = A_symbol_392;
				} catch (InvalidValueException e) {
					rightA_symbol_388 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_392 = rightA_symbol_388;
				DomainType static_A_symbol_388 = valueFactory.typeOf(A_symbol_389);
				LibraryBinaryOperation dynamic_A_symbol_388 = (LibraryBinaryOperation)static_A_symbol_388.lookupImplementation(standardLibrary, O_Boolean_implies);
				Value A_symbol_388 = dynamic_A_symbol_388.evaluate(evaluator, T_Boolean, A_symbol_389, A_symbol_392);
				final Value A_symbol_393 = A_symbol_388;
				final Value A_symbol_394 = A_symbol_393;
				final Value A_symbol_395 = A_symbol_394;
				final Value A_symbol_396 = A_symbol_395;
				final Value A_symbol_397 = A_symbol_396;
				rightA_symbol_370 = A_symbol_397;
			} catch (InvalidValueException e) {
				rightA_symbol_370 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_397 = rightA_symbol_370;
			DomainType static_A_symbol_370 = valueFactory.typeOf(A_symbol_371);
			LibraryBinaryOperation dynamic_A_symbol_370 = (LibraryBinaryOperation)static_A_symbol_370.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_370 = dynamic_A_symbol_370.evaluate(evaluator, T_Boolean, A_symbol_371, A_symbol_397);
			return A_symbol_370;
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
			final ExecutorType T_pivot__Property = PivotTables.Types._Property;
			final DomainCollectionType T_OrderedSet_pivot__Property_ = standardLibrary.getOrderedSetType(T_pivot__Property);
			final ExecutorProperty P_Type_ownedAttribute = PivotTables.Properties._Type__ownedAttribute;
			final LibraryProperty IP_Type_ownedAttribute = P_Type_ownedAttribute.getImplementation();
			final ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final ExecutorOperation O_OclAny_oclAsType = OCLstdlibTables.Operations._OclAny__oclAsType;
			final ExecutorType T_OclElement = OCLstdlibTables.Types._OclElement;
			final ExecutorOperation O_OclElement_oclContainer = OCLstdlibTables.Operations._OclElement__oclContainer;
			
			
			DomainType static_A_symbol_398 = valueFactory.typeOf(self);
			LibraryUnaryOperation dynamic_A_symbol_398 = (LibraryUnaryOperation)static_A_symbol_398.lookupImplementation(standardLibrary, O_OclElement_oclContainer);
			Value A_symbol_398 = dynamic_A_symbol_398.evaluate(evaluator, T_OclElement, self);
			final Value V_container = A_symbol_398;
			Value leftA_symbol_399;
			try {
				
				DomainType static_A_symbol_400 = valueFactory.typeOf(V_container);
				LibraryBinaryOperation dynamic_A_symbol_400 = (LibraryBinaryOperation)static_A_symbol_400.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
				Value A_symbol_400 = dynamic_A_symbol_400.evaluate(evaluator, T_Boolean, V_container, T_ClassClassifier_Type_);
				leftA_symbol_399 = A_symbol_400;
			} catch (InvalidValueException e) {
				leftA_symbol_399 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_400 = leftA_symbol_399;
			Value rightA_symbol_399;
			try {
				
				DomainType static_A_symbol_401 = valueFactory.typeOf(V_container);
				LibraryBinaryOperation dynamic_A_symbol_401 = (LibraryBinaryOperation)static_A_symbol_401.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_401 = dynamic_A_symbol_401.evaluate(evaluator, T_Type, V_container, T_ClassClassifier_Type_);
				Value A_symbol_402 = IP_Type_ownedAttribute.evaluate(evaluator, T_OrderedSet_pivot__Property_, A_symbol_401, P_Type_ownedAttribute);
				
				
				DomainType static_A_symbol_403 = valueFactory.typeOf(A_symbol_402);
				LibraryBinaryOperation dynamic_A_symbol_403 = (LibraryBinaryOperation)static_A_symbol_403.lookupImplementation(standardLibrary, O_Collection_includes);
				Value A_symbol_403 = dynamic_A_symbol_403.evaluate(evaluator, T_Boolean, A_symbol_402, self);
				rightA_symbol_399 = A_symbol_403;
			} catch (InvalidValueException e) {
				rightA_symbol_399 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_403 = rightA_symbol_399;
			DomainType static_A_symbol_399 = valueFactory.typeOf(A_symbol_400);
			LibraryBinaryOperation dynamic_A_symbol_399 = (LibraryBinaryOperation)static_A_symbol_399.lookupImplementation(standardLibrary, O_Boolean_and);
			Value A_symbol_399 = dynamic_A_symbol_399.evaluate(evaluator, T_Boolean, A_symbol_400, A_symbol_403);
			final Value A_symbol_404 = A_symbol_399;
			return A_symbol_404;
		}
	}






















}

