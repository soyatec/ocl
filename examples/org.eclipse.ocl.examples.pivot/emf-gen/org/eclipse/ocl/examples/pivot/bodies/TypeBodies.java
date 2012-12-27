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

import java.lang.Object;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractBinaryOperation;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;

@SuppressWarnings("nls")
public class TypeBodies extends ValuesUtil
{

    /**
     * Implementation of the Type::resolveSelfType '' <body>
     * 
     * self
     */
    public static class _resolveSelfType_body_ extends AbstractBinaryOperation
    {
        public static final @NonNull _resolveSelfType_body_ INSTANCE = new _resolveSelfType_body_();

        public @NonNull /*@Thrown*/ Object evaluate(final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator, final @NonNull /*@NonInvalid*/ TypeId returnTypeId, final @Nullable /*@Thrown*/ Object self, final @Nullable /*@Thrown*/ Object selfType) throws Exception {
            if (self == null) throw new InvalidValueException(null, "");
            return self;
        }
    }
}
