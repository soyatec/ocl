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
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.ClassId;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.PackageId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractUnaryOperation;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.library.collection.CollectionSizeOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;

@SuppressWarnings("nls")
public class OperationCallExpBodies extends ValuesUtil
{
    private static final @NonNull /*@NonInvalid*/ PackageId PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot = IdManager.INSTANCE.getNsURIPackageId("http://www.eclipse.org/ocl/3.1.0/Pivot", org.eclipse.ocl.examples.pivot.PivotPackage.eINSTANCE);
    private static final @NonNull /*@NonInvalid*/ ClassId CLSSid_OCLExpression = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("OCLExpression");
    private static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_OCLExpression = TypeId.ORDERED_SET.getSpecializedId(CLSSid_OCLExpression);
    private static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Parameter = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("Parameter");
    private static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Parameter = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Parameter);

    /**
     * Implementation of the OperationCallExp 'ArgumentCount' <invariant>
     * 
     * argument->size() = referredOperation.ownedParameter->size()
     */
    public static class _invariant_ArgumentCount extends AbstractUnaryOperation
    {
        public static final @NonNull _invariant_ArgumentCount INSTANCE = new _invariant_ArgumentCount();

        @Override
        public @NonNull /*@Thrown*/ Boolean evaluate(final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator, final @NonNull /*@NonInvalid*/ TypeId returnTypeId, final @Nullable /*@NonInvalid*/ Object self) throws Exception {
            if (self == null) throw new InvalidValueException("Null Literal");
            final @SuppressWarnings("null")@NonNull /*@Thrown*/ EList<?> argument = ((OperationCallExp)self).getArgument();
            final @NonNull /*@Thrown*/ CollectionValue BOXED_argument = createCollectionValue(ORD_CLSSid_OCLExpression, argument);
            final @NonNull /*@Thrown*/ IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(evaluator, TypeId.INTEGER, BOXED_argument);
            if (size instanceof InvalidValueException) throw (InvalidValueException)size;
            if (self == null) throw new InvalidValueException("Null Literal");
            final @Nullable /*@Thrown*/ Operation referredOperation = ((OperationCallExp)self).getReferredOperation();
            if (referredOperation == null) throw new InvalidValueException("Null Literal");
            final @SuppressWarnings("null")@NonNull /*@Thrown*/ List<?> ownedParameter = referredOperation.getOwnedParameter();
            final @NonNull /*@Thrown*/ CollectionValue BOXED_ownedParameter = createCollectionValue(ORD_CLSSid_Parameter, ownedParameter);
            final @NonNull /*@Thrown*/ IntegerValue size_0 = CollectionSizeOperation.INSTANCE.evaluate(evaluator, TypeId.INTEGER, BOXED_ownedParameter);
            if (size_0 instanceof InvalidValueException) throw (InvalidValueException)size_0;
            final @NonNull /*@Thrown*/ Boolean result = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, size, size_0);
            return result;
        }
    }
}
