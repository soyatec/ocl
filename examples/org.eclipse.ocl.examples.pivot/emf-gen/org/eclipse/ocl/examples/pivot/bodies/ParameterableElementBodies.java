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
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.PrimitiveTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractBinaryOperation;
import org.eclipse.ocl.examples.library.executor.ExecutorOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyOclTypeOperation;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.PivotTables;

/**
 * ParameterableElementBodies provides the Java implementation bodies of OCL-defined ParameterableElement operations and properties.
 */
@SuppressWarnings("nls")
public class ParameterableElementBodies
{

	/** 
	 * Implementation of the ParameterableElement::isCompatibleWith '' <body>.
	 */
	public static class _isCompatibleWith_body_ extends AbstractBinaryOperation
	{
		public static @NonNull _isCompatibleWith_body_ INSTANCE = new _isCompatibleWith_body_();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
		static final @NonNull TypeId T_pivot__ParameterableElement = PivotTables.Types._ParameterableElement.getTypeId();
		static final @NonNull CollectionTypeId T_Metaclass_pivot__ParameterableElement_ = TypeId.METACLASS.getSpecializedId(T_pivot__ParameterableElement);
		static final @NonNull ExecutorOperation O_OclAny_oclType = OCLstdlibTables.Operations._OclAny__oclType;
		
	
		/*
		p.oclIsKindOf(self.oclType())
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self, final @Nullable Object p) throws InvalidValueException {
			assert self != null;
			final @NonNull ParameterableElement unboxed_self = (ParameterableElement)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			
			
			Object A_symbol_ = OclAnyOclTypeOperation.INSTANCE.evaluate(evaluator, T_Metaclass_pivot__ParameterableElement_, self);
			Object A_symbol__1 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, T_Boolean, p, A_symbol_);
			return A_symbol__1;
		}
	}



}

