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
import org.eclipse.emf.common.util.EList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainCallExp;
import org.eclipse.ocl.examples.domain.elements.DomainExpression;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
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
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.library.collection.CollectionIsEmptyOperation;
import org.eclipse.ocl.examples.library.executor.ExecutorSingleIterationManager;
import org.eclipse.ocl.examples.library.oclany.OclAnyOclAsSetOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.examples.pivot.LoopExp;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Variable;

@SuppressWarnings("nls")
public class LoopExpBodies extends ValuesUtil
{
    private static final @NonNull /*@NonInvalid*/ PackageId PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot = IdManager.INSTANCE.getNsURIPackageId("http://www.eclipse.org/ocl/3.1.0/Pivot", org.eclipse.ocl.examples.pivot.PivotPackage.eINSTANCE);
    private static final @NonNull /*@NonInvalid*/ ClassId CLSSid_OCLExpression = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("OCLExpression");
    private static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_OCLExpression = TypeId.SET.getSpecializedId(CLSSid_OCLExpression);
    private static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Variable = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("Variable");
    private static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Variable = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Variable);
    private static final @NonNull /*@NonInvalid*/ ClassId CLSSid_CollectionType = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("CollectionType");

    /**
     * Implementation of the LoopExp 'NoInitializers' <invariant>
     * 
     * self.iterator->forAll(initExpression->isEmpty())
     */
    public static class _invariant_NoInitializers extends AbstractUnaryOperation
    {
        public static final @NonNull _invariant_NoInitializers INSTANCE = new _invariant_NoInitializers();

        public @NonNull /*@Thrown*/ Boolean evaluate(final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator, final @NonNull /*@NonInvalid*/ TypeId returnTypeId, final @Nullable /*@Thrown*/ Object self) throws Exception {
            if (self == null) throw new InvalidValueException("Null source for property: self.iterator");
            final @SuppressWarnings("null")@NonNull /*@Thrown*/ EList<?> iterator = ((LoopExp)self).getIterator();
            final @NonNull /*@Thrown*/ CollectionValue BOXED_iterator = createCollectionValue(ORD_CLSSid_Variable, iterator);
            final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
            /**
             * Implementation of the iterator body.
             */
            final @NonNull AbstractBinaryOperation BODY_result = new AbstractBinaryOperation()
            {
                /**
                 * initExpression->isEmpty()
                 */
                public @Nullable Object evaluate(final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator, final @NonNull TypeId returnTypeId, @Nullable final Object sourceValue, final @Nullable /*@Thrown*/ Object _49__) throws Exception {
                    if (_49__ == null) throw new InvalidValueException("Null source for property: initExpression");
                    final @Nullable /*@Thrown*/ OCLExpression initExpression = ((Variable)_49__).getInitExpression();
                    final @NonNull /*@Thrown*/ CollectionValue oclAsSet = OclAnyOclAsSetOperation.INSTANCE.evaluate(evaluator, SET_CLSSid_OCLExpression, initExpression);
                    final @NonNull /*@Thrown*/ Boolean isEmpty = CollectionIsEmptyOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, oclAsSet);
                    return isEmpty;
                }
            };
            DomainType TYPE_result = evaluator.getStaticTypeOf(BOXED_iterator);
            LibraryIteration IMPL_result = (LibraryIteration)TYPE_result.lookupImplementation(standardLibrary, OCLstdlibTables.Operations._Collection__1_forAll);
            Object ACC_result = IMPL_result.createAccumulatorValue(evaluator, TypeId.BOOLEAN, TypeId.BOOLEAN);
            ExecutorSingleIterationManager MGR_result = new ExecutorSingleIterationManager(evaluator, TypeId.BOOLEAN, BODY_result, BOXED_iterator, ACC_result);
            final @Nullable /*@Thrown*/ Object result = IMPL_result.evaluateIteration(MGR_result);
            if (result == null) throw new InvalidValueException("null return");
            return (Boolean)result;
        }
    }

    /**
     * Implementation of the LoopExp 'SourceIsCollection' <invariant>
     * 
     * source.type.oclIsKindOf(CollectionType)
     */
    public static class _invariant_SourceIsCollection extends AbstractUnaryOperation
    {
        public static final @NonNull _invariant_SourceIsCollection INSTANCE = new _invariant_SourceIsCollection();

        public @NonNull /*@Thrown*/ Boolean evaluate(final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator, final @NonNull /*@NonInvalid*/ TypeId returnTypeId, final @Nullable /*@Thrown*/ Object self) throws Exception {
            final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
            final @NonNull /*@NonInvalid*/ DomainType TYP_pivot_c_c_CollectionType = idResolver.getType(CLSSid_CollectionType, null);
            @Nullable /*@Caught*/ Object type;
            try {
                if (self == null) throw new InvalidValueException("Null source for property: source");
                final @Nullable /*@Thrown*/ DomainExpression source = ((DomainCallExp)self).getSource();
                if (source == null) throw new InvalidValueException("Null source for property: source.type");
                type = source.getType();
            } catch (Exception e) { type = createInvalidValue(e); }
            final @NonNull /*@Thrown*/ Boolean result = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type, TYP_pivot_c_c_CollectionType);
            return result;
        }
    }
}
