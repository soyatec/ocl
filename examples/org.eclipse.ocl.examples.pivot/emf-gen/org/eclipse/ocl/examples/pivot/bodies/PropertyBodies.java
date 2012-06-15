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
			
			Value leftA_symbol_52;
			try {
				
				Value A_symbol_53 = IP_Property_isDerived.evaluate(evaluator, T_Boolean, self, P_Property_isDerived);
				
				leftA_symbol_52 = A_symbol_53;
			} catch (InvalidValueException e) {
				leftA_symbol_52 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_53 = leftA_symbol_52;
			Value rightA_symbol_52;
			try {
				
				Value A_symbol_54 = IP_NamedElement_ownedRule.evaluate(evaluator, T_OrderedSet_Pivot_ecore__pivot__Constraint_, self, P_NamedElement_ownedRule);
				
				
				/** 
				 * Implementation of the iterator body.
				 */
				AbstractBinaryOperation body_A_symbol_55 = new AbstractBinaryOperation()
				{
				/*
				stereotype = 'derivation'
				*/
					public Value evaluate(DomainEvaluator evaluator, DomainType returnType, Value sourceValue, Value iterator1) throws InvalidValueException {
						final Value V_1_ = iterator1;	// iterator: 1_
						
						Value A_symbol_56 = IP_Constraint_stereotype.evaluate(evaluator, T_String, V_1_, P_Constraint_stereotype);
						
						DomainType static_A_symbol_57 = valueFactory.typeOf(A_symbol_56, S_derivati___);
						LibraryBinaryOperation dynamic_A_symbol_57 = (LibraryBinaryOperation)static_A_symbol_57.lookupImplementation(standardLibrary, O_String__eq_);
						Value A_symbol_57 = dynamic_A_symbol_57.evaluate(evaluator, T_Boolean, A_symbol_56, S_derivati___);
						return A_symbol_57;
					}
				};
				DomainType static_A_symbol_55 = A_symbol_54.getType();
				LibraryIteration dynamic_A_symbol_55 = (LibraryIteration)static_A_symbol_55.lookupImplementation(standardLibrary, O_Collection_any);
				Value acc_A_symbol_55 = dynamic_A_symbol_55.createAccumulatorValue(evaluator, T_Pivot_ecore__pivot__Constraint, T_Boolean);
				ExecutorSingleIterationManager manager_A_symbol_55 = new ExecutorSingleIterationManager(evaluator, T_Pivot_ecore__pivot__Constraint, body_A_symbol_55, (CollectionValue)A_symbol_54, acc_A_symbol_55);
				Value A_symbol_55 = dynamic_A_symbol_55.evaluateIteration(manager_A_symbol_55);
				final Value V_derivedConstraint = A_symbol_55;
				
				Value A_symbol_58 = IP_NamedElement_ownedRule.evaluate(evaluator, T_OrderedSet_Pivot_ecore__pivot__Constraint_, self, P_NamedElement_ownedRule);
				
				
				/** 
				 * Implementation of the iterator body.
				 */
				AbstractBinaryOperation body_A_symbol_59 = new AbstractBinaryOperation()
				{
				/*
				stereotype = 'initial'
				*/
					public Value evaluate(DomainEvaluator evaluator, DomainType returnType, Value sourceValue, Value iterator1) throws InvalidValueException {
						final Value V_1_1 = iterator1;	// iterator: 1_
						
						Value A_symbol_60 = IP_Constraint_stereotype.evaluate(evaluator, T_String, V_1_1, P_Constraint_stereotype);
						
						DomainType static_A_symbol_61 = valueFactory.typeOf(A_symbol_60, S_initial);
						LibraryBinaryOperation dynamic_A_symbol_61 = (LibraryBinaryOperation)static_A_symbol_61.lookupImplementation(standardLibrary, O_String__eq_);
						Value A_symbol_61 = dynamic_A_symbol_61.evaluate(evaluator, T_Boolean, A_symbol_60, S_initial);
						return A_symbol_61;
					}
				};
				DomainType static_A_symbol_59 = A_symbol_58.getType();
				LibraryIteration dynamic_A_symbol_59 = (LibraryIteration)static_A_symbol_59.lookupImplementation(standardLibrary, O_Collection_any);
				Value acc_A_symbol_59 = dynamic_A_symbol_59.createAccumulatorValue(evaluator, T_Pivot_ecore__pivot__Constraint, T_Boolean);
				ExecutorSingleIterationManager manager_A_symbol_59 = new ExecutorSingleIterationManager(evaluator, T_Pivot_ecore__pivot__Constraint, body_A_symbol_59, (CollectionValue)A_symbol_58, acc_A_symbol_59);
				Value A_symbol_59 = dynamic_A_symbol_59.evaluateIteration(manager_A_symbol_59);
				final Value V_initialConstraint = A_symbol_59;
					
					DomainType static_A_symbol_62 = valueFactory.typeOf(V_derivedConstraint, Null);
					LibraryBinaryOperation dynamic_A_symbol_62 = (LibraryBinaryOperation)static_A_symbol_62.lookupImplementation(standardLibrary, O_OclAny__lt__gt_);
					Value A_symbol_62 = dynamic_A_symbol_62.evaluate(evaluator, T_Boolean, V_derivedConstraint, Null);
				Value A_symbol_63;
				if (A_symbol_62.isTrue()) {
					
					Value A_symbol_64 = IP_Constraint_specification.evaluate(evaluator, T_Pivot_ecore__pivot__ValueSpecification, V_derivedConstraint, P_Constraint_specification);
					
					A_symbol_63 = A_symbol_64;
				}
				else if (A_symbol_62.isFalse()) {
					A_symbol_63 = Null;
				}
				else if (A_symbol_62.isNull()) {
					A_symbol_63 = valueFactory.throwInvalidValueException("null if condition");
				}
				else {
					A_symbol_63 = valueFactory.throwInvalidValueException("invalid if condition");
				}
				final Value V_derivedSpecification = A_symbol_63;
					
					DomainType static_A_symbol_65 = valueFactory.typeOf(V_initialConstraint, Null);
					LibraryBinaryOperation dynamic_A_symbol_65 = (LibraryBinaryOperation)static_A_symbol_65.lookupImplementation(standardLibrary, O_OclAny__lt__gt_);
					Value A_symbol_65 = dynamic_A_symbol_65.evaluate(evaluator, T_Boolean, V_initialConstraint, Null);
				Value A_symbol_66;
				if (A_symbol_65.isTrue()) {
					
					Value A_symbol_67 = IP_Constraint_specification.evaluate(evaluator, T_Pivot_ecore__pivot__ValueSpecification, V_initialConstraint, P_Constraint_specification);
					
					A_symbol_66 = A_symbol_67;
				}
				else if (A_symbol_65.isFalse()) {
					A_symbol_66 = Null;
				}
				else if (A_symbol_65.isNull()) {
					A_symbol_66 = valueFactory.throwInvalidValueException("null if condition");
				}
				else {
					A_symbol_66 = valueFactory.throwInvalidValueException("invalid if condition");
				}
				final Value V_initialSpecification = A_symbol_66;
					
					DomainType static_A_symbol_68 = valueFactory.typeOf(V_derivedSpecification, Null);
					LibraryBinaryOperation dynamic_A_symbol_68 = (LibraryBinaryOperation)static_A_symbol_68.lookupImplementation(standardLibrary, O_OclAny__lt__gt_);
					Value A_symbol_68 = dynamic_A_symbol_68.evaluate(evaluator, T_Boolean, V_derivedSpecification, Null);
				Value A_symbol_69;
				if (A_symbol_68.isTrue()) {
					
					A_symbol_69 = V_derivedSpecification;
				}
				else if (A_symbol_68.isFalse()) {
					
					A_symbol_69 = V_initialSpecification;
				}
				else if (A_symbol_68.isNull()) {
					A_symbol_69 = valueFactory.throwInvalidValueException("null if condition");
				}
				else {
					A_symbol_69 = valueFactory.throwInvalidValueException("invalid if condition");
				}
				final Value V_initialiser = A_symbol_69;
				Value leftA_symbol_70;
				try {
					Value leftA_symbol_71;
					try {
						
						DomainType static_A_symbol_72 = valueFactory.typeOf(V_initialiser, Null);
						LibraryBinaryOperation dynamic_A_symbol_72 = (LibraryBinaryOperation)static_A_symbol_72.lookupImplementation(standardLibrary, O_OclAny__lt__gt_);
						Value A_symbol_72 = dynamic_A_symbol_72.evaluate(evaluator, T_Boolean, V_initialiser, Null);
						leftA_symbol_71 = A_symbol_72;
					} catch (InvalidValueException e) {
						leftA_symbol_71 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_72 = leftA_symbol_71;
					Value rightA_symbol_71;
					try {
						
						DomainType static_A_symbol_73 = valueFactory.typeOf(V_initialiser);
						LibraryBinaryOperation dynamic_A_symbol_73 = (LibraryBinaryOperation)static_A_symbol_73.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Value A_symbol_73 = dynamic_A_symbol_73.evaluate(evaluator, T_Boolean, V_initialiser, T_ClassClassifier_Pivot_ecore__pivot__ExpressionInOCL_);
						rightA_symbol_71 = A_symbol_73;
					} catch (InvalidValueException e) {
						rightA_symbol_71 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_73 = rightA_symbol_71;
					DomainType static_A_symbol_71 = valueFactory.typeOf(A_symbol_72);
					LibraryBinaryOperation dynamic_A_symbol_71 = (LibraryBinaryOperation)static_A_symbol_71.lookupImplementation(standardLibrary, O_Boolean_and);
					Value A_symbol_71 = dynamic_A_symbol_71.evaluate(evaluator, T_Boolean, A_symbol_72, A_symbol_73);
					leftA_symbol_70 = A_symbol_71;
				} catch (InvalidValueException e) {
					leftA_symbol_70 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_71 = leftA_symbol_70;
				Value rightA_symbol_70;
				try {
					
					
					DomainType static_A_symbol_74 = valueFactory.typeOf(self);
					LibraryBinaryOperation dynamic_A_symbol_74 = (LibraryBinaryOperation)static_A_symbol_74.lookupImplementation(standardLibrary, O_TypedMultiplicityElement_CompatibleBody);
					Value A_symbol_74 = dynamic_A_symbol_74.evaluate(evaluator, T_Boolean, self, V_initialiser);
					rightA_symbol_70 = A_symbol_74;
				} catch (InvalidValueException e) {
					rightA_symbol_70 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_74 = rightA_symbol_70;
				DomainType static_A_symbol_70 = valueFactory.typeOf(A_symbol_71);
				LibraryBinaryOperation dynamic_A_symbol_70 = (LibraryBinaryOperation)static_A_symbol_70.lookupImplementation(standardLibrary, O_Boolean_implies);
				Value A_symbol_70 = dynamic_A_symbol_70.evaluate(evaluator, T_Boolean, A_symbol_71, A_symbol_74);
				final Value A_symbol_75 = A_symbol_70;
				final Value A_symbol_76 = A_symbol_75;
				final Value A_symbol_77 = A_symbol_76;
				final Value A_symbol_78 = A_symbol_77;
				final Value A_symbol_79 = A_symbol_78;
				rightA_symbol_52 = A_symbol_79;
			} catch (InvalidValueException e) {
				rightA_symbol_52 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_79 = rightA_symbol_52;
			DomainType static_A_symbol_52 = valueFactory.typeOf(A_symbol_53);
			LibraryBinaryOperation dynamic_A_symbol_52 = (LibraryBinaryOperation)static_A_symbol_52.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_52 = dynamic_A_symbol_52.evaluate(evaluator, T_Boolean, A_symbol_53, A_symbol_79);
			return A_symbol_52;
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
			
			
			DomainType static_A_symbol_80 = valueFactory.typeOf(self);
			LibraryUnaryOperation dynamic_A_symbol_80 = (LibraryUnaryOperation)static_A_symbol_80.lookupImplementation(standardLibrary, O_OclElement_oclContainer);
			Value A_symbol_80 = dynamic_A_symbol_80.evaluate(evaluator, T_OclElement, self);
			final Value V_container = A_symbol_80;
			Value leftA_symbol_81;
			try {
				
				DomainType static_A_symbol_82 = valueFactory.typeOf(V_container);
				LibraryBinaryOperation dynamic_A_symbol_82 = (LibraryBinaryOperation)static_A_symbol_82.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
				Value A_symbol_82 = dynamic_A_symbol_82.evaluate(evaluator, T_Boolean, V_container, T_ClassClassifier_Type_);
				leftA_symbol_81 = A_symbol_82;
			} catch (InvalidValueException e) {
				leftA_symbol_81 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_82 = leftA_symbol_81;
			Value rightA_symbol_81;
			try {
				
				DomainType static_A_symbol_83 = valueFactory.typeOf(V_container);
				LibraryBinaryOperation dynamic_A_symbol_83 = (LibraryBinaryOperation)static_A_symbol_83.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_83 = dynamic_A_symbol_83.evaluate(evaluator, T_Type, V_container, T_ClassClassifier_Type_);
				Value A_symbol_84 = IP_Type_ownedAttribute.evaluate(evaluator, T_OrderedSet_Pivot_ecore__pivot__Property_, A_symbol_83, P_Type_ownedAttribute);
				
				
				DomainType static_A_symbol_85 = valueFactory.typeOf(A_symbol_84);
				LibraryBinaryOperation dynamic_A_symbol_85 = (LibraryBinaryOperation)static_A_symbol_85.lookupImplementation(standardLibrary, O_Collection_includes);
				Value A_symbol_85 = dynamic_A_symbol_85.evaluate(evaluator, T_Boolean, A_symbol_84, self);
				rightA_symbol_81 = A_symbol_85;
			} catch (InvalidValueException e) {
				rightA_symbol_81 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_85 = rightA_symbol_81;
			DomainType static_A_symbol_81 = valueFactory.typeOf(A_symbol_82);
			LibraryBinaryOperation dynamic_A_symbol_81 = (LibraryBinaryOperation)static_A_symbol_81.lookupImplementation(standardLibrary, O_Boolean_and);
			Value A_symbol_81 = dynamic_A_symbol_81.evaluate(evaluator, T_Boolean, A_symbol_82, A_symbol_85);
			final Value A_symbol_86 = A_symbol_81;
			return A_symbol_86;
		}
	}


















}

