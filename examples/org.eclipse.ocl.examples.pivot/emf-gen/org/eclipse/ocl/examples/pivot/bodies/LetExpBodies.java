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
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractUnaryOperation;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation;
import org.eclipse.ocl.examples.pivot.LetExp;
import org.eclipse.ocl.examples.pivot.OCLExpression;

@SuppressWarnings("nls")
public class LetExpBodies extends ValuesUtil
{

    /**
     * Implementation of the LetExp 'TypeIsInType' <invariant>
     * 
     * type = _'in'.type
     */
    public static class _invariant_TypeIsInType extends AbstractUnaryOperation
    {
        public static final @NonNull _invariant_TypeIsInType INSTANCE = new _invariant_TypeIsInType();

        @Override
        public @NonNull /*@Thrown*/ Boolean evaluate(final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator, final @NonNull /*@NonInvalid*/ TypeId returnTypeId, final @Nullable /*@NonInvalid*/ Object self) throws Exception {
            if (self == null) throw new InvalidValueException(null, "");
            final @Nullable /*@Thrown*/ DomainType type = ((DomainTypedElement)self).getType();
            if (self == null) throw new InvalidValueException(null, "");
            final @Nullable /*@Thrown*/ OCLExpression in = ((LetExp)self).getIn();
            if (in == null) throw new InvalidValueException(null, "");
            final @Nullable /*@Thrown*/ DomainType type_0 = in.getType();
            final @NonNull /*@Thrown*/ Boolean result = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type, type_0);
            return result;
        }
    }
}
