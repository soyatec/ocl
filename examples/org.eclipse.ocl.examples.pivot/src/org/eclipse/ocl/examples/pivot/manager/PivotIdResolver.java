/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.pivot.manager;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.ids.TupleTypeId;
import org.eclipse.ocl.examples.domain.types.DomainInvalidTypeImpl;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.library.executor.AbstractIdResolver;
import org.eclipse.ocl.examples.pivot.TupleType;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.ecore.Ecore2Pivot;

public class PivotIdResolver extends AbstractIdResolver
{
	public PivotIdResolver(@NonNull MetaModelManager metaModelManager) {
		super(metaModelManager);
	}

	@Override
	public @NonNull TupleType getTupleType(@NonNull TupleTypeId typeId) {
		TupleTypeManager tupleManager = ((MetaModelManager)standardLibrary).getTupleManager();
		return tupleManager.getTupleType(this, typeId);
	}

	@Override
	public @NonNull DomainType getType(@NonNull EClassifier eClassifier) {
		Resource eResource = DomainUtil.nonNullState(eClassifier.eResource());
		Ecore2Pivot ecore2Pivot = Ecore2Pivot.getAdapter(eResource, (MetaModelManager)standardLibrary);
		Type pivotType = ecore2Pivot.getCreated(Type.class, eClassifier);
		if (pivotType == null) {
			return new DomainInvalidTypeImpl(standardLibrary, "No object created by Ecore2Pivot");
		}
		return ((MetaModelManager)standardLibrary).getPrimaryType(pivotType);
	}
}