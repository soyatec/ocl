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
		public static _invariant_CompatibleReturn INSTANCE = new _invariant_CompatibleReturn();
	
		/*
		let
	  bodyConstraint : Constraint = ownedRule->any(stereotype = 'body')
	in bodyConstraint <> null implies
	  let bodySpecification : ValueSpecification = bodyConstraint.specification
	  in bodySpecification <> null and
	    bodySpecification.oclIsKindOf(ExpressionInOCL) implies
	    CompatibleBody(bodySpecification)
		*/
		public Value evaluate(DomainEvaluator evaluator, DomainType returnType, final Value self) throws InvalidValueException {
			final ValueFactory valueFactory = evaluator.getValueFactory();
			final DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final ExecutorOperation O_OclAny__lt__gt_ = OCLstdlibTables.Operations._OclAny___lt__gt_;
			final NullValue Null = valueFactory.getNull();
			final ExecutorOperation O_Boolean_and = OCLstdlibTables.Operations._Boolean__and;
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
			final StringValue S_body = valueFactory.stringValueOf("body");
			
			
			Value A_symbol_301 = IP_NamedElement_ownedRule.evaluate(evaluator, T_OrderedSet_Pivot_ecore__pivot__Constraint_, self, P_NamedElement_ownedRule);
			
			
			/** 
			 * Implementation of the iterator body.
			 */
			AbstractBinaryOperation body_A_symbol_302 = new AbstractBinaryOperation()
			{
			/*
			stereotype = 'body'
			*/
				public Value evaluate(DomainEvaluator evaluator, DomainType returnType, Value sourceValue, Value iterator1) throws InvalidValueException {
					final Value V_1_ = iterator1;	// iterator: 1_
					
					Value A_symbol_303 = IP_Constraint_stereotype.evaluate(evaluator, T_String, V_1_, P_Constraint_stereotype);
					
					DomainType static_A_symbol_304 = valueFactory.typeOf(A_symbol_303, S_body);
					LibraryBinaryOperation dynamic_A_symbol_304 = (LibraryBinaryOperation)static_A_symbol_304.lookupImplementation(standardLibrary, O_String__eq_);
					Value A_symbol_304 = dynamic_A_symbol_304.evaluate(evaluator, T_Boolean, A_symbol_303, S_body);
					return A_symbol_304;
				}
			};
			DomainType static_A_symbol_302 = A_symbol_301.getType();
			LibraryIteration dynamic_A_symbol_302 = (LibraryIteration)static_A_symbol_302.lookupImplementation(standardLibrary, O_Collection_any);
			Value acc_A_symbol_302 = dynamic_A_symbol_302.createAccumulatorValue(evaluator, T_Pivot_ecore__pivot__Constraint, T_Boolean);
			ExecutorSingleIterationManager manager_A_symbol_302 = new ExecutorSingleIterationManager(evaluator, T_Pivot_ecore__pivot__Constraint, body_A_symbol_302, (CollectionValue)A_symbol_301, acc_A_symbol_302);
			Value A_symbol_302 = dynamic_A_symbol_302.evaluateIteration(manager_A_symbol_302);
			final Value V_bodyConstraint = A_symbol_302;
			Value leftA_symbol_305;
			try {
				
				DomainType static_A_symbol_306 = valueFactory.typeOf(V_bodyConstraint, Null);
				LibraryBinaryOperation dynamic_A_symbol_306 = (LibraryBinaryOperation)static_A_symbol_306.lookupImplementation(standardLibrary, O_OclAny__lt__gt_);
				Value A_symbol_306 = dynamic_A_symbol_306.evaluate(evaluator, T_Boolean, V_bodyConstraint, Null);
				leftA_symbol_305 = A_symbol_306;
			} catch (InvalidValueException e) {
				leftA_symbol_305 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_306 = leftA_symbol_305;
			Value rightA_symbol_305;
			try {
				
				Value A_symbol_307 = IP_Constraint_specification.evaluate(evaluator, T_Pivot_ecore__pivot__ValueSpecification, V_bodyConstraint, P_Constraint_specification);
				
				final Value V_bodySpecification = A_symbol_307;
				Value leftA_symbol_308;
				try {
					Value leftA_symbol_309;
					try {
						
						DomainType static_A_symbol_310 = valueFactory.typeOf(V_bodySpecification, Null);
						LibraryBinaryOperation dynamic_A_symbol_310 = (LibraryBinaryOperation)static_A_symbol_310.lookupImplementation(standardLibrary, O_OclAny__lt__gt_);
						Value A_symbol_310 = dynamic_A_symbol_310.evaluate(evaluator, T_Boolean, V_bodySpecification, Null);
						leftA_symbol_309 = A_symbol_310;
					} catch (InvalidValueException e) {
						leftA_symbol_309 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_310 = leftA_symbol_309;
					Value rightA_symbol_309;
					try {
						
						DomainType static_A_symbol_311 = valueFactory.typeOf(V_bodySpecification);
						LibraryBinaryOperation dynamic_A_symbol_311 = (LibraryBinaryOperation)static_A_symbol_311.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Value A_symbol_311 = dynamic_A_symbol_311.evaluate(evaluator, T_Boolean, V_bodySpecification, T_ClassClassifier_Pivot_ecore__pivot__ExpressionInOCL_);
						rightA_symbol_309 = A_symbol_311;
					} catch (InvalidValueException e) {
						rightA_symbol_309 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_311 = rightA_symbol_309;
					DomainType static_A_symbol_309 = valueFactory.typeOf(A_symbol_310);
					LibraryBinaryOperation dynamic_A_symbol_309 = (LibraryBinaryOperation)static_A_symbol_309.lookupImplementation(standardLibrary, O_Boolean_and);
					Value A_symbol_309 = dynamic_A_symbol_309.evaluate(evaluator, T_Boolean, A_symbol_310, A_symbol_311);
					leftA_symbol_308 = A_symbol_309;
				} catch (InvalidValueException e) {
					leftA_symbol_308 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_309 = leftA_symbol_308;
				Value rightA_symbol_308;
				try {
					
					
					DomainType static_A_symbol_312 = valueFactory.typeOf(self);
					LibraryBinaryOperation dynamic_A_symbol_312 = (LibraryBinaryOperation)static_A_symbol_312.lookupImplementation(standardLibrary, O_TypedMultiplicityElement_CompatibleBody);
					Value A_symbol_312 = dynamic_A_symbol_312.evaluate(evaluator, T_Boolean, self, V_bodySpecification);
					rightA_symbol_308 = A_symbol_312;
				} catch (InvalidValueException e) {
					rightA_symbol_308 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_312 = rightA_symbol_308;
				DomainType static_A_symbol_308 = valueFactory.typeOf(A_symbol_309);
				LibraryBinaryOperation dynamic_A_symbol_308 = (LibraryBinaryOperation)static_A_symbol_308.lookupImplementation(standardLibrary, O_Boolean_implies);
				Value A_symbol_308 = dynamic_A_symbol_308.evaluate(evaluator, T_Boolean, A_symbol_309, A_symbol_312);
				final Value A_symbol_313 = A_symbol_308;
				rightA_symbol_305 = A_symbol_313;
			} catch (InvalidValueException e) {
				rightA_symbol_305 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_313 = rightA_symbol_305;
			DomainType static_A_symbol_305 = valueFactory.typeOf(A_symbol_306);
			LibraryBinaryOperation dynamic_A_symbol_305 = (LibraryBinaryOperation)static_A_symbol_305.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_305 = dynamic_A_symbol_305.evaluate(evaluator, T_Boolean, A_symbol_306, A_symbol_313);
			final Value A_symbol_314 = A_symbol_305;
			return A_symbol_314;
		}
	}










}

