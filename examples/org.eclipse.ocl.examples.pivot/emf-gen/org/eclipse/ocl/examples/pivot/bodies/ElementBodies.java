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
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.PrimitiveTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractTernaryOperation;
import org.eclipse.ocl.examples.domain.library.AbstractUnaryOperation;
import org.eclipse.ocl.examples.library.classifier.ClassifierOclContentsOperation;
import org.eclipse.ocl.examples.library.collection.CollectionIncludesOperation;
import org.eclipse.ocl.examples.library.executor.ExecutorOperation;
import org.eclipse.ocl.examples.library.logical.BooleanNotOperation;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.PivotTables;

/**
 * ElementBodies provides the Java implementation bodies of OCL-defined Element operations and properties.
 */
@SuppressWarnings({"nls", "unused"})
public class ElementBodies
{

	/** 
	 * Implementation of the Element 'not_own_self' invariant.
	 */
	public static class _invariant_not_own_self extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_not_own_self INSTANCE = new _invariant_not_own_self();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Boolean_not = OCLstdlibTables.Operations._Boolean__not;
		static final @NonNull ExecutorOperation O_Collection_includes = OCLstdlibTables.Operations._Collection__includes;
		static final @NonNull TypeId T_pivot__Element = PivotTables.Types._Element.getTypeId();
		static final @NonNull CollectionTypeId T_Set_pivot__Element_ = TypeId.SET.getSpecializedId(T_pivot__Element);
		static final @NonNull ExecutorOperation O_Element_allOwnedElements = PivotTables.Operations._Element__allOwnedElements;
		
	
		/*
		not allOwnedElements()->includes(self)
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
			assert self != null;
			final @NonNull Element unboxed_self = (Element)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			
			Object A_symbol_ = org.eclipse.ocl.examples.pivot.bodies.ElementBodies._allOwnedElements_body_.INSTANCE.evaluate(evaluator, T_Set_pivot__Element_, self);
			
			Object A_symbol__1 = CollectionIncludesOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol_, self);
			Object A_symbol__2 = BooleanNotOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__1);
			return A_symbol__2;
		}
	}

	/** 
	 * Implementation of the Element::allOwnedElements '' <body>.
	 */
	public static class _allOwnedElements_body_ extends AbstractUnaryOperation
	{
		public static @NonNull _allOwnedElements_body_ INSTANCE = new _allOwnedElements_body_();
		static final @NonNull TypeId T_OclElement = OCLstdlibTables.Types._OclElement.getTypeId();
		static final @NonNull CollectionTypeId T_Set_OclElement_ = TypeId.SET.getSpecializedId(T_OclElement);
		static final @NonNull ExecutorOperation O_OclElement_oclContents = OCLstdlibTables.Operations._OclElement__oclContents;
		
	
		/*
		oclContents()
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
			assert self != null;
			final @NonNull Element unboxed_self = (Element)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			
			Object A_symbol__3 = ClassifierOclContentsOperation.INSTANCE.evaluate(evaluator, T_Set_OclElement_, self);
			return A_symbol__3;
		}
	}

	/** 
	 * Implementation of the Element::getValue '' <body>.
	 */
	public static class _getValue_body_ extends AbstractTernaryOperation
	{
		public static @NonNull _getValue_body_ INSTANCE = new _getValue_body_();
		static final Object Null = null;
		
	
		/*
		null
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self, final @Nullable Object stereotype, final @Nullable Object propertyName) throws Exception {
			assert self != null;
			final @NonNull Element unboxed_self = (Element)self;
			
			
			return Null;
		}
	}





}

