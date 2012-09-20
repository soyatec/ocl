/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: EObjectProperty.java,v 1.3 2011/05/07 16:41:22 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.ecore;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainProperty;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractProperty;
import org.eclipse.ocl.examples.pivot.ValueSpecification;

/** 
 * An EObjectProperty provides the standard LibraryProperty to implement a
 * PropertyCallExp. When constructed with a null specification, the call just accesses
 * the property field in a source object. When constructed with a non-null specification,
 * the specification defines the access algorithm, which if provided as an OpaqueExpression
 * is lazily compiled from OCL source text.
 */
public class EObjectProperty extends AbstractProperty
{
	protected final @NonNull EStructuralFeature eFeature;
	protected @Nullable ValueSpecification specification;

	public EObjectProperty(@NonNull EStructuralFeature eFeature, @Nullable ValueSpecification specification) {
		this.eFeature = eFeature;
		this.specification = specification;
	}

	public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @NonNull Object sourceValue, @NonNull DomainProperty property) {
		Object object = asObject(sourceValue);
		if (!(object instanceof EObject)) {
			return createInvalidValue("non-EObject");
		}
		Object eValue = ((EObject)object).eGet(eFeature);
		return eValue != null ? valueOf(eValue, eFeature, returnTypeId) : NULL_VALUE;
	}
}