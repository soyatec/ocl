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
 * $Id$
 */
package org.eclipse.ocl.examples.library.ecore;

import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.DomainModelManager;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.ValueFactory;
import org.eclipse.ocl.examples.library.executor.ExecutorManager;
import org.eclipse.ocl.examples.library.executor.LazyModelManager;

public class EcoreExecutorManager extends ExecutorManager
{
	protected static @NonNull ValueFactory getValueFactory(@NonNull EObject contextObject, @Nullable Map<Object, Object> contextMap, @NonNull DomainStandardLibrary standardLibrary) {
		if (contextMap != null) {
			Object valueFactory = contextMap.get(ValueFactory.class);
			if (valueFactory instanceof ValueFactory) {
				return (ValueFactory) valueFactory;
			}
		}
		EPackage ePackage = contextObject.eClass().getEPackage();
		EList<Adapter> eAdapters = ePackage.eAdapters();
		for (Adapter adapter : eAdapters) {
			if (adapter instanceof ValueFactory) {
				return (ValueFactory) adapter;
			}
		}
		EcoreValueFactory ecoreValueFactory = new EcoreValueFactory(standardLibrary);
		eAdapters.add(ecoreValueFactory);
		return ecoreValueFactory;
	}

	private final @NonNull EObject contextObject;
	private final Map<Object, Object> contextMap;
	private LazyModelManager modelManager = null;
	
	public EcoreExecutorManager(@NonNull EObject contextObject, @NonNull DomainStandardLibrary standardLibrary) {
		this(contextObject, null, standardLibrary);
	}

	public EcoreExecutorManager(@NonNull EObject contextObject, @Nullable Map<Object, Object> contextMap, @NonNull DomainStandardLibrary standardLibrary) {
		super(getValueFactory(contextObject, contextMap, standardLibrary));
		this.contextObject = contextObject;
		this.contextMap = contextMap;
	}

	public @NonNull DomainEvaluator createNestedEvaluator() {
		return new EcoreExecutorManager(contextObject, contextMap, valueFactory.getStandardLibrary());
	}

	public @NonNull DomainModelManager getModelManager() {
		if (modelManager == null) {
			modelManager = new LazyModelManager(contextObject)
			{
				@Override
				protected boolean isInstance(@NonNull DomainType type, @NonNull EObject element) {
					EClass eClass = DomainUtil.nonNullEMF(element.eClass());
					DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
					DomainType elementType = standardLibrary.getType(eClass);
					return elementType.conformsTo(standardLibrary, type);
				}
				
			};
		}
		return DomainUtil.nonNullJDT(modelManager);
	}
}