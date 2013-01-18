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

import java.util.Iterator;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.ClassId;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.PackageId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractUnaryOperation;
import org.eclipse.ocl.examples.domain.types.IdResolver;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.library.logical.BooleanAndOperation;
import org.eclipse.ocl.examples.library.logical.BooleanImpliesOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.NamedElement;

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

        @Override
        public @NonNull /*@Thrown*/ Boolean evaluate(final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator, final @NonNull /*@NonInvalid*/ TypeId returnTypeId, final @Nullable /*@NonInvalid*/ Object self) throws Exception {
            final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
            final @NonNull /*@NonInvalid*/ DomainType TYP_pivot_c_c_ExpressionInOCL = idResolver.getType(CLSSid_ExpressionInOCL, null);
            @Nullable /*@Caught*/ Object any;
            try {
                if (self == null) throw new InvalidValueException("Null Literal");
                final @SuppressWarnings("null")@NonNull /*@Thrown*/ List<?> ownedRule = ((NamedElement)self).getOwnedRule();
                final @NonNull /*@Thrown*/ CollectionValue BOXED_ownedRule = createCollectionValue(ORD_CLSSid_Constraint, ownedRule);
                final @NonNull /*@NonInvalid*/ Iterator<?> ownedRule_iterator = BOXED_ownedRule.iterator();
                ;
                while (true) {
                    if (!ownedRule_iterator.hasNext()) {
                        any = null;
                        break;
                    }
                    final @Nullable /*@NonInvalid*/ Object _49__ = ownedRule_iterator.next();
                    /**
                     * stereotype = 'body'
                     */
                    if (_49__ == null) throw new InvalidValueException("Null Literal");
                    final @Nullable /*@Thrown*/ String stereotype = ((Constraint)_49__).getStereotype();
                    final @NonNull /*@Thrown*/ Boolean _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, stereotype, STR_body);
                    /**/
                    if (_q != FALSE_VALUE) {			// Carry on till something found
                        any = _49__;
                        break;
                    }
                }
            } catch (Exception e) { any = createInvalidValue(e); }
            @NonNull /*@Caught*/ Object _l_g;
            try {
                if (any instanceof InvalidValueException) throw (InvalidValueException)any;
                _l_g = OclAnyNotEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, any, null);
            } catch (Exception e_0) { _l_g = createInvalidValue(e_0); }
            @Nullable /*@Caught*/ Object specification;
            try {
                if (any instanceof InvalidValueException) throw (InvalidValueException)any;
                if (any == null) throw new InvalidValueException("Null Literal");
                specification = ((Constraint)any).getSpecification();
            } catch (Exception e_1) { specification = createInvalidValue(e_1); }
            @Nullable /*@Caught*/ Object implies_0;
            try {
                @Nullable /*@Caught*/ Object and;
                try {
                    @NonNull /*@Caught*/ Object _l_g_0;
                    try {
                        if (specification instanceof InvalidValueException) throw (InvalidValueException)specification;
                        _l_g_0 = OclAnyNotEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, specification, null);
                    } catch (Exception e_2) { _l_g_0 = createInvalidValue(e_2); }
                    @NonNull /*@Caught*/ Object oclIsKindOf;
                    try {
                        oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, specification, TYP_pivot_c_c_ExpressionInOCL);
                    } catch (Exception e_3) { oclIsKindOf = createInvalidValue(e_3); }
                    and = BooleanAndOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _l_g_0, oclIsKindOf);
                } catch (Exception e_4) { and = createInvalidValue(e_4); }
                @NonNull /*@Caught*/ Object CompatibleBody;
                try {
                    if (specification instanceof InvalidValueException) throw (InvalidValueException)specification;
                    CompatibleBody = TypedMultiplicityElementBodies._CompatibleBody_body_.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, self, specification);
                } catch (Exception e_5) { CompatibleBody = createInvalidValue(e_5); }
                implies_0 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, and, CompatibleBody);
            } catch (Exception e_6) { implies_0 = createInvalidValue(e_6); }
            final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _l_g, implies_0);
            if (implies == null) throw new InvalidValueException("Null Literal");
            return implies;
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

        @Override
        public @NonNull /*@Thrown*/ Boolean evaluate(final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator, final @NonNull /*@NonInvalid*/ TypeId returnTypeId, final @Nullable /*@NonInvalid*/ Object self) throws Exception {
            return TRUE_VALUE;
        }
    }
}
