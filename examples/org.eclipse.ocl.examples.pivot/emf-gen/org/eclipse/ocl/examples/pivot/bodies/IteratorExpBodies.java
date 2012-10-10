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
import org.eclipse.jdt.annotation.Nullable;
import java.util.Iterator;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.PrimitiveTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractUnaryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryBinaryOperation;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.TypeValue;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.library.collection.CollectionSizeOperation;
import org.eclipse.ocl.examples.library.executor.ExecutorOperation;
import org.eclipse.ocl.examples.library.logical.BooleanImpliesOperation;
import org.eclipse.ocl.examples.library.logical.BooleanOrOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyOclAsTypeOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.IteratorExp;
import org.eclipse.ocl.examples.pivot.PivotTables;
import org.eclipse.ocl.examples.pivot.Variable;

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
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
		static final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
		static final @NonNull PrimitiveTypeId T_String = TypeId.STRING;
		static final @NonNull Object S_any = "any";
		static final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
		static final @NonNull TypeId T_Type = OCLstdlibTables.Types._Type.getTypeId();
		static final @NonNull TypeId T_pivot__OCLExpression = PivotTables.Types._OCLExpression.getTypeId();
		static final @NonNull Object S_Boolean = "Boolean";
		
	
		/*
		name = 'any' implies body.type = 'Boolean'
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws InvalidValueException {
			assert self != null;
			final @NonNull IteratorExp unboxed_self = (IteratorExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			Object leftA_symbol_;
			try {
				
				java.lang.String unboxed_A_symbol__1 = unboxed_self != null ? unboxed_self.getName() : null;
				Object A_symbol__1 = unboxed_A_symbol__1; // String
				
				
				Object A_symbol__2 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__1, S_any);
				leftA_symbol_ = A_symbol__2;
			} catch (InvalidValueException e) {
				leftA_symbol_ = createInvalidValue(e);
			}
			Object A_symbol__2 = leftA_symbol_;
			Object rightA_symbol_;
			try {
				
				org.eclipse.ocl.examples.pivot.OCLExpression unboxed_A_symbol__3 = unboxed_self != null ? unboxed_self.getBody() : null;
				Object A_symbol__3 = valueOf(unboxed_A_symbol__3); // OCLExpression
				
				
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__4 = unboxed_A_symbol__3 != null ? unboxed_A_symbol__3.getType() : null;
				Object A_symbol__4 = createTypeValue(unboxed_A_symbol__4);
				
				
				DomainType static_A_symbol__5 = evaluator.getStaticTypeOf(A_symbol__4, S_Boolean);
				LibraryBinaryOperation dynamic_A_symbol__5 = (LibraryBinaryOperation)static_A_symbol__5.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Object A_symbol__5 = dynamic_A_symbol__5.evaluate(evaluator, T_Boolean, A_symbol__4, S_Boolean);
				rightA_symbol_ = A_symbol__5;
			} catch (InvalidValueException e) {
				rightA_symbol_ = createInvalidValue(e);
			}
			Object A_symbol__5 = rightA_symbol_;
			Object A_symbol_ = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__2, A_symbol__5);
			return A_symbol_;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'AnyHasOneIterator' invariant.
	 */
	public static class _invariant_AnyHasOneIterator extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_AnyHasOneIterator INSTANCE = new _invariant_AnyHasOneIterator();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
		static final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
		static final @NonNull PrimitiveTypeId T_String = TypeId.STRING;
		static final @NonNull Object S_any = "any";
		static final @NonNull ExecutorOperation O_Real__eq_ = OCLstdlibTables.Operations._Real___eq_;
		static final @NonNull PrimitiveTypeId T_Integer = TypeId.INTEGER;
		static final @NonNull ExecutorOperation O_Collection_size = OCLstdlibTables.Operations._Collection__size;
		static final @NonNull TypeId T_pivot__Variable = PivotTables.Types._Variable.getTypeId();
		static final @NonNull CollectionTypeId T_OrderedSet_pivot__Variable_ = TypeId.ORDERED_SET.getSpecializedId(T_pivot__Variable);
		static final @NonNull IntegerValue I_1 = integerValueOf(1);
		
	
		/*
		name = 'any' implies iterator->size() = 1
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws InvalidValueException {
			assert self != null;
			final @NonNull IteratorExp unboxed_self = (IteratorExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			Object leftA_symbol__6;
			try {
				
				java.lang.String unboxed_A_symbol__7 = unboxed_self != null ? unboxed_self.getName() : null;
				Object A_symbol__7 = unboxed_A_symbol__7; // String
				
				
				Object A_symbol__8 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__7, S_any);
				leftA_symbol__6 = A_symbol__8;
			} catch (InvalidValueException e) {
				leftA_symbol__6 = createInvalidValue(e);
			}
			Object A_symbol__8 = leftA_symbol__6;
			Object rightA_symbol__6;
			try {
				
				org.eclipse.emf.common.util.EList<org.eclipse.ocl.examples.pivot.Variable> unboxed_A_symbol__9 = unboxed_self != null ? unboxed_self.getIterator() : null;
				assert unboxed_A_symbol__9 != null;
				final @NonNull Value A_symbol__9 = standardLibrary.createOrderedSetValueOf(T_OrderedSet_pivot__Variable_, unboxed_A_symbol__9);
				
				
				Object A_symbol__10 = CollectionSizeOperation.INSTANCE.evaluate(evaluator, T_Integer, A_symbol__9);
				Object A_symbol__11 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__10, I_1);
				rightA_symbol__6 = A_symbol__11;
			} catch (InvalidValueException e) {
				rightA_symbol__6 = createInvalidValue(e);
			}
			Object A_symbol__11 = rightA_symbol__6;
			Object A_symbol__6 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__8, A_symbol__11);
			return A_symbol__6;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'AnyTypeIsSourceElementType' invariant.
	 */
	public static class _invariant_AnyTypeIsSourceElementType extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_AnyTypeIsSourceElementType INSTANCE = new _invariant_AnyTypeIsSourceElementType();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
		static final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
		static final @NonNull PrimitiveTypeId T_String = TypeId.STRING;
		static final @NonNull Object S_any = "any";
		static final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
		static final @NonNull TypeId T_Type = OCLstdlibTables.Types._Type.getTypeId();
		static final @NonNull TypeId T_pivot__CollectionType = PivotTables.Types._CollectionType.getTypeId();
		static final @NonNull ExecutorOperation O_OclAny_oclAsType = OCLstdlibTables.Operations._OclAny__oclAsType;
		static final @NonNull TypeId T_pivot__OCLExpression = PivotTables.Types._OCLExpression.getTypeId();
		static final @NonNull Object T_Metaclass_pivot__CollectionType_ = createTypeValue(PivotTables.Types._CollectionType);
		
	
		/*
		name = 'any' implies type = source.type.oclAsType(CollectionType).elementType
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws InvalidValueException {
			assert self != null;
			final @NonNull IteratorExp unboxed_self = (IteratorExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			Object leftA_symbol__12;
			try {
				
				java.lang.String unboxed_A_symbol__13 = unboxed_self != null ? unboxed_self.getName() : null;
				Object A_symbol__13 = unboxed_A_symbol__13; // String
				
				
				Object A_symbol__14 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__13, S_any);
				leftA_symbol__12 = A_symbol__14;
			} catch (InvalidValueException e) {
				leftA_symbol__12 = createInvalidValue(e);
			}
			Object A_symbol__14 = leftA_symbol__12;
			Object rightA_symbol__12;
			try {
				
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__15 = unboxed_self != null ? unboxed_self.getType() : null;
				Object A_symbol__15 = createTypeValue(unboxed_A_symbol__15);
				
				
				
				org.eclipse.ocl.examples.pivot.OCLExpression unboxed_A_symbol__16 = unboxed_self != null ? unboxed_self.getSource() : null;
				Object A_symbol__16 = valueOf(unboxed_A_symbol__16); // OCLExpression
				
				
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__17 = unboxed_A_symbol__16 != null ? unboxed_A_symbol__16.getType() : null;
				Object A_symbol__17 = createTypeValue(unboxed_A_symbol__17);
				
				
				Object A_symbol__18 = OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, T_pivot__CollectionType, A_symbol__17, T_Metaclass_pivot__CollectionType_);
				assert A_symbol__18 != null;
				CollectionType unboxed_A_symbol__18 = (CollectionType)((TypeValue)A_symbol__18).getInstanceType();
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__19 = unboxed_A_symbol__18 != null ? unboxed_A_symbol__18.getElementType() : null;
				Object A_symbol__19 = createTypeValue(unboxed_A_symbol__19);
				
				
				DomainType static_A_symbol__20 = evaluator.getStaticTypeOf(A_symbol__15, A_symbol__19);
				LibraryBinaryOperation dynamic_A_symbol__20 = (LibraryBinaryOperation)static_A_symbol__20.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Object A_symbol__20 = dynamic_A_symbol__20.evaluate(evaluator, T_Boolean, A_symbol__15, A_symbol__19);
				rightA_symbol__12 = A_symbol__20;
			} catch (InvalidValueException e) {
				rightA_symbol__12 = createInvalidValue(e);
			}
			Object A_symbol__20 = rightA_symbol__12;
			Object A_symbol__12 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__14, A_symbol__20);
			return A_symbol__12;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'ClosureBodyTypeIsConformanttoIteratorType' invariant.
	 */
	public static class _invariant_ClosureBodyTypeIsConformanttoIteratorType extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_ClosureBodyTypeIsConformanttoIteratorType INSTANCE = new _invariant_ClosureBodyTypeIsConformanttoIteratorType();
		static final @NonNull Object True = true;
		
	
		/*
		true
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws InvalidValueException {
			assert self != null;
			final @NonNull IteratorExp unboxed_self = (IteratorExp)self;
			
			
			return True;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'ClosureElementTypeIsSourceElementType' invariant.
	 */
	public static class _invariant_ClosureElementTypeIsSourceElementType extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_ClosureElementTypeIsSourceElementType INSTANCE = new _invariant_ClosureElementTypeIsSourceElementType();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
		static final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
		static final @NonNull PrimitiveTypeId T_String = TypeId.STRING;
		static final @NonNull Object S_closure = "closure";
		static final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
		static final @NonNull TypeId T_Type = OCLstdlibTables.Types._Type.getTypeId();
		static final @NonNull TypeId T_pivot__CollectionType = PivotTables.Types._CollectionType.getTypeId();
		static final @NonNull ExecutorOperation O_OclAny_oclAsType = OCLstdlibTables.Operations._OclAny__oclAsType;
		static final @NonNull Object T_Metaclass_pivot__CollectionType_ = createTypeValue(PivotTables.Types._CollectionType);
		static final @NonNull TypeId T_pivot__OCLExpression = PivotTables.Types._OCLExpression.getTypeId();
		
	
		/*
		name = 'closure' implies
	type.oclAsType(CollectionType).elementType =
	source.type.oclAsType(CollectionType).elementType
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws InvalidValueException {
			assert self != null;
			final @NonNull IteratorExp unboxed_self = (IteratorExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			Object leftA_symbol__21;
			try {
				
				java.lang.String unboxed_A_symbol__22 = unboxed_self != null ? unboxed_self.getName() : null;
				Object A_symbol__22 = unboxed_A_symbol__22; // String
				
				
				Object A_symbol__23 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__22, S_closure);
				leftA_symbol__21 = A_symbol__23;
			} catch (InvalidValueException e) {
				leftA_symbol__21 = createInvalidValue(e);
			}
			Object A_symbol__23 = leftA_symbol__21;
			Object rightA_symbol__21;
			try {
				
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__24 = unboxed_self != null ? unboxed_self.getType() : null;
				Object A_symbol__24 = createTypeValue(unboxed_A_symbol__24);
				
				
				Object A_symbol__25 = OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, T_pivot__CollectionType, A_symbol__24, T_Metaclass_pivot__CollectionType_);
				assert A_symbol__25 != null;
				CollectionType unboxed_A_symbol__25 = (CollectionType)((TypeValue)A_symbol__25).getInstanceType();
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__26 = unboxed_A_symbol__25 != null ? unboxed_A_symbol__25.getElementType() : null;
				Object A_symbol__26 = createTypeValue(unboxed_A_symbol__26);
				
				
				
				org.eclipse.ocl.examples.pivot.OCLExpression unboxed_A_symbol__27 = unboxed_self != null ? unboxed_self.getSource() : null;
				Object A_symbol__27 = valueOf(unboxed_A_symbol__27); // OCLExpression
				
				
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__28 = unboxed_A_symbol__27 != null ? unboxed_A_symbol__27.getType() : null;
				Object A_symbol__28 = createTypeValue(unboxed_A_symbol__28);
				
				
				Object A_symbol__29 = OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, T_pivot__CollectionType, A_symbol__28, T_Metaclass_pivot__CollectionType_);
				assert A_symbol__29 != null;
				CollectionType unboxed_A_symbol__29 = (CollectionType)((TypeValue)A_symbol__29).getInstanceType();
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__30 = unboxed_A_symbol__29 != null ? unboxed_A_symbol__29.getElementType() : null;
				Object A_symbol__30 = createTypeValue(unboxed_A_symbol__30);
				
				
				DomainType static_A_symbol__31 = evaluator.getStaticTypeOf(A_symbol__26, A_symbol__30);
				LibraryBinaryOperation dynamic_A_symbol__31 = (LibraryBinaryOperation)static_A_symbol__31.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Object A_symbol__31 = dynamic_A_symbol__31.evaluate(evaluator, T_Boolean, A_symbol__26, A_symbol__30);
				rightA_symbol__21 = A_symbol__31;
			} catch (InvalidValueException e) {
				rightA_symbol__21 = createInvalidValue(e);
			}
			Object A_symbol__31 = rightA_symbol__21;
			Object A_symbol__21 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__23, A_symbol__31);
			return A_symbol__21;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'ClosureHasOneIterator' invariant.
	 */
	public static class _invariant_ClosureHasOneIterator extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_ClosureHasOneIterator INSTANCE = new _invariant_ClosureHasOneIterator();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
		static final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
		static final @NonNull PrimitiveTypeId T_String = TypeId.STRING;
		static final @NonNull Object S_closure = "closure";
		static final @NonNull ExecutorOperation O_Real__eq_ = OCLstdlibTables.Operations._Real___eq_;
		static final @NonNull PrimitiveTypeId T_Integer = TypeId.INTEGER;
		static final @NonNull ExecutorOperation O_Collection_size = OCLstdlibTables.Operations._Collection__size;
		static final @NonNull TypeId T_pivot__Variable = PivotTables.Types._Variable.getTypeId();
		static final @NonNull CollectionTypeId T_OrderedSet_pivot__Variable_ = TypeId.ORDERED_SET.getSpecializedId(T_pivot__Variable);
		static final @NonNull IntegerValue I_1 = integerValueOf(1);
		
	
		/*
		name = 'closure' implies iterator->size() = 1
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws InvalidValueException {
			assert self != null;
			final @NonNull IteratorExp unboxed_self = (IteratorExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			Object leftA_symbol__32;
			try {
				
				java.lang.String unboxed_A_symbol__33 = unboxed_self != null ? unboxed_self.getName() : null;
				Object A_symbol__33 = unboxed_A_symbol__33; // String
				
				
				Object A_symbol__34 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__33, S_closure);
				leftA_symbol__32 = A_symbol__34;
			} catch (InvalidValueException e) {
				leftA_symbol__32 = createInvalidValue(e);
			}
			Object A_symbol__34 = leftA_symbol__32;
			Object rightA_symbol__32;
			try {
				
				org.eclipse.emf.common.util.EList<org.eclipse.ocl.examples.pivot.Variable> unboxed_A_symbol__35 = unboxed_self != null ? unboxed_self.getIterator() : null;
				assert unboxed_A_symbol__35 != null;
				final @NonNull Value A_symbol__35 = standardLibrary.createOrderedSetValueOf(T_OrderedSet_pivot__Variable_, unboxed_A_symbol__35);
				
				
				Object A_symbol__36 = CollectionSizeOperation.INSTANCE.evaluate(evaluator, T_Integer, A_symbol__35);
				Object A_symbol__37 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__36, I_1);
				rightA_symbol__32 = A_symbol__37;
			} catch (InvalidValueException e) {
				rightA_symbol__32 = createInvalidValue(e);
			}
			Object A_symbol__37 = rightA_symbol__32;
			Object A_symbol__32 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__34, A_symbol__37);
			return A_symbol__32;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'ClosureSourceElementTypeIsBodyElementType' invariant.
	 */
	public static class _invariant_ClosureSourceElementTypeIsBodyElementType extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_ClosureSourceElementTypeIsBodyElementType INSTANCE = new _invariant_ClosureSourceElementTypeIsBodyElementType();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
		static final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
		static final @NonNull PrimitiveTypeId T_String = TypeId.STRING;
		static final @NonNull Object S_closure = "closure";
		static final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
		static final @NonNull TypeId T_Type = OCLstdlibTables.Types._Type.getTypeId();
		static final @NonNull TypeId T_pivot__CollectionType = PivotTables.Types._CollectionType.getTypeId();
		static final @NonNull ExecutorOperation O_OclAny_oclAsType = OCLstdlibTables.Operations._OclAny__oclAsType;
		static final @NonNull TypeId T_pivot__OCLExpression = PivotTables.Types._OCLExpression.getTypeId();
		static final @NonNull Object T_Metaclass_pivot__CollectionType_ = createTypeValue(PivotTables.Types._CollectionType);
		static final @NonNull ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
		
	
		/*
		name = 'closure' implies
	source.type.oclAsType(CollectionType).elementType =
	if body.type.oclIsKindOf(CollectionType)
	then body.type.oclAsType(CollectionType).elementType
	else body.type
	endif
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws InvalidValueException {
			assert self != null;
			final @NonNull IteratorExp unboxed_self = (IteratorExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			Object leftA_symbol__38;
			try {
				
				java.lang.String unboxed_A_symbol__39 = unboxed_self != null ? unboxed_self.getName() : null;
				Object A_symbol__39 = unboxed_A_symbol__39; // String
				
				
				Object A_symbol__40 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__39, S_closure);
				leftA_symbol__38 = A_symbol__40;
			} catch (InvalidValueException e) {
				leftA_symbol__38 = createInvalidValue(e);
			}
			Object A_symbol__40 = leftA_symbol__38;
			Object rightA_symbol__38;
			try {
				
				org.eclipse.ocl.examples.pivot.OCLExpression unboxed_A_symbol__41 = unboxed_self != null ? unboxed_self.getSource() : null;
				Object A_symbol__41 = valueOf(unboxed_A_symbol__41); // OCLExpression
				
				
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__42 = unboxed_A_symbol__41 != null ? unboxed_A_symbol__41.getType() : null;
				Object A_symbol__42 = createTypeValue(unboxed_A_symbol__42);
				
				
				Object A_symbol__43 = OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, T_pivot__CollectionType, A_symbol__42, T_Metaclass_pivot__CollectionType_);
				assert A_symbol__43 != null;
				CollectionType unboxed_A_symbol__43 = (CollectionType)((TypeValue)A_symbol__43).getInstanceType();
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__44 = unboxed_A_symbol__43 != null ? unboxed_A_symbol__43.getElementType() : null;
				Object A_symbol__44 = createTypeValue(unboxed_A_symbol__44);
				
				
					
					org.eclipse.ocl.examples.pivot.OCLExpression unboxed_A_symbol__45 = unboxed_self != null ? unboxed_self.getBody() : null;
					Object A_symbol__45 = valueOf(unboxed_A_symbol__45); // OCLExpression
					
					
					org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__46 = unboxed_A_symbol__45 != null ? unboxed_A_symbol__45.getType() : null;
					Object A_symbol__46 = createTypeValue(unboxed_A_symbol__46);
					
					
					Object A_symbol__47 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__46, T_Metaclass_pivot__CollectionType_);
				Object A_symbol__48;
				if (A_symbol__47 == ValuesUtil.TRUE_VALUE) {
					
					org.eclipse.ocl.examples.pivot.OCLExpression unboxed_A_symbol__49 = unboxed_self != null ? unboxed_self.getBody() : null;
					Object A_symbol__49 = valueOf(unboxed_A_symbol__49); // OCLExpression
					
					
					org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__50 = unboxed_A_symbol__49 != null ? unboxed_A_symbol__49.getType() : null;
					Object A_symbol__50 = createTypeValue(unboxed_A_symbol__50);
					
					
					Object A_symbol__51 = OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, T_pivot__CollectionType, A_symbol__50, T_Metaclass_pivot__CollectionType_);
					assert A_symbol__51 != null;
					CollectionType unboxed_A_symbol__51 = (CollectionType)((TypeValue)A_symbol__51).getInstanceType();
					org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__52 = unboxed_A_symbol__51 != null ? unboxed_A_symbol__51.getElementType() : null;
					Object A_symbol__52 = createTypeValue(unboxed_A_symbol__52);
					
					
					A_symbol__48 = A_symbol__52;
				}
				else if (A_symbol__47 == ValuesUtil.FALSE_VALUE) {
					
					org.eclipse.ocl.examples.pivot.OCLExpression unboxed_A_symbol__53 = unboxed_self != null ? unboxed_self.getBody() : null;
					Object A_symbol__53 = valueOf(unboxed_A_symbol__53); // OCLExpression
					
					
					org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__54 = unboxed_A_symbol__53 != null ? unboxed_A_symbol__53.getType() : null;
					Object A_symbol__54 = createTypeValue(unboxed_A_symbol__54);
					
					
					A_symbol__48 = A_symbol__54;
				}
				else {
					A_symbol__48 = createInvalidValue("non-Boolean if condition");
				}
				DomainType static_A_symbol__55 = evaluator.getStaticTypeOf(A_symbol__44, A_symbol__48);
				LibraryBinaryOperation dynamic_A_symbol__55 = (LibraryBinaryOperation)static_A_symbol__55.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Object A_symbol__55 = dynamic_A_symbol__55.evaluate(evaluator, T_Boolean, A_symbol__44, A_symbol__48);
				rightA_symbol__38 = A_symbol__55;
			} catch (InvalidValueException e) {
				rightA_symbol__38 = createInvalidValue(e);
			}
			Object A_symbol__55 = rightA_symbol__38;
			Object A_symbol__38 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__40, A_symbol__55);
			return A_symbol__38;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'ClosureTypeIsUniqueCollection' invariant.
	 */
	public static class _invariant_ClosureTypeIsUniqueCollection extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_ClosureTypeIsUniqueCollection INSTANCE = new _invariant_ClosureTypeIsUniqueCollection();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
		static final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
		static final @NonNull PrimitiveTypeId T_String = TypeId.STRING;
		static final @NonNull Object S_closure = "closure";
		static final @NonNull ExecutorOperation O_Boolean_or = OCLstdlibTables.Operations._Boolean__or;
		static final @NonNull ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
		static final @NonNull TypeId T_Type = OCLstdlibTables.Types._Type.getTypeId();
		static final @NonNull TypeId T_pivot__OCLExpression = PivotTables.Types._OCLExpression.getTypeId();
		static final @NonNull Object T_Metaclass_pivot__SequenceType_ = createTypeValue(PivotTables.Types._SequenceType);
		static final @NonNull Object T_Metaclass_pivot__OrderedSetType_ = createTypeValue(PivotTables.Types._OrderedSetType);
		static final @NonNull Object T_Metaclass_pivot__SetType_ = createTypeValue(PivotTables.Types._SetType);
		
	
		/*
		name = 'closure' implies
	if
	  source.type.oclIsKindOf(SequenceType) or
	  source.type.oclIsKindOf(OrderedSetType)
	then type.oclIsKindOf(OrderedSetType)
	else type.oclIsKindOf(SetType)
	endif
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws InvalidValueException {
			assert self != null;
			final @NonNull IteratorExp unboxed_self = (IteratorExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			Object leftA_symbol__56;
			try {
				
				java.lang.String unboxed_A_symbol__57 = unboxed_self != null ? unboxed_self.getName() : null;
				Object A_symbol__57 = unboxed_A_symbol__57; // String
				
				
				Object A_symbol__58 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__57, S_closure);
				leftA_symbol__56 = A_symbol__58;
			} catch (InvalidValueException e) {
				leftA_symbol__56 = createInvalidValue(e);
			}
			Object A_symbol__58 = leftA_symbol__56;
			Object rightA_symbol__56;
			try {
					Object leftA_symbol__59;
					try {
						
						org.eclipse.ocl.examples.pivot.OCLExpression unboxed_A_symbol__60 = unboxed_self != null ? unboxed_self.getSource() : null;
						Object A_symbol__60 = valueOf(unboxed_A_symbol__60); // OCLExpression
						
						
						org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__61 = unboxed_A_symbol__60 != null ? unboxed_A_symbol__60.getType() : null;
						Object A_symbol__61 = createTypeValue(unboxed_A_symbol__61);
						
						
						Object A_symbol__62 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__61, T_Metaclass_pivot__SequenceType_);
						leftA_symbol__59 = A_symbol__62;
					} catch (InvalidValueException e) {
						leftA_symbol__59 = createInvalidValue(e);
					}
					Object A_symbol__62 = leftA_symbol__59;
					Object rightA_symbol__59;
					try {
						
						org.eclipse.ocl.examples.pivot.OCLExpression unboxed_A_symbol__63 = unboxed_self != null ? unboxed_self.getSource() : null;
						Object A_symbol__63 = valueOf(unboxed_A_symbol__63); // OCLExpression
						
						
						org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__64 = unboxed_A_symbol__63 != null ? unboxed_A_symbol__63.getType() : null;
						Object A_symbol__64 = createTypeValue(unboxed_A_symbol__64);
						
						
						Object A_symbol__65 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__64, T_Metaclass_pivot__OrderedSetType_);
						rightA_symbol__59 = A_symbol__65;
					} catch (InvalidValueException e) {
						rightA_symbol__59 = createInvalidValue(e);
					}
					Object A_symbol__65 = rightA_symbol__59;
					Object A_symbol__59 = BooleanOrOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__62, A_symbol__65);
				Object A_symbol__66;
				if (A_symbol__59 == ValuesUtil.TRUE_VALUE) {
					
					org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__67 = unboxed_self != null ? unboxed_self.getType() : null;
					Object A_symbol__67 = createTypeValue(unboxed_A_symbol__67);
					
					
					Object A_symbol__68 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__67, T_Metaclass_pivot__OrderedSetType_);
					A_symbol__66 = A_symbol__68;
				}
				else if (A_symbol__59 == ValuesUtil.FALSE_VALUE) {
					
					org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__69 = unboxed_self != null ? unboxed_self.getType() : null;
					Object A_symbol__69 = createTypeValue(unboxed_A_symbol__69);
					
					
					Object A_symbol__70 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__69, T_Metaclass_pivot__SetType_);
					A_symbol__66 = A_symbol__70;
				}
				else {
					A_symbol__66 = createInvalidValue("non-Boolean if condition");
				}
				rightA_symbol__56 = A_symbol__66;
			} catch (InvalidValueException e) {
				rightA_symbol__56 = createInvalidValue(e);
			}
			Object A_symbol__66 = rightA_symbol__56;
			Object A_symbol__56 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__58, A_symbol__66);
			return A_symbol__56;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'CollectElementTypeIsSourceElementType' invariant.
	 */
	public static class _invariant_CollectElementTypeIsSourceElementType extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_CollectElementTypeIsSourceElementType INSTANCE = new _invariant_CollectElementTypeIsSourceElementType();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
		static final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
		static final @NonNull PrimitiveTypeId T_String = TypeId.STRING;
		static final @NonNull Object S_collect = "collect";
		static final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
		static final @NonNull TypeId T_Type = OCLstdlibTables.Types._Type.getTypeId();
		static final @NonNull TypeId T_pivot__CollectionType = PivotTables.Types._CollectionType.getTypeId();
		static final @NonNull ExecutorOperation O_OclAny_oclAsType = OCLstdlibTables.Operations._OclAny__oclAsType;
		static final @NonNull Object T_Metaclass_pivot__CollectionType_ = createTypeValue(PivotTables.Types._CollectionType);
		static final @NonNull TypeId T_pivot__OCLExpression = PivotTables.Types._OCLExpression.getTypeId();
		
	
		/*
		name = 'collect' implies
	type.oclAsType(CollectionType).elementType =
	body.type.oclAsType(CollectionType).elementType
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws InvalidValueException {
			assert self != null;
			final @NonNull IteratorExp unboxed_self = (IteratorExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			Object leftA_symbol__71;
			try {
				
				java.lang.String unboxed_A_symbol__72 = unboxed_self != null ? unboxed_self.getName() : null;
				Object A_symbol__72 = unboxed_A_symbol__72; // String
				
				
				Object A_symbol__73 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__72, S_collect);
				leftA_symbol__71 = A_symbol__73;
			} catch (InvalidValueException e) {
				leftA_symbol__71 = createInvalidValue(e);
			}
			Object A_symbol__73 = leftA_symbol__71;
			Object rightA_symbol__71;
			try {
				
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__74 = unboxed_self != null ? unboxed_self.getType() : null;
				Object A_symbol__74 = createTypeValue(unboxed_A_symbol__74);
				
				
				Object A_symbol__75 = OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, T_pivot__CollectionType, A_symbol__74, T_Metaclass_pivot__CollectionType_);
				assert A_symbol__75 != null;
				CollectionType unboxed_A_symbol__75 = (CollectionType)((TypeValue)A_symbol__75).getInstanceType();
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__76 = unboxed_A_symbol__75 != null ? unboxed_A_symbol__75.getElementType() : null;
				Object A_symbol__76 = createTypeValue(unboxed_A_symbol__76);
				
				
				
				org.eclipse.ocl.examples.pivot.OCLExpression unboxed_A_symbol__77 = unboxed_self != null ? unboxed_self.getBody() : null;
				Object A_symbol__77 = valueOf(unboxed_A_symbol__77); // OCLExpression
				
				
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__78 = unboxed_A_symbol__77 != null ? unboxed_A_symbol__77.getType() : null;
				Object A_symbol__78 = createTypeValue(unboxed_A_symbol__78);
				
				
				Object A_symbol__79 = OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, T_pivot__CollectionType, A_symbol__78, T_Metaclass_pivot__CollectionType_);
				assert A_symbol__79 != null;
				CollectionType unboxed_A_symbol__79 = (CollectionType)((TypeValue)A_symbol__79).getInstanceType();
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__80 = unboxed_A_symbol__79 != null ? unboxed_A_symbol__79.getElementType() : null;
				Object A_symbol__80 = createTypeValue(unboxed_A_symbol__80);
				
				
				DomainType static_A_symbol__81 = evaluator.getStaticTypeOf(A_symbol__76, A_symbol__80);
				LibraryBinaryOperation dynamic_A_symbol__81 = (LibraryBinaryOperation)static_A_symbol__81.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Object A_symbol__81 = dynamic_A_symbol__81.evaluate(evaluator, T_Boolean, A_symbol__76, A_symbol__80);
				rightA_symbol__71 = A_symbol__81;
			} catch (InvalidValueException e) {
				rightA_symbol__71 = createInvalidValue(e);
			}
			Object A_symbol__81 = rightA_symbol__71;
			Object A_symbol__71 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__73, A_symbol__81);
			return A_symbol__71;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'CollectHasOneIterator' invariant.
	 */
	public static class _invariant_CollectHasOneIterator extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_CollectHasOneIterator INSTANCE = new _invariant_CollectHasOneIterator();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
		static final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
		static final @NonNull PrimitiveTypeId T_String = TypeId.STRING;
		static final @NonNull Object S_collect = "collect";
		static final @NonNull ExecutorOperation O_Real__eq_ = OCLstdlibTables.Operations._Real___eq_;
		static final @NonNull PrimitiveTypeId T_Integer = TypeId.INTEGER;
		static final @NonNull ExecutorOperation O_Collection_size = OCLstdlibTables.Operations._Collection__size;
		static final @NonNull TypeId T_pivot__Variable = PivotTables.Types._Variable.getTypeId();
		static final @NonNull CollectionTypeId T_OrderedSet_pivot__Variable_ = TypeId.ORDERED_SET.getSpecializedId(T_pivot__Variable);
		static final @NonNull IntegerValue I_1 = integerValueOf(1);
		
	
		/*
		name = 'collect' implies iterator->size() = 1
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws InvalidValueException {
			assert self != null;
			final @NonNull IteratorExp unboxed_self = (IteratorExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			Object leftA_symbol__82;
			try {
				
				java.lang.String unboxed_A_symbol__83 = unboxed_self != null ? unboxed_self.getName() : null;
				Object A_symbol__83 = unboxed_A_symbol__83; // String
				
				
				Object A_symbol__84 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__83, S_collect);
				leftA_symbol__82 = A_symbol__84;
			} catch (InvalidValueException e) {
				leftA_symbol__82 = createInvalidValue(e);
			}
			Object A_symbol__84 = leftA_symbol__82;
			Object rightA_symbol__82;
			try {
				
				org.eclipse.emf.common.util.EList<org.eclipse.ocl.examples.pivot.Variable> unboxed_A_symbol__85 = unboxed_self != null ? unboxed_self.getIterator() : null;
				assert unboxed_A_symbol__85 != null;
				final @NonNull Value A_symbol__85 = standardLibrary.createOrderedSetValueOf(T_OrderedSet_pivot__Variable_, unboxed_A_symbol__85);
				
				
				Object A_symbol__86 = CollectionSizeOperation.INSTANCE.evaluate(evaluator, T_Integer, A_symbol__85);
				Object A_symbol__87 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__86, I_1);
				rightA_symbol__82 = A_symbol__87;
			} catch (InvalidValueException e) {
				rightA_symbol__82 = createInvalidValue(e);
			}
			Object A_symbol__87 = rightA_symbol__82;
			Object A_symbol__82 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__84, A_symbol__87);
			return A_symbol__82;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'CollectNestedHasOneIterator' invariant.
	 */
	public static class _invariant_CollectNestedHasOneIterator extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_CollectNestedHasOneIterator INSTANCE = new _invariant_CollectNestedHasOneIterator();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
		static final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
		static final @NonNull PrimitiveTypeId T_String = TypeId.STRING;
		static final @NonNull Object S_collectN___ = "collectNested";
		static final @NonNull ExecutorOperation O_Real__eq_ = OCLstdlibTables.Operations._Real___eq_;
		static final @NonNull PrimitiveTypeId T_Integer = TypeId.INTEGER;
		static final @NonNull ExecutorOperation O_Collection_size = OCLstdlibTables.Operations._Collection__size;
		static final @NonNull TypeId T_pivot__Variable = PivotTables.Types._Variable.getTypeId();
		static final @NonNull CollectionTypeId T_OrderedSet_pivot__Variable_ = TypeId.ORDERED_SET.getSpecializedId(T_pivot__Variable);
		static final @NonNull IntegerValue I_1 = integerValueOf(1);
		
	
		/*
		name = 'collectNested' implies iterator->size() = 1
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws InvalidValueException {
			assert self != null;
			final @NonNull IteratorExp unboxed_self = (IteratorExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			Object leftA_symbol__88;
			try {
				
				java.lang.String unboxed_A_symbol__89 = unboxed_self != null ? unboxed_self.getName() : null;
				Object A_symbol__89 = unboxed_A_symbol__89; // String
				
				
				Object A_symbol__90 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__89, S_collectN___);
				leftA_symbol__88 = A_symbol__90;
			} catch (InvalidValueException e) {
				leftA_symbol__88 = createInvalidValue(e);
			}
			Object A_symbol__90 = leftA_symbol__88;
			Object rightA_symbol__88;
			try {
				
				org.eclipse.emf.common.util.EList<org.eclipse.ocl.examples.pivot.Variable> unboxed_A_symbol__91 = unboxed_self != null ? unboxed_self.getIterator() : null;
				assert unboxed_A_symbol__91 != null;
				final @NonNull Value A_symbol__91 = standardLibrary.createOrderedSetValueOf(T_OrderedSet_pivot__Variable_, unboxed_A_symbol__91);
				
				
				Object A_symbol__92 = CollectionSizeOperation.INSTANCE.evaluate(evaluator, T_Integer, A_symbol__91);
				Object A_symbol__93 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__92, I_1);
				rightA_symbol__88 = A_symbol__93;
			} catch (InvalidValueException e) {
				rightA_symbol__88 = createInvalidValue(e);
			}
			Object A_symbol__93 = rightA_symbol__88;
			Object A_symbol__88 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__90, A_symbol__93);
			return A_symbol__88;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'CollectNestedTypeIsBag' invariant.
	 */
	public static class _invariant_CollectNestedTypeIsBag extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_CollectNestedTypeIsBag INSTANCE = new _invariant_CollectNestedTypeIsBag();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
		static final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
		static final @NonNull PrimitiveTypeId T_String = TypeId.STRING;
		static final @NonNull Object S_collectN___ = "collectNested";
		static final @NonNull ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
		static final @NonNull TypeId T_Type = OCLstdlibTables.Types._Type.getTypeId();
		static final @NonNull Object T_Metaclass_pivot__BagType_ = createTypeValue(PivotTables.Types._BagType);
		
	
		/*
		name = 'collectNested' implies type.oclIsKindOf(BagType)
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws InvalidValueException {
			assert self != null;
			final @NonNull IteratorExp unboxed_self = (IteratorExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			Object leftA_symbol__94;
			try {
				
				java.lang.String unboxed_A_symbol__95 = unboxed_self != null ? unboxed_self.getName() : null;
				Object A_symbol__95 = unboxed_A_symbol__95; // String
				
				
				Object A_symbol__96 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__95, S_collectN___);
				leftA_symbol__94 = A_symbol__96;
			} catch (InvalidValueException e) {
				leftA_symbol__94 = createInvalidValue(e);
			}
			Object A_symbol__96 = leftA_symbol__94;
			Object rightA_symbol__94;
			try {
				
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__97 = unboxed_self != null ? unboxed_self.getType() : null;
				Object A_symbol__97 = createTypeValue(unboxed_A_symbol__97);
				
				
				Object A_symbol__98 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__97, T_Metaclass_pivot__BagType_);
				rightA_symbol__94 = A_symbol__98;
			} catch (InvalidValueException e) {
				rightA_symbol__94 = createInvalidValue(e);
			}
			Object A_symbol__98 = rightA_symbol__94;
			Object A_symbol__94 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__96, A_symbol__98);
			return A_symbol__94;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'CollectNestedTypeIsBodyType' invariant.
	 */
	public static class _invariant_CollectNestedTypeIsBodyType extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_CollectNestedTypeIsBodyType INSTANCE = new _invariant_CollectNestedTypeIsBodyType();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
		static final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
		static final @NonNull PrimitiveTypeId T_String = TypeId.STRING;
		static final @NonNull Object S_collectN___ = "collectNested";
		static final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
		static final @NonNull TypeId T_Type = OCLstdlibTables.Types._Type.getTypeId();
		static final @NonNull TypeId T_pivot__OCLExpression = PivotTables.Types._OCLExpression.getTypeId();
		
	
		/*
		name = 'collectNested' implies type = body.type
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws InvalidValueException {
			assert self != null;
			final @NonNull IteratorExp unboxed_self = (IteratorExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			Object leftA_symbol__99;
			try {
				
				java.lang.String unboxed_A_symbol__100 = unboxed_self != null ? unboxed_self.getName() : null;
				Object A_symbol__100 = unboxed_A_symbol__100; // String
				
				
				Object A_symbol__101 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__100, S_collectN___);
				leftA_symbol__99 = A_symbol__101;
			} catch (InvalidValueException e) {
				leftA_symbol__99 = createInvalidValue(e);
			}
			Object A_symbol__101 = leftA_symbol__99;
			Object rightA_symbol__99;
			try {
				
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__102 = unboxed_self != null ? unboxed_self.getType() : null;
				Object A_symbol__102 = createTypeValue(unboxed_A_symbol__102);
				
				
				
				org.eclipse.ocl.examples.pivot.OCLExpression unboxed_A_symbol__103 = unboxed_self != null ? unboxed_self.getBody() : null;
				Object A_symbol__103 = valueOf(unboxed_A_symbol__103); // OCLExpression
				
				
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__104 = unboxed_A_symbol__103 != null ? unboxed_A_symbol__103.getType() : null;
				Object A_symbol__104 = createTypeValue(unboxed_A_symbol__104);
				
				
				DomainType static_A_symbol__105 = evaluator.getStaticTypeOf(A_symbol__102, A_symbol__104);
				LibraryBinaryOperation dynamic_A_symbol__105 = (LibraryBinaryOperation)static_A_symbol__105.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Object A_symbol__105 = dynamic_A_symbol__105.evaluate(evaluator, T_Boolean, A_symbol__102, A_symbol__104);
				rightA_symbol__99 = A_symbol__105;
			} catch (InvalidValueException e) {
				rightA_symbol__99 = createInvalidValue(e);
			}
			Object A_symbol__105 = rightA_symbol__99;
			Object A_symbol__99 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__101, A_symbol__105);
			return A_symbol__99;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'CollectTypeIsUnordered' invariant.
	 */
	public static class _invariant_CollectTypeIsUnordered extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_CollectTypeIsUnordered INSTANCE = new _invariant_CollectTypeIsUnordered();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
		static final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
		static final @NonNull PrimitiveTypeId T_String = TypeId.STRING;
		static final @NonNull Object S_collect = "collect";
		static final @NonNull ExecutorOperation O_Boolean_or = OCLstdlibTables.Operations._Boolean__or;
		static final @NonNull ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
		static final @NonNull TypeId T_Type = OCLstdlibTables.Types._Type.getTypeId();
		static final @NonNull TypeId T_pivot__OCLExpression = PivotTables.Types._OCLExpression.getTypeId();
		static final @NonNull Object T_Metaclass_pivot__SequenceType_ = createTypeValue(PivotTables.Types._SequenceType);
		static final @NonNull Object T_Metaclass_pivot__OrderedSetType_ = createTypeValue(PivotTables.Types._OrderedSetType);
		static final @NonNull Object T_Metaclass_pivot__BagType_ = createTypeValue(PivotTables.Types._BagType);
		
	
		/*
		name = 'collect' implies
	if
	  source.type.oclIsKindOf(SequenceType) or
	  source.type.oclIsKindOf(OrderedSetType)
	then type.oclIsKindOf(SequenceType)
	else type.oclIsKindOf(BagType)
	endif
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws InvalidValueException {
			assert self != null;
			final @NonNull IteratorExp unboxed_self = (IteratorExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			Object leftA_symbol__106;
			try {
				
				java.lang.String unboxed_A_symbol__107 = unboxed_self != null ? unboxed_self.getName() : null;
				Object A_symbol__107 = unboxed_A_symbol__107; // String
				
				
				Object A_symbol__108 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__107, S_collect);
				leftA_symbol__106 = A_symbol__108;
			} catch (InvalidValueException e) {
				leftA_symbol__106 = createInvalidValue(e);
			}
			Object A_symbol__108 = leftA_symbol__106;
			Object rightA_symbol__106;
			try {
					Object leftA_symbol__109;
					try {
						
						org.eclipse.ocl.examples.pivot.OCLExpression unboxed_A_symbol__110 = unboxed_self != null ? unboxed_self.getSource() : null;
						Object A_symbol__110 = valueOf(unboxed_A_symbol__110); // OCLExpression
						
						
						org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__111 = unboxed_A_symbol__110 != null ? unboxed_A_symbol__110.getType() : null;
						Object A_symbol__111 = createTypeValue(unboxed_A_symbol__111);
						
						
						Object A_symbol__112 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__111, T_Metaclass_pivot__SequenceType_);
						leftA_symbol__109 = A_symbol__112;
					} catch (InvalidValueException e) {
						leftA_symbol__109 = createInvalidValue(e);
					}
					Object A_symbol__112 = leftA_symbol__109;
					Object rightA_symbol__109;
					try {
						
						org.eclipse.ocl.examples.pivot.OCLExpression unboxed_A_symbol__113 = unboxed_self != null ? unboxed_self.getSource() : null;
						Object A_symbol__113 = valueOf(unboxed_A_symbol__113); // OCLExpression
						
						
						org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__114 = unboxed_A_symbol__113 != null ? unboxed_A_symbol__113.getType() : null;
						Object A_symbol__114 = createTypeValue(unboxed_A_symbol__114);
						
						
						Object A_symbol__115 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__114, T_Metaclass_pivot__OrderedSetType_);
						rightA_symbol__109 = A_symbol__115;
					} catch (InvalidValueException e) {
						rightA_symbol__109 = createInvalidValue(e);
					}
					Object A_symbol__115 = rightA_symbol__109;
					Object A_symbol__109 = BooleanOrOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__112, A_symbol__115);
				Object A_symbol__116;
				if (A_symbol__109 == ValuesUtil.TRUE_VALUE) {
					
					org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__117 = unboxed_self != null ? unboxed_self.getType() : null;
					Object A_symbol__117 = createTypeValue(unboxed_A_symbol__117);
					
					
					Object A_symbol__118 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__117, T_Metaclass_pivot__SequenceType_);
					A_symbol__116 = A_symbol__118;
				}
				else if (A_symbol__109 == ValuesUtil.FALSE_VALUE) {
					
					org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__119 = unboxed_self != null ? unboxed_self.getType() : null;
					Object A_symbol__119 = createTypeValue(unboxed_A_symbol__119);
					
					
					Object A_symbol__120 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__119, T_Metaclass_pivot__BagType_);
					A_symbol__116 = A_symbol__120;
				}
				else {
					A_symbol__116 = createInvalidValue("non-Boolean if condition");
				}
				rightA_symbol__106 = A_symbol__116;
			} catch (InvalidValueException e) {
				rightA_symbol__106 = createInvalidValue(e);
			}
			Object A_symbol__116 = rightA_symbol__106;
			Object A_symbol__106 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__108, A_symbol__116);
			return A_symbol__106;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'ExistsBodyTypeIsBoolean' invariant.
	 */
	public static class _invariant_ExistsBodyTypeIsBoolean extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_ExistsBodyTypeIsBoolean INSTANCE = new _invariant_ExistsBodyTypeIsBoolean();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
		static final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
		static final @NonNull PrimitiveTypeId T_String = TypeId.STRING;
		static final @NonNull Object S_exists = "exists";
		static final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
		static final @NonNull TypeId T_Type = OCLstdlibTables.Types._Type.getTypeId();
		static final @NonNull TypeId T_pivot__OCLExpression = PivotTables.Types._OCLExpression.getTypeId();
		static final @NonNull Object T_Metaclass_Boolean_ = createTypeValue(OCLstdlibTables.Types._Boolean);
		
	
		/*
		name = 'exists' implies body.type = Boolean
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws InvalidValueException {
			assert self != null;
			final @NonNull IteratorExp unboxed_self = (IteratorExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			Object leftA_symbol__121;
			try {
				
				java.lang.String unboxed_A_symbol__122 = unboxed_self != null ? unboxed_self.getName() : null;
				Object A_symbol__122 = unboxed_A_symbol__122; // String
				
				
				Object A_symbol__123 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__122, S_exists);
				leftA_symbol__121 = A_symbol__123;
			} catch (InvalidValueException e) {
				leftA_symbol__121 = createInvalidValue(e);
			}
			Object A_symbol__123 = leftA_symbol__121;
			Object rightA_symbol__121;
			try {
				
				org.eclipse.ocl.examples.pivot.OCLExpression unboxed_A_symbol__124 = unboxed_self != null ? unboxed_self.getBody() : null;
				Object A_symbol__124 = valueOf(unboxed_A_symbol__124); // OCLExpression
				
				
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__125 = unboxed_A_symbol__124 != null ? unboxed_A_symbol__124.getType() : null;
				Object A_symbol__125 = createTypeValue(unboxed_A_symbol__125);
				
				
				DomainType static_A_symbol__126 = evaluator.getStaticTypeOf(A_symbol__125, T_Metaclass_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol__126 = (LibraryBinaryOperation)static_A_symbol__126.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Object A_symbol__126 = dynamic_A_symbol__126.evaluate(evaluator, T_Boolean, A_symbol__125, T_Metaclass_Boolean_);
				rightA_symbol__121 = A_symbol__126;
			} catch (InvalidValueException e) {
				rightA_symbol__121 = createInvalidValue(e);
			}
			Object A_symbol__126 = rightA_symbol__121;
			Object A_symbol__121 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__123, A_symbol__126);
			return A_symbol__121;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'ExistsTypeIsBoolean' invariant.
	 */
	public static class _invariant_ExistsTypeIsBoolean extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_ExistsTypeIsBoolean INSTANCE = new _invariant_ExistsTypeIsBoolean();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
		static final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
		static final @NonNull PrimitiveTypeId T_String = TypeId.STRING;
		static final @NonNull Object S_exists = "exists";
		static final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
		static final @NonNull TypeId T_Type = OCLstdlibTables.Types._Type.getTypeId();
		static final @NonNull Object T_Metaclass_Boolean_ = createTypeValue(OCLstdlibTables.Types._Boolean);
		
	
		/*
		name = 'exists' implies type = Boolean
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws InvalidValueException {
			assert self != null;
			final @NonNull IteratorExp unboxed_self = (IteratorExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			Object leftA_symbol__127;
			try {
				
				java.lang.String unboxed_A_symbol__128 = unboxed_self != null ? unboxed_self.getName() : null;
				Object A_symbol__128 = unboxed_A_symbol__128; // String
				
				
				Object A_symbol__129 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__128, S_exists);
				leftA_symbol__127 = A_symbol__129;
			} catch (InvalidValueException e) {
				leftA_symbol__127 = createInvalidValue(e);
			}
			Object A_symbol__129 = leftA_symbol__127;
			Object rightA_symbol__127;
			try {
				
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__130 = unboxed_self != null ? unboxed_self.getType() : null;
				Object A_symbol__130 = createTypeValue(unboxed_A_symbol__130);
				
				
				DomainType static_A_symbol__131 = evaluator.getStaticTypeOf(A_symbol__130, T_Metaclass_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol__131 = (LibraryBinaryOperation)static_A_symbol__131.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Object A_symbol__131 = dynamic_A_symbol__131.evaluate(evaluator, T_Boolean, A_symbol__130, T_Metaclass_Boolean_);
				rightA_symbol__127 = A_symbol__131;
			} catch (InvalidValueException e) {
				rightA_symbol__127 = createInvalidValue(e);
			}
			Object A_symbol__131 = rightA_symbol__127;
			Object A_symbol__127 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__129, A_symbol__131);
			return A_symbol__127;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'ForAllBodyTypeIsBoolean' invariant.
	 */
	public static class _invariant_ForAllBodyTypeIsBoolean extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_ForAllBodyTypeIsBoolean INSTANCE = new _invariant_ForAllBodyTypeIsBoolean();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
		static final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
		static final @NonNull PrimitiveTypeId T_String = TypeId.STRING;
		static final @NonNull Object S_forAll = "forAll";
		static final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
		static final @NonNull TypeId T_Type = OCLstdlibTables.Types._Type.getTypeId();
		static final @NonNull TypeId T_pivot__OCLExpression = PivotTables.Types._OCLExpression.getTypeId();
		static final @NonNull Object T_Metaclass_Boolean_ = createTypeValue(OCLstdlibTables.Types._Boolean);
		
	
		/*
		name = 'forAll' implies body.type = Boolean
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws InvalidValueException {
			assert self != null;
			final @NonNull IteratorExp unboxed_self = (IteratorExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			Object leftA_symbol__132;
			try {
				
				java.lang.String unboxed_A_symbol__133 = unboxed_self != null ? unboxed_self.getName() : null;
				Object A_symbol__133 = unboxed_A_symbol__133; // String
				
				
				Object A_symbol__134 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__133, S_forAll);
				leftA_symbol__132 = A_symbol__134;
			} catch (InvalidValueException e) {
				leftA_symbol__132 = createInvalidValue(e);
			}
			Object A_symbol__134 = leftA_symbol__132;
			Object rightA_symbol__132;
			try {
				
				org.eclipse.ocl.examples.pivot.OCLExpression unboxed_A_symbol__135 = unboxed_self != null ? unboxed_self.getBody() : null;
				Object A_symbol__135 = valueOf(unboxed_A_symbol__135); // OCLExpression
				
				
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__136 = unboxed_A_symbol__135 != null ? unboxed_A_symbol__135.getType() : null;
				Object A_symbol__136 = createTypeValue(unboxed_A_symbol__136);
				
				
				DomainType static_A_symbol__137 = evaluator.getStaticTypeOf(A_symbol__136, T_Metaclass_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol__137 = (LibraryBinaryOperation)static_A_symbol__137.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Object A_symbol__137 = dynamic_A_symbol__137.evaluate(evaluator, T_Boolean, A_symbol__136, T_Metaclass_Boolean_);
				rightA_symbol__132 = A_symbol__137;
			} catch (InvalidValueException e) {
				rightA_symbol__132 = createInvalidValue(e);
			}
			Object A_symbol__137 = rightA_symbol__132;
			Object A_symbol__132 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__134, A_symbol__137);
			return A_symbol__132;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'ForAllTypeIsBoolean' invariant.
	 */
	public static class _invariant_ForAllTypeIsBoolean extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_ForAllTypeIsBoolean INSTANCE = new _invariant_ForAllTypeIsBoolean();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
		static final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
		static final @NonNull PrimitiveTypeId T_String = TypeId.STRING;
		static final @NonNull Object S_forAll = "forAll";
		static final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
		static final @NonNull TypeId T_Type = OCLstdlibTables.Types._Type.getTypeId();
		static final @NonNull Object T_Metaclass_Boolean_ = createTypeValue(OCLstdlibTables.Types._Boolean);
		
	
		/*
		name = 'forAll' implies type = Boolean
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws InvalidValueException {
			assert self != null;
			final @NonNull IteratorExp unboxed_self = (IteratorExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			Object leftA_symbol__138;
			try {
				
				java.lang.String unboxed_A_symbol__139 = unboxed_self != null ? unboxed_self.getName() : null;
				Object A_symbol__139 = unboxed_A_symbol__139; // String
				
				
				Object A_symbol__140 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__139, S_forAll);
				leftA_symbol__138 = A_symbol__140;
			} catch (InvalidValueException e) {
				leftA_symbol__138 = createInvalidValue(e);
			}
			Object A_symbol__140 = leftA_symbol__138;
			Object rightA_symbol__138;
			try {
				
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__141 = unboxed_self != null ? unboxed_self.getType() : null;
				Object A_symbol__141 = createTypeValue(unboxed_A_symbol__141);
				
				
				DomainType static_A_symbol__142 = evaluator.getStaticTypeOf(A_symbol__141, T_Metaclass_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol__142 = (LibraryBinaryOperation)static_A_symbol__142.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Object A_symbol__142 = dynamic_A_symbol__142.evaluate(evaluator, T_Boolean, A_symbol__141, T_Metaclass_Boolean_);
				rightA_symbol__138 = A_symbol__142;
			} catch (InvalidValueException e) {
				rightA_symbol__138 = createInvalidValue(e);
			}
			Object A_symbol__142 = rightA_symbol__138;
			Object A_symbol__138 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__140, A_symbol__142);
			return A_symbol__138;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'IsUniqueHasOneIterator' invariant.
	 */
	public static class _invariant_IsUniqueHasOneIterator extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_IsUniqueHasOneIterator INSTANCE = new _invariant_IsUniqueHasOneIterator();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
		static final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
		static final @NonNull PrimitiveTypeId T_String = TypeId.STRING;
		static final @NonNull Object S_isUnique = "isUnique";
		static final @NonNull ExecutorOperation O_Real__eq_ = OCLstdlibTables.Operations._Real___eq_;
		static final @NonNull PrimitiveTypeId T_Integer = TypeId.INTEGER;
		static final @NonNull ExecutorOperation O_Collection_size = OCLstdlibTables.Operations._Collection__size;
		static final @NonNull TypeId T_pivot__Variable = PivotTables.Types._Variable.getTypeId();
		static final @NonNull CollectionTypeId T_OrderedSet_pivot__Variable_ = TypeId.ORDERED_SET.getSpecializedId(T_pivot__Variable);
		static final @NonNull IntegerValue I_1 = integerValueOf(1);
		
	
		/*
		name = 'isUnique' implies iterator->size() = 1
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws InvalidValueException {
			assert self != null;
			final @NonNull IteratorExp unboxed_self = (IteratorExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			Object leftA_symbol__143;
			try {
				
				java.lang.String unboxed_A_symbol__144 = unboxed_self != null ? unboxed_self.getName() : null;
				Object A_symbol__144 = unboxed_A_symbol__144; // String
				
				
				Object A_symbol__145 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__144, S_isUnique);
				leftA_symbol__143 = A_symbol__145;
			} catch (InvalidValueException e) {
				leftA_symbol__143 = createInvalidValue(e);
			}
			Object A_symbol__145 = leftA_symbol__143;
			Object rightA_symbol__143;
			try {
				
				org.eclipse.emf.common.util.EList<org.eclipse.ocl.examples.pivot.Variable> unboxed_A_symbol__146 = unboxed_self != null ? unboxed_self.getIterator() : null;
				assert unboxed_A_symbol__146 != null;
				final @NonNull Value A_symbol__146 = standardLibrary.createOrderedSetValueOf(T_OrderedSet_pivot__Variable_, unboxed_A_symbol__146);
				
				
				Object A_symbol__147 = CollectionSizeOperation.INSTANCE.evaluate(evaluator, T_Integer, A_symbol__146);
				Object A_symbol__148 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__147, I_1);
				rightA_symbol__143 = A_symbol__148;
			} catch (InvalidValueException e) {
				rightA_symbol__143 = createInvalidValue(e);
			}
			Object A_symbol__148 = rightA_symbol__143;
			Object A_symbol__143 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__145, A_symbol__148);
			return A_symbol__143;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'IsUniqueTypeIsBoolean' invariant.
	 */
	public static class _invariant_IsUniqueTypeIsBoolean extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_IsUniqueTypeIsBoolean INSTANCE = new _invariant_IsUniqueTypeIsBoolean();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
		static final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
		static final @NonNull PrimitiveTypeId T_String = TypeId.STRING;
		static final @NonNull Object S_isUnique = "isUnique";
		static final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
		static final @NonNull TypeId T_Type = OCLstdlibTables.Types._Type.getTypeId();
		static final @NonNull Object T_Metaclass_Boolean_ = createTypeValue(OCLstdlibTables.Types._Boolean);
		
	
		/*
		name = 'isUnique' implies type = Boolean
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws InvalidValueException {
			assert self != null;
			final @NonNull IteratorExp unboxed_self = (IteratorExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			Object leftA_symbol__149;
			try {
				
				java.lang.String unboxed_A_symbol__150 = unboxed_self != null ? unboxed_self.getName() : null;
				Object A_symbol__150 = unboxed_A_symbol__150; // String
				
				
				Object A_symbol__151 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__150, S_isUnique);
				leftA_symbol__149 = A_symbol__151;
			} catch (InvalidValueException e) {
				leftA_symbol__149 = createInvalidValue(e);
			}
			Object A_symbol__151 = leftA_symbol__149;
			Object rightA_symbol__149;
			try {
				
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__152 = unboxed_self != null ? unboxed_self.getType() : null;
				Object A_symbol__152 = createTypeValue(unboxed_A_symbol__152);
				
				
				DomainType static_A_symbol__153 = evaluator.getStaticTypeOf(A_symbol__152, T_Metaclass_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol__153 = (LibraryBinaryOperation)static_A_symbol__153.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Object A_symbol__153 = dynamic_A_symbol__153.evaluate(evaluator, T_Boolean, A_symbol__152, T_Metaclass_Boolean_);
				rightA_symbol__149 = A_symbol__153;
			} catch (InvalidValueException e) {
				rightA_symbol__149 = createInvalidValue(e);
			}
			Object A_symbol__153 = rightA_symbol__149;
			Object A_symbol__149 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__151, A_symbol__153);
			return A_symbol__149;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'IteratorTypeIsSourceElementType' invariant.
	 */
	public static class _invariant_IteratorTypeIsSourceElementType extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_IteratorTypeIsSourceElementType INSTANCE = new _invariant_IteratorTypeIsSourceElementType();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Collection_forAll = OCLstdlibTables.Operations._Collection__1_forAll;
		static final @NonNull TypeId T_pivot__Variable = PivotTables.Types._Variable.getTypeId();
		static final @NonNull CollectionTypeId T_OrderedSet_pivot__Variable_ = TypeId.ORDERED_SET.getSpecializedId(T_pivot__Variable);
		static final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
		static final @NonNull TypeId T_Type = OCLstdlibTables.Types._Type.getTypeId();
		static final @NonNull TypeId T_pivot__CollectionType = PivotTables.Types._CollectionType.getTypeId();
		static final @NonNull ExecutorOperation O_OclAny_oclAsType = OCLstdlibTables.Operations._OclAny__oclAsType;
		static final @NonNull TypeId T_pivot__OCLExpression = PivotTables.Types._OCLExpression.getTypeId();
		static final @NonNull Object T_Metaclass_pivot__CollectionType_ = createTypeValue(PivotTables.Types._CollectionType);
		
	
		/*
		self.iterator->forAll(type =
	  source.type.oclAsType(CollectionType).elementType)
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws InvalidValueException {
			assert self != null;
			final @NonNull IteratorExp unboxed_self = (IteratorExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			
			org.eclipse.emf.common.util.EList<org.eclipse.ocl.examples.pivot.Variable> unboxed_A_symbol__154 = unboxed_self != null ? unboxed_self.getIterator() : null;
			assert unboxed_A_symbol__154 != null;
			final @NonNull Value A_symbol__154 = standardLibrary.createOrderedSetValueOf(T_OrderedSet_pivot__Variable_, unboxed_A_symbol__154);
			
			
			
			assert A_symbol__154 != null;
			final @NonNull Iterator<?> A_symbol__155_iteratorVal = ((CollectionValue)A_symbol__154).iterator();
			Object V_1_ = null;	// iterator: 1_
			Object A_symbol__155;
			while (true) {
				if (!A_symbol__155_iteratorVal.hasNext()) {
					A_symbol__155 = TRUE_VALUE;
					break;
				}
				Object A_symbol__155_bodyVal;
				try {
					/*
						type = source.type.oclAsType(CollectionType).elementType
					*/
					V_1_ = A_symbol__155_iteratorVal.next();
					
					Variable unboxed_V_1_ = (Variable)V_1_;	// Variable
					org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__156 = unboxed_V_1_ != null ? unboxed_V_1_.getType() : null;
					Object A_symbol__156 = createTypeValue(unboxed_A_symbol__156);
					
					
					
					org.eclipse.ocl.examples.pivot.OCLExpression unboxed_A_symbol__157 = unboxed_self != null ? unboxed_self.getSource() : null;
					Object A_symbol__157 = valueOf(unboxed_A_symbol__157); // OCLExpression
					
					
					org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__158 = unboxed_A_symbol__157 != null ? unboxed_A_symbol__157.getType() : null;
					Object A_symbol__158 = createTypeValue(unboxed_A_symbol__158);
					
					
					Object A_symbol__159 = OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, T_pivot__CollectionType, A_symbol__158, T_Metaclass_pivot__CollectionType_);
					assert A_symbol__159 != null;
					CollectionType unboxed_A_symbol__159 = (CollectionType)((TypeValue)A_symbol__159).getInstanceType();
					org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__160 = unboxed_A_symbol__159 != null ? unboxed_A_symbol__159.getElementType() : null;
					Object A_symbol__160 = createTypeValue(unboxed_A_symbol__160);
					
					
					DomainType static_A_symbol__161 = evaluator.getStaticTypeOf(A_symbol__156, A_symbol__160);
					LibraryBinaryOperation dynamic_A_symbol__161 = (LibraryBinaryOperation)static_A_symbol__161.lookupImplementation(standardLibrary, O_OclAny__eq_);
					Object A_symbol__161 = dynamic_A_symbol__161.evaluate(evaluator, T_Boolean, A_symbol__156, A_symbol__160);
					A_symbol__155_bodyVal = A_symbol__161;
				} catch (Exception e) {
					A_symbol__155_bodyVal = createInvalidValue(e);
				}
				if (A_symbol__155_bodyVal == null) {
					A_symbol__155 = createInvalidValue(EvaluatorMessages.UndefinedBody, "forAll");
					break;
				}
				else if (A_symbol__155_bodyVal != TRUE_VALUE) {
					A_symbol__155 = FALSE_VALUE;			// Abort after a fail
					break;
				}
				
			}
			
			return A_symbol__155;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'OneBodyTypeIsBoolean' invariant.
	 */
	public static class _invariant_OneBodyTypeIsBoolean extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_OneBodyTypeIsBoolean INSTANCE = new _invariant_OneBodyTypeIsBoolean();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
		static final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
		static final @NonNull PrimitiveTypeId T_String = TypeId.STRING;
		static final @NonNull Object S_one = "one";
		static final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
		static final @NonNull TypeId T_Type = OCLstdlibTables.Types._Type.getTypeId();
		static final @NonNull TypeId T_pivot__OCLExpression = PivotTables.Types._OCLExpression.getTypeId();
		static final @NonNull Object T_Metaclass_Boolean_ = createTypeValue(OCLstdlibTables.Types._Boolean);
		
	
		/*
		name = 'one' implies body.type = Boolean
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws InvalidValueException {
			assert self != null;
			final @NonNull IteratorExp unboxed_self = (IteratorExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			Object leftA_symbol__162;
			try {
				
				java.lang.String unboxed_A_symbol__163 = unboxed_self != null ? unboxed_self.getName() : null;
				Object A_symbol__163 = unboxed_A_symbol__163; // String
				
				
				Object A_symbol__164 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__163, S_one);
				leftA_symbol__162 = A_symbol__164;
			} catch (InvalidValueException e) {
				leftA_symbol__162 = createInvalidValue(e);
			}
			Object A_symbol__164 = leftA_symbol__162;
			Object rightA_symbol__162;
			try {
				
				org.eclipse.ocl.examples.pivot.OCLExpression unboxed_A_symbol__165 = unboxed_self != null ? unboxed_self.getBody() : null;
				Object A_symbol__165 = valueOf(unboxed_A_symbol__165); // OCLExpression
				
				
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__166 = unboxed_A_symbol__165 != null ? unboxed_A_symbol__165.getType() : null;
				Object A_symbol__166 = createTypeValue(unboxed_A_symbol__166);
				
				
				DomainType static_A_symbol__167 = evaluator.getStaticTypeOf(A_symbol__166, T_Metaclass_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol__167 = (LibraryBinaryOperation)static_A_symbol__167.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Object A_symbol__167 = dynamic_A_symbol__167.evaluate(evaluator, T_Boolean, A_symbol__166, T_Metaclass_Boolean_);
				rightA_symbol__162 = A_symbol__167;
			} catch (InvalidValueException e) {
				rightA_symbol__162 = createInvalidValue(e);
			}
			Object A_symbol__167 = rightA_symbol__162;
			Object A_symbol__162 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__164, A_symbol__167);
			return A_symbol__162;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'OneHasOneIterator' invariant.
	 */
	public static class _invariant_OneHasOneIterator extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_OneHasOneIterator INSTANCE = new _invariant_OneHasOneIterator();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
		static final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
		static final @NonNull PrimitiveTypeId T_String = TypeId.STRING;
		static final @NonNull Object S_one = "one";
		static final @NonNull ExecutorOperation O_Real__eq_ = OCLstdlibTables.Operations._Real___eq_;
		static final @NonNull PrimitiveTypeId T_Integer = TypeId.INTEGER;
		static final @NonNull ExecutorOperation O_Collection_size = OCLstdlibTables.Operations._Collection__size;
		static final @NonNull TypeId T_pivot__Variable = PivotTables.Types._Variable.getTypeId();
		static final @NonNull CollectionTypeId T_OrderedSet_pivot__Variable_ = TypeId.ORDERED_SET.getSpecializedId(T_pivot__Variable);
		static final @NonNull IntegerValue I_1 = integerValueOf(1);
		
	
		/*
		name = 'one' implies iterator->size() = 1
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws InvalidValueException {
			assert self != null;
			final @NonNull IteratorExp unboxed_self = (IteratorExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			Object leftA_symbol__168;
			try {
				
				java.lang.String unboxed_A_symbol__169 = unboxed_self != null ? unboxed_self.getName() : null;
				Object A_symbol__169 = unboxed_A_symbol__169; // String
				
				
				Object A_symbol__170 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__169, S_one);
				leftA_symbol__168 = A_symbol__170;
			} catch (InvalidValueException e) {
				leftA_symbol__168 = createInvalidValue(e);
			}
			Object A_symbol__170 = leftA_symbol__168;
			Object rightA_symbol__168;
			try {
				
				org.eclipse.emf.common.util.EList<org.eclipse.ocl.examples.pivot.Variable> unboxed_A_symbol__171 = unboxed_self != null ? unboxed_self.getIterator() : null;
				assert unboxed_A_symbol__171 != null;
				final @NonNull Value A_symbol__171 = standardLibrary.createOrderedSetValueOf(T_OrderedSet_pivot__Variable_, unboxed_A_symbol__171);
				
				
				Object A_symbol__172 = CollectionSizeOperation.INSTANCE.evaluate(evaluator, T_Integer, A_symbol__171);
				Object A_symbol__173 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__172, I_1);
				rightA_symbol__168 = A_symbol__173;
			} catch (InvalidValueException e) {
				rightA_symbol__168 = createInvalidValue(e);
			}
			Object A_symbol__173 = rightA_symbol__168;
			Object A_symbol__168 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__170, A_symbol__173);
			return A_symbol__168;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'OneTypeIsBoolean' invariant.
	 */
	public static class _invariant_OneTypeIsBoolean extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_OneTypeIsBoolean INSTANCE = new _invariant_OneTypeIsBoolean();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
		static final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
		static final @NonNull PrimitiveTypeId T_String = TypeId.STRING;
		static final @NonNull Object S_one = "one";
		static final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
		static final @NonNull TypeId T_Type = OCLstdlibTables.Types._Type.getTypeId();
		static final @NonNull Object T_Metaclass_Boolean_ = createTypeValue(OCLstdlibTables.Types._Boolean);
		
	
		/*
		name = 'one' implies type = Boolean
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws InvalidValueException {
			assert self != null;
			final @NonNull IteratorExp unboxed_self = (IteratorExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			Object leftA_symbol__174;
			try {
				
				java.lang.String unboxed_A_symbol__175 = unboxed_self != null ? unboxed_self.getName() : null;
				Object A_symbol__175 = unboxed_A_symbol__175; // String
				
				
				Object A_symbol__176 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__175, S_one);
				leftA_symbol__174 = A_symbol__176;
			} catch (InvalidValueException e) {
				leftA_symbol__174 = createInvalidValue(e);
			}
			Object A_symbol__176 = leftA_symbol__174;
			Object rightA_symbol__174;
			try {
				
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__177 = unboxed_self != null ? unboxed_self.getType() : null;
				Object A_symbol__177 = createTypeValue(unboxed_A_symbol__177);
				
				
				DomainType static_A_symbol__178 = evaluator.getStaticTypeOf(A_symbol__177, T_Metaclass_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol__178 = (LibraryBinaryOperation)static_A_symbol__178.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Object A_symbol__178 = dynamic_A_symbol__178.evaluate(evaluator, T_Boolean, A_symbol__177, T_Metaclass_Boolean_);
				rightA_symbol__174 = A_symbol__178;
			} catch (InvalidValueException e) {
				rightA_symbol__174 = createInvalidValue(e);
			}
			Object A_symbol__178 = rightA_symbol__174;
			Object A_symbol__174 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__176, A_symbol__178);
			return A_symbol__174;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'RejectOrSelectHasOneIterator' invariant.
	 */
	public static class _invariant_RejectOrSelectHasOneIterator extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_RejectOrSelectHasOneIterator INSTANCE = new _invariant_RejectOrSelectHasOneIterator();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
		static final @NonNull ExecutorOperation O_Boolean_or = OCLstdlibTables.Operations._Boolean__or;
		static final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
		static final @NonNull PrimitiveTypeId T_String = TypeId.STRING;
		static final @NonNull Object S_reject = "reject";
		static final @NonNull Object S_select = "select";
		static final @NonNull ExecutorOperation O_Real__eq_ = OCLstdlibTables.Operations._Real___eq_;
		static final @NonNull PrimitiveTypeId T_Integer = TypeId.INTEGER;
		static final @NonNull ExecutorOperation O_Collection_size = OCLstdlibTables.Operations._Collection__size;
		static final @NonNull TypeId T_pivot__Variable = PivotTables.Types._Variable.getTypeId();
		static final @NonNull CollectionTypeId T_OrderedSet_pivot__Variable_ = TypeId.ORDERED_SET.getSpecializedId(T_pivot__Variable);
		static final @NonNull IntegerValue I_1 = integerValueOf(1);
		
	
		/*
		name = 'reject' or name = 'select' implies iterator->size() = 1
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws InvalidValueException {
			assert self != null;
			final @NonNull IteratorExp unboxed_self = (IteratorExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			Object leftA_symbol__179;
			try {
				Object leftA_symbol__180;
				try {
					
					java.lang.String unboxed_A_symbol__181 = unboxed_self != null ? unboxed_self.getName() : null;
					Object A_symbol__181 = unboxed_A_symbol__181; // String
					
					
					Object A_symbol__182 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__181, S_reject);
					leftA_symbol__180 = A_symbol__182;
				} catch (InvalidValueException e) {
					leftA_symbol__180 = createInvalidValue(e);
				}
				Object A_symbol__182 = leftA_symbol__180;
				Object rightA_symbol__180;
				try {
					
					java.lang.String unboxed_A_symbol__183 = unboxed_self != null ? unboxed_self.getName() : null;
					Object A_symbol__183 = unboxed_A_symbol__183; // String
					
					
					Object A_symbol__184 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__183, S_select);
					rightA_symbol__180 = A_symbol__184;
				} catch (InvalidValueException e) {
					rightA_symbol__180 = createInvalidValue(e);
				}
				Object A_symbol__184 = rightA_symbol__180;
				Object A_symbol__180 = BooleanOrOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__182, A_symbol__184);
				leftA_symbol__179 = A_symbol__180;
			} catch (InvalidValueException e) {
				leftA_symbol__179 = createInvalidValue(e);
			}
			Object A_symbol__180 = leftA_symbol__179;
			Object rightA_symbol__179;
			try {
				
				org.eclipse.emf.common.util.EList<org.eclipse.ocl.examples.pivot.Variable> unboxed_A_symbol__185 = unboxed_self != null ? unboxed_self.getIterator() : null;
				assert unboxed_A_symbol__185 != null;
				final @NonNull Value A_symbol__185 = standardLibrary.createOrderedSetValueOf(T_OrderedSet_pivot__Variable_, unboxed_A_symbol__185);
				
				
				Object A_symbol__186 = CollectionSizeOperation.INSTANCE.evaluate(evaluator, T_Integer, A_symbol__185);
				Object A_symbol__187 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__186, I_1);
				rightA_symbol__179 = A_symbol__187;
			} catch (InvalidValueException e) {
				rightA_symbol__179 = createInvalidValue(e);
			}
			Object A_symbol__187 = rightA_symbol__179;
			Object A_symbol__179 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__180, A_symbol__187);
			return A_symbol__179;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'RejectOrSelectTypeIsBoolean' invariant.
	 */
	public static class _invariant_RejectOrSelectTypeIsBoolean extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_RejectOrSelectTypeIsBoolean INSTANCE = new _invariant_RejectOrSelectTypeIsBoolean();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
		static final @NonNull ExecutorOperation O_Boolean_or = OCLstdlibTables.Operations._Boolean__or;
		static final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
		static final @NonNull PrimitiveTypeId T_String = TypeId.STRING;
		static final @NonNull Object S_reject = "reject";
		static final @NonNull Object S_select = "select";
		static final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
		static final @NonNull TypeId T_Type = OCLstdlibTables.Types._Type.getTypeId();
		static final @NonNull Object T_Metaclass_Boolean_ = createTypeValue(OCLstdlibTables.Types._Boolean);
		
	
		/*
		name = 'reject' or name = 'select' implies type = Boolean
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws InvalidValueException {
			assert self != null;
			final @NonNull IteratorExp unboxed_self = (IteratorExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			Object leftA_symbol__188;
			try {
				Object leftA_symbol__189;
				try {
					
					java.lang.String unboxed_A_symbol__190 = unboxed_self != null ? unboxed_self.getName() : null;
					Object A_symbol__190 = unboxed_A_symbol__190; // String
					
					
					Object A_symbol__191 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__190, S_reject);
					leftA_symbol__189 = A_symbol__191;
				} catch (InvalidValueException e) {
					leftA_symbol__189 = createInvalidValue(e);
				}
				Object A_symbol__191 = leftA_symbol__189;
				Object rightA_symbol__189;
				try {
					
					java.lang.String unboxed_A_symbol__192 = unboxed_self != null ? unboxed_self.getName() : null;
					Object A_symbol__192 = unboxed_A_symbol__192; // String
					
					
					Object A_symbol__193 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__192, S_select);
					rightA_symbol__189 = A_symbol__193;
				} catch (InvalidValueException e) {
					rightA_symbol__189 = createInvalidValue(e);
				}
				Object A_symbol__193 = rightA_symbol__189;
				Object A_symbol__189 = BooleanOrOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__191, A_symbol__193);
				leftA_symbol__188 = A_symbol__189;
			} catch (InvalidValueException e) {
				leftA_symbol__188 = createInvalidValue(e);
			}
			Object A_symbol__189 = leftA_symbol__188;
			Object rightA_symbol__188;
			try {
				
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__194 = unboxed_self != null ? unboxed_self.getType() : null;
				Object A_symbol__194 = createTypeValue(unboxed_A_symbol__194);
				
				
				DomainType static_A_symbol__195 = evaluator.getStaticTypeOf(A_symbol__194, T_Metaclass_Boolean_);
				LibraryBinaryOperation dynamic_A_symbol__195 = (LibraryBinaryOperation)static_A_symbol__195.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Object A_symbol__195 = dynamic_A_symbol__195.evaluate(evaluator, T_Boolean, A_symbol__194, T_Metaclass_Boolean_);
				rightA_symbol__188 = A_symbol__195;
			} catch (InvalidValueException e) {
				rightA_symbol__188 = createInvalidValue(e);
			}
			Object A_symbol__195 = rightA_symbol__188;
			Object A_symbol__188 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__189, A_symbol__195);
			return A_symbol__188;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'RejectOrSelectTypeIsSourceType' invariant.
	 */
	public static class _invariant_RejectOrSelectTypeIsSourceType extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_RejectOrSelectTypeIsSourceType INSTANCE = new _invariant_RejectOrSelectTypeIsSourceType();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
		static final @NonNull ExecutorOperation O_Boolean_or = OCLstdlibTables.Operations._Boolean__or;
		static final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
		static final @NonNull PrimitiveTypeId T_String = TypeId.STRING;
		static final @NonNull Object S_reject = "reject";
		static final @NonNull Object S_select = "select";
		static final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
		static final @NonNull TypeId T_Type = OCLstdlibTables.Types._Type.getTypeId();
		static final @NonNull TypeId T_pivot__OCLExpression = PivotTables.Types._OCLExpression.getTypeId();
		
	
		/*
		name = 'reject' or name = 'select' implies type = source.type
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws InvalidValueException {
			assert self != null;
			final @NonNull IteratorExp unboxed_self = (IteratorExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			Object leftA_symbol__196;
			try {
				Object leftA_symbol__197;
				try {
					
					java.lang.String unboxed_A_symbol__198 = unboxed_self != null ? unboxed_self.getName() : null;
					Object A_symbol__198 = unboxed_A_symbol__198; // String
					
					
					Object A_symbol__199 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__198, S_reject);
					leftA_symbol__197 = A_symbol__199;
				} catch (InvalidValueException e) {
					leftA_symbol__197 = createInvalidValue(e);
				}
				Object A_symbol__199 = leftA_symbol__197;
				Object rightA_symbol__197;
				try {
					
					java.lang.String unboxed_A_symbol__200 = unboxed_self != null ? unboxed_self.getName() : null;
					Object A_symbol__200 = unboxed_A_symbol__200; // String
					
					
					Object A_symbol__201 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__200, S_select);
					rightA_symbol__197 = A_symbol__201;
				} catch (InvalidValueException e) {
					rightA_symbol__197 = createInvalidValue(e);
				}
				Object A_symbol__201 = rightA_symbol__197;
				Object A_symbol__197 = BooleanOrOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__199, A_symbol__201);
				leftA_symbol__196 = A_symbol__197;
			} catch (InvalidValueException e) {
				leftA_symbol__196 = createInvalidValue(e);
			}
			Object A_symbol__197 = leftA_symbol__196;
			Object rightA_symbol__196;
			try {
				
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__202 = unboxed_self != null ? unboxed_self.getType() : null;
				Object A_symbol__202 = createTypeValue(unboxed_A_symbol__202);
				
				
				
				org.eclipse.ocl.examples.pivot.OCLExpression unboxed_A_symbol__203 = unboxed_self != null ? unboxed_self.getSource() : null;
				Object A_symbol__203 = valueOf(unboxed_A_symbol__203); // OCLExpression
				
				
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__204 = unboxed_A_symbol__203 != null ? unboxed_A_symbol__203.getType() : null;
				Object A_symbol__204 = createTypeValue(unboxed_A_symbol__204);
				
				
				DomainType static_A_symbol__205 = evaluator.getStaticTypeOf(A_symbol__202, A_symbol__204);
				LibraryBinaryOperation dynamic_A_symbol__205 = (LibraryBinaryOperation)static_A_symbol__205.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Object A_symbol__205 = dynamic_A_symbol__205.evaluate(evaluator, T_Boolean, A_symbol__202, A_symbol__204);
				rightA_symbol__196 = A_symbol__205;
			} catch (InvalidValueException e) {
				rightA_symbol__196 = createInvalidValue(e);
			}
			Object A_symbol__205 = rightA_symbol__196;
			Object A_symbol__196 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__197, A_symbol__205);
			return A_symbol__196;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'SortedByElementTypeIsSourceElementType' invariant.
	 */
	public static class _invariant_SortedByElementTypeIsSourceElementType extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_SortedByElementTypeIsSourceElementType INSTANCE = new _invariant_SortedByElementTypeIsSourceElementType();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
		static final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
		static final @NonNull PrimitiveTypeId T_String = TypeId.STRING;
		static final @NonNull Object S_sortedBy = "sortedBy";
		static final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
		static final @NonNull TypeId T_Type = OCLstdlibTables.Types._Type.getTypeId();
		static final @NonNull TypeId T_pivot__CollectionType = PivotTables.Types._CollectionType.getTypeId();
		static final @NonNull ExecutorOperation O_OclAny_oclAsType = OCLstdlibTables.Operations._OclAny__oclAsType;
		static final @NonNull Object T_Metaclass_pivot__CollectionType_ = createTypeValue(PivotTables.Types._CollectionType);
		static final @NonNull TypeId T_pivot__OCLExpression = PivotTables.Types._OCLExpression.getTypeId();
		
	
		/*
		name = 'sortedBy' implies
	type.oclAsType(CollectionType).elementType =
	body.type.oclAsType(CollectionType).elementType
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws InvalidValueException {
			assert self != null;
			final @NonNull IteratorExp unboxed_self = (IteratorExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			Object leftA_symbol__206;
			try {
				
				java.lang.String unboxed_A_symbol__207 = unboxed_self != null ? unboxed_self.getName() : null;
				Object A_symbol__207 = unboxed_A_symbol__207; // String
				
				
				Object A_symbol__208 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__207, S_sortedBy);
				leftA_symbol__206 = A_symbol__208;
			} catch (InvalidValueException e) {
				leftA_symbol__206 = createInvalidValue(e);
			}
			Object A_symbol__208 = leftA_symbol__206;
			Object rightA_symbol__206;
			try {
				
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__209 = unboxed_self != null ? unboxed_self.getType() : null;
				Object A_symbol__209 = createTypeValue(unboxed_A_symbol__209);
				
				
				Object A_symbol__210 = OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, T_pivot__CollectionType, A_symbol__209, T_Metaclass_pivot__CollectionType_);
				assert A_symbol__210 != null;
				CollectionType unboxed_A_symbol__210 = (CollectionType)((TypeValue)A_symbol__210).getInstanceType();
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__211 = unboxed_A_symbol__210 != null ? unboxed_A_symbol__210.getElementType() : null;
				Object A_symbol__211 = createTypeValue(unboxed_A_symbol__211);
				
				
				
				org.eclipse.ocl.examples.pivot.OCLExpression unboxed_A_symbol__212 = unboxed_self != null ? unboxed_self.getBody() : null;
				Object A_symbol__212 = valueOf(unboxed_A_symbol__212); // OCLExpression
				
				
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__213 = unboxed_A_symbol__212 != null ? unboxed_A_symbol__212.getType() : null;
				Object A_symbol__213 = createTypeValue(unboxed_A_symbol__213);
				
				
				Object A_symbol__214 = OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, T_pivot__CollectionType, A_symbol__213, T_Metaclass_pivot__CollectionType_);
				assert A_symbol__214 != null;
				CollectionType unboxed_A_symbol__214 = (CollectionType)((TypeValue)A_symbol__214).getInstanceType();
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__215 = unboxed_A_symbol__214 != null ? unboxed_A_symbol__214.getElementType() : null;
				Object A_symbol__215 = createTypeValue(unboxed_A_symbol__215);
				
				
				DomainType static_A_symbol__216 = evaluator.getStaticTypeOf(A_symbol__211, A_symbol__215);
				LibraryBinaryOperation dynamic_A_symbol__216 = (LibraryBinaryOperation)static_A_symbol__216.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Object A_symbol__216 = dynamic_A_symbol__216.evaluate(evaluator, T_Boolean, A_symbol__211, A_symbol__215);
				rightA_symbol__206 = A_symbol__216;
			} catch (InvalidValueException e) {
				rightA_symbol__206 = createInvalidValue(e);
			}
			Object A_symbol__216 = rightA_symbol__206;
			Object A_symbol__206 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__208, A_symbol__216);
			return A_symbol__206;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'SortedByHasOneIterator' invariant.
	 */
	public static class _invariant_SortedByHasOneIterator extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_SortedByHasOneIterator INSTANCE = new _invariant_SortedByHasOneIterator();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
		static final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
		static final @NonNull PrimitiveTypeId T_String = TypeId.STRING;
		static final @NonNull Object S_sortedBy = "sortedBy";
		static final @NonNull ExecutorOperation O_Real__eq_ = OCLstdlibTables.Operations._Real___eq_;
		static final @NonNull PrimitiveTypeId T_Integer = TypeId.INTEGER;
		static final @NonNull ExecutorOperation O_Collection_size = OCLstdlibTables.Operations._Collection__size;
		static final @NonNull TypeId T_pivot__Variable = PivotTables.Types._Variable.getTypeId();
		static final @NonNull CollectionTypeId T_OrderedSet_pivot__Variable_ = TypeId.ORDERED_SET.getSpecializedId(T_pivot__Variable);
		static final @NonNull IntegerValue I_1 = integerValueOf(1);
		
	
		/*
		name = 'sortedBy' implies iterator->size() = 1
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws InvalidValueException {
			assert self != null;
			final @NonNull IteratorExp unboxed_self = (IteratorExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			Object leftA_symbol__217;
			try {
				
				java.lang.String unboxed_A_symbol__218 = unboxed_self != null ? unboxed_self.getName() : null;
				Object A_symbol__218 = unboxed_A_symbol__218; // String
				
				
				Object A_symbol__219 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__218, S_sortedBy);
				leftA_symbol__217 = A_symbol__219;
			} catch (InvalidValueException e) {
				leftA_symbol__217 = createInvalidValue(e);
			}
			Object A_symbol__219 = leftA_symbol__217;
			Object rightA_symbol__217;
			try {
				
				org.eclipse.emf.common.util.EList<org.eclipse.ocl.examples.pivot.Variable> unboxed_A_symbol__220 = unboxed_self != null ? unboxed_self.getIterator() : null;
				assert unboxed_A_symbol__220 != null;
				final @NonNull Value A_symbol__220 = standardLibrary.createOrderedSetValueOf(T_OrderedSet_pivot__Variable_, unboxed_A_symbol__220);
				
				
				Object A_symbol__221 = CollectionSizeOperation.INSTANCE.evaluate(evaluator, T_Integer, A_symbol__220);
				Object A_symbol__222 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__221, I_1);
				rightA_symbol__217 = A_symbol__222;
			} catch (InvalidValueException e) {
				rightA_symbol__217 = createInvalidValue(e);
			}
			Object A_symbol__222 = rightA_symbol__217;
			Object A_symbol__217 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__219, A_symbol__222);
			return A_symbol__217;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'SortedByIsOrderedIfSourceIsOrdered' invariant.
	 */
	public static class _invariant_SortedByIsOrderedIfSourceIsOrdered extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_SortedByIsOrderedIfSourceIsOrdered INSTANCE = new _invariant_SortedByIsOrderedIfSourceIsOrdered();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
		static final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
		static final @NonNull PrimitiveTypeId T_String = TypeId.STRING;
		static final @NonNull Object S_sortedBy = "sortedBy";
		static final @NonNull ExecutorOperation O_Boolean_or = OCLstdlibTables.Operations._Boolean__or;
		static final @NonNull ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
		static final @NonNull TypeId T_Type = OCLstdlibTables.Types._Type.getTypeId();
		static final @NonNull TypeId T_pivot__OCLExpression = PivotTables.Types._OCLExpression.getTypeId();
		static final @NonNull Object T_Metaclass_pivot__SequenceType_ = createTypeValue(PivotTables.Types._SequenceType);
		static final @NonNull Object T_Metaclass_pivot__BagType_ = createTypeValue(PivotTables.Types._BagType);
		static final @NonNull Object T_Metaclass_pivot__OrderedSetType_ = createTypeValue(PivotTables.Types._OrderedSetType);
		
	
		/*
		name = 'sortedBy' implies
	if
	  source.type.oclIsKindOf(SequenceType) or
	  source.type.oclIsKindOf(BagType)
	then type.oclIsKindOf(SequenceType)
	else type.oclIsKindOf(OrderedSetType)
	endif
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws InvalidValueException {
			assert self != null;
			final @NonNull IteratorExp unboxed_self = (IteratorExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			Object leftA_symbol__223;
			try {
				
				java.lang.String unboxed_A_symbol__224 = unboxed_self != null ? unboxed_self.getName() : null;
				Object A_symbol__224 = unboxed_A_symbol__224; // String
				
				
				Object A_symbol__225 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__224, S_sortedBy);
				leftA_symbol__223 = A_symbol__225;
			} catch (InvalidValueException e) {
				leftA_symbol__223 = createInvalidValue(e);
			}
			Object A_symbol__225 = leftA_symbol__223;
			Object rightA_symbol__223;
			try {
					Object leftA_symbol__226;
					try {
						
						org.eclipse.ocl.examples.pivot.OCLExpression unboxed_A_symbol__227 = unboxed_self != null ? unboxed_self.getSource() : null;
						Object A_symbol__227 = valueOf(unboxed_A_symbol__227); // OCLExpression
						
						
						org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__228 = unboxed_A_symbol__227 != null ? unboxed_A_symbol__227.getType() : null;
						Object A_symbol__228 = createTypeValue(unboxed_A_symbol__228);
						
						
						Object A_symbol__229 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__228, T_Metaclass_pivot__SequenceType_);
						leftA_symbol__226 = A_symbol__229;
					} catch (InvalidValueException e) {
						leftA_symbol__226 = createInvalidValue(e);
					}
					Object A_symbol__229 = leftA_symbol__226;
					Object rightA_symbol__226;
					try {
						
						org.eclipse.ocl.examples.pivot.OCLExpression unboxed_A_symbol__230 = unboxed_self != null ? unboxed_self.getSource() : null;
						Object A_symbol__230 = valueOf(unboxed_A_symbol__230); // OCLExpression
						
						
						org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__231 = unboxed_A_symbol__230 != null ? unboxed_A_symbol__230.getType() : null;
						Object A_symbol__231 = createTypeValue(unboxed_A_symbol__231);
						
						
						Object A_symbol__232 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__231, T_Metaclass_pivot__BagType_);
						rightA_symbol__226 = A_symbol__232;
					} catch (InvalidValueException e) {
						rightA_symbol__226 = createInvalidValue(e);
					}
					Object A_symbol__232 = rightA_symbol__226;
					Object A_symbol__226 = BooleanOrOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__229, A_symbol__232);
				Object A_symbol__233;
				if (A_symbol__226 == ValuesUtil.TRUE_VALUE) {
					
					org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__234 = unboxed_self != null ? unboxed_self.getType() : null;
					Object A_symbol__234 = createTypeValue(unboxed_A_symbol__234);
					
					
					Object A_symbol__235 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__234, T_Metaclass_pivot__SequenceType_);
					A_symbol__233 = A_symbol__235;
				}
				else if (A_symbol__226 == ValuesUtil.FALSE_VALUE) {
					
					org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__236 = unboxed_self != null ? unboxed_self.getType() : null;
					Object A_symbol__236 = createTypeValue(unboxed_A_symbol__236);
					
					
					Object A_symbol__237 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__236, T_Metaclass_pivot__OrderedSetType_);
					A_symbol__233 = A_symbol__237;
				}
				else {
					A_symbol__233 = createInvalidValue("non-Boolean if condition");
				}
				rightA_symbol__223 = A_symbol__233;
			} catch (InvalidValueException e) {
				rightA_symbol__223 = createInvalidValue(e);
			}
			Object A_symbol__233 = rightA_symbol__223;
			Object A_symbol__223 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__225, A_symbol__233);
			return A_symbol__223;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'SortedByIteratorTypeIsComparable' invariant.
	 */
	public static class _invariant_SortedByIteratorTypeIsComparable extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_SortedByIteratorTypeIsComparable INSTANCE = new _invariant_SortedByIteratorTypeIsComparable();
		static final @NonNull Object True = true;
		
	
		/*
		true
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws InvalidValueException {
			assert self != null;
			final @NonNull IteratorExp unboxed_self = (IteratorExp)self;
			
			
			return True;
		}
	}
}

