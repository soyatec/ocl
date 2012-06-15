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
			final Value A_symbol_3 = valueFactory.createEnumerationLiteralValue(PivotTables.EnumerationLiterals._CollectionKind__Bag);
			final ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
			final ExecutorType T_Pivot_ecore__pivot__Type = PivotTables.Types._Type;
			final ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final Value T_ClassClassifier_Pivot_ecore__pivot__BagType_ = valueFactory.createTypeValue(PivotTables.Types._BagType);
			
			Value leftA_symbol_4;
			try {
				
				Value A_symbol_5 = IP_CollectionLiteralExp_kind.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionKind, self, P_CollectionLiteralExp_kind);
				
				
				DomainType static_A_symbol_6 = valueFactory.typeOf(A_symbol_5, A_symbol_3);
				LibraryBinaryOperation dynamic_A_symbol_6 = (LibraryBinaryOperation)static_A_symbol_6.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_6 = dynamic_A_symbol_6.evaluate(evaluator, T_Boolean, A_symbol_5, A_symbol_3);
				leftA_symbol_4 = A_symbol_6;
			} catch (InvalidValueException e) {
				leftA_symbol_4 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_6 = leftA_symbol_4;
			Value rightA_symbol_4;
			try {
				
				Value A_symbol_7 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_8 = valueFactory.typeOf(A_symbol_7);
				LibraryBinaryOperation dynamic_A_symbol_8 = (LibraryBinaryOperation)static_A_symbol_8.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
				Value A_symbol_8 = dynamic_A_symbol_8.evaluate(evaluator, T_Boolean, A_symbol_7, T_ClassClassifier_Pivot_ecore__pivot__BagType_);
				rightA_symbol_4 = A_symbol_8;
			} catch (InvalidValueException e) {
				rightA_symbol_4 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_8 = rightA_symbol_4;
			DomainType static_A_symbol_4 = valueFactory.typeOf(A_symbol_6);
			LibraryBinaryOperation dynamic_A_symbol_4 = (LibraryBinaryOperation)static_A_symbol_4.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_4 = dynamic_A_symbol_4.evaluate(evaluator, T_Boolean, A_symbol_6, A_symbol_8);
			return A_symbol_4;
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
			final Value A_symbol_9 = valueFactory.createEnumerationLiteralValue(PivotTables.EnumerationLiterals._CollectionKind__Collection);
			
			
			Value A_symbol_10 = IP_CollectionLiteralExp_kind.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionKind, self, P_CollectionLiteralExp_kind);
			
			
			DomainType static_A_symbol_11 = valueFactory.typeOf(A_symbol_10, A_symbol_9);
			LibraryBinaryOperation dynamic_A_symbol_11 = (LibraryBinaryOperation)static_A_symbol_11.lookupImplementation(standardLibrary, O_OclAny__lt__gt_);
			Value A_symbol_11 = dynamic_A_symbol_11.evaluate(evaluator, T_Boolean, A_symbol_10, A_symbol_9);
			return A_symbol_11;
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
			final Value A_symbol_12 = valueFactory.createEnumerationLiteralValue(PivotTables.EnumerationLiterals._CollectionKind__OrderedSet);
			final ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
			final ExecutorType T_Pivot_ecore__pivot__Type = PivotTables.Types._Type;
			final ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final Value T_ClassClassifier_Pivot_ecore__pivot__OrderedSetType_ = valueFactory.createTypeValue(PivotTables.Types._OrderedSetType);
			
			Value leftA_symbol_13;
			try {
				
				Value A_symbol_14 = IP_CollectionLiteralExp_kind.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionKind, self, P_CollectionLiteralExp_kind);
				
				
				DomainType static_A_symbol_15 = valueFactory.typeOf(A_symbol_14, A_symbol_12);
				LibraryBinaryOperation dynamic_A_symbol_15 = (LibraryBinaryOperation)static_A_symbol_15.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_15 = dynamic_A_symbol_15.evaluate(evaluator, T_Boolean, A_symbol_14, A_symbol_12);
				leftA_symbol_13 = A_symbol_15;
			} catch (InvalidValueException e) {
				leftA_symbol_13 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_15 = leftA_symbol_13;
			Value rightA_symbol_13;
			try {
				
				Value A_symbol_16 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_17 = valueFactory.typeOf(A_symbol_16);
				LibraryBinaryOperation dynamic_A_symbol_17 = (LibraryBinaryOperation)static_A_symbol_17.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
				Value A_symbol_17 = dynamic_A_symbol_17.evaluate(evaluator, T_Boolean, A_symbol_16, T_ClassClassifier_Pivot_ecore__pivot__OrderedSetType_);
				rightA_symbol_13 = A_symbol_17;
			} catch (InvalidValueException e) {
				rightA_symbol_13 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_17 = rightA_symbol_13;
			DomainType static_A_symbol_13 = valueFactory.typeOf(A_symbol_15);
			LibraryBinaryOperation dynamic_A_symbol_13 = (LibraryBinaryOperation)static_A_symbol_13.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_13 = dynamic_A_symbol_13.evaluate(evaluator, T_Boolean, A_symbol_15, A_symbol_17);
			return A_symbol_13;
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
			final Value A_symbol_18 = valueFactory.createEnumerationLiteralValue(PivotTables.EnumerationLiterals._CollectionKind__Sequence);
			final ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
			final ExecutorType T_Pivot_ecore__pivot__Type = PivotTables.Types._Type;
			final ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final Value T_ClassClassifier_Pivot_ecore__pivot__SequenceType_ = valueFactory.createTypeValue(PivotTables.Types._SequenceType);
			
			Value leftA_symbol_19;
			try {
				
				Value A_symbol_20 = IP_CollectionLiteralExp_kind.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionKind, self, P_CollectionLiteralExp_kind);
				
				
				DomainType static_A_symbol_21 = valueFactory.typeOf(A_symbol_20, A_symbol_18);
				LibraryBinaryOperation dynamic_A_symbol_21 = (LibraryBinaryOperation)static_A_symbol_21.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_21 = dynamic_A_symbol_21.evaluate(evaluator, T_Boolean, A_symbol_20, A_symbol_18);
				leftA_symbol_19 = A_symbol_21;
			} catch (InvalidValueException e) {
				leftA_symbol_19 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_21 = leftA_symbol_19;
			Value rightA_symbol_19;
			try {
				
				Value A_symbol_22 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_23 = valueFactory.typeOf(A_symbol_22);
				LibraryBinaryOperation dynamic_A_symbol_23 = (LibraryBinaryOperation)static_A_symbol_23.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
				Value A_symbol_23 = dynamic_A_symbol_23.evaluate(evaluator, T_Boolean, A_symbol_22, T_ClassClassifier_Pivot_ecore__pivot__SequenceType_);
				rightA_symbol_19 = A_symbol_23;
			} catch (InvalidValueException e) {
				rightA_symbol_19 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_23 = rightA_symbol_19;
			DomainType static_A_symbol_19 = valueFactory.typeOf(A_symbol_21);
			LibraryBinaryOperation dynamic_A_symbol_19 = (LibraryBinaryOperation)static_A_symbol_19.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_19 = dynamic_A_symbol_19.evaluate(evaluator, T_Boolean, A_symbol_21, A_symbol_23);
			return A_symbol_19;
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
			final Value A_symbol_24 = valueFactory.createEnumerationLiteralValue(PivotTables.EnumerationLiterals._CollectionKind__Set);
			final ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
			final ExecutorType T_Pivot_ecore__pivot__Type = PivotTables.Types._Type;
			final ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final Value T_ClassClassifier_Pivot_ecore__pivot__SetType_ = valueFactory.createTypeValue(PivotTables.Types._SetType);
			
			Value leftA_symbol_25;
			try {
				
				Value A_symbol_26 = IP_CollectionLiteralExp_kind.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionKind, self, P_CollectionLiteralExp_kind);
				
				
				DomainType static_A_symbol_27 = valueFactory.typeOf(A_symbol_26, A_symbol_24);
				LibraryBinaryOperation dynamic_A_symbol_27 = (LibraryBinaryOperation)static_A_symbol_27.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_27 = dynamic_A_symbol_27.evaluate(evaluator, T_Boolean, A_symbol_26, A_symbol_24);
				leftA_symbol_25 = A_symbol_27;
			} catch (InvalidValueException e) {
				leftA_symbol_25 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_27 = leftA_symbol_25;
			Value rightA_symbol_25;
			try {
				
				Value A_symbol_28 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_29 = valueFactory.typeOf(A_symbol_28);
				LibraryBinaryOperation dynamic_A_symbol_29 = (LibraryBinaryOperation)static_A_symbol_29.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
				Value A_symbol_29 = dynamic_A_symbol_29.evaluate(evaluator, T_Boolean, A_symbol_28, T_ClassClassifier_Pivot_ecore__pivot__SetType_);
				rightA_symbol_25 = A_symbol_29;
			} catch (InvalidValueException e) {
				rightA_symbol_25 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_29 = rightA_symbol_25;
			DomainType static_A_symbol_25 = valueFactory.typeOf(A_symbol_27);
			LibraryBinaryOperation dynamic_A_symbol_25 = (LibraryBinaryOperation)static_A_symbol_25.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_25 = dynamic_A_symbol_25.evaluate(evaluator, T_Boolean, A_symbol_27, A_symbol_29);
			return A_symbol_25;
		}
	}


}

