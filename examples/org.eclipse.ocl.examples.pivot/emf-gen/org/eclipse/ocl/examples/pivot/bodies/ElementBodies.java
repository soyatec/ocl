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
import org.eclipse.ocl.examples.domain.elements.DomainCollectionType;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.library.AbstractTernaryOperation;
import org.eclipse.ocl.examples.domain.library.AbstractUnaryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryBinaryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryUnaryOperation;
import org.eclipse.ocl.examples.domain.values.NullValue;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.domain.values.ValueFactory;
import org.eclipse.ocl.examples.library.executor.ExecutorOperation;
import org.eclipse.ocl.examples.library.executor.ExecutorType;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.examples.pivot.PivotTables;

/**
 * ElementBodies provides the Java implementation bodies of OCL-defined Element operations and properties.
 */
@SuppressWarnings("nls")
public class ElementBodies
{

	/** 
	 * Implementation of the Element 'not_own_self' invariant.
	 */
	public static class _invariant_not_own_self extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_not_own_self INSTANCE = new _invariant_not_own_self();
	
		/*
		not allOwnedElements()->includes(self)
		*/
		public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Value self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Boolean_not = OCLstdlibTables.Operations._Boolean__not;
			final @NonNull ExecutorOperation O_Collection_includes = OCLstdlibTables.Operations._Collection__includes;
			final @NonNull ExecutorType T_pivot__Element = PivotTables.Types._Element;
			final @NonNull DomainCollectionType T_Set_pivot__Element_ = standardLibrary.getSetType(T_pivot__Element);
			final @NonNull ExecutorOperation O_Element_allOwnedElements = PivotTables.Operations._Element__allOwnedElements;
			
			
			DomainType static_A_symbol_0 = valueFactory.typeOf(self);
			LibraryUnaryOperation dynamic_A_symbol_0 = (LibraryUnaryOperation)static_A_symbol_0.lookupImplementation(standardLibrary, O_Element_allOwnedElements);
			Value A_symbol_0 = dynamic_A_symbol_0.evaluate(evaluator, T_Set_pivot__Element_, self);
			
			DomainType static_A_symbol_1 = valueFactory.typeOf(A_symbol_0);
			LibraryBinaryOperation dynamic_A_symbol_1 = (LibraryBinaryOperation)static_A_symbol_1.lookupImplementation(standardLibrary, O_Collection_includes);
			Value A_symbol_1 = dynamic_A_symbol_1.evaluate(evaluator, T_Boolean, A_symbol_0, self);
			DomainType static_A_symbol_2 = valueFactory.typeOf(A_symbol_1);
			LibraryUnaryOperation dynamic_A_symbol_2 = (LibraryUnaryOperation)static_A_symbol_2.lookupImplementation(standardLibrary, O_Boolean_not);
			Value A_symbol_2 = dynamic_A_symbol_2.evaluate(evaluator, T_Boolean, A_symbol_1);
			return A_symbol_2;
		}
	}

	/** 
	 * Implementation of the Element::allOwnedElements '' <body>.
	 */
	public static class _allOwnedElements_body_ extends AbstractUnaryOperation
	{
		public static @NonNull _allOwnedElements_body_ INSTANCE = new _allOwnedElements_body_();
	
		/*
		oclContents()
		*/
		public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Value self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_OclElement = OCLstdlibTables.Types._OclElement;
			final @NonNull DomainCollectionType T_Set_OclElement_ = standardLibrary.getSetType(T_OclElement);
			final @NonNull ExecutorOperation O_OclElement_oclContents = OCLstdlibTables.Operations._OclElement__oclContents;
			
			
			DomainType static_A_symbol_3 = valueFactory.typeOf(self);
			LibraryUnaryOperation dynamic_A_symbol_3 = (LibraryUnaryOperation)static_A_symbol_3.lookupImplementation(standardLibrary, O_OclElement_oclContents);
			Value A_symbol_3 = dynamic_A_symbol_3.evaluate(evaluator, T_Set_OclElement_, self);
			return A_symbol_3;
		}
	}

	/** 
	 * Implementation of the Element::getValue '' <body>.
	 */
	public static class _getValue_body_ extends AbstractTernaryOperation
	{
		public static @NonNull _getValue_body_ INSTANCE = new _getValue_body_();
	
		/*
		null
		*/
		public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Value self, final @NonNull Value stereotype, final @NonNull Value propertyName) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull NullValue Null = valueFactory.getNull();
			
			
			return Null;
		}
	}



}

