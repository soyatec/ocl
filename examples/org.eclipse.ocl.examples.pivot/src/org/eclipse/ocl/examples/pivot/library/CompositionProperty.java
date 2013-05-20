/**
 * <copyright>
 *
 * Copyright (c) 2011, 2013 E.D.Willink and others.
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
 * $Id: ExplicitNavigationProperty.java,v 1.2 2011/05/07 16:41:20 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.library;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.PropertyId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractProperty;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;

/**
 * An instance of ImplicitContainerProperty supports evaluation of
 * a property call that navigates a relationship to a container.
 */
public class CompositionProperty extends AbstractProperty
{
	protected @NonNull PropertyId containmentPropertyId;
	private EReference eContainmentFeature = null;	// Non null once discovered
	
	public CompositionProperty(@NonNull PropertyId containmentPropertyId) {
		this.containmentPropertyId = containmentPropertyId;
	}
	
	public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue) {
		EObject eObject = asNavigableObject(sourceValue); 
		EObject eContainer = eObject.eContainer();
		if (eContainer == null) {
			return null;				// No container
		}
		EReference eContainmentFeature = DomainUtil.nonNullModel(eObject.eContainmentFeature());
		if (eContainmentFeature != this.eContainmentFeature) {
			PropertyId propertyId = IdManager.getPropertyId(eContainmentFeature);	// FIXME get this from constructor
			if (!containmentPropertyId.equals(propertyId)) {
				return null;				// Contained but by some other property
			}
			this.eContainmentFeature = eContainmentFeature;
		}
		return evaluator.getIdResolver().boxedValueOf(eContainer);
	}
}
