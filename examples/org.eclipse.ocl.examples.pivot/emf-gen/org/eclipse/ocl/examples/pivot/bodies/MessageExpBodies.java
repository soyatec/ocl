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
import org.eclipse.ocl.examples.domain.library.AbstractUnaryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryBinaryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryProperty;
import org.eclipse.ocl.examples.domain.library.LibraryUnaryOperation;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.domain.values.ValueFactory;
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
		public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Value self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Real__eq_ = OCLstdlibTables.Operations._Real___eq_;
			final @NonNull ExecutorType T_Integer = OCLstdlibTables.Types._Integer;
			final @NonNull ExecutorOperation O_Integer__add_ = OCLstdlibTables.Operations._Integer___add_;
			final @NonNull ExecutorOperation O_Collection_size = OCLstdlibTables.Operations._Collection__size;
			final @NonNull ExecutorType T_pivot__CallOperationAction = PivotTables.Types._CallOperationAction;
			final @NonNull DomainCollectionType T_Set_pivot__CallOperationAction_ = standardLibrary.getSetType(T_pivot__CallOperationAction);
			final @NonNull ExecutorOperation O_OclAny_oclAsSet = OCLstdlibTables.Operations._OclAny__oclAsSet;
			final @NonNull ExecutorProperty P_MessageExp_calledOperation = PivotTables.Properties._MessageExp__calledOperation;
			final @NonNull LibraryProperty IP_MessageExp_calledOperation = P_MessageExp_calledOperation.getImplementation();
			final @NonNull ExecutorType T_pivot__SendSignalAction = PivotTables.Types._SendSignalAction;
			final @NonNull DomainCollectionType T_Set_pivot__SendSignalAction_ = standardLibrary.getSetType(T_pivot__SendSignalAction);
			final @NonNull ExecutorProperty P_MessageExp_sentSignal = PivotTables.Properties._MessageExp__sentSignal;
			final @NonNull LibraryProperty IP_MessageExp_sentSignal = P_MessageExp_sentSignal.getImplementation();
			final @NonNull IntegerValue I_1 = valueFactory.integerValueOf(1);
			
			
			Value A_symbol_304 = IP_MessageExp_calledOperation.evaluate(evaluator, T_pivot__CallOperationAction, self, P_MessageExp_calledOperation);
			
			DomainType static_A_symbol_305 = valueFactory.typeOf(A_symbol_304);
			LibraryUnaryOperation dynamic_A_symbol_305 = (LibraryUnaryOperation)static_A_symbol_305.lookupImplementation(standardLibrary, O_OclAny_oclAsSet);
			Value A_symbol_305 = dynamic_A_symbol_305.evaluate(evaluator, T_Set_pivot__CallOperationAction_, A_symbol_304);
			DomainType static_A_symbol_306 = valueFactory.typeOf(A_symbol_305);
			LibraryUnaryOperation dynamic_A_symbol_306 = (LibraryUnaryOperation)static_A_symbol_306.lookupImplementation(standardLibrary, O_Collection_size);
			Value A_symbol_306 = dynamic_A_symbol_306.evaluate(evaluator, T_Integer, A_symbol_305);
			
			Value A_symbol_307 = IP_MessageExp_sentSignal.evaluate(evaluator, T_pivot__SendSignalAction, self, P_MessageExp_sentSignal);
			
			DomainType static_A_symbol_308 = valueFactory.typeOf(A_symbol_307);
			LibraryUnaryOperation dynamic_A_symbol_308 = (LibraryUnaryOperation)static_A_symbol_308.lookupImplementation(standardLibrary, O_OclAny_oclAsSet);
			Value A_symbol_308 = dynamic_A_symbol_308.evaluate(evaluator, T_Set_pivot__SendSignalAction_, A_symbol_307);
			DomainType static_A_symbol_309 = valueFactory.typeOf(A_symbol_308);
			LibraryUnaryOperation dynamic_A_symbol_309 = (LibraryUnaryOperation)static_A_symbol_309.lookupImplementation(standardLibrary, O_Collection_size);
			Value A_symbol_309 = dynamic_A_symbol_309.evaluate(evaluator, T_Integer, A_symbol_308);
			DomainType static_A_symbol_310 = valueFactory.typeOf(A_symbol_306, A_symbol_309);
			LibraryBinaryOperation dynamic_A_symbol_310 = (LibraryBinaryOperation)static_A_symbol_310.lookupImplementation(standardLibrary, O_Integer__add_);
			Value A_symbol_310 = dynamic_A_symbol_310.evaluate(evaluator, T_Integer, A_symbol_306, A_symbol_309);
			DomainType static_A_symbol_311 = valueFactory.typeOf(A_symbol_310, I_1);
			LibraryBinaryOperation dynamic_A_symbol_311 = (LibraryBinaryOperation)static_A_symbol_311.lookupImplementation(standardLibrary, O_Real__eq_);
			Value A_symbol_311 = dynamic_A_symbol_311.evaluate(evaluator, T_Boolean, A_symbol_310, I_1);
			return A_symbol_311;
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
		public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Value self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Boolean_not = OCLstdlibTables.Operations._Boolean__not;
			final @NonNull ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
			final @NonNull ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final @NonNull ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final @NonNull LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final @NonNull ExecutorType T_pivot__OCLExpression = PivotTables.Types._OCLExpression;
			final @NonNull ExecutorProperty P_MessageExp_target = PivotTables.Properties._MessageExp__target;
			final @NonNull LibraryProperty IP_MessageExp_target = P_MessageExp_target.getImplementation();
			final @NonNull Value T_ClassClassifier_pivot__CollectionType_ = valueFactory.createTypeValue(PivotTables.Types._CollectionType);
			
			
			Value A_symbol_312 = IP_MessageExp_target.evaluate(evaluator, T_pivot__OCLExpression, self, P_MessageExp_target);
			
			Value A_symbol_313 = IP_TypedElement_type.evaluate(evaluator, T_Type, A_symbol_312, P_TypedElement_type);
			
			DomainType static_A_symbol_314 = valueFactory.typeOf(A_symbol_313);
			LibraryBinaryOperation dynamic_A_symbol_314 = (LibraryBinaryOperation)static_A_symbol_314.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
			Value A_symbol_314 = dynamic_A_symbol_314.evaluate(evaluator, T_Boolean, A_symbol_313, T_ClassClassifier_pivot__CollectionType_);
			DomainType static_A_symbol_315 = valueFactory.typeOf(A_symbol_314);
			LibraryUnaryOperation dynamic_A_symbol_315 = (LibraryUnaryOperation)static_A_symbol_315.lookupImplementation(standardLibrary, O_Boolean_not);
			Value A_symbol_315 = dynamic_A_symbol_315.evaluate(evaluator, T_Boolean, A_symbol_314);
			return A_symbol_315;
		}
	}




}

