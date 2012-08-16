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
import org.eclipse.ocl.examples.domain.library.LibraryProperty;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.domain.values.ValueFactory;
import org.eclipse.ocl.examples.library.executor.ExecutorProperty;
import org.eclipse.ocl.examples.library.executor.ExecutorType;
import org.eclipse.ocl.examples.pivot.PivotTables;

/**
 * PropertyCallExpBodies provides the Java implementation bodies of OCL-defined PropertyCallExp operations and properties.
 */
@SuppressWarnings("nls")
public class PropertyCallExpBodies
{

	/** 
	 * Implementation of the PropertyCallExp::allOCLExpressions '' <body>.
	 */
	public static class _allOCLExpressions_body_ extends AbstractUnaryOperation
	{
		public static @NonNull _allOCLExpressions_body_ INSTANCE = new _allOCLExpressions_body_();
	
		/*
		Set{self, source}
		*/
		public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Value self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final @NonNull DomainCollectionType T_Set_pivot__OCLExpression_ = standardLibrary.getSetType(T_pivot__OCLExpression, null, null);
			final @NonNull ExecutorProperty P_CallExp_source = PivotTables.Properties._CallExp__source;
			final @NonNull LibraryProperty IP_CallExp_source = P_CallExp_source.getImplementation();
			
			
			
			
			Value A_symbol_0 = IP_CallExp_source.evaluate(evaluator, T_pivot__OCLExpression, self, P_CallExp_source);
			
			
			final @NonNull List<Value> lA_symbol_1 = new ArrayList<Value>(); 
			final @NonNull Value A_symbol_1 = valueFactory.createSetValue(T_Set_pivot__OCLExpression_, lA_symbol_1);
			lA_symbol_1.add(self); // A_symbol_2
			lA_symbol_1.add(A_symbol_0); // A_symbol_3
			
			return A_symbol_1;
		}
	}

	/** 
	 * Implementation of the PropertyCallExp::referredElements '' <body>.
	 */
	public static class _referredElements_body_ extends AbstractUnaryOperation
	{
		public static @NonNull _referredElements_body_ INSTANCE = new _referredElements_body_();
	
		/*
		Set{referredProperty}
		*/
		public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Value self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_pivot__Property = PivotTables.Types._Property;
			final @NonNull DomainCollectionType T_Set_pivot__Property_ = standardLibrary.getSetType(T_pivot__Property, null, null);
			final @NonNull ExecutorProperty P_PropertyCallExp_referredProperty = PivotTables.Properties._PropertyCallExp__referredProperty;
			final @NonNull LibraryProperty IP_PropertyCallExp_referredProperty = P_PropertyCallExp_referredProperty.getImplementation();
			
			
			Value A_symbol_4 = IP_PropertyCallExp_referredProperty.evaluate(evaluator, T_pivot__Property, self, P_PropertyCallExp_referredProperty);
			
			
			final @NonNull List<Value> lA_symbol_5 = new ArrayList<Value>(); 
			final @NonNull Value A_symbol_5 = valueFactory.createSetValue(T_Set_pivot__Property_, lA_symbol_5);
			lA_symbol_5.add(A_symbol_4); // A_symbol_6
			
			return A_symbol_5;
		}
	}

}

