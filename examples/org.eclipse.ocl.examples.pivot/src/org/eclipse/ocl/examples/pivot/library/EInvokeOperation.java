/**
 * <copyright>
 *
 * Copyright (c) 2012, 2013 E.D.Willink and others.
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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.util.EcoreEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainCallExp;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractPolyOperation;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;

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

	public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainCallExp callExp, @Nullable Object sourceValue,
			Object... argumentValues) {
		EObject eObject = asNavigableObject(sourceValue);
		Object[] data = new Object[argumentValues.length];
		int i= 0;
		for (Object argumentValue : argumentValues) {
			assert argumentValue != null;
			data[i++] = asObject(argumentValue);
		}
		EList<Object> arguments = new EcoreEList.UnmodifiableEList<Object>(null, null, data.length, data);
		try {
			Object eResult = eObject.eInvoke(eOperation, arguments);
			DomainType returnType = callExp.getType();
			assert returnType != null;
			return getResultValue(evaluator, returnType.getTypeId(), eResult);
		} catch (InvocationTargetException e) {
			return createInvalidValue(e);
		}
	}

	public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue) {
		EObject eObject = asNavigableObject(sourceValue);
		EList<Object> arguments = new EcoreEList.UnmodifiableEList<Object>(null, null, 0, new Object[]{});
		try {
			Object eResult = eObject.eInvoke(eOperation, arguments);
			return getResultValue(evaluator, returnTypeId, eResult);
		} catch (InvocationTargetException e) {
			return createInvalidValue(e);
		}
	}

	public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue,
			@Nullable Object argumentValue) {
		EObject eObject = asNavigableObject(sourceValue);
		EList<Object> arguments = new EcoreEList.UnmodifiableEList<Object>(null, null, 1,
				new Object[]{asObject(argumentValue)});
		try {
			Object eResult = eObject.eInvoke(eOperation, arguments);
			return getResultValue(evaluator, returnTypeId, eResult);
		} catch (InvocationTargetException e) {
			return createInvalidValue(e);
		}
	}

	public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue,
			@Nullable Object firstArgumentValue, @Nullable Object secondArgumentValue) {
		EObject eObject = asNavigableObject(sourceValue);
		EList<Object> arguments = new EcoreEList.UnmodifiableEList<Object>(null, null, 2,
				new Object[]{asObject(firstArgumentValue), asObject(secondArgumentValue)});
		try {
			Object eResult = eObject.eInvoke(eOperation, arguments);
			return getResultValue(evaluator, returnTypeId, eResult);
		} catch (InvocationTargetException e) {
			return createInvalidValue(e);
		}
	}

	protected @Nullable Object getResultValue(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object eResult) {
		if (returnTypeId instanceof CollectionTypeId) {
			if (eResult instanceof Iterable<?>) {
				return evaluator.getIdResolver().createCollectionOfAll((CollectionTypeId)returnTypeId, (Iterable<?>)eResult);
			}
			else {
				throw new InvalidValueException("Non-iterable result");
			}
		} else if (eResult != null) {
			@SuppressWarnings("null") @NonNull EClassifier eType = eOperation.getEType();
			return evaluator.getIdResolver().boxedValueOf(eResult, eType);
		}
		else {
			return null;
		}
	}
}