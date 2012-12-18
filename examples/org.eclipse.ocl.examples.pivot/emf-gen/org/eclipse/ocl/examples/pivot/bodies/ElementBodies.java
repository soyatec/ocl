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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.ids.ClassId;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.PackageId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractTernaryOperation;
import org.eclipse.ocl.examples.domain.library.AbstractUnaryOperation;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.InvalidValue;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.library.classifier.ClassifierOclContentsOperation;
import org.eclipse.ocl.examples.library.collection.CollectionIncludesOperation;
import org.eclipse.ocl.examples.library.logical.BooleanNotOperation;
import org.eclipse.ocl.examples.pivot.bodies.ElementBodies;

@SuppressWarnings("nls")
public class ElementBodies extends ValuesUtil
{
    private static final @NonNull /*@NonInvalid*/ PackageId PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot = IdManager.INSTANCE.getNsURIPackageId("http://www.eclipse.org/ocl/3.1.0/Pivot", org.eclipse.ocl.examples.pivot.PivotPackage.eINSTANCE);
    private static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Element = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("Element");
    private static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_Element = TypeId.SET.getSpecializedId(CLSSid_Element);
    private static final @NonNull /*@NonInvalid*/ ClassId CLSSid_OclElement = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("OclElement");
    private static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_OclElement = TypeId.SET.getSpecializedId(CLSSid_OclElement);

    /**
     * Implementation of the Element 'not_own_self' <invariant>
     * 
     * not allOwnedElements()->includes(self)
     */
    public static class _invariant_not_own_self extends AbstractUnaryOperation
    {
        public static final @NonNull _invariant_not_own_self INSTANCE = new _invariant_not_own_self();

        public @NonNull /*@Thrown*/ Boolean evaluate(final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator, final @NonNull /*@NonInvalid*/ TypeId returnTypeId, final @Nullable /*@Caught*/ Object self) throws Exception {
            if (self instanceof InvalidValue) throw ((InvalidValue)self).getException();
            final @Nullable /*@Thrown*/ CollectionValue allOwnedElements = (CollectionValue)ElementBodies._allOwnedElements_body_.INSTANCE.evaluate(evaluator, SET_CLSSid_Element, self);
            if (self instanceof InvalidValue) throw ((InvalidValue)self).getException();
            final @NonNull /*@Thrown*/ Boolean includes = CollectionIncludesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, allOwnedElements, self);
            final @Nullable /*@Thrown*/ Boolean result = BooleanNotOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, includes);
            if (result == null) throw new InvalidValueException("null return");
            return result;
        }
    }

    /**
     * Implementation of the Element::allOwnedElements '' <body>
     * 
     * oclContents()
     */
    public static class _allOwnedElements_body_ extends AbstractUnaryOperation
    {
        public static final @NonNull _allOwnedElements_body_ INSTANCE = new _allOwnedElements_body_();

        public @Nullable /*@Thrown*/ CollectionValue evaluate(final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator, final @NonNull /*@NonInvalid*/ TypeId returnTypeId, final @Nullable /*@Thrown*/ Object self) throws Exception {
            final @NonNull /*@Thrown*/ CollectionValue result = (CollectionValue)ClassifierOclContentsOperation.INSTANCE.evaluate(evaluator, SET_CLSSid_OclElement, self);
            return result;
        }
    }

    /**
     * Implementation of the Element::getValue '' <body>
     * 
     * null
     */
    public static class _getValue_body_ extends AbstractTernaryOperation
    {
        public static final @NonNull _getValue_body_ INSTANCE = new _getValue_body_();

        public @Nullable /*@Thrown*/ EObject evaluate(final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator, final @NonNull /*@NonInvalid*/ TypeId returnTypeId, final @Nullable /*@Thrown*/ Object self, final @Nullable /*@Thrown*/ Object stereotype, final @Nullable /*@Thrown*/ Object propertyName) throws Exception {
            return null;
        }
    }
}
