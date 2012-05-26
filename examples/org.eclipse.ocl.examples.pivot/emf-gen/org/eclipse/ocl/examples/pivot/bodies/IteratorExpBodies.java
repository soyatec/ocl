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
			
			Value leftA_symbol_47;
			try {
				
				Value A_symbol_48 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_49 = valueFactory.typeOf(A_symbol_48, S_any);
				LibraryBinaryOperation dynamic_A_symbol_49 = (LibraryBinaryOperation)static_A_symbol_49.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_49 = dynamic_A_symbol_49.evaluate(evaluator, T_Boolean, A_symbol_48, S_any);
				leftA_symbol_47 = A_symbol_49;
			} catch (InvalidValueException e) {
				leftA_symbol_47 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_49 = leftA_symbol_47;
			Value rightA_symbol_47;
			try {
				
				Value A_symbol_50 = IP_LoopExp_body.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_LoopExp_body);
				
				Value A_symbol_51 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_50, P_TypedElement_type);
				
				DomainType static_A_symbol_52 = valueFactory.typeOf(A_symbol_51, S_Boolean);
				LibraryBinaryOperation dynamic_A_symbol_52 = (LibraryBinaryOperation)static_A_symbol_52.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_52 = dynamic_A_symbol_52.evaluate(evaluator, T_Boolean, A_symbol_51, S_Boolean);
				rightA_symbol_47 = A_symbol_52;
			} catch (InvalidValueException e) {
				rightA_symbol_47 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_52 = rightA_symbol_47;
			DomainType static_A_symbol_47 = valueFactory.typeOf(A_symbol_49);
			LibraryBinaryOperation dynamic_A_symbol_47 = (LibraryBinaryOperation)static_A_symbol_47.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_47 = dynamic_A_symbol_47.evaluate(evaluator, T_Boolean, A_symbol_49, A_symbol_52);
			return A_symbol_47;
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
			
			Value leftA_symbol_53;
			try {
				
				Value A_symbol_54 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_55 = valueFactory.typeOf(A_symbol_54, S_any);
				LibraryBinaryOperation dynamic_A_symbol_55 = (LibraryBinaryOperation)static_A_symbol_55.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_55 = dynamic_A_symbol_55.evaluate(evaluator, T_Boolean, A_symbol_54, S_any);
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
			
			Value leftA_symbol_59;
			try {
				
				Value A_symbol_60 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_61 = valueFactory.typeOf(A_symbol_60, S_any);
				LibraryBinaryOperation dynamic_A_symbol_61 = (LibraryBinaryOperation)static_A_symbol_61.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_61 = dynamic_A_symbol_61.evaluate(evaluator, T_Boolean, A_symbol_60, S_any);
				leftA_symbol_59 = A_symbol_61;
			} catch (InvalidValueException e) {
				leftA_symbol_59 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_61 = leftA_symbol_59;
			Value rightA_symbol_59;
			try {
				
				Value A_symbol_62 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				
				Value A_symbol_63 = IP_CallExp_source.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_CallExp_source);
				
				Value A_symbol_64 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_63, P_TypedElement_type);
				
				DomainType static_A_symbol_65 = valueFactory.typeOf(A_symbol_64);
				LibraryBinaryOperation dynamic_A_symbol_65 = (LibraryBinaryOperation)static_A_symbol_65.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_65 = dynamic_A_symbol_65.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionType, A_symbol_64, T_ClassClassifier_Pivot_ecore__pivot__CollectionType_);
				Value A_symbol_66 = IP_CollectionType_elementType.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_65, P_CollectionType_elementType);
				
				DomainType static_A_symbol_67 = valueFactory.typeOf(A_symbol_62, A_symbol_66);
				LibraryBinaryOperation dynamic_A_symbol_67 = (LibraryBinaryOperation)static_A_symbol_67.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_67 = dynamic_A_symbol_67.evaluate(evaluator, T_Boolean, A_symbol_62, A_symbol_66);
				rightA_symbol_59 = A_symbol_67;
			} catch (InvalidValueException e) {
				rightA_symbol_59 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_67 = rightA_symbol_59;
			DomainType static_A_symbol_59 = valueFactory.typeOf(A_symbol_61);
			LibraryBinaryOperation dynamic_A_symbol_59 = (LibraryBinaryOperation)static_A_symbol_59.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_59 = dynamic_A_symbol_59.evaluate(evaluator, T_Boolean, A_symbol_61, A_symbol_67);
			return A_symbol_59;
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
			
			Value leftA_symbol_68;
			try {
				
				Value A_symbol_69 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_70 = valueFactory.typeOf(A_symbol_69, S_closure);
				LibraryBinaryOperation dynamic_A_symbol_70 = (LibraryBinaryOperation)static_A_symbol_70.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_70 = dynamic_A_symbol_70.evaluate(evaluator, T_Boolean, A_symbol_69, S_closure);
				leftA_symbol_68 = A_symbol_70;
			} catch (InvalidValueException e) {
				leftA_symbol_68 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_70 = leftA_symbol_68;
			Value rightA_symbol_68;
			try {
				
				Value A_symbol_71 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_72 = valueFactory.typeOf(A_symbol_71);
				LibraryBinaryOperation dynamic_A_symbol_72 = (LibraryBinaryOperation)static_A_symbol_72.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_72 = dynamic_A_symbol_72.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionType, A_symbol_71, T_ClassClassifier_Pivot_ecore__pivot__CollectionType_);
				Value A_symbol_73 = IP_CollectionType_elementType.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_72, P_CollectionType_elementType);
				
				
				Value A_symbol_74 = IP_CallExp_source.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_CallExp_source);
				
				Value A_symbol_75 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_74, P_TypedElement_type);
				
				DomainType static_A_symbol_76 = valueFactory.typeOf(A_symbol_75);
				LibraryBinaryOperation dynamic_A_symbol_76 = (LibraryBinaryOperation)static_A_symbol_76.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_76 = dynamic_A_symbol_76.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionType, A_symbol_75, T_ClassClassifier_Pivot_ecore__pivot__CollectionType_);
				Value A_symbol_77 = IP_CollectionType_elementType.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_76, P_CollectionType_elementType);
				
				DomainType static_A_symbol_78 = valueFactory.typeOf(A_symbol_73, A_symbol_77);
				LibraryBinaryOperation dynamic_A_symbol_78 = (LibraryBinaryOperation)static_A_symbol_78.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_78 = dynamic_A_symbol_78.evaluate(evaluator, T_Boolean, A_symbol_73, A_symbol_77);
				rightA_symbol_68 = A_symbol_78;
			} catch (InvalidValueException e) {
				rightA_symbol_68 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_78 = rightA_symbol_68;
			DomainType static_A_symbol_68 = valueFactory.typeOf(A_symbol_70);
			LibraryBinaryOperation dynamic_A_symbol_68 = (LibraryBinaryOperation)static_A_symbol_68.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_68 = dynamic_A_symbol_68.evaluate(evaluator, T_Boolean, A_symbol_70, A_symbol_78);
			return A_symbol_68;
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
				
				Value A_symbol_82 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_Pivot_ecore__pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_83 = valueFactory.typeOf(A_symbol_82);
				LibraryUnaryOperation dynamic_A_symbol_83 = (LibraryUnaryOperation)static_A_symbol_83.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_83 = dynamic_A_symbol_83.evaluate(evaluator, T_Integer, A_symbol_82);
				DomainType static_A_symbol_84 = valueFactory.typeOf(A_symbol_83, I_1);
				LibraryBinaryOperation dynamic_A_symbol_84 = (LibraryBinaryOperation)static_A_symbol_84.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_84 = dynamic_A_symbol_84.evaluate(evaluator, T_Boolean, A_symbol_83, I_1);
				rightA_symbol_79 = A_symbol_84;
			} catch (InvalidValueException e) {
				rightA_symbol_79 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_84 = rightA_symbol_79;
			DomainType static_A_symbol_79 = valueFactory.typeOf(A_symbol_81);
			LibraryBinaryOperation dynamic_A_symbol_79 = (LibraryBinaryOperation)static_A_symbol_79.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_79 = dynamic_A_symbol_79.evaluate(evaluator, T_Boolean, A_symbol_81, A_symbol_84);
			return A_symbol_79;
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
			
			Value leftA_symbol_85;
			try {
				
				Value A_symbol_86 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_87 = valueFactory.typeOf(A_symbol_86, S_closure);
				LibraryBinaryOperation dynamic_A_symbol_87 = (LibraryBinaryOperation)static_A_symbol_87.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_87 = dynamic_A_symbol_87.evaluate(evaluator, T_Boolean, A_symbol_86, S_closure);
				leftA_symbol_85 = A_symbol_87;
			} catch (InvalidValueException e) {
				leftA_symbol_85 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_87 = leftA_symbol_85;
			Value rightA_symbol_85;
			try {
				
				Value A_symbol_88 = IP_CallExp_source.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_CallExp_source);
				
				Value A_symbol_89 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_88, P_TypedElement_type);
				
				DomainType static_A_symbol_90 = valueFactory.typeOf(A_symbol_89);
				LibraryBinaryOperation dynamic_A_symbol_90 = (LibraryBinaryOperation)static_A_symbol_90.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_90 = dynamic_A_symbol_90.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionType, A_symbol_89, T_ClassClassifier_Pivot_ecore__pivot__CollectionType_);
				Value A_symbol_91 = IP_CollectionType_elementType.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_90, P_CollectionType_elementType);
				
					
					Value A_symbol_92 = IP_LoopExp_body.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_LoopExp_body);
					
					Value A_symbol_93 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_92, P_TypedElement_type);
					
					DomainType static_A_symbol_94 = valueFactory.typeOf(A_symbol_93);
					LibraryBinaryOperation dynamic_A_symbol_94 = (LibraryBinaryOperation)static_A_symbol_94.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Value A_symbol_94 = dynamic_A_symbol_94.evaluate(evaluator, T_Boolean, A_symbol_93, T_ClassClassifier_Pivot_ecore__pivot__CollectionType_);
				Value A_symbol_95;
				if (A_symbol_94.isTrue()) {
					
					Value A_symbol_96 = IP_LoopExp_body.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_LoopExp_body);
					
					Value A_symbol_97 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_96, P_TypedElement_type);
					
					DomainType static_A_symbol_98 = valueFactory.typeOf(A_symbol_97);
					LibraryBinaryOperation dynamic_A_symbol_98 = (LibraryBinaryOperation)static_A_symbol_98.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
					Value A_symbol_98 = dynamic_A_symbol_98.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionType, A_symbol_97, T_ClassClassifier_Pivot_ecore__pivot__CollectionType_);
					Value A_symbol_99 = IP_CollectionType_elementType.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_98, P_CollectionType_elementType);
					
					A_symbol_95 = A_symbol_99;
				}
				else if (A_symbol_94.isFalse()) {
					
					Value A_symbol_100 = IP_LoopExp_body.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_LoopExp_body);
					
					Value A_symbol_101 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_100, P_TypedElement_type);
					
					A_symbol_95 = A_symbol_101;
				}
				else if (A_symbol_94.isNull()) {
					A_symbol_95 = valueFactory.throwInvalidValueException("null if condition");
				}
				else {
					A_symbol_95 = valueFactory.throwInvalidValueException("invalid if condition");
				}
				DomainType static_A_symbol_102 = valueFactory.typeOf(A_symbol_91, A_symbol_95);
				LibraryBinaryOperation dynamic_A_symbol_102 = (LibraryBinaryOperation)static_A_symbol_102.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_102 = dynamic_A_symbol_102.evaluate(evaluator, T_Boolean, A_symbol_91, A_symbol_95);
				rightA_symbol_85 = A_symbol_102;
			} catch (InvalidValueException e) {
				rightA_symbol_85 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_102 = rightA_symbol_85;
			DomainType static_A_symbol_85 = valueFactory.typeOf(A_symbol_87);
			LibraryBinaryOperation dynamic_A_symbol_85 = (LibraryBinaryOperation)static_A_symbol_85.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_85 = dynamic_A_symbol_85.evaluate(evaluator, T_Boolean, A_symbol_87, A_symbol_102);
			return A_symbol_85;
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
			
			Value leftA_symbol_103;
			try {
				
				Value A_symbol_104 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_105 = valueFactory.typeOf(A_symbol_104, S_closure);
				LibraryBinaryOperation dynamic_A_symbol_105 = (LibraryBinaryOperation)static_A_symbol_105.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_105 = dynamic_A_symbol_105.evaluate(evaluator, T_Boolean, A_symbol_104, S_closure);
				leftA_symbol_103 = A_symbol_105;
			} catch (InvalidValueException e) {
				leftA_symbol_103 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_105 = leftA_symbol_103;
			Value rightA_symbol_103;
			try {
					Value leftA_symbol_106;
					try {
						
						Value A_symbol_107 = IP_CallExp_source.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_CallExp_source);
						
						Value A_symbol_108 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_107, P_TypedElement_type);
						
						DomainType static_A_symbol_109 = valueFactory.typeOf(A_symbol_108);
						LibraryBinaryOperation dynamic_A_symbol_109 = (LibraryBinaryOperation)static_A_symbol_109.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Value A_symbol_109 = dynamic_A_symbol_109.evaluate(evaluator, T_Boolean, A_symbol_108, T_ClassClassifier_Pivot_ecore__pivot__SequenceType_);
						leftA_symbol_106 = A_symbol_109;
					} catch (InvalidValueException e) {
						leftA_symbol_106 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_109 = leftA_symbol_106;
					Value rightA_symbol_106;
					try {
						
						Value A_symbol_110 = IP_CallExp_source.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_CallExp_source);
						
						Value A_symbol_111 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_110, P_TypedElement_type);
						
						DomainType static_A_symbol_112 = valueFactory.typeOf(A_symbol_111);
						LibraryBinaryOperation dynamic_A_symbol_112 = (LibraryBinaryOperation)static_A_symbol_112.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Value A_symbol_112 = dynamic_A_symbol_112.evaluate(evaluator, T_Boolean, A_symbol_111, T_ClassClassifier_Pivot_ecore__pivot__OrderedSetType_);
						rightA_symbol_106 = A_symbol_112;
					} catch (InvalidValueException e) {
						rightA_symbol_106 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_112 = rightA_symbol_106;
					DomainType static_A_symbol_106 = valueFactory.typeOf(A_symbol_109);
					LibraryBinaryOperation dynamic_A_symbol_106 = (LibraryBinaryOperation)static_A_symbol_106.lookupImplementation(standardLibrary, O_Boolean_or);
					Value A_symbol_106 = dynamic_A_symbol_106.evaluate(evaluator, T_Boolean, A_symbol_109, A_symbol_112);
				Value A_symbol_113;
				if (A_symbol_106.isTrue()) {
					
					Value A_symbol_114 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
					
					DomainType static_A_symbol_115 = valueFactory.typeOf(A_symbol_114);
					LibraryBinaryOperation dynamic_A_symbol_115 = (LibraryBinaryOperation)static_A_symbol_115.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Value A_symbol_115 = dynamic_A_symbol_115.evaluate(evaluator, T_Boolean, A_symbol_114, T_ClassClassifier_Pivot_ecore__pivot__OrderedSetType_);
					A_symbol_113 = A_symbol_115;
				}
				else if (A_symbol_106.isFalse()) {
					
					Value A_symbol_116 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
					
					DomainType static_A_symbol_117 = valueFactory.typeOf(A_symbol_116);
					LibraryBinaryOperation dynamic_A_symbol_117 = (LibraryBinaryOperation)static_A_symbol_117.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Value A_symbol_117 = dynamic_A_symbol_117.evaluate(evaluator, T_Boolean, A_symbol_116, T_ClassClassifier_Pivot_ecore__pivot__SetType_);
					A_symbol_113 = A_symbol_117;
				}
				else if (A_symbol_106.isNull()) {
					A_symbol_113 = valueFactory.throwInvalidValueException("null if condition");
				}
				else {
					A_symbol_113 = valueFactory.throwInvalidValueException("invalid if condition");
				}
				rightA_symbol_103 = A_symbol_113;
			} catch (InvalidValueException e) {
				rightA_symbol_103 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_113 = rightA_symbol_103;
			DomainType static_A_symbol_103 = valueFactory.typeOf(A_symbol_105);
			LibraryBinaryOperation dynamic_A_symbol_103 = (LibraryBinaryOperation)static_A_symbol_103.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_103 = dynamic_A_symbol_103.evaluate(evaluator, T_Boolean, A_symbol_105, A_symbol_113);
			return A_symbol_103;
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
			
			Value leftA_symbol_118;
			try {
				
				Value A_symbol_119 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_120 = valueFactory.typeOf(A_symbol_119, S_collect);
				LibraryBinaryOperation dynamic_A_symbol_120 = (LibraryBinaryOperation)static_A_symbol_120.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_120 = dynamic_A_symbol_120.evaluate(evaluator, T_Boolean, A_symbol_119, S_collect);
				leftA_symbol_118 = A_symbol_120;
			} catch (InvalidValueException e) {
				leftA_symbol_118 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_120 = leftA_symbol_118;
			Value rightA_symbol_118;
			try {
				
				Value A_symbol_121 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_122 = valueFactory.typeOf(A_symbol_121);
				LibraryBinaryOperation dynamic_A_symbol_122 = (LibraryBinaryOperation)static_A_symbol_122.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_122 = dynamic_A_symbol_122.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionType, A_symbol_121, T_ClassClassifier_Pivot_ecore__pivot__CollectionType_);
				Value A_symbol_123 = IP_CollectionType_elementType.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_122, P_CollectionType_elementType);
				
				
				Value A_symbol_124 = IP_LoopExp_body.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_LoopExp_body);
				
				Value A_symbol_125 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_124, P_TypedElement_type);
				
				DomainType static_A_symbol_126 = valueFactory.typeOf(A_symbol_125);
				LibraryBinaryOperation dynamic_A_symbol_126 = (LibraryBinaryOperation)static_A_symbol_126.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_126 = dynamic_A_symbol_126.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionType, A_symbol_125, T_ClassClassifier_Pivot_ecore__pivot__CollectionType_);
				Value A_symbol_127 = IP_CollectionType_elementType.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_126, P_CollectionType_elementType);
				
				DomainType static_A_symbol_128 = valueFactory.typeOf(A_symbol_123, A_symbol_127);
				LibraryBinaryOperation dynamic_A_symbol_128 = (LibraryBinaryOperation)static_A_symbol_128.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_128 = dynamic_A_symbol_128.evaluate(evaluator, T_Boolean, A_symbol_123, A_symbol_127);
				rightA_symbol_118 = A_symbol_128;
			} catch (InvalidValueException e) {
				rightA_symbol_118 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_128 = rightA_symbol_118;
			DomainType static_A_symbol_118 = valueFactory.typeOf(A_symbol_120);
			LibraryBinaryOperation dynamic_A_symbol_118 = (LibraryBinaryOperation)static_A_symbol_118.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_118 = dynamic_A_symbol_118.evaluate(evaluator, T_Boolean, A_symbol_120, A_symbol_128);
			return A_symbol_118;
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
				
				Value A_symbol_132 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_Pivot_ecore__pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_133 = valueFactory.typeOf(A_symbol_132);
				LibraryUnaryOperation dynamic_A_symbol_133 = (LibraryUnaryOperation)static_A_symbol_133.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_133 = dynamic_A_symbol_133.evaluate(evaluator, T_Integer, A_symbol_132);
				DomainType static_A_symbol_134 = valueFactory.typeOf(A_symbol_133, I_1);
				LibraryBinaryOperation dynamic_A_symbol_134 = (LibraryBinaryOperation)static_A_symbol_134.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_134 = dynamic_A_symbol_134.evaluate(evaluator, T_Boolean, A_symbol_133, I_1);
				rightA_symbol_129 = A_symbol_134;
			} catch (InvalidValueException e) {
				rightA_symbol_129 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_134 = rightA_symbol_129;
			DomainType static_A_symbol_129 = valueFactory.typeOf(A_symbol_131);
			LibraryBinaryOperation dynamic_A_symbol_129 = (LibraryBinaryOperation)static_A_symbol_129.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_129 = dynamic_A_symbol_129.evaluate(evaluator, T_Boolean, A_symbol_131, A_symbol_134);
			return A_symbol_129;
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
			
			Value leftA_symbol_135;
			try {
				
				Value A_symbol_136 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_137 = valueFactory.typeOf(A_symbol_136, S_collectN___);
				LibraryBinaryOperation dynamic_A_symbol_137 = (LibraryBinaryOperation)static_A_symbol_137.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_137 = dynamic_A_symbol_137.evaluate(evaluator, T_Boolean, A_symbol_136, S_collectN___);
				leftA_symbol_135 = A_symbol_137;
			} catch (InvalidValueException e) {
				leftA_symbol_135 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_137 = leftA_symbol_135;
			Value rightA_symbol_135;
			try {
				
				Value A_symbol_138 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_Pivot_ecore__pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_139 = valueFactory.typeOf(A_symbol_138);
				LibraryUnaryOperation dynamic_A_symbol_139 = (LibraryUnaryOperation)static_A_symbol_139.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_139 = dynamic_A_symbol_139.evaluate(evaluator, T_Integer, A_symbol_138);
				DomainType static_A_symbol_140 = valueFactory.typeOf(A_symbol_139, I_1);
				LibraryBinaryOperation dynamic_A_symbol_140 = (LibraryBinaryOperation)static_A_symbol_140.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_140 = dynamic_A_symbol_140.evaluate(evaluator, T_Boolean, A_symbol_139, I_1);
				rightA_symbol_135 = A_symbol_140;
			} catch (InvalidValueException e) {
				rightA_symbol_135 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_140 = rightA_symbol_135;
			DomainType static_A_symbol_135 = valueFactory.typeOf(A_symbol_137);
			LibraryBinaryOperation dynamic_A_symbol_135 = (LibraryBinaryOperation)static_A_symbol_135.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_135 = dynamic_A_symbol_135.evaluate(evaluator, T_Boolean, A_symbol_137, A_symbol_140);
			return A_symbol_135;
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
			
			Value leftA_symbol_141;
			try {
				
				Value A_symbol_142 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_143 = valueFactory.typeOf(A_symbol_142, S_collectN___);
				LibraryBinaryOperation dynamic_A_symbol_143 = (LibraryBinaryOperation)static_A_symbol_143.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_143 = dynamic_A_symbol_143.evaluate(evaluator, T_Boolean, A_symbol_142, S_collectN___);
				leftA_symbol_141 = A_symbol_143;
			} catch (InvalidValueException e) {
				leftA_symbol_141 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_143 = leftA_symbol_141;
			Value rightA_symbol_141;
			try {
				
				Value A_symbol_144 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_145 = valueFactory.typeOf(A_symbol_144);
				LibraryBinaryOperation dynamic_A_symbol_145 = (LibraryBinaryOperation)static_A_symbol_145.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
				Value A_symbol_145 = dynamic_A_symbol_145.evaluate(evaluator, T_Boolean, A_symbol_144, T_ClassClassifier_Pivot_ecore__pivot__BagType_);
				rightA_symbol_141 = A_symbol_145;
			} catch (InvalidValueException e) {
				rightA_symbol_141 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_145 = rightA_symbol_141;
			DomainType static_A_symbol_141 = valueFactory.typeOf(A_symbol_143);
			LibraryBinaryOperation dynamic_A_symbol_141 = (LibraryBinaryOperation)static_A_symbol_141.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_141 = dynamic_A_symbol_141.evaluate(evaluator, T_Boolean, A_symbol_143, A_symbol_145);
			return A_symbol_141;
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
			
			Value leftA_symbol_146;
			try {
				
				Value A_symbol_147 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_148 = valueFactory.typeOf(A_symbol_147, S_collectN___);
				LibraryBinaryOperation dynamic_A_symbol_148 = (LibraryBinaryOperation)static_A_symbol_148.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_148 = dynamic_A_symbol_148.evaluate(evaluator, T_Boolean, A_symbol_147, S_collectN___);
				leftA_symbol_146 = A_symbol_148;
			} catch (InvalidValueException e) {
				leftA_symbol_146 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_148 = leftA_symbol_146;
			Value rightA_symbol_146;
			try {
				
				Value A_symbol_149 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				
				Value A_symbol_150 = IP_LoopExp_body.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_LoopExp_body);
				
				Value A_symbol_151 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_150, P_TypedElement_type);
				
				DomainType static_A_symbol_152 = valueFactory.typeOf(A_symbol_149, A_symbol_151);
				LibraryBinaryOperation dynamic_A_symbol_152 = (LibraryBinaryOperation)static_A_symbol_152.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_152 = dynamic_A_symbol_152.evaluate(evaluator, T_Boolean, A_symbol_149, A_symbol_151);
				rightA_symbol_146 = A_symbol_152;
			} catch (InvalidValueException e) {
				rightA_symbol_146 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_152 = rightA_symbol_146;
			DomainType static_A_symbol_146 = valueFactory.typeOf(A_symbol_148);
			LibraryBinaryOperation dynamic_A_symbol_146 = (LibraryBinaryOperation)static_A_symbol_146.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_146 = dynamic_A_symbol_146.evaluate(evaluator, T_Boolean, A_symbol_148, A_symbol_152);
			return A_symbol_146;
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
			
			Value leftA_symbol_153;
			try {
				
				Value A_symbol_154 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_155 = valueFactory.typeOf(A_symbol_154, S_collect);
				LibraryBinaryOperation dynamic_A_symbol_155 = (LibraryBinaryOperation)static_A_symbol_155.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_155 = dynamic_A_symbol_155.evaluate(evaluator, T_Boolean, A_symbol_154, S_collect);
				leftA_symbol_153 = A_symbol_155;
			} catch (InvalidValueException e) {
				leftA_symbol_153 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_155 = leftA_symbol_153;
			Value rightA_symbol_153;
			try {
					Value leftA_symbol_156;
					try {
						
						Value A_symbol_157 = IP_CallExp_source.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_CallExp_source);
						
						Value A_symbol_158 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_157, P_TypedElement_type);
						
						DomainType static_A_symbol_159 = valueFactory.typeOf(A_symbol_158);
						LibraryBinaryOperation dynamic_A_symbol_159 = (LibraryBinaryOperation)static_A_symbol_159.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Value A_symbol_159 = dynamic_A_symbol_159.evaluate(evaluator, T_Boolean, A_symbol_158, T_ClassClassifier_Pivot_ecore__pivot__SequenceType_);
						leftA_symbol_156 = A_symbol_159;
					} catch (InvalidValueException e) {
						leftA_symbol_156 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_159 = leftA_symbol_156;
					Value rightA_symbol_156;
					try {
						
						Value A_symbol_160 = IP_CallExp_source.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_CallExp_source);
						
						Value A_symbol_161 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_160, P_TypedElement_type);
						
						DomainType static_A_symbol_162 = valueFactory.typeOf(A_symbol_161);
						LibraryBinaryOperation dynamic_A_symbol_162 = (LibraryBinaryOperation)static_A_symbol_162.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Value A_symbol_162 = dynamic_A_symbol_162.evaluate(evaluator, T_Boolean, A_symbol_161, T_ClassClassifier_Pivot_ecore__pivot__OrderedSetType_);
						rightA_symbol_156 = A_symbol_162;
					} catch (InvalidValueException e) {
						rightA_symbol_156 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_162 = rightA_symbol_156;
					DomainType static_A_symbol_156 = valueFactory.typeOf(A_symbol_159);
					LibraryBinaryOperation dynamic_A_symbol_156 = (LibraryBinaryOperation)static_A_symbol_156.lookupImplementation(standardLibrary, O_Boolean_or);
					Value A_symbol_156 = dynamic_A_symbol_156.evaluate(evaluator, T_Boolean, A_symbol_159, A_symbol_162);
				Value A_symbol_163;
				if (A_symbol_156.isTrue()) {
					
					Value A_symbol_164 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
					
					DomainType static_A_symbol_165 = valueFactory.typeOf(A_symbol_164);
					LibraryBinaryOperation dynamic_A_symbol_165 = (LibraryBinaryOperation)static_A_symbol_165.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Value A_symbol_165 = dynamic_A_symbol_165.evaluate(evaluator, T_Boolean, A_symbol_164, T_ClassClassifier_Pivot_ecore__pivot__SequenceType_);
					A_symbol_163 = A_symbol_165;
				}
				else if (A_symbol_156.isFalse()) {
					
					Value A_symbol_166 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
					
					DomainType static_A_symbol_167 = valueFactory.typeOf(A_symbol_166);
					LibraryBinaryOperation dynamic_A_symbol_167 = (LibraryBinaryOperation)static_A_symbol_167.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Value A_symbol_167 = dynamic_A_symbol_167.evaluate(evaluator, T_Boolean, A_symbol_166, T_ClassClassifier_Pivot_ecore__pivot__BagType_);
					A_symbol_163 = A_symbol_167;
				}
				else if (A_symbol_156.isNull()) {
					A_symbol_163 = valueFactory.throwInvalidValueException("null if condition");
				}
				else {
					A_symbol_163 = valueFactory.throwInvalidValueException("invalid if condition");
				}
				rightA_symbol_153 = A_symbol_163;
			} catch (InvalidValueException e) {
				rightA_symbol_153 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_163 = rightA_symbol_153;
			DomainType static_A_symbol_153 = valueFactory.typeOf(A_symbol_155);
			LibraryBinaryOperation dynamic_A_symbol_153 = (LibraryBinaryOperation)static_A_symbol_153.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_153 = dynamic_A_symbol_153.evaluate(evaluator, T_Boolean, A_symbol_155, A_symbol_163);
			return A_symbol_153;
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
			
			Value leftA_symbol_168;
			try {
				
				Value A_symbol_169 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_170 = valueFactory.typeOf(A_symbol_169, S_exists);
				LibraryBinaryOperation dynamic_A_symbol_170 = (LibraryBinaryOperation)static_A_symbol_170.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_170 = dynamic_A_symbol_170.evaluate(evaluator, T_Boolean, A_symbol_169, S_exists);
				leftA_symbol_168 = A_symbol_170;
			} catch (InvalidValueException e) {
				leftA_symbol_168 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_170 = leftA_symbol_168;
			Value rightA_symbol_168;
			try {
				
				Value A_symbol_171 = IP_LoopExp_body.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_LoopExp_body);
				
				Value A_symbol_172 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_171, P_TypedElement_type);
				
				DomainType static_A_symbol_173 = valueFactory.typeOf(A_symbol_172, T_ClassClassifier_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_173 = (LibraryBinaryOperation)static_A_symbol_173.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_173 = dynamic_A_symbol_173.evaluate(evaluator, T_Boolean, A_symbol_172, T_ClassClassifier_Boolean_);
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
			
			Value leftA_symbol_174;
			try {
				
				Value A_symbol_175 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_176 = valueFactory.typeOf(A_symbol_175, S_exists);
				LibraryBinaryOperation dynamic_A_symbol_176 = (LibraryBinaryOperation)static_A_symbol_176.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_176 = dynamic_A_symbol_176.evaluate(evaluator, T_Boolean, A_symbol_175, S_exists);
				leftA_symbol_174 = A_symbol_176;
			} catch (InvalidValueException e) {
				leftA_symbol_174 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_176 = leftA_symbol_174;
			Value rightA_symbol_174;
			try {
				
				Value A_symbol_177 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_178 = valueFactory.typeOf(A_symbol_177, T_ClassClassifier_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_178 = (LibraryBinaryOperation)static_A_symbol_178.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_178 = dynamic_A_symbol_178.evaluate(evaluator, T_Boolean, A_symbol_177, T_ClassClassifier_Boolean_);
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
			
			Value leftA_symbol_179;
			try {
				
				Value A_symbol_180 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_181 = valueFactory.typeOf(A_symbol_180, S_forAll);
				LibraryBinaryOperation dynamic_A_symbol_181 = (LibraryBinaryOperation)static_A_symbol_181.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_181 = dynamic_A_symbol_181.evaluate(evaluator, T_Boolean, A_symbol_180, S_forAll);
				leftA_symbol_179 = A_symbol_181;
			} catch (InvalidValueException e) {
				leftA_symbol_179 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_181 = leftA_symbol_179;
			Value rightA_symbol_179;
			try {
				
				Value A_symbol_182 = IP_LoopExp_body.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_LoopExp_body);
				
				Value A_symbol_183 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_182, P_TypedElement_type);
				
				DomainType static_A_symbol_184 = valueFactory.typeOf(A_symbol_183, T_ClassClassifier_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_184 = (LibraryBinaryOperation)static_A_symbol_184.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_184 = dynamic_A_symbol_184.evaluate(evaluator, T_Boolean, A_symbol_183, T_ClassClassifier_Boolean_);
				rightA_symbol_179 = A_symbol_184;
			} catch (InvalidValueException e) {
				rightA_symbol_179 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_184 = rightA_symbol_179;
			DomainType static_A_symbol_179 = valueFactory.typeOf(A_symbol_181);
			LibraryBinaryOperation dynamic_A_symbol_179 = (LibraryBinaryOperation)static_A_symbol_179.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_179 = dynamic_A_symbol_179.evaluate(evaluator, T_Boolean, A_symbol_181, A_symbol_184);
			return A_symbol_179;
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
			
			Value leftA_symbol_185;
			try {
				
				Value A_symbol_186 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_187 = valueFactory.typeOf(A_symbol_186, S_forAll);
				LibraryBinaryOperation dynamic_A_symbol_187 = (LibraryBinaryOperation)static_A_symbol_187.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_187 = dynamic_A_symbol_187.evaluate(evaluator, T_Boolean, A_symbol_186, S_forAll);
				leftA_symbol_185 = A_symbol_187;
			} catch (InvalidValueException e) {
				leftA_symbol_185 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_187 = leftA_symbol_185;
			Value rightA_symbol_185;
			try {
				
				Value A_symbol_188 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_189 = valueFactory.typeOf(A_symbol_188, T_ClassClassifier_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_189 = (LibraryBinaryOperation)static_A_symbol_189.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_189 = dynamic_A_symbol_189.evaluate(evaluator, T_Boolean, A_symbol_188, T_ClassClassifier_Boolean_);
				rightA_symbol_185 = A_symbol_189;
			} catch (InvalidValueException e) {
				rightA_symbol_185 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_189 = rightA_symbol_185;
			DomainType static_A_symbol_185 = valueFactory.typeOf(A_symbol_187);
			LibraryBinaryOperation dynamic_A_symbol_185 = (LibraryBinaryOperation)static_A_symbol_185.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_185 = dynamic_A_symbol_185.evaluate(evaluator, T_Boolean, A_symbol_187, A_symbol_189);
			return A_symbol_185;
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
			
			Value leftA_symbol_190;
			try {
				
				Value A_symbol_191 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_192 = valueFactory.typeOf(A_symbol_191, S_isUnique);
				LibraryBinaryOperation dynamic_A_symbol_192 = (LibraryBinaryOperation)static_A_symbol_192.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_192 = dynamic_A_symbol_192.evaluate(evaluator, T_Boolean, A_symbol_191, S_isUnique);
				leftA_symbol_190 = A_symbol_192;
			} catch (InvalidValueException e) {
				leftA_symbol_190 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_192 = leftA_symbol_190;
			Value rightA_symbol_190;
			try {
				
				Value A_symbol_193 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_Pivot_ecore__pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_194 = valueFactory.typeOf(A_symbol_193);
				LibraryUnaryOperation dynamic_A_symbol_194 = (LibraryUnaryOperation)static_A_symbol_194.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_194 = dynamic_A_symbol_194.evaluate(evaluator, T_Integer, A_symbol_193);
				DomainType static_A_symbol_195 = valueFactory.typeOf(A_symbol_194, I_1);
				LibraryBinaryOperation dynamic_A_symbol_195 = (LibraryBinaryOperation)static_A_symbol_195.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_195 = dynamic_A_symbol_195.evaluate(evaluator, T_Boolean, A_symbol_194, I_1);
				rightA_symbol_190 = A_symbol_195;
			} catch (InvalidValueException e) {
				rightA_symbol_190 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_195 = rightA_symbol_190;
			DomainType static_A_symbol_190 = valueFactory.typeOf(A_symbol_192);
			LibraryBinaryOperation dynamic_A_symbol_190 = (LibraryBinaryOperation)static_A_symbol_190.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_190 = dynamic_A_symbol_190.evaluate(evaluator, T_Boolean, A_symbol_192, A_symbol_195);
			return A_symbol_190;
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
			
			Value leftA_symbol_196;
			try {
				
				Value A_symbol_197 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_198 = valueFactory.typeOf(A_symbol_197, S_isUnique);
				LibraryBinaryOperation dynamic_A_symbol_198 = (LibraryBinaryOperation)static_A_symbol_198.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_198 = dynamic_A_symbol_198.evaluate(evaluator, T_Boolean, A_symbol_197, S_isUnique);
				leftA_symbol_196 = A_symbol_198;
			} catch (InvalidValueException e) {
				leftA_symbol_196 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_198 = leftA_symbol_196;
			Value rightA_symbol_196;
			try {
				
				Value A_symbol_199 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_200 = valueFactory.typeOf(A_symbol_199, T_ClassClassifier_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_200 = (LibraryBinaryOperation)static_A_symbol_200.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_200 = dynamic_A_symbol_200.evaluate(evaluator, T_Boolean, A_symbol_199, T_ClassClassifier_Boolean_);
				rightA_symbol_196 = A_symbol_200;
			} catch (InvalidValueException e) {
				rightA_symbol_196 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_200 = rightA_symbol_196;
			DomainType static_A_symbol_196 = valueFactory.typeOf(A_symbol_198);
			LibraryBinaryOperation dynamic_A_symbol_196 = (LibraryBinaryOperation)static_A_symbol_196.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_196 = dynamic_A_symbol_196.evaluate(evaluator, T_Boolean, A_symbol_198, A_symbol_200);
			return A_symbol_196;
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
			
			
			Value A_symbol_201 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_Pivot_ecore__pivot__Variable_, self, P_LoopExp_iterator);
			
			
			/** 
			 * Implementation of the iterator body.
			 */
			AbstractBinaryOperation body_A_symbol_202 = new AbstractBinaryOperation()
			{
			/*
			type =
			source.type.oclAsType(_'file:/C:/Development/QVTd/GIT/org.eclipse.ocl/examples/org.eclipse.ocl.examples.pivot/model/Pivot.ecore'::ocl::CollectionType).elementType
			*/
				public Value evaluate(DomainEvaluator evaluator, DomainType returnType, Value sourceValue, Value iterator1) throws InvalidValueException {
					final Value V_1_ = iterator1;	// iterator: 1_
					
					Value A_symbol_203 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, V_1_, P_TypedElement_type);
					
					
					Value A_symbol_204 = IP_CallExp_source.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_CallExp_source);
					
					Value A_symbol_205 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_204, P_TypedElement_type);
					
					DomainType static_A_symbol_206 = valueFactory.typeOf(A_symbol_205);
					LibraryBinaryOperation dynamic_A_symbol_206 = (LibraryBinaryOperation)static_A_symbol_206.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
					Value A_symbol_206 = dynamic_A_symbol_206.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionType, A_symbol_205, T_ClassClassifier_Pivot_ecore__pivot__CollectionType_);
					Value A_symbol_207 = IP_CollectionType_elementType.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_206, P_CollectionType_elementType);
					
					DomainType static_A_symbol_208 = valueFactory.typeOf(A_symbol_203, A_symbol_207);
					LibraryBinaryOperation dynamic_A_symbol_208 = (LibraryBinaryOperation)static_A_symbol_208.lookupImplementation(standardLibrary, O_OclAny__eq_);
					Value A_symbol_208 = dynamic_A_symbol_208.evaluate(evaluator, T_Boolean, A_symbol_203, A_symbol_207);
					return A_symbol_208;
				}
			};
			DomainType static_A_symbol_202 = A_symbol_201.getType();
			LibraryIteration dynamic_A_symbol_202 = (LibraryIteration)static_A_symbol_202.lookupImplementation(standardLibrary, O_Collection_forAll);
			Value acc_A_symbol_202 = dynamic_A_symbol_202.createAccumulatorValue(evaluator, T_Boolean, T_Boolean);
			ExecutorSingleIterationManager manager_A_symbol_202 = new ExecutorSingleIterationManager(evaluator, T_Boolean, body_A_symbol_202, (CollectionValue)A_symbol_201, acc_A_symbol_202);
			Value A_symbol_202 = dynamic_A_symbol_202.evaluateIteration(manager_A_symbol_202);
			return A_symbol_202;
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
			
			Value leftA_symbol_209;
			try {
				
				Value A_symbol_210 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_211 = valueFactory.typeOf(A_symbol_210, S_one);
				LibraryBinaryOperation dynamic_A_symbol_211 = (LibraryBinaryOperation)static_A_symbol_211.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_211 = dynamic_A_symbol_211.evaluate(evaluator, T_Boolean, A_symbol_210, S_one);
				leftA_symbol_209 = A_symbol_211;
			} catch (InvalidValueException e) {
				leftA_symbol_209 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_211 = leftA_symbol_209;
			Value rightA_symbol_209;
			try {
				
				Value A_symbol_212 = IP_LoopExp_body.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_LoopExp_body);
				
				Value A_symbol_213 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_212, P_TypedElement_type);
				
				DomainType static_A_symbol_214 = valueFactory.typeOf(A_symbol_213, T_ClassClassifier_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_214 = (LibraryBinaryOperation)static_A_symbol_214.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_214 = dynamic_A_symbol_214.evaluate(evaluator, T_Boolean, A_symbol_213, T_ClassClassifier_Boolean_);
				rightA_symbol_209 = A_symbol_214;
			} catch (InvalidValueException e) {
				rightA_symbol_209 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_214 = rightA_symbol_209;
			DomainType static_A_symbol_209 = valueFactory.typeOf(A_symbol_211);
			LibraryBinaryOperation dynamic_A_symbol_209 = (LibraryBinaryOperation)static_A_symbol_209.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_209 = dynamic_A_symbol_209.evaluate(evaluator, T_Boolean, A_symbol_211, A_symbol_214);
			return A_symbol_209;
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
			
			Value leftA_symbol_215;
			try {
				
				Value A_symbol_216 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_217 = valueFactory.typeOf(A_symbol_216, S_one);
				LibraryBinaryOperation dynamic_A_symbol_217 = (LibraryBinaryOperation)static_A_symbol_217.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_217 = dynamic_A_symbol_217.evaluate(evaluator, T_Boolean, A_symbol_216, S_one);
				leftA_symbol_215 = A_symbol_217;
			} catch (InvalidValueException e) {
				leftA_symbol_215 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_217 = leftA_symbol_215;
			Value rightA_symbol_215;
			try {
				
				Value A_symbol_218 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_Pivot_ecore__pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_219 = valueFactory.typeOf(A_symbol_218);
				LibraryUnaryOperation dynamic_A_symbol_219 = (LibraryUnaryOperation)static_A_symbol_219.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_219 = dynamic_A_symbol_219.evaluate(evaluator, T_Integer, A_symbol_218);
				DomainType static_A_symbol_220 = valueFactory.typeOf(A_symbol_219, I_1);
				LibraryBinaryOperation dynamic_A_symbol_220 = (LibraryBinaryOperation)static_A_symbol_220.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_220 = dynamic_A_symbol_220.evaluate(evaluator, T_Boolean, A_symbol_219, I_1);
				rightA_symbol_215 = A_symbol_220;
			} catch (InvalidValueException e) {
				rightA_symbol_215 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_220 = rightA_symbol_215;
			DomainType static_A_symbol_215 = valueFactory.typeOf(A_symbol_217);
			LibraryBinaryOperation dynamic_A_symbol_215 = (LibraryBinaryOperation)static_A_symbol_215.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_215 = dynamic_A_symbol_215.evaluate(evaluator, T_Boolean, A_symbol_217, A_symbol_220);
			return A_symbol_215;
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
			
			Value leftA_symbol_221;
			try {
				
				Value A_symbol_222 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_223 = valueFactory.typeOf(A_symbol_222, S_one);
				LibraryBinaryOperation dynamic_A_symbol_223 = (LibraryBinaryOperation)static_A_symbol_223.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_223 = dynamic_A_symbol_223.evaluate(evaluator, T_Boolean, A_symbol_222, S_one);
				leftA_symbol_221 = A_symbol_223;
			} catch (InvalidValueException e) {
				leftA_symbol_221 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_223 = leftA_symbol_221;
			Value rightA_symbol_221;
			try {
				
				Value A_symbol_224 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_225 = valueFactory.typeOf(A_symbol_224, T_ClassClassifier_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_225 = (LibraryBinaryOperation)static_A_symbol_225.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_225 = dynamic_A_symbol_225.evaluate(evaluator, T_Boolean, A_symbol_224, T_ClassClassifier_Boolean_);
				rightA_symbol_221 = A_symbol_225;
			} catch (InvalidValueException e) {
				rightA_symbol_221 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_225 = rightA_symbol_221;
			DomainType static_A_symbol_221 = valueFactory.typeOf(A_symbol_223);
			LibraryBinaryOperation dynamic_A_symbol_221 = (LibraryBinaryOperation)static_A_symbol_221.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_221 = dynamic_A_symbol_221.evaluate(evaluator, T_Boolean, A_symbol_223, A_symbol_225);
			return A_symbol_221;
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
			
			Value leftA_symbol_226;
			try {
				Value leftA_symbol_227;
				try {
					
					Value A_symbol_228 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
					
					DomainType static_A_symbol_229 = valueFactory.typeOf(A_symbol_228, S_reject);
					LibraryBinaryOperation dynamic_A_symbol_229 = (LibraryBinaryOperation)static_A_symbol_229.lookupImplementation(standardLibrary, O_String__eq_);
					Value A_symbol_229 = dynamic_A_symbol_229.evaluate(evaluator, T_Boolean, A_symbol_228, S_reject);
					leftA_symbol_227 = A_symbol_229;
				} catch (InvalidValueException e) {
					leftA_symbol_227 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_229 = leftA_symbol_227;
				Value rightA_symbol_227;
				try {
					
					Value A_symbol_230 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
					
					DomainType static_A_symbol_231 = valueFactory.typeOf(A_symbol_230, S_select);
					LibraryBinaryOperation dynamic_A_symbol_231 = (LibraryBinaryOperation)static_A_symbol_231.lookupImplementation(standardLibrary, O_String__eq_);
					Value A_symbol_231 = dynamic_A_symbol_231.evaluate(evaluator, T_Boolean, A_symbol_230, S_select);
					rightA_symbol_227 = A_symbol_231;
				} catch (InvalidValueException e) {
					rightA_symbol_227 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_231 = rightA_symbol_227;
				DomainType static_A_symbol_227 = valueFactory.typeOf(A_symbol_229);
				LibraryBinaryOperation dynamic_A_symbol_227 = (LibraryBinaryOperation)static_A_symbol_227.lookupImplementation(standardLibrary, O_Boolean_or);
				Value A_symbol_227 = dynamic_A_symbol_227.evaluate(evaluator, T_Boolean, A_symbol_229, A_symbol_231);
				leftA_symbol_226 = A_symbol_227;
			} catch (InvalidValueException e) {
				leftA_symbol_226 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_227 = leftA_symbol_226;
			Value rightA_symbol_226;
			try {
				
				Value A_symbol_232 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_Pivot_ecore__pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_233 = valueFactory.typeOf(A_symbol_232);
				LibraryUnaryOperation dynamic_A_symbol_233 = (LibraryUnaryOperation)static_A_symbol_233.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_233 = dynamic_A_symbol_233.evaluate(evaluator, T_Integer, A_symbol_232);
				DomainType static_A_symbol_234 = valueFactory.typeOf(A_symbol_233, I_1);
				LibraryBinaryOperation dynamic_A_symbol_234 = (LibraryBinaryOperation)static_A_symbol_234.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_234 = dynamic_A_symbol_234.evaluate(evaluator, T_Boolean, A_symbol_233, I_1);
				rightA_symbol_226 = A_symbol_234;
			} catch (InvalidValueException e) {
				rightA_symbol_226 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_234 = rightA_symbol_226;
			DomainType static_A_symbol_226 = valueFactory.typeOf(A_symbol_227);
			LibraryBinaryOperation dynamic_A_symbol_226 = (LibraryBinaryOperation)static_A_symbol_226.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_226 = dynamic_A_symbol_226.evaluate(evaluator, T_Boolean, A_symbol_227, A_symbol_234);
			return A_symbol_226;
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
			
			Value leftA_symbol_235;
			try {
				Value leftA_symbol_236;
				try {
					
					Value A_symbol_237 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
					
					DomainType static_A_symbol_238 = valueFactory.typeOf(A_symbol_237, S_reject);
					LibraryBinaryOperation dynamic_A_symbol_238 = (LibraryBinaryOperation)static_A_symbol_238.lookupImplementation(standardLibrary, O_String__eq_);
					Value A_symbol_238 = dynamic_A_symbol_238.evaluate(evaluator, T_Boolean, A_symbol_237, S_reject);
					leftA_symbol_236 = A_symbol_238;
				} catch (InvalidValueException e) {
					leftA_symbol_236 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_238 = leftA_symbol_236;
				Value rightA_symbol_236;
				try {
					
					Value A_symbol_239 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
					
					DomainType static_A_symbol_240 = valueFactory.typeOf(A_symbol_239, S_select);
					LibraryBinaryOperation dynamic_A_symbol_240 = (LibraryBinaryOperation)static_A_symbol_240.lookupImplementation(standardLibrary, O_String__eq_);
					Value A_symbol_240 = dynamic_A_symbol_240.evaluate(evaluator, T_Boolean, A_symbol_239, S_select);
					rightA_symbol_236 = A_symbol_240;
				} catch (InvalidValueException e) {
					rightA_symbol_236 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_240 = rightA_symbol_236;
				DomainType static_A_symbol_236 = valueFactory.typeOf(A_symbol_238);
				LibraryBinaryOperation dynamic_A_symbol_236 = (LibraryBinaryOperation)static_A_symbol_236.lookupImplementation(standardLibrary, O_Boolean_or);
				Value A_symbol_236 = dynamic_A_symbol_236.evaluate(evaluator, T_Boolean, A_symbol_238, A_symbol_240);
				leftA_symbol_235 = A_symbol_236;
			} catch (InvalidValueException e) {
				leftA_symbol_235 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_236 = leftA_symbol_235;
			Value rightA_symbol_235;
			try {
				
				Value A_symbol_241 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_242 = valueFactory.typeOf(A_symbol_241, T_ClassClassifier_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_242 = (LibraryBinaryOperation)static_A_symbol_242.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_242 = dynamic_A_symbol_242.evaluate(evaluator, T_Boolean, A_symbol_241, T_ClassClassifier_Boolean_);
				rightA_symbol_235 = A_symbol_242;
			} catch (InvalidValueException e) {
				rightA_symbol_235 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_242 = rightA_symbol_235;
			DomainType static_A_symbol_235 = valueFactory.typeOf(A_symbol_236);
			LibraryBinaryOperation dynamic_A_symbol_235 = (LibraryBinaryOperation)static_A_symbol_235.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_235 = dynamic_A_symbol_235.evaluate(evaluator, T_Boolean, A_symbol_236, A_symbol_242);
			return A_symbol_235;
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
			
			Value leftA_symbol_243;
			try {
				Value leftA_symbol_244;
				try {
					
					Value A_symbol_245 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
					
					DomainType static_A_symbol_246 = valueFactory.typeOf(A_symbol_245, S_reject);
					LibraryBinaryOperation dynamic_A_symbol_246 = (LibraryBinaryOperation)static_A_symbol_246.lookupImplementation(standardLibrary, O_String__eq_);
					Value A_symbol_246 = dynamic_A_symbol_246.evaluate(evaluator, T_Boolean, A_symbol_245, S_reject);
					leftA_symbol_244 = A_symbol_246;
				} catch (InvalidValueException e) {
					leftA_symbol_244 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_246 = leftA_symbol_244;
				Value rightA_symbol_244;
				try {
					
					Value A_symbol_247 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
					
					DomainType static_A_symbol_248 = valueFactory.typeOf(A_symbol_247, S_select);
					LibraryBinaryOperation dynamic_A_symbol_248 = (LibraryBinaryOperation)static_A_symbol_248.lookupImplementation(standardLibrary, O_String__eq_);
					Value A_symbol_248 = dynamic_A_symbol_248.evaluate(evaluator, T_Boolean, A_symbol_247, S_select);
					rightA_symbol_244 = A_symbol_248;
				} catch (InvalidValueException e) {
					rightA_symbol_244 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_248 = rightA_symbol_244;
				DomainType static_A_symbol_244 = valueFactory.typeOf(A_symbol_246);
				LibraryBinaryOperation dynamic_A_symbol_244 = (LibraryBinaryOperation)static_A_symbol_244.lookupImplementation(standardLibrary, O_Boolean_or);
				Value A_symbol_244 = dynamic_A_symbol_244.evaluate(evaluator, T_Boolean, A_symbol_246, A_symbol_248);
				leftA_symbol_243 = A_symbol_244;
			} catch (InvalidValueException e) {
				leftA_symbol_243 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_244 = leftA_symbol_243;
			Value rightA_symbol_243;
			try {
				
				Value A_symbol_249 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				
				Value A_symbol_250 = IP_CallExp_source.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_CallExp_source);
				
				Value A_symbol_251 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_250, P_TypedElement_type);
				
				DomainType static_A_symbol_252 = valueFactory.typeOf(A_symbol_249, A_symbol_251);
				LibraryBinaryOperation dynamic_A_symbol_252 = (LibraryBinaryOperation)static_A_symbol_252.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_252 = dynamic_A_symbol_252.evaluate(evaluator, T_Boolean, A_symbol_249, A_symbol_251);
				rightA_symbol_243 = A_symbol_252;
			} catch (InvalidValueException e) {
				rightA_symbol_243 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_252 = rightA_symbol_243;
			DomainType static_A_symbol_243 = valueFactory.typeOf(A_symbol_244);
			LibraryBinaryOperation dynamic_A_symbol_243 = (LibraryBinaryOperation)static_A_symbol_243.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_243 = dynamic_A_symbol_243.evaluate(evaluator, T_Boolean, A_symbol_244, A_symbol_252);
			return A_symbol_243;
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
			
			Value leftA_symbol_253;
			try {
				
				Value A_symbol_254 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_255 = valueFactory.typeOf(A_symbol_254, S_sortedBy);
				LibraryBinaryOperation dynamic_A_symbol_255 = (LibraryBinaryOperation)static_A_symbol_255.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_255 = dynamic_A_symbol_255.evaluate(evaluator, T_Boolean, A_symbol_254, S_sortedBy);
				leftA_symbol_253 = A_symbol_255;
			} catch (InvalidValueException e) {
				leftA_symbol_253 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_255 = leftA_symbol_253;
			Value rightA_symbol_253;
			try {
				
				Value A_symbol_256 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_257 = valueFactory.typeOf(A_symbol_256);
				LibraryBinaryOperation dynamic_A_symbol_257 = (LibraryBinaryOperation)static_A_symbol_257.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_257 = dynamic_A_symbol_257.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionType, A_symbol_256, T_ClassClassifier_Pivot_ecore__pivot__CollectionType_);
				Value A_symbol_258 = IP_CollectionType_elementType.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_257, P_CollectionType_elementType);
				
				
				Value A_symbol_259 = IP_LoopExp_body.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_LoopExp_body);
				
				Value A_symbol_260 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_259, P_TypedElement_type);
				
				DomainType static_A_symbol_261 = valueFactory.typeOf(A_symbol_260);
				LibraryBinaryOperation dynamic_A_symbol_261 = (LibraryBinaryOperation)static_A_symbol_261.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_261 = dynamic_A_symbol_261.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionType, A_symbol_260, T_ClassClassifier_Pivot_ecore__pivot__CollectionType_);
				Value A_symbol_262 = IP_CollectionType_elementType.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_261, P_CollectionType_elementType);
				
				DomainType static_A_symbol_263 = valueFactory.typeOf(A_symbol_258, A_symbol_262);
				LibraryBinaryOperation dynamic_A_symbol_263 = (LibraryBinaryOperation)static_A_symbol_263.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_263 = dynamic_A_symbol_263.evaluate(evaluator, T_Boolean, A_symbol_258, A_symbol_262);
				rightA_symbol_253 = A_symbol_263;
			} catch (InvalidValueException e) {
				rightA_symbol_253 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_263 = rightA_symbol_253;
			DomainType static_A_symbol_253 = valueFactory.typeOf(A_symbol_255);
			LibraryBinaryOperation dynamic_A_symbol_253 = (LibraryBinaryOperation)static_A_symbol_253.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_253 = dynamic_A_symbol_253.evaluate(evaluator, T_Boolean, A_symbol_255, A_symbol_263);
			return A_symbol_253;
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
			
			Value leftA_symbol_264;
			try {
				
				Value A_symbol_265 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_266 = valueFactory.typeOf(A_symbol_265, S_sortedBy);
				LibraryBinaryOperation dynamic_A_symbol_266 = (LibraryBinaryOperation)static_A_symbol_266.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_266 = dynamic_A_symbol_266.evaluate(evaluator, T_Boolean, A_symbol_265, S_sortedBy);
				leftA_symbol_264 = A_symbol_266;
			} catch (InvalidValueException e) {
				leftA_symbol_264 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_266 = leftA_symbol_264;
			Value rightA_symbol_264;
			try {
				
				Value A_symbol_267 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_Pivot_ecore__pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_268 = valueFactory.typeOf(A_symbol_267);
				LibraryUnaryOperation dynamic_A_symbol_268 = (LibraryUnaryOperation)static_A_symbol_268.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_268 = dynamic_A_symbol_268.evaluate(evaluator, T_Integer, A_symbol_267);
				DomainType static_A_symbol_269 = valueFactory.typeOf(A_symbol_268, I_1);
				LibraryBinaryOperation dynamic_A_symbol_269 = (LibraryBinaryOperation)static_A_symbol_269.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_269 = dynamic_A_symbol_269.evaluate(evaluator, T_Boolean, A_symbol_268, I_1);
				rightA_symbol_264 = A_symbol_269;
			} catch (InvalidValueException e) {
				rightA_symbol_264 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_269 = rightA_symbol_264;
			DomainType static_A_symbol_264 = valueFactory.typeOf(A_symbol_266);
			LibraryBinaryOperation dynamic_A_symbol_264 = (LibraryBinaryOperation)static_A_symbol_264.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_264 = dynamic_A_symbol_264.evaluate(evaluator, T_Boolean, A_symbol_266, A_symbol_269);
			return A_symbol_264;
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
			
			Value leftA_symbol_270;
			try {
				
				Value A_symbol_271 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_272 = valueFactory.typeOf(A_symbol_271, S_sortedBy);
				LibraryBinaryOperation dynamic_A_symbol_272 = (LibraryBinaryOperation)static_A_symbol_272.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_272 = dynamic_A_symbol_272.evaluate(evaluator, T_Boolean, A_symbol_271, S_sortedBy);
				leftA_symbol_270 = A_symbol_272;
			} catch (InvalidValueException e) {
				leftA_symbol_270 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_272 = leftA_symbol_270;
			Value rightA_symbol_270;
			try {
					Value leftA_symbol_273;
					try {
						
						Value A_symbol_274 = IP_CallExp_source.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_CallExp_source);
						
						Value A_symbol_275 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_274, P_TypedElement_type);
						
						DomainType static_A_symbol_276 = valueFactory.typeOf(A_symbol_275);
						LibraryBinaryOperation dynamic_A_symbol_276 = (LibraryBinaryOperation)static_A_symbol_276.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Value A_symbol_276 = dynamic_A_symbol_276.evaluate(evaluator, T_Boolean, A_symbol_275, T_ClassClassifier_Pivot_ecore__pivot__SequenceType_);
						leftA_symbol_273 = A_symbol_276;
					} catch (InvalidValueException e) {
						leftA_symbol_273 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_276 = leftA_symbol_273;
					Value rightA_symbol_273;
					try {
						
						Value A_symbol_277 = IP_CallExp_source.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_CallExp_source);
						
						Value A_symbol_278 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_277, P_TypedElement_type);
						
						DomainType static_A_symbol_279 = valueFactory.typeOf(A_symbol_278);
						LibraryBinaryOperation dynamic_A_symbol_279 = (LibraryBinaryOperation)static_A_symbol_279.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Value A_symbol_279 = dynamic_A_symbol_279.evaluate(evaluator, T_Boolean, A_symbol_278, T_ClassClassifier_Pivot_ecore__pivot__BagType_);
						rightA_symbol_273 = A_symbol_279;
					} catch (InvalidValueException e) {
						rightA_symbol_273 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_279 = rightA_symbol_273;
					DomainType static_A_symbol_273 = valueFactory.typeOf(A_symbol_276);
					LibraryBinaryOperation dynamic_A_symbol_273 = (LibraryBinaryOperation)static_A_symbol_273.lookupImplementation(standardLibrary, O_Boolean_or);
					Value A_symbol_273 = dynamic_A_symbol_273.evaluate(evaluator, T_Boolean, A_symbol_276, A_symbol_279);
				Value A_symbol_280;
				if (A_symbol_273.isTrue()) {
					
					Value A_symbol_281 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
					
					DomainType static_A_symbol_282 = valueFactory.typeOf(A_symbol_281);
					LibraryBinaryOperation dynamic_A_symbol_282 = (LibraryBinaryOperation)static_A_symbol_282.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Value A_symbol_282 = dynamic_A_symbol_282.evaluate(evaluator, T_Boolean, A_symbol_281, T_ClassClassifier_Pivot_ecore__pivot__SequenceType_);
					A_symbol_280 = A_symbol_282;
				}
				else if (A_symbol_273.isFalse()) {
					
					Value A_symbol_283 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
					
					DomainType static_A_symbol_284 = valueFactory.typeOf(A_symbol_283);
					LibraryBinaryOperation dynamic_A_symbol_284 = (LibraryBinaryOperation)static_A_symbol_284.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Value A_symbol_284 = dynamic_A_symbol_284.evaluate(evaluator, T_Boolean, A_symbol_283, T_ClassClassifier_Pivot_ecore__pivot__OrderedSetType_);
					A_symbol_280 = A_symbol_284;
				}
				else if (A_symbol_273.isNull()) {
					A_symbol_280 = valueFactory.throwInvalidValueException("null if condition");
				}
				else {
					A_symbol_280 = valueFactory.throwInvalidValueException("invalid if condition");
				}
				rightA_symbol_270 = A_symbol_280;
			} catch (InvalidValueException e) {
				rightA_symbol_270 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_280 = rightA_symbol_270;
			DomainType static_A_symbol_270 = valueFactory.typeOf(A_symbol_272);
			LibraryBinaryOperation dynamic_A_symbol_270 = (LibraryBinaryOperation)static_A_symbol_270.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_270 = dynamic_A_symbol_270.evaluate(evaluator, T_Boolean, A_symbol_272, A_symbol_280);
			return A_symbol_270;
		}
	}
}

