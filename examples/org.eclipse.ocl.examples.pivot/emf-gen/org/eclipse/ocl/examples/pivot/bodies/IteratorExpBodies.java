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
import org.eclipse.ocl.examples.domain.values.ValueFactory;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
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
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Object self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final @NonNull ExecutorType T_String = OCLstdlibTables.Types._String;
			final @NonNull ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final @NonNull LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final @NonNull Object S_any = "any";
			final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
			final @NonNull ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final @NonNull ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final @NonNull LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final @NonNull ExecutorType T_pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final @NonNull ExecutorProperty P_LoopExp_body = PivotTables.Properties._LoopExp__body;
			final @NonNull LibraryProperty IP_LoopExp_body = P_LoopExp_body.getImplementation();
			final @NonNull Object S_Boolean = "Boolean";
			
			Object leftA_symbol_;
			try {
				
				Object A_symbol__1 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol__2 = valueFactory.typeOf(A_symbol__1, S_any);
				LibraryBinaryOperation dynamic_A_symbol__2 = (LibraryBinaryOperation)static_A_symbol__2.lookupImplementation(standardLibrary, O_String__eq_);
				Object A_symbol__2 = dynamic_A_symbol__2.evaluate(evaluator, T_Boolean, A_symbol__1, S_any);
				leftA_symbol_ = A_symbol__2;
			} catch (InvalidValueException e) {
				leftA_symbol_ = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__2 = leftA_symbol_;
			Object rightA_symbol_;
			try {
				
				Object A_symbol__3 = IP_LoopExp_body.evaluate(evaluator, T_pivot__OCLExpression, self, P_LoopExp_body);
				
				Object A_symbol__4 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol__3, P_TypedElement_type);
				
				DomainType static_A_symbol__5 = valueFactory.typeOf(A_symbol__4, S_Boolean);
				LibraryBinaryOperation dynamic_A_symbol__5 = (LibraryBinaryOperation)static_A_symbol__5.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Object A_symbol__5 = dynamic_A_symbol__5.evaluate(evaluator, T_Boolean, A_symbol__4, S_Boolean);
				rightA_symbol_ = A_symbol__5;
			} catch (InvalidValueException e) {
				rightA_symbol_ = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__5 = rightA_symbol_;
			DomainType static_A_symbol_ = valueFactory.typeOf(A_symbol__2);
			LibraryBinaryOperation dynamic_A_symbol_ = (LibraryBinaryOperation)static_A_symbol_.lookupImplementation(standardLibrary, O_Boolean_implies);
			Object A_symbol_ = dynamic_A_symbol_.evaluate(evaluator, T_Boolean, A_symbol__2, A_symbol__5);
			return A_symbol_;
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
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Object self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final @NonNull ExecutorType T_String = OCLstdlibTables.Types._String;
			final @NonNull ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final @NonNull LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final @NonNull Object S_any = "any";
			final @NonNull ExecutorOperation O_Real__eq_ = OCLstdlibTables.Operations._Real___eq_;
			final @NonNull ExecutorType T_Integer = OCLstdlibTables.Types._Integer;
			final @NonNull ExecutorOperation O_Collection_size = OCLstdlibTables.Operations._Collection__size;
			final @NonNull ExecutorType T_pivot__Variable = PivotTables.Types._Variable;
			final @NonNull DomainCollectionType T_OrderedSet_pivot__Variable_ = standardLibrary.getOrderedSetType(T_pivot__Variable, null, null);
			final @NonNull ExecutorProperty P_LoopExp_iterator = PivotTables.Properties._LoopExp__iterator;
			final @NonNull LibraryProperty IP_LoopExp_iterator = P_LoopExp_iterator.getImplementation();
			final @NonNull IntegerValue I_1 = valueFactory.integerValueOf(1);
			
			Object leftA_symbol__6;
			try {
				
				Object A_symbol__7 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol__8 = valueFactory.typeOf(A_symbol__7, S_any);
				LibraryBinaryOperation dynamic_A_symbol__8 = (LibraryBinaryOperation)static_A_symbol__8.lookupImplementation(standardLibrary, O_String__eq_);
				Object A_symbol__8 = dynamic_A_symbol__8.evaluate(evaluator, T_Boolean, A_symbol__7, S_any);
				leftA_symbol__6 = A_symbol__8;
			} catch (InvalidValueException e) {
				leftA_symbol__6 = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__8 = leftA_symbol__6;
			Object rightA_symbol__6;
			try {
				
				Object A_symbol__9 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol__10 = valueFactory.typeOf(A_symbol__9);
				LibraryUnaryOperation dynamic_A_symbol__10 = (LibraryUnaryOperation)static_A_symbol__10.lookupImplementation(standardLibrary, O_Collection_size);
				Object A_symbol__10 = dynamic_A_symbol__10.evaluate(evaluator, T_Integer, A_symbol__9);
				DomainType static_A_symbol__11 = valueFactory.typeOf(A_symbol__10, I_1);
				LibraryBinaryOperation dynamic_A_symbol__11 = (LibraryBinaryOperation)static_A_symbol__11.lookupImplementation(standardLibrary, O_Real__eq_);
				Object A_symbol__11 = dynamic_A_symbol__11.evaluate(evaluator, T_Boolean, A_symbol__10, I_1);
				rightA_symbol__6 = A_symbol__11;
			} catch (InvalidValueException e) {
				rightA_symbol__6 = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__11 = rightA_symbol__6;
			DomainType static_A_symbol__6 = valueFactory.typeOf(A_symbol__8);
			LibraryBinaryOperation dynamic_A_symbol__6 = (LibraryBinaryOperation)static_A_symbol__6.lookupImplementation(standardLibrary, O_Boolean_implies);
			Object A_symbol__6 = dynamic_A_symbol__6.evaluate(evaluator, T_Boolean, A_symbol__8, A_symbol__11);
			return A_symbol__6;
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
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Object self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final @NonNull ExecutorType T_String = OCLstdlibTables.Types._String;
			final @NonNull ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final @NonNull LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final @NonNull Object S_any = "any";
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
			final @NonNull Object T_Metaclass_pivot__CollectionType_ = valueFactory.createTypeValue(PivotTables.Types._CollectionType);
			
			Object leftA_symbol__12;
			try {
				
				Object A_symbol__13 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol__14 = valueFactory.typeOf(A_symbol__13, S_any);
				LibraryBinaryOperation dynamic_A_symbol__14 = (LibraryBinaryOperation)static_A_symbol__14.lookupImplementation(standardLibrary, O_String__eq_);
				Object A_symbol__14 = dynamic_A_symbol__14.evaluate(evaluator, T_Boolean, A_symbol__13, S_any);
				leftA_symbol__12 = A_symbol__14;
			} catch (InvalidValueException e) {
				leftA_symbol__12 = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__14 = leftA_symbol__12;
			Object rightA_symbol__12;
			try {
				
				Object A_symbol__15 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				
				Object A_symbol__16 = IP_CallExp_source.evaluate(evaluator, T_pivot__OCLExpression, self, P_CallExp_source);
				
				Object A_symbol__17 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol__16, P_TypedElement_type);
				
				DomainType static_A_symbol__18 = valueFactory.typeOf(A_symbol__17);
				LibraryBinaryOperation dynamic_A_symbol__18 = (LibraryBinaryOperation)static_A_symbol__18.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Object A_symbol__18 = dynamic_A_symbol__18.evaluate(evaluator, T_pivot__CollectionType, A_symbol__17, T_Metaclass_pivot__CollectionType_);
				Object A_symbol__19 = IP_CollectionType_elementType.evaluate(evaluator, T_Type, A_symbol__18, P_CollectionType_elementType);
				
				DomainType static_A_symbol__20 = valueFactory.typeOf(A_symbol__15, A_symbol__19);
				LibraryBinaryOperation dynamic_A_symbol__20 = (LibraryBinaryOperation)static_A_symbol__20.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Object A_symbol__20 = dynamic_A_symbol__20.evaluate(evaluator, T_Boolean, A_symbol__15, A_symbol__19);
				rightA_symbol__12 = A_symbol__20;
			} catch (InvalidValueException e) {
				rightA_symbol__12 = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__20 = rightA_symbol__12;
			DomainType static_A_symbol__12 = valueFactory.typeOf(A_symbol__14);
			LibraryBinaryOperation dynamic_A_symbol__12 = (LibraryBinaryOperation)static_A_symbol__12.lookupImplementation(standardLibrary, O_Boolean_implies);
			Object A_symbol__12 = dynamic_A_symbol__12.evaluate(evaluator, T_Boolean, A_symbol__14, A_symbol__20);
			return A_symbol__12;
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
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Object self) throws InvalidValueException {
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
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Object self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final @NonNull ExecutorType T_String = OCLstdlibTables.Types._String;
			final @NonNull ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final @NonNull LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final @NonNull Object S_closure = "closure";
			final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
			final @NonNull ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final @NonNull ExecutorProperty P_CollectionType_elementType = PivotTables.Properties._CollectionType__elementType;
			final @NonNull LibraryProperty IP_CollectionType_elementType = P_CollectionType_elementType.getImplementation();
			final @NonNull ExecutorType T_pivot__CollectionType = PivotTables.Types._CollectionType;
			final @NonNull ExecutorOperation O_OclAny_oclAsType = OCLstdlibTables.Operations._OclAny__oclAsType;
			final @NonNull ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final @NonNull LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final @NonNull Object T_Metaclass_pivot__CollectionType_ = valueFactory.createTypeValue(PivotTables.Types._CollectionType);
			final @NonNull ExecutorType T_pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final @NonNull ExecutorProperty P_CallExp_source = PivotTables.Properties._CallExp__source;
			final @NonNull LibraryProperty IP_CallExp_source = P_CallExp_source.getImplementation();
			
			Object leftA_symbol__21;
			try {
				
				Object A_symbol__22 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol__23 = valueFactory.typeOf(A_symbol__22, S_closure);
				LibraryBinaryOperation dynamic_A_symbol__23 = (LibraryBinaryOperation)static_A_symbol__23.lookupImplementation(standardLibrary, O_String__eq_);
				Object A_symbol__23 = dynamic_A_symbol__23.evaluate(evaluator, T_Boolean, A_symbol__22, S_closure);
				leftA_symbol__21 = A_symbol__23;
			} catch (InvalidValueException e) {
				leftA_symbol__21 = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__23 = leftA_symbol__21;
			Object rightA_symbol__21;
			try {
				
				Object A_symbol__24 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol__25 = valueFactory.typeOf(A_symbol__24);
				LibraryBinaryOperation dynamic_A_symbol__25 = (LibraryBinaryOperation)static_A_symbol__25.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Object A_symbol__25 = dynamic_A_symbol__25.evaluate(evaluator, T_pivot__CollectionType, A_symbol__24, T_Metaclass_pivot__CollectionType_);
				Object A_symbol__26 = IP_CollectionType_elementType.evaluate(evaluator, T_Type, A_symbol__25, P_CollectionType_elementType);
				
				
				Object A_symbol__27 = IP_CallExp_source.evaluate(evaluator, T_pivot__OCLExpression, self, P_CallExp_source);
				
				Object A_symbol__28 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol__27, P_TypedElement_type);
				
				DomainType static_A_symbol__29 = valueFactory.typeOf(A_symbol__28);
				LibraryBinaryOperation dynamic_A_symbol__29 = (LibraryBinaryOperation)static_A_symbol__29.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Object A_symbol__29 = dynamic_A_symbol__29.evaluate(evaluator, T_pivot__CollectionType, A_symbol__28, T_Metaclass_pivot__CollectionType_);
				Object A_symbol__30 = IP_CollectionType_elementType.evaluate(evaluator, T_Type, A_symbol__29, P_CollectionType_elementType);
				
				DomainType static_A_symbol__31 = valueFactory.typeOf(A_symbol__26, A_symbol__30);
				LibraryBinaryOperation dynamic_A_symbol__31 = (LibraryBinaryOperation)static_A_symbol__31.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Object A_symbol__31 = dynamic_A_symbol__31.evaluate(evaluator, T_Boolean, A_symbol__26, A_symbol__30);
				rightA_symbol__21 = A_symbol__31;
			} catch (InvalidValueException e) {
				rightA_symbol__21 = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__31 = rightA_symbol__21;
			DomainType static_A_symbol__21 = valueFactory.typeOf(A_symbol__23);
			LibraryBinaryOperation dynamic_A_symbol__21 = (LibraryBinaryOperation)static_A_symbol__21.lookupImplementation(standardLibrary, O_Boolean_implies);
			Object A_symbol__21 = dynamic_A_symbol__21.evaluate(evaluator, T_Boolean, A_symbol__23, A_symbol__31);
			return A_symbol__21;
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
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Object self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final @NonNull ExecutorType T_String = OCLstdlibTables.Types._String;
			final @NonNull ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final @NonNull LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final @NonNull Object S_closure = "closure";
			final @NonNull ExecutorOperation O_Real__eq_ = OCLstdlibTables.Operations._Real___eq_;
			final @NonNull ExecutorType T_Integer = OCLstdlibTables.Types._Integer;
			final @NonNull ExecutorOperation O_Collection_size = OCLstdlibTables.Operations._Collection__size;
			final @NonNull ExecutorType T_pivot__Variable = PivotTables.Types._Variable;
			final @NonNull DomainCollectionType T_OrderedSet_pivot__Variable_ = standardLibrary.getOrderedSetType(T_pivot__Variable, null, null);
			final @NonNull ExecutorProperty P_LoopExp_iterator = PivotTables.Properties._LoopExp__iterator;
			final @NonNull LibraryProperty IP_LoopExp_iterator = P_LoopExp_iterator.getImplementation();
			final @NonNull IntegerValue I_1 = valueFactory.integerValueOf(1);
			
			Object leftA_symbol__32;
			try {
				
				Object A_symbol__33 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol__34 = valueFactory.typeOf(A_symbol__33, S_closure);
				LibraryBinaryOperation dynamic_A_symbol__34 = (LibraryBinaryOperation)static_A_symbol__34.lookupImplementation(standardLibrary, O_String__eq_);
				Object A_symbol__34 = dynamic_A_symbol__34.evaluate(evaluator, T_Boolean, A_symbol__33, S_closure);
				leftA_symbol__32 = A_symbol__34;
			} catch (InvalidValueException e) {
				leftA_symbol__32 = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__34 = leftA_symbol__32;
			Object rightA_symbol__32;
			try {
				
				Object A_symbol__35 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol__36 = valueFactory.typeOf(A_symbol__35);
				LibraryUnaryOperation dynamic_A_symbol__36 = (LibraryUnaryOperation)static_A_symbol__36.lookupImplementation(standardLibrary, O_Collection_size);
				Object A_symbol__36 = dynamic_A_symbol__36.evaluate(evaluator, T_Integer, A_symbol__35);
				DomainType static_A_symbol__37 = valueFactory.typeOf(A_symbol__36, I_1);
				LibraryBinaryOperation dynamic_A_symbol__37 = (LibraryBinaryOperation)static_A_symbol__37.lookupImplementation(standardLibrary, O_Real__eq_);
				Object A_symbol__37 = dynamic_A_symbol__37.evaluate(evaluator, T_Boolean, A_symbol__36, I_1);
				rightA_symbol__32 = A_symbol__37;
			} catch (InvalidValueException e) {
				rightA_symbol__32 = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__37 = rightA_symbol__32;
			DomainType static_A_symbol__32 = valueFactory.typeOf(A_symbol__34);
			LibraryBinaryOperation dynamic_A_symbol__32 = (LibraryBinaryOperation)static_A_symbol__32.lookupImplementation(standardLibrary, O_Boolean_implies);
			Object A_symbol__32 = dynamic_A_symbol__32.evaluate(evaluator, T_Boolean, A_symbol__34, A_symbol__37);
			return A_symbol__32;
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
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Object self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final @NonNull ExecutorType T_String = OCLstdlibTables.Types._String;
			final @NonNull ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final @NonNull LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final @NonNull Object S_closure = "closure";
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
			final @NonNull Object T_Metaclass_pivot__CollectionType_ = valueFactory.createTypeValue(PivotTables.Types._CollectionType);
			final @NonNull ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
			final @NonNull ExecutorProperty P_LoopExp_body = PivotTables.Properties._LoopExp__body;
			final @NonNull LibraryProperty IP_LoopExp_body = P_LoopExp_body.getImplementation();
			
			Object leftA_symbol__38;
			try {
				
				Object A_symbol__39 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol__40 = valueFactory.typeOf(A_symbol__39, S_closure);
				LibraryBinaryOperation dynamic_A_symbol__40 = (LibraryBinaryOperation)static_A_symbol__40.lookupImplementation(standardLibrary, O_String__eq_);
				Object A_symbol__40 = dynamic_A_symbol__40.evaluate(evaluator, T_Boolean, A_symbol__39, S_closure);
				leftA_symbol__38 = A_symbol__40;
			} catch (InvalidValueException e) {
				leftA_symbol__38 = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__40 = leftA_symbol__38;
			Object rightA_symbol__38;
			try {
				
				Object A_symbol__41 = IP_CallExp_source.evaluate(evaluator, T_pivot__OCLExpression, self, P_CallExp_source);
				
				Object A_symbol__42 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol__41, P_TypedElement_type);
				
				DomainType static_A_symbol__43 = valueFactory.typeOf(A_symbol__42);
				LibraryBinaryOperation dynamic_A_symbol__43 = (LibraryBinaryOperation)static_A_symbol__43.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Object A_symbol__43 = dynamic_A_symbol__43.evaluate(evaluator, T_pivot__CollectionType, A_symbol__42, T_Metaclass_pivot__CollectionType_);
				Object A_symbol__44 = IP_CollectionType_elementType.evaluate(evaluator, T_Type, A_symbol__43, P_CollectionType_elementType);
				
					
					Object A_symbol__45 = IP_LoopExp_body.evaluate(evaluator, T_pivot__OCLExpression, self, P_LoopExp_body);
					
					Object A_symbol__46 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol__45, P_TypedElement_type);
					
					DomainType static_A_symbol__47 = valueFactory.typeOf(A_symbol__46);
					LibraryBinaryOperation dynamic_A_symbol__47 = (LibraryBinaryOperation)static_A_symbol__47.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Object A_symbol__47 = dynamic_A_symbol__47.evaluate(evaluator, T_Boolean, A_symbol__46, T_Metaclass_pivot__CollectionType_);
				Object A_symbol__48;
				if (ValuesUtil.isTrue(A_symbol__47)) {
					
					Object A_symbol__49 = IP_LoopExp_body.evaluate(evaluator, T_pivot__OCLExpression, self, P_LoopExp_body);
					
					Object A_symbol__50 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol__49, P_TypedElement_type);
					
					DomainType static_A_symbol__51 = valueFactory.typeOf(A_symbol__50);
					LibraryBinaryOperation dynamic_A_symbol__51 = (LibraryBinaryOperation)static_A_symbol__51.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
					Object A_symbol__51 = dynamic_A_symbol__51.evaluate(evaluator, T_pivot__CollectionType, A_symbol__50, T_Metaclass_pivot__CollectionType_);
					Object A_symbol__52 = IP_CollectionType_elementType.evaluate(evaluator, T_Type, A_symbol__51, P_CollectionType_elementType);
					
					A_symbol__48 = A_symbol__52;
				}
				else if (ValuesUtil.isFalse(A_symbol__47)) {
					
					Object A_symbol__53 = IP_LoopExp_body.evaluate(evaluator, T_pivot__OCLExpression, self, P_LoopExp_body);
					
					Object A_symbol__54 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol__53, P_TypedElement_type);
					
					A_symbol__48 = A_symbol__54;
				}
				else if (ValuesUtil.isNull(A_symbol__47)) {
					A_symbol__48 = valueFactory.throwInvalidValueException("null if condition");
				}
				else {
					A_symbol__48 = valueFactory.throwInvalidValueException("invalid if condition");
				}
				DomainType static_A_symbol__55 = valueFactory.typeOf(A_symbol__44, A_symbol__48);
				LibraryBinaryOperation dynamic_A_symbol__55 = (LibraryBinaryOperation)static_A_symbol__55.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Object A_symbol__55 = dynamic_A_symbol__55.evaluate(evaluator, T_Boolean, A_symbol__44, A_symbol__48);
				rightA_symbol__38 = A_symbol__55;
			} catch (InvalidValueException e) {
				rightA_symbol__38 = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__55 = rightA_symbol__38;
			DomainType static_A_symbol__38 = valueFactory.typeOf(A_symbol__40);
			LibraryBinaryOperation dynamic_A_symbol__38 = (LibraryBinaryOperation)static_A_symbol__38.lookupImplementation(standardLibrary, O_Boolean_implies);
			Object A_symbol__38 = dynamic_A_symbol__38.evaluate(evaluator, T_Boolean, A_symbol__40, A_symbol__55);
			return A_symbol__38;
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
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Object self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final @NonNull ExecutorType T_String = OCLstdlibTables.Types._String;
			final @NonNull ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final @NonNull LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final @NonNull Object S_closure = "closure";
			final @NonNull ExecutorOperation O_Boolean_or = OCLstdlibTables.Operations._Boolean__or;
			final @NonNull ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
			final @NonNull ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final @NonNull ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final @NonNull LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final @NonNull ExecutorType T_pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final @NonNull ExecutorProperty P_CallExp_source = PivotTables.Properties._CallExp__source;
			final @NonNull LibraryProperty IP_CallExp_source = P_CallExp_source.getImplementation();
			final @NonNull Object T_Metaclass_pivot__SequenceType_ = valueFactory.createTypeValue(PivotTables.Types._SequenceType);
			final @NonNull Object T_Metaclass_pivot__OrderedSetType_ = valueFactory.createTypeValue(PivotTables.Types._OrderedSetType);
			final @NonNull Object T_Metaclass_pivot__SetType_ = valueFactory.createTypeValue(PivotTables.Types._SetType);
			
			Object leftA_symbol__56;
			try {
				
				Object A_symbol__57 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol__58 = valueFactory.typeOf(A_symbol__57, S_closure);
				LibraryBinaryOperation dynamic_A_symbol__58 = (LibraryBinaryOperation)static_A_symbol__58.lookupImplementation(standardLibrary, O_String__eq_);
				Object A_symbol__58 = dynamic_A_symbol__58.evaluate(evaluator, T_Boolean, A_symbol__57, S_closure);
				leftA_symbol__56 = A_symbol__58;
			} catch (InvalidValueException e) {
				leftA_symbol__56 = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__58 = leftA_symbol__56;
			Object rightA_symbol__56;
			try {
					Object leftA_symbol__59;
					try {
						
						Object A_symbol__60 = IP_CallExp_source.evaluate(evaluator, T_pivot__OCLExpression, self, P_CallExp_source);
						
						Object A_symbol__61 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol__60, P_TypedElement_type);
						
						DomainType static_A_symbol__62 = valueFactory.typeOf(A_symbol__61);
						LibraryBinaryOperation dynamic_A_symbol__62 = (LibraryBinaryOperation)static_A_symbol__62.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Object A_symbol__62 = dynamic_A_symbol__62.evaluate(evaluator, T_Boolean, A_symbol__61, T_Metaclass_pivot__SequenceType_);
						leftA_symbol__59 = A_symbol__62;
					} catch (InvalidValueException e) {
						leftA_symbol__59 = valueFactory.createInvalidValue(e);
					}
					Object A_symbol__62 = leftA_symbol__59;
					Object rightA_symbol__59;
					try {
						
						Object A_symbol__63 = IP_CallExp_source.evaluate(evaluator, T_pivot__OCLExpression, self, P_CallExp_source);
						
						Object A_symbol__64 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol__63, P_TypedElement_type);
						
						DomainType static_A_symbol__65 = valueFactory.typeOf(A_symbol__64);
						LibraryBinaryOperation dynamic_A_symbol__65 = (LibraryBinaryOperation)static_A_symbol__65.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Object A_symbol__65 = dynamic_A_symbol__65.evaluate(evaluator, T_Boolean, A_symbol__64, T_Metaclass_pivot__OrderedSetType_);
						rightA_symbol__59 = A_symbol__65;
					} catch (InvalidValueException e) {
						rightA_symbol__59 = valueFactory.createInvalidValue(e);
					}
					Object A_symbol__65 = rightA_symbol__59;
					DomainType static_A_symbol__59 = valueFactory.typeOf(A_symbol__62);
					LibraryBinaryOperation dynamic_A_symbol__59 = (LibraryBinaryOperation)static_A_symbol__59.lookupImplementation(standardLibrary, O_Boolean_or);
					Object A_symbol__59 = dynamic_A_symbol__59.evaluate(evaluator, T_Boolean, A_symbol__62, A_symbol__65);
				Object A_symbol__66;
				if (ValuesUtil.isTrue(A_symbol__59)) {
					
					Object A_symbol__67 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
					
					DomainType static_A_symbol__68 = valueFactory.typeOf(A_symbol__67);
					LibraryBinaryOperation dynamic_A_symbol__68 = (LibraryBinaryOperation)static_A_symbol__68.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Object A_symbol__68 = dynamic_A_symbol__68.evaluate(evaluator, T_Boolean, A_symbol__67, T_Metaclass_pivot__OrderedSetType_);
					A_symbol__66 = A_symbol__68;
				}
				else if (ValuesUtil.isFalse(A_symbol__59)) {
					
					Object A_symbol__69 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
					
					DomainType static_A_symbol__70 = valueFactory.typeOf(A_symbol__69);
					LibraryBinaryOperation dynamic_A_symbol__70 = (LibraryBinaryOperation)static_A_symbol__70.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Object A_symbol__70 = dynamic_A_symbol__70.evaluate(evaluator, T_Boolean, A_symbol__69, T_Metaclass_pivot__SetType_);
					A_symbol__66 = A_symbol__70;
				}
				else if (ValuesUtil.isNull(A_symbol__59)) {
					A_symbol__66 = valueFactory.throwInvalidValueException("null if condition");
				}
				else {
					A_symbol__66 = valueFactory.throwInvalidValueException("invalid if condition");
				}
				rightA_symbol__56 = A_symbol__66;
			} catch (InvalidValueException e) {
				rightA_symbol__56 = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__66 = rightA_symbol__56;
			DomainType static_A_symbol__56 = valueFactory.typeOf(A_symbol__58);
			LibraryBinaryOperation dynamic_A_symbol__56 = (LibraryBinaryOperation)static_A_symbol__56.lookupImplementation(standardLibrary, O_Boolean_implies);
			Object A_symbol__56 = dynamic_A_symbol__56.evaluate(evaluator, T_Boolean, A_symbol__58, A_symbol__66);
			return A_symbol__56;
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
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Object self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final @NonNull ExecutorType T_String = OCLstdlibTables.Types._String;
			final @NonNull ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final @NonNull LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final @NonNull Object S_collect = "collect";
			final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
			final @NonNull ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final @NonNull ExecutorProperty P_CollectionType_elementType = PivotTables.Properties._CollectionType__elementType;
			final @NonNull LibraryProperty IP_CollectionType_elementType = P_CollectionType_elementType.getImplementation();
			final @NonNull ExecutorType T_pivot__CollectionType = PivotTables.Types._CollectionType;
			final @NonNull ExecutorOperation O_OclAny_oclAsType = OCLstdlibTables.Operations._OclAny__oclAsType;
			final @NonNull ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final @NonNull LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final @NonNull Object T_Metaclass_pivot__CollectionType_ = valueFactory.createTypeValue(PivotTables.Types._CollectionType);
			final @NonNull ExecutorType T_pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final @NonNull ExecutorProperty P_LoopExp_body = PivotTables.Properties._LoopExp__body;
			final @NonNull LibraryProperty IP_LoopExp_body = P_LoopExp_body.getImplementation();
			
			Object leftA_symbol__71;
			try {
				
				Object A_symbol__72 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol__73 = valueFactory.typeOf(A_symbol__72, S_collect);
				LibraryBinaryOperation dynamic_A_symbol__73 = (LibraryBinaryOperation)static_A_symbol__73.lookupImplementation(standardLibrary, O_String__eq_);
				Object A_symbol__73 = dynamic_A_symbol__73.evaluate(evaluator, T_Boolean, A_symbol__72, S_collect);
				leftA_symbol__71 = A_symbol__73;
			} catch (InvalidValueException e) {
				leftA_symbol__71 = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__73 = leftA_symbol__71;
			Object rightA_symbol__71;
			try {
				
				Object A_symbol__74 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol__75 = valueFactory.typeOf(A_symbol__74);
				LibraryBinaryOperation dynamic_A_symbol__75 = (LibraryBinaryOperation)static_A_symbol__75.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Object A_symbol__75 = dynamic_A_symbol__75.evaluate(evaluator, T_pivot__CollectionType, A_symbol__74, T_Metaclass_pivot__CollectionType_);
				Object A_symbol__76 = IP_CollectionType_elementType.evaluate(evaluator, T_Type, A_symbol__75, P_CollectionType_elementType);
				
				
				Object A_symbol__77 = IP_LoopExp_body.evaluate(evaluator, T_pivot__OCLExpression, self, P_LoopExp_body);
				
				Object A_symbol__78 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol__77, P_TypedElement_type);
				
				DomainType static_A_symbol__79 = valueFactory.typeOf(A_symbol__78);
				LibraryBinaryOperation dynamic_A_symbol__79 = (LibraryBinaryOperation)static_A_symbol__79.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Object A_symbol__79 = dynamic_A_symbol__79.evaluate(evaluator, T_pivot__CollectionType, A_symbol__78, T_Metaclass_pivot__CollectionType_);
				Object A_symbol__80 = IP_CollectionType_elementType.evaluate(evaluator, T_Type, A_symbol__79, P_CollectionType_elementType);
				
				DomainType static_A_symbol__81 = valueFactory.typeOf(A_symbol__76, A_symbol__80);
				LibraryBinaryOperation dynamic_A_symbol__81 = (LibraryBinaryOperation)static_A_symbol__81.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Object A_symbol__81 = dynamic_A_symbol__81.evaluate(evaluator, T_Boolean, A_symbol__76, A_symbol__80);
				rightA_symbol__71 = A_symbol__81;
			} catch (InvalidValueException e) {
				rightA_symbol__71 = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__81 = rightA_symbol__71;
			DomainType static_A_symbol__71 = valueFactory.typeOf(A_symbol__73);
			LibraryBinaryOperation dynamic_A_symbol__71 = (LibraryBinaryOperation)static_A_symbol__71.lookupImplementation(standardLibrary, O_Boolean_implies);
			Object A_symbol__71 = dynamic_A_symbol__71.evaluate(evaluator, T_Boolean, A_symbol__73, A_symbol__81);
			return A_symbol__71;
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
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Object self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final @NonNull ExecutorType T_String = OCLstdlibTables.Types._String;
			final @NonNull ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final @NonNull LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final @NonNull Object S_collect = "collect";
			final @NonNull ExecutorOperation O_Real__eq_ = OCLstdlibTables.Operations._Real___eq_;
			final @NonNull ExecutorType T_Integer = OCLstdlibTables.Types._Integer;
			final @NonNull ExecutorOperation O_Collection_size = OCLstdlibTables.Operations._Collection__size;
			final @NonNull ExecutorType T_pivot__Variable = PivotTables.Types._Variable;
			final @NonNull DomainCollectionType T_OrderedSet_pivot__Variable_ = standardLibrary.getOrderedSetType(T_pivot__Variable, null, null);
			final @NonNull ExecutorProperty P_LoopExp_iterator = PivotTables.Properties._LoopExp__iterator;
			final @NonNull LibraryProperty IP_LoopExp_iterator = P_LoopExp_iterator.getImplementation();
			final @NonNull IntegerValue I_1 = valueFactory.integerValueOf(1);
			
			Object leftA_symbol__82;
			try {
				
				Object A_symbol__83 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol__84 = valueFactory.typeOf(A_symbol__83, S_collect);
				LibraryBinaryOperation dynamic_A_symbol__84 = (LibraryBinaryOperation)static_A_symbol__84.lookupImplementation(standardLibrary, O_String__eq_);
				Object A_symbol__84 = dynamic_A_symbol__84.evaluate(evaluator, T_Boolean, A_symbol__83, S_collect);
				leftA_symbol__82 = A_symbol__84;
			} catch (InvalidValueException e) {
				leftA_symbol__82 = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__84 = leftA_symbol__82;
			Object rightA_symbol__82;
			try {
				
				Object A_symbol__85 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol__86 = valueFactory.typeOf(A_symbol__85);
				LibraryUnaryOperation dynamic_A_symbol__86 = (LibraryUnaryOperation)static_A_symbol__86.lookupImplementation(standardLibrary, O_Collection_size);
				Object A_symbol__86 = dynamic_A_symbol__86.evaluate(evaluator, T_Integer, A_symbol__85);
				DomainType static_A_symbol__87 = valueFactory.typeOf(A_symbol__86, I_1);
				LibraryBinaryOperation dynamic_A_symbol__87 = (LibraryBinaryOperation)static_A_symbol__87.lookupImplementation(standardLibrary, O_Real__eq_);
				Object A_symbol__87 = dynamic_A_symbol__87.evaluate(evaluator, T_Boolean, A_symbol__86, I_1);
				rightA_symbol__82 = A_symbol__87;
			} catch (InvalidValueException e) {
				rightA_symbol__82 = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__87 = rightA_symbol__82;
			DomainType static_A_symbol__82 = valueFactory.typeOf(A_symbol__84);
			LibraryBinaryOperation dynamic_A_symbol__82 = (LibraryBinaryOperation)static_A_symbol__82.lookupImplementation(standardLibrary, O_Boolean_implies);
			Object A_symbol__82 = dynamic_A_symbol__82.evaluate(evaluator, T_Boolean, A_symbol__84, A_symbol__87);
			return A_symbol__82;
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
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Object self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final @NonNull ExecutorType T_String = OCLstdlibTables.Types._String;
			final @NonNull ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final @NonNull LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final @NonNull Object S_collectN___ = "collectNested";
			final @NonNull ExecutorOperation O_Real__eq_ = OCLstdlibTables.Operations._Real___eq_;
			final @NonNull ExecutorType T_Integer = OCLstdlibTables.Types._Integer;
			final @NonNull ExecutorOperation O_Collection_size = OCLstdlibTables.Operations._Collection__size;
			final @NonNull ExecutorType T_pivot__Variable = PivotTables.Types._Variable;
			final @NonNull DomainCollectionType T_OrderedSet_pivot__Variable_ = standardLibrary.getOrderedSetType(T_pivot__Variable, null, null);
			final @NonNull ExecutorProperty P_LoopExp_iterator = PivotTables.Properties._LoopExp__iterator;
			final @NonNull LibraryProperty IP_LoopExp_iterator = P_LoopExp_iterator.getImplementation();
			final @NonNull IntegerValue I_1 = valueFactory.integerValueOf(1);
			
			Object leftA_symbol__88;
			try {
				
				Object A_symbol__89 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol__90 = valueFactory.typeOf(A_symbol__89, S_collectN___);
				LibraryBinaryOperation dynamic_A_symbol__90 = (LibraryBinaryOperation)static_A_symbol__90.lookupImplementation(standardLibrary, O_String__eq_);
				Object A_symbol__90 = dynamic_A_symbol__90.evaluate(evaluator, T_Boolean, A_symbol__89, S_collectN___);
				leftA_symbol__88 = A_symbol__90;
			} catch (InvalidValueException e) {
				leftA_symbol__88 = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__90 = leftA_symbol__88;
			Object rightA_symbol__88;
			try {
				
				Object A_symbol__91 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol__92 = valueFactory.typeOf(A_symbol__91);
				LibraryUnaryOperation dynamic_A_symbol__92 = (LibraryUnaryOperation)static_A_symbol__92.lookupImplementation(standardLibrary, O_Collection_size);
				Object A_symbol__92 = dynamic_A_symbol__92.evaluate(evaluator, T_Integer, A_symbol__91);
				DomainType static_A_symbol__93 = valueFactory.typeOf(A_symbol__92, I_1);
				LibraryBinaryOperation dynamic_A_symbol__93 = (LibraryBinaryOperation)static_A_symbol__93.lookupImplementation(standardLibrary, O_Real__eq_);
				Object A_symbol__93 = dynamic_A_symbol__93.evaluate(evaluator, T_Boolean, A_symbol__92, I_1);
				rightA_symbol__88 = A_symbol__93;
			} catch (InvalidValueException e) {
				rightA_symbol__88 = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__93 = rightA_symbol__88;
			DomainType static_A_symbol__88 = valueFactory.typeOf(A_symbol__90);
			LibraryBinaryOperation dynamic_A_symbol__88 = (LibraryBinaryOperation)static_A_symbol__88.lookupImplementation(standardLibrary, O_Boolean_implies);
			Object A_symbol__88 = dynamic_A_symbol__88.evaluate(evaluator, T_Boolean, A_symbol__90, A_symbol__93);
			return A_symbol__88;
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
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Object self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final @NonNull ExecutorType T_String = OCLstdlibTables.Types._String;
			final @NonNull ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final @NonNull LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final @NonNull Object S_collectN___ = "collectNested";
			final @NonNull ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
			final @NonNull ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final @NonNull ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final @NonNull LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final @NonNull Object T_Metaclass_pivot__BagType_ = valueFactory.createTypeValue(PivotTables.Types._BagType);
			
			Object leftA_symbol__94;
			try {
				
				Object A_symbol__95 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol__96 = valueFactory.typeOf(A_symbol__95, S_collectN___);
				LibraryBinaryOperation dynamic_A_symbol__96 = (LibraryBinaryOperation)static_A_symbol__96.lookupImplementation(standardLibrary, O_String__eq_);
				Object A_symbol__96 = dynamic_A_symbol__96.evaluate(evaluator, T_Boolean, A_symbol__95, S_collectN___);
				leftA_symbol__94 = A_symbol__96;
			} catch (InvalidValueException e) {
				leftA_symbol__94 = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__96 = leftA_symbol__94;
			Object rightA_symbol__94;
			try {
				
				Object A_symbol__97 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol__98 = valueFactory.typeOf(A_symbol__97);
				LibraryBinaryOperation dynamic_A_symbol__98 = (LibraryBinaryOperation)static_A_symbol__98.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
				Object A_symbol__98 = dynamic_A_symbol__98.evaluate(evaluator, T_Boolean, A_symbol__97, T_Metaclass_pivot__BagType_);
				rightA_symbol__94 = A_symbol__98;
			} catch (InvalidValueException e) {
				rightA_symbol__94 = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__98 = rightA_symbol__94;
			DomainType static_A_symbol__94 = valueFactory.typeOf(A_symbol__96);
			LibraryBinaryOperation dynamic_A_symbol__94 = (LibraryBinaryOperation)static_A_symbol__94.lookupImplementation(standardLibrary, O_Boolean_implies);
			Object A_symbol__94 = dynamic_A_symbol__94.evaluate(evaluator, T_Boolean, A_symbol__96, A_symbol__98);
			return A_symbol__94;
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
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Object self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final @NonNull ExecutorType T_String = OCLstdlibTables.Types._String;
			final @NonNull ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final @NonNull LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final @NonNull Object S_collectN___ = "collectNested";
			final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
			final @NonNull ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final @NonNull ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final @NonNull LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final @NonNull ExecutorType T_pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final @NonNull ExecutorProperty P_LoopExp_body = PivotTables.Properties._LoopExp__body;
			final @NonNull LibraryProperty IP_LoopExp_body = P_LoopExp_body.getImplementation();
			
			Object leftA_symbol__99;
			try {
				
				Object A_symbol__100 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol__101 = valueFactory.typeOf(A_symbol__100, S_collectN___);
				LibraryBinaryOperation dynamic_A_symbol__101 = (LibraryBinaryOperation)static_A_symbol__101.lookupImplementation(standardLibrary, O_String__eq_);
				Object A_symbol__101 = dynamic_A_symbol__101.evaluate(evaluator, T_Boolean, A_symbol__100, S_collectN___);
				leftA_symbol__99 = A_symbol__101;
			} catch (InvalidValueException e) {
				leftA_symbol__99 = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__101 = leftA_symbol__99;
			Object rightA_symbol__99;
			try {
				
				Object A_symbol__102 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				
				Object A_symbol__103 = IP_LoopExp_body.evaluate(evaluator, T_pivot__OCLExpression, self, P_LoopExp_body);
				
				Object A_symbol__104 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol__103, P_TypedElement_type);
				
				DomainType static_A_symbol__105 = valueFactory.typeOf(A_symbol__102, A_symbol__104);
				LibraryBinaryOperation dynamic_A_symbol__105 = (LibraryBinaryOperation)static_A_symbol__105.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Object A_symbol__105 = dynamic_A_symbol__105.evaluate(evaluator, T_Boolean, A_symbol__102, A_symbol__104);
				rightA_symbol__99 = A_symbol__105;
			} catch (InvalidValueException e) {
				rightA_symbol__99 = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__105 = rightA_symbol__99;
			DomainType static_A_symbol__99 = valueFactory.typeOf(A_symbol__101);
			LibraryBinaryOperation dynamic_A_symbol__99 = (LibraryBinaryOperation)static_A_symbol__99.lookupImplementation(standardLibrary, O_Boolean_implies);
			Object A_symbol__99 = dynamic_A_symbol__99.evaluate(evaluator, T_Boolean, A_symbol__101, A_symbol__105);
			return A_symbol__99;
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
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Object self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final @NonNull ExecutorType T_String = OCLstdlibTables.Types._String;
			final @NonNull ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final @NonNull LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final @NonNull Object S_collect = "collect";
			final @NonNull ExecutorOperation O_Boolean_or = OCLstdlibTables.Operations._Boolean__or;
			final @NonNull ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
			final @NonNull ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final @NonNull ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final @NonNull LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final @NonNull ExecutorType T_pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final @NonNull ExecutorProperty P_CallExp_source = PivotTables.Properties._CallExp__source;
			final @NonNull LibraryProperty IP_CallExp_source = P_CallExp_source.getImplementation();
			final @NonNull Object T_Metaclass_pivot__SequenceType_ = valueFactory.createTypeValue(PivotTables.Types._SequenceType);
			final @NonNull Object T_Metaclass_pivot__OrderedSetType_ = valueFactory.createTypeValue(PivotTables.Types._OrderedSetType);
			final @NonNull Object T_Metaclass_pivot__BagType_ = valueFactory.createTypeValue(PivotTables.Types._BagType);
			
			Object leftA_symbol__106;
			try {
				
				Object A_symbol__107 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol__108 = valueFactory.typeOf(A_symbol__107, S_collect);
				LibraryBinaryOperation dynamic_A_symbol__108 = (LibraryBinaryOperation)static_A_symbol__108.lookupImplementation(standardLibrary, O_String__eq_);
				Object A_symbol__108 = dynamic_A_symbol__108.evaluate(evaluator, T_Boolean, A_symbol__107, S_collect);
				leftA_symbol__106 = A_symbol__108;
			} catch (InvalidValueException e) {
				leftA_symbol__106 = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__108 = leftA_symbol__106;
			Object rightA_symbol__106;
			try {
					Object leftA_symbol__109;
					try {
						
						Object A_symbol__110 = IP_CallExp_source.evaluate(evaluator, T_pivot__OCLExpression, self, P_CallExp_source);
						
						Object A_symbol__111 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol__110, P_TypedElement_type);
						
						DomainType static_A_symbol__112 = valueFactory.typeOf(A_symbol__111);
						LibraryBinaryOperation dynamic_A_symbol__112 = (LibraryBinaryOperation)static_A_symbol__112.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Object A_symbol__112 = dynamic_A_symbol__112.evaluate(evaluator, T_Boolean, A_symbol__111, T_Metaclass_pivot__SequenceType_);
						leftA_symbol__109 = A_symbol__112;
					} catch (InvalidValueException e) {
						leftA_symbol__109 = valueFactory.createInvalidValue(e);
					}
					Object A_symbol__112 = leftA_symbol__109;
					Object rightA_symbol__109;
					try {
						
						Object A_symbol__113 = IP_CallExp_source.evaluate(evaluator, T_pivot__OCLExpression, self, P_CallExp_source);
						
						Object A_symbol__114 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol__113, P_TypedElement_type);
						
						DomainType static_A_symbol__115 = valueFactory.typeOf(A_symbol__114);
						LibraryBinaryOperation dynamic_A_symbol__115 = (LibraryBinaryOperation)static_A_symbol__115.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Object A_symbol__115 = dynamic_A_symbol__115.evaluate(evaluator, T_Boolean, A_symbol__114, T_Metaclass_pivot__OrderedSetType_);
						rightA_symbol__109 = A_symbol__115;
					} catch (InvalidValueException e) {
						rightA_symbol__109 = valueFactory.createInvalidValue(e);
					}
					Object A_symbol__115 = rightA_symbol__109;
					DomainType static_A_symbol__109 = valueFactory.typeOf(A_symbol__112);
					LibraryBinaryOperation dynamic_A_symbol__109 = (LibraryBinaryOperation)static_A_symbol__109.lookupImplementation(standardLibrary, O_Boolean_or);
					Object A_symbol__109 = dynamic_A_symbol__109.evaluate(evaluator, T_Boolean, A_symbol__112, A_symbol__115);
				Object A_symbol__116;
				if (ValuesUtil.isTrue(A_symbol__109)) {
					
					Object A_symbol__117 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
					
					DomainType static_A_symbol__118 = valueFactory.typeOf(A_symbol__117);
					LibraryBinaryOperation dynamic_A_symbol__118 = (LibraryBinaryOperation)static_A_symbol__118.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Object A_symbol__118 = dynamic_A_symbol__118.evaluate(evaluator, T_Boolean, A_symbol__117, T_Metaclass_pivot__SequenceType_);
					A_symbol__116 = A_symbol__118;
				}
				else if (ValuesUtil.isFalse(A_symbol__109)) {
					
					Object A_symbol__119 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
					
					DomainType static_A_symbol__120 = valueFactory.typeOf(A_symbol__119);
					LibraryBinaryOperation dynamic_A_symbol__120 = (LibraryBinaryOperation)static_A_symbol__120.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Object A_symbol__120 = dynamic_A_symbol__120.evaluate(evaluator, T_Boolean, A_symbol__119, T_Metaclass_pivot__BagType_);
					A_symbol__116 = A_symbol__120;
				}
				else if (ValuesUtil.isNull(A_symbol__109)) {
					A_symbol__116 = valueFactory.throwInvalidValueException("null if condition");
				}
				else {
					A_symbol__116 = valueFactory.throwInvalidValueException("invalid if condition");
				}
				rightA_symbol__106 = A_symbol__116;
			} catch (InvalidValueException e) {
				rightA_symbol__106 = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__116 = rightA_symbol__106;
			DomainType static_A_symbol__106 = valueFactory.typeOf(A_symbol__108);
			LibraryBinaryOperation dynamic_A_symbol__106 = (LibraryBinaryOperation)static_A_symbol__106.lookupImplementation(standardLibrary, O_Boolean_implies);
			Object A_symbol__106 = dynamic_A_symbol__106.evaluate(evaluator, T_Boolean, A_symbol__108, A_symbol__116);
			return A_symbol__106;
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
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Object self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final @NonNull ExecutorType T_String = OCLstdlibTables.Types._String;
			final @NonNull ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final @NonNull LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final @NonNull Object S_exists = "exists";
			final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
			final @NonNull ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final @NonNull ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final @NonNull LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final @NonNull ExecutorType T_pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final @NonNull ExecutorProperty P_LoopExp_body = PivotTables.Properties._LoopExp__body;
			final @NonNull LibraryProperty IP_LoopExp_body = P_LoopExp_body.getImplementation();
			final @NonNull Object T_Metaclass_Boolean_ = valueFactory.createTypeValue(OCLstdlibTables.Types._Boolean);
			
			Object leftA_symbol__121;
			try {
				
				Object A_symbol__122 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol__123 = valueFactory.typeOf(A_symbol__122, S_exists);
				LibraryBinaryOperation dynamic_A_symbol__123 = (LibraryBinaryOperation)static_A_symbol__123.lookupImplementation(standardLibrary, O_String__eq_);
				Object A_symbol__123 = dynamic_A_symbol__123.evaluate(evaluator, T_Boolean, A_symbol__122, S_exists);
				leftA_symbol__121 = A_symbol__123;
			} catch (InvalidValueException e) {
				leftA_symbol__121 = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__123 = leftA_symbol__121;
			Object rightA_symbol__121;
			try {
				
				Object A_symbol__124 = IP_LoopExp_body.evaluate(evaluator, T_pivot__OCLExpression, self, P_LoopExp_body);
				
				Object A_symbol__125 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol__124, P_TypedElement_type);
				
				DomainType static_A_symbol__126 = valueFactory.typeOf(A_symbol__125, T_Metaclass_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol__126 = (LibraryBinaryOperation)static_A_symbol__126.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Object A_symbol__126 = dynamic_A_symbol__126.evaluate(evaluator, T_Boolean, A_symbol__125, T_Metaclass_Boolean_);
				rightA_symbol__121 = A_symbol__126;
			} catch (InvalidValueException e) {
				rightA_symbol__121 = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__126 = rightA_symbol__121;
			DomainType static_A_symbol__121 = valueFactory.typeOf(A_symbol__123);
			LibraryBinaryOperation dynamic_A_symbol__121 = (LibraryBinaryOperation)static_A_symbol__121.lookupImplementation(standardLibrary, O_Boolean_implies);
			Object A_symbol__121 = dynamic_A_symbol__121.evaluate(evaluator, T_Boolean, A_symbol__123, A_symbol__126);
			return A_symbol__121;
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
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Object self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final @NonNull ExecutorType T_String = OCLstdlibTables.Types._String;
			final @NonNull ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final @NonNull LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final @NonNull Object S_exists = "exists";
			final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
			final @NonNull ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final @NonNull ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final @NonNull LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final @NonNull Object T_Metaclass_Boolean_ = valueFactory.createTypeValue(OCLstdlibTables.Types._Boolean);
			
			Object leftA_symbol__127;
			try {
				
				Object A_symbol__128 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol__129 = valueFactory.typeOf(A_symbol__128, S_exists);
				LibraryBinaryOperation dynamic_A_symbol__129 = (LibraryBinaryOperation)static_A_symbol__129.lookupImplementation(standardLibrary, O_String__eq_);
				Object A_symbol__129 = dynamic_A_symbol__129.evaluate(evaluator, T_Boolean, A_symbol__128, S_exists);
				leftA_symbol__127 = A_symbol__129;
			} catch (InvalidValueException e) {
				leftA_symbol__127 = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__129 = leftA_symbol__127;
			Object rightA_symbol__127;
			try {
				
				Object A_symbol__130 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol__131 = valueFactory.typeOf(A_symbol__130, T_Metaclass_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol__131 = (LibraryBinaryOperation)static_A_symbol__131.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Object A_symbol__131 = dynamic_A_symbol__131.evaluate(evaluator, T_Boolean, A_symbol__130, T_Metaclass_Boolean_);
				rightA_symbol__127 = A_symbol__131;
			} catch (InvalidValueException e) {
				rightA_symbol__127 = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__131 = rightA_symbol__127;
			DomainType static_A_symbol__127 = valueFactory.typeOf(A_symbol__129);
			LibraryBinaryOperation dynamic_A_symbol__127 = (LibraryBinaryOperation)static_A_symbol__127.lookupImplementation(standardLibrary, O_Boolean_implies);
			Object A_symbol__127 = dynamic_A_symbol__127.evaluate(evaluator, T_Boolean, A_symbol__129, A_symbol__131);
			return A_symbol__127;
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
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Object self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final @NonNull ExecutorType T_String = OCLstdlibTables.Types._String;
			final @NonNull ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final @NonNull LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final @NonNull Object S_forAll = "forAll";
			final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
			final @NonNull ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final @NonNull ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final @NonNull LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final @NonNull ExecutorType T_pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final @NonNull ExecutorProperty P_LoopExp_body = PivotTables.Properties._LoopExp__body;
			final @NonNull LibraryProperty IP_LoopExp_body = P_LoopExp_body.getImplementation();
			final @NonNull Object T_Metaclass_Boolean_ = valueFactory.createTypeValue(OCLstdlibTables.Types._Boolean);
			
			Object leftA_symbol__132;
			try {
				
				Object A_symbol__133 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol__134 = valueFactory.typeOf(A_symbol__133, S_forAll);
				LibraryBinaryOperation dynamic_A_symbol__134 = (LibraryBinaryOperation)static_A_symbol__134.lookupImplementation(standardLibrary, O_String__eq_);
				Object A_symbol__134 = dynamic_A_symbol__134.evaluate(evaluator, T_Boolean, A_symbol__133, S_forAll);
				leftA_symbol__132 = A_symbol__134;
			} catch (InvalidValueException e) {
				leftA_symbol__132 = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__134 = leftA_symbol__132;
			Object rightA_symbol__132;
			try {
				
				Object A_symbol__135 = IP_LoopExp_body.evaluate(evaluator, T_pivot__OCLExpression, self, P_LoopExp_body);
				
				Object A_symbol__136 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol__135, P_TypedElement_type);
				
				DomainType static_A_symbol__137 = valueFactory.typeOf(A_symbol__136, T_Metaclass_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol__137 = (LibraryBinaryOperation)static_A_symbol__137.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Object A_symbol__137 = dynamic_A_symbol__137.evaluate(evaluator, T_Boolean, A_symbol__136, T_Metaclass_Boolean_);
				rightA_symbol__132 = A_symbol__137;
			} catch (InvalidValueException e) {
				rightA_symbol__132 = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__137 = rightA_symbol__132;
			DomainType static_A_symbol__132 = valueFactory.typeOf(A_symbol__134);
			LibraryBinaryOperation dynamic_A_symbol__132 = (LibraryBinaryOperation)static_A_symbol__132.lookupImplementation(standardLibrary, O_Boolean_implies);
			Object A_symbol__132 = dynamic_A_symbol__132.evaluate(evaluator, T_Boolean, A_symbol__134, A_symbol__137);
			return A_symbol__132;
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
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Object self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final @NonNull ExecutorType T_String = OCLstdlibTables.Types._String;
			final @NonNull ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final @NonNull LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final @NonNull Object S_forAll = "forAll";
			final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
			final @NonNull ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final @NonNull ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final @NonNull LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final @NonNull Object T_Metaclass_Boolean_ = valueFactory.createTypeValue(OCLstdlibTables.Types._Boolean);
			
			Object leftA_symbol__138;
			try {
				
				Object A_symbol__139 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol__140 = valueFactory.typeOf(A_symbol__139, S_forAll);
				LibraryBinaryOperation dynamic_A_symbol__140 = (LibraryBinaryOperation)static_A_symbol__140.lookupImplementation(standardLibrary, O_String__eq_);
				Object A_symbol__140 = dynamic_A_symbol__140.evaluate(evaluator, T_Boolean, A_symbol__139, S_forAll);
				leftA_symbol__138 = A_symbol__140;
			} catch (InvalidValueException e) {
				leftA_symbol__138 = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__140 = leftA_symbol__138;
			Object rightA_symbol__138;
			try {
				
				Object A_symbol__141 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol__142 = valueFactory.typeOf(A_symbol__141, T_Metaclass_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol__142 = (LibraryBinaryOperation)static_A_symbol__142.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Object A_symbol__142 = dynamic_A_symbol__142.evaluate(evaluator, T_Boolean, A_symbol__141, T_Metaclass_Boolean_);
				rightA_symbol__138 = A_symbol__142;
			} catch (InvalidValueException e) {
				rightA_symbol__138 = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__142 = rightA_symbol__138;
			DomainType static_A_symbol__138 = valueFactory.typeOf(A_symbol__140);
			LibraryBinaryOperation dynamic_A_symbol__138 = (LibraryBinaryOperation)static_A_symbol__138.lookupImplementation(standardLibrary, O_Boolean_implies);
			Object A_symbol__138 = dynamic_A_symbol__138.evaluate(evaluator, T_Boolean, A_symbol__140, A_symbol__142);
			return A_symbol__138;
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
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Object self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final @NonNull ExecutorType T_String = OCLstdlibTables.Types._String;
			final @NonNull ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final @NonNull LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final @NonNull Object S_isUnique = "isUnique";
			final @NonNull ExecutorOperation O_Real__eq_ = OCLstdlibTables.Operations._Real___eq_;
			final @NonNull ExecutorType T_Integer = OCLstdlibTables.Types._Integer;
			final @NonNull ExecutorOperation O_Collection_size = OCLstdlibTables.Operations._Collection__size;
			final @NonNull ExecutorType T_pivot__Variable = PivotTables.Types._Variable;
			final @NonNull DomainCollectionType T_OrderedSet_pivot__Variable_ = standardLibrary.getOrderedSetType(T_pivot__Variable, null, null);
			final @NonNull ExecutorProperty P_LoopExp_iterator = PivotTables.Properties._LoopExp__iterator;
			final @NonNull LibraryProperty IP_LoopExp_iterator = P_LoopExp_iterator.getImplementation();
			final @NonNull IntegerValue I_1 = valueFactory.integerValueOf(1);
			
			Object leftA_symbol__143;
			try {
				
				Object A_symbol__144 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol__145 = valueFactory.typeOf(A_symbol__144, S_isUnique);
				LibraryBinaryOperation dynamic_A_symbol__145 = (LibraryBinaryOperation)static_A_symbol__145.lookupImplementation(standardLibrary, O_String__eq_);
				Object A_symbol__145 = dynamic_A_symbol__145.evaluate(evaluator, T_Boolean, A_symbol__144, S_isUnique);
				leftA_symbol__143 = A_symbol__145;
			} catch (InvalidValueException e) {
				leftA_symbol__143 = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__145 = leftA_symbol__143;
			Object rightA_symbol__143;
			try {
				
				Object A_symbol__146 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol__147 = valueFactory.typeOf(A_symbol__146);
				LibraryUnaryOperation dynamic_A_symbol__147 = (LibraryUnaryOperation)static_A_symbol__147.lookupImplementation(standardLibrary, O_Collection_size);
				Object A_symbol__147 = dynamic_A_symbol__147.evaluate(evaluator, T_Integer, A_symbol__146);
				DomainType static_A_symbol__148 = valueFactory.typeOf(A_symbol__147, I_1);
				LibraryBinaryOperation dynamic_A_symbol__148 = (LibraryBinaryOperation)static_A_symbol__148.lookupImplementation(standardLibrary, O_Real__eq_);
				Object A_symbol__148 = dynamic_A_symbol__148.evaluate(evaluator, T_Boolean, A_symbol__147, I_1);
				rightA_symbol__143 = A_symbol__148;
			} catch (InvalidValueException e) {
				rightA_symbol__143 = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__148 = rightA_symbol__143;
			DomainType static_A_symbol__143 = valueFactory.typeOf(A_symbol__145);
			LibraryBinaryOperation dynamic_A_symbol__143 = (LibraryBinaryOperation)static_A_symbol__143.lookupImplementation(standardLibrary, O_Boolean_implies);
			Object A_symbol__143 = dynamic_A_symbol__143.evaluate(evaluator, T_Boolean, A_symbol__145, A_symbol__148);
			return A_symbol__143;
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
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Object self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final @NonNull ExecutorType T_String = OCLstdlibTables.Types._String;
			final @NonNull ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final @NonNull LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final @NonNull Object S_isUnique = "isUnique";
			final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
			final @NonNull ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final @NonNull ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final @NonNull LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final @NonNull Object T_Metaclass_Boolean_ = valueFactory.createTypeValue(OCLstdlibTables.Types._Boolean);
			
			Object leftA_symbol__149;
			try {
				
				Object A_symbol__150 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol__151 = valueFactory.typeOf(A_symbol__150, S_isUnique);
				LibraryBinaryOperation dynamic_A_symbol__151 = (LibraryBinaryOperation)static_A_symbol__151.lookupImplementation(standardLibrary, O_String__eq_);
				Object A_symbol__151 = dynamic_A_symbol__151.evaluate(evaluator, T_Boolean, A_symbol__150, S_isUnique);
				leftA_symbol__149 = A_symbol__151;
			} catch (InvalidValueException e) {
				leftA_symbol__149 = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__151 = leftA_symbol__149;
			Object rightA_symbol__149;
			try {
				
				Object A_symbol__152 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol__153 = valueFactory.typeOf(A_symbol__152, T_Metaclass_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol__153 = (LibraryBinaryOperation)static_A_symbol__153.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Object A_symbol__153 = dynamic_A_symbol__153.evaluate(evaluator, T_Boolean, A_symbol__152, T_Metaclass_Boolean_);
				rightA_symbol__149 = A_symbol__153;
			} catch (InvalidValueException e) {
				rightA_symbol__149 = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__153 = rightA_symbol__149;
			DomainType static_A_symbol__149 = valueFactory.typeOf(A_symbol__151);
			LibraryBinaryOperation dynamic_A_symbol__149 = (LibraryBinaryOperation)static_A_symbol__149.lookupImplementation(standardLibrary, O_Boolean_implies);
			Object A_symbol__149 = dynamic_A_symbol__149.evaluate(evaluator, T_Boolean, A_symbol__151, A_symbol__153);
			return A_symbol__149;
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
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Object self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Collection_forAll = OCLstdlibTables.Operations._Collection__1_forAll;
			final @NonNull ExecutorType T_pivot__Variable = PivotTables.Types._Variable;
			final @NonNull DomainCollectionType T_OrderedSet_pivot__Variable_ = standardLibrary.getOrderedSetType(T_pivot__Variable, null, null);
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
			final @NonNull Object T_Metaclass_pivot__CollectionType_ = valueFactory.createTypeValue(PivotTables.Types._CollectionType);
			
			
			Object A_symbol__154 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_pivot__Variable_, self, P_LoopExp_iterator);
			
			
			/** 
			 * Implementation of the iterator body.
			 */
			AbstractBinaryOperation body_A_symbol__155 = new AbstractBinaryOperation()
			{
			/*
			type = source.type.oclAsType(CollectionType).elementType
			*/
				public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, @NonNull Object sourceValue, @NonNull Object iterator1) throws InvalidValueException {
					final @NonNull Object V_1_ = iterator1;	// iterator: 1_
					
					Object A_symbol__156 = IP_TypedElement_type.evaluate(evaluator, T_Type, V_1_, P_TypedElement_type);
					
					
					Object A_symbol__157 = IP_CallExp_source.evaluate(evaluator, T_pivot__OCLExpression, self, P_CallExp_source);
					
					Object A_symbol__158 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol__157, P_TypedElement_type);
					
					DomainType static_A_symbol__159 = valueFactory.typeOf(A_symbol__158);
					LibraryBinaryOperation dynamic_A_symbol__159 = (LibraryBinaryOperation)static_A_symbol__159.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
					Object A_symbol__159 = dynamic_A_symbol__159.evaluate(evaluator, T_pivot__CollectionType, A_symbol__158, T_Metaclass_pivot__CollectionType_);
					Object A_symbol__160 = IP_CollectionType_elementType.evaluate(evaluator, T_Type, A_symbol__159, P_CollectionType_elementType);
					
					DomainType static_A_symbol__161 = valueFactory.typeOf(A_symbol__156, A_symbol__160);
					LibraryBinaryOperation dynamic_A_symbol__161 = (LibraryBinaryOperation)static_A_symbol__161.lookupImplementation(standardLibrary, O_OclAny__eq_);
					Object A_symbol__161 = dynamic_A_symbol__161.evaluate(evaluator, T_Boolean, A_symbol__156, A_symbol__160);
					return A_symbol__161;
				}
			};
			DomainType static_A_symbol__155 = valueFactory.typeOf(A_symbol__154);
			LibraryIteration dynamic_A_symbol__155 = (LibraryIteration)static_A_symbol__155.lookupImplementation(standardLibrary, O_Collection_forAll);
			Object acc_A_symbol__155 = dynamic_A_symbol__155.createAccumulatorValue(evaluator, T_Boolean, T_Boolean);
			ExecutorSingleIterationManager manager_A_symbol__155 = new ExecutorSingleIterationManager(evaluator, T_Boolean, body_A_symbol__155, (CollectionValue)A_symbol__154, acc_A_symbol__155);
			Object A_symbol__155 = dynamic_A_symbol__155.evaluateIteration(manager_A_symbol__155);
			return A_symbol__155;
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
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Object self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final @NonNull ExecutorType T_String = OCLstdlibTables.Types._String;
			final @NonNull ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final @NonNull LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final @NonNull Object S_one = "one";
			final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
			final @NonNull ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final @NonNull ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final @NonNull LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final @NonNull ExecutorType T_pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final @NonNull ExecutorProperty P_LoopExp_body = PivotTables.Properties._LoopExp__body;
			final @NonNull LibraryProperty IP_LoopExp_body = P_LoopExp_body.getImplementation();
			final @NonNull Object T_Metaclass_Boolean_ = valueFactory.createTypeValue(OCLstdlibTables.Types._Boolean);
			
			Object leftA_symbol__162;
			try {
				
				Object A_symbol__163 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol__164 = valueFactory.typeOf(A_symbol__163, S_one);
				LibraryBinaryOperation dynamic_A_symbol__164 = (LibraryBinaryOperation)static_A_symbol__164.lookupImplementation(standardLibrary, O_String__eq_);
				Object A_symbol__164 = dynamic_A_symbol__164.evaluate(evaluator, T_Boolean, A_symbol__163, S_one);
				leftA_symbol__162 = A_symbol__164;
			} catch (InvalidValueException e) {
				leftA_symbol__162 = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__164 = leftA_symbol__162;
			Object rightA_symbol__162;
			try {
				
				Object A_symbol__165 = IP_LoopExp_body.evaluate(evaluator, T_pivot__OCLExpression, self, P_LoopExp_body);
				
				Object A_symbol__166 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol__165, P_TypedElement_type);
				
				DomainType static_A_symbol__167 = valueFactory.typeOf(A_symbol__166, T_Metaclass_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol__167 = (LibraryBinaryOperation)static_A_symbol__167.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Object A_symbol__167 = dynamic_A_symbol__167.evaluate(evaluator, T_Boolean, A_symbol__166, T_Metaclass_Boolean_);
				rightA_symbol__162 = A_symbol__167;
			} catch (InvalidValueException e) {
				rightA_symbol__162 = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__167 = rightA_symbol__162;
			DomainType static_A_symbol__162 = valueFactory.typeOf(A_symbol__164);
			LibraryBinaryOperation dynamic_A_symbol__162 = (LibraryBinaryOperation)static_A_symbol__162.lookupImplementation(standardLibrary, O_Boolean_implies);
			Object A_symbol__162 = dynamic_A_symbol__162.evaluate(evaluator, T_Boolean, A_symbol__164, A_symbol__167);
			return A_symbol__162;
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
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Object self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final @NonNull ExecutorType T_String = OCLstdlibTables.Types._String;
			final @NonNull ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final @NonNull LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final @NonNull Object S_one = "one";
			final @NonNull ExecutorOperation O_Real__eq_ = OCLstdlibTables.Operations._Real___eq_;
			final @NonNull ExecutorType T_Integer = OCLstdlibTables.Types._Integer;
			final @NonNull ExecutorOperation O_Collection_size = OCLstdlibTables.Operations._Collection__size;
			final @NonNull ExecutorType T_pivot__Variable = PivotTables.Types._Variable;
			final @NonNull DomainCollectionType T_OrderedSet_pivot__Variable_ = standardLibrary.getOrderedSetType(T_pivot__Variable, null, null);
			final @NonNull ExecutorProperty P_LoopExp_iterator = PivotTables.Properties._LoopExp__iterator;
			final @NonNull LibraryProperty IP_LoopExp_iterator = P_LoopExp_iterator.getImplementation();
			final @NonNull IntegerValue I_1 = valueFactory.integerValueOf(1);
			
			Object leftA_symbol__168;
			try {
				
				Object A_symbol__169 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol__170 = valueFactory.typeOf(A_symbol__169, S_one);
				LibraryBinaryOperation dynamic_A_symbol__170 = (LibraryBinaryOperation)static_A_symbol__170.lookupImplementation(standardLibrary, O_String__eq_);
				Object A_symbol__170 = dynamic_A_symbol__170.evaluate(evaluator, T_Boolean, A_symbol__169, S_one);
				leftA_symbol__168 = A_symbol__170;
			} catch (InvalidValueException e) {
				leftA_symbol__168 = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__170 = leftA_symbol__168;
			Object rightA_symbol__168;
			try {
				
				Object A_symbol__171 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol__172 = valueFactory.typeOf(A_symbol__171);
				LibraryUnaryOperation dynamic_A_symbol__172 = (LibraryUnaryOperation)static_A_symbol__172.lookupImplementation(standardLibrary, O_Collection_size);
				Object A_symbol__172 = dynamic_A_symbol__172.evaluate(evaluator, T_Integer, A_symbol__171);
				DomainType static_A_symbol__173 = valueFactory.typeOf(A_symbol__172, I_1);
				LibraryBinaryOperation dynamic_A_symbol__173 = (LibraryBinaryOperation)static_A_symbol__173.lookupImplementation(standardLibrary, O_Real__eq_);
				Object A_symbol__173 = dynamic_A_symbol__173.evaluate(evaluator, T_Boolean, A_symbol__172, I_1);
				rightA_symbol__168 = A_symbol__173;
			} catch (InvalidValueException e) {
				rightA_symbol__168 = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__173 = rightA_symbol__168;
			DomainType static_A_symbol__168 = valueFactory.typeOf(A_symbol__170);
			LibraryBinaryOperation dynamic_A_symbol__168 = (LibraryBinaryOperation)static_A_symbol__168.lookupImplementation(standardLibrary, O_Boolean_implies);
			Object A_symbol__168 = dynamic_A_symbol__168.evaluate(evaluator, T_Boolean, A_symbol__170, A_symbol__173);
			return A_symbol__168;
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
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Object self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final @NonNull ExecutorType T_String = OCLstdlibTables.Types._String;
			final @NonNull ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final @NonNull LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final @NonNull Object S_one = "one";
			final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
			final @NonNull ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final @NonNull ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final @NonNull LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final @NonNull Object T_Metaclass_Boolean_ = valueFactory.createTypeValue(OCLstdlibTables.Types._Boolean);
			
			Object leftA_symbol__174;
			try {
				
				Object A_symbol__175 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol__176 = valueFactory.typeOf(A_symbol__175, S_one);
				LibraryBinaryOperation dynamic_A_symbol__176 = (LibraryBinaryOperation)static_A_symbol__176.lookupImplementation(standardLibrary, O_String__eq_);
				Object A_symbol__176 = dynamic_A_symbol__176.evaluate(evaluator, T_Boolean, A_symbol__175, S_one);
				leftA_symbol__174 = A_symbol__176;
			} catch (InvalidValueException e) {
				leftA_symbol__174 = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__176 = leftA_symbol__174;
			Object rightA_symbol__174;
			try {
				
				Object A_symbol__177 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol__178 = valueFactory.typeOf(A_symbol__177, T_Metaclass_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol__178 = (LibraryBinaryOperation)static_A_symbol__178.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Object A_symbol__178 = dynamic_A_symbol__178.evaluate(evaluator, T_Boolean, A_symbol__177, T_Metaclass_Boolean_);
				rightA_symbol__174 = A_symbol__178;
			} catch (InvalidValueException e) {
				rightA_symbol__174 = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__178 = rightA_symbol__174;
			DomainType static_A_symbol__174 = valueFactory.typeOf(A_symbol__176);
			LibraryBinaryOperation dynamic_A_symbol__174 = (LibraryBinaryOperation)static_A_symbol__174.lookupImplementation(standardLibrary, O_Boolean_implies);
			Object A_symbol__174 = dynamic_A_symbol__174.evaluate(evaluator, T_Boolean, A_symbol__176, A_symbol__178);
			return A_symbol__174;
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
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Object self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final @NonNull ExecutorOperation O_Boolean_or = OCLstdlibTables.Operations._Boolean__or;
			final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final @NonNull ExecutorType T_String = OCLstdlibTables.Types._String;
			final @NonNull ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final @NonNull LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final @NonNull Object S_reject = "reject";
			final @NonNull Object S_select = "select";
			final @NonNull ExecutorOperation O_Real__eq_ = OCLstdlibTables.Operations._Real___eq_;
			final @NonNull ExecutorType T_Integer = OCLstdlibTables.Types._Integer;
			final @NonNull ExecutorOperation O_Collection_size = OCLstdlibTables.Operations._Collection__size;
			final @NonNull ExecutorType T_pivot__Variable = PivotTables.Types._Variable;
			final @NonNull DomainCollectionType T_OrderedSet_pivot__Variable_ = standardLibrary.getOrderedSetType(T_pivot__Variable, null, null);
			final @NonNull ExecutorProperty P_LoopExp_iterator = PivotTables.Properties._LoopExp__iterator;
			final @NonNull LibraryProperty IP_LoopExp_iterator = P_LoopExp_iterator.getImplementation();
			final @NonNull IntegerValue I_1 = valueFactory.integerValueOf(1);
			
			Object leftA_symbol__179;
			try {
				Object leftA_symbol__180;
				try {
					
					Object A_symbol__181 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
					
					DomainType static_A_symbol__182 = valueFactory.typeOf(A_symbol__181, S_reject);
					LibraryBinaryOperation dynamic_A_symbol__182 = (LibraryBinaryOperation)static_A_symbol__182.lookupImplementation(standardLibrary, O_String__eq_);
					Object A_symbol__182 = dynamic_A_symbol__182.evaluate(evaluator, T_Boolean, A_symbol__181, S_reject);
					leftA_symbol__180 = A_symbol__182;
				} catch (InvalidValueException e) {
					leftA_symbol__180 = valueFactory.createInvalidValue(e);
				}
				Object A_symbol__182 = leftA_symbol__180;
				Object rightA_symbol__180;
				try {
					
					Object A_symbol__183 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
					
					DomainType static_A_symbol__184 = valueFactory.typeOf(A_symbol__183, S_select);
					LibraryBinaryOperation dynamic_A_symbol__184 = (LibraryBinaryOperation)static_A_symbol__184.lookupImplementation(standardLibrary, O_String__eq_);
					Object A_symbol__184 = dynamic_A_symbol__184.evaluate(evaluator, T_Boolean, A_symbol__183, S_select);
					rightA_symbol__180 = A_symbol__184;
				} catch (InvalidValueException e) {
					rightA_symbol__180 = valueFactory.createInvalidValue(e);
				}
				Object A_symbol__184 = rightA_symbol__180;
				DomainType static_A_symbol__180 = valueFactory.typeOf(A_symbol__182);
				LibraryBinaryOperation dynamic_A_symbol__180 = (LibraryBinaryOperation)static_A_symbol__180.lookupImplementation(standardLibrary, O_Boolean_or);
				Object A_symbol__180 = dynamic_A_symbol__180.evaluate(evaluator, T_Boolean, A_symbol__182, A_symbol__184);
				leftA_symbol__179 = A_symbol__180;
			} catch (InvalidValueException e) {
				leftA_symbol__179 = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__180 = leftA_symbol__179;
			Object rightA_symbol__179;
			try {
				
				Object A_symbol__185 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol__186 = valueFactory.typeOf(A_symbol__185);
				LibraryUnaryOperation dynamic_A_symbol__186 = (LibraryUnaryOperation)static_A_symbol__186.lookupImplementation(standardLibrary, O_Collection_size);
				Object A_symbol__186 = dynamic_A_symbol__186.evaluate(evaluator, T_Integer, A_symbol__185);
				DomainType static_A_symbol__187 = valueFactory.typeOf(A_symbol__186, I_1);
				LibraryBinaryOperation dynamic_A_symbol__187 = (LibraryBinaryOperation)static_A_symbol__187.lookupImplementation(standardLibrary, O_Real__eq_);
				Object A_symbol__187 = dynamic_A_symbol__187.evaluate(evaluator, T_Boolean, A_symbol__186, I_1);
				rightA_symbol__179 = A_symbol__187;
			} catch (InvalidValueException e) {
				rightA_symbol__179 = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__187 = rightA_symbol__179;
			DomainType static_A_symbol__179 = valueFactory.typeOf(A_symbol__180);
			LibraryBinaryOperation dynamic_A_symbol__179 = (LibraryBinaryOperation)static_A_symbol__179.lookupImplementation(standardLibrary, O_Boolean_implies);
			Object A_symbol__179 = dynamic_A_symbol__179.evaluate(evaluator, T_Boolean, A_symbol__180, A_symbol__187);
			return A_symbol__179;
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
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Object self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final @NonNull ExecutorOperation O_Boolean_or = OCLstdlibTables.Operations._Boolean__or;
			final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final @NonNull ExecutorType T_String = OCLstdlibTables.Types._String;
			final @NonNull ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final @NonNull LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final @NonNull Object S_reject = "reject";
			final @NonNull Object S_select = "select";
			final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
			final @NonNull ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final @NonNull ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final @NonNull LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final @NonNull Object T_Metaclass_Boolean_ = valueFactory.createTypeValue(OCLstdlibTables.Types._Boolean);
			
			Object leftA_symbol__188;
			try {
				Object leftA_symbol__189;
				try {
					
					Object A_symbol__190 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
					
					DomainType static_A_symbol__191 = valueFactory.typeOf(A_symbol__190, S_reject);
					LibraryBinaryOperation dynamic_A_symbol__191 = (LibraryBinaryOperation)static_A_symbol__191.lookupImplementation(standardLibrary, O_String__eq_);
					Object A_symbol__191 = dynamic_A_symbol__191.evaluate(evaluator, T_Boolean, A_symbol__190, S_reject);
					leftA_symbol__189 = A_symbol__191;
				} catch (InvalidValueException e) {
					leftA_symbol__189 = valueFactory.createInvalidValue(e);
				}
				Object A_symbol__191 = leftA_symbol__189;
				Object rightA_symbol__189;
				try {
					
					Object A_symbol__192 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
					
					DomainType static_A_symbol__193 = valueFactory.typeOf(A_symbol__192, S_select);
					LibraryBinaryOperation dynamic_A_symbol__193 = (LibraryBinaryOperation)static_A_symbol__193.lookupImplementation(standardLibrary, O_String__eq_);
					Object A_symbol__193 = dynamic_A_symbol__193.evaluate(evaluator, T_Boolean, A_symbol__192, S_select);
					rightA_symbol__189 = A_symbol__193;
				} catch (InvalidValueException e) {
					rightA_symbol__189 = valueFactory.createInvalidValue(e);
				}
				Object A_symbol__193 = rightA_symbol__189;
				DomainType static_A_symbol__189 = valueFactory.typeOf(A_symbol__191);
				LibraryBinaryOperation dynamic_A_symbol__189 = (LibraryBinaryOperation)static_A_symbol__189.lookupImplementation(standardLibrary, O_Boolean_or);
				Object A_symbol__189 = dynamic_A_symbol__189.evaluate(evaluator, T_Boolean, A_symbol__191, A_symbol__193);
				leftA_symbol__188 = A_symbol__189;
			} catch (InvalidValueException e) {
				leftA_symbol__188 = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__189 = leftA_symbol__188;
			Object rightA_symbol__188;
			try {
				
				Object A_symbol__194 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol__195 = valueFactory.typeOf(A_symbol__194, T_Metaclass_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol__195 = (LibraryBinaryOperation)static_A_symbol__195.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Object A_symbol__195 = dynamic_A_symbol__195.evaluate(evaluator, T_Boolean, A_symbol__194, T_Metaclass_Boolean_);
				rightA_symbol__188 = A_symbol__195;
			} catch (InvalidValueException e) {
				rightA_symbol__188 = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__195 = rightA_symbol__188;
			DomainType static_A_symbol__188 = valueFactory.typeOf(A_symbol__189);
			LibraryBinaryOperation dynamic_A_symbol__188 = (LibraryBinaryOperation)static_A_symbol__188.lookupImplementation(standardLibrary, O_Boolean_implies);
			Object A_symbol__188 = dynamic_A_symbol__188.evaluate(evaluator, T_Boolean, A_symbol__189, A_symbol__195);
			return A_symbol__188;
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
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Object self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final @NonNull ExecutorOperation O_Boolean_or = OCLstdlibTables.Operations._Boolean__or;
			final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final @NonNull ExecutorType T_String = OCLstdlibTables.Types._String;
			final @NonNull ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final @NonNull LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final @NonNull Object S_reject = "reject";
			final @NonNull Object S_select = "select";
			final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
			final @NonNull ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final @NonNull ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final @NonNull LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final @NonNull ExecutorType T_pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final @NonNull ExecutorProperty P_CallExp_source = PivotTables.Properties._CallExp__source;
			final @NonNull LibraryProperty IP_CallExp_source = P_CallExp_source.getImplementation();
			
			Object leftA_symbol__196;
			try {
				Object leftA_symbol__197;
				try {
					
					Object A_symbol__198 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
					
					DomainType static_A_symbol__199 = valueFactory.typeOf(A_symbol__198, S_reject);
					LibraryBinaryOperation dynamic_A_symbol__199 = (LibraryBinaryOperation)static_A_symbol__199.lookupImplementation(standardLibrary, O_String__eq_);
					Object A_symbol__199 = dynamic_A_symbol__199.evaluate(evaluator, T_Boolean, A_symbol__198, S_reject);
					leftA_symbol__197 = A_symbol__199;
				} catch (InvalidValueException e) {
					leftA_symbol__197 = valueFactory.createInvalidValue(e);
				}
				Object A_symbol__199 = leftA_symbol__197;
				Object rightA_symbol__197;
				try {
					
					Object A_symbol__200 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
					
					DomainType static_A_symbol__201 = valueFactory.typeOf(A_symbol__200, S_select);
					LibraryBinaryOperation dynamic_A_symbol__201 = (LibraryBinaryOperation)static_A_symbol__201.lookupImplementation(standardLibrary, O_String__eq_);
					Object A_symbol__201 = dynamic_A_symbol__201.evaluate(evaluator, T_Boolean, A_symbol__200, S_select);
					rightA_symbol__197 = A_symbol__201;
				} catch (InvalidValueException e) {
					rightA_symbol__197 = valueFactory.createInvalidValue(e);
				}
				Object A_symbol__201 = rightA_symbol__197;
				DomainType static_A_symbol__197 = valueFactory.typeOf(A_symbol__199);
				LibraryBinaryOperation dynamic_A_symbol__197 = (LibraryBinaryOperation)static_A_symbol__197.lookupImplementation(standardLibrary, O_Boolean_or);
				Object A_symbol__197 = dynamic_A_symbol__197.evaluate(evaluator, T_Boolean, A_symbol__199, A_symbol__201);
				leftA_symbol__196 = A_symbol__197;
			} catch (InvalidValueException e) {
				leftA_symbol__196 = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__197 = leftA_symbol__196;
			Object rightA_symbol__196;
			try {
				
				Object A_symbol__202 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				
				Object A_symbol__203 = IP_CallExp_source.evaluate(evaluator, T_pivot__OCLExpression, self, P_CallExp_source);
				
				Object A_symbol__204 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol__203, P_TypedElement_type);
				
				DomainType static_A_symbol__205 = valueFactory.typeOf(A_symbol__202, A_symbol__204);
				LibraryBinaryOperation dynamic_A_symbol__205 = (LibraryBinaryOperation)static_A_symbol__205.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Object A_symbol__205 = dynamic_A_symbol__205.evaluate(evaluator, T_Boolean, A_symbol__202, A_symbol__204);
				rightA_symbol__196 = A_symbol__205;
			} catch (InvalidValueException e) {
				rightA_symbol__196 = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__205 = rightA_symbol__196;
			DomainType static_A_symbol__196 = valueFactory.typeOf(A_symbol__197);
			LibraryBinaryOperation dynamic_A_symbol__196 = (LibraryBinaryOperation)static_A_symbol__196.lookupImplementation(standardLibrary, O_Boolean_implies);
			Object A_symbol__196 = dynamic_A_symbol__196.evaluate(evaluator, T_Boolean, A_symbol__197, A_symbol__205);
			return A_symbol__196;
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
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Object self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final @NonNull ExecutorType T_String = OCLstdlibTables.Types._String;
			final @NonNull ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final @NonNull LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final @NonNull Object S_sortedBy = "sortedBy";
			final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
			final @NonNull ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final @NonNull ExecutorProperty P_CollectionType_elementType = PivotTables.Properties._CollectionType__elementType;
			final @NonNull LibraryProperty IP_CollectionType_elementType = P_CollectionType_elementType.getImplementation();
			final @NonNull ExecutorType T_pivot__CollectionType = PivotTables.Types._CollectionType;
			final @NonNull ExecutorOperation O_OclAny_oclAsType = OCLstdlibTables.Operations._OclAny__oclAsType;
			final @NonNull ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final @NonNull LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final @NonNull Object T_Metaclass_pivot__CollectionType_ = valueFactory.createTypeValue(PivotTables.Types._CollectionType);
			final @NonNull ExecutorType T_pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final @NonNull ExecutorProperty P_LoopExp_body = PivotTables.Properties._LoopExp__body;
			final @NonNull LibraryProperty IP_LoopExp_body = P_LoopExp_body.getImplementation();
			
			Object leftA_symbol__206;
			try {
				
				Object A_symbol__207 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol__208 = valueFactory.typeOf(A_symbol__207, S_sortedBy);
				LibraryBinaryOperation dynamic_A_symbol__208 = (LibraryBinaryOperation)static_A_symbol__208.lookupImplementation(standardLibrary, O_String__eq_);
				Object A_symbol__208 = dynamic_A_symbol__208.evaluate(evaluator, T_Boolean, A_symbol__207, S_sortedBy);
				leftA_symbol__206 = A_symbol__208;
			} catch (InvalidValueException e) {
				leftA_symbol__206 = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__208 = leftA_symbol__206;
			Object rightA_symbol__206;
			try {
				
				Object A_symbol__209 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol__210 = valueFactory.typeOf(A_symbol__209);
				LibraryBinaryOperation dynamic_A_symbol__210 = (LibraryBinaryOperation)static_A_symbol__210.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Object A_symbol__210 = dynamic_A_symbol__210.evaluate(evaluator, T_pivot__CollectionType, A_symbol__209, T_Metaclass_pivot__CollectionType_);
				Object A_symbol__211 = IP_CollectionType_elementType.evaluate(evaluator, T_Type, A_symbol__210, P_CollectionType_elementType);
				
				
				Object A_symbol__212 = IP_LoopExp_body.evaluate(evaluator, T_pivot__OCLExpression, self, P_LoopExp_body);
				
				Object A_symbol__213 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol__212, P_TypedElement_type);
				
				DomainType static_A_symbol__214 = valueFactory.typeOf(A_symbol__213);
				LibraryBinaryOperation dynamic_A_symbol__214 = (LibraryBinaryOperation)static_A_symbol__214.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Object A_symbol__214 = dynamic_A_symbol__214.evaluate(evaluator, T_pivot__CollectionType, A_symbol__213, T_Metaclass_pivot__CollectionType_);
				Object A_symbol__215 = IP_CollectionType_elementType.evaluate(evaluator, T_Type, A_symbol__214, P_CollectionType_elementType);
				
				DomainType static_A_symbol__216 = valueFactory.typeOf(A_symbol__211, A_symbol__215);
				LibraryBinaryOperation dynamic_A_symbol__216 = (LibraryBinaryOperation)static_A_symbol__216.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Object A_symbol__216 = dynamic_A_symbol__216.evaluate(evaluator, T_Boolean, A_symbol__211, A_symbol__215);
				rightA_symbol__206 = A_symbol__216;
			} catch (InvalidValueException e) {
				rightA_symbol__206 = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__216 = rightA_symbol__206;
			DomainType static_A_symbol__206 = valueFactory.typeOf(A_symbol__208);
			LibraryBinaryOperation dynamic_A_symbol__206 = (LibraryBinaryOperation)static_A_symbol__206.lookupImplementation(standardLibrary, O_Boolean_implies);
			Object A_symbol__206 = dynamic_A_symbol__206.evaluate(evaluator, T_Boolean, A_symbol__208, A_symbol__216);
			return A_symbol__206;
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
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Object self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final @NonNull ExecutorType T_String = OCLstdlibTables.Types._String;
			final @NonNull ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final @NonNull LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final @NonNull Object S_sortedBy = "sortedBy";
			final @NonNull ExecutorOperation O_Real__eq_ = OCLstdlibTables.Operations._Real___eq_;
			final @NonNull ExecutorType T_Integer = OCLstdlibTables.Types._Integer;
			final @NonNull ExecutorOperation O_Collection_size = OCLstdlibTables.Operations._Collection__size;
			final @NonNull ExecutorType T_pivot__Variable = PivotTables.Types._Variable;
			final @NonNull DomainCollectionType T_OrderedSet_pivot__Variable_ = standardLibrary.getOrderedSetType(T_pivot__Variable, null, null);
			final @NonNull ExecutorProperty P_LoopExp_iterator = PivotTables.Properties._LoopExp__iterator;
			final @NonNull LibraryProperty IP_LoopExp_iterator = P_LoopExp_iterator.getImplementation();
			final @NonNull IntegerValue I_1 = valueFactory.integerValueOf(1);
			
			Object leftA_symbol__217;
			try {
				
				Object A_symbol__218 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol__219 = valueFactory.typeOf(A_symbol__218, S_sortedBy);
				LibraryBinaryOperation dynamic_A_symbol__219 = (LibraryBinaryOperation)static_A_symbol__219.lookupImplementation(standardLibrary, O_String__eq_);
				Object A_symbol__219 = dynamic_A_symbol__219.evaluate(evaluator, T_Boolean, A_symbol__218, S_sortedBy);
				leftA_symbol__217 = A_symbol__219;
			} catch (InvalidValueException e) {
				leftA_symbol__217 = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__219 = leftA_symbol__217;
			Object rightA_symbol__217;
			try {
				
				Object A_symbol__220 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol__221 = valueFactory.typeOf(A_symbol__220);
				LibraryUnaryOperation dynamic_A_symbol__221 = (LibraryUnaryOperation)static_A_symbol__221.lookupImplementation(standardLibrary, O_Collection_size);
				Object A_symbol__221 = dynamic_A_symbol__221.evaluate(evaluator, T_Integer, A_symbol__220);
				DomainType static_A_symbol__222 = valueFactory.typeOf(A_symbol__221, I_1);
				LibraryBinaryOperation dynamic_A_symbol__222 = (LibraryBinaryOperation)static_A_symbol__222.lookupImplementation(standardLibrary, O_Real__eq_);
				Object A_symbol__222 = dynamic_A_symbol__222.evaluate(evaluator, T_Boolean, A_symbol__221, I_1);
				rightA_symbol__217 = A_symbol__222;
			} catch (InvalidValueException e) {
				rightA_symbol__217 = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__222 = rightA_symbol__217;
			DomainType static_A_symbol__217 = valueFactory.typeOf(A_symbol__219);
			LibraryBinaryOperation dynamic_A_symbol__217 = (LibraryBinaryOperation)static_A_symbol__217.lookupImplementation(standardLibrary, O_Boolean_implies);
			Object A_symbol__217 = dynamic_A_symbol__217.evaluate(evaluator, T_Boolean, A_symbol__219, A_symbol__222);
			return A_symbol__217;
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
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Object self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
			final @NonNull ExecutorType T_String = OCLstdlibTables.Types._String;
			final @NonNull ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final @NonNull LibraryProperty IP_NamedElement_name = P_NamedElement_name.getImplementation();
			final @NonNull Object S_sortedBy = "sortedBy";
			final @NonNull ExecutorOperation O_Boolean_or = OCLstdlibTables.Operations._Boolean__or;
			final @NonNull ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
			final @NonNull ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final @NonNull ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final @NonNull LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final @NonNull ExecutorType T_pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final @NonNull ExecutorProperty P_CallExp_source = PivotTables.Properties._CallExp__source;
			final @NonNull LibraryProperty IP_CallExp_source = P_CallExp_source.getImplementation();
			final @NonNull Object T_Metaclass_pivot__SequenceType_ = valueFactory.createTypeValue(PivotTables.Types._SequenceType);
			final @NonNull Object T_Metaclass_pivot__BagType_ = valueFactory.createTypeValue(PivotTables.Types._BagType);
			final @NonNull Object T_Metaclass_pivot__OrderedSetType_ = valueFactory.createTypeValue(PivotTables.Types._OrderedSetType);
			
			Object leftA_symbol__223;
			try {
				
				Object A_symbol__224 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol__225 = valueFactory.typeOf(A_symbol__224, S_sortedBy);
				LibraryBinaryOperation dynamic_A_symbol__225 = (LibraryBinaryOperation)static_A_symbol__225.lookupImplementation(standardLibrary, O_String__eq_);
				Object A_symbol__225 = dynamic_A_symbol__225.evaluate(evaluator, T_Boolean, A_symbol__224, S_sortedBy);
				leftA_symbol__223 = A_symbol__225;
			} catch (InvalidValueException e) {
				leftA_symbol__223 = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__225 = leftA_symbol__223;
			Object rightA_symbol__223;
			try {
					Object leftA_symbol__226;
					try {
						
						Object A_symbol__227 = IP_CallExp_source.evaluate(evaluator, T_pivot__OCLExpression, self, P_CallExp_source);
						
						Object A_symbol__228 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol__227, P_TypedElement_type);
						
						DomainType static_A_symbol__229 = valueFactory.typeOf(A_symbol__228);
						LibraryBinaryOperation dynamic_A_symbol__229 = (LibraryBinaryOperation)static_A_symbol__229.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Object A_symbol__229 = dynamic_A_symbol__229.evaluate(evaluator, T_Boolean, A_symbol__228, T_Metaclass_pivot__SequenceType_);
						leftA_symbol__226 = A_symbol__229;
					} catch (InvalidValueException e) {
						leftA_symbol__226 = valueFactory.createInvalidValue(e);
					}
					Object A_symbol__229 = leftA_symbol__226;
					Object rightA_symbol__226;
					try {
						
						Object A_symbol__230 = IP_CallExp_source.evaluate(evaluator, T_pivot__OCLExpression, self, P_CallExp_source);
						
						Object A_symbol__231 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol__230, P_TypedElement_type);
						
						DomainType static_A_symbol__232 = valueFactory.typeOf(A_symbol__231);
						LibraryBinaryOperation dynamic_A_symbol__232 = (LibraryBinaryOperation)static_A_symbol__232.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Object A_symbol__232 = dynamic_A_symbol__232.evaluate(evaluator, T_Boolean, A_symbol__231, T_Metaclass_pivot__BagType_);
						rightA_symbol__226 = A_symbol__232;
					} catch (InvalidValueException e) {
						rightA_symbol__226 = valueFactory.createInvalidValue(e);
					}
					Object A_symbol__232 = rightA_symbol__226;
					DomainType static_A_symbol__226 = valueFactory.typeOf(A_symbol__229);
					LibraryBinaryOperation dynamic_A_symbol__226 = (LibraryBinaryOperation)static_A_symbol__226.lookupImplementation(standardLibrary, O_Boolean_or);
					Object A_symbol__226 = dynamic_A_symbol__226.evaluate(evaluator, T_Boolean, A_symbol__229, A_symbol__232);
				Object A_symbol__233;
				if (ValuesUtil.isTrue(A_symbol__226)) {
					
					Object A_symbol__234 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
					
					DomainType static_A_symbol__235 = valueFactory.typeOf(A_symbol__234);
					LibraryBinaryOperation dynamic_A_symbol__235 = (LibraryBinaryOperation)static_A_symbol__235.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Object A_symbol__235 = dynamic_A_symbol__235.evaluate(evaluator, T_Boolean, A_symbol__234, T_Metaclass_pivot__SequenceType_);
					A_symbol__233 = A_symbol__235;
				}
				else if (ValuesUtil.isFalse(A_symbol__226)) {
					
					Object A_symbol__236 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
					
					DomainType static_A_symbol__237 = valueFactory.typeOf(A_symbol__236);
					LibraryBinaryOperation dynamic_A_symbol__237 = (LibraryBinaryOperation)static_A_symbol__237.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Object A_symbol__237 = dynamic_A_symbol__237.evaluate(evaluator, T_Boolean, A_symbol__236, T_Metaclass_pivot__OrderedSetType_);
					A_symbol__233 = A_symbol__237;
				}
				else if (ValuesUtil.isNull(A_symbol__226)) {
					A_symbol__233 = valueFactory.throwInvalidValueException("null if condition");
				}
				else {
					A_symbol__233 = valueFactory.throwInvalidValueException("invalid if condition");
				}
				rightA_symbol__223 = A_symbol__233;
			} catch (InvalidValueException e) {
				rightA_symbol__223 = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__233 = rightA_symbol__223;
			DomainType static_A_symbol__223 = valueFactory.typeOf(A_symbol__225);
			LibraryBinaryOperation dynamic_A_symbol__223 = (LibraryBinaryOperation)static_A_symbol__223.lookupImplementation(standardLibrary, O_Boolean_implies);
			Object A_symbol__223 = dynamic_A_symbol__223.evaluate(evaluator, T_Boolean, A_symbol__225, A_symbol__233);
			return A_symbol__223;
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
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Object self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull BooleanValue True = valueFactory.getTrue();
			
			
			return True;
		}
	}
}

