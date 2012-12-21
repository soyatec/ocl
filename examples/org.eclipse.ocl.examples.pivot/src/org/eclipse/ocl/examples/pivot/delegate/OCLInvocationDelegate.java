/**
 * <copyright>
 * 
 * Copyright (c) 2010,2011 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   C.Damus, K.Hussey, E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 *
 * $Id: OCLInvocationDelegate.java,v 1.3 2011/02/21 08:37:53 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.delegate;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.BasicInvocationDelegate;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.common.internal.delegate.OCLDelegateException;
import org.eclipse.ocl.examples.domain.evaluation.DomainException;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.Query;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
import org.eclipse.osgi.util.NLS;

/**
 * An implementation of an operation-invocation delegate for OCL body
 * expressions.
 */
public class OCLInvocationDelegate extends BasicInvocationDelegate
{
	protected final OCLDelegateDomain delegateDomain;
	private Operation operation;
	private ExpressionInOCL specification;

	/**
	 * Initializes me with my operation.
	 * 
	 * @param operation
	 *            the operation that I handle
	 */
	public OCLInvocationDelegate(@NonNull OCLDelegateDomain delegateDomain, @NonNull EOperation operation) {
		super(operation);
		this.delegateDomain = delegateDomain;
	}

	@Override
	public Object dynamicInvoke(InternalEObject target, EList<?> arguments) throws InvocationTargetException {
		try {
			OCL ocl = delegateDomain.getOCL();
			MetaModelManager metaModelManager = ocl.getMetaModelManager();
			ExpressionInOCL specification2 = specification;
			if (specification2 == null) {
				Operation operation2 = getOperation();
				specification2 = specification = InvocationBehavior.INSTANCE.getExpressionInOCL(metaModelManager, operation2);
				InvocationBehavior.INSTANCE.validate(operation2);
			}
			Query query = ocl.createQuery(specification2);
			EvaluationEnvironment env = query.getEvaluationEnvironment();
			List<Parameter> parms = operation.getOwnedParameter();
			if (!parms.isEmpty()) {
				// bind arguments to parameter names
				for (int i = 0; i < parms.size(); i++) {
					Object object = arguments.get(i);
					Object value = ValuesUtil.valueOf(object);
					env.add(DomainUtil.nonNullModel(parms.get(i)), value);
				}
			}
			Object result = query.evaluate(target);
//			if (result == null) {
//				String message = NLS.bind(OCLMessages.EvaluationResultIsInvalid_ERROR_, operation);
//				throw new InvocationTargetException(new OCLDelegateException(message));
//			}
			return metaModelManager.asEcoreObject(result);
		}
		catch (InvalidValueException e) {
			String message = NLS.bind(OCLMessages.EvaluationResultIsInvalid_ERROR_, operation);
			throw new InvocationTargetException(new OCLDelegateException(message));
		}
		catch (DomainException e) {
			String message = NLS.bind(OCLMessages.EvaluationResultIsInvalid_ERROR_, operation);
			throw new InvocationTargetException(new OCLDelegateException(message));
		}
		catch (OCLDelegateException e) {
			throw new InvocationTargetException(e);
		}
	}

	public @NonNull Operation getOperation() {
		Operation operation2 = operation;
		if (operation2 == null) {
			operation2 = operation = delegateDomain.getPivot(Operation.class, DomainUtil.nonNullEMF(eOperation));
			if (operation2 == null) {
				throw new OCLDelegateException("No pivot property for " + eOperation) ;
			}
		}
		return operation2;
	}
	
	@Override
	public String toString() {
		if (operation != null) {
			return "<" + delegateDomain.getURI() + ":invocation> " + operation; //$NON-NLS-1$ //$NON-NLS-2$
		}
		else {
			String name = eOperation.getEContainingClass().getEPackage().getName()
			+ "::" + eOperation.getEContainingClass().getName()
			+ "." + eOperation.getName();
			return "<" + delegateDomain.getURI() + ":invocation> " + name; //$NON-NLS-1$ //$NON-NLS-2$
		}
	}
}
