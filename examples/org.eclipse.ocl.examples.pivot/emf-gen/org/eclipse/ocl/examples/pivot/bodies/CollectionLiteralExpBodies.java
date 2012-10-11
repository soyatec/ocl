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
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.ids.PrimitiveTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractUnaryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryBinaryOperation;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueImpl;
import org.eclipse.ocl.examples.library.executor.ExecutorOperation;
import org.eclipse.ocl.examples.library.logical.BooleanImpliesOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyOclIsKindOfOperation;
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
		static final @NonNull TypeId T_pivot__CollectionKind = PivotTables.Types._CollectionKind.getTypeId();
		static final @NonNull Object A_symbol_ = createEnumerationLiteralValue(PivotTables.EnumerationLiterals._CollectionKind__Bag);
		static final @NonNull ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
		static final @NonNull TypeId T_Type = OCLstdlibTables.Types._Type.getTypeId();
		static final @NonNull Object T_Metaclass_pivot__BagType_ = createTypeValue(PivotTables.Types._BagType);
		
	
		/*
		kind = CollectionKind::Bag implies type.oclIsKindOf(BagType)
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
			assert self != null;
			final @NonNull CollectionLiteralExp unboxed_self = (CollectionLiteralExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			Object leftA_symbol__1;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				org.eclipse.ocl.examples.pivot.CollectionKind unboxed_A_symbol__2 = unboxed_self.getKind();
				Value A_symbol__2 = createEnumerationLiteralValue(unboxed_A_symbol__2, PivotPackage.Literals.COLLECTION_KIND);
				
				
				
				DomainType static_A_symbol__3 = evaluator.getStaticTypeOf(A_symbol__2, A_symbol_);
				LibraryBinaryOperation dynamic_A_symbol__3 = (LibraryBinaryOperation)static_A_symbol__3.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Object A_symbol__3 = dynamic_A_symbol__3.evaluate(evaluator, T_Boolean, A_symbol__2, A_symbol_);
				leftA_symbol__1 = A_symbol__3;
			} catch (Exception e) {
				leftA_symbol__1 = new InvalidValueImpl(e);
			}
			Object A_symbol__3 = leftA_symbol__1;
			Object rightA_symbol__1;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__4 = unboxed_self.getType();
				Object A_symbol__4 = createTypeValue(unboxed_A_symbol__4);
				
				
				Object A_symbol__5 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__4, T_Metaclass_pivot__BagType_);
				rightA_symbol__1 = A_symbol__5;
			} catch (Exception e) {
				rightA_symbol__1 = new InvalidValueImpl(e);
			}
			Object A_symbol__5 = rightA_symbol__1;
			Object A_symbol__1 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__3, A_symbol__5);
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
		static final @NonNull TypeId T_pivot__CollectionKind = PivotTables.Types._CollectionKind.getTypeId();
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
			Value A_symbol__7 = createEnumerationLiteralValue(unboxed_A_symbol__7, PivotPackage.Literals.COLLECTION_KIND);
			
			
			
			DomainType static_A_symbol__8 = evaluator.getStaticTypeOf(A_symbol__7, A_symbol__6);
			LibraryBinaryOperation dynamic_A_symbol__8 = (LibraryBinaryOperation)static_A_symbol__8.lookupImplementation(standardLibrary, O_OclAny__lt__gt_);
			Object A_symbol__8 = dynamic_A_symbol__8.evaluate(evaluator, T_Boolean, A_symbol__7, A_symbol__6);
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
		static final @NonNull TypeId T_pivot__CollectionKind = PivotTables.Types._CollectionKind.getTypeId();
		static final @NonNull Object A_symbol__9 = createEnumerationLiteralValue(PivotTables.EnumerationLiterals._CollectionKind__OrderedSet);
		static final @NonNull ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
		static final @NonNull TypeId T_Type = OCLstdlibTables.Types._Type.getTypeId();
		static final @NonNull Object T_Metaclass_pivot__OrderedSetType_ = createTypeValue(PivotTables.Types._OrderedSetType);
		
	
		/*
		kind = CollectionKind::OrderedSet implies
	type.oclIsKindOf(OrderedSetType)
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
			assert self != null;
			final @NonNull CollectionLiteralExp unboxed_self = (CollectionLiteralExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			Object leftA_symbol__10;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				org.eclipse.ocl.examples.pivot.CollectionKind unboxed_A_symbol__11 = unboxed_self.getKind();
				Value A_symbol__11 = createEnumerationLiteralValue(unboxed_A_symbol__11, PivotPackage.Literals.COLLECTION_KIND);
				
				
				
				DomainType static_A_symbol__12 = evaluator.getStaticTypeOf(A_symbol__11, A_symbol__9);
				LibraryBinaryOperation dynamic_A_symbol__12 = (LibraryBinaryOperation)static_A_symbol__12.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Object A_symbol__12 = dynamic_A_symbol__12.evaluate(evaluator, T_Boolean, A_symbol__11, A_symbol__9);
				leftA_symbol__10 = A_symbol__12;
			} catch (Exception e) {
				leftA_symbol__10 = new InvalidValueImpl(e);
			}
			Object A_symbol__12 = leftA_symbol__10;
			Object rightA_symbol__10;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__13 = unboxed_self.getType();
				Object A_symbol__13 = createTypeValue(unboxed_A_symbol__13);
				
				
				Object A_symbol__14 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__13, T_Metaclass_pivot__OrderedSetType_);
				rightA_symbol__10 = A_symbol__14;
			} catch (Exception e) {
				rightA_symbol__10 = new InvalidValueImpl(e);
			}
			Object A_symbol__14 = rightA_symbol__10;
			Object A_symbol__10 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__12, A_symbol__14);
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
		static final @NonNull TypeId T_pivot__CollectionKind = PivotTables.Types._CollectionKind.getTypeId();
		static final @NonNull Object A_symbol__15 = createEnumerationLiteralValue(PivotTables.EnumerationLiterals._CollectionKind__Sequence);
		static final @NonNull ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
		static final @NonNull TypeId T_Type = OCLstdlibTables.Types._Type.getTypeId();
		static final @NonNull Object T_Metaclass_pivot__SequenceType_ = createTypeValue(PivotTables.Types._SequenceType);
		
	
		/*
		kind = CollectionKind::Sequence implies
	type.oclIsKindOf(SequenceType)
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
			assert self != null;
			final @NonNull CollectionLiteralExp unboxed_self = (CollectionLiteralExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			Object leftA_symbol__16;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				org.eclipse.ocl.examples.pivot.CollectionKind unboxed_A_symbol__17 = unboxed_self.getKind();
				Value A_symbol__17 = createEnumerationLiteralValue(unboxed_A_symbol__17, PivotPackage.Literals.COLLECTION_KIND);
				
				
				
				DomainType static_A_symbol__18 = evaluator.getStaticTypeOf(A_symbol__17, A_symbol__15);
				LibraryBinaryOperation dynamic_A_symbol__18 = (LibraryBinaryOperation)static_A_symbol__18.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Object A_symbol__18 = dynamic_A_symbol__18.evaluate(evaluator, T_Boolean, A_symbol__17, A_symbol__15);
				leftA_symbol__16 = A_symbol__18;
			} catch (Exception e) {
				leftA_symbol__16 = new InvalidValueImpl(e);
			}
			Object A_symbol__18 = leftA_symbol__16;
			Object rightA_symbol__16;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__19 = unboxed_self.getType();
				Object A_symbol__19 = createTypeValue(unboxed_A_symbol__19);
				
				
				Object A_symbol__20 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__19, T_Metaclass_pivot__SequenceType_);
				rightA_symbol__16 = A_symbol__20;
			} catch (Exception e) {
				rightA_symbol__16 = new InvalidValueImpl(e);
			}
			Object A_symbol__20 = rightA_symbol__16;
			Object A_symbol__16 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__18, A_symbol__20);
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
		static final @NonNull TypeId T_pivot__CollectionKind = PivotTables.Types._CollectionKind.getTypeId();
		static final @NonNull Object A_symbol__21 = createEnumerationLiteralValue(PivotTables.EnumerationLiterals._CollectionKind__Set);
		static final @NonNull ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
		static final @NonNull TypeId T_Type = OCLstdlibTables.Types._Type.getTypeId();
		static final @NonNull Object T_Metaclass_pivot__SetType_ = createTypeValue(PivotTables.Types._SetType);
		
	
		/*
		kind = CollectionKind::Set implies type.oclIsKindOf(SetType)
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
			assert self != null;
			final @NonNull CollectionLiteralExp unboxed_self = (CollectionLiteralExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			Object leftA_symbol__22;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				org.eclipse.ocl.examples.pivot.CollectionKind unboxed_A_symbol__23 = unboxed_self.getKind();
				Value A_symbol__23 = createEnumerationLiteralValue(unboxed_A_symbol__23, PivotPackage.Literals.COLLECTION_KIND);
				
				
				
				DomainType static_A_symbol__24 = evaluator.getStaticTypeOf(A_symbol__23, A_symbol__21);
				LibraryBinaryOperation dynamic_A_symbol__24 = (LibraryBinaryOperation)static_A_symbol__24.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Object A_symbol__24 = dynamic_A_symbol__24.evaluate(evaluator, T_Boolean, A_symbol__23, A_symbol__21);
				leftA_symbol__22 = A_symbol__24;
			} catch (Exception e) {
				leftA_symbol__22 = new InvalidValueImpl(e);
			}
			Object A_symbol__24 = leftA_symbol__22;
			Object rightA_symbol__22;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__25 = unboxed_self.getType();
				Object A_symbol__25 = createTypeValue(unboxed_A_symbol__25);
				
				
				Object A_symbol__26 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__25, T_Metaclass_pivot__SetType_);
				rightA_symbol__22 = A_symbol__26;
			} catch (Exception e) {
				rightA_symbol__22 = new InvalidValueImpl(e);
			}
			Object A_symbol__26 = rightA_symbol__22;
			Object A_symbol__22 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__24, A_symbol__26);
			return A_symbol__22;
		}
	}


}

