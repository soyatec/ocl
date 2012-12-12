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
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.ids.ClassId;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.PackageId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractUnaryOperation;
import org.eclipse.ocl.examples.domain.types.IdResolver;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.TypeValue;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.library.collection.CollectionSizeOperation;
import org.eclipse.ocl.examples.library.logical.BooleanNotOperation;
import org.eclipse.ocl.examples.library.numeric.NumericPlusOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyOclAsSetOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.examples.pivot.CallOperationAction;
import org.eclipse.ocl.examples.pivot.MessageExp;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.SendSignalAction;

@SuppressWarnings("nls")
public class MessageExpBodies extends ValuesUtil

{
    private static final @NonNull IntegerValue INT_1 = integerValueOf(1);
    private static final @NonNull PackageId PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot = IdManager.INSTANCE.getNsURIPackageId("http://www.eclipse.org/ocl/3.1.0/Pivot", org.eclipse.ocl.examples.pivot.PivotPackage.eINSTANCE);
    private static final @NonNull ClassId CLSSid_SendSignalAction = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("SendSignalAction");
    private static final @NonNull CollectionTypeId SET_CLSSid_SendSignalAction = TypeId.SET.getSpecializedId(CLSSid_SendSignalAction);
    private static final @NonNull ClassId CLSSid_CollectionType = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("CollectionType");
    private static final @NonNull ClassId CLSSid_CallOperationAction = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("CallOperationAction");
    private static final @NonNull CollectionTypeId SET_CLSSid_CallOperationAction = TypeId.SET.getSpecializedId(CLSSid_CallOperationAction);
    /**
     * Implementation of the MessageExp 'OneCallOrOneSend' <invariant>
     * 
     * calledOperation->size() + sentSignal->size() = 1
     */
    public static class _invariant_OneCallOrOneSend extends AbstractUnaryOperation
    {
        public static final @NonNull _invariant_OneCallOrOneSend INSTANCE = new _invariant_OneCallOrOneSend();

        public @Nullable Object evaluate(final @NonNull DomainEvaluator evaluator, final @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable CallOperationAction calledOperation = ((MessageExp)self).getCalledOperation();
            final @NonNull CollectionValue oclAsSet = OclAnyOclAsSetOperation.INSTANCE.evaluate(evaluator, SET_CLSSid_CallOperationAction, calledOperation);
            final @NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(evaluator, TypeId.INTEGER, oclAsSet);
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable SendSignalAction sentSignal = ((MessageExp)self).getSentSignal();
            final @NonNull CollectionValue oclAsSet_0 = OclAnyOclAsSetOperation.INSTANCE.evaluate(evaluator, SET_CLSSid_SendSignalAction, sentSignal);
            final @NonNull IntegerValue size_0 = CollectionSizeOperation.INSTANCE.evaluate(evaluator, TypeId.INTEGER, oclAsSet_0);
            final @NonNull IntegerValue _p = (IntegerValue)NumericPlusOperation.INSTANCE.evaluate(evaluator, TypeId.INTEGER, size, size_0);
            final @NonNull Boolean result = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _p, INT_1);
            return result;
        }
    }
    /**
     * Implementation of the MessageExp 'TargetIsNotACollection' <invariant>
     * 
     * not target.type.oclIsKindOf(CollectionType)
     */
    public static class _invariant_TargetIsNotACollection extends AbstractUnaryOperation
    {
        public static final @NonNull _invariant_TargetIsNotACollection INSTANCE = new _invariant_TargetIsNotACollection();

        public @Nullable Object evaluate(final @NonNull DomainEvaluator evaluator, final @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
            final @NonNull IdResolver idResolver = evaluator.getIdResolver();
            final @NonNull TypeValue TYP_pivot_c_c_CollectionType = createTypeValue(idResolver.getType(CLSSid_CollectionType, null));
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable OCLExpression target = ((MessageExp)self).getTarget();
            if (target == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable DomainType type = target.getType();
            final @NonNull Boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type, TYP_pivot_c_c_CollectionType);
            final @Nullable Boolean result = BooleanNotOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, oclIsKindOf);
            return result;
        }
    }
}
