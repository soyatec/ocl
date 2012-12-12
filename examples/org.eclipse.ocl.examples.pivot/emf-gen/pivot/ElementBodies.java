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
package pivot;

import java.lang.Boolean;
import java.lang.Object;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.ClassId;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.PackageId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractTernaryOperation;
import org.eclipse.ocl.examples.domain.library.AbstractUnaryOperation;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.library.classifier.ClassifierOclContentsOperation;
import org.eclipse.ocl.examples.library.collection.CollectionIncludesOperation;
import org.eclipse.ocl.examples.library.logical.BooleanNotOperation;

@SuppressWarnings("nls")
public class ElementBodies extends ValuesUtil

{
    private static final @NonNull PackageId PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot = IdManager.INSTANCE.getNsURIPackageId("http://www.eclipse.org/ocl/3.1.0/Pivot", org.eclipse.ocl.examples.pivot.PivotPackage.eINSTANCE);
    private static final @NonNull ClassId CLSSid_Element = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("Element");
    private static final @NonNull CollectionTypeId SET_CLSSid_Element = TypeId.SET.getSpecializedId(CLSSid_Element);
    private static final @NonNull ClassId CLSSid_OclElement = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("OclElement");
    private static final @NonNull CollectionTypeId SET_CLSSid_OclElement = TypeId.SET.getSpecializedId(CLSSid_OclElement);
    /**
     * Implementation of the Element 'not_own_self' <invariant>
     * 
     * not allOwnedElements()->includes(self)
     */
    public static class _invariant_not_own_self extends AbstractUnaryOperation
    {
        public static final @NonNull _invariant_not_own_self INSTANCE = new _invariant_not_own_self();

        public @Nullable Object evaluate(final @NonNull DomainEvaluator evaluator, final @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
            final @Nullable CollectionValue allOwnedElements = (CollectionValue)ElementBodies._allOwnedElements_body_.INSTANCE.evaluate(evaluator, SET_CLSSid_Element, self);
            final @NonNull Boolean includes = CollectionIncludesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, allOwnedElements, self);
            final @Nullable Boolean result = BooleanNotOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, includes);
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

        public @Nullable Object evaluate(final @NonNull DomainEvaluator evaluator, final @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
            final @NonNull CollectionValue result = (CollectionValue)ClassifierOclContentsOperation.INSTANCE.evaluate(evaluator, SET_CLSSid_OclElement, self);
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

        public @Nullable Object evaluate(final @NonNull DomainEvaluator evaluator, final @NonNull TypeId returnTypeId, final @Nullable Object self, final @Nullable Object stereotype, final @Nullable Object propertyName) throws Exception {
            return null;
        }
    }
}
