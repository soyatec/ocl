/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.common.delegate;

import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EOperation.Internal.InvocationDelegate;

/**
 * OCLInvocationDelegateMapping provides a Factory entry that maps one delegate URI key to another.
 */
public class OCLInvocationDelegateMapping implements EOperation.Internal.InvocationDelegate.Factory
{
	protected final EOperation.Internal.InvocationDelegate.Factory.Registry registry;
	protected final VirtualDelegateMapping virtualDelegateMapping;
	
	public OCLInvocationDelegateMapping() {
		this(EOperation.Internal.InvocationDelegate.Factory.Registry.INSTANCE, VirtualDelegateMapping.INSTANCE);
	}
	
	public OCLInvocationDelegateMapping(EOperation.Internal.InvocationDelegate.Factory.Registry registry, VirtualDelegateMapping virtualDelegateMapping) {
		this.registry = registry;
		this.virtualDelegateMapping = virtualDelegateMapping;
	}

	public InvocationDelegate createInvocationDelegate(EOperation operation) {
		String delegateURI = virtualDelegateMapping.getDefaultValue();
		EOperation.Internal.InvocationDelegate.Factory factory = registry.getFactory(delegateURI);
		return factory.createInvocationDelegate(operation);
	}
}