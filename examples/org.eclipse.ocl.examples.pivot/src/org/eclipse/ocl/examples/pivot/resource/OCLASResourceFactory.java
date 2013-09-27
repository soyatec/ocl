/**
 * <copyright>
 *
 * Copyright (c) 2010, 2012 E.D.Willink and others.
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
 * $Id: PivotResourceFactoryImpl.java,v 1.2 2011/01/24 20:42:33 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.resource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.xmi.impl.RootXMLContentHandlerImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.library.StandardLibraryContribution;

/**
 * The <b>Resource Factory</b> associated with the package.
 * @see org.eclipse.ocl.examples.pivot.utilities.PivotResourceImpl
 */
public class OCLASResourceFactory extends AbstractASResourceFactory
{
	public static final @NonNull OCLASResourceFactory INSTANCE = new OCLASResourceFactory();

	private static final @NonNull ContentHandler PIVOT_CONTENT_HANDLER = new RootXMLContentHandlerImpl(
		ASResource.CONTENT_TYPE, new String[]{ASResource.FILE_EXTENSION},
		RootXMLContentHandlerImpl.XMI_KIND, PivotPackage.eNS_URI, null);

	static {
		installContentHandler(ContentHandler.Registry.NORMAL_PRIORITY, PIVOT_CONTENT_HANDLER);
	}

	/**
	 * Creates an instance of the resource factory.
	 */
	public OCLASResourceFactory() {
		super(ASResource.CONTENT_TYPE, ASResource.FILE_EXTENSION);
	}

	@Override
	public Resource createResource(URI uri) {
		if ((uri.isFile() || uri.isPlatform()) && URIConverter.INSTANCE.exists(uri, null)) {
			return super.createResource(uri);
		}
		URI nonASuri = uri.trimFileExtension();
		@SuppressWarnings("null")@NonNull String nonASuriString = nonASuri.toString();
		StandardLibraryContribution standardLibraryContribution = StandardLibraryContribution.REGISTRY.get(nonASuriString);
		if (standardLibraryContribution != null) {
			return standardLibraryContribution.getResource();
		}
		ASResourceFactory asResourceFactory = ASResourceFactoryRegistry.INSTANCE.getResourceFactory(nonASuri);
	    return asResourceFactory != null ? asResourceFactory.createResource(uri) : null;
	}
}
