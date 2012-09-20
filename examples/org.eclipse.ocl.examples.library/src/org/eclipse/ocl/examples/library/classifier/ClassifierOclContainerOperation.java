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
 *
 * $Id: ClassifierOclContainerOperation.java,v 1.2 2011/05/07 16:41:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.classifier;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractUnaryOperation;

/**
 * ClassifierOclContainerOperation realises the Classifier::oclContainer() library operation.
 */
public class ClassifierOclContainerOperation extends AbstractUnaryOperation
{
	public static final @NonNull ClassifierOclContainerOperation INSTANCE = new ClassifierOclContainerOperation();

	public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @NonNull Object sourceVal) {
		EObject object = asNavigableObject(sourceVal);
		EObject eContainer = object.eContainer();
		if (eContainer != null) {
			return eContainer;
		}
		else {
			return NULL_VALUE;
		}
	}
}
