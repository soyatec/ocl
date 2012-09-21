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
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractUnaryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryBinaryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryProperty;
import org.eclipse.ocl.examples.library.executor.ExecutorOperation;
import org.eclipse.ocl.examples.library.executor.ExecutorProperty;
import org.eclipse.ocl.examples.library.executor.ExecutorType;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.examples.pivot.PivotTables;

/**
 * LetExpBodies provides the Java implementation bodies of OCL-defined LetExp operations and properties.
 */
@SuppressWarnings("nls")
public class LetExpBodies
{

	/** 
	 * Implementation of the LetExp 'TypeIsInType' invariant.
	 */
	public static class _invariant_TypeIsInType extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_TypeIsInType INSTANCE = new _invariant_TypeIsInType();
	
		/*
		type = _'in'.type
		*/
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @NonNull Object self) throws InvalidValueException {
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
			final @NonNull ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final @NonNull ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final @NonNull LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final @NonNull ExecutorType T_pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final @NonNull ExecutorProperty P_LetExp_in = PivotTables.Properties._LetExp__in;
			final @NonNull LibraryProperty IP_LetExp_in = P_LetExp_in.getImplementation();
			
			
			Object A_symbol_ = IP_TypedElement_type.evaluate(evaluator, T_Type.getTypeId(), self, P_TypedElement_type);
			
			
			Object A_symbol__1 = IP_LetExp_in.evaluate(evaluator, T_pivot__OCLExpression.getTypeId(), self, P_LetExp_in);
			
			Object A_symbol__2 = IP_TypedElement_type.evaluate(evaluator, T_Type.getTypeId(), A_symbol__1, P_TypedElement_type);
			
			DomainType static_A_symbol__3 = evaluator.getStaticTypeOf(A_symbol_, A_symbol__2);
			LibraryBinaryOperation dynamic_A_symbol__3 = (LibraryBinaryOperation)static_A_symbol__3.lookupImplementation(standardLibrary, O_OclAny__eq_);
			Object A_symbol__3 = dynamic_A_symbol__3.evaluate(evaluator, TypeId.BOOLEAN, A_symbol_, A_symbol__2);
			return A_symbol__3;
		}
	}


}

