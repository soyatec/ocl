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
package org.eclipse.ocl.examples.pivot.utilities;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.pivot.context.ParserContext;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;

/**
 * BaseResource defines the Xtext-independent extended interface for a Concrete Syntax resource
 * for which a ParserContext defines how the Abstract Syntax elements should
 * be initialized.
 */
public interface BaseResource extends Resource
{
	ParserContext getParserContext();
	Resource getPivotResource(MetaModelManager metaModelManager);
	void setParserContext(ParserContext parserContext);
	void updateFrom(Resource pivotResource, MetaModelManager metaModelManager);
}
