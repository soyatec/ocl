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
			
			Value leftA_symbol_372;
			try {
				
				Value A_symbol_373 = IP_Property_isDerived.evaluate(evaluator, T_Boolean, self, P_Property_isDerived);
				
				leftA_symbol_372 = A_symbol_373;
			} catch (InvalidValueException e) {
				leftA_symbol_372 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_373 = leftA_symbol_372;
			Value rightA_symbol_372;
			try {
				
				Value A_symbol_374 = IP_NamedElement_ownedRule.evaluate(evaluator, T_OrderedSet_pivot__Constraint_, self, P_NamedElement_ownedRule);
				
				
				/** 
				 * Implementation of the iterator body.
				 */
				AbstractBinaryOperation body_A_symbol_375 = new AbstractBinaryOperation()
				{
				/*
				stereotype = 'derivation'
				*/
					public Value evaluate(DomainEvaluator evaluator, DomainType returnType, Value sourceValue, Value iterator1) throws InvalidValueException {
						final Value V_1_ = iterator1;	// iterator: 1_
						
						Value A_symbol_376 = IP_Constraint_stereotype.evaluate(evaluator, T_String, V_1_, P_Constraint_stereotype);
						
						DomainType static_A_symbol_377 = valueFactory.typeOf(A_symbol_376, S_derivati___);
						LibraryBinaryOperation dynamic_A_symbol_377 = (LibraryBinaryOperation)static_A_symbol_377.lookupImplementation(standardLibrary, O_String__eq_);
						Value A_symbol_377 = dynamic_A_symbol_377.evaluate(evaluator, T_Boolean, A_symbol_376, S_derivati___);
						return A_symbol_377;
					}
				};
				DomainType static_A_symbol_375 = A_symbol_374.getType();
				LibraryIteration dynamic_A_symbol_375 = (LibraryIteration)static_A_symbol_375.lookupImplementation(standardLibrary, O_Collection_any);
				Value acc_A_symbol_375 = dynamic_A_symbol_375.createAccumulatorValue(evaluator, T_pivot__Constraint, T_Boolean);
				ExecutorSingleIterationManager manager_A_symbol_375 = new ExecutorSingleIterationManager(evaluator, T_pivot__Constraint, body_A_symbol_375, (CollectionValue)A_symbol_374, acc_A_symbol_375);
				Value A_symbol_375 = dynamic_A_symbol_375.evaluateIteration(manager_A_symbol_375);
				final Value V_derivedConstraint = A_symbol_375;
				
				Value A_symbol_378 = IP_NamedElement_ownedRule.evaluate(evaluator, T_OrderedSet_pivot__Constraint_, self, P_NamedElement_ownedRule);
				
				
				/** 
				 * Implementation of the iterator body.
				 */
				AbstractBinaryOperation body_A_symbol_379 = new AbstractBinaryOperation()
				{
				/*
				stereotype = 'initial'
				*/
					public Value evaluate(DomainEvaluator evaluator, DomainType returnType, Value sourceValue, Value iterator1) throws InvalidValueException {
						final Value V_1_1 = iterator1;	// iterator: 1_
						
						Value A_symbol_380 = IP_Constraint_stereotype.evaluate(evaluator, T_String, V_1_1, P_Constraint_stereotype);
						
						DomainType static_A_symbol_381 = valueFactory.typeOf(A_symbol_380, S_initial);
						LibraryBinaryOperation dynamic_A_symbol_381 = (LibraryBinaryOperation)static_A_symbol_381.lookupImplementation(standardLibrary, O_String__eq_);
						Value A_symbol_381 = dynamic_A_symbol_381.evaluate(evaluator, T_Boolean, A_symbol_380, S_initial);
						return A_symbol_381;
					}
				};
				DomainType static_A_symbol_379 = A_symbol_378.getType();
				LibraryIteration dynamic_A_symbol_379 = (LibraryIteration)static_A_symbol_379.lookupImplementation(standardLibrary, O_Collection_any);
				Value acc_A_symbol_379 = dynamic_A_symbol_379.createAccumulatorValue(evaluator, T_pivot__Constraint, T_Boolean);
				ExecutorSingleIterationManager manager_A_symbol_379 = new ExecutorSingleIterationManager(evaluator, T_pivot__Constraint, body_A_symbol_379, (CollectionValue)A_symbol_378, acc_A_symbol_379);
				Value A_symbol_379 = dynamic_A_symbol_379.evaluateIteration(manager_A_symbol_379);
				final Value V_initialConstraint = A_symbol_379;
					
					DomainType static_A_symbol_382 = valueFactory.typeOf(V_derivedConstraint, Null);
					LibraryBinaryOperation dynamic_A_symbol_382 = (LibraryBinaryOperation)static_A_symbol_382.lookupImplementation(standardLibrary, O_OclAny__lt__gt_);
					Value A_symbol_382 = dynamic_A_symbol_382.evaluate(evaluator, T_Boolean, V_derivedConstraint, Null);
				Value A_symbol_383;
				if (A_symbol_382.isTrue()) {
					
					Value A_symbol_384 = IP_Constraint_specification.evaluate(evaluator, T_pivot__ValueSpecification, V_derivedConstraint, P_Constraint_specification);
					
					A_symbol_383 = A_symbol_384;
				}
				else if (A_symbol_382.isFalse()) {
					A_symbol_383 = Null;
				}
				else if (A_symbol_382.isNull()) {
					A_symbol_383 = valueFactory.throwInvalidValueException("null if condition");
				}
				else {
					A_symbol_383 = valueFactory.throwInvalidValueException("invalid if condition");
				}
				final Value V_derivedSpecification = A_symbol_383;
					
					DomainType static_A_symbol_385 = valueFactory.typeOf(V_initialConstraint, Null);
					LibraryBinaryOperation dynamic_A_symbol_385 = (LibraryBinaryOperation)static_A_symbol_385.lookupImplementation(standardLibrary, O_OclAny__lt__gt_);
					Value A_symbol_385 = dynamic_A_symbol_385.evaluate(evaluator, T_Boolean, V_initialConstraint, Null);
				Value A_symbol_386;
				if (A_symbol_385.isTrue()) {
					
					Value A_symbol_387 = IP_Constraint_specification.evaluate(evaluator, T_pivot__ValueSpecification, V_initialConstraint, P_Constraint_specification);
					
					A_symbol_386 = A_symbol_387;
				}
				else if (A_symbol_385.isFalse()) {
					A_symbol_386 = Null;
				}
				else if (A_symbol_385.isNull()) {
					A_symbol_386 = valueFactory.throwInvalidValueException("null if condition");
				}
				else {
					A_symbol_386 = valueFactory.throwInvalidValueException("invalid if condition");
				}
				final Value V_initialSpecification = A_symbol_386;
					
					DomainType static_A_symbol_388 = valueFactory.typeOf(V_derivedSpecification, Null);
					LibraryBinaryOperation dynamic_A_symbol_388 = (LibraryBinaryOperation)static_A_symbol_388.lookupImplementation(standardLibrary, O_OclAny__lt__gt_);
					Value A_symbol_388 = dynamic_A_symbol_388.evaluate(evaluator, T_Boolean, V_derivedSpecification, Null);
				Value A_symbol_389;
				if (A_symbol_388.isTrue()) {
					
					A_symbol_389 = V_derivedSpecification;
				}
				else if (A_symbol_388.isFalse()) {
					
					A_symbol_389 = V_initialSpecification;
				}
				else if (A_symbol_388.isNull()) {
					A_symbol_389 = valueFactory.throwInvalidValueException("null if condition");
				}
				else {
					A_symbol_389 = valueFactory.throwInvalidValueException("invalid if condition");
				}
				final Value V_initialiser = A_symbol_389;
				Value leftA_symbol_390;
				try {
					Value leftA_symbol_391;
					try {
						
						DomainType static_A_symbol_392 = valueFactory.typeOf(V_initialiser, Null);
						LibraryBinaryOperation dynamic_A_symbol_392 = (LibraryBinaryOperation)static_A_symbol_392.lookupImplementation(standardLibrary, O_OclAny__lt__gt_);
						Value A_symbol_392 = dynamic_A_symbol_392.evaluate(evaluator, T_Boolean, V_initialiser, Null);
						leftA_symbol_391 = A_symbol_392;
					} catch (InvalidValueException e) {
						leftA_symbol_391 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_392 = leftA_symbol_391;
					Value rightA_symbol_391;
					try {
						
						DomainType static_A_symbol_393 = valueFactory.typeOf(V_initialiser);
						LibraryBinaryOperation dynamic_A_symbol_393 = (LibraryBinaryOperation)static_A_symbol_393.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Value A_symbol_393 = dynamic_A_symbol_393.evaluate(evaluator, T_Boolean, V_initialiser, T_ClassClassifier_pivot__ExpressionInOCL_);
						rightA_symbol_391 = A_symbol_393;
					} catch (InvalidValueException e) {
						rightA_symbol_391 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_393 = rightA_symbol_391;
					DomainType static_A_symbol_391 = valueFactory.typeOf(A_symbol_392);
					LibraryBinaryOperation dynamic_A_symbol_391 = (LibraryBinaryOperation)static_A_symbol_391.lookupImplementation(standardLibrary, O_Boolean_and);
					Value A_symbol_391 = dynamic_A_symbol_391.evaluate(evaluator, T_Boolean, A_symbol_392, A_symbol_393);
					leftA_symbol_390 = A_symbol_391;
				} catch (InvalidValueException e) {
					leftA_symbol_390 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_391 = leftA_symbol_390;
				Value rightA_symbol_390;
				try {
					
					
					DomainType static_A_symbol_394 = valueFactory.typeOf(self);
					LibraryBinaryOperation dynamic_A_symbol_394 = (LibraryBinaryOperation)static_A_symbol_394.lookupImplementation(standardLibrary, O_TypedMultiplicityElement_CompatibleBody);
					Value A_symbol_394 = dynamic_A_symbol_394.evaluate(evaluator, T_Boolean, self, V_initialiser);
					rightA_symbol_390 = A_symbol_394;
				} catch (InvalidValueException e) {
					rightA_symbol_390 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_394 = rightA_symbol_390;
				DomainType static_A_symbol_390 = valueFactory.typeOf(A_symbol_391);
				LibraryBinaryOperation dynamic_A_symbol_390 = (LibraryBinaryOperation)static_A_symbol_390.lookupImplementation(standardLibrary, O_Boolean_implies);
				Value A_symbol_390 = dynamic_A_symbol_390.evaluate(evaluator, T_Boolean, A_symbol_391, A_symbol_394);
				final Value A_symbol_395 = A_symbol_390;
				final Value A_symbol_396 = A_symbol_395;
				final Value A_symbol_397 = A_symbol_396;
				final Value A_symbol_398 = A_symbol_397;
				final Value A_symbol_399 = A_symbol_398;
				rightA_symbol_372 = A_symbol_399;
			} catch (InvalidValueException e) {
				rightA_symbol_372 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_399 = rightA_symbol_372;
			DomainType static_A_symbol_372 = valueFactory.typeOf(A_symbol_373);
			LibraryBinaryOperation dynamic_A_symbol_372 = (LibraryBinaryOperation)static_A_symbol_372.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_372 = dynamic_A_symbol_372.evaluate(evaluator, T_Boolean, A_symbol_373, A_symbol_399);
			return A_symbol_372;
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
			
			
			DomainType static_A_symbol_400 = valueFactory.typeOf(self);
			LibraryUnaryOperation dynamic_A_symbol_400 = (LibraryUnaryOperation)static_A_symbol_400.lookupImplementation(standardLibrary, O_OclElement_oclContainer);
			Value A_symbol_400 = dynamic_A_symbol_400.evaluate(evaluator, T_OclElement, self);
			final Value V_container = A_symbol_400;
			Value leftA_symbol_401;
			try {
				
				DomainType static_A_symbol_402 = valueFactory.typeOf(V_container);
				LibraryBinaryOperation dynamic_A_symbol_402 = (LibraryBinaryOperation)static_A_symbol_402.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
				Value A_symbol_402 = dynamic_A_symbol_402.evaluate(evaluator, T_Boolean, V_container, T_ClassClassifier_Type_);
				leftA_symbol_401 = A_symbol_402;
			} catch (InvalidValueException e) {
				leftA_symbol_401 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_402 = leftA_symbol_401;
			Value rightA_symbol_401;
			try {
				
				DomainType static_A_symbol_403 = valueFactory.typeOf(V_container);
				LibraryBinaryOperation dynamic_A_symbol_403 = (LibraryBinaryOperation)static_A_symbol_403.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_403 = dynamic_A_symbol_403.evaluate(evaluator, T_Type, V_container, T_ClassClassifier_Type_);
				Value A_symbol_404 = IP_Type_ownedAttribute.evaluate(evaluator, T_OrderedSet_pivot__Property_, A_symbol_403, P_Type_ownedAttribute);
				
				
				DomainType static_A_symbol_405 = valueFactory.typeOf(A_symbol_404);
				LibraryBinaryOperation dynamic_A_symbol_405 = (LibraryBinaryOperation)static_A_symbol_405.lookupImplementation(standardLibrary, O_Collection_includes);
				Value A_symbol_405 = dynamic_A_symbol_405.evaluate(evaluator, T_Boolean, A_symbol_404, self);
				rightA_symbol_401 = A_symbol_405;
			} catch (InvalidValueException e) {
				rightA_symbol_401 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_405 = rightA_symbol_401;
			DomainType static_A_symbol_401 = valueFactory.typeOf(A_symbol_402);
			LibraryBinaryOperation dynamic_A_symbol_401 = (LibraryBinaryOperation)static_A_symbol_401.lookupImplementation(standardLibrary, O_Boolean_and);
			Value A_symbol_401 = dynamic_A_symbol_401.evaluate(evaluator, T_Boolean, A_symbol_402, A_symbol_405);
			final Value A_symbol_406 = A_symbol_401;
			return A_symbol_406;
		}
	}






















}

