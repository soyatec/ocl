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
import org.eclipse.ocl.examples.domain.library.AbstractBinaryOperation;
import org.eclipse.ocl.examples.domain.library.AbstractUnaryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryBinaryOperation;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.TypeValue;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueImpl;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.library.classifier.ClassifierOclContainerOperation;
import org.eclipse.ocl.examples.library.collection.CollectionIncludesOperation;
import org.eclipse.ocl.examples.library.executor.ExecutorOperation;
import org.eclipse.ocl.examples.library.logical.BooleanAndOperation;
import org.eclipse.ocl.examples.library.logical.BooleanImpliesOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyOclAsTypeOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.PivotTables;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;

/**
 * PropertyBodies provides the Java implementation bodies of OCL-defined Property operations and properties.
 */
@SuppressWarnings({"nls", "null", "unused"})
public class PropertyBodies
{

	/** 
	 * Implementation of the Property 'CompatibleInitialiser' invariant.
	 */
	public static class _invariant_CompatibleInitialiser extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_CompatibleInitialiser INSTANCE = new _invariant_CompatibleInitialiser();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
		static final @NonNull ExecutorOperation O_Boolean_and = OCLstdlibTables.Operations._Boolean__and;
		static final @NonNull ExecutorOperation O_OclAny__lt__gt_ = OCLstdlibTables.Operations._OclAny___lt__gt_;
		static final Object Null = null;
		static final @NonNull ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
		static final @NonNull Object T_Metaclass_pivot__ExpressionInOCL_ = createTypeValue(PivotTables.Types._ExpressionInOCL);
		static final @NonNull ExecutorOperation O_TypedMultiplicityElement_CompatibleBody = PivotTables.Operations._TypedMultiplicityElement__CompatibleBody;
		static final @NonNull TypeId T_pivot__ValueSpecification = PivotTables.Types._ValueSpecification.getTypeId();
		static final @NonNull TypeId T_pivot__Constraint = PivotTables.Types._Constraint.getTypeId();
		static final @NonNull ExecutorOperation O_Collection_any = OCLstdlibTables.Operations._Collection__any;
		static final @NonNull CollectionTypeId T_OrderedSet_pivot__Constraint_ = TypeId.ORDERED_SET.getSpecializedId(T_pivot__Constraint);
		static final @NonNull ExecutorOperation O_String__eq_ = OCLstdlibTables.Operations._String___eq_;
		static final @NonNull PrimitiveTypeId T_String = TypeId.STRING;
		static final @NonNull Object S_initial = "initial";
		static final @NonNull Object S_derivati___ = "derivation";
		
	
		/*
		isDerived implies
	let
	  derivedConstraint : Constraint = ownedRule->any(stereotype = 'derivation')
	in
	  let
	    initialConstraint : Constraint = ownedRule->any(stereotype = 'initial')
	  in
	    let
	      derivedSpecification : ValueSpecification = if derivedConstraint <> null
	      then derivedConstraint.specification
	      else null
	      endif
	    in
	      let
	        initialSpecification : ValueSpecification = if initialConstraint <> null
	        then initialConstraint.specification
	        else null
	        endif
	      in
	        let
	          initialiser : ValueSpecification = if derivedSpecification <> null
	          then derivedSpecification
	          else initialSpecification
	          endif
	        in initialiser <> null and
	          initialiser.oclIsKindOf(ExpressionInOCL) implies
	          CompatibleBody(initialiser)
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws InvalidValueException {
			assert self != null;
			final @NonNull Property unboxed_self = (Property)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			Object leftA_symbol_;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				java.lang.Boolean unboxed_A_symbol__1 = unboxed_self.isDerived();
				Object A_symbol__1 = unboxed_A_symbol__1;
				
				
				leftA_symbol_ = A_symbol__1;
			} catch (Exception e) {
				leftA_symbol_ = new InvalidValueImpl(e);
			}
			Object A_symbol__1 = leftA_symbol_;
			Object rightA_symbol_;
			try {
				Object V_derivedConstraint;
				try {
					
					if (self == null) { throw new InvalidValueException("Null property source"); }
					org.eclipse.emf.common.util.EList<org.eclipse.ocl.examples.pivot.Constraint> unboxed_A_symbol__3 = unboxed_self.getOwnedRule();
					assert unboxed_A_symbol__3 != null;
					final @NonNull Value A_symbol__3 = createOrderedSetValue(T_OrderedSet_pivot__Constraint_, unboxed_A_symbol__3);
					
					
					
					assert A_symbol__3 != null;
					final @NonNull Iterator<?> A_symbol__2_iteratorVal = ((CollectionValue)A_symbol__3).iterator();
					Object V_1_ = null;	// iterator: 1_
					Object A_symbol__2;
					while (true) {
						if (!A_symbol__2_iteratorVal.hasNext()) {
							A_symbol__2 = null;
							
							break;
						}
						/*
							stereotype = 'derivation'
						*/
						V_1_ = A_symbol__2_iteratorVal.next();
						
