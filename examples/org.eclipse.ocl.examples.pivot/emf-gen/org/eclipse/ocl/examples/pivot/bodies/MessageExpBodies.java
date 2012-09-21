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
import org.eclipse.ocl.examples.domain.elements.DomainCollectionType;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractUnaryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryBinaryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryProperty;
import org.eclipse.ocl.examples.domain.library.LibraryUnaryOperation;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.library.executor.ExecutorOperation;
import org.eclipse.ocl.examples.library.executor.ExecutorProperty;
import org.eclipse.ocl.examples.library.executor.ExecutorType;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.examples.pivot.PivotTables;

/**
 * MessageExpBodies provides the Java implementation bodies of OCL-defined MessageExp operations and properties.
 */
@SuppressWarnings("nls")
public class MessageExpBodies
{

	/** 
	 * Implementation of the MessageExp 'OneCallOrOneSend' invariant.
	 */
	public static class _invariant_OneCallOrOneSend extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_OneCallOrOneSend INSTANCE = new _invariant_OneCallOrOneSend();
	
		/*
		calledOperation->size() + sentSignal->size() = 1
		*/
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @NonNull Object self) throws InvalidValueException {
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			final @NonNull ExecutorOperation O_Real__eq_ = OCLstdlibTables.Operations._Real___eq_;
			final @NonNull ExecutorOperation O_Integer__add_ = OCLstdlibTables.Operations._Integer___add_;
			final @NonNull ExecutorOperation O_Collection_size = OCLstdlibTables.Operations._Collection__size;
			final @NonNull ExecutorType T_pivot__CallOperationAction = PivotTables.Types._CallOperationAction;
			final @NonNull DomainCollectionType T_Set_pivot__CallOperationAction_ = standardLibrary.getSetType(T_pivot__CallOperationAction, null, null);
			final @NonNull ExecutorOperation O_OclAny_oclAsSet = OCLstdlibTables.Operations._OclAny__oclAsSet;
			final @NonNull ExecutorProperty P_MessageExp_calledOperation = PivotTables.Properties._MessageExp__calledOperation;
			final @NonNull LibraryProperty IP_MessageExp_calledOperation = P_MessageExp_calledOperation.getImplementation();
			final @NonNull ExecutorType T_pivot__SendSignalAction = PivotTables.Types._SendSignalAction;
			final @NonNull DomainCollectionType T_Set_pivot__SendSignalAction_ = standardLibrary.getSetType(T_pivot__SendSignalAction, null, null);
			final @NonNull ExecutorProperty P_MessageExp_sentSignal = PivotTables.Properties._MessageExp__sentSignal;
			final @NonNull LibraryProperty IP_MessageExp_sentSignal = P_MessageExp_sentSignal.getImplementation();
			final @NonNull IntegerValue I_1 = integerValueOf(1);
			
			
			Object A_symbol_ = IP_MessageExp_calledOperation.evaluate(evaluator, T_pivot__CallOperationAction.getTypeId(), self, P_MessageExp_calledOperation);
			
			DomainType static_A_symbol__1 = evaluator.getStaticTypeOf(A_symbol_);
			LibraryUnaryOperation dynamic_A_symbol__1 = (LibraryUnaryOperation)static_A_symbol__1.lookupImplementation(standardLibrary, O_OclAny_oclAsSet);
			Object A_symbol__1 = dynamic_A_symbol__1.evaluate(evaluator, T_Set_pivot__CallOperationAction_.getTypeId(), A_symbol_);
			DomainType static_A_symbol__2 = evaluator.getStaticTypeOf(A_symbol__1);
			LibraryUnaryOperation dynamic_A_symbol__2 = (LibraryUnaryOperation)static_A_symbol__2.lookupImplementation(standardLibrary, O_Collection_size);
			Object A_symbol__2 = dynamic_A_symbol__2.evaluate(evaluator, TypeId.INTEGER, A_symbol__1);
			
			Object A_symbol__3 = IP_MessageExp_sentSignal.evaluate(evaluator, T_pivot__SendSignalAction.getTypeId(), self, P_MessageExp_sentSignal);
			
			DomainType static_A_symbol__4 = evaluator.getStaticTypeOf(A_symbol__3);
			LibraryUnaryOperation dynamic_A_symbol__4 = (LibraryUnaryOperation)static_A_symbol__4.lookupImplementation(standardLibrary, O_OclAny_oclAsSet);
			Object A_symbol__4 = dynamic_A_symbol__4.evaluate(evaluator, T_Set_pivot__SendSignalAction_.getTypeId(), A_symbol__3);
			DomainType static_A_symbol__5 = evaluator.getStaticTypeOf(A_symbol__4);
			LibraryUnaryOperation dynamic_A_symbol__5 = (LibraryUnaryOperation)static_A_symbol__5.lookupImplementation(standardLibrary, O_Collection_size);
			Object A_symbol__5 = dynamic_A_symbol__5.evaluate(evaluator, TypeId.INTEGER, A_symbol__4);
			DomainType static_A_symbol__6 = evaluator.getStaticTypeOf(A_symbol__2, A_symbol__5);
			LibraryBinaryOperation dynamic_A_symbol__6 = (LibraryBinaryOperation)static_A_symbol__6.lookupImplementation(standardLibrary, O_Integer__add_);
			Object A_symbol__6 = dynamic_A_symbol__6.evaluate(evaluator, TypeId.INTEGER, A_symbol__2, A_symbol__5);
			DomainType static_A_symbol__7 = evaluator.getStaticTypeOf(A_symbol__6, I_1);
			LibraryBinaryOperation dynamic_A_symbol__7 = (LibraryBinaryOperation)static_A_symbol__7.lookupImplementation(standardLibrary, O_Real__eq_);
			Object A_symbol__7 = dynamic_A_symbol__7.evaluate(evaluator, TypeId.BOOLEAN, A_symbol__6, I_1);
			return A_symbol__7;
		}
	}

	/** 
	 * Implementation of the MessageExp 'TargetIsNotACollection' invariant.
	 */
	public static class _invariant_TargetIsNotACollection extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_TargetIsNotACollection INSTANCE = new _invariant_TargetIsNotACollection();
	
		/*
		not target.type.oclIsKindOf(CollectionType)
		*/
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @NonNull Object self) throws InvalidValueException {
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			final @NonNull ExecutorOperation O_Boolean_not = OCLstdlibTables.Operations._Boolean__not;
			final @NonNull ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
			final @NonNull ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final @NonNull ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final @NonNull LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final @NonNull ExecutorType T_pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final @NonNull ExecutorProperty P_MessageExp_target = PivotTables.Properties._MessageExp__target;
			final @NonNull LibraryProperty IP_MessageExp_target = P_MessageExp_target.getImplementation();
			final @NonNull Object T_Metaclass_pivot__CollectionType_ = createTypeValue(PivotTables.Types._CollectionType);
			
			
			Object A_symbol__8 = IP_MessageExp_target.evaluate(evaluator, T_pivot__OCLExpression.getTypeId(), self, P_MessageExp_target);
			
			Object A_symbol__9 = IP_TypedElement_type.evaluate(evaluator, T_Type.getTypeId(), A_symbol__8, P_TypedElement_type);
			
			DomainType static_A_symbol__10 = evaluator.getStaticTypeOf(A_symbol__9);
			LibraryBinaryOperation dynamic_A_symbol__10 = (LibraryBinaryOperation)static_A_symbol__10.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
			Object A_symbol__10 = dynamic_A_symbol__10.evaluate(evaluator, TypeId.BOOLEAN, A_symbol__9, T_Metaclass_pivot__CollectionType_);
			DomainType static_A_symbol__11 = evaluator.getStaticTypeOf(A_symbol__10);
			LibraryUnaryOperation dynamic_A_symbol__11 = (LibraryUnaryOperation)static_A_symbol__11.lookupImplementation(standardLibrary, O_Boolean_not);
			Object A_symbol__11 = dynamic_A_symbol__11.evaluate(evaluator, TypeId.BOOLEAN, A_symbol__10);
			return A_symbol__11;
		}
	}




}

