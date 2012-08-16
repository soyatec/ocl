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
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.examples.pivot.PivotTables;

/**
 * TypeExpBodies provides the Java implementation bodies of OCL-defined TypeExp operations and properties.
 */
@SuppressWarnings("nls")
public class TypeExpBodies
{

	/** 
	 * Implementation of the TypeExp::referredElements '' <body>.
	 */
	public static class _referredElements_body_ extends AbstractUnaryOperation
	{
		public static @NonNull _referredElements_body_ INSTANCE = new _referredElements_body_();
	
		/*
		Set{referredType}
		*/
		public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Value self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final @NonNull DomainCollectionType T_Set_Type_ = standardLibrary.getSetType(T_Type, null, null);
			final @NonNull ExecutorProperty P_TypeExp_referredType = PivotTables.Properties._TypeExp__referredType;
			final @NonNull LibraryProperty IP_TypeExp_referredType = P_TypeExp_referredType.getImplementation();
			
			
			Value A_symbol_0 = IP_TypeExp_referredType.evaluate(evaluator, T_Type, self, P_TypeExp_referredType);
			
			
			final @NonNull List<Value> lA_symbol_1 = new ArrayList<Value>(); 
			final @NonNull Value A_symbol_1 = valueFactory.createSetValue(T_Set_Type_, lA_symbol_1);
			lA_symbol_1.add(A_symbol_0); // A_symbol_2
			
			return A_symbol_1;
		}
	}

}

