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
import java.lang.Exception;
import java.lang.Object;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.elements.DomainTypedElement;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.ClassId;
import org.eclipse.ocl.examples.domain.ids.EnumerationId;
import org.eclipse.ocl.examples.domain.ids.EnumerationLiteralId;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.PackageId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractUnaryOperation;
import org.eclipse.ocl.examples.domain.types.IdResolver;
import org.eclipse.ocl.examples.domain.values.EnumerationLiteralValue;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.library.logical.BooleanImpliesOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.examples.pivot.CollectionKind;
import org.eclipse.ocl.examples.pivot.CollectionLiteralExp;

@SuppressWarnings("nls")
public class CollectionLiteralExpBodies extends ValuesUtil
{
    private static final @NonNull /*@NonInvalid*/ PackageId PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot = IdManager.INSTANCE.getNsURIPackageId("http://www.eclipse.org/ocl/3.1.0/Pivot", org.eclipse.ocl.examples.pivot.PivotPackage.eINSTANCE);
    private static final @NonNull /*@NonInvalid*/ EnumerationId ENUMid_CollectionKind = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getEnumerationId("CollectionKind");
    private static final @NonNull /*@NonInvalid*/ EnumerationLiteralId ELITid_Bag = ENUMid_CollectionKind.getEnumerationLiteralId("Bag");
    private static final @NonNull /*@NonInvalid*/ EnumerationLiteralId ELITid_Collection = ENUMid_CollectionKind.getEnumerationLiteralId("Collection");
    private static final @NonNull /*@NonInvalid*/ EnumerationLiteralId ELITid_OrderedSet = ENUMid_CollectionKind.getEnumerationLiteralId("OrderedSet");
    private static final @NonNull /*@NonInvalid*/ EnumerationLiteralId ELITid_Sequence = ENUMid_CollectionKind.getEnumerationLiteralId("Sequence");
    private static final @NonNull /*@NonInvalid*/ EnumerationLiteralId ELITid_Set = ENUMid_CollectionKind.getEnumerationLiteralId("Set");
    private static final @NonNull /*@NonInvalid*/ ClassId CLSSid_BagType = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("BagType");
    private static final @NonNull /*@NonInvalid*/ ClassId CLSSid_OrderedSetType = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("OrderedSetType");
    private static final @NonNull /*@NonInvalid*/ ClassId CLSSid_SequenceType = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("SequenceType");
    private static final @NonNull /*@NonInvalid*/ ClassId CLSSid_SetType = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("SetType");

    /**
     * Implementation of the CollectionLiteralExp 'BagKindIsBag' <invariant>
     * 
     * kind = CollectionKind::Bag implies type.oclIsKindOf(BagType)
     */
    public static class _invariant_BagKindIsBag extends AbstractUnaryOperation
    {
        public static final @NonNull _invariant_BagKindIsBag INSTANCE = new _invariant_BagKindIsBag();

