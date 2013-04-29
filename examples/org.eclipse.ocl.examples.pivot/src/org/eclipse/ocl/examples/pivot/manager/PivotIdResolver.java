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

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainElement;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.ids.TupleTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.types.DomainInvalidTypeImpl;
import org.eclipse.ocl.examples.library.executor.AbstractIdResolver;
import org.eclipse.ocl.examples.pivot.ParserException;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TupleType;
import org.eclipse.ocl.examples.pivot.Type;

public class PivotIdResolver extends AbstractIdResolver
{
	private static final Logger logger = Logger.getLogger(PivotIdResolver.class);

	protected final @NonNull MetaModelManager metaModelManager;
	
	public PivotIdResolver(@NonNull MetaModelManager metaModelManager) {
		super(metaModelManager);
		this.metaModelManager = metaModelManager;
	}

	@Override
	public @NonNull TupleType getTupleType(@NonNull TupleTypeId typeId) {
		TupleTypeManager tupleManager = metaModelManager.getTupleManager();
		return tupleManager.getTupleType(this, typeId);
	}

	@Override
	public @NonNull DomainType getType(@NonNull EClassifier eClassifier) {
		Type pivotType;
		try {
			pivotType = metaModelManager.getPivotOf(Type.class, eClassifier);
			if (pivotType != null) {
				return metaModelManager.getPrimaryType(pivotType);
			}
		} catch (ParserException e) {
			logger.error("Failed to convert '" + eClassifier + "'", e);
		}
		return new DomainInvalidTypeImpl(standardLibrary, "No object created by Ecore2Pivot");
	}

	@Override
	public @NonNull Type getType(@NonNull TypeId typeId, @Nullable Object context) {
		DomainElement type = typeId.accept(this);
		if (type instanceof TemplateParameter) {
			type = ((TemplateParameter)type).getParameteredElement();
		}
		assert type != null;
		return (Type)type;
	}
}