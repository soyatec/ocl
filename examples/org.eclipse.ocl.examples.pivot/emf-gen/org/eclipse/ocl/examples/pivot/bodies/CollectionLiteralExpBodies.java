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
			final Value A_symbol_313 = valueFactory.createEnumerationLiteralValue(PivotTables.EnumerationLiterals._CollectionKind__Bag);
			final ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
			final ExecutorType T_Pivot_ecore__pivot__Type = PivotTables.Types._Type;
			final ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final Value T_ClassClassifier_Pivot_ecore__pivot__BagType_ = valueFactory.createTypeValue(PivotTables.Types._BagType);
			
			Value leftA_symbol_314;
			try {
				
				Value A_symbol_315 = IP_CollectionLiteralExp_kind.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionKind, self, P_CollectionLiteralExp_kind);
				
				
				DomainType static_A_symbol_316 = valueFactory.typeOf(A_symbol_315, A_symbol_313);
				LibraryBinaryOperation dynamic_A_symbol_316 = (LibraryBinaryOperation)static_A_symbol_316.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_316 = dynamic_A_symbol_316.evaluate(evaluator, T_Boolean, A_symbol_315, A_symbol_313);
				leftA_symbol_314 = A_symbol_316;
			} catch (InvalidValueException e) {
				leftA_symbol_314 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_316 = leftA_symbol_314;
			Value rightA_symbol_314;
			try {
				
				Value A_symbol_317 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_318 = valueFactory.typeOf(A_symbol_317);
				LibraryBinaryOperation dynamic_A_symbol_318 = (LibraryBinaryOperation)static_A_symbol_318.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
				Value A_symbol_318 = dynamic_A_symbol_318.evaluate(evaluator, T_Boolean, A_symbol_317, T_ClassClassifier_Pivot_ecore__pivot__BagType_);
				rightA_symbol_314 = A_symbol_318;
			} catch (InvalidValueException e) {
				rightA_symbol_314 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_318 = rightA_symbol_314;
			DomainType static_A_symbol_314 = valueFactory.typeOf(A_symbol_316);
			LibraryBinaryOperation dynamic_A_symbol_314 = (LibraryBinaryOperation)static_A_symbol_314.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_314 = dynamic_A_symbol_314.evaluate(evaluator, T_Boolean, A_symbol_316, A_symbol_318);
			return A_symbol_314;
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
			final Value A_symbol_319 = valueFactory.createEnumerationLiteralValue(PivotTables.EnumerationLiterals._CollectionKind__Collection);
			
			
			Value A_symbol_320 = IP_CollectionLiteralExp_kind.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionKind, self, P_CollectionLiteralExp_kind);
			
			
			DomainType static_A_symbol_321 = valueFactory.typeOf(A_symbol_320, A_symbol_319);
			LibraryBinaryOperation dynamic_A_symbol_321 = (LibraryBinaryOperation)static_A_symbol_321.lookupImplementation(standardLibrary, O_OclAny__lt__gt_);
			Value A_symbol_321 = dynamic_A_symbol_321.evaluate(evaluator, T_Boolean, A_symbol_320, A_symbol_319);
			return A_symbol_321;
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
			final Value A_symbol_322 = valueFactory.createEnumerationLiteralValue(PivotTables.EnumerationLiterals._CollectionKind__OrderedSet);
			final ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
			final ExecutorType T_Pivot_ecore__pivot__Type = PivotTables.Types._Type;
			final ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final Value T_ClassClassifier_Pivot_ecore__pivot__OrderedSetType_ = valueFactory.createTypeValue(PivotTables.Types._OrderedSetType);
			
			Value leftA_symbol_323;
			try {
				
				Value A_symbol_324 = IP_CollectionLiteralExp_kind.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionKind, self, P_CollectionLiteralExp_kind);
				
				
				DomainType static_A_symbol_325 = valueFactory.typeOf(A_symbol_324, A_symbol_322);
				LibraryBinaryOperation dynamic_A_symbol_325 = (LibraryBinaryOperation)static_A_symbol_325.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_325 = dynamic_A_symbol_325.evaluate(evaluator, T_Boolean, A_symbol_324, A_symbol_322);
				leftA_symbol_323 = A_symbol_325;
			} catch (InvalidValueException e) {
				leftA_symbol_323 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_325 = leftA_symbol_323;
			Value rightA_symbol_323;
			try {
				
				Value A_symbol_326 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_327 = valueFactory.typeOf(A_symbol_326);
				LibraryBinaryOperation dynamic_A_symbol_327 = (LibraryBinaryOperation)static_A_symbol_327.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
				Value A_symbol_327 = dynamic_A_symbol_327.evaluate(evaluator, T_Boolean, A_symbol_326, T_ClassClassifier_Pivot_ecore__pivot__OrderedSetType_);
				rightA_symbol_323 = A_symbol_327;
			} catch (InvalidValueException e) {
				rightA_symbol_323 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_327 = rightA_symbol_323;
			DomainType static_A_symbol_323 = valueFactory.typeOf(A_symbol_325);
			LibraryBinaryOperation dynamic_A_symbol_323 = (LibraryBinaryOperation)static_A_symbol_323.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_323 = dynamic_A_symbol_323.evaluate(evaluator, T_Boolean, A_symbol_325, A_symbol_327);
			return A_symbol_323;
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
			final Value A_symbol_328 = valueFactory.createEnumerationLiteralValue(PivotTables.EnumerationLiterals._CollectionKind__Sequence);
			final ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
			final ExecutorType T_Pivot_ecore__pivot__Type = PivotTables.Types._Type;
			final ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final Value T_ClassClassifier_Pivot_ecore__pivot__SequenceType_ = valueFactory.createTypeValue(PivotTables.Types._SequenceType);
			
			Value leftA_symbol_329;
			try {
				
				Value A_symbol_330 = IP_CollectionLiteralExp_kind.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionKind, self, P_CollectionLiteralExp_kind);
				
				
				DomainType static_A_symbol_331 = valueFactory.typeOf(A_symbol_330, A_symbol_328);
				LibraryBinaryOperation dynamic_A_symbol_331 = (LibraryBinaryOperation)static_A_symbol_331.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_331 = dynamic_A_symbol_331.evaluate(evaluator, T_Boolean, A_symbol_330, A_symbol_328);
				leftA_symbol_329 = A_symbol_331;
			} catch (InvalidValueException e) {
				leftA_symbol_329 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_331 = leftA_symbol_329;
			Value rightA_symbol_329;
			try {
				
				Value A_symbol_332 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_333 = valueFactory.typeOf(A_symbol_332);
				LibraryBinaryOperation dynamic_A_symbol_333 = (LibraryBinaryOperation)static_A_symbol_333.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
				Value A_symbol_333 = dynamic_A_symbol_333.evaluate(evaluator, T_Boolean, A_symbol_332, T_ClassClassifier_Pivot_ecore__pivot__SequenceType_);
				rightA_symbol_329 = A_symbol_333;
			} catch (InvalidValueException e) {
				rightA_symbol_329 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_333 = rightA_symbol_329;
			DomainType static_A_symbol_329 = valueFactory.typeOf(A_symbol_331);
			LibraryBinaryOperation dynamic_A_symbol_329 = (LibraryBinaryOperation)static_A_symbol_329.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_329 = dynamic_A_symbol_329.evaluate(evaluator, T_Boolean, A_symbol_331, A_symbol_333);
			return A_symbol_329;
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
			final Value A_symbol_334 = valueFactory.createEnumerationLiteralValue(PivotTables.EnumerationLiterals._CollectionKind__Set);
			final ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
			final ExecutorType T_Pivot_ecore__pivot__Type = PivotTables.Types._Type;
			final ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final Value T_ClassClassifier_Pivot_ecore__pivot__SetType_ = valueFactory.createTypeValue(PivotTables.Types._SetType);
			
			Value leftA_symbol_335;
			try {
				
				Value A_symbol_336 = IP_CollectionLiteralExp_kind.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionKind, self, P_CollectionLiteralExp_kind);
				
				
				DomainType static_A_symbol_337 = valueFactory.typeOf(A_symbol_336, A_symbol_334);
				LibraryBinaryOperation dynamic_A_symbol_337 = (LibraryBinaryOperation)static_A_symbol_337.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_337 = dynamic_A_symbol_337.evaluate(evaluator, T_Boolean, A_symbol_336, A_symbol_334);
				leftA_symbol_335 = A_symbol_337;
			} catch (InvalidValueException e) {
				leftA_symbol_335 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_337 = leftA_symbol_335;
			Value rightA_symbol_335;
			try {
				
				Value A_symbol_338 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_339 = valueFactory.typeOf(A_symbol_338);
				LibraryBinaryOperation dynamic_A_symbol_339 = (LibraryBinaryOperation)static_A_symbol_339.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
				Value A_symbol_339 = dynamic_A_symbol_339.evaluate(evaluator, T_Boolean, A_symbol_338, T_ClassClassifier_Pivot_ecore__pivot__SetType_);
				rightA_symbol_335 = A_symbol_339;
			} catch (InvalidValueException e) {
				rightA_symbol_335 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_339 = rightA_symbol_335;
			DomainType static_A_symbol_335 = valueFactory.typeOf(A_symbol_337);
			LibraryBinaryOperation dynamic_A_symbol_335 = (LibraryBinaryOperation)static_A_symbol_335.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_335 = dynamic_A_symbol_335.evaluate(evaluator, T_Boolean, A_symbol_337, A_symbol_339);
			return A_symbol_335;
		}
	}


}

