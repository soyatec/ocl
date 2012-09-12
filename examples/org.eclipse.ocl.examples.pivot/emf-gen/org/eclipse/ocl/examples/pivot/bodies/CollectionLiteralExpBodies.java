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
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.library.AbstractUnaryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryBinaryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryProperty;
import org.eclipse.ocl.examples.domain.values.ValueFactory;
import org.eclipse.ocl.examples.library.executor.ExecutorOperation;
import org.eclipse.ocl.examples.library.executor.ExecutorProperty;
import org.eclipse.ocl.examples.library.executor.ExecutorType;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.examples.pivot.PivotTables;

/**
 * CollectionLiteralExpBodies provides the Java implementation bodies of OCL-defined CollectionLiteralExp operations and properties.
 */
@SuppressWarnings("nls")
public class CollectionLiteralExpBodies
{

	/** 
	 * Implementation of the CollectionLiteralExp 'BagKindIsBag' invariant.
	 */
	public static class _invariant_BagKindIsBag extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_BagKindIsBag INSTANCE = new _invariant_BagKindIsBag();
	
		/*
		kind = CollectionKind::Bag implies type.oclIsKindOf(BagType)
		*/
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Object self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
			final @NonNull ExecutorType T_pivot__CollectionKind = PivotTables.Types._CollectionKind;
			final @NonNull ExecutorProperty P_CollectionLiteralExp_kind = PivotTables.Properties._CollectionLiteralExp__kind;
			final @NonNull LibraryProperty IP_CollectionLiteralExp_kind = P_CollectionLiteralExp_kind.getImplementation();
			final @NonNull Object A_symbol_ = valueFactory.createEnumerationLiteralValue(PivotTables.EnumerationLiterals._CollectionKind__Bag);
			final @NonNull ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
			final @NonNull ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final @NonNull ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final @NonNull LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final @NonNull Object T_Metaclass_pivot__BagType_ = valueFactory.createTypeValue(PivotTables.Types._BagType);
			
			Object leftA_symbol__1;
			try {
				
				Object A_symbol__2 = IP_CollectionLiteralExp_kind.evaluate(evaluator, T_pivot__CollectionKind, self, P_CollectionLiteralExp_kind);
				
				
				DomainType static_A_symbol__3 = valueFactory.typeOf(A_symbol__2, A_symbol_);
				LibraryBinaryOperation dynamic_A_symbol__3 = (LibraryBinaryOperation)static_A_symbol__3.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Object A_symbol__3 = dynamic_A_symbol__3.evaluate(evaluator, T_Boolean, A_symbol__2, A_symbol_);
				leftA_symbol__1 = A_symbol__3;
			} catch (InvalidValueException e) {
				leftA_symbol__1 = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__3 = leftA_symbol__1;
			Object rightA_symbol__1;
			try {
				
				Object A_symbol__4 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol__5 = valueFactory.typeOf(A_symbol__4);
				LibraryBinaryOperation dynamic_A_symbol__5 = (LibraryBinaryOperation)static_A_symbol__5.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
				Object A_symbol__5 = dynamic_A_symbol__5.evaluate(evaluator, T_Boolean, A_symbol__4, T_Metaclass_pivot__BagType_);
				rightA_symbol__1 = A_symbol__5;
			} catch (InvalidValueException e) {
				rightA_symbol__1 = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__5 = rightA_symbol__1;
			DomainType static_A_symbol__1 = valueFactory.typeOf(A_symbol__3);
			LibraryBinaryOperation dynamic_A_symbol__1 = (LibraryBinaryOperation)static_A_symbol__1.lookupImplementation(standardLibrary, O_Boolean_implies);
			Object A_symbol__1 = dynamic_A_symbol__1.evaluate(evaluator, T_Boolean, A_symbol__3, A_symbol__5);
			return A_symbol__1;
		}
	}

	/** 
	 * Implementation of the CollectionLiteralExp 'CollectionKindIsConcrete' invariant.
	 */
	public static class _invariant_CollectionKindIsConcrete extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_CollectionKindIsConcrete INSTANCE = new _invariant_CollectionKindIsConcrete();
	
		/*
		kind <> CollectionKind::Collection
		*/
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Object self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_OclAny__lt__gt_ = OCLstdlibTables.Operations._OclAny___lt__gt_;
			final @NonNull ExecutorType T_pivot__CollectionKind = PivotTables.Types._CollectionKind;
			final @NonNull ExecutorProperty P_CollectionLiteralExp_kind = PivotTables.Properties._CollectionLiteralExp__kind;
			final @NonNull LibraryProperty IP_CollectionLiteralExp_kind = P_CollectionLiteralExp_kind.getImplementation();
			final @NonNull Object A_symbol__6 = valueFactory.createEnumerationLiteralValue(PivotTables.EnumerationLiterals._CollectionKind__Collection);
			
			
			Object A_symbol__7 = IP_CollectionLiteralExp_kind.evaluate(evaluator, T_pivot__CollectionKind, self, P_CollectionLiteralExp_kind);
			
			
			DomainType static_A_symbol__8 = valueFactory.typeOf(A_symbol__7, A_symbol__6);
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
	
