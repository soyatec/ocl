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
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.library.collection.CollectionSizeOperation;
import org.eclipse.ocl.examples.library.executor.ExecutorOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.PivotTables;

/**
 * OperationCallExpBodies provides the Java implementation bodies of OCL-defined OperationCallExp operations and properties.
 */
@SuppressWarnings("nls")
public class OperationCallExpBodies
{

	/** 
	 * Implementation of the OperationCallExp 'ArgumentCount' invariant.
	 */
	public static class _invariant_ArgumentCount extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_ArgumentCount INSTANCE = new _invariant_ArgumentCount();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Real__eq_ = OCLstdlibTables.Operations._Real___eq_;
		static final @NonNull PrimitiveTypeId T_Integer = TypeId.INTEGER;
		static final @NonNull ExecutorOperation O_Collection_size = OCLstdlibTables.Operations._Collection__size;
		static final @NonNull TypeId T_pivot__OCLExpression = PivotTables.Types._OCLExpression.getTypeId();
		static final @NonNull CollectionTypeId T_OrderedSet_pivot__OCLExpression_ = TypeId.ORDERED_SET.getSpecializedId(T_pivot__OCLExpression);
		static final @NonNull TypeId T_pivot__Parameter = PivotTables.Types._Parameter.getTypeId();
		static final @NonNull CollectionTypeId T_OrderedSet_pivot__Parameter_ = TypeId.ORDERED_SET.getSpecializedId(T_pivot__Parameter);
		static final @NonNull TypeId T_pivot__Operation = PivotTables.Types._Operation.getTypeId();
		
	
		/*
		argument->size() = referredOperation.ownedParameter->size()
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws InvalidValueException {
			assert self != null;
			final @NonNull OperationCallExp unboxed_self = (OperationCallExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			
			org.eclipse.emf.common.util.EList<org.eclipse.ocl.examples.pivot.OCLExpression> unboxed_A_symbol_ = unboxed_self != null ? unboxed_self.getArgument() : null;
			assert unboxed_A_symbol_ != null;
			final @NonNull Value A_symbol_ = standardLibrary.createOrderedSetValueOf(T_OrderedSet_pivot__OCLExpression_, unboxed_A_symbol_);
			
			
			Object A_symbol__1 = CollectionSizeOperation.INSTANCE.evaluate(evaluator, T_Integer, A_symbol_);
			
			org.eclipse.ocl.examples.pivot.Operation unboxed_A_symbol__2 = unboxed_self != null ? unboxed_self.getReferredOperation() : null;
			Object A_symbol__2 = valueOf(unboxed_A_symbol__2); // Operation
			
			
			org.eclipse.emf.common.util.EList<org.eclipse.ocl.examples.pivot.Parameter> unboxed_A_symbol__3 = unboxed_A_symbol__2 != null ? unboxed_A_symbol__2.getOwnedParameter() : null;
			assert unboxed_A_symbol__3 != null;
			final @NonNull Value A_symbol__3 = standardLibrary.createOrderedSetValueOf(T_OrderedSet_pivot__Parameter_, unboxed_A_symbol__3);
			
			
			Object A_symbol__4 = CollectionSizeOperation.INSTANCE.evaluate(evaluator, T_Integer, A_symbol__3);
			Object A_symbol__5 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__1, A_symbol__4);
			return A_symbol__5;
		}
	}


}

