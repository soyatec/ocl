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
			final Value A_symbol_93 = valueFactory.createEnumerationLiteralValue(PivotTables.EnumerationLiterals._CollectionKind__Bag);
			final ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
			final ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final Value T_ClassClassifier_pivot__BagType_ = valueFactory.createTypeValue(PivotTables.Types._BagType);
			
			Value leftA_symbol_94;
			try {
				
				Value A_symbol_95 = IP_CollectionLiteralExp_kind.evaluate(evaluator, T_pivot__CollectionKind, self, P_CollectionLiteralExp_kind);
				
				
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
				
				Value A_symbol_97 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_98 = valueFactory.typeOf(A_symbol_97);
				LibraryBinaryOperation dynamic_A_symbol_98 = (LibraryBinaryOperation)static_A_symbol_98.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
				Value A_symbol_98 = dynamic_A_symbol_98.evaluate(evaluator, T_Boolean, A_symbol_97, T_ClassClassifier_pivot__BagType_);
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
			final Value A_symbol_99 = valueFactory.createEnumerationLiteralValue(PivotTables.EnumerationLiterals._CollectionKind__Collection);
			
			
			Value A_symbol_100 = IP_CollectionLiteralExp_kind.evaluate(evaluator, T_pivot__CollectionKind, self, P_CollectionLiteralExp_kind);
			
			
			DomainType static_A_symbol_101 = valueFactory.typeOf(A_symbol_100, A_symbol_99);
			LibraryBinaryOperation dynamic_A_symbol_101 = (LibraryBinaryOperation)static_A_symbol_101.lookupImplementation(standardLibrary, O_OclAny__lt__gt_);
			Value A_symbol_101 = dynamic_A_symbol_101.evaluate(evaluator, T_Boolean, A_symbol_100, A_symbol_99);
			return A_symbol_101;
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
			final Value A_symbol_102 = valueFactory.createEnumerationLiteralValue(PivotTables.EnumerationLiterals._CollectionKind__OrderedSet);
			final ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
			final ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final Value T_ClassClassifier_pivot__OrderedSetType_ = valueFactory.createTypeValue(PivotTables.Types._OrderedSetType);
			
			Value leftA_symbol_103;
			try {
				
				Value A_symbol_104 = IP_CollectionLiteralExp_kind.evaluate(evaluator, T_pivot__CollectionKind, self, P_CollectionLiteralExp_kind);
				
				
				DomainType static_A_symbol_105 = valueFactory.typeOf(A_symbol_104, A_symbol_102);
				LibraryBinaryOperation dynamic_A_symbol_105 = (LibraryBinaryOperation)static_A_symbol_105.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_105 = dynamic_A_symbol_105.evaluate(evaluator, T_Boolean, A_symbol_104, A_symbol_102);
				leftA_symbol_103 = A_symbol_105;
			} catch (InvalidValueException e) {
				leftA_symbol_103 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_105 = leftA_symbol_103;
			Value rightA_symbol_103;
			try {
				
				Value A_symbol_106 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_107 = valueFactory.typeOf(A_symbol_106);
				LibraryBinaryOperation dynamic_A_symbol_107 = (LibraryBinaryOperation)static_A_symbol_107.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
				Value A_symbol_107 = dynamic_A_symbol_107.evaluate(evaluator, T_Boolean, A_symbol_106, T_ClassClassifier_pivot__OrderedSetType_);
				rightA_symbol_103 = A_symbol_107;
			} catch (InvalidValueException e) {
				rightA_symbol_103 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_107 = rightA_symbol_103;
			DomainType static_A_symbol_103 = valueFactory.typeOf(A_symbol_105);
			LibraryBinaryOperation dynamic_A_symbol_103 = (LibraryBinaryOperation)static_A_symbol_103.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_103 = dynamic_A_symbol_103.evaluate(evaluator, T_Boolean, A_symbol_105, A_symbol_107);
			return A_symbol_103;
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
			final Value A_symbol_108 = valueFactory.createEnumerationLiteralValue(PivotTables.EnumerationLiterals._CollectionKind__Sequence);
			final ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
			final ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final Value T_ClassClassifier_pivot__SequenceType_ = valueFactory.createTypeValue(PivotTables.Types._SequenceType);
			
			Value leftA_symbol_109;
			try {
				
				Value A_symbol_110 = IP_CollectionLiteralExp_kind.evaluate(evaluator, T_pivot__CollectionKind, self, P_CollectionLiteralExp_kind);
				
				
				DomainType static_A_symbol_111 = valueFactory.typeOf(A_symbol_110, A_symbol_108);
				LibraryBinaryOperation dynamic_A_symbol_111 = (LibraryBinaryOperation)static_A_symbol_111.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_111 = dynamic_A_symbol_111.evaluate(evaluator, T_Boolean, A_symbol_110, A_symbol_108);
				leftA_symbol_109 = A_symbol_111;
			} catch (InvalidValueException e) {
				leftA_symbol_109 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_111 = leftA_symbol_109;
			Value rightA_symbol_109;
			try {
				
				Value A_symbol_112 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_113 = valueFactory.typeOf(A_symbol_112);
				LibraryBinaryOperation dynamic_A_symbol_113 = (LibraryBinaryOperation)static_A_symbol_113.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
				Value A_symbol_113 = dynamic_A_symbol_113.evaluate(evaluator, T_Boolean, A_symbol_112, T_ClassClassifier_pivot__SequenceType_);
				rightA_symbol_109 = A_symbol_113;
			} catch (InvalidValueException e) {
				rightA_symbol_109 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_113 = rightA_symbol_109;
			DomainType static_A_symbol_109 = valueFactory.typeOf(A_symbol_111);
			LibraryBinaryOperation dynamic_A_symbol_109 = (LibraryBinaryOperation)static_A_symbol_109.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_109 = dynamic_A_symbol_109.evaluate(evaluator, T_Boolean, A_symbol_111, A_symbol_113);
			return A_symbol_109;
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
			final Value A_symbol_114 = valueFactory.createEnumerationLiteralValue(PivotTables.EnumerationLiterals._CollectionKind__Set);
			final ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
			final ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final Value T_ClassClassifier_pivot__SetType_ = valueFactory.createTypeValue(PivotTables.Types._SetType);
			
			Value leftA_symbol_115;
			try {
				
				Value A_symbol_116 = IP_CollectionLiteralExp_kind.evaluate(evaluator, T_pivot__CollectionKind, self, P_CollectionLiteralExp_kind);
				
				
				DomainType static_A_symbol_117 = valueFactory.typeOf(A_symbol_116, A_symbol_114);
				LibraryBinaryOperation dynamic_A_symbol_117 = (LibraryBinaryOperation)static_A_symbol_117.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Value A_symbol_117 = dynamic_A_symbol_117.evaluate(evaluator, T_Boolean, A_symbol_116, A_symbol_114);
				leftA_symbol_115 = A_symbol_117;
			} catch (InvalidValueException e) {
				leftA_symbol_115 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_117 = leftA_symbol_115;
			Value rightA_symbol_115;
			try {
				
				Value A_symbol_118 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_119 = valueFactory.typeOf(A_symbol_118);
				LibraryBinaryOperation dynamic_A_symbol_119 = (LibraryBinaryOperation)static_A_symbol_119.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
				Value A_symbol_119 = dynamic_A_symbol_119.evaluate(evaluator, T_Boolean, A_symbol_118, T_ClassClassifier_pivot__SetType_);
				rightA_symbol_115 = A_symbol_119;
			} catch (InvalidValueException e) {
				rightA_symbol_115 = valueFactory.createInvalidValue(e);
			}
			Value A_symbol_119 = rightA_symbol_115;
			DomainType static_A_symbol_115 = valueFactory.typeOf(A_symbol_117);
			LibraryBinaryOperation dynamic_A_symbol_115 = (LibraryBinaryOperation)static_A_symbol_115.lookupImplementation(standardLibrary, O_Boolean_implies);
			Value A_symbol_115 = dynamic_A_symbol_115.evaluate(evaluator, T_Boolean, A_symbol_117, A_symbol_119);
			return A_symbol_115;
		}
	}


}