        @Override
        public @NonNull /*@Thrown*/ Boolean evaluate(final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator, final @NonNull /*@NonInvalid*/ TypeId returnTypeId, final @Nullable /*@NonInvalid*/ Object self) throws Exception {
            final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
            final @NonNull /*@NonInvalid*/ EnumerationLiteralValue symbol_0 = createEnumerationLiteralValue(idResolver.getEnumerationLiteral(ELITid_Bag, null));
            final @NonNull /*@NonInvalid*/ DomainType TYP_pivot_c_c_BagType = idResolver.getType(CLSSid_BagType, null);
            @NonNull /*@Caught*/ Object _q;
            try {
                if (self == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ CollectionKind kind = ((CollectionLiteralExp)self).getKind();
                final @Nullable /*@Thrown*/ EnumerationLiteralValue BOXED_kind = kind == null ? null : createEnumerationLiteralValue(idResolver.getEnumerationLiteral(ENUMid_CollectionKind.getEnumerationLiteralId(kind.getName()), null));
                _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, BOXED_kind, symbol_0);
            } catch (Exception e) { _q = createInvalidValue(e); }
            @NonNull /*@Caught*/ Object oclIsKindOf;
            try {
                @Nullable /*@Caught*/ Object type;
                try {
                    if (self == null) throw new InvalidValueException(null, "");
                    type = ((DomainTypedElement)self).getType();
                } catch (Exception e_0) { type = createInvalidValue(e_0); }
                oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type, TYP_pivot_c_c_BagType);
            } catch (Exception e_1) { oclIsKindOf = createInvalidValue(e_1); }
            final @Nullable /*@Thrown*/ Boolean result = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, oclIsKindOf);
            if (result == null) throw new InvalidValueException(null, "");
            return result;
        }
    }

    /**
     * Implementation of the CollectionLiteralExp 'CollectionKindIsConcrete' <invariant>
     * 
     * kind <> CollectionKind::Collection
     */
    public static class _invariant_CollectionKindIsConcrete extends AbstractUnaryOperation
    {
        public static final @NonNull _invariant_CollectionKindIsConcrete INSTANCE = new _invariant_CollectionKindIsConcrete();

        @Override
        public @NonNull /*@Thrown*/ Boolean evaluate(final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator, final @NonNull /*@NonInvalid*/ TypeId returnTypeId, final @Nullable /*@NonInvalid*/ Object self) throws Exception {
            final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
            final @NonNull /*@NonInvalid*/ EnumerationLiteralValue symbol_1 = createEnumerationLiteralValue(idResolver.getEnumerationLiteral(ELITid_Collection, null));
            if (self == null) throw new InvalidValueException(null, "");
            final @Nullable /*@Thrown*/ CollectionKind kind = ((CollectionLiteralExp)self).getKind();
            final @Nullable /*@Thrown*/ EnumerationLiteralValue BOXED_kind = kind == null ? null : createEnumerationLiteralValue(idResolver.getEnumerationLiteral(ENUMid_CollectionKind.getEnumerationLiteralId(kind.getName()), null));
            final @NonNull /*@Thrown*/ Boolean result = OclAnyNotEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, BOXED_kind, symbol_1);
            return result;
        }
    }

    /**
     * Implementation of the CollectionLiteralExp 'OrderedSetKindIsOrderedSet' <invariant>
     * 
     * kind = CollectionKind::OrderedSet implies
     * type.oclIsKindOf(OrderedSetType)
     */
    public static class _invariant_OrderedSetKindIsOrderedSet extends AbstractUnaryOperation
    {
        public static final @NonNull _invariant_OrderedSetKindIsOrderedSet INSTANCE = new _invariant_OrderedSetKindIsOrderedSet();

        @Override
        public @NonNull /*@Thrown*/ Boolean evaluate(final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator, final @NonNull /*@NonInvalid*/ TypeId returnTypeId, final @Nullable /*@NonInvalid*/ Object self) throws Exception {
            final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
            final @NonNull /*@NonInvalid*/ EnumerationLiteralValue symbol_2 = createEnumerationLiteralValue(idResolver.getEnumerationLiteral(ELITid_OrderedSet, null));
            final @NonNull /*@NonInvalid*/ DomainType TYP_pivot_c_c_OrderedSetType = idResolver.getType(CLSSid_OrderedSetType, null);
            @NonNull /*@Caught*/ Object _q;
            try {
                if (self == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ CollectionKind kind = ((CollectionLiteralExp)self).getKind();
                final @Nullable /*@Thrown*/ EnumerationLiteralValue BOXED_kind = kind == null ? null : createEnumerationLiteralValue(idResolver.getEnumerationLiteral(ENUMid_CollectionKind.getEnumerationLiteralId(kind.getName()), null));
                _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, BOXED_kind, symbol_2);
            } catch (Exception e) { _q = createInvalidValue(e); }
            @NonNull /*@Caught*/ Object oclIsKindOf;
            try {
                @Nullable /*@Caught*/ Object type;
                try {
                    if (self == null) throw new InvalidValueException(null, "");
                    type = ((DomainTypedElement)self).getType();
                } catch (Exception e_0) { type = createInvalidValue(e_0); }
                oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type, TYP_pivot_c_c_OrderedSetType);
            } catch (Exception e_1) { oclIsKindOf = createInvalidValue(e_1); }
            final @Nullable /*@Thrown*/ Boolean result = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, oclIsKindOf);
            if (result == null) throw new InvalidValueException(null, "");
            return result;
        }
    }

    /**
     * Implementation of the CollectionLiteralExp 'SequenceKindIsSequence' <invariant>
     * 
     * kind = CollectionKind::Sequence implies
     * type.oclIsKindOf(SequenceType)
     */
    public static class _invariant_SequenceKindIsSequence extends AbstractUnaryOperation
    {
        public static final @NonNull _invariant_SequenceKindIsSequence INSTANCE = new _invariant_SequenceKindIsSequence();

        @Override
        public @NonNull /*@Thrown*/ Boolean evaluate(final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator, final @NonNull /*@NonInvalid*/ TypeId returnTypeId, final @Nullable /*@NonInvalid*/ Object self) throws Exception {
            final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
            final @NonNull /*@NonInvalid*/ EnumerationLiteralValue symbol_3 = createEnumerationLiteralValue(idResolver.getEnumerationLiteral(ELITid_Sequence, null));
            final @NonNull /*@NonInvalid*/ DomainType TYP_pivot_c_c_SequenceType = idResolver.getType(CLSSid_SequenceType, null);
            @NonNull /*@Caught*/ Object _q;
            try {
                if (self == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ CollectionKind kind = ((CollectionLiteralExp)self).getKind();
                final @Nullable /*@Thrown*/ EnumerationLiteralValue BOXED_kind = kind == null ? null : createEnumerationLiteralValue(idResolver.getEnumerationLiteral(ENUMid_CollectionKind.getEnumerationLiteralId(kind.getName()), null));
                _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, BOXED_kind, symbol_3);
            } catch (Exception e) { _q = createInvalidValue(e); }
            @NonNull /*@Caught*/ Object oclIsKindOf;
            try {
                @Nullable /*@Caught*/ Object type;
                try {
                    if (self == null) throw new InvalidValueException(null, "");
                    type = ((DomainTypedElement)self).getType();
                } catch (Exception e_0) { type = createInvalidValue(e_0); }
                oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type, TYP_pivot_c_c_SequenceType);
            } catch (Exception e_1) { oclIsKindOf = createInvalidValue(e_1); }
            final @Nullable /*@Thrown*/ Boolean result = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, oclIsKindOf);
            if (result == null) throw new InvalidValueException(null, "");
            return result;
        }
    }

    /**
     * Implementation of the CollectionLiteralExp 'SetKindIsSet' <invariant>
     * 
     * kind = CollectionKind::Set implies type.oclIsKindOf(SetType)
     */
    public static class _invariant_SetKindIsSet extends AbstractUnaryOperation
    {
        public static final @NonNull _invariant_SetKindIsSet INSTANCE = new _invariant_SetKindIsSet();

        @Override
        public @NonNull /*@Thrown*/ Boolean evaluate(final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator, final @NonNull /*@NonInvalid*/ TypeId returnTypeId, final @Nullable /*@NonInvalid*/ Object self) throws Exception {
            final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
            final @NonNull /*@NonInvalid*/ EnumerationLiteralValue symbol_4 = createEnumerationLiteralValue(idResolver.getEnumerationLiteral(ELITid_Set, null));
            final @NonNull /*@NonInvalid*/ DomainType TYP_pivot_c_c_SetType = idResolver.getType(CLSSid_SetType, null);
            @NonNull /*@Caught*/ Object _q;
            try {
                if (self == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ CollectionKind kind = ((CollectionLiteralExp)self).getKind();
                final @Nullable /*@Thrown*/ EnumerationLiteralValue BOXED_kind = kind == null ? null : createEnumerationLiteralValue(idResolver.getEnumerationLiteral(ENUMid_CollectionKind.getEnumerationLiteralId(kind.getName()), null));
                _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, BOXED_kind, symbol_4);
            } catch (Exception e) { _q = createInvalidValue(e); }
            @NonNull /*@Caught*/ Object oclIsKindOf;
            try {
                @Nullable /*@Caught*/ Object type;
                try {
                    if (self == null) throw new InvalidValueException(null, "");
                    type = ((DomainTypedElement)self).getType();
                } catch (Exception e_0) { type = createInvalidValue(e_0); }
                oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type, TYP_pivot_c_c_SetType);
            } catch (Exception e_1) { oclIsKindOf = createInvalidValue(e_1); }
            final @Nullable /*@Thrown*/ Boolean result = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, oclIsKindOf);
            if (result == null) throw new InvalidValueException(null, "");
            return result;
        }
    }
}
