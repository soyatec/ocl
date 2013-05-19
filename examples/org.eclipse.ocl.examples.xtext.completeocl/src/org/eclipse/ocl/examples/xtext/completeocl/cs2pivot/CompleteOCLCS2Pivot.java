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
 * $Id: CompleteOCLCS2Pivot.java,v 1.4 2011/05/20 15:26:51 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl.cs2pivot;

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
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.completeocl.utilities.CompleteOCLCSResource;
import org.eclipse.ocl.examples.xtext.essentialocl.cs2pivot.EssentialOCLCS2Pivot;

public class CompleteOCLCS2Pivot extends EssentialOCLCS2Pivot
{	
	public static @NonNull MetaModelManager.Factory FACTORY = new Factory();

	private static final class Factory extends MetaModelManager.AbstractFactory
	{
		private Factory() {
			MetaModelManager.addFactory(this);
		}

		@Override
		public int getHandlerPriority(@NonNull Resource resource) {
			return resource instanceof CompleteOCLCSResource ? CAN_HANDLE : CANNOT_HANDLE;
		}

		public void configure(@NonNull ResourceSet resourceSet) {}

		public URI getPackageURI(@NonNull EObject eObject) {
			return null;
		}

		public <T extends Element> T getPivotOf(@NonNull MetaModelManager metaModelManager,
				@NonNull Class<T> pivotClass, @NonNull EObject eObject)throws ParserException {
			throw new UnsupportedOperationException();
		}

		public @Nullable Element importFromResource(@NonNull MetaModelManager metaModelManager, @NonNull Resource resource, @Nullable URI uri) {
			Resource pivotResource = ((CompleteOCLCSResource)resource).getPivotResource(metaModelManager);
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
		
	public CompleteOCLCS2Pivot(@NonNull Map<? extends Resource, ? extends Resource> cs2pivotResourceMap, @NonNull MetaModelManager metaModelManager) {
		super(cs2pivotResourceMap, metaModelManager);
	}

	@Override
	protected @NonNull CompleteOCLContainmentVisitor createContainmentVisitor(@NonNull CS2PivotConversion converter) {
		return new CompleteOCLContainmentVisitor(converter);
	}

	@Override
	protected @NonNull CompleteOCLLeft2RightVisitor createLeft2RightVisitor(@NonNull CS2PivotConversion converter) {
		return new CompleteOCLLeft2RightVisitor(converter);
	}

	@Override
	protected @NonNull CompleteOCLPostOrderVisitor createPostOrderVisitor(@NonNull CS2PivotConversion converter) {
		return new CompleteOCLPostOrderVisitor(converter);
	}

	@Override
	protected @NonNull CompleteOCLPreOrderVisitor createPreOrderVisitor(@NonNull CS2PivotConversion converter) {
		return new CompleteOCLPreOrderVisitor(converter);
	}
}