		/*
		kind = CollectionKind::OrderedSet implies
	type.oclIsKindOf(OrderedSetType)
		*/
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Object self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
			final @NonNull ExecutorType T_pivot__CollectionKind = PivotTables.Types._CollectionKind;
			final @NonNull ExecutorProperty P_CollectionLiteralExp_kind = PivotTables.Properties._CollectionLiteralExp__kind;
			final @NonNull LibraryProperty IP_CollectionLiteralExp_kind = P_CollectionLiteralExp_kind.getImplementation();
			final @NonNull Object A_symbol__9 = valueFactory.createEnumerationLiteralValue(PivotTables.EnumerationLiterals._CollectionKind__OrderedSet);
			final @NonNull ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
			final @NonNull ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final @NonNull ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final @NonNull LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final @NonNull Object T_Metaclass_pivot__OrderedSetType_ = valueFactory.createTypeValue(PivotTables.Types._OrderedSetType);
			
			Object leftA_symbol__10;
			try {
				
				Object A_symbol__11 = IP_CollectionLiteralExp_kind.evaluate(evaluator, T_pivot__CollectionKind, self, P_CollectionLiteralExp_kind);
				
				
				DomainType static_A_symbol__12 = valueFactory.typeOf(A_symbol__11, A_symbol__9);
				LibraryBinaryOperation dynamic_A_symbol__12 = (LibraryBinaryOperation)static_A_symbol__12.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Object A_symbol__12 = dynamic_A_symbol__12.evaluate(evaluator, T_Boolean, A_symbol__11, A_symbol__9);
				leftA_symbol__10 = A_symbol__12;
			} catch (InvalidValueException e) {
				leftA_symbol__10 = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__12 = leftA_symbol__10;
			Object rightA_symbol__10;
			try {
				
				Object A_symbol__13 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol__14 = valueFactory.typeOf(A_symbol__13);
				LibraryBinaryOperation dynamic_A_symbol__14 = (LibraryBinaryOperation)static_A_symbol__14.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
				Object A_symbol__14 = dynamic_A_symbol__14.evaluate(evaluator, T_Boolean, A_symbol__13, T_Metaclass_pivot__OrderedSetType_);
				rightA_symbol__10 = A_symbol__14;
			} catch (InvalidValueException e) {
				rightA_symbol__10 = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__14 = rightA_symbol__10;
			DomainType static_A_symbol__10 = valueFactory.typeOf(A_symbol__12);
			LibraryBinaryOperation dynamic_A_symbol__10 = (LibraryBinaryOperation)static_A_symbol__10.lookupImplementation(standardLibrary, O_Boolean_implies);
			Object A_symbol__10 = dynamic_A_symbol__10.evaluate(evaluator, T_Boolean, A_symbol__12, A_symbol__14);
			return A_symbol__10;
		}
	}

	/** 
	 * Implementation of the CollectionLiteralExp 'SequenceKindIsSequence' invariant.
	 */
	public static class _invariant_SequenceKindIsSequence extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_SequenceKindIsSequence INSTANCE = new _invariant_SequenceKindIsSequence();
	
		/*
		kind = CollectionKind::Sequence implies
	type.oclIsKindOf(SequenceType)
		*/
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Object self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
			final @NonNull ExecutorType T_pivot__CollectionKind = PivotTables.Types._CollectionKind;
			final @NonNull ExecutorProperty P_CollectionLiteralExp_kind = PivotTables.Properties._CollectionLiteralExp__kind;
			final @NonNull LibraryProperty IP_CollectionLiteralExp_kind = P_CollectionLiteralExp_kind.getImplementation();
			final @NonNull Object A_symbol__15 = valueFactory.createEnumerationLiteralValue(PivotTables.EnumerationLiterals._CollectionKind__Sequence);
			final @NonNull ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
			final @NonNull ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final @NonNull ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final @NonNull LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final @NonNull Object T_Metaclass_pivot__SequenceType_ = valueFactory.createTypeValue(PivotTables.Types._SequenceType);
			
