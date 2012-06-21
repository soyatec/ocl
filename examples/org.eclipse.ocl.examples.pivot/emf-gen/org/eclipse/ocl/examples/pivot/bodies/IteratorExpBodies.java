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
			
			Value leftA_symbol_23;
			try {
				
				Value A_symbol_24 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_25 = valueFactory.typeOf(A_symbol_24, S_any);
				LibraryBinaryOperation dynamic_A_symbol_25 = (LibraryBinaryOperation)static_A_symbol_25.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_25 = dynamic_A_symbol_25.evaluate(evaluator, T_Boolean, A_symbol_24, S_any);
				leftA_symbol_23 = A_symbol_25;
			} catch (InvalidValueException e) {
				leftA_symbol_23 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_25 = leftA_symbol_23;
			Value rightA_symbol_23;
			try {
				
				Value A_symbol_26 = IP_LoopExp_body.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_LoopExp_body);
				
				Value A_symbol_27 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_26, P_TypedElement_type);
				
				DomainType static_A_symbol_28 = valueFactory.typeOf(A_symbol_27, S_Boolean);
				LibraryBinaryOperation dynamic_A_symbol_28 = (LibraryBinaryOperation)static_A_symbol_28.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_28 = dynamic_A_symbol_28.evaluate(evaluator, T_Boolean, A_symbol_27, S_Boolean);
				rightA_symbol_23 = A_symbol_28;
			} catch (InvalidValueException e) {
				rightA_symbol_23 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_28 = rightA_symbol_23;
			DomainType static_A_symbol_23 = valueFactory.typeOf(A_symbol_25);
			LibraryBinaryOperation dynamic_A_symbol_23 = (LibraryBinaryOperation)static_A_symbol_23.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_23 = dynamic_A_symbol_23.evaluate(evaluator, T_Boolean, A_symbol_25, A_symbol_28);
			return A_symbol_23;
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
			
			Value leftA_symbol_29;
			try {
				
				Value A_symbol_30 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_31 = valueFactory.typeOf(A_symbol_30, S_any);
				LibraryBinaryOperation dynamic_A_symbol_31 = (LibraryBinaryOperation)static_A_symbol_31.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_31 = dynamic_A_symbol_31.evaluate(evaluator, T_Boolean, A_symbol_30, S_any);
				leftA_symbol_29 = A_symbol_31;
			} catch (InvalidValueException e) {
				leftA_symbol_29 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_31 = leftA_symbol_29;
			Value rightA_symbol_29;
			try {
				
				Value A_symbol_32 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_Pivot_ecore__pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_33 = valueFactory.typeOf(A_symbol_32);
				LibraryUnaryOperation dynamic_A_symbol_33 = (LibraryUnaryOperation)static_A_symbol_33.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_33 = dynamic_A_symbol_33.evaluate(evaluator, T_Integer, A_symbol_32);
				DomainType static_A_symbol_34 = valueFactory.typeOf(A_symbol_33, I_1);
				LibraryBinaryOperation dynamic_A_symbol_34 = (LibraryBinaryOperation)static_A_symbol_34.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_34 = dynamic_A_symbol_34.evaluate(evaluator, T_Boolean, A_symbol_33, I_1);
				rightA_symbol_29 = A_symbol_34;
			} catch (InvalidValueException e) {
				rightA_symbol_29 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_34 = rightA_symbol_29;
			DomainType static_A_symbol_29 = valueFactory.typeOf(A_symbol_31);
			LibraryBinaryOperation dynamic_A_symbol_29 = (LibraryBinaryOperation)static_A_symbol_29.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_29 = dynamic_A_symbol_29.evaluate(evaluator, T_Boolean, A_symbol_31, A_symbol_34);
			return A_symbol_29;
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
			
			Value leftA_symbol_35;
			try {
				
				Value A_symbol_36 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_37 = valueFactory.typeOf(A_symbol_36, S_any);
				LibraryBinaryOperation dynamic_A_symbol_37 = (LibraryBinaryOperation)static_A_symbol_37.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_37 = dynamic_A_symbol_37.evaluate(evaluator, T_Boolean, A_symbol_36, S_any);
				leftA_symbol_35 = A_symbol_37;
			} catch (InvalidValueException e) {
				leftA_symbol_35 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_37 = leftA_symbol_35;
			Value rightA_symbol_35;
			try {
				
				Value A_symbol_38 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				
				Value A_symbol_39 = IP_CallExp_source.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_CallExp_source);
				
				Value A_symbol_40 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_39, P_TypedElement_type);
				
				DomainType static_A_symbol_41 = valueFactory.typeOf(A_symbol_40);
				LibraryBinaryOperation dynamic_A_symbol_41 = (LibraryBinaryOperation)static_A_symbol_41.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_41 = dynamic_A_symbol_41.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionType, A_symbol_40, T_ClassClassifier_Pivot_ecore__pivot__CollectionType_);
				Value A_symbol_42 = IP_CollectionType_elementType.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_41, P_CollectionType_elementType);
				
				DomainType static_A_symbol_43 = valueFactory.typeOf(A_symbol_38, A_symbol_42);
				LibraryBinaryOperation dynamic_A_symbol_43 = (LibraryBinaryOperation)static_A_symbol_43.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_43 = dynamic_A_symbol_43.evaluate(evaluator, T_Boolean, A_symbol_38, A_symbol_42);
				rightA_symbol_35 = A_symbol_43;
			} catch (InvalidValueException e) {
				rightA_symbol_35 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_43 = rightA_symbol_35;
			DomainType static_A_symbol_35 = valueFactory.typeOf(A_symbol_37);
			LibraryBinaryOperation dynamic_A_symbol_35 = (LibraryBinaryOperation)static_A_symbol_35.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_35 = dynamic_A_symbol_35.evaluate(evaluator, T_Boolean, A_symbol_37, A_symbol_43);
			return A_symbol_35;
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
			
			Value leftA_symbol_44;
			try {
				
				Value A_symbol_45 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_46 = valueFactory.typeOf(A_symbol_45, S_closure);
				LibraryBinaryOperation dynamic_A_symbol_46 = (LibraryBinaryOperation)static_A_symbol_46.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_46 = dynamic_A_symbol_46.evaluate(evaluator, T_Boolean, A_symbol_45, S_closure);
				leftA_symbol_44 = A_symbol_46;
			} catch (InvalidValueException e) {
				leftA_symbol_44 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_46 = leftA_symbol_44;
			Value rightA_symbol_44;
			try {
				
				Value A_symbol_47 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_48 = valueFactory.typeOf(A_symbol_47);
				LibraryBinaryOperation dynamic_A_symbol_48 = (LibraryBinaryOperation)static_A_symbol_48.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_48 = dynamic_A_symbol_48.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionType, A_symbol_47, T_ClassClassifier_Pivot_ecore__pivot__CollectionType_);
				Value A_symbol_49 = IP_CollectionType_elementType.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_48, P_CollectionType_elementType);
				
				
				Value A_symbol_50 = IP_CallExp_source.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_CallExp_source);
				
				Value A_symbol_51 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_50, P_TypedElement_type);
				
				DomainType static_A_symbol_52 = valueFactory.typeOf(A_symbol_51);
				LibraryBinaryOperation dynamic_A_symbol_52 = (LibraryBinaryOperation)static_A_symbol_52.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_52 = dynamic_A_symbol_52.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionType, A_symbol_51, T_ClassClassifier_Pivot_ecore__pivot__CollectionType_);
				Value A_symbol_53 = IP_CollectionType_elementType.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_52, P_CollectionType_elementType);
				
				DomainType static_A_symbol_54 = valueFactory.typeOf(A_symbol_49, A_symbol_53);
				LibraryBinaryOperation dynamic_A_symbol_54 = (LibraryBinaryOperation)static_A_symbol_54.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_54 = dynamic_A_symbol_54.evaluate(evaluator, T_Boolean, A_symbol_49, A_symbol_53);
				rightA_symbol_44 = A_symbol_54;
			} catch (InvalidValueException e) {
				rightA_symbol_44 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_54 = rightA_symbol_44;
			DomainType static_A_symbol_44 = valueFactory.typeOf(A_symbol_46);
			LibraryBinaryOperation dynamic_A_symbol_44 = (LibraryBinaryOperation)static_A_symbol_44.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_44 = dynamic_A_symbol_44.evaluate(evaluator, T_Boolean, A_symbol_46, A_symbol_54);
			return A_symbol_44;
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
			
			Value leftA_symbol_55;
			try {
				
				Value A_symbol_56 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_57 = valueFactory.typeOf(A_symbol_56, S_closure);
				LibraryBinaryOperation dynamic_A_symbol_57 = (LibraryBinaryOperation)static_A_symbol_57.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_57 = dynamic_A_symbol_57.evaluate(evaluator, T_Boolean, A_symbol_56, S_closure);
				leftA_symbol_55 = A_symbol_57;
			} catch (InvalidValueException e) {
				leftA_symbol_55 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_57 = leftA_symbol_55;
			Value rightA_symbol_55;
			try {
				
				Value A_symbol_58 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_Pivot_ecore__pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_59 = valueFactory.typeOf(A_symbol_58);
				LibraryUnaryOperation dynamic_A_symbol_59 = (LibraryUnaryOperation)static_A_symbol_59.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_59 = dynamic_A_symbol_59.evaluate(evaluator, T_Integer, A_symbol_58);
				DomainType static_A_symbol_60 = valueFactory.typeOf(A_symbol_59, I_1);
				LibraryBinaryOperation dynamic_A_symbol_60 = (LibraryBinaryOperation)static_A_symbol_60.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_60 = dynamic_A_symbol_60.evaluate(evaluator, T_Boolean, A_symbol_59, I_1);
				rightA_symbol_55 = A_symbol_60;
			} catch (InvalidValueException e) {
				rightA_symbol_55 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_60 = rightA_symbol_55;
			DomainType static_A_symbol_55 = valueFactory.typeOf(A_symbol_57);
			LibraryBinaryOperation dynamic_A_symbol_55 = (LibraryBinaryOperation)static_A_symbol_55.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_55 = dynamic_A_symbol_55.evaluate(evaluator, T_Boolean, A_symbol_57, A_symbol_60);
			return A_symbol_55;
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
			
			Value leftA_symbol_61;
			try {
				
				Value A_symbol_62 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_63 = valueFactory.typeOf(A_symbol_62, S_closure);
				LibraryBinaryOperation dynamic_A_symbol_63 = (LibraryBinaryOperation)static_A_symbol_63.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_63 = dynamic_A_symbol_63.evaluate(evaluator, T_Boolean, A_symbol_62, S_closure);
				leftA_symbol_61 = A_symbol_63;
			} catch (InvalidValueException e) {
				leftA_symbol_61 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_63 = leftA_symbol_61;
			Value rightA_symbol_61;
			try {
				
				Value A_symbol_64 = IP_CallExp_source.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_CallExp_source);
				
				Value A_symbol_65 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_64, P_TypedElement_type);
				
				DomainType static_A_symbol_66 = valueFactory.typeOf(A_symbol_65);
				LibraryBinaryOperation dynamic_A_symbol_66 = (LibraryBinaryOperation)static_A_symbol_66.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_66 = dynamic_A_symbol_66.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionType, A_symbol_65, T_ClassClassifier_Pivot_ecore__pivot__CollectionType_);
				Value A_symbol_67 = IP_CollectionType_elementType.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_66, P_CollectionType_elementType);
				
					
					Value A_symbol_68 = IP_LoopExp_body.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_LoopExp_body);
					
					Value A_symbol_69 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_68, P_TypedElement_type);
					
					DomainType static_A_symbol_70 = valueFactory.typeOf(A_symbol_69);
					LibraryBinaryOperation dynamic_A_symbol_70 = (LibraryBinaryOperation)static_A_symbol_70.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Value A_symbol_70 = dynamic_A_symbol_70.evaluate(evaluator, T_Boolean, A_symbol_69, T_ClassClassifier_Pivot_ecore__pivot__CollectionType_);
				Value A_symbol_71;
				if (A_symbol_70.isTrue()) {
					
					Value A_symbol_72 = IP_LoopExp_body.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_LoopExp_body);
					
					Value A_symbol_73 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_72, P_TypedElement_type);
					
					DomainType static_A_symbol_74 = valueFactory.typeOf(A_symbol_73);
					LibraryBinaryOperation dynamic_A_symbol_74 = (LibraryBinaryOperation)static_A_symbol_74.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
					Value A_symbol_74 = dynamic_A_symbol_74.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionType, A_symbol_73, T_ClassClassifier_Pivot_ecore__pivot__CollectionType_);
					Value A_symbol_75 = IP_CollectionType_elementType.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_74, P_CollectionType_elementType);
					
					A_symbol_71 = A_symbol_75;
				}
				else if (A_symbol_70.isFalse()) {
					
					Value A_symbol_76 = IP_LoopExp_body.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_LoopExp_body);
					
					Value A_symbol_77 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_76, P_TypedElement_type);
					
					A_symbol_71 = A_symbol_77;
				}
				else if (A_symbol_70.isNull()) {
					A_symbol_71 = valueFactory.throwInvalidValueException("null if condition");
				}
				else {
					A_symbol_71 = valueFactory.throwInvalidValueException("invalid if condition");
				}
				DomainType static_A_symbol_78 = valueFactory.typeOf(A_symbol_67, A_symbol_71);
				LibraryBinaryOperation dynamic_A_symbol_78 = (LibraryBinaryOperation)static_A_symbol_78.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_78 = dynamic_A_symbol_78.evaluate(evaluator, T_Boolean, A_symbol_67, A_symbol_71);
				rightA_symbol_61 = A_symbol_78;
			} catch (InvalidValueException e) {
				rightA_symbol_61 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_78 = rightA_symbol_61;
			DomainType static_A_symbol_61 = valueFactory.typeOf(A_symbol_63);
			LibraryBinaryOperation dynamic_A_symbol_61 = (LibraryBinaryOperation)static_A_symbol_61.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_61 = dynamic_A_symbol_61.evaluate(evaluator, T_Boolean, A_symbol_63, A_symbol_78);
			return A_symbol_61;
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
			
			Value leftA_symbol_79;
			try {
				
				Value A_symbol_80 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_81 = valueFactory.typeOf(A_symbol_80, S_closure);
				LibraryBinaryOperation dynamic_A_symbol_81 = (LibraryBinaryOperation)static_A_symbol_81.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_81 = dynamic_A_symbol_81.evaluate(evaluator, T_Boolean, A_symbol_80, S_closure);
				leftA_symbol_79 = A_symbol_81;
			} catch (InvalidValueException e) {
				leftA_symbol_79 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_81 = leftA_symbol_79;
			Value rightA_symbol_79;
			try {
					Value leftA_symbol_82;
					try {
						
						Value A_symbol_83 = IP_CallExp_source.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_CallExp_source);
						
						Value A_symbol_84 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_83, P_TypedElement_type);
						
						DomainType static_A_symbol_85 = valueFactory.typeOf(A_symbol_84);
						LibraryBinaryOperation dynamic_A_symbol_85 = (LibraryBinaryOperation)static_A_symbol_85.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Value A_symbol_85 = dynamic_A_symbol_85.evaluate(evaluator, T_Boolean, A_symbol_84, T_ClassClassifier_Pivot_ecore__pivot__SequenceType_);
						leftA_symbol_82 = A_symbol_85;
					} catch (InvalidValueException e) {
						leftA_symbol_82 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_85 = leftA_symbol_82;
					Value rightA_symbol_82;
					try {
						
						Value A_symbol_86 = IP_CallExp_source.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_CallExp_source);
						
						Value A_symbol_87 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_86, P_TypedElement_type);
						
						DomainType static_A_symbol_88 = valueFactory.typeOf(A_symbol_87);
						LibraryBinaryOperation dynamic_A_symbol_88 = (LibraryBinaryOperation)static_A_symbol_88.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Value A_symbol_88 = dynamic_A_symbol_88.evaluate(evaluator, T_Boolean, A_symbol_87, T_ClassClassifier_Pivot_ecore__pivot__OrderedSetType_);
						rightA_symbol_82 = A_symbol_88;
					} catch (InvalidValueException e) {
						rightA_symbol_82 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_88 = rightA_symbol_82;
					DomainType static_A_symbol_82 = valueFactory.typeOf(A_symbol_85);
					LibraryBinaryOperation dynamic_A_symbol_82 = (LibraryBinaryOperation)static_A_symbol_82.lookupImplementation(standardLibrary, O_Boolean_or);
					Value A_symbol_82 = dynamic_A_symbol_82.evaluate(evaluator, T_Boolean, A_symbol_85, A_symbol_88);
				Value A_symbol_89;
				if (A_symbol_82.isTrue()) {
					
					Value A_symbol_90 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
					
					DomainType static_A_symbol_91 = valueFactory.typeOf(A_symbol_90);
					LibraryBinaryOperation dynamic_A_symbol_91 = (LibraryBinaryOperation)static_A_symbol_91.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Value A_symbol_91 = dynamic_A_symbol_91.evaluate(evaluator, T_Boolean, A_symbol_90, T_ClassClassifier_Pivot_ecore__pivot__OrderedSetType_);
					A_symbol_89 = A_symbol_91;
				}
				else if (A_symbol_82.isFalse()) {
					
					Value A_symbol_92 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
					
					DomainType static_A_symbol_93 = valueFactory.typeOf(A_symbol_92);
					LibraryBinaryOperation dynamic_A_symbol_93 = (LibraryBinaryOperation)static_A_symbol_93.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Value A_symbol_93 = dynamic_A_symbol_93.evaluate(evaluator, T_Boolean, A_symbol_92, T_ClassClassifier_Pivot_ecore__pivot__SetType_);
					A_symbol_89 = A_symbol_93;
				}
				else if (A_symbol_82.isNull()) {
					A_symbol_89 = valueFactory.throwInvalidValueException("null if condition");
				}
				else {
					A_symbol_89 = valueFactory.throwInvalidValueException("invalid if condition");
				}
				rightA_symbol_79 = A_symbol_89;
			} catch (InvalidValueException e) {
				rightA_symbol_79 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_89 = rightA_symbol_79;
			DomainType static_A_symbol_79 = valueFactory.typeOf(A_symbol_81);
			LibraryBinaryOperation dynamic_A_symbol_79 = (LibraryBinaryOperation)static_A_symbol_79.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_79 = dynamic_A_symbol_79.evaluate(evaluator, T_Boolean, A_symbol_81, A_symbol_89);
			return A_symbol_79;
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
			
			Value leftA_symbol_94;
			try {
				
				Value A_symbol_95 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_96 = valueFactory.typeOf(A_symbol_95, S_collect);
				LibraryBinaryOperation dynamic_A_symbol_96 = (LibraryBinaryOperation)static_A_symbol_96.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_96 = dynamic_A_symbol_96.evaluate(evaluator, T_Boolean, A_symbol_95, S_collect);
				leftA_symbol_94 = A_symbol_96;
			} catch (InvalidValueException e) {
				leftA_symbol_94 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_96 = leftA_symbol_94;
			Value rightA_symbol_94;
			try {
				
				Value A_symbol_97 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_98 = valueFactory.typeOf(A_symbol_97);
				LibraryBinaryOperation dynamic_A_symbol_98 = (LibraryBinaryOperation)static_A_symbol_98.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_98 = dynamic_A_symbol_98.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionType, A_symbol_97, T_ClassClassifier_Pivot_ecore__pivot__CollectionType_);
				Value A_symbol_99 = IP_CollectionType_elementType.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_98, P_CollectionType_elementType);
				
				
				Value A_symbol_100 = IP_LoopExp_body.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_LoopExp_body);
				
				Value A_symbol_101 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_100, P_TypedElement_type);
				
				DomainType static_A_symbol_102 = valueFactory.typeOf(A_symbol_101);
				LibraryBinaryOperation dynamic_A_symbol_102 = (LibraryBinaryOperation)static_A_symbol_102.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_102 = dynamic_A_symbol_102.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionType, A_symbol_101, T_ClassClassifier_Pivot_ecore__pivot__CollectionType_);
				Value A_symbol_103 = IP_CollectionType_elementType.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_102, P_CollectionType_elementType);
				
				DomainType static_A_symbol_104 = valueFactory.typeOf(A_symbol_99, A_symbol_103);
				LibraryBinaryOperation dynamic_A_symbol_104 = (LibraryBinaryOperation)static_A_symbol_104.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_104 = dynamic_A_symbol_104.evaluate(evaluator, T_Boolean, A_symbol_99, A_symbol_103);
				rightA_symbol_94 = A_symbol_104;
			} catch (InvalidValueException e) {
				rightA_symbol_94 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_104 = rightA_symbol_94;
			DomainType static_A_symbol_94 = valueFactory.typeOf(A_symbol_96);
			LibraryBinaryOperation dynamic_A_symbol_94 = (LibraryBinaryOperation)static_A_symbol_94.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_94 = dynamic_A_symbol_94.evaluate(evaluator, T_Boolean, A_symbol_96, A_symbol_104);
			return A_symbol_94;
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
			
			Value leftA_symbol_105;
			try {
				
				Value A_symbol_106 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_107 = valueFactory.typeOf(A_symbol_106, S_collect);
				LibraryBinaryOperation dynamic_A_symbol_107 = (LibraryBinaryOperation)static_A_symbol_107.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_107 = dynamic_A_symbol_107.evaluate(evaluator, T_Boolean, A_symbol_106, S_collect);
				leftA_symbol_105 = A_symbol_107;
			} catch (InvalidValueException e) {
				leftA_symbol_105 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_107 = leftA_symbol_105;
			Value rightA_symbol_105;
			try {
				
				Value A_symbol_108 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_Pivot_ecore__pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_109 = valueFactory.typeOf(A_symbol_108);
				LibraryUnaryOperation dynamic_A_symbol_109 = (LibraryUnaryOperation)static_A_symbol_109.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_109 = dynamic_A_symbol_109.evaluate(evaluator, T_Integer, A_symbol_108);
				DomainType static_A_symbol_110 = valueFactory.typeOf(A_symbol_109, I_1);
				LibraryBinaryOperation dynamic_A_symbol_110 = (LibraryBinaryOperation)static_A_symbol_110.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_110 = dynamic_A_symbol_110.evaluate(evaluator, T_Boolean, A_symbol_109, I_1);
				rightA_symbol_105 = A_symbol_110;
			} catch (InvalidValueException e) {
				rightA_symbol_105 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_110 = rightA_symbol_105;
			DomainType static_A_symbol_105 = valueFactory.typeOf(A_symbol_107);
			LibraryBinaryOperation dynamic_A_symbol_105 = (LibraryBinaryOperation)static_A_symbol_105.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_105 = dynamic_A_symbol_105.evaluate(evaluator, T_Boolean, A_symbol_107, A_symbol_110);
			return A_symbol_105;
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
			
			Value leftA_symbol_111;
			try {
				
				Value A_symbol_112 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_113 = valueFactory.typeOf(A_symbol_112, S_collectN___);
				LibraryBinaryOperation dynamic_A_symbol_113 = (LibraryBinaryOperation)static_A_symbol_113.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_113 = dynamic_A_symbol_113.evaluate(evaluator, T_Boolean, A_symbol_112, S_collectN___);
				leftA_symbol_111 = A_symbol_113;
			} catch (InvalidValueException e) {
				leftA_symbol_111 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_113 = leftA_symbol_111;
			Value rightA_symbol_111;
			try {
				
				Value A_symbol_114 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_Pivot_ecore__pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_115 = valueFactory.typeOf(A_symbol_114);
				LibraryUnaryOperation dynamic_A_symbol_115 = (LibraryUnaryOperation)static_A_symbol_115.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_115 = dynamic_A_symbol_115.evaluate(evaluator, T_Integer, A_symbol_114);
				DomainType static_A_symbol_116 = valueFactory.typeOf(A_symbol_115, I_1);
				LibraryBinaryOperation dynamic_A_symbol_116 = (LibraryBinaryOperation)static_A_symbol_116.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_116 = dynamic_A_symbol_116.evaluate(evaluator, T_Boolean, A_symbol_115, I_1);
				rightA_symbol_111 = A_symbol_116;
			} catch (InvalidValueException e) {
				rightA_symbol_111 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_116 = rightA_symbol_111;
			DomainType static_A_symbol_111 = valueFactory.typeOf(A_symbol_113);
			LibraryBinaryOperation dynamic_A_symbol_111 = (LibraryBinaryOperation)static_A_symbol_111.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_111 = dynamic_A_symbol_111.evaluate(evaluator, T_Boolean, A_symbol_113, A_symbol_116);
			return A_symbol_111;
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
				
				DomainType static_A_symbol_121 = valueFactory.typeOf(A_symbol_120);
				LibraryBinaryOperation dynamic_A_symbol_121 = (LibraryBinaryOperation)static_A_symbol_121.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
				Value A_symbol_121 = dynamic_A_symbol_121.evaluate(evaluator, T_Boolean, A_symbol_120, T_ClassClassifier_Pivot_ecore__pivot__BagType_);
				rightA_symbol_117 = A_symbol_121;
			} catch (InvalidValueException e) {
				rightA_symbol_117 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_121 = rightA_symbol_117;
			DomainType static_A_symbol_117 = valueFactory.typeOf(A_symbol_119);
			LibraryBinaryOperation dynamic_A_symbol_117 = (LibraryBinaryOperation)static_A_symbol_117.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_117 = dynamic_A_symbol_117.evaluate(evaluator, T_Boolean, A_symbol_119, A_symbol_121);
			return A_symbol_117;
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
			
			Value leftA_symbol_122;
			try {
				
				Value A_symbol_123 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_124 = valueFactory.typeOf(A_symbol_123, S_collectN___);
				LibraryBinaryOperation dynamic_A_symbol_124 = (LibraryBinaryOperation)static_A_symbol_124.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_124 = dynamic_A_symbol_124.evaluate(evaluator, T_Boolean, A_symbol_123, S_collectN___);
				leftA_symbol_122 = A_symbol_124;
			} catch (InvalidValueException e) {
				leftA_symbol_122 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_124 = leftA_symbol_122;
			Value rightA_symbol_122;
			try {
				
				Value A_symbol_125 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				
				Value A_symbol_126 = IP_LoopExp_body.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_LoopExp_body);
				
				Value A_symbol_127 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_126, P_TypedElement_type);
				
				DomainType static_A_symbol_128 = valueFactory.typeOf(A_symbol_125, A_symbol_127);
				LibraryBinaryOperation dynamic_A_symbol_128 = (LibraryBinaryOperation)static_A_symbol_128.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_128 = dynamic_A_symbol_128.evaluate(evaluator, T_Boolean, A_symbol_125, A_symbol_127);
				rightA_symbol_122 = A_symbol_128;
			} catch (InvalidValueException e) {
				rightA_symbol_122 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_128 = rightA_symbol_122;
			DomainType static_A_symbol_122 = valueFactory.typeOf(A_symbol_124);
			LibraryBinaryOperation dynamic_A_symbol_122 = (LibraryBinaryOperation)static_A_symbol_122.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_122 = dynamic_A_symbol_122.evaluate(evaluator, T_Boolean, A_symbol_124, A_symbol_128);
			return A_symbol_122;
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
			
			Value leftA_symbol_129;
			try {
				
				Value A_symbol_130 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_131 = valueFactory.typeOf(A_symbol_130, S_collect);
				LibraryBinaryOperation dynamic_A_symbol_131 = (LibraryBinaryOperation)static_A_symbol_131.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_131 = dynamic_A_symbol_131.evaluate(evaluator, T_Boolean, A_symbol_130, S_collect);
				leftA_symbol_129 = A_symbol_131;
			} catch (InvalidValueException e) {
				leftA_symbol_129 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_131 = leftA_symbol_129;
			Value rightA_symbol_129;
			try {
					Value leftA_symbol_132;
					try {
						
						Value A_symbol_133 = IP_CallExp_source.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_CallExp_source);
						
						Value A_symbol_134 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_133, P_TypedElement_type);
						
						DomainType static_A_symbol_135 = valueFactory.typeOf(A_symbol_134);
						LibraryBinaryOperation dynamic_A_symbol_135 = (LibraryBinaryOperation)static_A_symbol_135.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Value A_symbol_135 = dynamic_A_symbol_135.evaluate(evaluator, T_Boolean, A_symbol_134, T_ClassClassifier_Pivot_ecore__pivot__SequenceType_);
						leftA_symbol_132 = A_symbol_135;
					} catch (InvalidValueException e) {
						leftA_symbol_132 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_135 = leftA_symbol_132;
					Value rightA_symbol_132;
					try {
						
						Value A_symbol_136 = IP_CallExp_source.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_CallExp_source);
						
						Value A_symbol_137 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_136, P_TypedElement_type);
						
						DomainType static_A_symbol_138 = valueFactory.typeOf(A_symbol_137);
						LibraryBinaryOperation dynamic_A_symbol_138 = (LibraryBinaryOperation)static_A_symbol_138.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Value A_symbol_138 = dynamic_A_symbol_138.evaluate(evaluator, T_Boolean, A_symbol_137, T_ClassClassifier_Pivot_ecore__pivot__OrderedSetType_);
						rightA_symbol_132 = A_symbol_138;
					} catch (InvalidValueException e) {
						rightA_symbol_132 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_138 = rightA_symbol_132;
					DomainType static_A_symbol_132 = valueFactory.typeOf(A_symbol_135);
					LibraryBinaryOperation dynamic_A_symbol_132 = (LibraryBinaryOperation)static_A_symbol_132.lookupImplementation(standardLibrary, O_Boolean_or);
					Value A_symbol_132 = dynamic_A_symbol_132.evaluate(evaluator, T_Boolean, A_symbol_135, A_symbol_138);
				Value A_symbol_139;
				if (A_symbol_132.isTrue()) {
					
					Value A_symbol_140 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
					
					DomainType static_A_symbol_141 = valueFactory.typeOf(A_symbol_140);
					LibraryBinaryOperation dynamic_A_symbol_141 = (LibraryBinaryOperation)static_A_symbol_141.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Value A_symbol_141 = dynamic_A_symbol_141.evaluate(evaluator, T_Boolean, A_symbol_140, T_ClassClassifier_Pivot_ecore__pivot__SequenceType_);
					A_symbol_139 = A_symbol_141;
				}
				else if (A_symbol_132.isFalse()) {
					
					Value A_symbol_142 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
					
					DomainType static_A_symbol_143 = valueFactory.typeOf(A_symbol_142);
					LibraryBinaryOperation dynamic_A_symbol_143 = (LibraryBinaryOperation)static_A_symbol_143.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Value A_symbol_143 = dynamic_A_symbol_143.evaluate(evaluator, T_Boolean, A_symbol_142, T_ClassClassifier_Pivot_ecore__pivot__BagType_);
					A_symbol_139 = A_symbol_143;
				}
				else if (A_symbol_132.isNull()) {
					A_symbol_139 = valueFactory.throwInvalidValueException("null if condition");
				}
				else {
					A_symbol_139 = valueFactory.throwInvalidValueException("invalid if condition");
				}
				rightA_symbol_129 = A_symbol_139;
			} catch (InvalidValueException e) {
				rightA_symbol_129 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_139 = rightA_symbol_129;
			DomainType static_A_symbol_129 = valueFactory.typeOf(A_symbol_131);
			LibraryBinaryOperation dynamic_A_symbol_129 = (LibraryBinaryOperation)static_A_symbol_129.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_129 = dynamic_A_symbol_129.evaluate(evaluator, T_Boolean, A_symbol_131, A_symbol_139);
			return A_symbol_129;
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
			
			Value leftA_symbol_144;
			try {
				
				Value A_symbol_145 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_146 = valueFactory.typeOf(A_symbol_145, S_exists);
				LibraryBinaryOperation dynamic_A_symbol_146 = (LibraryBinaryOperation)static_A_symbol_146.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_146 = dynamic_A_symbol_146.evaluate(evaluator, T_Boolean, A_symbol_145, S_exists);
				leftA_symbol_144 = A_symbol_146;
			} catch (InvalidValueException e) {
				leftA_symbol_144 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_146 = leftA_symbol_144;
			Value rightA_symbol_144;
			try {
				
				Value A_symbol_147 = IP_LoopExp_body.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_LoopExp_body);
				
				Value A_symbol_148 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_147, P_TypedElement_type);
				
				DomainType static_A_symbol_149 = valueFactory.typeOf(A_symbol_148, T_ClassClassifier_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_149 = (LibraryBinaryOperation)static_A_symbol_149.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_149 = dynamic_A_symbol_149.evaluate(evaluator, T_Boolean, A_symbol_148, T_ClassClassifier_Boolean_);
				rightA_symbol_144 = A_symbol_149;
			} catch (InvalidValueException e) {
				rightA_symbol_144 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_149 = rightA_symbol_144;
			DomainType static_A_symbol_144 = valueFactory.typeOf(A_symbol_146);
			LibraryBinaryOperation dynamic_A_symbol_144 = (LibraryBinaryOperation)static_A_symbol_144.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_144 = dynamic_A_symbol_144.evaluate(evaluator, T_Boolean, A_symbol_146, A_symbol_149);
			return A_symbol_144;
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
			
			Value leftA_symbol_150;
			try {
				
				Value A_symbol_151 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_152 = valueFactory.typeOf(A_symbol_151, S_exists);
				LibraryBinaryOperation dynamic_A_symbol_152 = (LibraryBinaryOperation)static_A_symbol_152.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_152 = dynamic_A_symbol_152.evaluate(evaluator, T_Boolean, A_symbol_151, S_exists);
				leftA_symbol_150 = A_symbol_152;
			} catch (InvalidValueException e) {
				leftA_symbol_150 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_152 = leftA_symbol_150;
			Value rightA_symbol_150;
			try {
				
				Value A_symbol_153 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_154 = valueFactory.typeOf(A_symbol_153, T_ClassClassifier_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_154 = (LibraryBinaryOperation)static_A_symbol_154.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_154 = dynamic_A_symbol_154.evaluate(evaluator, T_Boolean, A_symbol_153, T_ClassClassifier_Boolean_);
				rightA_symbol_150 = A_symbol_154;
			} catch (InvalidValueException e) {
				rightA_symbol_150 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_154 = rightA_symbol_150;
			DomainType static_A_symbol_150 = valueFactory.typeOf(A_symbol_152);
			LibraryBinaryOperation dynamic_A_symbol_150 = (LibraryBinaryOperation)static_A_symbol_150.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_150 = dynamic_A_symbol_150.evaluate(evaluator, T_Boolean, A_symbol_152, A_symbol_154);
			return A_symbol_150;
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
			
			Value leftA_symbol_155;
			try {
				
				Value A_symbol_156 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_157 = valueFactory.typeOf(A_symbol_156, S_forAll);
				LibraryBinaryOperation dynamic_A_symbol_157 = (LibraryBinaryOperation)static_A_symbol_157.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_157 = dynamic_A_symbol_157.evaluate(evaluator, T_Boolean, A_symbol_156, S_forAll);
				leftA_symbol_155 = A_symbol_157;
			} catch (InvalidValueException e) {
				leftA_symbol_155 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_157 = leftA_symbol_155;
			Value rightA_symbol_155;
			try {
				
				Value A_symbol_158 = IP_LoopExp_body.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_LoopExp_body);
				
				Value A_symbol_159 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_158, P_TypedElement_type);
				
				DomainType static_A_symbol_160 = valueFactory.typeOf(A_symbol_159, T_ClassClassifier_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_160 = (LibraryBinaryOperation)static_A_symbol_160.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_160 = dynamic_A_symbol_160.evaluate(evaluator, T_Boolean, A_symbol_159, T_ClassClassifier_Boolean_);
				rightA_symbol_155 = A_symbol_160;
			} catch (InvalidValueException e) {
				rightA_symbol_155 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_160 = rightA_symbol_155;
			DomainType static_A_symbol_155 = valueFactory.typeOf(A_symbol_157);
			LibraryBinaryOperation dynamic_A_symbol_155 = (LibraryBinaryOperation)static_A_symbol_155.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_155 = dynamic_A_symbol_155.evaluate(evaluator, T_Boolean, A_symbol_157, A_symbol_160);
			return A_symbol_155;
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
			
			Value leftA_symbol_161;
			try {
				
				Value A_symbol_162 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_163 = valueFactory.typeOf(A_symbol_162, S_forAll);
				LibraryBinaryOperation dynamic_A_symbol_163 = (LibraryBinaryOperation)static_A_symbol_163.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_163 = dynamic_A_symbol_163.evaluate(evaluator, T_Boolean, A_symbol_162, S_forAll);
				leftA_symbol_161 = A_symbol_163;
			} catch (InvalidValueException e) {
				leftA_symbol_161 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_163 = leftA_symbol_161;
			Value rightA_symbol_161;
			try {
				
				Value A_symbol_164 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_165 = valueFactory.typeOf(A_symbol_164, T_ClassClassifier_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_165 = (LibraryBinaryOperation)static_A_symbol_165.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_165 = dynamic_A_symbol_165.evaluate(evaluator, T_Boolean, A_symbol_164, T_ClassClassifier_Boolean_);
				rightA_symbol_161 = A_symbol_165;
			} catch (InvalidValueException e) {
				rightA_symbol_161 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_165 = rightA_symbol_161;
			DomainType static_A_symbol_161 = valueFactory.typeOf(A_symbol_163);
			LibraryBinaryOperation dynamic_A_symbol_161 = (LibraryBinaryOperation)static_A_symbol_161.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_161 = dynamic_A_symbol_161.evaluate(evaluator, T_Boolean, A_symbol_163, A_symbol_165);
			return A_symbol_161;
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
			
			Value leftA_symbol_166;
			try {
				
				Value A_symbol_167 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_168 = valueFactory.typeOf(A_symbol_167, S_isUnique);
				LibraryBinaryOperation dynamic_A_symbol_168 = (LibraryBinaryOperation)static_A_symbol_168.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_168 = dynamic_A_symbol_168.evaluate(evaluator, T_Boolean, A_symbol_167, S_isUnique);
				leftA_symbol_166 = A_symbol_168;
			} catch (InvalidValueException e) {
				leftA_symbol_166 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_168 = leftA_symbol_166;
			Value rightA_symbol_166;
			try {
				
				Value A_symbol_169 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_Pivot_ecore__pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_170 = valueFactory.typeOf(A_symbol_169);
				LibraryUnaryOperation dynamic_A_symbol_170 = (LibraryUnaryOperation)static_A_symbol_170.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_170 = dynamic_A_symbol_170.evaluate(evaluator, T_Integer, A_symbol_169);
				DomainType static_A_symbol_171 = valueFactory.typeOf(A_symbol_170, I_1);
				LibraryBinaryOperation dynamic_A_symbol_171 = (LibraryBinaryOperation)static_A_symbol_171.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_171 = dynamic_A_symbol_171.evaluate(evaluator, T_Boolean, A_symbol_170, I_1);
				rightA_symbol_166 = A_symbol_171;
			} catch (InvalidValueException e) {
				rightA_symbol_166 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_171 = rightA_symbol_166;
			DomainType static_A_symbol_166 = valueFactory.typeOf(A_symbol_168);
			LibraryBinaryOperation dynamic_A_symbol_166 = (LibraryBinaryOperation)static_A_symbol_166.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_166 = dynamic_A_symbol_166.evaluate(evaluator, T_Boolean, A_symbol_168, A_symbol_171);
			return A_symbol_166;
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
			
			Value leftA_symbol_172;
			try {
				
				Value A_symbol_173 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_174 = valueFactory.typeOf(A_symbol_173, S_isUnique);
				LibraryBinaryOperation dynamic_A_symbol_174 = (LibraryBinaryOperation)static_A_symbol_174.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_174 = dynamic_A_symbol_174.evaluate(evaluator, T_Boolean, A_symbol_173, S_isUnique);
				leftA_symbol_172 = A_symbol_174;
			} catch (InvalidValueException e) {
				leftA_symbol_172 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_174 = leftA_symbol_172;
			Value rightA_symbol_172;
			try {
				
				Value A_symbol_175 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_176 = valueFactory.typeOf(A_symbol_175, T_ClassClassifier_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_176 = (LibraryBinaryOperation)static_A_symbol_176.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_176 = dynamic_A_symbol_176.evaluate(evaluator, T_Boolean, A_symbol_175, T_ClassClassifier_Boolean_);
				rightA_symbol_172 = A_symbol_176;
			} catch (InvalidValueException e) {
				rightA_symbol_172 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_176 = rightA_symbol_172;
			DomainType static_A_symbol_172 = valueFactory.typeOf(A_symbol_174);
			LibraryBinaryOperation dynamic_A_symbol_172 = (LibraryBinaryOperation)static_A_symbol_172.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_172 = dynamic_A_symbol_172.evaluate(evaluator, T_Boolean, A_symbol_174, A_symbol_176);
			return A_symbol_172;
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
			
			
			Value A_symbol_177 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_Pivot_ecore__pivot__Variable_, self, P_LoopExp_iterator);
			
			
			/** 
			 * Implementation of the iterator body.
			 */
			AbstractBinaryOperation body_A_symbol_178 = new AbstractBinaryOperation()
			{
			/*
			type =
			source.type.oclAsType(_'file:/C:/GIT/org.eclipse.ocl/examples/org.eclipse.ocl.examples.pivot/model/Pivot.ecore'::ocl::CollectionType).elementType
			*/
				public Value evaluate(DomainEvaluator evaluator, DomainType returnType, Value sourceValue, Value iterator1) throws InvalidValueException {
					final Value V_1_ = iterator1;	// iterator: 1_
					
					Value A_symbol_179 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, V_1_, P_TypedElement_type);
					
					
					Value A_symbol_180 = IP_CallExp_source.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_CallExp_source);
					
					Value A_symbol_181 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_180, P_TypedElement_type);
					
					DomainType static_A_symbol_182 = valueFactory.typeOf(A_symbol_181);
					LibraryBinaryOperation dynamic_A_symbol_182 = (LibraryBinaryOperation)static_A_symbol_182.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
					Value A_symbol_182 = dynamic_A_symbol_182.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionType, A_symbol_181, T_ClassClassifier_Pivot_ecore__pivot__CollectionType_);
					Value A_symbol_183 = IP_CollectionType_elementType.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_182, P_CollectionType_elementType);
					
					DomainType static_A_symbol_184 = valueFactory.typeOf(A_symbol_179, A_symbol_183);
					LibraryBinaryOperation dynamic_A_symbol_184 = (LibraryBinaryOperation)static_A_symbol_184.lookupImplementation(standardLibrary, O_OclAny__eq_);
					Value A_symbol_184 = dynamic_A_symbol_184.evaluate(evaluator, T_Boolean, A_symbol_179, A_symbol_183);
					return A_symbol_184;
				}
			};
			DomainType static_A_symbol_178 = A_symbol_177.getType();
			LibraryIteration dynamic_A_symbol_178 = (LibraryIteration)static_A_symbol_178.lookupImplementation(standardLibrary, O_Collection_forAll);
			Value acc_A_symbol_178 = dynamic_A_symbol_178.createAccumulatorValue(evaluator, T_Boolean, T_Boolean);
			ExecutorSingleIterationManager manager_A_symbol_178 = new ExecutorSingleIterationManager(evaluator, T_Boolean, body_A_symbol_178, (CollectionValue)A_symbol_177, acc_A_symbol_178);
			Value A_symbol_178 = dynamic_A_symbol_178.evaluateIteration(manager_A_symbol_178);
			return A_symbol_178;
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
			
			Value leftA_symbol_185;
			try {
				
				Value A_symbol_186 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_187 = valueFactory.typeOf(A_symbol_186, S_one);
				LibraryBinaryOperation dynamic_A_symbol_187 = (LibraryBinaryOperation)static_A_symbol_187.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_187 = dynamic_A_symbol_187.evaluate(evaluator, T_Boolean, A_symbol_186, S_one);
				leftA_symbol_185 = A_symbol_187;
			} catch (InvalidValueException e) {
				leftA_symbol_185 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_187 = leftA_symbol_185;
			Value rightA_symbol_185;
			try {
				
				Value A_symbol_188 = IP_LoopExp_body.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_LoopExp_body);
				
				Value A_symbol_189 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_188, P_TypedElement_type);
				
				DomainType static_A_symbol_190 = valueFactory.typeOf(A_symbol_189, T_ClassClassifier_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_190 = (LibraryBinaryOperation)static_A_symbol_190.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_190 = dynamic_A_symbol_190.evaluate(evaluator, T_Boolean, A_symbol_189, T_ClassClassifier_Boolean_);
				rightA_symbol_185 = A_symbol_190;
			} catch (InvalidValueException e) {
				rightA_symbol_185 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_190 = rightA_symbol_185;
			DomainType static_A_symbol_185 = valueFactory.typeOf(A_symbol_187);
			LibraryBinaryOperation dynamic_A_symbol_185 = (LibraryBinaryOperation)static_A_symbol_185.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_185 = dynamic_A_symbol_185.evaluate(evaluator, T_Boolean, A_symbol_187, A_symbol_190);
			return A_symbol_185;
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
			
			Value leftA_symbol_191;
			try {
				
				Value A_symbol_192 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_193 = valueFactory.typeOf(A_symbol_192, S_one);
				LibraryBinaryOperation dynamic_A_symbol_193 = (LibraryBinaryOperation)static_A_symbol_193.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_193 = dynamic_A_symbol_193.evaluate(evaluator, T_Boolean, A_symbol_192, S_one);
				leftA_symbol_191 = A_symbol_193;
			} catch (InvalidValueException e) {
				leftA_symbol_191 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_193 = leftA_symbol_191;
			Value rightA_symbol_191;
			try {
				
				Value A_symbol_194 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_Pivot_ecore__pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_195 = valueFactory.typeOf(A_symbol_194);
				LibraryUnaryOperation dynamic_A_symbol_195 = (LibraryUnaryOperation)static_A_symbol_195.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_195 = dynamic_A_symbol_195.evaluate(evaluator, T_Integer, A_symbol_194);
				DomainType static_A_symbol_196 = valueFactory.typeOf(A_symbol_195, I_1);
				LibraryBinaryOperation dynamic_A_symbol_196 = (LibraryBinaryOperation)static_A_symbol_196.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_196 = dynamic_A_symbol_196.evaluate(evaluator, T_Boolean, A_symbol_195, I_1);
				rightA_symbol_191 = A_symbol_196;
			} catch (InvalidValueException e) {
				rightA_symbol_191 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_196 = rightA_symbol_191;
			DomainType static_A_symbol_191 = valueFactory.typeOf(A_symbol_193);
			LibraryBinaryOperation dynamic_A_symbol_191 = (LibraryBinaryOperation)static_A_symbol_191.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_191 = dynamic_A_symbol_191.evaluate(evaluator, T_Boolean, A_symbol_193, A_symbol_196);
			return A_symbol_191;
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
			
			Value leftA_symbol_197;
			try {
				
				Value A_symbol_198 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_199 = valueFactory.typeOf(A_symbol_198, S_one);
				LibraryBinaryOperation dynamic_A_symbol_199 = (LibraryBinaryOperation)static_A_symbol_199.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_199 = dynamic_A_symbol_199.evaluate(evaluator, T_Boolean, A_symbol_198, S_one);
				leftA_symbol_197 = A_symbol_199;
			} catch (InvalidValueException e) {
				leftA_symbol_197 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_199 = leftA_symbol_197;
			Value rightA_symbol_197;
			try {
				
				Value A_symbol_200 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_201 = valueFactory.typeOf(A_symbol_200, T_ClassClassifier_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_201 = (LibraryBinaryOperation)static_A_symbol_201.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_201 = dynamic_A_symbol_201.evaluate(evaluator, T_Boolean, A_symbol_200, T_ClassClassifier_Boolean_);
				rightA_symbol_197 = A_symbol_201;
			} catch (InvalidValueException e) {
				rightA_symbol_197 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_201 = rightA_symbol_197;
			DomainType static_A_symbol_197 = valueFactory.typeOf(A_symbol_199);
			LibraryBinaryOperation dynamic_A_symbol_197 = (LibraryBinaryOperation)static_A_symbol_197.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_197 = dynamic_A_symbol_197.evaluate(evaluator, T_Boolean, A_symbol_199, A_symbol_201);
			return A_symbol_197;
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
			
			Value leftA_symbol_202;
			try {
				Value leftA_symbol_203;
				try {
					
					Value A_symbol_204 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
					
					DomainType static_A_symbol_205 = valueFactory.typeOf(A_symbol_204, S_reject);
					LibraryBinaryOperation dynamic_A_symbol_205 = (LibraryBinaryOperation)static_A_symbol_205.lookupImplementation(standardLibrary, O_String__eq_);
					Value A_symbol_205 = dynamic_A_symbol_205.evaluate(evaluator, T_Boolean, A_symbol_204, S_reject);
					leftA_symbol_203 = A_symbol_205;
				} catch (InvalidValueException e) {
					leftA_symbol_203 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_205 = leftA_symbol_203;
				Value rightA_symbol_203;
				try {
					
					Value A_symbol_206 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
					
					DomainType static_A_symbol_207 = valueFactory.typeOf(A_symbol_206, S_select);
					LibraryBinaryOperation dynamic_A_symbol_207 = (LibraryBinaryOperation)static_A_symbol_207.lookupImplementation(standardLibrary, O_String__eq_);
					Value A_symbol_207 = dynamic_A_symbol_207.evaluate(evaluator, T_Boolean, A_symbol_206, S_select);
					rightA_symbol_203 = A_symbol_207;
				} catch (InvalidValueException e) {
					rightA_symbol_203 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_207 = rightA_symbol_203;
				DomainType static_A_symbol_203 = valueFactory.typeOf(A_symbol_205);
				LibraryBinaryOperation dynamic_A_symbol_203 = (LibraryBinaryOperation)static_A_symbol_203.lookupImplementation(standardLibrary, O_Boolean_or);
				Value A_symbol_203 = dynamic_A_symbol_203.evaluate(evaluator, T_Boolean, A_symbol_205, A_symbol_207);
				leftA_symbol_202 = A_symbol_203;
			} catch (InvalidValueException e) {
				leftA_symbol_202 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_203 = leftA_symbol_202;
			Value rightA_symbol_202;
			try {
				
				Value A_symbol_208 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_Pivot_ecore__pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_209 = valueFactory.typeOf(A_symbol_208);
				LibraryUnaryOperation dynamic_A_symbol_209 = (LibraryUnaryOperation)static_A_symbol_209.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_209 = dynamic_A_symbol_209.evaluate(evaluator, T_Integer, A_symbol_208);
				DomainType static_A_symbol_210 = valueFactory.typeOf(A_symbol_209, I_1);
				LibraryBinaryOperation dynamic_A_symbol_210 = (LibraryBinaryOperation)static_A_symbol_210.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_210 = dynamic_A_symbol_210.evaluate(evaluator, T_Boolean, A_symbol_209, I_1);
				rightA_symbol_202 = A_symbol_210;
			} catch (InvalidValueException e) {
				rightA_symbol_202 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_210 = rightA_symbol_202;
			DomainType static_A_symbol_202 = valueFactory.typeOf(A_symbol_203);
			LibraryBinaryOperation dynamic_A_symbol_202 = (LibraryBinaryOperation)static_A_symbol_202.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_202 = dynamic_A_symbol_202.evaluate(evaluator, T_Boolean, A_symbol_203, A_symbol_210);
			return A_symbol_202;
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
			
			Value leftA_symbol_211;
			try {
				Value leftA_symbol_212;
				try {
					
					Value A_symbol_213 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
					
					DomainType static_A_symbol_214 = valueFactory.typeOf(A_symbol_213, S_reject);
					LibraryBinaryOperation dynamic_A_symbol_214 = (LibraryBinaryOperation)static_A_symbol_214.lookupImplementation(standardLibrary, O_String__eq_);
					Value A_symbol_214 = dynamic_A_symbol_214.evaluate(evaluator, T_Boolean, A_symbol_213, S_reject);
					leftA_symbol_212 = A_symbol_214;
				} catch (InvalidValueException e) {
					leftA_symbol_212 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_214 = leftA_symbol_212;
				Value rightA_symbol_212;
				try {
					
					Value A_symbol_215 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
					
					DomainType static_A_symbol_216 = valueFactory.typeOf(A_symbol_215, S_select);
					LibraryBinaryOperation dynamic_A_symbol_216 = (LibraryBinaryOperation)static_A_symbol_216.lookupImplementation(standardLibrary, O_String__eq_);
					Value A_symbol_216 = dynamic_A_symbol_216.evaluate(evaluator, T_Boolean, A_symbol_215, S_select);
					rightA_symbol_212 = A_symbol_216;
				} catch (InvalidValueException e) {
					rightA_symbol_212 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_216 = rightA_symbol_212;
				DomainType static_A_symbol_212 = valueFactory.typeOf(A_symbol_214);
				LibraryBinaryOperation dynamic_A_symbol_212 = (LibraryBinaryOperation)static_A_symbol_212.lookupImplementation(standardLibrary, O_Boolean_or);
				Value A_symbol_212 = dynamic_A_symbol_212.evaluate(evaluator, T_Boolean, A_symbol_214, A_symbol_216);
				leftA_symbol_211 = A_symbol_212;
			} catch (InvalidValueException e) {
				leftA_symbol_211 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_212 = leftA_symbol_211;
			Value rightA_symbol_211;
			try {
				
				Value A_symbol_217 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_218 = valueFactory.typeOf(A_symbol_217, T_ClassClassifier_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_218 = (LibraryBinaryOperation)static_A_symbol_218.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_218 = dynamic_A_symbol_218.evaluate(evaluator, T_Boolean, A_symbol_217, T_ClassClassifier_Boolean_);
				rightA_symbol_211 = A_symbol_218;
			} catch (InvalidValueException e) {
				rightA_symbol_211 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_218 = rightA_symbol_211;
			DomainType static_A_symbol_211 = valueFactory.typeOf(A_symbol_212);
			LibraryBinaryOperation dynamic_A_symbol_211 = (LibraryBinaryOperation)static_A_symbol_211.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_211 = dynamic_A_symbol_211.evaluate(evaluator, T_Boolean, A_symbol_212, A_symbol_218);
			return A_symbol_211;
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
			
			Value leftA_symbol_219;
			try {
				Value leftA_symbol_220;
				try {
					
					Value A_symbol_221 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
					
					DomainType static_A_symbol_222 = valueFactory.typeOf(A_symbol_221, S_reject);
					LibraryBinaryOperation dynamic_A_symbol_222 = (LibraryBinaryOperation)static_A_symbol_222.lookupImplementation(standardLibrary, O_String__eq_);
					Value A_symbol_222 = dynamic_A_symbol_222.evaluate(evaluator, T_Boolean, A_symbol_221, S_reject);
					leftA_symbol_220 = A_symbol_222;
				} catch (InvalidValueException e) {
					leftA_symbol_220 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_222 = leftA_symbol_220;
				Value rightA_symbol_220;
				try {
					
					Value A_symbol_223 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
					
					DomainType static_A_symbol_224 = valueFactory.typeOf(A_symbol_223, S_select);
					LibraryBinaryOperation dynamic_A_symbol_224 = (LibraryBinaryOperation)static_A_symbol_224.lookupImplementation(standardLibrary, O_String__eq_);
					Value A_symbol_224 = dynamic_A_symbol_224.evaluate(evaluator, T_Boolean, A_symbol_223, S_select);
					rightA_symbol_220 = A_symbol_224;
				} catch (InvalidValueException e) {
					rightA_symbol_220 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_224 = rightA_symbol_220;
				DomainType static_A_symbol_220 = valueFactory.typeOf(A_symbol_222);
				LibraryBinaryOperation dynamic_A_symbol_220 = (LibraryBinaryOperation)static_A_symbol_220.lookupImplementation(standardLibrary, O_Boolean_or);
				Value A_symbol_220 = dynamic_A_symbol_220.evaluate(evaluator, T_Boolean, A_symbol_222, A_symbol_224);
				leftA_symbol_219 = A_symbol_220;
			} catch (InvalidValueException e) {
				leftA_symbol_219 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_220 = leftA_symbol_219;
			Value rightA_symbol_219;
			try {
				
				Value A_symbol_225 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				
				Value A_symbol_226 = IP_CallExp_source.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_CallExp_source);
				
				Value A_symbol_227 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_226, P_TypedElement_type);
				
				DomainType static_A_symbol_228 = valueFactory.typeOf(A_symbol_225, A_symbol_227);
				LibraryBinaryOperation dynamic_A_symbol_228 = (LibraryBinaryOperation)static_A_symbol_228.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_228 = dynamic_A_symbol_228.evaluate(evaluator, T_Boolean, A_symbol_225, A_symbol_227);
				rightA_symbol_219 = A_symbol_228;
			} catch (InvalidValueException e) {
				rightA_symbol_219 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_228 = rightA_symbol_219;
			DomainType static_A_symbol_219 = valueFactory.typeOf(A_symbol_220);
			LibraryBinaryOperation dynamic_A_symbol_219 = (LibraryBinaryOperation)static_A_symbol_219.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_219 = dynamic_A_symbol_219.evaluate(evaluator, T_Boolean, A_symbol_220, A_symbol_228);
			return A_symbol_219;
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
			
			Value leftA_symbol_229;
			try {
				
				Value A_symbol_230 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_231 = valueFactory.typeOf(A_symbol_230, S_sortedBy);
				LibraryBinaryOperation dynamic_A_symbol_231 = (LibraryBinaryOperation)static_A_symbol_231.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_231 = dynamic_A_symbol_231.evaluate(evaluator, T_Boolean, A_symbol_230, S_sortedBy);
				leftA_symbol_229 = A_symbol_231;
			} catch (InvalidValueException e) {
				leftA_symbol_229 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_231 = leftA_symbol_229;
			Value rightA_symbol_229;
			try {
				
				Value A_symbol_232 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_233 = valueFactory.typeOf(A_symbol_232);
				LibraryBinaryOperation dynamic_A_symbol_233 = (LibraryBinaryOperation)static_A_symbol_233.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_233 = dynamic_A_symbol_233.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionType, A_symbol_232, T_ClassClassifier_Pivot_ecore__pivot__CollectionType_);
				Value A_symbol_234 = IP_CollectionType_elementType.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_233, P_CollectionType_elementType);
				
				
				Value A_symbol_235 = IP_LoopExp_body.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_LoopExp_body);
				
				Value A_symbol_236 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_235, P_TypedElement_type);
				
				DomainType static_A_symbol_237 = valueFactory.typeOf(A_symbol_236);
				LibraryBinaryOperation dynamic_A_symbol_237 = (LibraryBinaryOperation)static_A_symbol_237.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_237 = dynamic_A_symbol_237.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionType, A_symbol_236, T_ClassClassifier_Pivot_ecore__pivot__CollectionType_);
				Value A_symbol_238 = IP_CollectionType_elementType.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_237, P_CollectionType_elementType);
				
				DomainType static_A_symbol_239 = valueFactory.typeOf(A_symbol_234, A_symbol_238);
				LibraryBinaryOperation dynamic_A_symbol_239 = (LibraryBinaryOperation)static_A_symbol_239.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_239 = dynamic_A_symbol_239.evaluate(evaluator, T_Boolean, A_symbol_234, A_symbol_238);
				rightA_symbol_229 = A_symbol_239;
			} catch (InvalidValueException e) {
				rightA_symbol_229 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_239 = rightA_symbol_229;
			DomainType static_A_symbol_229 = valueFactory.typeOf(A_symbol_231);
			LibraryBinaryOperation dynamic_A_symbol_229 = (LibraryBinaryOperation)static_A_symbol_229.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_229 = dynamic_A_symbol_229.evaluate(evaluator, T_Boolean, A_symbol_231, A_symbol_239);
			return A_symbol_229;
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
			
			Value leftA_symbol_240;
			try {
				
				Value A_symbol_241 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_242 = valueFactory.typeOf(A_symbol_241, S_sortedBy);
				LibraryBinaryOperation dynamic_A_symbol_242 = (LibraryBinaryOperation)static_A_symbol_242.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_242 = dynamic_A_symbol_242.evaluate(evaluator, T_Boolean, A_symbol_241, S_sortedBy);
				leftA_symbol_240 = A_symbol_242;
			} catch (InvalidValueException e) {
				leftA_symbol_240 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_242 = leftA_symbol_240;
			Value rightA_symbol_240;
			try {
				
				Value A_symbol_243 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_Pivot_ecore__pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_244 = valueFactory.typeOf(A_symbol_243);
				LibraryUnaryOperation dynamic_A_symbol_244 = (LibraryUnaryOperation)static_A_symbol_244.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_244 = dynamic_A_symbol_244.evaluate(evaluator, T_Integer, A_symbol_243);
				DomainType static_A_symbol_245 = valueFactory.typeOf(A_symbol_244, I_1);
				LibraryBinaryOperation dynamic_A_symbol_245 = (LibraryBinaryOperation)static_A_symbol_245.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_245 = dynamic_A_symbol_245.evaluate(evaluator, T_Boolean, A_symbol_244, I_1);
				rightA_symbol_240 = A_symbol_245;
			} catch (InvalidValueException e) {
				rightA_symbol_240 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_245 = rightA_symbol_240;
			DomainType static_A_symbol_240 = valueFactory.typeOf(A_symbol_242);
			LibraryBinaryOperation dynamic_A_symbol_240 = (LibraryBinaryOperation)static_A_symbol_240.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_240 = dynamic_A_symbol_240.evaluate(evaluator, T_Boolean, A_symbol_242, A_symbol_245);
			return A_symbol_240;
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
			
			Value leftA_symbol_246;
			try {
				
				Value A_symbol_247 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_248 = valueFactory.typeOf(A_symbol_247, S_sortedBy);
				LibraryBinaryOperation dynamic_A_symbol_248 = (LibraryBinaryOperation)static_A_symbol_248.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_248 = dynamic_A_symbol_248.evaluate(evaluator, T_Boolean, A_symbol_247, S_sortedBy);
				leftA_symbol_246 = A_symbol_248;
			} catch (InvalidValueException e) {
				leftA_symbol_246 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_248 = leftA_symbol_246;
			Value rightA_symbol_246;
			try {
					Value leftA_symbol_249;
					try {
						
						Value A_symbol_250 = IP_CallExp_source.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_CallExp_source);
						
						Value A_symbol_251 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_250, P_TypedElement_type);
						
						DomainType static_A_symbol_252 = valueFactory.typeOf(A_symbol_251);
						LibraryBinaryOperation dynamic_A_symbol_252 = (LibraryBinaryOperation)static_A_symbol_252.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Value A_symbol_252 = dynamic_A_symbol_252.evaluate(evaluator, T_Boolean, A_symbol_251, T_ClassClassifier_Pivot_ecore__pivot__SequenceType_);
						leftA_symbol_249 = A_symbol_252;
					} catch (InvalidValueException e) {
						leftA_symbol_249 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_252 = leftA_symbol_249;
					Value rightA_symbol_249;
					try {
						
						Value A_symbol_253 = IP_CallExp_source.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_CallExp_source);
						
						Value A_symbol_254 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_253, P_TypedElement_type);
						
						DomainType static_A_symbol_255 = valueFactory.typeOf(A_symbol_254);
						LibraryBinaryOperation dynamic_A_symbol_255 = (LibraryBinaryOperation)static_A_symbol_255.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Value A_symbol_255 = dynamic_A_symbol_255.evaluate(evaluator, T_Boolean, A_symbol_254, T_ClassClassifier_Pivot_ecore__pivot__BagType_);
						rightA_symbol_249 = A_symbol_255;
					} catch (InvalidValueException e) {
						rightA_symbol_249 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_255 = rightA_symbol_249;
					DomainType static_A_symbol_249 = valueFactory.typeOf(A_symbol_252);
					LibraryBinaryOperation dynamic_A_symbol_249 = (LibraryBinaryOperation)static_A_symbol_249.lookupImplementation(standardLibrary, O_Boolean_or);
					Value A_symbol_249 = dynamic_A_symbol_249.evaluate(evaluator, T_Boolean, A_symbol_252, A_symbol_255);
				Value A_symbol_256;
				if (A_symbol_249.isTrue()) {
					
					Value A_symbol_257 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
					
					DomainType static_A_symbol_258 = valueFactory.typeOf(A_symbol_257);
					LibraryBinaryOperation dynamic_A_symbol_258 = (LibraryBinaryOperation)static_A_symbol_258.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Value A_symbol_258 = dynamic_A_symbol_258.evaluate(evaluator, T_Boolean, A_symbol_257, T_ClassClassifier_Pivot_ecore__pivot__SequenceType_);
					A_symbol_256 = A_symbol_258;
				}
				else if (A_symbol_249.isFalse()) {
					
					Value A_symbol_259 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
					
					DomainType static_A_symbol_260 = valueFactory.typeOf(A_symbol_259);
					LibraryBinaryOperation dynamic_A_symbol_260 = (LibraryBinaryOperation)static_A_symbol_260.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Value A_symbol_260 = dynamic_A_symbol_260.evaluate(evaluator, T_Boolean, A_symbol_259, T_ClassClassifier_Pivot_ecore__pivot__OrderedSetType_);
					A_symbol_256 = A_symbol_260;
				}
				else if (A_symbol_249.isNull()) {
					A_symbol_256 = valueFactory.throwInvalidValueException("null if condition");
				}
				else {
					A_symbol_256 = valueFactory.throwInvalidValueException("invalid if condition");
				}
				rightA_symbol_246 = A_symbol_256;
			} catch (InvalidValueException e) {
				rightA_symbol_246 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_256 = rightA_symbol_246;
			DomainType static_A_symbol_246 = valueFactory.typeOf(A_symbol_248);
			LibraryBinaryOperation dynamic_A_symbol_246 = (LibraryBinaryOperation)static_A_symbol_246.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_246 = dynamic_A_symbol_246.evaluate(evaluator, T_Boolean, A_symbol_248, A_symbol_256);
			return A_symbol_246;
		}
	}
}

