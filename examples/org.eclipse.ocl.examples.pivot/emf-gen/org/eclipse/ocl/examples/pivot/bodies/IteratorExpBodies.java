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
import org.eclipse.ocl.examples.domain.values.IntegerValue;
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
 * IteratorExpBodies provides the Java implementation bodies of OCL-defined IteratorExp operations and properties.
 */
@SuppressWarnings("nls")
public class IteratorExpBodies
{

	/** 
	 * Implementation of the IteratorExp 'AnyBodyTypeIsBoolean' invariant.
	 */
	public static class _invariant_AnyBodyTypeIsBoolean extends AbstractUnaryOperation
	{
		public static _invariant_AnyBodyTypeIsBoolean INSTANCE = new _invariant_AnyBodyTypeIsBoolean();
	
		/*
		name = 'any' implies body.type = 'Boolean'
		*/
		public Value evaluate(DomainEvaluator evaluator, DomainType returnType, final Value self) throws InvalidValueException {
			final ValueFactory valueFactory = evaluator.getValueFactory();
			final DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final ExecutorType T_String = OCLstdlibTables.Types._String;
			final ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final StringValue S_any = valueFactory.stringValueOf("any");
			final ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
			final ExecutorType T_Pivot_ecore__pivot__Type = PivotTables.Types._Type;
			final ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final ExecutorType T_Pivot_ecore__pivot__OclExpression = PivotTables.Types._OclExpression;
			final ExecutorProperty P_LoopExp_body = PivotTables.Properties._LoopExp__body;
			final LibraryProperty IP_LoopExp_body = P_LoopExp_body.getImplementation();
			final StringValue S_Boolean = valueFactory.stringValueOf("Boolean");
			
			Value leftA_symbol_21;
			try {
				
				Value A_symbol_22 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_23 = valueFactory.typeOf(A_symbol_22, S_any);
				LibraryBinaryOperation dynamic_A_symbol_23 = (LibraryBinaryOperation)static_A_symbol_23.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_23 = dynamic_A_symbol_23.evaluate(evaluator, T_Boolean, A_symbol_22, S_any);
				leftA_symbol_21 = A_symbol_23;
			} catch (InvalidValueException e) {
				leftA_symbol_21 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_23 = leftA_symbol_21;
			Value rightA_symbol_21;
			try {
				
				Value A_symbol_24 = IP_LoopExp_body.evaluate(evaluator, T_Pivot_ecore__pivot__OclExpression, self, P_LoopExp_body);
				
				Value A_symbol_25 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_24, P_TypedElement_type);
				
				DomainType static_A_symbol_26 = valueFactory.typeOf(A_symbol_25, S_Boolean);
				LibraryBinaryOperation dynamic_A_symbol_26 = (LibraryBinaryOperation)static_A_symbol_26.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_26 = dynamic_A_symbol_26.evaluate(evaluator, T_Boolean, A_symbol_25, S_Boolean);
				rightA_symbol_21 = A_symbol_26;
			} catch (InvalidValueException e) {
				rightA_symbol_21 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_26 = rightA_symbol_21;
			DomainType static_A_symbol_21 = valueFactory.typeOf(A_symbol_23);
			LibraryBinaryOperation dynamic_A_symbol_21 = (LibraryBinaryOperation)static_A_symbol_21.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_21 = dynamic_A_symbol_21.evaluate(evaluator, T_Boolean, A_symbol_23, A_symbol_26);
			return A_symbol_21;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'AnyHasOneIterator' invariant.
	 */
	public static class _invariant_AnyHasOneIterator extends AbstractUnaryOperation
	{
		public static _invariant_AnyHasOneIterator INSTANCE = new _invariant_AnyHasOneIterator();
	
		/*
		name = 'any' implies iterator->size() = 1
		*/
		public Value evaluate(DomainEvaluator evaluator, DomainType returnType, final Value self) throws InvalidValueException {
			final ValueFactory valueFactory = evaluator.getValueFactory();
			final DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final ExecutorType T_String = OCLstdlibTables.Types._String;
			final ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final StringValue S_any = valueFactory.stringValueOf("any");
			final ExecutorOperation O_Real__eq_ = OCLstdlibTables.Operations._Real___eq_;
			final ExecutorType T_Integer = OCLstdlibTables.Types._Integer;
			final ExecutorOperation O_Collection_size = OCLstdlibTables.Operations._Collection__size;
			final ExecutorType T_Pivot_ecore__pivot__Variable = PivotTables.Types._Variable;
			final DomainCollectionType T_OrderedSet_Pivot_ecore__pivot__Variable_ = standardLibrary.getOrderedSetType(T_Pivot_ecore__pivot__Variable);
			final ExecutorProperty P_LoopExp_iterator = PivotTables.Properties._LoopExp__iterator;
			final LibraryProperty IP_LoopExp_iterator = P_LoopExp_iterator.getImplementation();
			final IntegerValue I_1 = valueFactory.integerValueOf(1);
			
			Value leftA_symbol_27;
			try {
				
				Value A_symbol_28 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_29 = valueFactory.typeOf(A_symbol_28, S_any);
				LibraryBinaryOperation dynamic_A_symbol_29 = (LibraryBinaryOperation)static_A_symbol_29.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_29 = dynamic_A_symbol_29.evaluate(evaluator, T_Boolean, A_symbol_28, S_any);
				leftA_symbol_27 = A_symbol_29;
			} catch (InvalidValueException e) {
				leftA_symbol_27 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_29 = leftA_symbol_27;
			Value rightA_symbol_27;
			try {
				
				Value A_symbol_30 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_Pivot_ecore__pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_31 = valueFactory.typeOf(A_symbol_30);
				LibraryUnaryOperation dynamic_A_symbol_31 = (LibraryUnaryOperation)static_A_symbol_31.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_31 = dynamic_A_symbol_31.evaluate(evaluator, T_Integer, A_symbol_30);
				DomainType static_A_symbol_32 = valueFactory.typeOf(A_symbol_31, I_1);
				LibraryBinaryOperation dynamic_A_symbol_32 = (LibraryBinaryOperation)static_A_symbol_32.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_32 = dynamic_A_symbol_32.evaluate(evaluator, T_Boolean, A_symbol_31, I_1);
				rightA_symbol_27 = A_symbol_32;
			} catch (InvalidValueException e) {
				rightA_symbol_27 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_32 = rightA_symbol_27;
			DomainType static_A_symbol_27 = valueFactory.typeOf(A_symbol_29);
			LibraryBinaryOperation dynamic_A_symbol_27 = (LibraryBinaryOperation)static_A_symbol_27.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_27 = dynamic_A_symbol_27.evaluate(evaluator, T_Boolean, A_symbol_29, A_symbol_32);
			return A_symbol_27;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'AnyTypeIsSourceElementType' invariant.
	 */
	public static class _invariant_AnyTypeIsSourceElementType extends AbstractUnaryOperation
	{
		public static _invariant_AnyTypeIsSourceElementType INSTANCE = new _invariant_AnyTypeIsSourceElementType();
	
		/*
		name = 'any' implies type = source.type.oclAsType(CollectionType).elementType
		*/
		public Value evaluate(DomainEvaluator evaluator, DomainType returnType, final Value self) throws InvalidValueException {
			final ValueFactory valueFactory = evaluator.getValueFactory();
			final DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final ExecutorType T_String = OCLstdlibTables.Types._String;
			final ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final StringValue S_any = valueFactory.stringValueOf("any");
			final ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
			final ExecutorType T_Pivot_ecore__pivot__Type = PivotTables.Types._Type;
			final ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final ExecutorProperty P_CollectionType_elementType = PivotTables.Properties._CollectionType__elementType;
			final LibraryProperty IP_CollectionType_elementType = P_CollectionType_elementType.getImplementation();
			final ExecutorType T_Pivot_ecore__pivot__CollectionType = PivotTables.Types._CollectionType;
			final ExecutorOperation O_OclAny_oclAsType = OCLstdlibTables.Operations._OclAny__oclAsType;
			final ExecutorType T_Pivot_ecore__pivot__OclExpression = PivotTables.Types._OclExpression;
			final ExecutorProperty P_CallExp_source = PivotTables.Properties._CallExp__source;
			final LibraryProperty IP_CallExp_source = P_CallExp_source.getImplementation();
			final Value T_ClassClassifier_Pivot_ecore__pivot__CollectionType_ = valueFactory.createTypeValue(PivotTables.Types._CollectionType);
			
			Value leftA_symbol_33;
			try {
				
				Value A_symbol_34 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_35 = valueFactory.typeOf(A_symbol_34, S_any);
				LibraryBinaryOperation dynamic_A_symbol_35 = (LibraryBinaryOperation)static_A_symbol_35.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_35 = dynamic_A_symbol_35.evaluate(evaluator, T_Boolean, A_symbol_34, S_any);
				leftA_symbol_33 = A_symbol_35;
			} catch (InvalidValueException e) {
				leftA_symbol_33 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_35 = leftA_symbol_33;
			Value rightA_symbol_33;
			try {
				
				Value A_symbol_36 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				
				Value A_symbol_37 = IP_CallExp_source.evaluate(evaluator, T_Pivot_ecore__pivot__OclExpression, self, P_CallExp_source);
				
				Value A_symbol_38 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_37, P_TypedElement_type);
				
				DomainType static_A_symbol_39 = valueFactory.typeOf(A_symbol_38);
				LibraryBinaryOperation dynamic_A_symbol_39 = (LibraryBinaryOperation)static_A_symbol_39.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_39 = dynamic_A_symbol_39.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionType, A_symbol_38, T_ClassClassifier_Pivot_ecore__pivot__CollectionType_);
				Value A_symbol_40 = IP_CollectionType_elementType.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_39, P_CollectionType_elementType);
				
				DomainType static_A_symbol_41 = valueFactory.typeOf(A_symbol_36, A_symbol_40);
				LibraryBinaryOperation dynamic_A_symbol_41 = (LibraryBinaryOperation)static_A_symbol_41.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_41 = dynamic_A_symbol_41.evaluate(evaluator, T_Boolean, A_symbol_36, A_symbol_40);
				rightA_symbol_33 = A_symbol_41;
			} catch (InvalidValueException e) {
				rightA_symbol_33 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_41 = rightA_symbol_33;
			DomainType static_A_symbol_33 = valueFactory.typeOf(A_symbol_35);
			LibraryBinaryOperation dynamic_A_symbol_33 = (LibraryBinaryOperation)static_A_symbol_33.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_33 = dynamic_A_symbol_33.evaluate(evaluator, T_Boolean, A_symbol_35, A_symbol_41);
			return A_symbol_33;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'ClosureElementTypeIsSourceElementType' invariant.
	 */
	public static class _invariant_ClosureElementTypeIsSourceElementType extends AbstractUnaryOperation
	{
		public static _invariant_ClosureElementTypeIsSourceElementType INSTANCE = new _invariant_ClosureElementTypeIsSourceElementType();
	
		/*
		name = 'closure' implies
	type.oclAsType(CollectionType).elementType =
	source.type.oclAsType(CollectionType).elementType
		*/
		public Value evaluate(DomainEvaluator evaluator, DomainType returnType, final Value self) throws InvalidValueException {
			final ValueFactory valueFactory = evaluator.getValueFactory();
			final DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final ExecutorType T_String = OCLstdlibTables.Types._String;
			final ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final StringValue S_closure = valueFactory.stringValueOf("closure");
			final ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
			final ExecutorType T_Pivot_ecore__pivot__Type = PivotTables.Types._Type;
			final ExecutorProperty P_CollectionType_elementType = PivotTables.Properties._CollectionType__elementType;
			final LibraryProperty IP_CollectionType_elementType = P_CollectionType_elementType.getImplementation();
			final ExecutorType T_Pivot_ecore__pivot__CollectionType = PivotTables.Types._CollectionType;
			final ExecutorOperation O_OclAny_oclAsType = OCLstdlibTables.Operations._OclAny__oclAsType;
			final ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final Value T_ClassClassifier_Pivot_ecore__pivot__CollectionType_ = valueFactory.createTypeValue(PivotTables.Types._CollectionType);
			final ExecutorType T_Pivot_ecore__pivot__OclExpression = PivotTables.Types._OclExpression;
			final ExecutorProperty P_CallExp_source = PivotTables.Properties._CallExp__source;
			final LibraryProperty IP_CallExp_source = P_CallExp_source.getImplementation();
			
			Value leftA_symbol_42;
			try {
				
				Value A_symbol_43 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_44 = valueFactory.typeOf(A_symbol_43, S_closure);
				LibraryBinaryOperation dynamic_A_symbol_44 = (LibraryBinaryOperation)static_A_symbol_44.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_44 = dynamic_A_symbol_44.evaluate(evaluator, T_Boolean, A_symbol_43, S_closure);
				leftA_symbol_42 = A_symbol_44;
			} catch (InvalidValueException e) {
				leftA_symbol_42 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_44 = leftA_symbol_42;
			Value rightA_symbol_42;
			try {
				
				Value A_symbol_45 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_46 = valueFactory.typeOf(A_symbol_45);
				LibraryBinaryOperation dynamic_A_symbol_46 = (LibraryBinaryOperation)static_A_symbol_46.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_46 = dynamic_A_symbol_46.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionType, A_symbol_45, T_ClassClassifier_Pivot_ecore__pivot__CollectionType_);
				Value A_symbol_47 = IP_CollectionType_elementType.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_46, P_CollectionType_elementType);
				
				
				Value A_symbol_48 = IP_CallExp_source.evaluate(evaluator, T_Pivot_ecore__pivot__OclExpression, self, P_CallExp_source);
				
				Value A_symbol_49 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_48, P_TypedElement_type);
				
				DomainType static_A_symbol_50 = valueFactory.typeOf(A_symbol_49);
				LibraryBinaryOperation dynamic_A_symbol_50 = (LibraryBinaryOperation)static_A_symbol_50.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_50 = dynamic_A_symbol_50.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionType, A_symbol_49, T_ClassClassifier_Pivot_ecore__pivot__CollectionType_);
				Value A_symbol_51 = IP_CollectionType_elementType.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_50, P_CollectionType_elementType);
				
				DomainType static_A_symbol_52 = valueFactory.typeOf(A_symbol_47, A_symbol_51);
				LibraryBinaryOperation dynamic_A_symbol_52 = (LibraryBinaryOperation)static_A_symbol_52.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_52 = dynamic_A_symbol_52.evaluate(evaluator, T_Boolean, A_symbol_47, A_symbol_51);
				rightA_symbol_42 = A_symbol_52;
			} catch (InvalidValueException e) {
				rightA_symbol_42 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_52 = rightA_symbol_42;
			DomainType static_A_symbol_42 = valueFactory.typeOf(A_symbol_44);
			LibraryBinaryOperation dynamic_A_symbol_42 = (LibraryBinaryOperation)static_A_symbol_42.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_42 = dynamic_A_symbol_42.evaluate(evaluator, T_Boolean, A_symbol_44, A_symbol_52);
			return A_symbol_42;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'ClosureHasOneIterator' invariant.
	 */
	public static class _invariant_ClosureHasOneIterator extends AbstractUnaryOperation
	{
		public static _invariant_ClosureHasOneIterator INSTANCE = new _invariant_ClosureHasOneIterator();
	
		/*
		name = 'closure' implies iterator->size() = 1
		*/
		public Value evaluate(DomainEvaluator evaluator, DomainType returnType, final Value self) throws InvalidValueException {
			final ValueFactory valueFactory = evaluator.getValueFactory();
			final DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final ExecutorType T_String = OCLstdlibTables.Types._String;
			final ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final StringValue S_closure = valueFactory.stringValueOf("closure");
			final ExecutorOperation O_Real__eq_ = OCLstdlibTables.Operations._Real___eq_;
			final ExecutorType T_Integer = OCLstdlibTables.Types._Integer;
			final ExecutorOperation O_Collection_size = OCLstdlibTables.Operations._Collection__size;
			final ExecutorType T_Pivot_ecore__pivot__Variable = PivotTables.Types._Variable;
			final DomainCollectionType T_OrderedSet_Pivot_ecore__pivot__Variable_ = standardLibrary.getOrderedSetType(T_Pivot_ecore__pivot__Variable);
			final ExecutorProperty P_LoopExp_iterator = PivotTables.Properties._LoopExp__iterator;
			final LibraryProperty IP_LoopExp_iterator = P_LoopExp_iterator.getImplementation();
			final IntegerValue I_1 = valueFactory.integerValueOf(1);
			
			Value leftA_symbol_53;
			try {
				
				Value A_symbol_54 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_55 = valueFactory.typeOf(A_symbol_54, S_closure);
				LibraryBinaryOperation dynamic_A_symbol_55 = (LibraryBinaryOperation)static_A_symbol_55.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_55 = dynamic_A_symbol_55.evaluate(evaluator, T_Boolean, A_symbol_54, S_closure);
				leftA_symbol_53 = A_symbol_55;
			} catch (InvalidValueException e) {
				leftA_symbol_53 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_55 = leftA_symbol_53;
			Value rightA_symbol_53;
			try {
				
				Value A_symbol_56 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_Pivot_ecore__pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_57 = valueFactory.typeOf(A_symbol_56);
				LibraryUnaryOperation dynamic_A_symbol_57 = (LibraryUnaryOperation)static_A_symbol_57.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_57 = dynamic_A_symbol_57.evaluate(evaluator, T_Integer, A_symbol_56);
				DomainType static_A_symbol_58 = valueFactory.typeOf(A_symbol_57, I_1);
				LibraryBinaryOperation dynamic_A_symbol_58 = (LibraryBinaryOperation)static_A_symbol_58.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_58 = dynamic_A_symbol_58.evaluate(evaluator, T_Boolean, A_symbol_57, I_1);
				rightA_symbol_53 = A_symbol_58;
			} catch (InvalidValueException e) {
				rightA_symbol_53 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_58 = rightA_symbol_53;
			DomainType static_A_symbol_53 = valueFactory.typeOf(A_symbol_55);
			LibraryBinaryOperation dynamic_A_symbol_53 = (LibraryBinaryOperation)static_A_symbol_53.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_53 = dynamic_A_symbol_53.evaluate(evaluator, T_Boolean, A_symbol_55, A_symbol_58);
			return A_symbol_53;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'ClosureSourceElementTypeIsBodyElementType' invariant.
	 */
	public static class _invariant_ClosureSourceElementTypeIsBodyElementType extends AbstractUnaryOperation
	{
		public static _invariant_ClosureSourceElementTypeIsBodyElementType INSTANCE = new _invariant_ClosureSourceElementTypeIsBodyElementType();
	
		/*
		name = 'closure' implies
	source.type.oclAsType(CollectionType).elementType =
	if body.type.oclIsKindOf(CollectionType)
	then body.type.oclAsType(CollectionType).elementType
	else body.type
	endif
		*/
		public Value evaluate(DomainEvaluator evaluator, DomainType returnType, final Value self) throws InvalidValueException {
			final ValueFactory valueFactory = evaluator.getValueFactory();
			final DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final ExecutorType T_String = OCLstdlibTables.Types._String;
			final ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final StringValue S_closure = valueFactory.stringValueOf("closure");
			final ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
			final ExecutorType T_Pivot_ecore__pivot__Type = PivotTables.Types._Type;
			final ExecutorProperty P_CollectionType_elementType = PivotTables.Properties._CollectionType__elementType;
			final LibraryProperty IP_CollectionType_elementType = P_CollectionType_elementType.getImplementation();
			final ExecutorType T_Pivot_ecore__pivot__CollectionType = PivotTables.Types._CollectionType;
			final ExecutorOperation O_OclAny_oclAsType = OCLstdlibTables.Operations._OclAny__oclAsType;
			final ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final ExecutorType T_Pivot_ecore__pivot__OclExpression = PivotTables.Types._OclExpression;
			final ExecutorProperty P_CallExp_source = PivotTables.Properties._CallExp__source;
			final LibraryProperty IP_CallExp_source = P_CallExp_source.getImplementation();
			final Value T_ClassClassifier_Pivot_ecore__pivot__CollectionType_ = valueFactory.createTypeValue(PivotTables.Types._CollectionType);
			final ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
			final ExecutorProperty P_LoopExp_body = PivotTables.Properties._LoopExp__body;
			final LibraryProperty IP_LoopExp_body = P_LoopExp_body.getImplementation();
			
			Value leftA_symbol_59;
			try {
				
				Value A_symbol_60 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_61 = valueFactory.typeOf(A_symbol_60, S_closure);
				LibraryBinaryOperation dynamic_A_symbol_61 = (LibraryBinaryOperation)static_A_symbol_61.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_61 = dynamic_A_symbol_61.evaluate(evaluator, T_Boolean, A_symbol_60, S_closure);
				leftA_symbol_59 = A_symbol_61;
			} catch (InvalidValueException e) {
				leftA_symbol_59 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_61 = leftA_symbol_59;
			Value rightA_symbol_59;
			try {
				
				Value A_symbol_62 = IP_CallExp_source.evaluate(evaluator, T_Pivot_ecore__pivot__OclExpression, self, P_CallExp_source);
				
				Value A_symbol_63 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_62, P_TypedElement_type);
				
				DomainType static_A_symbol_64 = valueFactory.typeOf(A_symbol_63);
				LibraryBinaryOperation dynamic_A_symbol_64 = (LibraryBinaryOperation)static_A_symbol_64.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_64 = dynamic_A_symbol_64.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionType, A_symbol_63, T_ClassClassifier_Pivot_ecore__pivot__CollectionType_);
				Value A_symbol_65 = IP_CollectionType_elementType.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_64, P_CollectionType_elementType);
				
					
					Value A_symbol_66 = IP_LoopExp_body.evaluate(evaluator, T_Pivot_ecore__pivot__OclExpression, self, P_LoopExp_body);
					
					Value A_symbol_67 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_66, P_TypedElement_type);
					
					DomainType static_A_symbol_68 = valueFactory.typeOf(A_symbol_67);
					LibraryBinaryOperation dynamic_A_symbol_68 = (LibraryBinaryOperation)static_A_symbol_68.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Value A_symbol_68 = dynamic_A_symbol_68.evaluate(evaluator, T_Boolean, A_symbol_67, T_ClassClassifier_Pivot_ecore__pivot__CollectionType_);
				Value A_symbol_69;
				if (A_symbol_68.isTrue()) {
					
					Value A_symbol_70 = IP_LoopExp_body.evaluate(evaluator, T_Pivot_ecore__pivot__OclExpression, self, P_LoopExp_body);
					
					Value A_symbol_71 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_70, P_TypedElement_type);
					
					DomainType static_A_symbol_72 = valueFactory.typeOf(A_symbol_71);
					LibraryBinaryOperation dynamic_A_symbol_72 = (LibraryBinaryOperation)static_A_symbol_72.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
					Value A_symbol_72 = dynamic_A_symbol_72.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionType, A_symbol_71, T_ClassClassifier_Pivot_ecore__pivot__CollectionType_);
					Value A_symbol_73 = IP_CollectionType_elementType.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_72, P_CollectionType_elementType);
					
					A_symbol_69 = A_symbol_73;
				}
				else if (A_symbol_68.isFalse()) {
					
					Value A_symbol_74 = IP_LoopExp_body.evaluate(evaluator, T_Pivot_ecore__pivot__OclExpression, self, P_LoopExp_body);
					
					Value A_symbol_75 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_74, P_TypedElement_type);
					
					A_symbol_69 = A_symbol_75;
				}
				else if (A_symbol_68.isNull()) {
					A_symbol_69 = valueFactory.throwInvalidValueException("null if condition");
				}
				else {
					A_symbol_69 = valueFactory.throwInvalidValueException("invalid if condition");
				}
				DomainType static_A_symbol_76 = valueFactory.typeOf(A_symbol_65, A_symbol_69);
				LibraryBinaryOperation dynamic_A_symbol_76 = (LibraryBinaryOperation)static_A_symbol_76.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_76 = dynamic_A_symbol_76.evaluate(evaluator, T_Boolean, A_symbol_65, A_symbol_69);
				rightA_symbol_59 = A_symbol_76;
			} catch (InvalidValueException e) {
				rightA_symbol_59 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_76 = rightA_symbol_59;
			DomainType static_A_symbol_59 = valueFactory.typeOf(A_symbol_61);
			LibraryBinaryOperation dynamic_A_symbol_59 = (LibraryBinaryOperation)static_A_symbol_59.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_59 = dynamic_A_symbol_59.evaluate(evaluator, T_Boolean, A_symbol_61, A_symbol_76);
			return A_symbol_59;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'ClosureTypeIsUniqueCollection' invariant.
	 */
	public static class _invariant_ClosureTypeIsUniqueCollection extends AbstractUnaryOperation
	{
		public static _invariant_ClosureTypeIsUniqueCollection INSTANCE = new _invariant_ClosureTypeIsUniqueCollection();
	
		/*
		name = 'closure' implies
	if
	  source.type.oclIsKindOf(SequenceType) or
	  source.type.oclIsKindOf(OrderedSetType)
	then type.oclIsKindOf(OrderedSetType)
	else type.oclIsKindOf(SetType)
	endif
		*/
		public Value evaluate(DomainEvaluator evaluator, DomainType returnType, final Value self) throws InvalidValueException {
			final ValueFactory valueFactory = evaluator.getValueFactory();
			final DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final ExecutorType T_String = OCLstdlibTables.Types._String;
			final ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final StringValue S_closure = valueFactory.stringValueOf("closure");
			final ExecutorOperation O_Boolean_or = OCLstdlibTables.Operations._Boolean__or;
			final ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
			final ExecutorType T_Pivot_ecore__pivot__Type = PivotTables.Types._Type;
			final ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final ExecutorType T_Pivot_ecore__pivot__OclExpression = PivotTables.Types._OclExpression;
			final ExecutorProperty P_CallExp_source = PivotTables.Properties._CallExp__source;
			final LibraryProperty IP_CallExp_source = P_CallExp_source.getImplementation();
			final Value T_ClassClassifier_Pivot_ecore__pivot__SequenceType_ = valueFactory.createTypeValue(PivotTables.Types._SequenceType);
			final Value T_ClassClassifier_Pivot_ecore__pivot__OrderedSetType_ = valueFactory.createTypeValue(PivotTables.Types._OrderedSetType);
			final Value T_ClassClassifier_Pivot_ecore__pivot__SetType_ = valueFactory.createTypeValue(PivotTables.Types._SetType);
			
			Value leftA_symbol_77;
			try {
				
				Value A_symbol_78 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_79 = valueFactory.typeOf(A_symbol_78, S_closure);
				LibraryBinaryOperation dynamic_A_symbol_79 = (LibraryBinaryOperation)static_A_symbol_79.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_79 = dynamic_A_symbol_79.evaluate(evaluator, T_Boolean, A_symbol_78, S_closure);
				leftA_symbol_77 = A_symbol_79;
			} catch (InvalidValueException e) {
				leftA_symbol_77 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_79 = leftA_symbol_77;
			Value rightA_symbol_77;
			try {
					Value leftA_symbol_80;
					try {
						
						Value A_symbol_81 = IP_CallExp_source.evaluate(evaluator, T_Pivot_ecore__pivot__OclExpression, self, P_CallExp_source);
						
						Value A_symbol_82 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_81, P_TypedElement_type);
						
						DomainType static_A_symbol_83 = valueFactory.typeOf(A_symbol_82);
						LibraryBinaryOperation dynamic_A_symbol_83 = (LibraryBinaryOperation)static_A_symbol_83.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Value A_symbol_83 = dynamic_A_symbol_83.evaluate(evaluator, T_Boolean, A_symbol_82, T_ClassClassifier_Pivot_ecore__pivot__SequenceType_);
						leftA_symbol_80 = A_symbol_83;
					} catch (InvalidValueException e) {
						leftA_symbol_80 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_83 = leftA_symbol_80;
					Value rightA_symbol_80;
					try {
						
						Value A_symbol_84 = IP_CallExp_source.evaluate(evaluator, T_Pivot_ecore__pivot__OclExpression, self, P_CallExp_source);
						
						Value A_symbol_85 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_84, P_TypedElement_type);
						
						DomainType static_A_symbol_86 = valueFactory.typeOf(A_symbol_85);
						LibraryBinaryOperation dynamic_A_symbol_86 = (LibraryBinaryOperation)static_A_symbol_86.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Value A_symbol_86 = dynamic_A_symbol_86.evaluate(evaluator, T_Boolean, A_symbol_85, T_ClassClassifier_Pivot_ecore__pivot__OrderedSetType_);
						rightA_symbol_80 = A_symbol_86;
					} catch (InvalidValueException e) {
						rightA_symbol_80 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_86 = rightA_symbol_80;
					DomainType static_A_symbol_80 = valueFactory.typeOf(A_symbol_83);
					LibraryBinaryOperation dynamic_A_symbol_80 = (LibraryBinaryOperation)static_A_symbol_80.lookupImplementation(standardLibrary, O_Boolean_or);
					Value A_symbol_80 = dynamic_A_symbol_80.evaluate(evaluator, T_Boolean, A_symbol_83, A_symbol_86);
				Value A_symbol_87;
				if (A_symbol_80.isTrue()) {
					
					Value A_symbol_88 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
					
					DomainType static_A_symbol_89 = valueFactory.typeOf(A_symbol_88);
					LibraryBinaryOperation dynamic_A_symbol_89 = (LibraryBinaryOperation)static_A_symbol_89.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Value A_symbol_89 = dynamic_A_symbol_89.evaluate(evaluator, T_Boolean, A_symbol_88, T_ClassClassifier_Pivot_ecore__pivot__OrderedSetType_);
					A_symbol_87 = A_symbol_89;
				}
				else if (A_symbol_80.isFalse()) {
					
					Value A_symbol_90 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
					
					DomainType static_A_symbol_91 = valueFactory.typeOf(A_symbol_90);
					LibraryBinaryOperation dynamic_A_symbol_91 = (LibraryBinaryOperation)static_A_symbol_91.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Value A_symbol_91 = dynamic_A_symbol_91.evaluate(evaluator, T_Boolean, A_symbol_90, T_ClassClassifier_Pivot_ecore__pivot__SetType_);
					A_symbol_87 = A_symbol_91;
				}
				else if (A_symbol_80.isNull()) {
					A_symbol_87 = valueFactory.throwInvalidValueException("null if condition");
				}
				else {
					A_symbol_87 = valueFactory.throwInvalidValueException("invalid if condition");
				}
				rightA_symbol_77 = A_symbol_87;
			} catch (InvalidValueException e) {
				rightA_symbol_77 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_87 = rightA_symbol_77;
			DomainType static_A_symbol_77 = valueFactory.typeOf(A_symbol_79);
			LibraryBinaryOperation dynamic_A_symbol_77 = (LibraryBinaryOperation)static_A_symbol_77.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_77 = dynamic_A_symbol_77.evaluate(evaluator, T_Boolean, A_symbol_79, A_symbol_87);
			return A_symbol_77;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'CollectElementTypeIsSourceElementType' invariant.
	 */
	public static class _invariant_CollectElementTypeIsSourceElementType extends AbstractUnaryOperation
	{
		public static _invariant_CollectElementTypeIsSourceElementType INSTANCE = new _invariant_CollectElementTypeIsSourceElementType();
	
		/*
		name = 'collect' implies
	type.oclAsType(CollectionType).elementType =
	body.type.oclAsType(CollectionType).elementType
		*/
		public Value evaluate(DomainEvaluator evaluator, DomainType returnType, final Value self) throws InvalidValueException {
			final ValueFactory valueFactory = evaluator.getValueFactory();
			final DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final ExecutorType T_String = OCLstdlibTables.Types._String;
			final ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final StringValue S_collect = valueFactory.stringValueOf("collect");
			final ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
			final ExecutorType T_Pivot_ecore__pivot__Type = PivotTables.Types._Type;
			final ExecutorProperty P_CollectionType_elementType = PivotTables.Properties._CollectionType__elementType;
			final LibraryProperty IP_CollectionType_elementType = P_CollectionType_elementType.getImplementation();
			final ExecutorType T_Pivot_ecore__pivot__CollectionType = PivotTables.Types._CollectionType;
			final ExecutorOperation O_OclAny_oclAsType = OCLstdlibTables.Operations._OclAny__oclAsType;
			final ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final Value T_ClassClassifier_Pivot_ecore__pivot__CollectionType_ = valueFactory.createTypeValue(PivotTables.Types._CollectionType);
			final ExecutorType T_Pivot_ecore__pivot__OclExpression = PivotTables.Types._OclExpression;
			final ExecutorProperty P_LoopExp_body = PivotTables.Properties._LoopExp__body;
			final LibraryProperty IP_LoopExp_body = P_LoopExp_body.getImplementation();
			
			Value leftA_symbol_92;
			try {
				
				Value A_symbol_93 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_94 = valueFactory.typeOf(A_symbol_93, S_collect);
				LibraryBinaryOperation dynamic_A_symbol_94 = (LibraryBinaryOperation)static_A_symbol_94.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_94 = dynamic_A_symbol_94.evaluate(evaluator, T_Boolean, A_symbol_93, S_collect);
				leftA_symbol_92 = A_symbol_94;
			} catch (InvalidValueException e) {
				leftA_symbol_92 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_94 = leftA_symbol_92;
			Value rightA_symbol_92;
			try {
				
				Value A_symbol_95 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_96 = valueFactory.typeOf(A_symbol_95);
				LibraryBinaryOperation dynamic_A_symbol_96 = (LibraryBinaryOperation)static_A_symbol_96.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_96 = dynamic_A_symbol_96.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionType, A_symbol_95, T_ClassClassifier_Pivot_ecore__pivot__CollectionType_);
				Value A_symbol_97 = IP_CollectionType_elementType.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_96, P_CollectionType_elementType);
				
				
				Value A_symbol_98 = IP_LoopExp_body.evaluate(evaluator, T_Pivot_ecore__pivot__OclExpression, self, P_LoopExp_body);
				
				Value A_symbol_99 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_98, P_TypedElement_type);
				
				DomainType static_A_symbol_100 = valueFactory.typeOf(A_symbol_99);
				LibraryBinaryOperation dynamic_A_symbol_100 = (LibraryBinaryOperation)static_A_symbol_100.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_100 = dynamic_A_symbol_100.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionType, A_symbol_99, T_ClassClassifier_Pivot_ecore__pivot__CollectionType_);
				Value A_symbol_101 = IP_CollectionType_elementType.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_100, P_CollectionType_elementType);
				
				DomainType static_A_symbol_102 = valueFactory.typeOf(A_symbol_97, A_symbol_101);
				LibraryBinaryOperation dynamic_A_symbol_102 = (LibraryBinaryOperation)static_A_symbol_102.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_102 = dynamic_A_symbol_102.evaluate(evaluator, T_Boolean, A_symbol_97, A_symbol_101);
				rightA_symbol_92 = A_symbol_102;
			} catch (InvalidValueException e) {
				rightA_symbol_92 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_102 = rightA_symbol_92;
			DomainType static_A_symbol_92 = valueFactory.typeOf(A_symbol_94);
			LibraryBinaryOperation dynamic_A_symbol_92 = (LibraryBinaryOperation)static_A_symbol_92.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_92 = dynamic_A_symbol_92.evaluate(evaluator, T_Boolean, A_symbol_94, A_symbol_102);
			return A_symbol_92;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'CollectHasOneIterator' invariant.
	 */
	public static class _invariant_CollectHasOneIterator extends AbstractUnaryOperation
	{
		public static _invariant_CollectHasOneIterator INSTANCE = new _invariant_CollectHasOneIterator();
	
		/*
		name = 'collect' implies iterator->size() = 1
		*/
		public Value evaluate(DomainEvaluator evaluator, DomainType returnType, final Value self) throws InvalidValueException {
			final ValueFactory valueFactory = evaluator.getValueFactory();
			final DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final ExecutorType T_String = OCLstdlibTables.Types._String;
			final ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final StringValue S_collect = valueFactory.stringValueOf("collect");
			final ExecutorOperation O_Real__eq_ = OCLstdlibTables.Operations._Real___eq_;
			final ExecutorType T_Integer = OCLstdlibTables.Types._Integer;
			final ExecutorOperation O_Collection_size = OCLstdlibTables.Operations._Collection__size;
			final ExecutorType T_Pivot_ecore__pivot__Variable = PivotTables.Types._Variable;
			final DomainCollectionType T_OrderedSet_Pivot_ecore__pivot__Variable_ = standardLibrary.getOrderedSetType(T_Pivot_ecore__pivot__Variable);
			final ExecutorProperty P_LoopExp_iterator = PivotTables.Properties._LoopExp__iterator;
			final LibraryProperty IP_LoopExp_iterator = P_LoopExp_iterator.getImplementation();
			final IntegerValue I_1 = valueFactory.integerValueOf(1);
			
			Value leftA_symbol_103;
			try {
				
				Value A_symbol_104 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_105 = valueFactory.typeOf(A_symbol_104, S_collect);
				LibraryBinaryOperation dynamic_A_symbol_105 = (LibraryBinaryOperation)static_A_symbol_105.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_105 = dynamic_A_symbol_105.evaluate(evaluator, T_Boolean, A_symbol_104, S_collect);
				leftA_symbol_103 = A_symbol_105;
			} catch (InvalidValueException e) {
				leftA_symbol_103 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_105 = leftA_symbol_103;
			Value rightA_symbol_103;
			try {
				
				Value A_symbol_106 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_Pivot_ecore__pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_107 = valueFactory.typeOf(A_symbol_106);
				LibraryUnaryOperation dynamic_A_symbol_107 = (LibraryUnaryOperation)static_A_symbol_107.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_107 = dynamic_A_symbol_107.evaluate(evaluator, T_Integer, A_symbol_106);
				DomainType static_A_symbol_108 = valueFactory.typeOf(A_symbol_107, I_1);
				LibraryBinaryOperation dynamic_A_symbol_108 = (LibraryBinaryOperation)static_A_symbol_108.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_108 = dynamic_A_symbol_108.evaluate(evaluator, T_Boolean, A_symbol_107, I_1);
				rightA_symbol_103 = A_symbol_108;
			} catch (InvalidValueException e) {
				rightA_symbol_103 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_108 = rightA_symbol_103;
			DomainType static_A_symbol_103 = valueFactory.typeOf(A_symbol_105);
			LibraryBinaryOperation dynamic_A_symbol_103 = (LibraryBinaryOperation)static_A_symbol_103.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_103 = dynamic_A_symbol_103.evaluate(evaluator, T_Boolean, A_symbol_105, A_symbol_108);
			return A_symbol_103;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'CollectNestedHasOneIterator' invariant.
	 */
	public static class _invariant_CollectNestedHasOneIterator extends AbstractUnaryOperation
	{
		public static _invariant_CollectNestedHasOneIterator INSTANCE = new _invariant_CollectNestedHasOneIterator();
	
		/*
		name = 'collectNested' implies iterator->size() = 1
		*/
		public Value evaluate(DomainEvaluator evaluator, DomainType returnType, final Value self) throws InvalidValueException {
			final ValueFactory valueFactory = evaluator.getValueFactory();
			final DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final ExecutorType T_String = OCLstdlibTables.Types._String;
			final ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final StringValue S_collectN___ = valueFactory.stringValueOf("collectNested");
			final ExecutorOperation O_Real__eq_ = OCLstdlibTables.Operations._Real___eq_;
			final ExecutorType T_Integer = OCLstdlibTables.Types._Integer;
			final ExecutorOperation O_Collection_size = OCLstdlibTables.Operations._Collection__size;
			final ExecutorType T_Pivot_ecore__pivot__Variable = PivotTables.Types._Variable;
			final DomainCollectionType T_OrderedSet_Pivot_ecore__pivot__Variable_ = standardLibrary.getOrderedSetType(T_Pivot_ecore__pivot__Variable);
			final ExecutorProperty P_LoopExp_iterator = PivotTables.Properties._LoopExp__iterator;
			final LibraryProperty IP_LoopExp_iterator = P_LoopExp_iterator.getImplementation();
			final IntegerValue I_1 = valueFactory.integerValueOf(1);
			
			Value leftA_symbol_109;
			try {
				
				Value A_symbol_110 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_111 = valueFactory.typeOf(A_symbol_110, S_collectN___);
				LibraryBinaryOperation dynamic_A_symbol_111 = (LibraryBinaryOperation)static_A_symbol_111.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_111 = dynamic_A_symbol_111.evaluate(evaluator, T_Boolean, A_symbol_110, S_collectN___);
				leftA_symbol_109 = A_symbol_111;
			} catch (InvalidValueException e) {
				leftA_symbol_109 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_111 = leftA_symbol_109;
			Value rightA_symbol_109;
			try {
				
				Value A_symbol_112 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_Pivot_ecore__pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_113 = valueFactory.typeOf(A_symbol_112);
				LibraryUnaryOperation dynamic_A_symbol_113 = (LibraryUnaryOperation)static_A_symbol_113.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_113 = dynamic_A_symbol_113.evaluate(evaluator, T_Integer, A_symbol_112);
				DomainType static_A_symbol_114 = valueFactory.typeOf(A_symbol_113, I_1);
				LibraryBinaryOperation dynamic_A_symbol_114 = (LibraryBinaryOperation)static_A_symbol_114.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_114 = dynamic_A_symbol_114.evaluate(evaluator, T_Boolean, A_symbol_113, I_1);
				rightA_symbol_109 = A_symbol_114;
			} catch (InvalidValueException e) {
				rightA_symbol_109 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_114 = rightA_symbol_109;
			DomainType static_A_symbol_109 = valueFactory.typeOf(A_symbol_111);
			LibraryBinaryOperation dynamic_A_symbol_109 = (LibraryBinaryOperation)static_A_symbol_109.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_109 = dynamic_A_symbol_109.evaluate(evaluator, T_Boolean, A_symbol_111, A_symbol_114);
			return A_symbol_109;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'CollectNestedTypeIsBag' invariant.
	 */
	public static class _invariant_CollectNestedTypeIsBag extends AbstractUnaryOperation
	{
		public static _invariant_CollectNestedTypeIsBag INSTANCE = new _invariant_CollectNestedTypeIsBag();
	
		/*
		name = 'collectNested' implies type.oclIsKindOf(BagType)
		*/
		public Value evaluate(DomainEvaluator evaluator, DomainType returnType, final Value self) throws InvalidValueException {
			final ValueFactory valueFactory = evaluator.getValueFactory();
			final DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final ExecutorType T_String = OCLstdlibTables.Types._String;
			final ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final StringValue S_collectN___ = valueFactory.stringValueOf("collectNested");
			final ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
			final ExecutorType T_Pivot_ecore__pivot__Type = PivotTables.Types._Type;
			final ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final Value T_ClassClassifier_Pivot_ecore__pivot__BagType_ = valueFactory.createTypeValue(PivotTables.Types._BagType);
			
			Value leftA_symbol_115;
			try {
				
				Value A_symbol_116 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_117 = valueFactory.typeOf(A_symbol_116, S_collectN___);
				LibraryBinaryOperation dynamic_A_symbol_117 = (LibraryBinaryOperation)static_A_symbol_117.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_117 = dynamic_A_symbol_117.evaluate(evaluator, T_Boolean, A_symbol_116, S_collectN___);
				leftA_symbol_115 = A_symbol_117;
			} catch (InvalidValueException e) {
				leftA_symbol_115 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_117 = leftA_symbol_115;
			Value rightA_symbol_115;
			try {
				
				Value A_symbol_118 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_119 = valueFactory.typeOf(A_symbol_118);
				LibraryBinaryOperation dynamic_A_symbol_119 = (LibraryBinaryOperation)static_A_symbol_119.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
				Value A_symbol_119 = dynamic_A_symbol_119.evaluate(evaluator, T_Boolean, A_symbol_118, T_ClassClassifier_Pivot_ecore__pivot__BagType_);
				rightA_symbol_115 = A_symbol_119;
			} catch (InvalidValueException e) {
				rightA_symbol_115 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_119 = rightA_symbol_115;
			DomainType static_A_symbol_115 = valueFactory.typeOf(A_symbol_117);
			LibraryBinaryOperation dynamic_A_symbol_115 = (LibraryBinaryOperation)static_A_symbol_115.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_115 = dynamic_A_symbol_115.evaluate(evaluator, T_Boolean, A_symbol_117, A_symbol_119);
			return A_symbol_115;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'CollectNestedTypeIsBodyType' invariant.
	 */
	public static class _invariant_CollectNestedTypeIsBodyType extends AbstractUnaryOperation
	{
		public static _invariant_CollectNestedTypeIsBodyType INSTANCE = new _invariant_CollectNestedTypeIsBodyType();
	
		/*
		name = 'collectNested' implies type = body.type
		*/
		public Value evaluate(DomainEvaluator evaluator, DomainType returnType, final Value self) throws InvalidValueException {
			final ValueFactory valueFactory = evaluator.getValueFactory();
			final DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final ExecutorType T_String = OCLstdlibTables.Types._String;
			final ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final StringValue S_collectN___ = valueFactory.stringValueOf("collectNested");
			final ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
			final ExecutorType T_Pivot_ecore__pivot__Type = PivotTables.Types._Type;
			final ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final ExecutorType T_Pivot_ecore__pivot__OclExpression = PivotTables.Types._OclExpression;
			final ExecutorProperty P_LoopExp_body = PivotTables.Properties._LoopExp__body;
			final LibraryProperty IP_LoopExp_body = P_LoopExp_body.getImplementation();
			
			Value leftA_symbol_120;
			try {
				
				Value A_symbol_121 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_122 = valueFactory.typeOf(A_symbol_121, S_collectN___);
				LibraryBinaryOperation dynamic_A_symbol_122 = (LibraryBinaryOperation)static_A_symbol_122.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_122 = dynamic_A_symbol_122.evaluate(evaluator, T_Boolean, A_symbol_121, S_collectN___);
				leftA_symbol_120 = A_symbol_122;
			} catch (InvalidValueException e) {
				leftA_symbol_120 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_122 = leftA_symbol_120;
			Value rightA_symbol_120;
			try {
				
				Value A_symbol_123 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				
				Value A_symbol_124 = IP_LoopExp_body.evaluate(evaluator, T_Pivot_ecore__pivot__OclExpression, self, P_LoopExp_body);
				
				Value A_symbol_125 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_124, P_TypedElement_type);
				
				DomainType static_A_symbol_126 = valueFactory.typeOf(A_symbol_123, A_symbol_125);
				LibraryBinaryOperation dynamic_A_symbol_126 = (LibraryBinaryOperation)static_A_symbol_126.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_126 = dynamic_A_symbol_126.evaluate(evaluator, T_Boolean, A_symbol_123, A_symbol_125);
				rightA_symbol_120 = A_symbol_126;
			} catch (InvalidValueException e) {
				rightA_symbol_120 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_126 = rightA_symbol_120;
			DomainType static_A_symbol_120 = valueFactory.typeOf(A_symbol_122);
			LibraryBinaryOperation dynamic_A_symbol_120 = (LibraryBinaryOperation)static_A_symbol_120.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_120 = dynamic_A_symbol_120.evaluate(evaluator, T_Boolean, A_symbol_122, A_symbol_126);
			return A_symbol_120;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'CollectTypeIsUnordered' invariant.
	 */
	public static class _invariant_CollectTypeIsUnordered extends AbstractUnaryOperation
	{
		public static _invariant_CollectTypeIsUnordered INSTANCE = new _invariant_CollectTypeIsUnordered();
	
		/*
		name = 'collect' implies
	if
	  source.type.oclIsKindOf(SequenceType) or
	  source.type.oclIsKindOf(OrderedSetType)
	then type.oclIsKindOf(SequenceType)
	else type.oclIsKindOf(BagType)
	endif
		*/
		public Value evaluate(DomainEvaluator evaluator, DomainType returnType, final Value self) throws InvalidValueException {
			final ValueFactory valueFactory = evaluator.getValueFactory();
			final DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final ExecutorType T_String = OCLstdlibTables.Types._String;
			final ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final StringValue S_collect = valueFactory.stringValueOf("collect");
			final ExecutorOperation O_Boolean_or = OCLstdlibTables.Operations._Boolean__or;
			final ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
			final ExecutorType T_Pivot_ecore__pivot__Type = PivotTables.Types._Type;
			final ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final ExecutorType T_Pivot_ecore__pivot__OclExpression = PivotTables.Types._OclExpression;
			final ExecutorProperty P_CallExp_source = PivotTables.Properties._CallExp__source;
			final LibraryProperty IP_CallExp_source = P_CallExp_source.getImplementation();
			final Value T_ClassClassifier_Pivot_ecore__pivot__SequenceType_ = valueFactory.createTypeValue(PivotTables.Types._SequenceType);
			final Value T_ClassClassifier_Pivot_ecore__pivot__OrderedSetType_ = valueFactory.createTypeValue(PivotTables.Types._OrderedSetType);
			final Value T_ClassClassifier_Pivot_ecore__pivot__BagType_ = valueFactory.createTypeValue(PivotTables.Types._BagType);
			
			Value leftA_symbol_127;
			try {
				
				Value A_symbol_128 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_129 = valueFactory.typeOf(A_symbol_128, S_collect);
				LibraryBinaryOperation dynamic_A_symbol_129 = (LibraryBinaryOperation)static_A_symbol_129.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_129 = dynamic_A_symbol_129.evaluate(evaluator, T_Boolean, A_symbol_128, S_collect);
				leftA_symbol_127 = A_symbol_129;
			} catch (InvalidValueException e) {
				leftA_symbol_127 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_129 = leftA_symbol_127;
			Value rightA_symbol_127;
			try {
					Value leftA_symbol_130;
					try {
						
						Value A_symbol_131 = IP_CallExp_source.evaluate(evaluator, T_Pivot_ecore__pivot__OclExpression, self, P_CallExp_source);
						
						Value A_symbol_132 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_131, P_TypedElement_type);
						
						DomainType static_A_symbol_133 = valueFactory.typeOf(A_symbol_132);
						LibraryBinaryOperation dynamic_A_symbol_133 = (LibraryBinaryOperation)static_A_symbol_133.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Value A_symbol_133 = dynamic_A_symbol_133.evaluate(evaluator, T_Boolean, A_symbol_132, T_ClassClassifier_Pivot_ecore__pivot__SequenceType_);
						leftA_symbol_130 = A_symbol_133;
					} catch (InvalidValueException e) {
						leftA_symbol_130 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_133 = leftA_symbol_130;
					Value rightA_symbol_130;
					try {
						
						Value A_symbol_134 = IP_CallExp_source.evaluate(evaluator, T_Pivot_ecore__pivot__OclExpression, self, P_CallExp_source);
						
						Value A_symbol_135 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_134, P_TypedElement_type);
						
						DomainType static_A_symbol_136 = valueFactory.typeOf(A_symbol_135);
						LibraryBinaryOperation dynamic_A_symbol_136 = (LibraryBinaryOperation)static_A_symbol_136.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Value A_symbol_136 = dynamic_A_symbol_136.evaluate(evaluator, T_Boolean, A_symbol_135, T_ClassClassifier_Pivot_ecore__pivot__OrderedSetType_);
						rightA_symbol_130 = A_symbol_136;
					} catch (InvalidValueException e) {
						rightA_symbol_130 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_136 = rightA_symbol_130;
					DomainType static_A_symbol_130 = valueFactory.typeOf(A_symbol_133);
					LibraryBinaryOperation dynamic_A_symbol_130 = (LibraryBinaryOperation)static_A_symbol_130.lookupImplementation(standardLibrary, O_Boolean_or);
					Value A_symbol_130 = dynamic_A_symbol_130.evaluate(evaluator, T_Boolean, A_symbol_133, A_symbol_136);
				Value A_symbol_137;
				if (A_symbol_130.isTrue()) {
					
					Value A_symbol_138 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
					
					DomainType static_A_symbol_139 = valueFactory.typeOf(A_symbol_138);
					LibraryBinaryOperation dynamic_A_symbol_139 = (LibraryBinaryOperation)static_A_symbol_139.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Value A_symbol_139 = dynamic_A_symbol_139.evaluate(evaluator, T_Boolean, A_symbol_138, T_ClassClassifier_Pivot_ecore__pivot__SequenceType_);
					A_symbol_137 = A_symbol_139;
				}
				else if (A_symbol_130.isFalse()) {
					
					Value A_symbol_140 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
					
					DomainType static_A_symbol_141 = valueFactory.typeOf(A_symbol_140);
					LibraryBinaryOperation dynamic_A_symbol_141 = (LibraryBinaryOperation)static_A_symbol_141.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Value A_symbol_141 = dynamic_A_symbol_141.evaluate(evaluator, T_Boolean, A_symbol_140, T_ClassClassifier_Pivot_ecore__pivot__BagType_);
					A_symbol_137 = A_symbol_141;
				}
				else if (A_symbol_130.isNull()) {
					A_symbol_137 = valueFactory.throwInvalidValueException("null if condition");
				}
				else {
					A_symbol_137 = valueFactory.throwInvalidValueException("invalid if condition");
				}
				rightA_symbol_127 = A_symbol_137;
			} catch (InvalidValueException e) {
				rightA_symbol_127 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_137 = rightA_symbol_127;
			DomainType static_A_symbol_127 = valueFactory.typeOf(A_symbol_129);
			LibraryBinaryOperation dynamic_A_symbol_127 = (LibraryBinaryOperation)static_A_symbol_127.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_127 = dynamic_A_symbol_127.evaluate(evaluator, T_Boolean, A_symbol_129, A_symbol_137);
			return A_symbol_127;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'ExistsBodyTypeIsBoolean' invariant.
	 */
	public static class _invariant_ExistsBodyTypeIsBoolean extends AbstractUnaryOperation
	{
		public static _invariant_ExistsBodyTypeIsBoolean INSTANCE = new _invariant_ExistsBodyTypeIsBoolean();
	
		/*
		name = 'exists' implies body.type = Boolean
		*/
		public Value evaluate(DomainEvaluator evaluator, DomainType returnType, final Value self) throws InvalidValueException {
			final ValueFactory valueFactory = evaluator.getValueFactory();
			final DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final ExecutorType T_String = OCLstdlibTables.Types._String;
			final ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final StringValue S_exists = valueFactory.stringValueOf("exists");
			final ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
			final ExecutorType T_Pivot_ecore__pivot__Type = PivotTables.Types._Type;
			final ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final ExecutorType T_Pivot_ecore__pivot__OclExpression = PivotTables.Types._OclExpression;
			final ExecutorProperty P_LoopExp_body = PivotTables.Properties._LoopExp__body;
			final LibraryProperty IP_LoopExp_body = P_LoopExp_body.getImplementation();
			final Value T_ClassClassifier_Boolean_ = valueFactory.createTypeValue(OCLstdlibTables.Types._Boolean);
			
			Value leftA_symbol_142;
			try {
				
				Value A_symbol_143 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_144 = valueFactory.typeOf(A_symbol_143, S_exists);
				LibraryBinaryOperation dynamic_A_symbol_144 = (LibraryBinaryOperation)static_A_symbol_144.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_144 = dynamic_A_symbol_144.evaluate(evaluator, T_Boolean, A_symbol_143, S_exists);
				leftA_symbol_142 = A_symbol_144;
			} catch (InvalidValueException e) {
				leftA_symbol_142 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_144 = leftA_symbol_142;
			Value rightA_symbol_142;
			try {
				
				Value A_symbol_145 = IP_LoopExp_body.evaluate(evaluator, T_Pivot_ecore__pivot__OclExpression, self, P_LoopExp_body);
				
				Value A_symbol_146 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_145, P_TypedElement_type);
				
				DomainType static_A_symbol_147 = valueFactory.typeOf(A_symbol_146, T_ClassClassifier_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_147 = (LibraryBinaryOperation)static_A_symbol_147.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_147 = dynamic_A_symbol_147.evaluate(evaluator, T_Boolean, A_symbol_146, T_ClassClassifier_Boolean_);
				rightA_symbol_142 = A_symbol_147;
			} catch (InvalidValueException e) {
				rightA_symbol_142 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_147 = rightA_symbol_142;
			DomainType static_A_symbol_142 = valueFactory.typeOf(A_symbol_144);
			LibraryBinaryOperation dynamic_A_symbol_142 = (LibraryBinaryOperation)static_A_symbol_142.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_142 = dynamic_A_symbol_142.evaluate(evaluator, T_Boolean, A_symbol_144, A_symbol_147);
			return A_symbol_142;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'ExistsTypeIsBoolean' invariant.
	 */
	public static class _invariant_ExistsTypeIsBoolean extends AbstractUnaryOperation
	{
		public static _invariant_ExistsTypeIsBoolean INSTANCE = new _invariant_ExistsTypeIsBoolean();
	
		/*
		name = 'exists' implies type = Boolean
		*/
		public Value evaluate(DomainEvaluator evaluator, DomainType returnType, final Value self) throws InvalidValueException {
			final ValueFactory valueFactory = evaluator.getValueFactory();
			final DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final ExecutorType T_String = OCLstdlibTables.Types._String;
			final ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final StringValue S_exists = valueFactory.stringValueOf("exists");
			final ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
			final ExecutorType T_Pivot_ecore__pivot__Type = PivotTables.Types._Type;
			final ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final Value T_ClassClassifier_Boolean_ = valueFactory.createTypeValue(OCLstdlibTables.Types._Boolean);
			
			Value leftA_symbol_148;
			try {
				
				Value A_symbol_149 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_150 = valueFactory.typeOf(A_symbol_149, S_exists);
				LibraryBinaryOperation dynamic_A_symbol_150 = (LibraryBinaryOperation)static_A_symbol_150.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_150 = dynamic_A_symbol_150.evaluate(evaluator, T_Boolean, A_symbol_149, S_exists);
				leftA_symbol_148 = A_symbol_150;
			} catch (InvalidValueException e) {
				leftA_symbol_148 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_150 = leftA_symbol_148;
			Value rightA_symbol_148;
			try {
				
				Value A_symbol_151 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_152 = valueFactory.typeOf(A_symbol_151, T_ClassClassifier_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_152 = (LibraryBinaryOperation)static_A_symbol_152.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_152 = dynamic_A_symbol_152.evaluate(evaluator, T_Boolean, A_symbol_151, T_ClassClassifier_Boolean_);
				rightA_symbol_148 = A_symbol_152;
			} catch (InvalidValueException e) {
				rightA_symbol_148 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_152 = rightA_symbol_148;
			DomainType static_A_symbol_148 = valueFactory.typeOf(A_symbol_150);
			LibraryBinaryOperation dynamic_A_symbol_148 = (LibraryBinaryOperation)static_A_symbol_148.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_148 = dynamic_A_symbol_148.evaluate(evaluator, T_Boolean, A_symbol_150, A_symbol_152);
			return A_symbol_148;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'ForAllBodyTypeIsBoolean' invariant.
	 */
	public static class _invariant_ForAllBodyTypeIsBoolean extends AbstractUnaryOperation
	{
		public static _invariant_ForAllBodyTypeIsBoolean INSTANCE = new _invariant_ForAllBodyTypeIsBoolean();
	
		/*
		name = 'forAll' implies body.type = Boolean
		*/
		public Value evaluate(DomainEvaluator evaluator, DomainType returnType, final Value self) throws InvalidValueException {
			final ValueFactory valueFactory = evaluator.getValueFactory();
			final DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final ExecutorType T_String = OCLstdlibTables.Types._String;
			final ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final StringValue S_forAll = valueFactory.stringValueOf("forAll");
			final ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
			final ExecutorType T_Pivot_ecore__pivot__Type = PivotTables.Types._Type;
			final ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final ExecutorType T_Pivot_ecore__pivot__OclExpression = PivotTables.Types._OclExpression;
			final ExecutorProperty P_LoopExp_body = PivotTables.Properties._LoopExp__body;
			final LibraryProperty IP_LoopExp_body = P_LoopExp_body.getImplementation();
			final Value T_ClassClassifier_Boolean_ = valueFactory.createTypeValue(OCLstdlibTables.Types._Boolean);
			
			Value leftA_symbol_153;
			try {
				
				Value A_symbol_154 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_155 = valueFactory.typeOf(A_symbol_154, S_forAll);
				LibraryBinaryOperation dynamic_A_symbol_155 = (LibraryBinaryOperation)static_A_symbol_155.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_155 = dynamic_A_symbol_155.evaluate(evaluator, T_Boolean, A_symbol_154, S_forAll);
				leftA_symbol_153 = A_symbol_155;
			} catch (InvalidValueException e) {
				leftA_symbol_153 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_155 = leftA_symbol_153;
			Value rightA_symbol_153;
			try {
				
				Value A_symbol_156 = IP_LoopExp_body.evaluate(evaluator, T_Pivot_ecore__pivot__OclExpression, self, P_LoopExp_body);
				
				Value A_symbol_157 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_156, P_TypedElement_type);
				
				DomainType static_A_symbol_158 = valueFactory.typeOf(A_symbol_157, T_ClassClassifier_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_158 = (LibraryBinaryOperation)static_A_symbol_158.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_158 = dynamic_A_symbol_158.evaluate(evaluator, T_Boolean, A_symbol_157, T_ClassClassifier_Boolean_);
				rightA_symbol_153 = A_symbol_158;
			} catch (InvalidValueException e) {
				rightA_symbol_153 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_158 = rightA_symbol_153;
			DomainType static_A_symbol_153 = valueFactory.typeOf(A_symbol_155);
			LibraryBinaryOperation dynamic_A_symbol_153 = (LibraryBinaryOperation)static_A_symbol_153.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_153 = dynamic_A_symbol_153.evaluate(evaluator, T_Boolean, A_symbol_155, A_symbol_158);
			return A_symbol_153;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'ForAllTypeIsBoolean' invariant.
	 */
	public static class _invariant_ForAllTypeIsBoolean extends AbstractUnaryOperation
	{
		public static _invariant_ForAllTypeIsBoolean INSTANCE = new _invariant_ForAllTypeIsBoolean();
	
		/*
		name = 'forAll' implies type = Boolean
		*/
		public Value evaluate(DomainEvaluator evaluator, DomainType returnType, final Value self) throws InvalidValueException {
			final ValueFactory valueFactory = evaluator.getValueFactory();
			final DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final ExecutorType T_String = OCLstdlibTables.Types._String;
			final ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final StringValue S_forAll = valueFactory.stringValueOf("forAll");
			final ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
			final ExecutorType T_Pivot_ecore__pivot__Type = PivotTables.Types._Type;
			final ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final Value T_ClassClassifier_Boolean_ = valueFactory.createTypeValue(OCLstdlibTables.Types._Boolean);
			
			Value leftA_symbol_159;
			try {
				
				Value A_symbol_160 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_161 = valueFactory.typeOf(A_symbol_160, S_forAll);
				LibraryBinaryOperation dynamic_A_symbol_161 = (LibraryBinaryOperation)static_A_symbol_161.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_161 = dynamic_A_symbol_161.evaluate(evaluator, T_Boolean, A_symbol_160, S_forAll);
				leftA_symbol_159 = A_symbol_161;
			} catch (InvalidValueException e) {
				leftA_symbol_159 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_161 = leftA_symbol_159;
			Value rightA_symbol_159;
			try {
				
				Value A_symbol_162 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_163 = valueFactory.typeOf(A_symbol_162, T_ClassClassifier_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_163 = (LibraryBinaryOperation)static_A_symbol_163.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_163 = dynamic_A_symbol_163.evaluate(evaluator, T_Boolean, A_symbol_162, T_ClassClassifier_Boolean_);
				rightA_symbol_159 = A_symbol_163;
			} catch (InvalidValueException e) {
				rightA_symbol_159 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_163 = rightA_symbol_159;
			DomainType static_A_symbol_159 = valueFactory.typeOf(A_symbol_161);
			LibraryBinaryOperation dynamic_A_symbol_159 = (LibraryBinaryOperation)static_A_symbol_159.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_159 = dynamic_A_symbol_159.evaluate(evaluator, T_Boolean, A_symbol_161, A_symbol_163);
			return A_symbol_159;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'IsUniqueHasOneIterator' invariant.
	 */
	public static class _invariant_IsUniqueHasOneIterator extends AbstractUnaryOperation
	{
		public static _invariant_IsUniqueHasOneIterator INSTANCE = new _invariant_IsUniqueHasOneIterator();
	
		/*
		name = 'isUnique' implies iterator->size() = 1
		*/
		public Value evaluate(DomainEvaluator evaluator, DomainType returnType, final Value self) throws InvalidValueException {
			final ValueFactory valueFactory = evaluator.getValueFactory();
			final DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final ExecutorType T_String = OCLstdlibTables.Types._String;
			final ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final StringValue S_isUnique = valueFactory.stringValueOf("isUnique");
			final ExecutorOperation O_Real__eq_ = OCLstdlibTables.Operations._Real___eq_;
			final ExecutorType T_Integer = OCLstdlibTables.Types._Integer;
			final ExecutorOperation O_Collection_size = OCLstdlibTables.Operations._Collection__size;
			final ExecutorType T_Pivot_ecore__pivot__Variable = PivotTables.Types._Variable;
			final DomainCollectionType T_OrderedSet_Pivot_ecore__pivot__Variable_ = standardLibrary.getOrderedSetType(T_Pivot_ecore__pivot__Variable);
			final ExecutorProperty P_LoopExp_iterator = PivotTables.Properties._LoopExp__iterator;
			final LibraryProperty IP_LoopExp_iterator = P_LoopExp_iterator.getImplementation();
			final IntegerValue I_1 = valueFactory.integerValueOf(1);
			
			Value leftA_symbol_164;
			try {
				
				Value A_symbol_165 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_166 = valueFactory.typeOf(A_symbol_165, S_isUnique);
				LibraryBinaryOperation dynamic_A_symbol_166 = (LibraryBinaryOperation)static_A_symbol_166.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_166 = dynamic_A_symbol_166.evaluate(evaluator, T_Boolean, A_symbol_165, S_isUnique);
				leftA_symbol_164 = A_symbol_166;
			} catch (InvalidValueException e) {
				leftA_symbol_164 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_166 = leftA_symbol_164;
			Value rightA_symbol_164;
			try {
				
				Value A_symbol_167 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_Pivot_ecore__pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_168 = valueFactory.typeOf(A_symbol_167);
				LibraryUnaryOperation dynamic_A_symbol_168 = (LibraryUnaryOperation)static_A_symbol_168.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_168 = dynamic_A_symbol_168.evaluate(evaluator, T_Integer, A_symbol_167);
				DomainType static_A_symbol_169 = valueFactory.typeOf(A_symbol_168, I_1);
				LibraryBinaryOperation dynamic_A_symbol_169 = (LibraryBinaryOperation)static_A_symbol_169.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_169 = dynamic_A_symbol_169.evaluate(evaluator, T_Boolean, A_symbol_168, I_1);
				rightA_symbol_164 = A_symbol_169;
			} catch (InvalidValueException e) {
				rightA_symbol_164 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_169 = rightA_symbol_164;
			DomainType static_A_symbol_164 = valueFactory.typeOf(A_symbol_166);
			LibraryBinaryOperation dynamic_A_symbol_164 = (LibraryBinaryOperation)static_A_symbol_164.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_164 = dynamic_A_symbol_164.evaluate(evaluator, T_Boolean, A_symbol_166, A_symbol_169);
			return A_symbol_164;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'IsUniqueTypeIsBoolean' invariant.
	 */
	public static class _invariant_IsUniqueTypeIsBoolean extends AbstractUnaryOperation
	{
		public static _invariant_IsUniqueTypeIsBoolean INSTANCE = new _invariant_IsUniqueTypeIsBoolean();
	
		/*
		name = 'isUnique' implies type = Boolean
		*/
		public Value evaluate(DomainEvaluator evaluator, DomainType returnType, final Value self) throws InvalidValueException {
			final ValueFactory valueFactory = evaluator.getValueFactory();
			final DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final ExecutorType T_String = OCLstdlibTables.Types._String;
			final ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final StringValue S_isUnique = valueFactory.stringValueOf("isUnique");
			final ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
			final ExecutorType T_Pivot_ecore__pivot__Type = PivotTables.Types._Type;
			final ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final Value T_ClassClassifier_Boolean_ = valueFactory.createTypeValue(OCLstdlibTables.Types._Boolean);
			
			Value leftA_symbol_170;
			try {
				
				Value A_symbol_171 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_172 = valueFactory.typeOf(A_symbol_171, S_isUnique);
				LibraryBinaryOperation dynamic_A_symbol_172 = (LibraryBinaryOperation)static_A_symbol_172.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_172 = dynamic_A_symbol_172.evaluate(evaluator, T_Boolean, A_symbol_171, S_isUnique);
				leftA_symbol_170 = A_symbol_172;
			} catch (InvalidValueException e) {
				leftA_symbol_170 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_172 = leftA_symbol_170;
			Value rightA_symbol_170;
			try {
				
				Value A_symbol_173 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_174 = valueFactory.typeOf(A_symbol_173, T_ClassClassifier_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_174 = (LibraryBinaryOperation)static_A_symbol_174.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_174 = dynamic_A_symbol_174.evaluate(evaluator, T_Boolean, A_symbol_173, T_ClassClassifier_Boolean_);
				rightA_symbol_170 = A_symbol_174;
			} catch (InvalidValueException e) {
				rightA_symbol_170 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_174 = rightA_symbol_170;
			DomainType static_A_symbol_170 = valueFactory.typeOf(A_symbol_172);
			LibraryBinaryOperation dynamic_A_symbol_170 = (LibraryBinaryOperation)static_A_symbol_170.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_170 = dynamic_A_symbol_170.evaluate(evaluator, T_Boolean, A_symbol_172, A_symbol_174);
			return A_symbol_170;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'IteratorTypeIsSourceElementType' invariant.
	 */
	public static class _invariant_IteratorTypeIsSourceElementType extends AbstractUnaryOperation
	{
		public static _invariant_IteratorTypeIsSourceElementType INSTANCE = new _invariant_IteratorTypeIsSourceElementType();
	
		/*
		self.iterator->forAll(type =
	  source.type.oclAsType(CollectionType).elementType)
		*/
		public Value evaluate(DomainEvaluator evaluator, DomainType returnType, final Value self) throws InvalidValueException {
			final ValueFactory valueFactory = evaluator.getValueFactory();
			final DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final ExecutorOperation O_Collection_forAll = OCLstdlibTables.Operations._Collection__1_forAll;
			final ExecutorType T_Pivot_ecore__pivot__Variable = PivotTables.Types._Variable;
			final DomainCollectionType T_OrderedSet_Pivot_ecore__pivot__Variable_ = standardLibrary.getOrderedSetType(T_Pivot_ecore__pivot__Variable);
			final ExecutorProperty P_LoopExp_iterator = PivotTables.Properties._LoopExp__iterator;
			final LibraryProperty IP_LoopExp_iterator = P_LoopExp_iterator.getImplementation();
			final ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
			final ExecutorType T_Pivot_ecore__pivot__Type = PivotTables.Types._Type;
			final ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final ExecutorProperty P_CollectionType_elementType = PivotTables.Properties._CollectionType__elementType;
			final LibraryProperty IP_CollectionType_elementType = P_CollectionType_elementType.getImplementation();
			final ExecutorType T_Pivot_ecore__pivot__CollectionType = PivotTables.Types._CollectionType;
			final ExecutorOperation O_OclAny_oclAsType = OCLstdlibTables.Operations._OclAny__oclAsType;
			final ExecutorType T_Pivot_ecore__pivot__OclExpression = PivotTables.Types._OclExpression;
			final ExecutorProperty P_CallExp_source = PivotTables.Properties._CallExp__source;
			final LibraryProperty IP_CallExp_source = P_CallExp_source.getImplementation();
			final Value T_ClassClassifier_Pivot_ecore__pivot__CollectionType_ = valueFactory.createTypeValue(PivotTables.Types._CollectionType);
			
			
			Value A_symbol_175 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_Pivot_ecore__pivot__Variable_, self, P_LoopExp_iterator);
			
			
			/** 
			 * Implementation of the iterator body.
			 */
			AbstractBinaryOperation body_A_symbol_176 = new AbstractBinaryOperation()
			{
			/*
			type =
			source.type.oclAsType(_'file:/C:/Development/QVTd/GIT/org.eclipse.ocl/examples/org.eclipse.ocl.examples.pivot/model/Pivot.ecore'::pivot::CollectionType).elementType
			*/
				public Value evaluate(DomainEvaluator evaluator, DomainType returnType, Value sourceValue, Value iterator1) throws InvalidValueException {
					final Value V_1_ = iterator1;	// iterator: 1_
					
					Value A_symbol_177 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, V_1_, P_TypedElement_type);
					
					
					Value A_symbol_178 = IP_CallExp_source.evaluate(evaluator, T_Pivot_ecore__pivot__OclExpression, self, P_CallExp_source);
					
					Value A_symbol_179 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_178, P_TypedElement_type);
					
					DomainType static_A_symbol_180 = valueFactory.typeOf(A_symbol_179);
					LibraryBinaryOperation dynamic_A_symbol_180 = (LibraryBinaryOperation)static_A_symbol_180.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
					Value A_symbol_180 = dynamic_A_symbol_180.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionType, A_symbol_179, T_ClassClassifier_Pivot_ecore__pivot__CollectionType_);
					Value A_symbol_181 = IP_CollectionType_elementType.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_180, P_CollectionType_elementType);
					
					DomainType static_A_symbol_182 = valueFactory.typeOf(A_symbol_177, A_symbol_181);
					LibraryBinaryOperation dynamic_A_symbol_182 = (LibraryBinaryOperation)static_A_symbol_182.lookupImplementation(standardLibrary, O_OclAny__eq_);
					Value A_symbol_182 = dynamic_A_symbol_182.evaluate(evaluator, T_Boolean, A_symbol_177, A_symbol_181);
					return A_symbol_182;
				}
			};
			DomainType static_A_symbol_176 = A_symbol_175.getType();
			LibraryIteration dynamic_A_symbol_176 = (LibraryIteration)static_A_symbol_176.lookupImplementation(standardLibrary, O_Collection_forAll);
			Value acc_A_symbol_176 = dynamic_A_symbol_176.createAccumulatorValue(evaluator, T_Boolean, T_Boolean);
			ExecutorSingleIterationManager manager_A_symbol_176 = new ExecutorSingleIterationManager(evaluator, T_Boolean, body_A_symbol_176, (CollectionValue)A_symbol_175, acc_A_symbol_176);
			Value A_symbol_176 = dynamic_A_symbol_176.evaluateIteration(manager_A_symbol_176);
			return A_symbol_176;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'OneBodyTypeIsBoolean' invariant.
	 */
	public static class _invariant_OneBodyTypeIsBoolean extends AbstractUnaryOperation
	{
		public static _invariant_OneBodyTypeIsBoolean INSTANCE = new _invariant_OneBodyTypeIsBoolean();
	
		/*
		name = 'one' implies body.type = Boolean
		*/
		public Value evaluate(DomainEvaluator evaluator, DomainType returnType, final Value self) throws InvalidValueException {
			final ValueFactory valueFactory = evaluator.getValueFactory();
			final DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final ExecutorType T_String = OCLstdlibTables.Types._String;
			final ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final StringValue S_one = valueFactory.stringValueOf("one");
			final ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
			final ExecutorType T_Pivot_ecore__pivot__Type = PivotTables.Types._Type;
			final ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final ExecutorType T_Pivot_ecore__pivot__OclExpression = PivotTables.Types._OclExpression;
			final ExecutorProperty P_LoopExp_body = PivotTables.Properties._LoopExp__body;
			final LibraryProperty IP_LoopExp_body = P_LoopExp_body.getImplementation();
			final Value T_ClassClassifier_Boolean_ = valueFactory.createTypeValue(OCLstdlibTables.Types._Boolean);
			
			Value leftA_symbol_183;
			try {
				
				Value A_symbol_184 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_185 = valueFactory.typeOf(A_symbol_184, S_one);
				LibraryBinaryOperation dynamic_A_symbol_185 = (LibraryBinaryOperation)static_A_symbol_185.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_185 = dynamic_A_symbol_185.evaluate(evaluator, T_Boolean, A_symbol_184, S_one);
				leftA_symbol_183 = A_symbol_185;
			} catch (InvalidValueException e) {
				leftA_symbol_183 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_185 = leftA_symbol_183;
			Value rightA_symbol_183;
			try {
				
				Value A_symbol_186 = IP_LoopExp_body.evaluate(evaluator, T_Pivot_ecore__pivot__OclExpression, self, P_LoopExp_body);
				
				Value A_symbol_187 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_186, P_TypedElement_type);
				
				DomainType static_A_symbol_188 = valueFactory.typeOf(A_symbol_187, T_ClassClassifier_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_188 = (LibraryBinaryOperation)static_A_symbol_188.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_188 = dynamic_A_symbol_188.evaluate(evaluator, T_Boolean, A_symbol_187, T_ClassClassifier_Boolean_);
				rightA_symbol_183 = A_symbol_188;
			} catch (InvalidValueException e) {
				rightA_symbol_183 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_188 = rightA_symbol_183;
			DomainType static_A_symbol_183 = valueFactory.typeOf(A_symbol_185);
			LibraryBinaryOperation dynamic_A_symbol_183 = (LibraryBinaryOperation)static_A_symbol_183.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_183 = dynamic_A_symbol_183.evaluate(evaluator, T_Boolean, A_symbol_185, A_symbol_188);
			return A_symbol_183;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'OneHasOneIterator' invariant.
	 */
	public static class _invariant_OneHasOneIterator extends AbstractUnaryOperation
	{
		public static _invariant_OneHasOneIterator INSTANCE = new _invariant_OneHasOneIterator();
	
		/*
		name = 'one' implies iterator->size() = 1
		*/
		public Value evaluate(DomainEvaluator evaluator, DomainType returnType, final Value self) throws InvalidValueException {
			final ValueFactory valueFactory = evaluator.getValueFactory();
			final DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final ExecutorType T_String = OCLstdlibTables.Types._String;
			final ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final StringValue S_one = valueFactory.stringValueOf("one");
			final ExecutorOperation O_Real__eq_ = OCLstdlibTables.Operations._Real___eq_;
			final ExecutorType T_Integer = OCLstdlibTables.Types._Integer;
			final ExecutorOperation O_Collection_size = OCLstdlibTables.Operations._Collection__size;
			final ExecutorType T_Pivot_ecore__pivot__Variable = PivotTables.Types._Variable;
			final DomainCollectionType T_OrderedSet_Pivot_ecore__pivot__Variable_ = standardLibrary.getOrderedSetType(T_Pivot_ecore__pivot__Variable);
			final ExecutorProperty P_LoopExp_iterator = PivotTables.Properties._LoopExp__iterator;
			final LibraryProperty IP_LoopExp_iterator = P_LoopExp_iterator.getImplementation();
			final IntegerValue I_1 = valueFactory.integerValueOf(1);
			
			Value leftA_symbol_189;
			try {
				
				Value A_symbol_190 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_191 = valueFactory.typeOf(A_symbol_190, S_one);
				LibraryBinaryOperation dynamic_A_symbol_191 = (LibraryBinaryOperation)static_A_symbol_191.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_191 = dynamic_A_symbol_191.evaluate(evaluator, T_Boolean, A_symbol_190, S_one);
				leftA_symbol_189 = A_symbol_191;
			} catch (InvalidValueException e) {
				leftA_symbol_189 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_191 = leftA_symbol_189;
			Value rightA_symbol_189;
			try {
				
				Value A_symbol_192 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_Pivot_ecore__pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_193 = valueFactory.typeOf(A_symbol_192);
				LibraryUnaryOperation dynamic_A_symbol_193 = (LibraryUnaryOperation)static_A_symbol_193.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_193 = dynamic_A_symbol_193.evaluate(evaluator, T_Integer, A_symbol_192);
				DomainType static_A_symbol_194 = valueFactory.typeOf(A_symbol_193, I_1);
				LibraryBinaryOperation dynamic_A_symbol_194 = (LibraryBinaryOperation)static_A_symbol_194.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_194 = dynamic_A_symbol_194.evaluate(evaluator, T_Boolean, A_symbol_193, I_1);
				rightA_symbol_189 = A_symbol_194;
			} catch (InvalidValueException e) {
				rightA_symbol_189 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_194 = rightA_symbol_189;
			DomainType static_A_symbol_189 = valueFactory.typeOf(A_symbol_191);
			LibraryBinaryOperation dynamic_A_symbol_189 = (LibraryBinaryOperation)static_A_symbol_189.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_189 = dynamic_A_symbol_189.evaluate(evaluator, T_Boolean, A_symbol_191, A_symbol_194);
			return A_symbol_189;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'OneTypeIsBoolean' invariant.
	 */
	public static class _invariant_OneTypeIsBoolean extends AbstractUnaryOperation
	{
		public static _invariant_OneTypeIsBoolean INSTANCE = new _invariant_OneTypeIsBoolean();
	
		/*
		name = 'one' implies type = Boolean
		*/
		public Value evaluate(DomainEvaluator evaluator, DomainType returnType, final Value self) throws InvalidValueException {
			final ValueFactory valueFactory = evaluator.getValueFactory();
			final DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final ExecutorType T_String = OCLstdlibTables.Types._String;
			final ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final StringValue S_one = valueFactory.stringValueOf("one");
			final ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
			final ExecutorType T_Pivot_ecore__pivot__Type = PivotTables.Types._Type;
			final ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final Value T_ClassClassifier_Boolean_ = valueFactory.createTypeValue(OCLstdlibTables.Types._Boolean);
			
			Value leftA_symbol_195;
			try {
				
				Value A_symbol_196 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_197 = valueFactory.typeOf(A_symbol_196, S_one);
				LibraryBinaryOperation dynamic_A_symbol_197 = (LibraryBinaryOperation)static_A_symbol_197.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_197 = dynamic_A_symbol_197.evaluate(evaluator, T_Boolean, A_symbol_196, S_one);
				leftA_symbol_195 = A_symbol_197;
			} catch (InvalidValueException e) {
				leftA_symbol_195 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_197 = leftA_symbol_195;
			Value rightA_symbol_195;
			try {
				
				Value A_symbol_198 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_199 = valueFactory.typeOf(A_symbol_198, T_ClassClassifier_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_199 = (LibraryBinaryOperation)static_A_symbol_199.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_199 = dynamic_A_symbol_199.evaluate(evaluator, T_Boolean, A_symbol_198, T_ClassClassifier_Boolean_);
				rightA_symbol_195 = A_symbol_199;
			} catch (InvalidValueException e) {
				rightA_symbol_195 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_199 = rightA_symbol_195;
			DomainType static_A_symbol_195 = valueFactory.typeOf(A_symbol_197);
			LibraryBinaryOperation dynamic_A_symbol_195 = (LibraryBinaryOperation)static_A_symbol_195.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_195 = dynamic_A_symbol_195.evaluate(evaluator, T_Boolean, A_symbol_197, A_symbol_199);
			return A_symbol_195;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'RejectOrSelectHasOneIterator' invariant.
	 */
	public static class _invariant_RejectOrSelectHasOneIterator extends AbstractUnaryOperation
	{
		public static _invariant_RejectOrSelectHasOneIterator INSTANCE = new _invariant_RejectOrSelectHasOneIterator();
	
		/*
		name = 'reject' or name = 'select' implies iterator->size() = 1
		*/
		public Value evaluate(DomainEvaluator evaluator, DomainType returnType, final Value self) throws InvalidValueException {
			final ValueFactory valueFactory = evaluator.getValueFactory();
			final DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final ExecutorOperation O_Boolean_or = OCLstdlibTables.Operations._Boolean__or;
			final ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final ExecutorType T_String = OCLstdlibTables.Types._String;
			final ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final StringValue S_reject = valueFactory.stringValueOf("reject");
			final StringValue S_select = valueFactory.stringValueOf("select");
			final ExecutorOperation O_Real__eq_ = OCLstdlibTables.Operations._Real___eq_;
			final ExecutorType T_Integer = OCLstdlibTables.Types._Integer;
			final ExecutorOperation O_Collection_size = OCLstdlibTables.Operations._Collection__size;
			final ExecutorType T_Pivot_ecore__pivot__Variable = PivotTables.Types._Variable;
			final DomainCollectionType T_OrderedSet_Pivot_ecore__pivot__Variable_ = standardLibrary.getOrderedSetType(T_Pivot_ecore__pivot__Variable);
			final ExecutorProperty P_LoopExp_iterator = PivotTables.Properties._LoopExp__iterator;
			final LibraryProperty IP_LoopExp_iterator = P_LoopExp_iterator.getImplementation();
			final IntegerValue I_1 = valueFactory.integerValueOf(1);
			
			Value leftA_symbol_200;
			try {
				Value leftA_symbol_201;
				try {
					
					Value A_symbol_202 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
					
					DomainType static_A_symbol_203 = valueFactory.typeOf(A_symbol_202, S_reject);
					LibraryBinaryOperation dynamic_A_symbol_203 = (LibraryBinaryOperation)static_A_symbol_203.lookupImplementation(standardLibrary, O_String__eq_);
					Value A_symbol_203 = dynamic_A_symbol_203.evaluate(evaluator, T_Boolean, A_symbol_202, S_reject);
					leftA_symbol_201 = A_symbol_203;
				} catch (InvalidValueException e) {
					leftA_symbol_201 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_203 = leftA_symbol_201;
				Value rightA_symbol_201;
				try {
					
					Value A_symbol_204 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
					
					DomainType static_A_symbol_205 = valueFactory.typeOf(A_symbol_204, S_select);
					LibraryBinaryOperation dynamic_A_symbol_205 = (LibraryBinaryOperation)static_A_symbol_205.lookupImplementation(standardLibrary, O_String__eq_);
					Value A_symbol_205 = dynamic_A_symbol_205.evaluate(evaluator, T_Boolean, A_symbol_204, S_select);
					rightA_symbol_201 = A_symbol_205;
				} catch (InvalidValueException e) {
					rightA_symbol_201 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_205 = rightA_symbol_201;
				DomainType static_A_symbol_201 = valueFactory.typeOf(A_symbol_203);
				LibraryBinaryOperation dynamic_A_symbol_201 = (LibraryBinaryOperation)static_A_symbol_201.lookupImplementation(standardLibrary, O_Boolean_or);
				Value A_symbol_201 = dynamic_A_symbol_201.evaluate(evaluator, T_Boolean, A_symbol_203, A_symbol_205);
				leftA_symbol_200 = A_symbol_201;
			} catch (InvalidValueException e) {
				leftA_symbol_200 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_201 = leftA_symbol_200;
			Value rightA_symbol_200;
			try {
				
				Value A_symbol_206 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_Pivot_ecore__pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_207 = valueFactory.typeOf(A_symbol_206);
				LibraryUnaryOperation dynamic_A_symbol_207 = (LibraryUnaryOperation)static_A_symbol_207.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_207 = dynamic_A_symbol_207.evaluate(evaluator, T_Integer, A_symbol_206);
				DomainType static_A_symbol_208 = valueFactory.typeOf(A_symbol_207, I_1);
				LibraryBinaryOperation dynamic_A_symbol_208 = (LibraryBinaryOperation)static_A_symbol_208.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_208 = dynamic_A_symbol_208.evaluate(evaluator, T_Boolean, A_symbol_207, I_1);
				rightA_symbol_200 = A_symbol_208;
			} catch (InvalidValueException e) {
				rightA_symbol_200 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_208 = rightA_symbol_200;
			DomainType static_A_symbol_200 = valueFactory.typeOf(A_symbol_201);
			LibraryBinaryOperation dynamic_A_symbol_200 = (LibraryBinaryOperation)static_A_symbol_200.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_200 = dynamic_A_symbol_200.evaluate(evaluator, T_Boolean, A_symbol_201, A_symbol_208);
			return A_symbol_200;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'RejectOrSelectTypeIsBoolean' invariant.
	 */
	public static class _invariant_RejectOrSelectTypeIsBoolean extends AbstractUnaryOperation
	{
		public static _invariant_RejectOrSelectTypeIsBoolean INSTANCE = new _invariant_RejectOrSelectTypeIsBoolean();
	
		/*
		name = 'reject' or name = 'select' implies type = Boolean
		*/
		public Value evaluate(DomainEvaluator evaluator, DomainType returnType, final Value self) throws InvalidValueException {
			final ValueFactory valueFactory = evaluator.getValueFactory();
			final DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final ExecutorOperation O_Boolean_or = OCLstdlibTables.Operations._Boolean__or;
			final ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final ExecutorType T_String = OCLstdlibTables.Types._String;
			final ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final StringValue S_reject = valueFactory.stringValueOf("reject");
			final StringValue S_select = valueFactory.stringValueOf("select");
			final ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
			final ExecutorType T_Pivot_ecore__pivot__Type = PivotTables.Types._Type;
			final ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final Value T_ClassClassifier_Boolean_ = valueFactory.createTypeValue(OCLstdlibTables.Types._Boolean);
			
			Value leftA_symbol_209;
			try {
				Value leftA_symbol_210;
				try {
					
					Value A_symbol_211 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
					
					DomainType static_A_symbol_212 = valueFactory.typeOf(A_symbol_211, S_reject);
					LibraryBinaryOperation dynamic_A_symbol_212 = (LibraryBinaryOperation)static_A_symbol_212.lookupImplementation(standardLibrary, O_String__eq_);
					Value A_symbol_212 = dynamic_A_symbol_212.evaluate(evaluator, T_Boolean, A_symbol_211, S_reject);
					leftA_symbol_210 = A_symbol_212;
				} catch (InvalidValueException e) {
					leftA_symbol_210 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_212 = leftA_symbol_210;
				Value rightA_symbol_210;
				try {
					
					Value A_symbol_213 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
					
					DomainType static_A_symbol_214 = valueFactory.typeOf(A_symbol_213, S_select);
					LibraryBinaryOperation dynamic_A_symbol_214 = (LibraryBinaryOperation)static_A_symbol_214.lookupImplementation(standardLibrary, O_String__eq_);
					Value A_symbol_214 = dynamic_A_symbol_214.evaluate(evaluator, T_Boolean, A_symbol_213, S_select);
					rightA_symbol_210 = A_symbol_214;
				} catch (InvalidValueException e) {
					rightA_symbol_210 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_214 = rightA_symbol_210;
				DomainType static_A_symbol_210 = valueFactory.typeOf(A_symbol_212);
				LibraryBinaryOperation dynamic_A_symbol_210 = (LibraryBinaryOperation)static_A_symbol_210.lookupImplementation(standardLibrary, O_Boolean_or);
				Value A_symbol_210 = dynamic_A_symbol_210.evaluate(evaluator, T_Boolean, A_symbol_212, A_symbol_214);
				leftA_symbol_209 = A_symbol_210;
			} catch (InvalidValueException e) {
				leftA_symbol_209 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_210 = leftA_symbol_209;
			Value rightA_symbol_209;
			try {
				
				Value A_symbol_215 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_216 = valueFactory.typeOf(A_symbol_215, T_ClassClassifier_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_216 = (LibraryBinaryOperation)static_A_symbol_216.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_216 = dynamic_A_symbol_216.evaluate(evaluator, T_Boolean, A_symbol_215, T_ClassClassifier_Boolean_);
				rightA_symbol_209 = A_symbol_216;
			} catch (InvalidValueException e) {
				rightA_symbol_209 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_216 = rightA_symbol_209;
			DomainType static_A_symbol_209 = valueFactory.typeOf(A_symbol_210);
			LibraryBinaryOperation dynamic_A_symbol_209 = (LibraryBinaryOperation)static_A_symbol_209.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_209 = dynamic_A_symbol_209.evaluate(evaluator, T_Boolean, A_symbol_210, A_symbol_216);
			return A_symbol_209;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'RejectOrSelectTypeIsSourceType' invariant.
	 */
	public static class _invariant_RejectOrSelectTypeIsSourceType extends AbstractUnaryOperation
	{
		public static _invariant_RejectOrSelectTypeIsSourceType INSTANCE = new _invariant_RejectOrSelectTypeIsSourceType();
	
		/*
		name = 'reject' or name = 'select' implies type = source.type
		*/
		public Value evaluate(DomainEvaluator evaluator, DomainType returnType, final Value self) throws InvalidValueException {
			final ValueFactory valueFactory = evaluator.getValueFactory();
			final DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final ExecutorOperation O_Boolean_or = OCLstdlibTables.Operations._Boolean__or;
			final ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final ExecutorType T_String = OCLstdlibTables.Types._String;
			final ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final StringValue S_reject = valueFactory.stringValueOf("reject");
			final StringValue S_select = valueFactory.stringValueOf("select");
			final ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
			final ExecutorType T_Pivot_ecore__pivot__Type = PivotTables.Types._Type;
			final ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final ExecutorType T_Pivot_ecore__pivot__OclExpression = PivotTables.Types._OclExpression;
			final ExecutorProperty P_CallExp_source = PivotTables.Properties._CallExp__source;
			final LibraryProperty IP_CallExp_source = P_CallExp_source.getImplementation();
			
			Value leftA_symbol_217;
			try {
				Value leftA_symbol_218;
				try {
					
					Value A_symbol_219 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
					
					DomainType static_A_symbol_220 = valueFactory.typeOf(A_symbol_219, S_reject);
					LibraryBinaryOperation dynamic_A_symbol_220 = (LibraryBinaryOperation)static_A_symbol_220.lookupImplementation(standardLibrary, O_String__eq_);
					Value A_symbol_220 = dynamic_A_symbol_220.evaluate(evaluator, T_Boolean, A_symbol_219, S_reject);
					leftA_symbol_218 = A_symbol_220;
				} catch (InvalidValueException e) {
					leftA_symbol_218 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_220 = leftA_symbol_218;
				Value rightA_symbol_218;
				try {
					
					Value A_symbol_221 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
					
					DomainType static_A_symbol_222 = valueFactory.typeOf(A_symbol_221, S_select);
					LibraryBinaryOperation dynamic_A_symbol_222 = (LibraryBinaryOperation)static_A_symbol_222.lookupImplementation(standardLibrary, O_String__eq_);
					Value A_symbol_222 = dynamic_A_symbol_222.evaluate(evaluator, T_Boolean, A_symbol_221, S_select);
					rightA_symbol_218 = A_symbol_222;
				} catch (InvalidValueException e) {
					rightA_symbol_218 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_222 = rightA_symbol_218;
				DomainType static_A_symbol_218 = valueFactory.typeOf(A_symbol_220);
				LibraryBinaryOperation dynamic_A_symbol_218 = (LibraryBinaryOperation)static_A_symbol_218.lookupImplementation(standardLibrary, O_Boolean_or);
				Value A_symbol_218 = dynamic_A_symbol_218.evaluate(evaluator, T_Boolean, A_symbol_220, A_symbol_222);
				leftA_symbol_217 = A_symbol_218;
			} catch (InvalidValueException e) {
				leftA_symbol_217 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_218 = leftA_symbol_217;
			Value rightA_symbol_217;
			try {
				
				Value A_symbol_223 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				
				Value A_symbol_224 = IP_CallExp_source.evaluate(evaluator, T_Pivot_ecore__pivot__OclExpression, self, P_CallExp_source);
				
				Value A_symbol_225 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_224, P_TypedElement_type);
				
				DomainType static_A_symbol_226 = valueFactory.typeOf(A_symbol_223, A_symbol_225);
				LibraryBinaryOperation dynamic_A_symbol_226 = (LibraryBinaryOperation)static_A_symbol_226.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_226 = dynamic_A_symbol_226.evaluate(evaluator, T_Boolean, A_symbol_223, A_symbol_225);
				rightA_symbol_217 = A_symbol_226;
			} catch (InvalidValueException e) {
				rightA_symbol_217 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_226 = rightA_symbol_217;
			DomainType static_A_symbol_217 = valueFactory.typeOf(A_symbol_218);
			LibraryBinaryOperation dynamic_A_symbol_217 = (LibraryBinaryOperation)static_A_symbol_217.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_217 = dynamic_A_symbol_217.evaluate(evaluator, T_Boolean, A_symbol_218, A_symbol_226);
			return A_symbol_217;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'SortedByElementTypeIsSourceElementType' invariant.
	 */
	public static class _invariant_SortedByElementTypeIsSourceElementType extends AbstractUnaryOperation
	{
		public static _invariant_SortedByElementTypeIsSourceElementType INSTANCE = new _invariant_SortedByElementTypeIsSourceElementType();
	
		/*
		name = 'sortedBy' implies
	type.oclAsType(CollectionType).elementType =
	body.type.oclAsType(CollectionType).elementType
		*/
		public Value evaluate(DomainEvaluator evaluator, DomainType returnType, final Value self) throws InvalidValueException {
			final ValueFactory valueFactory = evaluator.getValueFactory();
			final DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final ExecutorType T_String = OCLstdlibTables.Types._String;
			final ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final StringValue S_sortedBy = valueFactory.stringValueOf("sortedBy");
			final ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
			final ExecutorType T_Pivot_ecore__pivot__Type = PivotTables.Types._Type;
			final ExecutorProperty P_CollectionType_elementType = PivotTables.Properties._CollectionType__elementType;
			final LibraryProperty IP_CollectionType_elementType = P_CollectionType_elementType.getImplementation();
			final ExecutorType T_Pivot_ecore__pivot__CollectionType = PivotTables.Types._CollectionType;
			final ExecutorOperation O_OclAny_oclAsType = OCLstdlibTables.Operations._OclAny__oclAsType;
			final ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final Value T_ClassClassifier_Pivot_ecore__pivot__CollectionType_ = valueFactory.createTypeValue(PivotTables.Types._CollectionType);
			final ExecutorType T_Pivot_ecore__pivot__OclExpression = PivotTables.Types._OclExpression;
			final ExecutorProperty P_LoopExp_body = PivotTables.Properties._LoopExp__body;
			final LibraryProperty IP_LoopExp_body = P_LoopExp_body.getImplementation();
			
			Value leftA_symbol_227;
			try {
				
				Value A_symbol_228 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_229 = valueFactory.typeOf(A_symbol_228, S_sortedBy);
				LibraryBinaryOperation dynamic_A_symbol_229 = (LibraryBinaryOperation)static_A_symbol_229.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_229 = dynamic_A_symbol_229.evaluate(evaluator, T_Boolean, A_symbol_228, S_sortedBy);
				leftA_symbol_227 = A_symbol_229;
			} catch (InvalidValueException e) {
				leftA_symbol_227 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_229 = leftA_symbol_227;
			Value rightA_symbol_227;
			try {
				
				Value A_symbol_230 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_231 = valueFactory.typeOf(A_symbol_230);
				LibraryBinaryOperation dynamic_A_symbol_231 = (LibraryBinaryOperation)static_A_symbol_231.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_231 = dynamic_A_symbol_231.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionType, A_symbol_230, T_ClassClassifier_Pivot_ecore__pivot__CollectionType_);
				Value A_symbol_232 = IP_CollectionType_elementType.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_231, P_CollectionType_elementType);
				
				
				Value A_symbol_233 = IP_LoopExp_body.evaluate(evaluator, T_Pivot_ecore__pivot__OclExpression, self, P_LoopExp_body);
				
				Value A_symbol_234 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_233, P_TypedElement_type);
				
				DomainType static_A_symbol_235 = valueFactory.typeOf(A_symbol_234);
				LibraryBinaryOperation dynamic_A_symbol_235 = (LibraryBinaryOperation)static_A_symbol_235.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_235 = dynamic_A_symbol_235.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionType, A_symbol_234, T_ClassClassifier_Pivot_ecore__pivot__CollectionType_);
				Value A_symbol_236 = IP_CollectionType_elementType.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_235, P_CollectionType_elementType);
				
				DomainType static_A_symbol_237 = valueFactory.typeOf(A_symbol_232, A_symbol_236);
				LibraryBinaryOperation dynamic_A_symbol_237 = (LibraryBinaryOperation)static_A_symbol_237.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_237 = dynamic_A_symbol_237.evaluate(evaluator, T_Boolean, A_symbol_232, A_symbol_236);
				rightA_symbol_227 = A_symbol_237;
			} catch (InvalidValueException e) {
				rightA_symbol_227 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_237 = rightA_symbol_227;
			DomainType static_A_symbol_227 = valueFactory.typeOf(A_symbol_229);
			LibraryBinaryOperation dynamic_A_symbol_227 = (LibraryBinaryOperation)static_A_symbol_227.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_227 = dynamic_A_symbol_227.evaluate(evaluator, T_Boolean, A_symbol_229, A_symbol_237);
			return A_symbol_227;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'SortedByHasOneIterator' invariant.
	 */
	public static class _invariant_SortedByHasOneIterator extends AbstractUnaryOperation
	{
		public static _invariant_SortedByHasOneIterator INSTANCE = new _invariant_SortedByHasOneIterator();
	
		/*
		name = 'sortedBy' implies iterator->size() = 1
		*/
		public Value evaluate(DomainEvaluator evaluator, DomainType returnType, final Value self) throws InvalidValueException {
			final ValueFactory valueFactory = evaluator.getValueFactory();
			final DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final ExecutorType T_String = OCLstdlibTables.Types._String;
			final ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final StringValue S_sortedBy = valueFactory.stringValueOf("sortedBy");
			final ExecutorOperation O_Real__eq_ = OCLstdlibTables.Operations._Real___eq_;
			final ExecutorType T_Integer = OCLstdlibTables.Types._Integer;
			final ExecutorOperation O_Collection_size = OCLstdlibTables.Operations._Collection__size;
			final ExecutorType T_Pivot_ecore__pivot__Variable = PivotTables.Types._Variable;
			final DomainCollectionType T_OrderedSet_Pivot_ecore__pivot__Variable_ = standardLibrary.getOrderedSetType(T_Pivot_ecore__pivot__Variable);
			final ExecutorProperty P_LoopExp_iterator = PivotTables.Properties._LoopExp__iterator;
			final LibraryProperty IP_LoopExp_iterator = P_LoopExp_iterator.getImplementation();
			final IntegerValue I_1 = valueFactory.integerValueOf(1);
			
			Value leftA_symbol_238;
			try {
				
				Value A_symbol_239 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_240 = valueFactory.typeOf(A_symbol_239, S_sortedBy);
				LibraryBinaryOperation dynamic_A_symbol_240 = (LibraryBinaryOperation)static_A_symbol_240.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_240 = dynamic_A_symbol_240.evaluate(evaluator, T_Boolean, A_symbol_239, S_sortedBy);
				leftA_symbol_238 = A_symbol_240;
			} catch (InvalidValueException e) {
				leftA_symbol_238 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_240 = leftA_symbol_238;
			Value rightA_symbol_238;
			try {
				
				Value A_symbol_241 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_Pivot_ecore__pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_242 = valueFactory.typeOf(A_symbol_241);
				LibraryUnaryOperation dynamic_A_symbol_242 = (LibraryUnaryOperation)static_A_symbol_242.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_242 = dynamic_A_symbol_242.evaluate(evaluator, T_Integer, A_symbol_241);
				DomainType static_A_symbol_243 = valueFactory.typeOf(A_symbol_242, I_1);
				LibraryBinaryOperation dynamic_A_symbol_243 = (LibraryBinaryOperation)static_A_symbol_243.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_243 = dynamic_A_symbol_243.evaluate(evaluator, T_Boolean, A_symbol_242, I_1);
				rightA_symbol_238 = A_symbol_243;
			} catch (InvalidValueException e) {
				rightA_symbol_238 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_243 = rightA_symbol_238;
			DomainType static_A_symbol_238 = valueFactory.typeOf(A_symbol_240);
			LibraryBinaryOperation dynamic_A_symbol_238 = (LibraryBinaryOperation)static_A_symbol_238.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_238 = dynamic_A_symbol_238.evaluate(evaluator, T_Boolean, A_symbol_240, A_symbol_243);
			return A_symbol_238;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'SortedByIsOrderedIfSourceIsOrdered' invariant.
	 */
	public static class _invariant_SortedByIsOrderedIfSourceIsOrdered extends AbstractUnaryOperation
	{
		public static _invariant_SortedByIsOrderedIfSourceIsOrdered INSTANCE = new _invariant_SortedByIsOrderedIfSourceIsOrdered();
	
		/*
		name = 'sortedBy' implies
	if
	  source.type.oclIsKindOf(SequenceType) or
	  source.type.oclIsKindOf(BagType)
	then type.oclIsKindOf(SequenceType)
	else type.oclIsKindOf(OrderedSetType)
	endif
		*/
		public Value evaluate(DomainEvaluator evaluator, DomainType returnType, final Value self) throws InvalidValueException {
			final ValueFactory valueFactory = evaluator.getValueFactory();
			final DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final ExecutorType T_String = OCLstdlibTables.Types._String;
			final ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final StringValue S_sortedBy = valueFactory.stringValueOf("sortedBy");
			final ExecutorOperation O_Boolean_or = OCLstdlibTables.Operations._Boolean__or;
			final ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
			final ExecutorType T_Pivot_ecore__pivot__Type = PivotTables.Types._Type;
			final ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final ExecutorType T_Pivot_ecore__pivot__OclExpression = PivotTables.Types._OclExpression;
			final ExecutorProperty P_CallExp_source = PivotTables.Properties._CallExp__source;
			final LibraryProperty IP_CallExp_source = P_CallExp_source.getImplementation();
			final Value T_ClassClassifier_Pivot_ecore__pivot__SequenceType_ = valueFactory.createTypeValue(PivotTables.Types._SequenceType);
			final Value T_ClassClassifier_Pivot_ecore__pivot__BagType_ = valueFactory.createTypeValue(PivotTables.Types._BagType);
			final Value T_ClassClassifier_Pivot_ecore__pivot__OrderedSetType_ = valueFactory.createTypeValue(PivotTables.Types._OrderedSetType);
			
			Value leftA_symbol_244;
			try {
				
				Value A_symbol_245 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_246 = valueFactory.typeOf(A_symbol_245, S_sortedBy);
				LibraryBinaryOperation dynamic_A_symbol_246 = (LibraryBinaryOperation)static_A_symbol_246.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_246 = dynamic_A_symbol_246.evaluate(evaluator, T_Boolean, A_symbol_245, S_sortedBy);
				leftA_symbol_244 = A_symbol_246;
			} catch (InvalidValueException e) {
				leftA_symbol_244 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_246 = leftA_symbol_244;
			Value rightA_symbol_244;
			try {
					Value leftA_symbol_247;
					try {
						
						Value A_symbol_248 = IP_CallExp_source.evaluate(evaluator, T_Pivot_ecore__pivot__OclExpression, self, P_CallExp_source);
						
						Value A_symbol_249 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_248, P_TypedElement_type);
						
						DomainType static_A_symbol_250 = valueFactory.typeOf(A_symbol_249);
						LibraryBinaryOperation dynamic_A_symbol_250 = (LibraryBinaryOperation)static_A_symbol_250.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Value A_symbol_250 = dynamic_A_symbol_250.evaluate(evaluator, T_Boolean, A_symbol_249, T_ClassClassifier_Pivot_ecore__pivot__SequenceType_);
						leftA_symbol_247 = A_symbol_250;
					} catch (InvalidValueException e) {
						leftA_symbol_247 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_250 = leftA_symbol_247;
					Value rightA_symbol_247;
					try {
						
						Value A_symbol_251 = IP_CallExp_source.evaluate(evaluator, T_Pivot_ecore__pivot__OclExpression, self, P_CallExp_source);
						
						Value A_symbol_252 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_251, P_TypedElement_type);
						
						DomainType static_A_symbol_253 = valueFactory.typeOf(A_symbol_252);
						LibraryBinaryOperation dynamic_A_symbol_253 = (LibraryBinaryOperation)static_A_symbol_253.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Value A_symbol_253 = dynamic_A_symbol_253.evaluate(evaluator, T_Boolean, A_symbol_252, T_ClassClassifier_Pivot_ecore__pivot__BagType_);
						rightA_symbol_247 = A_symbol_253;
					} catch (InvalidValueException e) {
						rightA_symbol_247 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_253 = rightA_symbol_247;
					DomainType static_A_symbol_247 = valueFactory.typeOf(A_symbol_250);
					LibraryBinaryOperation dynamic_A_symbol_247 = (LibraryBinaryOperation)static_A_symbol_247.lookupImplementation(standardLibrary, O_Boolean_or);
					Value A_symbol_247 = dynamic_A_symbol_247.evaluate(evaluator, T_Boolean, A_symbol_250, A_symbol_253);
				Value A_symbol_254;
				if (A_symbol_247.isTrue()) {
					
					Value A_symbol_255 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
					
					DomainType static_A_symbol_256 = valueFactory.typeOf(A_symbol_255);
					LibraryBinaryOperation dynamic_A_symbol_256 = (LibraryBinaryOperation)static_A_symbol_256.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Value A_symbol_256 = dynamic_A_symbol_256.evaluate(evaluator, T_Boolean, A_symbol_255, T_ClassClassifier_Pivot_ecore__pivot__SequenceType_);
					A_symbol_254 = A_symbol_256;
				}
				else if (A_symbol_247.isFalse()) {
					
					Value A_symbol_257 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
					
					DomainType static_A_symbol_258 = valueFactory.typeOf(A_symbol_257);
					LibraryBinaryOperation dynamic_A_symbol_258 = (LibraryBinaryOperation)static_A_symbol_258.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Value A_symbol_258 = dynamic_A_symbol_258.evaluate(evaluator, T_Boolean, A_symbol_257, T_ClassClassifier_Pivot_ecore__pivot__OrderedSetType_);
					A_symbol_254 = A_symbol_258;
				}
				else if (A_symbol_247.isNull()) {
					A_symbol_254 = valueFactory.throwInvalidValueException("null if condition");
				}
				else {
					A_symbol_254 = valueFactory.throwInvalidValueException("invalid if condition");
				}
				rightA_symbol_244 = A_symbol_254;
			} catch (InvalidValueException e) {
				rightA_symbol_244 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_254 = rightA_symbol_244;
			DomainType static_A_symbol_244 = valueFactory.typeOf(A_symbol_246);
			LibraryBinaryOperation dynamic_A_symbol_244 = (LibraryBinaryOperation)static_A_symbol_244.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_244 = dynamic_A_symbol_244.evaluate(evaluator, T_Boolean, A_symbol_246, A_symbol_254);
			return A_symbol_244;
		}
	}
}

