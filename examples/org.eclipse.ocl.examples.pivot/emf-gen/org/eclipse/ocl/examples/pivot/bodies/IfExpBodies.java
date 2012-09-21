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
 * IfExpBodies provides the Java implementation bodies of OCL-defined IfExp operations and properties.
 */
@SuppressWarnings("nls")
public class IfExpBodies
{

	/** 
	 * Implementation of the IfExp 'ConditionTypeIsBoolean' invariant.
	 */
	public static class _invariant_ConditionTypeIsBoolean extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_ConditionTypeIsBoolean INSTANCE = new _invariant_ConditionTypeIsBoolean();
	
		/*
		self.condition.type = Boolean
		*/
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @NonNull Object self) throws InvalidValueException {
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
			final @NonNull ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final @NonNull ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final @NonNull LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final @NonNull ExecutorType T_pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final @NonNull ExecutorProperty P_IfExp_condition = PivotTables.Properties._IfExp__condition;
			final @NonNull LibraryProperty IP_IfExp_condition = P_IfExp_condition.getImplementation();
			final @NonNull Object T_Metaclass_Boolean_ = createTypeValue(OCLstdlibTables.Types._Boolean);
			
			
			Object A_symbol_ = IP_IfExp_condition.evaluate(evaluator, T_pivot__OCLExpression.getTypeId(), self, P_IfExp_condition);
			
			Object A_symbol__1 = IP_TypedElement_type.evaluate(evaluator, T_Type.getTypeId(), A_symbol_, P_TypedElement_type);
			
			DomainType static_A_symbol__2 = evaluator.getStaticTypeOf(A_symbol__1, T_Metaclass_Boolean_);
			LibraryBinaryOperation dynamic_A_symbol__2 = (LibraryBinaryOperation)static_A_symbol__2.lookupImplementation(standardLibrary, O_OclAny__eq_);
			Object A_symbol__2 = dynamic_A_symbol__2.evaluate(evaluator, TypeId.BOOLEAN, A_symbol__1, T_Metaclass_Boolean_);
			return A_symbol__2;
		}
	}



}

