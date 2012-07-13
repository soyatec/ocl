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
			final ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final ExecutorType T_pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final ExecutorProperty P_LoopExp_body = PivotTables.Properties._LoopExp__body;
			final LibraryProperty IP_LoopExp_body = P_LoopExp_body.getImplementation();
			final StringValue S_Boolean = valueFactory.stringValueOf("Boolean");
			
			Value leftA_symbol_51;
			try {
				
				Value A_symbol_52 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_53 = valueFactory.typeOf(A_symbol_52, S_any);
				LibraryBinaryOperation dynamic_A_symbol_53 = (LibraryBinaryOperation)static_A_symbol_53.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_53 = dynamic_A_symbol_53.evaluate(evaluator, T_Boolean, A_symbol_52, S_any);
				leftA_symbol_51 = A_symbol_53;
			} catch (InvalidValueException e) {
				leftA_symbol_51 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_53 = leftA_symbol_51;
			Value rightA_symbol_51;
			try {
				
				Value A_symbol_54 = IP_LoopExp_body.evaluate(evaluator, T_pivot__OCLExpression, self, P_LoopExp_body);
				
				Value A_symbol_55 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_54, P_TypedElement_type);
				
				DomainType static_A_symbol_56 = valueFactory.typeOf(A_symbol_55, S_Boolean);
				LibraryBinaryOperation dynamic_A_symbol_56 = (LibraryBinaryOperation)static_A_symbol_56.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_56 = dynamic_A_symbol_56.evaluate(evaluator, T_Boolean, A_symbol_55, S_Boolean);
				rightA_symbol_51 = A_symbol_56;
			} catch (InvalidValueException e) {
				rightA_symbol_51 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_56 = rightA_symbol_51;
			DomainType static_A_symbol_51 = valueFactory.typeOf(A_symbol_53);
			LibraryBinaryOperation dynamic_A_symbol_51 = (LibraryBinaryOperation)static_A_symbol_51.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_51 = dynamic_A_symbol_51.evaluate(evaluator, T_Boolean, A_symbol_53, A_symbol_56);
			return A_symbol_51;
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
			final ExecutorType T_pivot__Variable = PivotTables.Types._Variable;
			final DomainCollectionType T_OrderedSet_pivot__Variable_ = standardLibrary.getOrderedSetType(T_pivot__Variable);
			final ExecutorProperty P_LoopExp_iterator = PivotTables.Properties._LoopExp__iterator;
			final LibraryProperty IP_LoopExp_iterator = P_LoopExp_iterator.getImplementation();
			final IntegerValue I_1 = valueFactory.integerValueOf(1);
			
			Value leftA_symbol_57;
			try {
				
				Value A_symbol_58 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_59 = valueFactory.typeOf(A_symbol_58, S_any);
				LibraryBinaryOperation dynamic_A_symbol_59 = (LibraryBinaryOperation)static_A_symbol_59.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_59 = dynamic_A_symbol_59.evaluate(evaluator, T_Boolean, A_symbol_58, S_any);
				leftA_symbol_57 = A_symbol_59;
			} catch (InvalidValueException e) {
				leftA_symbol_57 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_59 = leftA_symbol_57;
			Value rightA_symbol_57;
			try {
				
				Value A_symbol_60 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_61 = valueFactory.typeOf(A_symbol_60);
				LibraryUnaryOperation dynamic_A_symbol_61 = (LibraryUnaryOperation)static_A_symbol_61.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_61 = dynamic_A_symbol_61.evaluate(evaluator, T_Integer, A_symbol_60);
				DomainType static_A_symbol_62 = valueFactory.typeOf(A_symbol_61, I_1);
				LibraryBinaryOperation dynamic_A_symbol_62 = (LibraryBinaryOperation)static_A_symbol_62.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_62 = dynamic_A_symbol_62.evaluate(evaluator, T_Boolean, A_symbol_61, I_1);
				rightA_symbol_57 = A_symbol_62;
			} catch (InvalidValueException e) {
				rightA_symbol_57 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_62 = rightA_symbol_57;
			DomainType static_A_symbol_57 = valueFactory.typeOf(A_symbol_59);
			LibraryBinaryOperation dynamic_A_symbol_57 = (LibraryBinaryOperation)static_A_symbol_57.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_57 = dynamic_A_symbol_57.evaluate(evaluator, T_Boolean, A_symbol_59, A_symbol_62);
			return A_symbol_57;
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
			final ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final ExecutorProperty P_CollectionType_elementType = PivotTables.Properties._CollectionType__elementType;
			final LibraryProperty IP_CollectionType_elementType = P_CollectionType_elementType.getImplementation();
			final ExecutorType T_pivot__CollectionType = PivotTables.Types._CollectionType;
			final ExecutorOperation O_OclAny_oclAsType = OCLstdlibTables.Operations._OclAny__oclAsType;
			final ExecutorType T_pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final ExecutorProperty P_CallExp_source = PivotTables.Properties._CallExp__source;
			final LibraryProperty IP_CallExp_source = P_CallExp_source.getImplementation();
			final Value T_ClassClassifier_pivot__CollectionType_ = valueFactory.createTypeValue(PivotTables.Types._CollectionType);
			
			Value leftA_symbol_63;
			try {
				
				Value A_symbol_64 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_65 = valueFactory.typeOf(A_symbol_64, S_any);
				LibraryBinaryOperation dynamic_A_symbol_65 = (LibraryBinaryOperation)static_A_symbol_65.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_65 = dynamic_A_symbol_65.evaluate(evaluator, T_Boolean, A_symbol_64, S_any);
				leftA_symbol_63 = A_symbol_65;
			} catch (InvalidValueException e) {
				leftA_symbol_63 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_65 = leftA_symbol_63;
			Value rightA_symbol_63;
			try {
				
				Value A_symbol_66 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				
				Value A_symbol_67 = IP_CallExp_source.evaluate(evaluator, T_pivot__OCLExpression, self, P_CallExp_source);
				
				Value A_symbol_68 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_67, P_TypedElement_type);
				
				DomainType static_A_symbol_69 = valueFactory.typeOf(A_symbol_68);
				LibraryBinaryOperation dynamic_A_symbol_69 = (LibraryBinaryOperation)static_A_symbol_69.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_69 = dynamic_A_symbol_69.evaluate(evaluator, T_pivot__CollectionType, A_symbol_68, T_ClassClassifier_pivot__CollectionType_);
				Value A_symbol_70 = IP_CollectionType_elementType.evaluate(evaluator, T_Type, A_symbol_69, P_CollectionType_elementType);
				
				DomainType static_A_symbol_71 = valueFactory.typeOf(A_symbol_66, A_symbol_70);
				LibraryBinaryOperation dynamic_A_symbol_71 = (LibraryBinaryOperation)static_A_symbol_71.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_71 = dynamic_A_symbol_71.evaluate(evaluator, T_Boolean, A_symbol_66, A_symbol_70);
				rightA_symbol_63 = A_symbol_71;
			} catch (InvalidValueException e) {
				rightA_symbol_63 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_71 = rightA_symbol_63;
			DomainType static_A_symbol_63 = valueFactory.typeOf(A_symbol_65);
			LibraryBinaryOperation dynamic_A_symbol_63 = (LibraryBinaryOperation)static_A_symbol_63.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_63 = dynamic_A_symbol_63.evaluate(evaluator, T_Boolean, A_symbol_65, A_symbol_71);
			return A_symbol_63;
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
			final ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final ExecutorProperty P_CollectionType_elementType = PivotTables.Properties._CollectionType__elementType;
			final LibraryProperty IP_CollectionType_elementType = P_CollectionType_elementType.getImplementation();
			final ExecutorType T_pivot__CollectionType = PivotTables.Types._CollectionType;
			final ExecutorOperation O_OclAny_oclAsType = OCLstdlibTables.Operations._OclAny__oclAsType;
			final ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final Value T_ClassClassifier_pivot__CollectionType_ = valueFactory.createTypeValue(PivotTables.Types._CollectionType);
			final ExecutorType T_pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final ExecutorProperty P_CallExp_source = PivotTables.Properties._CallExp__source;
			final LibraryProperty IP_CallExp_source = P_CallExp_source.getImplementation();
			
			Value leftA_symbol_72;
			try {
				
				Value A_symbol_73 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_74 = valueFactory.typeOf(A_symbol_73, S_closure);
				LibraryBinaryOperation dynamic_A_symbol_74 = (LibraryBinaryOperation)static_A_symbol_74.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_74 = dynamic_A_symbol_74.evaluate(evaluator, T_Boolean, A_symbol_73, S_closure);
				leftA_symbol_72 = A_symbol_74;
			} catch (InvalidValueException e) {
				leftA_symbol_72 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_74 = leftA_symbol_72;
			Value rightA_symbol_72;
			try {
				
				Value A_symbol_75 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_76 = valueFactory.typeOf(A_symbol_75);
				LibraryBinaryOperation dynamic_A_symbol_76 = (LibraryBinaryOperation)static_A_symbol_76.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_76 = dynamic_A_symbol_76.evaluate(evaluator, T_pivot__CollectionType, A_symbol_75, T_ClassClassifier_pivot__CollectionType_);
				Value A_symbol_77 = IP_CollectionType_elementType.evaluate(evaluator, T_Type, A_symbol_76, P_CollectionType_elementType);
				
				
				Value A_symbol_78 = IP_CallExp_source.evaluate(evaluator, T_pivot__OCLExpression, self, P_CallExp_source);
				
				Value A_symbol_79 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_78, P_TypedElement_type);
				
				DomainType static_A_symbol_80 = valueFactory.typeOf(A_symbol_79);
				LibraryBinaryOperation dynamic_A_symbol_80 = (LibraryBinaryOperation)static_A_symbol_80.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_80 = dynamic_A_symbol_80.evaluate(evaluator, T_pivot__CollectionType, A_symbol_79, T_ClassClassifier_pivot__CollectionType_);
				Value A_symbol_81 = IP_CollectionType_elementType.evaluate(evaluator, T_Type, A_symbol_80, P_CollectionType_elementType);
				
				DomainType static_A_symbol_82 = valueFactory.typeOf(A_symbol_77, A_symbol_81);
				LibraryBinaryOperation dynamic_A_symbol_82 = (LibraryBinaryOperation)static_A_symbol_82.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_82 = dynamic_A_symbol_82.evaluate(evaluator, T_Boolean, A_symbol_77, A_symbol_81);
				rightA_symbol_72 = A_symbol_82;
			} catch (InvalidValueException e) {
				rightA_symbol_72 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_82 = rightA_symbol_72;
			DomainType static_A_symbol_72 = valueFactory.typeOf(A_symbol_74);
			LibraryBinaryOperation dynamic_A_symbol_72 = (LibraryBinaryOperation)static_A_symbol_72.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_72 = dynamic_A_symbol_72.evaluate(evaluator, T_Boolean, A_symbol_74, A_symbol_82);
			return A_symbol_72;
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
			final ExecutorType T_pivot__Variable = PivotTables.Types._Variable;
			final DomainCollectionType T_OrderedSet_pivot__Variable_ = standardLibrary.getOrderedSetType(T_pivot__Variable);
			final ExecutorProperty P_LoopExp_iterator = PivotTables.Properties._LoopExp__iterator;
			final LibraryProperty IP_LoopExp_iterator = P_LoopExp_iterator.getImplementation();
			final IntegerValue I_1 = valueFactory.integerValueOf(1);
			
			Value leftA_symbol_83;
			try {
				
				Value A_symbol_84 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_85 = valueFactory.typeOf(A_symbol_84, S_closure);
				LibraryBinaryOperation dynamic_A_symbol_85 = (LibraryBinaryOperation)static_A_symbol_85.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_85 = dynamic_A_symbol_85.evaluate(evaluator, T_Boolean, A_symbol_84, S_closure);
				leftA_symbol_83 = A_symbol_85;
			} catch (InvalidValueException e) {
				leftA_symbol_83 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_85 = leftA_symbol_83;
			Value rightA_symbol_83;
			try {
				
				Value A_symbol_86 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_87 = valueFactory.typeOf(A_symbol_86);
				LibraryUnaryOperation dynamic_A_symbol_87 = (LibraryUnaryOperation)static_A_symbol_87.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_87 = dynamic_A_symbol_87.evaluate(evaluator, T_Integer, A_symbol_86);
				DomainType static_A_symbol_88 = valueFactory.typeOf(A_symbol_87, I_1);
				LibraryBinaryOperation dynamic_A_symbol_88 = (LibraryBinaryOperation)static_A_symbol_88.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_88 = dynamic_A_symbol_88.evaluate(evaluator, T_Boolean, A_symbol_87, I_1);
				rightA_symbol_83 = A_symbol_88;
			} catch (InvalidValueException e) {
				rightA_symbol_83 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_88 = rightA_symbol_83;
			DomainType static_A_symbol_83 = valueFactory.typeOf(A_symbol_85);
			LibraryBinaryOperation dynamic_A_symbol_83 = (LibraryBinaryOperation)static_A_symbol_83.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_83 = dynamic_A_symbol_83.evaluate(evaluator, T_Boolean, A_symbol_85, A_symbol_88);
			return A_symbol_83;
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
			final ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final ExecutorProperty P_CollectionType_elementType = PivotTables.Properties._CollectionType__elementType;
			final LibraryProperty IP_CollectionType_elementType = P_CollectionType_elementType.getImplementation();
			final ExecutorType T_pivot__CollectionType = PivotTables.Types._CollectionType;
			final ExecutorOperation O_OclAny_oclAsType = OCLstdlibTables.Operations._OclAny__oclAsType;
			final ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final ExecutorType T_pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final ExecutorProperty P_CallExp_source = PivotTables.Properties._CallExp__source;
			final LibraryProperty IP_CallExp_source = P_CallExp_source.getImplementation();
			final Value T_ClassClassifier_pivot__CollectionType_ = valueFactory.createTypeValue(PivotTables.Types._CollectionType);
			final ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
			final ExecutorProperty P_LoopExp_body = PivotTables.Properties._LoopExp__body;
			final LibraryProperty IP_LoopExp_body = P_LoopExp_body.getImplementation();
			
			Value leftA_symbol_89;
			try {
				
				Value A_symbol_90 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_91 = valueFactory.typeOf(A_symbol_90, S_closure);
				LibraryBinaryOperation dynamic_A_symbol_91 = (LibraryBinaryOperation)static_A_symbol_91.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_91 = dynamic_A_symbol_91.evaluate(evaluator, T_Boolean, A_symbol_90, S_closure);
				leftA_symbol_89 = A_symbol_91;
			} catch (InvalidValueException e) {
				leftA_symbol_89 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_91 = leftA_symbol_89;
			Value rightA_symbol_89;
			try {
				
				Value A_symbol_92 = IP_CallExp_source.evaluate(evaluator, T_pivot__OCLExpression, self, P_CallExp_source);
				
				Value A_symbol_93 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_92, P_TypedElement_type);
				
				DomainType static_A_symbol_94 = valueFactory.typeOf(A_symbol_93);
				LibraryBinaryOperation dynamic_A_symbol_94 = (LibraryBinaryOperation)static_A_symbol_94.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_94 = dynamic_A_symbol_94.evaluate(evaluator, T_pivot__CollectionType, A_symbol_93, T_ClassClassifier_pivot__CollectionType_);
				Value A_symbol_95 = IP_CollectionType_elementType.evaluate(evaluator, T_Type, A_symbol_94, P_CollectionType_elementType);
				
					
					Value A_symbol_96 = IP_LoopExp_body.evaluate(evaluator, T_pivot__OCLExpression, self, P_LoopExp_body);
					
					Value A_symbol_97 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_96, P_TypedElement_type);
					
					DomainType static_A_symbol_98 = valueFactory.typeOf(A_symbol_97);
					LibraryBinaryOperation dynamic_A_symbol_98 = (LibraryBinaryOperation)static_A_symbol_98.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Value A_symbol_98 = dynamic_A_symbol_98.evaluate(evaluator, T_Boolean, A_symbol_97, T_ClassClassifier_pivot__CollectionType_);
				Value A_symbol_99;
				if (A_symbol_98.isTrue()) {
					
					Value A_symbol_100 = IP_LoopExp_body.evaluate(evaluator, T_pivot__OCLExpression, self, P_LoopExp_body);
					
					Value A_symbol_101 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_100, P_TypedElement_type);
					
					DomainType static_A_symbol_102 = valueFactory.typeOf(A_symbol_101);
					LibraryBinaryOperation dynamic_A_symbol_102 = (LibraryBinaryOperation)static_A_symbol_102.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
					Value A_symbol_102 = dynamic_A_symbol_102.evaluate(evaluator, T_pivot__CollectionType, A_symbol_101, T_ClassClassifier_pivot__CollectionType_);
					Value A_symbol_103 = IP_CollectionType_elementType.evaluate(evaluator, T_Type, A_symbol_102, P_CollectionType_elementType);
					
					A_symbol_99 = A_symbol_103;
				}
				else if (A_symbol_98.isFalse()) {
					
					Value A_symbol_104 = IP_LoopExp_body.evaluate(evaluator, T_pivot__OCLExpression, self, P_LoopExp_body);
					
					Value A_symbol_105 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_104, P_TypedElement_type);
					
					A_symbol_99 = A_symbol_105;
				}
				else if (A_symbol_98.isNull()) {
					A_symbol_99 = valueFactory.throwInvalidValueException("null if condition");
				}
				else {
					A_symbol_99 = valueFactory.throwInvalidValueException("invalid if condition");
				}
				DomainType static_A_symbol_106 = valueFactory.typeOf(A_symbol_95, A_symbol_99);
				LibraryBinaryOperation dynamic_A_symbol_106 = (LibraryBinaryOperation)static_A_symbol_106.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_106 = dynamic_A_symbol_106.evaluate(evaluator, T_Boolean, A_symbol_95, A_symbol_99);
				rightA_symbol_89 = A_symbol_106;
			} catch (InvalidValueException e) {
				rightA_symbol_89 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_106 = rightA_symbol_89;
			DomainType static_A_symbol_89 = valueFactory.typeOf(A_symbol_91);
			LibraryBinaryOperation dynamic_A_symbol_89 = (LibraryBinaryOperation)static_A_symbol_89.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_89 = dynamic_A_symbol_89.evaluate(evaluator, T_Boolean, A_symbol_91, A_symbol_106);
			return A_symbol_89;
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
			final ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final ExecutorType T_pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final ExecutorProperty P_CallExp_source = PivotTables.Properties._CallExp__source;
			final LibraryProperty IP_CallExp_source = P_CallExp_source.getImplementation();
			final Value T_ClassClassifier_pivot__SequenceType_ = valueFactory.createTypeValue(PivotTables.Types._SequenceType);
			final Value T_ClassClassifier_pivot__OrderedSetType_ = valueFactory.createTypeValue(PivotTables.Types._OrderedSetType);
			final Value T_ClassClassifier_pivot__SetType_ = valueFactory.createTypeValue(PivotTables.Types._SetType);
			
			Value leftA_symbol_107;
			try {
				
				Value A_symbol_108 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_109 = valueFactory.typeOf(A_symbol_108, S_closure);
				LibraryBinaryOperation dynamic_A_symbol_109 = (LibraryBinaryOperation)static_A_symbol_109.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_109 = dynamic_A_symbol_109.evaluate(evaluator, T_Boolean, A_symbol_108, S_closure);
				leftA_symbol_107 = A_symbol_109;
			} catch (InvalidValueException e) {
				leftA_symbol_107 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_109 = leftA_symbol_107;
			Value rightA_symbol_107;
			try {
					Value leftA_symbol_110;
					try {
						
						Value A_symbol_111 = IP_CallExp_source.evaluate(evaluator, T_pivot__OCLExpression, self, P_CallExp_source);
						
						Value A_symbol_112 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_111, P_TypedElement_type);
						
						DomainType static_A_symbol_113 = valueFactory.typeOf(A_symbol_112);
						LibraryBinaryOperation dynamic_A_symbol_113 = (LibraryBinaryOperation)static_A_symbol_113.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Value A_symbol_113 = dynamic_A_symbol_113.evaluate(evaluator, T_Boolean, A_symbol_112, T_ClassClassifier_pivot__SequenceType_);
						leftA_symbol_110 = A_symbol_113;
					} catch (InvalidValueException e) {
						leftA_symbol_110 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_113 = leftA_symbol_110;
					Value rightA_symbol_110;
					try {
						
						Value A_symbol_114 = IP_CallExp_source.evaluate(evaluator, T_pivot__OCLExpression, self, P_CallExp_source);
						
						Value A_symbol_115 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_114, P_TypedElement_type);
						
						DomainType static_A_symbol_116 = valueFactory.typeOf(A_symbol_115);
						LibraryBinaryOperation dynamic_A_symbol_116 = (LibraryBinaryOperation)static_A_symbol_116.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Value A_symbol_116 = dynamic_A_symbol_116.evaluate(evaluator, T_Boolean, A_symbol_115, T_ClassClassifier_pivot__OrderedSetType_);
						rightA_symbol_110 = A_symbol_116;
					} catch (InvalidValueException e) {
						rightA_symbol_110 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_116 = rightA_symbol_110;
					DomainType static_A_symbol_110 = valueFactory.typeOf(A_symbol_113);
					LibraryBinaryOperation dynamic_A_symbol_110 = (LibraryBinaryOperation)static_A_symbol_110.lookupImplementation(standardLibrary, O_Boolean_or);
					Value A_symbol_110 = dynamic_A_symbol_110.evaluate(evaluator, T_Boolean, A_symbol_113, A_symbol_116);
				Value A_symbol_117;
				if (A_symbol_110.isTrue()) {
					
					Value A_symbol_118 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
					
					DomainType static_A_symbol_119 = valueFactory.typeOf(A_symbol_118);
					LibraryBinaryOperation dynamic_A_symbol_119 = (LibraryBinaryOperation)static_A_symbol_119.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Value A_symbol_119 = dynamic_A_symbol_119.evaluate(evaluator, T_Boolean, A_symbol_118, T_ClassClassifier_pivot__OrderedSetType_);
					A_symbol_117 = A_symbol_119;
				}
				else if (A_symbol_110.isFalse()) {
					
					Value A_symbol_120 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
					
					DomainType static_A_symbol_121 = valueFactory.typeOf(A_symbol_120);
					LibraryBinaryOperation dynamic_A_symbol_121 = (LibraryBinaryOperation)static_A_symbol_121.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Value A_symbol_121 = dynamic_A_symbol_121.evaluate(evaluator, T_Boolean, A_symbol_120, T_ClassClassifier_pivot__SetType_);
					A_symbol_117 = A_symbol_121;
				}
				else if (A_symbol_110.isNull()) {
					A_symbol_117 = valueFactory.throwInvalidValueException("null if condition");
				}
				else {
					A_symbol_117 = valueFactory.throwInvalidValueException("invalid if condition");
				}
				rightA_symbol_107 = A_symbol_117;
			} catch (InvalidValueException e) {
				rightA_symbol_107 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_117 = rightA_symbol_107;
			DomainType static_A_symbol_107 = valueFactory.typeOf(A_symbol_109);
			LibraryBinaryOperation dynamic_A_symbol_107 = (LibraryBinaryOperation)static_A_symbol_107.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_107 = dynamic_A_symbol_107.evaluate(evaluator, T_Boolean, A_symbol_109, A_symbol_117);
			return A_symbol_107;
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
			final ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final ExecutorProperty P_CollectionType_elementType = PivotTables.Properties._CollectionType__elementType;
			final LibraryProperty IP_CollectionType_elementType = P_CollectionType_elementType.getImplementation();
			final ExecutorType T_pivot__CollectionType = PivotTables.Types._CollectionType;
			final ExecutorOperation O_OclAny_oclAsType = OCLstdlibTables.Operations._OclAny__oclAsType;
			final ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final Value T_ClassClassifier_pivot__CollectionType_ = valueFactory.createTypeValue(PivotTables.Types._CollectionType);
			final ExecutorType T_pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final ExecutorProperty P_LoopExp_body = PivotTables.Properties._LoopExp__body;
			final LibraryProperty IP_LoopExp_body = P_LoopExp_body.getImplementation();
			
			Value leftA_symbol_122;
			try {
				
				Value A_symbol_123 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_124 = valueFactory.typeOf(A_symbol_123, S_collect);
				LibraryBinaryOperation dynamic_A_symbol_124 = (LibraryBinaryOperation)static_A_symbol_124.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_124 = dynamic_A_symbol_124.evaluate(evaluator, T_Boolean, A_symbol_123, S_collect);
				leftA_symbol_122 = A_symbol_124;
			} catch (InvalidValueException e) {
				leftA_symbol_122 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_124 = leftA_symbol_122;
			Value rightA_symbol_122;
			try {
				
				Value A_symbol_125 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_126 = valueFactory.typeOf(A_symbol_125);
				LibraryBinaryOperation dynamic_A_symbol_126 = (LibraryBinaryOperation)static_A_symbol_126.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_126 = dynamic_A_symbol_126.evaluate(evaluator, T_pivot__CollectionType, A_symbol_125, T_ClassClassifier_pivot__CollectionType_);
				Value A_symbol_127 = IP_CollectionType_elementType.evaluate(evaluator, T_Type, A_symbol_126, P_CollectionType_elementType);
				
				
				Value A_symbol_128 = IP_LoopExp_body.evaluate(evaluator, T_pivot__OCLExpression, self, P_LoopExp_body);
				
				Value A_symbol_129 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_128, P_TypedElement_type);
				
				DomainType static_A_symbol_130 = valueFactory.typeOf(A_symbol_129);
				LibraryBinaryOperation dynamic_A_symbol_130 = (LibraryBinaryOperation)static_A_symbol_130.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_130 = dynamic_A_symbol_130.evaluate(evaluator, T_pivot__CollectionType, A_symbol_129, T_ClassClassifier_pivot__CollectionType_);
				Value A_symbol_131 = IP_CollectionType_elementType.evaluate(evaluator, T_Type, A_symbol_130, P_CollectionType_elementType);
				
				DomainType static_A_symbol_132 = valueFactory.typeOf(A_symbol_127, A_symbol_131);
				LibraryBinaryOperation dynamic_A_symbol_132 = (LibraryBinaryOperation)static_A_symbol_132.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_132 = dynamic_A_symbol_132.evaluate(evaluator, T_Boolean, A_symbol_127, A_symbol_131);
				rightA_symbol_122 = A_symbol_132;
			} catch (InvalidValueException e) {
				rightA_symbol_122 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_132 = rightA_symbol_122;
			DomainType static_A_symbol_122 = valueFactory.typeOf(A_symbol_124);
			LibraryBinaryOperation dynamic_A_symbol_122 = (LibraryBinaryOperation)static_A_symbol_122.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_122 = dynamic_A_symbol_122.evaluate(evaluator, T_Boolean, A_symbol_124, A_symbol_132);
			return A_symbol_122;
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
			final ExecutorType T_pivot__Variable = PivotTables.Types._Variable;
			final DomainCollectionType T_OrderedSet_pivot__Variable_ = standardLibrary.getOrderedSetType(T_pivot__Variable);
			final ExecutorProperty P_LoopExp_iterator = PivotTables.Properties._LoopExp__iterator;
			final LibraryProperty IP_LoopExp_iterator = P_LoopExp_iterator.getImplementation();
			final IntegerValue I_1 = valueFactory.integerValueOf(1);
			
			Value leftA_symbol_133;
			try {
				
				Value A_symbol_134 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_135 = valueFactory.typeOf(A_symbol_134, S_collect);
				LibraryBinaryOperation dynamic_A_symbol_135 = (LibraryBinaryOperation)static_A_symbol_135.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_135 = dynamic_A_symbol_135.evaluate(evaluator, T_Boolean, A_symbol_134, S_collect);
				leftA_symbol_133 = A_symbol_135;
			} catch (InvalidValueException e) {
				leftA_symbol_133 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_135 = leftA_symbol_133;
			Value rightA_symbol_133;
			try {
				
				Value A_symbol_136 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_137 = valueFactory.typeOf(A_symbol_136);
				LibraryUnaryOperation dynamic_A_symbol_137 = (LibraryUnaryOperation)static_A_symbol_137.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_137 = dynamic_A_symbol_137.evaluate(evaluator, T_Integer, A_symbol_136);
				DomainType static_A_symbol_138 = valueFactory.typeOf(A_symbol_137, I_1);
				LibraryBinaryOperation dynamic_A_symbol_138 = (LibraryBinaryOperation)static_A_symbol_138.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_138 = dynamic_A_symbol_138.evaluate(evaluator, T_Boolean, A_symbol_137, I_1);
				rightA_symbol_133 = A_symbol_138;
			} catch (InvalidValueException e) {
				rightA_symbol_133 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_138 = rightA_symbol_133;
			DomainType static_A_symbol_133 = valueFactory.typeOf(A_symbol_135);
			LibraryBinaryOperation dynamic_A_symbol_133 = (LibraryBinaryOperation)static_A_symbol_133.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_133 = dynamic_A_symbol_133.evaluate(evaluator, T_Boolean, A_symbol_135, A_symbol_138);
			return A_symbol_133;
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
			final ExecutorType T_pivot__Variable = PivotTables.Types._Variable;
			final DomainCollectionType T_OrderedSet_pivot__Variable_ = standardLibrary.getOrderedSetType(T_pivot__Variable);
			final ExecutorProperty P_LoopExp_iterator = PivotTables.Properties._LoopExp__iterator;
			final LibraryProperty IP_LoopExp_iterator = P_LoopExp_iterator.getImplementation();
			final IntegerValue I_1 = valueFactory.integerValueOf(1);
			
			Value leftA_symbol_139;
			try {
				
				Value A_symbol_140 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_141 = valueFactory.typeOf(A_symbol_140, S_collectN___);
				LibraryBinaryOperation dynamic_A_symbol_141 = (LibraryBinaryOperation)static_A_symbol_141.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_141 = dynamic_A_symbol_141.evaluate(evaluator, T_Boolean, A_symbol_140, S_collectN___);
				leftA_symbol_139 = A_symbol_141;
			} catch (InvalidValueException e) {
				leftA_symbol_139 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_141 = leftA_symbol_139;
			Value rightA_symbol_139;
			try {
				
				Value A_symbol_142 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_143 = valueFactory.typeOf(A_symbol_142);
				LibraryUnaryOperation dynamic_A_symbol_143 = (LibraryUnaryOperation)static_A_symbol_143.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_143 = dynamic_A_symbol_143.evaluate(evaluator, T_Integer, A_symbol_142);
				DomainType static_A_symbol_144 = valueFactory.typeOf(A_symbol_143, I_1);
				LibraryBinaryOperation dynamic_A_symbol_144 = (LibraryBinaryOperation)static_A_symbol_144.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_144 = dynamic_A_symbol_144.evaluate(evaluator, T_Boolean, A_symbol_143, I_1);
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
			final ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final Value T_ClassClassifier_pivot__BagType_ = valueFactory.createTypeValue(PivotTables.Types._BagType);
			
			Value leftA_symbol_145;
			try {
				
				Value A_symbol_146 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_147 = valueFactory.typeOf(A_symbol_146, S_collectN___);
				LibraryBinaryOperation dynamic_A_symbol_147 = (LibraryBinaryOperation)static_A_symbol_147.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_147 = dynamic_A_symbol_147.evaluate(evaluator, T_Boolean, A_symbol_146, S_collectN___);
				leftA_symbol_145 = A_symbol_147;
			} catch (InvalidValueException e) {
				leftA_symbol_145 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_147 = leftA_symbol_145;
			Value rightA_symbol_145;
			try {
				
				Value A_symbol_148 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_149 = valueFactory.typeOf(A_symbol_148);
				LibraryBinaryOperation dynamic_A_symbol_149 = (LibraryBinaryOperation)static_A_symbol_149.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
				Value A_symbol_149 = dynamic_A_symbol_149.evaluate(evaluator, T_Boolean, A_symbol_148, T_ClassClassifier_pivot__BagType_);
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
			final ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final ExecutorType T_pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final ExecutorProperty P_LoopExp_body = PivotTables.Properties._LoopExp__body;
			final LibraryProperty IP_LoopExp_body = P_LoopExp_body.getImplementation();
			
			Value leftA_symbol_150;
			try {
				
				Value A_symbol_151 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_152 = valueFactory.typeOf(A_symbol_151, S_collectN___);
				LibraryBinaryOperation dynamic_A_symbol_152 = (LibraryBinaryOperation)static_A_symbol_152.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_152 = dynamic_A_symbol_152.evaluate(evaluator, T_Boolean, A_symbol_151, S_collectN___);
				leftA_symbol_150 = A_symbol_152;
			} catch (InvalidValueException e) {
				leftA_symbol_150 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_152 = leftA_symbol_150;
			Value rightA_symbol_150;
			try {
				
				Value A_symbol_153 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				
				Value A_symbol_154 = IP_LoopExp_body.evaluate(evaluator, T_pivot__OCLExpression, self, P_LoopExp_body);
				
				Value A_symbol_155 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_154, P_TypedElement_type);
				
				DomainType static_A_symbol_156 = valueFactory.typeOf(A_symbol_153, A_symbol_155);
				LibraryBinaryOperation dynamic_A_symbol_156 = (LibraryBinaryOperation)static_A_symbol_156.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_156 = dynamic_A_symbol_156.evaluate(evaluator, T_Boolean, A_symbol_153, A_symbol_155);
				rightA_symbol_150 = A_symbol_156;
			} catch (InvalidValueException e) {
				rightA_symbol_150 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_156 = rightA_symbol_150;
			DomainType static_A_symbol_150 = valueFactory.typeOf(A_symbol_152);
			LibraryBinaryOperation dynamic_A_symbol_150 = (LibraryBinaryOperation)static_A_symbol_150.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_150 = dynamic_A_symbol_150.evaluate(evaluator, T_Boolean, A_symbol_152, A_symbol_156);
			return A_symbol_150;
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
			final ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final ExecutorType T_pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final ExecutorProperty P_CallExp_source = PivotTables.Properties._CallExp__source;
			final LibraryProperty IP_CallExp_source = P_CallExp_source.getImplementation();
			final Value T_ClassClassifier_pivot__SequenceType_ = valueFactory.createTypeValue(PivotTables.Types._SequenceType);
			final Value T_ClassClassifier_pivot__OrderedSetType_ = valueFactory.createTypeValue(PivotTables.Types._OrderedSetType);
			final Value T_ClassClassifier_pivot__BagType_ = valueFactory.createTypeValue(PivotTables.Types._BagType);
			
			Value leftA_symbol_157;
			try {
				
				Value A_symbol_158 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_159 = valueFactory.typeOf(A_symbol_158, S_collect);
				LibraryBinaryOperation dynamic_A_symbol_159 = (LibraryBinaryOperation)static_A_symbol_159.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_159 = dynamic_A_symbol_159.evaluate(evaluator, T_Boolean, A_symbol_158, S_collect);
				leftA_symbol_157 = A_symbol_159;
			} catch (InvalidValueException e) {
				leftA_symbol_157 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_159 = leftA_symbol_157;
			Value rightA_symbol_157;
			try {
					Value leftA_symbol_160;
					try {
						
						Value A_symbol_161 = IP_CallExp_source.evaluate(evaluator, T_pivot__OCLExpression, self, P_CallExp_source);
						
						Value A_symbol_162 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_161, P_TypedElement_type);
						
						DomainType static_A_symbol_163 = valueFactory.typeOf(A_symbol_162);
						LibraryBinaryOperation dynamic_A_symbol_163 = (LibraryBinaryOperation)static_A_symbol_163.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Value A_symbol_163 = dynamic_A_symbol_163.evaluate(evaluator, T_Boolean, A_symbol_162, T_ClassClassifier_pivot__SequenceType_);
						leftA_symbol_160 = A_symbol_163;
					} catch (InvalidValueException e) {
						leftA_symbol_160 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_163 = leftA_symbol_160;
					Value rightA_symbol_160;
					try {
						
						Value A_symbol_164 = IP_CallExp_source.evaluate(evaluator, T_pivot__OCLExpression, self, P_CallExp_source);
						
						Value A_symbol_165 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_164, P_TypedElement_type);
						
						DomainType static_A_symbol_166 = valueFactory.typeOf(A_symbol_165);
						LibraryBinaryOperation dynamic_A_symbol_166 = (LibraryBinaryOperation)static_A_symbol_166.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Value A_symbol_166 = dynamic_A_symbol_166.evaluate(evaluator, T_Boolean, A_symbol_165, T_ClassClassifier_pivot__OrderedSetType_);
						rightA_symbol_160 = A_symbol_166;
					} catch (InvalidValueException e) {
						rightA_symbol_160 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_166 = rightA_symbol_160;
					DomainType static_A_symbol_160 = valueFactory.typeOf(A_symbol_163);
					LibraryBinaryOperation dynamic_A_symbol_160 = (LibraryBinaryOperation)static_A_symbol_160.lookupImplementation(standardLibrary, O_Boolean_or);
					Value A_symbol_160 = dynamic_A_symbol_160.evaluate(evaluator, T_Boolean, A_symbol_163, A_symbol_166);
				Value A_symbol_167;
				if (A_symbol_160.isTrue()) {
					
					Value A_symbol_168 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
					
					DomainType static_A_symbol_169 = valueFactory.typeOf(A_symbol_168);
					LibraryBinaryOperation dynamic_A_symbol_169 = (LibraryBinaryOperation)static_A_symbol_169.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Value A_symbol_169 = dynamic_A_symbol_169.evaluate(evaluator, T_Boolean, A_symbol_168, T_ClassClassifier_pivot__SequenceType_);
					A_symbol_167 = A_symbol_169;
				}
				else if (A_symbol_160.isFalse()) {
					
					Value A_symbol_170 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
					
					DomainType static_A_symbol_171 = valueFactory.typeOf(A_symbol_170);
					LibraryBinaryOperation dynamic_A_symbol_171 = (LibraryBinaryOperation)static_A_symbol_171.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Value A_symbol_171 = dynamic_A_symbol_171.evaluate(evaluator, T_Boolean, A_symbol_170, T_ClassClassifier_pivot__BagType_);
					A_symbol_167 = A_symbol_171;
				}
				else if (A_symbol_160.isNull()) {
					A_symbol_167 = valueFactory.throwInvalidValueException("null if condition");
				}
				else {
					A_symbol_167 = valueFactory.throwInvalidValueException("invalid if condition");
				}
				rightA_symbol_157 = A_symbol_167;
			} catch (InvalidValueException e) {
				rightA_symbol_157 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_167 = rightA_symbol_157;
			DomainType static_A_symbol_157 = valueFactory.typeOf(A_symbol_159);
			LibraryBinaryOperation dynamic_A_symbol_157 = (LibraryBinaryOperation)static_A_symbol_157.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_157 = dynamic_A_symbol_157.evaluate(evaluator, T_Boolean, A_symbol_159, A_symbol_167);
			return A_symbol_157;
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
			final ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final ExecutorType T_pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final ExecutorProperty P_LoopExp_body = PivotTables.Properties._LoopExp__body;
			final LibraryProperty IP_LoopExp_body = P_LoopExp_body.getImplementation();
			final Value T_ClassClassifier_Boolean_ = valueFactory.createTypeValue(OCLstdlibTables.Types._Boolean);
			
			Value leftA_symbol_172;
			try {
				
				Value A_symbol_173 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_174 = valueFactory.typeOf(A_symbol_173, S_exists);
				LibraryBinaryOperation dynamic_A_symbol_174 = (LibraryBinaryOperation)static_A_symbol_174.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_174 = dynamic_A_symbol_174.evaluate(evaluator, T_Boolean, A_symbol_173, S_exists);
				leftA_symbol_172 = A_symbol_174;
			} catch (InvalidValueException e) {
				leftA_symbol_172 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_174 = leftA_symbol_172;
			Value rightA_symbol_172;
			try {
				
				Value A_symbol_175 = IP_LoopExp_body.evaluate(evaluator, T_pivot__OCLExpression, self, P_LoopExp_body);
				
				Value A_symbol_176 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_175, P_TypedElement_type);
				
				DomainType static_A_symbol_177 = valueFactory.typeOf(A_symbol_176, T_ClassClassifier_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_177 = (LibraryBinaryOperation)static_A_symbol_177.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_177 = dynamic_A_symbol_177.evaluate(evaluator, T_Boolean, A_symbol_176, T_ClassClassifier_Boolean_);
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
			final ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final Value T_ClassClassifier_Boolean_ = valueFactory.createTypeValue(OCLstdlibTables.Types._Boolean);
			
			Value leftA_symbol_178;
			try {
				
				Value A_symbol_179 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_180 = valueFactory.typeOf(A_symbol_179, S_exists);
				LibraryBinaryOperation dynamic_A_symbol_180 = (LibraryBinaryOperation)static_A_symbol_180.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_180 = dynamic_A_symbol_180.evaluate(evaluator, T_Boolean, A_symbol_179, S_exists);
				leftA_symbol_178 = A_symbol_180;
			} catch (InvalidValueException e) {
				leftA_symbol_178 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_180 = leftA_symbol_178;
			Value rightA_symbol_178;
			try {
				
				Value A_symbol_181 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_182 = valueFactory.typeOf(A_symbol_181, T_ClassClassifier_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_182 = (LibraryBinaryOperation)static_A_symbol_182.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_182 = dynamic_A_symbol_182.evaluate(evaluator, T_Boolean, A_symbol_181, T_ClassClassifier_Boolean_);
				rightA_symbol_178 = A_symbol_182;
			} catch (InvalidValueException e) {
				rightA_symbol_178 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_182 = rightA_symbol_178;
			DomainType static_A_symbol_178 = valueFactory.typeOf(A_symbol_180);
			LibraryBinaryOperation dynamic_A_symbol_178 = (LibraryBinaryOperation)static_A_symbol_178.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_178 = dynamic_A_symbol_178.evaluate(evaluator, T_Boolean, A_symbol_180, A_symbol_182);
			return A_symbol_178;
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
			final ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final ExecutorType T_pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final ExecutorProperty P_LoopExp_body = PivotTables.Properties._LoopExp__body;
			final LibraryProperty IP_LoopExp_body = P_LoopExp_body.getImplementation();
			final Value T_ClassClassifier_Boolean_ = valueFactory.createTypeValue(OCLstdlibTables.Types._Boolean);
			
			Value leftA_symbol_183;
			try {
				
				Value A_symbol_184 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_185 = valueFactory.typeOf(A_symbol_184, S_forAll);
				LibraryBinaryOperation dynamic_A_symbol_185 = (LibraryBinaryOperation)static_A_symbol_185.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_185 = dynamic_A_symbol_185.evaluate(evaluator, T_Boolean, A_symbol_184, S_forAll);
				leftA_symbol_183 = A_symbol_185;
			} catch (InvalidValueException e) {
				leftA_symbol_183 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_185 = leftA_symbol_183;
			Value rightA_symbol_183;
			try {
				
				Value A_symbol_186 = IP_LoopExp_body.evaluate(evaluator, T_pivot__OCLExpression, self, P_LoopExp_body);
				
				Value A_symbol_187 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_186, P_TypedElement_type);
				
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
			final ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final Value T_ClassClassifier_Boolean_ = valueFactory.createTypeValue(OCLstdlibTables.Types._Boolean);
			
			Value leftA_symbol_189;
			try {
				
				Value A_symbol_190 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_191 = valueFactory.typeOf(A_symbol_190, S_forAll);
				LibraryBinaryOperation dynamic_A_symbol_191 = (LibraryBinaryOperation)static_A_symbol_191.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_191 = dynamic_A_symbol_191.evaluate(evaluator, T_Boolean, A_symbol_190, S_forAll);
				leftA_symbol_189 = A_symbol_191;
			} catch (InvalidValueException e) {
				leftA_symbol_189 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_191 = leftA_symbol_189;
			Value rightA_symbol_189;
			try {
				
				Value A_symbol_192 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_193 = valueFactory.typeOf(A_symbol_192, T_ClassClassifier_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_193 = (LibraryBinaryOperation)static_A_symbol_193.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_193 = dynamic_A_symbol_193.evaluate(evaluator, T_Boolean, A_symbol_192, T_ClassClassifier_Boolean_);
				rightA_symbol_189 = A_symbol_193;
			} catch (InvalidValueException e) {
				rightA_symbol_189 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_193 = rightA_symbol_189;
			DomainType static_A_symbol_189 = valueFactory.typeOf(A_symbol_191);
			LibraryBinaryOperation dynamic_A_symbol_189 = (LibraryBinaryOperation)static_A_symbol_189.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_189 = dynamic_A_symbol_189.evaluate(evaluator, T_Boolean, A_symbol_191, A_symbol_193);
			return A_symbol_189;
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
			final ExecutorType T_pivot__Variable = PivotTables.Types._Variable;
			final DomainCollectionType T_OrderedSet_pivot__Variable_ = standardLibrary.getOrderedSetType(T_pivot__Variable);
			final ExecutorProperty P_LoopExp_iterator = PivotTables.Properties._LoopExp__iterator;
			final LibraryProperty IP_LoopExp_iterator = P_LoopExp_iterator.getImplementation();
			final IntegerValue I_1 = valueFactory.integerValueOf(1);
			
			Value leftA_symbol_194;
			try {
				
				Value A_symbol_195 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_196 = valueFactory.typeOf(A_symbol_195, S_isUnique);
				LibraryBinaryOperation dynamic_A_symbol_196 = (LibraryBinaryOperation)static_A_symbol_196.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_196 = dynamic_A_symbol_196.evaluate(evaluator, T_Boolean, A_symbol_195, S_isUnique);
				leftA_symbol_194 = A_symbol_196;
			} catch (InvalidValueException e) {
				leftA_symbol_194 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_196 = leftA_symbol_194;
			Value rightA_symbol_194;
			try {
				
				Value A_symbol_197 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_198 = valueFactory.typeOf(A_symbol_197);
				LibraryUnaryOperation dynamic_A_symbol_198 = (LibraryUnaryOperation)static_A_symbol_198.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_198 = dynamic_A_symbol_198.evaluate(evaluator, T_Integer, A_symbol_197);
				DomainType static_A_symbol_199 = valueFactory.typeOf(A_symbol_198, I_1);
				LibraryBinaryOperation dynamic_A_symbol_199 = (LibraryBinaryOperation)static_A_symbol_199.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_199 = dynamic_A_symbol_199.evaluate(evaluator, T_Boolean, A_symbol_198, I_1);
				rightA_symbol_194 = A_symbol_199;
			} catch (InvalidValueException e) {
				rightA_symbol_194 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_199 = rightA_symbol_194;
			DomainType static_A_symbol_194 = valueFactory.typeOf(A_symbol_196);
			LibraryBinaryOperation dynamic_A_symbol_194 = (LibraryBinaryOperation)static_A_symbol_194.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_194 = dynamic_A_symbol_194.evaluate(evaluator, T_Boolean, A_symbol_196, A_symbol_199);
			return A_symbol_194;
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
			final ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final Value T_ClassClassifier_Boolean_ = valueFactory.createTypeValue(OCLstdlibTables.Types._Boolean);
			
			Value leftA_symbol_200;
			try {
				
				Value A_symbol_201 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_202 = valueFactory.typeOf(A_symbol_201, S_isUnique);
				LibraryBinaryOperation dynamic_A_symbol_202 = (LibraryBinaryOperation)static_A_symbol_202.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_202 = dynamic_A_symbol_202.evaluate(evaluator, T_Boolean, A_symbol_201, S_isUnique);
				leftA_symbol_200 = A_symbol_202;
			} catch (InvalidValueException e) {
				leftA_symbol_200 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_202 = leftA_symbol_200;
			Value rightA_symbol_200;
			try {
				
				Value A_symbol_203 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_204 = valueFactory.typeOf(A_symbol_203, T_ClassClassifier_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_204 = (LibraryBinaryOperation)static_A_symbol_204.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_204 = dynamic_A_symbol_204.evaluate(evaluator, T_Boolean, A_symbol_203, T_ClassClassifier_Boolean_);
				rightA_symbol_200 = A_symbol_204;
			} catch (InvalidValueException e) {
				rightA_symbol_200 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_204 = rightA_symbol_200;
			DomainType static_A_symbol_200 = valueFactory.typeOf(A_symbol_202);
			LibraryBinaryOperation dynamic_A_symbol_200 = (LibraryBinaryOperation)static_A_symbol_200.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_200 = dynamic_A_symbol_200.evaluate(evaluator, T_Boolean, A_symbol_202, A_symbol_204);
			return A_symbol_200;
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
			final ExecutorType T_pivot__Variable = PivotTables.Types._Variable;
			final DomainCollectionType T_OrderedSet_pivot__Variable_ = standardLibrary.getOrderedSetType(T_pivot__Variable);
			final ExecutorProperty P_LoopExp_iterator = PivotTables.Properties._LoopExp__iterator;
			final LibraryProperty IP_LoopExp_iterator = P_LoopExp_iterator.getImplementation();
			final ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
			final ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final ExecutorProperty P_CollectionType_elementType = PivotTables.Properties._CollectionType__elementType;
			final LibraryProperty IP_CollectionType_elementType = P_CollectionType_elementType.getImplementation();
			final ExecutorType T_pivot__CollectionType = PivotTables.Types._CollectionType;
			final ExecutorOperation O_OclAny_oclAsType = OCLstdlibTables.Operations._OclAny__oclAsType;
			final ExecutorType T_pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final ExecutorProperty P_CallExp_source = PivotTables.Properties._CallExp__source;
			final LibraryProperty IP_CallExp_source = P_CallExp_source.getImplementation();
			final Value T_ClassClassifier_pivot__CollectionType_ = valueFactory.createTypeValue(PivotTables.Types._CollectionType);
			
			
			Value A_symbol_205 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_pivot__Variable_, self, P_LoopExp_iterator);
			
			
			/** 
			 * Implementation of the iterator body.
			 */
			AbstractBinaryOperation body_A_symbol_206 = new AbstractBinaryOperation()
			{
			/*
			type = source.type.oclAsType(CollectionType).elementType
			*/
				public Value evaluate(DomainEvaluator evaluator, DomainType returnType, Value sourceValue, Value iterator1) throws InvalidValueException {
					final Value V_1_ = iterator1;	// iterator: 1_
					
					Value A_symbol_207 = IP_TypedElement_type.evaluate(evaluator, T_Type, V_1_, P_TypedElement_type);
					
					
					Value A_symbol_208 = IP_CallExp_source.evaluate(evaluator, T_pivot__OCLExpression, self, P_CallExp_source);
					
					Value A_symbol_209 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_208, P_TypedElement_type);
					
					DomainType static_A_symbol_210 = valueFactory.typeOf(A_symbol_209);
					LibraryBinaryOperation dynamic_A_symbol_210 = (LibraryBinaryOperation)static_A_symbol_210.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
					Value A_symbol_210 = dynamic_A_symbol_210.evaluate(evaluator, T_pivot__CollectionType, A_symbol_209, T_ClassClassifier_pivot__CollectionType_);
					Value A_symbol_211 = IP_CollectionType_elementType.evaluate(evaluator, T_Type, A_symbol_210, P_CollectionType_elementType);
					
					DomainType static_A_symbol_212 = valueFactory.typeOf(A_symbol_207, A_symbol_211);
					LibraryBinaryOperation dynamic_A_symbol_212 = (LibraryBinaryOperation)static_A_symbol_212.lookupImplementation(standardLibrary, O_OclAny__eq_);
					Value A_symbol_212 = dynamic_A_symbol_212.evaluate(evaluator, T_Boolean, A_symbol_207, A_symbol_211);
					return A_symbol_212;
				}
			};
			DomainType static_A_symbol_206 = A_symbol_205.getType();
			LibraryIteration dynamic_A_symbol_206 = (LibraryIteration)static_A_symbol_206.lookupImplementation(standardLibrary, O_Collection_forAll);
			Value acc_A_symbol_206 = dynamic_A_symbol_206.createAccumulatorValue(evaluator, T_Boolean, T_Boolean);
			ExecutorSingleIterationManager manager_A_symbol_206 = new ExecutorSingleIterationManager(evaluator, T_Boolean, body_A_symbol_206, (CollectionValue)A_symbol_205, acc_A_symbol_206);
			Value A_symbol_206 = dynamic_A_symbol_206.evaluateIteration(manager_A_symbol_206);
			return A_symbol_206;
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
			final ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final ExecutorType T_pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final ExecutorProperty P_LoopExp_body = PivotTables.Properties._LoopExp__body;
			final LibraryProperty IP_LoopExp_body = P_LoopExp_body.getImplementation();
			final Value T_ClassClassifier_Boolean_ = valueFactory.createTypeValue(OCLstdlibTables.Types._Boolean);
			
			Value leftA_symbol_213;
			try {
				
				Value A_symbol_214 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_215 = valueFactory.typeOf(A_symbol_214, S_one);
				LibraryBinaryOperation dynamic_A_symbol_215 = (LibraryBinaryOperation)static_A_symbol_215.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_215 = dynamic_A_symbol_215.evaluate(evaluator, T_Boolean, A_symbol_214, S_one);
				leftA_symbol_213 = A_symbol_215;
			} catch (InvalidValueException e) {
				leftA_symbol_213 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_215 = leftA_symbol_213;
			Value rightA_symbol_213;
			try {
				
				Value A_symbol_216 = IP_LoopExp_body.evaluate(evaluator, T_pivot__OCLExpression, self, P_LoopExp_body);
				
				Value A_symbol_217 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_216, P_TypedElement_type);
				
				DomainType static_A_symbol_218 = valueFactory.typeOf(A_symbol_217, T_ClassClassifier_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_218 = (LibraryBinaryOperation)static_A_symbol_218.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_218 = dynamic_A_symbol_218.evaluate(evaluator, T_Boolean, A_symbol_217, T_ClassClassifier_Boolean_);
				rightA_symbol_213 = A_symbol_218;
			} catch (InvalidValueException e) {
				rightA_symbol_213 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_218 = rightA_symbol_213;
			DomainType static_A_symbol_213 = valueFactory.typeOf(A_symbol_215);
			LibraryBinaryOperation dynamic_A_symbol_213 = (LibraryBinaryOperation)static_A_symbol_213.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_213 = dynamic_A_symbol_213.evaluate(evaluator, T_Boolean, A_symbol_215, A_symbol_218);
			return A_symbol_213;
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
			final ExecutorType T_pivot__Variable = PivotTables.Types._Variable;
			final DomainCollectionType T_OrderedSet_pivot__Variable_ = standardLibrary.getOrderedSetType(T_pivot__Variable);
			final ExecutorProperty P_LoopExp_iterator = PivotTables.Properties._LoopExp__iterator;
			final LibraryProperty IP_LoopExp_iterator = P_LoopExp_iterator.getImplementation();
			final IntegerValue I_1 = valueFactory.integerValueOf(1);
			
			Value leftA_symbol_219;
			try {
				
				Value A_symbol_220 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_221 = valueFactory.typeOf(A_symbol_220, S_one);
				LibraryBinaryOperation dynamic_A_symbol_221 = (LibraryBinaryOperation)static_A_symbol_221.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_221 = dynamic_A_symbol_221.evaluate(evaluator, T_Boolean, A_symbol_220, S_one);
				leftA_symbol_219 = A_symbol_221;
			} catch (InvalidValueException e) {
				leftA_symbol_219 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_221 = leftA_symbol_219;
			Value rightA_symbol_219;
			try {
				
				Value A_symbol_222 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_223 = valueFactory.typeOf(A_symbol_222);
				LibraryUnaryOperation dynamic_A_symbol_223 = (LibraryUnaryOperation)static_A_symbol_223.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_223 = dynamic_A_symbol_223.evaluate(evaluator, T_Integer, A_symbol_222);
				DomainType static_A_symbol_224 = valueFactory.typeOf(A_symbol_223, I_1);
				LibraryBinaryOperation dynamic_A_symbol_224 = (LibraryBinaryOperation)static_A_symbol_224.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_224 = dynamic_A_symbol_224.evaluate(evaluator, T_Boolean, A_symbol_223, I_1);
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
			final ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final Value T_ClassClassifier_Boolean_ = valueFactory.createTypeValue(OCLstdlibTables.Types._Boolean);
			
			Value leftA_symbol_225;
			try {
				
				Value A_symbol_226 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_227 = valueFactory.typeOf(A_symbol_226, S_one);
				LibraryBinaryOperation dynamic_A_symbol_227 = (LibraryBinaryOperation)static_A_symbol_227.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_227 = dynamic_A_symbol_227.evaluate(evaluator, T_Boolean, A_symbol_226, S_one);
				leftA_symbol_225 = A_symbol_227;
			} catch (InvalidValueException e) {
				leftA_symbol_225 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_227 = leftA_symbol_225;
			Value rightA_symbol_225;
			try {
				
				Value A_symbol_228 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
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
			final ExecutorType T_pivot__Variable = PivotTables.Types._Variable;
			final DomainCollectionType T_OrderedSet_pivot__Variable_ = standardLibrary.getOrderedSetType(T_pivot__Variable);
			final ExecutorProperty P_LoopExp_iterator = PivotTables.Properties._LoopExp__iterator;
			final LibraryProperty IP_LoopExp_iterator = P_LoopExp_iterator.getImplementation();
			final IntegerValue I_1 = valueFactory.integerValueOf(1);
			
			Value leftA_symbol_230;
			try {
				Value leftA_symbol_231;
				try {
					
					Value A_symbol_232 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
					
					DomainType static_A_symbol_233 = valueFactory.typeOf(A_symbol_232, S_reject);
					LibraryBinaryOperation dynamic_A_symbol_233 = (LibraryBinaryOperation)static_A_symbol_233.lookupImplementation(standardLibrary, O_String__eq_);
					Value A_symbol_233 = dynamic_A_symbol_233.evaluate(evaluator, T_Boolean, A_symbol_232, S_reject);
					leftA_symbol_231 = A_symbol_233;
				} catch (InvalidValueException e) {
					leftA_symbol_231 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_233 = leftA_symbol_231;
				Value rightA_symbol_231;
				try {
					
					Value A_symbol_234 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
					
					DomainType static_A_symbol_235 = valueFactory.typeOf(A_symbol_234, S_select);
					LibraryBinaryOperation dynamic_A_symbol_235 = (LibraryBinaryOperation)static_A_symbol_235.lookupImplementation(standardLibrary, O_String__eq_);
					Value A_symbol_235 = dynamic_A_symbol_235.evaluate(evaluator, T_Boolean, A_symbol_234, S_select);
					rightA_symbol_231 = A_symbol_235;
				} catch (InvalidValueException e) {
					rightA_symbol_231 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_235 = rightA_symbol_231;
				DomainType static_A_symbol_231 = valueFactory.typeOf(A_symbol_233);
				LibraryBinaryOperation dynamic_A_symbol_231 = (LibraryBinaryOperation)static_A_symbol_231.lookupImplementation(standardLibrary, O_Boolean_or);
				Value A_symbol_231 = dynamic_A_symbol_231.evaluate(evaluator, T_Boolean, A_symbol_233, A_symbol_235);
				leftA_symbol_230 = A_symbol_231;
			} catch (InvalidValueException e) {
				leftA_symbol_230 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_231 = leftA_symbol_230;
			Value rightA_symbol_230;
			try {
				
				Value A_symbol_236 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_237 = valueFactory.typeOf(A_symbol_236);
				LibraryUnaryOperation dynamic_A_symbol_237 = (LibraryUnaryOperation)static_A_symbol_237.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_237 = dynamic_A_symbol_237.evaluate(evaluator, T_Integer, A_symbol_236);
				DomainType static_A_symbol_238 = valueFactory.typeOf(A_symbol_237, I_1);
				LibraryBinaryOperation dynamic_A_symbol_238 = (LibraryBinaryOperation)static_A_symbol_238.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_238 = dynamic_A_symbol_238.evaluate(evaluator, T_Boolean, A_symbol_237, I_1);
				rightA_symbol_230 = A_symbol_238;
			} catch (InvalidValueException e) {
				rightA_symbol_230 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_238 = rightA_symbol_230;
			DomainType static_A_symbol_230 = valueFactory.typeOf(A_symbol_231);
			LibraryBinaryOperation dynamic_A_symbol_230 = (LibraryBinaryOperation)static_A_symbol_230.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_230 = dynamic_A_symbol_230.evaluate(evaluator, T_Boolean, A_symbol_231, A_symbol_238);
			return A_symbol_230;
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
			final ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final Value T_ClassClassifier_Boolean_ = valueFactory.createTypeValue(OCLstdlibTables.Types._Boolean);
			
			Value leftA_symbol_239;
			try {
				Value leftA_symbol_240;
				try {
					
					Value A_symbol_241 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
					
					DomainType static_A_symbol_242 = valueFactory.typeOf(A_symbol_241, S_reject);
					LibraryBinaryOperation dynamic_A_symbol_242 = (LibraryBinaryOperation)static_A_symbol_242.lookupImplementation(standardLibrary, O_String__eq_);
					Value A_symbol_242 = dynamic_A_symbol_242.evaluate(evaluator, T_Boolean, A_symbol_241, S_reject);
					leftA_symbol_240 = A_symbol_242;
				} catch (InvalidValueException e) {
					leftA_symbol_240 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_242 = leftA_symbol_240;
				Value rightA_symbol_240;
				try {
					
					Value A_symbol_243 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
					
					DomainType static_A_symbol_244 = valueFactory.typeOf(A_symbol_243, S_select);
					LibraryBinaryOperation dynamic_A_symbol_244 = (LibraryBinaryOperation)static_A_symbol_244.lookupImplementation(standardLibrary, O_String__eq_);
					Value A_symbol_244 = dynamic_A_symbol_244.evaluate(evaluator, T_Boolean, A_symbol_243, S_select);
					rightA_symbol_240 = A_symbol_244;
				} catch (InvalidValueException e) {
					rightA_symbol_240 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_244 = rightA_symbol_240;
				DomainType static_A_symbol_240 = valueFactory.typeOf(A_symbol_242);
				LibraryBinaryOperation dynamic_A_symbol_240 = (LibraryBinaryOperation)static_A_symbol_240.lookupImplementation(standardLibrary, O_Boolean_or);
				Value A_symbol_240 = dynamic_A_symbol_240.evaluate(evaluator, T_Boolean, A_symbol_242, A_symbol_244);
				leftA_symbol_239 = A_symbol_240;
			} catch (InvalidValueException e) {
				leftA_symbol_239 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_240 = leftA_symbol_239;
			Value rightA_symbol_239;
			try {
				
				Value A_symbol_245 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_246 = valueFactory.typeOf(A_symbol_245, T_ClassClassifier_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol_246 = (LibraryBinaryOperation)static_A_symbol_246.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_246 = dynamic_A_symbol_246.evaluate(evaluator, T_Boolean, A_symbol_245, T_ClassClassifier_Boolean_);
				rightA_symbol_239 = A_symbol_246;
			} catch (InvalidValueException e) {
				rightA_symbol_239 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_246 = rightA_symbol_239;
			DomainType static_A_symbol_239 = valueFactory.typeOf(A_symbol_240);
			LibraryBinaryOperation dynamic_A_symbol_239 = (LibraryBinaryOperation)static_A_symbol_239.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_239 = dynamic_A_symbol_239.evaluate(evaluator, T_Boolean, A_symbol_240, A_symbol_246);
			return A_symbol_239;
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
			final ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final ExecutorType T_pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final ExecutorProperty P_CallExp_source = PivotTables.Properties._CallExp__source;
			final LibraryProperty IP_CallExp_source = P_CallExp_source.getImplementation();
			
			Value leftA_symbol_247;
			try {
				Value leftA_symbol_248;
				try {
					
					Value A_symbol_249 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
					
					DomainType static_A_symbol_250 = valueFactory.typeOf(A_symbol_249, S_reject);
					LibraryBinaryOperation dynamic_A_symbol_250 = (LibraryBinaryOperation)static_A_symbol_250.lookupImplementation(standardLibrary, O_String__eq_);
					Value A_symbol_250 = dynamic_A_symbol_250.evaluate(evaluator, T_Boolean, A_symbol_249, S_reject);
					leftA_symbol_248 = A_symbol_250;
				} catch (InvalidValueException e) {
					leftA_symbol_248 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_250 = leftA_symbol_248;
				Value rightA_symbol_248;
				try {
					
					Value A_symbol_251 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
					
					DomainType static_A_symbol_252 = valueFactory.typeOf(A_symbol_251, S_select);
					LibraryBinaryOperation dynamic_A_symbol_252 = (LibraryBinaryOperation)static_A_symbol_252.lookupImplementation(standardLibrary, O_String__eq_);
					Value A_symbol_252 = dynamic_A_symbol_252.evaluate(evaluator, T_Boolean, A_symbol_251, S_select);
					rightA_symbol_248 = A_symbol_252;
				} catch (InvalidValueException e) {
					rightA_symbol_248 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_252 = rightA_symbol_248;
				DomainType static_A_symbol_248 = valueFactory.typeOf(A_symbol_250);
				LibraryBinaryOperation dynamic_A_symbol_248 = (LibraryBinaryOperation)static_A_symbol_248.lookupImplementation(standardLibrary, O_Boolean_or);
				Value A_symbol_248 = dynamic_A_symbol_248.evaluate(evaluator, T_Boolean, A_symbol_250, A_symbol_252);
				leftA_symbol_247 = A_symbol_248;
			} catch (InvalidValueException e) {
				leftA_symbol_247 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_248 = leftA_symbol_247;
			Value rightA_symbol_247;
			try {
				
				Value A_symbol_253 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				
				Value A_symbol_254 = IP_CallExp_source.evaluate(evaluator, T_pivot__OCLExpression, self, P_CallExp_source);
				
				Value A_symbol_255 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_254, P_TypedElement_type);
				
				DomainType static_A_symbol_256 = valueFactory.typeOf(A_symbol_253, A_symbol_255);
				LibraryBinaryOperation dynamic_A_symbol_256 = (LibraryBinaryOperation)static_A_symbol_256.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_256 = dynamic_A_symbol_256.evaluate(evaluator, T_Boolean, A_symbol_253, A_symbol_255);
				rightA_symbol_247 = A_symbol_256;
			} catch (InvalidValueException e) {
				rightA_symbol_247 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_256 = rightA_symbol_247;
			DomainType static_A_symbol_247 = valueFactory.typeOf(A_symbol_248);
			LibraryBinaryOperation dynamic_A_symbol_247 = (LibraryBinaryOperation)static_A_symbol_247.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_247 = dynamic_A_symbol_247.evaluate(evaluator, T_Boolean, A_symbol_248, A_symbol_256);
			return A_symbol_247;
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
			final ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final ExecutorProperty P_CollectionType_elementType = PivotTables.Properties._CollectionType__elementType;
			final LibraryProperty IP_CollectionType_elementType = P_CollectionType_elementType.getImplementation();
			final ExecutorType T_pivot__CollectionType = PivotTables.Types._CollectionType;
			final ExecutorOperation O_OclAny_oclAsType = OCLstdlibTables.Operations._OclAny__oclAsType;
			final ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final Value T_ClassClassifier_pivot__CollectionType_ = valueFactory.createTypeValue(PivotTables.Types._CollectionType);
			final ExecutorType T_pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final ExecutorProperty P_LoopExp_body = PivotTables.Properties._LoopExp__body;
			final LibraryProperty IP_LoopExp_body = P_LoopExp_body.getImplementation();
			
			Value leftA_symbol_257;
			try {
				
				Value A_symbol_258 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_259 = valueFactory.typeOf(A_symbol_258, S_sortedBy);
				LibraryBinaryOperation dynamic_A_symbol_259 = (LibraryBinaryOperation)static_A_symbol_259.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_259 = dynamic_A_symbol_259.evaluate(evaluator, T_Boolean, A_symbol_258, S_sortedBy);
				leftA_symbol_257 = A_symbol_259;
			} catch (InvalidValueException e) {
				leftA_symbol_257 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_259 = leftA_symbol_257;
			Value rightA_symbol_257;
			try {
				
				Value A_symbol_260 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_261 = valueFactory.typeOf(A_symbol_260);
				LibraryBinaryOperation dynamic_A_symbol_261 = (LibraryBinaryOperation)static_A_symbol_261.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_261 = dynamic_A_symbol_261.evaluate(evaluator, T_pivot__CollectionType, A_symbol_260, T_ClassClassifier_pivot__CollectionType_);
				Value A_symbol_262 = IP_CollectionType_elementType.evaluate(evaluator, T_Type, A_symbol_261, P_CollectionType_elementType);
				
				
				Value A_symbol_263 = IP_LoopExp_body.evaluate(evaluator, T_pivot__OCLExpression, self, P_LoopExp_body);
				
				Value A_symbol_264 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_263, P_TypedElement_type);
				
				DomainType static_A_symbol_265 = valueFactory.typeOf(A_symbol_264);
				LibraryBinaryOperation dynamic_A_symbol_265 = (LibraryBinaryOperation)static_A_symbol_265.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_265 = dynamic_A_symbol_265.evaluate(evaluator, T_pivot__CollectionType, A_symbol_264, T_ClassClassifier_pivot__CollectionType_);
				Value A_symbol_266 = IP_CollectionType_elementType.evaluate(evaluator, T_Type, A_symbol_265, P_CollectionType_elementType);
				
				DomainType static_A_symbol_267 = valueFactory.typeOf(A_symbol_262, A_symbol_266);
				LibraryBinaryOperation dynamic_A_symbol_267 = (LibraryBinaryOperation)static_A_symbol_267.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_267 = dynamic_A_symbol_267.evaluate(evaluator, T_Boolean, A_symbol_262, A_symbol_266);
				rightA_symbol_257 = A_symbol_267;
			} catch (InvalidValueException e) {
				rightA_symbol_257 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_267 = rightA_symbol_257;
			DomainType static_A_symbol_257 = valueFactory.typeOf(A_symbol_259);
			LibraryBinaryOperation dynamic_A_symbol_257 = (LibraryBinaryOperation)static_A_symbol_257.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_257 = dynamic_A_symbol_257.evaluate(evaluator, T_Boolean, A_symbol_259, A_symbol_267);
			return A_symbol_257;
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
			final ExecutorType T_pivot__Variable = PivotTables.Types._Variable;
			final DomainCollectionType T_OrderedSet_pivot__Variable_ = standardLibrary.getOrderedSetType(T_pivot__Variable);
			final ExecutorProperty P_LoopExp_iterator = PivotTables.Properties._LoopExp__iterator;
			final LibraryProperty IP_LoopExp_iterator = P_LoopExp_iterator.getImplementation();
			final IntegerValue I_1 = valueFactory.integerValueOf(1);
			
			Value leftA_symbol_268;
			try {
				
				Value A_symbol_269 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_270 = valueFactory.typeOf(A_symbol_269, S_sortedBy);
				LibraryBinaryOperation dynamic_A_symbol_270 = (LibraryBinaryOperation)static_A_symbol_270.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_270 = dynamic_A_symbol_270.evaluate(evaluator, T_Boolean, A_symbol_269, S_sortedBy);
				leftA_symbol_268 = A_symbol_270;
			} catch (InvalidValueException e) {
				leftA_symbol_268 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_270 = leftA_symbol_268;
			Value rightA_symbol_268;
			try {
				
				Value A_symbol_271 = IP_LoopExp_iterator.evaluate(evaluator, T_OrderedSet_pivot__Variable_, self, P_LoopExp_iterator);
				
				DomainType static_A_symbol_272 = valueFactory.typeOf(A_symbol_271);
				LibraryUnaryOperation dynamic_A_symbol_272 = (LibraryUnaryOperation)static_A_symbol_272.lookupImplementation(standardLibrary, O_Collection_size);
				Value A_symbol_272 = dynamic_A_symbol_272.evaluate(evaluator, T_Integer, A_symbol_271);
				DomainType static_A_symbol_273 = valueFactory.typeOf(A_symbol_272, I_1);
				LibraryBinaryOperation dynamic_A_symbol_273 = (LibraryBinaryOperation)static_A_symbol_273.lookupImplementation(standardLibrary, O_Real__eq_);
				Value A_symbol_273 = dynamic_A_symbol_273.evaluate(evaluator, T_Boolean, A_symbol_272, I_1);
				rightA_symbol_268 = A_symbol_273;
			} catch (InvalidValueException e) {
				rightA_symbol_268 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_273 = rightA_symbol_268;
			DomainType static_A_symbol_268 = valueFactory.typeOf(A_symbol_270);
			LibraryBinaryOperation dynamic_A_symbol_268 = (LibraryBinaryOperation)static_A_symbol_268.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_268 = dynamic_A_symbol_268.evaluate(evaluator, T_Boolean, A_symbol_270, A_symbol_273);
			return A_symbol_268;
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
			final ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final ExecutorType T_pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final ExecutorProperty P_CallExp_source = PivotTables.Properties._CallExp__source;
			final LibraryProperty IP_CallExp_source = P_CallExp_source.getImplementation();
			final Value T_ClassClassifier_pivot__SequenceType_ = valueFactory.createTypeValue(PivotTables.Types._SequenceType);
			final Value T_ClassClassifier_pivot__BagType_ = valueFactory.createTypeValue(PivotTables.Types._BagType);
			final Value T_ClassClassifier_pivot__OrderedSetType_ = valueFactory.createTypeValue(PivotTables.Types._OrderedSetType);
			
			Value leftA_symbol_274;
			try {
				
				Value A_symbol_275 = IP_NamedElement_name.evaluate(evaluator, T_String, self, P_NamedElement_name);
				
				DomainType static_A_symbol_276 = valueFactory.typeOf(A_symbol_275, S_sortedBy);
				LibraryBinaryOperation dynamic_A_symbol_276 = (LibraryBinaryOperation)static_A_symbol_276.lookupImplementation(standardLibrary, O_String__eq_);
				Value A_symbol_276 = dynamic_A_symbol_276.evaluate(evaluator, T_Boolean, A_symbol_275, S_sortedBy);
				leftA_symbol_274 = A_symbol_276;
			} catch (InvalidValueException e) {
				leftA_symbol_274 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_276 = leftA_symbol_274;
			Value rightA_symbol_274;
			try {
					Value leftA_symbol_277;
					try {
						
						Value A_symbol_278 = IP_CallExp_source.evaluate(evaluator, T_pivot__OCLExpression, self, P_CallExp_source);
						
						Value A_symbol_279 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_278, P_TypedElement_type);
						
						DomainType static_A_symbol_280 = valueFactory.typeOf(A_symbol_279);
						LibraryBinaryOperation dynamic_A_symbol_280 = (LibraryBinaryOperation)static_A_symbol_280.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Value A_symbol_280 = dynamic_A_symbol_280.evaluate(evaluator, T_Boolean, A_symbol_279, T_ClassClassifier_pivot__SequenceType_);
						leftA_symbol_277 = A_symbol_280;
					} catch (InvalidValueException e) {
						leftA_symbol_277 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_280 = leftA_symbol_277;
					Value rightA_symbol_277;
					try {
						
						Value A_symbol_281 = IP_CallExp_source.evaluate(evaluator, T_pivot__OCLExpression, self, P_CallExp_source);
						
						Value A_symbol_282 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_281, P_TypedElement_type);
						
						DomainType static_A_symbol_283 = valueFactory.typeOf(A_symbol_282);
						LibraryBinaryOperation dynamic_A_symbol_283 = (LibraryBinaryOperation)static_A_symbol_283.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
						Value A_symbol_283 = dynamic_A_symbol_283.evaluate(evaluator, T_Boolean, A_symbol_282, T_ClassClassifier_pivot__BagType_);
						rightA_symbol_277 = A_symbol_283;
					} catch (InvalidValueException e) {
						rightA_symbol_277 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_283 = rightA_symbol_277;
					DomainType static_A_symbol_277 = valueFactory.typeOf(A_symbol_280);
					LibraryBinaryOperation dynamic_A_symbol_277 = (LibraryBinaryOperation)static_A_symbol_277.lookupImplementation(standardLibrary, O_Boolean_or);
					Value A_symbol_277 = dynamic_A_symbol_277.evaluate(evaluator, T_Boolean, A_symbol_280, A_symbol_283);
				Value A_symbol_284;
				if (A_symbol_277.isTrue()) {
					
					Value A_symbol_285 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
					
					DomainType static_A_symbol_286 = valueFactory.typeOf(A_symbol_285);
					LibraryBinaryOperation dynamic_A_symbol_286 = (LibraryBinaryOperation)static_A_symbol_286.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Value A_symbol_286 = dynamic_A_symbol_286.evaluate(evaluator, T_Boolean, A_symbol_285, T_ClassClassifier_pivot__SequenceType_);
					A_symbol_284 = A_symbol_286;
				}
				else if (A_symbol_277.isFalse()) {
					
					Value A_symbol_287 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
					
					DomainType static_A_symbol_288 = valueFactory.typeOf(A_symbol_287);
					LibraryBinaryOperation dynamic_A_symbol_288 = (LibraryBinaryOperation)static_A_symbol_288.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
					Value A_symbol_288 = dynamic_A_symbol_288.evaluate(evaluator, T_Boolean, A_symbol_287, T_ClassClassifier_pivot__OrderedSetType_);
					A_symbol_284 = A_symbol_288;
				}
				else if (A_symbol_277.isNull()) {
					A_symbol_284 = valueFactory.throwInvalidValueException("null if condition");
				}
				else {
					A_symbol_284 = valueFactory.throwInvalidValueException("invalid if condition");
				}
				rightA_symbol_274 = A_symbol_284;
			} catch (InvalidValueException e) {
				rightA_symbol_274 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_284 = rightA_symbol_274;
			DomainType static_A_symbol_274 = valueFactory.typeOf(A_symbol_276);
			LibraryBinaryOperation dynamic_A_symbol_274 = (LibraryBinaryOperation)static_A_symbol_274.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_274 = dynamic_A_symbol_274.evaluate(evaluator, T_Boolean, A_symbol_276, A_symbol_284);
			return A_symbol_274;
		}
	}
}

