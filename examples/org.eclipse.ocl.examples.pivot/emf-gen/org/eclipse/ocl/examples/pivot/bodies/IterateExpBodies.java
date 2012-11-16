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
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.PackageId;
import org.eclipse.ocl.examples.domain.ids.PrimitiveTypeId;
import org.eclipse.ocl.examples.domain.ids.TemplateParameterId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractUnaryOperation;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueImpl;
import org.eclipse.ocl.examples.library.classifier.OclTypeConformsToOperation;
import org.eclipse.ocl.examples.library.collection.CollectionSizeOperation;
import org.eclipse.ocl.examples.library.executor.ExecutorOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyOclAsSetOperation;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibPackage;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.examples.pivot.IterateExp;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.PivotTables;

/**
 * IterateExpBodies provides the Java implementation bodies of OCL-defined IterateExp operations and properties.
 */
@SuppressWarnings({"nls", "null", "unused"})
public class IterateExpBodies
{

	/** 
	 * Implementation of the IterateExp 'BodyTypeConformsToResultType' invariant.
	 */
	public static class _invariant_BodyTypeConformsToResultType extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_BodyTypeConformsToResultType INSTANCE = new _invariant_BodyTypeConformsToResultType();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_OclType_conformsTo = OCLstdlibTables.Operations._OclType__conformsTo;
		static final @NonNull PackageId Pk_ocl = IdManager.INSTANCE.getPackageId(OCLstdlibPackage.eINSTANCE);
		static final @NonNull TypeId T_Type = Pk_ocl.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "Type");
		static final @NonNull PackageId Pk_pivot = IdManager.INSTANCE.getPackageId(PivotPackage.eINSTANCE);
		static final @NonNull TypeId T_pivot__OCLExpression = Pk_pivot.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "OCLExpression");
		static final @NonNull TypeId T_pivot__Variable = Pk_pivot.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "Variable");
		
	
		/*
		body.type.conformsTo(result.type)
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
			assert self != null;
			final @NonNull IterateExp unboxed_self = (IterateExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			
			if (self == null) { throw new InvalidValueException("Null property source"); }
			org.eclipse.ocl.examples.pivot.OCLExpression unboxed_A_symbol_ = unboxed_self.getBody();
			final Object A_symbol_ = valueOf(unboxed_A_symbol_); // OCLExpression
			
			
			if (A_symbol_ == null) { throw new InvalidValueException("Null property source"); }
			org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__1 = unboxed_A_symbol_.getType();
			PivotTables.PACKAGE.getName();
			final Object A_symbol__1 = createTypeValue(unboxed_A_symbol__1);
			
			
			
			if (self == null) { throw new InvalidValueException("Null property source"); }
			org.eclipse.ocl.examples.pivot.Variable unboxed_A_symbol__2 = unboxed_self.getResult();
			final Object A_symbol__2 = valueOf(unboxed_A_symbol__2); // Variable
			
			
			if (A_symbol__2 == null) { throw new InvalidValueException("Null property source"); }
			org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__3 = unboxed_A_symbol__2.getType();
			PivotTables.PACKAGE.getName();
			final Object A_symbol__3 = createTypeValue(unboxed_A_symbol__3);
			
			
			Object A_symbol__4 = OclTypeConformsToOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__1, A_symbol__3);
			return A_symbol__4;
		}
	}

	/** 
	 * Implementation of the IterateExp 'OneInitializer' invariant.
	 */
	public static class _invariant_OneInitializer extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_OneInitializer INSTANCE = new _invariant_OneInitializer();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Real__eq_ = OCLstdlibTables.Operations._Real___eq_;
		static final @NonNull PrimitiveTypeId T_Integer = TypeId.INTEGER;
		static final @NonNull ExecutorOperation O_Collection_size = OCLstdlibTables.Operations._Collection__size;
		static final @NonNull PackageId Pk_pivot = IdManager.INSTANCE.getPackageId(PivotPackage.eINSTANCE);
		static final @NonNull TypeId T_pivot__OCLExpression = Pk_pivot.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "OCLExpression");
		static final @NonNull CollectionTypeId T_Set_pivot__OCLExpression_ = TypeId.SET.getSpecializedId(T_pivot__OCLExpression);
		static final @NonNull ExecutorOperation O_OclAny_oclAsSet = OCLstdlibTables.Operations._OclAny__oclAsSet;
		static final @NonNull TypeId T_pivot__Variable = Pk_pivot.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "Variable");
		static final @NonNull IntegerValue I_1 = integerValueOf(1);
		
	
		/*
		self.result.initExpression->size() = 1
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
			assert self != null;
			final @NonNull IterateExp unboxed_self = (IterateExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			Object aA_symbol__6;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				org.eclipse.ocl.examples.pivot.Variable unboxed_A_symbol__7 = unboxed_self.getResult();
				final Object A_symbol__7 = valueOf(unboxed_A_symbol__7); // Variable
				
				
				if (A_symbol__7 == null) { throw new InvalidValueException("Null property source"); }
				org.eclipse.ocl.examples.pivot.OCLExpression unboxed_A_symbol__6 = unboxed_A_symbol__7.getInitExpression();
				final Object A_symbol__6 = valueOf(unboxed_A_symbol__6); // OCLExpression
				
				
				aA_symbol__6 = A_symbol__6;
			} catch (Exception e) {
				aA_symbol__6 = new InvalidValueImpl(e);
			}
			Object A_symbol__5 = OclAnyOclAsSetOperation.INSTANCE.evaluate(evaluator, T_Set_pivot__OCLExpression_, aA_symbol__6);
			
			Object A_symbol__8 = CollectionSizeOperation.INSTANCE.evaluate(evaluator, T_Integer, A_symbol__5);
			Object A_symbol__9 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__8, I_1);
			return A_symbol__9;
		}
	}

	/** 
	 * Implementation of the IterateExp 'TypeIsResultType' invariant.
	 */
	public static class _invariant_TypeIsResultType extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_TypeIsResultType INSTANCE = new _invariant_TypeIsResultType();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
		static final @NonNull PackageId Pk_ocl = IdManager.INSTANCE.getPackageId(OCLstdlibPackage.eINSTANCE);
		static final @NonNull TypeId T_Type = Pk_ocl.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "Type");
		static final @NonNull PackageId Pk_pivot = IdManager.INSTANCE.getPackageId(PivotPackage.eINSTANCE);
		static final @NonNull TypeId T_pivot__Variable = Pk_pivot.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "Variable");
		
	
		/*
		type = result.type
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
			assert self != null;
			final @NonNull IterateExp unboxed_self = (IterateExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			
			if (self == null) { throw new InvalidValueException("Null property source"); }
			org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__10 = unboxed_self.getType();
			PivotTables.PACKAGE.getName();
			final Object A_symbol__10 = createTypeValue(unboxed_A_symbol__10);
			
			
			
			if (self == null) { throw new InvalidValueException("Null property source"); }
			org.eclipse.ocl.examples.pivot.Variable unboxed_A_symbol__11 = unboxed_self.getResult();
			final Object A_symbol__11 = valueOf(unboxed_A_symbol__11); // Variable
			
			
			if (A_symbol__11 == null) { throw new InvalidValueException("Null property source"); }
			org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__12 = unboxed_A_symbol__11.getType();
			PivotTables.PACKAGE.getName();
			final Object A_symbol__12 = createTypeValue(unboxed_A_symbol__12);
			
			
			Object A_symbol__13 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__10, A_symbol__12);
			return A_symbol__13;
		}
	}

}

