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
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractUnaryOperation;
import org.eclipse.ocl.examples.domain.types.IdResolver;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation;

@SuppressWarnings("nls")
public class IntegerLiteralExpBodies extends ValuesUtil
{

    /**
     * Implementation of the IntegerLiteralExp 'TypeIsInteger' <invariant>
     * 
     * self.type = Integer
     */
    public static class _invariant_TypeIsInteger extends AbstractUnaryOperation
    {
        public static final @NonNull _invariant_TypeIsInteger INSTANCE = new _invariant_TypeIsInteger();

        public @NonNull /*@Thrown*/ Boolean evaluate(final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator, final @NonNull /*@NonInvalid*/ TypeId returnTypeId, final @Nullable /*@Thrown*/ Object self) throws Exception {
            final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
            final @NonNull /*@NonInvalid*/ DomainType TYP_Integer = idResolver.getType(TypeId.INTEGER, null);
            if (self == null) throw new InvalidValueException("Null source for property: self.type");
            final @Nullable /*@Thrown*/ DomainType type = ((DomainTypedElement)self).getType();
            final @NonNull /*@Thrown*/ Boolean result = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type, TYP_Integer);
            return result;
        }
    }
}