						if (V_1_ == null) { throw new InvalidValueException("Null property source"); }
						Constraint unboxed_V_1_ = (Constraint)V_1_;	// Constraint
						java.lang.String unboxed_A_symbol__4 = unboxed_V_1_.getStereotype();
						Object A_symbol__4 = unboxed_A_symbol__4; // String
						
						
						Object A_symbol__5 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__4, S_derivati___);
						Object A_symbol__2_bodyVal = A_symbol__5;
						if (A_symbol__2_bodyVal != FALSE_VALUE) {
							if (A_symbol__2_bodyVal == null) {
								throw new InvalidValueException(EvaluatorMessages.UndefinedBody, "any");
							}
							else {			// Carry on till something found
								A_symbol__2 = V_1_;
								break;
							}
						}
					}
					
					V_derivedConstraint = A_symbol__2;
				}
				catch (Exception e) {
					V_derivedConstraint = new InvalidValueImpl(e);
				}
				Object V_initialConstraint;
				try {
					
					if (self == null) { throw new InvalidValueException("Null property source"); }
					org.eclipse.emf.common.util.EList<org.eclipse.ocl.examples.pivot.Constraint> unboxed_A_symbol__7 = unboxed_self.getOwnedRule();
					assert unboxed_A_symbol__7 != null;
					final @NonNull Value A_symbol__7 = createOrderedSetValue(T_OrderedSet_pivot__Constraint_, unboxed_A_symbol__7);
					
					
					
					assert A_symbol__7 != null;
					final @NonNull Iterator<?> A_symbol__6_iteratorVal = ((CollectionValue)A_symbol__7).iterator();
					Object V_1_1 = null;	// iterator: 1_
					Object A_symbol__6;
					while (true) {
						if (!A_symbol__6_iteratorVal.hasNext()) {
							A_symbol__6 = null;
							
							break;
						}
						/*
							stereotype = 'initial'
						*/
						V_1_1 = A_symbol__6_iteratorVal.next();
						
						if (V_1_1 == null) { throw new InvalidValueException("Null property source"); }
						Constraint unboxed_V_1_1 = (Constraint)V_1_1;	// Constraint
						java.lang.String unboxed_A_symbol__8 = unboxed_V_1_1.getStereotype();
						Object A_symbol__8 = unboxed_A_symbol__8; // String
						
						
						Object A_symbol__9 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__8, S_initial);
						Object A_symbol__6_bodyVal = A_symbol__9;
						if (A_symbol__6_bodyVal != FALSE_VALUE) {
							if (A_symbol__6_bodyVal == null) {
								throw new InvalidValueException(EvaluatorMessages.UndefinedBody, "any");
							}
							else {			// Carry on till something found
								A_symbol__6 = V_1_1;
								break;
							}
						}
					}
					
					V_initialConstraint = A_symbol__6;
				}
				catch (Exception e) {
					V_initialConstraint = new InvalidValueImpl(e);
				}
				Object V_derivedSpecification;
				try {
						
						DomainType static_A_symbol__10 = evaluator.getStaticTypeOf(V_derivedConstraint, Null);
						LibraryBinaryOperation dynamic_A_symbol__10 = (LibraryBinaryOperation)static_A_symbol__10.lookupImplementation(standardLibrary, O_OclAny__lt__gt_);
						Object A_symbol__10 = dynamic_A_symbol__10.evaluate(evaluator, T_Boolean, V_derivedConstraint, Null);
					Object A_symbol__11;
					if (A_symbol__10 == ValuesUtil.TRUE_VALUE) {
						
						if (V_derivedConstraint == null) { throw new InvalidValueException("Null property source"); }
						Constraint unboxed_V_derivedConstraint = (Constraint)V_derivedConstraint;	// Constraint
						org.eclipse.ocl.examples.pivot.ValueSpecification unboxed_A_symbol__12 = unboxed_V_derivedConstraint.getSpecification();
						Object A_symbol__12 = valueOf(unboxed_A_symbol__12); // ValueSpecification
						
						
						A_symbol__11 = A_symbol__12;
					}
					else if (A_symbol__10 == ValuesUtil.FALSE_VALUE) {
						A_symbol__11 = Null;
					}
					else {
						throw new InvalidValueException("non-Boolean if condition");
					}
					V_derivedSpecification = A_symbol__11;
				}
				catch (Exception e) {
					V_derivedSpecification = new InvalidValueImpl(e);
				}
				Object V_initialSpecification;
				try {
						
						DomainType static_A_symbol__13 = evaluator.getStaticTypeOf(V_initialConstraint, Null);
						LibraryBinaryOperation dynamic_A_symbol__13 = (LibraryBinaryOperation)static_A_symbol__13.lookupImplementation(standardLibrary, O_OclAny__lt__gt_);
						Object A_symbol__13 = dynamic_A_symbol__13.evaluate(evaluator, T_Boolean, V_initialConstraint, Null);
					Object A_symbol__14;
					if (A_symbol__13 == ValuesUtil.TRUE_VALUE) {
						
						if (V_initialConstraint == null) { throw new InvalidValueException("Null property source"); }
						Constraint unboxed_V_initialConstraint = (Constraint)V_initialConstraint;	// Constraint
						org.eclipse.ocl.examples.pivot.ValueSpecification unboxed_A_symbol__15 = unboxed_V_initialConstraint.getSpecification();
						Object A_symbol__15 = valueOf(unboxed_A_symbol__15); // ValueSpecification
						
						
						A_symbol__14 = A_symbol__15;
					}
					else if (A_symbol__13 == ValuesUtil.FALSE_VALUE) {
						A_symbol__14 = Null;
					}
					else {
						throw new InvalidValueException("non-Boolean if condition");
					}
					V_initialSpecification = A_symbol__14;
				}
				catch (Exception e) {
					V_initialSpecification = new InvalidValueImpl(e);
				}
				Object V_initialiser;
				try {
						
						DomainType static_A_symbol__16 = evaluator.getStaticTypeOf(V_derivedSpecification, Null);
						LibraryBinaryOperation dynamic_A_symbol__16 = (LibraryBinaryOperation)static_A_symbol__16.lookupImplementation(standardLibrary, O_OclAny__lt__gt_);
						Object A_symbol__16 = dynamic_A_symbol__16.evaluate(evaluator, T_Boolean, V_derivedSpecification, Null);
					Object A_symbol__17;
					if (A_symbol__16 == ValuesUtil.TRUE_VALUE) {
						
						A_symbol__17 = V_derivedSpecification;
					}
					else if (A_symbol__16 == ValuesUtil.FALSE_VALUE) {
						
						A_symbol__17 = V_initialSpecification;
					}
					else {
						throw new InvalidValueException("non-Boolean if condition");
					}
					V_initialiser = A_symbol__17;
				}
				catch (Exception e) {
					V_initialiser = new InvalidValueImpl(e);
				}
				Object leftA_symbol__18;
				try {
					Object leftA_symbol__19;
					try {
						
						DomainType static_A_symbol__20 = evaluator.getStaticTypeOf(V_initialiser, Null);
						LibraryBinaryOperation dynamic_A_symbol__20 = (LibraryBinaryOperation)static_A_symbol__20.lookupImplementation(standardLibrary, O_OclAny__lt__gt_);
						Object A_symbol__20 = dynamic_A_symbol__20.evaluate(evaluator, T_Boolean, V_initialiser, Null);
						leftA_symbol__19 = A_symbol__20;
					} catch (Exception e) {
						leftA_symbol__19 = new InvalidValueImpl(e);
					}
					Object A_symbol__20 = leftA_symbol__19;
					Object rightA_symbol__19;
					try {
						
						Object A_symbol__21 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, T_Boolean, V_initialiser, T_Metaclass_pivot__ExpressionInOCL_);
						rightA_symbol__19 = A_symbol__21;
					} catch (Exception e) {
						rightA_symbol__19 = new InvalidValueImpl(e);
					}
					Object A_symbol__21 = rightA_symbol__19;
					Object A_symbol__19 = BooleanAndOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__20, A_symbol__21);
					leftA_symbol__18 = A_symbol__19;
				} catch (Exception e) {
					leftA_symbol__18 = new InvalidValueImpl(e);
				}
				Object A_symbol__19 = leftA_symbol__18;
				Object rightA_symbol__18;
				try {
					
					
					Object A_symbol__22 = org.eclipse.ocl.examples.pivot.bodies.TypedMultiplicityElementBodies._CompatibleBody_body_.INSTANCE.evaluate(evaluator, T_Boolean, self, V_initialiser);
					rightA_symbol__18 = A_symbol__22;
				} catch (Exception e) {
					rightA_symbol__18 = new InvalidValueImpl(e);
				}
				Object A_symbol__22 = rightA_symbol__18;
				Object A_symbol__18 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__19, A_symbol__22);
				final Object A_symbol__23 = A_symbol__18;
				final Object A_symbol__24 = A_symbol__23;
				final Object A_symbol__25 = A_symbol__24;
				final Object A_symbol__26 = A_symbol__25;
				final Object A_symbol__27 = A_symbol__26;
				rightA_symbol_ = A_symbol__27;
			} catch (Exception e) {
				rightA_symbol_ = new InvalidValueImpl(e);
			}
			Object A_symbol__27 = rightA_symbol_;
			Object A_symbol_ = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__1, A_symbol__27);
			return A_symbol_;
		}
	}

	/** 
	 * Implementation of the Property::isAttribute '' <body>.
	 */
	public static class _isAttribute_body_ extends AbstractBinaryOperation
	{
		public static @NonNull _isAttribute_body_ INSTANCE = new _isAttribute_body_();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Boolean_and = OCLstdlibTables.Operations._Boolean__and;
		static final @NonNull ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
		static final @NonNull Object T_Metaclass_Type_ = createTypeValue(OCLstdlibTables.Types._Type);
		static final @NonNull ExecutorOperation O_Collection_includes = OCLstdlibTables.Operations._Collection__includes;
		static final @NonNull TypeId T_pivot__Property = PivotTables.Types._Property.getTypeId();
		static final @NonNull CollectionTypeId T_OrderedSet_pivot__Property_ = TypeId.ORDERED_SET.getSpecializedId(T_pivot__Property);
		static final @NonNull TypeId T_Type = OCLstdlibTables.Types._Type.getTypeId();
		static final @NonNull ExecutorOperation O_OclAny_oclAsType = OCLstdlibTables.Operations._OclAny__oclAsType;
		static final @NonNull TypeId T_OclElement = OCLstdlibTables.Types._OclElement.getTypeId();
		static final @NonNull ExecutorOperation O_OclElement_oclContainer = OCLstdlibTables.Operations._OclElement__oclContainer;
		
	
		/*
		let container : OclElement = oclContainer()
	in
	  container.oclIsKindOf(Type) and
	  container.oclAsType(Type)
	  .ownedAttribute->includes(self)
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self, final @Nullable Object p) throws InvalidValueException {
			assert self != null;
			final @NonNull Property unboxed_self = (Property)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			Object V_container;
			try {
				
				Object A_symbol__28 = ClassifierOclContainerOperation.INSTANCE.evaluate(evaluator, T_OclElement, self);
				V_container = A_symbol__28;
			}
			catch (Exception e) {
				V_container = new InvalidValueImpl(e);
			}
			Object leftA_symbol__29;
			try {
				
				Object A_symbol__30 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, T_Boolean, V_container, T_Metaclass_Type_);
				leftA_symbol__29 = A_symbol__30;
			} catch (Exception e) {
				leftA_symbol__29 = new InvalidValueImpl(e);
			}
			Object A_symbol__30 = leftA_symbol__29;
			Object rightA_symbol__29;
			try {
				
				Object A_symbol__31 = OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, T_Type, V_container, T_Metaclass_Type_);
				if (A_symbol__31 == null) { throw new InvalidValueException("Null property source"); }
				assert A_symbol__31 != null;
				Type unboxed_A_symbol__31 = (Type)((TypeValue)A_symbol__31).getInstanceType();
				org.eclipse.emf.common.util.EList<org.eclipse.ocl.examples.pivot.Property> unboxed_A_symbol__32 = unboxed_A_symbol__31.getOwnedAttribute();
				assert unboxed_A_symbol__32 != null;
				final @NonNull Value A_symbol__32 = createOrderedSetValue(T_OrderedSet_pivot__Property_, unboxed_A_symbol__32);
				
				
				
				Object A_symbol__33 = CollectionIncludesOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__32, self);
				rightA_symbol__29 = A_symbol__33;
			} catch (Exception e) {
				rightA_symbol__29 = new InvalidValueImpl(e);
			}
			Object A_symbol__33 = rightA_symbol__29;
			Object A_symbol__29 = BooleanAndOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__30, A_symbol__33);
			final Object A_symbol__34 = A_symbol__29;
			return A_symbol__34;
		}
	}






















}

