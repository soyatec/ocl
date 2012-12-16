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
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.elements.DomainTypedElement;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.ids.ClassId;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.PackageId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractUnaryOperation;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.InvalidValue;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.library.classifier.OclTypeConformsToOperation;
import org.eclipse.ocl.examples.library.collection.CollectionSizeOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyOclAsSetOperation;
import org.eclipse.ocl.examples.pivot.IterateExp;
import org.eclipse.ocl.examples.pivot.LoopExp;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Variable;

@SuppressWarnings("nls")
public class IterateExpBodies extends ValuesUtil
{
    private static final @NonNull /*@NonInvalid*/ IntegerValue INT_1 = integerValueOf(1);
    private static final @NonNull /*@NonInvalid*/ PackageId PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot = IdManager.INSTANCE.getNsURIPackageId("http://www.eclipse.org/ocl/3.1.0/Pivot", org.eclipse.ocl.examples.pivot.PivotPackage.eINSTANCE);
    private static final @NonNull /*@NonInvalid*/ ClassId CLSSid_OCLExpression = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("OCLExpression");
    private static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_OCLExpression = TypeId.SET.getSpecializedId(CLSSid_OCLExpression);

    /**
     * Implementation of the IterateExp 'BodyTypeConformsToResultType' <invariant>
     * 
     * body.type.conformsTo(result.type)
     */
    public static class _invariant_BodyTypeConformsToResultType extends AbstractUnaryOperation
    {
        public static final @NonNull _invariant_BodyTypeConformsToResultType INSTANCE = new _invariant_BodyTypeConformsToResultType();

        public @NonNull /*@Thrown*/ Boolean evaluate(final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator, final @NonNull /*@NonInvalid*/ TypeId returnTypeId, final @Nullable /*@Caught*/ Object self) throws Exception {
            if (self == null) throw new InvalidValueException("Null source for property: body");
            if (self instanceof InvalidValue) throw ((InvalidValue)self).getException();
            final @Nullable /*@Thrown*/ OCLExpression body = ((LoopExp)self).getBody();
            if (body == null) throw new InvalidValueException("Null source for property: body.type");
            final @Nullable /*@Thrown*/ DomainType type = body.getType();
            if (self == null) throw new InvalidValueException("Null source for property: result");
            if (self instanceof InvalidValue) throw ((InvalidValue)self).getException();
            final @Nullable /*@Thrown*/ Variable result_1 = ((IterateExp)self).getResult();
            if (result_1 == null) throw new InvalidValueException("Null source for property: result.type");
            final @Nullable /*@Thrown*/ DomainType type_0 = result_1.getType();
            final @NonNull /*@Thrown*/ Boolean result = OclTypeConformsToOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type, type_0);
            return result;
        }
    }

    /**
     * Implementation of the IterateExp 'OneInitializer' <invariant>
     * 
     * self.result.initExpression->size() = 1
     */
    public static class _invariant_OneInitializer extends AbstractUnaryOperation
    {
        public static final @NonNull _invariant_OneInitializer INSTANCE = new _invariant_OneInitializer();

        public @NonNull /*@Thrown*/ Boolean evaluate(final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator, final @NonNull /*@NonInvalid*/ TypeId returnTypeId, final @Nullable /*@Thrown*/ Object self) throws Exception {
            if (self == null) throw new InvalidValueException("Null source for property: self.result");
            final @Nullable /*@Thrown*/ Variable result_1 = ((IterateExp)self).getResult();
            if (result_1 == null) throw new InvalidValueException("Null source for property: self.result.initExpression");
            final @Nullable /*@Thrown*/ OCLExpression initExpression = result_1.getInitExpression();
            final @NonNull /*@Thrown*/ CollectionValue oclAsSet = OclAnyOclAsSetOperation.INSTANCE.evaluate(evaluator, SET_CLSSid_OCLExpression, initExpression);
            final @NonNull /*@Thrown*/ IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(evaluator, TypeId.INTEGER, oclAsSet);
            final @NonNull /*@Thrown*/ Boolean result = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, size, INT_1);
            return result;
        }
    }

    /**
     * Implementation of the IterateExp 'TypeIsResultType' <invariant>
     * 
     * type = result.type
     */
    public static class _invariant_TypeIsResultType extends AbstractUnaryOperation
    {
        public static final @NonNull _invariant_TypeIsResultType INSTANCE = new _invariant_TypeIsResultType();

        public @NonNull /*@Thrown*/ Boolean evaluate(final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator, final @NonNull /*@NonInvalid*/ TypeId returnTypeId, final @Nullable /*@Caught*/ Object self) throws Exception {
            if (self == null) throw new InvalidValueException("Null source for property: type");
            if (self instanceof InvalidValue) throw ((InvalidValue)self).getException();
            final @Nullable /*@Thrown*/ DomainType type = ((DomainTypedElement)self).getType();
            if (self == null) throw new InvalidValueException("Null source for property: result");
            if (self instanceof InvalidValue) throw ((InvalidValue)self).getException();
            final @Nullable /*@Thrown*/ Variable result_1 = ((IterateExp)self).getResult();
            if (result_1 == null) throw new InvalidValueException("Null source for property: result.type");
            final @Nullable /*@Thrown*/ DomainType type_0 = result_1.getType();
            final @NonNull /*@Thrown*/ Boolean result = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type, type_0);
            return result;
        }
    }
}
