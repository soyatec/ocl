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
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.PrimitiveTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractUnaryOperation;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.library.collection.CollectionSizeOperation;
import org.eclipse.ocl.examples.library.executor.ExecutorOperation;
import org.eclipse.ocl.examples.library.integer.IntegerPlusOperation;
import org.eclipse.ocl.examples.library.logical.BooleanNotOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyOclAsSetOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.examples.pivot.MessageExp;
import org.eclipse.ocl.examples.pivot.PivotTables;

/**
 * MessageExpBodies provides the Java implementation bodies of OCL-defined MessageExp operations and properties.
 */
@SuppressWarnings({"nls", "null", "unused"})
public class MessageExpBodies
{

	/** 
	 * Implementation of the MessageExp 'OneCallOrOneSend' invariant.
	 */
	public static class _invariant_OneCallOrOneSend extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_OneCallOrOneSend INSTANCE = new _invariant_OneCallOrOneSend();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Real__eq_ = OCLstdlibTables.Operations._Real___eq_;
		static final @NonNull PrimitiveTypeId T_Integer = TypeId.INTEGER;
		static final @NonNull ExecutorOperation O_Integer__add_ = OCLstdlibTables.Operations._Integer___add_;
		static final @NonNull ExecutorOperation O_Collection_size = OCLstdlibTables.Operations._Collection__size;
		static final @NonNull TypeId T_pivot__CallOperationAction = PivotTables.Types._CallOperationAction.getTypeId();
		static final @NonNull CollectionTypeId T_Set_pivot__CallOperationAction_ = TypeId.SET.getSpecializedId(T_pivot__CallOperationAction);
		static final @NonNull ExecutorOperation O_OclAny_oclAsSet = OCLstdlibTables.Operations._OclAny__oclAsSet;
		static final @NonNull TypeId T_pivot__SendSignalAction = PivotTables.Types._SendSignalAction.getTypeId();
		static final @NonNull CollectionTypeId T_Set_pivot__SendSignalAction_ = TypeId.SET.getSpecializedId(T_pivot__SendSignalAction);
		static final @NonNull IntegerValue I_1 = integerValueOf(1);
		
	
		/*
		calledOperation->size() + sentSignal->size() = 1
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
			assert self != null;
			final @NonNull MessageExp unboxed_self = (MessageExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			
			if (self == null) { throw new InvalidValueException("Null property source"); }
			org.eclipse.ocl.examples.pivot.CallOperationAction unboxed_A_symbol_ = unboxed_self.getCalledOperation();
			Object A_symbol_ = valueOf(unboxed_A_symbol_); // CallOperationAction
			
			
			Object A_symbol__1 = OclAnyOclAsSetOperation.INSTANCE.evaluate(evaluator, T_Set_pivot__CallOperationAction_, A_symbol_);
			Object A_symbol__2 = CollectionSizeOperation.INSTANCE.evaluate(evaluator, T_Integer, A_symbol__1);
			
			if (self == null) { throw new InvalidValueException("Null property source"); }
			org.eclipse.ocl.examples.pivot.SendSignalAction unboxed_A_symbol__3 = unboxed_self.getSentSignal();
			Object A_symbol__3 = valueOf(unboxed_A_symbol__3); // SendSignalAction
			
			
			Object A_symbol__4 = OclAnyOclAsSetOperation.INSTANCE.evaluate(evaluator, T_Set_pivot__SendSignalAction_, A_symbol__3);
			Object A_symbol__5 = CollectionSizeOperation.INSTANCE.evaluate(evaluator, T_Integer, A_symbol__4);
			Object A_symbol__6 = IntegerPlusOperation.INSTANCE.evaluate(evaluator, T_Integer, A_symbol__2, A_symbol__5);
			Object A_symbol__7 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__6, I_1);
			return A_symbol__7;
		}
	}

	/** 
	 * Implementation of the MessageExp 'TargetIsNotACollection' invariant.
	 */
	public static class _invariant_TargetIsNotACollection extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_TargetIsNotACollection INSTANCE = new _invariant_TargetIsNotACollection();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Boolean_not = OCLstdlibTables.Operations._Boolean__not;
		static final @NonNull ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
		static final @NonNull TypeId T_Type = OCLstdlibTables.Types._Type.getTypeId();
		static final @NonNull TypeId T_pivot__OCLExpression = PivotTables.Types._OCLExpression.getTypeId();
		static final @NonNull Object T_Metaclass_pivot__CollectionType_ = createTypeValue(PivotTables.Types._CollectionType);
		
	
		/*
		not target.type.oclIsKindOf(CollectionType)
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
			assert self != null;
			final @NonNull MessageExp unboxed_self = (MessageExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			
			if (self == null) { throw new InvalidValueException("Null property source"); }
			org.eclipse.ocl.examples.pivot.OCLExpression unboxed_A_symbol__8 = unboxed_self.getTarget();
			Object A_symbol__8 = valueOf(unboxed_A_symbol__8); // OCLExpression
			
			
			if (A_symbol__8 == null) { throw new InvalidValueException("Null property source"); }
			org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__9 = unboxed_A_symbol__8.getType();
			Object A_symbol__9 = createTypeValue(unboxed_A_symbol__9);
			
			
			Object A_symbol__10 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__9, T_Metaclass_pivot__CollectionType_);
			Object A_symbol__11 = BooleanNotOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__10);
			return A_symbol__11;
		}
	}




}

