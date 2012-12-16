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
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
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
import org.eclipse.ocl.examples.domain.values.InvalidValue;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.library.executor.ExecutorSingleIterationManager;
import org.eclipse.ocl.examples.library.logical.BooleanAndOperation;
import org.eclipse.ocl.examples.library.logical.BooleanImpliesOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.bodies.TypedMultiplicityElementBodies;

@SuppressWarnings("nls")
public class OperationBodies extends ValuesUtil
{
    private static final @NonNull /*@NonInvalid*/ String STR_body = "body";
    private static final @NonNull /*@NonInvalid*/ PackageId PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot = IdManager.INSTANCE.getNsURIPackageId("http://www.eclipse.org/ocl/3.1.0/Pivot", org.eclipse.ocl.examples.pivot.PivotPackage.eINSTANCE);
    private static final @NonNull /*@NonInvalid*/ ClassId CLSSid_ExpressionInOCL = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("ExpressionInOCL");
    private static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Constraint = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("Constraint");
    private static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Constraint = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Constraint);

    /**
     * Implementation of the Operation 'CompatibleReturn' <invariant>
     * 
     * 
     * let
     *   bodyConstraint : Constraint = ownedRule->any(stereotype = 'body')
     * in bodyConstraint <> null implies
     *   let bodySpecification : ValueSpecification = bodyConstraint.specification
     *   in bodySpecification <> null and
     *     bodySpecification.oclIsKindOf(ExpressionInOCL) implies
     *     CompatibleBody(bodySpecification)
     */
    public static class _invariant_CompatibleReturn extends AbstractUnaryOperation
    {
        public static final @NonNull _invariant_CompatibleReturn INSTANCE = new _invariant_CompatibleReturn();

        public @NonNull /*@Thrown*/ Boolean evaluate(final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator, final @NonNull /*@NonInvalid*/ TypeId returnTypeId, final @Nullable /*@Caught*/ Object self) throws Exception {
            final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
            final @NonNull /*@NonInvalid*/ DomainType TYP_pivot_c_c_ExpressionInOCL = idResolver.getType(CLSSid_ExpressionInOCL, null);
            if (self == null) throw new InvalidValueException("Null source for property: ownedRule");
            if (self instanceof InvalidValue) throw ((InvalidValue)self).getException();
            final @SuppressWarnings("null")@NonNull /*@Thrown*/ EList<?> ownedRule = ((NamedElement)self).getOwnedRule();
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
                     * stereotype = 'body'
                     */
                    public @Nullable Object evaluate(final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator, final @NonNull TypeId returnTypeId, @Nullable final Object sourceValue, final @Nullable /*@Thrown*/ Object _49__) throws Exception {
                        if (_49__ == null) throw new InvalidValueException("Null source for property: stereotype");
                        final @Nullable /*@Thrown*/ String stereotype = ((Constraint)_49__).getStereotype();
                        final @NonNull /*@Thrown*/ Boolean _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, stereotype, STR_body);
                        return _q;
                    }
                };
                DomainType TYPE_any = evaluator.getStaticTypeOf(BOXED_ownedRule);
                LibraryIteration IMPL_any = (LibraryIteration)TYPE_any.lookupImplementation(standardLibrary, OCLstdlibTables.Operations._Collection__any);
                Object ACC_any = IMPL_any.createAccumulatorValue(evaluator, CLSSid_Constraint, TypeId.BOOLEAN);
                ExecutorSingleIterationManager MGR_any = new ExecutorSingleIterationManager(evaluator, CLSSid_Constraint, BODY_any, BOXED_ownedRule, ACC_any);
                any = IMPL_any.evaluateIteration(MGR_any);
            } catch (Exception e) { any = createInvalidValue(e); }
            @NonNull /*@Caught*/ Object _l_g;
            try {
                if (any instanceof InvalidValue) throw ((InvalidValue)any).getException();
                _l_g = OclAnyNotEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, any, null);
            } catch (Exception e) { _l_g = createInvalidValue(e); }
            @Nullable /*@Caught*/ Object specification;
            try {
                if (any == null) throw new InvalidValueException("Null source for property: bodyConstraint.specification");
                if (any instanceof InvalidValue) throw ((InvalidValue)any).getException();
                specification = ((Constraint)any).getSpecification();
            } catch (Exception e) { specification = createInvalidValue(e); }
            @NonNull /*@Caught*/ Object _l_g_0;
            try {
                if (specification instanceof InvalidValue) throw ((InvalidValue)specification).getException();
                _l_g_0 = OclAnyNotEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, specification, null);
            } catch (Exception e) { _l_g_0 = createInvalidValue(e); }
            @NonNull /*@Caught*/ Object oclIsKindOf;
            try {
                oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, specification, TYP_pivot_c_c_ExpressionInOCL);
            } catch (Exception e) { oclIsKindOf = createInvalidValue(e); }
            @Nullable /*@Caught*/ Object and;
            try {
                and = BooleanAndOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _l_g_0, oclIsKindOf);
            } catch (Exception e) { and = createInvalidValue(e); }
            @NonNull /*@Caught*/ Object CompatibleBody;
            try {
                if (self instanceof InvalidValue) throw ((InvalidValue)self).getException();
                if (specification instanceof InvalidValue) throw ((InvalidValue)specification).getException();
                CompatibleBody = (Boolean)TypedMultiplicityElementBodies._CompatibleBody_body_.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, self, specification);
            } catch (Exception e) { CompatibleBody = createInvalidValue(e); }
            @Nullable /*@Caught*/ Object implies_0;
            try {
                implies_0 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, and, CompatibleBody);
            } catch (Exception e) { implies_0 = createInvalidValue(e); }
            final @Nullable /*@Thrown*/ Object implies = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _l_g, implies_0);
            if (implies == null) throw new InvalidValueException("null return");
            return (Boolean)implies;
        }
    }

    /**
     * Implementation of the Operation 'LoadableImplementation' <invariant>
     * 
     * true
     */
    public static class _invariant_LoadableImplementation extends AbstractUnaryOperation
    {
        public static final @NonNull _invariant_LoadableImplementation INSTANCE = new _invariant_LoadableImplementation();

        public @NonNull /*@Thrown*/ Boolean evaluate(final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator, final @NonNull /*@NonInvalid*/ TypeId returnTypeId, final @Nullable /*@Thrown*/ Object self) throws Exception {
            return TRUE_VALUE;
        }
    }
}
