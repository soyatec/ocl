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
import java.util.Iterator;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.PrimitiveTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractUnaryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryBinaryOperation;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueImpl;
import org.eclipse.ocl.examples.library.executor.ExecutorOperation;
import org.eclipse.ocl.examples.library.logical.BooleanAndOperation;
import org.eclipse.ocl.examples.library.logical.BooleanImpliesOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.PivotTables;

/**
 * OperationBodies provides the Java implementation bodies of OCL-defined Operation operations and properties.
 */
@SuppressWarnings({"nls", "null", "unused"})
public class OperationBodies
{

	/** 
	 * Implementation of the Operation 'CompatibleReturn' invariant.
	 */
	public static class _invariant_CompatibleReturn extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_CompatibleReturn INSTANCE = new _invariant_CompatibleReturn();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
		static final @NonNull ExecutorOperation O_OclAny__lt__gt_ = OCLstdlibTables.Operations._OclAny___lt__gt_;
		static final Object Null = null;
		static final @NonNull ExecutorOperation O_Boolean_and = OCLstdlibTables.Operations._Boolean__and;
		static final @NonNull ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
		static final @NonNull Object T_Metaclass_pivot__ExpressionInOCL_ = createTypeValue(PivotTables.Types._ExpressionInOCL);
		static final @NonNull ExecutorOperation O_TypedMultiplicityElement_CompatibleBody = PivotTables.Operations._TypedMultiplicityElement__CompatibleBody;
		static final @NonNull TypeId T_pivot__ValueSpecification = PivotTables.Types._ValueSpecification.getTypeId();
		static final @NonNull TypeId T_pivot__Constraint = PivotTables.Types._Constraint.getTypeId();
		static final @NonNull ExecutorOperation O_Collection_any = OCLstdlibTables.Operations._Collection__any;
		static final @NonNull CollectionTypeId T_OrderedSet_pivot__Constraint_ = TypeId.ORDERED_SET.getSpecializedId(T_pivot__Constraint);
		static final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
		static final @NonNull PrimitiveTypeId T_String = TypeId.STRING;
		static final @NonNull Object S_body = "body";
		
	
		/*
		let
	  bodyConstraint : Constraint = ownedRule->any(stereotype = 'body')
	in bodyConstraint <> null implies
	  let bodySpecification : ValueSpecification = bodyConstraint.specification
	  in bodySpecification <> null and
	    bodySpecification.oclIsKindOf(ExpressionInOCL) implies
	    CompatibleBody(bodySpecification)
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
			assert self != null;
			final @NonNull Operation unboxed_self = (Operation)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			Object V_bodyConstraint;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				org.eclipse.emf.common.util.EList<org.eclipse.ocl.examples.pivot.Constraint> unboxed_A_symbol__1 = unboxed_self.getOwnedRule();
				assert unboxed_A_symbol__1 != null;
				final @NonNull Value A_symbol__1 = createOrderedSetValue(T_OrderedSet_pivot__Constraint_, unboxed_A_symbol__1);
				
				
				
				assert A_symbol__1 != null;
				final @NonNull Iterator<?> A_symbol__iteratorVal = ((CollectionValue)A_symbol__1).iterator();
				Object V_1_ = null;	// iterator: 1_
				Object A_symbol_;
				while (true) {
					if (!A_symbol__iteratorVal.hasNext()) {
						A_symbol_ = null;
						
						break;
					}
					/*
						stereotype = 'body'
					*/
					V_1_ = A_symbol__iteratorVal.next();
					