			Object leftA_symbol__16;
			try {
				
				Object A_symbol__17 = IP_CollectionLiteralExp_kind.evaluate(evaluator, T_pivot__CollectionKind, self, P_CollectionLiteralExp_kind);
				
				
				DomainType static_A_symbol__18 = valueFactory.typeOf(A_symbol__17, A_symbol__15);
				LibraryBinaryOperation dynamic_A_symbol__18 = (LibraryBinaryOperation)static_A_symbol__18.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Object A_symbol__18 = dynamic_A_symbol__18.evaluate(evaluator, T_Boolean, A_symbol__17, A_symbol__15);
				leftA_symbol__16 = A_symbol__18;
			} catch (InvalidValueException e) {
				leftA_symbol__16 = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__18 = leftA_symbol__16;
			Object rightA_symbol__16;
			try {
				
				Object A_symbol__19 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol__20 = valueFactory.typeOf(A_symbol__19);
				LibraryBinaryOperation dynamic_A_symbol__20 = (LibraryBinaryOperation)static_A_symbol__20.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
				Object A_symbol__20 = dynamic_A_symbol__20.evaluate(evaluator, T_Boolean, A_symbol__19, T_Metaclass_pivot__SequenceType_);
				rightA_symbol__16 = A_symbol__20;
			} catch (InvalidValueException e) {
				rightA_symbol__16 = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__20 = rightA_symbol__16;
			DomainType static_A_symbol__16 = valueFactory.typeOf(A_symbol__18);
			LibraryBinaryOperation dynamic_A_symbol__16 = (LibraryBinaryOperation)static_A_symbol__16.lookupImplementation(standardLibrary, O_Boolean_implies);
			Object A_symbol__16 = dynamic_A_symbol__16.evaluate(evaluator, T_Boolean, A_symbol__18, A_symbol__20);
			return A_symbol__16;
		}
	}

	/** 
	 * Implementation of the CollectionLiteralExp 'SetKindIsSet' invariant.
	 */
	public static class _invariant_SetKindIsSet extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_SetKindIsSet INSTANCE = new _invariant_SetKindIsSet();
	
		/*
		kind = CollectionKind::Set implies type.oclIsKindOf(SetType)
		*/
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Object self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
			final @NonNull ExecutorType T_pivot__CollectionKind = PivotTables.Types._CollectionKind;
			final @NonNull ExecutorProperty P_CollectionLiteralExp_kind = PivotTables.Properties._CollectionLiteralExp__kind;
			final @NonNull LibraryProperty IP_CollectionLiteralExp_kind = P_CollectionLiteralExp_kind.getImplementation();
			final @NonNull Object A_symbol__21 = valueFactory.createEnumerationLiteralValue(PivotTables.EnumerationLiterals._CollectionKind__Set);
			final @NonNull ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
			final @NonNull ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final @NonNull ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final @NonNull LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final @NonNull Object T_Metaclass_pivot__SetType_ = valueFactory.createTypeValue(PivotTables.Types._SetType);
			
			Object leftA_symbol__22;
			try {
				
				Object A_symbol__23 = IP_CollectionLiteralExp_kind.evaluate(evaluator, T_pivot__CollectionKind, self, P_CollectionLiteralExp_kind);
				
				
				DomainType static_A_symbol__24 = valueFactory.typeOf(A_symbol__23, A_symbol__21);
				LibraryBinaryOperation dynamic_A_symbol__24 = (LibraryBinaryOperation)static_A_symbol__24.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Object A_symbol__24 = dynamic_A_symbol__24.evaluate(evaluator, T_Boolean, A_symbol__23, A_symbol__21);
				leftA_symbol__22 = A_symbol__24;
			} catch (InvalidValueException e) {
				leftA_symbol__22 = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__24 = leftA_symbol__22;
			Object rightA_symbol__22;
			try {
				
				Object A_symbol__25 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol__26 = valueFactory.typeOf(A_symbol__25);
				LibraryBinaryOperation dynamic_A_symbol__26 = (LibraryBinaryOperation)static_A_symbol__26.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
				Object A_symbol__26 = dynamic_A_symbol__26.evaluate(evaluator, T_Boolean, A_symbol__25, T_Metaclass_pivot__SetType_);
				rightA_symbol__22 = A_symbol__26;
			} catch (InvalidValueException e) {
				rightA_symbol__22 = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__26 = rightA_symbol__22;
			DomainType static_A_symbol__22 = valueFactory.typeOf(A_symbol__24);
			LibraryBinaryOperation dynamic_A_symbol__22 = (LibraryBinaryOperation)static_A_symbol__22.lookupImplementation(standardLibrary, O_Boolean_implies);
			Object A_symbol__22 = dynamic_A_symbol__22.evaluate(evaluator, T_Boolean, A_symbol__24, A_symbol__26);
			return A_symbol__22;
		}
	}


}

