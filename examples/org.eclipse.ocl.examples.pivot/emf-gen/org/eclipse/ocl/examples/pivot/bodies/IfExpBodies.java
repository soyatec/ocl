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
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.ids.PrimitiveTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractUnaryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryBinaryOperation;
import org.eclipse.ocl.examples.library.executor.ExecutorOperation;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.examples.pivot.IfExp;
import org.eclipse.ocl.examples.pivot.PivotTables;

/**
 * IfExpBodies provides the Java implementation bodies of OCL-defined IfExp operations and properties.
 */
@SuppressWarnings({"nls", "null", "unused"})
public class IfExpBodies
{

	/** 
	 * Implementation of the IfExp 'ConditionTypeIsBoolean' invariant.
	 */
	public static class _invariant_ConditionTypeIsBoolean extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_ConditionTypeIsBoolean INSTANCE = new _invariant_ConditionTypeIsBoolean();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
		static final @NonNull TypeId T_Type = OCLstdlibTables.Types._Type.getTypeId();
		static final @NonNull TypeId T_pivot__OCLExpression = PivotTables.Types._OCLExpression.getTypeId();
		static final @NonNull Object T_Metaclass_Boolean_ = createTypeValue(OCLstdlibTables.Types._Boolean);
		
	
		/*
		self.condition.type = Boolean
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
			assert self != null;
			final @NonNull IfExp unboxed_self = (IfExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			
			if (self == null) { throw new InvalidValueException("Null property source"); }
			org.eclipse.ocl.examples.pivot.OCLExpression unboxed_A_symbol_ = unboxed_self.getCondition();
			Object A_symbol_ = valueOf(unboxed_A_symbol_); // OCLExpression
			
			
			if (A_symbol_ == null) { throw new InvalidValueException("Null property source"); }
			org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__1 = unboxed_A_symbol_.getType();
			Object A_symbol__1 = createTypeValue(unboxed_A_symbol__1);
			
			
			DomainType static_A_symbol__2 = evaluator.getStaticTypeOf(A_symbol__1, T_Metaclass_Boolean_);
			LibraryBinaryOperation dynamic_A_symbol__2 = (LibraryBinaryOperation)static_A_symbol__2.lookupImplementation(standardLibrary, O_OclAny__eq_);
			Object A_symbol__2 = dynamic_A_symbol__2.evaluate(evaluator, T_Boolean, A_symbol__1, T_Metaclass_Boolean_);
			return A_symbol__2;
		}
	}



}

