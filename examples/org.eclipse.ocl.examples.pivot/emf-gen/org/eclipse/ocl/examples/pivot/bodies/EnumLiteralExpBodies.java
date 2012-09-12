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
import org.eclipse.ocl.examples.domain.library.AbstractUnaryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryBinaryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryProperty;
import org.eclipse.ocl.examples.domain.values.ValueFactory;
import org.eclipse.ocl.examples.library.executor.ExecutorOperation;
import org.eclipse.ocl.examples.library.executor.ExecutorProperty;
import org.eclipse.ocl.examples.library.executor.ExecutorType;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.examples.pivot.PivotTables;

/**
 * EnumLiteralExpBodies provides the Java implementation bodies of OCL-defined EnumLiteralExp operations and properties.
 */
@SuppressWarnings("nls")
public class EnumLiteralExpBodies
{

	/** 
	 * Implementation of the EnumLiteralExp 'TypeIsEnumerationType' invariant.
	 */
	public static class _invariant_TypeIsEnumerationType extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_TypeIsEnumerationType INSTANCE = new _invariant_TypeIsEnumerationType();
	
		/*
		self.type = referredEnumLiteral.enumeration
		*/
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Object self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
			final @NonNull ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final @NonNull ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final @NonNull LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final @NonNull ExecutorType T_Enumeration = OCLstdlibTables.Types._Enumeration;
			final @NonNull ExecutorProperty P_EnumerationLiteral_enumeration = PivotTables.Properties._EnumerationLiteral__enumeration;
			final @NonNull LibraryProperty IP_EnumerationLiteral_enumeration = P_EnumerationLiteral_enumeration.getImplementation();
			final @NonNull ExecutorType T_EnumerationLiteral = OCLstdlibTables.Types._EnumerationLiteral;
			final @NonNull ExecutorProperty P_EnumLiteralExp_referredEnumLiteral = PivotTables.Properties._EnumLiteralExp__referredEnumLiteral;
			final @NonNull LibraryProperty IP_EnumLiteralExp_referredEnumLiteral = P_EnumLiteralExp_referredEnumLiteral.getImplementation();
			
			
			Object A_symbol_ = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
			
			
			Object A_symbol__1 = IP_EnumLiteralExp_referredEnumLiteral.evaluate(evaluator, T_EnumerationLiteral, self, P_EnumLiteralExp_referredEnumLiteral);
			
			Object A_symbol__2 = IP_EnumerationLiteral_enumeration.evaluate(evaluator, T_Enumeration, A_symbol__1, P_EnumerationLiteral_enumeration);
			
			DomainType static_A_symbol__3 = valueFactory.typeOf(A_symbol_, A_symbol__2);
			LibraryBinaryOperation dynamic_A_symbol__3 = (LibraryBinaryOperation)static_A_symbol__3.lookupImplementation(standardLibrary, O_OclAny__eq_);
			Object A_symbol__3 = dynamic_A_symbol__3.evaluate(evaluator, T_Boolean, A_symbol_, A_symbol__2);
			return A_symbol__3;
		}
	}

}

