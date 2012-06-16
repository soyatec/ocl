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
			final ExecutorType T_Pivot_ecore__pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final ExecutorProperty P_LoopExp_body = PivotTables.Properties._LoopExp__body;
			final LibraryProperty IP_LoopExp_body = P_LoopExp_body.getImplementation();
			final StringValue S_Boolean = valueFactory.stringValueOf("Boolean");
			
			Value leftA_symbol_18;
			try {
				
				Value A_symbol_19 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_20 = valueFactory.typeOf(A_symbol_19, S_any);
				LibraryBinaryOperation dynamic_A_symbol_20 = (LibraryBinaryOperation)static_A_symbol_20.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_20 = dynamic_A_symbol_20.evaluate(evaluator, T_Boolean, A_symbol_19, S_any);
				leftA_symbol_18 = A_symbol_20;
			} catch (InvalidValueException e) {
				leftA_symbol_18 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_20 = leftA_symbol_18;
			Value rightA_symbol_18;
			try {
				
				Value A_symbol_21 = IP_LoopExp_body.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_LoopExp_body);
				
				Value A_symbol_22 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_21, P_TypedElement_type);
				
				DomainType static_A_symbol_23 = valueFactory.typeOf(A_symbol_22, S_Boolean);
				LibraryBinaryOperation dynamic_A_symbol_23 = (LibraryBinaryOperation)static_A_symbol_23.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_23 = dynamic_A_symbol_23.evaluate(evaluator, T_Boolean, A_symbol_22, S_Boolean);
				rightA_symbol_18 = A_symbol_23;
			} catch (InvalidValueException e) {
				rightA_symbol_18 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_23 = rightA_symbol_18;
			DomainType static_A_symbol_18 = valueFactory.typeOf(A_symbol_20);
			LibraryBinaryOperation dynamic_A_symbol_18 = (LibraryBinaryOperation)static_A_symbol_18.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_18 = dynamic_A_symbol_18.evaluate(evaluator, T_Boolean, A_symbol_20, A_symbol_23);
			return A_symbol_18;
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
			
			Value leftA_symbol_24;
			try {
				
				Value A_symbol_25 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_26 = valueFactory.typeOf(A_symbol_25, S_any);
				LibraryBinaryOperation dynamic_A_symbol_26 = (LibraryBinaryOperation)static_A_symbol_26.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_26 = dynamic_A_symbol_26.evaluate(evaluator, T_Boolean, A_symbol_25, S_any);
				leftA_symbol_24 = A_symbol_26;
			} catch (InvalidValueException e) {
				leftA_symbol_24 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_26 = leftA_symbol_24;
			Value rightA_symbol_24;
			try {
				
				Value A_symbol_27 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_Pivot_ecore__pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_28 = valueFactory.typeOf(A_symbol_27);
				LibraryUnaryOperation dynamic_A_symbol_28 = (LibraryUnaryOperation)static_A_symbol_28.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_28 = dynamic_A_symbol_28.evaluate(evaluator, T_Integer, A_symbol_27);
				DomainType static_A_symbol_29 = valueFactory.typeOf(A_symbol_28, I_1);
				LibraryBinaryOperation dynamic_A_symbol_29 = (LibraryBinaryOperation)static_A_symbol_29.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_29 = dynamic_A_symbol_29.evaluate(evaluator, T_Boolean, A_symbol_28, I_1);
				rightA_symbol_24 = A_symbol_29;
			} catch (InvalidValueException e) {
				rightA_symbol_24 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_29 = rightA_symbol_24;
			DomainType static_A_symbol_24 = valueFactory.typeOf(A_symbol_26);
			LibraryBinaryOperation dynamic_A_symbol_24 = (LibraryBinaryOperation)static_A_symbol_24.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_24 = dynamic_A_symbol_24.evaluate(evaluator, T_Boolean, A_symbol_26, A_symbol_29);
			return A_symbol_24;
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
			final ExecutorType T_Pivot_ecore__pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final ExecutorProperty P_CallExp_source = PivotTables.Properties._CallExp__source;
			final LibraryProperty IP_CallExp_source = P_CallExp_source.getImplementation();
			final Value T_ClassClassifier_Pivot_ecore__pivot__CollectionType_ = valueFactory.createTypeValue(PivotTables.Types._CollectionType);
			
			Value leftA_symbol_30;
			try {
				
				Value A_symbol_31 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_32 = valueFactory.typeOf(A_symbol_31, S_any);
				LibraryBinaryOperation dynamic_A_symbol_32 = (LibraryBinaryOperation)static_A_symbol_32.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_32 = dynamic_A_symbol_32.evaluate(evaluator, T_Boolean, A_symbol_31, S_any);
				leftA_symbol_30 = A_symbol_32;
			} catch (InvalidValueException e) {
				leftA_symbol_30 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_32 = leftA_symbol_30;
			Value rightA_symbol_30;
			try {
				
				Value A_symbol_33 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				
				Value A_symbol_34 = IP_CallExp_source.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_CallExp_source);
				
				Value A_symbol_35 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_34, P_TypedElement_type);
				
				DomainType static_A_symbol_36 = valueFactory.typeOf(A_symbol_35);
				LibraryBinaryOperation dynamic_A_symbol_36 = (LibraryBinaryOperation)static_A_symbol_36.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_36 = dynamic_A_symbol_36.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionType, A_symbol_35, T_ClassClassifier_Pivot_ecore__pivot__CollectionType_);
				Value A_symbol_37 = IP_CollectionType_elementType.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_36, P_CollectionType_elementType);
				
				DomainType static_A_symbol_38 = valueFactory.typeOf(A_symbol_33, A_symbol_37);
				LibraryBinaryOperation dynamic_A_symbol_38 = (LibraryBinaryOperation)static_A_symbol_38.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_38 = dynamic_A_symbol_38.evaluate(evaluator, T_Boolean, A_symbol_33, A_symbol_37);
				rightA_symbol_30 = A_symbol_38;
			} catch (InvalidValueException e) {
				rightA_symbol_30 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_38 = rightA_symbol_30;
			DomainType static_A_symbol_30 = valueFactory.typeOf(A_symbol_32);
			LibraryBinaryOperation dynamic_A_symbol_30 = (LibraryBinaryOperation)static_A_symbol_30.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_30 = dynamic_A_symbol_30.evaluate(evaluator, T_Boolean, A_symbol_32, A_symbol_38);
			return A_symbol_30;
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
			final ExecutorType T_Pivot_ecore__pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final ExecutorProperty P_CallExp_source = PivotTables.Properties._CallExp__source;
			final LibraryProperty IP_CallExp_source = P_CallExp_source.getImplementation();
			
			Value leftA_symbol_39;
			try {
				
				Value A_symbol_40 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_41 = valueFactory.typeOf(A_symbol_40, S_closure);
				LibraryBinaryOperation dynamic_A_symbol_41 = (LibraryBinaryOperation)static_A_symbol_41.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_41 = dynamic_A_symbol_41.evaluate(evaluator, T_Boolean, A_symbol_40, S_closure);
				leftA_symbol_39 = A_symbol_41;
			} catch (InvalidValueException e) {
				leftA_symbol_39 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_41 = leftA_symbol_39;
			Value rightA_symbol_39;
			try {
				
				Value A_symbol_42 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_43 = valueFactory.typeOf(A_symbol_42);
				LibraryBinaryOperation dynamic_A_symbol_43 = (LibraryBinaryOperation)static_A_symbol_43.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_43 = dynamic_A_symbol_43.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionType, A_symbol_42, T_ClassClassifier_Pivot_ecore__pivot__CollectionType_);
				Value A_symbol_44 = IP_CollectionType_elementType.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_43, P_CollectionType_elementType);
				
				
				Value A_symbol_45 = IP_CallExp_source.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_CallExp_source);
				
				Value A_symbol_46 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_45, P_TypedElement_type);
				
				DomainType static_A_symbol_47 = valueFactory.typeOf(A_symbol_46);
				LibraryBinaryOperation dynamic_A_symbol_47 = (LibraryBinaryOperation)static_A_symbol_47.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_47 = dynamic_A_symbol_47.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionType, A_symbol_46, T_ClassClassifier_Pivot_ecore__pivot__CollectionType_);
				Value A_symbol_48 = IP_CollectionType_elementType.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_47, P_CollectionType_elementType);
				
				DomainType static_A_symbol_49 = valueFactory.typeOf(A_symbol_44, A_symbol_48);
				LibraryBinaryOperation dynamic_A_symbol_49 = (LibraryBinaryOperation)static_A_symbol_49.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_49 = dynamic_A_symbol_49.evaluate(evaluator, T_Boolean, A_symbol_44, A_symbol_48);
				rightA_symbol_39 = A_symbol_49;
			} catch (InvalidValueException e) {
				rightA_symbol_39 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_49 = rightA_symbol_39;
			DomainType static_A_symbol_39 = valueFactory.typeOf(A_symbol_41);
			LibraryBinaryOperation dynamic_A_symbol_39 = (LibraryBinaryOperation)static_A_symbol_39.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_39 = dynamic_A_symbol_39.evaluate(evaluator, T_Boolean, A_symbol_41, A_symbol_49);
			return A_symbol_39;
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
			
			Value leftA_symbol_50;
			try {
				
				Value A_symbol_51 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_52 = valueFactory.typeOf(A_symbol_51, S_closure);
				LibraryBinaryOperation dynamic_A_symbol_52 = (LibraryBinaryOperation)static_A_symbol_52.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_52 = dynamic_A_symbol_52.evaluate(evaluator, T_Boolean, A_symbol_51, S_closure);
				leftA_symbol_50 = A_symbol_52;
			} catch (InvalidValueException e) {
				leftA_symbol_50 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_52 = leftA_symbol_50;
			Value rightA_symbol_50;
			try {
				
				Value A_symbol_53 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_Pivot_ecore__pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_54 = valueFactory.typeOf(A_symbol_53);
				LibraryUnaryOperation dynamic_A_symbol_54 = (LibraryUnaryOperation)static_A_symbol_54.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_54 = dynamic_A_symbol_54.evaluate(evaluator, T_Integer, A_symbol_53);
				DomainType static_A_symbol_55 = valueFactory.typeOf(A_symbol_54, I_1);
				LibraryBinaryOperation dynamic_A_symbol_55 = (LibraryBinaryOperation)static_A_symbol_55.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_55 = dynamic_A_symbol_55.evaluate(evaluator, T_Boolean, A_symbol_54, I_1);
				rightA_symbol_50 = A_symbol_55;
			} catch (InvalidValueException e) {
				rightA_symbol_50 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_55 = rightA_symbol_50;
			DomainType static_A_symbol_50 = valueFactory.typeOf(A_symbol_52);
			LibraryBinaryOperation dynamic_A_symbol_50 = (LibraryBinaryOperation)static_A_symbol_50.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_50 = dynamic_A_symbol_50.evaluate(evaluator, T_Boolean, A_symbol_52, A_symbol_55);
			return A_symbol_50;
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
			final ExecutorType T_Pivot_ecore__pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final ExecutorProperty P_CallExp_source = PivotTables.Properties._CallExp__source;
			final LibraryProperty IP_CallExp_source = P_CallExp_source.getImplementation();
			final Value T_ClassClassifier_Pivot_ecore__pivot__CollectionType_ = valueFactory.createTypeValue(PivotTables.Types._CollectionType);
			final ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
			final ExecutorProperty P_LoopExp_body = PivotTables.Properties._LoopExp__body;
			final LibraryProperty IP_LoopExp_body = P_LoopExp_body.getImplementation();
			
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
				
				Value A_symbol_59 = IP_CallExp_source.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_CallExp_source);
				
				Value A_symbol_60 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_59, P_TypedElement_type);
				
				DomainType static_A_symbol_61 = valueFactory.typeOf(A_symbol_60);
				LibraryBinaryOperation dynamic_A_symbol_61 = (LibraryBinaryOperation)static_A_symbol_61.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_61 = dynamic_A_symbol_61.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionType, A_symbol_60, T_ClassClassifier_Pivot_ecore__pivot__CollectionType_);
				Value A_symbol_62 = IP_CollectionType_elementType.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_61, P_CollectionType_elementType);
				
					
					Value A_symbol_63 = IP_LoopExp_body.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_LoopExp_body);
					
					Value A_symbol_64 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_63, P_TypedElement_type);
					
					DomainType static_A_symbol_65 = valueFactory.typeOf(A_symbol_64);
					LibraryBinaryOperation dynamic_A_symbol_65 = (LibraryBinaryOperation)static_A_symbol_65.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Value A_symbol_65 = dynamic_A_symbol_65.evaluate(evaluator, T_Boolean, A_symbol_64, T_ClassClassifier_Pivot_ecore__pivot__CollectionType_);
				Value A_symbol_66;
				if (A_symbol_65.isTrue()) {
					
					Value A_symbol_67 = IP_LoopExp_body.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_LoopExp_body);
					
					Value A_symbol_68 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_67, P_TypedElement_type);
					
					DomainType static_A_symbol_69 = valueFactory.typeOf(A_symbol_68);
					LibraryBinaryOperation dynamic_A_symbol_69 = (LibraryBinaryOperation)static_A_symbol_69.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
					Value A_symbol_69 = dynamic_A_symbol_69.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionType, A_symbol_68, T_ClassClassifier_Pivot_ecore__pivot__CollectionType_);
					Value A_symbol_70 = IP_CollectionType_elementType.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_69, P_CollectionType_elementType);
					
					A_symbol_66 = A_symbol_70;
				}
				else if (A_symbol_65.isFalse()) {
					
					Value A_symbol_71 = IP_LoopExp_body.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_LoopExp_body);
					
					Value A_symbol_72 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_71, P_TypedElement_type);
					
					A_symbol_66 = A_symbol_72;
				}
				else if (A_symbol_65.isNull()) {
					A_symbol_66 = valueFactory.throwInvalidValueException("null if condition");
				}
				else {
					A_symbol_66 = valueFactory.throwInvalidValueException("invalid if condition");
				}
				DomainType static_A_symbol_73 = valueFactory.typeOf(A_symbol_62, A_symbol_66);
				LibraryBinaryOperation dynamic_A_symbol_73 = (LibraryBinaryOperation)static_A_symbol_73.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_73 = dynamic_A_symbol_73.evaluate(evaluator, T_Boolean, A_symbol_62, A_symbol_66);
				rightA_symbol_56 = A_symbol_73;
			} catch (InvalidValueException e) {
				rightA_symbol_56 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_73 = rightA_symbol_56;
			DomainType static_A_symbol_56 = valueFactory.typeOf(A_symbol_58);
			LibraryBinaryOperation dynamic_A_symbol_56 = (LibraryBinaryOperation)static_A_symbol_56.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_56 = dynamic_A_symbol_56.evaluate(evaluator, T_Boolean, A_symbol_58, A_symbol_73);
			return A_symbol_56;
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
			final ExecutorType T_Pivot_ecore__pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final ExecutorProperty P_CallExp_source = PivotTables.Properties._CallExp__source;
			final LibraryProperty IP_CallExp_source = P_CallExp_source.getImplementation();
			final Value T_ClassClassifier_Pivot_ecore__pivot__SequenceType_ = valueFactory.createTypeValue(PivotTables.Types._SequenceType);
			final Value T_ClassClassifier_Pivot_ecore__pivot__OrderedSetType_ = valueFactory.createTypeValue(PivotTables.Types._OrderedSetType);
			final Value T_ClassClassifier_Pivot_ecore__pivot__SetType_ = valueFactory.createTypeValue(PivotTables.Types._SetType);
			
			Value leftA_symbol_74;
			try {
				
				Value A_symbol_75 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_76 = valueFactory.typeOf(A_symbol_75, S_closure);
				LibraryBinaryOperation dynamic_A_symbol_76 = (LibraryBinaryOperation)static_A_symbol_76.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_76 = dynamic_A_symbol_76.evaluate(evaluator, T_Boolean, A_symbol_75, S_closure);
				leftA_symbol_74 = A_symbol_76;
			} catch (InvalidValueException e) {
				leftA_symbol_74 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_76 = leftA_symbol_74;
			Value rightA_symbol_74;
			try {
					Value leftA_symbol_77;
					try {
						
						Value A_symbol_78 = IP_CallExp_source.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_CallExp_source);
						
						Value A_symbol_79 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_78, P_TypedElement_type);
						
						DomainType static_A_symbol_80 = valueFactory.typeOf(A_symbol_79);
						LibraryBinaryOperation dynamic_A_symbol_80 = (LibraryBinaryOperation)static_A_symbol_80.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Value A_symbol_80 = dynamic_A_symbol_80.evaluate(evaluator, T_Boolean, A_symbol_79, T_ClassClassifier_Pivot_ecore__pivot__SequenceType_);
						leftA_symbol_77 = A_symbol_80;
					} catch (InvalidValueException e) {
						leftA_symbol_77 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_80 = leftA_symbol_77;
					Value rightA_symbol_77;
					try {
						
						Value A_symbol_81 = IP_CallExp_source.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_CallExp_source);
						
						Value A_symbol_82 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_81, P_TypedElement_type);
						
						DomainType static_A_symbol_83 = valueFactory.typeOf(A_symbol_82);
						LibraryBinaryOperation dynamic_A_symbol_83 = (LibraryBinaryOperation)static_A_symbol_83.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Value A_symbol_83 = dynamic_A_symbol_83.evaluate(evaluator, T_Boolean, A_symbol_82, T_ClassClassifier_Pivot_ecore__pivot__OrderedSetType_);
						rightA_symbol_77 = A_symbol_83;
					} catch (InvalidValueException e) {
						rightA_symbol_77 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_83 = rightA_symbol_77;
					DomainType static_A_symbol_77 = valueFactory.typeOf(A_symbol_80);
					LibraryBinaryOperation dynamic_A_symbol_77 = (LibraryBinaryOperation)static_A_symbol_77.lookupImplementation(standardLibrary, O_Boolean_or);
					Value A_symbol_77 = dynamic_A_symbol_77.evaluate(evaluator, T_Boolean, A_symbol_80, A_symbol_83);
				Value A_symbol_84;
				if (A_symbol_77.isTrue()) {
					
					Value A_symbol_85 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
					
					DomainType static_A_symbol_86 = valueFactory.typeOf(A_symbol_85);
					LibraryBinaryOperation dynamic_A_symbol_86 = (LibraryBinaryOperation)static_A_symbol_86.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Value A_symbol_86 = dynamic_A_symbol_86.evaluate(evaluator, T_Boolean, A_symbol_85, T_ClassClassifier_Pivot_ecore__pivot__OrderedSetType_);
					A_symbol_84 = A_symbol_86;
				}
				else if (A_symbol_77.isFalse()) {
					
					Value A_symbol_87 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
					
					DomainType static_A_symbol_88 = valueFactory.typeOf(A_symbol_87);
					LibraryBinaryOperation dynamic_A_symbol_88 = (LibraryBinaryOperation)static_A_symbol_88.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Value A_symbol_88 = dynamic_A_symbol_88.evaluate(evaluator, T_Boolean, A_symbol_87, T_ClassClassifier_Pivot_ecore__pivot__SetType_);
					A_symbol_84 = A_symbol_88;
				}
				else if (A_symbol_77.isNull()) {
					A_symbol_84 = valueFactory.throwInvalidValueException("null if condition");
				}
				else {
					A_symbol_84 = valueFactory.throwInvalidValueException("invalid if condition");
				}
				rightA_symbol_74 = A_symbol_84;
			} catch (InvalidValueException e) {
				rightA_symbol_74 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_84 = rightA_symbol_74;
			DomainType static_A_symbol_74 = valueFactory.typeOf(A_symbol_76);
			LibraryBinaryOperation dynamic_A_symbol_74 = (LibraryBinaryOperation)static_A_symbol_74.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_74 = dynamic_A_symbol_74.evaluate(evaluator, T_Boolean, A_symbol_76, A_symbol_84);
			return A_symbol_74;
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
			final ExecutorType T_Pivot_ecore__pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final ExecutorProperty P_LoopExp_body = PivotTables.Properties._LoopExp__body;
			final LibraryProperty IP_LoopExp_body = P_LoopExp_body.getImplementation();
			
			Value leftA_symbol_89;
			try {
				
				Value A_symbol_90 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_91 = valueFactory.typeOf(A_symbol_90, S_collect);
				LibraryBinaryOperation dynamic_A_symbol_91 = (LibraryBinaryOperation)static_A_symbol_91.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_91 = dynamic_A_symbol_91.evaluate(evaluator, T_Boolean, A_symbol_90, S_collect);
				leftA_symbol_89 = A_symbol_91;
			} catch (InvalidValueException e) {
				leftA_symbol_89 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_91 = leftA_symbol_89;
			Value rightA_symbol_89;
			try {
				
				Value A_symbol_92 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_93 = valueFactory.typeOf(A_symbol_92);
				LibraryBinaryOperation dynamic_A_symbol_93 = (LibraryBinaryOperation)static_A_symbol_93.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_93 = dynamic_A_symbol_93.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionType, A_symbol_92, T_ClassClassifier_Pivot_ecore__pivot__CollectionType_);
				Value A_symbol_94 = IP_CollectionType_elementType.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_93, P_CollectionType_elementType);
				
				
				Value A_symbol_95 = IP_LoopExp_body.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_LoopExp_body);
				
				Value A_symbol_96 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_95, P_TypedElement_type);
				
				DomainType static_A_symbol_97 = valueFactory.typeOf(A_symbol_96);
				LibraryBinaryOperation dynamic_A_symbol_97 = (LibraryBinaryOperation)static_A_symbol_97.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_97 = dynamic_A_symbol_97.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionType, A_symbol_96, T_ClassClassifier_Pivot_ecore__pivot__CollectionType_);
				Value A_symbol_98 = IP_CollectionType_elementType.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_97, P_CollectionType_elementType);
				
				DomainType static_A_symbol_99 = valueFactory.typeOf(A_symbol_94, A_symbol_98);
				LibraryBinaryOperation dynamic_A_symbol_99 = (LibraryBinaryOperation)static_A_symbol_99.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_99 = dynamic_A_symbol_99.evaluate(evaluator, T_Boolean, A_symbol_94, A_symbol_98);
				rightA_symbol_89 = A_symbol_99;
			} catch (InvalidValueException e) {
				rightA_symbol_89 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_99 = rightA_symbol_89;
			DomainType static_A_symbol_89 = valueFactory.typeOf(A_symbol_91);
			LibraryBinaryOperation dynamic_A_symbol_89 = (LibraryBinaryOperation)static_A_symbol_89.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_89 = dynamic_A_symbol_89.evaluate(evaluator, T_Boolean, A_symbol_91, A_symbol_99);
			return A_symbol_89;
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
			
			Value leftA_symbol_100;
			try {
				
				Value A_symbol_101 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_102 = valueFactory.typeOf(A_symbol_101, S_collect);
				LibraryBinaryOperation dynamic_A_symbol_102 = (LibraryBinaryOperation)static_A_symbol_102.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_102 = dynamic_A_symbol_102.evaluate(evaluator, T_Boolean, A_symbol_101, S_collect);
				leftA_symbol_100 = A_symbol_102;
			} catch (InvalidValueException e) {
				leftA_symbol_100 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_102 = leftA_symbol_100;
			Value rightA_symbol_100;
			try {
				
				Value A_symbol_103 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_Pivot_ecore__pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_104 = valueFactory.typeOf(A_symbol_103);
				LibraryUnaryOperation dynamic_A_symbol_104 = (LibraryUnaryOperation)static_A_symbol_104.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_104 = dynamic_A_symbol_104.evaluate(evaluator, T_Integer, A_symbol_103);
				DomainType static_A_symbol_105 = valueFactory.typeOf(A_symbol_104, I_1);
				LibraryBinaryOperation dynamic_A_symbol_105 = (LibraryBinaryOperation)static_A_symbol_105.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_105 = dynamic_A_symbol_105.evaluate(evaluator, T_Boolean, A_symbol_104, I_1);
				rightA_symbol_100 = A_symbol_105;
			} catch (InvalidValueException e) {
				rightA_symbol_100 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_105 = rightA_symbol_100;
			DomainType static_A_symbol_100 = valueFactory.typeOf(A_symbol_102);
			LibraryBinaryOperation dynamic_A_symbol_100 = (LibraryBinaryOperation)static_A_symbol_100.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_100 = dynamic_A_symbol_100.evaluate(evaluator, T_Boolean, A_symbol_102, A_symbol_105);
			return A_symbol_100;
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
			
			Value leftA_symbol_106;
			try {
				
				Value A_symbol_107 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_108 = valueFactory.typeOf(A_symbol_107, S_collectN___);
				LibraryBinaryOperation dynamic_A_symbol_108 = (LibraryBinaryOperation)static_A_symbol_108.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_108 = dynamic_A_symbol_108.evaluate(evaluator, T_Boolean, A_symbol_107, S_collectN___);
				leftA_symbol_106 = A_symbol_108;
			} catch (InvalidValueException e) {
				leftA_symbol_106 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_108 = leftA_symbol_106;
			Value rightA_symbol_106;
			try {
				
				Value A_symbol_109 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_Pivot_ecore__pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_110 = valueFactory.typeOf(A_symbol_109);
				LibraryUnaryOperation dynamic_A_symbol_110 = (LibraryUnaryOperation)static_A_symbol_110.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_110 = dynamic_A_symbol_110.evaluate(evaluator, T_Integer, A_symbol_109);
				DomainType static_A_symbol_111 = valueFactory.typeOf(A_symbol_110, I_1);
				LibraryBinaryOperation dynamic_A_symbol_111 = (LibraryBinaryOperation)static_A_symbol_111.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_111 = dynamic_A_symbol_111.evaluate(evaluator, T_Boolean, A_symbol_110, I_1);
				rightA_symbol_106 = A_symbol_111;
			} catch (InvalidValueException e) {
				rightA_symbol_106 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_111 = rightA_symbol_106;
			DomainType static_A_symbol_106 = valueFactory.typeOf(A_symbol_108);
			LibraryBinaryOperation dynamic_A_symbol_106 = (LibraryBinaryOperation)static_A_symbol_106.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_106 = dynamic_A_symbol_106.evaluate(evaluator, T_Boolean, A_symbol_108, A_symbol_111);
			return A_symbol_106;
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
			
			Value leftA_symbol_112;
			try {
				
				Value A_symbol_113 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_114 = valueFactory.typeOf(A_symbol_113, S_collectN___);
				LibraryBinaryOperation dynamic_A_symbol_114 = (LibraryBinaryOperation)static_A_symbol_114.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_114 = dynamic_A_symbol_114.evaluate(evaluator, T_Boolean, A_symbol_113, S_collectN___);
				leftA_symbol_112 = A_symbol_114;
			} catch (InvalidValueException e) {
				leftA_symbol_112 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_114 = leftA_symbol_112;
			Value rightA_symbol_112;
			try {
				
				Value A_symbol_115 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_116 = valueFactory.typeOf(A_symbol_115);
				LibraryBinaryOperation dynamic_A_symbol_116 = (LibraryBinaryOperation)static_A_symbol_116.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
				Value A_symbol_116 = dynamic_A_symbol_116.evaluate(evaluator, T_Boolean, A_symbol_115, T_ClassClassifier_Pivot_ecore__pivot__BagType_);
				rightA_symbol_112 = A_symbol_116;
			} catch (InvalidValueException e) {
				rightA_symbol_112 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_116 = rightA_symbol_112;
			DomainType static_A_symbol_112 = valueFactory.typeOf(A_symbol_114);
			LibraryBinaryOperation dynamic_A_symbol_112 = (LibraryBinaryOperation)static_A_symbol_112.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_112 = dynamic_A_symbol_112.evaluate(evaluator, T_Boolean, A_symbol_114, A_symbol_116);
			return A_symbol_112;
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
			final ExecutorType T_Pivot_ecore__pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final ExecutorProperty P_LoopExp_body = PivotTables.Properties._LoopExp__body;
			final LibraryProperty IP_LoopExp_body = P_LoopExp_body.getImplementation();
			
			Value leftA_symbol_117;
			try {
				
				Value A_symbol_118 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_119 = valueFactory.typeOf(A_symbol_118, S_collectN___);
				LibraryBinaryOperation dynamic_A_symbol_119 = (LibraryBinaryOperation)static_A_symbol_119.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_119 = dynamic_A_symbol_119.evaluate(evaluator, T_Boolean, A_symbol_118, S_collectN___);
				leftA_symbol_117 = A_symbol_119;
			} catch (InvalidValueException e) {
				leftA_symbol_117 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_119 = leftA_symbol_117;
			Value rightA_symbol_117;
			try {
				
				Value A_symbol_120 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				
				Value A_symbol_121 = IP_LoopExp_body.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_LoopExp_body);
				
				Value A_symbol_122 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_121, P_TypedElement_type);
				
				DomainType static_A_symbol_123 = valueFactory.typeOf(A_symbol_120, A_symbol_122);
				LibraryBinaryOperation dynamic_A_symbol_123 = (LibraryBinaryOperation)static_A_symbol_123.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_123 = dynamic_A_symbol_123.evaluate(evaluator, T_Boolean, A_symbol_120, A_symbol_122);
				rightA_symbol_117 = A_symbol_123;
			} catch (InvalidValueException e) {
				rightA_symbol_117 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_123 = rightA_symbol_117;
			DomainType static_A_symbol_117 = valueFactory.typeOf(A_symbol_119);
			LibraryBinaryOperation dynamic_A_symbol_117 = (LibraryBinaryOperation)static_A_symbol_117.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_117 = dynamic_A_symbol_117.evaluate(evaluator, T_Boolean, A_symbol_119, A_symbol_123);
			return A_symbol_117;
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
			final ExecutorType T_Pivot_ecore__pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final ExecutorProperty P_CallExp_source = PivotTables.Properties._CallExp__source;
			final LibraryProperty IP_CallExp_source = P_CallExp_source.getImplementation();
			final Value T_ClassClassifier_Pivot_ecore__pivot__SequenceType_ = valueFactory.createTypeValue(PivotTables.Types._SequenceType);
			final Value T_ClassClassifier_Pivot_ecore__pivot__OrderedSetType_ = valueFactory.createTypeValue(PivotTables.Types._OrderedSetType);
			final Value T_ClassClassifier_Pivot_ecore__pivot__BagType_ = valueFactory.createTypeValue(PivotTables.Types._BagType);
			
			Value leftA_symbol_124;
			try {
				
				Value A_symbol_125 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_126 = valueFactory.typeOf(A_symbol_125, S_collect);
				LibraryBinaryOperation dynamic_A_symbol_126 = (LibraryBinaryOperation)static_A_symbol_126.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_126 = dynamic_A_symbol_126.evaluate(evaluator, T_Boolean, A_symbol_125, S_collect);
				leftA_symbol_124 = A_symbol_126;
			} catch (InvalidValueException e) {
				leftA_symbol_124 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_126 = leftA_symbol_124;
			Value rightA_symbol_124;
			try {
					Value leftA_symbol_127;
					try {
						
						Value A_symbol_128 = IP_CallExp_source.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_CallExp_source);
						
						Value A_symbol_129 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_128, P_TypedElement_type);
						
						DomainType static_A_symbol_130 = valueFactory.typeOf(A_symbol_129);
						LibraryBinaryOperation dynamic_A_symbol_130 = (LibraryBinaryOperation)static_A_symbol_130.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Value A_symbol_130 = dynamic_A_symbol_130.evaluate(evaluator, T_Boolean, A_symbol_129, T_ClassClassifier_Pivot_ecore__pivot__SequenceType_);
						leftA_symbol_127 = A_symbol_130;
					} catch (InvalidValueException e) {
						leftA_symbol_127 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_130 = leftA_symbol_127;
					Value rightA_symbol_127;
					try {
						
						Value A_symbol_131 = IP_CallExp_source.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_CallExp_source);
						
						Value A_symbol_132 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_131, P_TypedElement_type);
						
						DomainType static_A_symbol_133 = valueFactory.typeOf(A_symbol_132);
						LibraryBinaryOperation dynamic_A_symbol_133 = (LibraryBinaryOperation)static_A_symbol_133.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Value A_symbol_133 = dynamic_A_symbol_133.evaluate(evaluator, T_Boolean, A_symbol_132, T_ClassClassifier_Pivot_ecore__pivot__OrderedSetType_);
						rightA_symbol_127 = A_symbol_133;
					} catch (InvalidValueException e) {
						rightA_symbol_127 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_133 = rightA_symbol_127;
					DomainType static_A_symbol_127 = valueFactory.typeOf(A_symbol_130);
					LibraryBinaryOperation dynamic_A_symbol_127 = (LibraryBinaryOperation)static_A_symbol_127.lookupImplementation(standardLibrary, O_Boolean_or);
					Value A_symbol_127 = dynamic_A_symbol_127.evaluate(evaluator, T_Boolean, A_symbol_130, A_symbol_133);
				Value A_symbol_134;
				if (A_symbol_127.isTrue()) {
					
					Value A_symbol_135 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
					
					DomainType static_A_symbol_136 = valueFactory.typeOf(A_symbol_135);
					LibraryBinaryOperation dynamic_A_symbol_136 = (LibraryBinaryOperation)static_A_symbol_136.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Value A_symbol_136 = dynamic_A_symbol_136.evaluate(evaluator, T_Boolean, A_symbol_135, T_ClassClassifier_Pivot_ecore__pivot__SequenceType_);
					A_symbol_134 = A_symbol_136;
				}
				else if (A_symbol_127.isFalse()) {
					
					Value A_symbol_137 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
					
					DomainType static_A_symbol_138 = valueFactory.typeOf(A_symbol_137);
					LibraryBinaryOperation dynamic_A_symbol_138 = (LibraryBinaryOperation)static_A_symbol_138.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Value A_symbol_138 = dynamic_A_symbol_138.evaluate(evaluator, T_Boolean, A_symbol_137, T_ClassClassifier_Pivot_ecore__pivot__BagType_);
					A_symbol_134 = A_symbol_138;
				}
				else if (A_symbol_127.isNull()) {
					A_symbol_134 = valueFactory.throwInvalidValueException("null if condition");
				}
				else {
					A_symbol_134 = valueFactory.throwInvalidValueException("invalid if condition");
				}
				rightA_symbol_124 = A_symbol_134;
			} catch (InvalidValueException e) {
				rightA_symbol_124 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_134 = rightA_symbol_124;
			DomainType static_A_symbol_124 = valueFactory.typeOf(A_symbol_126);
			LibraryBinaryOperation dynamic_A_symbol_124 = (LibraryBinaryOperation)static_A_symbol_124.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_124 = dynamic_A_symbol_124.evaluate(evaluator, T_Boolean, A_symbol_126, A_symbol_134);
			return A_symbol_124;
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
			final ExecutorType T_Pivot_ecore__pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final ExecutorProperty P_LoopExp_body = PivotTables.Properties._LoopExp__body;
			final LibraryProperty IP_LoopExp_body = P_LoopExp_body.getImplementation();
			final Value T_ClassClassifier_Boolean_ = valueFactory.createTypeValue(OCLstdlibTables.Types._Boolean);
			
			Value leftA_symbol_139;
			try {
				
				Value A_symbol_140 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_141 = valueFactory.typeOf(A_symbol_140, S_exists);
				LibraryBinaryOperation dynamic_A_symbol_141 = (LibraryBinaryOperation)static_A_symbol_141.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_141 = dynamic_A_symbol_141.evaluate(evaluator, T_Boolean, A_symbol_140, S_exists);
				leftA_symbol_139 = A_symbol_141;
			} catch (InvalidValueException e) {
				leftA_symbol_139 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_141 = leftA_symbol_139;
			Value rightA_symbol_139;
			try {
				
				Value A_symbol_142 = IP_LoopExp_body.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_LoopExp_body);
				
				Value A_symbol_143 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_142, P_TypedElement_type);
				
				DomainType static_A_symbol_144 = valueFactory.typeOf(A_symbol_143, T_ClassClassifier_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_144 = (LibraryBinaryOperation)static_A_symbol_144.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_144 = dynamic_A_symbol_144.evaluate(evaluator, T_Boolean, A_symbol_143, T_ClassClassifier_Boolean_);
				rightA_symbol_139 = A_symbol_144;
			} catch (InvalidValueException e) {
				rightA_symbol_139 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_144 = rightA_symbol_139;
			DomainType static_A_symbol_139 = valueFactory.typeOf(A_symbol_141);
			LibraryBinaryOperation dynamic_A_symbol_139 = (LibraryBinaryOperation)static_A_symbol_139.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_139 = dynamic_A_symbol_139.evaluate(evaluator, T_Boolean, A_symbol_141, A_symbol_144);
			return A_symbol_139;
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
			
			Value leftA_symbol_145;
			try {
				
				Value A_symbol_146 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_147 = valueFactory.typeOf(A_symbol_146, S_exists);
				LibraryBinaryOperation dynamic_A_symbol_147 = (LibraryBinaryOperation)static_A_symbol_147.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_147 = dynamic_A_symbol_147.evaluate(evaluator, T_Boolean, A_symbol_146, S_exists);
				leftA_symbol_145 = A_symbol_147;
			} catch (InvalidValueException e) {
				leftA_symbol_145 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_147 = leftA_symbol_145;
			Value rightA_symbol_145;
			try {
				
				Value A_symbol_148 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_149 = valueFactory.typeOf(A_symbol_148, T_ClassClassifier_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_149 = (LibraryBinaryOperation)static_A_symbol_149.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_149 = dynamic_A_symbol_149.evaluate(evaluator, T_Boolean, A_symbol_148, T_ClassClassifier_Boolean_);
				rightA_symbol_145 = A_symbol_149;
			} catch (InvalidValueException e) {
				rightA_symbol_145 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_149 = rightA_symbol_145;
			DomainType static_A_symbol_145 = valueFactory.typeOf(A_symbol_147);
			LibraryBinaryOperation dynamic_A_symbol_145 = (LibraryBinaryOperation)static_A_symbol_145.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_145 = dynamic_A_symbol_145.evaluate(evaluator, T_Boolean, A_symbol_147, A_symbol_149);
			return A_symbol_145;
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
			final ExecutorType T_Pivot_ecore__pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final ExecutorProperty P_LoopExp_body = PivotTables.Properties._LoopExp__body;
			final LibraryProperty IP_LoopExp_body = P_LoopExp_body.getImplementation();
			final Value T_ClassClassifier_Boolean_ = valueFactory.createTypeValue(OCLstdlibTables.Types._Boolean);
			
			Value leftA_symbol_150;
			try {
				
				Value A_symbol_151 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_152 = valueFactory.typeOf(A_symbol_151, S_forAll);
				LibraryBinaryOperation dynamic_A_symbol_152 = (LibraryBinaryOperation)static_A_symbol_152.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_152 = dynamic_A_symbol_152.evaluate(evaluator, T_Boolean, A_symbol_151, S_forAll);
				leftA_symbol_150 = A_symbol_152;
			} catch (InvalidValueException e) {
				leftA_symbol_150 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_152 = leftA_symbol_150;
			Value rightA_symbol_150;
			try {
				
				Value A_symbol_153 = IP_LoopExp_body.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_LoopExp_body);
				
				Value A_symbol_154 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_153, P_TypedElement_type);
				
				DomainType static_A_symbol_155 = valueFactory.typeOf(A_symbol_154, T_ClassClassifier_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_155 = (LibraryBinaryOperation)static_A_symbol_155.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_155 = dynamic_A_symbol_155.evaluate(evaluator, T_Boolean, A_symbol_154, T_ClassClassifier_Boolean_);
				rightA_symbol_150 = A_symbol_155;
			} catch (InvalidValueException e) {
				rightA_symbol_150 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_155 = rightA_symbol_150;
			DomainType static_A_symbol_150 = valueFactory.typeOf(A_symbol_152);
			LibraryBinaryOperation dynamic_A_symbol_150 = (LibraryBinaryOperation)static_A_symbol_150.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_150 = dynamic_A_symbol_150.evaluate(evaluator, T_Boolean, A_symbol_152, A_symbol_155);
			return A_symbol_150;
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
			
			Value leftA_symbol_156;
			try {
				
				Value A_symbol_157 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_158 = valueFactory.typeOf(A_symbol_157, S_forAll);
				LibraryBinaryOperation dynamic_A_symbol_158 = (LibraryBinaryOperation)static_A_symbol_158.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_158 = dynamic_A_symbol_158.evaluate(evaluator, T_Boolean, A_symbol_157, S_forAll);
				leftA_symbol_156 = A_symbol_158;
			} catch (InvalidValueException e) {
				leftA_symbol_156 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_158 = leftA_symbol_156;
			Value rightA_symbol_156;
			try {
				
				Value A_symbol_159 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_160 = valueFactory.typeOf(A_symbol_159, T_ClassClassifier_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_160 = (LibraryBinaryOperation)static_A_symbol_160.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_160 = dynamic_A_symbol_160.evaluate(evaluator, T_Boolean, A_symbol_159, T_ClassClassifier_Boolean_);
				rightA_symbol_156 = A_symbol_160;
			} catch (InvalidValueException e) {
				rightA_symbol_156 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_160 = rightA_symbol_156;
			DomainType static_A_symbol_156 = valueFactory.typeOf(A_symbol_158);
			LibraryBinaryOperation dynamic_A_symbol_156 = (LibraryBinaryOperation)static_A_symbol_156.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_156 = dynamic_A_symbol_156.evaluate(evaluator, T_Boolean, A_symbol_158, A_symbol_160);
			return A_symbol_156;
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
			
			Value leftA_symbol_161;
			try {
				
				Value A_symbol_162 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_163 = valueFactory.typeOf(A_symbol_162, S_isUnique);
				LibraryBinaryOperation dynamic_A_symbol_163 = (LibraryBinaryOperation)static_A_symbol_163.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_163 = dynamic_A_symbol_163.evaluate(evaluator, T_Boolean, A_symbol_162, S_isUnique);
				leftA_symbol_161 = A_symbol_163;
			} catch (InvalidValueException e) {
				leftA_symbol_161 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_163 = leftA_symbol_161;
			Value rightA_symbol_161;
			try {
				
				Value A_symbol_164 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_Pivot_ecore__pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_165 = valueFactory.typeOf(A_symbol_164);
				LibraryUnaryOperation dynamic_A_symbol_165 = (LibraryUnaryOperation)static_A_symbol_165.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_165 = dynamic_A_symbol_165.evaluate(evaluator, T_Integer, A_symbol_164);
				DomainType static_A_symbol_166 = valueFactory.typeOf(A_symbol_165, I_1);
				LibraryBinaryOperation dynamic_A_symbol_166 = (LibraryBinaryOperation)static_A_symbol_166.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_166 = dynamic_A_symbol_166.evaluate(evaluator, T_Boolean, A_symbol_165, I_1);
				rightA_symbol_161 = A_symbol_166;
			} catch (InvalidValueException e) {
				rightA_symbol_161 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_166 = rightA_symbol_161;
			DomainType static_A_symbol_161 = valueFactory.typeOf(A_symbol_163);
			LibraryBinaryOperation dynamic_A_symbol_161 = (LibraryBinaryOperation)static_A_symbol_161.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_161 = dynamic_A_symbol_161.evaluate(evaluator, T_Boolean, A_symbol_163, A_symbol_166);
			return A_symbol_161;
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
			
			Value leftA_symbol_167;
			try {
				
				Value A_symbol_168 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_169 = valueFactory.typeOf(A_symbol_168, S_isUnique);
				LibraryBinaryOperation dynamic_A_symbol_169 = (LibraryBinaryOperation)static_A_symbol_169.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_169 = dynamic_A_symbol_169.evaluate(evaluator, T_Boolean, A_symbol_168, S_isUnique);
				leftA_symbol_167 = A_symbol_169;
			} catch (InvalidValueException e) {
				leftA_symbol_167 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_169 = leftA_symbol_167;
			Value rightA_symbol_167;
			try {
				
				Value A_symbol_170 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_171 = valueFactory.typeOf(A_symbol_170, T_ClassClassifier_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_171 = (LibraryBinaryOperation)static_A_symbol_171.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_171 = dynamic_A_symbol_171.evaluate(evaluator, T_Boolean, A_symbol_170, T_ClassClassifier_Boolean_);
				rightA_symbol_167 = A_symbol_171;
			} catch (InvalidValueException e) {
				rightA_symbol_167 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_171 = rightA_symbol_167;
			DomainType static_A_symbol_167 = valueFactory.typeOf(A_symbol_169);
			LibraryBinaryOperation dynamic_A_symbol_167 = (LibraryBinaryOperation)static_A_symbol_167.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_167 = dynamic_A_symbol_167.evaluate(evaluator, T_Boolean, A_symbol_169, A_symbol_171);
			return A_symbol_167;
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
			final ExecutorType T_Pivot_ecore__pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final ExecutorProperty P_CallExp_source = PivotTables.Properties._CallExp__source;
			final LibraryProperty IP_CallExp_source = P_CallExp_source.getImplementation();
			final Value T_ClassClassifier_Pivot_ecore__pivot__CollectionType_ = valueFactory.createTypeValue(PivotTables.Types._CollectionType);
			
			
			Value A_symbol_172 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_Pivot_ecore__pivot__Variable_, self, P_LoopExp_iterator);
			
			
			/** 
			 * Implementation of the iterator body.
			 */
			AbstractBinaryOperation body_A_symbol_173 = new AbstractBinaryOperation()
			{
			/*
			type =
			source.type.oclAsType(_'file:/C:/GIT/org.eclipse.ocl/examples/org.eclipse.ocl.examples.pivot/model/Pivot.ecore'::ocl::CollectionType).elementType
			*/
				public Value evaluate(DomainEvaluator evaluator, DomainType returnType, Value sourceValue, Value iterator1) throws InvalidValueException {
					final Value V_1_ = iterator1;	// iterator: 1_
					
					Value A_symbol_174 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, V_1_, P_TypedElement_type);
					
					
					Value A_symbol_175 = IP_CallExp_source.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_CallExp_source);
					
					Value A_symbol_176 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_175, P_TypedElement_type);
					
					DomainType static_A_symbol_177 = valueFactory.typeOf(A_symbol_176);
					LibraryBinaryOperation dynamic_A_symbol_177 = (LibraryBinaryOperation)static_A_symbol_177.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
					Value A_symbol_177 = dynamic_A_symbol_177.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionType, A_symbol_176, T_ClassClassifier_Pivot_ecore__pivot__CollectionType_);
					Value A_symbol_178 = IP_CollectionType_elementType.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_177, P_CollectionType_elementType);
					
					DomainType static_A_symbol_179 = valueFactory.typeOf(A_symbol_174, A_symbol_178);
					LibraryBinaryOperation dynamic_A_symbol_179 = (LibraryBinaryOperation)static_A_symbol_179.lookupImplementation(standardLibrary, O_OclAny__eq_);
					Value A_symbol_179 = dynamic_A_symbol_179.evaluate(evaluator, T_Boolean, A_symbol_174, A_symbol_178);
					return A_symbol_179;
				}
			};
			DomainType static_A_symbol_173 = A_symbol_172.getType();
			LibraryIteration dynamic_A_symbol_173 = (LibraryIteration)static_A_symbol_173.lookupImplementation(standardLibrary, O_Collection_forAll);
			Value acc_A_symbol_173 = dynamic_A_symbol_173.createAccumulatorValue(evaluator, T_Boolean, T_Boolean);
			ExecutorSingleIterationManager manager_A_symbol_173 = new ExecutorSingleIterationManager(evaluator, T_Boolean, body_A_symbol_173, (CollectionValue)A_symbol_172, acc_A_symbol_173);
			Value A_symbol_173 = dynamic_A_symbol_173.evaluateIteration(manager_A_symbol_173);
			return A_symbol_173;
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
			final ExecutorType T_Pivot_ecore__pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final ExecutorProperty P_LoopExp_body = PivotTables.Properties._LoopExp__body;
			final LibraryProperty IP_LoopExp_body = P_LoopExp_body.getImplementation();
			final Value T_ClassClassifier_Boolean_ = valueFactory.createTypeValue(OCLstdlibTables.Types._Boolean);
			
			Value leftA_symbol_180;
			try {
				
				Value A_symbol_181 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_182 = valueFactory.typeOf(A_symbol_181, S_one);
				LibraryBinaryOperation dynamic_A_symbol_182 = (LibraryBinaryOperation)static_A_symbol_182.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_182 = dynamic_A_symbol_182.evaluate(evaluator, T_Boolean, A_symbol_181, S_one);
				leftA_symbol_180 = A_symbol_182;
			} catch (InvalidValueException e) {
				leftA_symbol_180 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_182 = leftA_symbol_180;
			Value rightA_symbol_180;
			try {
				
				Value A_symbol_183 = IP_LoopExp_body.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_LoopExp_body);
				
				Value A_symbol_184 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_183, P_TypedElement_type);
				
				DomainType static_A_symbol_185 = valueFactory.typeOf(A_symbol_184, T_ClassClassifier_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_185 = (LibraryBinaryOperation)static_A_symbol_185.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_185 = dynamic_A_symbol_185.evaluate(evaluator, T_Boolean, A_symbol_184, T_ClassClassifier_Boolean_);
				rightA_symbol_180 = A_symbol_185;
			} catch (InvalidValueException e) {
				rightA_symbol_180 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_185 = rightA_symbol_180;
			DomainType static_A_symbol_180 = valueFactory.typeOf(A_symbol_182);
			LibraryBinaryOperation dynamic_A_symbol_180 = (LibraryBinaryOperation)static_A_symbol_180.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_180 = dynamic_A_symbol_180.evaluate(evaluator, T_Boolean, A_symbol_182, A_symbol_185);
			return A_symbol_180;
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
			
			Value leftA_symbol_186;
			try {
				
				Value A_symbol_187 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_188 = valueFactory.typeOf(A_symbol_187, S_one);
				LibraryBinaryOperation dynamic_A_symbol_188 = (LibraryBinaryOperation)static_A_symbol_188.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_188 = dynamic_A_symbol_188.evaluate(evaluator, T_Boolean, A_symbol_187, S_one);
				leftA_symbol_186 = A_symbol_188;
			} catch (InvalidValueException e) {
				leftA_symbol_186 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_188 = leftA_symbol_186;
			Value rightA_symbol_186;
			try {
				
				Value A_symbol_189 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_Pivot_ecore__pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_190 = valueFactory.typeOf(A_symbol_189);
				LibraryUnaryOperation dynamic_A_symbol_190 = (LibraryUnaryOperation)static_A_symbol_190.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_190 = dynamic_A_symbol_190.evaluate(evaluator, T_Integer, A_symbol_189);
				DomainType static_A_symbol_191 = valueFactory.typeOf(A_symbol_190, I_1);
				LibraryBinaryOperation dynamic_A_symbol_191 = (LibraryBinaryOperation)static_A_symbol_191.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_191 = dynamic_A_symbol_191.evaluate(evaluator, T_Boolean, A_symbol_190, I_1);
				rightA_symbol_186 = A_symbol_191;
			} catch (InvalidValueException e) {
				rightA_symbol_186 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_191 = rightA_symbol_186;
			DomainType static_A_symbol_186 = valueFactory.typeOf(A_symbol_188);
			LibraryBinaryOperation dynamic_A_symbol_186 = (LibraryBinaryOperation)static_A_symbol_186.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_186 = dynamic_A_symbol_186.evaluate(evaluator, T_Boolean, A_symbol_188, A_symbol_191);
			return A_symbol_186;
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
			
			Value leftA_symbol_192;
			try {
				
				Value A_symbol_193 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_194 = valueFactory.typeOf(A_symbol_193, S_one);
				LibraryBinaryOperation dynamic_A_symbol_194 = (LibraryBinaryOperation)static_A_symbol_194.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_194 = dynamic_A_symbol_194.evaluate(evaluator, T_Boolean, A_symbol_193, S_one);
				leftA_symbol_192 = A_symbol_194;
			} catch (InvalidValueException e) {
				leftA_symbol_192 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_194 = leftA_symbol_192;
			Value rightA_symbol_192;
			try {
				
				Value A_symbol_195 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_196 = valueFactory.typeOf(A_symbol_195, T_ClassClassifier_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_196 = (LibraryBinaryOperation)static_A_symbol_196.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_196 = dynamic_A_symbol_196.evaluate(evaluator, T_Boolean, A_symbol_195, T_ClassClassifier_Boolean_);
				rightA_symbol_192 = A_symbol_196;
			} catch (InvalidValueException e) {
				rightA_symbol_192 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_196 = rightA_symbol_192;
			DomainType static_A_symbol_192 = valueFactory.typeOf(A_symbol_194);
			LibraryBinaryOperation dynamic_A_symbol_192 = (LibraryBinaryOperation)static_A_symbol_192.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_192 = dynamic_A_symbol_192.evaluate(evaluator, T_Boolean, A_symbol_194, A_symbol_196);
			return A_symbol_192;
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
			
			Value leftA_symbol_197;
			try {
				Value leftA_symbol_198;
				try {
					
					Value A_symbol_199 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
					
					DomainType static_A_symbol_200 = valueFactory.typeOf(A_symbol_199, S_reject);
					LibraryBinaryOperation dynamic_A_symbol_200 = (LibraryBinaryOperation)static_A_symbol_200.lookupImplementation(standardLibrary, O_String__eq_);
					Value A_symbol_200 = dynamic_A_symbol_200.evaluate(evaluator, T_Boolean, A_symbol_199, S_reject);
					leftA_symbol_198 = A_symbol_200;
				} catch (InvalidValueException e) {
					leftA_symbol_198 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_200 = leftA_symbol_198;
				Value rightA_symbol_198;
				try {
					
					Value A_symbol_201 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
					
					DomainType static_A_symbol_202 = valueFactory.typeOf(A_symbol_201, S_select);
					LibraryBinaryOperation dynamic_A_symbol_202 = (LibraryBinaryOperation)static_A_symbol_202.lookupImplementation(standardLibrary, O_String__eq_);
					Value A_symbol_202 = dynamic_A_symbol_202.evaluate(evaluator, T_Boolean, A_symbol_201, S_select);
					rightA_symbol_198 = A_symbol_202;
				} catch (InvalidValueException e) {
					rightA_symbol_198 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_202 = rightA_symbol_198;
				DomainType static_A_symbol_198 = valueFactory.typeOf(A_symbol_200);
				LibraryBinaryOperation dynamic_A_symbol_198 = (LibraryBinaryOperation)static_A_symbol_198.lookupImplementation(standardLibrary, O_Boolean_or);
				Value A_symbol_198 = dynamic_A_symbol_198.evaluate(evaluator, T_Boolean, A_symbol_200, A_symbol_202);
				leftA_symbol_197 = A_symbol_198;
			} catch (InvalidValueException e) {
				leftA_symbol_197 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_198 = leftA_symbol_197;
			Value rightA_symbol_197;
			try {
				
				Value A_symbol_203 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_Pivot_ecore__pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_204 = valueFactory.typeOf(A_symbol_203);
				LibraryUnaryOperation dynamic_A_symbol_204 = (LibraryUnaryOperation)static_A_symbol_204.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_204 = dynamic_A_symbol_204.evaluate(evaluator, T_Integer, A_symbol_203);
				DomainType static_A_symbol_205 = valueFactory.typeOf(A_symbol_204, I_1);
				LibraryBinaryOperation dynamic_A_symbol_205 = (LibraryBinaryOperation)static_A_symbol_205.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_205 = dynamic_A_symbol_205.evaluate(evaluator, T_Boolean, A_symbol_204, I_1);
				rightA_symbol_197 = A_symbol_205;
			} catch (InvalidValueException e) {
				rightA_symbol_197 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_205 = rightA_symbol_197;
			DomainType static_A_symbol_197 = valueFactory.typeOf(A_symbol_198);
			LibraryBinaryOperation dynamic_A_symbol_197 = (LibraryBinaryOperation)static_A_symbol_197.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_197 = dynamic_A_symbol_197.evaluate(evaluator, T_Boolean, A_symbol_198, A_symbol_205);
			return A_symbol_197;
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
			
			Value leftA_symbol_206;
			try {
				Value leftA_symbol_207;
				try {
					
					Value A_symbol_208 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
					
					DomainType static_A_symbol_209 = valueFactory.typeOf(A_symbol_208, S_reject);
					LibraryBinaryOperation dynamic_A_symbol_209 = (LibraryBinaryOperation)static_A_symbol_209.lookupImplementation(standardLibrary, O_String__eq_);
					Value A_symbol_209 = dynamic_A_symbol_209.evaluate(evaluator, T_Boolean, A_symbol_208, S_reject);
					leftA_symbol_207 = A_symbol_209;
				} catch (InvalidValueException e) {
					leftA_symbol_207 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_209 = leftA_symbol_207;
				Value rightA_symbol_207;
				try {
					
					Value A_symbol_210 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
					
					DomainType static_A_symbol_211 = valueFactory.typeOf(A_symbol_210, S_select);
					LibraryBinaryOperation dynamic_A_symbol_211 = (LibraryBinaryOperation)static_A_symbol_211.lookupImplementation(standardLibrary, O_String__eq_);
					Value A_symbol_211 = dynamic_A_symbol_211.evaluate(evaluator, T_Boolean, A_symbol_210, S_select);
					rightA_symbol_207 = A_symbol_211;
				} catch (InvalidValueException e) {
					rightA_symbol_207 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_211 = rightA_symbol_207;
				DomainType static_A_symbol_207 = valueFactory.typeOf(A_symbol_209);
				LibraryBinaryOperation dynamic_A_symbol_207 = (LibraryBinaryOperation)static_A_symbol_207.lookupImplementation(standardLibrary, O_Boolean_or);
				Value A_symbol_207 = dynamic_A_symbol_207.evaluate(evaluator, T_Boolean, A_symbol_209, A_symbol_211);
				leftA_symbol_206 = A_symbol_207;
			} catch (InvalidValueException e) {
				leftA_symbol_206 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_207 = leftA_symbol_206;
			Value rightA_symbol_206;
			try {
				
				Value A_symbol_212 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_213 = valueFactory.typeOf(A_symbol_212, T_ClassClassifier_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_213 = (LibraryBinaryOperation)static_A_symbol_213.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_213 = dynamic_A_symbol_213.evaluate(evaluator, T_Boolean, A_symbol_212, T_ClassClassifier_Boolean_);
				rightA_symbol_206 = A_symbol_213;
			} catch (InvalidValueException e) {
				rightA_symbol_206 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_213 = rightA_symbol_206;
			DomainType static_A_symbol_206 = valueFactory.typeOf(A_symbol_207);
			LibraryBinaryOperation dynamic_A_symbol_206 = (LibraryBinaryOperation)static_A_symbol_206.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_206 = dynamic_A_symbol_206.evaluate(evaluator, T_Boolean, A_symbol_207, A_symbol_213);
			return A_symbol_206;
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
			final ExecutorType T_Pivot_ecore__pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final ExecutorProperty P_CallExp_source = PivotTables.Properties._CallExp__source;
			final LibraryProperty IP_CallExp_source = P_CallExp_source.getImplementation();
			
			Value leftA_symbol_214;
			try {
				Value leftA_symbol_215;
				try {
					
					Value A_symbol_216 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
					
					DomainType static_A_symbol_217 = valueFactory.typeOf(A_symbol_216, S_reject);
					LibraryBinaryOperation dynamic_A_symbol_217 = (LibraryBinaryOperation)static_A_symbol_217.lookupImplementation(standardLibrary, O_String__eq_);
					Value A_symbol_217 = dynamic_A_symbol_217.evaluate(evaluator, T_Boolean, A_symbol_216, S_reject);
					leftA_symbol_215 = A_symbol_217;
				} catch (InvalidValueException e) {
					leftA_symbol_215 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_217 = leftA_symbol_215;
				Value rightA_symbol_215;
				try {
					
					Value A_symbol_218 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
					
					DomainType static_A_symbol_219 = valueFactory.typeOf(A_symbol_218, S_select);
					LibraryBinaryOperation dynamic_A_symbol_219 = (LibraryBinaryOperation)static_A_symbol_219.lookupImplementation(standardLibrary, O_String__eq_);
					Value A_symbol_219 = dynamic_A_symbol_219.evaluate(evaluator, T_Boolean, A_symbol_218, S_select);
					rightA_symbol_215 = A_symbol_219;
				} catch (InvalidValueException e) {
					rightA_symbol_215 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_219 = rightA_symbol_215;
				DomainType static_A_symbol_215 = valueFactory.typeOf(A_symbol_217);
				LibraryBinaryOperation dynamic_A_symbol_215 = (LibraryBinaryOperation)static_A_symbol_215.lookupImplementation(standardLibrary, O_Boolean_or);
				Value A_symbol_215 = dynamic_A_symbol_215.evaluate(evaluator, T_Boolean, A_symbol_217, A_symbol_219);
				leftA_symbol_214 = A_symbol_215;
			} catch (InvalidValueException e) {
				leftA_symbol_214 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_215 = leftA_symbol_214;
			Value rightA_symbol_214;
			try {
				
				Value A_symbol_220 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				
				Value A_symbol_221 = IP_CallExp_source.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_CallExp_source);
				
				Value A_symbol_222 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_221, P_TypedElement_type);
				
				DomainType static_A_symbol_223 = valueFactory.typeOf(A_symbol_220, A_symbol_222);
				LibraryBinaryOperation dynamic_A_symbol_223 = (LibraryBinaryOperation)static_A_symbol_223.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_223 = dynamic_A_symbol_223.evaluate(evaluator, T_Boolean, A_symbol_220, A_symbol_222);
				rightA_symbol_214 = A_symbol_223;
			} catch (InvalidValueException e) {
				rightA_symbol_214 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_223 = rightA_symbol_214;
			DomainType static_A_symbol_214 = valueFactory.typeOf(A_symbol_215);
			LibraryBinaryOperation dynamic_A_symbol_214 = (LibraryBinaryOperation)static_A_symbol_214.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_214 = dynamic_A_symbol_214.evaluate(evaluator, T_Boolean, A_symbol_215, A_symbol_223);
			return A_symbol_214;
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
			final ExecutorType T_Pivot_ecore__pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final ExecutorProperty P_LoopExp_body = PivotTables.Properties._LoopExp__body;
			final LibraryProperty IP_LoopExp_body = P_LoopExp_body.getImplementation();
			
			Value leftA_symbol_224;
			try {
				
				Value A_symbol_225 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_226 = valueFactory.typeOf(A_symbol_225, S_sortedBy);
				LibraryBinaryOperation dynamic_A_symbol_226 = (LibraryBinaryOperation)static_A_symbol_226.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_226 = dynamic_A_symbol_226.evaluate(evaluator, T_Boolean, A_symbol_225, S_sortedBy);
				leftA_symbol_224 = A_symbol_226;
			} catch (InvalidValueException e) {
				leftA_symbol_224 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_226 = leftA_symbol_224;
			Value rightA_symbol_224;
			try {
				
				Value A_symbol_227 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_228 = valueFactory.typeOf(A_symbol_227);
				LibraryBinaryOperation dynamic_A_symbol_228 = (LibraryBinaryOperation)static_A_symbol_228.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_228 = dynamic_A_symbol_228.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionType, A_symbol_227, T_ClassClassifier_Pivot_ecore__pivot__CollectionType_);
				Value A_symbol_229 = IP_CollectionType_elementType.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_228, P_CollectionType_elementType);
				
				
				Value A_symbol_230 = IP_LoopExp_body.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_LoopExp_body);
				
				Value A_symbol_231 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_230, P_TypedElement_type);
				
				DomainType static_A_symbol_232 = valueFactory.typeOf(A_symbol_231);
				LibraryBinaryOperation dynamic_A_symbol_232 = (LibraryBinaryOperation)static_A_symbol_232.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_232 = dynamic_A_symbol_232.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionType, A_symbol_231, T_ClassClassifier_Pivot_ecore__pivot__CollectionType_);
				Value A_symbol_233 = IP_CollectionType_elementType.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_232, P_CollectionType_elementType);
				
				DomainType static_A_symbol_234 = valueFactory.typeOf(A_symbol_229, A_symbol_233);
				LibraryBinaryOperation dynamic_A_symbol_234 = (LibraryBinaryOperation)static_A_symbol_234.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_234 = dynamic_A_symbol_234.evaluate(evaluator, T_Boolean, A_symbol_229, A_symbol_233);
				rightA_symbol_224 = A_symbol_234;
			} catch (InvalidValueException e) {
				rightA_symbol_224 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_234 = rightA_symbol_224;
			DomainType static_A_symbol_224 = valueFactory.typeOf(A_symbol_226);
			LibraryBinaryOperation dynamic_A_symbol_224 = (LibraryBinaryOperation)static_A_symbol_224.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_224 = dynamic_A_symbol_224.evaluate(evaluator, T_Boolean, A_symbol_226, A_symbol_234);
			return A_symbol_224;
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
			
			Value leftA_symbol_235;
			try {
				
				Value A_symbol_236 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_237 = valueFactory.typeOf(A_symbol_236, S_sortedBy);
				LibraryBinaryOperation dynamic_A_symbol_237 = (LibraryBinaryOperation)static_A_symbol_237.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_237 = dynamic_A_symbol_237.evaluate(evaluator, T_Boolean, A_symbol_236, S_sortedBy);
				leftA_symbol_235 = A_symbol_237;
			} catch (InvalidValueException e) {
				leftA_symbol_235 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_237 = leftA_symbol_235;
			Value rightA_symbol_235;
			try {
				
				Value A_symbol_238 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_Pivot_ecore__pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_239 = valueFactory.typeOf(A_symbol_238);
				LibraryUnaryOperation dynamic_A_symbol_239 = (LibraryUnaryOperation)static_A_symbol_239.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_239 = dynamic_A_symbol_239.evaluate(evaluator, T_Integer, A_symbol_238);
				DomainType static_A_symbol_240 = valueFactory.typeOf(A_symbol_239, I_1);
				LibraryBinaryOperation dynamic_A_symbol_240 = (LibraryBinaryOperation)static_A_symbol_240.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_240 = dynamic_A_symbol_240.evaluate(evaluator, T_Boolean, A_symbol_239, I_1);
				rightA_symbol_235 = A_symbol_240;
			} catch (InvalidValueException e) {
				rightA_symbol_235 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_240 = rightA_symbol_235;
			DomainType static_A_symbol_235 = valueFactory.typeOf(A_symbol_237);
			LibraryBinaryOperation dynamic_A_symbol_235 = (LibraryBinaryOperation)static_A_symbol_235.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_235 = dynamic_A_symbol_235.evaluate(evaluator, T_Boolean, A_symbol_237, A_symbol_240);
			return A_symbol_235;
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
			final ExecutorType T_Pivot_ecore__pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final ExecutorProperty P_CallExp_source = PivotTables.Properties._CallExp__source;
			final LibraryProperty IP_CallExp_source = P_CallExp_source.getImplementation();
			final Value T_ClassClassifier_Pivot_ecore__pivot__SequenceType_ = valueFactory.createTypeValue(PivotTables.Types._SequenceType);
			final Value T_ClassClassifier_Pivot_ecore__pivot__BagType_ = valueFactory.createTypeValue(PivotTables.Types._BagType);
			final Value T_ClassClassifier_Pivot_ecore__pivot__OrderedSetType_ = valueFactory.createTypeValue(PivotTables.Types._OrderedSetType);
			
			Value leftA_symbol_241;
			try {
				
				Value A_symbol_242 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_243 = valueFactory.typeOf(A_symbol_242, S_sortedBy);
				LibraryBinaryOperation dynamic_A_symbol_243 = (LibraryBinaryOperation)static_A_symbol_243.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_243 = dynamic_A_symbol_243.evaluate(evaluator, T_Boolean, A_symbol_242, S_sortedBy);
				leftA_symbol_241 = A_symbol_243;
			} catch (InvalidValueException e) {
				leftA_symbol_241 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_243 = leftA_symbol_241;
			Value rightA_symbol_241;
			try {
					Value leftA_symbol_244;
					try {
						
						Value A_symbol_245 = IP_CallExp_source.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_CallExp_source);
						
						Value A_symbol_246 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_245, P_TypedElement_type);
						
						DomainType static_A_symbol_247 = valueFactory.typeOf(A_symbol_246);
						LibraryBinaryOperation dynamic_A_symbol_247 = (LibraryBinaryOperation)static_A_symbol_247.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Value A_symbol_247 = dynamic_A_symbol_247.evaluate(evaluator, T_Boolean, A_symbol_246, T_ClassClassifier_Pivot_ecore__pivot__SequenceType_);
						leftA_symbol_244 = A_symbol_247;
					} catch (InvalidValueException e) {
						leftA_symbol_244 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_247 = leftA_symbol_244;
					Value rightA_symbol_244;
					try {
						
						Value A_symbol_248 = IP_CallExp_source.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_CallExp_source);
						
						Value A_symbol_249 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_248, P_TypedElement_type);
						
						DomainType static_A_symbol_250 = valueFactory.typeOf(A_symbol_249);
						LibraryBinaryOperation dynamic_A_symbol_250 = (LibraryBinaryOperation)static_A_symbol_250.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Value A_symbol_250 = dynamic_A_symbol_250.evaluate(evaluator, T_Boolean, A_symbol_249, T_ClassClassifier_Pivot_ecore__pivot__BagType_);
						rightA_symbol_244 = A_symbol_250;
					} catch (InvalidValueException e) {
						rightA_symbol_244 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_250 = rightA_symbol_244;
					DomainType static_A_symbol_244 = valueFactory.typeOf(A_symbol_247);
					LibraryBinaryOperation dynamic_A_symbol_244 = (LibraryBinaryOperation)static_A_symbol_244.lookupImplementation(standardLibrary, O_Boolean_or);
					Value A_symbol_244 = dynamic_A_symbol_244.evaluate(evaluator, T_Boolean, A_symbol_247, A_symbol_250);
				Value A_symbol_251;
				if (A_symbol_244.isTrue()) {
					
					Value A_symbol_252 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
					
					DomainType static_A_symbol_253 = valueFactory.typeOf(A_symbol_252);
					LibraryBinaryOperation dynamic_A_symbol_253 = (LibraryBinaryOperation)static_A_symbol_253.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Value A_symbol_253 = dynamic_A_symbol_253.evaluate(evaluator, T_Boolean, A_symbol_252, T_ClassClassifier_Pivot_ecore__pivot__SequenceType_);
					A_symbol_251 = A_symbol_253;
				}
				else if (A_symbol_244.isFalse()) {
					
					Value A_symbol_254 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
					
					DomainType static_A_symbol_255 = valueFactory.typeOf(A_symbol_254);
					LibraryBinaryOperation dynamic_A_symbol_255 = (LibraryBinaryOperation)static_A_symbol_255.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Value A_symbol_255 = dynamic_A_symbol_255.evaluate(evaluator, T_Boolean, A_symbol_254, T_ClassClassifier_Pivot_ecore__pivot__OrderedSetType_);
					A_symbol_251 = A_symbol_255;
				}
				else if (A_symbol_244.isNull()) {
					A_symbol_251 = valueFactory.throwInvalidValueException("null if condition");
				}
				else {
					A_symbol_251 = valueFactory.throwInvalidValueException("invalid if condition");
				}
				rightA_symbol_241 = A_symbol_251;
			} catch (InvalidValueException e) {
				rightA_symbol_241 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_251 = rightA_symbol_241;
			DomainType static_A_symbol_241 = valueFactory.typeOf(A_symbol_243);
			LibraryBinaryOperation dynamic_A_symbol_241 = (LibraryBinaryOperation)static_A_symbol_241.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_241 = dynamic_A_symbol_241.evaluate(evaluator, T_Boolean, A_symbol_243, A_symbol_251);
			return A_symbol_241;
		}
	}
}

