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
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.PrimitiveTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractUnaryOperation;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.library.collection.CollectionIsEmptyOperation;
import org.eclipse.ocl.examples.library.executor.ExecutorOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyOclAsSetOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.examples.pivot.LoopExp;
import org.eclipse.ocl.examples.pivot.PivotTables;
import org.eclipse.ocl.examples.pivot.Variable;

/**
 * LoopExpBodies provides the Java implementation bodies of OCL-defined LoopExp operations and properties.
 */
@SuppressWarnings("nls")
public class LoopExpBodies
{

	/** 
	 * Implementation of the LoopExp 'NoInitializers' invariant.
	 */
	public static class _invariant_NoInitializers extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_NoInitializers INSTANCE = new _invariant_NoInitializers();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Collection_forAll = OCLstdlibTables.Operations._Collection__1_forAll;
		static final @NonNull TypeId T_pivot__Variable = PivotTables.Types._Variable.getTypeId();
		static final @NonNull CollectionTypeId T_OrderedSet_pivot__Variable_ = TypeId.ORDERED_SET.getSpecializedId(T_pivot__Variable);
		static final @NonNull ExecutorOperation O_Collection_isEmpty = OCLstdlibTables.Operations._Collection__isEmpty;
		static final @NonNull TypeId T_pivot__OCLExpression = PivotTables.Types._OCLExpression.getTypeId();
		static final @NonNull CollectionTypeId T_Set_pivot__OCLExpression_ = TypeId.SET.getSpecializedId(T_pivot__OCLExpression);
		static final @NonNull ExecutorOperation O_OclAny_oclAsSet = OCLstdlibTables.Operations._OclAny__oclAsSet;
		
	
		/*
		self.iterator->forAll(initExpression->isEmpty())
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws InvalidValueException {
			assert self != null;
			final @NonNull LoopExp unboxed_self = (LoopExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			
			org.eclipse.emf.common.util.EList<org.eclipse.ocl.examples.pivot.Variable> unboxed_A_symbol_ = unboxed_self != null ? unboxed_self.getIterator() : null;
			assert unboxed_A_symbol_ != null;
			final @NonNull Value A_symbol_ = standardLibrary.createOrderedSetValueOf(T_OrderedSet_pivot__Variable_, unboxed_A_symbol_);
			
			
			
			assert A_symbol_ != null;
			final @NonNull Iterator<?> A_symbol__1_iteratorVal = ((CollectionValue)A_symbol_).iterator();
			Object V_1_ = null;	// iterator: 1_
			Object A_symbol__1;
			while (true) {
				if (!A_symbol__1_iteratorVal.hasNext()) {
					A_symbol__1 = TRUE_VALUE;
					break;
				}
				Object A_symbol__1_bodyVal;
				try {
					/*
						initExpression->isEmpty()
					*/
					V_1_ = A_symbol__1_iteratorVal.next();
					
					Variable unboxed_V_1_ = (Variable)V_1_;	// Variable
					org.eclipse.ocl.examples.pivot.OCLExpression unboxed_A_symbol__2 = unboxed_V_1_ != null ? unboxed_V_1_.getInitExpression() : null;
					Object A_symbol__2 = valueOf(unboxed_A_symbol__2); // OCLExpression
					
					
					Object A_symbol__3 = OclAnyOclAsSetOperation.INSTANCE.evaluate(evaluator, T_Set_pivot__OCLExpression_, A_symbol__2);
					Object A_symbol__4 = CollectionIsEmptyOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__3);
					A_symbol__1_bodyVal = A_symbol__4;
				} catch (Exception e) {
					A_symbol__1_bodyVal = createInvalidValue(e);
				}
				if (A_symbol__1_bodyVal == null) {
					A_symbol__1 = createInvalidValue(EvaluatorMessages.UndefinedBody, "forAll");
					break;
				}
				else if (A_symbol__1_bodyVal != TRUE_VALUE) {
					A_symbol__1 = FALSE_VALUE;			// Abort after a fail
					break;
				}
				
			}
			
			return A_symbol__1;
		}
	}

	/** 
	 * Implementation of the LoopExp 'SourceIsCollection' invariant.
	 */
	public static class _invariant_SourceIsCollection extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_SourceIsCollection INSTANCE = new _invariant_SourceIsCollection();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
		static final @NonNull TypeId T_Type = OCLstdlibTables.Types._Type.getTypeId();
		static final @NonNull TypeId T_pivot__OCLExpression = PivotTables.Types._OCLExpression.getTypeId();
		static final @NonNull Object T_Metaclass_pivot__CollectionType_ = createTypeValue(PivotTables.Types._CollectionType);
		
	
		/*
		source.type.oclIsKindOf(CollectionType)
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws InvalidValueException {
			assert self != null;
			final @NonNull LoopExp unboxed_self = (LoopExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			
			org.eclipse.ocl.examples.pivot.OCLExpression unboxed_A_symbol__5 = unboxed_self != null ? unboxed_self.getSource() : null;
			Object A_symbol__5 = valueOf(unboxed_A_symbol__5); // OCLExpression
			
			
			org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__6 = unboxed_A_symbol__5 != null ? unboxed_A_symbol__5.getType() : null;
			Object A_symbol__6 = createTypeValue(unboxed_A_symbol__6);
			
			
			Object A_symbol__7 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__6, T_Metaclass_pivot__CollectionType_);
			return A_symbol__7;
		}
	}



}

