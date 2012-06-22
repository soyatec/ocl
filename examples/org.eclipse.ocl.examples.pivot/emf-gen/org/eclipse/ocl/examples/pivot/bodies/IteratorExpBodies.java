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
			
			Value leftA_symbol_87;
			try {
				
				Value A_symbol_88 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_89 = valueFactory.typeOf(A_symbol_88, S_any);
				LibraryBinaryOperation dynamic_A_symbol_89 = (LibraryBinaryOperation)static_A_symbol_89.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_89 = dynamic_A_symbol_89.evaluate(evaluator, T_Boolean, A_symbol_88, S_any);
				leftA_symbol_87 = A_symbol_89;
			} catch (InvalidValueException e) {
				leftA_symbol_87 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_89 = leftA_symbol_87;
			Value rightA_symbol_87;
			try {
				
				Value A_symbol_90 = IP_LoopExp_body.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_LoopExp_body);
				
				Value A_symbol_91 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_90, P_TypedElement_type);
				
				DomainType static_A_symbol_92 = valueFactory.typeOf(A_symbol_91, S_Boolean);
				LibraryBinaryOperation dynamic_A_symbol_92 = (LibraryBinaryOperation)static_A_symbol_92.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_92 = dynamic_A_symbol_92.evaluate(evaluator, T_Boolean, A_symbol_91, S_Boolean);
				rightA_symbol_87 = A_symbol_92;
			} catch (InvalidValueException e) {
				rightA_symbol_87 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_92 = rightA_symbol_87;
			DomainType static_A_symbol_87 = valueFactory.typeOf(A_symbol_89);
			LibraryBinaryOperation dynamic_A_symbol_87 = (LibraryBinaryOperation)static_A_symbol_87.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_87 = dynamic_A_symbol_87.evaluate(evaluator, T_Boolean, A_symbol_89, A_symbol_92);
			return A_symbol_87;
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
			
			Value leftA_symbol_93;
			try {
				
				Value A_symbol_94 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_95 = valueFactory.typeOf(A_symbol_94, S_any);
				LibraryBinaryOperation dynamic_A_symbol_95 = (LibraryBinaryOperation)static_A_symbol_95.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_95 = dynamic_A_symbol_95.evaluate(evaluator, T_Boolean, A_symbol_94, S_any);
				leftA_symbol_93 = A_symbol_95;
			} catch (InvalidValueException e) {
				leftA_symbol_93 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_95 = leftA_symbol_93;
			Value rightA_symbol_93;
			try {
				
				Value A_symbol_96 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_Pivot_ecore__pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_97 = valueFactory.typeOf(A_symbol_96);
				LibraryUnaryOperation dynamic_A_symbol_97 = (LibraryUnaryOperation)static_A_symbol_97.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_97 = dynamic_A_symbol_97.evaluate(evaluator, T_Integer, A_symbol_96);
				DomainType static_A_symbol_98 = valueFactory.typeOf(A_symbol_97, I_1);
				LibraryBinaryOperation dynamic_A_symbol_98 = (LibraryBinaryOperation)static_A_symbol_98.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_98 = dynamic_A_symbol_98.evaluate(evaluator, T_Boolean, A_symbol_97, I_1);
				rightA_symbol_93 = A_symbol_98;
			} catch (InvalidValueException e) {
				rightA_symbol_93 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_98 = rightA_symbol_93;
			DomainType static_A_symbol_93 = valueFactory.typeOf(A_symbol_95);
			LibraryBinaryOperation dynamic_A_symbol_93 = (LibraryBinaryOperation)static_A_symbol_93.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_93 = dynamic_A_symbol_93.evaluate(evaluator, T_Boolean, A_symbol_95, A_symbol_98);
			return A_symbol_93;
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
			
			Value leftA_symbol_99;
			try {
				
				Value A_symbol_100 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_101 = valueFactory.typeOf(A_symbol_100, S_any);
				LibraryBinaryOperation dynamic_A_symbol_101 = (LibraryBinaryOperation)static_A_symbol_101.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_101 = dynamic_A_symbol_101.evaluate(evaluator, T_Boolean, A_symbol_100, S_any);
				leftA_symbol_99 = A_symbol_101;
			} catch (InvalidValueException e) {
				leftA_symbol_99 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_101 = leftA_symbol_99;
			Value rightA_symbol_99;
			try {
				
				Value A_symbol_102 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				
				Value A_symbol_103 = IP_CallExp_source.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_CallExp_source);
				
				Value A_symbol_104 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_103, P_TypedElement_type);
				
				DomainType static_A_symbol_105 = valueFactory.typeOf(A_symbol_104);
				LibraryBinaryOperation dynamic_A_symbol_105 = (LibraryBinaryOperation)static_A_symbol_105.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_105 = dynamic_A_symbol_105.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionType, A_symbol_104, T_ClassClassifier_Pivot_ecore__pivot__CollectionType_);
				Value A_symbol_106 = IP_CollectionType_elementType.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_105, P_CollectionType_elementType);
				
				DomainType static_A_symbol_107 = valueFactory.typeOf(A_symbol_102, A_symbol_106);
				LibraryBinaryOperation dynamic_A_symbol_107 = (LibraryBinaryOperation)static_A_symbol_107.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_107 = dynamic_A_symbol_107.evaluate(evaluator, T_Boolean, A_symbol_102, A_symbol_106);
				rightA_symbol_99 = A_symbol_107;
			} catch (InvalidValueException e) {
				rightA_symbol_99 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_107 = rightA_symbol_99;
			DomainType static_A_symbol_99 = valueFactory.typeOf(A_symbol_101);
			LibraryBinaryOperation dynamic_A_symbol_99 = (LibraryBinaryOperation)static_A_symbol_99.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_99 = dynamic_A_symbol_99.evaluate(evaluator, T_Boolean, A_symbol_101, A_symbol_107);
			return A_symbol_99;
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
			
			Value leftA_symbol_108;
			try {
				
				Value A_symbol_109 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_110 = valueFactory.typeOf(A_symbol_109, S_closure);
				LibraryBinaryOperation dynamic_A_symbol_110 = (LibraryBinaryOperation)static_A_symbol_110.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_110 = dynamic_A_symbol_110.evaluate(evaluator, T_Boolean, A_symbol_109, S_closure);
				leftA_symbol_108 = A_symbol_110;
			} catch (InvalidValueException e) {
				leftA_symbol_108 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_110 = leftA_symbol_108;
			Value rightA_symbol_108;
			try {
				
				Value A_symbol_111 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_112 = valueFactory.typeOf(A_symbol_111);
				LibraryBinaryOperation dynamic_A_symbol_112 = (LibraryBinaryOperation)static_A_symbol_112.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_112 = dynamic_A_symbol_112.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionType, A_symbol_111, T_ClassClassifier_Pivot_ecore__pivot__CollectionType_);
				Value A_symbol_113 = IP_CollectionType_elementType.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_112, P_CollectionType_elementType);
				
				
				Value A_symbol_114 = IP_CallExp_source.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_CallExp_source);
				
				Value A_symbol_115 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_114, P_TypedElement_type);
				
				DomainType static_A_symbol_116 = valueFactory.typeOf(A_symbol_115);
				LibraryBinaryOperation dynamic_A_symbol_116 = (LibraryBinaryOperation)static_A_symbol_116.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_116 = dynamic_A_symbol_116.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionType, A_symbol_115, T_ClassClassifier_Pivot_ecore__pivot__CollectionType_);
				Value A_symbol_117 = IP_CollectionType_elementType.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_116, P_CollectionType_elementType);
				
				DomainType static_A_symbol_118 = valueFactory.typeOf(A_symbol_113, A_symbol_117);
				LibraryBinaryOperation dynamic_A_symbol_118 = (LibraryBinaryOperation)static_A_symbol_118.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_118 = dynamic_A_symbol_118.evaluate(evaluator, T_Boolean, A_symbol_113, A_symbol_117);
				rightA_symbol_108 = A_symbol_118;
			} catch (InvalidValueException e) {
				rightA_symbol_108 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_118 = rightA_symbol_108;
			DomainType static_A_symbol_108 = valueFactory.typeOf(A_symbol_110);
			LibraryBinaryOperation dynamic_A_symbol_108 = (LibraryBinaryOperation)static_A_symbol_108.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_108 = dynamic_A_symbol_108.evaluate(evaluator, T_Boolean, A_symbol_110, A_symbol_118);
			return A_symbol_108;
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
			
			Value leftA_symbol_119;
			try {
				
				Value A_symbol_120 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_121 = valueFactory.typeOf(A_symbol_120, S_closure);
				LibraryBinaryOperation dynamic_A_symbol_121 = (LibraryBinaryOperation)static_A_symbol_121.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_121 = dynamic_A_symbol_121.evaluate(evaluator, T_Boolean, A_symbol_120, S_closure);
				leftA_symbol_119 = A_symbol_121;
			} catch (InvalidValueException e) {
				leftA_symbol_119 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_121 = leftA_symbol_119;
			Value rightA_symbol_119;
			try {
				
				Value A_symbol_122 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_Pivot_ecore__pivot__Variable_, self, P_LoopExp_iterator);
				
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
			
			Value leftA_symbol_125;
			try {
				
				Value A_symbol_126 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_127 = valueFactory.typeOf(A_symbol_126, S_closure);
				LibraryBinaryOperation dynamic_A_symbol_127 = (LibraryBinaryOperation)static_A_symbol_127.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_127 = dynamic_A_symbol_127.evaluate(evaluator, T_Boolean, A_symbol_126, S_closure);
				leftA_symbol_125 = A_symbol_127;
			} catch (InvalidValueException e) {
				leftA_symbol_125 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_127 = leftA_symbol_125;
			Value rightA_symbol_125;
			try {
				
				Value A_symbol_128 = IP_CallExp_source.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_CallExp_source);
				
				Value A_symbol_129 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_128, P_TypedElement_type);
				
				DomainType static_A_symbol_130 = valueFactory.typeOf(A_symbol_129);
				LibraryBinaryOperation dynamic_A_symbol_130 = (LibraryBinaryOperation)static_A_symbol_130.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_130 = dynamic_A_symbol_130.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionType, A_symbol_129, T_ClassClassifier_Pivot_ecore__pivot__CollectionType_);
				Value A_symbol_131 = IP_CollectionType_elementType.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_130, P_CollectionType_elementType);
				
					
					Value A_symbol_132 = IP_LoopExp_body.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_LoopExp_body);
					
					Value A_symbol_133 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_132, P_TypedElement_type);
					
					DomainType static_A_symbol_134 = valueFactory.typeOf(A_symbol_133);
					LibraryBinaryOperation dynamic_A_symbol_134 = (LibraryBinaryOperation)static_A_symbol_134.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Value A_symbol_134 = dynamic_A_symbol_134.evaluate(evaluator, T_Boolean, A_symbol_133, T_ClassClassifier_Pivot_ecore__pivot__CollectionType_);
				Value A_symbol_135;
				if (A_symbol_134.isTrue()) {
					
					Value A_symbol_136 = IP_LoopExp_body.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_LoopExp_body);
					
					Value A_symbol_137 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_136, P_TypedElement_type);
					
					DomainType static_A_symbol_138 = valueFactory.typeOf(A_symbol_137);
					LibraryBinaryOperation dynamic_A_symbol_138 = (LibraryBinaryOperation)static_A_symbol_138.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
					Value A_symbol_138 = dynamic_A_symbol_138.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionType, A_symbol_137, T_ClassClassifier_Pivot_ecore__pivot__CollectionType_);
					Value A_symbol_139 = IP_CollectionType_elementType.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_138, P_CollectionType_elementType);
					
					A_symbol_135 = A_symbol_139;
				}
				else if (A_symbol_134.isFalse()) {
					
					Value A_symbol_140 = IP_LoopExp_body.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_LoopExp_body);
					
					Value A_symbol_141 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_140, P_TypedElement_type);
					
					A_symbol_135 = A_symbol_141;
				}
				else if (A_symbol_134.isNull()) {
					A_symbol_135 = valueFactory.throwInvalidValueException("null if condition");
				}
				else {
					A_symbol_135 = valueFactory.throwInvalidValueException("invalid if condition");
				}
				DomainType static_A_symbol_142 = valueFactory.typeOf(A_symbol_131, A_symbol_135);
				LibraryBinaryOperation dynamic_A_symbol_142 = (LibraryBinaryOperation)static_A_symbol_142.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_142 = dynamic_A_symbol_142.evaluate(evaluator, T_Boolean, A_symbol_131, A_symbol_135);
				rightA_symbol_125 = A_symbol_142;
			} catch (InvalidValueException e) {
				rightA_symbol_125 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_142 = rightA_symbol_125;
			DomainType static_A_symbol_125 = valueFactory.typeOf(A_symbol_127);
			LibraryBinaryOperation dynamic_A_symbol_125 = (LibraryBinaryOperation)static_A_symbol_125.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_125 = dynamic_A_symbol_125.evaluate(evaluator, T_Boolean, A_symbol_127, A_symbol_142);
			return A_symbol_125;
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
			
			Value leftA_symbol_143;
			try {
				
				Value A_symbol_144 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_145 = valueFactory.typeOf(A_symbol_144, S_closure);
				LibraryBinaryOperation dynamic_A_symbol_145 = (LibraryBinaryOperation)static_A_symbol_145.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_145 = dynamic_A_symbol_145.evaluate(evaluator, T_Boolean, A_symbol_144, S_closure);
				leftA_symbol_143 = A_symbol_145;
			} catch (InvalidValueException e) {
				leftA_symbol_143 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_145 = leftA_symbol_143;
			Value rightA_symbol_143;
			try {
					Value leftA_symbol_146;
					try {
						
						Value A_symbol_147 = IP_CallExp_source.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_CallExp_source);
						
						Value A_symbol_148 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_147, P_TypedElement_type);
						
						DomainType static_A_symbol_149 = valueFactory.typeOf(A_symbol_148);
						LibraryBinaryOperation dynamic_A_symbol_149 = (LibraryBinaryOperation)static_A_symbol_149.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Value A_symbol_149 = dynamic_A_symbol_149.evaluate(evaluator, T_Boolean, A_symbol_148, T_ClassClassifier_Pivot_ecore__pivot__SequenceType_);
						leftA_symbol_146 = A_symbol_149;
					} catch (InvalidValueException e) {
						leftA_symbol_146 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_149 = leftA_symbol_146;
					Value rightA_symbol_146;
					try {
						
						Value A_symbol_150 = IP_CallExp_source.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_CallExp_source);
						
						Value A_symbol_151 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_150, P_TypedElement_type);
						
						DomainType static_A_symbol_152 = valueFactory.typeOf(A_symbol_151);
						LibraryBinaryOperation dynamic_A_symbol_152 = (LibraryBinaryOperation)static_A_symbol_152.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Value A_symbol_152 = dynamic_A_symbol_152.evaluate(evaluator, T_Boolean, A_symbol_151, T_ClassClassifier_Pivot_ecore__pivot__OrderedSetType_);
						rightA_symbol_146 = A_symbol_152;
					} catch (InvalidValueException e) {
						rightA_symbol_146 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_152 = rightA_symbol_146;
					DomainType static_A_symbol_146 = valueFactory.typeOf(A_symbol_149);
					LibraryBinaryOperation dynamic_A_symbol_146 = (LibraryBinaryOperation)static_A_symbol_146.lookupImplementation(standardLibrary, O_Boolean_or);
					Value A_symbol_146 = dynamic_A_symbol_146.evaluate(evaluator, T_Boolean, A_symbol_149, A_symbol_152);
				Value A_symbol_153;
				if (A_symbol_146.isTrue()) {
					
					Value A_symbol_154 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
					
					DomainType static_A_symbol_155 = valueFactory.typeOf(A_symbol_154);
					LibraryBinaryOperation dynamic_A_symbol_155 = (LibraryBinaryOperation)static_A_symbol_155.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Value A_symbol_155 = dynamic_A_symbol_155.evaluate(evaluator, T_Boolean, A_symbol_154, T_ClassClassifier_Pivot_ecore__pivot__OrderedSetType_);
					A_symbol_153 = A_symbol_155;
				}
				else if (A_symbol_146.isFalse()) {
					
					Value A_symbol_156 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
					
					DomainType static_A_symbol_157 = valueFactory.typeOf(A_symbol_156);
					LibraryBinaryOperation dynamic_A_symbol_157 = (LibraryBinaryOperation)static_A_symbol_157.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Value A_symbol_157 = dynamic_A_symbol_157.evaluate(evaluator, T_Boolean, A_symbol_156, T_ClassClassifier_Pivot_ecore__pivot__SetType_);
					A_symbol_153 = A_symbol_157;
				}
				else if (A_symbol_146.isNull()) {
					A_symbol_153 = valueFactory.throwInvalidValueException("null if condition");
				}
				else {
					A_symbol_153 = valueFactory.throwInvalidValueException("invalid if condition");
				}
				rightA_symbol_143 = A_symbol_153;
			} catch (InvalidValueException e) {
				rightA_symbol_143 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_153 = rightA_symbol_143;
			DomainType static_A_symbol_143 = valueFactory.typeOf(A_symbol_145);
			LibraryBinaryOperation dynamic_A_symbol_143 = (LibraryBinaryOperation)static_A_symbol_143.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_143 = dynamic_A_symbol_143.evaluate(evaluator, T_Boolean, A_symbol_145, A_symbol_153);
			return A_symbol_143;
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
			
			Value leftA_symbol_158;
			try {
				
				Value A_symbol_159 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_160 = valueFactory.typeOf(A_symbol_159, S_collect);
				LibraryBinaryOperation dynamic_A_symbol_160 = (LibraryBinaryOperation)static_A_symbol_160.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_160 = dynamic_A_symbol_160.evaluate(evaluator, T_Boolean, A_symbol_159, S_collect);
				leftA_symbol_158 = A_symbol_160;
			} catch (InvalidValueException e) {
				leftA_symbol_158 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_160 = leftA_symbol_158;
			Value rightA_symbol_158;
			try {
				
				Value A_symbol_161 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_162 = valueFactory.typeOf(A_symbol_161);
				LibraryBinaryOperation dynamic_A_symbol_162 = (LibraryBinaryOperation)static_A_symbol_162.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_162 = dynamic_A_symbol_162.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionType, A_symbol_161, T_ClassClassifier_Pivot_ecore__pivot__CollectionType_);
				Value A_symbol_163 = IP_CollectionType_elementType.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_162, P_CollectionType_elementType);
				
				
				Value A_symbol_164 = IP_LoopExp_body.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_LoopExp_body);
				
				Value A_symbol_165 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_164, P_TypedElement_type);
				
				DomainType static_A_symbol_166 = valueFactory.typeOf(A_symbol_165);
				LibraryBinaryOperation dynamic_A_symbol_166 = (LibraryBinaryOperation)static_A_symbol_166.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_166 = dynamic_A_symbol_166.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionType, A_symbol_165, T_ClassClassifier_Pivot_ecore__pivot__CollectionType_);
				Value A_symbol_167 = IP_CollectionType_elementType.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_166, P_CollectionType_elementType);
				
				DomainType static_A_symbol_168 = valueFactory.typeOf(A_symbol_163, A_symbol_167);
				LibraryBinaryOperation dynamic_A_symbol_168 = (LibraryBinaryOperation)static_A_symbol_168.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_168 = dynamic_A_symbol_168.evaluate(evaluator, T_Boolean, A_symbol_163, A_symbol_167);
				rightA_symbol_158 = A_symbol_168;
			} catch (InvalidValueException e) {
				rightA_symbol_158 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_168 = rightA_symbol_158;
			DomainType static_A_symbol_158 = valueFactory.typeOf(A_symbol_160);
			LibraryBinaryOperation dynamic_A_symbol_158 = (LibraryBinaryOperation)static_A_symbol_158.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_158 = dynamic_A_symbol_158.evaluate(evaluator, T_Boolean, A_symbol_160, A_symbol_168);
			return A_symbol_158;
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
			
			Value leftA_symbol_169;
			try {
				
				Value A_symbol_170 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_171 = valueFactory.typeOf(A_symbol_170, S_collect);
				LibraryBinaryOperation dynamic_A_symbol_171 = (LibraryBinaryOperation)static_A_symbol_171.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_171 = dynamic_A_symbol_171.evaluate(evaluator, T_Boolean, A_symbol_170, S_collect);
				leftA_symbol_169 = A_symbol_171;
			} catch (InvalidValueException e) {
				leftA_symbol_169 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_171 = leftA_symbol_169;
			Value rightA_symbol_169;
			try {
				
				Value A_symbol_172 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_Pivot_ecore__pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_173 = valueFactory.typeOf(A_symbol_172);
				LibraryUnaryOperation dynamic_A_symbol_173 = (LibraryUnaryOperation)static_A_symbol_173.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_173 = dynamic_A_symbol_173.evaluate(evaluator, T_Integer, A_symbol_172);
				DomainType static_A_symbol_174 = valueFactory.typeOf(A_symbol_173, I_1);
				LibraryBinaryOperation dynamic_A_symbol_174 = (LibraryBinaryOperation)static_A_symbol_174.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_174 = dynamic_A_symbol_174.evaluate(evaluator, T_Boolean, A_symbol_173, I_1);
				rightA_symbol_169 = A_symbol_174;
			} catch (InvalidValueException e) {
				rightA_symbol_169 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_174 = rightA_symbol_169;
			DomainType static_A_symbol_169 = valueFactory.typeOf(A_symbol_171);
			LibraryBinaryOperation dynamic_A_symbol_169 = (LibraryBinaryOperation)static_A_symbol_169.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_169 = dynamic_A_symbol_169.evaluate(evaluator, T_Boolean, A_symbol_171, A_symbol_174);
			return A_symbol_169;
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
			
			Value leftA_symbol_175;
			try {
				
				Value A_symbol_176 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_177 = valueFactory.typeOf(A_symbol_176, S_collectN___);
				LibraryBinaryOperation dynamic_A_symbol_177 = (LibraryBinaryOperation)static_A_symbol_177.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_177 = dynamic_A_symbol_177.evaluate(evaluator, T_Boolean, A_symbol_176, S_collectN___);
				leftA_symbol_175 = A_symbol_177;
			} catch (InvalidValueException e) {
				leftA_symbol_175 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_177 = leftA_symbol_175;
			Value rightA_symbol_175;
			try {
				
				Value A_symbol_178 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_Pivot_ecore__pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_179 = valueFactory.typeOf(A_symbol_178);
				LibraryUnaryOperation dynamic_A_symbol_179 = (LibraryUnaryOperation)static_A_symbol_179.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_179 = dynamic_A_symbol_179.evaluate(evaluator, T_Integer, A_symbol_178);
				DomainType static_A_symbol_180 = valueFactory.typeOf(A_symbol_179, I_1);
				LibraryBinaryOperation dynamic_A_symbol_180 = (LibraryBinaryOperation)static_A_symbol_180.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_180 = dynamic_A_symbol_180.evaluate(evaluator, T_Boolean, A_symbol_179, I_1);
				rightA_symbol_175 = A_symbol_180;
			} catch (InvalidValueException e) {
				rightA_symbol_175 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_180 = rightA_symbol_175;
			DomainType static_A_symbol_175 = valueFactory.typeOf(A_symbol_177);
			LibraryBinaryOperation dynamic_A_symbol_175 = (LibraryBinaryOperation)static_A_symbol_175.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_175 = dynamic_A_symbol_175.evaluate(evaluator, T_Boolean, A_symbol_177, A_symbol_180);
			return A_symbol_175;
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
			
			Value leftA_symbol_181;
			try {
				
				Value A_symbol_182 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_183 = valueFactory.typeOf(A_symbol_182, S_collectN___);
				LibraryBinaryOperation dynamic_A_symbol_183 = (LibraryBinaryOperation)static_A_symbol_183.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_183 = dynamic_A_symbol_183.evaluate(evaluator, T_Boolean, A_symbol_182, S_collectN___);
				leftA_symbol_181 = A_symbol_183;
			} catch (InvalidValueException e) {
				leftA_symbol_181 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_183 = leftA_symbol_181;
			Value rightA_symbol_181;
			try {
				
				Value A_symbol_184 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_185 = valueFactory.typeOf(A_symbol_184);
				LibraryBinaryOperation dynamic_A_symbol_185 = (LibraryBinaryOperation)static_A_symbol_185.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
				Value A_symbol_185 = dynamic_A_symbol_185.evaluate(evaluator, T_Boolean, A_symbol_184, T_ClassClassifier_Pivot_ecore__pivot__BagType_);
				rightA_symbol_181 = A_symbol_185;
			} catch (InvalidValueException e) {
				rightA_symbol_181 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_185 = rightA_symbol_181;
			DomainType static_A_symbol_181 = valueFactory.typeOf(A_symbol_183);
			LibraryBinaryOperation dynamic_A_symbol_181 = (LibraryBinaryOperation)static_A_symbol_181.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_181 = dynamic_A_symbol_181.evaluate(evaluator, T_Boolean, A_symbol_183, A_symbol_185);
			return A_symbol_181;
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
			
			Value leftA_symbol_186;
			try {
				
				Value A_symbol_187 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_188 = valueFactory.typeOf(A_symbol_187, S_collectN___);
				LibraryBinaryOperation dynamic_A_symbol_188 = (LibraryBinaryOperation)static_A_symbol_188.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_188 = dynamic_A_symbol_188.evaluate(evaluator, T_Boolean, A_symbol_187, S_collectN___);
				leftA_symbol_186 = A_symbol_188;
			} catch (InvalidValueException e) {
				leftA_symbol_186 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_188 = leftA_symbol_186;
			Value rightA_symbol_186;
			try {
				
				Value A_symbol_189 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				
				Value A_symbol_190 = IP_LoopExp_body.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_LoopExp_body);
				
				Value A_symbol_191 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_190, P_TypedElement_type);
				
				DomainType static_A_symbol_192 = valueFactory.typeOf(A_symbol_189, A_symbol_191);
				LibraryBinaryOperation dynamic_A_symbol_192 = (LibraryBinaryOperation)static_A_symbol_192.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_192 = dynamic_A_symbol_192.evaluate(evaluator, T_Boolean, A_symbol_189, A_symbol_191);
				rightA_symbol_186 = A_symbol_192;
			} catch (InvalidValueException e) {
				rightA_symbol_186 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_192 = rightA_symbol_186;
			DomainType static_A_symbol_186 = valueFactory.typeOf(A_symbol_188);
			LibraryBinaryOperation dynamic_A_symbol_186 = (LibraryBinaryOperation)static_A_symbol_186.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_186 = dynamic_A_symbol_186.evaluate(evaluator, T_Boolean, A_symbol_188, A_symbol_192);
			return A_symbol_186;
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
			
			Value leftA_symbol_193;
			try {
				
				Value A_symbol_194 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_195 = valueFactory.typeOf(A_symbol_194, S_collect);
				LibraryBinaryOperation dynamic_A_symbol_195 = (LibraryBinaryOperation)static_A_symbol_195.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_195 = dynamic_A_symbol_195.evaluate(evaluator, T_Boolean, A_symbol_194, S_collect);
				leftA_symbol_193 = A_symbol_195;
			} catch (InvalidValueException e) {
				leftA_symbol_193 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_195 = leftA_symbol_193;
			Value rightA_symbol_193;
			try {
					Value leftA_symbol_196;
					try {
						
						Value A_symbol_197 = IP_CallExp_source.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_CallExp_source);
						
						Value A_symbol_198 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_197, P_TypedElement_type);
						
						DomainType static_A_symbol_199 = valueFactory.typeOf(A_symbol_198);
						LibraryBinaryOperation dynamic_A_symbol_199 = (LibraryBinaryOperation)static_A_symbol_199.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Value A_symbol_199 = dynamic_A_symbol_199.evaluate(evaluator, T_Boolean, A_symbol_198, T_ClassClassifier_Pivot_ecore__pivot__SequenceType_);
						leftA_symbol_196 = A_symbol_199;
					} catch (InvalidValueException e) {
						leftA_symbol_196 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_199 = leftA_symbol_196;
					Value rightA_symbol_196;
					try {
						
						Value A_symbol_200 = IP_CallExp_source.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_CallExp_source);
						
						Value A_symbol_201 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_200, P_TypedElement_type);
						
						DomainType static_A_symbol_202 = valueFactory.typeOf(A_symbol_201);
						LibraryBinaryOperation dynamic_A_symbol_202 = (LibraryBinaryOperation)static_A_symbol_202.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Value A_symbol_202 = dynamic_A_symbol_202.evaluate(evaluator, T_Boolean, A_symbol_201, T_ClassClassifier_Pivot_ecore__pivot__OrderedSetType_);
						rightA_symbol_196 = A_symbol_202;
					} catch (InvalidValueException e) {
						rightA_symbol_196 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_202 = rightA_symbol_196;
					DomainType static_A_symbol_196 = valueFactory.typeOf(A_symbol_199);
					LibraryBinaryOperation dynamic_A_symbol_196 = (LibraryBinaryOperation)static_A_symbol_196.lookupImplementation(standardLibrary, O_Boolean_or);
					Value A_symbol_196 = dynamic_A_symbol_196.evaluate(evaluator, T_Boolean, A_symbol_199, A_symbol_202);
				Value A_symbol_203;
				if (A_symbol_196.isTrue()) {
					
					Value A_symbol_204 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
					
					DomainType static_A_symbol_205 = valueFactory.typeOf(A_symbol_204);
					LibraryBinaryOperation dynamic_A_symbol_205 = (LibraryBinaryOperation)static_A_symbol_205.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Value A_symbol_205 = dynamic_A_symbol_205.evaluate(evaluator, T_Boolean, A_symbol_204, T_ClassClassifier_Pivot_ecore__pivot__SequenceType_);
					A_symbol_203 = A_symbol_205;
				}
				else if (A_symbol_196.isFalse()) {
					
					Value A_symbol_206 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
					
					DomainType static_A_symbol_207 = valueFactory.typeOf(A_symbol_206);
					LibraryBinaryOperation dynamic_A_symbol_207 = (LibraryBinaryOperation)static_A_symbol_207.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Value A_symbol_207 = dynamic_A_symbol_207.evaluate(evaluator, T_Boolean, A_symbol_206, T_ClassClassifier_Pivot_ecore__pivot__BagType_);
					A_symbol_203 = A_symbol_207;
				}
				else if (A_symbol_196.isNull()) {
					A_symbol_203 = valueFactory.throwInvalidValueException("null if condition");
				}
				else {
					A_symbol_203 = valueFactory.throwInvalidValueException("invalid if condition");
				}
				rightA_symbol_193 = A_symbol_203;
			} catch (InvalidValueException e) {
				rightA_symbol_193 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_203 = rightA_symbol_193;
			DomainType static_A_symbol_193 = valueFactory.typeOf(A_symbol_195);
			LibraryBinaryOperation dynamic_A_symbol_193 = (LibraryBinaryOperation)static_A_symbol_193.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_193 = dynamic_A_symbol_193.evaluate(evaluator, T_Boolean, A_symbol_195, A_symbol_203);
			return A_symbol_193;
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
			
			Value leftA_symbol_208;
			try {
				
				Value A_symbol_209 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_210 = valueFactory.typeOf(A_symbol_209, S_exists);
				LibraryBinaryOperation dynamic_A_symbol_210 = (LibraryBinaryOperation)static_A_symbol_210.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_210 = dynamic_A_symbol_210.evaluate(evaluator, T_Boolean, A_symbol_209, S_exists);
				leftA_symbol_208 = A_symbol_210;
			} catch (InvalidValueException e) {
				leftA_symbol_208 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_210 = leftA_symbol_208;
			Value rightA_symbol_208;
			try {
				
				Value A_symbol_211 = IP_LoopExp_body.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_LoopExp_body);
				
				Value A_symbol_212 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_211, P_TypedElement_type);
				
				DomainType static_A_symbol_213 = valueFactory.typeOf(A_symbol_212, T_ClassClassifier_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_213 = (LibraryBinaryOperation)static_A_symbol_213.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_213 = dynamic_A_symbol_213.evaluate(evaluator, T_Boolean, A_symbol_212, T_ClassClassifier_Boolean_);
				rightA_symbol_208 = A_symbol_213;
			} catch (InvalidValueException e) {
				rightA_symbol_208 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_213 = rightA_symbol_208;
			DomainType static_A_symbol_208 = valueFactory.typeOf(A_symbol_210);
			LibraryBinaryOperation dynamic_A_symbol_208 = (LibraryBinaryOperation)static_A_symbol_208.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_208 = dynamic_A_symbol_208.evaluate(evaluator, T_Boolean, A_symbol_210, A_symbol_213);
			return A_symbol_208;
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
			
			Value leftA_symbol_214;
			try {
				
				Value A_symbol_215 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_216 = valueFactory.typeOf(A_symbol_215, S_exists);
				LibraryBinaryOperation dynamic_A_symbol_216 = (LibraryBinaryOperation)static_A_symbol_216.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_216 = dynamic_A_symbol_216.evaluate(evaluator, T_Boolean, A_symbol_215, S_exists);
				leftA_symbol_214 = A_symbol_216;
			} catch (InvalidValueException e) {
				leftA_symbol_214 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_216 = leftA_symbol_214;
			Value rightA_symbol_214;
			try {
				
				Value A_symbol_217 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_218 = valueFactory.typeOf(A_symbol_217, T_ClassClassifier_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_218 = (LibraryBinaryOperation)static_A_symbol_218.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_218 = dynamic_A_symbol_218.evaluate(evaluator, T_Boolean, A_symbol_217, T_ClassClassifier_Boolean_);
				rightA_symbol_214 = A_symbol_218;
			} catch (InvalidValueException e) {
				rightA_symbol_214 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_218 = rightA_symbol_214;
			DomainType static_A_symbol_214 = valueFactory.typeOf(A_symbol_216);
			LibraryBinaryOperation dynamic_A_symbol_214 = (LibraryBinaryOperation)static_A_symbol_214.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_214 = dynamic_A_symbol_214.evaluate(evaluator, T_Boolean, A_symbol_216, A_symbol_218);
			return A_symbol_214;
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
			
			Value leftA_symbol_219;
			try {
				
				Value A_symbol_220 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_221 = valueFactory.typeOf(A_symbol_220, S_forAll);
				LibraryBinaryOperation dynamic_A_symbol_221 = (LibraryBinaryOperation)static_A_symbol_221.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_221 = dynamic_A_symbol_221.evaluate(evaluator, T_Boolean, A_symbol_220, S_forAll);
				leftA_symbol_219 = A_symbol_221;
			} catch (InvalidValueException e) {
				leftA_symbol_219 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_221 = leftA_symbol_219;
			Value rightA_symbol_219;
			try {
				
				Value A_symbol_222 = IP_LoopExp_body.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_LoopExp_body);
				
				Value A_symbol_223 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_222, P_TypedElement_type);
				
				DomainType static_A_symbol_224 = valueFactory.typeOf(A_symbol_223, T_ClassClassifier_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_224 = (LibraryBinaryOperation)static_A_symbol_224.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_224 = dynamic_A_symbol_224.evaluate(evaluator, T_Boolean, A_symbol_223, T_ClassClassifier_Boolean_);
				rightA_symbol_219 = A_symbol_224;
			} catch (InvalidValueException e) {
				rightA_symbol_219 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_224 = rightA_symbol_219;
			DomainType static_A_symbol_219 = valueFactory.typeOf(A_symbol_221);
			LibraryBinaryOperation dynamic_A_symbol_219 = (LibraryBinaryOperation)static_A_symbol_219.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_219 = dynamic_A_symbol_219.evaluate(evaluator, T_Boolean, A_symbol_221, A_symbol_224);
			return A_symbol_219;
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
			
			Value leftA_symbol_225;
			try {
				
				Value A_symbol_226 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_227 = valueFactory.typeOf(A_symbol_226, S_forAll);
				LibraryBinaryOperation dynamic_A_symbol_227 = (LibraryBinaryOperation)static_A_symbol_227.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_227 = dynamic_A_symbol_227.evaluate(evaluator, T_Boolean, A_symbol_226, S_forAll);
				leftA_symbol_225 = A_symbol_227;
			} catch (InvalidValueException e) {
				leftA_symbol_225 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_227 = leftA_symbol_225;
			Value rightA_symbol_225;
			try {
				
				Value A_symbol_228 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_229 = valueFactory.typeOf(A_symbol_228, T_ClassClassifier_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_229 = (LibraryBinaryOperation)static_A_symbol_229.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_229 = dynamic_A_symbol_229.evaluate(evaluator, T_Boolean, A_symbol_228, T_ClassClassifier_Boolean_);
				rightA_symbol_225 = A_symbol_229;
			} catch (InvalidValueException e) {
				rightA_symbol_225 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_229 = rightA_symbol_225;
			DomainType static_A_symbol_225 = valueFactory.typeOf(A_symbol_227);
			LibraryBinaryOperation dynamic_A_symbol_225 = (LibraryBinaryOperation)static_A_symbol_225.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_225 = dynamic_A_symbol_225.evaluate(evaluator, T_Boolean, A_symbol_227, A_symbol_229);
			return A_symbol_225;
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
			
			Value leftA_symbol_230;
			try {
				
				Value A_symbol_231 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_232 = valueFactory.typeOf(A_symbol_231, S_isUnique);
				LibraryBinaryOperation dynamic_A_symbol_232 = (LibraryBinaryOperation)static_A_symbol_232.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_232 = dynamic_A_symbol_232.evaluate(evaluator, T_Boolean, A_symbol_231, S_isUnique);
				leftA_symbol_230 = A_symbol_232;
			} catch (InvalidValueException e) {
				leftA_symbol_230 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_232 = leftA_symbol_230;
			Value rightA_symbol_230;
			try {
				
				Value A_symbol_233 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_Pivot_ecore__pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_234 = valueFactory.typeOf(A_symbol_233);
				LibraryUnaryOperation dynamic_A_symbol_234 = (LibraryUnaryOperation)static_A_symbol_234.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_234 = dynamic_A_symbol_234.evaluate(evaluator, T_Integer, A_symbol_233);
				DomainType static_A_symbol_235 = valueFactory.typeOf(A_symbol_234, I_1);
				LibraryBinaryOperation dynamic_A_symbol_235 = (LibraryBinaryOperation)static_A_symbol_235.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_235 = dynamic_A_symbol_235.evaluate(evaluator, T_Boolean, A_symbol_234, I_1);
				rightA_symbol_230 = A_symbol_235;
			} catch (InvalidValueException e) {
				rightA_symbol_230 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_235 = rightA_symbol_230;
			DomainType static_A_symbol_230 = valueFactory.typeOf(A_symbol_232);
			LibraryBinaryOperation dynamic_A_symbol_230 = (LibraryBinaryOperation)static_A_symbol_230.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_230 = dynamic_A_symbol_230.evaluate(evaluator, T_Boolean, A_symbol_232, A_symbol_235);
			return A_symbol_230;
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
			
			Value leftA_symbol_236;
			try {
				
				Value A_symbol_237 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_238 = valueFactory.typeOf(A_symbol_237, S_isUnique);
				LibraryBinaryOperation dynamic_A_symbol_238 = (LibraryBinaryOperation)static_A_symbol_238.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_238 = dynamic_A_symbol_238.evaluate(evaluator, T_Boolean, A_symbol_237, S_isUnique);
				leftA_symbol_236 = A_symbol_238;
			} catch (InvalidValueException e) {
				leftA_symbol_236 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_238 = leftA_symbol_236;
			Value rightA_symbol_236;
			try {
				
				Value A_symbol_239 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_240 = valueFactory.typeOf(A_symbol_239, T_ClassClassifier_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_240 = (LibraryBinaryOperation)static_A_symbol_240.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_240 = dynamic_A_symbol_240.evaluate(evaluator, T_Boolean, A_symbol_239, T_ClassClassifier_Boolean_);
				rightA_symbol_236 = A_symbol_240;
			} catch (InvalidValueException e) {
				rightA_symbol_236 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_240 = rightA_symbol_236;
			DomainType static_A_symbol_236 = valueFactory.typeOf(A_symbol_238);
			LibraryBinaryOperation dynamic_A_symbol_236 = (LibraryBinaryOperation)static_A_symbol_236.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_236 = dynamic_A_symbol_236.evaluate(evaluator, T_Boolean, A_symbol_238, A_symbol_240);
			return A_symbol_236;
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
			
			
			Value A_symbol_241 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_Pivot_ecore__pivot__Variable_, self, P_LoopExp_iterator);
			
			
			/** 
			 * Implementation of the iterator body.
			 */
			AbstractBinaryOperation body_A_symbol_242 = new AbstractBinaryOperation()
			{
			/*
			type =
			source.type.oclAsType(_'file:/C:/GIT/org.eclipse.ocl/examples/org.eclipse.ocl.examples.pivot/model/Pivot.ecore'::ocl::CollectionType).elementType
			*/
				public Value evaluate(DomainEvaluator evaluator, DomainType returnType, Value sourceValue, Value iterator1) throws InvalidValueException {
					final Value V_1_ = iterator1;	// iterator: 1_
					
					Value A_symbol_243 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, V_1_, P_TypedElement_type);
					
					
					Value A_symbol_244 = IP_CallExp_source.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_CallExp_source);
					
					Value A_symbol_245 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_244, P_TypedElement_type);
					
					DomainType static_A_symbol_246 = valueFactory.typeOf(A_symbol_245);
					LibraryBinaryOperation dynamic_A_symbol_246 = (LibraryBinaryOperation)static_A_symbol_246.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
					Value A_symbol_246 = dynamic_A_symbol_246.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionType, A_symbol_245, T_ClassClassifier_Pivot_ecore__pivot__CollectionType_);
					Value A_symbol_247 = IP_CollectionType_elementType.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_246, P_CollectionType_elementType);
					
					DomainType static_A_symbol_248 = valueFactory.typeOf(A_symbol_243, A_symbol_247);
					LibraryBinaryOperation dynamic_A_symbol_248 = (LibraryBinaryOperation)static_A_symbol_248.lookupImplementation(standardLibrary, O_OclAny__eq_);
					Value A_symbol_248 = dynamic_A_symbol_248.evaluate(evaluator, T_Boolean, A_symbol_243, A_symbol_247);
					return A_symbol_248;
				}
			};
			DomainType static_A_symbol_242 = A_symbol_241.getType();
			LibraryIteration dynamic_A_symbol_242 = (LibraryIteration)static_A_symbol_242.lookupImplementation(standardLibrary, O_Collection_forAll);
			Value acc_A_symbol_242 = dynamic_A_symbol_242.createAccumulatorValue(evaluator, T_Boolean, T_Boolean);
			ExecutorSingleIterationManager manager_A_symbol_242 = new ExecutorSingleIterationManager(evaluator, T_Boolean, body_A_symbol_242, (CollectionValue)A_symbol_241, acc_A_symbol_242);
			Value A_symbol_242 = dynamic_A_symbol_242.evaluateIteration(manager_A_symbol_242);
			return A_symbol_242;
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
			
			Value leftA_symbol_249;
			try {
				
				Value A_symbol_250 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_251 = valueFactory.typeOf(A_symbol_250, S_one);
				LibraryBinaryOperation dynamic_A_symbol_251 = (LibraryBinaryOperation)static_A_symbol_251.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_251 = dynamic_A_symbol_251.evaluate(evaluator, T_Boolean, A_symbol_250, S_one);
				leftA_symbol_249 = A_symbol_251;
			} catch (InvalidValueException e) {
				leftA_symbol_249 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_251 = leftA_symbol_249;
			Value rightA_symbol_249;
			try {
				
				Value A_symbol_252 = IP_LoopExp_body.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_LoopExp_body);
				
				Value A_symbol_253 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_252, P_TypedElement_type);
				
				DomainType static_A_symbol_254 = valueFactory.typeOf(A_symbol_253, T_ClassClassifier_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_254 = (LibraryBinaryOperation)static_A_symbol_254.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_254 = dynamic_A_symbol_254.evaluate(evaluator, T_Boolean, A_symbol_253, T_ClassClassifier_Boolean_);
				rightA_symbol_249 = A_symbol_254;
			} catch (InvalidValueException e) {
				rightA_symbol_249 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_254 = rightA_symbol_249;
			DomainType static_A_symbol_249 = valueFactory.typeOf(A_symbol_251);
			LibraryBinaryOperation dynamic_A_symbol_249 = (LibraryBinaryOperation)static_A_symbol_249.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_249 = dynamic_A_symbol_249.evaluate(evaluator, T_Boolean, A_symbol_251, A_symbol_254);
			return A_symbol_249;
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
			
			Value leftA_symbol_255;
			try {
				
				Value A_symbol_256 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_257 = valueFactory.typeOf(A_symbol_256, S_one);
				LibraryBinaryOperation dynamic_A_symbol_257 = (LibraryBinaryOperation)static_A_symbol_257.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_257 = dynamic_A_symbol_257.evaluate(evaluator, T_Boolean, A_symbol_256, S_one);
				leftA_symbol_255 = A_symbol_257;
			} catch (InvalidValueException e) {
				leftA_symbol_255 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_257 = leftA_symbol_255;
			Value rightA_symbol_255;
			try {
				
				Value A_symbol_258 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_Pivot_ecore__pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_259 = valueFactory.typeOf(A_symbol_258);
				LibraryUnaryOperation dynamic_A_symbol_259 = (LibraryUnaryOperation)static_A_symbol_259.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_259 = dynamic_A_symbol_259.evaluate(evaluator, T_Integer, A_symbol_258);
				DomainType static_A_symbol_260 = valueFactory.typeOf(A_symbol_259, I_1);
				LibraryBinaryOperation dynamic_A_symbol_260 = (LibraryBinaryOperation)static_A_symbol_260.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_260 = dynamic_A_symbol_260.evaluate(evaluator, T_Boolean, A_symbol_259, I_1);
				rightA_symbol_255 = A_symbol_260;
			} catch (InvalidValueException e) {
				rightA_symbol_255 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_260 = rightA_symbol_255;
			DomainType static_A_symbol_255 = valueFactory.typeOf(A_symbol_257);
			LibraryBinaryOperation dynamic_A_symbol_255 = (LibraryBinaryOperation)static_A_symbol_255.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_255 = dynamic_A_symbol_255.evaluate(evaluator, T_Boolean, A_symbol_257, A_symbol_260);
			return A_symbol_255;
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
			
			Value leftA_symbol_261;
			try {
				
				Value A_symbol_262 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_263 = valueFactory.typeOf(A_symbol_262, S_one);
				LibraryBinaryOperation dynamic_A_symbol_263 = (LibraryBinaryOperation)static_A_symbol_263.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_263 = dynamic_A_symbol_263.evaluate(evaluator, T_Boolean, A_symbol_262, S_one);
				leftA_symbol_261 = A_symbol_263;
			} catch (InvalidValueException e) {
				leftA_symbol_261 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_263 = leftA_symbol_261;
			Value rightA_symbol_261;
			try {
				
				Value A_symbol_264 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_265 = valueFactory.typeOf(A_symbol_264, T_ClassClassifier_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_265 = (LibraryBinaryOperation)static_A_symbol_265.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_265 = dynamic_A_symbol_265.evaluate(evaluator, T_Boolean, A_symbol_264, T_ClassClassifier_Boolean_);
				rightA_symbol_261 = A_symbol_265;
			} catch (InvalidValueException e) {
				rightA_symbol_261 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_265 = rightA_symbol_261;
			DomainType static_A_symbol_261 = valueFactory.typeOf(A_symbol_263);
			LibraryBinaryOperation dynamic_A_symbol_261 = (LibraryBinaryOperation)static_A_symbol_261.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_261 = dynamic_A_symbol_261.evaluate(evaluator, T_Boolean, A_symbol_263, A_symbol_265);
			return A_symbol_261;
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
			
			Value leftA_symbol_266;
			try {
				Value leftA_symbol_267;
				try {
					
					Value A_symbol_268 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
					
					DomainType static_A_symbol_269 = valueFactory.typeOf(A_symbol_268, S_reject);
					LibraryBinaryOperation dynamic_A_symbol_269 = (LibraryBinaryOperation)static_A_symbol_269.lookupImplementation(standardLibrary, O_String__eq_);
					Value A_symbol_269 = dynamic_A_symbol_269.evaluate(evaluator, T_Boolean, A_symbol_268, S_reject);
					leftA_symbol_267 = A_symbol_269;
				} catch (InvalidValueException e) {
					leftA_symbol_267 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_269 = leftA_symbol_267;
				Value rightA_symbol_267;
				try {
					
					Value A_symbol_270 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
					
					DomainType static_A_symbol_271 = valueFactory.typeOf(A_symbol_270, S_select);
					LibraryBinaryOperation dynamic_A_symbol_271 = (LibraryBinaryOperation)static_A_symbol_271.lookupImplementation(standardLibrary, O_String__eq_);
					Value A_symbol_271 = dynamic_A_symbol_271.evaluate(evaluator, T_Boolean, A_symbol_270, S_select);
					rightA_symbol_267 = A_symbol_271;
				} catch (InvalidValueException e) {
					rightA_symbol_267 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_271 = rightA_symbol_267;
				DomainType static_A_symbol_267 = valueFactory.typeOf(A_symbol_269);
				LibraryBinaryOperation dynamic_A_symbol_267 = (LibraryBinaryOperation)static_A_symbol_267.lookupImplementation(standardLibrary, O_Boolean_or);
				Value A_symbol_267 = dynamic_A_symbol_267.evaluate(evaluator, T_Boolean, A_symbol_269, A_symbol_271);
				leftA_symbol_266 = A_symbol_267;
			} catch (InvalidValueException e) {
				leftA_symbol_266 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_267 = leftA_symbol_266;
			Value rightA_symbol_266;
			try {
				
				Value A_symbol_272 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_Pivot_ecore__pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_273 = valueFactory.typeOf(A_symbol_272);
				LibraryUnaryOperation dynamic_A_symbol_273 = (LibraryUnaryOperation)static_A_symbol_273.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_273 = dynamic_A_symbol_273.evaluate(evaluator, T_Integer, A_symbol_272);
				DomainType static_A_symbol_274 = valueFactory.typeOf(A_symbol_273, I_1);
				LibraryBinaryOperation dynamic_A_symbol_274 = (LibraryBinaryOperation)static_A_symbol_274.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_274 = dynamic_A_symbol_274.evaluate(evaluator, T_Boolean, A_symbol_273, I_1);
				rightA_symbol_266 = A_symbol_274;
			} catch (InvalidValueException e) {
				rightA_symbol_266 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_274 = rightA_symbol_266;
			DomainType static_A_symbol_266 = valueFactory.typeOf(A_symbol_267);
			LibraryBinaryOperation dynamic_A_symbol_266 = (LibraryBinaryOperation)static_A_symbol_266.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_266 = dynamic_A_symbol_266.evaluate(evaluator, T_Boolean, A_symbol_267, A_symbol_274);
			return A_symbol_266;
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
			
			Value leftA_symbol_275;
			try {
				Value leftA_symbol_276;
				try {
					
					Value A_symbol_277 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
					
					DomainType static_A_symbol_278 = valueFactory.typeOf(A_symbol_277, S_reject);
					LibraryBinaryOperation dynamic_A_symbol_278 = (LibraryBinaryOperation)static_A_symbol_278.lookupImplementation(standardLibrary, O_String__eq_);
					Value A_symbol_278 = dynamic_A_symbol_278.evaluate(evaluator, T_Boolean, A_symbol_277, S_reject);
					leftA_symbol_276 = A_symbol_278;
				} catch (InvalidValueException e) {
					leftA_symbol_276 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_278 = leftA_symbol_276;
				Value rightA_symbol_276;
				try {
					
					Value A_symbol_279 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
					
					DomainType static_A_symbol_280 = valueFactory.typeOf(A_symbol_279, S_select);
					LibraryBinaryOperation dynamic_A_symbol_280 = (LibraryBinaryOperation)static_A_symbol_280.lookupImplementation(standardLibrary, O_String__eq_);
					Value A_symbol_280 = dynamic_A_symbol_280.evaluate(evaluator, T_Boolean, A_symbol_279, S_select);
					rightA_symbol_276 = A_symbol_280;
				} catch (InvalidValueException e) {
					rightA_symbol_276 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_280 = rightA_symbol_276;
				DomainType static_A_symbol_276 = valueFactory.typeOf(A_symbol_278);
				LibraryBinaryOperation dynamic_A_symbol_276 = (LibraryBinaryOperation)static_A_symbol_276.lookupImplementation(standardLibrary, O_Boolean_or);
				Value A_symbol_276 = dynamic_A_symbol_276.evaluate(evaluator, T_Boolean, A_symbol_278, A_symbol_280);
				leftA_symbol_275 = A_symbol_276;
			} catch (InvalidValueException e) {
				leftA_symbol_275 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_276 = leftA_symbol_275;
			Value rightA_symbol_275;
			try {
				
				Value A_symbol_281 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_282 = valueFactory.typeOf(A_symbol_281, T_ClassClassifier_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_282 = (LibraryBinaryOperation)static_A_symbol_282.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_282 = dynamic_A_symbol_282.evaluate(evaluator, T_Boolean, A_symbol_281, T_ClassClassifier_Boolean_);
				rightA_symbol_275 = A_symbol_282;
			} catch (InvalidValueException e) {
				rightA_symbol_275 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_282 = rightA_symbol_275;
			DomainType static_A_symbol_275 = valueFactory.typeOf(A_symbol_276);
			LibraryBinaryOperation dynamic_A_symbol_275 = (LibraryBinaryOperation)static_A_symbol_275.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_275 = dynamic_A_symbol_275.evaluate(evaluator, T_Boolean, A_symbol_276, A_symbol_282);
			return A_symbol_275;
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
			
			Value leftA_symbol_283;
			try {
				Value leftA_symbol_284;
				try {
					
					Value A_symbol_285 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
					
					DomainType static_A_symbol_286 = valueFactory.typeOf(A_symbol_285, S_reject);
					LibraryBinaryOperation dynamic_A_symbol_286 = (LibraryBinaryOperation)static_A_symbol_286.lookupImplementation(standardLibrary, O_String__eq_);
					Value A_symbol_286 = dynamic_A_symbol_286.evaluate(evaluator, T_Boolean, A_symbol_285, S_reject);
					leftA_symbol_284 = A_symbol_286;
				} catch (InvalidValueException e) {
					leftA_symbol_284 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_286 = leftA_symbol_284;
				Value rightA_symbol_284;
				try {
					
					Value A_symbol_287 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
					
					DomainType static_A_symbol_288 = valueFactory.typeOf(A_symbol_287, S_select);
					LibraryBinaryOperation dynamic_A_symbol_288 = (LibraryBinaryOperation)static_A_symbol_288.lookupImplementation(standardLibrary, O_String__eq_);
					Value A_symbol_288 = dynamic_A_symbol_288.evaluate(evaluator, T_Boolean, A_symbol_287, S_select);
					rightA_symbol_284 = A_symbol_288;
				} catch (InvalidValueException e) {
					rightA_symbol_284 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_288 = rightA_symbol_284;
				DomainType static_A_symbol_284 = valueFactory.typeOf(A_symbol_286);
				LibraryBinaryOperation dynamic_A_symbol_284 = (LibraryBinaryOperation)static_A_symbol_284.lookupImplementation(standardLibrary, O_Boolean_or);
				Value A_symbol_284 = dynamic_A_symbol_284.evaluate(evaluator, T_Boolean, A_symbol_286, A_symbol_288);
				leftA_symbol_283 = A_symbol_284;
			} catch (InvalidValueException e) {
				leftA_symbol_283 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_284 = leftA_symbol_283;
			Value rightA_symbol_283;
			try {
				
				Value A_symbol_289 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				
				Value A_symbol_290 = IP_CallExp_source.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_CallExp_source);
				
				Value A_symbol_291 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_290, P_TypedElement_type);
				
				DomainType static_A_symbol_292 = valueFactory.typeOf(A_symbol_289, A_symbol_291);
				LibraryBinaryOperation dynamic_A_symbol_292 = (LibraryBinaryOperation)static_A_symbol_292.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_292 = dynamic_A_symbol_292.evaluate(evaluator, T_Boolean, A_symbol_289, A_symbol_291);
				rightA_symbol_283 = A_symbol_292;
			} catch (InvalidValueException e) {
				rightA_symbol_283 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_292 = rightA_symbol_283;
			DomainType static_A_symbol_283 = valueFactory.typeOf(A_symbol_284);
			LibraryBinaryOperation dynamic_A_symbol_283 = (LibraryBinaryOperation)static_A_symbol_283.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_283 = dynamic_A_symbol_283.evaluate(evaluator, T_Boolean, A_symbol_284, A_symbol_292);
			return A_symbol_283;
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
			
			Value leftA_symbol_293;
			try {
				
				Value A_symbol_294 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_295 = valueFactory.typeOf(A_symbol_294, S_sortedBy);
				LibraryBinaryOperation dynamic_A_symbol_295 = (LibraryBinaryOperation)static_A_symbol_295.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_295 = dynamic_A_symbol_295.evaluate(evaluator, T_Boolean, A_symbol_294, S_sortedBy);
				leftA_symbol_293 = A_symbol_295;
			} catch (InvalidValueException e) {
				leftA_symbol_293 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_295 = leftA_symbol_293;
			Value rightA_symbol_293;
			try {
				
				Value A_symbol_296 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_297 = valueFactory.typeOf(A_symbol_296);
				LibraryBinaryOperation dynamic_A_symbol_297 = (LibraryBinaryOperation)static_A_symbol_297.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_297 = dynamic_A_symbol_297.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionType, A_symbol_296, T_ClassClassifier_Pivot_ecore__pivot__CollectionType_);
				Value A_symbol_298 = IP_CollectionType_elementType.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_297, P_CollectionType_elementType);
				
				
				Value A_symbol_299 = IP_LoopExp_body.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_LoopExp_body);
				
				Value A_symbol_300 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_299, P_TypedElement_type);
				
				DomainType static_A_symbol_301 = valueFactory.typeOf(A_symbol_300);
				LibraryBinaryOperation dynamic_A_symbol_301 = (LibraryBinaryOperation)static_A_symbol_301.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_301 = dynamic_A_symbol_301.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionType, A_symbol_300, T_ClassClassifier_Pivot_ecore__pivot__CollectionType_);
				Value A_symbol_302 = IP_CollectionType_elementType.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_301, P_CollectionType_elementType);
				
				DomainType static_A_symbol_303 = valueFactory.typeOf(A_symbol_298, A_symbol_302);
				LibraryBinaryOperation dynamic_A_symbol_303 = (LibraryBinaryOperation)static_A_symbol_303.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_303 = dynamic_A_symbol_303.evaluate(evaluator, T_Boolean, A_symbol_298, A_symbol_302);
				rightA_symbol_293 = A_symbol_303;
			} catch (InvalidValueException e) {
				rightA_symbol_293 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_303 = rightA_symbol_293;
			DomainType static_A_symbol_293 = valueFactory.typeOf(A_symbol_295);
			LibraryBinaryOperation dynamic_A_symbol_293 = (LibraryBinaryOperation)static_A_symbol_293.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_293 = dynamic_A_symbol_293.evaluate(evaluator, T_Boolean, A_symbol_295, A_symbol_303);
			return A_symbol_293;
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
			
			Value leftA_symbol_304;
			try {
				
				Value A_symbol_305 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_306 = valueFactory.typeOf(A_symbol_305, S_sortedBy);
				LibraryBinaryOperation dynamic_A_symbol_306 = (LibraryBinaryOperation)static_A_symbol_306.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_306 = dynamic_A_symbol_306.evaluate(evaluator, T_Boolean, A_symbol_305, S_sortedBy);
				leftA_symbol_304 = A_symbol_306;
			} catch (InvalidValueException e) {
				leftA_symbol_304 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_306 = leftA_symbol_304;
			Value rightA_symbol_304;
			try {
				
				Value A_symbol_307 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_Pivot_ecore__pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_308 = valueFactory.typeOf(A_symbol_307);
				LibraryUnaryOperation dynamic_A_symbol_308 = (LibraryUnaryOperation)static_A_symbol_308.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_308 = dynamic_A_symbol_308.evaluate(evaluator, T_Integer, A_symbol_307);
				DomainType static_A_symbol_309 = valueFactory.typeOf(A_symbol_308, I_1);
				LibraryBinaryOperation dynamic_A_symbol_309 = (LibraryBinaryOperation)static_A_symbol_309.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_309 = dynamic_A_symbol_309.evaluate(evaluator, T_Boolean, A_symbol_308, I_1);
				rightA_symbol_304 = A_symbol_309;
			} catch (InvalidValueException e) {
				rightA_symbol_304 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_309 = rightA_symbol_304;
			DomainType static_A_symbol_304 = valueFactory.typeOf(A_symbol_306);
			LibraryBinaryOperation dynamic_A_symbol_304 = (LibraryBinaryOperation)static_A_symbol_304.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_304 = dynamic_A_symbol_304.evaluate(evaluator, T_Boolean, A_symbol_306, A_symbol_309);
			return A_symbol_304;
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
			
			Value leftA_symbol_310;
			try {
				
				Value A_symbol_311 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_312 = valueFactory.typeOf(A_symbol_311, S_sortedBy);
				LibraryBinaryOperation dynamic_A_symbol_312 = (LibraryBinaryOperation)static_A_symbol_312.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_312 = dynamic_A_symbol_312.evaluate(evaluator, T_Boolean, A_symbol_311, S_sortedBy);
				leftA_symbol_310 = A_symbol_312;
			} catch (InvalidValueException e) {
				leftA_symbol_310 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_312 = leftA_symbol_310;
			Value rightA_symbol_310;
			try {
					Value leftA_symbol_313;
					try {
						
						Value A_symbol_314 = IP_CallExp_source.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_CallExp_source);
						
						Value A_symbol_315 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_314, P_TypedElement_type);
						
						DomainType static_A_symbol_316 = valueFactory.typeOf(A_symbol_315);
						LibraryBinaryOperation dynamic_A_symbol_316 = (LibraryBinaryOperation)static_A_symbol_316.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Value A_symbol_316 = dynamic_A_symbol_316.evaluate(evaluator, T_Boolean, A_symbol_315, T_ClassClassifier_Pivot_ecore__pivot__SequenceType_);
						leftA_symbol_313 = A_symbol_316;
					} catch (InvalidValueException e) {
						leftA_symbol_313 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_316 = leftA_symbol_313;
					Value rightA_symbol_313;
					try {
						
						Value A_symbol_317 = IP_CallExp_source.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_CallExp_source);
						
						Value A_symbol_318 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_317, P_TypedElement_type);
						
						DomainType static_A_symbol_319 = valueFactory.typeOf(A_symbol_318);
						LibraryBinaryOperation dynamic_A_symbol_319 = (LibraryBinaryOperation)static_A_symbol_319.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Value A_symbol_319 = dynamic_A_symbol_319.evaluate(evaluator, T_Boolean, A_symbol_318, T_ClassClassifier_Pivot_ecore__pivot__BagType_);
						rightA_symbol_313 = A_symbol_319;
					} catch (InvalidValueException e) {
						rightA_symbol_313 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_319 = rightA_symbol_313;
					DomainType static_A_symbol_313 = valueFactory.typeOf(A_symbol_316);
					LibraryBinaryOperation dynamic_A_symbol_313 = (LibraryBinaryOperation)static_A_symbol_313.lookupImplementation(standardLibrary, O_Boolean_or);
					Value A_symbol_313 = dynamic_A_symbol_313.evaluate(evaluator, T_Boolean, A_symbol_316, A_symbol_319);
				Value A_symbol_320;
				if (A_symbol_313.isTrue()) {
					
					Value A_symbol_321 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
					
					DomainType static_A_symbol_322 = valueFactory.typeOf(A_symbol_321);
					LibraryBinaryOperation dynamic_A_symbol_322 = (LibraryBinaryOperation)static_A_symbol_322.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Value A_symbol_322 = dynamic_A_symbol_322.evaluate(evaluator, T_Boolean, A_symbol_321, T_ClassClassifier_Pivot_ecore__pivot__SequenceType_);
					A_symbol_320 = A_symbol_322;
				}
				else if (A_symbol_313.isFalse()) {
					
					Value A_symbol_323 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
					
					DomainType static_A_symbol_324 = valueFactory.typeOf(A_symbol_323);
					LibraryBinaryOperation dynamic_A_symbol_324 = (LibraryBinaryOperation)static_A_symbol_324.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Value A_symbol_324 = dynamic_A_symbol_324.evaluate(evaluator, T_Boolean, A_symbol_323, T_ClassClassifier_Pivot_ecore__pivot__OrderedSetType_);
					A_symbol_320 = A_symbol_324;
				}
				else if (A_symbol_313.isNull()) {
					A_symbol_320 = valueFactory.throwInvalidValueException("null if condition");
				}
				else {
					A_symbol_320 = valueFactory.throwInvalidValueException("invalid if condition");
				}
				rightA_symbol_310 = A_symbol_320;
			} catch (InvalidValueException e) {
				rightA_symbol_310 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_320 = rightA_symbol_310;
			DomainType static_A_symbol_310 = valueFactory.typeOf(A_symbol_312);
			LibraryBinaryOperation dynamic_A_symbol_310 = (LibraryBinaryOperation)static_A_symbol_310.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_310 = dynamic_A_symbol_310.evaluate(evaluator, T_Boolean, A_symbol_312, A_symbol_320);
			return A_symbol_310;
		}
	}
}

