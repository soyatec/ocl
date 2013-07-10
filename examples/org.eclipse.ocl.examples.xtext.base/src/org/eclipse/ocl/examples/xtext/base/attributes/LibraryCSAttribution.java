/**
 * <copyright>
 *
 * Copyright (c) 2011, 2012 E.D.Willink and others.
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
 * $Id: LibraryAttribution.java,v 1.2 2011/05/22 16:42:05 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.attributes;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainElement;
import org.eclipse.ocl.examples.domain.elements.DomainNamedElement;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Library;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.library.StandardLibraryContribution;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManagerResourceSetAdapter;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
import org.eclipse.ocl.examples.pivot.scoping.AbstractAttribution;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.scoping.ScopeView;
import org.eclipse.ocl.examples.pivot.util.Pivotable;
import org.eclipse.ocl.examples.pivot.utilities.IllegalLibraryException;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.LibraryCS;
import org.eclipse.ocl.examples.xtext.base.cs2as.ValidationDiagnostic;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2Pivot.UnresolvedProxyMessageProvider;
import org.eclipse.ocl.examples.xtext.base.utilities.BaseCSResource;
import org.eclipse.osgi.util.NLS;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

public class LibraryCSAttribution extends AbstractAttribution implements UnresolvedProxyMessageProvider
{
	public static final LibraryCSAttribution INSTANCE = new LibraryCSAttribution();

	private static class LibraryAdapter extends AdapterImpl
	{
		private URI uri = null;
		private Element importedElement = null;
		private Throwable throwable = null;
	
		public ScopeView computeLookup(LibraryCS targetElement, EnvironmentView environmentView, ScopeView scopeView) {
			importLibrary(targetElement, environmentView);
			Element importedElement2 = importedElement;
			if (importedElement2 != null) {
				Resource importedResource = importedElement2.eResource();
				List<Resource.Diagnostic> errors = importedResource.getErrors();
				if (errors.size() == 0) {
					if (importedElement2 instanceof DomainNamedElement) {
						String name = ((DomainNamedElement)importedElement2).getName();
						if (name != null) {
							environmentView.addElement(name, importedElement2);
						}
					}
				}
			}
			return null;
		}
	
		public String getMessage() {
			return throwable != null ? throwable.getMessage() : null;
		}
	
		protected void importLibrary(LibraryCS target, EnvironmentView environmentView) {
			String name = environmentView.getName();
			if (name == null) {
				return;
			}
			StandardLibraryContribution contribution = StandardLibraryContribution.REGISTRY.get(name);
			if (contribution != null) {
				Resource resource = contribution.getResource();
				try {
					MetaModelManager metaModelManager = environmentView.getMetaModelManager();
					metaModelManager.installResource(resource);
					for (EObject root : resource.getContents()) {
						if (root instanceof Root) {
							for (DomainElement pkg : ((Root)root).getNestedPackage()) {
								if (pkg instanceof Library) {
									environmentView.addElement(name, pkg);									
								}
							}
						}
					}
				} catch (IllegalLibraryException e) {
					throwable = e;
				}
				return;
			}
			BaseCSResource csResource = (BaseCSResource) target.eResource();
			@NonNull URI uri2;
			try {
				@SuppressWarnings("null") @NonNull URI newURI = URI.createURI(name);
				newURI = csResource.resolve(newURI);
				if (newURI.equals(uri)) {
					return;
				}
				uri2 = uri = newURI;					// Lock out recursive attempt from EcoreUtil.resolveProxy
				importedElement = null;
				throwable = null;
			} catch (WrappedException e) {
				throwable = e.exception();
				return;
			} catch (Exception e) {
				throwable = e;
				return;
			}
			List<EObject> importedElements = new ArrayList<EObject>();
			ResourceSet csResourceSet = DomainUtil.nonNullState(csResource.getResourceSet());
			MetaModelManager metaModelManager = environmentView.getMetaModelManager();
			MetaModelManagerResourceSetAdapter.getAdapter(csResourceSet, metaModelManager);
			try {
				Resource importedResource = csResourceSet.getResource(uri2, true);
				List<EObject> contents = importedResource.getContents();
				if (contents.size() > 0) {
					for (EObject content : contents) {
						if (content instanceof Pivotable) {
							Element pivot = ((Pivotable)content).getPivot();
							importedElements.add(pivot);
							if (importedElement == null) {
								importedElement = pivot;		// FIXME Use a single RootElement
							}
						}
					}
				}
				List<Resource.Diagnostic> warnings = importedResource.getWarnings();
				if (warnings.size() > 0) {
					INode node = NodeModelUtils.getNode(target);
					String errorMessage = PivotUtil.formatResourceDiagnostics(warnings, DomainUtil.bind(OCLMessages.WarningsInURI, uri), "\n\t");
					Resource.Diagnostic resourceDiagnostic = new ValidationDiagnostic(node, errorMessage);
					csResource.getWarnings().add(resourceDiagnostic);
				}
				List<Resource.Diagnostic> errors = importedResource.getErrors();
				if (errors.size() > 0) {
					Diagnostic diagnostic = errors.get(0);
					if (diagnostic instanceof WrappedException) {
						throwable = ((WrappedException)diagnostic).exception();
					}
					else {
						INode node = NodeModelUtils.getNode(target);
						String errorMessage = PivotUtil.formatResourceDiagnostics(errors, "Errors in '" + uri + "'", "\n\t");
						Resource.Diagnostic resourceDiagnostic = new ValidationDiagnostic(node, errorMessage);
						csResource.getErrors().add(resourceDiagnostic);
					}
				}
			} catch (WrappedException e) {
				throwable = e.exception();
			} catch (Exception e) {
				throwable = e;
			}
		}

		@Override
		public boolean isAdapterForType(Object type) {
			return type == LibraryAdapter.class;
		}
	}

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		LibraryCS targetElement = (LibraryCS)target;
		LibraryAdapter adapter = PivotUtil.getAdapter(LibraryAdapter.class, targetElement);
		if (adapter == null) {
			adapter = new LibraryAdapter();
			targetElement.eAdapters().add(adapter);
		}
		return adapter.computeLookup(targetElement, environmentView, scopeView);
	}

	public @NonNull EReference getEReference() {
		@SuppressWarnings("null") @NonNull EReference libraryCsPackage = BaseCSTPackage.Literals.LIBRARY_CS__PACKAGE;
		return libraryCsPackage;
	}

	public @Nullable String getMessage(@NonNull EObject context, @NonNull String linkText) {
		LibraryAdapter adapter = PivotUtil.getAdapter(LibraryAdapter.class, context);
		if (adapter != null) {
			String message = adapter.getMessage();
			return NLS.bind(OCLMessages.UnresolvedLibrary_ERROR_, linkText, message);
		}
		return null;
	}
}
