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
			final ExecutorType T_pivot__CollectionKind = PivotTables.Types._CollectionKind;
			final ExecutorProperty P_CollectionLiteralExp_kind = PivotTables.Properties._CollectionLiteralExp__kind;
			final LibraryProperty IP_CollectionLiteralExp_kind = P_CollectionLiteralExp_kind.getImplementation();
			final Value A_symbol_320 = valueFactory.createEnumerationLiteralValue(PivotTables.EnumerationLiterals._CollectionKind__Bag);
			final ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
			final ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final Value T_ClassClassifier_pivot__BagType_ = valueFactory.createTypeValue(PivotTables.Types._BagType);
			
			Value leftA_symbol_321;
			try {
				
				Value A_symbol_322 = IP_CollectionLiteralExp_kind.evaluate(evaluator, T_pivot__CollectionKind, self, P_CollectionLiteralExp_kind);
				
				
				DomainType static_A_symbol_323 = valueFactory.typeOf(A_symbol_322, A_symbol_320);
				LibraryBinaryOperation dynamic_A_symbol_323 = (LibraryBinaryOperation)static_A_symbol_323.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_323 = dynamic_A_symbol_323.evaluate(evaluator, T_Boolean, A_symbol_322, A_symbol_320);
				leftA_symbol_321 = A_symbol_323;
			} catch (InvalidValueException e) {
				leftA_symbol_321 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_323 = leftA_symbol_321;
			Value rightA_symbol_321;
			try {
				
				Value A_symbol_324 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_325 = valueFactory.typeOf(A_symbol_324);
				LibraryBinaryOperation dynamic_A_symbol_325 = (LibraryBinaryOperation)static_A_symbol_325.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
				Value A_symbol_325 = dynamic_A_symbol_325.evaluate(evaluator, T_Boolean, A_symbol_324, T_ClassClassifier_pivot__BagType_);
				rightA_symbol_321 = A_symbol_325;
			} catch (InvalidValueException e) {
				rightA_symbol_321 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_325 = rightA_symbol_321;
			DomainType static_A_symbol_321 = valueFactory.typeOf(A_symbol_323);
			LibraryBinaryOperation dynamic_A_symbol_321 = (LibraryBinaryOperation)static_A_symbol_321.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_321 = dynamic_A_symbol_321.evaluate(evaluator, T_Boolean, A_symbol_323, A_symbol_325);
			return A_symbol_321;
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
			final ExecutorType T_pivot__CollectionKind = PivotTables.Types._CollectionKind;
			final ExecutorProperty P_CollectionLiteralExp_kind = PivotTables.Properties._CollectionLiteralExp__kind;
			final LibraryProperty IP_CollectionLiteralExp_kind = P_CollectionLiteralExp_kind.getImplementation();
			final Value A_symbol_326 = valueFactory.createEnumerationLiteralValue(PivotTables.EnumerationLiterals._CollectionKind__Collection);
			
			
			Value A_symbol_327 = IP_CollectionLiteralExp_kind.evaluate(evaluator, T_pivot__CollectionKind, self, P_CollectionLiteralExp_kind);
			
			
			DomainType static_A_symbol_328 = valueFactory.typeOf(A_symbol_327, A_symbol_326);
			LibraryBinaryOperation dynamic_A_symbol_328 = (LibraryBinaryOperation)static_A_symbol_328.lookupImplementation(standardLibrary, O_OclAny__lt__gt_);
			Value A_symbol_328 = dynamic_A_symbol_328.evaluate(evaluator, T_Boolean, A_symbol_327, A_symbol_326);
			return A_symbol_328;
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
			final ExecutorType T_pivot__CollectionKind = PivotTables.Types._CollectionKind;
			final ExecutorProperty P_CollectionLiteralExp_kind = PivotTables.Properties._CollectionLiteralExp__kind;
			final LibraryProperty IP_CollectionLiteralExp_kind = P_CollectionLiteralExp_kind.getImplementation();
			final Value A_symbol_329 = valueFactory.createEnumerationLiteralValue(PivotTables.EnumerationLiterals._CollectionKind__OrderedSet);
			final ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
			final ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final Value T_ClassClassifier_pivot__OrderedSetType_ = valueFactory.createTypeValue(PivotTables.Types._OrderedSetType);
			
			Value leftA_symbol_330;
			try {
				
				Value A_symbol_331 = IP_CollectionLiteralExp_kind.evaluate(evaluator, T_pivot__CollectionKind, self, P_CollectionLiteralExp_kind);
				
				
				DomainType static_A_symbol_332 = valueFactory.typeOf(A_symbol_331, A_symbol_329);
				LibraryBinaryOperation dynamic_A_symbol_332 = (LibraryBinaryOperation)static_A_symbol_332.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_332 = dynamic_A_symbol_332.evaluate(evaluator, T_Boolean, A_symbol_331, A_symbol_329);
				leftA_symbol_330 = A_symbol_332;
			} catch (InvalidValueException e) {
				leftA_symbol_330 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_332 = leftA_symbol_330;
			Value rightA_symbol_330;
			try {
				
				Value A_symbol_333 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_334 = valueFactory.typeOf(A_symbol_333);
				LibraryBinaryOperation dynamic_A_symbol_334 = (LibraryBinaryOperation)static_A_symbol_334.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
				Value A_symbol_334 = dynamic_A_symbol_334.evaluate(evaluator, T_Boolean, A_symbol_333, T_ClassClassifier_pivot__OrderedSetType_);
				rightA_symbol_330 = A_symbol_334;
			} catch (InvalidValueException e) {
				rightA_symbol_330 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_334 = rightA_symbol_330;
			DomainType static_A_symbol_330 = valueFactory.typeOf(A_symbol_332);
			LibraryBinaryOperation dynamic_A_symbol_330 = (LibraryBinaryOperation)static_A_symbol_330.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_330 = dynamic_A_symbol_330.evaluate(evaluator, T_Boolean, A_symbol_332, A_symbol_334);
			return A_symbol_330;
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
			final ExecutorType T_pivot__CollectionKind = PivotTables.Types._CollectionKind;
			final ExecutorProperty P_CollectionLiteralExp_kind = PivotTables.Properties._CollectionLiteralExp__kind;
			final LibraryProperty IP_CollectionLiteralExp_kind = P_CollectionLiteralExp_kind.getImplementation();
			final Value A_symbol_335 = valueFactory.createEnumerationLiteralValue(PivotTables.EnumerationLiterals._CollectionKind__Sequence);
			final ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
			final ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final Value T_ClassClassifier_pivot__SequenceType_ = valueFactory.createTypeValue(PivotTables.Types._SequenceType);
			
			Value leftA_symbol_336;
			try {
				
				Value A_symbol_337 = IP_CollectionLiteralExp_kind.evaluate(evaluator, T_pivot__CollectionKind, self, P_CollectionLiteralExp_kind);
				
				
				DomainType static_A_symbol_338 = valueFactory.typeOf(A_symbol_337, A_symbol_335);
				LibraryBinaryOperation dynamic_A_symbol_338 = (LibraryBinaryOperation)static_A_symbol_338.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_338 = dynamic_A_symbol_338.evaluate(evaluator, T_Boolean, A_symbol_337, A_symbol_335);
				leftA_symbol_336 = A_symbol_338;
			} catch (InvalidValueException e) {
				leftA_symbol_336 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_338 = leftA_symbol_336;
			Value rightA_symbol_336;
			try {
				
				Value A_symbol_339 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_340 = valueFactory.typeOf(A_symbol_339);
				LibraryBinaryOperation dynamic_A_symbol_340 = (LibraryBinaryOperation)static_A_symbol_340.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
				Value A_symbol_340 = dynamic_A_symbol_340.evaluate(evaluator, T_Boolean, A_symbol_339, T_ClassClassifier_pivot__SequenceType_);
				rightA_symbol_336 = A_symbol_340;
			} catch (InvalidValueException e) {
				rightA_symbol_336 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_340 = rightA_symbol_336;
			DomainType static_A_symbol_336 = valueFactory.typeOf(A_symbol_338);
			LibraryBinaryOperation dynamic_A_symbol_336 = (LibraryBinaryOperation)static_A_symbol_336.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_336 = dynamic_A_symbol_336.evaluate(evaluator, T_Boolean, A_symbol_338, A_symbol_340);
			return A_symbol_336;
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
			final ExecutorType T_pivot__CollectionKind = PivotTables.Types._CollectionKind;
			final ExecutorProperty P_CollectionLiteralExp_kind = PivotTables.Properties._CollectionLiteralExp__kind;
			final LibraryProperty IP_CollectionLiteralExp_kind = P_CollectionLiteralExp_kind.getImplementation();
			final Value A_symbol_341 = valueFactory.createEnumerationLiteralValue(PivotTables.EnumerationLiterals._CollectionKind__Set);
			final ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
			final ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final Value T_ClassClassifier_pivot__SetType_ = valueFactory.createTypeValue(PivotTables.Types._SetType);
			
			Value leftA_symbol_342;
			try {
				
				Value A_symbol_343 = IP_CollectionLiteralExp_kind.evaluate(evaluator, T_pivot__CollectionKind, self, P_CollectionLiteralExp_kind);
				
				
				DomainType static_A_symbol_344 = valueFactory.typeOf(A_symbol_343, A_symbol_341);
				LibraryBinaryOperation dynamic_A_symbol_344 = (LibraryBinaryOperation)static_A_symbol_344.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_344 = dynamic_A_symbol_344.evaluate(evaluator, T_Boolean, A_symbol_343, A_symbol_341);
				leftA_symbol_342 = A_symbol_344;
			} catch (InvalidValueException e) {
				leftA_symbol_342 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_344 = leftA_symbol_342;
			Value rightA_symbol_342;
			try {
				
				Value A_symbol_345 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_346 = valueFactory.typeOf(A_symbol_345);
				LibraryBinaryOperation dynamic_A_symbol_346 = (LibraryBinaryOperation)static_A_symbol_346.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
				Value A_symbol_346 = dynamic_A_symbol_346.evaluate(evaluator, T_Boolean, A_symbol_345, T_ClassClassifier_pivot__SetType_);
				rightA_symbol_342 = A_symbol_346;
			} catch (InvalidValueException e) {
				rightA_symbol_342 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_346 = rightA_symbol_342;
			DomainType static_A_symbol_342 = valueFactory.typeOf(A_symbol_344);
			LibraryBinaryOperation dynamic_A_symbol_342 = (LibraryBinaryOperation)static_A_symbol_342.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_342 = dynamic_A_symbol_342.evaluate(evaluator, T_Boolean, A_symbol_344, A_symbol_346);
			return A_symbol_342;
		}
	}


}

