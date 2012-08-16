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
import java.util.ArrayList;
import java.util.List;
import org.eclipse.ocl.examples.domain.elements.DomainCollectionType;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.library.AbstractUnaryOperation;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.domain.values.ValueFactory;
import org.eclipse.ocl.examples.library.executor.ExecutorType;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.examples.pivot.PivotTables;

/**
 * OCLExpressionBodies provides the Java implementation bodies of OCL-defined OCLExpression operations and properties.
 */
@SuppressWarnings("nls")
public class OCLExpressionBodies
{

	/** 
	 * Implementation of the OCLExpression::allOCLExpressions '' <body>.
	 */
	public static class _allOCLExpressions_body_ extends AbstractUnaryOperation
	{
		public static @NonNull _allOCLExpressions_body_ INSTANCE = new _allOCLExpressions_body_();
	
		/*
		Set{self}
		*/
		public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Value self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final @NonNull DomainCollectionType T_Set_pivot__OCLExpression_ = standardLibrary.getSetType(T_pivot__OCLExpression, null, null);
			
			
			
			final @NonNull List<Value> lA_symbol_0 = new ArrayList<Value>(); 
			final @NonNull Value A_symbol_0 = valueFactory.createSetValue(T_Set_pivot__OCLExpression_, lA_symbol_0);
			lA_symbol_0.add(self); // A_symbol_1
			
			return A_symbol_0;
		}
	}

	/** 
	 * Implementation of the OCLExpression::referredElements '' <body>.
	 */
	public static class _referredElements_body_ extends AbstractUnaryOperation
	{
		public static @NonNull _referredElements_body_ INSTANCE = new _referredElements_body_();
	
		/*
		Set{}
		*/
		public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Value self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_OclAny = OCLstdlibTables.Types._OclAny;
			final @NonNull DomainCollectionType T_Set_OclAny_ = standardLibrary.getSetType(T_OclAny, null, null);
			final @NonNull List<Value> lA_symbol_2 = new ArrayList<Value>();
			final @NonNull Value A_symbol_2 = valueFactory.createSetValue(T_Set_OclAny_, lA_symbol_2);
			
			
			return A_symbol_2;
		}
	}










}

