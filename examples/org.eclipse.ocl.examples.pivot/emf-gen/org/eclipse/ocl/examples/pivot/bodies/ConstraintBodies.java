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
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueImpl;
import org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation;
import org.eclipse.ocl.examples.library.executor.ExecutorOperation;
import org.eclipse.ocl.examples.library.logical.BooleanOrOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.PivotPackage;

/**
 * ConstraintBodies provides the Java implementation bodies of OCL-defined Constraint operations and properties.
 */
@SuppressWarnings({"nls", "null", "unused"})
public class ConstraintBodies
{

	/** 
	 * Implementation of the Constraint 'UniqueName' invariant.
	 */
	public static class _invariant_UniqueName extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_UniqueName INSTANCE = new _invariant_UniqueName();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Collection_forAll = OCLstdlibTables.Operations._Collection__1_forAll;
		static final @NonNull PackageId Pk_pivot = IdManager.INSTANCE.getPackageId(PivotPackage.eINSTANCE);
		static final @NonNull TypeId T_pivot__Constraint = Pk_pivot.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "Constraint");
		static final @NonNull CollectionTypeId T_OrderedSet_pivot__Constraint_ = TypeId.ORDERED_SET.getSpecializedId(T_pivot__Constraint);
		static final @NonNull ExecutorOperation O_OrderedSet_excluding = OCLstdlibTables.Operations._OrderedSet__excluding;
		static final @NonNull TypeId T_pivot__NamedElement = Pk_pivot.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "NamedElement");
		static final @NonNull ExecutorOperation O_Boolean_or = OCLstdlibTables.Operations._Boolean__or;
		static final @NonNull ExecutorOperation O_String__lt__gt_ = OCLstdlibTables.Operations._String___lt__gt_;
		static final @NonNull PrimitiveTypeId T_String = TypeId.STRING;
		
	
		/*
		context.ownedRule->excluding(self)
	->forAll(name <> self.name or stereotype <> self.stereotype)
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
			assert self != null;
			final @NonNull Constraint unboxed_self = (Constraint)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			
			if (self == null) { throw new InvalidValueException("Null property source"); }
			org.eclipse.ocl.examples.pivot.NamedElement unboxed_A_symbol__1 = unboxed_self.getContext();
			final Object A_symbol__1 = valueOf(unboxed_A_symbol__1); // NamedElement
			
			
			if (A_symbol__1 == null) { throw new InvalidValueException("Null property source"); }
			org.eclipse.emf.common.util.EList<org.eclipse.ocl.examples.pivot.Constraint> unboxed_A_symbol__2 = unboxed_A_symbol__1.getOwnedRule();
			assert unboxed_A_symbol__2 != null;
			final @NonNull Value A_symbol__2 = createOrderedSetValue(T_OrderedSet_pivot__Constraint_, unboxed_A_symbol__2);
			
			
			
			Object A_symbol__3 = CollectionExcludingOperation.INSTANCE.evaluate(evaluator, T_OrderedSet_pivot__Constraint_, A_symbol__2, self);
			if (A_symbol__3 == null) throw new InvalidValueException("''Collection'' rather than ''OclVoid'' value required");
			if (A_symbol__3 instanceof InvalidValue) throw ((InvalidValue)A_symbol__3).getException();
			
			final @NonNull Iterator<?> A_symbol__iteratorVal = ((CollectionValue)A_symbol__3).iterator();
			Object V_1_ = null;	// iterator: 1_
			Object A_symbol_;
			while (true) {
				if (!A_symbol__iteratorVal.hasNext()) {
					A_symbol_ = TRUE_VALUE;
					break;
				}
				/*
					name <> self.name or stereotype <> self.stereotype
				*/
				V_1_ = A_symbol__iteratorVal.next();
				Object aA_symbol__5;
				try {
					
					if (V_1_ == null) { throw new InvalidValueException("Null property source"); }
					Constraint unboxed_V_1_ = (Constraint)V_1_;	// Constraint
					java.lang.String unboxed_A_symbol__6 = unboxed_V_1_.getName();
					final Object A_symbol__6 = unboxed_A_symbol__6; // String
					
					
					
					if (self == null) { throw new InvalidValueException("Null property source"); }
					java.lang.String unboxed_A_symbol__7 = unboxed_self.getName();
					final Object A_symbol__7 = unboxed_A_symbol__7; // String
					
					
					Object A_symbol__5 = OclAnyNotEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__6, A_symbol__7);
					aA_symbol__5 = A_symbol__5;
				} catch (Exception e) {
					aA_symbol__5 = new InvalidValueImpl(e);
				}
				Object aA_symbol__8;
				try {
					
					if (V_1_ == null) { throw new InvalidValueException("Null property source"); }
					Constraint unboxed_V_1_ = (Constraint)V_1_;	// Constraint
					java.lang.String unboxed_A_symbol__9 = unboxed_V_1_.getStereotype();
					final Object A_symbol__9 = unboxed_A_symbol__9; // String
					
					
					
					if (self == null) { throw new InvalidValueException("Null property source"); }
					java.lang.String unboxed_A_symbol__10 = unboxed_self.getStereotype();
					final Object A_symbol__10 = unboxed_A_symbol__10; // String
					
					
					Object A_symbol__8 = OclAnyNotEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__9, A_symbol__10);
					aA_symbol__8 = A_symbol__8;
				} catch (Exception e) {
					aA_symbol__8 = new InvalidValueImpl(e);
				}
				Object A_symbol__4 = BooleanOrOperation.INSTANCE.evaluate(evaluator, T_Boolean, aA_symbol__5, aA_symbol__8);
				
				Object A_symbol__bodyVal = A_symbol__4;
				if (A_symbol__bodyVal != TRUE_VALUE) {
					if (A_symbol__bodyVal == null) {
						throw new InvalidValueException(EvaluatorMessages.UndefinedBody, "forAll");
					}
					else {
						A_symbol_ = FALSE_VALUE;			// Abort after a fail
						break;
					}
				}
			}
			
			return A_symbol_;
		}
	}





}

