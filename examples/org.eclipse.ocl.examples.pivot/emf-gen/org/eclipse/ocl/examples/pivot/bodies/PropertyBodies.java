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
			
			Value leftA_symbol_279;
			try {
				
				Value A_symbol_280 = IP_Property_isDerived.evaluate(evaluator, T_Boolean, self, P_Property_isDerived);
				
				leftA_symbol_279 = A_symbol_280;
			} catch (InvalidValueException e) {
				leftA_symbol_279 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_280 = leftA_symbol_279;
			Value rightA_symbol_279;
			try {
				
				Value A_symbol_281 = IP_NamedElement_ownedRule.evaluate(evaluator, T_OrderedSet_Pivot_ecore__pivot__Constraint_, self, P_NamedElement_ownedRule);
				
				
				/** 
				 * Implementation of the iterator body.
				 */
				AbstractBinaryOperation body_A_symbol_282 = new AbstractBinaryOperation()
				{
				/*
				stereotype = 'derivation'
				*/
					public Value evaluate(DomainEvaluator evaluator, DomainType returnType, Value sourceValue, Value iterator1) throws InvalidValueException {
						final Value V_1_ = iterator1;	// iterator: 1_
						
						Value A_symbol_283 = IP_Constraint_stereotype.evaluate(evaluator, T_String, V_1_, P_Constraint_stereotype);
						
						DomainType static_A_symbol_284 = valueFactory.typeOf(A_symbol_283, S_derivati___);
						LibraryBinaryOperation dynamic_A_symbol_284 = (LibraryBinaryOperation)static_A_symbol_284.lookupImplementation(standardLibrary, O_String__eq_);
						Value A_symbol_284 = dynamic_A_symbol_284.evaluate(evaluator, T_Boolean, A_symbol_283, S_derivati___);
						return A_symbol_284;
					}
				};
				DomainType static_A_symbol_282 = A_symbol_281.getType();
				LibraryIteration dynamic_A_symbol_282 = (LibraryIteration)static_A_symbol_282.lookupImplementation(standardLibrary, O_Collection_any);
				Value acc_A_symbol_282 = dynamic_A_symbol_282.createAccumulatorValue(evaluator, T_Pivot_ecore__pivot__Constraint, T_Boolean);
				ExecutorSingleIterationManager manager_A_symbol_282 = new ExecutorSingleIterationManager(evaluator, T_Pivot_ecore__pivot__Constraint, body_A_symbol_282, (CollectionValue)A_symbol_281, acc_A_symbol_282);
				Value A_symbol_282 = dynamic_A_symbol_282.evaluateIteration(manager_A_symbol_282);
				final Value V_derivedConstraint = A_symbol_282;
				
				Value A_symbol_285 = IP_NamedElement_ownedRule.evaluate(evaluator, T_OrderedSet_Pivot_ecore__pivot__Constraint_, self, P_NamedElement_ownedRule);
				
				
				/** 
				 * Implementation of the iterator body.
				 */
				AbstractBinaryOperation body_A_symbol_286 = new AbstractBinaryOperation()
				{
				/*
				stereotype = 'initial'
				*/
					public Value evaluate(DomainEvaluator evaluator, DomainType returnType, Value sourceValue, Value iterator1) throws InvalidValueException {
						final Value V_1_1 = iterator1;	// iterator: 1_
						
						Value A_symbol_287 = IP_Constraint_stereotype.evaluate(evaluator, T_String, V_1_1, P_Constraint_stereotype);
						
						DomainType static_A_symbol_288 = valueFactory.typeOf(A_symbol_287, S_initial);
						LibraryBinaryOperation dynamic_A_symbol_288 = (LibraryBinaryOperation)static_A_symbol_288.lookupImplementation(standardLibrary, O_String__eq_);
						Value A_symbol_288 = dynamic_A_symbol_288.evaluate(evaluator, T_Boolean, A_symbol_287, S_initial);
						return A_symbol_288;
					}
				};
				DomainType static_A_symbol_286 = A_symbol_285.getType();
				LibraryIteration dynamic_A_symbol_286 = (LibraryIteration)static_A_symbol_286.lookupImplementation(standardLibrary, O_Collection_any);
				Value acc_A_symbol_286 = dynamic_A_symbol_286.createAccumulatorValue(evaluator, T_Pivot_ecore__pivot__Constraint, T_Boolean);
				ExecutorSingleIterationManager manager_A_symbol_286 = new ExecutorSingleIterationManager(evaluator, T_Pivot_ecore__pivot__Constraint, body_A_symbol_286, (CollectionValue)A_symbol_285, acc_A_symbol_286);
				Value A_symbol_286 = dynamic_A_symbol_286.evaluateIteration(manager_A_symbol_286);
				final Value V_initialConstraint = A_symbol_286;
					
					DomainType static_A_symbol_289 = valueFactory.typeOf(V_derivedConstraint, Null);
					LibraryBinaryOperation dynamic_A_symbol_289 = (LibraryBinaryOperation)static_A_symbol_289.lookupImplementation(standardLibrary, O_OclAny__lt__gt_);
					Value A_symbol_289 = dynamic_A_symbol_289.evaluate(evaluator, T_Boolean, V_derivedConstraint, Null);
				Value A_symbol_290;
				if (A_symbol_289.isTrue()) {
					
					Value A_symbol_291 = IP_Constraint_specification.evaluate(evaluator, T_Pivot_ecore__pivot__ValueSpecification, V_derivedConstraint, P_Constraint_specification);
					
					A_symbol_290 = A_symbol_291;
				}
				else if (A_symbol_289.isFalse()) {
					A_symbol_290 = Null;
				}
				else if (A_symbol_289.isNull()) {
					A_symbol_290 = valueFactory.throwInvalidValueException("null if condition");
				}
				else {
					A_symbol_290 = valueFactory.throwInvalidValueException("invalid if condition");
				}
				final Value V_derivedSpecification = A_symbol_290;
					
					DomainType static_A_symbol_292 = valueFactory.typeOf(V_initialConstraint, Null);
					LibraryBinaryOperation dynamic_A_symbol_292 = (LibraryBinaryOperation)static_A_symbol_292.lookupImplementation(standardLibrary, O_OclAny__lt__gt_);
					Value A_symbol_292 = dynamic_A_symbol_292.evaluate(evaluator, T_Boolean, V_initialConstraint, Null);
				Value A_symbol_293;
				if (A_symbol_292.isTrue()) {
					
					Value A_symbol_294 = IP_Constraint_specification.evaluate(evaluator, T_Pivot_ecore__pivot__ValueSpecification, V_initialConstraint, P_Constraint_specification);
					
					A_symbol_293 = A_symbol_294;
				}
				else if (A_symbol_292.isFalse()) {
					A_symbol_293 = Null;
				}
				else if (A_symbol_292.isNull()) {
					A_symbol_293 = valueFactory.throwInvalidValueException("null if condition");
				}
				else {
					A_symbol_293 = valueFactory.throwInvalidValueException("invalid if condition");
				}
				final Value V_initialSpecification = A_symbol_293;
					
					DomainType static_A_symbol_295 = valueFactory.typeOf(V_derivedSpecification, Null);
					LibraryBinaryOperation dynamic_A_symbol_295 = (LibraryBinaryOperation)static_A_symbol_295.lookupImplementation(standardLibrary, O_OclAny__lt__gt_);
					Value A_symbol_295 = dynamic_A_symbol_295.evaluate(evaluator, T_Boolean, V_derivedSpecification, Null);
				Value A_symbol_296;
				if (A_symbol_295.isTrue()) {
					
					A_symbol_296 = V_derivedSpecification;
				}
				else if (A_symbol_295.isFalse()) {
					
					A_symbol_296 = V_initialSpecification;
				}
				else if (A_symbol_295.isNull()) {
					A_symbol_296 = valueFactory.throwInvalidValueException("null if condition");
				}
				else {
					A_symbol_296 = valueFactory.throwInvalidValueException("invalid if condition");
				}
				final Value V_initialiser = A_symbol_296;
				Value leftA_symbol_297;
				try {
					Value leftA_symbol_298;
					try {
						
						DomainType static_A_symbol_299 = valueFactory.typeOf(V_initialiser, Null);
						LibraryBinaryOperation dynamic_A_symbol_299 = (LibraryBinaryOperation)static_A_symbol_299.lookupImplementation(standardLibrary, O_OclAny__lt__gt_);
						Value A_symbol_299 = dynamic_A_symbol_299.evaluate(evaluator, T_Boolean, V_initialiser, Null);
						leftA_symbol_298 = A_symbol_299;
					} catch (InvalidValueException e) {
						leftA_symbol_298 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_299 = leftA_symbol_298;
					Value rightA_symbol_298;
					try {
						
						DomainType static_A_symbol_300 = valueFactory.typeOf(V_initialiser);
						LibraryBinaryOperation dynamic_A_symbol_300 = (LibraryBinaryOperation)static_A_symbol_300.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Value A_symbol_300 = dynamic_A_symbol_300.evaluate(evaluator, T_Boolean, V_initialiser, T_ClassClassifier_Pivot_ecore__pivot__ExpressionInOCL_);
						rightA_symbol_298 = A_symbol_300;
					} catch (InvalidValueException e) {
						rightA_symbol_298 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_300 = rightA_symbol_298;
					DomainType static_A_symbol_298 = valueFactory.typeOf(A_symbol_299);
					LibraryBinaryOperation dynamic_A_symbol_298 = (LibraryBinaryOperation)static_A_symbol_298.lookupImplementation(standardLibrary, O_Boolean_and);
					Value A_symbol_298 = dynamic_A_symbol_298.evaluate(evaluator, T_Boolean, A_symbol_299, A_symbol_300);
					leftA_symbol_297 = A_symbol_298;
				} catch (InvalidValueException e) {
					leftA_symbol_297 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_298 = leftA_symbol_297;
				Value rightA_symbol_297;
				try {
					
					
					DomainType static_A_symbol_301 = valueFactory.typeOf(self);
					LibraryBinaryOperation dynamic_A_symbol_301 = (LibraryBinaryOperation)static_A_symbol_301.lookupImplementation(standardLibrary, O_TypedMultiplicityElement_CompatibleBody);
					Value A_symbol_301 = dynamic_A_symbol_301.evaluate(evaluator, T_Boolean, self, V_initialiser);
					rightA_symbol_297 = A_symbol_301;
				} catch (InvalidValueException e) {
					rightA_symbol_297 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_301 = rightA_symbol_297;
				DomainType static_A_symbol_297 = valueFactory.typeOf(A_symbol_298);
				LibraryBinaryOperation dynamic_A_symbol_297 = (LibraryBinaryOperation)static_A_symbol_297.lookupImplementation(standardLibrary, O_Boolean_implies);
				Value A_symbol_297 = dynamic_A_symbol_297.evaluate(evaluator, T_Boolean, A_symbol_298, A_symbol_301);
				final Value A_symbol_302 = A_symbol_297;
				final Value A_symbol_303 = A_symbol_302;
				final Value A_symbol_304 = A_symbol_303;
				final Value A_symbol_305 = A_symbol_304;
				final Value A_symbol_306 = A_symbol_305;
				rightA_symbol_279 = A_symbol_306;
			} catch (InvalidValueException e) {
				rightA_symbol_279 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_306 = rightA_symbol_279;
			DomainType static_A_symbol_279 = valueFactory.typeOf(A_symbol_280);
			LibraryBinaryOperation dynamic_A_symbol_279 = (LibraryBinaryOperation)static_A_symbol_279.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_279 = dynamic_A_symbol_279.evaluate(evaluator, T_Boolean, A_symbol_280, A_symbol_306);
			return A_symbol_279;
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
			
			
			DomainType static_A_symbol_307 = valueFactory.typeOf(self);
			LibraryUnaryOperation dynamic_A_symbol_307 = (LibraryUnaryOperation)static_A_symbol_307.lookupImplementation(standardLibrary, O_OclElement_oclContainer);
			Value A_symbol_307 = dynamic_A_symbol_307.evaluate(evaluator, T_OclElement, self);
			final Value V_container = A_symbol_307;
			Value leftA_symbol_308;
			try {
				
				DomainType static_A_symbol_309 = valueFactory.typeOf(V_container);
				LibraryBinaryOperation dynamic_A_symbol_309 = (LibraryBinaryOperation)static_A_symbol_309.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
				Value A_symbol_309 = dynamic_A_symbol_309.evaluate(evaluator, T_Boolean, V_container, T_ClassClassifier_Type_);
				leftA_symbol_308 = A_symbol_309;
			} catch (InvalidValueException e) {
				leftA_symbol_308 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_309 = leftA_symbol_308;
			Value rightA_symbol_308;
			try {
				
				DomainType static_A_symbol_310 = valueFactory.typeOf(V_container);
				LibraryBinaryOperation dynamic_A_symbol_310 = (LibraryBinaryOperation)static_A_symbol_310.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_310 = dynamic_A_symbol_310.evaluate(evaluator, T_Type, V_container, T_ClassClassifier_Type_);
				Value A_symbol_311 = IP_Type_ownedAttribute.evaluate(evaluator, T_OrderedSet_Pivot_ecore__pivot__Property_, A_symbol_310, P_Type_ownedAttribute);
				
				
				DomainType static_A_symbol_312 = valueFactory.typeOf(A_symbol_311);
				LibraryBinaryOperation dynamic_A_symbol_312 = (LibraryBinaryOperation)static_A_symbol_312.lookupImplementation(standardLibrary, O_Collection_includes);
				Value A_symbol_312 = dynamic_A_symbol_312.evaluate(evaluator, T_Boolean, A_symbol_311, self);
				rightA_symbol_308 = A_symbol_312;
			} catch (InvalidValueException e) {
				rightA_symbol_308 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_312 = rightA_symbol_308;
			DomainType static_A_symbol_308 = valueFactory.typeOf(A_symbol_309);
			LibraryBinaryOperation dynamic_A_symbol_308 = (LibraryBinaryOperation)static_A_symbol_308.lookupImplementation(standardLibrary, O_Boolean_and);
			Value A_symbol_308 = dynamic_A_symbol_308.evaluate(evaluator, T_Boolean, A_symbol_309, A_symbol_312);
			final Value A_symbol_313 = A_symbol_308;
			return A_symbol_313;
		}
	}


















}

