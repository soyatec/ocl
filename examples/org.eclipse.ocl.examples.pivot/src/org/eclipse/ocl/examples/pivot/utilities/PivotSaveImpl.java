/**
 * <copyright>
 *
 * Copyright (c) 2010,2011 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: PivotSaveImpl.java,v 1.2 2011/01/24 20:42:33 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.utilities;

import java.util.Map;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMISaveImpl;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;

/**
 * PivotSaveImpl ensures that all references to specialized types are terminated
 * by local copies of the specialization.
 */
public final class PivotSaveImpl extends XMISaveImpl
{
	public PivotSaveImpl(XMLHelper helper) {
		super(helper);
	}

	/**
	 * Prepare a pivot resource for save by redirecting all type references to
	 * specializations to local copies of the specializations.
	 */
	@Override
	protected void init(XMLResource resource, Map<?, ?> options) {
		XMLResource asResource = DomainUtil.nonNullState(resource);
    	ResourceSet asResourceSet = DomainUtil.nonNullState(asResource.getResourceSet());
		ASSaver asSaver = new ASSaver(asResource);
		AS2XMIid as2xmIid = new AS2XMIid();
		asSaver.localizeSpecializations();
		asSaver.normalizeContents();
		as2xmIid.assignIds(asResourceSet);
		super.init(asResource, options);
	}
}