					if (V_1_ == null) { throw new InvalidValueException("Null property source"); }
					Constraint unboxed_V_1_ = (Constraint)V_1_;	// Constraint
					java.lang.String unboxed_A_symbol__2 = unboxed_V_1_.getStereotype();
					Object A_symbol__2 = unboxed_A_symbol__2; // String
					
					
					Object A_symbol__3 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__2, S_body);
					Object A_symbol__bodyVal = A_symbol__3;
					if (A_symbol__bodyVal != FALSE_VALUE) {
						if (A_symbol__bodyVal == null) {
							throw new InvalidValueException(EvaluatorMessages.UndefinedBody, "any");
						}
						else {			// Carry on till something found
							A_symbol_ = V_1_;
							break;
						}
					}
				}
				
				V_bodyConstraint = A_symbol_;
			}
			catch (Exception e) {
				V_bodyConstraint = new InvalidValueImpl(e);
			}
			Object leftA_symbol__4;
			try {
				
				DomainType static_A_symbol__5 = evaluator.getStaticTypeOf(V_bodyConstraint, Null);
				LibraryBinaryOperation dynamic_A_symbol__5 = (LibraryBinaryOperation)static_A_symbol__5.lookupImplementation(standardLibrary, O_OclAny__lt__gt_);
				Object A_symbol__5 = dynamic_A_symbol__5.evaluate(evaluator, T_Boolean, V_bodyConstraint, Null);
				leftA_symbol__4 = A_symbol__5;
			} catch (Exception e) {
				leftA_symbol__4 = new InvalidValueImpl(e);
			}
			Object A_symbol__5 = leftA_symbol__4;
			Object rightA_symbol__4;
			try {
				Object V_bodySpecification;
				try {
					
					if (V_bodyConstraint == null) { throw new InvalidValueException("Null property source"); }
					Constraint unboxed_V_bodyConstraint = (Constraint)V_bodyConstraint;	// Constraint
					org.eclipse.ocl.examples.pivot.ValueSpecification unboxed_A_symbol__6 = unboxed_V_bodyConstraint.getSpecification();
					Object A_symbol__6 = valueOf(unboxed_A_symbol__6); // ValueSpecification
					
					
					V_bodySpecification = A_symbol__6;
				}
				catch (Exception e) {
					V_bodySpecification = new InvalidValueImpl(e);
				}
				Object leftA_symbol__7;
				try {
					Object leftA_symbol__8;
					try {
						
						DomainType static_A_symbol__9 = evaluator.getStaticTypeOf(V_bodySpecification, Null);
						LibraryBinaryOperation dynamic_A_symbol__9 = (LibraryBinaryOperation)static_A_symbol__9.lookupImplementation(standardLibrary, O_OclAny__lt__gt_);
						Object A_symbol__9 = dynamic_A_symbol__9.evaluate(evaluator, T_Boolean, V_bodySpecification, Null);
						leftA_symbol__8 = A_symbol__9;
					} catch (Exception e) {
						leftA_symbol__8 = new InvalidValueImpl(e);
					}
					Object A_symbol__9 = leftA_symbol__8;
					Object rightA_symbol__8;
					try {
						
						Object A_symbol__10 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, T_Boolean, V_bodySpecification, T_Metaclass_pivot__ExpressionInOCL_);
						rightA_symbol__8 = A_symbol__10;
					} catch (Exception e) {
						rightA_symbol__8 = new InvalidValueImpl(e);
					}
					Object A_symbol__10 = rightA_symbol__8;
					Object A_symbol__8 = BooleanAndOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__9, A_symbol__10);
					leftA_symbol__7 = A_symbol__8;
				} catch (Exception e) {
					leftA_symbol__7 = new InvalidValueImpl(e);
				}
				Object A_symbol__8 = leftA_symbol__7;
				Object rightA_symbol__7;
				try {
					
					
					Object A_symbol__11 = org.eclipse.ocl.examples.pivot.bodies.TypedMultiplicityElementBodies._CompatibleBody_body_.INSTANCE.evaluate(evaluator, T_Boolean, self, V_bodySpecification);
					rightA_symbol__7 = A_symbol__11;
				} catch (Exception e) {
					rightA_symbol__7 = new InvalidValueImpl(e);
				}
				Object A_symbol__11 = rightA_symbol__7;
				Object A_symbol__7 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__8, A_symbol__11);
				final Object A_symbol__12 = A_symbol__7;
				rightA_symbol__4 = A_symbol__12;
			} catch (Exception e) {
				rightA_symbol__4 = new InvalidValueImpl(e);
			}
			Object A_symbol__12 = rightA_symbol__4;
			Object A_symbol__4 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__5, A_symbol__12);
			final Object A_symbol__13 = A_symbol__4;
			return A_symbol__13;
		}
	}

	/** 
	 * Implementation of the Operation 'LoadableImplementation' invariant.
	 */
	public static class _invariant_LoadableImplementation extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_LoadableImplementation INSTANCE = new _invariant_LoadableImplementation();
		static final @NonNull Object True = true;
		
	
		/*
		true
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
			assert self != null;
			final @NonNull Operation unboxed_self = (Operation)self;
			
			
			return True;
		}
	}










}

