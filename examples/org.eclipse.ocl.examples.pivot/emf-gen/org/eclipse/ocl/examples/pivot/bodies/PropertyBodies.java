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
import org.eclipse.ocl.examples.domain.library.AbstractBinaryOperation;
import org.eclipse.ocl.examples.domain.library.AbstractUnaryOperation;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.InvalidValue;
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
import org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyOclAsTypeOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibPackage;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.PivotTables;
import org.eclipse.ocl.examples.pivot.Property;

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
		static final @NonNull PackageId Pk_pivot = IdManager.INSTANCE.getPackageId(PivotPackage.eINSTANCE);
		static final @NonNull TypeId T_pivot__ExpressionInOCL = Pk_pivot.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "ExpressionInOCL");
		static final @NonNull ExecutorOperation O_TypedMultiplicityElement_CompatibleBody = PivotTables.Operations._TypedMultiplicityElement__CompatibleBody;
		static final @NonNull TypeId T_pivot__ValueSpecification = Pk_pivot.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "ValueSpecification");
		static final @NonNull TypeId T_pivot__Constraint = Pk_pivot.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "Constraint");
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
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
			assert self != null;
			final @NonNull Property unboxed_self = (Property)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			final TypeValue Te_Metaclass_pivot__ExpressionInOCL_ = createTypeValue(evaluator.getIdResolver().getType(T_pivot__ExpressionInOCL, null));
			
			Object aA_symbol__1;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				java.lang.Boolean unboxed_A_symbol__1 = unboxed_self.isDerived();
				final Object A_symbol__1 = unboxed_A_symbol__1;
				
				
				aA_symbol__1 = A_symbol__1;
			} catch (Exception e) {
				aA_symbol__1 = new InvalidValueImpl(e);
			}
			Object aA_symbol__2;
			try {
				Object let_V_derivedConstraint;
				try {
					
					if (self == null) { throw new InvalidValueException("Null property source"); }
					org.eclipse.emf.common.util.EList<org.eclipse.ocl.examples.pivot.Constraint> unboxed_A_symbol__4 = unboxed_self.getOwnedRule();
					assert unboxed_A_symbol__4 != null;
					final @NonNull Value A_symbol__4 = createOrderedSetValue(T_OrderedSet_pivot__Constraint_, unboxed_A_symbol__4);
					
					
					if (A_symbol__4 == null) throw new InvalidValueException("''Collection'' rather than ''OclVoid'' value required");
					if (A_symbol__4 instanceof InvalidValue) throw ((InvalidValue)A_symbol__4).getException();
					
					final @NonNull Iterator<?> A_symbol__3_iteratorVal = ((CollectionValue)A_symbol__4).iterator();
					Object V_1_ = null;	// iterator: 1_
					Object A_symbol__3;
					while (true) {
						if (!A_symbol__3_iteratorVal.hasNext()) {
							A_symbol__3 = null;
							
							break;
						}
						/*
							stereotype = 'derivation'
						*/
						V_1_ = A_symbol__3_iteratorVal.next();
						
						if (V_1_ == null) { throw new InvalidValueException("Null property source"); }
						Constraint unboxed_V_1_ = (Constraint)V_1_;	// Constraint
						java.lang.String unboxed_A_symbol__5 = unboxed_V_1_.getStereotype();
						final Object A_symbol__5 = unboxed_A_symbol__5; // String
						
						
						Object A_symbol__6 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__5, S_derivati___);
						Object A_symbol__3_bodyVal = A_symbol__6;
						if (A_symbol__3_bodyVal != FALSE_VALUE) {
							if (A_symbol__3_bodyVal == null) {
								throw new InvalidValueException(EvaluatorMessages.UndefinedBody, "any");
							}
							else {			// Carry on till something found
								A_symbol__3 = V_1_;
								break;
							}
						}
					}
					
					let_V_derivedConstraint = A_symbol__3;
				}
				catch (Exception e) {
					let_V_derivedConstraint = new InvalidValueImpl(e);
				}
				final Object V_derivedConstraint = let_V_derivedConstraint;
				Object let_V_initialConstraint;
				try {
					
					if (self == null) { throw new InvalidValueException("Null property source"); }
					org.eclipse.emf.common.util.EList<org.eclipse.ocl.examples.pivot.Constraint> unboxed_A_symbol__8 = unboxed_self.getOwnedRule();
					assert unboxed_A_symbol__8 != null;
					final @NonNull Value A_symbol__8 = createOrderedSetValue(T_OrderedSet_pivot__Constraint_, unboxed_A_symbol__8);
					
					
					if (A_symbol__8 == null) throw new InvalidValueException("''Collection'' rather than ''OclVoid'' value required");
					if (A_symbol__8 instanceof InvalidValue) throw ((InvalidValue)A_symbol__8).getException();
					
					final @NonNull Iterator<?> A_symbol__7_iteratorVal = ((CollectionValue)A_symbol__8).iterator();
					Object V_1__1 = null;	// iterator: 1_
					Object A_symbol__7;
					while (true) {
						if (!A_symbol__7_iteratorVal.hasNext()) {
							A_symbol__7 = null;
							
							break;
						}
						/*
							stereotype = 'initial'
						*/
						V_1__1 = A_symbol__7_iteratorVal.next();
						
						if (V_1__1 == null) { throw new InvalidValueException("Null property source"); }
						Constraint unboxed_V_1__1 = (Constraint)V_1__1;	// Constraint
						java.lang.String unboxed_A_symbol__9 = unboxed_V_1__1.getStereotype();
						final Object A_symbol__9 = unboxed_A_symbol__9; // String
						
						
						Object A_symbol__10 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__9, S_initial);
						Object A_symbol__7_bodyVal = A_symbol__10;
						if (A_symbol__7_bodyVal != FALSE_VALUE) {
							if (A_symbol__7_bodyVal == null) {
								throw new InvalidValueException(EvaluatorMessages.UndefinedBody, "any");
							}
							else {			// Carry on till something found
								A_symbol__7 = V_1__1;
								break;
							}
						}
					}
					
					let_V_initialConstraint = A_symbol__7;
				}
				catch (Exception e) {
					let_V_initialConstraint = new InvalidValueImpl(e);
				}
				final Object V_initialConstraint = let_V_initialConstraint;
				Object let_V_derivedSpecification;
				try {
						
						Object A_symbol__11 = OclAnyNotEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, V_derivedConstraint, Null);
					Object A_symbol__12;
					if (A_symbol__11 == ValuesUtil.TRUE_VALUE) {
						
						if (V_derivedConstraint == null) { throw new InvalidValueException("Null property source"); }
						Constraint unboxed_V_derivedConstraint = (Constraint)V_derivedConstraint;	// Constraint
						org.eclipse.ocl.examples.pivot.ValueSpecification unboxed_A_symbol__13 = unboxed_V_derivedConstraint.getSpecification();
						final Object A_symbol__13 = valueOf(unboxed_A_symbol__13); // ValueSpecification
						
						
						A_symbol__12 = A_symbol__13;
					}
					else if (A_symbol__11 == ValuesUtil.FALSE_VALUE) {
						A_symbol__12 = Null;
					}
					else {
						throw new InvalidValueException("non-Boolean if condition");
					}
					let_V_derivedSpecification = A_symbol__12;
				}
				catch (Exception e) {
					let_V_derivedSpecification = new InvalidValueImpl(e);
				}
				final Object V_derivedSpecification = let_V_derivedSpecification;
				Object let_V_initialSpecification;
				try {
						
						Object A_symbol__14 = OclAnyNotEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, V_initialConstraint, Null);
					Object A_symbol__15;
					if (A_symbol__14 == ValuesUtil.TRUE_VALUE) {
						
						if (V_initialConstraint == null) { throw new InvalidValueException("Null property source"); }
						Constraint unboxed_V_initialConstraint = (Constraint)V_initialConstraint;	// Constraint
						org.eclipse.ocl.examples.pivot.ValueSpecification unboxed_A_symbol__16 = unboxed_V_initialConstraint.getSpecification();
						final Object A_symbol__16 = valueOf(unboxed_A_symbol__16); // ValueSpecification
						
						
						A_symbol__15 = A_symbol__16;
					}
					else if (A_symbol__14 == ValuesUtil.FALSE_VALUE) {
						A_symbol__15 = Null;
					}
					else {
						throw new InvalidValueException("non-Boolean if condition");
					}
					let_V_initialSpecification = A_symbol__15;
				}
				catch (Exception e) {
					let_V_initialSpecification = new InvalidValueImpl(e);
				}
				final Object V_initialSpecification = let_V_initialSpecification;
				Object let_V_initialiser;
				try {
						
						Object A_symbol__17 = OclAnyNotEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, V_derivedSpecification, Null);
					Object A_symbol__18;
					if (A_symbol__17 == ValuesUtil.TRUE_VALUE) {
						
						A_symbol__18 = V_derivedSpecification;
					}
					else if (A_symbol__17 == ValuesUtil.FALSE_VALUE) {
						
						A_symbol__18 = V_initialSpecification;
					}
					else {
						throw new InvalidValueException("non-Boolean if condition");
					}
					let_V_initialiser = A_symbol__18;
				}
				catch (Exception e) {
					let_V_initialiser = new InvalidValueImpl(e);
				}
				final Object V_initialiser = let_V_initialiser;
				Object aA_symbol__20;
				try {
					Object aA_symbol__21;
					try {
						
						Object A_symbol__21 = OclAnyNotEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, V_initialiser, Null);
						aA_symbol__21 = A_symbol__21;
					} catch (Exception e) {
						aA_symbol__21 = new InvalidValueImpl(e);
					}
					Object aA_symbol__22;
					try {
						
						Object A_symbol__22 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, T_Boolean, V_initialiser, Te_Metaclass_pivot__ExpressionInOCL_);
						aA_symbol__22 = A_symbol__22;
					} catch (Exception e) {
						aA_symbol__22 = new InvalidValueImpl(e);
					}
					Object A_symbol__20 = BooleanAndOperation.INSTANCE.evaluate(evaluator, T_Boolean, aA_symbol__21, aA_symbol__22);
					
					aA_symbol__20 = A_symbol__20;
				} catch (Exception e) {
					aA_symbol__20 = new InvalidValueImpl(e);
				}
				Object aA_symbol__23;
				try {
					
					
					Object A_symbol__23 = org.eclipse.ocl.examples.pivot.bodies.TypedMultiplicityElementBodies._CompatibleBody_body_.INSTANCE.evaluate(evaluator, T_Boolean, self, V_initialiser);
					aA_symbol__23 = A_symbol__23;
				} catch (Exception e) {
					aA_symbol__23 = new InvalidValueImpl(e);
				}
				Object A_symbol__19 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, aA_symbol__20, aA_symbol__23);
				
				final Object A_symbol__24 = A_symbol__19;
				final Object A_symbol__25 = A_symbol__24;
				final Object A_symbol__26 = A_symbol__25;
				final Object A_symbol__27 = A_symbol__26;
				final Object A_symbol__2 = A_symbol__27;
				aA_symbol__2 = A_symbol__2;
			} catch (Exception e) {
				aA_symbol__2 = new InvalidValueImpl(e);
			}
			Object A_symbol_ = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, aA_symbol__1, aA_symbol__2);
			
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
		static final @NonNull PackageId Pk_ocl = IdManager.INSTANCE.getPackageId(OCLstdlibPackage.eINSTANCE);
		static final @NonNull TypeId T_Type = Pk_ocl.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "Type");
		static final @NonNull ExecutorOperation O_Collection_includes = OCLstdlibTables.Operations._Collection__includes;
		static final @NonNull PackageId Pk_pivot = IdManager.INSTANCE.getPackageId(PivotPackage.eINSTANCE);
		static final @NonNull TypeId T_pivot__Property = Pk_pivot.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "Property");
		static final @NonNull CollectionTypeId T_OrderedSet_pivot__Property_ = TypeId.ORDERED_SET.getSpecializedId(T_pivot__Property);
		static final @NonNull ExecutorOperation O_OclAny_oclAsType = OCLstdlibTables.Operations._OclAny__oclAsType;
		static final @NonNull TypeId T_OclElement = Pk_ocl.getNestedTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, "OclElement");
		static final @NonNull ExecutorOperation O_OclElement_oclContainer = OCLstdlibTables.Operations._OclElement__oclContainer;
		
	
		/*
		let container : OclElement = oclContainer()
	in
	  container.oclIsKindOf(Type) and
	  container.oclAsType(Type)
	  .ownedAttribute->includes(self)
		*/
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self, final @Nullable Object p) throws Exception {
			assert self != null;
			final @NonNull Property unboxed_self = (Property)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			final TypeValue Te_Metaclass_Type_ = createTypeValue(evaluator.getIdResolver().getType(T_Type, null));
			
			Object let_V_container;
			try {
				
				Object A_symbol__28 = ClassifierOclContainerOperation.INSTANCE.evaluate(evaluator, T_OclElement, self);
				let_V_container = A_symbol__28;
			}
			catch (Exception e) {
				let_V_container = new InvalidValueImpl(e);
			}
			final Object V_container = let_V_container;
			Object aA_symbol__30;
			try {
				
				Object A_symbol__30 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, T_Boolean, V_container, Te_Metaclass_Type_);
				aA_symbol__30 = A_symbol__30;
			} catch (Exception e) {
				aA_symbol__30 = new InvalidValueImpl(e);
			}
			Object aA_symbol__31;
			try {
				
				Object A_symbol__32 = OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, T_Type, V_container, Te_Metaclass_Type_);
				if (A_symbol__32 == null) { throw new InvalidValueException("Null property source"); }
				assert A_symbol__32 != null;
				org.eclipse.ocl.examples.pivot.Type unboxed_A_symbol__32 = (org.eclipse.ocl.examples.pivot.Type)((TypeValue)A_symbol__32).getInstanceType();
				org.eclipse.emf.common.util.EList<org.eclipse.ocl.examples.pivot.Property> unboxed_A_symbol__33 = unboxed_A_symbol__32.getOwnedAttribute();
				assert unboxed_A_symbol__33 != null;
				final @NonNull Value A_symbol__33 = createOrderedSetValue(T_OrderedSet_pivot__Property_, unboxed_A_symbol__33);
				
				
				
				Object A_symbol__31 = CollectionIncludesOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__33, self);
				aA_symbol__31 = A_symbol__31;
			} catch (Exception e) {
				aA_symbol__31 = new InvalidValueImpl(e);
			}
			Object A_symbol__29 = BooleanAndOperation.INSTANCE.evaluate(evaluator, T_Boolean, aA_symbol__30, aA_symbol__31);
			
			final Object A_symbol__34 = A_symbol__29;
			return A_symbol__34;
		}
	}






















}

