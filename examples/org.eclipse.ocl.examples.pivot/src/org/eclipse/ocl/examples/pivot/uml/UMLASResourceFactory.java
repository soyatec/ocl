/**
 * <copyright>
 *
 * Copyright (c) 2013 E.D.Willink and others.
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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.ParserException;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.resource.ASResource;
import org.eclipse.ocl.examples.pivot.resource.AbstractASResourceFactory;
import org.eclipse.uml2.uml.resource.UMLResource;

public final class UMLASResourceFactory extends AbstractASResourceFactory
{
	public static final @NonNull UMLASResourceFactory INSTANCE = new UMLASResourceFactory();
	
	protected UMLASResourceFactory() {
		super(ASResource.UML_CONTENT_TYPE, null);
	}

	@Override
	public int getHandlerPriority(@NonNull EObject eObject) {
		if (eObject instanceof org.eclipse.uml2.uml.Element) {
			return CAN_HANDLE;
		}
		if (eObject.eResource() instanceof UMLResource) {
			return CAN_HANDLE;		// e.g. A StereotypeApplication
		}
		return CANNOT_HANDLE;
	}

	@Override
	public int getHandlerPriority(@NonNull Resource resource) {
		return UML2Pivot.isUML(resource) ? CAN_HANDLE : CANNOT_HANDLE;
	}

	@Override
	public int getHandlerPriority(@NonNull URI uri) {
		return "uml".equals(uri.fileExtension()) ? CAN_HANDLE : CANNOT_HANDLE;
	}

	@Override
	public void configure(@NonNull ResourceSet resourceSet) {
		super.configure(resourceSet);
		OCL.initialize(resourceSet);
	}

	@Override
	public @Nullable <T extends Element> T getASElement(@NonNull MetaModelManager metaModelManager,
			@NonNull Class<T> pivotClass, @NonNull EObject eObject) throws ParserException {
		Resource metaModel = eObject.eResource();
		if (metaModel == null) {
			return null;
		}
		UML2Pivot uml2pivot = UML2Pivot.getAdapter(metaModel, metaModelManager);
		uml2pivot.getPivotRoot();
		return uml2pivot.getCreated(pivotClass, eObject);
	}

	@Override
	public @Nullable URI getPackageURI(@NonNull EObject eObject) {
		if (eObject instanceof org.eclipse.uml2.uml.Package) {
			String uri = ((org.eclipse.uml2.uml.Package)eObject).getURI();
			if (uri != null) {
				return URI.createURI(uri);
			}
		}
		return null;
	}

	@Override
	public @Nullable Element importFromResource(@NonNull MetaModelManager metaModelManager, @NonNull Resource umlResource, @Nullable URI uri) throws ParserException {
		UML2Pivot conversion = UML2Pivot.getAdapter(umlResource, metaModelManager);
		conversion.setUMLURI(uri);
		Root pivotRoot = conversion.getPivotRoot();
		String uriFragment = uri != null ? uri.fragment() : null;
		if (uriFragment == null) {
			return pivotRoot;
		}
		else {
			EObject eObject = umlResource.getEObject(uriFragment);
			if (eObject == null) {
				return null;
			}
			return conversion.getCreated(Element.class, eObject);
		}
	}
}