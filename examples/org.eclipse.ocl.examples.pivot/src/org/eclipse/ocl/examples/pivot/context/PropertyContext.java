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
package org.eclipse.ocl.examples.pivot.context;

import org.eclipse.emf.common.util.URI;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;

/**
 * PropertyContext supports parsing OCL expressions in the context of a Property.
 */
public class PropertyContext extends ClassContext
{
//	private final Property propertyContext;
	
	public PropertyContext(MetaModelManager metaModelManager, URI uri, Property propertyContext) {
		super(metaModelManager, uri, propertyContext.getOwningType());
//		this.propertyContext = propertyContext;
	}
}
