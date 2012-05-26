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

import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.library.AbstractUnaryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryBinaryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryProperty;
import org.eclipse.ocl.examples.domain.values.Value;
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
		public static _invariant_BagKindIsBag INSTANCE = new _invariant_BagKindIsBag();
	
		/*
		kind = CollectionKind::Bag implies type.oclIsKindOf(BagType)
		*/
		public Value evaluate(DomainEvaluator evaluator, DomainType returnType, final Value self) throws InvalidValueException {
			final ValueFactory valueFactory = evaluator.getValueFactory();
			final DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
			final ExecutorType T_Pivot_ecore__pivot__CollectionKind = PivotTables.Types._CollectionKind;
			final ExecutorProperty P_CollectionLiteralExp_kind = PivotTables.Properties._CollectionLiteralExp__kind;
			final LibraryProperty IP_CollectionLiteralExp_kind = P_CollectionLiteralExp_kind.getImplementation();
			final Value A_symbol_368 = valueFactory.createEnumerationLiteralValue(PivotTables.EnumerationLiterals._CollectionKind__Bag);
			final ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
			final ExecutorType T_Pivot_ecore__pivot__Type = PivotTables.Types._Type;
			final ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final Value T_ClassClassifier_Pivot_ecore__pivot__BagType_ = valueFactory.createTypeValue(PivotTables.Types._BagType);
			
			Value leftA_symbol_369;
			try {
				
				Value A_symbol_370 = IP_CollectionLiteralExp_kind.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionKind, self, P_CollectionLiteralExp_kind);
				
				
				DomainType static_A_symbol_371 = valueFactory.typeOf(A_symbol_370, A_symbol_368);
				LibraryBinaryOperation dynamic_A_symbol_371 = (LibraryBinaryOperation)static_A_symbol_371.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_371 = dynamic_A_symbol_371.evaluate(evaluator, T_Boolean, A_symbol_370, A_symbol_368);
				leftA_symbol_369 = A_symbol_371;
			} catch (InvalidValueException e) {
				leftA_symbol_369 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_371 = leftA_symbol_369;
			Value rightA_symbol_369;
			try {
				
				Value A_symbol_372 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_373 = valueFactory.typeOf(A_symbol_372);
				LibraryBinaryOperation dynamic_A_symbol_373 = (LibraryBinaryOperation)static_A_symbol_373.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
				Value A_symbol_373 = dynamic_A_symbol_373.evaluate(evaluator, T_Boolean, A_symbol_372, T_ClassClassifier_Pivot_ecore__pivot__BagType_);
				rightA_symbol_369 = A_symbol_373;
			} catch (InvalidValueException e) {
				rightA_symbol_369 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_373 = rightA_symbol_369;
			DomainType static_A_symbol_369 = valueFactory.typeOf(A_symbol_371);
			LibraryBinaryOperation dynamic_A_symbol_369 = (LibraryBinaryOperation)static_A_symbol_369.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_369 = dynamic_A_symbol_369.evaluate(evaluator, T_Boolean, A_symbol_371, A_symbol_373);
			return A_symbol_369;
		}
	}

	/** 
	 * Implementation of the CollectionLiteralExp 'CollectionKindIsConcrete' invariant.
	 */
	public static class _invariant_CollectionKindIsConcrete extends AbstractUnaryOperation
	{
		public static _invariant_CollectionKindIsConcrete INSTANCE = new _invariant_CollectionKindIsConcrete();
	
		/*
		kind <> CollectionKind::Collection
		*/
		public Value evaluate(DomainEvaluator evaluator, DomainType returnType, final Value self) throws InvalidValueException {
			final ValueFactory valueFactory = evaluator.getValueFactory();
			final DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final ExecutorOperation O_OclAny__lt__gt_ = OCLstdlibTables.Operations._OclAny___lt__gt_;
			final ExecutorType T_Pivot_ecore__pivot__CollectionKind = PivotTables.Types._CollectionKind;
			final ExecutorProperty P_CollectionLiteralExp_kind = PivotTables.Properties._CollectionLiteralExp__kind;
			final LibraryProperty IP_CollectionLiteralExp_kind = P_CollectionLiteralExp_kind.getImplementation();
			final Value A_symbol_374 = valueFactory.createEnumerationLiteralValue(PivotTables.EnumerationLiterals._CollectionKind__Collection);
			
			
			Value A_symbol_375 = IP_CollectionLiteralExp_kind.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionKind, self, P_CollectionLiteralExp_kind);
			
			
			DomainType static_A_symbol_376 = valueFactory.typeOf(A_symbol_375, A_symbol_374);
			LibraryBinaryOperation dynamic_A_symbol_376 = (LibraryBinaryOperation)static_A_symbol_376.lookupImplementation(standardLibrary, O_OclAny__lt__gt_);
			Value A_symbol_376 = dynamic_A_symbol_376.evaluate(evaluator, T_Boolean, A_symbol_375, A_symbol_374);
			return A_symbol_376;
		}
	}

	/** 
	 * Implementation of the CollectionLiteralExp 'OrderedSetKindIsOrderedSet' invariant.
	 */
	public static class _invariant_OrderedSetKindIsOrderedSet extends AbstractUnaryOperation
	{
		public static _invariant_OrderedSetKindIsOrderedSet INSTANCE = new _invariant_OrderedSetKindIsOrderedSet();
	
		/*
		kind = CollectionKind::OrderedSet implies
	type.oclIsKindOf(OrderedSetType)
		*/
		public Value evaluate(DomainEvaluator evaluator, DomainType returnType, final Value self) throws InvalidValueException {
			final ValueFactory valueFactory = evaluator.getValueFactory();
			final DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
			final ExecutorType T_Pivot_ecore__pivot__CollectionKind = PivotTables.Types._CollectionKind;
			final ExecutorProperty P_CollectionLiteralExp_kind = PivotTables.Properties._CollectionLiteralExp__kind;
			final LibraryProperty IP_CollectionLiteralExp_kind = P_CollectionLiteralExp_kind.getImplementation();
			final Value A_symbol_377 = valueFactory.createEnumerationLiteralValue(PivotTables.EnumerationLiterals._CollectionKind__OrderedSet);
			final ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
			final ExecutorType T_Pivot_ecore__pivot__Type = PivotTables.Types._Type;
			final ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final Value T_ClassClassifier_Pivot_ecore__pivot__OrderedSetType_ = valueFactory.createTypeValue(PivotTables.Types._OrderedSetType);
			
			Value leftA_symbol_378;
			try {
				
				Value A_symbol_379 = IP_CollectionLiteralExp_kind.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionKind, self, P_CollectionLiteralExp_kind);
				
				
				DomainType static_A_symbol_380 = valueFactory.typeOf(A_symbol_379, A_symbol_377);
				LibraryBinaryOperation dynamic_A_symbol_380 = (LibraryBinaryOperation)static_A_symbol_380.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_380 = dynamic_A_symbol_380.evaluate(evaluator, T_Boolean, A_symbol_379, A_symbol_377);
				leftA_symbol_378 = A_symbol_380;
			} catch (InvalidValueException e) {
				leftA_symbol_378 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_380 = leftA_symbol_378;
			Value rightA_symbol_378;
			try {
				
				Value A_symbol_381 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_382 = valueFactory.typeOf(A_symbol_381);
				LibraryBinaryOperation dynamic_A_symbol_382 = (LibraryBinaryOperation)static_A_symbol_382.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
				Value A_symbol_382 = dynamic_A_symbol_382.evaluate(evaluator, T_Boolean, A_symbol_381, T_ClassClassifier_Pivot_ecore__pivot__OrderedSetType_);
				rightA_symbol_378 = A_symbol_382;
			} catch (InvalidValueException e) {
				rightA_symbol_378 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_382 = rightA_symbol_378;
			DomainType static_A_symbol_378 = valueFactory.typeOf(A_symbol_380);
			LibraryBinaryOperation dynamic_A_symbol_378 = (LibraryBinaryOperation)static_A_symbol_378.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_378 = dynamic_A_symbol_378.evaluate(evaluator, T_Boolean, A_symbol_380, A_symbol_382);
			return A_symbol_378;
		}
	}

	/** 
	 * Implementation of the CollectionLiteralExp 'SequenceKindIsSequence' invariant.
	 */
	public static class _invariant_SequenceKindIsSequence extends AbstractUnaryOperation
	{
		public static _invariant_SequenceKindIsSequence INSTANCE = new _invariant_SequenceKindIsSequence();
	
		/*
		kind = CollectionKind::Sequence implies
	type.oclIsKindOf(SequenceType)
		*/
		public Value evaluate(DomainEvaluator evaluator, DomainType returnType, final Value self) throws InvalidValueException {
			final ValueFactory valueFactory = evaluator.getValueFactory();
			final DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
			final ExecutorType T_Pivot_ecore__pivot__CollectionKind = PivotTables.Types._CollectionKind;
			final ExecutorProperty P_CollectionLiteralExp_kind = PivotTables.Properties._CollectionLiteralExp__kind;
			final LibraryProperty IP_CollectionLiteralExp_kind = P_CollectionLiteralExp_kind.getImplementation();
			final Value A_symbol_383 = valueFactory.createEnumerationLiteralValue(PivotTables.EnumerationLiterals._CollectionKind__Sequence);
			final ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
			final ExecutorType T_Pivot_ecore__pivot__Type = PivotTables.Types._Type;
			final ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final Value T_ClassClassifier_Pivot_ecore__pivot__SequenceType_ = valueFactory.createTypeValue(PivotTables.Types._SequenceType);
			
			Value leftA_symbol_384;
			try {
				
				Value A_symbol_385 = IP_CollectionLiteralExp_kind.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionKind, self, P_CollectionLiteralExp_kind);
				
				
				DomainType static_A_symbol_386 = valueFactory.typeOf(A_symbol_385, A_symbol_383);
				LibraryBinaryOperation dynamic_A_symbol_386 = (LibraryBinaryOperation)static_A_symbol_386.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_386 = dynamic_A_symbol_386.evaluate(evaluator, T_Boolean, A_symbol_385, A_symbol_383);
				leftA_symbol_384 = A_symbol_386;
			} catch (InvalidValueException e) {
				leftA_symbol_384 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_386 = leftA_symbol_384;
			Value rightA_symbol_384;
			try {
				
				Value A_symbol_387 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_388 = valueFactory.typeOf(A_symbol_387);
				LibraryBinaryOperation dynamic_A_symbol_388 = (LibraryBinaryOperation)static_A_symbol_388.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
				Value A_symbol_388 = dynamic_A_symbol_388.evaluate(evaluator, T_Boolean, A_symbol_387, T_ClassClassifier_Pivot_ecore__pivot__SequenceType_);
				rightA_symbol_384 = A_symbol_388;
			} catch (InvalidValueException e) {
				rightA_symbol_384 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_388 = rightA_symbol_384;
			DomainType static_A_symbol_384 = valueFactory.typeOf(A_symbol_386);
			LibraryBinaryOperation dynamic_A_symbol_384 = (LibraryBinaryOperation)static_A_symbol_384.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_384 = dynamic_A_symbol_384.evaluate(evaluator, T_Boolean, A_symbol_386, A_symbol_388);
			return A_symbol_384;
		}
	}

	/** 
	 * Implementation of the CollectionLiteralExp 'SetKindIsSet' invariant.
	 */
	public static class _invariant_SetKindIsSet extends AbstractUnaryOperation
	{
		public static _invariant_SetKindIsSet INSTANCE = new _invariant_SetKindIsSet();
	
		/*
		kind = CollectionKind::Set implies type.oclIsKindOf(SetType)
		*/
		public Value evaluate(DomainEvaluator evaluator, DomainType returnType, final Value self) throws InvalidValueException {
			final ValueFactory valueFactory = evaluator.getValueFactory();
			final DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
			final ExecutorType T_Pivot_ecore__pivot__CollectionKind = PivotTables.Types._CollectionKind;
			final ExecutorProperty P_CollectionLiteralExp_kind = PivotTables.Properties._CollectionLiteralExp__kind;
			final LibraryProperty IP_CollectionLiteralExp_kind = P_CollectionLiteralExp_kind.getImplementation();
			final Value A_symbol_389 = valueFactory.createEnumerationLiteralValue(PivotTables.EnumerationLiterals._CollectionKind__Set);
			final ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
			final ExecutorType T_Pivot_ecore__pivot__Type = PivotTables.Types._Type;
			final ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final Value T_ClassClassifier_Pivot_ecore__pivot__SetType_ = valueFactory.createTypeValue(PivotTables.Types._SetType);
			
			Value leftA_symbol_390;
			try {
				
				Value A_symbol_391 = IP_CollectionLiteralExp_kind.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionKind, self, P_CollectionLiteralExp_kind);
				
				
				DomainType static_A_symbol_392 = valueFactory.typeOf(A_symbol_391, A_symbol_389);
				LibraryBinaryOperation dynamic_A_symbol_392 = (LibraryBinaryOperation)static_A_symbol_392.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_392 = dynamic_A_symbol_392.evaluate(evaluator, T_Boolean, A_symbol_391, A_symbol_389);
				leftA_symbol_390 = A_symbol_392;
			} catch (InvalidValueException e) {
				leftA_symbol_390 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_392 = leftA_symbol_390;
			Value rightA_symbol_390;
			try {
				
				Value A_symbol_393 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_394 = valueFactory.typeOf(A_symbol_393);
				LibraryBinaryOperation dynamic_A_symbol_394 = (LibraryBinaryOperation)static_A_symbol_394.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
				Value A_symbol_394 = dynamic_A_symbol_394.evaluate(evaluator, T_Boolean, A_symbol_393, T_ClassClassifier_Pivot_ecore__pivot__SetType_);
				rightA_symbol_390 = A_symbol_394;
			} catch (InvalidValueException e) {
				rightA_symbol_390 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_394 = rightA_symbol_390;
			DomainType static_A_symbol_390 = valueFactory.typeOf(A_symbol_392);
			LibraryBinaryOperation dynamic_A_symbol_390 = (LibraryBinaryOperation)static_A_symbol_390.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_390 = dynamic_A_symbol_390.evaluate(evaluator, T_Boolean, A_symbol_392, A_symbol_394);
			return A_symbol_390;
		}
	}


}

