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
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.ids.PrimitiveTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractBinaryOperation;
import org.eclipse.ocl.examples.domain.library.AbstractUnaryOperation;
import org.eclipse.ocl.examples.domain.values.ObjectValue;
import org.eclipse.ocl.examples.library.classifier.OclTypeConformsToOperation;
import org.eclipse.ocl.examples.library.executor.ExecutorOperation;
import org.eclipse.ocl.examples.library.executor.ExecutorProperty;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.examples.pivot.PivotTables;
import org.eclipse.ocl.examples.pivot.TypedMultiplicityElement;
import org.eclipse.ocl.examples.pivot.ValueSpecification;

/**
 * TypedMultiplicityElementBodies provides the Java implementation bodies of OCL-defined TypedMultiplicityElement operations and properties.
 */
@SuppressWarnings("nls")
public class TypedMultiplicityElementBodies
{

	/** 
	 * Implementation of the TypedMultiplicityElement::CompatibleBody '' <body>.
	 */
	public static class _CompatibleBody_body_ extends AbstractBinaryOperation
	{
		public static @NonNull _CompatibleBody_body_ INSTANCE = new _CompatibleBody_body_();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_OclType_conformsTo = OCLstdlibTables.Operations._OclType__conformsTo;
		static final @NonNull TypeId T_Type = OCLstdlibTables.Types._Type.getTypeId();
		
	
		/*
		bodySpecification.type.conformsTo(self.type)
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self, final @Nullable Object bodySpecification) throws InvalidValueException {
			assert self != null;
			final @NonNull TypedMultiplicityElement unboxed_self = (TypedMultiplicityElement)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			
			ValueSpecification unboxed_bodySpecification = (ValueSpecification)bodySpecification;	// ValueSpecification
			org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol_ = unboxed_bodySpecification != null ? unboxed_bodySpecification.getType() : null;
			Object A_symbol_ = createTypeValue(unboxed_A_symbol_);
			
			
			
			org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__1 = unboxed_self != null ? unboxed_self.getType() : null;
			Object A_symbol__1 = createTypeValue(unboxed_A_symbol__1);
			
			
			Object A_symbol__2 = OclTypeConformsToOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol_, A_symbol__1);
			return A_symbol__2;
		}
	}

	/** 
	 * Implementation of the TypedMultiplicityElement::makeParameter '' <body>.
	 */
	public static class _makeParameter_body_ extends AbstractUnaryOperation
	{
		public static @NonNull _makeParameter_body_ INSTANCE = new _makeParameter_body_();
		static final @NonNull ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
		static final @NonNull Object S_name = "name";
		
	
		/*
		Parameter{name = 'name'}
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws InvalidValueException {
			assert self != null;
			final @NonNull TypedMultiplicityElement unboxed_self = (TypedMultiplicityElement)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			ObjectValue A_symbol__3 = PivotTables.Types._Parameter.createInstance(standardLibrary);
			
			P_NamedElement_name.setValue(standardLibrary, A_symbol__3, S_name);
			
			return A_symbol__3;
		}
	}

}

