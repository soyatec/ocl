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
import org.eclipse.ocl.examples.pivot.LetExp;
import org.eclipse.ocl.examples.pivot.PivotTables;

/**
 * LetExpBodies provides the Java implementation bodies of OCL-defined LetExp operations and properties.
 */
@SuppressWarnings({"nls", "null", "unused"})
public class LetExpBodies
{

	/** 
	 * Implementation of the LetExp 'TypeIsInType' invariant.
	 */
	public static class _invariant_TypeIsInType extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_TypeIsInType INSTANCE = new _invariant_TypeIsInType();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
		static final @NonNull TypeId T_Type = OCLstdlibTables.Types._Type.getTypeId();
		static final @NonNull TypeId T_pivot__OCLExpression = PivotTables.Types._OCLExpression.getTypeId();
		
	
		/*
		type = _'in'.type
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
			assert self != null;
			final @NonNull LetExp unboxed_self = (LetExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			
			if (self == null) { throw new InvalidValueException("Null property source"); }
			org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol_ = unboxed_self.getType();
			Object A_symbol_ = createTypeValue(unboxed_A_symbol_);
			
			
			
			if (self == null) { throw new InvalidValueException("Null property source"); }
			org.eclipse.ocl.examples.pivot.OCLExpression unboxed_A_symbol__1 = unboxed_self.getIn();
			Object A_symbol__1 = valueOf(unboxed_A_symbol__1); // OCLExpression
			
			
			if (A_symbol__1 == null) { throw new InvalidValueException("Null property source"); }
			org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__2 = unboxed_A_symbol__1.getType();
			Object A_symbol__2 = createTypeValue(unboxed_A_symbol__2);
			
			
			DomainType static_A_symbol__3 = evaluator.getStaticTypeOf(A_symbol_, A_symbol__2);
			LibraryBinaryOperation dynamic_A_symbol__3 = (LibraryBinaryOperation)static_A_symbol__3.lookupImplementation(standardLibrary, O_OclAny__eq_);
			Object A_symbol__3 = dynamic_A_symbol__3.evaluate(evaluator, T_Boolean, A_symbol_, A_symbol__2);
			return A_symbol__3;
		}
	}


}

