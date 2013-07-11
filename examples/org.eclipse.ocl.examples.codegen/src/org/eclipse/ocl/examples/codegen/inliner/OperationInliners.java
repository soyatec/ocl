/**
 * <copyright>
 * 
 * Copyright (c) 2013 CEA LIST and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink(CEA LIST) - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.ocl.examples.codegen.inliner;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.util.BasicInternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainCallExp;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.OperationId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractPolyOperation;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;

@Deprecated   // Maintained temporarily for non-modelled CG compatibility
public class OperationInliners
{
	public static class UnboxedInvocationOperation extends AbstractPolyOperation
	{
		protected @NonNull OperationId operationId;
		private EOperation eOperation = null;
		
		public UnboxedInvocationOperation(@NonNull OperationId operationId) {
			this.operationId = operationId;
			// FIXME static attempt at eFeature
		}

		@Nullable
		public Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainCallExp callExp, @Nullable Object sourceValue, Object... argumentValues)  {
			assert sourceValue != null;
			EObject eObject = (EObject)sourceValue; 
			EOperation eOperation2 = eOperation;
			if (eOperation2 == null) {
				eOperation = eOperation2 = getEOperation(eObject);
			}
			EList<Object> args = new BasicInternalEList<Object>(Object.class);
			for (Object argumentValue : argumentValues) {
				args.add(argumentValue);
			}
			try {
				return eObject.eInvoke(eOperation2, args);
			} catch (InvocationTargetException e) {
				throw new InvalidValueException(e, "Null Operation");
			}
		}
		
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue) {
			assert sourceValue != null;
			EObject eObject = (EObject)sourceValue; 
			EOperation eOperation2 = eOperation;
			if (eOperation2 == null) {
				eOperation = eOperation2 = getEOperation(eObject);
			}
			EList<Object> args = new BasicInternalEList<Object>(Object.class);
			args.add(sourceValue);
			try {
				return eObject.eInvoke(eOperation2, args);
			} catch (InvocationTargetException e) {
				throw new InvalidValueException(e, "Null Operation");
			}
		}

		@Nullable
		public Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue, @Nullable Object argumentValue) {
			assert sourceValue != null;
			EObject eObject = (EObject)sourceValue; 
			EOperation eOperation2 = eOperation;
			if (eOperation2 == null) {
				eOperation = eOperation2 = getEOperation(eObject);
			}
			EList<Object> args = new BasicInternalEList<Object>(Object.class);
			args.add(argumentValue);
			try {
				return eObject.eInvoke(eOperation2, args);
			} catch (InvocationTargetException e) {
				throw new InvalidValueException(e, "Null Operation");
			}
		}

		@Nullable
		public Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue, @Nullable Object firstArgumentValue, @Nullable Object secondArgumentValue) {
			assert sourceValue != null;
			EObject eObject = (EObject)sourceValue; 
			EOperation eOperation2 = eOperation;
			if (eOperation2 == null) {
				eOperation = eOperation2 = getEOperation(eObject);
			}
			EList<Object> args = new BasicInternalEList<Object>(Object.class);
			args.add(firstArgumentValue);
			args.add(secondArgumentValue);
			try {
				return eObject.eInvoke(eOperation2, args);
			} catch (InvocationTargetException e) {
				throw new InvalidValueException(e, "Null Operation");
			}
		}

		protected @NonNull EOperation getEOperation(EObject eObject) {
			EClass eClass = eObject.eClass();
			for (EOperation eOperation : eClass.getEAllOperations()) {
				if (operationId.getName().equals(eOperation.getName())) {
					return eOperation;				// FIXME check argument lists
				}
			}
			throw new InvalidValueException("No such operation", operationId);
		}
	}
}
