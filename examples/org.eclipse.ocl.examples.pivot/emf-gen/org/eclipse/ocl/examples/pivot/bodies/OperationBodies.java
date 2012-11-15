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
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.PackageId;
import org.eclipse.ocl.examples.domain.ids.PrimitiveTypeId;
import org.eclipse.ocl.examples.domain.ids.TemplateParameterId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractUnaryOperation;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.InvalidValue;
import org.eclipse.ocl.examples.domain.values.TypeValue;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueImpl;
import org.eclipse.ocl.examples.library.executor.ExecutorOperation;
import org.eclipse.ocl.examples.library.logical.BooleanAndOperation;
import org.eclipse.ocl.examples.library.logical.BooleanImpliesOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.PivotPackage;
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
		static final @NonNull PackageId Pk_pivot = IdManager.INSTANCE.getPackageId(PivotPackage.eINSTANCE);
		static final @NonNull TypeId T_pivot__ExpressionInOCL = Pk_pivot.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "ExpressionInOCL");
		static final @NonNull ExecutorOperation O_TypedMultiplicityElement_CompatibleBody = PivotTables.Operations._TypedMultiplicityElement__CompatibleBody;
		static final @NonNull TypeId T_pivot__ValueSpecification = Pk_pivot.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "ValueSpecification");
		static final @NonNull TypeId T_pivot__Constraint = Pk_pivot.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "Constraint");
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
			final TypeValue Te_Metaclass_pivot__ExpressionInOCL_ = createTypeValue(evaluator.getIdResolver().getType(T_pivot__ExpressionInOCL, null));
			
			Object let_V_bodyConstraint;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				org.eclipse.emf.common.util.EList<org.eclipse.ocl.examples.pivot.Constraint> unboxed_A_symbol__1 = unboxed_self.getOwnedRule();
				assert unboxed_A_symbol__1 != null;
				final @NonNull Value A_symbol__1 = createOrderedSetValue(T_OrderedSet_pivot__Constraint_, unboxed_A_symbol__1);
				
				
				if (A_symbol__1 == null) throw new InvalidValueException("''Collection'' rather than ''OclVoid'' value required");
				if (A_symbol__1 instanceof InvalidValue) throw ((InvalidValue)A_symbol__1).getException();
				
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
					final Object A_symbol__2 = unboxed_A_symbol__2; // String
					
					
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
				
				let_V_bodyConstraint = A_symbol_;
			}
			catch (Exception e) {
				let_V_bodyConstraint = new InvalidValueImpl(e);
			}
			final Object V_bodyConstraint = let_V_bodyConstraint;
			Object aA_symbol__5;
			try {
				
				Object A_symbol__5 = OclAnyNotEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, V_bodyConstraint, Null);
				aA_symbol__5 = A_symbol__5;
			} catch (Exception e) {
				aA_symbol__5 = new InvalidValueImpl(e);
			}
			Object aA_symbol__6;
			try {
				Object let_V_bodySpecification;
				try {
					
					if (V_bodyConstraint == null) { throw new InvalidValueException("Null property source"); }
					Constraint unboxed_V_bodyConstraint = (Constraint)V_bodyConstraint;	// Constraint
					org.eclipse.ocl.examples.pivot.ValueSpecification unboxed_A_symbol__7 = unboxed_V_bodyConstraint.getSpecification();
					final Object A_symbol__7 = valueOf(unboxed_A_symbol__7); // ValueSpecification
					
					
					let_V_bodySpecification = A_symbol__7;
				}
				catch (Exception e) {
					let_V_bodySpecification = new InvalidValueImpl(e);
				}
				final Object V_bodySpecification = let_V_bodySpecification;
				Object aA_symbol__9;
				try {
					Object aA_symbol__10;
					try {
						
						Object A_symbol__10 = OclAnyNotEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, V_bodySpecification, Null);
						aA_symbol__10 = A_symbol__10;
					} catch (Exception e) {
						aA_symbol__10 = new InvalidValueImpl(e);
					}
					Object aA_symbol__11;
					try {
						
						Object A_symbol__11 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, T_Boolean, V_bodySpecification, Te_Metaclass_pivot__ExpressionInOCL_);
						aA_symbol__11 = A_symbol__11;
					} catch (Exception e) {
						aA_symbol__11 = new InvalidValueImpl(e);
					}
					Object A_symbol__9 = BooleanAndOperation.INSTANCE.evaluate(evaluator, T_Boolean, aA_symbol__10, aA_symbol__11);
					
					aA_symbol__9 = A_symbol__9;
				} catch (Exception e) {
					aA_symbol__9 = new InvalidValueImpl(e);
				}
				Object aA_symbol__12;
				try {
					
					
					Object A_symbol__12 = org.eclipse.ocl.examples.pivot.bodies.TypedMultiplicityElementBodies._CompatibleBody_body_.INSTANCE.evaluate(evaluator, T_Boolean, self, V_bodySpecification);
					aA_symbol__12 = A_symbol__12;
				} catch (Exception e) {
					aA_symbol__12 = new InvalidValueImpl(e);
				}
				Object A_symbol__8 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, aA_symbol__9, aA_symbol__12);
				
				final Object A_symbol__6 = A_symbol__8;
				aA_symbol__6 = A_symbol__6;
			} catch (Exception e) {
				aA_symbol__6 = new InvalidValueImpl(e);
			}
			Object A_symbol__4 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, aA_symbol__5, aA_symbol__6);
			
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

