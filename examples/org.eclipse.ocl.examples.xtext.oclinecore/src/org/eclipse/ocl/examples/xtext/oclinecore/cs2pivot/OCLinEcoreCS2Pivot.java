/**
 * <copyright>
 *
 * Copyright (c) 2010, 2013 E.D.Willink and others.
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
 * $Id: OCLinEcoreCS2Pivot.java,v 1.4 2011/05/20 15:27:12 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.cs2pivot;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ParserException;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.xtext.base.baseCST.PackageCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.RootPackageCS;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.essentialocl.cs2pivot.EssentialOCLCS2Pivot;
import org.eclipse.ocl.examples.xtext.oclinecore.utilities.OCLinEcoreCSResource;

public class OCLinEcoreCS2Pivot extends EssentialOCLCS2Pivot 
{	
	private static final class Factory extends MetaModelManager.AbstractFactory
	{
		private Factory() {
			MetaModelManager.addFactory(this);
		}

		@Override
		public int getHandlerPriority(@NonNull Resource resource) {
			return resource instanceof OCLinEcoreCSResource ? CAN_HANDLE : CANNOT_HANDLE;
		}

		public void configure(@NonNull ResourceSet resourceSet) {}

		public URI getPackageURI(@NonNull EObject eObject) {
			if (eObject instanceof RootPackageCS) {
				Element pivot = ((RootPackageCS)eObject).getPivot();
				if (pivot instanceof Root) {
					String uri = ((Root)pivot).getExternalURI();
					if (uri != null) {
						if (uri.endsWith("oclinecore")) {
							uri = uri.substring(0, uri.length()-10) + "ecore"; 
						}
						return URI.createURI(uri);
					}
				}
			}
			else if (eObject instanceof PackageCS) {
				Element pivot = ((PackageCS)eObject).getPivot();
				if (pivot instanceof org.eclipse.ocl.examples.pivot.Package) {
					String uri = ((org.eclipse.ocl.examples.pivot.Package)pivot).getNsURI();
					if (uri != null) {
						return URI.createURI(uri);
					}
				}
			}
			return null;
		}

		public <T extends Element> T getPivotOf(@NonNull MetaModelManager metaModelManager,
				@NonNull Class<T> pivotClass, @NonNull EObject eObject)throws ParserException {
			throw new UnsupportedOperationException();
		}

		public @Nullable Element importFromResource(@NonNull MetaModelManager metaModelManager, @NonNull Resource resource, @Nullable URI uri) {
			Resource pivotResource = ((OCLinEcoreCSResource)resource).getPivotResource(metaModelManager);
			List<EObject> contents = pivotResource.getContents();
			if (contents.size() <= 0) {
				return null;
			}
			if ((uri != null) && (uri.fragment() == null)) {
				return (Element) contents.get(0);
			}
			else {
				throw new UnsupportedOperationException();	// FIXME
			}
		}
	}

	public static @NonNull MetaModelManager.Factory FACTORY = new Factory();
		
	public OCLinEcoreCS2Pivot(@NonNull Map<? extends Resource, ? extends Resource> cs2pivotResourceMap, @NonNull MetaModelManager metaModelManager) {
		super(cs2pivotResourceMap, metaModelManager);
	}

	@Override
	protected @NonNull OCLinEcoreContainmentVisitor createContainmentVisitor(@NonNull CS2PivotConversion converter) {
		return new OCLinEcoreContainmentVisitor(converter);
	}

	@Override
	protected @NonNull OCLinEcoreLeft2RightVisitor createLeft2RightVisitor(@NonNull CS2PivotConversion converter) {
		return new OCLinEcoreLeft2RightVisitor(converter);
	}

	@Override
	protected @NonNull OCLinEcorePostOrderVisitor createPostOrderVisitor(@NonNull CS2PivotConversion converter) {
		return new OCLinEcorePostOrderVisitor(converter);
	}

	@Override
	protected @NonNull OCLinEcorePreOrderVisitor createPreOrderVisitor(@NonNull CS2PivotConversion converter) {
		return new OCLinEcorePreOrderVisitor(converter);
	}
}
