/**
 * <copyright>
 *
 * Copyright (c) 2013 E.D.Willink and others.
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
package org.eclipse.ocl.examples.test.xtext;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.RootXMLContentHandlerImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.internal.resource.XMI2UMLResourceFactoryImpl;
import org.eclipse.uml2.uml.resource.CMOF2UMLResourceHandler;
import org.eclipse.uml2.uml.resource.XMI2UMLExtendedMetaData;
import org.eclipse.uml2.uml.resource.XMI2UMLResource;

/**
 * XMI252UMLResourceFactoryImpl supports loading OMG UML 2.5 XMI files as Eclipse UML 4.0 resources.
 * <p>
 * install() should be invoked to initialize a ResourceSet with the locations of the UML 2.5 XMI files.
 * <p>
 * Thereafter ReseourceSet.getResource(...) should work.
 *
 */
@SuppressWarnings("restriction")
public class XMI252UMLResourceFactoryImpl extends XMI2UMLResourceFactoryImpl implements XMI2UMLResource.Factory
{
	private static final String UML_2_5_CONTENT_TYPE_IDENTIFIER = "org.omg.uml_2_5"; //$NON-NLS-1$
	private static final String UML_METAMODEL_2_5_NS_URI = "http://www.omg.org/spec/UML/20131001";

	private static final ContentHandler OMG_2_5_CONTENT_HANDLER = new RootXMLContentHandlerImpl(
		UML_2_5_CONTENT_TYPE_IDENTIFIER, new String[]{XMI2UMLResource.FILE_EXTENSION},
		RootXMLContentHandlerImpl.XMI_KIND, UML_METAMODEL_2_5_NS_URI, null);

	public static void install(@NonNull ResourceSet resourceSet, @NonNull URI uml25uri) {
		URIConverter uriConverter = resourceSet.getURIConverter();
		List<ContentHandler> contentHandlers = uriConverter.getContentHandlers();
		if (!contentHandlers.contains(OMG_2_5_CONTENT_HANDLER)) {
			contentHandlers.add(0, OMG_2_5_CONTENT_HANDLER);
		}
		resourceSet.getResourceFactoryRegistry().getContentTypeToFactoryMap().put(
			UML_2_5_CONTENT_TYPE_IDENTIFIER, new XMI252UMLResourceFactoryImpl());
		Map<URI, URI> uriMap = uriConverter.getURIMap();
		uriMap.put(URI.createURI("http://www.omg.org/spec/DD/20131001/"), uml25uri);
		uriMap.put(URI.createURI("http://www.omg.org/spec/UML/20131001/"), uml25uri);
	}
	
	protected static class XMI252UMLExtendedMetaData extends XMI2UMLExtendedMetaData
	{
		public XMI252UMLExtendedMetaData(EPackage.Registry registry) {
			super(registry);
		}

		@Override
		public EPackage getPackage(String namespace) {
			if (namespace != null) {
				if (UML_METAMODEL_2_5_NS_URI.equals(namespace)) {
					return UMLPackage.eINSTANCE;
				}
				else if ("http://www.omg.org/spec/MOF/20131001".equals(namespace)) {
					return demandPackage(namespace);
				}
				else if ("http://www.omg.org/spec/XMI/20131001".equals(namespace)) {
					return demandPackage(namespace);
				}
			}
			return super.getPackage(namespace);
		}
	}

	@Override
	public Resource createResource(URI uri) {
		XMI2UMLResource resource = (XMI2UMLResource) super.createResource(uri);

		ExtendedMetaData extendedMetaData = new XMI252UMLExtendedMetaData(EPackage.Registry.INSTANCE);

		Map<Object, Object> defaultSaveOptions = resource.getDefaultSaveOptions();

		defaultSaveOptions.put(XMLResource.OPTION_EXTENDED_META_DATA, extendedMetaData);
		defaultSaveOptions.put(XMLResource.OPTION_SAVE_TYPE_INFORMATION, Boolean.TRUE);

		Map<Object, Object> defaultLoadOptions = resource.getDefaultLoadOptions();

		defaultLoadOptions.put(XMLResource.OPTION_EXTENDED_META_DATA, extendedMetaData);
		defaultLoadOptions.put(XMLResource.OPTION_RESOURCE_HANDLER, new CMOF2UMLResourceHandler(null));

		return resource;
	}
}