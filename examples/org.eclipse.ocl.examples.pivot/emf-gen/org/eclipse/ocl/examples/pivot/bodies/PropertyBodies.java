/**
 *<copyright>
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
 * using: org.eclipse.ocl.examples.codegen.expression.OCLinEcore2JavaClass
 *
 * Do not edit it.
 */
package org.eclipse.ocl.examples.pivot.bodies;

import java.lang.Boolean;
import java.lang.Object;
import java.lang.String;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.ClassId;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.PackageId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractBinaryOperation;
import org.eclipse.ocl.examples.domain.library.AbstractUnaryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryIteration;
import org.eclipse.ocl.examples.domain.types.IdResolver;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.library.classifier.ClassifierOclContainerOperation;
import org.eclipse.ocl.examples.library.collection.CollectionIncludesOperation;
import org.eclipse.ocl.examples.library.executor.ExecutorSingleIterationManager;
import org.eclipse.ocl.examples.library.logical.BooleanAndOperation;
import org.eclipse.ocl.examples.library.logical.BooleanImpliesOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyOclAsTypeOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.ValueSpecification;
import org.eclipse.ocl.examples.pivot.bodies.TypedMultiplicityElementBodies;

@SuppressWarnings("nls")
public class PropertyBodies extends ValuesUtil
{
    private static final @NonNull /*@NonInvalid*/ String STR_derivation = "derivation";
    private static final @NonNull /*@NonInvalid*/ String STR_initial = "initial";
    private static final @NonNull /*@NonInvalid*/ PackageId PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot = IdManager.INSTANCE.getNsURIPackageId("http://www.eclipse.org/ocl/3.1.0/Pivot", org.eclipse.ocl.examples.pivot.PivotPackage.eINSTANCE);
    private static final @NonNull /*@NonInvalid*/ ClassId CLSSid_ExpressionInOCL = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("ExpressionInOCL");
    private static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Constraint = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("Constraint");
    private static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Constraint = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Constraint);
    private static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Type = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("Type");
    private static final @NonNull /*@NonInvalid*/ ClassId CLSSid_OclElement = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("OclElement");
    private static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Property = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("Property");
    private static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Property = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Property);

    /**
     * Implementation of the Property 'CompatibleInitialiser' <invariant>
     * 
     * isDerived implies
     * let
     *   derivedConstraint : Constraint = ownedRule->any(stereotype = 'derivation')
     * in
     *   let
     *     initialConstraint : Constraint = ownedRule->any(stereotype = 'initial')
     *   in
     *     let
     *       derivedSpecification : ValueSpecification = if derivedConstraint <> null
     *       then derivedConstraint.specification
     *       else null
     *       endif
     *     in
     *       let
     *         initialSpecification : ValueSpecification = if initialConstraint <> null
     *         then initialConstraint.specification
     *         else null
     *         endif
     *       in
     *         let
     *           initialiser : ValueSpecification = if derivedSpecification <> null
     *           then derivedSpecification
     *           else initialSpecification
     *           endif
     *         in initialiser <> null and
     *           initialiser.oclIsKindOf(ExpressionInOCL) implies
     *           CompatibleBody(initialiser)
     */
    public static class _invariant_CompatibleInitialiser extends AbstractUnaryOperation
    {
        public static final @NonNull _invariant_CompatibleInitialiser INSTANCE = new _invariant_CompatibleInitialiser();

        public @NonNull /*@Thrown*/ Boolean evaluate(final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator, final @NonNull /*@NonInvalid*/ TypeId returnTypeId, final @Nullable /*@Caught*/ Object self) throws Exception {
            final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
            final @NonNull /*@NonInvalid*/ DomainType TYP_pivot_c_c_ExpressionInOCL = idResolver.getType(CLSSid_ExpressionInOCL, null);
            @Nullable /*@Caught*/ Object isDerived;
            try {
                if (self == null) throw new InvalidValueException("Null source for property: isDerived");
                if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                isDerived = ((Property)self).isDerived();
            } catch (Exception e) { isDerived = createInvalidValue(e); }
            if (self == null) throw new InvalidValueException("Null source for property: ownedRule");
            if (self instanceof InvalidValueException) throw (InvalidValueException)self;
            final @SuppressWarnings("null")@NonNull /*@Thrown*/ EList<?> ownedRule = ((NamedElement)self).getOwnedRule();
            if (self == null) throw new InvalidValueException("Null source for property: ownedRule");
            if (self instanceof InvalidValueException) throw (InvalidValueException)self;
            final @SuppressWarnings("null")@NonNull /*@Thrown*/ EList<?> ownedRule_0 = ((NamedElement)self).getOwnedRule();
            final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
            @Nullable /*@Caught*/ Object any;
            try {
                final @NonNull /*@Thrown*/ CollectionValue BOXED_ownedRule = createCollectionValue(ORD_CLSSid_Constraint, ownedRule);
                /**
                 * Implementation of the iterator body.
                 */
                final @NonNull AbstractBinaryOperation BODY_any = new AbstractBinaryOperation()
                {
                    /**
                     * stereotype = 'derivation'
                     */
                    public @Nullable Object evaluate(final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator, final @NonNull TypeId returnTypeId, @Nullable final Object sourceValue, final @Nullable /*@Thrown*/ Object _49__) throws Exception {
                        if (_49__ == null) throw new InvalidValueException("Null source for property: stereotype");
                        final @Nullable /*@Thrown*/ String stereotype = ((Constraint)_49__).getStereotype();
                        final @NonNull /*@Thrown*/ Boolean _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, stereotype, STR_derivation);
                        return _q;
                    }
                };
                DomainType TYPE_any = evaluator.getStaticTypeOf(BOXED_ownedRule);
                LibraryIteration IMPL_any = (LibraryIteration)TYPE_any.lookupImplementation(standardLibrary, OCLstdlibTables.Operations._Collection__any);
                Object ACC_any = IMPL_any.createAccumulatorValue(evaluator, CLSSid_Constraint, TypeId.BOOLEAN);
                ExecutorSingleIterationManager MGR_any = new ExecutorSingleIterationManager(evaluator, CLSSid_Constraint, BODY_any, BOXED_ownedRule, ACC_any);
                any = IMPL_any.evaluateIteration(MGR_any);
            } catch (Exception e) { any = createInvalidValue(e); }
            @Nullable /*@Caught*/ Object any_0;
            try {
                final @NonNull /*@Thrown*/ CollectionValue BOXED_ownedRule_0 = createCollectionValue(ORD_CLSSid_Constraint, ownedRule_0);
                /**
                 * Implementation of the iterator body.
                 */
                final @NonNull AbstractBinaryOperation BODY_any_0 = new AbstractBinaryOperation()
                {
                    /**
                     * stereotype = 'initial'
                     */
                    public @Nullable Object evaluate(final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator, final @NonNull TypeId returnTypeId, @Nullable final Object sourceValue, final @Nullable /*@Thrown*/ Object _49___0) throws Exception {
                        if (_49___0 == null) throw new InvalidValueException("Null source for property: stereotype");
                        final @Nullable /*@Thrown*/ String stereotype_0 = ((Constraint)_49___0).getStereotype();
                        final @NonNull /*@Thrown*/ Boolean _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, stereotype_0, STR_initial);
                        return _q_0;
                    }
                };
                DomainType TYPE_any_0 = evaluator.getStaticTypeOf(BOXED_ownedRule_0);
                LibraryIteration IMPL_any_0 = (LibraryIteration)TYPE_any_0.lookupImplementation(standardLibrary, OCLstdlibTables.Operations._Collection__any);
                Object ACC_any_0 = IMPL_any_0.createAccumulatorValue(evaluator, CLSSid_Constraint, TypeId.BOOLEAN);
                ExecutorSingleIterationManager MGR_any_0 = new ExecutorSingleIterationManager(evaluator, CLSSid_Constraint, BODY_any_0, BOXED_ownedRule_0, ACC_any_0);
                any_0 = IMPL_any_0.evaluateIteration(MGR_any_0);
            } catch (Exception e) { any_0 = createInvalidValue(e); }
            if (any instanceof InvalidValueException) throw (InvalidValueException)any;
            final @NonNull /*@Thrown*/ Boolean _l_g_1 = OclAnyNotEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, any, null);
            @Nullable /*@Caught*/ Object symbol_1;
            if (_l_g_1 == TRUE_VALUE) {
                if (any == null) throw new InvalidValueException("Null source for property: derivedConstraint.specification");
                if (any instanceof InvalidValueException) throw (InvalidValueException)any;
                final @Nullable /*@Thrown*/ ValueSpecification specification = ((Constraint)any).getSpecification();
                symbol_1 = specification;
            }
            else if (_l_g_1 == FALSE_VALUE) {
                symbol_1 = null;
            }
            else {
                throw INVALID_VALUE;
            }
            if (symbol_1 instanceof InvalidValueException) throw (InvalidValueException)symbol_1;
            final @NonNull /*@Thrown*/ Boolean _l_g_0 = OclAnyNotEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, symbol_1, null);
            @Nullable /*@Caught*/ EObject symbol_0;
            if (_l_g_0 == TRUE_VALUE) {
                symbol_0 = (EObject)symbol_1;
            }
            else if (_l_g_0 == FALSE_VALUE) {
                if (any_0 instanceof InvalidValueException) throw (InvalidValueException)any_0;
                final @NonNull /*@Thrown*/ Boolean _l_g_2 = OclAnyNotEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, any_0, null);
                @Nullable /*@Thrown*/ Object symbol_2;
                if (_l_g_2 == TRUE_VALUE) {
                    if (any_0 == null) throw new InvalidValueException("Null source for property: initialConstraint.specification");
                    if (any_0 instanceof InvalidValueException) throw (InvalidValueException)any_0;
                    final @Nullable /*@Thrown*/ ValueSpecification specification_0 = ((Constraint)any_0).getSpecification();
                    symbol_2 = specification_0;
                }
                else if (_l_g_2 == FALSE_VALUE) {
                    symbol_2 = null;
                }
                else {
                    throw INVALID_VALUE;
                }
                symbol_0 = (EObject)symbol_2;
            }
            else {
                throw INVALID_VALUE;
            }
            @NonNull /*@Caught*/ Object oclIsKindOf;
            try {
                oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, symbol_0, TYP_pivot_c_c_ExpressionInOCL);
            } catch (Exception e) { oclIsKindOf = createInvalidValue(e); }
            @NonNull /*@Caught*/ Object CompatibleBody;
            try {
                if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                CompatibleBody = (Boolean)TypedMultiplicityElementBodies._CompatibleBody_body_.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, self, symbol_0);
            } catch (Exception e) { CompatibleBody = createInvalidValue(e); }
            @NonNull /*@Caught*/ Object _l_g;
            try {
                _l_g = OclAnyNotEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, symbol_0, null);
            } catch (Exception e) { _l_g = createInvalidValue(e); }
            @Nullable /*@Caught*/ Object and;
            try {
                and = BooleanAndOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _l_g, oclIsKindOf);
            } catch (Exception e) { and = createInvalidValue(e); }
            @Nullable /*@Caught*/ Object implies;
            try {
                implies = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, and, CompatibleBody);
            } catch (Exception e) { implies = createInvalidValue(e); }
            final @Nullable /*@Thrown*/ Object result = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, isDerived, implies);
            if (result == null) throw new InvalidValueException("null return");
            return (Boolean)result;
        }
    }

    /**
     * Implementation of the Property::isAttribute '' <body>
     * 
     * 
     * let container : OclElement = oclContainer()
     * in
     *   container.oclIsKindOf(Type) and
     *   container.oclAsType(Type)
     *   .ownedAttribute->includes(self)
     */
    public static class _isAttribute_body_ extends AbstractBinaryOperation
    {
        public static final @NonNull _isAttribute_body_ INSTANCE = new _isAttribute_body_();

        public @NonNull /*@Thrown*/ Boolean evaluate(final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator, final @NonNull /*@NonInvalid*/ TypeId returnTypeId, final @Nullable /*@Caught*/ Object self, final @Nullable /*@Thrown*/ Object p) throws Exception {
            final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
            final @NonNull /*@NonInvalid*/ DomainType TYP_Type = idResolver.getType(CLSSid_Type, null);
            @Nullable /*@Caught*/ Object oclContainer;
            try {
                if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                oclContainer = (EObject)ClassifierOclContainerOperation.INSTANCE.evaluate(evaluator, CLSSid_OclElement, self);
            } catch (Exception e) { oclContainer = createInvalidValue(e); }
            @NonNull /*@Caught*/ Object oclIsKindOf;
            try {
                oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, oclContainer, TYP_Type);
            } catch (Exception e) { oclIsKindOf = createInvalidValue(e); }
            @NonNull /*@Caught*/ Object includes;
            try {
                if (oclContainer instanceof InvalidValueException) throw (InvalidValueException)oclContainer;
                final @Nullable /*@Thrown*/ Object oclAsType = OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, CLSSid_Type, oclContainer, TYP_Type);
                if (oclAsType == null) throw new InvalidValueException("Null source for property: container.oclAsType(Type).ownedAttribute");
                final @SuppressWarnings("null")@NonNull /*@Thrown*/ EList<?> ownedAttribute = ((Type)oclAsType).getOwnedAttribute();
                final @NonNull /*@Thrown*/ CollectionValue BOXED_ownedAttribute = createCollectionValue(ORD_CLSSid_Property, ownedAttribute);
                if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                includes = CollectionIncludesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, BOXED_ownedAttribute, self);
            } catch (Exception e) { includes = createInvalidValue(e); }
            final @Nullable /*@Thrown*/ Object and = BooleanAndOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, oclIsKindOf, includes);
            if (and == null) throw new InvalidValueException("null return");
            return (Boolean)and;
        }
    }
}
