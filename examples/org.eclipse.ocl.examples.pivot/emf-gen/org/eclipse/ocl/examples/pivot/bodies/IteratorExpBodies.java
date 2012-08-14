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
import org.eclipse.ocl.examples.domain.values.BooleanValue;
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
		public static @NonNull _invariant_AnyBodyTypeIsBoolean INSTANCE = new _invariant_AnyBodyTypeIsBoolean();
	
		/*
		name = 'any' implies body.type = 'Boolean'
		*/
		public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Value self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final @NonNull ExecutorType T_String = OCLstdlibTables.Types._String;
			final @NonNull ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final @NonNull LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final @NonNull StringValue S_any = valueFactory.stringValueOf("any");
			final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
			final @NonNull ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final @NonNull ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final @NonNull LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final @NonNull ExecutorType T_pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final @NonNull ExecutorProperty P_LoopExp_body = PivotTables.Properties._LoopExp__body;
			final @NonNull LibraryProperty IP_LoopExp_body = P_LoopExp_body.getImplementation();
			final @NonNull StringValue S_Boolean = valueFactory.stringValueOf("Boolean");
			
			Value leftA_symbol_0;
			try {
				
				Value A_symbol_1 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_2 = valueFactory.typeOf(A_symbol_1, S_any);
				LibraryBinaryOperation dynamic_A_symbol_2 = (LibraryBinaryOperation)static_A_symbol_2.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_2 = dynamic_A_symbol_2.evaluate(evaluator, T_Boolean, A_symbol_1, S_any);
				leftA_symbol_0 = A_symbol_2;
			} catch (InvalidValueException e) {
				leftA_symbol_0 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_2 = leftA_symbol_0;
			Value rightA_symbol_0;
			try {
				
				Value A_symbol_3 = IP_LoopExp_body.evaluate(evaluator, T_pivot__OCLExpression, self, P_LoopExp_body);
				
				Value A_symbol_4 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_3, P_TypedElement_type);
				
				DomainType static_A_symbol_5 = valueFactory.typeOf(A_symbol_4, S_Boolean);
				LibraryBinaryOperation dynamic_A_symbol_5 = (LibraryBinaryOperation)static_A_symbol_5.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_5 = dynamic_A_symbol_5.evaluate(evaluator, T_Boolean, A_symbol_4, S_Boolean);
				rightA_symbol_0 = A_symbol_5;
			} catch (InvalidValueException e) {
				rightA_symbol_0 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_5 = rightA_symbol_0;
			DomainType static_A_symbol_0 = valueFactory.typeOf(A_symbol_2);
			LibraryBinaryOperation dynamic_A_symbol_0 = (LibraryBinaryOperation)static_A_symbol_0.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_0 = dynamic_A_symbol_0.evaluate(evaluator, T_Boolean, A_symbol_2, A_symbol_5);
			return A_symbol_0;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'AnyHasOneIterator' invariant.
	 */
	public static class _invariant_AnyHasOneIterator extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_AnyHasOneIterator INSTANCE = new _invariant_AnyHasOneIterator();
	
		/*
		name = 'any' implies iterator->size() = 1
		*/
		public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Value self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final @NonNull ExecutorType T_String = OCLstdlibTables.Types._String;
			final @NonNull ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final @NonNull LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final @NonNull StringValue S_any = valueFactory.stringValueOf("any");
			final @NonNull ExecutorOperation O_Real__eq_ = OCLstdlibTables.Operations._Real___eq_;
			final @NonNull ExecutorType T_Integer = OCLstdlibTables.Types._Integer;
			final @NonNull ExecutorOperation O_Collection_size = OCLstdlibTables.Operations._Collection__size;
			final @NonNull ExecutorType T_pivot__Variable = PivotTables.Types._Variable;
			final @NonNull DomainCollectionType T_OrderedSet_pivot__Variable_ = standardLibrary.getOrderedSetType(T_pivot__Variable);
			final @NonNull ExecutorProperty P_LoopExp_iterator = PivotTables.Properties._LoopExp__iterator;
			final @NonNull LibraryProperty IP_LoopExp_iterator = P_LoopExp_iterator.getImplementation();
			final @NonNull IntegerValue I_1 = valueFactory.integerValueOf(1);
			
			Value leftA_symbol_6;
			try {
				
				Value A_symbol_7 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_8 = valueFactory.typeOf(A_symbol_7, S_any);
				LibraryBinaryOperation dynamic_A_symbol_8 = (LibraryBinaryOperation)static_A_symbol_8.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_8 = dynamic_A_symbol_8.evaluate(evaluator, T_Boolean, A_symbol_7, S_any);
				leftA_symbol_6 = A_symbol_8;
			} catch (InvalidValueException e) {
				leftA_symbol_6 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_8 = leftA_symbol_6;
			Value rightA_symbol_6;
			try {
				
				Value A_symbol_9 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_10 = valueFactory.typeOf(A_symbol_9);
				LibraryUnaryOperation dynamic_A_symbol_10 = (LibraryUnaryOperation)static_A_symbol_10.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_10 = dynamic_A_symbol_10.evaluate(evaluator, T_Integer, A_symbol_9);
				DomainType static_A_symbol_11 = valueFactory.typeOf(A_symbol_10, I_1);
				LibraryBinaryOperation dynamic_A_symbol_11 = (LibraryBinaryOperation)static_A_symbol_11.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_11 = dynamic_A_symbol_11.evaluate(evaluator, T_Boolean, A_symbol_10, I_1);
				rightA_symbol_6 = A_symbol_11;
			} catch (InvalidValueException e) {
				rightA_symbol_6 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_11 = rightA_symbol_6;
			DomainType static_A_symbol_6 = valueFactory.typeOf(A_symbol_8);
			LibraryBinaryOperation dynamic_A_symbol_6 = (LibraryBinaryOperation)static_A_symbol_6.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_6 = dynamic_A_symbol_6.evaluate(evaluator, T_Boolean, A_symbol_8, A_symbol_11);
			return A_symbol_6;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'AnyTypeIsSourceElementType' invariant.
	 */
	public static class _invariant_AnyTypeIsSourceElementType extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_AnyTypeIsSourceElementType INSTANCE = new _invariant_AnyTypeIsSourceElementType();
	
		/*
		name = 'any' implies type = source.type.oclAsType(CollectionType).elementType
		*/
		public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Value self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final @NonNull ExecutorType T_String = OCLstdlibTables.Types._String;
			final @NonNull ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final @NonNull LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final @NonNull StringValue S_any = valueFactory.stringValueOf("any");
			final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
			final @NonNull ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final @NonNull ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final @NonNull LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final @NonNull ExecutorProperty P_CollectionType_elementType = PivotTables.Properties._CollectionType__elementType;
			final @NonNull LibraryProperty IP_CollectionType_elementType = P_CollectionType_elementType.getImplementation();
			final @NonNull ExecutorType T_pivot__CollectionType = PivotTables.Types._CollectionType;
			final @NonNull ExecutorOperation O_OclAny_oclAsType = OCLstdlibTables.Operations._OclAny__oclAsType;
			final @NonNull ExecutorType T_pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final @NonNull ExecutorProperty P_CallExp_source = PivotTables.Properties._CallExp__source;
			final @NonNull LibraryProperty IP_CallExp_source = P_CallExp_source.getImplementation();
			final @NonNull Value T_Metaclass_pivot__CollectionType_ = valueFactory.createTypeValue(PivotTables.Types._CollectionType);
			
			Value leftA_symbol_12;
			try {
				
				Value A_symbol_13 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_14 = valueFactory.typeOf(A_symbol_13, S_any);
				LibraryBinaryOperation dynamic_A_symbol_14 = (LibraryBinaryOperation)static_A_symbol_14.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_14 = dynamic_A_symbol_14.evaluate(evaluator, T_Boolean, A_symbol_13, S_any);
				leftA_symbol_12 = A_symbol_14;
			} catch (InvalidValueException e) {
				leftA_symbol_12 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_14 = leftA_symbol_12;
			Value rightA_symbol_12;
			try {
				
				Value A_symbol_15 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				
				Value A_symbol_16 = IP_CallExp_source.evaluate(evaluator, T_pivot__OCLExpression, self, P_CallExp_source);
				
				Value A_symbol_17 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_16, P_TypedElement_type);
				
				DomainType static_A_symbol_18 = valueFactory.typeOf(A_symbol_17);
				LibraryBinaryOperation dynamic_A_symbol_18 = (LibraryBinaryOperation)static_A_symbol_18.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_18 = dynamic_A_symbol_18.evaluate(evaluator, T_pivot__CollectionType, A_symbol_17, T_Metaclass_pivot__CollectionType_);
				Value A_symbol_19 = IP_CollectionType_elementType.evaluate(evaluator, T_Type, A_symbol_18, P_CollectionType_elementType);
				
				DomainType static_A_symbol_20 = valueFactory.typeOf(A_symbol_15, A_symbol_19);
				LibraryBinaryOperation dynamic_A_symbol_20 = (LibraryBinaryOperation)static_A_symbol_20.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_20 = dynamic_A_symbol_20.evaluate(evaluator, T_Boolean, A_symbol_15, A_symbol_19);
				rightA_symbol_12 = A_symbol_20;
			} catch (InvalidValueException e) {
				rightA_symbol_12 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_20 = rightA_symbol_12;
			DomainType static_A_symbol_12 = valueFactory.typeOf(A_symbol_14);
			LibraryBinaryOperation dynamic_A_symbol_12 = (LibraryBinaryOperation)static_A_symbol_12.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_12 = dynamic_A_symbol_12.evaluate(evaluator, T_Boolean, A_symbol_14, A_symbol_20);
			return A_symbol_12;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'ClosureBodyTypeIsConformanttoIteratorType' invariant.
	 */
	public static class _invariant_ClosureBodyTypeIsConformanttoIteratorType extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_ClosureBodyTypeIsConformanttoIteratorType INSTANCE = new _invariant_ClosureBodyTypeIsConformanttoIteratorType();
	
		/*
		true
		*/
		public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Value self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull BooleanValue True = valueFactory.getTrue();
			
			
			return True;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'ClosureElementTypeIsSourceElementType' invariant.
	 */
	public static class _invariant_ClosureElementTypeIsSourceElementType extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_ClosureElementTypeIsSourceElementType INSTANCE = new _invariant_ClosureElementTypeIsSourceElementType();
	
		/*
		name = 'closure' implies
	type.oclAsType(CollectionType).elementType =
	source.type.oclAsType(CollectionType).elementType
		*/
		public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Value self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final @NonNull ExecutorType T_String = OCLstdlibTables.Types._String;
			final @NonNull ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final @NonNull LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final @NonNull StringValue S_closure = valueFactory.stringValueOf("closure");
			final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
			final @NonNull ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final @NonNull ExecutorProperty P_CollectionType_elementType = PivotTables.Properties._CollectionType__elementType;
			final @NonNull LibraryProperty IP_CollectionType_elementType = P_CollectionType_elementType.getImplementation();
			final @NonNull ExecutorType T_pivot__CollectionType = PivotTables.Types._CollectionType;
			final @NonNull ExecutorOperation O_OclAny_oclAsType = OCLstdlibTables.Operations._OclAny__oclAsType;
			final @NonNull ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final @NonNull LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final @NonNull Value T_Metaclass_pivot__CollectionType_ = valueFactory.createTypeValue(PivotTables.Types._CollectionType);
			final @NonNull ExecutorType T_pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final @NonNull ExecutorProperty P_CallExp_source = PivotTables.Properties._CallExp__source;
			final @NonNull LibraryProperty IP_CallExp_source = P_CallExp_source.getImplementation();
			
			Value leftA_symbol_21;
			try {
				
				Value A_symbol_22 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_23 = valueFactory.typeOf(A_symbol_22, S_closure);
				LibraryBinaryOperation dynamic_A_symbol_23 = (LibraryBinaryOperation)static_A_symbol_23.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_23 = dynamic_A_symbol_23.evaluate(evaluator, T_Boolean, A_symbol_22, S_closure);
				leftA_symbol_21 = A_symbol_23;
			} catch (InvalidValueException e) {
				leftA_symbol_21 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_23 = leftA_symbol_21;
			Value rightA_symbol_21;
			try {
				
				Value A_symbol_24 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_25 = valueFactory.typeOf(A_symbol_24);
				LibraryBinaryOperation dynamic_A_symbol_25 = (LibraryBinaryOperation)static_A_symbol_25.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_25 = dynamic_A_symbol_25.evaluate(evaluator, T_pivot__CollectionType, A_symbol_24, T_Metaclass_pivot__CollectionType_);
				Value A_symbol_26 = IP_CollectionType_elementType.evaluate(evaluator, T_Type, A_symbol_25, P_CollectionType_elementType);
				
				
				Value A_symbol_27 = IP_CallExp_source.evaluate(evaluator, T_pivot__OCLExpression, self, P_CallExp_source);
				
				Value A_symbol_28 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_27, P_TypedElement_type);
				
				DomainType static_A_symbol_29 = valueFactory.typeOf(A_symbol_28);
				LibraryBinaryOperation dynamic_A_symbol_29 = (LibraryBinaryOperation)static_A_symbol_29.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_29 = dynamic_A_symbol_29.evaluate(evaluator, T_pivot__CollectionType, A_symbol_28, T_Metaclass_pivot__CollectionType_);
				Value A_symbol_30 = IP_CollectionType_elementType.evaluate(evaluator, T_Type, A_symbol_29, P_CollectionType_elementType);
				
				DomainType static_A_symbol_31 = valueFactory.typeOf(A_symbol_26, A_symbol_30);
				LibraryBinaryOperation dynamic_A_symbol_31 = (LibraryBinaryOperation)static_A_symbol_31.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_31 = dynamic_A_symbol_31.evaluate(evaluator, T_Boolean, A_symbol_26, A_symbol_30);
				rightA_symbol_21 = A_symbol_31;
			} catch (InvalidValueException e) {
				rightA_symbol_21 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_31 = rightA_symbol_21;
			DomainType static_A_symbol_21 = valueFactory.typeOf(A_symbol_23);
			LibraryBinaryOperation dynamic_A_symbol_21 = (LibraryBinaryOperation)static_A_symbol_21.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_21 = dynamic_A_symbol_21.evaluate(evaluator, T_Boolean, A_symbol_23, A_symbol_31);
			return A_symbol_21;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'ClosureHasOneIterator' invariant.
	 */
	public static class _invariant_ClosureHasOneIterator extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_ClosureHasOneIterator INSTANCE = new _invariant_ClosureHasOneIterator();
	
		/*
		name = 'closure' implies iterator->size() = 1
		*/
		public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Value self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final @NonNull ExecutorType T_String = OCLstdlibTables.Types._String;
			final @NonNull ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final @NonNull LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final @NonNull StringValue S_closure = valueFactory.stringValueOf("closure");
			final @NonNull ExecutorOperation O_Real__eq_ = OCLstdlibTables.Operations._Real___eq_;
			final @NonNull ExecutorType T_Integer = OCLstdlibTables.Types._Integer;
			final @NonNull ExecutorOperation O_Collection_size = OCLstdlibTables.Operations._Collection__size;
			final @NonNull ExecutorType T_pivot__Variable = PivotTables.Types._Variable;
			final @NonNull DomainCollectionType T_OrderedSet_pivot__Variable_ = standardLibrary.getOrderedSetType(T_pivot__Variable);
			final @NonNull ExecutorProperty P_LoopExp_iterator = PivotTables.Properties._LoopExp__iterator;
			final @NonNull LibraryProperty IP_LoopExp_iterator = P_LoopExp_iterator.getImplementation();
			final @NonNull IntegerValue I_1 = valueFactory.integerValueOf(1);
			
			Value leftA_symbol_32;
			try {
				
				Value A_symbol_33 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_34 = valueFactory.typeOf(A_symbol_33, S_closure);
				LibraryBinaryOperation dynamic_A_symbol_34 = (LibraryBinaryOperation)static_A_symbol_34.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_34 = dynamic_A_symbol_34.evaluate(evaluator, T_Boolean, A_symbol_33, S_closure);
				leftA_symbol_32 = A_symbol_34;
			} catch (InvalidValueException e) {
				leftA_symbol_32 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_34 = leftA_symbol_32;
			Value rightA_symbol_32;
			try {
				
				Value A_symbol_35 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_36 = valueFactory.typeOf(A_symbol_35);
				LibraryUnaryOperation dynamic_A_symbol_36 = (LibraryUnaryOperation)static_A_symbol_36.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_36 = dynamic_A_symbol_36.evaluate(evaluator, T_Integer, A_symbol_35);
				DomainType static_A_symbol_37 = valueFactory.typeOf(A_symbol_36, I_1);
				LibraryBinaryOperation dynamic_A_symbol_37 = (LibraryBinaryOperation)static_A_symbol_37.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_37 = dynamic_A_symbol_37.evaluate(evaluator, T_Boolean, A_symbol_36, I_1);
				rightA_symbol_32 = A_symbol_37;
			} catch (InvalidValueException e) {
				rightA_symbol_32 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_37 = rightA_symbol_32;
			DomainType static_A_symbol_32 = valueFactory.typeOf(A_symbol_34);
			LibraryBinaryOperation dynamic_A_symbol_32 = (LibraryBinaryOperation)static_A_symbol_32.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_32 = dynamic_A_symbol_32.evaluate(evaluator, T_Boolean, A_symbol_34, A_symbol_37);
			return A_symbol_32;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'ClosureSourceElementTypeIsBodyElementType' invariant.
	 */
	public static class _invariant_ClosureSourceElementTypeIsBodyElementType extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_ClosureSourceElementTypeIsBodyElementType INSTANCE = new _invariant_ClosureSourceElementTypeIsBodyElementType();
	
		/*
		name = 'closure' implies
	source.type.oclAsType(CollectionType).elementType =
	if body.type.oclIsKindOf(CollectionType)
	then body.type.oclAsType(CollectionType).elementType
	else body.type
	endif
		*/
		public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Value self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final @NonNull ExecutorType T_String = OCLstdlibTables.Types._String;
			final @NonNull ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final @NonNull LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final @NonNull StringValue S_closure = valueFactory.stringValueOf("closure");
			final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
			final @NonNull ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final @NonNull ExecutorProperty P_CollectionType_elementType = PivotTables.Properties._CollectionType__elementType;
			final @NonNull LibraryProperty IP_CollectionType_elementType = P_CollectionType_elementType.getImplementation();
			final @NonNull ExecutorType T_pivot__CollectionType = PivotTables.Types._CollectionType;
			final @NonNull ExecutorOperation O_OclAny_oclAsType = OCLstdlibTables.Operations._OclAny__oclAsType;
			final @NonNull ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final @NonNull LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final @NonNull ExecutorType T_pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final @NonNull ExecutorProperty P_CallExp_source = PivotTables.Properties._CallExp__source;
			final @NonNull LibraryProperty IP_CallExp_source = P_CallExp_source.getImplementation();
			final @NonNull Value T_Metaclass_pivot__CollectionType_ = valueFactory.createTypeValue(PivotTables.Types._CollectionType);
			final @NonNull ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
			final @NonNull ExecutorProperty P_LoopExp_body = PivotTables.Properties._LoopExp__body;
			final @NonNull LibraryProperty IP_LoopExp_body = P_LoopExp_body.getImplementation();
			
			Value leftA_symbol_38;
			try {
				
				Value A_symbol_39 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_40 = valueFactory.typeOf(A_symbol_39, S_closure);
				LibraryBinaryOperation dynamic_A_symbol_40 = (LibraryBinaryOperation)static_A_symbol_40.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_40 = dynamic_A_symbol_40.evaluate(evaluator, T_Boolean, A_symbol_39, S_closure);
				leftA_symbol_38 = A_symbol_40;
			} catch (InvalidValueException e) {
				leftA_symbol_38 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_40 = leftA_symbol_38;
			Value rightA_symbol_38;
			try {
				
				Value A_symbol_41 = IP_CallExp_source.evaluate(evaluator, T_pivot__OCLExpression, self, P_CallExp_source);
				
				Value A_symbol_42 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_41, P_TypedElement_type);
				
				DomainType static_A_symbol_43 = valueFactory.typeOf(A_symbol_42);
				LibraryBinaryOperation dynamic_A_symbol_43 = (LibraryBinaryOperation)static_A_symbol_43.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_43 = dynamic_A_symbol_43.evaluate(evaluator, T_pivot__CollectionType, A_symbol_42, T_Metaclass_pivot__CollectionType_);
				Value A_symbol_44 = IP_CollectionType_elementType.evaluate(evaluator, T_Type, A_symbol_43, P_CollectionType_elementType);
				
					
					Value A_symbol_45 = IP_LoopExp_body.evaluate(evaluator, T_pivot__OCLExpression, self, P_LoopExp_body);
					
					Value A_symbol_46 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_45, P_TypedElement_type);
					
					DomainType static_A_symbol_47 = valueFactory.typeOf(A_symbol_46);
					LibraryBinaryOperation dynamic_A_symbol_47 = (LibraryBinaryOperation)static_A_symbol_47.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Value A_symbol_47 = dynamic_A_symbol_47.evaluate(evaluator, T_Boolean, A_symbol_46, T_Metaclass_pivot__CollectionType_);
				Value A_symbol_48;
				if (A_symbol_47.isTrue()) {
					
					Value A_symbol_49 = IP_LoopExp_body.evaluate(evaluator, T_pivot__OCLExpression, self, P_LoopExp_body);
					
					Value A_symbol_50 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_49, P_TypedElement_type);
					
					DomainType static_A_symbol_51 = valueFactory.typeOf(A_symbol_50);
					LibraryBinaryOperation dynamic_A_symbol_51 = (LibraryBinaryOperation)static_A_symbol_51.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
					Value A_symbol_51 = dynamic_A_symbol_51.evaluate(evaluator, T_pivot__CollectionType, A_symbol_50, T_Metaclass_pivot__CollectionType_);
					Value A_symbol_52 = IP_CollectionType_elementType.evaluate(evaluator, T_Type, A_symbol_51, P_CollectionType_elementType);
					
					A_symbol_48 = A_symbol_52;
				}
				else if (A_symbol_47.isFalse()) {
					
					Value A_symbol_53 = IP_LoopExp_body.evaluate(evaluator, T_pivot__OCLExpression, self, P_LoopExp_body);
					
					Value A_symbol_54 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_53, P_TypedElement_type);
					
					A_symbol_48 = A_symbol_54;
				}
				else if (A_symbol_47.isNull()) {
					A_symbol_48 = valueFactory.throwInvalidValueException("null if condition");
				}
				else {
					A_symbol_48 = valueFactory.throwInvalidValueException("invalid if condition");
				}
				DomainType static_A_symbol_55 = valueFactory.typeOf(A_symbol_44, A_symbol_48);
				LibraryBinaryOperation dynamic_A_symbol_55 = (LibraryBinaryOperation)static_A_symbol_55.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_55 = dynamic_A_symbol_55.evaluate(evaluator, T_Boolean, A_symbol_44, A_symbol_48);
				rightA_symbol_38 = A_symbol_55;
			} catch (InvalidValueException e) {
				rightA_symbol_38 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_55 = rightA_symbol_38;
			DomainType static_A_symbol_38 = valueFactory.typeOf(A_symbol_40);
			LibraryBinaryOperation dynamic_A_symbol_38 = (LibraryBinaryOperation)static_A_symbol_38.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_38 = dynamic_A_symbol_38.evaluate(evaluator, T_Boolean, A_symbol_40, A_symbol_55);
			return A_symbol_38;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'ClosureTypeIsUniqueCollection' invariant.
	 */
	public static class _invariant_ClosureTypeIsUniqueCollection extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_ClosureTypeIsUniqueCollection INSTANCE = new _invariant_ClosureTypeIsUniqueCollection();
	
		/*
		name = 'closure' implies
	if
	  source.type.oclIsKindOf(SequenceType) or
	  source.type.oclIsKindOf(OrderedSetType)
	then type.oclIsKindOf(OrderedSetType)
	else type.oclIsKindOf(SetType)
	endif
		*/
		public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Value self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final @NonNull ExecutorType T_String = OCLstdlibTables.Types._String;
			final @NonNull ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final @NonNull LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final @NonNull StringValue S_closure = valueFactory.stringValueOf("closure");
			final @NonNull ExecutorOperation O_Boolean_or = OCLstdlibTables.Operations._Boolean__or;
			final @NonNull ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
			final @NonNull ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final @NonNull ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final @NonNull LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final @NonNull ExecutorType T_pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final @NonNull ExecutorProperty P_CallExp_source = PivotTables.Properties._CallExp__source;
			final @NonNull LibraryProperty IP_CallExp_source = P_CallExp_source.getImplementation();
			final @NonNull Value T_Metaclass_pivot__SequenceType_ = valueFactory.createTypeValue(PivotTables.Types._SequenceType);
			final @NonNull Value T_Metaclass_pivot__OrderedSetType_ = valueFactory.createTypeValue(PivotTables.Types._OrderedSetType);
			final @NonNull Value T_Metaclass_pivot__SetType_ = valueFactory.createTypeValue(PivotTables.Types._SetType);
			
			Value leftA_symbol_56;
			try {
				
				Value A_symbol_57 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_58 = valueFactory.typeOf(A_symbol_57, S_closure);
				LibraryBinaryOperation dynamic_A_symbol_58 = (LibraryBinaryOperation)static_A_symbol_58.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_58 = dynamic_A_symbol_58.evaluate(evaluator, T_Boolean, A_symbol_57, S_closure);
				leftA_symbol_56 = A_symbol_58;
			} catch (InvalidValueException e) {
				leftA_symbol_56 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_58 = leftA_symbol_56;
			Value rightA_symbol_56;
			try {
					Value leftA_symbol_59;
					try {
						
						Value A_symbol_60 = IP_CallExp_source.evaluate(evaluator, T_pivot__OCLExpression, self, P_CallExp_source);
						
						Value A_symbol_61 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_60, P_TypedElement_type);
						
						DomainType static_A_symbol_62 = valueFactory.typeOf(A_symbol_61);
						LibraryBinaryOperation dynamic_A_symbol_62 = (LibraryBinaryOperation)static_A_symbol_62.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Value A_symbol_62 = dynamic_A_symbol_62.evaluate(evaluator, T_Boolean, A_symbol_61, T_Metaclass_pivot__SequenceType_);
						leftA_symbol_59 = A_symbol_62;
					} catch (InvalidValueException e) {
						leftA_symbol_59 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_62 = leftA_symbol_59;
					Value rightA_symbol_59;
					try {
						
						Value A_symbol_63 = IP_CallExp_source.evaluate(evaluator, T_pivot__OCLExpression, self, P_CallExp_source);
						
						Value A_symbol_64 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_63, P_TypedElement_type);
						
						DomainType static_A_symbol_65 = valueFactory.typeOf(A_symbol_64);
						LibraryBinaryOperation dynamic_A_symbol_65 = (LibraryBinaryOperation)static_A_symbol_65.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Value A_symbol_65 = dynamic_A_symbol_65.evaluate(evaluator, T_Boolean, A_symbol_64, T_Metaclass_pivot__OrderedSetType_);
						rightA_symbol_59 = A_symbol_65;
					} catch (InvalidValueException e) {
						rightA_symbol_59 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_65 = rightA_symbol_59;
					DomainType static_A_symbol_59 = valueFactory.typeOf(A_symbol_62);
					LibraryBinaryOperation dynamic_A_symbol_59 = (LibraryBinaryOperation)static_A_symbol_59.lookupImplementation(standardLibrary, O_Boolean_or);
					Value A_symbol_59 = dynamic_A_symbol_59.evaluate(evaluator, T_Boolean, A_symbol_62, A_symbol_65);
				Value A_symbol_66;
				if (A_symbol_59.isTrue()) {
					
					Value A_symbol_67 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
					
					DomainType static_A_symbol_68 = valueFactory.typeOf(A_symbol_67);
					LibraryBinaryOperation dynamic_A_symbol_68 = (LibraryBinaryOperation)static_A_symbol_68.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Value A_symbol_68 = dynamic_A_symbol_68.evaluate(evaluator, T_Boolean, A_symbol_67, T_Metaclass_pivot__OrderedSetType_);
					A_symbol_66 = A_symbol_68;
				}
				else if (A_symbol_59.isFalse()) {
					
					Value A_symbol_69 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
					
					DomainType static_A_symbol_70 = valueFactory.typeOf(A_symbol_69);
					LibraryBinaryOperation dynamic_A_symbol_70 = (LibraryBinaryOperation)static_A_symbol_70.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Value A_symbol_70 = dynamic_A_symbol_70.evaluate(evaluator, T_Boolean, A_symbol_69, T_Metaclass_pivot__SetType_);
					A_symbol_66 = A_symbol_70;
				}
				else if (A_symbol_59.isNull()) {
					A_symbol_66 = valueFactory.throwInvalidValueException("null if condition");
				}
				else {
					A_symbol_66 = valueFactory.throwInvalidValueException("invalid if condition");
				}
				rightA_symbol_56 = A_symbol_66;
			} catch (InvalidValueException e) {
				rightA_symbol_56 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_66 = rightA_symbol_56;
			DomainType static_A_symbol_56 = valueFactory.typeOf(A_symbol_58);
			LibraryBinaryOperation dynamic_A_symbol_56 = (LibraryBinaryOperation)static_A_symbol_56.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_56 = dynamic_A_symbol_56.evaluate(evaluator, T_Boolean, A_symbol_58, A_symbol_66);
			return A_symbol_56;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'CollectElementTypeIsSourceElementType' invariant.
	 */
	public static class _invariant_CollectElementTypeIsSourceElementType extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_CollectElementTypeIsSourceElementType INSTANCE = new _invariant_CollectElementTypeIsSourceElementType();
	
		/*
		name = 'collect' implies
	type.oclAsType(CollectionType).elementType =
	body.type.oclAsType(CollectionType).elementType
		*/
		public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Value self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final @NonNull ExecutorType T_String = OCLstdlibTables.Types._String;
			final @NonNull ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final @NonNull LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final @NonNull StringValue S_collect = valueFactory.stringValueOf("collect");
			final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
			final @NonNull ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final @NonNull ExecutorProperty P_CollectionType_elementType = PivotTables.Properties._CollectionType__elementType;
			final @NonNull LibraryProperty IP_CollectionType_elementType = P_CollectionType_elementType.getImplementation();
			final @NonNull ExecutorType T_pivot__CollectionType = PivotTables.Types._CollectionType;
			final @NonNull ExecutorOperation O_OclAny_oclAsType = OCLstdlibTables.Operations._OclAny__oclAsType;
			final @NonNull ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final @NonNull LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final @NonNull Value T_Metaclass_pivot__CollectionType_ = valueFactory.createTypeValue(PivotTables.Types._CollectionType);
			final @NonNull ExecutorType T_pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final @NonNull ExecutorProperty P_LoopExp_body = PivotTables.Properties._LoopExp__body;
			final @NonNull LibraryProperty IP_LoopExp_body = P_LoopExp_body.getImplementation();
			
			Value leftA_symbol_71;
			try {
				
				Value A_symbol_72 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_73 = valueFactory.typeOf(A_symbol_72, S_collect);
				LibraryBinaryOperation dynamic_A_symbol_73 = (LibraryBinaryOperation)static_A_symbol_73.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_73 = dynamic_A_symbol_73.evaluate(evaluator, T_Boolean, A_symbol_72, S_collect);
				leftA_symbol_71 = A_symbol_73;
			} catch (InvalidValueException e) {
				leftA_symbol_71 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_73 = leftA_symbol_71;
			Value rightA_symbol_71;
			try {
				
				Value A_symbol_74 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_75 = valueFactory.typeOf(A_symbol_74);
				LibraryBinaryOperation dynamic_A_symbol_75 = (LibraryBinaryOperation)static_A_symbol_75.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_75 = dynamic_A_symbol_75.evaluate(evaluator, T_pivot__CollectionType, A_symbol_74, T_Metaclass_pivot__CollectionType_);
				Value A_symbol_76 = IP_CollectionType_elementType.evaluate(evaluator, T_Type, A_symbol_75, P_CollectionType_elementType);
				
				
				Value A_symbol_77 = IP_LoopExp_body.evaluate(evaluator, T_pivot__OCLExpression, self, P_LoopExp_body);
				
				Value A_symbol_78 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_77, P_TypedElement_type);
				
				DomainType static_A_symbol_79 = valueFactory.typeOf(A_symbol_78);
				LibraryBinaryOperation dynamic_A_symbol_79 = (LibraryBinaryOperation)static_A_symbol_79.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_79 = dynamic_A_symbol_79.evaluate(evaluator, T_pivot__CollectionType, A_symbol_78, T_Metaclass_pivot__CollectionType_);
				Value A_symbol_80 = IP_CollectionType_elementType.evaluate(evaluator, T_Type, A_symbol_79, P_CollectionType_elementType);
				
				DomainType static_A_symbol_81 = valueFactory.typeOf(A_symbol_76, A_symbol_80);
				LibraryBinaryOperation dynamic_A_symbol_81 = (LibraryBinaryOperation)static_A_symbol_81.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_81 = dynamic_A_symbol_81.evaluate(evaluator, T_Boolean, A_symbol_76, A_symbol_80);
				rightA_symbol_71 = A_symbol_81;
			} catch (InvalidValueException e) {
				rightA_symbol_71 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_81 = rightA_symbol_71;
			DomainType static_A_symbol_71 = valueFactory.typeOf(A_symbol_73);
			LibraryBinaryOperation dynamic_A_symbol_71 = (LibraryBinaryOperation)static_A_symbol_71.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_71 = dynamic_A_symbol_71.evaluate(evaluator, T_Boolean, A_symbol_73, A_symbol_81);
			return A_symbol_71;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'CollectHasOneIterator' invariant.
	 */
	public static class _invariant_CollectHasOneIterator extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_CollectHasOneIterator INSTANCE = new _invariant_CollectHasOneIterator();
	
		/*
		name = 'collect' implies iterator->size() = 1
		*/
		public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Value self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final @NonNull ExecutorType T_String = OCLstdlibTables.Types._String;
			final @NonNull ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final @NonNull LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final @NonNull StringValue S_collect = valueFactory.stringValueOf("collect");
			final @NonNull ExecutorOperation O_Real__eq_ = OCLstdlibTables.Operations._Real___eq_;
			final @NonNull ExecutorType T_Integer = OCLstdlibTables.Types._Integer;
			final @NonNull ExecutorOperation O_Collection_size = OCLstdlibTables.Operations._Collection__size;
			final @NonNull ExecutorType T_pivot__Variable = PivotTables.Types._Variable;
			final @NonNull DomainCollectionType T_OrderedSet_pivot__Variable_ = standardLibrary.getOrderedSetType(T_pivot__Variable);
			final @NonNull ExecutorProperty P_LoopExp_iterator = PivotTables.Properties._LoopExp__iterator;
			final @NonNull LibraryProperty IP_LoopExp_iterator = P_LoopExp_iterator.getImplementation();
			final @NonNull IntegerValue I_1 = valueFactory.integerValueOf(1);
			
			Value leftA_symbol_82;
			try {
				
				Value A_symbol_83 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_84 = valueFactory.typeOf(A_symbol_83, S_collect);
				LibraryBinaryOperation dynamic_A_symbol_84 = (LibraryBinaryOperation)static_A_symbol_84.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_84 = dynamic_A_symbol_84.evaluate(evaluator, T_Boolean, A_symbol_83, S_collect);
				leftA_symbol_82 = A_symbol_84;
			} catch (InvalidValueException e) {
				leftA_symbol_82 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_84 = leftA_symbol_82;
			Value rightA_symbol_82;
			try {
				
				Value A_symbol_85 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_86 = valueFactory.typeOf(A_symbol_85);
				LibraryUnaryOperation dynamic_A_symbol_86 = (LibraryUnaryOperation)static_A_symbol_86.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_86 = dynamic_A_symbol_86.evaluate(evaluator, T_Integer, A_symbol_85);
				DomainType static_A_symbol_87 = valueFactory.typeOf(A_symbol_86, I_1);
				LibraryBinaryOperation dynamic_A_symbol_87 = (LibraryBinaryOperation)static_A_symbol_87.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_87 = dynamic_A_symbol_87.evaluate(evaluator, T_Boolean, A_symbol_86, I_1);
				rightA_symbol_82 = A_symbol_87;
			} catch (InvalidValueException e) {
				rightA_symbol_82 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_87 = rightA_symbol_82;
			DomainType static_A_symbol_82 = valueFactory.typeOf(A_symbol_84);
			LibraryBinaryOperation dynamic_A_symbol_82 = (LibraryBinaryOperation)static_A_symbol_82.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_82 = dynamic_A_symbol_82.evaluate(evaluator, T_Boolean, A_symbol_84, A_symbol_87);
			return A_symbol_82;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'CollectNestedHasOneIterator' invariant.
	 */
	public static class _invariant_CollectNestedHasOneIterator extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_CollectNestedHasOneIterator INSTANCE = new _invariant_CollectNestedHasOneIterator();
	
		/*
		name = 'collectNested' implies iterator->size() = 1
		*/
		public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Value self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final @NonNull ExecutorType T_String = OCLstdlibTables.Types._String;
			final @NonNull ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final @NonNull LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final @NonNull StringValue S_collectN___ = valueFactory.stringValueOf("collectNested");
			final @NonNull ExecutorOperation O_Real__eq_ = OCLstdlibTables.Operations._Real___eq_;
			final @NonNull ExecutorType T_Integer = OCLstdlibTables.Types._Integer;
			final @NonNull ExecutorOperation O_Collection_size = OCLstdlibTables.Operations._Collection__size;
			final @NonNull ExecutorType T_pivot__Variable = PivotTables.Types._Variable;
			final @NonNull DomainCollectionType T_OrderedSet_pivot__Variable_ = standardLibrary.getOrderedSetType(T_pivot__Variable);
			final @NonNull ExecutorProperty P_LoopExp_iterator = PivotTables.Properties._LoopExp__iterator;
			final @NonNull LibraryProperty IP_LoopExp_iterator = P_LoopExp_iterator.getImplementation();
			final @NonNull IntegerValue I_1 = valueFactory.integerValueOf(1);
			
			Value leftA_symbol_88;
			try {
				
				Value A_symbol_89 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_90 = valueFactory.typeOf(A_symbol_89, S_collectN___);
				LibraryBinaryOperation dynamic_A_symbol_90 = (LibraryBinaryOperation)static_A_symbol_90.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_90 = dynamic_A_symbol_90.evaluate(evaluator, T_Boolean, A_symbol_89, S_collectN___);
				leftA_symbol_88 = A_symbol_90;
			} catch (InvalidValueException e) {
				leftA_symbol_88 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_90 = leftA_symbol_88;
			Value rightA_symbol_88;
			try {
				
				Value A_symbol_91 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_92 = valueFactory.typeOf(A_symbol_91);
				LibraryUnaryOperation dynamic_A_symbol_92 = (LibraryUnaryOperation)static_A_symbol_92.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_92 = dynamic_A_symbol_92.evaluate(evaluator, T_Integer, A_symbol_91);
				DomainType static_A_symbol_93 = valueFactory.typeOf(A_symbol_92, I_1);
				LibraryBinaryOperation dynamic_A_symbol_93 = (LibraryBinaryOperation)static_A_symbol_93.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_93 = dynamic_A_symbol_93.evaluate(evaluator, T_Boolean, A_symbol_92, I_1);
				rightA_symbol_88 = A_symbol_93;
			} catch (InvalidValueException e) {
				rightA_symbol_88 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_93 = rightA_symbol_88;
			DomainType static_A_symbol_88 = valueFactory.typeOf(A_symbol_90);
			LibraryBinaryOperation dynamic_A_symbol_88 = (LibraryBinaryOperation)static_A_symbol_88.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_88 = dynamic_A_symbol_88.evaluate(evaluator, T_Boolean, A_symbol_90, A_symbol_93);
			return A_symbol_88;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'CollectNestedTypeIsBag' invariant.
	 */
	public static class _invariant_CollectNestedTypeIsBag extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_CollectNestedTypeIsBag INSTANCE = new _invariant_CollectNestedTypeIsBag();
	
		/*
		name = 'collectNested' implies type.oclIsKindOf(BagType)
		*/
		public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Value self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final @NonNull ExecutorType T_String = OCLstdlibTables.Types._String;
			final @NonNull ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final @NonNull LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final @NonNull StringValue S_collectN___ = valueFactory.stringValueOf("collectNested");
			final @NonNull ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
			final @NonNull ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final @NonNull ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final @NonNull LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final @NonNull Value T_Metaclass_pivot__BagType_ = valueFactory.createTypeValue(PivotTables.Types._BagType);
			
			Value leftA_symbol_94;
			try {
				
				Value A_symbol_95 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_96 = valueFactory.typeOf(A_symbol_95, S_collectN___);
				LibraryBinaryOperation dynamic_A_symbol_96 = (LibraryBinaryOperation)static_A_symbol_96.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_96 = dynamic_A_symbol_96.evaluate(evaluator, T_Boolean, A_symbol_95, S_collectN___);
				leftA_symbol_94 = A_symbol_96;
			} catch (InvalidValueException e) {
				leftA_symbol_94 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_96 = leftA_symbol_94;
			Value rightA_symbol_94;
			try {
				
				Value A_symbol_97 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_98 = valueFactory.typeOf(A_symbol_97);
				LibraryBinaryOperation dynamic_A_symbol_98 = (LibraryBinaryOperation)static_A_symbol_98.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
				Value A_symbol_98 = dynamic_A_symbol_98.evaluate(evaluator, T_Boolean, A_symbol_97, T_Metaclass_pivot__BagType_);
				rightA_symbol_94 = A_symbol_98;
			} catch (InvalidValueException e) {
				rightA_symbol_94 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_98 = rightA_symbol_94;
			DomainType static_A_symbol_94 = valueFactory.typeOf(A_symbol_96);
			LibraryBinaryOperation dynamic_A_symbol_94 = (LibraryBinaryOperation)static_A_symbol_94.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_94 = dynamic_A_symbol_94.evaluate(evaluator, T_Boolean, A_symbol_96, A_symbol_98);
			return A_symbol_94;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'CollectNestedTypeIsBodyType' invariant.
	 */
	public static class _invariant_CollectNestedTypeIsBodyType extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_CollectNestedTypeIsBodyType INSTANCE = new _invariant_CollectNestedTypeIsBodyType();
	
		/*
		name = 'collectNested' implies type = body.type
		*/
		public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Value self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final @NonNull ExecutorType T_String = OCLstdlibTables.Types._String;
			final @NonNull ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final @NonNull LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final @NonNull StringValue S_collectN___ = valueFactory.stringValueOf("collectNested");
			final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
			final @NonNull ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final @NonNull ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final @NonNull LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final @NonNull ExecutorType T_pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final @NonNull ExecutorProperty P_LoopExp_body = PivotTables.Properties._LoopExp__body;
			final @NonNull LibraryProperty IP_LoopExp_body = P_LoopExp_body.getImplementation();
			
			Value leftA_symbol_99;
			try {
				
				Value A_symbol_100 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_101 = valueFactory.typeOf(A_symbol_100, S_collectN___);
				LibraryBinaryOperation dynamic_A_symbol_101 = (LibraryBinaryOperation)static_A_symbol_101.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_101 = dynamic_A_symbol_101.evaluate(evaluator, T_Boolean, A_symbol_100, S_collectN___);
				leftA_symbol_99 = A_symbol_101;
			} catch (InvalidValueException e) {
				leftA_symbol_99 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_101 = leftA_symbol_99;
			Value rightA_symbol_99;
			try {
				
				Value A_symbol_102 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				
				Value A_symbol_103 = IP_LoopExp_body.evaluate(evaluator, T_pivot__OCLExpression, self, P_LoopExp_body);
				
				Value A_symbol_104 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_103, P_TypedElement_type);
				
				DomainType static_A_symbol_105 = valueFactory.typeOf(A_symbol_102, A_symbol_104);
				LibraryBinaryOperation dynamic_A_symbol_105 = (LibraryBinaryOperation)static_A_symbol_105.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_105 = dynamic_A_symbol_105.evaluate(evaluator, T_Boolean, A_symbol_102, A_symbol_104);
				rightA_symbol_99 = A_symbol_105;
			} catch (InvalidValueException e) {
				rightA_symbol_99 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_105 = rightA_symbol_99;
			DomainType static_A_symbol_99 = valueFactory.typeOf(A_symbol_101);
			LibraryBinaryOperation dynamic_A_symbol_99 = (LibraryBinaryOperation)static_A_symbol_99.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_99 = dynamic_A_symbol_99.evaluate(evaluator, T_Boolean, A_symbol_101, A_symbol_105);
			return A_symbol_99;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'CollectTypeIsUnordered' invariant.
	 */
	public static class _invariant_CollectTypeIsUnordered extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_CollectTypeIsUnordered INSTANCE = new _invariant_CollectTypeIsUnordered();
	
		/*
		name = 'collect' implies
	if
	  source.type.oclIsKindOf(SequenceType) or
	  source.type.oclIsKindOf(OrderedSetType)
	then type.oclIsKindOf(SequenceType)
	else type.oclIsKindOf(BagType)
	endif
		*/
		public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Value self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final @NonNull ExecutorType T_String = OCLstdlibTables.Types._String;
			final @NonNull ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final @NonNull LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final @NonNull StringValue S_collect = valueFactory.stringValueOf("collect");
			final @NonNull ExecutorOperation O_Boolean_or = OCLstdlibTables.Operations._Boolean__or;
			final @NonNull ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
			final @NonNull ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final @NonNull ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final @NonNull LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final @NonNull ExecutorType T_pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final @NonNull ExecutorProperty P_CallExp_source = PivotTables.Properties._CallExp__source;
			final @NonNull LibraryProperty IP_CallExp_source = P_CallExp_source.getImplementation();
			final @NonNull Value T_Metaclass_pivot__SequenceType_ = valueFactory.createTypeValue(PivotTables.Types._SequenceType);
			final @NonNull Value T_Metaclass_pivot__OrderedSetType_ = valueFactory.createTypeValue(PivotTables.Types._OrderedSetType);
			final @NonNull Value T_Metaclass_pivot__BagType_ = valueFactory.createTypeValue(PivotTables.Types._BagType);
			
			Value leftA_symbol_106;
			try {
				
				Value A_symbol_107 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_108 = valueFactory.typeOf(A_symbol_107, S_collect);
				LibraryBinaryOperation dynamic_A_symbol_108 = (LibraryBinaryOperation)static_A_symbol_108.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_108 = dynamic_A_symbol_108.evaluate(evaluator, T_Boolean, A_symbol_107, S_collect);
				leftA_symbol_106 = A_symbol_108;
			} catch (InvalidValueException e) {
				leftA_symbol_106 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_108 = leftA_symbol_106;
			Value rightA_symbol_106;
			try {
					Value leftA_symbol_109;
					try {
						
						Value A_symbol_110 = IP_CallExp_source.evaluate(evaluator, T_pivot__OCLExpression, self, P_CallExp_source);
						
						Value A_symbol_111 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_110, P_TypedElement_type);
						
						DomainType static_A_symbol_112 = valueFactory.typeOf(A_symbol_111);
						LibraryBinaryOperation dynamic_A_symbol_112 = (LibraryBinaryOperation)static_A_symbol_112.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Value A_symbol_112 = dynamic_A_symbol_112.evaluate(evaluator, T_Boolean, A_symbol_111, T_Metaclass_pivot__SequenceType_);
						leftA_symbol_109 = A_symbol_112;
					} catch (InvalidValueException e) {
						leftA_symbol_109 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_112 = leftA_symbol_109;
					Value rightA_symbol_109;
					try {
						
						Value A_symbol_113 = IP_CallExp_source.evaluate(evaluator, T_pivot__OCLExpression, self, P_CallExp_source);
						
						Value A_symbol_114 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_113, P_TypedElement_type);
						
						DomainType static_A_symbol_115 = valueFactory.typeOf(A_symbol_114);
						LibraryBinaryOperation dynamic_A_symbol_115 = (LibraryBinaryOperation)static_A_symbol_115.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Value A_symbol_115 = dynamic_A_symbol_115.evaluate(evaluator, T_Boolean, A_symbol_114, T_Metaclass_pivot__OrderedSetType_);
						rightA_symbol_109 = A_symbol_115;
					} catch (InvalidValueException e) {
						rightA_symbol_109 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_115 = rightA_symbol_109;
					DomainType static_A_symbol_109 = valueFactory.typeOf(A_symbol_112);
					LibraryBinaryOperation dynamic_A_symbol_109 = (LibraryBinaryOperation)static_A_symbol_109.lookupImplementation(standardLibrary, O_Boolean_or);
					Value A_symbol_109 = dynamic_A_symbol_109.evaluate(evaluator, T_Boolean, A_symbol_112, A_symbol_115);
				Value A_symbol_116;
				if (A_symbol_109.isTrue()) {
					
					Value A_symbol_117 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
					
					DomainType static_A_symbol_118 = valueFactory.typeOf(A_symbol_117);
					LibraryBinaryOperation dynamic_A_symbol_118 = (LibraryBinaryOperation)static_A_symbol_118.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Value A_symbol_118 = dynamic_A_symbol_118.evaluate(evaluator, T_Boolean, A_symbol_117, T_Metaclass_pivot__SequenceType_);
					A_symbol_116 = A_symbol_118;
				}
				else if (A_symbol_109.isFalse()) {
					
					Value A_symbol_119 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
					
					DomainType static_A_symbol_120 = valueFactory.typeOf(A_symbol_119);
					LibraryBinaryOperation dynamic_A_symbol_120 = (LibraryBinaryOperation)static_A_symbol_120.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Value A_symbol_120 = dynamic_A_symbol_120.evaluate(evaluator, T_Boolean, A_symbol_119, T_Metaclass_pivot__BagType_);
					A_symbol_116 = A_symbol_120;
				}
				else if (A_symbol_109.isNull()) {
					A_symbol_116 = valueFactory.throwInvalidValueException("null if condition");
				}
				else {
					A_symbol_116 = valueFactory.throwInvalidValueException("invalid if condition");
				}
				rightA_symbol_106 = A_symbol_116;
			} catch (InvalidValueException e) {
				rightA_symbol_106 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_116 = rightA_symbol_106;
			DomainType static_A_symbol_106 = valueFactory.typeOf(A_symbol_108);
			LibraryBinaryOperation dynamic_A_symbol_106 = (LibraryBinaryOperation)static_A_symbol_106.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_106 = dynamic_A_symbol_106.evaluate(evaluator, T_Boolean, A_symbol_108, A_symbol_116);
			return A_symbol_106;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'ExistsBodyTypeIsBoolean' invariant.
	 */
	public static class _invariant_ExistsBodyTypeIsBoolean extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_ExistsBodyTypeIsBoolean INSTANCE = new _invariant_ExistsBodyTypeIsBoolean();
	
		/*
		name = 'exists' implies body.type = Boolean
		*/
		public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Value self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final @NonNull ExecutorType T_String = OCLstdlibTables.Types._String;
			final @NonNull ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final @NonNull LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final @NonNull StringValue S_exists = valueFactory.stringValueOf("exists");
			final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
			final @NonNull ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final @NonNull ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final @NonNull LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final @NonNull ExecutorType T_pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final @NonNull ExecutorProperty P_LoopExp_body = PivotTables.Properties._LoopExp__body;
			final @NonNull LibraryProperty IP_LoopExp_body = P_LoopExp_body.getImplementation();
			final @NonNull Value T_Metaclass_Boolean_ = valueFactory.createTypeValue(OCLstdlibTables.Types._Boolean);
			
			Value leftA_symbol_121;
			try {
				
				Value A_symbol_122 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_123 = valueFactory.typeOf(A_symbol_122, S_exists);
				LibraryBinaryOperation dynamic_A_symbol_123 = (LibraryBinaryOperation)static_A_symbol_123.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_123 = dynamic_A_symbol_123.evaluate(evaluator, T_Boolean, A_symbol_122, S_exists);
				leftA_symbol_121 = A_symbol_123;
			} catch (InvalidValueException e) {
				leftA_symbol_121 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_123 = leftA_symbol_121;
			Value rightA_symbol_121;
			try {
				
				Value A_symbol_124 = IP_LoopExp_body.evaluate(evaluator, T_pivot__OCLExpression, self, P_LoopExp_body);
				
				Value A_symbol_125 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_124, P_TypedElement_type);
				
				DomainType static_A_symbol_126 = valueFactory.typeOf(A_symbol_125, T_Metaclass_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_126 = (LibraryBinaryOperation)static_A_symbol_126.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_126 = dynamic_A_symbol_126.evaluate(evaluator, T_Boolean, A_symbol_125, T_Metaclass_Boolean_);
				rightA_symbol_121 = A_symbol_126;
			} catch (InvalidValueException e) {
				rightA_symbol_121 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_126 = rightA_symbol_121;
			DomainType static_A_symbol_121 = valueFactory.typeOf(A_symbol_123);
			LibraryBinaryOperation dynamic_A_symbol_121 = (LibraryBinaryOperation)static_A_symbol_121.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_121 = dynamic_A_symbol_121.evaluate(evaluator, T_Boolean, A_symbol_123, A_symbol_126);
			return A_symbol_121;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'ExistsTypeIsBoolean' invariant.
	 */
	public static class _invariant_ExistsTypeIsBoolean extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_ExistsTypeIsBoolean INSTANCE = new _invariant_ExistsTypeIsBoolean();
	
		/*
		name = 'exists' implies type = Boolean
		*/
		public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Value self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final @NonNull ExecutorType T_String = OCLstdlibTables.Types._String;
			final @NonNull ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final @NonNull LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final @NonNull StringValue S_exists = valueFactory.stringValueOf("exists");
			final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
			final @NonNull ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final @NonNull ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final @NonNull LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final @NonNull Value T_Metaclass_Boolean_ = valueFactory.createTypeValue(OCLstdlibTables.Types._Boolean);
			
			Value leftA_symbol_127;
			try {
				
				Value A_symbol_128 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_129 = valueFactory.typeOf(A_symbol_128, S_exists);
				LibraryBinaryOperation dynamic_A_symbol_129 = (LibraryBinaryOperation)static_A_symbol_129.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_129 = dynamic_A_symbol_129.evaluate(evaluator, T_Boolean, A_symbol_128, S_exists);
				leftA_symbol_127 = A_symbol_129;
			} catch (InvalidValueException e) {
				leftA_symbol_127 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_129 = leftA_symbol_127;
			Value rightA_symbol_127;
			try {
				
				Value A_symbol_130 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_131 = valueFactory.typeOf(A_symbol_130, T_Metaclass_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_131 = (LibraryBinaryOperation)static_A_symbol_131.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_131 = dynamic_A_symbol_131.evaluate(evaluator, T_Boolean, A_symbol_130, T_Metaclass_Boolean_);
				rightA_symbol_127 = A_symbol_131;
			} catch (InvalidValueException e) {
				rightA_symbol_127 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_131 = rightA_symbol_127;
			DomainType static_A_symbol_127 = valueFactory.typeOf(A_symbol_129);
			LibraryBinaryOperation dynamic_A_symbol_127 = (LibraryBinaryOperation)static_A_symbol_127.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_127 = dynamic_A_symbol_127.evaluate(evaluator, T_Boolean, A_symbol_129, A_symbol_131);
			return A_symbol_127;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'ForAllBodyTypeIsBoolean' invariant.
	 */
	public static class _invariant_ForAllBodyTypeIsBoolean extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_ForAllBodyTypeIsBoolean INSTANCE = new _invariant_ForAllBodyTypeIsBoolean();
	
		/*
		name = 'forAll' implies body.type = Boolean
		*/
		public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Value self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final @NonNull ExecutorType T_String = OCLstdlibTables.Types._String;
			final @NonNull ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final @NonNull LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final @NonNull StringValue S_forAll = valueFactory.stringValueOf("forAll");
			final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
			final @NonNull ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final @NonNull ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final @NonNull LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final @NonNull ExecutorType T_pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final @NonNull ExecutorProperty P_LoopExp_body = PivotTables.Properties._LoopExp__body;
			final @NonNull LibraryProperty IP_LoopExp_body = P_LoopExp_body.getImplementation();
			final @NonNull Value T_Metaclass_Boolean_ = valueFactory.createTypeValue(OCLstdlibTables.Types._Boolean);
			
			Value leftA_symbol_132;
			try {
				
				Value A_symbol_133 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_134 = valueFactory.typeOf(A_symbol_133, S_forAll);
				LibraryBinaryOperation dynamic_A_symbol_134 = (LibraryBinaryOperation)static_A_symbol_134.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_134 = dynamic_A_symbol_134.evaluate(evaluator, T_Boolean, A_symbol_133, S_forAll);
				leftA_symbol_132 = A_symbol_134;
			} catch (InvalidValueException e) {
				leftA_symbol_132 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_134 = leftA_symbol_132;
			Value rightA_symbol_132;
			try {
				
				Value A_symbol_135 = IP_LoopExp_body.evaluate(evaluator, T_pivot__OCLExpression, self, P_LoopExp_body);
				
				Value A_symbol_136 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_135, P_TypedElement_type);
				
				DomainType static_A_symbol_137 = valueFactory.typeOf(A_symbol_136, T_Metaclass_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_137 = (LibraryBinaryOperation)static_A_symbol_137.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_137 = dynamic_A_symbol_137.evaluate(evaluator, T_Boolean, A_symbol_136, T_Metaclass_Boolean_);
				rightA_symbol_132 = A_symbol_137;
			} catch (InvalidValueException e) {
				rightA_symbol_132 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_137 = rightA_symbol_132;
			DomainType static_A_symbol_132 = valueFactory.typeOf(A_symbol_134);
			LibraryBinaryOperation dynamic_A_symbol_132 = (LibraryBinaryOperation)static_A_symbol_132.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_132 = dynamic_A_symbol_132.evaluate(evaluator, T_Boolean, A_symbol_134, A_symbol_137);
			return A_symbol_132;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'ForAllTypeIsBoolean' invariant.
	 */
	public static class _invariant_ForAllTypeIsBoolean extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_ForAllTypeIsBoolean INSTANCE = new _invariant_ForAllTypeIsBoolean();
	
		/*
		name = 'forAll' implies type = Boolean
		*/
		public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Value self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final @NonNull ExecutorType T_String = OCLstdlibTables.Types._String;
			final @NonNull ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final @NonNull LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final @NonNull StringValue S_forAll = valueFactory.stringValueOf("forAll");
			final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
			final @NonNull ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final @NonNull ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final @NonNull LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final @NonNull Value T_Metaclass_Boolean_ = valueFactory.createTypeValue(OCLstdlibTables.Types._Boolean);
			
			Value leftA_symbol_138;
			try {
				
				Value A_symbol_139 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_140 = valueFactory.typeOf(A_symbol_139, S_forAll);
				LibraryBinaryOperation dynamic_A_symbol_140 = (LibraryBinaryOperation)static_A_symbol_140.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_140 = dynamic_A_symbol_140.evaluate(evaluator, T_Boolean, A_symbol_139, S_forAll);
				leftA_symbol_138 = A_symbol_140;
			} catch (InvalidValueException e) {
				leftA_symbol_138 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_140 = leftA_symbol_138;
			Value rightA_symbol_138;
			try {
				
				Value A_symbol_141 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_142 = valueFactory.typeOf(A_symbol_141, T_Metaclass_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_142 = (LibraryBinaryOperation)static_A_symbol_142.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_142 = dynamic_A_symbol_142.evaluate(evaluator, T_Boolean, A_symbol_141, T_Metaclass_Boolean_);
				rightA_symbol_138 = A_symbol_142;
			} catch (InvalidValueException e) {
				rightA_symbol_138 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_142 = rightA_symbol_138;
			DomainType static_A_symbol_138 = valueFactory.typeOf(A_symbol_140);
			LibraryBinaryOperation dynamic_A_symbol_138 = (LibraryBinaryOperation)static_A_symbol_138.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_138 = dynamic_A_symbol_138.evaluate(evaluator, T_Boolean, A_symbol_140, A_symbol_142);
			return A_symbol_138;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'IsUniqueHasOneIterator' invariant.
	 */
	public static class _invariant_IsUniqueHasOneIterator extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_IsUniqueHasOneIterator INSTANCE = new _invariant_IsUniqueHasOneIterator();
	
		/*
		name = 'isUnique' implies iterator->size() = 1
		*/
		public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Value self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final @NonNull ExecutorType T_String = OCLstdlibTables.Types._String;
			final @NonNull ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final @NonNull LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final @NonNull StringValue S_isUnique = valueFactory.stringValueOf("isUnique");
			final @NonNull ExecutorOperation O_Real__eq_ = OCLstdlibTables.Operations._Real___eq_;
			final @NonNull ExecutorType T_Integer = OCLstdlibTables.Types._Integer;
			final @NonNull ExecutorOperation O_Collection_size = OCLstdlibTables.Operations._Collection__size;
			final @NonNull ExecutorType T_pivot__Variable = PivotTables.Types._Variable;
			final @NonNull DomainCollectionType T_OrderedSet_pivot__Variable_ = standardLibrary.getOrderedSetType(T_pivot__Variable);
			final @NonNull ExecutorProperty P_LoopExp_iterator = PivotTables.Properties._LoopExp__iterator;
			final @NonNull LibraryProperty IP_LoopExp_iterator = P_LoopExp_iterator.getImplementation();
			final @NonNull IntegerValue I_1 = valueFactory.integerValueOf(1);
			
			Value leftA_symbol_143;
			try {
				
				Value A_symbol_144 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_145 = valueFactory.typeOf(A_symbol_144, S_isUnique);
				LibraryBinaryOperation dynamic_A_symbol_145 = (LibraryBinaryOperation)static_A_symbol_145.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_145 = dynamic_A_symbol_145.evaluate(evaluator, T_Boolean, A_symbol_144, S_isUnique);
				leftA_symbol_143 = A_symbol_145;
			} catch (InvalidValueException e) {
				leftA_symbol_143 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_145 = leftA_symbol_143;
			Value rightA_symbol_143;
			try {
				
				Value A_symbol_146 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_147 = valueFactory.typeOf(A_symbol_146);
				LibraryUnaryOperation dynamic_A_symbol_147 = (LibraryUnaryOperation)static_A_symbol_147.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_147 = dynamic_A_symbol_147.evaluate(evaluator, T_Integer, A_symbol_146);
				DomainType static_A_symbol_148 = valueFactory.typeOf(A_symbol_147, I_1);
				LibraryBinaryOperation dynamic_A_symbol_148 = (LibraryBinaryOperation)static_A_symbol_148.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_148 = dynamic_A_symbol_148.evaluate(evaluator, T_Boolean, A_symbol_147, I_1);
				rightA_symbol_143 = A_symbol_148;
			} catch (InvalidValueException e) {
				rightA_symbol_143 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_148 = rightA_symbol_143;
			DomainType static_A_symbol_143 = valueFactory.typeOf(A_symbol_145);
			LibraryBinaryOperation dynamic_A_symbol_143 = (LibraryBinaryOperation)static_A_symbol_143.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_143 = dynamic_A_symbol_143.evaluate(evaluator, T_Boolean, A_symbol_145, A_symbol_148);
			return A_symbol_143;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'IsUniqueTypeIsBoolean' invariant.
	 */
	public static class _invariant_IsUniqueTypeIsBoolean extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_IsUniqueTypeIsBoolean INSTANCE = new _invariant_IsUniqueTypeIsBoolean();
	
		/*
		name = 'isUnique' implies type = Boolean
		*/
		public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Value self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final @NonNull ExecutorType T_String = OCLstdlibTables.Types._String;
			final @NonNull ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final @NonNull LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final @NonNull StringValue S_isUnique = valueFactory.stringValueOf("isUnique");
			final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
			final @NonNull ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final @NonNull ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final @NonNull LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final @NonNull Value T_Metaclass_Boolean_ = valueFactory.createTypeValue(OCLstdlibTables.Types._Boolean);
			
			Value leftA_symbol_149;
			try {
				
				Value A_symbol_150 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_151 = valueFactory.typeOf(A_symbol_150, S_isUnique);
				LibraryBinaryOperation dynamic_A_symbol_151 = (LibraryBinaryOperation)static_A_symbol_151.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_151 = dynamic_A_symbol_151.evaluate(evaluator, T_Boolean, A_symbol_150, S_isUnique);
				leftA_symbol_149 = A_symbol_151;
			} catch (InvalidValueException e) {
				leftA_symbol_149 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_151 = leftA_symbol_149;
			Value rightA_symbol_149;
			try {
				
				Value A_symbol_152 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_153 = valueFactory.typeOf(A_symbol_152, T_Metaclass_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_153 = (LibraryBinaryOperation)static_A_symbol_153.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_153 = dynamic_A_symbol_153.evaluate(evaluator, T_Boolean, A_symbol_152, T_Metaclass_Boolean_);
				rightA_symbol_149 = A_symbol_153;
			} catch (InvalidValueException e) {
				rightA_symbol_149 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_153 = rightA_symbol_149;
			DomainType static_A_symbol_149 = valueFactory.typeOf(A_symbol_151);
			LibraryBinaryOperation dynamic_A_symbol_149 = (LibraryBinaryOperation)static_A_symbol_149.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_149 = dynamic_A_symbol_149.evaluate(evaluator, T_Boolean, A_symbol_151, A_symbol_153);
			return A_symbol_149;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'IteratorTypeIsSourceElementType' invariant.
	 */
	public static class _invariant_IteratorTypeIsSourceElementType extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_IteratorTypeIsSourceElementType INSTANCE = new _invariant_IteratorTypeIsSourceElementType();
	
		/*
		self.iterator->forAll(type =
	  source.type.oclAsType(CollectionType).elementType)
		*/
		public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Value self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Collection_forAll = OCLstdlibTables.Operations._Collection__1_forAll;
			final @NonNull ExecutorType T_pivot__Variable = PivotTables.Types._Variable;
			final @NonNull DomainCollectionType T_OrderedSet_pivot__Variable_ = standardLibrary.getOrderedSetType(T_pivot__Variable);
			final @NonNull ExecutorProperty P_LoopExp_iterator = PivotTables.Properties._LoopExp__iterator;
			final @NonNull LibraryProperty IP_LoopExp_iterator = P_LoopExp_iterator.getImplementation();
			final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
			final @NonNull ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final @NonNull ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final @NonNull LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final @NonNull ExecutorProperty P_CollectionType_elementType = PivotTables.Properties._CollectionType__elementType;
			final @NonNull LibraryProperty IP_CollectionType_elementType = P_CollectionType_elementType.getImplementation();
			final @NonNull ExecutorType T_pivot__CollectionType = PivotTables.Types._CollectionType;
			final @NonNull ExecutorOperation O_OclAny_oclAsType = OCLstdlibTables.Operations._OclAny__oclAsType;
			final @NonNull ExecutorType T_pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final @NonNull ExecutorProperty P_CallExp_source = PivotTables.Properties._CallExp__source;
			final @NonNull LibraryProperty IP_CallExp_source = P_CallExp_source.getImplementation();
			final @NonNull Value T_Metaclass_pivot__CollectionType_ = valueFactory.createTypeValue(PivotTables.Types._CollectionType);
			
			
			Value A_symbol_154 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_pivot__Variable_, self, P_LoopExp_iterator);
			
			
			/** 
			 * Implementation of the iterator body.
			 */
			AbstractBinaryOperation body_A_symbol_155 = new AbstractBinaryOperation()
			{
			/*
			type = source.type.oclAsType(CollectionType).elementType
			*/
				public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, @NonNull Value sourceValue, @NonNull Value iterator1) throws InvalidValueException {
					final @NonNull Value V_1_ = iterator1;	// iterator: 1_
					
					Value A_symbol_156 = IP_TypedElement_type.evaluate(evaluator, T_Type, V_1_, P_TypedElement_type);
					
					
					Value A_symbol_157 = IP_CallExp_source.evaluate(evaluator, T_pivot__OCLExpression, self, P_CallExp_source);
					
					Value A_symbol_158 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_157, P_TypedElement_type);
					
					DomainType static_A_symbol_159 = valueFactory.typeOf(A_symbol_158);
					LibraryBinaryOperation dynamic_A_symbol_159 = (LibraryBinaryOperation)static_A_symbol_159.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
					Value A_symbol_159 = dynamic_A_symbol_159.evaluate(evaluator, T_pivot__CollectionType, A_symbol_158, T_Metaclass_pivot__CollectionType_);
					Value A_symbol_160 = IP_CollectionType_elementType.evaluate(evaluator, T_Type, A_symbol_159, P_CollectionType_elementType);
					
					DomainType static_A_symbol_161 = valueFactory.typeOf(A_symbol_156, A_symbol_160);
					LibraryBinaryOperation dynamic_A_symbol_161 = (LibraryBinaryOperation)static_A_symbol_161.lookupImplementation(standardLibrary, O_OclAny__eq_);
					Value A_symbol_161 = dynamic_A_symbol_161.evaluate(evaluator, T_Boolean, A_symbol_156, A_symbol_160);
					return A_symbol_161;
				}
			};
			DomainType static_A_symbol_155 = A_symbol_154.getType();
			LibraryIteration dynamic_A_symbol_155 = (LibraryIteration)static_A_symbol_155.lookupImplementation(standardLibrary, O_Collection_forAll);
			Value acc_A_symbol_155 = dynamic_A_symbol_155.createAccumulatorValue(evaluator, T_Boolean, T_Boolean);
			ExecutorSingleIterationManager manager_A_symbol_155 = new ExecutorSingleIterationManager(evaluator, T_Boolean, body_A_symbol_155, (CollectionValue)A_symbol_154, acc_A_symbol_155);
			Value A_symbol_155 = dynamic_A_symbol_155.evaluateIteration(manager_A_symbol_155);
			return A_symbol_155;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'OneBodyTypeIsBoolean' invariant.
	 */
	public static class _invariant_OneBodyTypeIsBoolean extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_OneBodyTypeIsBoolean INSTANCE = new _invariant_OneBodyTypeIsBoolean();
	
		/*
		name = 'one' implies body.type = Boolean
		*/
		public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Value self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final @NonNull ExecutorType T_String = OCLstdlibTables.Types._String;
			final @NonNull ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final @NonNull LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final @NonNull StringValue S_one = valueFactory.stringValueOf("one");
			final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
			final @NonNull ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final @NonNull ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final @NonNull LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final @NonNull ExecutorType T_pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final @NonNull ExecutorProperty P_LoopExp_body = PivotTables.Properties._LoopExp__body;
			final @NonNull LibraryProperty IP_LoopExp_body = P_LoopExp_body.getImplementation();
			final @NonNull Value T_Metaclass_Boolean_ = valueFactory.createTypeValue(OCLstdlibTables.Types._Boolean);
			
			Value leftA_symbol_162;
			try {
				
				Value A_symbol_163 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_164 = valueFactory.typeOf(A_symbol_163, S_one);
				LibraryBinaryOperation dynamic_A_symbol_164 = (LibraryBinaryOperation)static_A_symbol_164.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_164 = dynamic_A_symbol_164.evaluate(evaluator, T_Boolean, A_symbol_163, S_one);
				leftA_symbol_162 = A_symbol_164;
			} catch (InvalidValueException e) {
				leftA_symbol_162 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_164 = leftA_symbol_162;
			Value rightA_symbol_162;
			try {
				
				Value A_symbol_165 = IP_LoopExp_body.evaluate(evaluator, T_pivot__OCLExpression, self, P_LoopExp_body);
				
				Value A_symbol_166 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_165, P_TypedElement_type);
				
				DomainType static_A_symbol_167 = valueFactory.typeOf(A_symbol_166, T_Metaclass_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_167 = (LibraryBinaryOperation)static_A_symbol_167.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_167 = dynamic_A_symbol_167.evaluate(evaluator, T_Boolean, A_symbol_166, T_Metaclass_Boolean_);
				rightA_symbol_162 = A_symbol_167;
			} catch (InvalidValueException e) {
				rightA_symbol_162 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_167 = rightA_symbol_162;
			DomainType static_A_symbol_162 = valueFactory.typeOf(A_symbol_164);
			LibraryBinaryOperation dynamic_A_symbol_162 = (LibraryBinaryOperation)static_A_symbol_162.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_162 = dynamic_A_symbol_162.evaluate(evaluator, T_Boolean, A_symbol_164, A_symbol_167);
			return A_symbol_162;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'OneHasOneIterator' invariant.
	 */
	public static class _invariant_OneHasOneIterator extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_OneHasOneIterator INSTANCE = new _invariant_OneHasOneIterator();
	
		/*
		name = 'one' implies iterator->size() = 1
		*/
		public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Value self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final @NonNull ExecutorType T_String = OCLstdlibTables.Types._String;
			final @NonNull ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final @NonNull LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final @NonNull StringValue S_one = valueFactory.stringValueOf("one");
			final @NonNull ExecutorOperation O_Real__eq_ = OCLstdlibTables.Operations._Real___eq_;
			final @NonNull ExecutorType T_Integer = OCLstdlibTables.Types._Integer;
			final @NonNull ExecutorOperation O_Collection_size = OCLstdlibTables.Operations._Collection__size;
			final @NonNull ExecutorType T_pivot__Variable = PivotTables.Types._Variable;
			final @NonNull DomainCollectionType T_OrderedSet_pivot__Variable_ = standardLibrary.getOrderedSetType(T_pivot__Variable);
			final @NonNull ExecutorProperty P_LoopExp_iterator = PivotTables.Properties._LoopExp__iterator;
			final @NonNull LibraryProperty IP_LoopExp_iterator = P_LoopExp_iterator.getImplementation();
			final @NonNull IntegerValue I_1 = valueFactory.integerValueOf(1);
			
			Value leftA_symbol_168;
			try {
				
				Value A_symbol_169 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_170 = valueFactory.typeOf(A_symbol_169, S_one);
				LibraryBinaryOperation dynamic_A_symbol_170 = (LibraryBinaryOperation)static_A_symbol_170.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_170 = dynamic_A_symbol_170.evaluate(evaluator, T_Boolean, A_symbol_169, S_one);
				leftA_symbol_168 = A_symbol_170;
			} catch (InvalidValueException e) {
				leftA_symbol_168 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_170 = leftA_symbol_168;
			Value rightA_symbol_168;
			try {
				
				Value A_symbol_171 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_172 = valueFactory.typeOf(A_symbol_171);
				LibraryUnaryOperation dynamic_A_symbol_172 = (LibraryUnaryOperation)static_A_symbol_172.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_172 = dynamic_A_symbol_172.evaluate(evaluator, T_Integer, A_symbol_171);
				DomainType static_A_symbol_173 = valueFactory.typeOf(A_symbol_172, I_1);
				LibraryBinaryOperation dynamic_A_symbol_173 = (LibraryBinaryOperation)static_A_symbol_173.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_173 = dynamic_A_symbol_173.evaluate(evaluator, T_Boolean, A_symbol_172, I_1);
				rightA_symbol_168 = A_symbol_173;
			} catch (InvalidValueException e) {
				rightA_symbol_168 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_173 = rightA_symbol_168;
			DomainType static_A_symbol_168 = valueFactory.typeOf(A_symbol_170);
			LibraryBinaryOperation dynamic_A_symbol_168 = (LibraryBinaryOperation)static_A_symbol_168.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_168 = dynamic_A_symbol_168.evaluate(evaluator, T_Boolean, A_symbol_170, A_symbol_173);
			return A_symbol_168;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'OneTypeIsBoolean' invariant.
	 */
	public static class _invariant_OneTypeIsBoolean extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_OneTypeIsBoolean INSTANCE = new _invariant_OneTypeIsBoolean();
	
		/*
		name = 'one' implies type = Boolean
		*/
		public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Value self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final @NonNull ExecutorType T_String = OCLstdlibTables.Types._String;
			final @NonNull ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final @NonNull LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final @NonNull StringValue S_one = valueFactory.stringValueOf("one");
			final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
			final @NonNull ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final @NonNull ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final @NonNull LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final @NonNull Value T_Metaclass_Boolean_ = valueFactory.createTypeValue(OCLstdlibTables.Types._Boolean);
			
			Value leftA_symbol_174;
			try {
				
				Value A_symbol_175 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_176 = valueFactory.typeOf(A_symbol_175, S_one);
				LibraryBinaryOperation dynamic_A_symbol_176 = (LibraryBinaryOperation)static_A_symbol_176.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_176 = dynamic_A_symbol_176.evaluate(evaluator, T_Boolean, A_symbol_175, S_one);
				leftA_symbol_174 = A_symbol_176;
			} catch (InvalidValueException e) {
				leftA_symbol_174 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_176 = leftA_symbol_174;
			Value rightA_symbol_174;
			try {
				
				Value A_symbol_177 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_178 = valueFactory.typeOf(A_symbol_177, T_Metaclass_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_178 = (LibraryBinaryOperation)static_A_symbol_178.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_178 = dynamic_A_symbol_178.evaluate(evaluator, T_Boolean, A_symbol_177, T_Metaclass_Boolean_);
				rightA_symbol_174 = A_symbol_178;
			} catch (InvalidValueException e) {
				rightA_symbol_174 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_178 = rightA_symbol_174;
			DomainType static_A_symbol_174 = valueFactory.typeOf(A_symbol_176);
			LibraryBinaryOperation dynamic_A_symbol_174 = (LibraryBinaryOperation)static_A_symbol_174.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_174 = dynamic_A_symbol_174.evaluate(evaluator, T_Boolean, A_symbol_176, A_symbol_178);
			return A_symbol_174;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'RejectOrSelectHasOneIterator' invariant.
	 */
	public static class _invariant_RejectOrSelectHasOneIterator extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_RejectOrSelectHasOneIterator INSTANCE = new _invariant_RejectOrSelectHasOneIterator();
	
		/*
		name = 'reject' or name = 'select' implies iterator->size() = 1
		*/
		public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Value self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final @NonNull ExecutorOperation O_Boolean_or = OCLstdlibTables.Operations._Boolean__or;
			final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final @NonNull ExecutorType T_String = OCLstdlibTables.Types._String;
			final @NonNull ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final @NonNull LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final @NonNull StringValue S_reject = valueFactory.stringValueOf("reject");
			final @NonNull StringValue S_select = valueFactory.stringValueOf("select");
			final @NonNull ExecutorOperation O_Real__eq_ = OCLstdlibTables.Operations._Real___eq_;
			final @NonNull ExecutorType T_Integer = OCLstdlibTables.Types._Integer;
			final @NonNull ExecutorOperation O_Collection_size = OCLstdlibTables.Operations._Collection__size;
			final @NonNull ExecutorType T_pivot__Variable = PivotTables.Types._Variable;
			final @NonNull DomainCollectionType T_OrderedSet_pivot__Variable_ = standardLibrary.getOrderedSetType(T_pivot__Variable);
			final @NonNull ExecutorProperty P_LoopExp_iterator = PivotTables.Properties._LoopExp__iterator;
			final @NonNull LibraryProperty IP_LoopExp_iterator = P_LoopExp_iterator.getImplementation();
			final @NonNull IntegerValue I_1 = valueFactory.integerValueOf(1);
			
			Value leftA_symbol_179;
			try {
				Value leftA_symbol_180;
				try {
					
					Value A_symbol_181 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
					
					DomainType static_A_symbol_182 = valueFactory.typeOf(A_symbol_181, S_reject);
					LibraryBinaryOperation dynamic_A_symbol_182 = (LibraryBinaryOperation)static_A_symbol_182.lookupImplementation(standardLibrary, O_String__eq_);
					Value A_symbol_182 = dynamic_A_symbol_182.evaluate(evaluator, T_Boolean, A_symbol_181, S_reject);
					leftA_symbol_180 = A_symbol_182;
				} catch (InvalidValueException e) {
					leftA_symbol_180 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_182 = leftA_symbol_180;
				Value rightA_symbol_180;
				try {
					
					Value A_symbol_183 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
					
					DomainType static_A_symbol_184 = valueFactory.typeOf(A_symbol_183, S_select);
					LibraryBinaryOperation dynamic_A_symbol_184 = (LibraryBinaryOperation)static_A_symbol_184.lookupImplementation(standardLibrary, O_String__eq_);
					Value A_symbol_184 = dynamic_A_symbol_184.evaluate(evaluator, T_Boolean, A_symbol_183, S_select);
					rightA_symbol_180 = A_symbol_184;
				} catch (InvalidValueException e) {
					rightA_symbol_180 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_184 = rightA_symbol_180;
				DomainType static_A_symbol_180 = valueFactory.typeOf(A_symbol_182);
				LibraryBinaryOperation dynamic_A_symbol_180 = (LibraryBinaryOperation)static_A_symbol_180.lookupImplementation(standardLibrary, O_Boolean_or);
				Value A_symbol_180 = dynamic_A_symbol_180.evaluate(evaluator, T_Boolean, A_symbol_182, A_symbol_184);
				leftA_symbol_179 = A_symbol_180;
			} catch (InvalidValueException e) {
				leftA_symbol_179 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_180 = leftA_symbol_179;
			Value rightA_symbol_179;
			try {
				
				Value A_symbol_185 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_186 = valueFactory.typeOf(A_symbol_185);
				LibraryUnaryOperation dynamic_A_symbol_186 = (LibraryUnaryOperation)static_A_symbol_186.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_186 = dynamic_A_symbol_186.evaluate(evaluator, T_Integer, A_symbol_185);
				DomainType static_A_symbol_187 = valueFactory.typeOf(A_symbol_186, I_1);
				LibraryBinaryOperation dynamic_A_symbol_187 = (LibraryBinaryOperation)static_A_symbol_187.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_187 = dynamic_A_symbol_187.evaluate(evaluator, T_Boolean, A_symbol_186, I_1);
				rightA_symbol_179 = A_symbol_187;
			} catch (InvalidValueException e) {
				rightA_symbol_179 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_187 = rightA_symbol_179;
			DomainType static_A_symbol_179 = valueFactory.typeOf(A_symbol_180);
			LibraryBinaryOperation dynamic_A_symbol_179 = (LibraryBinaryOperation)static_A_symbol_179.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_179 = dynamic_A_symbol_179.evaluate(evaluator, T_Boolean, A_symbol_180, A_symbol_187);
			return A_symbol_179;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'RejectOrSelectTypeIsBoolean' invariant.
	 */
	public static class _invariant_RejectOrSelectTypeIsBoolean extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_RejectOrSelectTypeIsBoolean INSTANCE = new _invariant_RejectOrSelectTypeIsBoolean();
	
		/*
		name = 'reject' or name = 'select' implies type = Boolean
		*/
		public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Value self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final @NonNull ExecutorOperation O_Boolean_or = OCLstdlibTables.Operations._Boolean__or;
			final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final @NonNull ExecutorType T_String = OCLstdlibTables.Types._String;
			final @NonNull ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final @NonNull LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final @NonNull StringValue S_reject = valueFactory.stringValueOf("reject");
			final @NonNull StringValue S_select = valueFactory.stringValueOf("select");
			final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
			final @NonNull ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final @NonNull ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final @NonNull LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final @NonNull Value T_Metaclass_Boolean_ = valueFactory.createTypeValue(OCLstdlibTables.Types._Boolean);
			
			Value leftA_symbol_188;
			try {
				Value leftA_symbol_189;
				try {
					
					Value A_symbol_190 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
					
					DomainType static_A_symbol_191 = valueFactory.typeOf(A_symbol_190, S_reject);
					LibraryBinaryOperation dynamic_A_symbol_191 = (LibraryBinaryOperation)static_A_symbol_191.lookupImplementation(standardLibrary, O_String__eq_);
					Value A_symbol_191 = dynamic_A_symbol_191.evaluate(evaluator, T_Boolean, A_symbol_190, S_reject);
					leftA_symbol_189 = A_symbol_191;
				} catch (InvalidValueException e) {
					leftA_symbol_189 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_191 = leftA_symbol_189;
				Value rightA_symbol_189;
				try {
					
					Value A_symbol_192 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
					
					DomainType static_A_symbol_193 = valueFactory.typeOf(A_symbol_192, S_select);
					LibraryBinaryOperation dynamic_A_symbol_193 = (LibraryBinaryOperation)static_A_symbol_193.lookupImplementation(standardLibrary, O_String__eq_);
					Value A_symbol_193 = dynamic_A_symbol_193.evaluate(evaluator, T_Boolean, A_symbol_192, S_select);
					rightA_symbol_189 = A_symbol_193;
				} catch (InvalidValueException e) {
					rightA_symbol_189 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_193 = rightA_symbol_189;
				DomainType static_A_symbol_189 = valueFactory.typeOf(A_symbol_191);
				LibraryBinaryOperation dynamic_A_symbol_189 = (LibraryBinaryOperation)static_A_symbol_189.lookupImplementation(standardLibrary, O_Boolean_or);
				Value A_symbol_189 = dynamic_A_symbol_189.evaluate(evaluator, T_Boolean, A_symbol_191, A_symbol_193);
				leftA_symbol_188 = A_symbol_189;
			} catch (InvalidValueException e) {
				leftA_symbol_188 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_189 = leftA_symbol_188;
			Value rightA_symbol_188;
			try {
				
				Value A_symbol_194 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_195 = valueFactory.typeOf(A_symbol_194, T_Metaclass_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_195 = (LibraryBinaryOperation)static_A_symbol_195.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_195 = dynamic_A_symbol_195.evaluate(evaluator, T_Boolean, A_symbol_194, T_Metaclass_Boolean_);
				rightA_symbol_188 = A_symbol_195;
			} catch (InvalidValueException e) {
				rightA_symbol_188 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_195 = rightA_symbol_188;
			DomainType static_A_symbol_188 = valueFactory.typeOf(A_symbol_189);
			LibraryBinaryOperation dynamic_A_symbol_188 = (LibraryBinaryOperation)static_A_symbol_188.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_188 = dynamic_A_symbol_188.evaluate(evaluator, T_Boolean, A_symbol_189, A_symbol_195);
			return A_symbol_188;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'RejectOrSelectTypeIsSourceType' invariant.
	 */
	public static class _invariant_RejectOrSelectTypeIsSourceType extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_RejectOrSelectTypeIsSourceType INSTANCE = new _invariant_RejectOrSelectTypeIsSourceType();
	
		/*
		name = 'reject' or name = 'select' implies type = source.type
		*/
		public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Value self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final @NonNull ExecutorOperation O_Boolean_or = OCLstdlibTables.Operations._Boolean__or;
			final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final @NonNull ExecutorType T_String = OCLstdlibTables.Types._String;
			final @NonNull ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final @NonNull LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final @NonNull StringValue S_reject = valueFactory.stringValueOf("reject");
			final @NonNull StringValue S_select = valueFactory.stringValueOf("select");
			final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
			final @NonNull ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final @NonNull ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final @NonNull LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final @NonNull ExecutorType T_pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final @NonNull ExecutorProperty P_CallExp_source = PivotTables.Properties._CallExp__source;
			final @NonNull LibraryProperty IP_CallExp_source = P_CallExp_source.getImplementation();
			
			Value leftA_symbol_196;
			try {
				Value leftA_symbol_197;
				try {
					
					Value A_symbol_198 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
					
					DomainType static_A_symbol_199 = valueFactory.typeOf(A_symbol_198, S_reject);
					LibraryBinaryOperation dynamic_A_symbol_199 = (LibraryBinaryOperation)static_A_symbol_199.lookupImplementation(standardLibrary, O_String__eq_);
					Value A_symbol_199 = dynamic_A_symbol_199.evaluate(evaluator, T_Boolean, A_symbol_198, S_reject);
					leftA_symbol_197 = A_symbol_199;
				} catch (InvalidValueException e) {
					leftA_symbol_197 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_199 = leftA_symbol_197;
				Value rightA_symbol_197;
				try {
					
					Value A_symbol_200 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
					
					DomainType static_A_symbol_201 = valueFactory.typeOf(A_symbol_200, S_select);
					LibraryBinaryOperation dynamic_A_symbol_201 = (LibraryBinaryOperation)static_A_symbol_201.lookupImplementation(standardLibrary, O_String__eq_);
					Value A_symbol_201 = dynamic_A_symbol_201.evaluate(evaluator, T_Boolean, A_symbol_200, S_select);
					rightA_symbol_197 = A_symbol_201;
				} catch (InvalidValueException e) {
					rightA_symbol_197 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_201 = rightA_symbol_197;
				DomainType static_A_symbol_197 = valueFactory.typeOf(A_symbol_199);
				LibraryBinaryOperation dynamic_A_symbol_197 = (LibraryBinaryOperation)static_A_symbol_197.lookupImplementation(standardLibrary, O_Boolean_or);
				Value A_symbol_197 = dynamic_A_symbol_197.evaluate(evaluator, T_Boolean, A_symbol_199, A_symbol_201);
				leftA_symbol_196 = A_symbol_197;
			} catch (InvalidValueException e) {
				leftA_symbol_196 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_197 = leftA_symbol_196;
			Value rightA_symbol_196;
			try {
				
				Value A_symbol_202 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				
				Value A_symbol_203 = IP_CallExp_source.evaluate(evaluator, T_pivot__OCLExpression, self, P_CallExp_source);
				
				Value A_symbol_204 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_203, P_TypedElement_type);
				
				DomainType static_A_symbol_205 = valueFactory.typeOf(A_symbol_202, A_symbol_204);
				LibraryBinaryOperation dynamic_A_symbol_205 = (LibraryBinaryOperation)static_A_symbol_205.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_205 = dynamic_A_symbol_205.evaluate(evaluator, T_Boolean, A_symbol_202, A_symbol_204);
				rightA_symbol_196 = A_symbol_205;
			} catch (InvalidValueException e) {
				rightA_symbol_196 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_205 = rightA_symbol_196;
			DomainType static_A_symbol_196 = valueFactory.typeOf(A_symbol_197);
			LibraryBinaryOperation dynamic_A_symbol_196 = (LibraryBinaryOperation)static_A_symbol_196.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_196 = dynamic_A_symbol_196.evaluate(evaluator, T_Boolean, A_symbol_197, A_symbol_205);
			return A_symbol_196;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'SortedByElementTypeIsSourceElementType' invariant.
	 */
	public static class _invariant_SortedByElementTypeIsSourceElementType extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_SortedByElementTypeIsSourceElementType INSTANCE = new _invariant_SortedByElementTypeIsSourceElementType();
	
		/*
		name = 'sortedBy' implies
	type.oclAsType(CollectionType).elementType =
	body.type.oclAsType(CollectionType).elementType
		*/
		public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Value self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final @NonNull ExecutorType T_String = OCLstdlibTables.Types._String;
			final @NonNull ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final @NonNull LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final @NonNull StringValue S_sortedBy = valueFactory.stringValueOf("sortedBy");
			final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
			final @NonNull ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final @NonNull ExecutorProperty P_CollectionType_elementType = PivotTables.Properties._CollectionType__elementType;
			final @NonNull LibraryProperty IP_CollectionType_elementType = P_CollectionType_elementType.getImplementation();
			final @NonNull ExecutorType T_pivot__CollectionType = PivotTables.Types._CollectionType;
			final @NonNull ExecutorOperation O_OclAny_oclAsType = OCLstdlibTables.Operations._OclAny__oclAsType;
			final @NonNull ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final @NonNull LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final @NonNull Value T_Metaclass_pivot__CollectionType_ = valueFactory.createTypeValue(PivotTables.Types._CollectionType);
			final @NonNull ExecutorType T_pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final @NonNull ExecutorProperty P_LoopExp_body = PivotTables.Properties._LoopExp__body;
			final @NonNull LibraryProperty IP_LoopExp_body = P_LoopExp_body.getImplementation();
			
			Value leftA_symbol_206;
			try {
				
				Value A_symbol_207 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_208 = valueFactory.typeOf(A_symbol_207, S_sortedBy);
				LibraryBinaryOperation dynamic_A_symbol_208 = (LibraryBinaryOperation)static_A_symbol_208.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_208 = dynamic_A_symbol_208.evaluate(evaluator, T_Boolean, A_symbol_207, S_sortedBy);
				leftA_symbol_206 = A_symbol_208;
			} catch (InvalidValueException e) {
				leftA_symbol_206 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_208 = leftA_symbol_206;
			Value rightA_symbol_206;
			try {
				
				Value A_symbol_209 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_210 = valueFactory.typeOf(A_symbol_209);
				LibraryBinaryOperation dynamic_A_symbol_210 = (LibraryBinaryOperation)static_A_symbol_210.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_210 = dynamic_A_symbol_210.evaluate(evaluator, T_pivot__CollectionType, A_symbol_209, T_Metaclass_pivot__CollectionType_);
				Value A_symbol_211 = IP_CollectionType_elementType.evaluate(evaluator, T_Type, A_symbol_210, P_CollectionType_elementType);
				
				
				Value A_symbol_212 = IP_LoopExp_body.evaluate(evaluator, T_pivot__OCLExpression, self, P_LoopExp_body);
				
				Value A_symbol_213 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_212, P_TypedElement_type);
				
				DomainType static_A_symbol_214 = valueFactory.typeOf(A_symbol_213);
				LibraryBinaryOperation dynamic_A_symbol_214 = (LibraryBinaryOperation)static_A_symbol_214.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_214 = dynamic_A_symbol_214.evaluate(evaluator, T_pivot__CollectionType, A_symbol_213, T_Metaclass_pivot__CollectionType_);
				Value A_symbol_215 = IP_CollectionType_elementType.evaluate(evaluator, T_Type, A_symbol_214, P_CollectionType_elementType);
				
				DomainType static_A_symbol_216 = valueFactory.typeOf(A_symbol_211, A_symbol_215);
				LibraryBinaryOperation dynamic_A_symbol_216 = (LibraryBinaryOperation)static_A_symbol_216.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_216 = dynamic_A_symbol_216.evaluate(evaluator, T_Boolean, A_symbol_211, A_symbol_215);
				rightA_symbol_206 = A_symbol_216;
			} catch (InvalidValueException e) {
				rightA_symbol_206 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_216 = rightA_symbol_206;
			DomainType static_A_symbol_206 = valueFactory.typeOf(A_symbol_208);
			LibraryBinaryOperation dynamic_A_symbol_206 = (LibraryBinaryOperation)static_A_symbol_206.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_206 = dynamic_A_symbol_206.evaluate(evaluator, T_Boolean, A_symbol_208, A_symbol_216);
			return A_symbol_206;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'SortedByHasOneIterator' invariant.
	 */
	public static class _invariant_SortedByHasOneIterator extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_SortedByHasOneIterator INSTANCE = new _invariant_SortedByHasOneIterator();
	
		/*
		name = 'sortedBy' implies iterator->size() = 1
		*/
		public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Value self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final @NonNull ExecutorType T_String = OCLstdlibTables.Types._String;
			final @NonNull ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final @NonNull LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final @NonNull StringValue S_sortedBy = valueFactory.stringValueOf("sortedBy");
			final @NonNull ExecutorOperation O_Real__eq_ = OCLstdlibTables.Operations._Real___eq_;
			final @NonNull ExecutorType T_Integer = OCLstdlibTables.Types._Integer;
			final @NonNull ExecutorOperation O_Collection_size = OCLstdlibTables.Operations._Collection__size;
			final @NonNull ExecutorType T_pivot__Variable = PivotTables.Types._Variable;
			final @NonNull DomainCollectionType T_OrderedSet_pivot__Variable_ = standardLibrary.getOrderedSetType(T_pivot__Variable);
			final @NonNull ExecutorProperty P_LoopExp_iterator = PivotTables.Properties._LoopExp__iterator;
			final @NonNull LibraryProperty IP_LoopExp_iterator = P_LoopExp_iterator.getImplementation();
			final @NonNull IntegerValue I_1 = valueFactory.integerValueOf(1);
			
			Value leftA_symbol_217;
			try {
				
				Value A_symbol_218 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_219 = valueFactory.typeOf(A_symbol_218, S_sortedBy);
				LibraryBinaryOperation dynamic_A_symbol_219 = (LibraryBinaryOperation)static_A_symbol_219.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_219 = dynamic_A_symbol_219.evaluate(evaluator, T_Boolean, A_symbol_218, S_sortedBy);
				leftA_symbol_217 = A_symbol_219;
			} catch (InvalidValueException e) {
				leftA_symbol_217 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_219 = leftA_symbol_217;
			Value rightA_symbol_217;
			try {
				
				Value A_symbol_220 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_221 = valueFactory.typeOf(A_symbol_220);
				LibraryUnaryOperation dynamic_A_symbol_221 = (LibraryUnaryOperation)static_A_symbol_221.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_221 = dynamic_A_symbol_221.evaluate(evaluator, T_Integer, A_symbol_220);
				DomainType static_A_symbol_222 = valueFactory.typeOf(A_symbol_221, I_1);
				LibraryBinaryOperation dynamic_A_symbol_222 = (LibraryBinaryOperation)static_A_symbol_222.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_222 = dynamic_A_symbol_222.evaluate(evaluator, T_Boolean, A_symbol_221, I_1);
				rightA_symbol_217 = A_symbol_222;
			} catch (InvalidValueException e) {
				rightA_symbol_217 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_222 = rightA_symbol_217;
			DomainType static_A_symbol_217 = valueFactory.typeOf(A_symbol_219);
			LibraryBinaryOperation dynamic_A_symbol_217 = (LibraryBinaryOperation)static_A_symbol_217.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_217 = dynamic_A_symbol_217.evaluate(evaluator, T_Boolean, A_symbol_219, A_symbol_222);
			return A_symbol_217;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'SortedByIsOrderedIfSourceIsOrdered' invariant.
	 */
	public static class _invariant_SortedByIsOrderedIfSourceIsOrdered extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_SortedByIsOrderedIfSourceIsOrdered INSTANCE = new _invariant_SortedByIsOrderedIfSourceIsOrdered();
	
		/*
		name = 'sortedBy' implies
	if
	  source.type.oclIsKindOf(SequenceType) or
	  source.type.oclIsKindOf(BagType)
	then type.oclIsKindOf(SequenceType)
	else type.oclIsKindOf(OrderedSetType)
	endif
		*/
		public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Value self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final @NonNull ExecutorType T_String = OCLstdlibTables.Types._String;
			final @NonNull ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final @NonNull LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final @NonNull StringValue S_sortedBy = valueFactory.stringValueOf("sortedBy");
			final @NonNull ExecutorOperation O_Boolean_or = OCLstdlibTables.Operations._Boolean__or;
			final @NonNull ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
			final @NonNull ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final @NonNull ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final @NonNull LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final @NonNull ExecutorType T_pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final @NonNull ExecutorProperty P_CallExp_source = PivotTables.Properties._CallExp__source;
			final @NonNull LibraryProperty IP_CallExp_source = P_CallExp_source.getImplementation();
			final @NonNull Value T_Metaclass_pivot__SequenceType_ = valueFactory.createTypeValue(PivotTables.Types._SequenceType);
			final @NonNull Value T_Metaclass_pivot__BagType_ = valueFactory.createTypeValue(PivotTables.Types._BagType);
			final @NonNull Value T_Metaclass_pivot__OrderedSetType_ = valueFactory.createTypeValue(PivotTables.Types._OrderedSetType);
			
			Value leftA_symbol_223;
			try {
				
				Value A_symbol_224 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_225 = valueFactory.typeOf(A_symbol_224, S_sortedBy);
				LibraryBinaryOperation dynamic_A_symbol_225 = (LibraryBinaryOperation)static_A_symbol_225.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_225 = dynamic_A_symbol_225.evaluate(evaluator, T_Boolean, A_symbol_224, S_sortedBy);
				leftA_symbol_223 = A_symbol_225;
			} catch (InvalidValueException e) {
				leftA_symbol_223 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_225 = leftA_symbol_223;
			Value rightA_symbol_223;
			try {
					Value leftA_symbol_226;
					try {
						
						Value A_symbol_227 = IP_CallExp_source.evaluate(evaluator, T_pivot__OCLExpression, self, P_CallExp_source);
						
						Value A_symbol_228 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_227, P_TypedElement_type);
						
						DomainType static_A_symbol_229 = valueFactory.typeOf(A_symbol_228);
						LibraryBinaryOperation dynamic_A_symbol_229 = (LibraryBinaryOperation)static_A_symbol_229.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Value A_symbol_229 = dynamic_A_symbol_229.evaluate(evaluator, T_Boolean, A_symbol_228, T_Metaclass_pivot__SequenceType_);
						leftA_symbol_226 = A_symbol_229;
					} catch (InvalidValueException e) {
						leftA_symbol_226 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_229 = leftA_symbol_226;
					Value rightA_symbol_226;
					try {
						
						Value A_symbol_230 = IP_CallExp_source.evaluate(evaluator, T_pivot__OCLExpression, self, P_CallExp_source);
						
						Value A_symbol_231 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_230, P_TypedElement_type);
						
						DomainType static_A_symbol_232 = valueFactory.typeOf(A_symbol_231);
						LibraryBinaryOperation dynamic_A_symbol_232 = (LibraryBinaryOperation)static_A_symbol_232.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Value A_symbol_232 = dynamic_A_symbol_232.evaluate(evaluator, T_Boolean, A_symbol_231, T_Metaclass_pivot__BagType_);
						rightA_symbol_226 = A_symbol_232;
					} catch (InvalidValueException e) {
						rightA_symbol_226 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_232 = rightA_symbol_226;
					DomainType static_A_symbol_226 = valueFactory.typeOf(A_symbol_229);
					LibraryBinaryOperation dynamic_A_symbol_226 = (LibraryBinaryOperation)static_A_symbol_226.lookupImplementation(standardLibrary, O_Boolean_or);
					Value A_symbol_226 = dynamic_A_symbol_226.evaluate(evaluator, T_Boolean, A_symbol_229, A_symbol_232);
				Value A_symbol_233;
				if (A_symbol_226.isTrue()) {
					
					Value A_symbol_234 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
					
					DomainType static_A_symbol_235 = valueFactory.typeOf(A_symbol_234);
					LibraryBinaryOperation dynamic_A_symbol_235 = (LibraryBinaryOperation)static_A_symbol_235.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Value A_symbol_235 = dynamic_A_symbol_235.evaluate(evaluator, T_Boolean, A_symbol_234, T_Metaclass_pivot__SequenceType_);
					A_symbol_233 = A_symbol_235;
				}
				else if (A_symbol_226.isFalse()) {
					
					Value A_symbol_236 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
					
					DomainType static_A_symbol_237 = valueFactory.typeOf(A_symbol_236);
					LibraryBinaryOperation dynamic_A_symbol_237 = (LibraryBinaryOperation)static_A_symbol_237.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Value A_symbol_237 = dynamic_A_symbol_237.evaluate(evaluator, T_Boolean, A_symbol_236, T_Metaclass_pivot__OrderedSetType_);
					A_symbol_233 = A_symbol_237;
				}
				else if (A_symbol_226.isNull()) {
					A_symbol_233 = valueFactory.throwInvalidValueException("null if condition");
				}
				else {
					A_symbol_233 = valueFactory.throwInvalidValueException("invalid if condition");
				}
				rightA_symbol_223 = A_symbol_233;
			} catch (InvalidValueException e) {
				rightA_symbol_223 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_233 = rightA_symbol_223;
			DomainType static_A_symbol_223 = valueFactory.typeOf(A_symbol_225);
			LibraryBinaryOperation dynamic_A_symbol_223 = (LibraryBinaryOperation)static_A_symbol_223.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_223 = dynamic_A_symbol_223.evaluate(evaluator, T_Boolean, A_symbol_225, A_symbol_233);
			return A_symbol_223;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'SortedByIteratorTypeIsComparable' invariant.
	 */
	public static class _invariant_SortedByIteratorTypeIsComparable extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_SortedByIteratorTypeIsComparable INSTANCE = new _invariant_SortedByIteratorTypeIsComparable();
	
		/*
		true
		*/
		public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Value self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull BooleanValue True = valueFactory.getTrue();
			
			
			return True;
		}
	}
}

