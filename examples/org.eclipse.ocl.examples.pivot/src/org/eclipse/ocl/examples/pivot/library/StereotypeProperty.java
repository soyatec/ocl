/**
 * <copyright>
 *
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.pivot.library;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.common.utils.EcoreUtils;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.types.IdResolver;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.ElementExtension;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.Metaclass;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.OpaqueExpression;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

/**
 * An instance of StereotypeProperty supports evaluation of a property call that accesses a stereotype extension property.
 */
public class StereotypeProperty extends ConstrainedProperty
{
	public StereotypeProperty(@NonNull Property property) {
		super(property);
	}
	
	@Override
	public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue) {
		IdResolver idResolver = evaluator.getIdResolver();
		EObject eObject = asNavigableObject(sourceValue);
		if (eObject instanceof Metaclass<?>) {
			eObject = ((Metaclass<?>)eObject).getInstanceType();
		}
		Object boxedValue = null;
		if (eObject instanceof ElementExtension) {
			ElementExtension elementExtension = (ElementExtension)eObject;
			Property theProperty = DomainUtil.getNamedElement(elementExtension.getOwnedAttribute(), property.getName());
			if (theProperty == null) {
				return super.evaluate(evaluator, returnTypeId, sourceValue);
			}
			String defaultValueLiteral = theProperty.getDefault();
			OpaqueExpression defaultExpression = theProperty.getDefaultExpression();
			if (defaultValueLiteral != null) {
				boxedValue = idResolver.createInstance(property.getTypeId(), defaultValueLiteral);
			}
			else if (defaultExpression != null) {
				String body = PivotUtil.getBody(defaultExpression);
				if (body != null) {
					ExpressionInOCL expr =	PivotUtil.getExpressionInOCL(elementExtension, body);
					if (expr != null) {
						OCLExpression bodyExpression = expr.getBodyExpression();
						if (bodyExpression != null) {
							boxedValue = evaluator.evaluate(bodyExpression);		// FIXME errors
						}
					}
				}
			}
		}
		else {
			EClass eClass = eObject.eClass();
			EStructuralFeature eFeature = EcoreUtils.getNamedElement(eClass.getEAllStructuralFeatures(), property.getName());
			if (eFeature != null) {
				Object value = eObject.eGet(eFeature);
				boxedValue = value != null ? idResolver.boxedValueOf(value, eFeature, returnTypeId) : null;
			}
		}
		return boxedValue;
	}
}