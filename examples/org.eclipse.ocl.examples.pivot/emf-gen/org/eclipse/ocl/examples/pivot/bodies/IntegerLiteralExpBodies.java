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
 * IntegerLiteralExpBodies provides the Java implementation bodies of OCL-defined IntegerLiteralExp operations and properties.
 */
@SuppressWarnings("nls")
public class IntegerLiteralExpBodies
{

	/** 
	 * Implementation of the IntegerLiteralExp 'TypeIsInteger' invariant.
	 */
	public static class _invariant_TypeIsInteger extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_TypeIsInteger INSTANCE = new _invariant_TypeIsInteger();
	
		/*
		self.type = Integer
		*/
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @NonNull Object self) throws InvalidValueException {
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
			final @NonNull ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final @NonNull ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final @NonNull LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final @NonNull Object T_Metaclass_Integer_ = createTypeValue(OCLstdlibTables.Types._Integer);
			
			
			Object A_symbol_ = IP_TypedElement_type.evaluate(evaluator, T_Type.getTypeId(), self, P_TypedElement_type);
			
			DomainType static_A_symbol__1 = evaluator.getStaticTypeOf(A_symbol_, T_Metaclass_Integer_);
			LibraryBinaryOperation dynamic_A_symbol__1 = (LibraryBinaryOperation)static_A_symbol__1.lookupImplementation(standardLibrary, O_OclAny__eq_);
			Object A_symbol__1 = dynamic_A_symbol__1.evaluate(evaluator, TypeId.BOOLEAN, A_symbol_, T_Metaclass_Integer_);
			return A_symbol__1;
		}
	}

}

