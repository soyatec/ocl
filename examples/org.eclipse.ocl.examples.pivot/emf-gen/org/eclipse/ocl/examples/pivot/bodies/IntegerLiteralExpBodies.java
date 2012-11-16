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
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.PackageId;
import org.eclipse.ocl.examples.domain.ids.PrimitiveTypeId;
import org.eclipse.ocl.examples.domain.ids.TemplateParameterId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractUnaryOperation;
import org.eclipse.ocl.examples.domain.values.TypeValue;
import org.eclipse.ocl.examples.library.executor.ExecutorOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibPackage;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.examples.pivot.IntegerLiteralExp;
import org.eclipse.ocl.examples.pivot.PivotTables;

/**
 * IntegerLiteralExpBodies provides the Java implementation bodies of OCL-defined IntegerLiteralExp operations and properties.
 */
@SuppressWarnings({"nls", "null", "unused"})
public class IntegerLiteralExpBodies
{

	/** 
	 * Implementation of the IntegerLiteralExp 'TypeIsInteger' invariant.
	 */
	public static class _invariant_TypeIsInteger extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_TypeIsInteger INSTANCE = new _invariant_TypeIsInteger();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
		static final @NonNull PackageId Pk_ocl = IdManager.INSTANCE.getPackageId(OCLstdlibPackage.eINSTANCE);
		static final @NonNull TypeId T_Type = Pk_ocl.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "Type");
		static final @NonNull PrimitiveTypeId T_Integer = TypeId.INTEGER;
		
	
		/*
		self.type = Integer
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
			assert self != null;
			final @NonNull IntegerLiteralExp unboxed_self = (IntegerLiteralExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			final TypeValue Te_Metaclass_Integer_ = createTypeValue(evaluator.getIdResolver().getType(T_Integer, null));
			
			
			if (self == null) { throw new InvalidValueException("Null property source"); }
			org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol_ = unboxed_self.getType();
			PivotTables.PACKAGE.getName();
			final Object A_symbol_ = createTypeValue(unboxed_A_symbol_);
			
			
			Object A_symbol__1 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol_, Te_Metaclass_Integer_);
			return A_symbol__1;
		}
	}

}

