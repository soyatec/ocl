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
import java.lang.String;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainProperty;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.elements.DomainTypedElement;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.ids.ClassId;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.PackageId;
import org.eclipse.ocl.examples.domain.ids.PropertyId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractBinaryOperation;
import org.eclipse.ocl.examples.domain.library.AbstractUnaryOperation;
import org.eclipse.ocl.examples.domain.types.IdResolver;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.library.classifier.OclTypeConformsToOperation;

@SuppressWarnings("nls")
public class TypedMultiplicityElementBodies extends ValuesUtil
{
    private static final @NonNull /*@NonInvalid*/ String STR_name = "name";
    private static final @NonNull /*@NonInvalid*/ PackageId PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot = IdManager.INSTANCE.getNsURIPackageId("http://www.eclipse.org/ocl/3.1.0/Pivot", org.eclipse.ocl.examples.pivot.PivotPackage.eINSTANCE);
    private static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Parameter = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("Parameter");
    private static final @NonNull /*@NonInvalid*/ ClassId CLSSid_NamedElement = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("NamedElement");
    private static final @NonNull /*@NonInvalid*/ PropertyId PROPid_name = CLSSid_NamedElement.getPropertyId("name");

    /**
     * Implementation of the TypedMultiplicityElement::CompatibleBody '' <body>
     * 
     * bodySpecification.type.conformsTo(self.type)
     */
    public static class _CompatibleBody_body_ extends AbstractBinaryOperation
    {
        public static final @NonNull _CompatibleBody_body_ INSTANCE = new _CompatibleBody_body_();

        public @NonNull /*@Thrown*/ Boolean evaluate(final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator, final @NonNull /*@NonInvalid*/ TypeId returnTypeId, final @Nullable /*@Thrown*/ Object self, final @Nullable /*@Thrown*/ Object bodySpecification) throws Exception {
            if (bodySpecification == null) throw new InvalidValueException("Null source for property: bodySpecification.type");
            final @Nullable /*@Thrown*/ DomainType type = ((DomainTypedElement)bodySpecification).getType();
            if (self == null) throw new InvalidValueException("Null source for property: self.type");
            final @Nullable /*@Thrown*/ DomainType type_0 = ((DomainTypedElement)self).getType();
            final @NonNull /*@Thrown*/ Boolean result = OclTypeConformsToOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, type, type_0);
            return result;
        }
    }

    /**
     * Implementation of the TypedMultiplicityElement::makeParameter '' <body>
     * 
     * Parameter{name = 'name'}
     */
    public static class _makeParameter_body_ extends AbstractUnaryOperation
    {
        public static final @NonNull _makeParameter_body_ INSTANCE = new _makeParameter_body_();

        public @NonNull /*@Thrown*/ EObject evaluate(final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator, final @NonNull /*@NonInvalid*/ TypeId returnTypeId, final @Nullable /*@Thrown*/ Object self) throws Exception {
            final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
            final @NonNull /*@NonInvalid*/ DomainType TYP_pivot_c_c_Parameter = idResolver.getType(CLSSid_Parameter, null);
            final @NonNull /*@NonInvalid*/ DomainProperty name = idResolver.getProperty(PROPid_name);
            final @Nullable /*@Thrown*/ EObject result = (EObject)TYP_pivot_c_c_Parameter.createInstance();
            name.initValue(result, STR_name);
            if (result == null) throw new InvalidValueException("null return");
            return result;
        }
    }
}
