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
import org.eclipse.ocl.examples.domain.elements.DomainMetaclass;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.library.AbstractBinaryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryBinaryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryUnaryOperation;
import org.eclipse.ocl.examples.domain.values.ValueFactory;
import org.eclipse.ocl.examples.library.executor.ExecutorOperation;
import org.eclipse.ocl.examples.library.executor.ExecutorType;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibTables;
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
	
		/*
		p.oclIsKindOf(self.oclType())
		*/
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Object self, final @NonNull Object p) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
			final @NonNull ExecutorType T_pivot__ParameterableElement = PivotTables.Types._ParameterableElement;
			final @NonNull DomainMetaclass T_Metaclass_pivot__ParameterableElement_ = standardLibrary.getMetaclass(T_pivot__ParameterableElement);
			final @NonNull ExecutorOperation O_OclAny_oclType = OCLstdlibTables.Operations._OclAny__oclType;
			
			
			
			DomainType static_A_symbol_ = valueFactory.typeOf(self);
			LibraryUnaryOperation dynamic_A_symbol_ = (LibraryUnaryOperation)static_A_symbol_.lookupImplementation(standardLibrary, O_OclAny_oclType);
			Object A_symbol_ = dynamic_A_symbol_.evaluate(evaluator, T_Metaclass_pivot__ParameterableElement_, self);
			DomainType static_A_symbol__1 = valueFactory.typeOf(p);
			LibraryBinaryOperation dynamic_A_symbol__1 = (LibraryBinaryOperation)static_A_symbol__1.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
			Object A_symbol__1 = dynamic_A_symbol__1.evaluate(evaluator, T_Boolean, p, A_symbol_);
			return A_symbol__1;
		}
	}



}

