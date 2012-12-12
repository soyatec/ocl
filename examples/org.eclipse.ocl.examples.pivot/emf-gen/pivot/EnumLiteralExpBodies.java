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
import org.eclipse.ocl.examples.domain.elements.DomainEnumeration;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.elements.DomainTypedElement;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractUnaryOperation;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation;
import org.eclipse.ocl.examples.pivot.EnumLiteralExp;
import org.eclipse.ocl.examples.pivot.EnumerationLiteral;

@SuppressWarnings("nls")
public class EnumLiteralExpBodies extends ValuesUtil

{
    /**
     * Implementation of the EnumLiteralExp 'TypeIsEnumerationType' <invariant>
     * 
     * self.type = referredEnumLiteral.enumeration
     */
    public static class _invariant_TypeIsEnumerationType extends AbstractUnaryOperation
    {
        public static final @NonNull _invariant_TypeIsEnumerationType INSTANCE = new _invariant_TypeIsEnumerationType();

        public @Nullable Object evaluate(final @NonNull DomainEvaluator evaluator, final @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable DomainType type = ((DomainTypedElement)self).getType();
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable EnumerationLiteral referredEnumLiteral = ((EnumLiteralExp)self).getReferredEnumLiteral();
            if (referredEnumLiteral == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable DomainEnumeration enumeration = referredEnumLiteral.getEnumeration();
            final @NonNull Boolean result = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type, enumeration);
            return result;
        }
    }
}
