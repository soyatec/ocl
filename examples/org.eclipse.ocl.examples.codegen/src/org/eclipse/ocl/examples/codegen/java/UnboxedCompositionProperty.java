/*******************************************************************************
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.codegen.java;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractProperty;

public class UnboxedCompositionProperty extends AbstractProperty
{
	protected @NonNull String containmentFeatureName;
	
	public UnboxedCompositionProperty(@NonNull String containmentFeatureName) {
		this.containmentFeatureName = containmentFeatureName;
	}
	
	@Override
	public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue) {
		assert sourceValue != null;
		EObject eObject = (EObject)sourceValue; 
		EObject eContainer = eObject.eContainer();
		if (eContainer == null) {
			return null;				// No container
		}
		EReference eContainmentFeature = eObject.eContainmentFeature();
		if (!containmentFeatureName.equals(eContainmentFeature.getName())) {
			return null;				// Contained but by some other property
		}
		return eContainer;
	}
}
