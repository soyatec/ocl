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
 *   E.D.Willink - Initial API and implementation
 * 	 E.D.Willink - Bug 306079
 *
 * </copyright>
 *
 * $Id: DelegateEClassifierAdapter.java,v 1.1 2011/01/30 11:16:29 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.delegate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;

/**
 * DelegateEClassifierAdapter extends an EClassifier to cache its ValidationDelegate.
 */
public class DelegateEClassifierAdapter extends AdapterImpl {

	public static @NonNull DelegateEClassifierAdapter getAdapter(@NonNull EClassifier eClassifier) {
		DelegateEClassifierAdapter adapter = (DelegateEClassifierAdapter) EcoreUtil
			.getAdapter(eClassifier.eAdapters(), DelegateEClassifierAdapter.class);
		if (adapter == null) {
			adapter = new DelegateEClassifierAdapter();
			eClassifier.eAdapters().add(adapter);
		}
		return adapter;
	}

	protected Map<String, ValidationDelegate> validationDelegateMap;

	public @Nullable ValidationDelegate getValidationDelegate(@NonNull String delegateURI) {
		if (validationDelegateMap == null) {
			getValidationDelegates();
		}
		return validationDelegateMap.get(delegateURI);
	}
	
	public @NonNull Map<String, ValidationDelegate> getValidationDelegates() {
		Map<String, ValidationDelegate> validationDelegateMap2 = validationDelegateMap;
		if (validationDelegateMap2 == null) {
			EClassifier eClassifier = DomainUtil.nonNullState(getTarget());
			validationDelegateMap2 = validationDelegateMap = new HashMap<String, ValidationDelegate>();
			List<ValidationDelegate.Factory> factories = ValidationBehavior.INSTANCE.getFactories(eClassifier);
			if (eClassifier instanceof EClass) {
				for (EOperation eOperation : ((EClass)eClassifier).getEOperations()) {
					if ((eOperation != null) && EcoreUtil.isInvariant(eOperation)) {					
						List<DelegateDomain> opDelegateDomains = InvocationBehavior.INSTANCE.getDelegateDomains(eOperation);
						for (DelegateDomain opDelegateDomain : opDelegateDomains) {
							if (opDelegateDomain != null) {
								ValidationDelegate.Factory opFactory = ValidationBehavior.INSTANCE.getFactory(opDelegateDomain, eClassifier);
								if ((opFactory != null) && !factories.contains(opFactory)) {
									factories.add(opFactory);
								}
							}
						}
					}
				}
			}
			if (!factories.isEmpty()) {
				for (ValidationDelegate.Factory factory : factories) {
					ValidationDelegate validationDelegate = factory.createValidationDelegate(eClassifier);
					if (validationDelegate != null) {
						validationDelegateMap2.put(factory.getURI(), validationDelegate);
					}
				}
			} 
		}
		return validationDelegateMap2;
	}

	@Override
	public EClassifier getTarget() {
		return (EClassifier) super.getTarget();
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return type == DelegateEClassifierAdapter.class;
	}

	@Override
	public void setTarget(Notifier newTarget) {
		EClassifier resourceSet = (EClassifier) newTarget;
		super.setTarget(resourceSet);
	}
}
