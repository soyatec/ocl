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
import org.eclipse.ocl.examples.domain.elements.DomainTypedElement;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractUnaryOperation;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueImpl;
import org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation;
import org.eclipse.ocl.examples.pivot.CollectionItem;
import org.eclipse.ocl.examples.pivot.OCLExpression;

@SuppressWarnings("nls")
public class CollectionItemBodies
{
    /**
     * Implementation of the CollectionItem 'TypeIsItemType' <invariant>
     * 
     * type = item.type
     */
    public static class _invariant_TypeIsItemType extends AbstractUnaryOperation
    {
        public static final @NonNull _invariant_TypeIsItemType INSTANCE = new _invariant_TypeIsItemType();

        public @Nullable Object evaluate(final @NonNull DomainEvaluator evaluator, final @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable OCLExpression item = ((CollectionItem)self).getItem();
            @Nullable Object CAUGHT_type_0;
            try {
                if (item == null) throw new InvalidValueException("Non-Null source for property");
                final @Nullable DomainType type_0 = item.getType();
                CAUGHT_type_0 = type_0;
            }
            catch (Exception e) {
                CAUGHT_type_0 = new InvalidValueImpl(e);
            }
            @Nullable Object CAUGHT_type;
            try {
                if (self == null) throw new InvalidValueException("Non-Null source for property");
                final @Nullable DomainType type = ((DomainTypedElement)self).getType();
                CAUGHT_type = type;
            }
            catch (Exception e) {
                CAUGHT_type = new InvalidValueImpl(e);
            }
            final @NonNull Boolean result = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, CAUGHT_type, CAUGHT_type_0);
            return result;
        }
    }
}
