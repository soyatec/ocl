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
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueImpl;
import org.eclipse.ocl.examples.library.executor.ExecutorOperation;
import org.eclipse.ocl.examples.library.logical.BooleanImpliesOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibPackage;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.examples.pivot.CollectionLiteralExp;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.PivotTables;

/**
 * CollectionLiteralExpBodies provides the Java implementation bodies of OCL-defined CollectionLiteralExp operations and properties.
 */
@SuppressWarnings({"nls", "null", "unused"})
public class CollectionLiteralExpBodies
{

	/** 
	 * Implementation of the CollectionLiteralExp 'BagKindIsBag' invariant.
	 */
	public static class _invariant_BagKindIsBag extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_BagKindIsBag INSTANCE = new _invariant_BagKindIsBag();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
		static final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
		static final @NonNull PackageId Pk_pivot = IdManager.INSTANCE.getPackageId(PivotPackage.eINSTANCE);
		static final @NonNull TypeId T_pivot__CollectionKind = Pk_pivot.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "CollectionKind");
		static final @NonNull Object A_symbol_ = createEnumerationLiteralValue(PivotTables.EnumerationLiterals._CollectionKind__Bag);
		static final @NonNull ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
		static final @NonNull PackageId Pk_ocl = IdManager.INSTANCE.getPackageId(OCLstdlibPackage.eINSTANCE);
		static final @NonNull TypeId T_Type = Pk_ocl.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "Type");
		static final @NonNull TypeId T_pivot__BagType = Pk_pivot.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "BagType");
		
	
		/*
		kind = CollectionKind::Bag implies type.oclIsKindOf(BagType)
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
			assert self != null;
			final @NonNull CollectionLiteralExp unboxed_self = (CollectionLiteralExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			final TypeValue Te_Metaclass_pivot__BagType_ = createTypeValue(evaluator.getIdResolver().getType(T_pivot__BagType, null));
			
			Object aA_symbol__2;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				org.eclipse.ocl.examples.pivot.CollectionKind unboxed_A_symbol__3 = unboxed_self.getKind();
				final Value A_symbol__3 = createEnumerationLiteralValue(unboxed_A_symbol__3, PivotPackage.Literals.COLLECTION_KIND);
				
				
				
				Object A_symbol__2 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__3, A_symbol_);
				aA_symbol__2 = A_symbol__2;
			} catch (Exception e) {
				aA_symbol__2 = new InvalidValueImpl(e);
			}
			Object aA_symbol__4;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__5 = unboxed_self.getType();
				PivotTables.PACKAGE.getName();
				final Object A_symbol__5 = createTypeValue(unboxed_A_symbol__5);
				
				
				Object A_symbol__4 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__5, Te_Metaclass_pivot__BagType_);
				aA_symbol__4 = A_symbol__4;
			} catch (Exception e) {
				aA_symbol__4 = new InvalidValueImpl(e);
			}
			Object A_symbol__1 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, aA_symbol__2, aA_symbol__4);
			
			return A_symbol__1;
		}
	}

	/** 
	 * Implementation of the CollectionLiteralExp 'CollectionKindIsConcrete' invariant.
	 */
	public static class _invariant_CollectionKindIsConcrete extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_CollectionKindIsConcrete INSTANCE = new _invariant_CollectionKindIsConcrete();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_OclAny__lt__gt_ = OCLstdlibTables.Operations._OclAny___lt__gt_;
		static final @NonNull PackageId Pk_pivot = IdManager.INSTANCE.getPackageId(PivotPackage.eINSTANCE);
		static final @NonNull TypeId T_pivot__CollectionKind = Pk_pivot.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "CollectionKind");
		static final @NonNull Object A_symbol__6 = createEnumerationLiteralValue(PivotTables.EnumerationLiterals._CollectionKind__Collection);
		
	
		/*
		kind <> CollectionKind::Collection
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
			assert self != null;
			final @NonNull CollectionLiteralExp unboxed_self = (CollectionLiteralExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			
			if (self == null) { throw new InvalidValueException("Null property source"); }
			org.eclipse.ocl.examples.pivot.CollectionKind unboxed_A_symbol__7 = unboxed_self.getKind();
			final Value A_symbol__7 = createEnumerationLiteralValue(unboxed_A_symbol__7, PivotPackage.Literals.COLLECTION_KIND);
			
			
			
			Object A_symbol__8 = OclAnyNotEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__7, A_symbol__6);
			return A_symbol__8;
		}
	}

	/** 
	 * Implementation of the CollectionLiteralExp 'OrderedSetKindIsOrderedSet' invariant.
	 */
	public static class _invariant_OrderedSetKindIsOrderedSet extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_OrderedSetKindIsOrderedSet INSTANCE = new _invariant_OrderedSetKindIsOrderedSet();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
		static final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
		static final @NonNull PackageId Pk_pivot = IdManager.INSTANCE.getPackageId(PivotPackage.eINSTANCE);
		static final @NonNull TypeId T_pivot__CollectionKind = Pk_pivot.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "CollectionKind");
		static final @NonNull Object A_symbol__9 = createEnumerationLiteralValue(PivotTables.EnumerationLiterals._CollectionKind__OrderedSet);
		static final @NonNull ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
		static final @NonNull PackageId Pk_ocl = IdManager.INSTANCE.getPackageId(OCLstdlibPackage.eINSTANCE);
		static final @NonNull TypeId T_Type = Pk_ocl.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "Type");
		static final @NonNull TypeId T_pivot__OrderedSetType = Pk_pivot.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "OrderedSetType");
		
	
		/*
		kind = CollectionKind::OrderedSet implies
	type.oclIsKindOf(OrderedSetType)
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
			assert self != null;
			final @NonNull CollectionLiteralExp unboxed_self = (CollectionLiteralExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			final TypeValue Te_Metaclass_pivot__OrderedSetType_ = createTypeValue(evaluator.getIdResolver().getType(T_pivot__OrderedSetType, null));
			
			Object aA_symbol__11;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				org.eclipse.ocl.examples.pivot.CollectionKind unboxed_A_symbol__12 = unboxed_self.getKind();
				final Value A_symbol__12 = createEnumerationLiteralValue(unboxed_A_symbol__12, PivotPackage.Literals.COLLECTION_KIND);
				
				
				
				Object A_symbol__11 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__12, A_symbol__9);
				aA_symbol__11 = A_symbol__11;
			} catch (Exception e) {
				aA_symbol__11 = new InvalidValueImpl(e);
			}
			Object aA_symbol__13;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__14 = unboxed_self.getType();
				PivotTables.PACKAGE.getName();
				final Object A_symbol__14 = createTypeValue(unboxed_A_symbol__14);
				
				
				Object A_symbol__13 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__14, Te_Metaclass_pivot__OrderedSetType_);
				aA_symbol__13 = A_symbol__13;
			} catch (Exception e) {
				aA_symbol__13 = new InvalidValueImpl(e);
			}
			Object A_symbol__10 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, aA_symbol__11, aA_symbol__13);
			
			return A_symbol__10;
		}
	}

	/** 
	 * Implementation of the CollectionLiteralExp 'SequenceKindIsSequence' invariant.
	 */
	public static class _invariant_SequenceKindIsSequence extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_SequenceKindIsSequence INSTANCE = new _invariant_SequenceKindIsSequence();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
		static final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
		static final @NonNull PackageId Pk_pivot = IdManager.INSTANCE.getPackageId(PivotPackage.eINSTANCE);
		static final @NonNull TypeId T_pivot__CollectionKind = Pk_pivot.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "CollectionKind");
		static final @NonNull Object A_symbol__15 = createEnumerationLiteralValue(PivotTables.EnumerationLiterals._CollectionKind__Sequence);
		static final @NonNull ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
		static final @NonNull PackageId Pk_ocl = IdManager.INSTANCE.getPackageId(OCLstdlibPackage.eINSTANCE);
		static final @NonNull TypeId T_Type = Pk_ocl.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "Type");
		static final @NonNull TypeId T_pivot__SequenceType = Pk_pivot.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "SequenceType");
		
	
		/*
		kind = CollectionKind::Sequence implies
	type.oclIsKindOf(SequenceType)
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
			assert self != null;
			final @NonNull CollectionLiteralExp unboxed_self = (CollectionLiteralExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			final TypeValue Te_Metaclass_pivot__SequenceType_ = createTypeValue(evaluator.getIdResolver().getType(T_pivot__SequenceType, null));
			
			Object aA_symbol__17;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				org.eclipse.ocl.examples.pivot.CollectionKind unboxed_A_symbol__18 = unboxed_self.getKind();
				final Value A_symbol__18 = createEnumerationLiteralValue(unboxed_A_symbol__18, PivotPackage.Literals.COLLECTION_KIND);
				
				
				
				Object A_symbol__17 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__18, A_symbol__15);
				aA_symbol__17 = A_symbol__17;
			} catch (Exception e) {
				aA_symbol__17 = new InvalidValueImpl(e);
			}
			Object aA_symbol__19;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__20 = unboxed_self.getType();
				PivotTables.PACKAGE.getName();
				final Object A_symbol__20 = createTypeValue(unboxed_A_symbol__20);
				
				
				Object A_symbol__19 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__20, Te_Metaclass_pivot__SequenceType_);
				aA_symbol__19 = A_symbol__19;
			} catch (Exception e) {
				aA_symbol__19 = new InvalidValueImpl(e);
			}
			Object A_symbol__16 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, aA_symbol__17, aA_symbol__19);
			
			return A_symbol__16;
		}
	}

	/** 
	 * Implementation of the CollectionLiteralExp 'SetKindIsSet' invariant.
	 */
	public static class _invariant_SetKindIsSet extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_SetKindIsSet INSTANCE = new _invariant_SetKindIsSet();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
		static final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
		static final @NonNull PackageId Pk_pivot = IdManager.INSTANCE.getPackageId(PivotPackage.eINSTANCE);
		static final @NonNull TypeId T_pivot__CollectionKind = Pk_pivot.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "CollectionKind");
		static final @NonNull Object A_symbol__21 = createEnumerationLiteralValue(PivotTables.EnumerationLiterals._CollectionKind__Set);
		static final @NonNull ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
		static final @NonNull PackageId Pk_ocl = IdManager.INSTANCE.getPackageId(OCLstdlibPackage.eINSTANCE);
		static final @NonNull TypeId T_Type = Pk_ocl.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "Type");
		static final @NonNull TypeId T_pivot__SetType = Pk_pivot.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "SetType");
		
	
		/*
		kind = CollectionKind::Set implies type.oclIsKindOf(SetType)
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
			assert self != null;
			final @NonNull CollectionLiteralExp unboxed_self = (CollectionLiteralExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			final TypeValue Te_Metaclass_pivot__SetType_ = createTypeValue(evaluator.getIdResolver().getType(T_pivot__SetType, null));
			
			Object aA_symbol__23;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				org.eclipse.ocl.examples.pivot.CollectionKind unboxed_A_symbol__24 = unboxed_self.getKind();
				final Value A_symbol__24 = createEnumerationLiteralValue(unboxed_A_symbol__24, PivotPackage.Literals.COLLECTION_KIND);
				
				
				
				Object A_symbol__23 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__24, A_symbol__21);
				aA_symbol__23 = A_symbol__23;
			} catch (Exception e) {
				aA_symbol__23 = new InvalidValueImpl(e);
			}
			Object aA_symbol__25;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__26 = unboxed_self.getType();
				PivotTables.PACKAGE.getName();
				final Object A_symbol__26 = createTypeValue(unboxed_A_symbol__26);
				
				
				Object A_symbol__25 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__26, Te_Metaclass_pivot__SetType_);
				aA_symbol__25 = A_symbol__25;
			} catch (Exception e) {
				aA_symbol__25 = new InvalidValueImpl(e);
			}
			Object A_symbol__22 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, aA_symbol__23, aA_symbol__25);
			
			return A_symbol__22;
		}
	}


}

