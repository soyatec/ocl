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
import java.util.Iterator;
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
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.InvalidValue;
import org.eclipse.ocl.examples.domain.values.TypeValue;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueImpl;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.library.collection.CollectionSizeOperation;
import org.eclipse.ocl.examples.library.executor.ExecutorOperation;
import org.eclipse.ocl.examples.library.logical.BooleanImpliesOperation;
import org.eclipse.ocl.examples.library.logical.BooleanOrOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyOclAsTypeOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibPackage;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.IteratorExp;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Variable;

/**
 * IteratorExpBodies provides the Java implementation bodies of OCL-defined IteratorExp operations and properties.
 */
@SuppressWarnings({"nls", "null", "unused"})
public class IteratorExpBodies
{

	/** 
	 * Implementation of the IteratorExp 'AnyBodyTypeIsBoolean' invariant.
	 */
	public static class _invariant_AnyBodyTypeIsBoolean extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_AnyBodyTypeIsBoolean INSTANCE = new _invariant_AnyBodyTypeIsBoolean();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
		static final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
		static final @NonNull PrimitiveTypeId T_String = TypeId.STRING;
		static final @NonNull Object S_any = "any";
		static final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
		static final @NonNull PackageId Pk_ocl = IdManager.INSTANCE.getPackageId(OCLstdlibPackage.eINSTANCE);
		static final @NonNull TypeId T_Type = Pk_ocl.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "Type");
		static final @NonNull PackageId Pk_pivot = IdManager.INSTANCE.getPackageId(PivotPackage.eINSTANCE);
		static final @NonNull TypeId T_pivot__OCLExpression = Pk_pivot.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "OCLExpression");
		static final @NonNull Object S_Boolean = "Boolean";
		
	
		/*
		name = 'any' implies body.type = 'Boolean'
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
			assert self != null;
			final @NonNull IteratorExp unboxed_self = (IteratorExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			Object aA_symbol__1;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				java.lang.String unboxed_A_symbol__2 = unboxed_self.getName();
				final Object A_symbol__2 = unboxed_A_symbol__2; // String
				
				
				Object A_symbol__1 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__2, S_any);
				aA_symbol__1 = A_symbol__1;
			} catch (Exception e) {
				aA_symbol__1 = new InvalidValueImpl(e);
			}
			Object aA_symbol__3;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				org.eclipse.ocl.examples.pivot.OCLExpression unboxed_A_symbol__4 = unboxed_self.getBody();
				final Object A_symbol__4 = valueOf(unboxed_A_symbol__4); // OCLExpression
				
				
				if (A_symbol__4 == null) { throw new InvalidValueException("Null property source"); }
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__5 = unboxed_A_symbol__4.getType();
				final Object A_symbol__5 = createTypeValue(unboxed_A_symbol__5);
				
				
				Object A_symbol__3 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__5, S_Boolean);
				aA_symbol__3 = A_symbol__3;
			} catch (Exception e) {
				aA_symbol__3 = new InvalidValueImpl(e);
			}
			Object A_symbol_ = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, aA_symbol__1, aA_symbol__3);
			
			return A_symbol_;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'AnyHasOneIterator' invariant.
	 */
	public static class _invariant_AnyHasOneIterator extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_AnyHasOneIterator INSTANCE = new _invariant_AnyHasOneIterator();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
		static final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
		static final @NonNull PrimitiveTypeId T_String = TypeId.STRING;
		static final @NonNull Object S_any = "any";
		static final @NonNull ExecutorOperation O_Real__eq_ = OCLstdlibTables.Operations._Real___eq_;
		static final @NonNull PrimitiveTypeId T_Integer = TypeId.INTEGER;
		static final @NonNull ExecutorOperation O_Collection_size = OCLstdlibTables.Operations._Collection__size;
		static final @NonNull PackageId Pk_pivot = IdManager.INSTANCE.getPackageId(PivotPackage.eINSTANCE);
		static final @NonNull TypeId T_pivot__Variable = Pk_pivot.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "Variable");
		static final @NonNull CollectionTypeId T_OrderedSet_pivot__Variable_ = TypeId.ORDERED_SET.getSpecializedId(T_pivot__Variable);
		static final @NonNull IntegerValue I_1 = integerValueOf(1);
		
	
		/*
		name = 'any' implies iterator->size() = 1
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
			assert self != null;
			final @NonNull IteratorExp unboxed_self = (IteratorExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			Object aA_symbol__7;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				java.lang.String unboxed_A_symbol__8 = unboxed_self.getName();
				final Object A_symbol__8 = unboxed_A_symbol__8; // String
				
				
				Object A_symbol__7 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__8, S_any);
				aA_symbol__7 = A_symbol__7;
			} catch (Exception e) {
				aA_symbol__7 = new InvalidValueImpl(e);
			}
			Object aA_symbol__9;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				org.eclipse.emf.common.util.EList<org.eclipse.ocl.examples.pivot.Variable> unboxed_A_symbol__10 = unboxed_self.getIterator();
				assert unboxed_A_symbol__10 != null;
				final @NonNull Value A_symbol__10 = createOrderedSetValue(T_OrderedSet_pivot__Variable_, unboxed_A_symbol__10);
				
				
				Object A_symbol__11 = CollectionSizeOperation.INSTANCE.evaluate(evaluator, T_Integer, A_symbol__10);
				Object A_symbol__9 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__11, I_1);
				aA_symbol__9 = A_symbol__9;
			} catch (Exception e) {
				aA_symbol__9 = new InvalidValueImpl(e);
			}
			Object A_symbol__6 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, aA_symbol__7, aA_symbol__9);
			
			return A_symbol__6;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'AnyTypeIsSourceElementType' invariant.
	 */
	public static class _invariant_AnyTypeIsSourceElementType extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_AnyTypeIsSourceElementType INSTANCE = new _invariant_AnyTypeIsSourceElementType();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
		static final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
		static final @NonNull PrimitiveTypeId T_String = TypeId.STRING;
		static final @NonNull Object S_any = "any";
		static final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
		static final @NonNull PackageId Pk_ocl = IdManager.INSTANCE.getPackageId(OCLstdlibPackage.eINSTANCE);
		static final @NonNull TypeId T_Type = Pk_ocl.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "Type");
		static final @NonNull PackageId Pk_pivot = IdManager.INSTANCE.getPackageId(PivotPackage.eINSTANCE);
		static final @NonNull TypeId T_pivot__CollectionType = Pk_pivot.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "CollectionType");
		static final @NonNull ExecutorOperation O_OclAny_oclAsType = OCLstdlibTables.Operations._OclAny__oclAsType;
		static final @NonNull TypeId T_pivot__OCLExpression = Pk_pivot.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "OCLExpression");
		
	
		/*
		name = 'any' implies type = source.type.oclAsType(CollectionType).elementType
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
			assert self != null;
			final @NonNull IteratorExp unboxed_self = (IteratorExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			final TypeValue Te_Metaclass_pivot__CollectionType_ = createTypeValue(evaluator.getIdResolver().getType(T_pivot__CollectionType, null));
			
			Object aA_symbol__13;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				java.lang.String unboxed_A_symbol__14 = unboxed_self.getName();
				final Object A_symbol__14 = unboxed_A_symbol__14; // String
				
				
				Object A_symbol__13 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__14, S_any);
				aA_symbol__13 = A_symbol__13;
			} catch (Exception e) {
				aA_symbol__13 = new InvalidValueImpl(e);
			}
			Object aA_symbol__15;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__16 = unboxed_self.getType();
				final Object A_symbol__16 = createTypeValue(unboxed_A_symbol__16);
				
				
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				org.eclipse.ocl.examples.pivot.OCLExpression unboxed_A_symbol__17 = unboxed_self.getSource();
				final Object A_symbol__17 = valueOf(unboxed_A_symbol__17); // OCLExpression
				
				
				if (A_symbol__17 == null) { throw new InvalidValueException("Null property source"); }
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__18 = unboxed_A_symbol__17.getType();
				final Object A_symbol__18 = createTypeValue(unboxed_A_symbol__18);
				
				
				Object A_symbol__19 = OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, T_pivot__CollectionType, A_symbol__18, Te_Metaclass_pivot__CollectionType_);
				if (A_symbol__19 == null) { throw new InvalidValueException("Null property source"); }
				assert A_symbol__19 != null;
				CollectionType unboxed_A_symbol__19 = (CollectionType)((TypeValue)A_symbol__19).getInstanceType();
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__20 = unboxed_A_symbol__19.getElementType();
				final Object A_symbol__20 = createTypeValue(unboxed_A_symbol__20);
				
				
				Object A_symbol__15 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__16, A_symbol__20);
				aA_symbol__15 = A_symbol__15;
			} catch (Exception e) {
				aA_symbol__15 = new InvalidValueImpl(e);
			}
			Object A_symbol__12 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, aA_symbol__13, aA_symbol__15);
			
			return A_symbol__12;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'ClosureBodyTypeIsConformanttoIteratorType' invariant.
	 */
	public static class _invariant_ClosureBodyTypeIsConformanttoIteratorType extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_ClosureBodyTypeIsConformanttoIteratorType INSTANCE = new _invariant_ClosureBodyTypeIsConformanttoIteratorType();
		static final @NonNull Object True = true;
		
	
		/*
		true
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
			assert self != null;
			final @NonNull IteratorExp unboxed_self = (IteratorExp)self;
			
			
			return True;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'ClosureElementTypeIsSourceElementType' invariant.
	 */
	public static class _invariant_ClosureElementTypeIsSourceElementType extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_ClosureElementTypeIsSourceElementType INSTANCE = new _invariant_ClosureElementTypeIsSourceElementType();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
		static final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
		static final @NonNull PrimitiveTypeId T_String = TypeId.STRING;
		static final @NonNull Object S_closure = "closure";
		static final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
		static final @NonNull PackageId Pk_ocl = IdManager.INSTANCE.getPackageId(OCLstdlibPackage.eINSTANCE);
		static final @NonNull TypeId T_Type = Pk_ocl.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "Type");
		static final @NonNull PackageId Pk_pivot = IdManager.INSTANCE.getPackageId(PivotPackage.eINSTANCE);
		static final @NonNull TypeId T_pivot__CollectionType = Pk_pivot.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "CollectionType");
		static final @NonNull ExecutorOperation O_OclAny_oclAsType = OCLstdlibTables.Operations._OclAny__oclAsType;
		static final @NonNull TypeId T_pivot__OCLExpression = Pk_pivot.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "OCLExpression");
		
	
		/*
		name = 'closure' implies
	type.oclAsType(CollectionType).elementType =
	source.type.oclAsType(CollectionType).elementType
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
			assert self != null;
			final @NonNull IteratorExp unboxed_self = (IteratorExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			final TypeValue Te_Metaclass_pivot__CollectionType_ = createTypeValue(evaluator.getIdResolver().getType(T_pivot__CollectionType, null));
			
			Object aA_symbol__22;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				java.lang.String unboxed_A_symbol__23 = unboxed_self.getName();
				final Object A_symbol__23 = unboxed_A_symbol__23; // String
				
				
				Object A_symbol__22 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__23, S_closure);
				aA_symbol__22 = A_symbol__22;
			} catch (Exception e) {
				aA_symbol__22 = new InvalidValueImpl(e);
			}
			Object aA_symbol__24;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__25 = unboxed_self.getType();
				final Object A_symbol__25 = createTypeValue(unboxed_A_symbol__25);
				
				
				Object A_symbol__26 = OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, T_pivot__CollectionType, A_symbol__25, Te_Metaclass_pivot__CollectionType_);
				if (A_symbol__26 == null) { throw new InvalidValueException("Null property source"); }
				assert A_symbol__26 != null;
				CollectionType unboxed_A_symbol__26 = (CollectionType)((TypeValue)A_symbol__26).getInstanceType();
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__27 = unboxed_A_symbol__26.getElementType();
				final Object A_symbol__27 = createTypeValue(unboxed_A_symbol__27);
				
				
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				org.eclipse.ocl.examples.pivot.OCLExpression unboxed_A_symbol__28 = unboxed_self.getSource();
				final Object A_symbol__28 = valueOf(unboxed_A_symbol__28); // OCLExpression
				
				
				if (A_symbol__28 == null) { throw new InvalidValueException("Null property source"); }
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__29 = unboxed_A_symbol__28.getType();
				final Object A_symbol__29 = createTypeValue(unboxed_A_symbol__29);
				
				
				Object A_symbol__30 = OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, T_pivot__CollectionType, A_symbol__29, Te_Metaclass_pivot__CollectionType_);
				if (A_symbol__30 == null) { throw new InvalidValueException("Null property source"); }
				assert A_symbol__30 != null;
				CollectionType unboxed_A_symbol__30 = (CollectionType)((TypeValue)A_symbol__30).getInstanceType();
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__31 = unboxed_A_symbol__30.getElementType();
				final Object A_symbol__31 = createTypeValue(unboxed_A_symbol__31);
				
				
				Object A_symbol__24 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__27, A_symbol__31);
				aA_symbol__24 = A_symbol__24;
			} catch (Exception e) {
				aA_symbol__24 = new InvalidValueImpl(e);
			}
			Object A_symbol__21 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, aA_symbol__22, aA_symbol__24);
			
			return A_symbol__21;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'ClosureHasOneIterator' invariant.
	 */
	public static class _invariant_ClosureHasOneIterator extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_ClosureHasOneIterator INSTANCE = new _invariant_ClosureHasOneIterator();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
		static final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
		static final @NonNull PrimitiveTypeId T_String = TypeId.STRING;
		static final @NonNull Object S_closure = "closure";
		static final @NonNull ExecutorOperation O_Real__eq_ = OCLstdlibTables.Operations._Real___eq_;
		static final @NonNull PrimitiveTypeId T_Integer = TypeId.INTEGER;
		static final @NonNull ExecutorOperation O_Collection_size = OCLstdlibTables.Operations._Collection__size;
		static final @NonNull PackageId Pk_pivot = IdManager.INSTANCE.getPackageId(PivotPackage.eINSTANCE);
		static final @NonNull TypeId T_pivot__Variable = Pk_pivot.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "Variable");
		static final @NonNull CollectionTypeId T_OrderedSet_pivot__Variable_ = TypeId.ORDERED_SET.getSpecializedId(T_pivot__Variable);
		static final @NonNull IntegerValue I_1 = integerValueOf(1);
		
	
		/*
		name = 'closure' implies iterator->size() = 1
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
			assert self != null;
			final @NonNull IteratorExp unboxed_self = (IteratorExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			Object aA_symbol__33;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				java.lang.String unboxed_A_symbol__34 = unboxed_self.getName();
				final Object A_symbol__34 = unboxed_A_symbol__34; // String
				
				
				Object A_symbol__33 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__34, S_closure);
				aA_symbol__33 = A_symbol__33;
			} catch (Exception e) {
				aA_symbol__33 = new InvalidValueImpl(e);
			}
			Object aA_symbol__35;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				org.eclipse.emf.common.util.EList<org.eclipse.ocl.examples.pivot.Variable> unboxed_A_symbol__36 = unboxed_self.getIterator();
				assert unboxed_A_symbol__36 != null;
				final @NonNull Value A_symbol__36 = createOrderedSetValue(T_OrderedSet_pivot__Variable_, unboxed_A_symbol__36);
				
				
				Object A_symbol__37 = CollectionSizeOperation.INSTANCE.evaluate(evaluator, T_Integer, A_symbol__36);
				Object A_symbol__35 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__37, I_1);
				aA_symbol__35 = A_symbol__35;
			} catch (Exception e) {
				aA_symbol__35 = new InvalidValueImpl(e);
			}
			Object A_symbol__32 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, aA_symbol__33, aA_symbol__35);
			
			return A_symbol__32;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'ClosureSourceElementTypeIsBodyElementType' invariant.
	 */
	public static class _invariant_ClosureSourceElementTypeIsBodyElementType extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_ClosureSourceElementTypeIsBodyElementType INSTANCE = new _invariant_ClosureSourceElementTypeIsBodyElementType();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
		static final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
		static final @NonNull PrimitiveTypeId T_String = TypeId.STRING;
		static final @NonNull Object S_closure = "closure";
		static final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
		static final @NonNull PackageId Pk_ocl = IdManager.INSTANCE.getPackageId(OCLstdlibPackage.eINSTANCE);
		static final @NonNull TypeId T_Type = Pk_ocl.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "Type");
		static final @NonNull PackageId Pk_pivot = IdManager.INSTANCE.getPackageId(PivotPackage.eINSTANCE);
		static final @NonNull TypeId T_pivot__CollectionType = Pk_pivot.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "CollectionType");
		static final @NonNull ExecutorOperation O_OclAny_oclAsType = OCLstdlibTables.Operations._OclAny__oclAsType;
		static final @NonNull TypeId T_pivot__OCLExpression = Pk_pivot.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "OCLExpression");
		static final @NonNull ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
		
	
		/*
		name = 'closure' implies
	source.type.oclAsType(CollectionType).elementType =
	if body.type.oclIsKindOf(CollectionType)
	then body.type.oclAsType(CollectionType).elementType
	else body.type
	endif
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
			assert self != null;
			final @NonNull IteratorExp unboxed_self = (IteratorExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			final TypeValue Te_Metaclass_pivot__CollectionType_ = createTypeValue(evaluator.getIdResolver().getType(T_pivot__CollectionType, null));
			
			Object aA_symbol__39;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				java.lang.String unboxed_A_symbol__40 = unboxed_self.getName();
				final Object A_symbol__40 = unboxed_A_symbol__40; // String
				
				
				Object A_symbol__39 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__40, S_closure);
				aA_symbol__39 = A_symbol__39;
			} catch (Exception e) {
				aA_symbol__39 = new InvalidValueImpl(e);
			}
			Object aA_symbol__41;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				org.eclipse.ocl.examples.pivot.OCLExpression unboxed_A_symbol__42 = unboxed_self.getSource();
				final Object A_symbol__42 = valueOf(unboxed_A_symbol__42); // OCLExpression
				
				
				if (A_symbol__42 == null) { throw new InvalidValueException("Null property source"); }
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__43 = unboxed_A_symbol__42.getType();
				final Object A_symbol__43 = createTypeValue(unboxed_A_symbol__43);
				
				
				Object A_symbol__44 = OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, T_pivot__CollectionType, A_symbol__43, Te_Metaclass_pivot__CollectionType_);
				if (A_symbol__44 == null) { throw new InvalidValueException("Null property source"); }
				assert A_symbol__44 != null;
				CollectionType unboxed_A_symbol__44 = (CollectionType)((TypeValue)A_symbol__44).getInstanceType();
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__45 = unboxed_A_symbol__44.getElementType();
				final Object A_symbol__45 = createTypeValue(unboxed_A_symbol__45);
				
				
					
					if (self == null) { throw new InvalidValueException("Null property source"); }
					org.eclipse.ocl.examples.pivot.OCLExpression unboxed_A_symbol__46 = unboxed_self.getBody();
					final Object A_symbol__46 = valueOf(unboxed_A_symbol__46); // OCLExpression
					
					
					if (A_symbol__46 == null) { throw new InvalidValueException("Null property source"); }
					org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__47 = unboxed_A_symbol__46.getType();
					final Object A_symbol__47 = createTypeValue(unboxed_A_symbol__47);
					
					
					Object A_symbol__48 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__47, Te_Metaclass_pivot__CollectionType_);
				Object A_symbol__49;
				if (A_symbol__48 == ValuesUtil.TRUE_VALUE) {
					
					if (self == null) { throw new InvalidValueException("Null property source"); }
					org.eclipse.ocl.examples.pivot.OCLExpression unboxed_A_symbol__50 = unboxed_self.getBody();
					final Object A_symbol__50 = valueOf(unboxed_A_symbol__50); // OCLExpression
					
					
					if (A_symbol__50 == null) { throw new InvalidValueException("Null property source"); }
					org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__51 = unboxed_A_symbol__50.getType();
					final Object A_symbol__51 = createTypeValue(unboxed_A_symbol__51);
					
					
					Object A_symbol__52 = OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, T_pivot__CollectionType, A_symbol__51, Te_Metaclass_pivot__CollectionType_);
					if (A_symbol__52 == null) { throw new InvalidValueException("Null property source"); }
					assert A_symbol__52 != null;
					CollectionType unboxed_A_symbol__52 = (CollectionType)((TypeValue)A_symbol__52).getInstanceType();
					org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__53 = unboxed_A_symbol__52.getElementType();
					final Object A_symbol__53 = createTypeValue(unboxed_A_symbol__53);
					
					
					A_symbol__49 = A_symbol__53;
				}
				else if (A_symbol__48 == ValuesUtil.FALSE_VALUE) {
					
					if (self == null) { throw new InvalidValueException("Null property source"); }
					org.eclipse.ocl.examples.pivot.OCLExpression unboxed_A_symbol__54 = unboxed_self.getBody();
					final Object A_symbol__54 = valueOf(unboxed_A_symbol__54); // OCLExpression
					
					
					if (A_symbol__54 == null) { throw new InvalidValueException("Null property source"); }
					org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__55 = unboxed_A_symbol__54.getType();
					final Object A_symbol__55 = createTypeValue(unboxed_A_symbol__55);
					
					
					A_symbol__49 = A_symbol__55;
				}
				else {
					throw new InvalidValueException("non-Boolean if condition");
				}
				Object A_symbol__41 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__45, A_symbol__49);
				aA_symbol__41 = A_symbol__41;
			} catch (Exception e) {
				aA_symbol__41 = new InvalidValueImpl(e);
			}
			Object A_symbol__38 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, aA_symbol__39, aA_symbol__41);
			
			return A_symbol__38;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'ClosureTypeIsUniqueCollection' invariant.
	 */
	public static class _invariant_ClosureTypeIsUniqueCollection extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_ClosureTypeIsUniqueCollection INSTANCE = new _invariant_ClosureTypeIsUniqueCollection();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
		static final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
		static final @NonNull PrimitiveTypeId T_String = TypeId.STRING;
		static final @NonNull Object S_closure = "closure";
		static final @NonNull ExecutorOperation O_Boolean_or = OCLstdlibTables.Operations._Boolean__or;
		static final @NonNull ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
		static final @NonNull PackageId Pk_ocl = IdManager.INSTANCE.getPackageId(OCLstdlibPackage.eINSTANCE);
		static final @NonNull TypeId T_Type = Pk_ocl.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "Type");
		static final @NonNull PackageId Pk_pivot = IdManager.INSTANCE.getPackageId(PivotPackage.eINSTANCE);
		static final @NonNull TypeId T_pivot__OCLExpression = Pk_pivot.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "OCLExpression");
		static final @NonNull TypeId T_pivot__SequenceType = Pk_pivot.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "SequenceType");
		static final @NonNull TypeId T_pivot__OrderedSetType = Pk_pivot.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "OrderedSetType");
		static final @NonNull TypeId T_pivot__SetType = Pk_pivot.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "SetType");
		
	
		/*
		name = 'closure' implies
	if
	  source.type.oclIsKindOf(SequenceType) or
	  source.type.oclIsKindOf(OrderedSetType)
	then type.oclIsKindOf(OrderedSetType)
	else type.oclIsKindOf(SetType)
	endif
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
			assert self != null;
			final @NonNull IteratorExp unboxed_self = (IteratorExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			final TypeValue Te_Metaclass_pivot__SequenceType_ = createTypeValue(evaluator.getIdResolver().getType(T_pivot__SequenceType, null));
			final TypeValue Te_Metaclass_pivot__OrderedSetType_ = createTypeValue(evaluator.getIdResolver().getType(T_pivot__OrderedSetType, null));
			final TypeValue Te_Metaclass_pivot__SetType_ = createTypeValue(evaluator.getIdResolver().getType(T_pivot__SetType, null));
			
			Object aA_symbol__57;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				java.lang.String unboxed_A_symbol__58 = unboxed_self.getName();
				final Object A_symbol__58 = unboxed_A_symbol__58; // String
				
				
				Object A_symbol__57 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__58, S_closure);
				aA_symbol__57 = A_symbol__57;
			} catch (Exception e) {
				aA_symbol__57 = new InvalidValueImpl(e);
			}
			Object aA_symbol__59;
			try {
					Object aA_symbol__61;
					try {
						
						if (self == null) { throw new InvalidValueException("Null property source"); }
						org.eclipse.ocl.examples.pivot.OCLExpression unboxed_A_symbol__62 = unboxed_self.getSource();
						final Object A_symbol__62 = valueOf(unboxed_A_symbol__62); // OCLExpression
						
						
						if (A_symbol__62 == null) { throw new InvalidValueException("Null property source"); }
						org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__63 = unboxed_A_symbol__62.getType();
						final Object A_symbol__63 = createTypeValue(unboxed_A_symbol__63);
						
						
						Object A_symbol__61 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__63, Te_Metaclass_pivot__SequenceType_);
						aA_symbol__61 = A_symbol__61;
					} catch (Exception e) {
						aA_symbol__61 = new InvalidValueImpl(e);
					}
					Object aA_symbol__64;
					try {
						
						if (self == null) { throw new InvalidValueException("Null property source"); }
						org.eclipse.ocl.examples.pivot.OCLExpression unboxed_A_symbol__65 = unboxed_self.getSource();
						final Object A_symbol__65 = valueOf(unboxed_A_symbol__65); // OCLExpression
						
						
						if (A_symbol__65 == null) { throw new InvalidValueException("Null property source"); }
						org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__66 = unboxed_A_symbol__65.getType();
						final Object A_symbol__66 = createTypeValue(unboxed_A_symbol__66);
						
						
						Object A_symbol__64 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__66, Te_Metaclass_pivot__OrderedSetType_);
						aA_symbol__64 = A_symbol__64;
					} catch (Exception e) {
						aA_symbol__64 = new InvalidValueImpl(e);
					}
					Object A_symbol__60 = BooleanOrOperation.INSTANCE.evaluate(evaluator, T_Boolean, aA_symbol__61, aA_symbol__64);
					
				Object A_symbol__59;
				if (A_symbol__60 == ValuesUtil.TRUE_VALUE) {
					
					if (self == null) { throw new InvalidValueException("Null property source"); }
					org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__67 = unboxed_self.getType();
					final Object A_symbol__67 = createTypeValue(unboxed_A_symbol__67);
					
					
					Object A_symbol__68 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__67, Te_Metaclass_pivot__OrderedSetType_);
					A_symbol__59 = A_symbol__68;
				}
				else if (A_symbol__60 == ValuesUtil.FALSE_VALUE) {
					
					if (self == null) { throw new InvalidValueException("Null property source"); }
					org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__69 = unboxed_self.getType();
					final Object A_symbol__69 = createTypeValue(unboxed_A_symbol__69);
					
					
					Object A_symbol__70 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__69, Te_Metaclass_pivot__SetType_);
					A_symbol__59 = A_symbol__70;
				}
				else {
					throw new InvalidValueException("non-Boolean if condition");
				}
				aA_symbol__59 = A_symbol__59;
			} catch (Exception e) {
				aA_symbol__59 = new InvalidValueImpl(e);
			}
			Object A_symbol__56 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, aA_symbol__57, aA_symbol__59);
			
			return A_symbol__56;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'CollectElementTypeIsSourceElementType' invariant.
	 */
	public static class _invariant_CollectElementTypeIsSourceElementType extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_CollectElementTypeIsSourceElementType INSTANCE = new _invariant_CollectElementTypeIsSourceElementType();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
		static final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
		static final @NonNull PrimitiveTypeId T_String = TypeId.STRING;
		static final @NonNull Object S_collect = "collect";
		static final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
		static final @NonNull PackageId Pk_ocl = IdManager.INSTANCE.getPackageId(OCLstdlibPackage.eINSTANCE);
		static final @NonNull TypeId T_Type = Pk_ocl.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "Type");
		static final @NonNull PackageId Pk_pivot = IdManager.INSTANCE.getPackageId(PivotPackage.eINSTANCE);
		static final @NonNull TypeId T_pivot__CollectionType = Pk_pivot.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "CollectionType");
		static final @NonNull ExecutorOperation O_OclAny_oclAsType = OCLstdlibTables.Operations._OclAny__oclAsType;
		static final @NonNull TypeId T_pivot__OCLExpression = Pk_pivot.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "OCLExpression");
		
	
		/*
		name = 'collect' implies
	type.oclAsType(CollectionType).elementType =
	body.type.oclAsType(CollectionType).elementType
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
			assert self != null;
			final @NonNull IteratorExp unboxed_self = (IteratorExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			final TypeValue Te_Metaclass_pivot__CollectionType_ = createTypeValue(evaluator.getIdResolver().getType(T_pivot__CollectionType, null));
			
			Object aA_symbol__72;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				java.lang.String unboxed_A_symbol__73 = unboxed_self.getName();
				final Object A_symbol__73 = unboxed_A_symbol__73; // String
				
				
				Object A_symbol__72 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__73, S_collect);
				aA_symbol__72 = A_symbol__72;
			} catch (Exception e) {
				aA_symbol__72 = new InvalidValueImpl(e);
			}
			Object aA_symbol__74;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__75 = unboxed_self.getType();
				final Object A_symbol__75 = createTypeValue(unboxed_A_symbol__75);
				
				
				Object A_symbol__76 = OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, T_pivot__CollectionType, A_symbol__75, Te_Metaclass_pivot__CollectionType_);
				if (A_symbol__76 == null) { throw new InvalidValueException("Null property source"); }
				assert A_symbol__76 != null;
				CollectionType unboxed_A_symbol__76 = (CollectionType)((TypeValue)A_symbol__76).getInstanceType();
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__77 = unboxed_A_symbol__76.getElementType();
				final Object A_symbol__77 = createTypeValue(unboxed_A_symbol__77);
				
				
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				org.eclipse.ocl.examples.pivot.OCLExpression unboxed_A_symbol__78 = unboxed_self.getBody();
				final Object A_symbol__78 = valueOf(unboxed_A_symbol__78); // OCLExpression
				
				
				if (A_symbol__78 == null) { throw new InvalidValueException("Null property source"); }
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__79 = unboxed_A_symbol__78.getType();
				final Object A_symbol__79 = createTypeValue(unboxed_A_symbol__79);
				
				
				Object A_symbol__80 = OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, T_pivot__CollectionType, A_symbol__79, Te_Metaclass_pivot__CollectionType_);
				if (A_symbol__80 == null) { throw new InvalidValueException("Null property source"); }
				assert A_symbol__80 != null;
				CollectionType unboxed_A_symbol__80 = (CollectionType)((TypeValue)A_symbol__80).getInstanceType();
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__81 = unboxed_A_symbol__80.getElementType();
				final Object A_symbol__81 = createTypeValue(unboxed_A_symbol__81);
				
				
				Object A_symbol__74 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__77, A_symbol__81);
				aA_symbol__74 = A_symbol__74;
			} catch (Exception e) {
				aA_symbol__74 = new InvalidValueImpl(e);
			}
			Object A_symbol__71 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, aA_symbol__72, aA_symbol__74);
			
			return A_symbol__71;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'CollectHasOneIterator' invariant.
	 */
	public static class _invariant_CollectHasOneIterator extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_CollectHasOneIterator INSTANCE = new _invariant_CollectHasOneIterator();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
		static final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
		static final @NonNull PrimitiveTypeId T_String = TypeId.STRING;
		static final @NonNull Object S_collect = "collect";
		static final @NonNull ExecutorOperation O_Real__eq_ = OCLstdlibTables.Operations._Real___eq_;
		static final @NonNull PrimitiveTypeId T_Integer = TypeId.INTEGER;
		static final @NonNull ExecutorOperation O_Collection_size = OCLstdlibTables.Operations._Collection__size;
		static final @NonNull PackageId Pk_pivot = IdManager.INSTANCE.getPackageId(PivotPackage.eINSTANCE);
		static final @NonNull TypeId T_pivot__Variable = Pk_pivot.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "Variable");
		static final @NonNull CollectionTypeId T_OrderedSet_pivot__Variable_ = TypeId.ORDERED_SET.getSpecializedId(T_pivot__Variable);
		static final @NonNull IntegerValue I_1 = integerValueOf(1);
		
	
		/*
		name = 'collect' implies iterator->size() = 1
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
			assert self != null;
			final @NonNull IteratorExp unboxed_self = (IteratorExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			Object aA_symbol__83;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				java.lang.String unboxed_A_symbol__84 = unboxed_self.getName();
				final Object A_symbol__84 = unboxed_A_symbol__84; // String
				
				
				Object A_symbol__83 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__84, S_collect);
				aA_symbol__83 = A_symbol__83;
			} catch (Exception e) {
				aA_symbol__83 = new InvalidValueImpl(e);
			}
			Object aA_symbol__85;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				org.eclipse.emf.common.util.EList<org.eclipse.ocl.examples.pivot.Variable> unboxed_A_symbol__86 = unboxed_self.getIterator();
				assert unboxed_A_symbol__86 != null;
				final @NonNull Value A_symbol__86 = createOrderedSetValue(T_OrderedSet_pivot__Variable_, unboxed_A_symbol__86);
				
				
				Object A_symbol__87 = CollectionSizeOperation.INSTANCE.evaluate(evaluator, T_Integer, A_symbol__86);
				Object A_symbol__85 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__87, I_1);
				aA_symbol__85 = A_symbol__85;
			} catch (Exception e) {
				aA_symbol__85 = new InvalidValueImpl(e);
			}
			Object A_symbol__82 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, aA_symbol__83, aA_symbol__85);
			
			return A_symbol__82;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'CollectNestedHasOneIterator' invariant.
	 */
	public static class _invariant_CollectNestedHasOneIterator extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_CollectNestedHasOneIterator INSTANCE = new _invariant_CollectNestedHasOneIterator();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
		static final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
		static final @NonNull PrimitiveTypeId T_String = TypeId.STRING;
		static final @NonNull Object S_collectN___ = "collectNested";
		static final @NonNull ExecutorOperation O_Real__eq_ = OCLstdlibTables.Operations._Real___eq_;
		static final @NonNull PrimitiveTypeId T_Integer = TypeId.INTEGER;
		static final @NonNull ExecutorOperation O_Collection_size = OCLstdlibTables.Operations._Collection__size;
		static final @NonNull PackageId Pk_pivot = IdManager.INSTANCE.getPackageId(PivotPackage.eINSTANCE);
		static final @NonNull TypeId T_pivot__Variable = Pk_pivot.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "Variable");
		static final @NonNull CollectionTypeId T_OrderedSet_pivot__Variable_ = TypeId.ORDERED_SET.getSpecializedId(T_pivot__Variable);
		static final @NonNull IntegerValue I_1 = integerValueOf(1);
		
	
		/*
		name = 'collectNested' implies iterator->size() = 1
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
			assert self != null;
			final @NonNull IteratorExp unboxed_self = (IteratorExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			Object aA_symbol__89;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				java.lang.String unboxed_A_symbol__90 = unboxed_self.getName();
				final Object A_symbol__90 = unboxed_A_symbol__90; // String
				
				
				Object A_symbol__89 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__90, S_collectN___);
				aA_symbol__89 = A_symbol__89;
			} catch (Exception e) {
				aA_symbol__89 = new InvalidValueImpl(e);
			}
			Object aA_symbol__91;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				org.eclipse.emf.common.util.EList<org.eclipse.ocl.examples.pivot.Variable> unboxed_A_symbol__92 = unboxed_self.getIterator();
				assert unboxed_A_symbol__92 != null;
				final @NonNull Value A_symbol__92 = createOrderedSetValue(T_OrderedSet_pivot__Variable_, unboxed_A_symbol__92);
				
				
				Object A_symbol__93 = CollectionSizeOperation.INSTANCE.evaluate(evaluator, T_Integer, A_symbol__92);
				Object A_symbol__91 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__93, I_1);
				aA_symbol__91 = A_symbol__91;
			} catch (Exception e) {
				aA_symbol__91 = new InvalidValueImpl(e);
			}
			Object A_symbol__88 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, aA_symbol__89, aA_symbol__91);
			
			return A_symbol__88;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'CollectNestedTypeIsBag' invariant.
	 */
	public static class _invariant_CollectNestedTypeIsBag extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_CollectNestedTypeIsBag INSTANCE = new _invariant_CollectNestedTypeIsBag();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
		static final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
		static final @NonNull PrimitiveTypeId T_String = TypeId.STRING;
		static final @NonNull Object S_collectN___ = "collectNested";
		static final @NonNull ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
		static final @NonNull PackageId Pk_ocl = IdManager.INSTANCE.getPackageId(OCLstdlibPackage.eINSTANCE);
		static final @NonNull TypeId T_Type = Pk_ocl.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "Type");
		static final @NonNull PackageId Pk_pivot = IdManager.INSTANCE.getPackageId(PivotPackage.eINSTANCE);
		static final @NonNull TypeId T_pivot__BagType = Pk_pivot.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "BagType");
		
	
		/*
		name = 'collectNested' implies type.oclIsKindOf(BagType)
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
			assert self != null;
			final @NonNull IteratorExp unboxed_self = (IteratorExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			final TypeValue Te_Metaclass_pivot__BagType_ = createTypeValue(evaluator.getIdResolver().getType(T_pivot__BagType, null));
			
			Object aA_symbol__95;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				java.lang.String unboxed_A_symbol__96 = unboxed_self.getName();
				final Object A_symbol__96 = unboxed_A_symbol__96; // String
				
				
				Object A_symbol__95 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__96, S_collectN___);
				aA_symbol__95 = A_symbol__95;
			} catch (Exception e) {
				aA_symbol__95 = new InvalidValueImpl(e);
			}
			Object aA_symbol__97;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__98 = unboxed_self.getType();
				final Object A_symbol__98 = createTypeValue(unboxed_A_symbol__98);
				
				
				Object A_symbol__97 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__98, Te_Metaclass_pivot__BagType_);
				aA_symbol__97 = A_symbol__97;
			} catch (Exception e) {
				aA_symbol__97 = new InvalidValueImpl(e);
			}
			Object A_symbol__94 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, aA_symbol__95, aA_symbol__97);
			
			return A_symbol__94;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'CollectNestedTypeIsBodyType' invariant.
	 */
	public static class _invariant_CollectNestedTypeIsBodyType extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_CollectNestedTypeIsBodyType INSTANCE = new _invariant_CollectNestedTypeIsBodyType();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
		static final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
		static final @NonNull PrimitiveTypeId T_String = TypeId.STRING;
		static final @NonNull Object S_collectN___ = "collectNested";
		static final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
		static final @NonNull PackageId Pk_ocl = IdManager.INSTANCE.getPackageId(OCLstdlibPackage.eINSTANCE);
		static final @NonNull TypeId T_Type = Pk_ocl.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "Type");
		static final @NonNull PackageId Pk_pivot = IdManager.INSTANCE.getPackageId(PivotPackage.eINSTANCE);
		static final @NonNull TypeId T_pivot__OCLExpression = Pk_pivot.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "OCLExpression");
		
	
		/*
		name = 'collectNested' implies type = body.type
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
			assert self != null;
			final @NonNull IteratorExp unboxed_self = (IteratorExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			Object aA_symbol__100;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				java.lang.String unboxed_A_symbol__101 = unboxed_self.getName();
				final Object A_symbol__101 = unboxed_A_symbol__101; // String
				
				
				Object A_symbol__100 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__101, S_collectN___);
				aA_symbol__100 = A_symbol__100;
			} catch (Exception e) {
				aA_symbol__100 = new InvalidValueImpl(e);
			}
			Object aA_symbol__102;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__103 = unboxed_self.getType();
				final Object A_symbol__103 = createTypeValue(unboxed_A_symbol__103);
				
				
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				org.eclipse.ocl.examples.pivot.OCLExpression unboxed_A_symbol__104 = unboxed_self.getBody();
				final Object A_symbol__104 = valueOf(unboxed_A_symbol__104); // OCLExpression
				
				
				if (A_symbol__104 == null) { throw new InvalidValueException("Null property source"); }
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__105 = unboxed_A_symbol__104.getType();
				final Object A_symbol__105 = createTypeValue(unboxed_A_symbol__105);
				
				
				Object A_symbol__102 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__103, A_symbol__105);
				aA_symbol__102 = A_symbol__102;
			} catch (Exception e) {
				aA_symbol__102 = new InvalidValueImpl(e);
			}
			Object A_symbol__99 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, aA_symbol__100, aA_symbol__102);
			
			return A_symbol__99;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'CollectTypeIsUnordered' invariant.
	 */
	public static class _invariant_CollectTypeIsUnordered extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_CollectTypeIsUnordered INSTANCE = new _invariant_CollectTypeIsUnordered();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
		static final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
		static final @NonNull PrimitiveTypeId T_String = TypeId.STRING;
		static final @NonNull Object S_collect = "collect";
		static final @NonNull ExecutorOperation O_Boolean_or = OCLstdlibTables.Operations._Boolean__or;
		static final @NonNull ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
		static final @NonNull PackageId Pk_ocl = IdManager.INSTANCE.getPackageId(OCLstdlibPackage.eINSTANCE);
		static final @NonNull TypeId T_Type = Pk_ocl.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "Type");
		static final @NonNull PackageId Pk_pivot = IdManager.INSTANCE.getPackageId(PivotPackage.eINSTANCE);
		static final @NonNull TypeId T_pivot__OCLExpression = Pk_pivot.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "OCLExpression");
		static final @NonNull TypeId T_pivot__SequenceType = Pk_pivot.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "SequenceType");
		static final @NonNull TypeId T_pivot__OrderedSetType = Pk_pivot.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "OrderedSetType");
		static final @NonNull TypeId T_pivot__BagType = Pk_pivot.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "BagType");
		
	
		/*
		name = 'collect' implies
	if
	  source.type.oclIsKindOf(SequenceType) or
	  source.type.oclIsKindOf(OrderedSetType)
	then type.oclIsKindOf(SequenceType)
	else type.oclIsKindOf(BagType)
	endif
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
			assert self != null;
			final @NonNull IteratorExp unboxed_self = (IteratorExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			final TypeValue Te_Metaclass_pivot__SequenceType_ = createTypeValue(evaluator.getIdResolver().getType(T_pivot__SequenceType, null));
			final TypeValue Te_Metaclass_pivot__OrderedSetType_ = createTypeValue(evaluator.getIdResolver().getType(T_pivot__OrderedSetType, null));
			final TypeValue Te_Metaclass_pivot__BagType_ = createTypeValue(evaluator.getIdResolver().getType(T_pivot__BagType, null));
			
			Object aA_symbol__107;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				java.lang.String unboxed_A_symbol__108 = unboxed_self.getName();
				final Object A_symbol__108 = unboxed_A_symbol__108; // String
				
				
				Object A_symbol__107 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__108, S_collect);
				aA_symbol__107 = A_symbol__107;
			} catch (Exception e) {
				aA_symbol__107 = new InvalidValueImpl(e);
			}
			Object aA_symbol__109;
			try {
					Object aA_symbol__111;
					try {
						
						if (self == null) { throw new InvalidValueException("Null property source"); }
						org.eclipse.ocl.examples.pivot.OCLExpression unboxed_A_symbol__112 = unboxed_self.getSource();
						final Object A_symbol__112 = valueOf(unboxed_A_symbol__112); // OCLExpression
						
						
						if (A_symbol__112 == null) { throw new InvalidValueException("Null property source"); }
						org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__113 = unboxed_A_symbol__112.getType();
						final Object A_symbol__113 = createTypeValue(unboxed_A_symbol__113);
						
						
						Object A_symbol__111 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__113, Te_Metaclass_pivot__SequenceType_);
						aA_symbol__111 = A_symbol__111;
					} catch (Exception e) {
						aA_symbol__111 = new InvalidValueImpl(e);
					}
					Object aA_symbol__114;
					try {
						
						if (self == null) { throw new InvalidValueException("Null property source"); }
						org.eclipse.ocl.examples.pivot.OCLExpression unboxed_A_symbol__115 = unboxed_self.getSource();
						final Object A_symbol__115 = valueOf(unboxed_A_symbol__115); // OCLExpression
						
						
						if (A_symbol__115 == null) { throw new InvalidValueException("Null property source"); }
						org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__116 = unboxed_A_symbol__115.getType();
						final Object A_symbol__116 = createTypeValue(unboxed_A_symbol__116);
						
						
						Object A_symbol__114 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__116, Te_Metaclass_pivot__OrderedSetType_);
						aA_symbol__114 = A_symbol__114;
					} catch (Exception e) {
						aA_symbol__114 = new InvalidValueImpl(e);
					}
					Object A_symbol__110 = BooleanOrOperation.INSTANCE.evaluate(evaluator, T_Boolean, aA_symbol__111, aA_symbol__114);
					
				Object A_symbol__109;
				if (A_symbol__110 == ValuesUtil.TRUE_VALUE) {
					
					if (self == null) { throw new InvalidValueException("Null property source"); }
					org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__117 = unboxed_self.getType();
					final Object A_symbol__117 = createTypeValue(unboxed_A_symbol__117);
					
					
					Object A_symbol__118 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__117, Te_Metaclass_pivot__SequenceType_);
					A_symbol__109 = A_symbol__118;
				}
				else if (A_symbol__110 == ValuesUtil.FALSE_VALUE) {
					
					if (self == null) { throw new InvalidValueException("Null property source"); }
					org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__119 = unboxed_self.getType();
					final Object A_symbol__119 = createTypeValue(unboxed_A_symbol__119);
					
					
					Object A_symbol__120 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__119, Te_Metaclass_pivot__BagType_);
					A_symbol__109 = A_symbol__120;
				}
				else {
					throw new InvalidValueException("non-Boolean if condition");
				}
				aA_symbol__109 = A_symbol__109;
			} catch (Exception e) {
				aA_symbol__109 = new InvalidValueImpl(e);
			}
			Object A_symbol__106 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, aA_symbol__107, aA_symbol__109);
			
			return A_symbol__106;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'ExistsBodyTypeIsBoolean' invariant.
	 */
	public static class _invariant_ExistsBodyTypeIsBoolean extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_ExistsBodyTypeIsBoolean INSTANCE = new _invariant_ExistsBodyTypeIsBoolean();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
		static final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
		static final @NonNull PrimitiveTypeId T_String = TypeId.STRING;
		static final @NonNull Object S_exists = "exists";
		static final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
		static final @NonNull PackageId Pk_ocl = IdManager.INSTANCE.getPackageId(OCLstdlibPackage.eINSTANCE);
		static final @NonNull TypeId T_Type = Pk_ocl.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "Type");
		static final @NonNull PackageId Pk_pivot = IdManager.INSTANCE.getPackageId(PivotPackage.eINSTANCE);
		static final @NonNull TypeId T_pivot__OCLExpression = Pk_pivot.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "OCLExpression");
		
	
		/*
		name = 'exists' implies body.type = Boolean
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
			assert self != null;
			final @NonNull IteratorExp unboxed_self = (IteratorExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			final TypeValue Te_Metaclass_Boolean_ = createTypeValue(evaluator.getIdResolver().getType(T_Boolean, null));
			
			Object aA_symbol__122;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				java.lang.String unboxed_A_symbol__123 = unboxed_self.getName();
				final Object A_symbol__123 = unboxed_A_symbol__123; // String
				
				
				Object A_symbol__122 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__123, S_exists);
				aA_symbol__122 = A_symbol__122;
			} catch (Exception e) {
				aA_symbol__122 = new InvalidValueImpl(e);
			}
			Object aA_symbol__124;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				org.eclipse.ocl.examples.pivot.OCLExpression unboxed_A_symbol__125 = unboxed_self.getBody();
				final Object A_symbol__125 = valueOf(unboxed_A_symbol__125); // OCLExpression
				
				
				if (A_symbol__125 == null) { throw new InvalidValueException("Null property source"); }
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__126 = unboxed_A_symbol__125.getType();
				final Object A_symbol__126 = createTypeValue(unboxed_A_symbol__126);
				
				
				Object A_symbol__124 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__126, Te_Metaclass_Boolean_);
				aA_symbol__124 = A_symbol__124;
			} catch (Exception e) {
				aA_symbol__124 = new InvalidValueImpl(e);
			}
			Object A_symbol__121 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, aA_symbol__122, aA_symbol__124);
			
			return A_symbol__121;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'ExistsTypeIsBoolean' invariant.
	 */
	public static class _invariant_ExistsTypeIsBoolean extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_ExistsTypeIsBoolean INSTANCE = new _invariant_ExistsTypeIsBoolean();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
		static final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
		static final @NonNull PrimitiveTypeId T_String = TypeId.STRING;
		static final @NonNull Object S_exists = "exists";
		static final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
		static final @NonNull PackageId Pk_ocl = IdManager.INSTANCE.getPackageId(OCLstdlibPackage.eINSTANCE);
		static final @NonNull TypeId T_Type = Pk_ocl.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "Type");
		
	
		/*
		name = 'exists' implies type = Boolean
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
			assert self != null;
			final @NonNull IteratorExp unboxed_self = (IteratorExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			final TypeValue Te_Metaclass_Boolean_ = createTypeValue(evaluator.getIdResolver().getType(T_Boolean, null));
			
			Object aA_symbol__128;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				java.lang.String unboxed_A_symbol__129 = unboxed_self.getName();
				final Object A_symbol__129 = unboxed_A_symbol__129; // String
				
				
				Object A_symbol__128 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__129, S_exists);
				aA_symbol__128 = A_symbol__128;
			} catch (Exception e) {
				aA_symbol__128 = new InvalidValueImpl(e);
			}
			Object aA_symbol__130;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__131 = unboxed_self.getType();
				final Object A_symbol__131 = createTypeValue(unboxed_A_symbol__131);
				
				
				Object A_symbol__130 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__131, Te_Metaclass_Boolean_);
				aA_symbol__130 = A_symbol__130;
			} catch (Exception e) {
				aA_symbol__130 = new InvalidValueImpl(e);
			}
			Object A_symbol__127 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, aA_symbol__128, aA_symbol__130);
			
			return A_symbol__127;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'ForAllBodyTypeIsBoolean' invariant.
	 */
	public static class _invariant_ForAllBodyTypeIsBoolean extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_ForAllBodyTypeIsBoolean INSTANCE = new _invariant_ForAllBodyTypeIsBoolean();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
		static final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
		static final @NonNull PrimitiveTypeId T_String = TypeId.STRING;
		static final @NonNull Object S_forAll = "forAll";
		static final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
		static final @NonNull PackageId Pk_ocl = IdManager.INSTANCE.getPackageId(OCLstdlibPackage.eINSTANCE);
		static final @NonNull TypeId T_Type = Pk_ocl.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "Type");
		static final @NonNull PackageId Pk_pivot = IdManager.INSTANCE.getPackageId(PivotPackage.eINSTANCE);
		static final @NonNull TypeId T_pivot__OCLExpression = Pk_pivot.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "OCLExpression");
		
	
		/*
		name = 'forAll' implies body.type = Boolean
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
			assert self != null;
			final @NonNull IteratorExp unboxed_self = (IteratorExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			final TypeValue Te_Metaclass_Boolean_ = createTypeValue(evaluator.getIdResolver().getType(T_Boolean, null));
			
			Object aA_symbol__133;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				java.lang.String unboxed_A_symbol__134 = unboxed_self.getName();
				final Object A_symbol__134 = unboxed_A_symbol__134; // String
				
				
				Object A_symbol__133 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__134, S_forAll);
				aA_symbol__133 = A_symbol__133;
			} catch (Exception e) {
				aA_symbol__133 = new InvalidValueImpl(e);
			}
			Object aA_symbol__135;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				org.eclipse.ocl.examples.pivot.OCLExpression unboxed_A_symbol__136 = unboxed_self.getBody();
				final Object A_symbol__136 = valueOf(unboxed_A_symbol__136); // OCLExpression
				
				
				if (A_symbol__136 == null) { throw new InvalidValueException("Null property source"); }
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__137 = unboxed_A_symbol__136.getType();
				final Object A_symbol__137 = createTypeValue(unboxed_A_symbol__137);
				
				
				Object A_symbol__135 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__137, Te_Metaclass_Boolean_);
				aA_symbol__135 = A_symbol__135;
			} catch (Exception e) {
				aA_symbol__135 = new InvalidValueImpl(e);
			}
			Object A_symbol__132 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, aA_symbol__133, aA_symbol__135);
			
			return A_symbol__132;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'ForAllTypeIsBoolean' invariant.
	 */
	public static class _invariant_ForAllTypeIsBoolean extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_ForAllTypeIsBoolean INSTANCE = new _invariant_ForAllTypeIsBoolean();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
		static final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
		static final @NonNull PrimitiveTypeId T_String = TypeId.STRING;
		static final @NonNull Object S_forAll = "forAll";
		static final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
		static final @NonNull PackageId Pk_ocl = IdManager.INSTANCE.getPackageId(OCLstdlibPackage.eINSTANCE);
		static final @NonNull TypeId T_Type = Pk_ocl.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "Type");
		
	
		/*
		name = 'forAll' implies type = Boolean
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
			assert self != null;
			final @NonNull IteratorExp unboxed_self = (IteratorExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			final TypeValue Te_Metaclass_Boolean_ = createTypeValue(evaluator.getIdResolver().getType(T_Boolean, null));
			
			Object aA_symbol__139;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				java.lang.String unboxed_A_symbol__140 = unboxed_self.getName();
				final Object A_symbol__140 = unboxed_A_symbol__140; // String
				
				
				Object A_symbol__139 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__140, S_forAll);
				aA_symbol__139 = A_symbol__139;
			} catch (Exception e) {
				aA_symbol__139 = new InvalidValueImpl(e);
			}
			Object aA_symbol__141;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__142 = unboxed_self.getType();
				final Object A_symbol__142 = createTypeValue(unboxed_A_symbol__142);
				
				
				Object A_symbol__141 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__142, Te_Metaclass_Boolean_);
				aA_symbol__141 = A_symbol__141;
			} catch (Exception e) {
				aA_symbol__141 = new InvalidValueImpl(e);
			}
			Object A_symbol__138 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, aA_symbol__139, aA_symbol__141);
			
			return A_symbol__138;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'IsUniqueHasOneIterator' invariant.
	 */
	public static class _invariant_IsUniqueHasOneIterator extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_IsUniqueHasOneIterator INSTANCE = new _invariant_IsUniqueHasOneIterator();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
		static final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
		static final @NonNull PrimitiveTypeId T_String = TypeId.STRING;
		static final @NonNull Object S_isUnique = "isUnique";
		static final @NonNull ExecutorOperation O_Real__eq_ = OCLstdlibTables.Operations._Real___eq_;
		static final @NonNull PrimitiveTypeId T_Integer = TypeId.INTEGER;
		static final @NonNull ExecutorOperation O_Collection_size = OCLstdlibTables.Operations._Collection__size;
		static final @NonNull PackageId Pk_pivot = IdManager.INSTANCE.getPackageId(PivotPackage.eINSTANCE);
		static final @NonNull TypeId T_pivot__Variable = Pk_pivot.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "Variable");
		static final @NonNull CollectionTypeId T_OrderedSet_pivot__Variable_ = TypeId.ORDERED_SET.getSpecializedId(T_pivot__Variable);
		static final @NonNull IntegerValue I_1 = integerValueOf(1);
		
	
		/*
		name = 'isUnique' implies iterator->size() = 1
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
			assert self != null;
			final @NonNull IteratorExp unboxed_self = (IteratorExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			Object aA_symbol__144;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				java.lang.String unboxed_A_symbol__145 = unboxed_self.getName();
				final Object A_symbol__145 = unboxed_A_symbol__145; // String
				
				
				Object A_symbol__144 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__145, S_isUnique);
				aA_symbol__144 = A_symbol__144;
			} catch (Exception e) {
				aA_symbol__144 = new InvalidValueImpl(e);
			}
			Object aA_symbol__146;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				org.eclipse.emf.common.util.EList<org.eclipse.ocl.examples.pivot.Variable> unboxed_A_symbol__147 = unboxed_self.getIterator();
				assert unboxed_A_symbol__147 != null;
				final @NonNull Value A_symbol__147 = createOrderedSetValue(T_OrderedSet_pivot__Variable_, unboxed_A_symbol__147);
				
				
				Object A_symbol__148 = CollectionSizeOperation.INSTANCE.evaluate(evaluator, T_Integer, A_symbol__147);
				Object A_symbol__146 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__148, I_1);
				aA_symbol__146 = A_symbol__146;
			} catch (Exception e) {
				aA_symbol__146 = new InvalidValueImpl(e);
			}
			Object A_symbol__143 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, aA_symbol__144, aA_symbol__146);
			
			return A_symbol__143;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'IsUniqueTypeIsBoolean' invariant.
	 */
	public static class _invariant_IsUniqueTypeIsBoolean extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_IsUniqueTypeIsBoolean INSTANCE = new _invariant_IsUniqueTypeIsBoolean();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
		static final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
		static final @NonNull PrimitiveTypeId T_String = TypeId.STRING;
		static final @NonNull Object S_isUnique = "isUnique";
		static final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
		static final @NonNull PackageId Pk_ocl = IdManager.INSTANCE.getPackageId(OCLstdlibPackage.eINSTANCE);
		static final @NonNull TypeId T_Type = Pk_ocl.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "Type");
		
	
		/*
		name = 'isUnique' implies type = Boolean
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
			assert self != null;
			final @NonNull IteratorExp unboxed_self = (IteratorExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			final TypeValue Te_Metaclass_Boolean_ = createTypeValue(evaluator.getIdResolver().getType(T_Boolean, null));
			
			Object aA_symbol__150;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				java.lang.String unboxed_A_symbol__151 = unboxed_self.getName();
				final Object A_symbol__151 = unboxed_A_symbol__151; // String
				
				
				Object A_symbol__150 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__151, S_isUnique);
				aA_symbol__150 = A_symbol__150;
			} catch (Exception e) {
				aA_symbol__150 = new InvalidValueImpl(e);
			}
			Object aA_symbol__152;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__153 = unboxed_self.getType();
				final Object A_symbol__153 = createTypeValue(unboxed_A_symbol__153);
				
				
				Object A_symbol__152 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__153, Te_Metaclass_Boolean_);
				aA_symbol__152 = A_symbol__152;
			} catch (Exception e) {
				aA_symbol__152 = new InvalidValueImpl(e);
			}
			Object A_symbol__149 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, aA_symbol__150, aA_symbol__152);
			
			return A_symbol__149;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'IteratorTypeIsSourceElementType' invariant.
	 */
	public static class _invariant_IteratorTypeIsSourceElementType extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_IteratorTypeIsSourceElementType INSTANCE = new _invariant_IteratorTypeIsSourceElementType();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Collection_forAll = OCLstdlibTables.Operations._Collection__1_forAll;
		static final @NonNull PackageId Pk_pivot = IdManager.INSTANCE.getPackageId(PivotPackage.eINSTANCE);
		static final @NonNull TypeId T_pivot__Variable = Pk_pivot.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "Variable");
		static final @NonNull CollectionTypeId T_OrderedSet_pivot__Variable_ = TypeId.ORDERED_SET.getSpecializedId(T_pivot__Variable);
		static final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
		static final @NonNull PackageId Pk_ocl = IdManager.INSTANCE.getPackageId(OCLstdlibPackage.eINSTANCE);
		static final @NonNull TypeId T_Type = Pk_ocl.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "Type");
		static final @NonNull TypeId T_pivot__CollectionType = Pk_pivot.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "CollectionType");
		static final @NonNull ExecutorOperation O_OclAny_oclAsType = OCLstdlibTables.Operations._OclAny__oclAsType;
		static final @NonNull TypeId T_pivot__OCLExpression = Pk_pivot.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "OCLExpression");
		
	
		/*
		self.iterator->forAll(type =
	  source.type.oclAsType(CollectionType).elementType)
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
			assert self != null;
			final @NonNull IteratorExp unboxed_self = (IteratorExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			final TypeValue Te_Metaclass_pivot__CollectionType_ = createTypeValue(evaluator.getIdResolver().getType(T_pivot__CollectionType, null));
			
			
			if (self == null) { throw new InvalidValueException("Null property source"); }
			org.eclipse.emf.common.util.EList<org.eclipse.ocl.examples.pivot.Variable> unboxed_A_symbol__155 = unboxed_self.getIterator();
			assert unboxed_A_symbol__155 != null;
			final @NonNull Value A_symbol__155 = createOrderedSetValue(T_OrderedSet_pivot__Variable_, unboxed_A_symbol__155);
			
			
			if (A_symbol__155 == null) throw new InvalidValueException("''Collection'' rather than ''OclVoid'' value required");
			if (A_symbol__155 instanceof InvalidValue) throw ((InvalidValue)A_symbol__155).getException();
			
			final @NonNull Iterator<?> A_symbol__154_iteratorVal = ((CollectionValue)A_symbol__155).iterator();
			Object V_1_ = null;	// iterator: 1_
			Object A_symbol__154;
			while (true) {
				if (!A_symbol__154_iteratorVal.hasNext()) {
					A_symbol__154 = TRUE_VALUE;
					break;
				}
				/*
					type = source.type.oclAsType(CollectionType).elementType
				*/
				V_1_ = A_symbol__154_iteratorVal.next();
				
				if (V_1_ == null) { throw new InvalidValueException("Null property source"); }
				Variable unboxed_V_1_ = (Variable)V_1_;	// Variable
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__156 = unboxed_V_1_.getType();
				final Object A_symbol__156 = createTypeValue(unboxed_A_symbol__156);
				
				
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				org.eclipse.ocl.examples.pivot.OCLExpression unboxed_A_symbol__157 = unboxed_self.getSource();
				final Object A_symbol__157 = valueOf(unboxed_A_symbol__157); // OCLExpression
				
				
				if (A_symbol__157 == null) { throw new InvalidValueException("Null property source"); }
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__158 = unboxed_A_symbol__157.getType();
				final Object A_symbol__158 = createTypeValue(unboxed_A_symbol__158);
				
				
				Object A_symbol__159 = OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, T_pivot__CollectionType, A_symbol__158, Te_Metaclass_pivot__CollectionType_);
				if (A_symbol__159 == null) { throw new InvalidValueException("Null property source"); }
				assert A_symbol__159 != null;
				CollectionType unboxed_A_symbol__159 = (CollectionType)((TypeValue)A_symbol__159).getInstanceType();
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__160 = unboxed_A_symbol__159.getElementType();
				final Object A_symbol__160 = createTypeValue(unboxed_A_symbol__160);
				
				
				Object A_symbol__161 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__156, A_symbol__160);
				Object A_symbol__154_bodyVal = A_symbol__161;
				if (A_symbol__154_bodyVal != TRUE_VALUE) {
					if (A_symbol__154_bodyVal == null) {
						throw new InvalidValueException(EvaluatorMessages.UndefinedBody, "forAll");
					}
					else {
						A_symbol__154 = FALSE_VALUE;			// Abort after a fail
						break;
					}
				}
			}
			
			return A_symbol__154;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'OneBodyTypeIsBoolean' invariant.
	 */
	public static class _invariant_OneBodyTypeIsBoolean extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_OneBodyTypeIsBoolean INSTANCE = new _invariant_OneBodyTypeIsBoolean();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
		static final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
		static final @NonNull PrimitiveTypeId T_String = TypeId.STRING;
		static final @NonNull Object S_one = "one";
		static final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
		static final @NonNull PackageId Pk_ocl = IdManager.INSTANCE.getPackageId(OCLstdlibPackage.eINSTANCE);
		static final @NonNull TypeId T_Type = Pk_ocl.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "Type");
		static final @NonNull PackageId Pk_pivot = IdManager.INSTANCE.getPackageId(PivotPackage.eINSTANCE);
		static final @NonNull TypeId T_pivot__OCLExpression = Pk_pivot.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "OCLExpression");
		
	
		/*
		name = 'one' implies body.type = Boolean
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
			assert self != null;
			final @NonNull IteratorExp unboxed_self = (IteratorExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			final TypeValue Te_Metaclass_Boolean_ = createTypeValue(evaluator.getIdResolver().getType(T_Boolean, null));
			
			Object aA_symbol__163;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				java.lang.String unboxed_A_symbol__164 = unboxed_self.getName();
				final Object A_symbol__164 = unboxed_A_symbol__164; // String
				
				
				Object A_symbol__163 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__164, S_one);
				aA_symbol__163 = A_symbol__163;
			} catch (Exception e) {
				aA_symbol__163 = new InvalidValueImpl(e);
			}
			Object aA_symbol__165;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				org.eclipse.ocl.examples.pivot.OCLExpression unboxed_A_symbol__166 = unboxed_self.getBody();
				final Object A_symbol__166 = valueOf(unboxed_A_symbol__166); // OCLExpression
				
				
				if (A_symbol__166 == null) { throw new InvalidValueException("Null property source"); }
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__167 = unboxed_A_symbol__166.getType();
				final Object A_symbol__167 = createTypeValue(unboxed_A_symbol__167);
				
				
				Object A_symbol__165 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__167, Te_Metaclass_Boolean_);
				aA_symbol__165 = A_symbol__165;
			} catch (Exception e) {
				aA_symbol__165 = new InvalidValueImpl(e);
			}
			Object A_symbol__162 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, aA_symbol__163, aA_symbol__165);
			
			return A_symbol__162;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'OneHasOneIterator' invariant.
	 */
	public static class _invariant_OneHasOneIterator extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_OneHasOneIterator INSTANCE = new _invariant_OneHasOneIterator();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
		static final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
		static final @NonNull PrimitiveTypeId T_String = TypeId.STRING;
		static final @NonNull Object S_one = "one";
		static final @NonNull ExecutorOperation O_Real__eq_ = OCLstdlibTables.Operations._Real___eq_;
		static final @NonNull PrimitiveTypeId T_Integer = TypeId.INTEGER;
		static final @NonNull ExecutorOperation O_Collection_size = OCLstdlibTables.Operations._Collection__size;
		static final @NonNull PackageId Pk_pivot = IdManager.INSTANCE.getPackageId(PivotPackage.eINSTANCE);
		static final @NonNull TypeId T_pivot__Variable = Pk_pivot.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "Variable");
		static final @NonNull CollectionTypeId T_OrderedSet_pivot__Variable_ = TypeId.ORDERED_SET.getSpecializedId(T_pivot__Variable);
		static final @NonNull IntegerValue I_1 = integerValueOf(1);
		
	
		/*
		name = 'one' implies iterator->size() = 1
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
			assert self != null;
			final @NonNull IteratorExp unboxed_self = (IteratorExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			Object aA_symbol__169;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				java.lang.String unboxed_A_symbol__170 = unboxed_self.getName();
				final Object A_symbol__170 = unboxed_A_symbol__170; // String
				
				
				Object A_symbol__169 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__170, S_one);
				aA_symbol__169 = A_symbol__169;
			} catch (Exception e) {
				aA_symbol__169 = new InvalidValueImpl(e);
			}
			Object aA_symbol__171;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				org.eclipse.emf.common.util.EList<org.eclipse.ocl.examples.pivot.Variable> unboxed_A_symbol__172 = unboxed_self.getIterator();
				assert unboxed_A_symbol__172 != null;
				final @NonNull Value A_symbol__172 = createOrderedSetValue(T_OrderedSet_pivot__Variable_, unboxed_A_symbol__172);
				
				
				Object A_symbol__173 = CollectionSizeOperation.INSTANCE.evaluate(evaluator, T_Integer, A_symbol__172);
				Object A_symbol__171 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__173, I_1);
				aA_symbol__171 = A_symbol__171;
			} catch (Exception e) {
				aA_symbol__171 = new InvalidValueImpl(e);
			}
			Object A_symbol__168 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, aA_symbol__169, aA_symbol__171);
			
			return A_symbol__168;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'OneTypeIsBoolean' invariant.
	 */
	public static class _invariant_OneTypeIsBoolean extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_OneTypeIsBoolean INSTANCE = new _invariant_OneTypeIsBoolean();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
		static final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
		static final @NonNull PrimitiveTypeId T_String = TypeId.STRING;
		static final @NonNull Object S_one = "one";
		static final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
		static final @NonNull PackageId Pk_ocl = IdManager.INSTANCE.getPackageId(OCLstdlibPackage.eINSTANCE);
		static final @NonNull TypeId T_Type = Pk_ocl.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "Type");
		
	
		/*
		name = 'one' implies type = Boolean
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
			assert self != null;
			final @NonNull IteratorExp unboxed_self = (IteratorExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			final TypeValue Te_Metaclass_Boolean_ = createTypeValue(evaluator.getIdResolver().getType(T_Boolean, null));
			
			Object aA_symbol__175;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				java.lang.String unboxed_A_symbol__176 = unboxed_self.getName();
				final Object A_symbol__176 = unboxed_A_symbol__176; // String
				
				
				Object A_symbol__175 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__176, S_one);
				aA_symbol__175 = A_symbol__175;
			} catch (Exception e) {
				aA_symbol__175 = new InvalidValueImpl(e);
			}
			Object aA_symbol__177;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__178 = unboxed_self.getType();
				final Object A_symbol__178 = createTypeValue(unboxed_A_symbol__178);
				
				
				Object A_symbol__177 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__178, Te_Metaclass_Boolean_);
				aA_symbol__177 = A_symbol__177;
			} catch (Exception e) {
				aA_symbol__177 = new InvalidValueImpl(e);
			}
			Object A_symbol__174 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, aA_symbol__175, aA_symbol__177);
			
			return A_symbol__174;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'RejectOrSelectHasOneIterator' invariant.
	 */
	public static class _invariant_RejectOrSelectHasOneIterator extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_RejectOrSelectHasOneIterator INSTANCE = new _invariant_RejectOrSelectHasOneIterator();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
		static final @NonNull ExecutorOperation O_Boolean_or = OCLstdlibTables.Operations._Boolean__or;
		static final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
		static final @NonNull PrimitiveTypeId T_String = TypeId.STRING;
		static final @NonNull Object S_reject = "reject";
		static final @NonNull Object S_select = "select";
		static final @NonNull ExecutorOperation O_Real__eq_ = OCLstdlibTables.Operations._Real___eq_;
		static final @NonNull PrimitiveTypeId T_Integer = TypeId.INTEGER;
		static final @NonNull ExecutorOperation O_Collection_size = OCLstdlibTables.Operations._Collection__size;
		static final @NonNull PackageId Pk_pivot = IdManager.INSTANCE.getPackageId(PivotPackage.eINSTANCE);
		static final @NonNull TypeId T_pivot__Variable = Pk_pivot.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "Variable");
		static final @NonNull CollectionTypeId T_OrderedSet_pivot__Variable_ = TypeId.ORDERED_SET.getSpecializedId(T_pivot__Variable);
		static final @NonNull IntegerValue I_1 = integerValueOf(1);
		
	
		/*
		name = 'reject' or name = 'select' implies iterator->size() = 1
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
			assert self != null;
			final @NonNull IteratorExp unboxed_self = (IteratorExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			Object aA_symbol__180;
			try {
				Object aA_symbol__181;
				try {
					
					if (self == null) { throw new InvalidValueException("Null property source"); }
					java.lang.String unboxed_A_symbol__182 = unboxed_self.getName();
					final Object A_symbol__182 = unboxed_A_symbol__182; // String
					
					
					Object A_symbol__181 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__182, S_reject);
					aA_symbol__181 = A_symbol__181;
				} catch (Exception e) {
					aA_symbol__181 = new InvalidValueImpl(e);
				}
				Object aA_symbol__183;
				try {
					
					if (self == null) { throw new InvalidValueException("Null property source"); }
					java.lang.String unboxed_A_symbol__184 = unboxed_self.getName();
					final Object A_symbol__184 = unboxed_A_symbol__184; // String
					
					
					Object A_symbol__183 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__184, S_select);
					aA_symbol__183 = A_symbol__183;
				} catch (Exception e) {
					aA_symbol__183 = new InvalidValueImpl(e);
				}
				Object A_symbol__180 = BooleanOrOperation.INSTANCE.evaluate(evaluator, T_Boolean, aA_symbol__181, aA_symbol__183);
				
				aA_symbol__180 = A_symbol__180;
			} catch (Exception e) {
				aA_symbol__180 = new InvalidValueImpl(e);
			}
			Object aA_symbol__185;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				org.eclipse.emf.common.util.EList<org.eclipse.ocl.examples.pivot.Variable> unboxed_A_symbol__186 = unboxed_self.getIterator();
				assert unboxed_A_symbol__186 != null;
				final @NonNull Value A_symbol__186 = createOrderedSetValue(T_OrderedSet_pivot__Variable_, unboxed_A_symbol__186);
				
				
				Object A_symbol__187 = CollectionSizeOperation.INSTANCE.evaluate(evaluator, T_Integer, A_symbol__186);
				Object A_symbol__185 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__187, I_1);
				aA_symbol__185 = A_symbol__185;
			} catch (Exception e) {
				aA_symbol__185 = new InvalidValueImpl(e);
			}
			Object A_symbol__179 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, aA_symbol__180, aA_symbol__185);
			
			return A_symbol__179;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'RejectOrSelectTypeIsBoolean' invariant.
	 */
	public static class _invariant_RejectOrSelectTypeIsBoolean extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_RejectOrSelectTypeIsBoolean INSTANCE = new _invariant_RejectOrSelectTypeIsBoolean();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
		static final @NonNull ExecutorOperation O_Boolean_or = OCLstdlibTables.Operations._Boolean__or;
		static final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
		static final @NonNull PrimitiveTypeId T_String = TypeId.STRING;
		static final @NonNull Object S_reject = "reject";
		static final @NonNull Object S_select = "select";
		static final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
		static final @NonNull PackageId Pk_ocl = IdManager.INSTANCE.getPackageId(OCLstdlibPackage.eINSTANCE);
		static final @NonNull TypeId T_Type = Pk_ocl.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "Type");
		
	
		/*
		name = 'reject' or name = 'select' implies type = Boolean
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
			assert self != null;
			final @NonNull IteratorExp unboxed_self = (IteratorExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			final TypeValue Te_Metaclass_Boolean_ = createTypeValue(evaluator.getIdResolver().getType(T_Boolean, null));
			
			Object aA_symbol__189;
			try {
				Object aA_symbol__190;
				try {
					
					if (self == null) { throw new InvalidValueException("Null property source"); }
					java.lang.String unboxed_A_symbol__191 = unboxed_self.getName();
					final Object A_symbol__191 = unboxed_A_symbol__191; // String
					
					
					Object A_symbol__190 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__191, S_reject);
					aA_symbol__190 = A_symbol__190;
				} catch (Exception e) {
					aA_symbol__190 = new InvalidValueImpl(e);
				}
				Object aA_symbol__192;
				try {
					
					if (self == null) { throw new InvalidValueException("Null property source"); }
					java.lang.String unboxed_A_symbol__193 = unboxed_self.getName();
					final Object A_symbol__193 = unboxed_A_symbol__193; // String
					
					
					Object A_symbol__192 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__193, S_select);
					aA_symbol__192 = A_symbol__192;
				} catch (Exception e) {
					aA_symbol__192 = new InvalidValueImpl(e);
				}
				Object A_symbol__189 = BooleanOrOperation.INSTANCE.evaluate(evaluator, T_Boolean, aA_symbol__190, aA_symbol__192);
				
				aA_symbol__189 = A_symbol__189;
			} catch (Exception e) {
				aA_symbol__189 = new InvalidValueImpl(e);
			}
			Object aA_symbol__194;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__195 = unboxed_self.getType();
				final Object A_symbol__195 = createTypeValue(unboxed_A_symbol__195);
				
				
				Object A_symbol__194 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__195, Te_Metaclass_Boolean_);
				aA_symbol__194 = A_symbol__194;
			} catch (Exception e) {
				aA_symbol__194 = new InvalidValueImpl(e);
			}
			Object A_symbol__188 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, aA_symbol__189, aA_symbol__194);
			
			return A_symbol__188;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'RejectOrSelectTypeIsSourceType' invariant.
	 */
	public static class _invariant_RejectOrSelectTypeIsSourceType extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_RejectOrSelectTypeIsSourceType INSTANCE = new _invariant_RejectOrSelectTypeIsSourceType();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
		static final @NonNull ExecutorOperation O_Boolean_or = OCLstdlibTables.Operations._Boolean__or;
		static final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
		static final @NonNull PrimitiveTypeId T_String = TypeId.STRING;
		static final @NonNull Object S_reject = "reject";
		static final @NonNull Object S_select = "select";
		static final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
		static final @NonNull PackageId Pk_ocl = IdManager.INSTANCE.getPackageId(OCLstdlibPackage.eINSTANCE);
		static final @NonNull TypeId T_Type = Pk_ocl.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "Type");
		static final @NonNull PackageId Pk_pivot = IdManager.INSTANCE.getPackageId(PivotPackage.eINSTANCE);
		static final @NonNull TypeId T_pivot__OCLExpression = Pk_pivot.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "OCLExpression");
		
	
		/*
		name = 'reject' or name = 'select' implies type = source.type
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
			assert self != null;
			final @NonNull IteratorExp unboxed_self = (IteratorExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			Object aA_symbol__197;
			try {
				Object aA_symbol__198;
				try {
					
					if (self == null) { throw new InvalidValueException("Null property source"); }
					java.lang.String unboxed_A_symbol__199 = unboxed_self.getName();
					final Object A_symbol__199 = unboxed_A_symbol__199; // String
					
					
					Object A_symbol__198 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__199, S_reject);
					aA_symbol__198 = A_symbol__198;
				} catch (Exception e) {
					aA_symbol__198 = new InvalidValueImpl(e);
				}
				Object aA_symbol__200;
				try {
					
					if (self == null) { throw new InvalidValueException("Null property source"); }
					java.lang.String unboxed_A_symbol__201 = unboxed_self.getName();
					final Object A_symbol__201 = unboxed_A_symbol__201; // String
					
					
					Object A_symbol__200 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__201, S_select);
					aA_symbol__200 = A_symbol__200;
				} catch (Exception e) {
					aA_symbol__200 = new InvalidValueImpl(e);
				}
				Object A_symbol__197 = BooleanOrOperation.INSTANCE.evaluate(evaluator, T_Boolean, aA_symbol__198, aA_symbol__200);
				
				aA_symbol__197 = A_symbol__197;
			} catch (Exception e) {
				aA_symbol__197 = new InvalidValueImpl(e);
			}
			Object aA_symbol__202;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__203 = unboxed_self.getType();
				final Object A_symbol__203 = createTypeValue(unboxed_A_symbol__203);
				
				
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				org.eclipse.ocl.examples.pivot.OCLExpression unboxed_A_symbol__204 = unboxed_self.getSource();
				final Object A_symbol__204 = valueOf(unboxed_A_symbol__204); // OCLExpression
				
				
				if (A_symbol__204 == null) { throw new InvalidValueException("Null property source"); }
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__205 = unboxed_A_symbol__204.getType();
				final Object A_symbol__205 = createTypeValue(unboxed_A_symbol__205);
				
				
				Object A_symbol__202 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__203, A_symbol__205);
				aA_symbol__202 = A_symbol__202;
			} catch (Exception e) {
				aA_symbol__202 = new InvalidValueImpl(e);
			}
			Object A_symbol__196 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, aA_symbol__197, aA_symbol__202);
			
			return A_symbol__196;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'SortedByElementTypeIsSourceElementType' invariant.
	 */
	public static class _invariant_SortedByElementTypeIsSourceElementType extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_SortedByElementTypeIsSourceElementType INSTANCE = new _invariant_SortedByElementTypeIsSourceElementType();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
		static final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
		static final @NonNull PrimitiveTypeId T_String = TypeId.STRING;
		static final @NonNull Object S_sortedBy = "sortedBy";
		static final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
		static final @NonNull PackageId Pk_ocl = IdManager.INSTANCE.getPackageId(OCLstdlibPackage.eINSTANCE);
		static final @NonNull TypeId T_Type = Pk_ocl.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "Type");
		static final @NonNull PackageId Pk_pivot = IdManager.INSTANCE.getPackageId(PivotPackage.eINSTANCE);
		static final @NonNull TypeId T_pivot__CollectionType = Pk_pivot.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "CollectionType");
		static final @NonNull ExecutorOperation O_OclAny_oclAsType = OCLstdlibTables.Operations._OclAny__oclAsType;
		static final @NonNull TypeId T_pivot__OCLExpression = Pk_pivot.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "OCLExpression");
		
	
		/*
		name = 'sortedBy' implies
	type.oclAsType(CollectionType).elementType =
	body.type.oclAsType(CollectionType).elementType
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
			assert self != null;
			final @NonNull IteratorExp unboxed_self = (IteratorExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			final TypeValue Te_Metaclass_pivot__CollectionType_ = createTypeValue(evaluator.getIdResolver().getType(T_pivot__CollectionType, null));
			
			Object aA_symbol__207;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				java.lang.String unboxed_A_symbol__208 = unboxed_self.getName();
				final Object A_symbol__208 = unboxed_A_symbol__208; // String
				
				
				Object A_symbol__207 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__208, S_sortedBy);
				aA_symbol__207 = A_symbol__207;
			} catch (Exception e) {
				aA_symbol__207 = new InvalidValueImpl(e);
			}
			Object aA_symbol__209;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__210 = unboxed_self.getType();
				final Object A_symbol__210 = createTypeValue(unboxed_A_symbol__210);
				
				
				Object A_symbol__211 = OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, T_pivot__CollectionType, A_symbol__210, Te_Metaclass_pivot__CollectionType_);
				if (A_symbol__211 == null) { throw new InvalidValueException("Null property source"); }
				assert A_symbol__211 != null;
				CollectionType unboxed_A_symbol__211 = (CollectionType)((TypeValue)A_symbol__211).getInstanceType();
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__212 = unboxed_A_symbol__211.getElementType();
				final Object A_symbol__212 = createTypeValue(unboxed_A_symbol__212);
				
				
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				org.eclipse.ocl.examples.pivot.OCLExpression unboxed_A_symbol__213 = unboxed_self.getBody();
				final Object A_symbol__213 = valueOf(unboxed_A_symbol__213); // OCLExpression
				
				
				if (A_symbol__213 == null) { throw new InvalidValueException("Null property source"); }
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__214 = unboxed_A_symbol__213.getType();
				final Object A_symbol__214 = createTypeValue(unboxed_A_symbol__214);
				
				
				Object A_symbol__215 = OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, T_pivot__CollectionType, A_symbol__214, Te_Metaclass_pivot__CollectionType_);
				if (A_symbol__215 == null) { throw new InvalidValueException("Null property source"); }
				assert A_symbol__215 != null;
				CollectionType unboxed_A_symbol__215 = (CollectionType)((TypeValue)A_symbol__215).getInstanceType();
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__216 = unboxed_A_symbol__215.getElementType();
				final Object A_symbol__216 = createTypeValue(unboxed_A_symbol__216);
				
				
				Object A_symbol__209 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__212, A_symbol__216);
				aA_symbol__209 = A_symbol__209;
			} catch (Exception e) {
				aA_symbol__209 = new InvalidValueImpl(e);
			}
			Object A_symbol__206 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, aA_symbol__207, aA_symbol__209);
			
			return A_symbol__206;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'SortedByHasOneIterator' invariant.
	 */
	public static class _invariant_SortedByHasOneIterator extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_SortedByHasOneIterator INSTANCE = new _invariant_SortedByHasOneIterator();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
		static final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
		static final @NonNull PrimitiveTypeId T_String = TypeId.STRING;
		static final @NonNull Object S_sortedBy = "sortedBy";
		static final @NonNull ExecutorOperation O_Real__eq_ = OCLstdlibTables.Operations._Real___eq_;
		static final @NonNull PrimitiveTypeId T_Integer = TypeId.INTEGER;
		static final @NonNull ExecutorOperation O_Collection_size = OCLstdlibTables.Operations._Collection__size;
		static final @NonNull PackageId Pk_pivot = IdManager.INSTANCE.getPackageId(PivotPackage.eINSTANCE);
		static final @NonNull TypeId T_pivot__Variable = Pk_pivot.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "Variable");
		static final @NonNull CollectionTypeId T_OrderedSet_pivot__Variable_ = TypeId.ORDERED_SET.getSpecializedId(T_pivot__Variable);
		static final @NonNull IntegerValue I_1 = integerValueOf(1);
		
	
		/*
		name = 'sortedBy' implies iterator->size() = 1
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
			assert self != null;
			final @NonNull IteratorExp unboxed_self = (IteratorExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			Object aA_symbol__218;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				java.lang.String unboxed_A_symbol__219 = unboxed_self.getName();
				final Object A_symbol__219 = unboxed_A_symbol__219; // String
				
				
				Object A_symbol__218 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__219, S_sortedBy);
				aA_symbol__218 = A_symbol__218;
			} catch (Exception e) {
				aA_symbol__218 = new InvalidValueImpl(e);
			}
			Object aA_symbol__220;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				org.eclipse.emf.common.util.EList<org.eclipse.ocl.examples.pivot.Variable> unboxed_A_symbol__221 = unboxed_self.getIterator();
				assert unboxed_A_symbol__221 != null;
				final @NonNull Value A_symbol__221 = createOrderedSetValue(T_OrderedSet_pivot__Variable_, unboxed_A_symbol__221);
				
				
				Object A_symbol__222 = CollectionSizeOperation.INSTANCE.evaluate(evaluator, T_Integer, A_symbol__221);
				Object A_symbol__220 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__222, I_1);
				aA_symbol__220 = A_symbol__220;
			} catch (Exception e) {
				aA_symbol__220 = new InvalidValueImpl(e);
			}
			Object A_symbol__217 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, aA_symbol__218, aA_symbol__220);
			
			return A_symbol__217;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'SortedByIsOrderedIfSourceIsOrdered' invariant.
	 */
	public static class _invariant_SortedByIsOrderedIfSourceIsOrdered extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_SortedByIsOrderedIfSourceIsOrdered INSTANCE = new _invariant_SortedByIsOrderedIfSourceIsOrdered();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
		static final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
		static final @NonNull PrimitiveTypeId T_String = TypeId.STRING;
		static final @NonNull Object S_sortedBy = "sortedBy";
		static final @NonNull ExecutorOperation O_Boolean_or = OCLstdlibTables.Operations._Boolean__or;
		static final @NonNull ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
		static final @NonNull PackageId Pk_ocl = IdManager.INSTANCE.getPackageId(OCLstdlibPackage.eINSTANCE);
		static final @NonNull TypeId T_Type = Pk_ocl.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "Type");
		static final @NonNull PackageId Pk_pivot = IdManager.INSTANCE.getPackageId(PivotPackage.eINSTANCE);
		static final @NonNull TypeId T_pivot__OCLExpression = Pk_pivot.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "OCLExpression");
		static final @NonNull TypeId T_pivot__SequenceType = Pk_pivot.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "SequenceType");
		static final @NonNull TypeId T_pivot__BagType = Pk_pivot.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "BagType");
		static final @NonNull TypeId T_pivot__OrderedSetType = Pk_pivot.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "OrderedSetType");
		
	
		/*
		name = 'sortedBy' implies
	if
	  source.type.oclIsKindOf(SequenceType) or
	  source.type.oclIsKindOf(BagType)
	then type.oclIsKindOf(SequenceType)
	else type.oclIsKindOf(OrderedSetType)
	endif
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
			assert self != null;
			final @NonNull IteratorExp unboxed_self = (IteratorExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			final TypeValue Te_Metaclass_pivot__SequenceType_ = createTypeValue(evaluator.getIdResolver().getType(T_pivot__SequenceType, null));
			final TypeValue Te_Metaclass_pivot__BagType_ = createTypeValue(evaluator.getIdResolver().getType(T_pivot__BagType, null));
			final TypeValue Te_Metaclass_pivot__OrderedSetType_ = createTypeValue(evaluator.getIdResolver().getType(T_pivot__OrderedSetType, null));
			
			Object aA_symbol__224;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				java.lang.String unboxed_A_symbol__225 = unboxed_self.getName();
				final Object A_symbol__225 = unboxed_A_symbol__225; // String
				
				
				Object A_symbol__224 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__225, S_sortedBy);
				aA_symbol__224 = A_symbol__224;
			} catch (Exception e) {
				aA_symbol__224 = new InvalidValueImpl(e);
			}
			Object aA_symbol__226;
			try {
					Object aA_symbol__228;
					try {
						
						if (self == null) { throw new InvalidValueException("Null property source"); }
						org.eclipse.ocl.examples.pivot.OCLExpression unboxed_A_symbol__229 = unboxed_self.getSource();
						final Object A_symbol__229 = valueOf(unboxed_A_symbol__229); // OCLExpression
						
						
						if (A_symbol__229 == null) { throw new InvalidValueException("Null property source"); }
						org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__230 = unboxed_A_symbol__229.getType();
						final Object A_symbol__230 = createTypeValue(unboxed_A_symbol__230);
						
						
						Object A_symbol__228 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__230, Te_Metaclass_pivot__SequenceType_);
						aA_symbol__228 = A_symbol__228;
					} catch (Exception e) {
						aA_symbol__228 = new InvalidValueImpl(e);
					}
					Object aA_symbol__231;
					try {
						
						if (self == null) { throw new InvalidValueException("Null property source"); }
						org.eclipse.ocl.examples.pivot.OCLExpression unboxed_A_symbol__232 = unboxed_self.getSource();
						final Object A_symbol__232 = valueOf(unboxed_A_symbol__232); // OCLExpression
						
						
						if (A_symbol__232 == null) { throw new InvalidValueException("Null property source"); }
						org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__233 = unboxed_A_symbol__232.getType();
						final Object A_symbol__233 = createTypeValue(unboxed_A_symbol__233);
						
						
						Object A_symbol__231 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__233, Te_Metaclass_pivot__BagType_);
						aA_symbol__231 = A_symbol__231;
					} catch (Exception e) {
						aA_symbol__231 = new InvalidValueImpl(e);
					}
					Object A_symbol__227 = BooleanOrOperation.INSTANCE.evaluate(evaluator, T_Boolean, aA_symbol__228, aA_symbol__231);
					
				Object A_symbol__226;
				if (A_symbol__227 == ValuesUtil.TRUE_VALUE) {
					
					if (self == null) { throw new InvalidValueException("Null property source"); }
					org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__234 = unboxed_self.getType();
					final Object A_symbol__234 = createTypeValue(unboxed_A_symbol__234);
					
					
					Object A_symbol__235 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__234, Te_Metaclass_pivot__SequenceType_);
					A_symbol__226 = A_symbol__235;
				}
				else if (A_symbol__227 == ValuesUtil.FALSE_VALUE) {
					
					if (self == null) { throw new InvalidValueException("Null property source"); }
					org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__236 = unboxed_self.getType();
					final Object A_symbol__236 = createTypeValue(unboxed_A_symbol__236);
					
					
					Object A_symbol__237 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__236, Te_Metaclass_pivot__OrderedSetType_);
					A_symbol__226 = A_symbol__237;
				}
				else {
					throw new InvalidValueException("non-Boolean if condition");
				}
				aA_symbol__226 = A_symbol__226;
			} catch (Exception e) {
				aA_symbol__226 = new InvalidValueImpl(e);
			}
			Object A_symbol__223 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, aA_symbol__224, aA_symbol__226);
			
			return A_symbol__223;
		}
	}

	/** 
	 * Implementation of the IteratorExp 'SortedByIteratorTypeIsComparable' invariant.
	 */
	public static class _invariant_SortedByIteratorTypeIsComparable extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_SortedByIteratorTypeIsComparable INSTANCE = new _invariant_SortedByIteratorTypeIsComparable();
		static final @NonNull Object True = true;
		
	
		/*
		true
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
			assert self != null;
			final @NonNull IteratorExp unboxed_self = (IteratorExp)self;
			
			
			return True;
		}
	}
}

