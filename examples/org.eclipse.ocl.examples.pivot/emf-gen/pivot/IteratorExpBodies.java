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
import java.lang.String;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainCallExp;
import org.eclipse.ocl.examples.domain.elements.DomainCollectionType;
import org.eclipse.ocl.examples.domain.elements.DomainExpression;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.elements.DomainTypedElement;
import org.eclipse.ocl.examples.domain.elements.Nameable;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.ids.ClassId;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.PackageId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractBinaryOperation;
import org.eclipse.ocl.examples.domain.library.AbstractUnaryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryIteration;
import org.eclipse.ocl.examples.domain.types.IdResolver;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.TypeValue;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueImpl;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.library.collection.CollectionSizeOperation;
import org.eclipse.ocl.examples.library.executor.ExecutorSingleIterationManager;
import org.eclipse.ocl.examples.library.logical.BooleanImpliesOperation;
import org.eclipse.ocl.examples.library.logical.BooleanOrOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyOclAsTypeOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.examples.pivot.LoopExp;
import org.eclipse.ocl.examples.pivot.OCLExpression;

@SuppressWarnings("nls")
public class IteratorExpBodies extends ValuesUtil

{
    private static final @NonNull String STR_Boolean = "Boolean";
    private static final @NonNull String STR_isUnique = "isUnique";
    private static final @NonNull String STR_any = "any";
    private static final @NonNull IntegerValue INT_1 = integerValueOf(1);
    private static final @NonNull String STR_collect = "collect";
    private static final @NonNull String STR_forAll = "forAll";
    private static final @NonNull String STR_select = "select";
    private static final @NonNull String STR_collectNested = "collectNested";
    private static final @NonNull String STR_reject = "reject";
    private static final @NonNull String STR_exists = "exists";
    private static final @NonNull String STR_closure = "closure";
    private static final @NonNull PackageId PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot = IdManager.INSTANCE.getNsURIPackageId("http://www.eclipse.org/ocl/3.1.0/Pivot", org.eclipse.ocl.examples.pivot.PivotPackage.eINSTANCE);
    private static final @NonNull ClassId CLSSid_BagType = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("BagType");
    private static final @NonNull ClassId CLSSid_SequenceType = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("SequenceType");
    private static final @NonNull ClassId CLSSid_SetType = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("SetType");
    private static final @NonNull ClassId CLSSid_OrderedSetType = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("OrderedSetType");
    private static final @NonNull ClassId CLSSid_Variable = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("Variable");
    private static final @NonNull CollectionTypeId ORD_CLSSid_Variable = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Variable);
    private static final @NonNull ClassId CLSSid_CollectionType = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("CollectionType");
    private static final @NonNull String STR_sortedBy = "sortedBy";
    private static final @NonNull String STR_one = "one";
    /**
     * Implementation of the IteratorExp 'ClosureBodyTypeIsConformanttoIteratorType' <invariant>
     * 
     * true
     */
    public static class _invariant_ClosureBodyTypeIsConformanttoIteratorType extends AbstractUnaryOperation
    {
        public static final @NonNull _invariant_ClosureBodyTypeIsConformanttoIteratorType INSTANCE = new _invariant_ClosureBodyTypeIsConformanttoIteratorType();

        public @Nullable Object evaluate(final @NonNull DomainEvaluator evaluator, final @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
            return TRUE_VALUE;
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

        public @Nullable Object evaluate(final @NonNull DomainEvaluator evaluator, final @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
            return TRUE_VALUE;
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

        public @Nullable Object evaluate(final @NonNull DomainEvaluator evaluator, final @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @SuppressWarnings("null")@NonNull EList<?> iterator = ((LoopExp)self).getIterator();
            final @NonNull CollectionValue BOXED_iterator = createCollectionValue(ORD_CLSSid_Variable, iterator);
            final @NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(evaluator, TypeId.INTEGER, BOXED_iterator);
            @NonNull Object _q_0;
            try {
                _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, size, INT_1);
            }
            catch (Exception e) {
                _q_0 = new InvalidValueImpl(e);
            }
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable String name = ((Nameable)self).getName();
            @NonNull Object _q;
            try {
                _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, STR_any);
            }
            catch (Exception e) {
                _q = new InvalidValueImpl(e);
            }
            final @Nullable Object result = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
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

        public @Nullable Object evaluate(final @NonNull DomainEvaluator evaluator, final @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable DomainExpression source = ((DomainCallExp)self).getSource();
            if (source == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable DomainType type_0 = source.getType();
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable DomainType type = ((DomainTypedElement)self).getType();
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable String name = ((Nameable)self).getName();
            @NonNull Object _q;
            try {
                _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, STR_any);
            }
            catch (Exception e) {
                _q = new InvalidValueImpl(e);
            }
            final @NonNull IdResolver idResolver = evaluator.getIdResolver();
            final @NonNull TypeValue TYP_pivot_c_c_CollectionType = createTypeValue(idResolver.getType(CLSSid_CollectionType, null));
            final @Nullable Object oclAsType = OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, CLSSid_CollectionType, type_0, TYP_pivot_c_c_CollectionType);
            if (oclAsType == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable DomainType elementType = ((DomainCollectionType)oclAsType).getElementType();
            @NonNull Object _q_0;
            try {
                _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type, elementType);
            }
            catch (Exception e) {
                _q_0 = new InvalidValueImpl(e);
            }
            final @Nullable Object result = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
            return result;
        }
    }
    /**
     * Implementation of the IteratorExp 'AnyBodyTypeIsBoolean' <invariant>
     * 
     * name = 'any' implies body.type = 'Boolean'
     */
    public static class _invariant_AnyBodyTypeIsBoolean extends AbstractUnaryOperation
    {
        public static final @NonNull _invariant_AnyBodyTypeIsBoolean INSTANCE = new _invariant_AnyBodyTypeIsBoolean();

        public @Nullable Object evaluate(final @NonNull DomainEvaluator evaluator, final @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable OCLExpression body = ((LoopExp)self).getBody();
            if (body == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable DomainType type = body.getType();
            @NonNull Object _q_0;
            try {
                _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type, STR_Boolean);
            }
            catch (Exception e) {
                _q_0 = new InvalidValueImpl(e);
            }
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable String name = ((Nameable)self).getName();
            @NonNull Object _q;
            try {
                _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, STR_any);
            }
            catch (Exception e) {
                _q = new InvalidValueImpl(e);
            }
            final @Nullable Object result = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
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

        public @Nullable Object evaluate(final @NonNull DomainEvaluator evaluator, final @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable String name = ((Nameable)self).getName();
            @NonNull Object _q;
            try {
                _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, STR_closure);
            }
            catch (Exception e) {
                _q = new InvalidValueImpl(e);
            }
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @SuppressWarnings("null")@NonNull EList<?> iterator = ((LoopExp)self).getIterator();
            final @NonNull CollectionValue BOXED_iterator = createCollectionValue(ORD_CLSSid_Variable, iterator);
            final @NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(evaluator, TypeId.INTEGER, BOXED_iterator);
            @NonNull Object _q_0;
            try {
                _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, size, INT_1);
            }
            catch (Exception e) {
                _q_0 = new InvalidValueImpl(e);
            }
            final @Nullable Object result = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
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

        public @Nullable Object evaluate(final @NonNull DomainEvaluator evaluator, final @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable DomainType type_0 = ((DomainTypedElement)self).getType();
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable DomainExpression source = ((DomainCallExp)self).getSource();
            if (source == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable DomainType type = source.getType();
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable DomainExpression source_0 = ((DomainCallExp)self).getSource();
            if (source_0 == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable DomainType type_1 = source_0.getType();
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable String name = ((Nameable)self).getName();
            @NonNull Object _q;
            try {
                _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, STR_closure);
            }
            catch (Exception e) {
                _q = new InvalidValueImpl(e);
            }
            final @NonNull IdResolver idResolver = evaluator.getIdResolver();
            final @NonNull TypeValue TYP_pivot_c_c_SequenceType = createTypeValue(idResolver.getType(CLSSid_SequenceType, null));
            @NonNull Object oclIsKindOf;
            try {
                oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type_1, TYP_pivot_c_c_SequenceType);
            }
            catch (Exception e) {
                oclIsKindOf = new InvalidValueImpl(e);
            }
            final @NonNull TypeValue TYP_pivot_c_c_SetType = createTypeValue(idResolver.getType(CLSSid_SetType, null));
            final @NonNull TypeValue TYP_pivot_c_c_OrderedSetType = createTypeValue(idResolver.getType(CLSSid_OrderedSetType, null));
            @NonNull Object oclIsKindOf_0;
            try {
                oclIsKindOf_0 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type, TYP_pivot_c_c_OrderedSetType);
            }
            catch (Exception e) {
                oclIsKindOf_0 = new InvalidValueImpl(e);
            }
            final @Nullable Object or = BooleanOrOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, oclIsKindOf, oclIsKindOf_0);
            @Nullable Boolean symbol_0;
            if ((Boolean)or == TRUE_VALUE) {
                final @NonNull Boolean oclIsKindOf_1 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type_0, TYP_pivot_c_c_OrderedSetType);
                symbol_0 = oclIsKindOf_1;
            }
            else if ((Boolean)or == FALSE_VALUE) {
                if (self == null) throw new InvalidValueException("Non-Null source for property");
                final @Nullable DomainType type_2 = ((DomainTypedElement)self).getType();
                final @NonNull Boolean oclIsKindOf_2 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type_2, TYP_pivot_c_c_SetType);
                symbol_0 = oclIsKindOf_2;
            }
            else {
                throw INVALID_VALUE.getException();
            }
            final @Nullable Object result = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, symbol_0);
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

        public @Nullable Object evaluate(final @NonNull DomainEvaluator evaluator, final @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable DomainExpression source_0 = ((DomainCallExp)self).getSource();
            if (source_0 == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable DomainType type_2 = source_0.getType();
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable OCLExpression body = ((LoopExp)self).getBody();
            if (body == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable DomainType type_0 = body.getType();
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable String name = ((Nameable)self).getName();
            @NonNull Object _q;
            try {
                _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, STR_closure);
            }
            catch (Exception e) {
                _q = new InvalidValueImpl(e);
            }
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable OCLExpression body_0 = ((LoopExp)self).getBody();
            if (body_0 == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable DomainType type_3 = body_0.getType();
            final @NonNull IdResolver idResolver = evaluator.getIdResolver();
            final @NonNull TypeValue TYP_pivot_c_c_CollectionType = createTypeValue(idResolver.getType(CLSSid_CollectionType, null));
            final @NonNull Boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type_3, TYP_pivot_c_c_CollectionType);
            @Nullable EObject symbol_0;
            if (oclIsKindOf == TRUE_VALUE) {
                if (self == null) throw new InvalidValueException("Non-Null source for property");
                final @Nullable OCLExpression body_1 = ((LoopExp)self).getBody();
                if (body_1 == null) throw new InvalidValueException("Non-Null source for property");
                final @Nullable DomainType type_4 = body_1.getType();
                final @Nullable Object oclAsType_0 = OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, CLSSid_CollectionType, type_4, TYP_pivot_c_c_CollectionType);
                if (oclAsType_0 == null) throw new InvalidValueException("Non-Null source for property");
                final @Nullable DomainType elementType_0 = ((DomainCollectionType)oclAsType_0).getElementType();
                symbol_0 = (EObject)elementType_0;
            }
            else if (oclIsKindOf == FALSE_VALUE) {
                symbol_0 = (EObject)type_0;
            }
            else {
                throw INVALID_VALUE.getException();
            }
            final @Nullable Object oclAsType = OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, CLSSid_CollectionType, type_2, TYP_pivot_c_c_CollectionType);
            if (oclAsType == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable DomainType elementType = ((DomainCollectionType)oclAsType).getElementType();
            @NonNull Object _q_0;
            try {
                _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, elementType, symbol_0);
            }
            catch (Exception e) {
                _q_0 = new InvalidValueImpl(e);
            }
            final @Nullable Object result = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
            return result;
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

        public @Nullable Object evaluate(final @NonNull DomainEvaluator evaluator, final @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable DomainType type_2 = ((DomainTypedElement)self).getType();
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable DomainExpression source_0 = ((DomainCallExp)self).getSource();
            if (source_0 == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable DomainType type_3 = source_0.getType();
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable String name = ((Nameable)self).getName();
            @NonNull Object _q;
            try {
                _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, STR_closure);
            }
            catch (Exception e) {
                _q = new InvalidValueImpl(e);
            }
            final @NonNull IdResolver idResolver = evaluator.getIdResolver();
            final @NonNull TypeValue TYP_pivot_c_c_CollectionType = createTypeValue(idResolver.getType(CLSSid_CollectionType, null));
            final @Nullable Object oclAsType = OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, CLSSid_CollectionType, type_2, TYP_pivot_c_c_CollectionType);
            if (oclAsType == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable DomainType elementType = ((DomainCollectionType)oclAsType).getElementType();
            final @Nullable Object oclAsType_0 = OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, CLSSid_CollectionType, type_3, TYP_pivot_c_c_CollectionType);
            if (oclAsType_0 == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable DomainType elementType_0 = ((DomainCollectionType)oclAsType_0).getElementType();
            @NonNull Object _q_0;
            try {
                _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, elementType, elementType_0);
            }
            catch (Exception e) {
                _q_0 = new InvalidValueImpl(e);
            }
            final @Nullable Object result = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
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

        public @Nullable Object evaluate(final @NonNull DomainEvaluator evaluator, final @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @SuppressWarnings("null")@NonNull EList<?> iterator = ((LoopExp)self).getIterator();
            final @NonNull CollectionValue BOXED_iterator = createCollectionValue(ORD_CLSSid_Variable, iterator);
            final @NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(evaluator, TypeId.INTEGER, BOXED_iterator);
            @NonNull Object _q_0;
            try {
                _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, size, INT_1);
            }
            catch (Exception e) {
                _q_0 = new InvalidValueImpl(e);
            }
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable String name = ((Nameable)self).getName();
            @NonNull Object _q;
            try {
                _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, STR_collect);
            }
            catch (Exception e) {
                _q = new InvalidValueImpl(e);
            }
            final @Nullable Object result = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
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

        public @Nullable Object evaluate(final @NonNull DomainEvaluator evaluator, final @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable DomainType type_0 = ((DomainTypedElement)self).getType();
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable DomainExpression source_1 = ((DomainCallExp)self).getSource();
            if (source_1 == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable DomainType type_4 = source_1.getType();
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable String name = ((Nameable)self).getName();
            @NonNull Object _q;
            try {
                _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, STR_collect);
            }
            catch (Exception e) {
                _q = new InvalidValueImpl(e);
            }
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable DomainExpression source_0 = ((DomainCallExp)self).getSource();
            if (source_0 == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable DomainType type_3 = source_0.getType();
            final @NonNull IdResolver idResolver = evaluator.getIdResolver();
            final @NonNull TypeValue TYP_pivot_c_c_BagType = createTypeValue(idResolver.getType(CLSSid_BagType, null));
            final @NonNull TypeValue TYP_pivot_c_c_SequenceType = createTypeValue(idResolver.getType(CLSSid_SequenceType, null));
            @NonNull Object oclIsKindOf;
            try {
                oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type_4, TYP_pivot_c_c_SequenceType);
            }
            catch (Exception e) {
                oclIsKindOf = new InvalidValueImpl(e);
            }
            final @NonNull TypeValue TYP_pivot_c_c_OrderedSetType = createTypeValue(idResolver.getType(CLSSid_OrderedSetType, null));
            @NonNull Object oclIsKindOf_0;
            try {
                oclIsKindOf_0 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type_3, TYP_pivot_c_c_OrderedSetType);
            }
            catch (Exception e) {
                oclIsKindOf_0 = new InvalidValueImpl(e);
            }
            final @Nullable Object or = BooleanOrOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, oclIsKindOf, oclIsKindOf_0);
            @Nullable Boolean symbol_0;
            if ((Boolean)or == TRUE_VALUE) {
                final @NonNull Boolean oclIsKindOf_1 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type_0, TYP_pivot_c_c_SequenceType);
                symbol_0 = oclIsKindOf_1;
            }
            else if ((Boolean)or == FALSE_VALUE) {
                if (self == null) throw new InvalidValueException("Non-Null source for property");
                final @Nullable DomainType type_5 = ((DomainTypedElement)self).getType();
                final @NonNull Boolean oclIsKindOf_2 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type_5, TYP_pivot_c_c_BagType);
                symbol_0 = oclIsKindOf_2;
            }
            else {
                throw INVALID_VALUE.getException();
            }
            final @Nullable Object result = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, symbol_0);
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

        public @Nullable Object evaluate(final @NonNull DomainEvaluator evaluator, final @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable String name = ((Nameable)self).getName();
            @NonNull Object _q;
            try {
                _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, STR_collect);
            }
            catch (Exception e) {
                _q = new InvalidValueImpl(e);
            }
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable DomainType type_4 = ((DomainTypedElement)self).getType();
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable OCLExpression body_0 = ((LoopExp)self).getBody();
            if (body_0 == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable DomainType type_5 = body_0.getType();
            final @NonNull IdResolver idResolver = evaluator.getIdResolver();
            final @NonNull TypeValue TYP_pivot_c_c_CollectionType = createTypeValue(idResolver.getType(CLSSid_CollectionType, null));
            final @Nullable Object oclAsType_0 = OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, CLSSid_CollectionType, type_5, TYP_pivot_c_c_CollectionType);
            if (oclAsType_0 == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable DomainType elementType_0 = ((DomainCollectionType)oclAsType_0).getElementType();
            final @Nullable Object oclAsType = OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, CLSSid_CollectionType, type_4, TYP_pivot_c_c_CollectionType);
            if (oclAsType == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable DomainType elementType = ((DomainCollectionType)oclAsType).getElementType();
            @NonNull Object _q_0;
            try {
                _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, elementType, elementType_0);
            }
            catch (Exception e) {
                _q_0 = new InvalidValueImpl(e);
            }
            final @Nullable Object result = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
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

        public @Nullable Object evaluate(final @NonNull DomainEvaluator evaluator, final @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable String name = ((Nameable)self).getName();
            @NonNull Object _q;
            try {
                _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, STR_collectNested);
            }
            catch (Exception e) {
                _q = new InvalidValueImpl(e);
            }
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @SuppressWarnings("null")@NonNull EList<?> iterator = ((LoopExp)self).getIterator();
            final @NonNull CollectionValue BOXED_iterator = createCollectionValue(ORD_CLSSid_Variable, iterator);
            final @NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(evaluator, TypeId.INTEGER, BOXED_iterator);
            @NonNull Object _q_0;
            try {
                _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, size, INT_1);
            }
            catch (Exception e) {
                _q_0 = new InvalidValueImpl(e);
            }
            final @Nullable Object result = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
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

        public @Nullable Object evaluate(final @NonNull DomainEvaluator evaluator, final @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable DomainType type_4 = ((DomainTypedElement)self).getType();
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable String name = ((Nameable)self).getName();
            @NonNull Object _q;
            try {
                _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, STR_collectNested);
            }
            catch (Exception e) {
                _q = new InvalidValueImpl(e);
            }
            final @NonNull IdResolver idResolver = evaluator.getIdResolver();
            final @NonNull TypeValue TYP_pivot_c_c_BagType = createTypeValue(idResolver.getType(CLSSid_BagType, null));
            @NonNull Object oclIsKindOf;
            try {
                oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type_4, TYP_pivot_c_c_BagType);
            }
            catch (Exception e) {
                oclIsKindOf = new InvalidValueImpl(e);
            }
            final @Nullable Object result = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, oclIsKindOf);
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

        public @Nullable Object evaluate(final @NonNull DomainEvaluator evaluator, final @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable String name = ((Nameable)self).getName();
            @NonNull Object _q;
            try {
                _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, STR_collectNested);
            }
            catch (Exception e) {
                _q = new InvalidValueImpl(e);
            }
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable OCLExpression body_0 = ((LoopExp)self).getBody();
            if (body_0 == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable DomainType type_5 = body_0.getType();
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable DomainType type_4 = ((DomainTypedElement)self).getType();
            @NonNull Object _q_0;
            try {
                _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type_4, type_5);
            }
            catch (Exception e) {
                _q_0 = new InvalidValueImpl(e);
            }
            final @Nullable Object result = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
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

        public @Nullable Object evaluate(final @NonNull DomainEvaluator evaluator, final @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
            final @NonNull IdResolver idResolver = evaluator.getIdResolver();
            final @NonNull TypeValue TYP_Boolean = createTypeValue(idResolver.getType(TypeId.BOOLEAN, null));
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable String name = ((Nameable)self).getName();
            @NonNull Object _q;
            try {
                _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, STR_exists);
            }
            catch (Exception e) {
                _q = new InvalidValueImpl(e);
            }
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable DomainType type_4 = ((DomainTypedElement)self).getType();
            @NonNull Object _q_0;
            try {
                _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type_4, TYP_Boolean);
            }
            catch (Exception e) {
                _q_0 = new InvalidValueImpl(e);
            }
            final @Nullable Object result = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
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

        public @Nullable Object evaluate(final @NonNull DomainEvaluator evaluator, final @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable OCLExpression body_0 = ((LoopExp)self).getBody();
            if (body_0 == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable DomainType type_4 = body_0.getType();
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable String name = ((Nameable)self).getName();
            @NonNull Object _q;
            try {
                _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, STR_exists);
            }
            catch (Exception e) {
                _q = new InvalidValueImpl(e);
            }
            final @NonNull IdResolver idResolver = evaluator.getIdResolver();
            final @NonNull TypeValue TYP_Boolean = createTypeValue(idResolver.getType(TypeId.BOOLEAN, null));
            @NonNull Object _q_0;
            try {
                _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type_4, TYP_Boolean);
            }
            catch (Exception e) {
                _q_0 = new InvalidValueImpl(e);
            }
            final @Nullable Object result = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
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

        public @Nullable Object evaluate(final @NonNull DomainEvaluator evaluator, final @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable String name = ((Nameable)self).getName();
            @NonNull Object _q;
            try {
                _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, STR_forAll);
            }
            catch (Exception e) {
                _q = new InvalidValueImpl(e);
            }
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable DomainType type_4 = ((DomainTypedElement)self).getType();
            final @NonNull IdResolver idResolver = evaluator.getIdResolver();
            final @NonNull TypeValue TYP_Boolean = createTypeValue(idResolver.getType(TypeId.BOOLEAN, null));
            @NonNull Object _q_0;
            try {
                _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type_4, TYP_Boolean);
            }
            catch (Exception e) {
                _q_0 = new InvalidValueImpl(e);
            }
            final @Nullable Object result = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
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

        public @Nullable Object evaluate(final @NonNull DomainEvaluator evaluator, final @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable OCLExpression body_0 = ((LoopExp)self).getBody();
            if (body_0 == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable DomainType type_4 = body_0.getType();
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable String name = ((Nameable)self).getName();
            @NonNull Object _q;
            try {
                _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, STR_forAll);
            }
            catch (Exception e) {
                _q = new InvalidValueImpl(e);
            }
            final @NonNull IdResolver idResolver = evaluator.getIdResolver();
            final @NonNull TypeValue TYP_Boolean = createTypeValue(idResolver.getType(TypeId.BOOLEAN, null));
            @NonNull Object _q_0;
            try {
                _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type_4, TYP_Boolean);
            }
            catch (Exception e) {
                _q_0 = new InvalidValueImpl(e);
            }
            final @Nullable Object result = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
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

        public @Nullable Object evaluate(final @NonNull DomainEvaluator evaluator, final @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable String name = ((Nameable)self).getName();
            @NonNull Object _q;
            try {
                _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, STR_isUnique);
            }
            catch (Exception e) {
                _q = new InvalidValueImpl(e);
            }
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @SuppressWarnings("null")@NonNull EList<?> iterator = ((LoopExp)self).getIterator();
            final @NonNull CollectionValue BOXED_iterator = createCollectionValue(ORD_CLSSid_Variable, iterator);
            final @NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(evaluator, TypeId.INTEGER, BOXED_iterator);
            @NonNull Object _q_0;
            try {
                _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, size, INT_1);
            }
            catch (Exception e) {
                _q_0 = new InvalidValueImpl(e);
            }
            final @Nullable Object result = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
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

        public @Nullable Object evaluate(final @NonNull DomainEvaluator evaluator, final @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable String name = ((Nameable)self).getName();
            @NonNull Object _q;
            try {
                _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, STR_isUnique);
            }
            catch (Exception e) {
                _q = new InvalidValueImpl(e);
            }
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable DomainType type_4 = ((DomainTypedElement)self).getType();
            final @NonNull IdResolver idResolver = evaluator.getIdResolver();
            final @NonNull TypeValue TYP_Boolean = createTypeValue(idResolver.getType(TypeId.BOOLEAN, null));
            @NonNull Object _q_0;
            try {
                _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type_4, TYP_Boolean);
            }
            catch (Exception e) {
                _q_0 = new InvalidValueImpl(e);
            }
            final @Nullable Object result = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
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

        public @Nullable Object evaluate(final @NonNull DomainEvaluator evaluator, final @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable String name = ((Nameable)self).getName();
            @NonNull Object _q;
            try {
                _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, STR_one);
            }
            catch (Exception e) {
                _q = new InvalidValueImpl(e);
            }
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @SuppressWarnings("null")@NonNull EList<?> iterator = ((LoopExp)self).getIterator();
            final @NonNull CollectionValue BOXED_iterator = createCollectionValue(ORD_CLSSid_Variable, iterator);
            final @NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(evaluator, TypeId.INTEGER, BOXED_iterator);
            @NonNull Object _q_0;
            try {
                _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, size, INT_1);
            }
            catch (Exception e) {
                _q_0 = new InvalidValueImpl(e);
            }
            final @Nullable Object result = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
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

        public @Nullable Object evaluate(final @NonNull DomainEvaluator evaluator, final @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable String name = ((Nameable)self).getName();
            @NonNull Object _q;
            try {
                _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, STR_one);
            }
            catch (Exception e) {
                _q = new InvalidValueImpl(e);
            }
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable DomainType type_4 = ((DomainTypedElement)self).getType();
            final @NonNull IdResolver idResolver = evaluator.getIdResolver();
            final @NonNull TypeValue TYP_Boolean = createTypeValue(idResolver.getType(TypeId.BOOLEAN, null));
            @NonNull Object _q_0;
            try {
                _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type_4, TYP_Boolean);
            }
            catch (Exception e) {
                _q_0 = new InvalidValueImpl(e);
            }
            final @Nullable Object result = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
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

        public @Nullable Object evaluate(final @NonNull DomainEvaluator evaluator, final @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable OCLExpression body_0 = ((LoopExp)self).getBody();
            if (body_0 == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable DomainType type_4 = body_0.getType();
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable String name = ((Nameable)self).getName();
            @NonNull Object _q;
            try {
                _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, STR_one);
            }
            catch (Exception e) {
                _q = new InvalidValueImpl(e);
            }
            final @NonNull IdResolver idResolver = evaluator.getIdResolver();
            final @NonNull TypeValue TYP_Boolean = createTypeValue(idResolver.getType(TypeId.BOOLEAN, null));
            @NonNull Object _q_0;
            try {
                _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type_4, TYP_Boolean);
            }
            catch (Exception e) {
                _q_0 = new InvalidValueImpl(e);
            }
            final @Nullable Object result = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
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

        public @Nullable Object evaluate(final @NonNull DomainEvaluator evaluator, final @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @SuppressWarnings("null")@NonNull EList<?> iterator = ((LoopExp)self).getIterator();
            final @NonNull CollectionValue BOXED_iterator = createCollectionValue(ORD_CLSSid_Variable, iterator);
            final @NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(evaluator, TypeId.INTEGER, BOXED_iterator);
            @NonNull Object _q_1;
            try {
                _q_1 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, size, INT_1);
            }
            catch (Exception e) {
                _q_1 = new InvalidValueImpl(e);
            }
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable String name_0 = ((Nameable)self).getName();
            @NonNull Object _q;
            try {
                _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name_0, STR_reject);
            }
            catch (Exception e) {
                _q = new InvalidValueImpl(e);
            }
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable String name = ((Nameable)self).getName();
            @NonNull Object _q_0;
            try {
                _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, STR_select);
            }
            catch (Exception e) {
                _q_0 = new InvalidValueImpl(e);
            }
            @Nullable Object or;
            try {
                or = BooleanOrOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
            }
            catch (Exception e) {
                or = new InvalidValueImpl(e);
            }
            final @Nullable Object result = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, or, _q_1);
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

        public @Nullable Object evaluate(final @NonNull DomainEvaluator evaluator, final @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable String name_1 = ((Nameable)self).getName();
            @NonNull Object _q;
            try {
                _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name_1, STR_reject);
            }
            catch (Exception e) {
                _q = new InvalidValueImpl(e);
            }
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable DomainType type_4 = ((DomainTypedElement)self).getType();
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable String name_0 = ((Nameable)self).getName();
            @NonNull Object _q_0;
            try {
                _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name_0, STR_select);
            }
            catch (Exception e) {
                _q_0 = new InvalidValueImpl(e);
            }
            @Nullable Object or;
            try {
                or = BooleanOrOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
            }
            catch (Exception e) {
                or = new InvalidValueImpl(e);
            }
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable DomainExpression source_1 = ((DomainCallExp)self).getSource();
            if (source_1 == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable DomainType type_5 = source_1.getType();
            @NonNull Object _q_1;
            try {
                _q_1 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type_4, type_5);
            }
            catch (Exception e) {
                _q_1 = new InvalidValueImpl(e);
            }
            final @Nullable Object result = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, or, _q_1);
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

        public @Nullable Object evaluate(final @NonNull DomainEvaluator evaluator, final @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable DomainType type_4 = ((DomainTypedElement)self).getType();
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable String name = ((Nameable)self).getName();
            @NonNull Object _q_0;
            try {
                _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, STR_select);
            }
            catch (Exception e) {
                _q_0 = new InvalidValueImpl(e);
            }
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable String name_2 = ((Nameable)self).getName();
            @NonNull Object _q;
            try {
                _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name_2, STR_reject);
            }
            catch (Exception e) {
                _q = new InvalidValueImpl(e);
            }
            @Nullable Object or;
            try {
                or = BooleanOrOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
            }
            catch (Exception e) {
                or = new InvalidValueImpl(e);
            }
            final @NonNull IdResolver idResolver = evaluator.getIdResolver();
            final @NonNull TypeValue TYP_Boolean = createTypeValue(idResolver.getType(TypeId.BOOLEAN, null));
            @NonNull Object _q_1;
            try {
                _q_1 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type_4, TYP_Boolean);
            }
            catch (Exception e) {
                _q_1 = new InvalidValueImpl(e);
            }
            final @Nullable Object result = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, or, _q_1);
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

        public @Nullable Object evaluate(final @NonNull DomainEvaluator evaluator, final @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable String name_2 = ((Nameable)self).getName();
            @NonNull Object _q;
            try {
                _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name_2, STR_sortedBy);
            }
            catch (Exception e) {
                _q = new InvalidValueImpl(e);
            }
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @SuppressWarnings("null")@NonNull EList<?> iterator = ((LoopExp)self).getIterator();
            final @NonNull CollectionValue BOXED_iterator = createCollectionValue(ORD_CLSSid_Variable, iterator);
            final @NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(evaluator, TypeId.INTEGER, BOXED_iterator);
            @NonNull Object _q_0;
            try {
                _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, size, INT_1);
            }
            catch (Exception e) {
                _q_0 = new InvalidValueImpl(e);
            }
            final @Nullable Object result = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
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

        public @Nullable Object evaluate(final @NonNull DomainEvaluator evaluator, final @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable DomainExpression source_1 = ((DomainCallExp)self).getSource();
            if (source_1 == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable DomainType type_2 = source_1.getType();
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable DomainExpression source_2 = ((DomainCallExp)self).getSource();
            if (source_2 == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable DomainType type_6 = source_2.getType();
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable String name_2 = ((Nameable)self).getName();
            @NonNull Object _q;
            try {
                _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name_2, STR_sortedBy);
            }
            catch (Exception e) {
                _q = new InvalidValueImpl(e);
            }
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable DomainType type_3 = ((DomainTypedElement)self).getType();
            final @NonNull IdResolver idResolver = evaluator.getIdResolver();
            final @NonNull TypeValue TYP_pivot_c_c_OrderedSetType = createTypeValue(idResolver.getType(CLSSid_OrderedSetType, null));
            final @NonNull TypeValue TYP_pivot_c_c_BagType = createTypeValue(idResolver.getType(CLSSid_BagType, null));
            @NonNull Object oclIsKindOf_0;
            try {
                oclIsKindOf_0 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type_2, TYP_pivot_c_c_BagType);
            }
            catch (Exception e) {
                oclIsKindOf_0 = new InvalidValueImpl(e);
            }
            final @NonNull TypeValue TYP_pivot_c_c_SequenceType = createTypeValue(idResolver.getType(CLSSid_SequenceType, null));
            @NonNull Object oclIsKindOf;
            try {
                oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type_6, TYP_pivot_c_c_SequenceType);
            }
            catch (Exception e) {
                oclIsKindOf = new InvalidValueImpl(e);
            }
            final @Nullable Object or = BooleanOrOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, oclIsKindOf, oclIsKindOf_0);
            @Nullable Boolean symbol_0;
            if ((Boolean)or == TRUE_VALUE) {
                final @NonNull Boolean oclIsKindOf_1 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type_3, TYP_pivot_c_c_SequenceType);
                symbol_0 = oclIsKindOf_1;
            }
            else if ((Boolean)or == FALSE_VALUE) {
                if (self == null) throw new InvalidValueException("Non-Null source for property");
                final @Nullable DomainType type_7 = ((DomainTypedElement)self).getType();
                final @NonNull Boolean oclIsKindOf_2 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type_7, TYP_pivot_c_c_OrderedSetType);
                symbol_0 = oclIsKindOf_2;
            }
            else {
                throw INVALID_VALUE.getException();
            }
            final @Nullable Object result = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, symbol_0);
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

        public @Nullable Object evaluate(final @NonNull DomainEvaluator evaluator, final @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable OCLExpression body_0 = ((LoopExp)self).getBody();
            if (body_0 == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable DomainType type_7 = body_0.getType();
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable String name_2 = ((Nameable)self).getName();
            @NonNull Object _q;
            try {
                _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name_2, STR_sortedBy);
            }
            catch (Exception e) {
                _q = new InvalidValueImpl(e);
            }
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable DomainType type_6 = ((DomainTypedElement)self).getType();
            final @NonNull IdResolver idResolver = evaluator.getIdResolver();
            final @NonNull TypeValue TYP_pivot_c_c_CollectionType = createTypeValue(idResolver.getType(CLSSid_CollectionType, null));
            final @Nullable Object oclAsType_0 = OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, CLSSid_CollectionType, type_7, TYP_pivot_c_c_CollectionType);
            if (oclAsType_0 == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable DomainType elementType_0 = ((DomainCollectionType)oclAsType_0).getElementType();
            final @Nullable Object oclAsType = OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, CLSSid_CollectionType, type_6, TYP_pivot_c_c_CollectionType);
            if (oclAsType == null) throw new InvalidValueException("Non-Null source for property");
            final @Nullable DomainType elementType = ((DomainCollectionType)oclAsType).getElementType();
            @NonNull Object _q_0;
            try {
                _q_0 = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, elementType, elementType_0);
            }
            catch (Exception e) {
                _q_0 = new InvalidValueImpl(e);
            }
            final @Nullable Object result = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, _q, _q_0);
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

        public @Nullable Object evaluate(final @NonNull DomainEvaluator evaluator, final @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
            if (self == null) throw new InvalidValueException("Non-Null source for property");
            final @SuppressWarnings("null")@NonNull EList<?> iterator = ((LoopExp)self).getIterator();
            final @NonNull CollectionValue BOXED_iterator = createCollectionValue(ORD_CLSSid_Variable, iterator);
            final @NonNull IdResolver idResolver = evaluator.getIdResolver();
            final @NonNull TypeValue TYP_pivot_c_c_CollectionType = createTypeValue(idResolver.getType(CLSSid_CollectionType, null));
            final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
            /**
             * Implementation of the iterator body.
             */
            final @NonNull AbstractBinaryOperation BODY_result = new AbstractBinaryOperation()
            {
                /**
                 * type = source.type.oclAsType(CollectionType).elementType
                 */
                public @Nullable Object evaluate(final @NonNull DomainEvaluator evaluator, final @NonNull TypeId returnTypeId, @Nullable final Object sourceValue, final @Nullable Object _49__) throws Exception {
                    if (self == null) throw new InvalidValueException("Non-Null source for property");
                    final @Nullable DomainExpression source_2 = ((DomainCallExp)self).getSource();
                    if (source_2 == null) throw new InvalidValueException("Non-Null source for property");
                    final @Nullable DomainType type_7 = source_2.getType();
                    final @Nullable Object oclAsType = OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, CLSSid_CollectionType, type_7, TYP_pivot_c_c_CollectionType);
                    if (oclAsType == null) throw new InvalidValueException("Non-Null source for property");
                    final @Nullable DomainType elementType = ((DomainCollectionType)oclAsType).getElementType();
                    if (_49__ == null) throw new InvalidValueException("Non-Null source for property");
                    final @Nullable DomainType type_6 = ((DomainTypedElement)_49__).getType();
                    final @NonNull Boolean _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type_6, elementType);
                    return _q;
                }
            };
            DomainType TYPE_result = evaluator.getStaticTypeOf(BOXED_iterator);
            LibraryIteration IMPL_result = (LibraryIteration)TYPE_result.lookupImplementation(standardLibrary, OCLstdlibTables.Operations._Collection__1_forAll);
            Object ACC_result = IMPL_result.createAccumulatorValue(evaluator, TypeId.BOOLEAN, TypeId.BOOLEAN);
            ExecutorSingleIterationManager MGR_result = new ExecutorSingleIterationManager(evaluator, TypeId.BOOLEAN, BODY_result, BOXED_iterator, ACC_result);
            @Nullable Object result = IMPL_result.evaluateIteration(MGR_result);
            return result;
        }
    }
}
