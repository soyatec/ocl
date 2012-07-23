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
 * $Id: CollectionProductOperation.java,v 1.3 2011/02/21 08:37:46 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.collection;

import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainCollectionType;
import org.eclipse.ocl.examples.domain.elements.DomainTupleType;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.library.AbstractBinaryOperation;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.TupleValue;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.domain.values.ValueFactory;
import org.eclipse.osgi.util.NLS;

/**
 * CollectionProductOperation realises the Collection::product() library operation.
 */
public class CollectionProductOperation extends AbstractBinaryOperation
{
	public static final CollectionProductOperation INSTANCE = new CollectionProductOperation();

	public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, @NonNull Value sourceVal, @NonNull Value argVal) throws InvalidValueException {
		ValueFactory valueFactory = evaluator.getValueFactory();
		CollectionValue sourceValue = sourceVal.asCollectionValue();
		CollectionValue argumentValue = argVal.asCollectionValue();
		DomainCollectionType collType = (DomainCollectionType)returnType;
		DomainTupleType tupleType = (DomainTupleType) DomainUtil.nonNullModel(collType.getElementType());
		Set<TupleValue> product = sourceValue.product(argumentValue, tupleType);
        if (product != null) {
        	return valueFactory.createSetValue(collType, product);
        }
        else {
        	return valueFactory.throwInvalidValueException(NLS.bind(EvaluatorMessages.MissingResult, "product")); //$NON-NLS-1$
        }
	}
}
