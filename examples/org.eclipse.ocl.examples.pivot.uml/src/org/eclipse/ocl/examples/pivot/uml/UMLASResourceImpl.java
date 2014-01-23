/**
 * <copyright>
 *
 * Copyright (c) 2010, 2011 E.D.Willink and others.
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
package org.eclipse.ocl.examples.pivot.uml;

import java.io.IOException;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.resource.ASResourceFactory;
import org.eclipse.ocl.examples.pivot.resource.ASResourceImpl;
import org.eclipse.ocl.examples.pivot.utilities.AS2XMIid;

public class UMLASResourceImpl extends ASResourceImpl
{
	public UMLASResourceImpl(@NonNull URI uri, @NonNull ASResourceFactory asResourceFactory) {
		super(uri, asResourceFactory);
	}

	@Override
	public EObject getEObject(String uriFragment) {
		if (idToEObjectMap == null) {
			AS2XMIid as2id = new AS2XMIid();
			as2id.assignIds(this, null);
		}
		return super.getEObject(uriFragment);
	}

	@Override
	public void load(Map<?, ?> options) throws IOException {
		@SuppressWarnings("null")@NonNull URI umlURI = uri.trimFileExtension();
		UML2Pivot.loadFromUML(this, umlURI);
		super.load(options);
	}
}