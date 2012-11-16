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
import org.eclipse.ocl.examples.library.collection.CollectionIsEmptyOperation;
import org.eclipse.ocl.examples.library.executor.ExecutorOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyOclAsSetOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibPackage;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.examples.pivot.LoopExp;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.PivotTables;
import org.eclipse.ocl.examples.pivot.Variable;

/**
 * LoopExpBodies provides the Java implementation bodies of OCL-defined LoopExp operations and properties.
 */
@SuppressWarnings({"nls", "null", "unused"})
public class LoopExpBodies
{

	/** 
	 * Implementation of the LoopExp 'NoInitializers' invariant.
	 */
	public static class _invariant_NoInitializers extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_NoInitializers INSTANCE = new _invariant_NoInitializers();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Collection_forAll = OCLstdlibTables.Operations._Collection__1_forAll;
		static final @NonNull PackageId Pk_pivot = IdManager.INSTANCE.getPackageId(PivotPackage.eINSTANCE);
		static final @NonNull TypeId T_pivot__Variable = Pk_pivot.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "Variable");
		static final @NonNull CollectionTypeId T_OrderedSet_pivot__Variable_ = TypeId.ORDERED_SET.getSpecializedId(T_pivot__Variable);
		static final @NonNull ExecutorOperation O_Collection_isEmpty = OCLstdlibTables.Operations._Collection__isEmpty;
		static final @NonNull TypeId T_pivot__OCLExpression = Pk_pivot.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "OCLExpression");
		static final @NonNull CollectionTypeId T_Set_pivot__OCLExpression_ = TypeId.SET.getSpecializedId(T_pivot__OCLExpression);
		static final @NonNull ExecutorOperation O_OclAny_oclAsSet = OCLstdlibTables.Operations._OclAny__oclAsSet;
		
	
		/*
		self.iterator->forAll(initExpression->isEmpty())
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
			assert self != null;
			final @NonNull LoopExp unboxed_self = (LoopExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			
			if (self == null) { throw new InvalidValueException("Null property source"); }
			org.eclipse.emf.common.util.EList<org.eclipse.ocl.examples.pivot.Variable> unboxed_A_symbol__1 = unboxed_self.getIterator();
			assert unboxed_A_symbol__1 != null;
			final @NonNull Value A_symbol__1 = createOrderedSetValue(T_OrderedSet_pivot__Variable_, unboxed_A_symbol__1);
			
			
			if (A_symbol__1 == null) throw new InvalidValueException("''Collection'' rather than ''OclVoid'' value required");
			if (A_symbol__1 instanceof InvalidValue) throw ((InvalidValue)A_symbol__1).getException();
			
			final @NonNull Iterator<?> A_symbol__iteratorVal = ((CollectionValue)A_symbol__1).iterator();
			Object V_1_ = null;	// iterator: 1_
			Object A_symbol_;
			while (true) {
				if (!A_symbol__iteratorVal.hasNext()) {
					A_symbol_ = TRUE_VALUE;
					break;
				}
				/*
					initExpression->isEmpty()
				*/
				V_1_ = A_symbol__iteratorVal.next();
				Object aA_symbol__3;
				try {
					
					if (V_1_ == null) { throw new InvalidValueException("Null property source"); }
					Variable unboxed_V_1_ = (Variable)V_1_;	// Variable
					org.eclipse.ocl.examples.pivot.OCLExpression unboxed_A_symbol__3 = unboxed_V_1_.getInitExpression();
					final Object A_symbol__3 = valueOf(unboxed_A_symbol__3); // OCLExpression
					
					
					aA_symbol__3 = A_symbol__3;
				} catch (Exception e) {
					aA_symbol__3 = new InvalidValueImpl(e);
				}
				Object A_symbol__2 = OclAnyOclAsSetOperation.INSTANCE.evaluate(evaluator, T_Set_pivot__OCLExpression_, aA_symbol__3);
				
				Object A_symbol__4 = CollectionIsEmptyOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__2);
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

	/** 
	 * Implementation of the LoopExp 'SourceIsCollection' invariant.
	 */
	public static class _invariant_SourceIsCollection extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_SourceIsCollection INSTANCE = new _invariant_SourceIsCollection();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
		static final @NonNull PackageId Pk_ocl = IdManager.INSTANCE.getPackageId(OCLstdlibPackage.eINSTANCE);
		static final @NonNull TypeId T_Type = Pk_ocl.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "Type");
		static final @NonNull PackageId Pk_pivot = IdManager.INSTANCE.getPackageId(PivotPackage.eINSTANCE);
		static final @NonNull TypeId T_pivot__OCLExpression = Pk_pivot.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "OCLExpression");
		static final @NonNull TypeId T_pivot__CollectionType = Pk_pivot.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "CollectionType");
		
	
		/*
		source.type.oclIsKindOf(CollectionType)
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
			assert self != null;
			final @NonNull LoopExp unboxed_self = (LoopExp)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			final TypeValue Te_Metaclass_pivot__CollectionType_ = createTypeValue(evaluator.getIdResolver().getType(T_pivot__CollectionType, null));
			
			
			if (self == null) { throw new InvalidValueException("Null property source"); }
			org.eclipse.ocl.examples.pivot.OCLExpression unboxed_A_symbol__5 = unboxed_self.getSource();
			final Object A_symbol__5 = valueOf(unboxed_A_symbol__5); // OCLExpression
			
			
			if (A_symbol__5 == null) { throw new InvalidValueException("Null property source"); }
			org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__6 = unboxed_A_symbol__5.getType();
			PivotTables.PACKAGE.getName();
			final Object A_symbol__6 = createTypeValue(unboxed_A_symbol__6);
			
			
			Object A_symbol__7 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__6, Te_Metaclass_pivot__CollectionType_);
			return A_symbol__7;
		}
	}



}

