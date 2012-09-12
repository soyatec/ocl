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
 * $Id: ClassifierOclContentsOperation.java,v 1.2 2011/05/07 16:41:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.classifier;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainCollectionType;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.library.AbstractUnaryOperation;
import org.eclipse.ocl.examples.domain.values.ValueFactory;

/**
 * ClassifierOclContentsOperation realises the Classifier::oclContents() library operation.
 */
public class ClassifierOclContentsOperation extends AbstractUnaryOperation
{
	public static final @NonNull ClassifierOclContentsOperation INSTANCE = new ClassifierOclContentsOperation();

	public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, @NonNull Object sourceValue) throws InvalidValueException {
		ValueFactory valueFactory = evaluator.getValueFactory();
		EObject object = asNavigableObject(sourceValue);
    	Set<Object> collection = new HashSet<Object>();
		for (Object eContent : object.eContents()) {
			if (eContent != null) {
				collection.add(valueFactory.valueOf(eContent));
			}
    	}
    	return valueFactory.createSetValue((DomainCollectionType)returnType, collection);
	}
}
