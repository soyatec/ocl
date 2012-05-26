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
			
			Value leftA_symbol_138;
			try {
				
				Value A_symbol_139 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_140 = valueFactory.typeOf(A_symbol_139, S_any);
				LibraryBinaryOperation dynamic_A_symbol_140 = (LibraryBinaryOperation)static_A_symbol_140.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_140 = dynamic_A_symbol_140.evaluate(evaluator, T_Boolean, A_symbol_139, S_any);
				leftA_symbol_138 = A_symbol_140;
			} catch (InvalidValueException e) {
				leftA_symbol_138 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_140 = leftA_symbol_138;
			Value rightA_symbol_138;
			try {
				
				Value A_symbol_141 = IP_LoopExp_body.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_LoopExp_body);
				
				Value A_symbol_142 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_141, P_TypedElement_type);
				
				DomainType static_A_symbol_143 = valueFactory.typeOf(A_symbol_142, S_Boolean);
				LibraryBinaryOperation dynamic_A_symbol_143 = (LibraryBinaryOperation)static_A_symbol_143.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_143 = dynamic_A_symbol_143.evaluate(evaluator, T_Boolean, A_symbol_142, S_Boolean);
				rightA_symbol_138 = A_symbol_143;
			} catch (InvalidValueException e) {
				rightA_symbol_138 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_143 = rightA_symbol_138;
			DomainType static_A_symbol_138 = valueFactory.typeOf(A_symbol_140);
			LibraryBinaryOperation dynamic_A_symbol_138 = (LibraryBinaryOperation)static_A_symbol_138.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_138 = dynamic_A_symbol_138.evaluate(evaluator, T_Boolean, A_symbol_140, A_symbol_143);
			return A_symbol_138;
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
			
			Value leftA_symbol_144;
			try {
				
				Value A_symbol_145 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_146 = valueFactory.typeOf(A_symbol_145, S_any);
				LibraryBinaryOperation dynamic_A_symbol_146 = (LibraryBinaryOperation)static_A_symbol_146.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_146 = dynamic_A_symbol_146.evaluate(evaluator, T_Boolean, A_symbol_145, S_any);
				leftA_symbol_144 = A_symbol_146;
			} catch (InvalidValueException e) {
				leftA_symbol_144 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_146 = leftA_symbol_144;
			Value rightA_symbol_144;
			try {
				
				Value A_symbol_147 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_Pivot_ecore__pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_148 = valueFactory.typeOf(A_symbol_147);
				LibraryUnaryOperation dynamic_A_symbol_148 = (LibraryUnaryOperation)static_A_symbol_148.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_148 = dynamic_A_symbol_148.evaluate(evaluator, T_Integer, A_symbol_147);
				DomainType static_A_symbol_149 = valueFactory.typeOf(A_symbol_148, I_1);
				LibraryBinaryOperation dynamic_A_symbol_149 = (LibraryBinaryOperation)static_A_symbol_149.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_149 = dynamic_A_symbol_149.evaluate(evaluator, T_Boolean, A_symbol_148, I_1);
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
			
			Value leftA_symbol_150;
			try {
				
				Value A_symbol_151 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_152 = valueFactory.typeOf(A_symbol_151, S_any);
				LibraryBinaryOperation dynamic_A_symbol_152 = (LibraryBinaryOperation)static_A_symbol_152.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_152 = dynamic_A_symbol_152.evaluate(evaluator, T_Boolean, A_symbol_151, S_any);
				leftA_symbol_150 = A_symbol_152;
			} catch (InvalidValueException e) {
				leftA_symbol_150 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_152 = leftA_symbol_150;
			Value rightA_symbol_150;
			try {
				
				Value A_symbol_153 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				
				Value A_symbol_154 = IP_CallExp_source.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_CallExp_source);
				
				Value A_symbol_155 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_154, P_TypedElement_type);
				
				DomainType static_A_symbol_156 = valueFactory.typeOf(A_symbol_155);
				LibraryBinaryOperation dynamic_A_symbol_156 = (LibraryBinaryOperation)static_A_symbol_156.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_156 = dynamic_A_symbol_156.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionType, A_symbol_155, T_ClassClassifier_Pivot_ecore__pivot__CollectionType_);
				Value A_symbol_157 = IP_CollectionType_elementType.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_156, P_CollectionType_elementType);
				
				DomainType static_A_symbol_158 = valueFactory.typeOf(A_symbol_153, A_symbol_157);
				LibraryBinaryOperation dynamic_A_symbol_158 = (LibraryBinaryOperation)static_A_symbol_158.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_158 = dynamic_A_symbol_158.evaluate(evaluator, T_Boolean, A_symbol_153, A_symbol_157);
				rightA_symbol_150 = A_symbol_158;
			} catch (InvalidValueException e) {
				rightA_symbol_150 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_158 = rightA_symbol_150;
			DomainType static_A_symbol_150 = valueFactory.typeOf(A_symbol_152);
			LibraryBinaryOperation dynamic_A_symbol_150 = (LibraryBinaryOperation)static_A_symbol_150.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_150 = dynamic_A_symbol_150.evaluate(evaluator, T_Boolean, A_symbol_152, A_symbol_158);
			return A_symbol_150;
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
			
			Value leftA_symbol_159;
			try {
				
				Value A_symbol_160 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_161 = valueFactory.typeOf(A_symbol_160, S_closure);
				LibraryBinaryOperation dynamic_A_symbol_161 = (LibraryBinaryOperation)static_A_symbol_161.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_161 = dynamic_A_symbol_161.evaluate(evaluator, T_Boolean, A_symbol_160, S_closure);
				leftA_symbol_159 = A_symbol_161;
			} catch (InvalidValueException e) {
				leftA_symbol_159 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_161 = leftA_symbol_159;
			Value rightA_symbol_159;
			try {
				
				Value A_symbol_162 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_163 = valueFactory.typeOf(A_symbol_162);
				LibraryBinaryOperation dynamic_A_symbol_163 = (LibraryBinaryOperation)static_A_symbol_163.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_163 = dynamic_A_symbol_163.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionType, A_symbol_162, T_ClassClassifier_Pivot_ecore__pivot__CollectionType_);
				Value A_symbol_164 = IP_CollectionType_elementType.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_163, P_CollectionType_elementType);
				
				
				Value A_symbol_165 = IP_CallExp_source.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_CallExp_source);
				
				Value A_symbol_166 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_165, P_TypedElement_type);
				
				DomainType static_A_symbol_167 = valueFactory.typeOf(A_symbol_166);
				LibraryBinaryOperation dynamic_A_symbol_167 = (LibraryBinaryOperation)static_A_symbol_167.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_167 = dynamic_A_symbol_167.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionType, A_symbol_166, T_ClassClassifier_Pivot_ecore__pivot__CollectionType_);
				Value A_symbol_168 = IP_CollectionType_elementType.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_167, P_CollectionType_elementType);
				
				DomainType static_A_symbol_169 = valueFactory.typeOf(A_symbol_164, A_symbol_168);
				LibraryBinaryOperation dynamic_A_symbol_169 = (LibraryBinaryOperation)static_A_symbol_169.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_169 = dynamic_A_symbol_169.evaluate(evaluator, T_Boolean, A_symbol_164, A_symbol_168);
				rightA_symbol_159 = A_symbol_169;
			} catch (InvalidValueException e) {
				rightA_symbol_159 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_169 = rightA_symbol_159;
			DomainType static_A_symbol_159 = valueFactory.typeOf(A_symbol_161);
			LibraryBinaryOperation dynamic_A_symbol_159 = (LibraryBinaryOperation)static_A_symbol_159.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_159 = dynamic_A_symbol_159.evaluate(evaluator, T_Boolean, A_symbol_161, A_symbol_169);
			return A_symbol_159;
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
			
			Value leftA_symbol_170;
			try {
				
				Value A_symbol_171 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_172 = valueFactory.typeOf(A_symbol_171, S_closure);
				LibraryBinaryOperation dynamic_A_symbol_172 = (LibraryBinaryOperation)static_A_symbol_172.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_172 = dynamic_A_symbol_172.evaluate(evaluator, T_Boolean, A_symbol_171, S_closure);
				leftA_symbol_170 = A_symbol_172;
			} catch (InvalidValueException e) {
				leftA_symbol_170 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_172 = leftA_symbol_170;
			Value rightA_symbol_170;
			try {
				
				Value A_symbol_173 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_Pivot_ecore__pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_174 = valueFactory.typeOf(A_symbol_173);
				LibraryUnaryOperation dynamic_A_symbol_174 = (LibraryUnaryOperation)static_A_symbol_174.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_174 = dynamic_A_symbol_174.evaluate(evaluator, T_Integer, A_symbol_173);
				DomainType static_A_symbol_175 = valueFactory.typeOf(A_symbol_174, I_1);
				LibraryBinaryOperation dynamic_A_symbol_175 = (LibraryBinaryOperation)static_A_symbol_175.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_175 = dynamic_A_symbol_175.evaluate(evaluator, T_Boolean, A_symbol_174, I_1);
				rightA_symbol_170 = A_symbol_175;
			} catch (InvalidValueException e) {
				rightA_symbol_170 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_175 = rightA_symbol_170;
			DomainType static_A_symbol_170 = valueFactory.typeOf(A_symbol_172);
			LibraryBinaryOperation dynamic_A_symbol_170 = (LibraryBinaryOperation)static_A_symbol_170.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_170 = dynamic_A_symbol_170.evaluate(evaluator, T_Boolean, A_symbol_172, A_symbol_175);
			return A_symbol_170;
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
			
			Value leftA_symbol_176;
			try {
				
				Value A_symbol_177 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_178 = valueFactory.typeOf(A_symbol_177, S_closure);
				LibraryBinaryOperation dynamic_A_symbol_178 = (LibraryBinaryOperation)static_A_symbol_178.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_178 = dynamic_A_symbol_178.evaluate(evaluator, T_Boolean, A_symbol_177, S_closure);
				leftA_symbol_176 = A_symbol_178;
			} catch (InvalidValueException e) {
				leftA_symbol_176 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_178 = leftA_symbol_176;
			Value rightA_symbol_176;
			try {
				
				Value A_symbol_179 = IP_CallExp_source.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_CallExp_source);
				
				Value A_symbol_180 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_179, P_TypedElement_type);
				
				DomainType static_A_symbol_181 = valueFactory.typeOf(A_symbol_180);
				LibraryBinaryOperation dynamic_A_symbol_181 = (LibraryBinaryOperation)static_A_symbol_181.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_181 = dynamic_A_symbol_181.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionType, A_symbol_180, T_ClassClassifier_Pivot_ecore__pivot__CollectionType_);
				Value A_symbol_182 = IP_CollectionType_elementType.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_181, P_CollectionType_elementType);
				
					
					Value A_symbol_183 = IP_LoopExp_body.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_LoopExp_body);
					
					Value A_symbol_184 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_183, P_TypedElement_type);
					
					DomainType static_A_symbol_185 = valueFactory.typeOf(A_symbol_184);
					LibraryBinaryOperation dynamic_A_symbol_185 = (LibraryBinaryOperation)static_A_symbol_185.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Value A_symbol_185 = dynamic_A_symbol_185.evaluate(evaluator, T_Boolean, A_symbol_184, T_ClassClassifier_Pivot_ecore__pivot__CollectionType_);
				Value A_symbol_186;
				if (A_symbol_185.isTrue()) {
					
					Value A_symbol_187 = IP_LoopExp_body.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_LoopExp_body);
					
					Value A_symbol_188 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_187, P_TypedElement_type);
					
					DomainType static_A_symbol_189 = valueFactory.typeOf(A_symbol_188);
					LibraryBinaryOperation dynamic_A_symbol_189 = (LibraryBinaryOperation)static_A_symbol_189.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
					Value A_symbol_189 = dynamic_A_symbol_189.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionType, A_symbol_188, T_ClassClassifier_Pivot_ecore__pivot__CollectionType_);
					Value A_symbol_190 = IP_CollectionType_elementType.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_189, P_CollectionType_elementType);
					
					A_symbol_186 = A_symbol_190;
				}
				else if (A_symbol_185.isFalse()) {
					
					Value A_symbol_191 = IP_LoopExp_body.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_LoopExp_body);
					
					Value A_symbol_192 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_191, P_TypedElement_type);
					
					A_symbol_186 = A_symbol_192;
				}
				else if (A_symbol_185.isNull()) {
					A_symbol_186 = valueFactory.throwInvalidValueException("null if condition");
				}
				else {
					A_symbol_186 = valueFactory.throwInvalidValueException("invalid if condition");
				}
				DomainType static_A_symbol_193 = valueFactory.typeOf(A_symbol_182, A_symbol_186);
				LibraryBinaryOperation dynamic_A_symbol_193 = (LibraryBinaryOperation)static_A_symbol_193.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_193 = dynamic_A_symbol_193.evaluate(evaluator, T_Boolean, A_symbol_182, A_symbol_186);
				rightA_symbol_176 = A_symbol_193;
			} catch (InvalidValueException e) {
				rightA_symbol_176 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_193 = rightA_symbol_176;
			DomainType static_A_symbol_176 = valueFactory.typeOf(A_symbol_178);
			LibraryBinaryOperation dynamic_A_symbol_176 = (LibraryBinaryOperation)static_A_symbol_176.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_176 = dynamic_A_symbol_176.evaluate(evaluator, T_Boolean, A_symbol_178, A_symbol_193);
			return A_symbol_176;
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
			
			Value leftA_symbol_194;
			try {
				
				Value A_symbol_195 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_196 = valueFactory.typeOf(A_symbol_195, S_closure);
				LibraryBinaryOperation dynamic_A_symbol_196 = (LibraryBinaryOperation)static_A_symbol_196.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_196 = dynamic_A_symbol_196.evaluate(evaluator, T_Boolean, A_symbol_195, S_closure);
				leftA_symbol_194 = A_symbol_196;
			} catch (InvalidValueException e) {
				leftA_symbol_194 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_196 = leftA_symbol_194;
			Value rightA_symbol_194;
			try {
					Value leftA_symbol_197;
					try {
						
						Value A_symbol_198 = IP_CallExp_source.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_CallExp_source);
						
						Value A_symbol_199 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_198, P_TypedElement_type);
						
						DomainType static_A_symbol_200 = valueFactory.typeOf(A_symbol_199);
						LibraryBinaryOperation dynamic_A_symbol_200 = (LibraryBinaryOperation)static_A_symbol_200.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Value A_symbol_200 = dynamic_A_symbol_200.evaluate(evaluator, T_Boolean, A_symbol_199, T_ClassClassifier_Pivot_ecore__pivot__SequenceType_);
						leftA_symbol_197 = A_symbol_200;
					} catch (InvalidValueException e) {
						leftA_symbol_197 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_200 = leftA_symbol_197;
					Value rightA_symbol_197;
					try {
						
						Value A_symbol_201 = IP_CallExp_source.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_CallExp_source);
						
						Value A_symbol_202 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_201, P_TypedElement_type);
						
						DomainType static_A_symbol_203 = valueFactory.typeOf(A_symbol_202);
						LibraryBinaryOperation dynamic_A_symbol_203 = (LibraryBinaryOperation)static_A_symbol_203.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Value A_symbol_203 = dynamic_A_symbol_203.evaluate(evaluator, T_Boolean, A_symbol_202, T_ClassClassifier_Pivot_ecore__pivot__OrderedSetType_);
						rightA_symbol_197 = A_symbol_203;
					} catch (InvalidValueException e) {
						rightA_symbol_197 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_203 = rightA_symbol_197;
					DomainType static_A_symbol_197 = valueFactory.typeOf(A_symbol_200);
					LibraryBinaryOperation dynamic_A_symbol_197 = (LibraryBinaryOperation)static_A_symbol_197.lookupImplementation(standardLibrary, O_Boolean_or);
					Value A_symbol_197 = dynamic_A_symbol_197.evaluate(evaluator, T_Boolean, A_symbol_200, A_symbol_203);
				Value A_symbol_204;
				if (A_symbol_197.isTrue()) {
					
					Value A_symbol_205 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
					
					DomainType static_A_symbol_206 = valueFactory.typeOf(A_symbol_205);
					LibraryBinaryOperation dynamic_A_symbol_206 = (LibraryBinaryOperation)static_A_symbol_206.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Value A_symbol_206 = dynamic_A_symbol_206.evaluate(evaluator, T_Boolean, A_symbol_205, T_ClassClassifier_Pivot_ecore__pivot__OrderedSetType_);
					A_symbol_204 = A_symbol_206;
				}
				else if (A_symbol_197.isFalse()) {
					
					Value A_symbol_207 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
					
					DomainType static_A_symbol_208 = valueFactory.typeOf(A_symbol_207);
					LibraryBinaryOperation dynamic_A_symbol_208 = (LibraryBinaryOperation)static_A_symbol_208.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Value A_symbol_208 = dynamic_A_symbol_208.evaluate(evaluator, T_Boolean, A_symbol_207, T_ClassClassifier_Pivot_ecore__pivot__SetType_);
					A_symbol_204 = A_symbol_208;
				}
				else if (A_symbol_197.isNull()) {
					A_symbol_204 = valueFactory.throwInvalidValueException("null if condition");
				}
				else {
					A_symbol_204 = valueFactory.throwInvalidValueException("invalid if condition");
				}
				rightA_symbol_194 = A_symbol_204;
			} catch (InvalidValueException e) {
				rightA_symbol_194 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_204 = rightA_symbol_194;
			DomainType static_A_symbol_194 = valueFactory.typeOf(A_symbol_196);
			LibraryBinaryOperation dynamic_A_symbol_194 = (LibraryBinaryOperation)static_A_symbol_194.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_194 = dynamic_A_symbol_194.evaluate(evaluator, T_Boolean, A_symbol_196, A_symbol_204);
			return A_symbol_194;
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
			
			Value leftA_symbol_209;
			try {
				
				Value A_symbol_210 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_211 = valueFactory.typeOf(A_symbol_210, S_collect);
				LibraryBinaryOperation dynamic_A_symbol_211 = (LibraryBinaryOperation)static_A_symbol_211.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_211 = dynamic_A_symbol_211.evaluate(evaluator, T_Boolean, A_symbol_210, S_collect);
				leftA_symbol_209 = A_symbol_211;
			} catch (InvalidValueException e) {
				leftA_symbol_209 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_211 = leftA_symbol_209;
			Value rightA_symbol_209;
			try {
				
				Value A_symbol_212 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_213 = valueFactory.typeOf(A_symbol_212);
				LibraryBinaryOperation dynamic_A_symbol_213 = (LibraryBinaryOperation)static_A_symbol_213.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_213 = dynamic_A_symbol_213.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionType, A_symbol_212, T_ClassClassifier_Pivot_ecore__pivot__CollectionType_);
				Value A_symbol_214 = IP_CollectionType_elementType.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_213, P_CollectionType_elementType);
				
				
				Value A_symbol_215 = IP_LoopExp_body.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_LoopExp_body);
				
				Value A_symbol_216 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_215, P_TypedElement_type);
				
				DomainType static_A_symbol_217 = valueFactory.typeOf(A_symbol_216);
				LibraryBinaryOperation dynamic_A_symbol_217 = (LibraryBinaryOperation)static_A_symbol_217.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_217 = dynamic_A_symbol_217.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionType, A_symbol_216, T_ClassClassifier_Pivot_ecore__pivot__CollectionType_);
				Value A_symbol_218 = IP_CollectionType_elementType.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_217, P_CollectionType_elementType);
				
				DomainType static_A_symbol_219 = valueFactory.typeOf(A_symbol_214, A_symbol_218);
				LibraryBinaryOperation dynamic_A_symbol_219 = (LibraryBinaryOperation)static_A_symbol_219.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_219 = dynamic_A_symbol_219.evaluate(evaluator, T_Boolean, A_symbol_214, A_symbol_218);
				rightA_symbol_209 = A_symbol_219;
			} catch (InvalidValueException e) {
				rightA_symbol_209 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_219 = rightA_symbol_209;
			DomainType static_A_symbol_209 = valueFactory.typeOf(A_symbol_211);
			LibraryBinaryOperation dynamic_A_symbol_209 = (LibraryBinaryOperation)static_A_symbol_209.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_209 = dynamic_A_symbol_209.evaluate(evaluator, T_Boolean, A_symbol_211, A_symbol_219);
			return A_symbol_209;
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
			
			Value leftA_symbol_220;
			try {
				
				Value A_symbol_221 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_222 = valueFactory.typeOf(A_symbol_221, S_collect);
				LibraryBinaryOperation dynamic_A_symbol_222 = (LibraryBinaryOperation)static_A_symbol_222.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_222 = dynamic_A_symbol_222.evaluate(evaluator, T_Boolean, A_symbol_221, S_collect);
				leftA_symbol_220 = A_symbol_222;
			} catch (InvalidValueException e) {
				leftA_symbol_220 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_222 = leftA_symbol_220;
			Value rightA_symbol_220;
			try {
				
				Value A_symbol_223 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_Pivot_ecore__pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_224 = valueFactory.typeOf(A_symbol_223);
				LibraryUnaryOperation dynamic_A_symbol_224 = (LibraryUnaryOperation)static_A_symbol_224.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_224 = dynamic_A_symbol_224.evaluate(evaluator, T_Integer, A_symbol_223);
				DomainType static_A_symbol_225 = valueFactory.typeOf(A_symbol_224, I_1);
				LibraryBinaryOperation dynamic_A_symbol_225 = (LibraryBinaryOperation)static_A_symbol_225.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_225 = dynamic_A_symbol_225.evaluate(evaluator, T_Boolean, A_symbol_224, I_1);
				rightA_symbol_220 = A_symbol_225;
			} catch (InvalidValueException e) {
				rightA_symbol_220 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_225 = rightA_symbol_220;
			DomainType static_A_symbol_220 = valueFactory.typeOf(A_symbol_222);
			LibraryBinaryOperation dynamic_A_symbol_220 = (LibraryBinaryOperation)static_A_symbol_220.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_220 = dynamic_A_symbol_220.evaluate(evaluator, T_Boolean, A_symbol_222, A_symbol_225);
			return A_symbol_220;
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
			
			Value leftA_symbol_226;
			try {
				
				Value A_symbol_227 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_228 = valueFactory.typeOf(A_symbol_227, S_collectN___);
				LibraryBinaryOperation dynamic_A_symbol_228 = (LibraryBinaryOperation)static_A_symbol_228.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_228 = dynamic_A_symbol_228.evaluate(evaluator, T_Boolean, A_symbol_227, S_collectN___);
				leftA_symbol_226 = A_symbol_228;
			} catch (InvalidValueException e) {
				leftA_symbol_226 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_228 = leftA_symbol_226;
			Value rightA_symbol_226;
			try {
				
				Value A_symbol_229 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_Pivot_ecore__pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_230 = valueFactory.typeOf(A_symbol_229);
				LibraryUnaryOperation dynamic_A_symbol_230 = (LibraryUnaryOperation)static_A_symbol_230.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_230 = dynamic_A_symbol_230.evaluate(evaluator, T_Integer, A_symbol_229);
				DomainType static_A_symbol_231 = valueFactory.typeOf(A_symbol_230, I_1);
				LibraryBinaryOperation dynamic_A_symbol_231 = (LibraryBinaryOperation)static_A_symbol_231.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_231 = dynamic_A_symbol_231.evaluate(evaluator, T_Boolean, A_symbol_230, I_1);
				rightA_symbol_226 = A_symbol_231;
			} catch (InvalidValueException e) {
				rightA_symbol_226 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_231 = rightA_symbol_226;
			DomainType static_A_symbol_226 = valueFactory.typeOf(A_symbol_228);
			LibraryBinaryOperation dynamic_A_symbol_226 = (LibraryBinaryOperation)static_A_symbol_226.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_226 = dynamic_A_symbol_226.evaluate(evaluator, T_Boolean, A_symbol_228, A_symbol_231);
			return A_symbol_226;
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
			
			Value leftA_symbol_232;
			try {
				
				Value A_symbol_233 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_234 = valueFactory.typeOf(A_symbol_233, S_collectN___);
				LibraryBinaryOperation dynamic_A_symbol_234 = (LibraryBinaryOperation)static_A_symbol_234.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_234 = dynamic_A_symbol_234.evaluate(evaluator, T_Boolean, A_symbol_233, S_collectN___);
				leftA_symbol_232 = A_symbol_234;
			} catch (InvalidValueException e) {
				leftA_symbol_232 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_234 = leftA_symbol_232;
			Value rightA_symbol_232;
			try {
				
				Value A_symbol_235 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_236 = valueFactory.typeOf(A_symbol_235);
				LibraryBinaryOperation dynamic_A_symbol_236 = (LibraryBinaryOperation)static_A_symbol_236.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
				Value A_symbol_236 = dynamic_A_symbol_236.evaluate(evaluator, T_Boolean, A_symbol_235, T_ClassClassifier_Pivot_ecore__pivot__BagType_);
				rightA_symbol_232 = A_symbol_236;
			} catch (InvalidValueException e) {
				rightA_symbol_232 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_236 = rightA_symbol_232;
			DomainType static_A_symbol_232 = valueFactory.typeOf(A_symbol_234);
			LibraryBinaryOperation dynamic_A_symbol_232 = (LibraryBinaryOperation)static_A_symbol_232.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_232 = dynamic_A_symbol_232.evaluate(evaluator, T_Boolean, A_symbol_234, A_symbol_236);
			return A_symbol_232;
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
			
			Value leftA_symbol_237;
			try {
				
				Value A_symbol_238 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_239 = valueFactory.typeOf(A_symbol_238, S_collectN___);
				LibraryBinaryOperation dynamic_A_symbol_239 = (LibraryBinaryOperation)static_A_symbol_239.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_239 = dynamic_A_symbol_239.evaluate(evaluator, T_Boolean, A_symbol_238, S_collectN___);
				leftA_symbol_237 = A_symbol_239;
			} catch (InvalidValueException e) {
				leftA_symbol_237 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_239 = leftA_symbol_237;
			Value rightA_symbol_237;
			try {
				
				Value A_symbol_240 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				
				Value A_symbol_241 = IP_LoopExp_body.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_LoopExp_body);
				
				Value A_symbol_242 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_241, P_TypedElement_type);
				
				DomainType static_A_symbol_243 = valueFactory.typeOf(A_symbol_240, A_symbol_242);
				LibraryBinaryOperation dynamic_A_symbol_243 = (LibraryBinaryOperation)static_A_symbol_243.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_243 = dynamic_A_symbol_243.evaluate(evaluator, T_Boolean, A_symbol_240, A_symbol_242);
				rightA_symbol_237 = A_symbol_243;
			} catch (InvalidValueException e) {
				rightA_symbol_237 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_243 = rightA_symbol_237;
			DomainType static_A_symbol_237 = valueFactory.typeOf(A_symbol_239);
			LibraryBinaryOperation dynamic_A_symbol_237 = (LibraryBinaryOperation)static_A_symbol_237.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_237 = dynamic_A_symbol_237.evaluate(evaluator, T_Boolean, A_symbol_239, A_symbol_243);
			return A_symbol_237;
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
			
			Value leftA_symbol_244;
			try {
				
				Value A_symbol_245 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_246 = valueFactory.typeOf(A_symbol_245, S_collect);
				LibraryBinaryOperation dynamic_A_symbol_246 = (LibraryBinaryOperation)static_A_symbol_246.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_246 = dynamic_A_symbol_246.evaluate(evaluator, T_Boolean, A_symbol_245, S_collect);
				leftA_symbol_244 = A_symbol_246;
			} catch (InvalidValueException e) {
				leftA_symbol_244 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_246 = leftA_symbol_244;
			Value rightA_symbol_244;
			try {
					Value leftA_symbol_247;
					try {
						
						Value A_symbol_248 = IP_CallExp_source.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_CallExp_source);
						
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
						
						Value A_symbol_251 = IP_CallExp_source.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_CallExp_source);
						
						Value A_symbol_252 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_251, P_TypedElement_type);
						
						DomainType static_A_symbol_253 = valueFactory.typeOf(A_symbol_252);
						LibraryBinaryOperation dynamic_A_symbol_253 = (LibraryBinaryOperation)static_A_symbol_253.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Value A_symbol_253 = dynamic_A_symbol_253.evaluate(evaluator, T_Boolean, A_symbol_252, T_ClassClassifier_Pivot_ecore__pivot__OrderedSetType_);
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
					Value A_symbol_258 = dynamic_A_symbol_258.evaluate(evaluator, T_Boolean, A_symbol_257, T_ClassClassifier_Pivot_ecore__pivot__BagType_);
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
			
			Value leftA_symbol_259;
			try {
				
				Value A_symbol_260 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_261 = valueFactory.typeOf(A_symbol_260, S_exists);
				LibraryBinaryOperation dynamic_A_symbol_261 = (LibraryBinaryOperation)static_A_symbol_261.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_261 = dynamic_A_symbol_261.evaluate(evaluator, T_Boolean, A_symbol_260, S_exists);
				leftA_symbol_259 = A_symbol_261;
			} catch (InvalidValueException e) {
				leftA_symbol_259 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_261 = leftA_symbol_259;
			Value rightA_symbol_259;
			try {
				
				Value A_symbol_262 = IP_LoopExp_body.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_LoopExp_body);
				
				Value A_symbol_263 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_262, P_TypedElement_type);
				
				DomainType static_A_symbol_264 = valueFactory.typeOf(A_symbol_263, T_ClassClassifier_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_264 = (LibraryBinaryOperation)static_A_symbol_264.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_264 = dynamic_A_symbol_264.evaluate(evaluator, T_Boolean, A_symbol_263, T_ClassClassifier_Boolean_);
				rightA_symbol_259 = A_symbol_264;
			} catch (InvalidValueException e) {
				rightA_symbol_259 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_264 = rightA_symbol_259;
			DomainType static_A_symbol_259 = valueFactory.typeOf(A_symbol_261);
			LibraryBinaryOperation dynamic_A_symbol_259 = (LibraryBinaryOperation)static_A_symbol_259.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_259 = dynamic_A_symbol_259.evaluate(evaluator, T_Boolean, A_symbol_261, A_symbol_264);
			return A_symbol_259;
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
			
			Value leftA_symbol_265;
			try {
				
				Value A_symbol_266 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_267 = valueFactory.typeOf(A_symbol_266, S_exists);
				LibraryBinaryOperation dynamic_A_symbol_267 = (LibraryBinaryOperation)static_A_symbol_267.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_267 = dynamic_A_symbol_267.evaluate(evaluator, T_Boolean, A_symbol_266, S_exists);
				leftA_symbol_265 = A_symbol_267;
			} catch (InvalidValueException e) {
				leftA_symbol_265 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_267 = leftA_symbol_265;
			Value rightA_symbol_265;
			try {
				
				Value A_symbol_268 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_269 = valueFactory.typeOf(A_symbol_268, T_ClassClassifier_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_269 = (LibraryBinaryOperation)static_A_symbol_269.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_269 = dynamic_A_symbol_269.evaluate(evaluator, T_Boolean, A_symbol_268, T_ClassClassifier_Boolean_);
				rightA_symbol_265 = A_symbol_269;
			} catch (InvalidValueException e) {
				rightA_symbol_265 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_269 = rightA_symbol_265;
			DomainType static_A_symbol_265 = valueFactory.typeOf(A_symbol_267);
			LibraryBinaryOperation dynamic_A_symbol_265 = (LibraryBinaryOperation)static_A_symbol_265.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_265 = dynamic_A_symbol_265.evaluate(evaluator, T_Boolean, A_symbol_267, A_symbol_269);
			return A_symbol_265;
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
			
			Value leftA_symbol_270;
			try {
				
				Value A_symbol_271 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_272 = valueFactory.typeOf(A_symbol_271, S_forAll);
				LibraryBinaryOperation dynamic_A_symbol_272 = (LibraryBinaryOperation)static_A_symbol_272.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_272 = dynamic_A_symbol_272.evaluate(evaluator, T_Boolean, A_symbol_271, S_forAll);
				leftA_symbol_270 = A_symbol_272;
			} catch (InvalidValueException e) {
				leftA_symbol_270 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_272 = leftA_symbol_270;
			Value rightA_symbol_270;
			try {
				
				Value A_symbol_273 = IP_LoopExp_body.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_LoopExp_body);
				
				Value A_symbol_274 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_273, P_TypedElement_type);
				
				DomainType static_A_symbol_275 = valueFactory.typeOf(A_symbol_274, T_ClassClassifier_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_275 = (LibraryBinaryOperation)static_A_symbol_275.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_275 = dynamic_A_symbol_275.evaluate(evaluator, T_Boolean, A_symbol_274, T_ClassClassifier_Boolean_);
				rightA_symbol_270 = A_symbol_275;
			} catch (InvalidValueException e) {
				rightA_symbol_270 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_275 = rightA_symbol_270;
			DomainType static_A_symbol_270 = valueFactory.typeOf(A_symbol_272);
			LibraryBinaryOperation dynamic_A_symbol_270 = (LibraryBinaryOperation)static_A_symbol_270.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_270 = dynamic_A_symbol_270.evaluate(evaluator, T_Boolean, A_symbol_272, A_symbol_275);
			return A_symbol_270;
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
			
			Value leftA_symbol_276;
			try {
				
				Value A_symbol_277 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_278 = valueFactory.typeOf(A_symbol_277, S_forAll);
				LibraryBinaryOperation dynamic_A_symbol_278 = (LibraryBinaryOperation)static_A_symbol_278.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_278 = dynamic_A_symbol_278.evaluate(evaluator, T_Boolean, A_symbol_277, S_forAll);
				leftA_symbol_276 = A_symbol_278;
			} catch (InvalidValueException e) {
				leftA_symbol_276 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_278 = leftA_symbol_276;
			Value rightA_symbol_276;
			try {
				
				Value A_symbol_279 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_280 = valueFactory.typeOf(A_symbol_279, T_ClassClassifier_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_280 = (LibraryBinaryOperation)static_A_symbol_280.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_280 = dynamic_A_symbol_280.evaluate(evaluator, T_Boolean, A_symbol_279, T_ClassClassifier_Boolean_);
				rightA_symbol_276 = A_symbol_280;
			} catch (InvalidValueException e) {
				rightA_symbol_276 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_280 = rightA_symbol_276;
			DomainType static_A_symbol_276 = valueFactory.typeOf(A_symbol_278);
			LibraryBinaryOperation dynamic_A_symbol_276 = (LibraryBinaryOperation)static_A_symbol_276.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_276 = dynamic_A_symbol_276.evaluate(evaluator, T_Boolean, A_symbol_278, A_symbol_280);
			return A_symbol_276;
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
			
			Value leftA_symbol_281;
			try {
				
				Value A_symbol_282 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_283 = valueFactory.typeOf(A_symbol_282, S_isUnique);
				LibraryBinaryOperation dynamic_A_symbol_283 = (LibraryBinaryOperation)static_A_symbol_283.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_283 = dynamic_A_symbol_283.evaluate(evaluator, T_Boolean, A_symbol_282, S_isUnique);
				leftA_symbol_281 = A_symbol_283;
			} catch (InvalidValueException e) {
				leftA_symbol_281 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_283 = leftA_symbol_281;
			Value rightA_symbol_281;
			try {
				
				Value A_symbol_284 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_Pivot_ecore__pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_285 = valueFactory.typeOf(A_symbol_284);
				LibraryUnaryOperation dynamic_A_symbol_285 = (LibraryUnaryOperation)static_A_symbol_285.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_285 = dynamic_A_symbol_285.evaluate(evaluator, T_Integer, A_symbol_284);
				DomainType static_A_symbol_286 = valueFactory.typeOf(A_symbol_285, I_1);
				LibraryBinaryOperation dynamic_A_symbol_286 = (LibraryBinaryOperation)static_A_symbol_286.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_286 = dynamic_A_symbol_286.evaluate(evaluator, T_Boolean, A_symbol_285, I_1);
				rightA_symbol_281 = A_symbol_286;
			} catch (InvalidValueException e) {
				rightA_symbol_281 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_286 = rightA_symbol_281;
			DomainType static_A_symbol_281 = valueFactory.typeOf(A_symbol_283);
			LibraryBinaryOperation dynamic_A_symbol_281 = (LibraryBinaryOperation)static_A_symbol_281.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_281 = dynamic_A_symbol_281.evaluate(evaluator, T_Boolean, A_symbol_283, A_symbol_286);
			return A_symbol_281;
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
			
			Value leftA_symbol_287;
			try {
				
				Value A_symbol_288 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_289 = valueFactory.typeOf(A_symbol_288, S_isUnique);
				LibraryBinaryOperation dynamic_A_symbol_289 = (LibraryBinaryOperation)static_A_symbol_289.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_289 = dynamic_A_symbol_289.evaluate(evaluator, T_Boolean, A_symbol_288, S_isUnique);
				leftA_symbol_287 = A_symbol_289;
			} catch (InvalidValueException e) {
				leftA_symbol_287 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_289 = leftA_symbol_287;
			Value rightA_symbol_287;
			try {
				
				Value A_symbol_290 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_291 = valueFactory.typeOf(A_symbol_290, T_ClassClassifier_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_291 = (LibraryBinaryOperation)static_A_symbol_291.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_291 = dynamic_A_symbol_291.evaluate(evaluator, T_Boolean, A_symbol_290, T_ClassClassifier_Boolean_);
				rightA_symbol_287 = A_symbol_291;
			} catch (InvalidValueException e) {
				rightA_symbol_287 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_291 = rightA_symbol_287;
			DomainType static_A_symbol_287 = valueFactory.typeOf(A_symbol_289);
			LibraryBinaryOperation dynamic_A_symbol_287 = (LibraryBinaryOperation)static_A_symbol_287.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_287 = dynamic_A_symbol_287.evaluate(evaluator, T_Boolean, A_symbol_289, A_symbol_291);
			return A_symbol_287;
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
			
			
			Value A_symbol_292 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_Pivot_ecore__pivot__Variable_, self, P_LoopExp_iterator);
			
			
			/** 
			 * Implementation of the iterator body.
			 */
			AbstractBinaryOperation body_A_symbol_293 = new AbstractBinaryOperation()
			{
			/*
			type =
			source.type.oclAsType(_'file:/C:/Development/QVTd/GIT/org.eclipse.ocl/examples/org.eclipse.ocl.examples.pivot/model/Pivot.ecore'::ocl::CollectionType).elementType
			*/
				public Value evaluate(DomainEvaluator evaluator, DomainType returnType, Value sourceValue, Value iterator1) throws InvalidValueException {
					final Value V_1_ = iterator1;	// iterator: 1_
					
					Value A_symbol_294 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, V_1_, P_TypedElement_type);
					
					
					Value A_symbol_295 = IP_CallExp_source.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_CallExp_source);
					
					Value A_symbol_296 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_295, P_TypedElement_type);
					
					DomainType static_A_symbol_297 = valueFactory.typeOf(A_symbol_296);
					LibraryBinaryOperation dynamic_A_symbol_297 = (LibraryBinaryOperation)static_A_symbol_297.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
					Value A_symbol_297 = dynamic_A_symbol_297.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionType, A_symbol_296, T_ClassClassifier_Pivot_ecore__pivot__CollectionType_);
					Value A_symbol_298 = IP_CollectionType_elementType.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_297, P_CollectionType_elementType);
					
					DomainType static_A_symbol_299 = valueFactory.typeOf(A_symbol_294, A_symbol_298);
					LibraryBinaryOperation dynamic_A_symbol_299 = (LibraryBinaryOperation)static_A_symbol_299.lookupImplementation(standardLibrary, O_OclAny__eq_);
					Value A_symbol_299 = dynamic_A_symbol_299.evaluate(evaluator, T_Boolean, A_symbol_294, A_symbol_298);
					return A_symbol_299;
				}
			};
			DomainType static_A_symbol_293 = A_symbol_292.getType();
			LibraryIteration dynamic_A_symbol_293 = (LibraryIteration)static_A_symbol_293.lookupImplementation(standardLibrary, O_Collection_forAll);
			Value acc_A_symbol_293 = dynamic_A_symbol_293.createAccumulatorValue(evaluator, T_Boolean, T_Boolean);
			ExecutorSingleIterationManager manager_A_symbol_293 = new ExecutorSingleIterationManager(evaluator, T_Boolean, body_A_symbol_293, (CollectionValue)A_symbol_292, acc_A_symbol_293);
			Value A_symbol_293 = dynamic_A_symbol_293.evaluateIteration(manager_A_symbol_293);
			return A_symbol_293;
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
			
			Value leftA_symbol_300;
			try {
				
				Value A_symbol_301 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_302 = valueFactory.typeOf(A_symbol_301, S_one);
				LibraryBinaryOperation dynamic_A_symbol_302 = (LibraryBinaryOperation)static_A_symbol_302.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_302 = dynamic_A_symbol_302.evaluate(evaluator, T_Boolean, A_symbol_301, S_one);
				leftA_symbol_300 = A_symbol_302;
			} catch (InvalidValueException e) {
				leftA_symbol_300 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_302 = leftA_symbol_300;
			Value rightA_symbol_300;
			try {
				
				Value A_symbol_303 = IP_LoopExp_body.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_LoopExp_body);
				
				Value A_symbol_304 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_303, P_TypedElement_type);
				
				DomainType static_A_symbol_305 = valueFactory.typeOf(A_symbol_304, T_ClassClassifier_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_305 = (LibraryBinaryOperation)static_A_symbol_305.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_305 = dynamic_A_symbol_305.evaluate(evaluator, T_Boolean, A_symbol_304, T_ClassClassifier_Boolean_);
				rightA_symbol_300 = A_symbol_305;
			} catch (InvalidValueException e) {
				rightA_symbol_300 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_305 = rightA_symbol_300;
			DomainType static_A_symbol_300 = valueFactory.typeOf(A_symbol_302);
			LibraryBinaryOperation dynamic_A_symbol_300 = (LibraryBinaryOperation)static_A_symbol_300.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_300 = dynamic_A_symbol_300.evaluate(evaluator, T_Boolean, A_symbol_302, A_symbol_305);
			return A_symbol_300;
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
			
			Value leftA_symbol_306;
			try {
				
				Value A_symbol_307 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_308 = valueFactory.typeOf(A_symbol_307, S_one);
				LibraryBinaryOperation dynamic_A_symbol_308 = (LibraryBinaryOperation)static_A_symbol_308.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_308 = dynamic_A_symbol_308.evaluate(evaluator, T_Boolean, A_symbol_307, S_one);
				leftA_symbol_306 = A_symbol_308;
			} catch (InvalidValueException e) {
				leftA_symbol_306 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_308 = leftA_symbol_306;
			Value rightA_symbol_306;
			try {
				
				Value A_symbol_309 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_Pivot_ecore__pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_310 = valueFactory.typeOf(A_symbol_309);
				LibraryUnaryOperation dynamic_A_symbol_310 = (LibraryUnaryOperation)static_A_symbol_310.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_310 = dynamic_A_symbol_310.evaluate(evaluator, T_Integer, A_symbol_309);
				DomainType static_A_symbol_311 = valueFactory.typeOf(A_symbol_310, I_1);
				LibraryBinaryOperation dynamic_A_symbol_311 = (LibraryBinaryOperation)static_A_symbol_311.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_311 = dynamic_A_symbol_311.evaluate(evaluator, T_Boolean, A_symbol_310, I_1);
				rightA_symbol_306 = A_symbol_311;
			} catch (InvalidValueException e) {
				rightA_symbol_306 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_311 = rightA_symbol_306;
			DomainType static_A_symbol_306 = valueFactory.typeOf(A_symbol_308);
			LibraryBinaryOperation dynamic_A_symbol_306 = (LibraryBinaryOperation)static_A_symbol_306.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_306 = dynamic_A_symbol_306.evaluate(evaluator, T_Boolean, A_symbol_308, A_symbol_311);
			return A_symbol_306;
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
			
			Value leftA_symbol_312;
			try {
				
				Value A_symbol_313 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_314 = valueFactory.typeOf(A_symbol_313, S_one);
				LibraryBinaryOperation dynamic_A_symbol_314 = (LibraryBinaryOperation)static_A_symbol_314.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_314 = dynamic_A_symbol_314.evaluate(evaluator, T_Boolean, A_symbol_313, S_one);
				leftA_symbol_312 = A_symbol_314;
			} catch (InvalidValueException e) {
				leftA_symbol_312 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_314 = leftA_symbol_312;
			Value rightA_symbol_312;
			try {
				
				Value A_symbol_315 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_316 = valueFactory.typeOf(A_symbol_315, T_ClassClassifier_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_316 = (LibraryBinaryOperation)static_A_symbol_316.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_316 = dynamic_A_symbol_316.evaluate(evaluator, T_Boolean, A_symbol_315, T_ClassClassifier_Boolean_);
				rightA_symbol_312 = A_symbol_316;
			} catch (InvalidValueException e) {
				rightA_symbol_312 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_316 = rightA_symbol_312;
			DomainType static_A_symbol_312 = valueFactory.typeOf(A_symbol_314);
			LibraryBinaryOperation dynamic_A_symbol_312 = (LibraryBinaryOperation)static_A_symbol_312.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_312 = dynamic_A_symbol_312.evaluate(evaluator, T_Boolean, A_symbol_314, A_symbol_316);
			return A_symbol_312;
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
			
			Value leftA_symbol_317;
			try {
				Value leftA_symbol_318;
				try {
					
					Value A_symbol_319 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
					
					DomainType static_A_symbol_320 = valueFactory.typeOf(A_symbol_319, S_reject);
					LibraryBinaryOperation dynamic_A_symbol_320 = (LibraryBinaryOperation)static_A_symbol_320.lookupImplementation(standardLibrary, O_String__eq_);
					Value A_symbol_320 = dynamic_A_symbol_320.evaluate(evaluator, T_Boolean, A_symbol_319, S_reject);
					leftA_symbol_318 = A_symbol_320;
				} catch (InvalidValueException e) {
					leftA_symbol_318 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_320 = leftA_symbol_318;
				Value rightA_symbol_318;
				try {
					
					Value A_symbol_321 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
					
					DomainType static_A_symbol_322 = valueFactory.typeOf(A_symbol_321, S_select);
					LibraryBinaryOperation dynamic_A_symbol_322 = (LibraryBinaryOperation)static_A_symbol_322.lookupImplementation(standardLibrary, O_String__eq_);
					Value A_symbol_322 = dynamic_A_symbol_322.evaluate(evaluator, T_Boolean, A_symbol_321, S_select);
					rightA_symbol_318 = A_symbol_322;
				} catch (InvalidValueException e) {
					rightA_symbol_318 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_322 = rightA_symbol_318;
				DomainType static_A_symbol_318 = valueFactory.typeOf(A_symbol_320);
				LibraryBinaryOperation dynamic_A_symbol_318 = (LibraryBinaryOperation)static_A_symbol_318.lookupImplementation(standardLibrary, O_Boolean_or);
				Value A_symbol_318 = dynamic_A_symbol_318.evaluate(evaluator, T_Boolean, A_symbol_320, A_symbol_322);
				leftA_symbol_317 = A_symbol_318;
			} catch (InvalidValueException e) {
				leftA_symbol_317 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_318 = leftA_symbol_317;
			Value rightA_symbol_317;
			try {
				
				Value A_symbol_323 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_Pivot_ecore__pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_324 = valueFactory.typeOf(A_symbol_323);
				LibraryUnaryOperation dynamic_A_symbol_324 = (LibraryUnaryOperation)static_A_symbol_324.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_324 = dynamic_A_symbol_324.evaluate(evaluator, T_Integer, A_symbol_323);
				DomainType static_A_symbol_325 = valueFactory.typeOf(A_symbol_324, I_1);
				LibraryBinaryOperation dynamic_A_symbol_325 = (LibraryBinaryOperation)static_A_symbol_325.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_325 = dynamic_A_symbol_325.evaluate(evaluator, T_Boolean, A_symbol_324, I_1);
				rightA_symbol_317 = A_symbol_325;
			} catch (InvalidValueException e) {
				rightA_symbol_317 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_325 = rightA_symbol_317;
			DomainType static_A_symbol_317 = valueFactory.typeOf(A_symbol_318);
			LibraryBinaryOperation dynamic_A_symbol_317 = (LibraryBinaryOperation)static_A_symbol_317.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_317 = dynamic_A_symbol_317.evaluate(evaluator, T_Boolean, A_symbol_318, A_symbol_325);
			return A_symbol_317;
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
			
			Value leftA_symbol_326;
			try {
				Value leftA_symbol_327;
				try {
					
					Value A_symbol_328 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
					
					DomainType static_A_symbol_329 = valueFactory.typeOf(A_symbol_328, S_reject);
					LibraryBinaryOperation dynamic_A_symbol_329 = (LibraryBinaryOperation)static_A_symbol_329.lookupImplementation(standardLibrary, O_String__eq_);
					Value A_symbol_329 = dynamic_A_symbol_329.evaluate(evaluator, T_Boolean, A_symbol_328, S_reject);
					leftA_symbol_327 = A_symbol_329;
				} catch (InvalidValueException e) {
					leftA_symbol_327 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_329 = leftA_symbol_327;
				Value rightA_symbol_327;
				try {
					
					Value A_symbol_330 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
					
					DomainType static_A_symbol_331 = valueFactory.typeOf(A_symbol_330, S_select);
					LibraryBinaryOperation dynamic_A_symbol_331 = (LibraryBinaryOperation)static_A_symbol_331.lookupImplementation(standardLibrary, O_String__eq_);
					Value A_symbol_331 = dynamic_A_symbol_331.evaluate(evaluator, T_Boolean, A_symbol_330, S_select);
					rightA_symbol_327 = A_symbol_331;
				} catch (InvalidValueException e) {
					rightA_symbol_327 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_331 = rightA_symbol_327;
				DomainType static_A_symbol_327 = valueFactory.typeOf(A_symbol_329);
				LibraryBinaryOperation dynamic_A_symbol_327 = (LibraryBinaryOperation)static_A_symbol_327.lookupImplementation(standardLibrary, O_Boolean_or);
				Value A_symbol_327 = dynamic_A_symbol_327.evaluate(evaluator, T_Boolean, A_symbol_329, A_symbol_331);
				leftA_symbol_326 = A_symbol_327;
			} catch (InvalidValueException e) {
				leftA_symbol_326 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_327 = leftA_symbol_326;
			Value rightA_symbol_326;
			try {
				
				Value A_symbol_332 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_333 = valueFactory.typeOf(A_symbol_332, T_ClassClassifier_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_333 = (LibraryBinaryOperation)static_A_symbol_333.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_333 = dynamic_A_symbol_333.evaluate(evaluator, T_Boolean, A_symbol_332, T_ClassClassifier_Boolean_);
				rightA_symbol_326 = A_symbol_333;
			} catch (InvalidValueException e) {
				rightA_symbol_326 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_333 = rightA_symbol_326;
			DomainType static_A_symbol_326 = valueFactory.typeOf(A_symbol_327);
			LibraryBinaryOperation dynamic_A_symbol_326 = (LibraryBinaryOperation)static_A_symbol_326.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_326 = dynamic_A_symbol_326.evaluate(evaluator, T_Boolean, A_symbol_327, A_symbol_333);
			return A_symbol_326;
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
			
			Value leftA_symbol_334;
			try {
				Value leftA_symbol_335;
				try {
					
					Value A_symbol_336 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
					
					DomainType static_A_symbol_337 = valueFactory.typeOf(A_symbol_336, S_reject);
					LibraryBinaryOperation dynamic_A_symbol_337 = (LibraryBinaryOperation)static_A_symbol_337.lookupImplementation(standardLibrary, O_String__eq_);
					Value A_symbol_337 = dynamic_A_symbol_337.evaluate(evaluator, T_Boolean, A_symbol_336, S_reject);
					leftA_symbol_335 = A_symbol_337;
				} catch (InvalidValueException e) {
					leftA_symbol_335 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_337 = leftA_symbol_335;
				Value rightA_symbol_335;
				try {
					
					Value A_symbol_338 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
					
					DomainType static_A_symbol_339 = valueFactory.typeOf(A_symbol_338, S_select);
					LibraryBinaryOperation dynamic_A_symbol_339 = (LibraryBinaryOperation)static_A_symbol_339.lookupImplementation(standardLibrary, O_String__eq_);
					Value A_symbol_339 = dynamic_A_symbol_339.evaluate(evaluator, T_Boolean, A_symbol_338, S_select);
					rightA_symbol_335 = A_symbol_339;
				} catch (InvalidValueException e) {
					rightA_symbol_335 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_339 = rightA_symbol_335;
				DomainType static_A_symbol_335 = valueFactory.typeOf(A_symbol_337);
				LibraryBinaryOperation dynamic_A_symbol_335 = (LibraryBinaryOperation)static_A_symbol_335.lookupImplementation(standardLibrary, O_Boolean_or);
				Value A_symbol_335 = dynamic_A_symbol_335.evaluate(evaluator, T_Boolean, A_symbol_337, A_symbol_339);
				leftA_symbol_334 = A_symbol_335;
			} catch (InvalidValueException e) {
				leftA_symbol_334 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_335 = leftA_symbol_334;
			Value rightA_symbol_334;
			try {
				
				Value A_symbol_340 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				
				Value A_symbol_341 = IP_CallExp_source.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_CallExp_source);
				
				Value A_symbol_342 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_341, P_TypedElement_type);
				
				DomainType static_A_symbol_343 = valueFactory.typeOf(A_symbol_340, A_symbol_342);
				LibraryBinaryOperation dynamic_A_symbol_343 = (LibraryBinaryOperation)static_A_symbol_343.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_343 = dynamic_A_symbol_343.evaluate(evaluator, T_Boolean, A_symbol_340, A_symbol_342);
				rightA_symbol_334 = A_symbol_343;
			} catch (InvalidValueException e) {
				rightA_symbol_334 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_343 = rightA_symbol_334;
			DomainType static_A_symbol_334 = valueFactory.typeOf(A_symbol_335);
			LibraryBinaryOperation dynamic_A_symbol_334 = (LibraryBinaryOperation)static_A_symbol_334.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_334 = dynamic_A_symbol_334.evaluate(evaluator, T_Boolean, A_symbol_335, A_symbol_343);
			return A_symbol_334;
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
			
			Value leftA_symbol_344;
			try {
				
				Value A_symbol_345 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_346 = valueFactory.typeOf(A_symbol_345, S_sortedBy);
				LibraryBinaryOperation dynamic_A_symbol_346 = (LibraryBinaryOperation)static_A_symbol_346.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_346 = dynamic_A_symbol_346.evaluate(evaluator, T_Boolean, A_symbol_345, S_sortedBy);
				leftA_symbol_344 = A_symbol_346;
			} catch (InvalidValueException e) {
				leftA_symbol_344 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_346 = leftA_symbol_344;
			Value rightA_symbol_344;
			try {
				
				Value A_symbol_347 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_348 = valueFactory.typeOf(A_symbol_347);
				LibraryBinaryOperation dynamic_A_symbol_348 = (LibraryBinaryOperation)static_A_symbol_348.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_348 = dynamic_A_symbol_348.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionType, A_symbol_347, T_ClassClassifier_Pivot_ecore__pivot__CollectionType_);
				Value A_symbol_349 = IP_CollectionType_elementType.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_348, P_CollectionType_elementType);
				
				
				Value A_symbol_350 = IP_LoopExp_body.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_LoopExp_body);
				
				Value A_symbol_351 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_350, P_TypedElement_type);
				
				DomainType static_A_symbol_352 = valueFactory.typeOf(A_symbol_351);
				LibraryBinaryOperation dynamic_A_symbol_352 = (LibraryBinaryOperation)static_A_symbol_352.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_352 = dynamic_A_symbol_352.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionType, A_symbol_351, T_ClassClassifier_Pivot_ecore__pivot__CollectionType_);
				Value A_symbol_353 = IP_CollectionType_elementType.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_352, P_CollectionType_elementType);
				
				DomainType static_A_symbol_354 = valueFactory.typeOf(A_symbol_349, A_symbol_353);
				LibraryBinaryOperation dynamic_A_symbol_354 = (LibraryBinaryOperation)static_A_symbol_354.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_354 = dynamic_A_symbol_354.evaluate(evaluator, T_Boolean, A_symbol_349, A_symbol_353);
				rightA_symbol_344 = A_symbol_354;
			} catch (InvalidValueException e) {
				rightA_symbol_344 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_354 = rightA_symbol_344;
			DomainType static_A_symbol_344 = valueFactory.typeOf(A_symbol_346);
			LibraryBinaryOperation dynamic_A_symbol_344 = (LibraryBinaryOperation)static_A_symbol_344.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_344 = dynamic_A_symbol_344.evaluate(evaluator, T_Boolean, A_symbol_346, A_symbol_354);
			return A_symbol_344;
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
			
			Value leftA_symbol_355;
			try {
				
				Value A_symbol_356 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_357 = valueFactory.typeOf(A_symbol_356, S_sortedBy);
				LibraryBinaryOperation dynamic_A_symbol_357 = (LibraryBinaryOperation)static_A_symbol_357.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_357 = dynamic_A_symbol_357.evaluate(evaluator, T_Boolean, A_symbol_356, S_sortedBy);
				leftA_symbol_355 = A_symbol_357;
			} catch (InvalidValueException e) {
				leftA_symbol_355 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_357 = leftA_symbol_355;
			Value rightA_symbol_355;
			try {
				
				Value A_symbol_358 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_Pivot_ecore__pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_359 = valueFactory.typeOf(A_symbol_358);
				LibraryUnaryOperation dynamic_A_symbol_359 = (LibraryUnaryOperation)static_A_symbol_359.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_359 = dynamic_A_symbol_359.evaluate(evaluator, T_Integer, A_symbol_358);
				DomainType static_A_symbol_360 = valueFactory.typeOf(A_symbol_359, I_1);
				LibraryBinaryOperation dynamic_A_symbol_360 = (LibraryBinaryOperation)static_A_symbol_360.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_360 = dynamic_A_symbol_360.evaluate(evaluator, T_Boolean, A_symbol_359, I_1);
				rightA_symbol_355 = A_symbol_360;
			} catch (InvalidValueException e) {
				rightA_symbol_355 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_360 = rightA_symbol_355;
			DomainType static_A_symbol_355 = valueFactory.typeOf(A_symbol_357);
			LibraryBinaryOperation dynamic_A_symbol_355 = (LibraryBinaryOperation)static_A_symbol_355.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_355 = dynamic_A_symbol_355.evaluate(evaluator, T_Boolean, A_symbol_357, A_symbol_360);
			return A_symbol_355;
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
			
			Value leftA_symbol_361;
			try {
				
				Value A_symbol_362 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_363 = valueFactory.typeOf(A_symbol_362, S_sortedBy);
				LibraryBinaryOperation dynamic_A_symbol_363 = (LibraryBinaryOperation)static_A_symbol_363.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_363 = dynamic_A_symbol_363.evaluate(evaluator, T_Boolean, A_symbol_362, S_sortedBy);
				leftA_symbol_361 = A_symbol_363;
			} catch (InvalidValueException e) {
				leftA_symbol_361 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_363 = leftA_symbol_361;
			Value rightA_symbol_361;
			try {
					Value leftA_symbol_364;
					try {
						
						Value A_symbol_365 = IP_CallExp_source.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_CallExp_source);
						
						Value A_symbol_366 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_365, P_TypedElement_type);
						
						DomainType static_A_symbol_367 = valueFactory.typeOf(A_symbol_366);
						LibraryBinaryOperation dynamic_A_symbol_367 = (LibraryBinaryOperation)static_A_symbol_367.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Value A_symbol_367 = dynamic_A_symbol_367.evaluate(evaluator, T_Boolean, A_symbol_366, T_ClassClassifier_Pivot_ecore__pivot__SequenceType_);
						leftA_symbol_364 = A_symbol_367;
					} catch (InvalidValueException e) {
						leftA_symbol_364 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_367 = leftA_symbol_364;
					Value rightA_symbol_364;
					try {
						
						Value A_symbol_368 = IP_CallExp_source.evaluate(evaluator, T_Pivot_ecore__pivot__OCLExpression, self, P_CallExp_source);
						
						Value A_symbol_369 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, A_symbol_368, P_TypedElement_type);
						
						DomainType static_A_symbol_370 = valueFactory.typeOf(A_symbol_369);
						LibraryBinaryOperation dynamic_A_symbol_370 = (LibraryBinaryOperation)static_A_symbol_370.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Value A_symbol_370 = dynamic_A_symbol_370.evaluate(evaluator, T_Boolean, A_symbol_369, T_ClassClassifier_Pivot_ecore__pivot__BagType_);
						rightA_symbol_364 = A_symbol_370;
					} catch (InvalidValueException e) {
						rightA_symbol_364 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_370 = rightA_symbol_364;
					DomainType static_A_symbol_364 = valueFactory.typeOf(A_symbol_367);
					LibraryBinaryOperation dynamic_A_symbol_364 = (LibraryBinaryOperation)static_A_symbol_364.lookupImplementation(standardLibrary, O_Boolean_or);
					Value A_symbol_364 = dynamic_A_symbol_364.evaluate(evaluator, T_Boolean, A_symbol_367, A_symbol_370);
				Value A_symbol_371;
				if (A_symbol_364.isTrue()) {
					
					Value A_symbol_372 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
					
					DomainType static_A_symbol_373 = valueFactory.typeOf(A_symbol_372);
					LibraryBinaryOperation dynamic_A_symbol_373 = (LibraryBinaryOperation)static_A_symbol_373.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Value A_symbol_373 = dynamic_A_symbol_373.evaluate(evaluator, T_Boolean, A_symbol_372, T_ClassClassifier_Pivot_ecore__pivot__SequenceType_);
					A_symbol_371 = A_symbol_373;
				}
				else if (A_symbol_364.isFalse()) {
					
					Value A_symbol_374 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
					
					DomainType static_A_symbol_375 = valueFactory.typeOf(A_symbol_374);
					LibraryBinaryOperation dynamic_A_symbol_375 = (LibraryBinaryOperation)static_A_symbol_375.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Value A_symbol_375 = dynamic_A_symbol_375.evaluate(evaluator, T_Boolean, A_symbol_374, T_ClassClassifier_Pivot_ecore__pivot__OrderedSetType_);
					A_symbol_371 = A_symbol_375;
				}
				else if (A_symbol_364.isNull()) {
					A_symbol_371 = valueFactory.throwInvalidValueException("null if condition");
				}
				else {
					A_symbol_371 = valueFactory.throwInvalidValueException("invalid if condition");
				}
				rightA_symbol_361 = A_symbol_371;
			} catch (InvalidValueException e) {
				rightA_symbol_361 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_371 = rightA_symbol_361;
			DomainType static_A_symbol_361 = valueFactory.typeOf(A_symbol_363);
			LibraryBinaryOperation dynamic_A_symbol_361 = (LibraryBinaryOperation)static_A_symbol_361.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_361 = dynamic_A_symbol_361.evaluate(evaluator, T_Boolean, A_symbol_363, A_symbol_371);
			return A_symbol_361;
		}
	}
}

