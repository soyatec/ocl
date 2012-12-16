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
import org.eclipse.ocl.examples.domain.elements.Nameable;
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
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.InvalidValue;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.library.collection.CollectionExcludingOperation;
import org.eclipse.ocl.examples.library.executor.ExecutorSingleIterationManager;
import org.eclipse.ocl.examples.library.logical.BooleanOrOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.NamedElement;

@SuppressWarnings("nls")
public class ConstraintBodies extends ValuesUtil
{
    private static final @NonNull /*@NonInvalid*/ PackageId PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot = IdManager.INSTANCE.getNsURIPackageId("http://www.eclipse.org/ocl/3.1.0/Pivot", org.eclipse.ocl.examples.pivot.PivotPackage.eINSTANCE);
    private static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Constraint = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("Constraint");
    private static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Constraint = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Constraint);

    /**
     * Implementation of the Constraint 'UniqueName' <invariant>
     * 
     * 
     * context.ownedRule->excluding(self)
     * ->forAll(name <> self.name or stereotype <> self.stereotype)
     */
    public static class _invariant_UniqueName extends AbstractUnaryOperation
    {
        public static final @NonNull _invariant_UniqueName INSTANCE = new _invariant_UniqueName();

        public @NonNull /*@Thrown*/ Boolean evaluate(final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator, final @NonNull /*@NonInvalid*/ TypeId returnTypeId, final @Nullable /*@Caught*/ Object self) throws Exception {
            if (self == null) throw new InvalidValueException("Null source for property: context");
            if (self instanceof InvalidValue) throw ((InvalidValue)self).getException();
            final @Nullable /*@Thrown*/ NamedElement context = ((Constraint)self).getContext();
            if (context == null) throw new InvalidValueException("Null source for property: context.ownedRule");
            final @SuppressWarnings("null")@NonNull /*@Thrown*/ EList<?> ownedRule = context.getOwnedRule();
            final @NonNull /*@Thrown*/ CollectionValue BOXED_ownedRule = createCollectionValue(ORD_CLSSid_Constraint, ownedRule);
            if (self instanceof InvalidValue) throw ((InvalidValue)self).getException();
            final @NonNull /*@Thrown*/ CollectionValue excluding = CollectionExcludingOperation.INSTANCE.evaluate(evaluator, ORD_CLSSid_Constraint, BOXED_ownedRule, self);
            final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
            /**
             * Implementation of the iterator body.
             */
            final @NonNull AbstractBinaryOperation BODY_result = new AbstractBinaryOperation()
            {
                /**
                 * name <> self.name or stereotype <> self.stereotype
                 */
                public @Nullable Object evaluate(final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator, final @NonNull TypeId returnTypeId, @Nullable final Object sourceValue, final @Nullable /*@Caught*/ Object _49__) throws Exception {
                    @NonNull /*@Caught*/ Object _l_g;
                    try {
                        if (_49__ == null) throw new InvalidValueException("Null source for property: name");
                        if (_49__ instanceof InvalidValue) throw ((InvalidValue)_49__).getException();
                        final @Nullable /*@Thrown*/ String name = ((Nameable)_49__).getName();
                        if (self == null) throw new InvalidValueException("Null source for property: self.name");
                        if (self instanceof InvalidValue) throw ((InvalidValue)self).getException();
                        final @Nullable /*@Thrown*/ String name_0 = ((Nameable)self).getName();
                        _l_g = OclAnyNotEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, name_0);
                    } catch (Exception e) { _l_g = createInvalidValue(e); }
                    @NonNull /*@Caught*/ Object _l_g_0;
                    try {
                        if (_49__ == null) throw new InvalidValueException("Null source for property: stereotype");
                        if (_49__ instanceof InvalidValue) throw ((InvalidValue)_49__).getException();
                        final @Nullable /*@Thrown*/ String stereotype = ((Constraint)_49__).getStereotype();
                        if (self == null) throw new InvalidValueException("Null source for property: self.stereotype");
                        if (self instanceof InvalidValue) throw ((InvalidValue)self).getException();
                        final @Nullable /*@Thrown*/ String stereotype_0 = ((Constraint)self).getStereotype();
                        _l_g_0 = OclAnyNotEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, stereotype, stereotype_0);
                    } catch (Exception e) { _l_g_0 = createInvalidValue(e); }
                    final @Nullable /*@Thrown*/ Object or = BooleanOrOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _l_g, _l_g_0);
                    return or;
                }
            };
            DomainType TYPE_result = evaluator.getStaticTypeOf(excluding);
            LibraryIteration IMPL_result = (LibraryIteration)TYPE_result.lookupImplementation(standardLibrary, OCLstdlibTables.Operations._Collection__1_forAll);
            Object ACC_result = IMPL_result.createAccumulatorValue(evaluator, TypeId.BOOLEAN, TypeId.BOOLEAN);
            ExecutorSingleIterationManager MGR_result = new ExecutorSingleIterationManager(evaluator, TypeId.BOOLEAN, BODY_result, excluding, ACC_result);
            final @Nullable /*@Thrown*/ Object result = IMPL_result.evaluateIteration(MGR_result);
            if (result == null) throw new InvalidValueException("null return");
            return (Boolean)result;
        }
    }
}
