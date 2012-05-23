/**
 * <copyright>
 * 
 * Copyright (c) 2010,2011 Kenn Hussey and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Kenn Hussey - Initial API and implementation
 *   E.D.Willink - Bug 353171
 * 
 * </copyright>
 *
 * $Id: OCLQueryDelegateFactory.java,v 1.4 2011/04/20 19:02:46 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.delegate;

import java.util.Map;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.util.QueryDelegate;
import org.eclipse.ocl.common.delegate.DelegateResourceSetAdapter;

/**
 * Factory for OCL query delegates.
 * <p>
 * The factory may be obtained by:
 * <pre>
 * QueryDelegate.Factory factory = QueryDelegate.Factory.Registry.INSTANCE
 *		.getFactory(OCLDelegateDomain.OCL_DELEGATE_URI);
 * </pre>
 * from which a query delegate may be created by: 
 * <pre>
 * QueryDelegate delegate = factory.createQueryDelegate(
 * 		classifier,                 // the context type
 * 		map-of-name-to-classifier,  // the external variable names and types
 * 		string);                    // the OCL expression text
 * </pre>
 * and (repeatedly) invoked by: 
 * <pre>
 * Object result = delegate.execute(
 * 		target,                     // the context instance
 * 		map-of-name-to-object);     // the external variable bindings
 * </pre>
 */
public class OCLQueryDelegateFactory extends AbstractOCLDelegateFactory
		implements QueryDelegate.Factory {
	public OCLQueryDelegateFactory(String delegateURI) {
		super(delegateURI);
	}

	public QueryDelegate createQueryDelegate(EClassifier context, Map<String, EClassifier> parameters, String expression) {
		OCLDelegateDomain delegateDomain = loadDelegateDomain(context.getEPackage());
		return new OCLQueryDelegate(delegateDomain, context, parameters, expression);
	}
	
	/**
	 * The Global variant of the Factory delegates to a local ResourceSet factory if one
	 * can be located at the QueryDelegate.Factory.Registry
	 * by the DelegateResourceSetAdapter.
	 */
	public static class Global extends OCLQueryDelegateFactory
	{
		public Global() {
			super(OCLDelegateDomain.OCL_DELEGATE_URI_PIVOT);
		}

		@Override
		public QueryDelegate createQueryDelegate(EClassifier context,
				Map<String, EClassifier> parameters, String expression) {
			QueryDelegate.Factory.Registry localRegistry = DelegateResourceSetAdapter.getRegistry(
				context, QueryDelegate.Factory.Registry.class, null);
			if (localRegistry != null) {
				QueryDelegate.Factory factory = localRegistry.getFactory(delegateURI);
				if (factory != null) {
					return factory.createQueryDelegate(context, parameters, expression);
				}
			}
			return super.createQueryDelegate(context, parameters, expression);
		}	
	}
}
