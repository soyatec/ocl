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
			
			Value leftA_symbol_31;
			try {
				
				Value A_symbol_32 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_33 = valueFactory.typeOf(A_symbol_32, S_any);
				LibraryBinaryOperation dynamic_A_symbol_33 = (LibraryBinaryOperation)static_A_symbol_33.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_33 = dynamic_A_symbol_33.evaluate(evaluator, T_Boolean, A_symbol_32, S_any);
				leftA_symbol_31 = A_symbol_33;
			} catch (InvalidValueException e) {
				leftA_symbol_31 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_33 = leftA_symbol_31;
			Value rightA_symbol_31;
			try {
				
				Value A_symbol_34 = IP_LoopExp_body.evaluate(evaluator, T_pivot__OCLExpression, self, P_LoopExp_body);
				
				Value A_symbol_35 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_34, P_TypedElement_type);
				
				DomainType static_A_symbol_36 = valueFactory.typeOf(A_symbol_35, S_Boolean);
				LibraryBinaryOperation dynamic_A_symbol_36 = (LibraryBinaryOperation)static_A_symbol_36.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_36 = dynamic_A_symbol_36.evaluate(evaluator, T_Boolean, A_symbol_35, S_Boolean);
				rightA_symbol_31 = A_symbol_36;
			} catch (InvalidValueException e) {
				rightA_symbol_31 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_36 = rightA_symbol_31;
			DomainType static_A_symbol_31 = valueFactory.typeOf(A_symbol_33);
			LibraryBinaryOperation dynamic_A_symbol_31 = (LibraryBinaryOperation)static_A_symbol_31.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_31 = dynamic_A_symbol_31.evaluate(evaluator, T_Boolean, A_symbol_33, A_symbol_36);
			return A_symbol_31;
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
			
			Value leftA_symbol_37;
			try {
				
				Value A_symbol_38 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_39 = valueFactory.typeOf(A_symbol_38, S_any);
				LibraryBinaryOperation dynamic_A_symbol_39 = (LibraryBinaryOperation)static_A_symbol_39.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_39 = dynamic_A_symbol_39.evaluate(evaluator, T_Boolean, A_symbol_38, S_any);
				leftA_symbol_37 = A_symbol_39;
			} catch (InvalidValueException e) {
				leftA_symbol_37 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_39 = leftA_symbol_37;
			Value rightA_symbol_37;
			try {
				
				Value A_symbol_40 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_41 = valueFactory.typeOf(A_symbol_40);
				LibraryUnaryOperation dynamic_A_symbol_41 = (LibraryUnaryOperation)static_A_symbol_41.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_41 = dynamic_A_symbol_41.evaluate(evaluator, T_Integer, A_symbol_40);
				DomainType static_A_symbol_42 = valueFactory.typeOf(A_symbol_41, I_1);
				LibraryBinaryOperation dynamic_A_symbol_42 = (LibraryBinaryOperation)static_A_symbol_42.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_42 = dynamic_A_symbol_42.evaluate(evaluator, T_Boolean, A_symbol_41, I_1);
				rightA_symbol_37 = A_symbol_42;
			} catch (InvalidValueException e) {
				rightA_symbol_37 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_42 = rightA_symbol_37;
			DomainType static_A_symbol_37 = valueFactory.typeOf(A_symbol_39);
			LibraryBinaryOperation dynamic_A_symbol_37 = (LibraryBinaryOperation)static_A_symbol_37.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_37 = dynamic_A_symbol_37.evaluate(evaluator, T_Boolean, A_symbol_39, A_symbol_42);
			return A_symbol_37;
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
			final @NonNull Value T_ClassClassifier_pivot__CollectionType_ = valueFactory.createTypeValue(PivotTables.Types._CollectionType);
			
			Value leftA_symbol_43;
			try {
				
				Value A_symbol_44 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_45 = valueFactory.typeOf(A_symbol_44, S_any);
				LibraryBinaryOperation dynamic_A_symbol_45 = (LibraryBinaryOperation)static_A_symbol_45.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_45 = dynamic_A_symbol_45.evaluate(evaluator, T_Boolean, A_symbol_44, S_any);
				leftA_symbol_43 = A_symbol_45;
			} catch (InvalidValueException e) {
				leftA_symbol_43 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_45 = leftA_symbol_43;
			Value rightA_symbol_43;
			try {
				
				Value A_symbol_46 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				
				Value A_symbol_47 = IP_CallExp_source.evaluate(evaluator, T_pivot__OCLExpression, self, P_CallExp_source);
				
				Value A_symbol_48 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_47, P_TypedElement_type);
				
				DomainType static_A_symbol_49 = valueFactory.typeOf(A_symbol_48);
				LibraryBinaryOperation dynamic_A_symbol_49 = (LibraryBinaryOperation)static_A_symbol_49.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_49 = dynamic_A_symbol_49.evaluate(evaluator, T_pivot__CollectionType, A_symbol_48, T_ClassClassifier_pivot__CollectionType_);
				Value A_symbol_50 = IP_CollectionType_elementType.evaluate(evaluator, T_Type, A_symbol_49, P_CollectionType_elementType);
				
				DomainType static_A_symbol_51 = valueFactory.typeOf(A_symbol_46, A_symbol_50);
				LibraryBinaryOperation dynamic_A_symbol_51 = (LibraryBinaryOperation)static_A_symbol_51.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_51 = dynamic_A_symbol_51.evaluate(evaluator, T_Boolean, A_symbol_46, A_symbol_50);
				rightA_symbol_43 = A_symbol_51;
			} catch (InvalidValueException e) {
				rightA_symbol_43 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_51 = rightA_symbol_43;
			DomainType static_A_symbol_43 = valueFactory.typeOf(A_symbol_45);
			LibraryBinaryOperation dynamic_A_symbol_43 = (LibraryBinaryOperation)static_A_symbol_43.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_43 = dynamic_A_symbol_43.evaluate(evaluator, T_Boolean, A_symbol_45, A_symbol_51);
			return A_symbol_43;
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
			final @NonNull Value T_ClassClassifier_pivot__CollectionType_ = valueFactory.createTypeValue(PivotTables.Types._CollectionType);
			final @NonNull ExecutorType T_pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final @NonNull ExecutorProperty P_CallExp_source = PivotTables.Properties._CallExp__source;
			final @NonNull LibraryProperty IP_CallExp_source = P_CallExp_source.getImplementation();
			
			Value leftA_symbol_52;
			try {
				
				Value A_symbol_53 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_54 = valueFactory.typeOf(A_symbol_53, S_closure);
				LibraryBinaryOperation dynamic_A_symbol_54 = (LibraryBinaryOperation)static_A_symbol_54.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_54 = dynamic_A_symbol_54.evaluate(evaluator, T_Boolean, A_symbol_53, S_closure);
				leftA_symbol_52 = A_symbol_54;
			} catch (InvalidValueException e) {
				leftA_symbol_52 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_54 = leftA_symbol_52;
			Value rightA_symbol_52;
			try {
				
				Value A_symbol_55 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_56 = valueFactory.typeOf(A_symbol_55);
				LibraryBinaryOperation dynamic_A_symbol_56 = (LibraryBinaryOperation)static_A_symbol_56.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_56 = dynamic_A_symbol_56.evaluate(evaluator, T_pivot__CollectionType, A_symbol_55, T_ClassClassifier_pivot__CollectionType_);
				Value A_symbol_57 = IP_CollectionType_elementType.evaluate(evaluator, T_Type, A_symbol_56, P_CollectionType_elementType);
				
				
				Value A_symbol_58 = IP_CallExp_source.evaluate(evaluator, T_pivot__OCLExpression, self, P_CallExp_source);
				
				Value A_symbol_59 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_58, P_TypedElement_type);
				
				DomainType static_A_symbol_60 = valueFactory.typeOf(A_symbol_59);
				LibraryBinaryOperation dynamic_A_symbol_60 = (LibraryBinaryOperation)static_A_symbol_60.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_60 = dynamic_A_symbol_60.evaluate(evaluator, T_pivot__CollectionType, A_symbol_59, T_ClassClassifier_pivot__CollectionType_);
				Value A_symbol_61 = IP_CollectionType_elementType.evaluate(evaluator, T_Type, A_symbol_60, P_CollectionType_elementType);
				
				DomainType static_A_symbol_62 = valueFactory.typeOf(A_symbol_57, A_symbol_61);
				LibraryBinaryOperation dynamic_A_symbol_62 = (LibraryBinaryOperation)static_A_symbol_62.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_62 = dynamic_A_symbol_62.evaluate(evaluator, T_Boolean, A_symbol_57, A_symbol_61);
				rightA_symbol_52 = A_symbol_62;
			} catch (InvalidValueException e) {
				rightA_symbol_52 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_62 = rightA_symbol_52;
			DomainType static_A_symbol_52 = valueFactory.typeOf(A_symbol_54);
			LibraryBinaryOperation dynamic_A_symbol_52 = (LibraryBinaryOperation)static_A_symbol_52.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_52 = dynamic_A_symbol_52.evaluate(evaluator, T_Boolean, A_symbol_54, A_symbol_62);
			return A_symbol_52;
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
			
			Value leftA_symbol_63;
			try {
				
				Value A_symbol_64 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_65 = valueFactory.typeOf(A_symbol_64, S_closure);
				LibraryBinaryOperation dynamic_A_symbol_65 = (LibraryBinaryOperation)static_A_symbol_65.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_65 = dynamic_A_symbol_65.evaluate(evaluator, T_Boolean, A_symbol_64, S_closure);
				leftA_symbol_63 = A_symbol_65;
			} catch (InvalidValueException e) {
				leftA_symbol_63 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_65 = leftA_symbol_63;
			Value rightA_symbol_63;
			try {
				
				Value A_symbol_66 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_67 = valueFactory.typeOf(A_symbol_66);
				LibraryUnaryOperation dynamic_A_symbol_67 = (LibraryUnaryOperation)static_A_symbol_67.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_67 = dynamic_A_symbol_67.evaluate(evaluator, T_Integer, A_symbol_66);
				DomainType static_A_symbol_68 = valueFactory.typeOf(A_symbol_67, I_1);
				LibraryBinaryOperation dynamic_A_symbol_68 = (LibraryBinaryOperation)static_A_symbol_68.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_68 = dynamic_A_symbol_68.evaluate(evaluator, T_Boolean, A_symbol_67, I_1);
				rightA_symbol_63 = A_symbol_68;
			} catch (InvalidValueException e) {
				rightA_symbol_63 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_68 = rightA_symbol_63;
			DomainType static_A_symbol_63 = valueFactory.typeOf(A_symbol_65);
			LibraryBinaryOperation dynamic_A_symbol_63 = (LibraryBinaryOperation)static_A_symbol_63.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_63 = dynamic_A_symbol_63.evaluate(evaluator, T_Boolean, A_symbol_65, A_symbol_68);
			return A_symbol_63;
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
			final @NonNull Value T_ClassClassifier_pivot__CollectionType_ = valueFactory.createTypeValue(PivotTables.Types._CollectionType);
			final @NonNull ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
			final @NonNull ExecutorProperty P_LoopExp_body = PivotTables.Properties._LoopExp__body;
			final @NonNull LibraryProperty IP_LoopExp_body = P_LoopExp_body.getImplementation();
			
			Value leftA_symbol_69;
			try {
				
				Value A_symbol_70 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_71 = valueFactory.typeOf(A_symbol_70, S_closure);
				LibraryBinaryOperation dynamic_A_symbol_71 = (LibraryBinaryOperation)static_A_symbol_71.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_71 = dynamic_A_symbol_71.evaluate(evaluator, T_Boolean, A_symbol_70, S_closure);
				leftA_symbol_69 = A_symbol_71;
			} catch (InvalidValueException e) {
				leftA_symbol_69 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_71 = leftA_symbol_69;
			Value rightA_symbol_69;
			try {
				
				Value A_symbol_72 = IP_CallExp_source.evaluate(evaluator, T_pivot__OCLExpression, self, P_CallExp_source);
				
				Value A_symbol_73 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_72, P_TypedElement_type);
				
				DomainType static_A_symbol_74 = valueFactory.typeOf(A_symbol_73);
				LibraryBinaryOperation dynamic_A_symbol_74 = (LibraryBinaryOperation)static_A_symbol_74.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_74 = dynamic_A_symbol_74.evaluate(evaluator, T_pivot__CollectionType, A_symbol_73, T_ClassClassifier_pivot__CollectionType_);
				Value A_symbol_75 = IP_CollectionType_elementType.evaluate(evaluator, T_Type, A_symbol_74, P_CollectionType_elementType);
				
					
					Value A_symbol_76 = IP_LoopExp_body.evaluate(evaluator, T_pivot__OCLExpression, self, P_LoopExp_body);
					
					Value A_symbol_77 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_76, P_TypedElement_type);
					
					DomainType static_A_symbol_78 = valueFactory.typeOf(A_symbol_77);
					LibraryBinaryOperation dynamic_A_symbol_78 = (LibraryBinaryOperation)static_A_symbol_78.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Value A_symbol_78 = dynamic_A_symbol_78.evaluate(evaluator, T_Boolean, A_symbol_77, T_ClassClassifier_pivot__CollectionType_);
				Value A_symbol_79;
				if (A_symbol_78.isTrue()) {
					
					Value A_symbol_80 = IP_LoopExp_body.evaluate(evaluator, T_pivot__OCLExpression, self, P_LoopExp_body);
					
					Value A_symbol_81 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_80, P_TypedElement_type);
					
					DomainType static_A_symbol_82 = valueFactory.typeOf(A_symbol_81);
					LibraryBinaryOperation dynamic_A_symbol_82 = (LibraryBinaryOperation)static_A_symbol_82.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
					Value A_symbol_82 = dynamic_A_symbol_82.evaluate(evaluator, T_pivot__CollectionType, A_symbol_81, T_ClassClassifier_pivot__CollectionType_);
					Value A_symbol_83 = IP_CollectionType_elementType.evaluate(evaluator, T_Type, A_symbol_82, P_CollectionType_elementType);
					
					A_symbol_79 = A_symbol_83;
				}
				else if (A_symbol_78.isFalse()) {
					
					Value A_symbol_84 = IP_LoopExp_body.evaluate(evaluator, T_pivot__OCLExpression, self, P_LoopExp_body);
					
					Value A_symbol_85 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_84, P_TypedElement_type);
					
					A_symbol_79 = A_symbol_85;
				}
				else if (A_symbol_78.isNull()) {
					A_symbol_79 = valueFactory.throwInvalidValueException("null if condition");
				}
				else {
					A_symbol_79 = valueFactory.throwInvalidValueException("invalid if condition");
				}
				DomainType static_A_symbol_86 = valueFactory.typeOf(A_symbol_75, A_symbol_79);
				LibraryBinaryOperation dynamic_A_symbol_86 = (LibraryBinaryOperation)static_A_symbol_86.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_86 = dynamic_A_symbol_86.evaluate(evaluator, T_Boolean, A_symbol_75, A_symbol_79);
				rightA_symbol_69 = A_symbol_86;
			} catch (InvalidValueException e) {
				rightA_symbol_69 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_86 = rightA_symbol_69;
			DomainType static_A_symbol_69 = valueFactory.typeOf(A_symbol_71);
			LibraryBinaryOperation dynamic_A_symbol_69 = (LibraryBinaryOperation)static_A_symbol_69.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_69 = dynamic_A_symbol_69.evaluate(evaluator, T_Boolean, A_symbol_71, A_symbol_86);
			return A_symbol_69;
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
			final @NonNull Value T_ClassClassifier_pivot__SequenceType_ = valueFactory.createTypeValue(PivotTables.Types._SequenceType);
			final @NonNull Value T_ClassClassifier_pivot__OrderedSetType_ = valueFactory.createTypeValue(PivotTables.Types._OrderedSetType);
			final @NonNull Value T_ClassClassifier_pivot__SetType_ = valueFactory.createTypeValue(PivotTables.Types._SetType);
			
			Value leftA_symbol_87;
			try {
				
				Value A_symbol_88 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_89 = valueFactory.typeOf(A_symbol_88, S_closure);
				LibraryBinaryOperation dynamic_A_symbol_89 = (LibraryBinaryOperation)static_A_symbol_89.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_89 = dynamic_A_symbol_89.evaluate(evaluator, T_Boolean, A_symbol_88, S_closure);
				leftA_symbol_87 = A_symbol_89;
			} catch (InvalidValueException e) {
				leftA_symbol_87 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_89 = leftA_symbol_87;
			Value rightA_symbol_87;
			try {
					Value leftA_symbol_90;
					try {
						
						Value A_symbol_91 = IP_CallExp_source.evaluate(evaluator, T_pivot__OCLExpression, self, P_CallExp_source);
						
						Value A_symbol_92 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_91, P_TypedElement_type);
						
						DomainType static_A_symbol_93 = valueFactory.typeOf(A_symbol_92);
						LibraryBinaryOperation dynamic_A_symbol_93 = (LibraryBinaryOperation)static_A_symbol_93.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Value A_symbol_93 = dynamic_A_symbol_93.evaluate(evaluator, T_Boolean, A_symbol_92, T_ClassClassifier_pivot__SequenceType_);
						leftA_symbol_90 = A_symbol_93;
					} catch (InvalidValueException e) {
						leftA_symbol_90 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_93 = leftA_symbol_90;
					Value rightA_symbol_90;
					try {
						
						Value A_symbol_94 = IP_CallExp_source.evaluate(evaluator, T_pivot__OCLExpression, self, P_CallExp_source);
						
						Value A_symbol_95 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_94, P_TypedElement_type);
						
						DomainType static_A_symbol_96 = valueFactory.typeOf(A_symbol_95);
						LibraryBinaryOperation dynamic_A_symbol_96 = (LibraryBinaryOperation)static_A_symbol_96.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Value A_symbol_96 = dynamic_A_symbol_96.evaluate(evaluator, T_Boolean, A_symbol_95, T_ClassClassifier_pivot__OrderedSetType_);
						rightA_symbol_90 = A_symbol_96;
					} catch (InvalidValueException e) {
						rightA_symbol_90 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_96 = rightA_symbol_90;
					DomainType static_A_symbol_90 = valueFactory.typeOf(A_symbol_93);
					LibraryBinaryOperation dynamic_A_symbol_90 = (LibraryBinaryOperation)static_A_symbol_90.lookupImplementation(standardLibrary, O_Boolean_or);
					Value A_symbol_90 = dynamic_A_symbol_90.evaluate(evaluator, T_Boolean, A_symbol_93, A_symbol_96);
				Value A_symbol_97;
				if (A_symbol_90.isTrue()) {
					
					Value A_symbol_98 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
					
					DomainType static_A_symbol_99 = valueFactory.typeOf(A_symbol_98);
					LibraryBinaryOperation dynamic_A_symbol_99 = (LibraryBinaryOperation)static_A_symbol_99.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Value A_symbol_99 = dynamic_A_symbol_99.evaluate(evaluator, T_Boolean, A_symbol_98, T_ClassClassifier_pivot__OrderedSetType_);
					A_symbol_97 = A_symbol_99;
				}
				else if (A_symbol_90.isFalse()) {
					
					Value A_symbol_100 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
					
					DomainType static_A_symbol_101 = valueFactory.typeOf(A_symbol_100);
					LibraryBinaryOperation dynamic_A_symbol_101 = (LibraryBinaryOperation)static_A_symbol_101.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Value A_symbol_101 = dynamic_A_symbol_101.evaluate(evaluator, T_Boolean, A_symbol_100, T_ClassClassifier_pivot__SetType_);
					A_symbol_97 = A_symbol_101;
				}
				else if (A_symbol_90.isNull()) {
					A_symbol_97 = valueFactory.throwInvalidValueException("null if condition");
				}
				else {
					A_symbol_97 = valueFactory.throwInvalidValueException("invalid if condition");
				}
				rightA_symbol_87 = A_symbol_97;
			} catch (InvalidValueException e) {
				rightA_symbol_87 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_97 = rightA_symbol_87;
			DomainType static_A_symbol_87 = valueFactory.typeOf(A_symbol_89);
			LibraryBinaryOperation dynamic_A_symbol_87 = (LibraryBinaryOperation)static_A_symbol_87.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_87 = dynamic_A_symbol_87.evaluate(evaluator, T_Boolean, A_symbol_89, A_symbol_97);
			return A_symbol_87;
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
			final @NonNull Value T_ClassClassifier_pivot__CollectionType_ = valueFactory.createTypeValue(PivotTables.Types._CollectionType);
			final @NonNull ExecutorType T_pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final @NonNull ExecutorProperty P_LoopExp_body = PivotTables.Properties._LoopExp__body;
			final @NonNull LibraryProperty IP_LoopExp_body = P_LoopExp_body.getImplementation();
			
			Value leftA_symbol_102;
			try {
				
				Value A_symbol_103 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_104 = valueFactory.typeOf(A_symbol_103, S_collect);
				LibraryBinaryOperation dynamic_A_symbol_104 = (LibraryBinaryOperation)static_A_symbol_104.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_104 = dynamic_A_symbol_104.evaluate(evaluator, T_Boolean, A_symbol_103, S_collect);
				leftA_symbol_102 = A_symbol_104;
			} catch (InvalidValueException e) {
				leftA_symbol_102 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_104 = leftA_symbol_102;
			Value rightA_symbol_102;
			try {
				
				Value A_symbol_105 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_106 = valueFactory.typeOf(A_symbol_105);
				LibraryBinaryOperation dynamic_A_symbol_106 = (LibraryBinaryOperation)static_A_symbol_106.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_106 = dynamic_A_symbol_106.evaluate(evaluator, T_pivot__CollectionType, A_symbol_105, T_ClassClassifier_pivot__CollectionType_);
				Value A_symbol_107 = IP_CollectionType_elementType.evaluate(evaluator, T_Type, A_symbol_106, P_CollectionType_elementType);
				
				
				Value A_symbol_108 = IP_LoopExp_body.evaluate(evaluator, T_pivot__OCLExpression, self, P_LoopExp_body);
				
				Value A_symbol_109 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_108, P_TypedElement_type);
				
				DomainType static_A_symbol_110 = valueFactory.typeOf(A_symbol_109);
				LibraryBinaryOperation dynamic_A_symbol_110 = (LibraryBinaryOperation)static_A_symbol_110.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_110 = dynamic_A_symbol_110.evaluate(evaluator, T_pivot__CollectionType, A_symbol_109, T_ClassClassifier_pivot__CollectionType_);
				Value A_symbol_111 = IP_CollectionType_elementType.evaluate(evaluator, T_Type, A_symbol_110, P_CollectionType_elementType);
				
				DomainType static_A_symbol_112 = valueFactory.typeOf(A_symbol_107, A_symbol_111);
				LibraryBinaryOperation dynamic_A_symbol_112 = (LibraryBinaryOperation)static_A_symbol_112.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_112 = dynamic_A_symbol_112.evaluate(evaluator, T_Boolean, A_symbol_107, A_symbol_111);
				rightA_symbol_102 = A_symbol_112;
			} catch (InvalidValueException e) {
				rightA_symbol_102 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_112 = rightA_symbol_102;
			DomainType static_A_symbol_102 = valueFactory.typeOf(A_symbol_104);
			LibraryBinaryOperation dynamic_A_symbol_102 = (LibraryBinaryOperation)static_A_symbol_102.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_102 = dynamic_A_symbol_102.evaluate(evaluator, T_Boolean, A_symbol_104, A_symbol_112);
			return A_symbol_102;
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
			
			Value leftA_symbol_113;
			try {
				
				Value A_symbol_114 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_115 = valueFactory.typeOf(A_symbol_114, S_collect);
				LibraryBinaryOperation dynamic_A_symbol_115 = (LibraryBinaryOperation)static_A_symbol_115.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_115 = dynamic_A_symbol_115.evaluate(evaluator, T_Boolean, A_symbol_114, S_collect);
				leftA_symbol_113 = A_symbol_115;
			} catch (InvalidValueException e) {
				leftA_symbol_113 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_115 = leftA_symbol_113;
			Value rightA_symbol_113;
			try {
				
				Value A_symbol_116 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_117 = valueFactory.typeOf(A_symbol_116);
				LibraryUnaryOperation dynamic_A_symbol_117 = (LibraryUnaryOperation)static_A_symbol_117.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_117 = dynamic_A_symbol_117.evaluate(evaluator, T_Integer, A_symbol_116);
				DomainType static_A_symbol_118 = valueFactory.typeOf(A_symbol_117, I_1);
				LibraryBinaryOperation dynamic_A_symbol_118 = (LibraryBinaryOperation)static_A_symbol_118.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_118 = dynamic_A_symbol_118.evaluate(evaluator, T_Boolean, A_symbol_117, I_1);
				rightA_symbol_113 = A_symbol_118;
			} catch (InvalidValueException e) {
				rightA_symbol_113 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_118 = rightA_symbol_113;
			DomainType static_A_symbol_113 = valueFactory.typeOf(A_symbol_115);
			LibraryBinaryOperation dynamic_A_symbol_113 = (LibraryBinaryOperation)static_A_symbol_113.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_113 = dynamic_A_symbol_113.evaluate(evaluator, T_Boolean, A_symbol_115, A_symbol_118);
			return A_symbol_113;
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
			
			Value leftA_symbol_119;
			try {
				
				Value A_symbol_120 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_121 = valueFactory.typeOf(A_symbol_120, S_collectN___);
				LibraryBinaryOperation dynamic_A_symbol_121 = (LibraryBinaryOperation)static_A_symbol_121.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_121 = dynamic_A_symbol_121.evaluate(evaluator, T_Boolean, A_symbol_120, S_collectN___);
				leftA_symbol_119 = A_symbol_121;
			} catch (InvalidValueException e) {
				leftA_symbol_119 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_121 = leftA_symbol_119;
			Value rightA_symbol_119;
			try {
				
				Value A_symbol_122 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_123 = valueFactory.typeOf(A_symbol_122);
				LibraryUnaryOperation dynamic_A_symbol_123 = (LibraryUnaryOperation)static_A_symbol_123.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_123 = dynamic_A_symbol_123.evaluate(evaluator, T_Integer, A_symbol_122);
				DomainType static_A_symbol_124 = valueFactory.typeOf(A_symbol_123, I_1);
				LibraryBinaryOperation dynamic_A_symbol_124 = (LibraryBinaryOperation)static_A_symbol_124.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_124 = dynamic_A_symbol_124.evaluate(evaluator, T_Boolean, A_symbol_123, I_1);
				rightA_symbol_119 = A_symbol_124;
			} catch (InvalidValueException e) {
				rightA_symbol_119 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_124 = rightA_symbol_119;
			DomainType static_A_symbol_119 = valueFactory.typeOf(A_symbol_121);
			LibraryBinaryOperation dynamic_A_symbol_119 = (LibraryBinaryOperation)static_A_symbol_119.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_119 = dynamic_A_symbol_119.evaluate(evaluator, T_Boolean, A_symbol_121, A_symbol_124);
			return A_symbol_119;
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
			final @NonNull Value T_ClassClassifier_pivot__BagType_ = valueFactory.createTypeValue(PivotTables.Types._BagType);
			
			Value leftA_symbol_125;
			try {
				
				Value A_symbol_126 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_127 = valueFactory.typeOf(A_symbol_126, S_collectN___);
				LibraryBinaryOperation dynamic_A_symbol_127 = (LibraryBinaryOperation)static_A_symbol_127.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_127 = dynamic_A_symbol_127.evaluate(evaluator, T_Boolean, A_symbol_126, S_collectN___);
				leftA_symbol_125 = A_symbol_127;
			} catch (InvalidValueException e) {
				leftA_symbol_125 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_127 = leftA_symbol_125;
			Value rightA_symbol_125;
			try {
				
				Value A_symbol_128 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_129 = valueFactory.typeOf(A_symbol_128);
				LibraryBinaryOperation dynamic_A_symbol_129 = (LibraryBinaryOperation)static_A_symbol_129.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
				Value A_symbol_129 = dynamic_A_symbol_129.evaluate(evaluator, T_Boolean, A_symbol_128, T_ClassClassifier_pivot__BagType_);
				rightA_symbol_125 = A_symbol_129;
			} catch (InvalidValueException e) {
				rightA_symbol_125 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_129 = rightA_symbol_125;
			DomainType static_A_symbol_125 = valueFactory.typeOf(A_symbol_127);
			LibraryBinaryOperation dynamic_A_symbol_125 = (LibraryBinaryOperation)static_A_symbol_125.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_125 = dynamic_A_symbol_125.evaluate(evaluator, T_Boolean, A_symbol_127, A_symbol_129);
			return A_symbol_125;
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
			
			Value leftA_symbol_130;
			try {
				
				Value A_symbol_131 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_132 = valueFactory.typeOf(A_symbol_131, S_collectN___);
				LibraryBinaryOperation dynamic_A_symbol_132 = (LibraryBinaryOperation)static_A_symbol_132.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_132 = dynamic_A_symbol_132.evaluate(evaluator, T_Boolean, A_symbol_131, S_collectN___);
				leftA_symbol_130 = A_symbol_132;
			} catch (InvalidValueException e) {
				leftA_symbol_130 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_132 = leftA_symbol_130;
			Value rightA_symbol_130;
			try {
				
				Value A_symbol_133 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				
				Value A_symbol_134 = IP_LoopExp_body.evaluate(evaluator, T_pivot__OCLExpression, self, P_LoopExp_body);
				
				Value A_symbol_135 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_134, P_TypedElement_type);
				
				DomainType static_A_symbol_136 = valueFactory.typeOf(A_symbol_133, A_symbol_135);
				LibraryBinaryOperation dynamic_A_symbol_136 = (LibraryBinaryOperation)static_A_symbol_136.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_136 = dynamic_A_symbol_136.evaluate(evaluator, T_Boolean, A_symbol_133, A_symbol_135);
				rightA_symbol_130 = A_symbol_136;
			} catch (InvalidValueException e) {
				rightA_symbol_130 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_136 = rightA_symbol_130;
			DomainType static_A_symbol_130 = valueFactory.typeOf(A_symbol_132);
			LibraryBinaryOperation dynamic_A_symbol_130 = (LibraryBinaryOperation)static_A_symbol_130.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_130 = dynamic_A_symbol_130.evaluate(evaluator, T_Boolean, A_symbol_132, A_symbol_136);
			return A_symbol_130;
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
			final @NonNull Value T_ClassClassifier_pivot__SequenceType_ = valueFactory.createTypeValue(PivotTables.Types._SequenceType);
			final @NonNull Value T_ClassClassifier_pivot__OrderedSetType_ = valueFactory.createTypeValue(PivotTables.Types._OrderedSetType);
			final @NonNull Value T_ClassClassifier_pivot__BagType_ = valueFactory.createTypeValue(PivotTables.Types._BagType);
			
			Value leftA_symbol_137;
			try {
				
				Value A_symbol_138 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_139 = valueFactory.typeOf(A_symbol_138, S_collect);
				LibraryBinaryOperation dynamic_A_symbol_139 = (LibraryBinaryOperation)static_A_symbol_139.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_139 = dynamic_A_symbol_139.evaluate(evaluator, T_Boolean, A_symbol_138, S_collect);
				leftA_symbol_137 = A_symbol_139;
			} catch (InvalidValueException e) {
				leftA_symbol_137 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_139 = leftA_symbol_137;
			Value rightA_symbol_137;
			try {
					Value leftA_symbol_140;
					try {
						
						Value A_symbol_141 = IP_CallExp_source.evaluate(evaluator, T_pivot__OCLExpression, self, P_CallExp_source);
						
						Value A_symbol_142 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_141, P_TypedElement_type);
						
						DomainType static_A_symbol_143 = valueFactory.typeOf(A_symbol_142);
						LibraryBinaryOperation dynamic_A_symbol_143 = (LibraryBinaryOperation)static_A_symbol_143.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Value A_symbol_143 = dynamic_A_symbol_143.evaluate(evaluator, T_Boolean, A_symbol_142, T_ClassClassifier_pivot__SequenceType_);
						leftA_symbol_140 = A_symbol_143;
					} catch (InvalidValueException e) {
						leftA_symbol_140 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_143 = leftA_symbol_140;
					Value rightA_symbol_140;
					try {
						
						Value A_symbol_144 = IP_CallExp_source.evaluate(evaluator, T_pivot__OCLExpression, self, P_CallExp_source);
						
						Value A_symbol_145 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_144, P_TypedElement_type);
						
						DomainType static_A_symbol_146 = valueFactory.typeOf(A_symbol_145);
						LibraryBinaryOperation dynamic_A_symbol_146 = (LibraryBinaryOperation)static_A_symbol_146.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Value A_symbol_146 = dynamic_A_symbol_146.evaluate(evaluator, T_Boolean, A_symbol_145, T_ClassClassifier_pivot__OrderedSetType_);
						rightA_symbol_140 = A_symbol_146;
					} catch (InvalidValueException e) {
						rightA_symbol_140 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_146 = rightA_symbol_140;
					DomainType static_A_symbol_140 = valueFactory.typeOf(A_symbol_143);
					LibraryBinaryOperation dynamic_A_symbol_140 = (LibraryBinaryOperation)static_A_symbol_140.lookupImplementation(standardLibrary, O_Boolean_or);
					Value A_symbol_140 = dynamic_A_symbol_140.evaluate(evaluator, T_Boolean, A_symbol_143, A_symbol_146);
				Value A_symbol_147;
				if (A_symbol_140.isTrue()) {
					
					Value A_symbol_148 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
					
					DomainType static_A_symbol_149 = valueFactory.typeOf(A_symbol_148);
					LibraryBinaryOperation dynamic_A_symbol_149 = (LibraryBinaryOperation)static_A_symbol_149.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Value A_symbol_149 = dynamic_A_symbol_149.evaluate(evaluator, T_Boolean, A_symbol_148, T_ClassClassifier_pivot__SequenceType_);
					A_symbol_147 = A_symbol_149;
				}
				else if (A_symbol_140.isFalse()) {
					
					Value A_symbol_150 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
					
					DomainType static_A_symbol_151 = valueFactory.typeOf(A_symbol_150);
					LibraryBinaryOperation dynamic_A_symbol_151 = (LibraryBinaryOperation)static_A_symbol_151.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Value A_symbol_151 = dynamic_A_symbol_151.evaluate(evaluator, T_Boolean, A_symbol_150, T_ClassClassifier_pivot__BagType_);
					A_symbol_147 = A_symbol_151;
				}
				else if (A_symbol_140.isNull()) {
					A_symbol_147 = valueFactory.throwInvalidValueException("null if condition");
				}
				else {
					A_symbol_147 = valueFactory.throwInvalidValueException("invalid if condition");
				}
				rightA_symbol_137 = A_symbol_147;
			} catch (InvalidValueException e) {
				rightA_symbol_137 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_147 = rightA_symbol_137;
			DomainType static_A_symbol_137 = valueFactory.typeOf(A_symbol_139);
			LibraryBinaryOperation dynamic_A_symbol_137 = (LibraryBinaryOperation)static_A_symbol_137.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_137 = dynamic_A_symbol_137.evaluate(evaluator, T_Boolean, A_symbol_139, A_symbol_147);
			return A_symbol_137;
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
			final @NonNull Value T_ClassClassifier_Boolean_ = valueFactory.createTypeValue(OCLstdlibTables.Types._Boolean);
			
			Value leftA_symbol_152;
			try {
				
				Value A_symbol_153 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_154 = valueFactory.typeOf(A_symbol_153, S_exists);
				LibraryBinaryOperation dynamic_A_symbol_154 = (LibraryBinaryOperation)static_A_symbol_154.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_154 = dynamic_A_symbol_154.evaluate(evaluator, T_Boolean, A_symbol_153, S_exists);
				leftA_symbol_152 = A_symbol_154;
			} catch (InvalidValueException e) {
				leftA_symbol_152 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_154 = leftA_symbol_152;
			Value rightA_symbol_152;
			try {
				
				Value A_symbol_155 = IP_LoopExp_body.evaluate(evaluator, T_pivot__OCLExpression, self, P_LoopExp_body);
				
				Value A_symbol_156 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_155, P_TypedElement_type);
				
				DomainType static_A_symbol_157 = valueFactory.typeOf(A_symbol_156, T_ClassClassifier_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_157 = (LibraryBinaryOperation)static_A_symbol_157.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_157 = dynamic_A_symbol_157.evaluate(evaluator, T_Boolean, A_symbol_156, T_ClassClassifier_Boolean_);
				rightA_symbol_152 = A_symbol_157;
			} catch (InvalidValueException e) {
				rightA_symbol_152 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_157 = rightA_symbol_152;
			DomainType static_A_symbol_152 = valueFactory.typeOf(A_symbol_154);
			LibraryBinaryOperation dynamic_A_symbol_152 = (LibraryBinaryOperation)static_A_symbol_152.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_152 = dynamic_A_symbol_152.evaluate(evaluator, T_Boolean, A_symbol_154, A_symbol_157);
			return A_symbol_152;
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
			final @NonNull Value T_ClassClassifier_Boolean_ = valueFactory.createTypeValue(OCLstdlibTables.Types._Boolean);
			
			Value leftA_symbol_158;
			try {
				
				Value A_symbol_159 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_160 = valueFactory.typeOf(A_symbol_159, S_exists);
				LibraryBinaryOperation dynamic_A_symbol_160 = (LibraryBinaryOperation)static_A_symbol_160.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_160 = dynamic_A_symbol_160.evaluate(evaluator, T_Boolean, A_symbol_159, S_exists);
				leftA_symbol_158 = A_symbol_160;
			} catch (InvalidValueException e) {
				leftA_symbol_158 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_160 = leftA_symbol_158;
			Value rightA_symbol_158;
			try {
				
				Value A_symbol_161 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_162 = valueFactory.typeOf(A_symbol_161, T_ClassClassifier_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_162 = (LibraryBinaryOperation)static_A_symbol_162.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_162 = dynamic_A_symbol_162.evaluate(evaluator, T_Boolean, A_symbol_161, T_ClassClassifier_Boolean_);
				rightA_symbol_158 = A_symbol_162;
			} catch (InvalidValueException e) {
				rightA_symbol_158 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_162 = rightA_symbol_158;
			DomainType static_A_symbol_158 = valueFactory.typeOf(A_symbol_160);
			LibraryBinaryOperation dynamic_A_symbol_158 = (LibraryBinaryOperation)static_A_symbol_158.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_158 = dynamic_A_symbol_158.evaluate(evaluator, T_Boolean, A_symbol_160, A_symbol_162);
			return A_symbol_158;
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
			final @NonNull Value T_ClassClassifier_Boolean_ = valueFactory.createTypeValue(OCLstdlibTables.Types._Boolean);
			
			Value leftA_symbol_163;
			try {
				
				Value A_symbol_164 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_165 = valueFactory.typeOf(A_symbol_164, S_forAll);
				LibraryBinaryOperation dynamic_A_symbol_165 = (LibraryBinaryOperation)static_A_symbol_165.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_165 = dynamic_A_symbol_165.evaluate(evaluator, T_Boolean, A_symbol_164, S_forAll);
				leftA_symbol_163 = A_symbol_165;
			} catch (InvalidValueException e) {
				leftA_symbol_163 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_165 = leftA_symbol_163;
			Value rightA_symbol_163;
			try {
				
				Value A_symbol_166 = IP_LoopExp_body.evaluate(evaluator, T_pivot__OCLExpression, self, P_LoopExp_body);
				
				Value A_symbol_167 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_166, P_TypedElement_type);
				
				DomainType static_A_symbol_168 = valueFactory.typeOf(A_symbol_167, T_ClassClassifier_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_168 = (LibraryBinaryOperation)static_A_symbol_168.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_168 = dynamic_A_symbol_168.evaluate(evaluator, T_Boolean, A_symbol_167, T_ClassClassifier_Boolean_);
				rightA_symbol_163 = A_symbol_168;
			} catch (InvalidValueException e) {
				rightA_symbol_163 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_168 = rightA_symbol_163;
			DomainType static_A_symbol_163 = valueFactory.typeOf(A_symbol_165);
			LibraryBinaryOperation dynamic_A_symbol_163 = (LibraryBinaryOperation)static_A_symbol_163.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_163 = dynamic_A_symbol_163.evaluate(evaluator, T_Boolean, A_symbol_165, A_symbol_168);
			return A_symbol_163;
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
			final @NonNull Value T_ClassClassifier_Boolean_ = valueFactory.createTypeValue(OCLstdlibTables.Types._Boolean);
			
			Value leftA_symbol_169;
			try {
				
				Value A_symbol_170 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_171 = valueFactory.typeOf(A_symbol_170, S_forAll);
				LibraryBinaryOperation dynamic_A_symbol_171 = (LibraryBinaryOperation)static_A_symbol_171.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_171 = dynamic_A_symbol_171.evaluate(evaluator, T_Boolean, A_symbol_170, S_forAll);
				leftA_symbol_169 = A_symbol_171;
			} catch (InvalidValueException e) {
				leftA_symbol_169 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_171 = leftA_symbol_169;
			Value rightA_symbol_169;
			try {
				
				Value A_symbol_172 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_173 = valueFactory.typeOf(A_symbol_172, T_ClassClassifier_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_173 = (LibraryBinaryOperation)static_A_symbol_173.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_173 = dynamic_A_symbol_173.evaluate(evaluator, T_Boolean, A_symbol_172, T_ClassClassifier_Boolean_);
				rightA_symbol_169 = A_symbol_173;
			} catch (InvalidValueException e) {
				rightA_symbol_169 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_173 = rightA_symbol_169;
			DomainType static_A_symbol_169 = valueFactory.typeOf(A_symbol_171);
			LibraryBinaryOperation dynamic_A_symbol_169 = (LibraryBinaryOperation)static_A_symbol_169.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_169 = dynamic_A_symbol_169.evaluate(evaluator, T_Boolean, A_symbol_171, A_symbol_173);
			return A_symbol_169;
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
			
			Value leftA_symbol_174;
			try {
				
				Value A_symbol_175 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_176 = valueFactory.typeOf(A_symbol_175, S_isUnique);
				LibraryBinaryOperation dynamic_A_symbol_176 = (LibraryBinaryOperation)static_A_symbol_176.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_176 = dynamic_A_symbol_176.evaluate(evaluator, T_Boolean, A_symbol_175, S_isUnique);
				leftA_symbol_174 = A_symbol_176;
			} catch (InvalidValueException e) {
				leftA_symbol_174 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_176 = leftA_symbol_174;
			Value rightA_symbol_174;
			try {
				
				Value A_symbol_177 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_178 = valueFactory.typeOf(A_symbol_177);
				LibraryUnaryOperation dynamic_A_symbol_178 = (LibraryUnaryOperation)static_A_symbol_178.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_178 = dynamic_A_symbol_178.evaluate(evaluator, T_Integer, A_symbol_177);
				DomainType static_A_symbol_179 = valueFactory.typeOf(A_symbol_178, I_1);
				LibraryBinaryOperation dynamic_A_symbol_179 = (LibraryBinaryOperation)static_A_symbol_179.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_179 = dynamic_A_symbol_179.evaluate(evaluator, T_Boolean, A_symbol_178, I_1);
				rightA_symbol_174 = A_symbol_179;
			} catch (InvalidValueException e) {
				rightA_symbol_174 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_179 = rightA_symbol_174;
			DomainType static_A_symbol_174 = valueFactory.typeOf(A_symbol_176);
			LibraryBinaryOperation dynamic_A_symbol_174 = (LibraryBinaryOperation)static_A_symbol_174.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_174 = dynamic_A_symbol_174.evaluate(evaluator, T_Boolean, A_symbol_176, A_symbol_179);
			return A_symbol_174;
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
			final @NonNull Value T_ClassClassifier_Boolean_ = valueFactory.createTypeValue(OCLstdlibTables.Types._Boolean);
			
			Value leftA_symbol_180;
			try {
				
				Value A_symbol_181 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_182 = valueFactory.typeOf(A_symbol_181, S_isUnique);
				LibraryBinaryOperation dynamic_A_symbol_182 = (LibraryBinaryOperation)static_A_symbol_182.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_182 = dynamic_A_symbol_182.evaluate(evaluator, T_Boolean, A_symbol_181, S_isUnique);
				leftA_symbol_180 = A_symbol_182;
			} catch (InvalidValueException e) {
				leftA_symbol_180 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_182 = leftA_symbol_180;
			Value rightA_symbol_180;
			try {
				
				Value A_symbol_183 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_184 = valueFactory.typeOf(A_symbol_183, T_ClassClassifier_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_184 = (LibraryBinaryOperation)static_A_symbol_184.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_184 = dynamic_A_symbol_184.evaluate(evaluator, T_Boolean, A_symbol_183, T_ClassClassifier_Boolean_);
				rightA_symbol_180 = A_symbol_184;
			} catch (InvalidValueException e) {
				rightA_symbol_180 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_184 = rightA_symbol_180;
			DomainType static_A_symbol_180 = valueFactory.typeOf(A_symbol_182);
			LibraryBinaryOperation dynamic_A_symbol_180 = (LibraryBinaryOperation)static_A_symbol_180.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_180 = dynamic_A_symbol_180.evaluate(evaluator, T_Boolean, A_symbol_182, A_symbol_184);
			return A_symbol_180;
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
			final @NonNull Value T_ClassClassifier_pivot__CollectionType_ = valueFactory.createTypeValue(PivotTables.Types._CollectionType);
			
			
			Value A_symbol_185 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_pivot__Variable_, self, P_LoopExp_iterator);
			
			
			/** 
			 * Implementation of the iterator body.
			 */
			AbstractBinaryOperation body_A_symbol_186 = new AbstractBinaryOperation()
			{
			/*
			type = source.type.oclAsType(CollectionType).elementType
			*/
				public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, @NonNull Value sourceValue, @NonNull Value iterator1) throws InvalidValueException {
					final @NonNull Value V_1_ = iterator1;	// iterator: 1_
					
					Value A_symbol_187 = IP_TypedElement_type.evaluate(evaluator, T_Type, V_1_, P_TypedElement_type);
					
					
					Value A_symbol_188 = IP_CallExp_source.evaluate(evaluator, T_pivot__OCLExpression, self, P_CallExp_source);
					
					Value A_symbol_189 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_188, P_TypedElement_type);
					
					DomainType static_A_symbol_190 = valueFactory.typeOf(A_symbol_189);
					LibraryBinaryOperation dynamic_A_symbol_190 = (LibraryBinaryOperation)static_A_symbol_190.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
					Value A_symbol_190 = dynamic_A_symbol_190.evaluate(evaluator, T_pivot__CollectionType, A_symbol_189, T_ClassClassifier_pivot__CollectionType_);
					Value A_symbol_191 = IP_CollectionType_elementType.evaluate(evaluator, T_Type, A_symbol_190, P_CollectionType_elementType);
					
					DomainType static_A_symbol_192 = valueFactory.typeOf(A_symbol_187, A_symbol_191);
					LibraryBinaryOperation dynamic_A_symbol_192 = (LibraryBinaryOperation)static_A_symbol_192.lookupImplementation(standardLibrary, O_OclAny__eq_);
					Value A_symbol_192 = dynamic_A_symbol_192.evaluate(evaluator, T_Boolean, A_symbol_187, A_symbol_191);
					return A_symbol_192;
				}
			};
			DomainType static_A_symbol_186 = A_symbol_185.getType();
			LibraryIteration dynamic_A_symbol_186 = (LibraryIteration)static_A_symbol_186.lookupImplementation(standardLibrary, O_Collection_forAll);
			Value acc_A_symbol_186 = dynamic_A_symbol_186.createAccumulatorValue(evaluator, T_Boolean, T_Boolean);
			ExecutorSingleIterationManager manager_A_symbol_186 = new ExecutorSingleIterationManager(evaluator, T_Boolean, body_A_symbol_186, (CollectionValue)A_symbol_185, acc_A_symbol_186);
			Value A_symbol_186 = dynamic_A_symbol_186.evaluateIteration(manager_A_symbol_186);
			return A_symbol_186;
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
			final @NonNull Value T_ClassClassifier_Boolean_ = valueFactory.createTypeValue(OCLstdlibTables.Types._Boolean);
			
			Value leftA_symbol_193;
			try {
				
				Value A_symbol_194 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_195 = valueFactory.typeOf(A_symbol_194, S_one);
				LibraryBinaryOperation dynamic_A_symbol_195 = (LibraryBinaryOperation)static_A_symbol_195.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_195 = dynamic_A_symbol_195.evaluate(evaluator, T_Boolean, A_symbol_194, S_one);
				leftA_symbol_193 = A_symbol_195;
			} catch (InvalidValueException e) {
				leftA_symbol_193 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_195 = leftA_symbol_193;
			Value rightA_symbol_193;
			try {
				
				Value A_symbol_196 = IP_LoopExp_body.evaluate(evaluator, T_pivot__OCLExpression, self, P_LoopExp_body);
				
				Value A_symbol_197 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_196, P_TypedElement_type);
				
				DomainType static_A_symbol_198 = valueFactory.typeOf(A_symbol_197, T_ClassClassifier_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_198 = (LibraryBinaryOperation)static_A_symbol_198.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_198 = dynamic_A_symbol_198.evaluate(evaluator, T_Boolean, A_symbol_197, T_ClassClassifier_Boolean_);
				rightA_symbol_193 = A_symbol_198;
			} catch (InvalidValueException e) {
				rightA_symbol_193 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_198 = rightA_symbol_193;
			DomainType static_A_symbol_193 = valueFactory.typeOf(A_symbol_195);
			LibraryBinaryOperation dynamic_A_symbol_193 = (LibraryBinaryOperation)static_A_symbol_193.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_193 = dynamic_A_symbol_193.evaluate(evaluator, T_Boolean, A_symbol_195, A_symbol_198);
			return A_symbol_193;
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
			
			Value leftA_symbol_199;
			try {
				
				Value A_symbol_200 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_201 = valueFactory.typeOf(A_symbol_200, S_one);
				LibraryBinaryOperation dynamic_A_symbol_201 = (LibraryBinaryOperation)static_A_symbol_201.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_201 = dynamic_A_symbol_201.evaluate(evaluator, T_Boolean, A_symbol_200, S_one);
				leftA_symbol_199 = A_symbol_201;
			} catch (InvalidValueException e) {
				leftA_symbol_199 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_201 = leftA_symbol_199;
			Value rightA_symbol_199;
			try {
				
				Value A_symbol_202 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_203 = valueFactory.typeOf(A_symbol_202);
				LibraryUnaryOperation dynamic_A_symbol_203 = (LibraryUnaryOperation)static_A_symbol_203.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_203 = dynamic_A_symbol_203.evaluate(evaluator, T_Integer, A_symbol_202);
				DomainType static_A_symbol_204 = valueFactory.typeOf(A_symbol_203, I_1);
				LibraryBinaryOperation dynamic_A_symbol_204 = (LibraryBinaryOperation)static_A_symbol_204.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_204 = dynamic_A_symbol_204.evaluate(evaluator, T_Boolean, A_symbol_203, I_1);
				rightA_symbol_199 = A_symbol_204;
			} catch (InvalidValueException e) {
				rightA_symbol_199 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_204 = rightA_symbol_199;
			DomainType static_A_symbol_199 = valueFactory.typeOf(A_symbol_201);
			LibraryBinaryOperation dynamic_A_symbol_199 = (LibraryBinaryOperation)static_A_symbol_199.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_199 = dynamic_A_symbol_199.evaluate(evaluator, T_Boolean, A_symbol_201, A_symbol_204);
			return A_symbol_199;
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
			final @NonNull Value T_ClassClassifier_Boolean_ = valueFactory.createTypeValue(OCLstdlibTables.Types._Boolean);
			
			Value leftA_symbol_205;
			try {
				
				Value A_symbol_206 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_207 = valueFactory.typeOf(A_symbol_206, S_one);
				LibraryBinaryOperation dynamic_A_symbol_207 = (LibraryBinaryOperation)static_A_symbol_207.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_207 = dynamic_A_symbol_207.evaluate(evaluator, T_Boolean, A_symbol_206, S_one);
				leftA_symbol_205 = A_symbol_207;
			} catch (InvalidValueException e) {
				leftA_symbol_205 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_207 = leftA_symbol_205;
			Value rightA_symbol_205;
			try {
				
				Value A_symbol_208 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_209 = valueFactory.typeOf(A_symbol_208, T_ClassClassifier_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_209 = (LibraryBinaryOperation)static_A_symbol_209.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_209 = dynamic_A_symbol_209.evaluate(evaluator, T_Boolean, A_symbol_208, T_ClassClassifier_Boolean_);
				rightA_symbol_205 = A_symbol_209;
			} catch (InvalidValueException e) {
				rightA_symbol_205 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_209 = rightA_symbol_205;
			DomainType static_A_symbol_205 = valueFactory.typeOf(A_symbol_207);
			LibraryBinaryOperation dynamic_A_symbol_205 = (LibraryBinaryOperation)static_A_symbol_205.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_205 = dynamic_A_symbol_205.evaluate(evaluator, T_Boolean, A_symbol_207, A_symbol_209);
			return A_symbol_205;
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
			
			Value leftA_symbol_210;
			try {
				Value leftA_symbol_211;
				try {
					
					Value A_symbol_212 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
					
					DomainType static_A_symbol_213 = valueFactory.typeOf(A_symbol_212, S_reject);
					LibraryBinaryOperation dynamic_A_symbol_213 = (LibraryBinaryOperation)static_A_symbol_213.lookupImplementation(standardLibrary, O_String__eq_);
					Value A_symbol_213 = dynamic_A_symbol_213.evaluate(evaluator, T_Boolean, A_symbol_212, S_reject);
					leftA_symbol_211 = A_symbol_213;
				} catch (InvalidValueException e) {
					leftA_symbol_211 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_213 = leftA_symbol_211;
				Value rightA_symbol_211;
				try {
					
					Value A_symbol_214 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
					
					DomainType static_A_symbol_215 = valueFactory.typeOf(A_symbol_214, S_select);
					LibraryBinaryOperation dynamic_A_symbol_215 = (LibraryBinaryOperation)static_A_symbol_215.lookupImplementation(standardLibrary, O_String__eq_);
					Value A_symbol_215 = dynamic_A_symbol_215.evaluate(evaluator, T_Boolean, A_symbol_214, S_select);
					rightA_symbol_211 = A_symbol_215;
				} catch (InvalidValueException e) {
					rightA_symbol_211 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_215 = rightA_symbol_211;
				DomainType static_A_symbol_211 = valueFactory.typeOf(A_symbol_213);
				LibraryBinaryOperation dynamic_A_symbol_211 = (LibraryBinaryOperation)static_A_symbol_211.lookupImplementation(standardLibrary, O_Boolean_or);
				Value A_symbol_211 = dynamic_A_symbol_211.evaluate(evaluator, T_Boolean, A_symbol_213, A_symbol_215);
				leftA_symbol_210 = A_symbol_211;
			} catch (InvalidValueException e) {
				leftA_symbol_210 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_211 = leftA_symbol_210;
			Value rightA_symbol_210;
			try {
				
				Value A_symbol_216 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_217 = valueFactory.typeOf(A_symbol_216);
				LibraryUnaryOperation dynamic_A_symbol_217 = (LibraryUnaryOperation)static_A_symbol_217.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_217 = dynamic_A_symbol_217.evaluate(evaluator, T_Integer, A_symbol_216);
				DomainType static_A_symbol_218 = valueFactory.typeOf(A_symbol_217, I_1);
				LibraryBinaryOperation dynamic_A_symbol_218 = (LibraryBinaryOperation)static_A_symbol_218.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_218 = dynamic_A_symbol_218.evaluate(evaluator, T_Boolean, A_symbol_217, I_1);
				rightA_symbol_210 = A_symbol_218;
			} catch (InvalidValueException e) {
				rightA_symbol_210 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_218 = rightA_symbol_210;
			DomainType static_A_symbol_210 = valueFactory.typeOf(A_symbol_211);
			LibraryBinaryOperation dynamic_A_symbol_210 = (LibraryBinaryOperation)static_A_symbol_210.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_210 = dynamic_A_symbol_210.evaluate(evaluator, T_Boolean, A_symbol_211, A_symbol_218);
			return A_symbol_210;
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
			final @NonNull Value T_ClassClassifier_Boolean_ = valueFactory.createTypeValue(OCLstdlibTables.Types._Boolean);
			
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
				
				Value A_symbol_225 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_226 = valueFactory.typeOf(A_symbol_225, T_ClassClassifier_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_226 = (LibraryBinaryOperation)static_A_symbol_226.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_226 = dynamic_A_symbol_226.evaluate(evaluator, T_Boolean, A_symbol_225, T_ClassClassifier_Boolean_);
				rightA_symbol_219 = A_symbol_226;
			} catch (InvalidValueException e) {
				rightA_symbol_219 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_226 = rightA_symbol_219;
			DomainType static_A_symbol_219 = valueFactory.typeOf(A_symbol_220);
			LibraryBinaryOperation dynamic_A_symbol_219 = (LibraryBinaryOperation)static_A_symbol_219.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_219 = dynamic_A_symbol_219.evaluate(evaluator, T_Boolean, A_symbol_220, A_symbol_226);
			return A_symbol_219;
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
			
			Value leftA_symbol_227;
			try {
				Value leftA_symbol_228;
				try {
					
					Value A_symbol_229 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
					
					DomainType static_A_symbol_230 = valueFactory.typeOf(A_symbol_229, S_reject);
					LibraryBinaryOperation dynamic_A_symbol_230 = (LibraryBinaryOperation)static_A_symbol_230.lookupImplementation(standardLibrary, O_String__eq_);
					Value A_symbol_230 = dynamic_A_symbol_230.evaluate(evaluator, T_Boolean, A_symbol_229, S_reject);
					leftA_symbol_228 = A_symbol_230;
				} catch (InvalidValueException e) {
					leftA_symbol_228 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_230 = leftA_symbol_228;
				Value rightA_symbol_228;
				try {
					
					Value A_symbol_231 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
					
					DomainType static_A_symbol_232 = valueFactory.typeOf(A_symbol_231, S_select);
					LibraryBinaryOperation dynamic_A_symbol_232 = (LibraryBinaryOperation)static_A_symbol_232.lookupImplementation(standardLibrary, O_String__eq_);
					Value A_symbol_232 = dynamic_A_symbol_232.evaluate(evaluator, T_Boolean, A_symbol_231, S_select);
					rightA_symbol_228 = A_symbol_232;
				} catch (InvalidValueException e) {
					rightA_symbol_228 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_232 = rightA_symbol_228;
				DomainType static_A_symbol_228 = valueFactory.typeOf(A_symbol_230);
				LibraryBinaryOperation dynamic_A_symbol_228 = (LibraryBinaryOperation)static_A_symbol_228.lookupImplementation(standardLibrary, O_Boolean_or);
				Value A_symbol_228 = dynamic_A_symbol_228.evaluate(evaluator, T_Boolean, A_symbol_230, A_symbol_232);
				leftA_symbol_227 = A_symbol_228;
			} catch (InvalidValueException e) {
				leftA_symbol_227 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_228 = leftA_symbol_227;
			Value rightA_symbol_227;
			try {
				
				Value A_symbol_233 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				
				Value A_symbol_234 = IP_CallExp_source.evaluate(evaluator, T_pivot__OCLExpression, self, P_CallExp_source);
				
				Value A_symbol_235 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_234, P_TypedElement_type);
				
				DomainType static_A_symbol_236 = valueFactory.typeOf(A_symbol_233, A_symbol_235);
				LibraryBinaryOperation dynamic_A_symbol_236 = (LibraryBinaryOperation)static_A_symbol_236.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_236 = dynamic_A_symbol_236.evaluate(evaluator, T_Boolean, A_symbol_233, A_symbol_235);
				rightA_symbol_227 = A_symbol_236;
			} catch (InvalidValueException e) {
				rightA_symbol_227 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_236 = rightA_symbol_227;
			DomainType static_A_symbol_227 = valueFactory.typeOf(A_symbol_228);
			LibraryBinaryOperation dynamic_A_symbol_227 = (LibraryBinaryOperation)static_A_symbol_227.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_227 = dynamic_A_symbol_227.evaluate(evaluator, T_Boolean, A_symbol_228, A_symbol_236);
			return A_symbol_227;
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
			final @NonNull Value T_ClassClassifier_pivot__CollectionType_ = valueFactory.createTypeValue(PivotTables.Types._CollectionType);
			final @NonNull ExecutorType T_pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final @NonNull ExecutorProperty P_LoopExp_body = PivotTables.Properties._LoopExp__body;
			final @NonNull LibraryProperty IP_LoopExp_body = P_LoopExp_body.getImplementation();
			
			Value leftA_symbol_237;
			try {
				
				Value A_symbol_238 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_239 = valueFactory.typeOf(A_symbol_238, S_sortedBy);
				LibraryBinaryOperation dynamic_A_symbol_239 = (LibraryBinaryOperation)static_A_symbol_239.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_239 = dynamic_A_symbol_239.evaluate(evaluator, T_Boolean, A_symbol_238, S_sortedBy);
				leftA_symbol_237 = A_symbol_239;
			} catch (InvalidValueException e) {
				leftA_symbol_237 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_239 = leftA_symbol_237;
			Value rightA_symbol_237;
			try {
				
				Value A_symbol_240 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_241 = valueFactory.typeOf(A_symbol_240);
				LibraryBinaryOperation dynamic_A_symbol_241 = (LibraryBinaryOperation)static_A_symbol_241.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_241 = dynamic_A_symbol_241.evaluate(evaluator, T_pivot__CollectionType, A_symbol_240, T_ClassClassifier_pivot__CollectionType_);
				Value A_symbol_242 = IP_CollectionType_elementType.evaluate(evaluator, T_Type, A_symbol_241, P_CollectionType_elementType);
				
				
				Value A_symbol_243 = IP_LoopExp_body.evaluate(evaluator, T_pivot__OCLExpression, self, P_LoopExp_body);
				
				Value A_symbol_244 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_243, P_TypedElement_type);
				
				DomainType static_A_symbol_245 = valueFactory.typeOf(A_symbol_244);
				LibraryBinaryOperation dynamic_A_symbol_245 = (LibraryBinaryOperation)static_A_symbol_245.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_245 = dynamic_A_symbol_245.evaluate(evaluator, T_pivot__CollectionType, A_symbol_244, T_ClassClassifier_pivot__CollectionType_);
				Value A_symbol_246 = IP_CollectionType_elementType.evaluate(evaluator, T_Type, A_symbol_245, P_CollectionType_elementType);
				
				DomainType static_A_symbol_247 = valueFactory.typeOf(A_symbol_242, A_symbol_246);
				LibraryBinaryOperation dynamic_A_symbol_247 = (LibraryBinaryOperation)static_A_symbol_247.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_247 = dynamic_A_symbol_247.evaluate(evaluator, T_Boolean, A_symbol_242, A_symbol_246);
				rightA_symbol_237 = A_symbol_247;
			} catch (InvalidValueException e) {
				rightA_symbol_237 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_247 = rightA_symbol_237;
			DomainType static_A_symbol_237 = valueFactory.typeOf(A_symbol_239);
			LibraryBinaryOperation dynamic_A_symbol_237 = (LibraryBinaryOperation)static_A_symbol_237.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_237 = dynamic_A_symbol_237.evaluate(evaluator, T_Boolean, A_symbol_239, A_symbol_247);
			return A_symbol_237;
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
			
			Value leftA_symbol_248;
			try {
				
				Value A_symbol_249 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_250 = valueFactory.typeOf(A_symbol_249, S_sortedBy);
				LibraryBinaryOperation dynamic_A_symbol_250 = (LibraryBinaryOperation)static_A_symbol_250.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_250 = dynamic_A_symbol_250.evaluate(evaluator, T_Boolean, A_symbol_249, S_sortedBy);
				leftA_symbol_248 = A_symbol_250;
			} catch (InvalidValueException e) {
				leftA_symbol_248 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_250 = leftA_symbol_248;
			Value rightA_symbol_248;
			try {
				
				Value A_symbol_251 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_252 = valueFactory.typeOf(A_symbol_251);
				LibraryUnaryOperation dynamic_A_symbol_252 = (LibraryUnaryOperation)static_A_symbol_252.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_252 = dynamic_A_symbol_252.evaluate(evaluator, T_Integer, A_symbol_251);
				DomainType static_A_symbol_253 = valueFactory.typeOf(A_symbol_252, I_1);
				LibraryBinaryOperation dynamic_A_symbol_253 = (LibraryBinaryOperation)static_A_symbol_253.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_253 = dynamic_A_symbol_253.evaluate(evaluator, T_Boolean, A_symbol_252, I_1);
				rightA_symbol_248 = A_symbol_253;
			} catch (InvalidValueException e) {
				rightA_symbol_248 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_253 = rightA_symbol_248;
			DomainType static_A_symbol_248 = valueFactory.typeOf(A_symbol_250);
			LibraryBinaryOperation dynamic_A_symbol_248 = (LibraryBinaryOperation)static_A_symbol_248.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_248 = dynamic_A_symbol_248.evaluate(evaluator, T_Boolean, A_symbol_250, A_symbol_253);
			return A_symbol_248;
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
			final @NonNull Value T_ClassClassifier_pivot__SequenceType_ = valueFactory.createTypeValue(PivotTables.Types._SequenceType);
			final @NonNull Value T_ClassClassifier_pivot__BagType_ = valueFactory.createTypeValue(PivotTables.Types._BagType);
			final @NonNull Value T_ClassClassifier_pivot__OrderedSetType_ = valueFactory.createTypeValue(PivotTables.Types._OrderedSetType);
			
			Value leftA_symbol_254;
			try {
				
				Value A_symbol_255 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_256 = valueFactory.typeOf(A_symbol_255, S_sortedBy);
				LibraryBinaryOperation dynamic_A_symbol_256 = (LibraryBinaryOperation)static_A_symbol_256.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_256 = dynamic_A_symbol_256.evaluate(evaluator, T_Boolean, A_symbol_255, S_sortedBy);
				leftA_symbol_254 = A_symbol_256;
			} catch (InvalidValueException e) {
				leftA_symbol_254 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_256 = leftA_symbol_254;
			Value rightA_symbol_254;
			try {
					Value leftA_symbol_257;
					try {
						
						Value A_symbol_258 = IP_CallExp_source.evaluate(evaluator, T_pivot__OCLExpression, self, P_CallExp_source);
						
						Value A_symbol_259 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_258, P_TypedElement_type);
						
						DomainType static_A_symbol_260 = valueFactory.typeOf(A_symbol_259);
						LibraryBinaryOperation dynamic_A_symbol_260 = (LibraryBinaryOperation)static_A_symbol_260.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Value A_symbol_260 = dynamic_A_symbol_260.evaluate(evaluator, T_Boolean, A_symbol_259, T_ClassClassifier_pivot__SequenceType_);
						leftA_symbol_257 = A_symbol_260;
					} catch (InvalidValueException e) {
						leftA_symbol_257 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_260 = leftA_symbol_257;
					Value rightA_symbol_257;
					try {
						
						Value A_symbol_261 = IP_CallExp_source.evaluate(evaluator, T_pivot__OCLExpression, self, P_CallExp_source);
						
						Value A_symbol_262 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_261, P_TypedElement_type);
						
						DomainType static_A_symbol_263 = valueFactory.typeOf(A_symbol_262);
						LibraryBinaryOperation dynamic_A_symbol_263 = (LibraryBinaryOperation)static_A_symbol_263.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Value A_symbol_263 = dynamic_A_symbol_263.evaluate(evaluator, T_Boolean, A_symbol_262, T_ClassClassifier_pivot__BagType_);
						rightA_symbol_257 = A_symbol_263;
					} catch (InvalidValueException e) {
						rightA_symbol_257 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_263 = rightA_symbol_257;
					DomainType static_A_symbol_257 = valueFactory.typeOf(A_symbol_260);
					LibraryBinaryOperation dynamic_A_symbol_257 = (LibraryBinaryOperation)static_A_symbol_257.lookupImplementation(standardLibrary, O_Boolean_or);
					Value A_symbol_257 = dynamic_A_symbol_257.evaluate(evaluator, T_Boolean, A_symbol_260, A_symbol_263);
				Value A_symbol_264;
				if (A_symbol_257.isTrue()) {
					
					Value A_symbol_265 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
					
					DomainType static_A_symbol_266 = valueFactory.typeOf(A_symbol_265);
					LibraryBinaryOperation dynamic_A_symbol_266 = (LibraryBinaryOperation)static_A_symbol_266.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Value A_symbol_266 = dynamic_A_symbol_266.evaluate(evaluator, T_Boolean, A_symbol_265, T_ClassClassifier_pivot__SequenceType_);
					A_symbol_264 = A_symbol_266;
				}
				else if (A_symbol_257.isFalse()) {
					
					Value A_symbol_267 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
					
					DomainType static_A_symbol_268 = valueFactory.typeOf(A_symbol_267);
					LibraryBinaryOperation dynamic_A_symbol_268 = (LibraryBinaryOperation)static_A_symbol_268.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Value A_symbol_268 = dynamic_A_symbol_268.evaluate(evaluator, T_Boolean, A_symbol_267, T_ClassClassifier_pivot__OrderedSetType_);
					A_symbol_264 = A_symbol_268;
				}
				else if (A_symbol_257.isNull()) {
					A_symbol_264 = valueFactory.throwInvalidValueException("null if condition");
				}
				else {
					A_symbol_264 = valueFactory.throwInvalidValueException("invalid if condition");
				}
				rightA_symbol_254 = A_symbol_264;
			} catch (InvalidValueException e) {
				rightA_symbol_254 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_264 = rightA_symbol_254;
			DomainType static_A_symbol_254 = valueFactory.typeOf(A_symbol_256);
			LibraryBinaryOperation dynamic_A_symbol_254 = (LibraryBinaryOperation)static_A_symbol_254.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_254 = dynamic_A_symbol_254.evaluate(evaluator, T_Boolean, A_symbol_256, A_symbol_264);
			return A_symbol_254;
		}
	}
}

