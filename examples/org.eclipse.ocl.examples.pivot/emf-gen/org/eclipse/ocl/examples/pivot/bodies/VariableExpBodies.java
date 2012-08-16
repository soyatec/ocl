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
 * VariableExpBodies provides the Java implementation bodies of OCL-defined VariableExp operations and properties.
 */
@SuppressWarnings("nls")
public class VariableExpBodies
{

	/** 
	 * Implementation of the VariableExp::referredElements '' <body>.
	 */
	public static class _referredElements_body_ extends AbstractUnaryOperation
	{
		public static @NonNull _referredElements_body_ INSTANCE = new _referredElements_body_();
	
		/*
		Set{referredVariable}
		*/
		public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Value self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_pivot__VariableDeclaration = PivotTables.Types._VariableDeclaration;
			final @NonNull DomainCollectionType T_Set_pivot__VariableDeclaration_ = standardLibrary.getSetType(T_pivot__VariableDeclaration, null, null);
			final @NonNull ExecutorProperty P_VariableExp_referredVariable = PivotTables.Properties._VariableExp__referredVariable;
			final @NonNull LibraryProperty IP_VariableExp_referredVariable = P_VariableExp_referredVariable.getImplementation();
			
			
			Value A_symbol_0 = IP_VariableExp_referredVariable.evaluate(evaluator, T_pivot__VariableDeclaration, self, P_VariableExp_referredVariable);
			
			
			final @NonNull List<Value> lA_symbol_1 = new ArrayList<Value>(); 
			final @NonNull Value A_symbol_1 = valueFactory.createSetValue(T_Set_pivot__VariableDeclaration_, lA_symbol_1);
			lA_symbol_1.add(A_symbol_0); // A_symbol_2
			
			return A_symbol_1;
		}
	}


}

