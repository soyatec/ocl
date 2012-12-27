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
import java.lang.String;
import java.util.Iterator;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainCallExp;
import org.eclipse.ocl.examples.domain.elements.DomainCollectionType;
import org.eclipse.ocl.examples.domain.elements.DomainExpression;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.elements.DomainTypedElement;
import org.eclipse.ocl.examples.domain.elements.Nameable;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.ClassId;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.PackageId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractUnaryOperation;
import org.eclipse.ocl.examples.domain.types.IdResolver;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.library.collection.CollectionSizeOperation;
import org.eclipse.ocl.examples.library.logical.BooleanImpliesOperation;
import org.eclipse.ocl.examples.library.logical.BooleanOrOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyOclAsTypeOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.examples.pivot.LoopExp;
import org.eclipse.ocl.examples.pivot.OCLExpression;

@SuppressWarnings("nls")
public class IteratorExpBodies extends ValuesUtil
{
    private static final @NonNull /*@NonInvalid*/ String STR_any = "any";
    private static final @NonNull /*@NonInvalid*/ String STR_Boolean = "Boolean";
    private static final @NonNull /*@NonInvalid*/ IntegerValue INT_1 = integerValueOf(1);
    private static final @NonNull /*@NonInvalid*/ PackageId PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot = IdManager.INSTANCE.getNsURIPackageId("http://www.eclipse.org/ocl/3.1.0/Pivot", org.eclipse.ocl.examples.pivot.PivotPackage.eINSTANCE);
    private static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Variable = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("Variable");
    private static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Variable = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Variable);
    private static final @NonNull /*@NonInvalid*/ ClassId CLSSid_CollectionType = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("CollectionType");
    private static final @NonNull /*@NonInvalid*/ ClassId CLSSid_SequenceType = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("SequenceType");
    private static final @NonNull /*@NonInvalid*/ ClassId CLSSid_OrderedSetType = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("OrderedSetType");
    private static final @NonNull /*@NonInvalid*/ ClassId CLSSid_SetType = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("SetType");
    private static final @NonNull /*@NonInvalid*/ ClassId CLSSid_BagType = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("BagType");
    private static final @NonNull /*@NonInvalid*/ String STR_closure = "closure";
    private static final @NonNull /*@NonInvalid*/ String STR_collect = "collect";
    private static final @NonNull /*@NonInvalid*/ String STR_collectNested = "collectNested";
    private static final @NonNull /*@NonInvalid*/ String STR_exists = "exists";
    private static final @NonNull /*@NonInvalid*/ String STR_forAll = "forAll";
    private static final @NonNull /*@NonInvalid*/ String STR_isUnique = "isUnique";
    private static final @NonNull /*@NonInvalid*/ String STR_one = "one";
    private static final @NonNull /*@NonInvalid*/ String STR_reject = "reject";
    private static final @NonNull /*@NonInvalid*/ String STR_select = "select";
    private static final @NonNull /*@NonInvalid*/ String STR_sortedBy = "sortedBy";

    /**
     * Implementation of the IteratorExp 'AnyBodyTypeIsBoolean' <invariant>
     * 
     * name = 'any' implies body.type = 'Boolean'
     */
    public static class _invariant_AnyBodyTypeIsBoolean extends AbstractUnaryOperation
    {
        public static final @NonNull _invariant_AnyBodyTypeIsBoolean INSTANCE = new _invariant_AnyBodyTypeIsBoolean();

        public @NonNull /*@Thrown*/ Boolean evaluate(final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator, final @NonNull /*@NonInvalid*/ TypeId returnTypeId, final @Nullable /*@Caught*/ Object self) throws Exception {
            @NonNull /*@Caught*/ Object _q;
            try {
                if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                if (self == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ String name = ((Nameable)self).getName();
                _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, STR_any);
            } catch (Exception e) { _q = createInvalidValue(e); }
            @NonNull /*@Caught*/ Object _q_0;
            try {
                if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                if (self == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ OCLExpression body = ((LoopExp)self).getBody();
                if (body == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ DomainType type = body.getType();
                _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type, STR_Boolean);
            } catch (Exception e_0) { _q_0 = createInvalidValue(e_0); }
            final @Nullable /*@Thrown*/ Boolean result = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
            if (result == null) throw new InvalidValueException(null, "");
            return result;
        }
    }

    /**
     * Implementation of the IteratorExp 'AnyHasOneIterator' <invariant>
     * 
     * name = 'any' implies iterator->size() = 1
     */
    public static class _invariant_AnyHasOneIterator extends AbstractUnaryOperation
    {
        public static final @NonNull _invariant_AnyHasOneIterator INSTANCE = new _invariant_AnyHasOneIterator();

        public @NonNull /*@Thrown*/ Boolean evaluate(final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator, final @NonNull /*@NonInvalid*/ TypeId returnTypeId, final @Nullable /*@Caught*/ Object self) throws Exception {
            @NonNull /*@Caught*/ Object _q;
            try {
                if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                if (self == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ String name = ((Nameable)self).getName();
                _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, STR_any);
            } catch (Exception e) { _q = createInvalidValue(e); }
            @NonNull /*@Caught*/ Object _q_0;
            try {
                if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                if (self == null) throw new InvalidValueException(null, "");
                final @SuppressWarnings("null")@NonNull /*@Thrown*/ EList<?> iterator = ((LoopExp)self).getIterator();
                final @NonNull /*@Thrown*/ CollectionValue BOXED_iterator = createCollectionValue(ORD_CLSSid_Variable, iterator);
                final @NonNull /*@Thrown*/ IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(evaluator, TypeId.INTEGER, BOXED_iterator);
                _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, size, INT_1);
            } catch (Exception e_0) { _q_0 = createInvalidValue(e_0); }
            final @Nullable /*@Thrown*/ Boolean result = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
            if (result == null) throw new InvalidValueException(null, "");
            return result;
        }
    }

    /**
     * Implementation of the IteratorExp 'AnyTypeIsSourceElementType' <invariant>
     * 
     * name = 'any' implies type = source.type.oclAsType(CollectionType).elementType
     */
    public static class _invariant_AnyTypeIsSourceElementType extends AbstractUnaryOperation
    {
        public static final @NonNull _invariant_AnyTypeIsSourceElementType INSTANCE = new _invariant_AnyTypeIsSourceElementType();

        public @NonNull /*@Thrown*/ Boolean evaluate(final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator, final @NonNull /*@NonInvalid*/ TypeId returnTypeId, final @Nullable /*@Caught*/ Object self) throws Exception {
            final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
            final @NonNull /*@NonInvalid*/ DomainType TYP_pivot_c_c_CollectionType = idResolver.getType(CLSSid_CollectionType, null);
            @NonNull /*@Caught*/ Object _q;
            try {
                if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                if (self == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ String name = ((Nameable)self).getName();
                _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, STR_any);
            } catch (Exception e) { _q = createInvalidValue(e); }
            @NonNull /*@Caught*/ Object _q_0;
            try {
                if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                if (self == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ DomainType type = ((DomainTypedElement)self).getType();
                if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                if (self == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ DomainExpression source = ((DomainCallExp)self).getSource();
                if (source == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ DomainType type_0 = source.getType();
                final @Nullable /*@Thrown*/ Object oclAsType = OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, CLSSid_CollectionType, type_0, TYP_pivot_c_c_CollectionType);
                if (oclAsType == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ DomainType elementType = ((DomainCollectionType)oclAsType).getElementType();
                _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type, elementType);
            } catch (Exception e_0) { _q_0 = createInvalidValue(e_0); }
            final @Nullable /*@Thrown*/ Boolean result = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
            if (result == null) throw new InvalidValueException(null, "");
            return result;
        }
    }

    /**
     * Implementation of the IteratorExp 'ClosureBodyTypeIsConformanttoIteratorType' <invariant>
     * 
     * true
     */
    public static class _invariant_ClosureBodyTypeIsConformanttoIteratorType extends AbstractUnaryOperation
    {
        public static final @NonNull _invariant_ClosureBodyTypeIsConformanttoIteratorType INSTANCE = new _invariant_ClosureBodyTypeIsConformanttoIteratorType();

        public @NonNull /*@Thrown*/ Boolean evaluate(final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator, final @NonNull /*@NonInvalid*/ TypeId returnTypeId, final @Nullable /*@Thrown*/ Object self) throws Exception {
            return TRUE_VALUE;
        }
    }

    /**
     * Implementation of the IteratorExp 'ClosureElementTypeIsSourceElementType' <invariant>
     * 
     * name = 'closure' implies
     * type.oclAsType(CollectionType).elementType =
     * source.type.oclAsType(CollectionType).elementType
     */
    public static class _invariant_ClosureElementTypeIsSourceElementType extends AbstractUnaryOperation
    {
        public static final @NonNull _invariant_ClosureElementTypeIsSourceElementType INSTANCE = new _invariant_ClosureElementTypeIsSourceElementType();

        public @NonNull /*@Thrown*/ Boolean evaluate(final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator, final @NonNull /*@NonInvalid*/ TypeId returnTypeId, final @Nullable /*@Caught*/ Object self) throws Exception {
            final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
            final @NonNull /*@NonInvalid*/ DomainType TYP_pivot_c_c_CollectionType = idResolver.getType(CLSSid_CollectionType, null);
            @NonNull /*@Caught*/ Object _q;
            try {
                if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                if (self == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ String name = ((Nameable)self).getName();
                _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, STR_closure);
            } catch (Exception e) { _q = createInvalidValue(e); }
            @NonNull /*@Caught*/ Object _q_0;
            try {
                if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                if (self == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ DomainType type = ((DomainTypedElement)self).getType();
                final @Nullable /*@Thrown*/ Object oclAsType = OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, CLSSid_CollectionType, type, TYP_pivot_c_c_CollectionType);
                if (oclAsType == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ DomainType elementType = ((DomainCollectionType)oclAsType).getElementType();
                if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                if (self == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ DomainExpression source = ((DomainCallExp)self).getSource();
                if (source == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ DomainType type_0 = source.getType();
                final @Nullable /*@Thrown*/ Object oclAsType_0 = OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, CLSSid_CollectionType, type_0, TYP_pivot_c_c_CollectionType);
                if (oclAsType_0 == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ DomainType elementType_0 = ((DomainCollectionType)oclAsType_0).getElementType();
                _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, elementType, elementType_0);
            } catch (Exception e_0) { _q_0 = createInvalidValue(e_0); }
            final @Nullable /*@Thrown*/ Boolean result = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
            if (result == null) throw new InvalidValueException(null, "");
            return result;
        }
    }

    /**
     * Implementation of the IteratorExp 'ClosureHasOneIterator' <invariant>
     * 
     * name = 'closure' implies iterator->size() = 1
     */
    public static class _invariant_ClosureHasOneIterator extends AbstractUnaryOperation
    {
        public static final @NonNull _invariant_ClosureHasOneIterator INSTANCE = new _invariant_ClosureHasOneIterator();

        public @NonNull /*@Thrown*/ Boolean evaluate(final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator, final @NonNull /*@NonInvalid*/ TypeId returnTypeId, final @Nullable /*@Caught*/ Object self) throws Exception {
            @NonNull /*@Caught*/ Object _q;
            try {
                if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                if (self == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ String name = ((Nameable)self).getName();
                _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, STR_closure);
            } catch (Exception e) { _q = createInvalidValue(e); }
            @NonNull /*@Caught*/ Object _q_0;
            try {
                if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                if (self == null) throw new InvalidValueException(null, "");
                final @SuppressWarnings("null")@NonNull /*@Thrown*/ EList<?> iterator = ((LoopExp)self).getIterator();
                final @NonNull /*@Thrown*/ CollectionValue BOXED_iterator = createCollectionValue(ORD_CLSSid_Variable, iterator);
                final @NonNull /*@Thrown*/ IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(evaluator, TypeId.INTEGER, BOXED_iterator);
                _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, size, INT_1);
            } catch (Exception e_0) { _q_0 = createInvalidValue(e_0); }
            final @Nullable /*@Thrown*/ Boolean result = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
            if (result == null) throw new InvalidValueException(null, "");
            return result;
        }
    }

    /**
     * Implementation of the IteratorExp 'ClosureSourceElementTypeIsBodyElementType' <invariant>
     * 
     * name = 'closure' implies
     * source.type.oclAsType(CollectionType).elementType =
     * if body.type.oclIsKindOf(CollectionType)
     * then body.type.oclAsType(CollectionType).elementType
     * else body.type
     * endif
     */
    public static class _invariant_ClosureSourceElementTypeIsBodyElementType extends AbstractUnaryOperation
    {
        public static final @NonNull _invariant_ClosureSourceElementTypeIsBodyElementType INSTANCE = new _invariant_ClosureSourceElementTypeIsBodyElementType();

        public @NonNull /*@Thrown*/ Boolean evaluate(final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator, final @NonNull /*@NonInvalid*/ TypeId returnTypeId, final @Nullable /*@Caught*/ Object self) throws Exception {
            final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
            final @NonNull /*@NonInvalid*/ DomainType TYP_pivot_c_c_CollectionType = idResolver.getType(CLSSid_CollectionType, null);
            @NonNull /*@Caught*/ Object _q;
            try {
                if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                if (self == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ String name = ((Nameable)self).getName();
                _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, STR_closure);
            } catch (Exception e) { _q = createInvalidValue(e); }
            @NonNull /*@Caught*/ Object _q_0;
            try {
                if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                if (self == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ DomainExpression source = ((DomainCallExp)self).getSource();
                if (source == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ DomainType type = source.getType();
                final @Nullable /*@Thrown*/ Object oclAsType = OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, CLSSid_CollectionType, type, TYP_pivot_c_c_CollectionType);
                if (oclAsType == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ DomainType elementType = ((DomainCollectionType)oclAsType).getElementType();
                @Nullable /*@Thrown*/ Object symbol_0;
                @Nullable /*@Caught*/ Object type_0;
                try {
                    if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                    if (self == null) throw new InvalidValueException(null, "");
                    final @Nullable /*@Thrown*/ OCLExpression body = ((LoopExp)self).getBody();
                    if (body == null) throw new InvalidValueException(null, "");
                    type_0 = body.getType();
                } catch (Exception e_0) { type_0 = createInvalidValue(e_0); }
                final @NonNull /*@Thrown*/ Boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type_0, TYP_pivot_c_c_CollectionType);
                if (oclIsKindOf == TRUE_VALUE) {
                    if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                    if (self == null) throw new InvalidValueException(null, "");
                    final @Nullable /*@Thrown*/ OCLExpression body_0 = ((LoopExp)self).getBody();
                    if (body_0 == null) throw new InvalidValueException(null, "");
                    final @Nullable /*@Thrown*/ DomainType type_1 = body_0.getType();
                    final @Nullable /*@Thrown*/ Object oclAsType_0 = OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, CLSSid_CollectionType, type_1, TYP_pivot_c_c_CollectionType);
                    if (oclAsType_0 == null) throw new InvalidValueException(null, "");
                    final @Nullable /*@Thrown*/ DomainType elementType_0 = ((DomainCollectionType)oclAsType_0).getElementType();
                    symbol_0 = elementType_0;
                }
                else if (oclIsKindOf == FALSE_VALUE) {
                    if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                    if (self == null) throw new InvalidValueException(null, "");
                    final @Nullable /*@Thrown*/ OCLExpression body_1 = ((LoopExp)self).getBody();
                    if (body_1 == null) throw new InvalidValueException(null, "");
                    final @Nullable /*@Thrown*/ DomainType type_2 = body_1.getType();
                    symbol_0 = type_2;
                }
                else {
                    throw INVALID_VALUE;
                }
                _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, elementType, symbol_0);
            } catch (Exception e_1) { _q_0 = createInvalidValue(e_1); }
            final @Nullable /*@Thrown*/ Boolean result = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
            if (result == null) throw new InvalidValueException(null, "");
            return result;
        }
    }

    /**
     * Implementation of the IteratorExp 'ClosureTypeIsUniqueCollection' <invariant>
     * 
     * name = 'closure' implies
     * if
     *   source.type.oclIsKindOf(SequenceType) or
     *   source.type.oclIsKindOf(OrderedSetType)
     * then type.oclIsKindOf(OrderedSetType)
     * else type.oclIsKindOf(SetType)
     * endif
     */
    public static class _invariant_ClosureTypeIsUniqueCollection extends AbstractUnaryOperation
    {
        public static final @NonNull _invariant_ClosureTypeIsUniqueCollection INSTANCE = new _invariant_ClosureTypeIsUniqueCollection();

        public @NonNull /*@Thrown*/ Boolean evaluate(final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator, final @NonNull /*@NonInvalid*/ TypeId returnTypeId, final @Nullable /*@Caught*/ Object self) throws Exception {
            final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
            final @NonNull /*@NonInvalid*/ DomainType TYP_pivot_c_c_SequenceType = idResolver.getType(CLSSid_SequenceType, null);
            final @NonNull /*@NonInvalid*/ DomainType TYP_pivot_c_c_OrderedSetType = idResolver.getType(CLSSid_OrderedSetType, null);
            final @NonNull /*@NonInvalid*/ DomainType TYP_pivot_c_c_SetType = idResolver.getType(CLSSid_SetType, null);
            @NonNull /*@Caught*/ Object _q;
            try {
                if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                if (self == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ String name = ((Nameable)self).getName();
                _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, STR_closure);
            } catch (Exception e) { _q = createInvalidValue(e); }
            @Nullable /*@Caught*/ Object symbol_0;
            try {
                @NonNull /*@Caught*/ Object oclIsKindOf;
                try {
                    @Nullable /*@Caught*/ Object type;
                    try {
                        if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                        if (self == null) throw new InvalidValueException(null, "");
                        final @Nullable /*@Thrown*/ DomainExpression source = ((DomainCallExp)self).getSource();
                        if (source == null) throw new InvalidValueException(null, "");
                        type = source.getType();
                    } catch (Exception e_1) { type = createInvalidValue(e_1); }
                    oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type, TYP_pivot_c_c_SequenceType);
                } catch (Exception e_2) { oclIsKindOf = createInvalidValue(e_2); }
                @NonNull /*@Caught*/ Object oclIsKindOf_0;
                try {
                    @Nullable /*@Caught*/ Object type_0;
                    try {
                        if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                        if (self == null) throw new InvalidValueException(null, "");
                        final @Nullable /*@Thrown*/ DomainExpression source_0 = ((DomainCallExp)self).getSource();
                        if (source_0 == null) throw new InvalidValueException(null, "");
                        type_0 = source_0.getType();
                    } catch (Exception e_3) { type_0 = createInvalidValue(e_3); }
                    oclIsKindOf_0 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type_0, TYP_pivot_c_c_OrderedSetType);
                } catch (Exception e_4) { oclIsKindOf_0 = createInvalidValue(e_4); }
                final @Nullable /*@Thrown*/ Boolean or = BooleanOrOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, oclIsKindOf, oclIsKindOf_0);
                if (or == TRUE_VALUE) {
                    @Nullable /*@Caught*/ Object type_1;
                    try {
                        if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                        if (self == null) throw new InvalidValueException(null, "");
                        type_1 = ((DomainTypedElement)self).getType();
                    } catch (Exception e_5) { type_1 = createInvalidValue(e_5); }
                    final @NonNull /*@Thrown*/ Boolean oclIsKindOf_1 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type_1, TYP_pivot_c_c_OrderedSetType);
                    symbol_0 = oclIsKindOf_1;
                }
                else if (or == FALSE_VALUE) {
                    @Nullable /*@Caught*/ Object type_2;
                    try {
                        if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                        if (self == null) throw new InvalidValueException(null, "");
                        type_2 = ((DomainTypedElement)self).getType();
                    } catch (Exception e_6) { type_2 = createInvalidValue(e_6); }
                    final @NonNull /*@Thrown*/ Boolean oclIsKindOf_2 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type_2, TYP_pivot_c_c_SetType);
                    symbol_0 = oclIsKindOf_2;
                }
                else {
                    throw INVALID_VALUE;
                }
                ;
            } catch (Exception e_0) { symbol_0 = createInvalidValue(e_0); }
            final @Nullable /*@Thrown*/ Boolean result = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, symbol_0);
            if (result == null) throw new InvalidValueException(null, "");
            return result;
        }
    }

    /**
     * Implementation of the IteratorExp 'CollectElementTypeIsSourceElementType' <invariant>
     * 
     * name = 'collect' implies
     * type.oclAsType(CollectionType).elementType =
     * body.type.oclAsType(CollectionType).elementType
     */
    public static class _invariant_CollectElementTypeIsSourceElementType extends AbstractUnaryOperation
    {
        public static final @NonNull _invariant_CollectElementTypeIsSourceElementType INSTANCE = new _invariant_CollectElementTypeIsSourceElementType();

        public @NonNull /*@Thrown*/ Boolean evaluate(final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator, final @NonNull /*@NonInvalid*/ TypeId returnTypeId, final @Nullable /*@Caught*/ Object self) throws Exception {
            final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
            final @NonNull /*@NonInvalid*/ DomainType TYP_pivot_c_c_CollectionType = idResolver.getType(CLSSid_CollectionType, null);
            @NonNull /*@Caught*/ Object _q;
            try {
                if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                if (self == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ String name = ((Nameable)self).getName();
                _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, STR_collect);
            } catch (Exception e) { _q = createInvalidValue(e); }
            @NonNull /*@Caught*/ Object _q_0;
            try {
                if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                if (self == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ DomainType type = ((DomainTypedElement)self).getType();
                final @Nullable /*@Thrown*/ Object oclAsType = OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, CLSSid_CollectionType, type, TYP_pivot_c_c_CollectionType);
                if (oclAsType == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ DomainType elementType = ((DomainCollectionType)oclAsType).getElementType();
                if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                if (self == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ OCLExpression body = ((LoopExp)self).getBody();
                if (body == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ DomainType type_0 = body.getType();
                final @Nullable /*@Thrown*/ Object oclAsType_0 = OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, CLSSid_CollectionType, type_0, TYP_pivot_c_c_CollectionType);
                if (oclAsType_0 == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ DomainType elementType_0 = ((DomainCollectionType)oclAsType_0).getElementType();
                _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, elementType, elementType_0);
            } catch (Exception e_0) { _q_0 = createInvalidValue(e_0); }
            final @Nullable /*@Thrown*/ Boolean result = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
            if (result == null) throw new InvalidValueException(null, "");
            return result;
        }
    }

    /**
     * Implementation of the IteratorExp 'CollectHasOneIterator' <invariant>
     * 
     * name = 'collect' implies iterator->size() = 1
     */
    public static class _invariant_CollectHasOneIterator extends AbstractUnaryOperation
    {
        public static final @NonNull _invariant_CollectHasOneIterator INSTANCE = new _invariant_CollectHasOneIterator();

        public @NonNull /*@Thrown*/ Boolean evaluate(final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator, final @NonNull /*@NonInvalid*/ TypeId returnTypeId, final @Nullable /*@Caught*/ Object self) throws Exception {
            @NonNull /*@Caught*/ Object _q;
            try {
                if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                if (self == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ String name = ((Nameable)self).getName();
                _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, STR_collect);
            } catch (Exception e) { _q = createInvalidValue(e); }
            @NonNull /*@Caught*/ Object _q_0;
            try {
                if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                if (self == null) throw new InvalidValueException(null, "");
                final @SuppressWarnings("null")@NonNull /*@Thrown*/ EList<?> iterator = ((LoopExp)self).getIterator();
                final @NonNull /*@Thrown*/ CollectionValue BOXED_iterator = createCollectionValue(ORD_CLSSid_Variable, iterator);
                final @NonNull /*@Thrown*/ IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(evaluator, TypeId.INTEGER, BOXED_iterator);
                _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, size, INT_1);
            } catch (Exception e_0) { _q_0 = createInvalidValue(e_0); }
            final @Nullable /*@Thrown*/ Boolean result = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
            if (result == null) throw new InvalidValueException(null, "");
            return result;
        }
    }

    /**
     * Implementation of the IteratorExp 'CollectNestedHasOneIterator' <invariant>
     * 
     * name = 'collectNested' implies iterator->size() = 1
     */
    public static class _invariant_CollectNestedHasOneIterator extends AbstractUnaryOperation
    {
        public static final @NonNull _invariant_CollectNestedHasOneIterator INSTANCE = new _invariant_CollectNestedHasOneIterator();

        public @NonNull /*@Thrown*/ Boolean evaluate(final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator, final @NonNull /*@NonInvalid*/ TypeId returnTypeId, final @Nullable /*@Caught*/ Object self) throws Exception {
            @NonNull /*@Caught*/ Object _q;
            try {
                if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                if (self == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ String name = ((Nameable)self).getName();
                _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, STR_collectNested);
            } catch (Exception e) { _q = createInvalidValue(e); }
            @NonNull /*@Caught*/ Object _q_0;
            try {
                if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                if (self == null) throw new InvalidValueException(null, "");
                final @SuppressWarnings("null")@NonNull /*@Thrown*/ EList<?> iterator = ((LoopExp)self).getIterator();
                final @NonNull /*@Thrown*/ CollectionValue BOXED_iterator = createCollectionValue(ORD_CLSSid_Variable, iterator);
                final @NonNull /*@Thrown*/ IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(evaluator, TypeId.INTEGER, BOXED_iterator);
                _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, size, INT_1);
            } catch (Exception e_0) { _q_0 = createInvalidValue(e_0); }
            final @Nullable /*@Thrown*/ Boolean result = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
            if (result == null) throw new InvalidValueException(null, "");
            return result;
        }
    }

    /**
     * Implementation of the IteratorExp 'CollectNestedTypeIsBag' <invariant>
     * 
     * name = 'collectNested' implies type.oclIsKindOf(BagType)
     */
    public static class _invariant_CollectNestedTypeIsBag extends AbstractUnaryOperation
    {
        public static final @NonNull _invariant_CollectNestedTypeIsBag INSTANCE = new _invariant_CollectNestedTypeIsBag();

        public @NonNull /*@Thrown*/ Boolean evaluate(final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator, final @NonNull /*@NonInvalid*/ TypeId returnTypeId, final @Nullable /*@Caught*/ Object self) throws Exception {
            final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
            final @NonNull /*@NonInvalid*/ DomainType TYP_pivot_c_c_BagType = idResolver.getType(CLSSid_BagType, null);
            @NonNull /*@Caught*/ Object _q;
            try {
                if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                if (self == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ String name = ((Nameable)self).getName();
                _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, STR_collectNested);
            } catch (Exception e) { _q = createInvalidValue(e); }
            @NonNull /*@Caught*/ Object oclIsKindOf;
            try {
                @Nullable /*@Caught*/ Object type;
                try {
                    if (self instanceof InvalidValueException) throw (InvalidValueException)self;
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
     * Implementation of the IteratorExp 'CollectNestedTypeIsBodyType' <invariant>
     * 
     * name = 'collectNested' implies type = body.type
     */
    public static class _invariant_CollectNestedTypeIsBodyType extends AbstractUnaryOperation
    {
        public static final @NonNull _invariant_CollectNestedTypeIsBodyType INSTANCE = new _invariant_CollectNestedTypeIsBodyType();

        public @NonNull /*@Thrown*/ Boolean evaluate(final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator, final @NonNull /*@NonInvalid*/ TypeId returnTypeId, final @Nullable /*@Caught*/ Object self) throws Exception {
            @NonNull /*@Caught*/ Object _q;
            try {
                if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                if (self == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ String name = ((Nameable)self).getName();
                _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, STR_collectNested);
            } catch (Exception e) { _q = createInvalidValue(e); }
            @NonNull /*@Caught*/ Object _q_0;
            try {
                if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                if (self == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ DomainType type = ((DomainTypedElement)self).getType();
                if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                if (self == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ OCLExpression body = ((LoopExp)self).getBody();
                if (body == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ DomainType type_0 = body.getType();
                _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type, type_0);
            } catch (Exception e_0) { _q_0 = createInvalidValue(e_0); }
            final @Nullable /*@Thrown*/ Boolean result = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
            if (result == null) throw new InvalidValueException(null, "");
            return result;
        }
    }

    /**
     * Implementation of the IteratorExp 'CollectTypeIsUnordered' <invariant>
     * 
     * name = 'collect' implies
     * if
     *   source.type.oclIsKindOf(SequenceType) or
     *   source.type.oclIsKindOf(OrderedSetType)
     * then type.oclIsKindOf(SequenceType)
     * else type.oclIsKindOf(BagType)
     * endif
     */
    public static class _invariant_CollectTypeIsUnordered extends AbstractUnaryOperation
    {
        public static final @NonNull _invariant_CollectTypeIsUnordered INSTANCE = new _invariant_CollectTypeIsUnordered();

        public @NonNull /*@Thrown*/ Boolean evaluate(final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator, final @NonNull /*@NonInvalid*/ TypeId returnTypeId, final @Nullable /*@Caught*/ Object self) throws Exception {
            final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
            final @NonNull /*@NonInvalid*/ DomainType TYP_pivot_c_c_SequenceType = idResolver.getType(CLSSid_SequenceType, null);
            final @NonNull /*@NonInvalid*/ DomainType TYP_pivot_c_c_OrderedSetType = idResolver.getType(CLSSid_OrderedSetType, null);
            final @NonNull /*@NonInvalid*/ DomainType TYP_pivot_c_c_BagType = idResolver.getType(CLSSid_BagType, null);
            @NonNull /*@Caught*/ Object _q;
            try {
                if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                if (self == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ String name = ((Nameable)self).getName();
                _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, STR_collect);
            } catch (Exception e) { _q = createInvalidValue(e); }
            @Nullable /*@Caught*/ Object symbol_0;
            try {
                @NonNull /*@Caught*/ Object oclIsKindOf;
                try {
                    @Nullable /*@Caught*/ Object type;
                    try {
                        if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                        if (self == null) throw new InvalidValueException(null, "");
                        final @Nullable /*@Thrown*/ DomainExpression source = ((DomainCallExp)self).getSource();
                        if (source == null) throw new InvalidValueException(null, "");
                        type = source.getType();
                    } catch (Exception e_1) { type = createInvalidValue(e_1); }
                    oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type, TYP_pivot_c_c_SequenceType);
                } catch (Exception e_2) { oclIsKindOf = createInvalidValue(e_2); }
                @NonNull /*@Caught*/ Object oclIsKindOf_0;
                try {
                    @Nullable /*@Caught*/ Object type_0;
                    try {
                        if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                        if (self == null) throw new InvalidValueException(null, "");
                        final @Nullable /*@Thrown*/ DomainExpression source_0 = ((DomainCallExp)self).getSource();
                        if (source_0 == null) throw new InvalidValueException(null, "");
                        type_0 = source_0.getType();
                    } catch (Exception e_3) { type_0 = createInvalidValue(e_3); }
                    oclIsKindOf_0 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type_0, TYP_pivot_c_c_OrderedSetType);
                } catch (Exception e_4) { oclIsKindOf_0 = createInvalidValue(e_4); }
                final @Nullable /*@Thrown*/ Boolean or = BooleanOrOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, oclIsKindOf, oclIsKindOf_0);
                if (or == TRUE_VALUE) {
                    @Nullable /*@Caught*/ Object type_1;
                    try {
                        if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                        if (self == null) throw new InvalidValueException(null, "");
                        type_1 = ((DomainTypedElement)self).getType();
                    } catch (Exception e_5) { type_1 = createInvalidValue(e_5); }
                    final @NonNull /*@Thrown*/ Boolean oclIsKindOf_1 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type_1, TYP_pivot_c_c_SequenceType);
                    symbol_0 = oclIsKindOf_1;
                }
                else if (or == FALSE_VALUE) {
                    @Nullable /*@Caught*/ Object type_2;
                    try {
                        if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                        if (self == null) throw new InvalidValueException(null, "");
                        type_2 = ((DomainTypedElement)self).getType();
                    } catch (Exception e_6) { type_2 = createInvalidValue(e_6); }
                    final @NonNull /*@Thrown*/ Boolean oclIsKindOf_2 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type_2, TYP_pivot_c_c_BagType);
                    symbol_0 = oclIsKindOf_2;
                }
                else {
                    throw INVALID_VALUE;
                }
                ;
            } catch (Exception e_0) { symbol_0 = createInvalidValue(e_0); }
            final @Nullable /*@Thrown*/ Boolean result = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, symbol_0);
            if (result == null) throw new InvalidValueException(null, "");
            return result;
        }
    }

    /**
     * Implementation of the IteratorExp 'ExistsBodyTypeIsBoolean' <invariant>
     * 
     * name = 'exists' implies body.type = Boolean
     */
    public static class _invariant_ExistsBodyTypeIsBoolean extends AbstractUnaryOperation
    {
        public static final @NonNull _invariant_ExistsBodyTypeIsBoolean INSTANCE = new _invariant_ExistsBodyTypeIsBoolean();

        public @NonNull /*@Thrown*/ Boolean evaluate(final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator, final @NonNull /*@NonInvalid*/ TypeId returnTypeId, final @Nullable /*@Caught*/ Object self) throws Exception {
            final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
            final @NonNull /*@NonInvalid*/ DomainType TYP_Boolean = idResolver.getType(TypeId.BOOLEAN, null);
            @NonNull /*@Caught*/ Object _q;
            try {
                if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                if (self == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ String name = ((Nameable)self).getName();
                _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, STR_exists);
            } catch (Exception e) { _q = createInvalidValue(e); }
            @NonNull /*@Caught*/ Object _q_0;
            try {
                if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                if (self == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ OCLExpression body = ((LoopExp)self).getBody();
                if (body == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ DomainType type = body.getType();
                _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type, TYP_Boolean);
            } catch (Exception e_0) { _q_0 = createInvalidValue(e_0); }
            final @Nullable /*@Thrown*/ Boolean result = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
            if (result == null) throw new InvalidValueException(null, "");
            return result;
        }
    }

    /**
     * Implementation of the IteratorExp 'ExistsTypeIsBoolean' <invariant>
     * 
     * name = 'exists' implies type = Boolean
     */
    public static class _invariant_ExistsTypeIsBoolean extends AbstractUnaryOperation
    {
        public static final @NonNull _invariant_ExistsTypeIsBoolean INSTANCE = new _invariant_ExistsTypeIsBoolean();

        public @NonNull /*@Thrown*/ Boolean evaluate(final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator, final @NonNull /*@NonInvalid*/ TypeId returnTypeId, final @Nullable /*@Caught*/ Object self) throws Exception {
            final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
            final @NonNull /*@NonInvalid*/ DomainType TYP_Boolean = idResolver.getType(TypeId.BOOLEAN, null);
            @NonNull /*@Caught*/ Object _q;
            try {
                if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                if (self == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ String name = ((Nameable)self).getName();
                _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, STR_exists);
            } catch (Exception e) { _q = createInvalidValue(e); }
            @NonNull /*@Caught*/ Object _q_0;
            try {
                if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                if (self == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ DomainType type = ((DomainTypedElement)self).getType();
                _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type, TYP_Boolean);
            } catch (Exception e_0) { _q_0 = createInvalidValue(e_0); }
            final @Nullable /*@Thrown*/ Boolean result = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
            if (result == null) throw new InvalidValueException(null, "");
            return result;
        }
    }

    /**
     * Implementation of the IteratorExp 'ForAllBodyTypeIsBoolean' <invariant>
     * 
     * name = 'forAll' implies body.type = Boolean
     */
    public static class _invariant_ForAllBodyTypeIsBoolean extends AbstractUnaryOperation
    {
        public static final @NonNull _invariant_ForAllBodyTypeIsBoolean INSTANCE = new _invariant_ForAllBodyTypeIsBoolean();

        public @NonNull /*@Thrown*/ Boolean evaluate(final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator, final @NonNull /*@NonInvalid*/ TypeId returnTypeId, final @Nullable /*@Caught*/ Object self) throws Exception {
            final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
            final @NonNull /*@NonInvalid*/ DomainType TYP_Boolean = idResolver.getType(TypeId.BOOLEAN, null);
            @NonNull /*@Caught*/ Object _q;
            try {
                if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                if (self == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ String name = ((Nameable)self).getName();
                _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, STR_forAll);
            } catch (Exception e) { _q = createInvalidValue(e); }
            @NonNull /*@Caught*/ Object _q_0;
            try {
                if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                if (self == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ OCLExpression body = ((LoopExp)self).getBody();
                if (body == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ DomainType type = body.getType();
                _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type, TYP_Boolean);
            } catch (Exception e_0) { _q_0 = createInvalidValue(e_0); }
            final @Nullable /*@Thrown*/ Boolean result = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
            if (result == null) throw new InvalidValueException(null, "");
            return result;
        }
    }

    /**
     * Implementation of the IteratorExp 'ForAllTypeIsBoolean' <invariant>
     * 
     * name = 'forAll' implies type = Boolean
     */
    public static class _invariant_ForAllTypeIsBoolean extends AbstractUnaryOperation
    {
        public static final @NonNull _invariant_ForAllTypeIsBoolean INSTANCE = new _invariant_ForAllTypeIsBoolean();

        public @NonNull /*@Thrown*/ Boolean evaluate(final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator, final @NonNull /*@NonInvalid*/ TypeId returnTypeId, final @Nullable /*@Caught*/ Object self) throws Exception {
            final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
            final @NonNull /*@NonInvalid*/ DomainType TYP_Boolean = idResolver.getType(TypeId.BOOLEAN, null);
            @NonNull /*@Caught*/ Object _q;
            try {
                if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                if (self == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ String name = ((Nameable)self).getName();
                _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, STR_forAll);
            } catch (Exception e) { _q = createInvalidValue(e); }
            @NonNull /*@Caught*/ Object _q_0;
            try {
                if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                if (self == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ DomainType type = ((DomainTypedElement)self).getType();
                _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type, TYP_Boolean);
            } catch (Exception e_0) { _q_0 = createInvalidValue(e_0); }
            final @Nullable /*@Thrown*/ Boolean result = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
            if (result == null) throw new InvalidValueException(null, "");
            return result;
        }
    }

    /**
     * Implementation of the IteratorExp 'IsUniqueHasOneIterator' <invariant>
     * 
     * name = 'isUnique' implies iterator->size() = 1
     */
    public static class _invariant_IsUniqueHasOneIterator extends AbstractUnaryOperation
    {
        public static final @NonNull _invariant_IsUniqueHasOneIterator INSTANCE = new _invariant_IsUniqueHasOneIterator();

        public @NonNull /*@Thrown*/ Boolean evaluate(final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator, final @NonNull /*@NonInvalid*/ TypeId returnTypeId, final @Nullable /*@Caught*/ Object self) throws Exception {
            @NonNull /*@Caught*/ Object _q;
            try {
                if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                if (self == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ String name = ((Nameable)self).getName();
                _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, STR_isUnique);
            } catch (Exception e) { _q = createInvalidValue(e); }
            @NonNull /*@Caught*/ Object _q_0;
            try {
                if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                if (self == null) throw new InvalidValueException(null, "");
                final @SuppressWarnings("null")@NonNull /*@Thrown*/ EList<?> iterator = ((LoopExp)self).getIterator();
                final @NonNull /*@Thrown*/ CollectionValue BOXED_iterator = createCollectionValue(ORD_CLSSid_Variable, iterator);
                final @NonNull /*@Thrown*/ IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(evaluator, TypeId.INTEGER, BOXED_iterator);
                _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, size, INT_1);
            } catch (Exception e_0) { _q_0 = createInvalidValue(e_0); }
            final @Nullable /*@Thrown*/ Boolean result = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
            if (result == null) throw new InvalidValueException(null, "");
            return result;
        }
    }

    /**
     * Implementation of the IteratorExp 'IsUniqueTypeIsBoolean' <invariant>
     * 
     * name = 'isUnique' implies type = Boolean
     */
    public static class _invariant_IsUniqueTypeIsBoolean extends AbstractUnaryOperation
    {
        public static final @NonNull _invariant_IsUniqueTypeIsBoolean INSTANCE = new _invariant_IsUniqueTypeIsBoolean();

        public @NonNull /*@Thrown*/ Boolean evaluate(final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator, final @NonNull /*@NonInvalid*/ TypeId returnTypeId, final @Nullable /*@Caught*/ Object self) throws Exception {
            final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
            final @NonNull /*@NonInvalid*/ DomainType TYP_Boolean = idResolver.getType(TypeId.BOOLEAN, null);
            @NonNull /*@Caught*/ Object _q;
            try {
                if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                if (self == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ String name = ((Nameable)self).getName();
                _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, STR_isUnique);
            } catch (Exception e) { _q = createInvalidValue(e); }
            @NonNull /*@Caught*/ Object _q_0;
            try {
                if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                if (self == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ DomainType type = ((DomainTypedElement)self).getType();
                _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type, TYP_Boolean);
            } catch (Exception e_0) { _q_0 = createInvalidValue(e_0); }
            final @Nullable /*@Thrown*/ Boolean result = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
            if (result == null) throw new InvalidValueException(null, "");
            return result;
        }
    }

    /**
     * Implementation of the IteratorExp 'IteratorTypeIsSourceElementType' <invariant>
     * 
     * 
     * self.iterator->forAll(type =
     *   source.type.oclAsType(CollectionType).elementType)
     */
    public static class _invariant_IteratorTypeIsSourceElementType extends AbstractUnaryOperation
    {
        public static final @NonNull _invariant_IteratorTypeIsSourceElementType INSTANCE = new _invariant_IteratorTypeIsSourceElementType();

        public @NonNull /*@Thrown*/ Boolean evaluate(final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator, final @NonNull /*@NonInvalid*/ TypeId returnTypeId, final @Nullable /*@Caught*/ Object self) throws Exception {
            final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
            final @NonNull /*@NonInvalid*/ DomainType TYP_pivot_c_c_CollectionType = idResolver.getType(CLSSid_CollectionType, null);
            if (self instanceof InvalidValueException) throw (InvalidValueException)self;
            if (self == null) throw new InvalidValueException(null, "");
            final @SuppressWarnings("null")@NonNull /*@Thrown*/ EList<?> iterator = ((LoopExp)self).getIterator();
            if (iterator == null) throw new InvalidValueException(null, "'Collection' rather than 'OclVoid' value required");
            final @NonNull /*@Thrown*/ CollectionValue BOXED_iterator = createCollectionValue(ORD_CLSSid_Variable, iterator);
            @NonNull /*@Thrown*/ Iterator<?> iterator_iterator = BOXED_iterator.iterator();
            @Nullable /*@Thrown*/ Boolean result;
            while (true) {
                if (!iterator_iterator.hasNext()) {
                    result = TRUE_VALUE;
                    break;
                }
                final @Nullable /*@Thrown*/ Object _49__ = iterator_iterator.next();
                /**
                 * type = source.type.oclAsType(CollectionType).elementType
                 */
                if (_49__ == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ DomainType type = ((DomainTypedElement)_49__).getType();
                if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                if (self == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ DomainExpression source = ((DomainCallExp)self).getSource();
                if (source == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ DomainType type_0 = source.getType();
                final @Nullable /*@Thrown*/ Object oclAsType = OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, CLSSid_CollectionType, type_0, TYP_pivot_c_c_CollectionType);
                if (oclAsType == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ DomainType elementType = ((DomainCollectionType)oclAsType).getElementType();
                final @NonNull /*@Thrown*/ Boolean _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type, elementType);
                /**/
                if (_q != TRUE_VALUE) {			// Carry unless something not found
                    result = FALSE_VALUE;			// Abort after a fail
                    break;
                }
            }
            if (result == null) throw new InvalidValueException(null, "");
            return result;
        }
    }

    /**
     * Implementation of the IteratorExp 'OneBodyTypeIsBoolean' <invariant>
     * 
     * name = 'one' implies body.type = Boolean
     */
    public static class _invariant_OneBodyTypeIsBoolean extends AbstractUnaryOperation
    {
        public static final @NonNull _invariant_OneBodyTypeIsBoolean INSTANCE = new _invariant_OneBodyTypeIsBoolean();

        public @NonNull /*@Thrown*/ Boolean evaluate(final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator, final @NonNull /*@NonInvalid*/ TypeId returnTypeId, final @Nullable /*@Caught*/ Object self) throws Exception {
            final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
            final @NonNull /*@NonInvalid*/ DomainType TYP_Boolean = idResolver.getType(TypeId.BOOLEAN, null);
            @NonNull /*@Caught*/ Object _q;
            try {
                if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                if (self == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ String name = ((Nameable)self).getName();
                _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, STR_one);
            } catch (Exception e) { _q = createInvalidValue(e); }
            @NonNull /*@Caught*/ Object _q_0;
            try {
                if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                if (self == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ OCLExpression body = ((LoopExp)self).getBody();
                if (body == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ DomainType type = body.getType();
                _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type, TYP_Boolean);
            } catch (Exception e_0) { _q_0 = createInvalidValue(e_0); }
            final @Nullable /*@Thrown*/ Boolean result = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
            if (result == null) throw new InvalidValueException(null, "");
            return result;
        }
    }

    /**
     * Implementation of the IteratorExp 'OneHasOneIterator' <invariant>
     * 
     * name = 'one' implies iterator->size() = 1
     */
    public static class _invariant_OneHasOneIterator extends AbstractUnaryOperation
    {
        public static final @NonNull _invariant_OneHasOneIterator INSTANCE = new _invariant_OneHasOneIterator();

        public @NonNull /*@Thrown*/ Boolean evaluate(final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator, final @NonNull /*@NonInvalid*/ TypeId returnTypeId, final @Nullable /*@Caught*/ Object self) throws Exception {
            @NonNull /*@Caught*/ Object _q;
            try {
                if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                if (self == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ String name = ((Nameable)self).getName();
                _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, STR_one);
            } catch (Exception e) { _q = createInvalidValue(e); }
            @NonNull /*@Caught*/ Object _q_0;
            try {
                if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                if (self == null) throw new InvalidValueException(null, "");
                final @SuppressWarnings("null")@NonNull /*@Thrown*/ EList<?> iterator = ((LoopExp)self).getIterator();
                final @NonNull /*@Thrown*/ CollectionValue BOXED_iterator = createCollectionValue(ORD_CLSSid_Variable, iterator);
                final @NonNull /*@Thrown*/ IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(evaluator, TypeId.INTEGER, BOXED_iterator);
                _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, size, INT_1);
            } catch (Exception e_0) { _q_0 = createInvalidValue(e_0); }
            final @Nullable /*@Thrown*/ Boolean result = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
            if (result == null) throw new InvalidValueException(null, "");
            return result;
        }
    }

    /**
     * Implementation of the IteratorExp 'OneTypeIsBoolean' <invariant>
     * 
     * name = 'one' implies type = Boolean
     */
    public static class _invariant_OneTypeIsBoolean extends AbstractUnaryOperation
    {
        public static final @NonNull _invariant_OneTypeIsBoolean INSTANCE = new _invariant_OneTypeIsBoolean();

        public @NonNull /*@Thrown*/ Boolean evaluate(final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator, final @NonNull /*@NonInvalid*/ TypeId returnTypeId, final @Nullable /*@Caught*/ Object self) throws Exception {
            final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
            final @NonNull /*@NonInvalid*/ DomainType TYP_Boolean = idResolver.getType(TypeId.BOOLEAN, null);
            @NonNull /*@Caught*/ Object _q;
            try {
                if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                if (self == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ String name = ((Nameable)self).getName();
                _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, STR_one);
            } catch (Exception e) { _q = createInvalidValue(e); }
            @NonNull /*@Caught*/ Object _q_0;
            try {
                if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                if (self == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ DomainType type = ((DomainTypedElement)self).getType();
                _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type, TYP_Boolean);
            } catch (Exception e_0) { _q_0 = createInvalidValue(e_0); }
            final @Nullable /*@Thrown*/ Boolean result = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
            if (result == null) throw new InvalidValueException(null, "");
            return result;
        }
    }

    /**
     * Implementation of the IteratorExp 'RejectOrSelectHasOneIterator' <invariant>
     * 
     * name = 'reject' or name = 'select' implies iterator->size() = 1
     */
    public static class _invariant_RejectOrSelectHasOneIterator extends AbstractUnaryOperation
    {
        public static final @NonNull _invariant_RejectOrSelectHasOneIterator INSTANCE = new _invariant_RejectOrSelectHasOneIterator();

        public @NonNull /*@Thrown*/ Boolean evaluate(final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator, final @NonNull /*@NonInvalid*/ TypeId returnTypeId, final @Nullable /*@Caught*/ Object self) throws Exception {
            @Nullable /*@Caught*/ Object or;
            try {
                @NonNull /*@Caught*/ Object _q;
                try {
                    if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                    if (self == null) throw new InvalidValueException(null, "");
                    final @Nullable /*@Thrown*/ String name = ((Nameable)self).getName();
                    _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, STR_reject);
                } catch (Exception e) { _q = createInvalidValue(e); }
                @NonNull /*@Caught*/ Object _q_0;
                try {
                    if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                    if (self == null) throw new InvalidValueException(null, "");
                    final @Nullable /*@Thrown*/ String name_0 = ((Nameable)self).getName();
                    _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name_0, STR_select);
                } catch (Exception e_0) { _q_0 = createInvalidValue(e_0); }
                or = BooleanOrOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
            } catch (Exception e_1) { or = createInvalidValue(e_1); }
            @NonNull /*@Caught*/ Object _q_1;
            try {
                if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                if (self == null) throw new InvalidValueException(null, "");
                final @SuppressWarnings("null")@NonNull /*@Thrown*/ EList<?> iterator = ((LoopExp)self).getIterator();
                final @NonNull /*@Thrown*/ CollectionValue BOXED_iterator = createCollectionValue(ORD_CLSSid_Variable, iterator);
                final @NonNull /*@Thrown*/ IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(evaluator, TypeId.INTEGER, BOXED_iterator);
                _q_1 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, size, INT_1);
            } catch (Exception e_2) { _q_1 = createInvalidValue(e_2); }
            final @Nullable /*@Thrown*/ Boolean result = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, or, _q_1);
            if (result == null) throw new InvalidValueException(null, "");
            return result;
        }
    }

    /**
     * Implementation of the IteratorExp 'RejectOrSelectTypeIsBoolean' <invariant>
     * 
     * name = 'reject' or name = 'select' implies type = Boolean
     */
    public static class _invariant_RejectOrSelectTypeIsBoolean extends AbstractUnaryOperation
    {
        public static final @NonNull _invariant_RejectOrSelectTypeIsBoolean INSTANCE = new _invariant_RejectOrSelectTypeIsBoolean();

        public @NonNull /*@Thrown*/ Boolean evaluate(final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator, final @NonNull /*@NonInvalid*/ TypeId returnTypeId, final @Nullable /*@Caught*/ Object self) throws Exception {
            final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
            final @NonNull /*@NonInvalid*/ DomainType TYP_Boolean = idResolver.getType(TypeId.BOOLEAN, null);
            @Nullable /*@Caught*/ Object or;
            try {
                @NonNull /*@Caught*/ Object _q;
                try {
                    if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                    if (self == null) throw new InvalidValueException(null, "");
                    final @Nullable /*@Thrown*/ String name = ((Nameable)self).getName();
                    _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, STR_reject);
                } catch (Exception e) { _q = createInvalidValue(e); }
                @NonNull /*@Caught*/ Object _q_0;
                try {
                    if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                    if (self == null) throw new InvalidValueException(null, "");
                    final @Nullable /*@Thrown*/ String name_0 = ((Nameable)self).getName();
                    _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name_0, STR_select);
                } catch (Exception e_0) { _q_0 = createInvalidValue(e_0); }
                or = BooleanOrOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
            } catch (Exception e_1) { or = createInvalidValue(e_1); }
            @NonNull /*@Caught*/ Object _q_1;
            try {
                if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                if (self == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ DomainType type = ((DomainTypedElement)self).getType();
                _q_1 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type, TYP_Boolean);
            } catch (Exception e_2) { _q_1 = createInvalidValue(e_2); }
            final @Nullable /*@Thrown*/ Boolean result = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, or, _q_1);
            if (result == null) throw new InvalidValueException(null, "");
            return result;
        }
    }

    /**
     * Implementation of the IteratorExp 'RejectOrSelectTypeIsSourceType' <invariant>
     * 
     * name = 'reject' or name = 'select' implies type = source.type
     */
    public static class _invariant_RejectOrSelectTypeIsSourceType extends AbstractUnaryOperation
    {
        public static final @NonNull _invariant_RejectOrSelectTypeIsSourceType INSTANCE = new _invariant_RejectOrSelectTypeIsSourceType();

        public @NonNull /*@Thrown*/ Boolean evaluate(final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator, final @NonNull /*@NonInvalid*/ TypeId returnTypeId, final @Nullable /*@Caught*/ Object self) throws Exception {
            @Nullable /*@Caught*/ Object or;
            try {
                @NonNull /*@Caught*/ Object _q;
                try {
                    if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                    if (self == null) throw new InvalidValueException(null, "");
                    final @Nullable /*@Thrown*/ String name = ((Nameable)self).getName();
                    _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, STR_reject);
                } catch (Exception e) { _q = createInvalidValue(e); }
                @NonNull /*@Caught*/ Object _q_0;
                try {
                    if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                    if (self == null) throw new InvalidValueException(null, "");
                    final @Nullable /*@Thrown*/ String name_0 = ((Nameable)self).getName();
                    _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name_0, STR_select);
                } catch (Exception e_0) { _q_0 = createInvalidValue(e_0); }
                or = BooleanOrOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
            } catch (Exception e_1) { or = createInvalidValue(e_1); }
            @NonNull /*@Caught*/ Object _q_1;
            try {
                if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                if (self == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ DomainType type = ((DomainTypedElement)self).getType();
                if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                if (self == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ DomainExpression source = ((DomainCallExp)self).getSource();
                if (source == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ DomainType type_0 = source.getType();
                _q_1 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type, type_0);
            } catch (Exception e_2) { _q_1 = createInvalidValue(e_2); }
            final @Nullable /*@Thrown*/ Boolean result = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, or, _q_1);
            if (result == null) throw new InvalidValueException(null, "");
            return result;
        }
    }

    /**
     * Implementation of the IteratorExp 'SortedByElementTypeIsSourceElementType' <invariant>
     * 
     * name = 'sortedBy' implies
     * type.oclAsType(CollectionType).elementType =
     * body.type.oclAsType(CollectionType).elementType
     */
    public static class _invariant_SortedByElementTypeIsSourceElementType extends AbstractUnaryOperation
    {
        public static final @NonNull _invariant_SortedByElementTypeIsSourceElementType INSTANCE = new _invariant_SortedByElementTypeIsSourceElementType();

        public @NonNull /*@Thrown*/ Boolean evaluate(final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator, final @NonNull /*@NonInvalid*/ TypeId returnTypeId, final @Nullable /*@Caught*/ Object self) throws Exception {
            final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
            final @NonNull /*@NonInvalid*/ DomainType TYP_pivot_c_c_CollectionType = idResolver.getType(CLSSid_CollectionType, null);
            @NonNull /*@Caught*/ Object _q;
            try {
                if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                if (self == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ String name = ((Nameable)self).getName();
                _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, STR_sortedBy);
            } catch (Exception e) { _q = createInvalidValue(e); }
            @NonNull /*@Caught*/ Object _q_0;
            try {
                if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                if (self == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ DomainType type = ((DomainTypedElement)self).getType();
                final @Nullable /*@Thrown*/ Object oclAsType = OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, CLSSid_CollectionType, type, TYP_pivot_c_c_CollectionType);
                if (oclAsType == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ DomainType elementType = ((DomainCollectionType)oclAsType).getElementType();
                if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                if (self == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ OCLExpression body = ((LoopExp)self).getBody();
                if (body == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ DomainType type_0 = body.getType();
                final @Nullable /*@Thrown*/ Object oclAsType_0 = OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, CLSSid_CollectionType, type_0, TYP_pivot_c_c_CollectionType);
                if (oclAsType_0 == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ DomainType elementType_0 = ((DomainCollectionType)oclAsType_0).getElementType();
                _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, elementType, elementType_0);
            } catch (Exception e_0) { _q_0 = createInvalidValue(e_0); }
            final @Nullable /*@Thrown*/ Boolean result = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
            if (result == null) throw new InvalidValueException(null, "");
            return result;
        }
    }

    /**
     * Implementation of the IteratorExp 'SortedByHasOneIterator' <invariant>
     * 
     * name = 'sortedBy' implies iterator->size() = 1
     */
    public static class _invariant_SortedByHasOneIterator extends AbstractUnaryOperation
    {
        public static final @NonNull _invariant_SortedByHasOneIterator INSTANCE = new _invariant_SortedByHasOneIterator();

        public @NonNull /*@Thrown*/ Boolean evaluate(final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator, final @NonNull /*@NonInvalid*/ TypeId returnTypeId, final @Nullable /*@Caught*/ Object self) throws Exception {
            @NonNull /*@Caught*/ Object _q;
            try {
                if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                if (self == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ String name = ((Nameable)self).getName();
                _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, STR_sortedBy);
            } catch (Exception e) { _q = createInvalidValue(e); }
            @NonNull /*@Caught*/ Object _q_0;
            try {
                if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                if (self == null) throw new InvalidValueException(null, "");
                final @SuppressWarnings("null")@NonNull /*@Thrown*/ EList<?> iterator = ((LoopExp)self).getIterator();
                final @NonNull /*@Thrown*/ CollectionValue BOXED_iterator = createCollectionValue(ORD_CLSSid_Variable, iterator);
                final @NonNull /*@Thrown*/ IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(evaluator, TypeId.INTEGER, BOXED_iterator);
                _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, size, INT_1);
            } catch (Exception e_0) { _q_0 = createInvalidValue(e_0); }
            final @Nullable /*@Thrown*/ Boolean result = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
            if (result == null) throw new InvalidValueException(null, "");
            return result;
        }
    }

    /**
     * Implementation of the IteratorExp 'SortedByIsOrderedIfSourceIsOrdered' <invariant>
     * 
     * name = 'sortedBy' implies
     * if
     *   source.type.oclIsKindOf(SequenceType) or
     *   source.type.oclIsKindOf(BagType)
     * then type.oclIsKindOf(SequenceType)
     * else type.oclIsKindOf(OrderedSetType)
     * endif
     */
    public static class _invariant_SortedByIsOrderedIfSourceIsOrdered extends AbstractUnaryOperation
    {
        public static final @NonNull _invariant_SortedByIsOrderedIfSourceIsOrdered INSTANCE = new _invariant_SortedByIsOrderedIfSourceIsOrdered();

        public @NonNull /*@Thrown*/ Boolean evaluate(final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator, final @NonNull /*@NonInvalid*/ TypeId returnTypeId, final @Nullable /*@Caught*/ Object self) throws Exception {
            final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
            final @NonNull /*@NonInvalid*/ DomainType TYP_pivot_c_c_SequenceType = idResolver.getType(CLSSid_SequenceType, null);
            final @NonNull /*@NonInvalid*/ DomainType TYP_pivot_c_c_OrderedSetType = idResolver.getType(CLSSid_OrderedSetType, null);
            final @NonNull /*@NonInvalid*/ DomainType TYP_pivot_c_c_BagType = idResolver.getType(CLSSid_BagType, null);
            @NonNull /*@Caught*/ Object _q;
            try {
                if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                if (self == null) throw new InvalidValueException(null, "");
                final @Nullable /*@Thrown*/ String name = ((Nameable)self).getName();
                _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, STR_sortedBy);
            } catch (Exception e) { _q = createInvalidValue(e); }
            @Nullable /*@Caught*/ Object symbol_0;
            try {
                @NonNull /*@Caught*/ Object oclIsKindOf;
                try {
                    @Nullable /*@Caught*/ Object type;
                    try {
                        if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                        if (self == null) throw new InvalidValueException(null, "");
                        final @Nullable /*@Thrown*/ DomainExpression source = ((DomainCallExp)self).getSource();
                        if (source == null) throw new InvalidValueException(null, "");
                        type = source.getType();
                    } catch (Exception e_1) { type = createInvalidValue(e_1); }
                    oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type, TYP_pivot_c_c_SequenceType);
                } catch (Exception e_2) { oclIsKindOf = createInvalidValue(e_2); }
                @NonNull /*@Caught*/ Object oclIsKindOf_0;
                try {
                    @Nullable /*@Caught*/ Object type_0;
                    try {
                        if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                        if (self == null) throw new InvalidValueException(null, "");
                        final @Nullable /*@Thrown*/ DomainExpression source_0 = ((DomainCallExp)self).getSource();
                        if (source_0 == null) throw new InvalidValueException(null, "");
                        type_0 = source_0.getType();
                    } catch (Exception e_3) { type_0 = createInvalidValue(e_3); }
                    oclIsKindOf_0 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type_0, TYP_pivot_c_c_BagType);
                } catch (Exception e_4) { oclIsKindOf_0 = createInvalidValue(e_4); }
                final @Nullable /*@Thrown*/ Boolean or = BooleanOrOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, oclIsKindOf, oclIsKindOf_0);
                if (or == TRUE_VALUE) {
                    @Nullable /*@Caught*/ Object type_1;
                    try {
                        if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                        if (self == null) throw new InvalidValueException(null, "");
                        type_1 = ((DomainTypedElement)self).getType();
                    } catch (Exception e_5) { type_1 = createInvalidValue(e_5); }
                    final @NonNull /*@Thrown*/ Boolean oclIsKindOf_1 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type_1, TYP_pivot_c_c_SequenceType);
                    symbol_0 = oclIsKindOf_1;
                }
                else if (or == FALSE_VALUE) {
                    @Nullable /*@Caught*/ Object type_2;
                    try {
                        if (self instanceof InvalidValueException) throw (InvalidValueException)self;
                        if (self == null) throw new InvalidValueException(null, "");
                        type_2 = ((DomainTypedElement)self).getType();
                    } catch (Exception e_6) { type_2 = createInvalidValue(e_6); }
                    final @NonNull /*@Thrown*/ Boolean oclIsKindOf_2 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type_2, TYP_pivot_c_c_OrderedSetType);
                    symbol_0 = oclIsKindOf_2;
                }
                else {
                    throw INVALID_VALUE;
                }
                ;
            } catch (Exception e_0) { symbol_0 = createInvalidValue(e_0); }
            final @Nullable /*@Thrown*/ Boolean result = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, symbol_0);
            if (result == null) throw new InvalidValueException(null, "");
            return result;
        }
    }

    /**
     * Implementation of the IteratorExp 'SortedByIteratorTypeIsComparable' <invariant>
     * 
     * true
     */
    public static class _invariant_SortedByIteratorTypeIsComparable extends AbstractUnaryOperation
    {
        public static final @NonNull _invariant_SortedByIteratorTypeIsComparable INSTANCE = new _invariant_SortedByIteratorTypeIsComparable();

        public @NonNull /*@Thrown*/ Boolean evaluate(final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator, final @NonNull /*@NonInvalid*/ TypeId returnTypeId, final @Nullable /*@Thrown*/ Object self) throws Exception {
            return TRUE_VALUE;
        }
    }
}
