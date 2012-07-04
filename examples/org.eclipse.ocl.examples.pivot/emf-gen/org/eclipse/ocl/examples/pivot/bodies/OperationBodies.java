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
			final StringValue S_body = valueFactory.stringValueOf("body");
			
			
			Value A_symbol_136 = IP_NamedElement_ownedRule.evaluate(evaluator, T_OrderedSet_pivot__Constraint_, self, P_NamedElement_ownedRule);
			
			
			/** 
			 * Implementation of the iterator body.
			 */
			AbstractBinaryOperation body_A_symbol_137 = new AbstractBinaryOperation()
			{
			/*
			stereotype = 'body'
			*/
				public Value evaluate(DomainEvaluator evaluator, DomainType returnType, Value sourceValue, Value iterator1) throws InvalidValueException {
					final Value V_1_ = iterator1;	// iterator: 1_
					
					Value A_symbol_138 = IP_Constraint_stereotype.evaluate(evaluator, T_String, V_1_, P_Constraint_stereotype);
					
					DomainType static_A_symbol_139 = valueFactory.typeOf(A_symbol_138, S_body);
					LibraryBinaryOperation dynamic_A_symbol_139 = (LibraryBinaryOperation)static_A_symbol_139.lookupImplementation(standardLibrary, O_String__eq_);
					Value A_symbol_139 = dynamic_A_symbol_139.evaluate(evaluator, T_Boolean, A_symbol_138, S_body);
					return A_symbol_139;
				}
			};
			DomainType static_A_symbol_137 = A_symbol_136.getType();
			LibraryIteration dynamic_A_symbol_137 = (LibraryIteration)static_A_symbol_137.lookupImplementation(standardLibrary, O_Collection_any);
			Value acc_A_symbol_137 = dynamic_A_symbol_137.createAccumulatorValue(evaluator, T_pivot__Constraint, T_Boolean);
			ExecutorSingleIterationManager manager_A_symbol_137 = new ExecutorSingleIterationManager(evaluator, T_pivot__Constraint, body_A_symbol_137, (CollectionValue)A_symbol_136, acc_A_symbol_137);
			Value A_symbol_137 = dynamic_A_symbol_137.evaluateIteration(manager_A_symbol_137);
			final Value V_bodyConstraint = A_symbol_137;
			Value leftA_symbol_140;
			try {
				
				DomainType static_A_symbol_141 = valueFactory.typeOf(V_bodyConstraint, Null);
				LibraryBinaryOperation dynamic_A_symbol_141 = (LibraryBinaryOperation)static_A_symbol_141.lookupImplementation(standardLibrary, O_OclAny__lt__gt_);
				Value A_symbol_141 = dynamic_A_symbol_141.evaluate(evaluator, T_Boolean, V_bodyConstraint, Null);
				leftA_symbol_140 = A_symbol_141;
			} catch (InvalidValueException e) {
				leftA_symbol_140 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_141 = leftA_symbol_140;
			Value rightA_symbol_140;
			try {
				
				Value A_symbol_142 = IP_Constraint_specification.evaluate(evaluator, T_pivot__ValueSpecification, V_bodyConstraint, P_Constraint_specification);
				
				final Value V_bodySpecification = A_symbol_142;
				Value leftA_symbol_143;
				try {
					Value leftA_symbol_144;
					try {
						
						DomainType static_A_symbol_145 = valueFactory.typeOf(V_bodySpecification, Null);
						LibraryBinaryOperation dynamic_A_symbol_145 = (LibraryBinaryOperation)static_A_symbol_145.lookupImplementation(standardLibrary, O_OclAny__lt__gt_);
						Value A_symbol_145 = dynamic_A_symbol_145.evaluate(evaluator, T_Boolean, V_bodySpecification, Null);
						leftA_symbol_144 = A_symbol_145;
					} catch (InvalidValueException e) {
						leftA_symbol_144 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_145 = leftA_symbol_144;
					Value rightA_symbol_144;
					try {
						
						DomainType static_A_symbol_146 = valueFactory.typeOf(V_bodySpecification);
						LibraryBinaryOperation dynamic_A_symbol_146 = (LibraryBinaryOperation)static_A_symbol_146.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Value A_symbol_146 = dynamic_A_symbol_146.evaluate(evaluator, T_Boolean, V_bodySpecification, T_ClassClassifier_pivot__ExpressionInOCL_);
						rightA_symbol_144 = A_symbol_146;
					} catch (InvalidValueException e) {
						rightA_symbol_144 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_146 = rightA_symbol_144;
					DomainType static_A_symbol_144 = valueFactory.typeOf(A_symbol_145);
					LibraryBinaryOperation dynamic_A_symbol_144 = (LibraryBinaryOperation)static_A_symbol_144.lookupImplementation(standardLibrary, O_Boolean_and);
					Value A_symbol_144 = dynamic_A_symbol_144.evaluate(evaluator, T_Boolean, A_symbol_145, A_symbol_146);
					leftA_symbol_143 = A_symbol_144;
				} catch (InvalidValueException e) {
					leftA_symbol_143 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_144 = leftA_symbol_143;
				Value rightA_symbol_143;
				try {
					
					
					DomainType static_A_symbol_147 = valueFactory.typeOf(self);
					LibraryBinaryOperation dynamic_A_symbol_147 = (LibraryBinaryOperation)static_A_symbol_147.lookupImplementation(standardLibrary, O_TypedMultiplicityElement_CompatibleBody);
					Value A_symbol_147 = dynamic_A_symbol_147.evaluate(evaluator, T_Boolean, self, V_bodySpecification);
					rightA_symbol_143 = A_symbol_147;
				} catch (InvalidValueException e) {
					rightA_symbol_143 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_147 = rightA_symbol_143;
				DomainType static_A_symbol_143 = valueFactory.typeOf(A_symbol_144);
				LibraryBinaryOperation dynamic_A_symbol_143 = (LibraryBinaryOperation)static_A_symbol_143.lookupImplementation(standardLibrary, O_Boolean_implies);
				Value A_symbol_143 = dynamic_A_symbol_143.evaluate(evaluator, T_Boolean, A_symbol_144, A_symbol_147);
				final Value A_symbol_148 = A_symbol_143;
				rightA_symbol_140 = A_symbol_148;
			} catch (InvalidValueException e) {
				rightA_symbol_140 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_148 = rightA_symbol_140;
			DomainType static_A_symbol_140 = valueFactory.typeOf(A_symbol_141);
			LibraryBinaryOperation dynamic_A_symbol_140 = (LibraryBinaryOperation)static_A_symbol_140.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_140 = dynamic_A_symbol_140.evaluate(evaluator, T_Boolean, A_symbol_141, A_symbol_148);
			final Value A_symbol_149 = A_symbol_140;
			return A_symbol_149;
		}
	}










}

