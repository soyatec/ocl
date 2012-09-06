/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D.Willink and others.
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

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainCallExp;
import org.eclipse.ocl.examples.domain.elements.DomainCollectionType;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.InvalidEvaluationException;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.library.AbstractPolyOperation;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.domain.values.ValueFactory;

/**
 * An EInvokeOperation supports evaluation of an operation call by using eInvoke on the underlying eObject.
 */
public class EInvokeOperation extends AbstractPolyOperation
{
	protected final @NonNull EOperation eOperation;	
	
	public EInvokeOperation(@NonNull EOperation eOperation) {
		this.eOperation = eOperation;
		EClassifier eType = eOperation.getEType();
		if (eType == null) {
			throw new IllegalArgumentException("Non-query EOperation");
		}
	}

	public @Nullable Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainCallExp callExp, @NonNull Value sourceValue,
			Value... argumentValues) throws InvalidEvaluationException, InvalidValueException {
		ValueFactory valueFactory = evaluator.getValueFactory();
		EObject eObject = sourceValue.asNavigableObject();
		BasicEList<Object> arguments = new BasicEList<Object>();
		for (Value argumentValue : argumentValues) {
			arguments.add(argumentValue.asObject());
		}
		try {
			Object eResult = eObject.eInvoke(eOperation, arguments);
			DomainType returnType = callExp.getType();
			assert returnType != null;
			return getResultValue(valueFactory, returnType, eResult);
		} catch (InvocationTargetException e) {
			throw new InvalidValueException(e);
		}
	}

	public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, @NonNull Value sourceValue)
			throws InvalidValueException {
		ValueFactory valueFactory = evaluator.getValueFactory();
		EObject eObject = sourceValue.asNavigableObject();
		BasicEList<Object> arguments = new BasicEList<Object>();
		try {
			Object eResult = eObject.eInvoke(eOperation, arguments);
			return getResultValue(valueFactory, returnType, eResult);
		} catch (InvocationTargetException e) {
			throw new InvalidValueException(e);
		}
	}

	public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, @NonNull Value sourceValue,
			@NonNull Value argumentValue) throws InvalidValueException {
		ValueFactory valueFactory = evaluator.getValueFactory();
		EObject eObject = sourceValue.asNavigableObject();
		BasicEList<Object> arguments = new BasicEList<Object>();
		arguments.add(argumentValue.asObject());
		try {
			Object eResult = eObject.eInvoke(eOperation, arguments);
			return getResultValue(valueFactory, returnType, eResult);
		} catch (InvocationTargetException e) {
			throw new InvalidValueException(e);
		}
	}

	public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, @NonNull Value sourceValue,
			@NonNull Value firstArgumentValue, @NonNull Value secondArgumentValue) throws InvalidValueException {
		ValueFactory valueFactory = evaluator.getValueFactory();
		EObject eObject = sourceValue.asNavigableObject();
		BasicEList<Object> arguments = new BasicEList<Object>();
		arguments.add(firstArgumentValue.asObject());
		arguments.add(secondArgumentValue.asObject());
		try {
			Object eResult = eObject.eInvoke(eOperation, arguments);
			return getResultValue(valueFactory, returnType, eResult);
		} catch (InvocationTargetException e) {
			throw new InvalidValueException(e);
		}
	}

	protected @NonNull Value getResultValue(@NonNull ValueFactory valueFactory, @NonNull DomainType returnType, Object eResult) throws InvalidValueException {
		if (returnType instanceof DomainCollectionType) {
			if (eResult instanceof Iterable<?>) {
				Iterable<?> eResults = (Iterable<?>) eResult;
				if (returnType.isOrdered()) {
					if (returnType.isUnique()) {
						return valueFactory.createOrderedSetOf(eResults);
					}
					else {
						return valueFactory.createSequenceOf(eResults);
					}
				}
				else {
					if (returnType.isUnique()) {
						return valueFactory.createSetOf(eResults);
					}
					else {
						return valueFactory.createBagOf(eResults);
					}
				}
			}
			else {
				throw new InvalidValueException("Non-iterable result");
			}
		} else if (eResult != null) {
			@SuppressWarnings("null") @NonNull EClassifier eType = eOperation.getEType();
			return valueFactory.valueOf(eResult, eType);
		}
		else {
			return valueFactory.getNull();
		}
	}
}