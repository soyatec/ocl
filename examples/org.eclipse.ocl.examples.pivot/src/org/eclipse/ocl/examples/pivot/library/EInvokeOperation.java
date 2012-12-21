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

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
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
			Object... argumentValues) throws Exception {
		EObject eObject = asNavigableObject(sourceValue);
		BasicEList<Object> arguments = new BasicEList<Object>();
		for (Object argumentValue : argumentValues) {
			assert argumentValue != null;
			arguments.add(asObject(argumentValue));
		}
//		try {
			Object eResult = eObject.eInvoke(eOperation, arguments);
			DomainType returnType = callExp.getType();
			assert returnType != null;
			return getResultValue(returnType.getTypeId(), eResult);
//		} catch (InvocationTargetException e) {
//			return createInvalidValue(e);
//		}
	}

	public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue) throws Exception {
		EObject eObject = asNavigableObject(sourceValue);
		BasicEList<Object> arguments = new BasicEList<Object>();
//		try {
			Object eResult = eObject.eInvoke(eOperation, arguments);
			return getResultValue(returnTypeId, eResult);
//		} catch (InvocationTargetException e) {
//			return createInvalidValue(e);
//		}
	}

	public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue,
			@Nullable Object argumentValue) throws Exception {
		EObject eObject = asNavigableObject(sourceValue);
		BasicEList<Object> arguments = new BasicEList<Object>();
		arguments.add(asObject(argumentValue));
//		try {
			Object eResult = eObject.eInvoke(eOperation, arguments);
			return getResultValue(returnTypeId, eResult);
//		} catch (InvocationTargetException e) {
//			return createInvalidValue(e);
//		}
	}

	public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue,
			@Nullable Object firstArgumentValue, @Nullable Object secondArgumentValue) throws Exception {
		EObject eObject = asNavigableObject(sourceValue);
		BasicEList<Object> arguments = new BasicEList<Object>();
		arguments.add(asObject(firstArgumentValue));
		arguments.add(asObject(secondArgumentValue));
//		try {
			Object eResult = eObject.eInvoke(eOperation, arguments);
			return getResultValue(returnTypeId, eResult);
//		} catch (InvocationTargetException e) {
//			return createInvalidValue(e);
//		}
	}

	protected @Nullable Object getResultValue(@NonNull TypeId returnTypeId, @Nullable Object eResult) throws Exception {
		if (returnTypeId instanceof CollectionTypeId) {
			if (eResult instanceof Iterable<?>) {
				return createCollectionValue((CollectionTypeId)returnTypeId, (Iterable<?>)eResult);
			}
			else {
				throw new InvalidValueException("Non-iterable result");
			}
		} else if (eResult != null) {
			@SuppressWarnings("null") @NonNull EClassifier eType = eOperation.getEType();
			return valueOf(eResult, eType);
		}
		else {
			return null;
		}
	}
}