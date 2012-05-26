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
			final Value A_symbol_78 = valueFactory.createEnumerationLiteralValue(PivotTables.EnumerationLiterals._CollectionKind__Bag);
			final ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
			final ExecutorType T_Pivot_ecore__pivot__Type = PivotTables.Types._Type;
			final ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final Value T_ClassClassifier_Pivot_ecore__pivot__BagType_ = valueFactory.createTypeValue(PivotTables.Types._BagType);
			
			Value leftA_symbol_79;
			try {
				
				Value A_symbol_80 = IP_CollectionLiteralExp_kind.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionKind, self, P_CollectionLiteralExp_kind);
				
				
				DomainType static_A_symbol_81 = valueFactory.typeOf(A_symbol_80, A_symbol_78);
				LibraryBinaryOperation dynamic_A_symbol_81 = (LibraryBinaryOperation)static_A_symbol_81.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_81 = dynamic_A_symbol_81.evaluate(evaluator, T_Boolean, A_symbol_80, A_symbol_78);
				leftA_symbol_79 = A_symbol_81;
			} catch (InvalidValueException e) {
				leftA_symbol_79 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_81 = leftA_symbol_79;
			Value rightA_symbol_79;
			try {
				
				Value A_symbol_82 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_83 = valueFactory.typeOf(A_symbol_82);
				LibraryBinaryOperation dynamic_A_symbol_83 = (LibraryBinaryOperation)static_A_symbol_83.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
				Value A_symbol_83 = dynamic_A_symbol_83.evaluate(evaluator, T_Boolean, A_symbol_82, T_ClassClassifier_Pivot_ecore__pivot__BagType_);
				rightA_symbol_79 = A_symbol_83;
			} catch (InvalidValueException e) {
				rightA_symbol_79 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_83 = rightA_symbol_79;
			DomainType static_A_symbol_79 = valueFactory.typeOf(A_symbol_81);
			LibraryBinaryOperation dynamic_A_symbol_79 = (LibraryBinaryOperation)static_A_symbol_79.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_79 = dynamic_A_symbol_79.evaluate(evaluator, T_Boolean, A_symbol_81, A_symbol_83);
			return A_symbol_79;
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
			final Value A_symbol_84 = valueFactory.createEnumerationLiteralValue(PivotTables.EnumerationLiterals._CollectionKind__Collection);
			
			
			Value A_symbol_85 = IP_CollectionLiteralExp_kind.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionKind, self, P_CollectionLiteralExp_kind);
			
			
			DomainType static_A_symbol_86 = valueFactory.typeOf(A_symbol_85, A_symbol_84);
			LibraryBinaryOperation dynamic_A_symbol_86 = (LibraryBinaryOperation)static_A_symbol_86.lookupImplementation(standardLibrary, O_OclAny__lt__gt_);
			Value A_symbol_86 = dynamic_A_symbol_86.evaluate(evaluator, T_Boolean, A_symbol_85, A_symbol_84);
			return A_symbol_86;
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
			final Value A_symbol_87 = valueFactory.createEnumerationLiteralValue(PivotTables.EnumerationLiterals._CollectionKind__OrderedSet);
			final ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
			final ExecutorType T_Pivot_ecore__pivot__Type = PivotTables.Types._Type;
			final ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final Value T_ClassClassifier_Pivot_ecore__pivot__OrderedSetType_ = valueFactory.createTypeValue(PivotTables.Types._OrderedSetType);
			
			Value leftA_symbol_88;
			try {
				
				Value A_symbol_89 = IP_CollectionLiteralExp_kind.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionKind, self, P_CollectionLiteralExp_kind);
				
				
				DomainType static_A_symbol_90 = valueFactory.typeOf(A_symbol_89, A_symbol_87);
				LibraryBinaryOperation dynamic_A_symbol_90 = (LibraryBinaryOperation)static_A_symbol_90.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_90 = dynamic_A_symbol_90.evaluate(evaluator, T_Boolean, A_symbol_89, A_symbol_87);
				leftA_symbol_88 = A_symbol_90;
			} catch (InvalidValueException e) {
				leftA_symbol_88 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_90 = leftA_symbol_88;
			Value rightA_symbol_88;
			try {
				
				Value A_symbol_91 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_92 = valueFactory.typeOf(A_symbol_91);
				LibraryBinaryOperation dynamic_A_symbol_92 = (LibraryBinaryOperation)static_A_symbol_92.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
				Value A_symbol_92 = dynamic_A_symbol_92.evaluate(evaluator, T_Boolean, A_symbol_91, T_ClassClassifier_Pivot_ecore__pivot__OrderedSetType_);
				rightA_symbol_88 = A_symbol_92;
			} catch (InvalidValueException e) {
				rightA_symbol_88 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_92 = rightA_symbol_88;
			DomainType static_A_symbol_88 = valueFactory.typeOf(A_symbol_90);
			LibraryBinaryOperation dynamic_A_symbol_88 = (LibraryBinaryOperation)static_A_symbol_88.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_88 = dynamic_A_symbol_88.evaluate(evaluator, T_Boolean, A_symbol_90, A_symbol_92);
			return A_symbol_88;
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
			final Value A_symbol_93 = valueFactory.createEnumerationLiteralValue(PivotTables.EnumerationLiterals._CollectionKind__Sequence);
			final ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
			final ExecutorType T_Pivot_ecore__pivot__Type = PivotTables.Types._Type;
			final ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final Value T_ClassClassifier_Pivot_ecore__pivot__SequenceType_ = valueFactory.createTypeValue(PivotTables.Types._SequenceType);
			
			Value leftA_symbol_94;
			try {
				
				Value A_symbol_95 = IP_CollectionLiteralExp_kind.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionKind, self, P_CollectionLiteralExp_kind);
				
				
				DomainType static_A_symbol_96 = valueFactory.typeOf(A_symbol_95, A_symbol_93);
				LibraryBinaryOperation dynamic_A_symbol_96 = (LibraryBinaryOperation)static_A_symbol_96.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_96 = dynamic_A_symbol_96.evaluate(evaluator, T_Boolean, A_symbol_95, A_symbol_93);
				leftA_symbol_94 = A_symbol_96;
			} catch (InvalidValueException e) {
				leftA_symbol_94 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_96 = leftA_symbol_94;
			Value rightA_symbol_94;
			try {
				
				Value A_symbol_97 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_98 = valueFactory.typeOf(A_symbol_97);
				LibraryBinaryOperation dynamic_A_symbol_98 = (LibraryBinaryOperation)static_A_symbol_98.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
				Value A_symbol_98 = dynamic_A_symbol_98.evaluate(evaluator, T_Boolean, A_symbol_97, T_ClassClassifier_Pivot_ecore__pivot__SequenceType_);
				rightA_symbol_94 = A_symbol_98;
			} catch (InvalidValueException e) {
				rightA_symbol_94 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_98 = rightA_symbol_94;
			DomainType static_A_symbol_94 = valueFactory.typeOf(A_symbol_96);
			LibraryBinaryOperation dynamic_A_symbol_94 = (LibraryBinaryOperation)static_A_symbol_94.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_94 = dynamic_A_symbol_94.evaluate(evaluator, T_Boolean, A_symbol_96, A_symbol_98);
			return A_symbol_94;
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
			final Value A_symbol_99 = valueFactory.createEnumerationLiteralValue(PivotTables.EnumerationLiterals._CollectionKind__Set);
			final ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
			final ExecutorType T_Pivot_ecore__pivot__Type = PivotTables.Types._Type;
			final ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final Value T_ClassClassifier_Pivot_ecore__pivot__SetType_ = valueFactory.createTypeValue(PivotTables.Types._SetType);
			
			Value leftA_symbol_100;
			try {
				
				Value A_symbol_101 = IP_CollectionLiteralExp_kind.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionKind, self, P_CollectionLiteralExp_kind);
				
				
				DomainType static_A_symbol_102 = valueFactory.typeOf(A_symbol_101, A_symbol_99);
				LibraryBinaryOperation dynamic_A_symbol_102 = (LibraryBinaryOperation)static_A_symbol_102.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_102 = dynamic_A_symbol_102.evaluate(evaluator, T_Boolean, A_symbol_101, A_symbol_99);
				leftA_symbol_100 = A_symbol_102;
			} catch (InvalidValueException e) {
				leftA_symbol_100 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_102 = leftA_symbol_100;
			Value rightA_symbol_100;
			try {
				
				Value A_symbol_103 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_104 = valueFactory.typeOf(A_symbol_103);
				LibraryBinaryOperation dynamic_A_symbol_104 = (LibraryBinaryOperation)static_A_symbol_104.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
				Value A_symbol_104 = dynamic_A_symbol_104.evaluate(evaluator, T_Boolean, A_symbol_103, T_ClassClassifier_Pivot_ecore__pivot__SetType_);
				rightA_symbol_100 = A_symbol_104;
			} catch (InvalidValueException e) {
				rightA_symbol_100 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_104 = rightA_symbol_100;
			DomainType static_A_symbol_100 = valueFactory.typeOf(A_symbol_102);
			LibraryBinaryOperation dynamic_A_symbol_100 = (LibraryBinaryOperation)static_A_symbol_100.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_100 = dynamic_A_symbol_100.evaluate(evaluator, T_Boolean, A_symbol_102, A_symbol_104);
			return A_symbol_100;
		}
	}


}

