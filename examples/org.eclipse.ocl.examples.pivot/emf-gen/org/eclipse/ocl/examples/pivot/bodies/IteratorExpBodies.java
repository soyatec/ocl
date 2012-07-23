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
			
			Value leftA_symbol_90;
			try {
				
				Value A_symbol_91 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_92 = valueFactory.typeOf(A_symbol_91, S_any);
				LibraryBinaryOperation dynamic_A_symbol_92 = (LibraryBinaryOperation)static_A_symbol_92.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_92 = dynamic_A_symbol_92.evaluate(evaluator, T_Boolean, A_symbol_91, S_any);
				leftA_symbol_90 = A_symbol_92;
			} catch (InvalidValueException e) {
				leftA_symbol_90 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_92 = leftA_symbol_90;
			Value rightA_symbol_90;
			try {
				
				Value A_symbol_93 = IP_LoopExp_body.evaluate(evaluator, T_pivot__OCLExpression, self, P_LoopExp_body);
				
				Value A_symbol_94 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_93, P_TypedElement_type);
				
				DomainType static_A_symbol_95 = valueFactory.typeOf(A_symbol_94, S_Boolean);
				LibraryBinaryOperation dynamic_A_symbol_95 = (LibraryBinaryOperation)static_A_symbol_95.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_95 = dynamic_A_symbol_95.evaluate(evaluator, T_Boolean, A_symbol_94, S_Boolean);
				rightA_symbol_90 = A_symbol_95;
			} catch (InvalidValueException e) {
				rightA_symbol_90 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_95 = rightA_symbol_90;
			DomainType static_A_symbol_90 = valueFactory.typeOf(A_symbol_92);
			LibraryBinaryOperation dynamic_A_symbol_90 = (LibraryBinaryOperation)static_A_symbol_90.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_90 = dynamic_A_symbol_90.evaluate(evaluator, T_Boolean, A_symbol_92, A_symbol_95);
			return A_symbol_90;
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
			
			Value leftA_symbol_96;
			try {
				
				Value A_symbol_97 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_98 = valueFactory.typeOf(A_symbol_97, S_any);
				LibraryBinaryOperation dynamic_A_symbol_98 = (LibraryBinaryOperation)static_A_symbol_98.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_98 = dynamic_A_symbol_98.evaluate(evaluator, T_Boolean, A_symbol_97, S_any);
				leftA_symbol_96 = A_symbol_98;
			} catch (InvalidValueException e) {
				leftA_symbol_96 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_98 = leftA_symbol_96;
			Value rightA_symbol_96;
			try {
				
				Value A_symbol_99 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_100 = valueFactory.typeOf(A_symbol_99);
				LibraryUnaryOperation dynamic_A_symbol_100 = (LibraryUnaryOperation)static_A_symbol_100.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_100 = dynamic_A_symbol_100.evaluate(evaluator, T_Integer, A_symbol_99);
				DomainType static_A_symbol_101 = valueFactory.typeOf(A_symbol_100, I_1);
				LibraryBinaryOperation dynamic_A_symbol_101 = (LibraryBinaryOperation)static_A_symbol_101.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_101 = dynamic_A_symbol_101.evaluate(evaluator, T_Boolean, A_symbol_100, I_1);
				rightA_symbol_96 = A_symbol_101;
			} catch (InvalidValueException e) {
				rightA_symbol_96 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_101 = rightA_symbol_96;
			DomainType static_A_symbol_96 = valueFactory.typeOf(A_symbol_98);
			LibraryBinaryOperation dynamic_A_symbol_96 = (LibraryBinaryOperation)static_A_symbol_96.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_96 = dynamic_A_symbol_96.evaluate(evaluator, T_Boolean, A_symbol_98, A_symbol_101);
			return A_symbol_96;
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
			
			Value leftA_symbol_102;
			try {
				
				Value A_symbol_103 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_104 = valueFactory.typeOf(A_symbol_103, S_any);
				LibraryBinaryOperation dynamic_A_symbol_104 = (LibraryBinaryOperation)static_A_symbol_104.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_104 = dynamic_A_symbol_104.evaluate(evaluator, T_Boolean, A_symbol_103, S_any);
				leftA_symbol_102 = A_symbol_104;
			} catch (InvalidValueException e) {
				leftA_symbol_102 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_104 = leftA_symbol_102;
			Value rightA_symbol_102;
			try {
				
				Value A_symbol_105 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				
				Value A_symbol_106 = IP_CallExp_source.evaluate(evaluator, T_pivot__OCLExpression, self, P_CallExp_source);
				
				Value A_symbol_107 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_106, P_TypedElement_type);
				
				DomainType static_A_symbol_108 = valueFactory.typeOf(A_symbol_107);
				LibraryBinaryOperation dynamic_A_symbol_108 = (LibraryBinaryOperation)static_A_symbol_108.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_108 = dynamic_A_symbol_108.evaluate(evaluator, T_pivot__CollectionType, A_symbol_107, T_ClassClassifier_pivot__CollectionType_);
				Value A_symbol_109 = IP_CollectionType_elementType.evaluate(evaluator, T_Type, A_symbol_108, P_CollectionType_elementType);
				
				DomainType static_A_symbol_110 = valueFactory.typeOf(A_symbol_105, A_symbol_109);
				LibraryBinaryOperation dynamic_A_symbol_110 = (LibraryBinaryOperation)static_A_symbol_110.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_110 = dynamic_A_symbol_110.evaluate(evaluator, T_Boolean, A_symbol_105, A_symbol_109);
				rightA_symbol_102 = A_symbol_110;
			} catch (InvalidValueException e) {
				rightA_symbol_102 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_110 = rightA_symbol_102;
			DomainType static_A_symbol_102 = valueFactory.typeOf(A_symbol_104);
			LibraryBinaryOperation dynamic_A_symbol_102 = (LibraryBinaryOperation)static_A_symbol_102.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_102 = dynamic_A_symbol_102.evaluate(evaluator, T_Boolean, A_symbol_104, A_symbol_110);
			return A_symbol_102;
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
			final @NonNull Value T_ClassClassifier_pivot__CollectionType_ = valueFactory.createTypeValue(PivotTables.Types._CollectionType);
			final @NonNull ExecutorType T_pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final @NonNull ExecutorProperty P_CallExp_source = PivotTables.Properties._CallExp__source;
			final @NonNull LibraryProperty IP_CallExp_source = P_CallExp_source.getImplementation();
			
			Value leftA_symbol_111;
			try {
				
				Value A_symbol_112 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_113 = valueFactory.typeOf(A_symbol_112, S_closure);
				LibraryBinaryOperation dynamic_A_symbol_113 = (LibraryBinaryOperation)static_A_symbol_113.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_113 = dynamic_A_symbol_113.evaluate(evaluator, T_Boolean, A_symbol_112, S_closure);
				leftA_symbol_111 = A_symbol_113;
			} catch (InvalidValueException e) {
				leftA_symbol_111 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_113 = leftA_symbol_111;
			Value rightA_symbol_111;
			try {
				
				Value A_symbol_114 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_115 = valueFactory.typeOf(A_symbol_114);
				LibraryBinaryOperation dynamic_A_symbol_115 = (LibraryBinaryOperation)static_A_symbol_115.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_115 = dynamic_A_symbol_115.evaluate(evaluator, T_pivot__CollectionType, A_symbol_114, T_ClassClassifier_pivot__CollectionType_);
				Value A_symbol_116 = IP_CollectionType_elementType.evaluate(evaluator, T_Type, A_symbol_115, P_CollectionType_elementType);
				
				
				Value A_symbol_117 = IP_CallExp_source.evaluate(evaluator, T_pivot__OCLExpression, self, P_CallExp_source);
				
				Value A_symbol_118 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_117, P_TypedElement_type);
				
				DomainType static_A_symbol_119 = valueFactory.typeOf(A_symbol_118);
				LibraryBinaryOperation dynamic_A_symbol_119 = (LibraryBinaryOperation)static_A_symbol_119.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_119 = dynamic_A_symbol_119.evaluate(evaluator, T_pivot__CollectionType, A_symbol_118, T_ClassClassifier_pivot__CollectionType_);
				Value A_symbol_120 = IP_CollectionType_elementType.evaluate(evaluator, T_Type, A_symbol_119, P_CollectionType_elementType);
				
				DomainType static_A_symbol_121 = valueFactory.typeOf(A_symbol_116, A_symbol_120);
				LibraryBinaryOperation dynamic_A_symbol_121 = (LibraryBinaryOperation)static_A_symbol_121.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_121 = dynamic_A_symbol_121.evaluate(evaluator, T_Boolean, A_symbol_116, A_symbol_120);
				rightA_symbol_111 = A_symbol_121;
			} catch (InvalidValueException e) {
				rightA_symbol_111 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_121 = rightA_symbol_111;
			DomainType static_A_symbol_111 = valueFactory.typeOf(A_symbol_113);
			LibraryBinaryOperation dynamic_A_symbol_111 = (LibraryBinaryOperation)static_A_symbol_111.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_111 = dynamic_A_symbol_111.evaluate(evaluator, T_Boolean, A_symbol_113, A_symbol_121);
			return A_symbol_111;
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
			
			Value leftA_symbol_122;
			try {
				
				Value A_symbol_123 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_124 = valueFactory.typeOf(A_symbol_123, S_closure);
				LibraryBinaryOperation dynamic_A_symbol_124 = (LibraryBinaryOperation)static_A_symbol_124.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_124 = dynamic_A_symbol_124.evaluate(evaluator, T_Boolean, A_symbol_123, S_closure);
				leftA_symbol_122 = A_symbol_124;
			} catch (InvalidValueException e) {
				leftA_symbol_122 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_124 = leftA_symbol_122;
			Value rightA_symbol_122;
			try {
				
				Value A_symbol_125 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_126 = valueFactory.typeOf(A_symbol_125);
				LibraryUnaryOperation dynamic_A_symbol_126 = (LibraryUnaryOperation)static_A_symbol_126.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_126 = dynamic_A_symbol_126.evaluate(evaluator, T_Integer, A_symbol_125);
				DomainType static_A_symbol_127 = valueFactory.typeOf(A_symbol_126, I_1);
				LibraryBinaryOperation dynamic_A_symbol_127 = (LibraryBinaryOperation)static_A_symbol_127.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_127 = dynamic_A_symbol_127.evaluate(evaluator, T_Boolean, A_symbol_126, I_1);
				rightA_symbol_122 = A_symbol_127;
			} catch (InvalidValueException e) {
				rightA_symbol_122 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_127 = rightA_symbol_122;
			DomainType static_A_symbol_122 = valueFactory.typeOf(A_symbol_124);
			LibraryBinaryOperation dynamic_A_symbol_122 = (LibraryBinaryOperation)static_A_symbol_122.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_122 = dynamic_A_symbol_122.evaluate(evaluator, T_Boolean, A_symbol_124, A_symbol_127);
			return A_symbol_122;
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
			
			Value leftA_symbol_128;
			try {
				
				Value A_symbol_129 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_130 = valueFactory.typeOf(A_symbol_129, S_closure);
				LibraryBinaryOperation dynamic_A_symbol_130 = (LibraryBinaryOperation)static_A_symbol_130.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_130 = dynamic_A_symbol_130.evaluate(evaluator, T_Boolean, A_symbol_129, S_closure);
				leftA_symbol_128 = A_symbol_130;
			} catch (InvalidValueException e) {
				leftA_symbol_128 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_130 = leftA_symbol_128;
			Value rightA_symbol_128;
			try {
				
				Value A_symbol_131 = IP_CallExp_source.evaluate(evaluator, T_pivot__OCLExpression, self, P_CallExp_source);
				
				Value A_symbol_132 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_131, P_TypedElement_type);
				
				DomainType static_A_symbol_133 = valueFactory.typeOf(A_symbol_132);
				LibraryBinaryOperation dynamic_A_symbol_133 = (LibraryBinaryOperation)static_A_symbol_133.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_133 = dynamic_A_symbol_133.evaluate(evaluator, T_pivot__CollectionType, A_symbol_132, T_ClassClassifier_pivot__CollectionType_);
				Value A_symbol_134 = IP_CollectionType_elementType.evaluate(evaluator, T_Type, A_symbol_133, P_CollectionType_elementType);
				
					
					Value A_symbol_135 = IP_LoopExp_body.evaluate(evaluator, T_pivot__OCLExpression, self, P_LoopExp_body);
					
					Value A_symbol_136 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_135, P_TypedElement_type);
					
					DomainType static_A_symbol_137 = valueFactory.typeOf(A_symbol_136);
					LibraryBinaryOperation dynamic_A_symbol_137 = (LibraryBinaryOperation)static_A_symbol_137.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Value A_symbol_137 = dynamic_A_symbol_137.evaluate(evaluator, T_Boolean, A_symbol_136, T_ClassClassifier_pivot__CollectionType_);
				Value A_symbol_138;
				if (A_symbol_137.isTrue()) {
					
					Value A_symbol_139 = IP_LoopExp_body.evaluate(evaluator, T_pivot__OCLExpression, self, P_LoopExp_body);
					
					Value A_symbol_140 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_139, P_TypedElement_type);
					
					DomainType static_A_symbol_141 = valueFactory.typeOf(A_symbol_140);
					LibraryBinaryOperation dynamic_A_symbol_141 = (LibraryBinaryOperation)static_A_symbol_141.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
					Value A_symbol_141 = dynamic_A_symbol_141.evaluate(evaluator, T_pivot__CollectionType, A_symbol_140, T_ClassClassifier_pivot__CollectionType_);
					Value A_symbol_142 = IP_CollectionType_elementType.evaluate(evaluator, T_Type, A_symbol_141, P_CollectionType_elementType);
					
					A_symbol_138 = A_symbol_142;
				}
				else if (A_symbol_137.isFalse()) {
					
					Value A_symbol_143 = IP_LoopExp_body.evaluate(evaluator, T_pivot__OCLExpression, self, P_LoopExp_body);
					
					Value A_symbol_144 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_143, P_TypedElement_type);
					
					A_symbol_138 = A_symbol_144;
				}
				else if (A_symbol_137.isNull()) {
					A_symbol_138 = valueFactory.throwInvalidValueException("null if condition");
				}
				else {
					A_symbol_138 = valueFactory.throwInvalidValueException("invalid if condition");
				}
				DomainType static_A_symbol_145 = valueFactory.typeOf(A_symbol_134, A_symbol_138);
				LibraryBinaryOperation dynamic_A_symbol_145 = (LibraryBinaryOperation)static_A_symbol_145.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_145 = dynamic_A_symbol_145.evaluate(evaluator, T_Boolean, A_symbol_134, A_symbol_138);
				rightA_symbol_128 = A_symbol_145;
			} catch (InvalidValueException e) {
				rightA_symbol_128 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_145 = rightA_symbol_128;
			DomainType static_A_symbol_128 = valueFactory.typeOf(A_symbol_130);
			LibraryBinaryOperation dynamic_A_symbol_128 = (LibraryBinaryOperation)static_A_symbol_128.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_128 = dynamic_A_symbol_128.evaluate(evaluator, T_Boolean, A_symbol_130, A_symbol_145);
			return A_symbol_128;
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
			
			Value leftA_symbol_146;
			try {
				
				Value A_symbol_147 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_148 = valueFactory.typeOf(A_symbol_147, S_closure);
				LibraryBinaryOperation dynamic_A_symbol_148 = (LibraryBinaryOperation)static_A_symbol_148.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_148 = dynamic_A_symbol_148.evaluate(evaluator, T_Boolean, A_symbol_147, S_closure);
				leftA_symbol_146 = A_symbol_148;
			} catch (InvalidValueException e) {
				leftA_symbol_146 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_148 = leftA_symbol_146;
			Value rightA_symbol_146;
			try {
					Value leftA_symbol_149;
					try {
						
						Value A_symbol_150 = IP_CallExp_source.evaluate(evaluator, T_pivot__OCLExpression, self, P_CallExp_source);
						
						Value A_symbol_151 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_150, P_TypedElement_type);
						
						DomainType static_A_symbol_152 = valueFactory.typeOf(A_symbol_151);
						LibraryBinaryOperation dynamic_A_symbol_152 = (LibraryBinaryOperation)static_A_symbol_152.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Value A_symbol_152 = dynamic_A_symbol_152.evaluate(evaluator, T_Boolean, A_symbol_151, T_ClassClassifier_pivot__SequenceType_);
						leftA_symbol_149 = A_symbol_152;
					} catch (InvalidValueException e) {
						leftA_symbol_149 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_152 = leftA_symbol_149;
					Value rightA_symbol_149;
					try {
						
						Value A_symbol_153 = IP_CallExp_source.evaluate(evaluator, T_pivot__OCLExpression, self, P_CallExp_source);
						
						Value A_symbol_154 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_153, P_TypedElement_type);
						
						DomainType static_A_symbol_155 = valueFactory.typeOf(A_symbol_154);
						LibraryBinaryOperation dynamic_A_symbol_155 = (LibraryBinaryOperation)static_A_symbol_155.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Value A_symbol_155 = dynamic_A_symbol_155.evaluate(evaluator, T_Boolean, A_symbol_154, T_ClassClassifier_pivot__OrderedSetType_);
						rightA_symbol_149 = A_symbol_155;
					} catch (InvalidValueException e) {
						rightA_symbol_149 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_155 = rightA_symbol_149;
					DomainType static_A_symbol_149 = valueFactory.typeOf(A_symbol_152);
					LibraryBinaryOperation dynamic_A_symbol_149 = (LibraryBinaryOperation)static_A_symbol_149.lookupImplementation(standardLibrary, O_Boolean_or);
					Value A_symbol_149 = dynamic_A_symbol_149.evaluate(evaluator, T_Boolean, A_symbol_152, A_symbol_155);
				Value A_symbol_156;
				if (A_symbol_149.isTrue()) {
					
					Value A_symbol_157 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
					
					DomainType static_A_symbol_158 = valueFactory.typeOf(A_symbol_157);
					LibraryBinaryOperation dynamic_A_symbol_158 = (LibraryBinaryOperation)static_A_symbol_158.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Value A_symbol_158 = dynamic_A_symbol_158.evaluate(evaluator, T_Boolean, A_symbol_157, T_ClassClassifier_pivot__OrderedSetType_);
					A_symbol_156 = A_symbol_158;
				}
				else if (A_symbol_149.isFalse()) {
					
					Value A_symbol_159 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
					
					DomainType static_A_symbol_160 = valueFactory.typeOf(A_symbol_159);
					LibraryBinaryOperation dynamic_A_symbol_160 = (LibraryBinaryOperation)static_A_symbol_160.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Value A_symbol_160 = dynamic_A_symbol_160.evaluate(evaluator, T_Boolean, A_symbol_159, T_ClassClassifier_pivot__SetType_);
					A_symbol_156 = A_symbol_160;
				}
				else if (A_symbol_149.isNull()) {
					A_symbol_156 = valueFactory.throwInvalidValueException("null if condition");
				}
				else {
					A_symbol_156 = valueFactory.throwInvalidValueException("invalid if condition");
				}
				rightA_symbol_146 = A_symbol_156;
			} catch (InvalidValueException e) {
				rightA_symbol_146 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_156 = rightA_symbol_146;
			DomainType static_A_symbol_146 = valueFactory.typeOf(A_symbol_148);
			LibraryBinaryOperation dynamic_A_symbol_146 = (LibraryBinaryOperation)static_A_symbol_146.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_146 = dynamic_A_symbol_146.evaluate(evaluator, T_Boolean, A_symbol_148, A_symbol_156);
			return A_symbol_146;
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
			
			Value leftA_symbol_161;
			try {
				
				Value A_symbol_162 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_163 = valueFactory.typeOf(A_symbol_162, S_collect);
				LibraryBinaryOperation dynamic_A_symbol_163 = (LibraryBinaryOperation)static_A_symbol_163.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_163 = dynamic_A_symbol_163.evaluate(evaluator, T_Boolean, A_symbol_162, S_collect);
				leftA_symbol_161 = A_symbol_163;
			} catch (InvalidValueException e) {
				leftA_symbol_161 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_163 = leftA_symbol_161;
			Value rightA_symbol_161;
			try {
				
				Value A_symbol_164 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_165 = valueFactory.typeOf(A_symbol_164);
				LibraryBinaryOperation dynamic_A_symbol_165 = (LibraryBinaryOperation)static_A_symbol_165.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_165 = dynamic_A_symbol_165.evaluate(evaluator, T_pivot__CollectionType, A_symbol_164, T_ClassClassifier_pivot__CollectionType_);
				Value A_symbol_166 = IP_CollectionType_elementType.evaluate(evaluator, T_Type, A_symbol_165, P_CollectionType_elementType);
				
				
				Value A_symbol_167 = IP_LoopExp_body.evaluate(evaluator, T_pivot__OCLExpression, self, P_LoopExp_body);
				
				Value A_symbol_168 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_167, P_TypedElement_type);
				
				DomainType static_A_symbol_169 = valueFactory.typeOf(A_symbol_168);
				LibraryBinaryOperation dynamic_A_symbol_169 = (LibraryBinaryOperation)static_A_symbol_169.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_169 = dynamic_A_symbol_169.evaluate(evaluator, T_pivot__CollectionType, A_symbol_168, T_ClassClassifier_pivot__CollectionType_);
				Value A_symbol_170 = IP_CollectionType_elementType.evaluate(evaluator, T_Type, A_symbol_169, P_CollectionType_elementType);
				
				DomainType static_A_symbol_171 = valueFactory.typeOf(A_symbol_166, A_symbol_170);
				LibraryBinaryOperation dynamic_A_symbol_171 = (LibraryBinaryOperation)static_A_symbol_171.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_171 = dynamic_A_symbol_171.evaluate(evaluator, T_Boolean, A_symbol_166, A_symbol_170);
				rightA_symbol_161 = A_symbol_171;
			} catch (InvalidValueException e) {
				rightA_symbol_161 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_171 = rightA_symbol_161;
			DomainType static_A_symbol_161 = valueFactory.typeOf(A_symbol_163);
			LibraryBinaryOperation dynamic_A_symbol_161 = (LibraryBinaryOperation)static_A_symbol_161.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_161 = dynamic_A_symbol_161.evaluate(evaluator, T_Boolean, A_symbol_163, A_symbol_171);
			return A_symbol_161;
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
			
			Value leftA_symbol_172;
			try {
				
				Value A_symbol_173 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_174 = valueFactory.typeOf(A_symbol_173, S_collect);
				LibraryBinaryOperation dynamic_A_symbol_174 = (LibraryBinaryOperation)static_A_symbol_174.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_174 = dynamic_A_symbol_174.evaluate(evaluator, T_Boolean, A_symbol_173, S_collect);
				leftA_symbol_172 = A_symbol_174;
			} catch (InvalidValueException e) {
				leftA_symbol_172 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_174 = leftA_symbol_172;
			Value rightA_symbol_172;
			try {
				
				Value A_symbol_175 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_176 = valueFactory.typeOf(A_symbol_175);
				LibraryUnaryOperation dynamic_A_symbol_176 = (LibraryUnaryOperation)static_A_symbol_176.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_176 = dynamic_A_symbol_176.evaluate(evaluator, T_Integer, A_symbol_175);
				DomainType static_A_symbol_177 = valueFactory.typeOf(A_symbol_176, I_1);
				LibraryBinaryOperation dynamic_A_symbol_177 = (LibraryBinaryOperation)static_A_symbol_177.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_177 = dynamic_A_symbol_177.evaluate(evaluator, T_Boolean, A_symbol_176, I_1);
				rightA_symbol_172 = A_symbol_177;
			} catch (InvalidValueException e) {
				rightA_symbol_172 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_177 = rightA_symbol_172;
			DomainType static_A_symbol_172 = valueFactory.typeOf(A_symbol_174);
			LibraryBinaryOperation dynamic_A_symbol_172 = (LibraryBinaryOperation)static_A_symbol_172.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_172 = dynamic_A_symbol_172.evaluate(evaluator, T_Boolean, A_symbol_174, A_symbol_177);
			return A_symbol_172;
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
			
			Value leftA_symbol_178;
			try {
				
				Value A_symbol_179 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_180 = valueFactory.typeOf(A_symbol_179, S_collectN___);
				LibraryBinaryOperation dynamic_A_symbol_180 = (LibraryBinaryOperation)static_A_symbol_180.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_180 = dynamic_A_symbol_180.evaluate(evaluator, T_Boolean, A_symbol_179, S_collectN___);
				leftA_symbol_178 = A_symbol_180;
			} catch (InvalidValueException e) {
				leftA_symbol_178 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_180 = leftA_symbol_178;
			Value rightA_symbol_178;
			try {
				
				Value A_symbol_181 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_182 = valueFactory.typeOf(A_symbol_181);
				LibraryUnaryOperation dynamic_A_symbol_182 = (LibraryUnaryOperation)static_A_symbol_182.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_182 = dynamic_A_symbol_182.evaluate(evaluator, T_Integer, A_symbol_181);
				DomainType static_A_symbol_183 = valueFactory.typeOf(A_symbol_182, I_1);
				LibraryBinaryOperation dynamic_A_symbol_183 = (LibraryBinaryOperation)static_A_symbol_183.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_183 = dynamic_A_symbol_183.evaluate(evaluator, T_Boolean, A_symbol_182, I_1);
				rightA_symbol_178 = A_symbol_183;
			} catch (InvalidValueException e) {
				rightA_symbol_178 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_183 = rightA_symbol_178;
			DomainType static_A_symbol_178 = valueFactory.typeOf(A_symbol_180);
			LibraryBinaryOperation dynamic_A_symbol_178 = (LibraryBinaryOperation)static_A_symbol_178.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_178 = dynamic_A_symbol_178.evaluate(evaluator, T_Boolean, A_symbol_180, A_symbol_183);
			return A_symbol_178;
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
			
			Value leftA_symbol_184;
			try {
				
				Value A_symbol_185 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_186 = valueFactory.typeOf(A_symbol_185, S_collectN___);
				LibraryBinaryOperation dynamic_A_symbol_186 = (LibraryBinaryOperation)static_A_symbol_186.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_186 = dynamic_A_symbol_186.evaluate(evaluator, T_Boolean, A_symbol_185, S_collectN___);
				leftA_symbol_184 = A_symbol_186;
			} catch (InvalidValueException e) {
				leftA_symbol_184 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_186 = leftA_symbol_184;
			Value rightA_symbol_184;
			try {
				
				Value A_symbol_187 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_188 = valueFactory.typeOf(A_symbol_187);
				LibraryBinaryOperation dynamic_A_symbol_188 = (LibraryBinaryOperation)static_A_symbol_188.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
				Value A_symbol_188 = dynamic_A_symbol_188.evaluate(evaluator, T_Boolean, A_symbol_187, T_ClassClassifier_pivot__BagType_);
				rightA_symbol_184 = A_symbol_188;
			} catch (InvalidValueException e) {
				rightA_symbol_184 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_188 = rightA_symbol_184;
			DomainType static_A_symbol_184 = valueFactory.typeOf(A_symbol_186);
			LibraryBinaryOperation dynamic_A_symbol_184 = (LibraryBinaryOperation)static_A_symbol_184.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_184 = dynamic_A_symbol_184.evaluate(evaluator, T_Boolean, A_symbol_186, A_symbol_188);
			return A_symbol_184;
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
			
			Value leftA_symbol_189;
			try {
				
				Value A_symbol_190 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_191 = valueFactory.typeOf(A_symbol_190, S_collectN___);
				LibraryBinaryOperation dynamic_A_symbol_191 = (LibraryBinaryOperation)static_A_symbol_191.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_191 = dynamic_A_symbol_191.evaluate(evaluator, T_Boolean, A_symbol_190, S_collectN___);
				leftA_symbol_189 = A_symbol_191;
			} catch (InvalidValueException e) {
				leftA_symbol_189 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_191 = leftA_symbol_189;
			Value rightA_symbol_189;
			try {
				
				Value A_symbol_192 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				
				Value A_symbol_193 = IP_LoopExp_body.evaluate(evaluator, T_pivot__OCLExpression, self, P_LoopExp_body);
				
				Value A_symbol_194 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_193, P_TypedElement_type);
				
				DomainType static_A_symbol_195 = valueFactory.typeOf(A_symbol_192, A_symbol_194);
				LibraryBinaryOperation dynamic_A_symbol_195 = (LibraryBinaryOperation)static_A_symbol_195.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_195 = dynamic_A_symbol_195.evaluate(evaluator, T_Boolean, A_symbol_192, A_symbol_194);
				rightA_symbol_189 = A_symbol_195;
			} catch (InvalidValueException e) {
				rightA_symbol_189 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_195 = rightA_symbol_189;
			DomainType static_A_symbol_189 = valueFactory.typeOf(A_symbol_191);
			LibraryBinaryOperation dynamic_A_symbol_189 = (LibraryBinaryOperation)static_A_symbol_189.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_189 = dynamic_A_symbol_189.evaluate(evaluator, T_Boolean, A_symbol_191, A_symbol_195);
			return A_symbol_189;
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
			
			Value leftA_symbol_196;
			try {
				
				Value A_symbol_197 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_198 = valueFactory.typeOf(A_symbol_197, S_collect);
				LibraryBinaryOperation dynamic_A_symbol_198 = (LibraryBinaryOperation)static_A_symbol_198.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_198 = dynamic_A_symbol_198.evaluate(evaluator, T_Boolean, A_symbol_197, S_collect);
				leftA_symbol_196 = A_symbol_198;
			} catch (InvalidValueException e) {
				leftA_symbol_196 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_198 = leftA_symbol_196;
			Value rightA_symbol_196;
			try {
					Value leftA_symbol_199;
					try {
						
						Value A_symbol_200 = IP_CallExp_source.evaluate(evaluator, T_pivot__OCLExpression, self, P_CallExp_source);
						
						Value A_symbol_201 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_200, P_TypedElement_type);
						
						DomainType static_A_symbol_202 = valueFactory.typeOf(A_symbol_201);
						LibraryBinaryOperation dynamic_A_symbol_202 = (LibraryBinaryOperation)static_A_symbol_202.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Value A_symbol_202 = dynamic_A_symbol_202.evaluate(evaluator, T_Boolean, A_symbol_201, T_ClassClassifier_pivot__SequenceType_);
						leftA_symbol_199 = A_symbol_202;
					} catch (InvalidValueException e) {
						leftA_symbol_199 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_202 = leftA_symbol_199;
					Value rightA_symbol_199;
					try {
						
						Value A_symbol_203 = IP_CallExp_source.evaluate(evaluator, T_pivot__OCLExpression, self, P_CallExp_source);
						
						Value A_symbol_204 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_203, P_TypedElement_type);
						
						DomainType static_A_symbol_205 = valueFactory.typeOf(A_symbol_204);
						LibraryBinaryOperation dynamic_A_symbol_205 = (LibraryBinaryOperation)static_A_symbol_205.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Value A_symbol_205 = dynamic_A_symbol_205.evaluate(evaluator, T_Boolean, A_symbol_204, T_ClassClassifier_pivot__OrderedSetType_);
						rightA_symbol_199 = A_symbol_205;
					} catch (InvalidValueException e) {
						rightA_symbol_199 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_205 = rightA_symbol_199;
					DomainType static_A_symbol_199 = valueFactory.typeOf(A_symbol_202);
					LibraryBinaryOperation dynamic_A_symbol_199 = (LibraryBinaryOperation)static_A_symbol_199.lookupImplementation(standardLibrary, O_Boolean_or);
					Value A_symbol_199 = dynamic_A_symbol_199.evaluate(evaluator, T_Boolean, A_symbol_202, A_symbol_205);
				Value A_symbol_206;
				if (A_symbol_199.isTrue()) {
					
					Value A_symbol_207 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
					
					DomainType static_A_symbol_208 = valueFactory.typeOf(A_symbol_207);
					LibraryBinaryOperation dynamic_A_symbol_208 = (LibraryBinaryOperation)static_A_symbol_208.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Value A_symbol_208 = dynamic_A_symbol_208.evaluate(evaluator, T_Boolean, A_symbol_207, T_ClassClassifier_pivot__SequenceType_);
					A_symbol_206 = A_symbol_208;
				}
				else if (A_symbol_199.isFalse()) {
					
					Value A_symbol_209 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
					
					DomainType static_A_symbol_210 = valueFactory.typeOf(A_symbol_209);
					LibraryBinaryOperation dynamic_A_symbol_210 = (LibraryBinaryOperation)static_A_symbol_210.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Value A_symbol_210 = dynamic_A_symbol_210.evaluate(evaluator, T_Boolean, A_symbol_209, T_ClassClassifier_pivot__BagType_);
					A_symbol_206 = A_symbol_210;
				}
				else if (A_symbol_199.isNull()) {
					A_symbol_206 = valueFactory.throwInvalidValueException("null if condition");
				}
				else {
					A_symbol_206 = valueFactory.throwInvalidValueException("invalid if condition");
				}
				rightA_symbol_196 = A_symbol_206;
			} catch (InvalidValueException e) {
				rightA_symbol_196 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_206 = rightA_symbol_196;
			DomainType static_A_symbol_196 = valueFactory.typeOf(A_symbol_198);
			LibraryBinaryOperation dynamic_A_symbol_196 = (LibraryBinaryOperation)static_A_symbol_196.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_196 = dynamic_A_symbol_196.evaluate(evaluator, T_Boolean, A_symbol_198, A_symbol_206);
			return A_symbol_196;
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
			
			Value leftA_symbol_211;
			try {
				
				Value A_symbol_212 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_213 = valueFactory.typeOf(A_symbol_212, S_exists);
				LibraryBinaryOperation dynamic_A_symbol_213 = (LibraryBinaryOperation)static_A_symbol_213.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_213 = dynamic_A_symbol_213.evaluate(evaluator, T_Boolean, A_symbol_212, S_exists);
				leftA_symbol_211 = A_symbol_213;
			} catch (InvalidValueException e) {
				leftA_symbol_211 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_213 = leftA_symbol_211;
			Value rightA_symbol_211;
			try {
				
				Value A_symbol_214 = IP_LoopExp_body.evaluate(evaluator, T_pivot__OCLExpression, self, P_LoopExp_body);
				
				Value A_symbol_215 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_214, P_TypedElement_type);
				
				DomainType static_A_symbol_216 = valueFactory.typeOf(A_symbol_215, T_ClassClassifier_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_216 = (LibraryBinaryOperation)static_A_symbol_216.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_216 = dynamic_A_symbol_216.evaluate(evaluator, T_Boolean, A_symbol_215, T_ClassClassifier_Boolean_);
				rightA_symbol_211 = A_symbol_216;
			} catch (InvalidValueException e) {
				rightA_symbol_211 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_216 = rightA_symbol_211;
			DomainType static_A_symbol_211 = valueFactory.typeOf(A_symbol_213);
			LibraryBinaryOperation dynamic_A_symbol_211 = (LibraryBinaryOperation)static_A_symbol_211.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_211 = dynamic_A_symbol_211.evaluate(evaluator, T_Boolean, A_symbol_213, A_symbol_216);
			return A_symbol_211;
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
			
			Value leftA_symbol_217;
			try {
				
				Value A_symbol_218 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_219 = valueFactory.typeOf(A_symbol_218, S_exists);
				LibraryBinaryOperation dynamic_A_symbol_219 = (LibraryBinaryOperation)static_A_symbol_219.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_219 = dynamic_A_symbol_219.evaluate(evaluator, T_Boolean, A_symbol_218, S_exists);
				leftA_symbol_217 = A_symbol_219;
			} catch (InvalidValueException e) {
				leftA_symbol_217 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_219 = leftA_symbol_217;
			Value rightA_symbol_217;
			try {
				
				Value A_symbol_220 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_221 = valueFactory.typeOf(A_symbol_220, T_ClassClassifier_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_221 = (LibraryBinaryOperation)static_A_symbol_221.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_221 = dynamic_A_symbol_221.evaluate(evaluator, T_Boolean, A_symbol_220, T_ClassClassifier_Boolean_);
				rightA_symbol_217 = A_symbol_221;
			} catch (InvalidValueException e) {
				rightA_symbol_217 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_221 = rightA_symbol_217;
			DomainType static_A_symbol_217 = valueFactory.typeOf(A_symbol_219);
			LibraryBinaryOperation dynamic_A_symbol_217 = (LibraryBinaryOperation)static_A_symbol_217.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_217 = dynamic_A_symbol_217.evaluate(evaluator, T_Boolean, A_symbol_219, A_symbol_221);
			return A_symbol_217;
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
			
			Value leftA_symbol_222;
			try {
				
				Value A_symbol_223 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_224 = valueFactory.typeOf(A_symbol_223, S_forAll);
				LibraryBinaryOperation dynamic_A_symbol_224 = (LibraryBinaryOperation)static_A_symbol_224.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_224 = dynamic_A_symbol_224.evaluate(evaluator, T_Boolean, A_symbol_223, S_forAll);
				leftA_symbol_222 = A_symbol_224;
			} catch (InvalidValueException e) {
				leftA_symbol_222 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_224 = leftA_symbol_222;
			Value rightA_symbol_222;
			try {
				
				Value A_symbol_225 = IP_LoopExp_body.evaluate(evaluator, T_pivot__OCLExpression, self, P_LoopExp_body);
				
				Value A_symbol_226 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_225, P_TypedElement_type);
				
				DomainType static_A_symbol_227 = valueFactory.typeOf(A_symbol_226, T_ClassClassifier_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_227 = (LibraryBinaryOperation)static_A_symbol_227.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_227 = dynamic_A_symbol_227.evaluate(evaluator, T_Boolean, A_symbol_226, T_ClassClassifier_Boolean_);
				rightA_symbol_222 = A_symbol_227;
			} catch (InvalidValueException e) {
				rightA_symbol_222 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_227 = rightA_symbol_222;
			DomainType static_A_symbol_222 = valueFactory.typeOf(A_symbol_224);
			LibraryBinaryOperation dynamic_A_symbol_222 = (LibraryBinaryOperation)static_A_symbol_222.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_222 = dynamic_A_symbol_222.evaluate(evaluator, T_Boolean, A_symbol_224, A_symbol_227);
			return A_symbol_222;
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
			
			Value leftA_symbol_228;
			try {
				
				Value A_symbol_229 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_230 = valueFactory.typeOf(A_symbol_229, S_forAll);
				LibraryBinaryOperation dynamic_A_symbol_230 = (LibraryBinaryOperation)static_A_symbol_230.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_230 = dynamic_A_symbol_230.evaluate(evaluator, T_Boolean, A_symbol_229, S_forAll);
				leftA_symbol_228 = A_symbol_230;
			} catch (InvalidValueException e) {
				leftA_symbol_228 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_230 = leftA_symbol_228;
			Value rightA_symbol_228;
			try {
				
				Value A_symbol_231 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_232 = valueFactory.typeOf(A_symbol_231, T_ClassClassifier_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_232 = (LibraryBinaryOperation)static_A_symbol_232.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_232 = dynamic_A_symbol_232.evaluate(evaluator, T_Boolean, A_symbol_231, T_ClassClassifier_Boolean_);
				rightA_symbol_228 = A_symbol_232;
			} catch (InvalidValueException e) {
				rightA_symbol_228 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_232 = rightA_symbol_228;
			DomainType static_A_symbol_228 = valueFactory.typeOf(A_symbol_230);
			LibraryBinaryOperation dynamic_A_symbol_228 = (LibraryBinaryOperation)static_A_symbol_228.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_228 = dynamic_A_symbol_228.evaluate(evaluator, T_Boolean, A_symbol_230, A_symbol_232);
			return A_symbol_228;
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
			
			Value leftA_symbol_233;
			try {
				
				Value A_symbol_234 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_235 = valueFactory.typeOf(A_symbol_234, S_isUnique);
				LibraryBinaryOperation dynamic_A_symbol_235 = (LibraryBinaryOperation)static_A_symbol_235.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_235 = dynamic_A_symbol_235.evaluate(evaluator, T_Boolean, A_symbol_234, S_isUnique);
				leftA_symbol_233 = A_symbol_235;
			} catch (InvalidValueException e) {
				leftA_symbol_233 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_235 = leftA_symbol_233;
			Value rightA_symbol_233;
			try {
				
				Value A_symbol_236 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_237 = valueFactory.typeOf(A_symbol_236);
				LibraryUnaryOperation dynamic_A_symbol_237 = (LibraryUnaryOperation)static_A_symbol_237.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_237 = dynamic_A_symbol_237.evaluate(evaluator, T_Integer, A_symbol_236);
				DomainType static_A_symbol_238 = valueFactory.typeOf(A_symbol_237, I_1);
				LibraryBinaryOperation dynamic_A_symbol_238 = (LibraryBinaryOperation)static_A_symbol_238.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_238 = dynamic_A_symbol_238.evaluate(evaluator, T_Boolean, A_symbol_237, I_1);
				rightA_symbol_233 = A_symbol_238;
			} catch (InvalidValueException e) {
				rightA_symbol_233 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_238 = rightA_symbol_233;
			DomainType static_A_symbol_233 = valueFactory.typeOf(A_symbol_235);
			LibraryBinaryOperation dynamic_A_symbol_233 = (LibraryBinaryOperation)static_A_symbol_233.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_233 = dynamic_A_symbol_233.evaluate(evaluator, T_Boolean, A_symbol_235, A_symbol_238);
			return A_symbol_233;
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
			
			Value leftA_symbol_239;
			try {
				
				Value A_symbol_240 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_241 = valueFactory.typeOf(A_symbol_240, S_isUnique);
				LibraryBinaryOperation dynamic_A_symbol_241 = (LibraryBinaryOperation)static_A_symbol_241.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_241 = dynamic_A_symbol_241.evaluate(evaluator, T_Boolean, A_symbol_240, S_isUnique);
				leftA_symbol_239 = A_symbol_241;
			} catch (InvalidValueException e) {
				leftA_symbol_239 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_241 = leftA_symbol_239;
			Value rightA_symbol_239;
			try {
				
				Value A_symbol_242 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_243 = valueFactory.typeOf(A_symbol_242, T_ClassClassifier_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_243 = (LibraryBinaryOperation)static_A_symbol_243.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_243 = dynamic_A_symbol_243.evaluate(evaluator, T_Boolean, A_symbol_242, T_ClassClassifier_Boolean_);
				rightA_symbol_239 = A_symbol_243;
			} catch (InvalidValueException e) {
				rightA_symbol_239 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_243 = rightA_symbol_239;
			DomainType static_A_symbol_239 = valueFactory.typeOf(A_symbol_241);
			LibraryBinaryOperation dynamic_A_symbol_239 = (LibraryBinaryOperation)static_A_symbol_239.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_239 = dynamic_A_symbol_239.evaluate(evaluator, T_Boolean, A_symbol_241, A_symbol_243);
			return A_symbol_239;
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
			
			
			Value A_symbol_244 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_pivot__Variable_, self, P_LoopExp_iterator);
			
			
			/** 
			 * Implementation of the iterator body.
			 */
			AbstractBinaryOperation body_A_symbol_245 = new AbstractBinaryOperation()
			{
			/*
			type = source.type.oclAsType(CollectionType).elementType
			*/
				public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, @NonNull Value sourceValue, @NonNull Value iterator1) throws InvalidValueException {
					final @NonNull Value V_1_ = iterator1;	// iterator: 1_
					
					Value A_symbol_246 = IP_TypedElement_type.evaluate(evaluator, T_Type, V_1_, P_TypedElement_type);
					
					
					Value A_symbol_247 = IP_CallExp_source.evaluate(evaluator, T_pivot__OCLExpression, self, P_CallExp_source);
					
					Value A_symbol_248 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_247, P_TypedElement_type);
					
					DomainType static_A_symbol_249 = valueFactory.typeOf(A_symbol_248);
					LibraryBinaryOperation dynamic_A_symbol_249 = (LibraryBinaryOperation)static_A_symbol_249.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
					Value A_symbol_249 = dynamic_A_symbol_249.evaluate(evaluator, T_pivot__CollectionType, A_symbol_248, T_ClassClassifier_pivot__CollectionType_);
					Value A_symbol_250 = IP_CollectionType_elementType.evaluate(evaluator, T_Type, A_symbol_249, P_CollectionType_elementType);
					
					DomainType static_A_symbol_251 = valueFactory.typeOf(A_symbol_246, A_symbol_250);
					LibraryBinaryOperation dynamic_A_symbol_251 = (LibraryBinaryOperation)static_A_symbol_251.lookupImplementation(standardLibrary, O_OclAny__eq_);
					Value A_symbol_251 = dynamic_A_symbol_251.evaluate(evaluator, T_Boolean, A_symbol_246, A_symbol_250);
					return A_symbol_251;
				}
			};
			DomainType static_A_symbol_245 = A_symbol_244.getType();
			LibraryIteration dynamic_A_symbol_245 = (LibraryIteration)static_A_symbol_245.lookupImplementation(standardLibrary, O_Collection_forAll);
			Value acc_A_symbol_245 = dynamic_A_symbol_245.createAccumulatorValue(evaluator, T_Boolean, T_Boolean);
			ExecutorSingleIterationManager manager_A_symbol_245 = new ExecutorSingleIterationManager(evaluator, T_Boolean, body_A_symbol_245, (CollectionValue)A_symbol_244, acc_A_symbol_245);
			Value A_symbol_245 = dynamic_A_symbol_245.evaluateIteration(manager_A_symbol_245);
			return A_symbol_245;
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
			
			Value leftA_symbol_252;
			try {
				
				Value A_symbol_253 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_254 = valueFactory.typeOf(A_symbol_253, S_one);
				LibraryBinaryOperation dynamic_A_symbol_254 = (LibraryBinaryOperation)static_A_symbol_254.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_254 = dynamic_A_symbol_254.evaluate(evaluator, T_Boolean, A_symbol_253, S_one);
				leftA_symbol_252 = A_symbol_254;
			} catch (InvalidValueException e) {
				leftA_symbol_252 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_254 = leftA_symbol_252;
			Value rightA_symbol_252;
			try {
				
				Value A_symbol_255 = IP_LoopExp_body.evaluate(evaluator, T_pivot__OCLExpression, self, P_LoopExp_body);
				
				Value A_symbol_256 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_255, P_TypedElement_type);
				
				DomainType static_A_symbol_257 = valueFactory.typeOf(A_symbol_256, T_ClassClassifier_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_257 = (LibraryBinaryOperation)static_A_symbol_257.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_257 = dynamic_A_symbol_257.evaluate(evaluator, T_Boolean, A_symbol_256, T_ClassClassifier_Boolean_);
				rightA_symbol_252 = A_symbol_257;
			} catch (InvalidValueException e) {
				rightA_symbol_252 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_257 = rightA_symbol_252;
			DomainType static_A_symbol_252 = valueFactory.typeOf(A_symbol_254);
			LibraryBinaryOperation dynamic_A_symbol_252 = (LibraryBinaryOperation)static_A_symbol_252.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_252 = dynamic_A_symbol_252.evaluate(evaluator, T_Boolean, A_symbol_254, A_symbol_257);
			return A_symbol_252;
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
			
			Value leftA_symbol_258;
			try {
				
				Value A_symbol_259 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_260 = valueFactory.typeOf(A_symbol_259, S_one);
				LibraryBinaryOperation dynamic_A_symbol_260 = (LibraryBinaryOperation)static_A_symbol_260.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_260 = dynamic_A_symbol_260.evaluate(evaluator, T_Boolean, A_symbol_259, S_one);
				leftA_symbol_258 = A_symbol_260;
			} catch (InvalidValueException e) {
				leftA_symbol_258 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_260 = leftA_symbol_258;
			Value rightA_symbol_258;
			try {
				
				Value A_symbol_261 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_262 = valueFactory.typeOf(A_symbol_261);
				LibraryUnaryOperation dynamic_A_symbol_262 = (LibraryUnaryOperation)static_A_symbol_262.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_262 = dynamic_A_symbol_262.evaluate(evaluator, T_Integer, A_symbol_261);
				DomainType static_A_symbol_263 = valueFactory.typeOf(A_symbol_262, I_1);
				LibraryBinaryOperation dynamic_A_symbol_263 = (LibraryBinaryOperation)static_A_symbol_263.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_263 = dynamic_A_symbol_263.evaluate(evaluator, T_Boolean, A_symbol_262, I_1);
				rightA_symbol_258 = A_symbol_263;
			} catch (InvalidValueException e) {
				rightA_symbol_258 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_263 = rightA_symbol_258;
			DomainType static_A_symbol_258 = valueFactory.typeOf(A_symbol_260);
			LibraryBinaryOperation dynamic_A_symbol_258 = (LibraryBinaryOperation)static_A_symbol_258.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_258 = dynamic_A_symbol_258.evaluate(evaluator, T_Boolean, A_symbol_260, A_symbol_263);
			return A_symbol_258;
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
			
			Value leftA_symbol_264;
			try {
				
				Value A_symbol_265 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_266 = valueFactory.typeOf(A_symbol_265, S_one);
				LibraryBinaryOperation dynamic_A_symbol_266 = (LibraryBinaryOperation)static_A_symbol_266.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_266 = dynamic_A_symbol_266.evaluate(evaluator, T_Boolean, A_symbol_265, S_one);
				leftA_symbol_264 = A_symbol_266;
			} catch (InvalidValueException e) {
				leftA_symbol_264 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_266 = leftA_symbol_264;
			Value rightA_symbol_264;
			try {
				
				Value A_symbol_267 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_268 = valueFactory.typeOf(A_symbol_267, T_ClassClassifier_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_268 = (LibraryBinaryOperation)static_A_symbol_268.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_268 = dynamic_A_symbol_268.evaluate(evaluator, T_Boolean, A_symbol_267, T_ClassClassifier_Boolean_);
				rightA_symbol_264 = A_symbol_268;
			} catch (InvalidValueException e) {
				rightA_symbol_264 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_268 = rightA_symbol_264;
			DomainType static_A_symbol_264 = valueFactory.typeOf(A_symbol_266);
			LibraryBinaryOperation dynamic_A_symbol_264 = (LibraryBinaryOperation)static_A_symbol_264.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_264 = dynamic_A_symbol_264.evaluate(evaluator, T_Boolean, A_symbol_266, A_symbol_268);
			return A_symbol_264;
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
			
			Value leftA_symbol_269;
			try {
				Value leftA_symbol_270;
				try {
					
					Value A_symbol_271 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
					
					DomainType static_A_symbol_272 = valueFactory.typeOf(A_symbol_271, S_reject);
					LibraryBinaryOperation dynamic_A_symbol_272 = (LibraryBinaryOperation)static_A_symbol_272.lookupImplementation(standardLibrary, O_String__eq_);
					Value A_symbol_272 = dynamic_A_symbol_272.evaluate(evaluator, T_Boolean, A_symbol_271, S_reject);
					leftA_symbol_270 = A_symbol_272;
				} catch (InvalidValueException e) {
					leftA_symbol_270 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_272 = leftA_symbol_270;
				Value rightA_symbol_270;
				try {
					
					Value A_symbol_273 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
					
					DomainType static_A_symbol_274 = valueFactory.typeOf(A_symbol_273, S_select);
					LibraryBinaryOperation dynamic_A_symbol_274 = (LibraryBinaryOperation)static_A_symbol_274.lookupImplementation(standardLibrary, O_String__eq_);
					Value A_symbol_274 = dynamic_A_symbol_274.evaluate(evaluator, T_Boolean, A_symbol_273, S_select);
					rightA_symbol_270 = A_symbol_274;
				} catch (InvalidValueException e) {
					rightA_symbol_270 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_274 = rightA_symbol_270;
				DomainType static_A_symbol_270 = valueFactory.typeOf(A_symbol_272);
				LibraryBinaryOperation dynamic_A_symbol_270 = (LibraryBinaryOperation)static_A_symbol_270.lookupImplementation(standardLibrary, O_Boolean_or);
				Value A_symbol_270 = dynamic_A_symbol_270.evaluate(evaluator, T_Boolean, A_symbol_272, A_symbol_274);
				leftA_symbol_269 = A_symbol_270;
			} catch (InvalidValueException e) {
				leftA_symbol_269 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_270 = leftA_symbol_269;
			Value rightA_symbol_269;
			try {
				
				Value A_symbol_275 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_276 = valueFactory.typeOf(A_symbol_275);
				LibraryUnaryOperation dynamic_A_symbol_276 = (LibraryUnaryOperation)static_A_symbol_276.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_276 = dynamic_A_symbol_276.evaluate(evaluator, T_Integer, A_symbol_275);
				DomainType static_A_symbol_277 = valueFactory.typeOf(A_symbol_276, I_1);
				LibraryBinaryOperation dynamic_A_symbol_277 = (LibraryBinaryOperation)static_A_symbol_277.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_277 = dynamic_A_symbol_277.evaluate(evaluator, T_Boolean, A_symbol_276, I_1);
				rightA_symbol_269 = A_symbol_277;
			} catch (InvalidValueException e) {
				rightA_symbol_269 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_277 = rightA_symbol_269;
			DomainType static_A_symbol_269 = valueFactory.typeOf(A_symbol_270);
			LibraryBinaryOperation dynamic_A_symbol_269 = (LibraryBinaryOperation)static_A_symbol_269.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_269 = dynamic_A_symbol_269.evaluate(evaluator, T_Boolean, A_symbol_270, A_symbol_277);
			return A_symbol_269;
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
			
			Value leftA_symbol_278;
			try {
				Value leftA_symbol_279;
				try {
					
					Value A_symbol_280 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
					
					DomainType static_A_symbol_281 = valueFactory.typeOf(A_symbol_280, S_reject);
					LibraryBinaryOperation dynamic_A_symbol_281 = (LibraryBinaryOperation)static_A_symbol_281.lookupImplementation(standardLibrary, O_String__eq_);
					Value A_symbol_281 = dynamic_A_symbol_281.evaluate(evaluator, T_Boolean, A_symbol_280, S_reject);
					leftA_symbol_279 = A_symbol_281;
				} catch (InvalidValueException e) {
					leftA_symbol_279 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_281 = leftA_symbol_279;
				Value rightA_symbol_279;
				try {
					
					Value A_symbol_282 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
					
					DomainType static_A_symbol_283 = valueFactory.typeOf(A_symbol_282, S_select);
					LibraryBinaryOperation dynamic_A_symbol_283 = (LibraryBinaryOperation)static_A_symbol_283.lookupImplementation(standardLibrary, O_String__eq_);
					Value A_symbol_283 = dynamic_A_symbol_283.evaluate(evaluator, T_Boolean, A_symbol_282, S_select);
					rightA_symbol_279 = A_symbol_283;
				} catch (InvalidValueException e) {
					rightA_symbol_279 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_283 = rightA_symbol_279;
				DomainType static_A_symbol_279 = valueFactory.typeOf(A_symbol_281);
				LibraryBinaryOperation dynamic_A_symbol_279 = (LibraryBinaryOperation)static_A_symbol_279.lookupImplementation(standardLibrary, O_Boolean_or);
				Value A_symbol_279 = dynamic_A_symbol_279.evaluate(evaluator, T_Boolean, A_symbol_281, A_symbol_283);
				leftA_symbol_278 = A_symbol_279;
			} catch (InvalidValueException e) {
				leftA_symbol_278 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_279 = leftA_symbol_278;
			Value rightA_symbol_278;
			try {
				
				Value A_symbol_284 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_285 = valueFactory.typeOf(A_symbol_284, T_ClassClassifier_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_285 = (LibraryBinaryOperation)static_A_symbol_285.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_285 = dynamic_A_symbol_285.evaluate(evaluator, T_Boolean, A_symbol_284, T_ClassClassifier_Boolean_);
				rightA_symbol_278 = A_symbol_285;
			} catch (InvalidValueException e) {
				rightA_symbol_278 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_285 = rightA_symbol_278;
			DomainType static_A_symbol_278 = valueFactory.typeOf(A_symbol_279);
			LibraryBinaryOperation dynamic_A_symbol_278 = (LibraryBinaryOperation)static_A_symbol_278.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_278 = dynamic_A_symbol_278.evaluate(evaluator, T_Boolean, A_symbol_279, A_symbol_285);
			return A_symbol_278;
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
			
			Value leftA_symbol_286;
			try {
				Value leftA_symbol_287;
				try {
					
					Value A_symbol_288 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
					
					DomainType static_A_symbol_289 = valueFactory.typeOf(A_symbol_288, S_reject);
					LibraryBinaryOperation dynamic_A_symbol_289 = (LibraryBinaryOperation)static_A_symbol_289.lookupImplementation(standardLibrary, O_String__eq_);
					Value A_symbol_289 = dynamic_A_symbol_289.evaluate(evaluator, T_Boolean, A_symbol_288, S_reject);
					leftA_symbol_287 = A_symbol_289;
				} catch (InvalidValueException e) {
					leftA_symbol_287 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_289 = leftA_symbol_287;
				Value rightA_symbol_287;
				try {
					
					Value A_symbol_290 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
					
					DomainType static_A_symbol_291 = valueFactory.typeOf(A_symbol_290, S_select);
					LibraryBinaryOperation dynamic_A_symbol_291 = (LibraryBinaryOperation)static_A_symbol_291.lookupImplementation(standardLibrary, O_String__eq_);
					Value A_symbol_291 = dynamic_A_symbol_291.evaluate(evaluator, T_Boolean, A_symbol_290, S_select);
					rightA_symbol_287 = A_symbol_291;
				} catch (InvalidValueException e) {
					rightA_symbol_287 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_291 = rightA_symbol_287;
				DomainType static_A_symbol_287 = valueFactory.typeOf(A_symbol_289);
				LibraryBinaryOperation dynamic_A_symbol_287 = (LibraryBinaryOperation)static_A_symbol_287.lookupImplementation(standardLibrary, O_Boolean_or);
				Value A_symbol_287 = dynamic_A_symbol_287.evaluate(evaluator, T_Boolean, A_symbol_289, A_symbol_291);
				leftA_symbol_286 = A_symbol_287;
			} catch (InvalidValueException e) {
				leftA_symbol_286 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_287 = leftA_symbol_286;
			Value rightA_symbol_286;
			try {
				
				Value A_symbol_292 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				
				Value A_symbol_293 = IP_CallExp_source.evaluate(evaluator, T_pivot__OCLExpression, self, P_CallExp_source);
				
				Value A_symbol_294 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_293, P_TypedElement_type);
				
				DomainType static_A_symbol_295 = valueFactory.typeOf(A_symbol_292, A_symbol_294);
				LibraryBinaryOperation dynamic_A_symbol_295 = (LibraryBinaryOperation)static_A_symbol_295.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_295 = dynamic_A_symbol_295.evaluate(evaluator, T_Boolean, A_symbol_292, A_symbol_294);
				rightA_symbol_286 = A_symbol_295;
			} catch (InvalidValueException e) {
				rightA_symbol_286 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_295 = rightA_symbol_286;
			DomainType static_A_symbol_286 = valueFactory.typeOf(A_symbol_287);
			LibraryBinaryOperation dynamic_A_symbol_286 = (LibraryBinaryOperation)static_A_symbol_286.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_286 = dynamic_A_symbol_286.evaluate(evaluator, T_Boolean, A_symbol_287, A_symbol_295);
			return A_symbol_286;
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
			
			Value leftA_symbol_296;
			try {
				
				Value A_symbol_297 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_298 = valueFactory.typeOf(A_symbol_297, S_sortedBy);
				LibraryBinaryOperation dynamic_A_symbol_298 = (LibraryBinaryOperation)static_A_symbol_298.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_298 = dynamic_A_symbol_298.evaluate(evaluator, T_Boolean, A_symbol_297, S_sortedBy);
				leftA_symbol_296 = A_symbol_298;
			} catch (InvalidValueException e) {
				leftA_symbol_296 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_298 = leftA_symbol_296;
			Value rightA_symbol_296;
			try {
				
				Value A_symbol_299 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_300 = valueFactory.typeOf(A_symbol_299);
				LibraryBinaryOperation dynamic_A_symbol_300 = (LibraryBinaryOperation)static_A_symbol_300.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_300 = dynamic_A_symbol_300.evaluate(evaluator, T_pivot__CollectionType, A_symbol_299, T_ClassClassifier_pivot__CollectionType_);
				Value A_symbol_301 = IP_CollectionType_elementType.evaluate(evaluator, T_Type, A_symbol_300, P_CollectionType_elementType);
				
				
				Value A_symbol_302 = IP_LoopExp_body.evaluate(evaluator, T_pivot__OCLExpression, self, P_LoopExp_body);
				
				Value A_symbol_303 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_302, P_TypedElement_type);
				
				DomainType static_A_symbol_304 = valueFactory.typeOf(A_symbol_303);
				LibraryBinaryOperation dynamic_A_symbol_304 = (LibraryBinaryOperation)static_A_symbol_304.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_304 = dynamic_A_symbol_304.evaluate(evaluator, T_pivot__CollectionType, A_symbol_303, T_ClassClassifier_pivot__CollectionType_);
				Value A_symbol_305 = IP_CollectionType_elementType.evaluate(evaluator, T_Type, A_symbol_304, P_CollectionType_elementType);
				
				DomainType static_A_symbol_306 = valueFactory.typeOf(A_symbol_301, A_symbol_305);
				LibraryBinaryOperation dynamic_A_symbol_306 = (LibraryBinaryOperation)static_A_symbol_306.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_306 = dynamic_A_symbol_306.evaluate(evaluator, T_Boolean, A_symbol_301, A_symbol_305);
				rightA_symbol_296 = A_symbol_306;
			} catch (InvalidValueException e) {
				rightA_symbol_296 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_306 = rightA_symbol_296;
			DomainType static_A_symbol_296 = valueFactory.typeOf(A_symbol_298);
			LibraryBinaryOperation dynamic_A_symbol_296 = (LibraryBinaryOperation)static_A_symbol_296.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_296 = dynamic_A_symbol_296.evaluate(evaluator, T_Boolean, A_symbol_298, A_symbol_306);
			return A_symbol_296;
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
			
			Value leftA_symbol_307;
			try {
				
				Value A_symbol_308 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_309 = valueFactory.typeOf(A_symbol_308, S_sortedBy);
				LibraryBinaryOperation dynamic_A_symbol_309 = (LibraryBinaryOperation)static_A_symbol_309.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_309 = dynamic_A_symbol_309.evaluate(evaluator, T_Boolean, A_symbol_308, S_sortedBy);
				leftA_symbol_307 = A_symbol_309;
			} catch (InvalidValueException e) {
				leftA_symbol_307 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_309 = leftA_symbol_307;
			Value rightA_symbol_307;
			try {
				
				Value A_symbol_310 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_311 = valueFactory.typeOf(A_symbol_310);
				LibraryUnaryOperation dynamic_A_symbol_311 = (LibraryUnaryOperation)static_A_symbol_311.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_311 = dynamic_A_symbol_311.evaluate(evaluator, T_Integer, A_symbol_310);
				DomainType static_A_symbol_312 = valueFactory.typeOf(A_symbol_311, I_1);
				LibraryBinaryOperation dynamic_A_symbol_312 = (LibraryBinaryOperation)static_A_symbol_312.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_312 = dynamic_A_symbol_312.evaluate(evaluator, T_Boolean, A_symbol_311, I_1);
				rightA_symbol_307 = A_symbol_312;
			} catch (InvalidValueException e) {
				rightA_symbol_307 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_312 = rightA_symbol_307;
			DomainType static_A_symbol_307 = valueFactory.typeOf(A_symbol_309);
			LibraryBinaryOperation dynamic_A_symbol_307 = (LibraryBinaryOperation)static_A_symbol_307.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_307 = dynamic_A_symbol_307.evaluate(evaluator, T_Boolean, A_symbol_309, A_symbol_312);
			return A_symbol_307;
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
			
			Value leftA_symbol_313;
			try {
				
				Value A_symbol_314 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_315 = valueFactory.typeOf(A_symbol_314, S_sortedBy);
				LibraryBinaryOperation dynamic_A_symbol_315 = (LibraryBinaryOperation)static_A_symbol_315.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_315 = dynamic_A_symbol_315.evaluate(evaluator, T_Boolean, A_symbol_314, S_sortedBy);
				leftA_symbol_313 = A_symbol_315;
			} catch (InvalidValueException e) {
				leftA_symbol_313 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_315 = leftA_symbol_313;
			Value rightA_symbol_313;
			try {
					Value leftA_symbol_316;
					try {
						
						Value A_symbol_317 = IP_CallExp_source.evaluate(evaluator, T_pivot__OCLExpression, self, P_CallExp_source);
						
						Value A_symbol_318 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_317, P_TypedElement_type);
						
						DomainType static_A_symbol_319 = valueFactory.typeOf(A_symbol_318);
						LibraryBinaryOperation dynamic_A_symbol_319 = (LibraryBinaryOperation)static_A_symbol_319.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Value A_symbol_319 = dynamic_A_symbol_319.evaluate(evaluator, T_Boolean, A_symbol_318, T_ClassClassifier_pivot__SequenceType_);
						leftA_symbol_316 = A_symbol_319;
					} catch (InvalidValueException e) {
						leftA_symbol_316 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_319 = leftA_symbol_316;
					Value rightA_symbol_316;
					try {
						
						Value A_symbol_320 = IP_CallExp_source.evaluate(evaluator, T_pivot__OCLExpression, self, P_CallExp_source);
						
						Value A_symbol_321 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_320, P_TypedElement_type);
						
						DomainType static_A_symbol_322 = valueFactory.typeOf(A_symbol_321);
						LibraryBinaryOperation dynamic_A_symbol_322 = (LibraryBinaryOperation)static_A_symbol_322.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Value A_symbol_322 = dynamic_A_symbol_322.evaluate(evaluator, T_Boolean, A_symbol_321, T_ClassClassifier_pivot__BagType_);
						rightA_symbol_316 = A_symbol_322;
					} catch (InvalidValueException e) {
						rightA_symbol_316 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_322 = rightA_symbol_316;
					DomainType static_A_symbol_316 = valueFactory.typeOf(A_symbol_319);
					LibraryBinaryOperation dynamic_A_symbol_316 = (LibraryBinaryOperation)static_A_symbol_316.lookupImplementation(standardLibrary, O_Boolean_or);
					Value A_symbol_316 = dynamic_A_symbol_316.evaluate(evaluator, T_Boolean, A_symbol_319, A_symbol_322);
				Value A_symbol_323;
				if (A_symbol_316.isTrue()) {
					
					Value A_symbol_324 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
					
					DomainType static_A_symbol_325 = valueFactory.typeOf(A_symbol_324);
					LibraryBinaryOperation dynamic_A_symbol_325 = (LibraryBinaryOperation)static_A_symbol_325.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Value A_symbol_325 = dynamic_A_symbol_325.evaluate(evaluator, T_Boolean, A_symbol_324, T_ClassClassifier_pivot__SequenceType_);
					A_symbol_323 = A_symbol_325;
				}
				else if (A_symbol_316.isFalse()) {
					
					Value A_symbol_326 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
					
					DomainType static_A_symbol_327 = valueFactory.typeOf(A_symbol_326);
					LibraryBinaryOperation dynamic_A_symbol_327 = (LibraryBinaryOperation)static_A_symbol_327.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Value A_symbol_327 = dynamic_A_symbol_327.evaluate(evaluator, T_Boolean, A_symbol_326, T_ClassClassifier_pivot__OrderedSetType_);
					A_symbol_323 = A_symbol_327;
				}
				else if (A_symbol_316.isNull()) {
					A_symbol_323 = valueFactory.throwInvalidValueException("null if condition");
				}
				else {
					A_symbol_323 = valueFactory.throwInvalidValueException("invalid if condition");
				}
				rightA_symbol_313 = A_symbol_323;
			} catch (InvalidValueException e) {
				rightA_symbol_313 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_323 = rightA_symbol_313;
			DomainType static_A_symbol_313 = valueFactory.typeOf(A_symbol_315);
			LibraryBinaryOperation dynamic_A_symbol_313 = (LibraryBinaryOperation)static_A_symbol_313.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_313 = dynamic_A_symbol_313.evaluate(evaluator, T_Boolean, A_symbol_315, A_symbol_323);
			return A_symbol_313;
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

