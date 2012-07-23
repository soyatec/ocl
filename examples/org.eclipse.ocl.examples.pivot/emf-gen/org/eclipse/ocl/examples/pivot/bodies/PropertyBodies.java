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
			
			Value leftA_symbol_269;
			try {
				
				Value A_symbol_270 = IP_Property_isDerived.evaluate(evaluator, T_Boolean, self, P_Property_isDerived);
				
				leftA_symbol_269 = A_symbol_270;
			} catch (InvalidValueException e) {
				leftA_symbol_269 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_270 = leftA_symbol_269;
			Value rightA_symbol_269;
			try {
				
				Value A_symbol_271 = IP_NamedElement_ownedRule.evaluate(evaluator, T_OrderedSet_pivot__Constraint_, self, P_NamedElement_ownedRule);
				
				
				/** 
				 * Implementation of the iterator body.
				 */
				AbstractBinaryOperation body_A_symbol_272 = new AbstractBinaryOperation()
				{
				/*
				stereotype = 'derivation'
				*/
					public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, @NonNull Value sourceValue, @NonNull Value iterator1) throws InvalidValueException {
						final @NonNull Value V_1_ = iterator1;	// iterator: 1_
						
						Value A_symbol_273 = IP_Constraint_stereotype.evaluate(evaluator, T_String, V_1_, P_Constraint_stereotype);
						
						DomainType static_A_symbol_274 = valueFactory.typeOf(A_symbol_273, S_derivati___);
						LibraryBinaryOperation dynamic_A_symbol_274 = (LibraryBinaryOperation)static_A_symbol_274.lookupImplementation(standardLibrary, O_String__eq_);
						Value A_symbol_274 = dynamic_A_symbol_274.evaluate(evaluator, T_Boolean, A_symbol_273, S_derivati___);
						return A_symbol_274;
					}
				};
				DomainType static_A_symbol_272 = A_symbol_271.getType();
				LibraryIteration dynamic_A_symbol_272 = (LibraryIteration)static_A_symbol_272.lookupImplementation(standardLibrary, O_Collection_any);
				Value acc_A_symbol_272 = dynamic_A_symbol_272.createAccumulatorValue(evaluator, T_pivot__Constraint, T_Boolean);
				ExecutorSingleIterationManager manager_A_symbol_272 = new ExecutorSingleIterationManager(evaluator, T_pivot__Constraint, body_A_symbol_272, (CollectionValue)A_symbol_271, acc_A_symbol_272);
				Value A_symbol_272 = dynamic_A_symbol_272.evaluateIteration(manager_A_symbol_272);
				final @NonNull Value V_derivedConstraint = A_symbol_272;
				
				Value A_symbol_275 = IP_NamedElement_ownedRule.evaluate(evaluator, T_OrderedSet_pivot__Constraint_, self, P_NamedElement_ownedRule);
				
				
				/** 
				 * Implementation of the iterator body.
				 */
				AbstractBinaryOperation body_A_symbol_276 = new AbstractBinaryOperation()
				{
				/*
				stereotype = 'initial'
				*/
					public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, @NonNull Value sourceValue, @NonNull Value iterator1) throws InvalidValueException {
						final @NonNull Value V_1_1 = iterator1;	// iterator: 1_
						
						Value A_symbol_277 = IP_Constraint_stereotype.evaluate(evaluator, T_String, V_1_1, P_Constraint_stereotype);
						
						DomainType static_A_symbol_278 = valueFactory.typeOf(A_symbol_277, S_initial);
						LibraryBinaryOperation dynamic_A_symbol_278 = (LibraryBinaryOperation)static_A_symbol_278.lookupImplementation(standardLibrary, O_String__eq_);
						Value A_symbol_278 = dynamic_A_symbol_278.evaluate(evaluator, T_Boolean, A_symbol_277, S_initial);
						return A_symbol_278;
					}
				};
				DomainType static_A_symbol_276 = A_symbol_275.getType();
				LibraryIteration dynamic_A_symbol_276 = (LibraryIteration)static_A_symbol_276.lookupImplementation(standardLibrary, O_Collection_any);
				Value acc_A_symbol_276 = dynamic_A_symbol_276.createAccumulatorValue(evaluator, T_pivot__Constraint, T_Boolean);
				ExecutorSingleIterationManager manager_A_symbol_276 = new ExecutorSingleIterationManager(evaluator, T_pivot__Constraint, body_A_symbol_276, (CollectionValue)A_symbol_275, acc_A_symbol_276);
				Value A_symbol_276 = dynamic_A_symbol_276.evaluateIteration(manager_A_symbol_276);
				final @NonNull Value V_initialConstraint = A_symbol_276;
					
					DomainType static_A_symbol_279 = valueFactory.typeOf(V_derivedConstraint, Null);
					LibraryBinaryOperation dynamic_A_symbol_279 = (LibraryBinaryOperation)static_A_symbol_279.lookupImplementation(standardLibrary, O_OclAny__lt__gt_);
					Value A_symbol_279 = dynamic_A_symbol_279.evaluate(evaluator, T_Boolean, V_derivedConstraint, Null);
				Value A_symbol_280;
				if (A_symbol_279.isTrue()) {
					
					Value A_symbol_281 = IP_Constraint_specification.evaluate(evaluator, T_pivot__ValueSpecification, V_derivedConstraint, P_Constraint_specification);
					
					A_symbol_280 = A_symbol_281;
				}
				else if (A_symbol_279.isFalse()) {
					A_symbol_280 = Null;
				}
				else if (A_symbol_279.isNull()) {
					A_symbol_280 = valueFactory.throwInvalidValueException("null if condition");
				}
				else {
					A_symbol_280 = valueFactory.throwInvalidValueException("invalid if condition");
				}
				final @NonNull Value V_derivedSpecification = A_symbol_280;
					
					DomainType static_A_symbol_282 = valueFactory.typeOf(V_initialConstraint, Null);
					LibraryBinaryOperation dynamic_A_symbol_282 = (LibraryBinaryOperation)static_A_symbol_282.lookupImplementation(standardLibrary, O_OclAny__lt__gt_);
					Value A_symbol_282 = dynamic_A_symbol_282.evaluate(evaluator, T_Boolean, V_initialConstraint, Null);
				Value A_symbol_283;
				if (A_symbol_282.isTrue()) {
					
					Value A_symbol_284 = IP_Constraint_specification.evaluate(evaluator, T_pivot__ValueSpecification, V_initialConstraint, P_Constraint_specification);
					
					A_symbol_283 = A_symbol_284;
				}
				else if (A_symbol_282.isFalse()) {
					A_symbol_283 = Null;
				}
				else if (A_symbol_282.isNull()) {
					A_symbol_283 = valueFactory.throwInvalidValueException("null if condition");
				}
				else {
					A_symbol_283 = valueFactory.throwInvalidValueException("invalid if condition");
				}
				final @NonNull Value V_initialSpecification = A_symbol_283;
					
					DomainType static_A_symbol_285 = valueFactory.typeOf(V_derivedSpecification, Null);
					LibraryBinaryOperation dynamic_A_symbol_285 = (LibraryBinaryOperation)static_A_symbol_285.lookupImplementation(standardLibrary, O_OclAny__lt__gt_);
					Value A_symbol_285 = dynamic_A_symbol_285.evaluate(evaluator, T_Boolean, V_derivedSpecification, Null);
				Value A_symbol_286;
				if (A_symbol_285.isTrue()) {
					
					A_symbol_286 = V_derivedSpecification;
				}
				else if (A_symbol_285.isFalse()) {
					
					A_symbol_286 = V_initialSpecification;
				}
				else if (A_symbol_285.isNull()) {
					A_symbol_286 = valueFactory.throwInvalidValueException("null if condition");
				}
				else {
					A_symbol_286 = valueFactory.throwInvalidValueException("invalid if condition");
				}
				final @NonNull Value V_initialiser = A_symbol_286;
				Value leftA_symbol_287;
				try {
					Value leftA_symbol_288;
					try {
						
						DomainType static_A_symbol_289 = valueFactory.typeOf(V_initialiser, Null);
						LibraryBinaryOperation dynamic_A_symbol_289 = (LibraryBinaryOperation)static_A_symbol_289.lookupImplementation(standardLibrary, O_OclAny__lt__gt_);
						Value A_symbol_289 = dynamic_A_symbol_289.evaluate(evaluator, T_Boolean, V_initialiser, Null);
						leftA_symbol_288 = A_symbol_289;
					} catch (InvalidValueException e) {
						leftA_symbol_288 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_289 = leftA_symbol_288;
					Value rightA_symbol_288;
					try {
						
						DomainType static_A_symbol_290 = valueFactory.typeOf(V_initialiser);
						LibraryBinaryOperation dynamic_A_symbol_290 = (LibraryBinaryOperation)static_A_symbol_290.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Value A_symbol_290 = dynamic_A_symbol_290.evaluate(evaluator, T_Boolean, V_initialiser, T_ClassClassifier_pivot__ExpressionInOCL_);
						rightA_symbol_288 = A_symbol_290;
					} catch (InvalidValueException e) {
						rightA_symbol_288 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_290 = rightA_symbol_288;
					DomainType static_A_symbol_288 = valueFactory.typeOf(A_symbol_289);
					LibraryBinaryOperation dynamic_A_symbol_288 = (LibraryBinaryOperation)static_A_symbol_288.lookupImplementation(standardLibrary, O_Boolean_and);
					Value A_symbol_288 = dynamic_A_symbol_288.evaluate(evaluator, T_Boolean, A_symbol_289, A_symbol_290);
					leftA_symbol_287 = A_symbol_288;
				} catch (InvalidValueException e) {
					leftA_symbol_287 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_288 = leftA_symbol_287;
				Value rightA_symbol_287;
				try {
					
					
					DomainType static_A_symbol_291 = valueFactory.typeOf(self);
					LibraryBinaryOperation dynamic_A_symbol_291 = (LibraryBinaryOperation)static_A_symbol_291.lookupImplementation(standardLibrary, O_TypedMultiplicityElement_CompatibleBody);
					Value A_symbol_291 = dynamic_A_symbol_291.evaluate(evaluator, T_Boolean, self, V_initialiser);
					rightA_symbol_287 = A_symbol_291;
				} catch (InvalidValueException e) {
					rightA_symbol_287 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_291 = rightA_symbol_287;
				DomainType static_A_symbol_287 = valueFactory.typeOf(A_symbol_288);
				LibraryBinaryOperation dynamic_A_symbol_287 = (LibraryBinaryOperation)static_A_symbol_287.lookupImplementation(standardLibrary, O_Boolean_implies);
				Value A_symbol_287 = dynamic_A_symbol_287.evaluate(evaluator, T_Boolean, A_symbol_288, A_symbol_291);
				final @NonNull Value A_symbol_292 = A_symbol_287;
				final @NonNull Value A_symbol_293 = A_symbol_292;
				final @NonNull Value A_symbol_294 = A_symbol_293;
				final @NonNull Value A_symbol_295 = A_symbol_294;
				final @NonNull Value A_symbol_296 = A_symbol_295;
				rightA_symbol_269 = A_symbol_296;
			} catch (InvalidValueException e) {
				rightA_symbol_269 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_296 = rightA_symbol_269;
			DomainType static_A_symbol_269 = valueFactory.typeOf(A_symbol_270);
			LibraryBinaryOperation dynamic_A_symbol_269 = (LibraryBinaryOperation)static_A_symbol_269.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_269 = dynamic_A_symbol_269.evaluate(evaluator, T_Boolean, A_symbol_270, A_symbol_296);
			return A_symbol_269;
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
			
			
			DomainType static_A_symbol_297 = valueFactory.typeOf(self);
			LibraryUnaryOperation dynamic_A_symbol_297 = (LibraryUnaryOperation)static_A_symbol_297.lookupImplementation(standardLibrary, O_OclElement_oclContainer);
			Value A_symbol_297 = dynamic_A_symbol_297.evaluate(evaluator, T_OclElement, self);
			final @NonNull Value V_container = A_symbol_297;
			Value leftA_symbol_298;
			try {
				
				DomainType static_A_symbol_299 = valueFactory.typeOf(V_container);
				LibraryBinaryOperation dynamic_A_symbol_299 = (LibraryBinaryOperation)static_A_symbol_299.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
				Value A_symbol_299 = dynamic_A_symbol_299.evaluate(evaluator, T_Boolean, V_container, T_ClassClassifier_Type_);
				leftA_symbol_298 = A_symbol_299;
			} catch (InvalidValueException e) {
				leftA_symbol_298 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_299 = leftA_symbol_298;
			Value rightA_symbol_298;
			try {
				
				DomainType static_A_symbol_300 = valueFactory.typeOf(V_container);
				LibraryBinaryOperation dynamic_A_symbol_300 = (LibraryBinaryOperation)static_A_symbol_300.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_300 = dynamic_A_symbol_300.evaluate(evaluator, T_Type, V_container, T_ClassClassifier_Type_);
				Value A_symbol_301 = IP_Type_ownedAttribute.evaluate(evaluator, T_OrderedSet_pivot__Property_, A_symbol_300, P_Type_ownedAttribute);
				
				
				DomainType static_A_symbol_302 = valueFactory.typeOf(A_symbol_301);
				LibraryBinaryOperation dynamic_A_symbol_302 = (LibraryBinaryOperation)static_A_symbol_302.lookupImplementation(standardLibrary, O_Collection_includes);
				Value A_symbol_302 = dynamic_A_symbol_302.evaluate(evaluator, T_Boolean, A_symbol_301, self);
				rightA_symbol_298 = A_symbol_302;
			} catch (InvalidValueException e) {
				rightA_symbol_298 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_302 = rightA_symbol_298;
			DomainType static_A_symbol_298 = valueFactory.typeOf(A_symbol_299);
			LibraryBinaryOperation dynamic_A_symbol_298 = (LibraryBinaryOperation)static_A_symbol_298.lookupImplementation(standardLibrary, O_Boolean_and);
			Value A_symbol_298 = dynamic_A_symbol_298.evaluate(evaluator, T_Boolean, A_symbol_299, A_symbol_302);
			final @NonNull Value A_symbol_303 = A_symbol_298;
			return A_symbol_303;
		}
	}






















}

