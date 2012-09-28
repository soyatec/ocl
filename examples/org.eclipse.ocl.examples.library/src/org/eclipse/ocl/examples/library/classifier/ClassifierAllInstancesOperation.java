/**
 * <copyright>
 *
 * Copyright (c) 2009,2011 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: ClassifierAllInstancesOperation.java,v 1.4 2011/04/25 09:48:56 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.classifier;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.DomainModelManager;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractUnaryOperation;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;

/**
 * ClassifierAllInstancesOperation realises the Classifier::allInstances() library operation.
 */
public class ClassifierAllInstancesOperation extends AbstractUnaryOperation
{
	public static final @NonNull ClassifierAllInstancesOperation INSTANCE = new ClassifierAllInstancesOperation();

	public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @NonNull Object sourceVal) {
		DomainType type = asType(sourceVal);
		DomainModelManager modelManager = evaluator.getModelManager();
		Set<Object> results = new HashSet<Object>();
		Set<?> instances = modelManager.get(type);
		for (Object instance : instances) {
			if (instance != null){
				results.add(ValuesUtil.valueOf(instance));	// FIXME Move to model manager
			}
		}
		return createSetValue((CollectionTypeId)returnTypeId, results);
	}
}
