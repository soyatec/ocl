/**
 * <copyright>
 *
 * Copyright (c) 2010, 2012 E.D.Willink and others.
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
 * $Id: ImportAttribution.java,v 1.4 2011/05/20 15:27:24 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.attributes;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.compatibility.EMF_2_9;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
import org.eclipse.ocl.examples.pivot.scoping.AbstractAttribution;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.scoping.ScopeView;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.ImportCS;
import org.eclipse.ocl.examples.xtext.base.cs2as.ValidationDiagnostic;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2Pivot.UnresolvedProxyMessageProvider;
import org.eclipse.ocl.examples.xtext.base.utilities.BaseCSResource;
import org.eclipse.osgi.util.NLS;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

public class ImportCSAttribution extends AbstractAttribution implements UnresolvedProxyMessageProvider
{
	public static final ImportCSAttribution INSTANCE = new ImportCSAttribution();

	private static class ImportAdapter extends AdapterImpl
	{
		private URI uri = null;
		private Element importedElement = null;
		private Throwable throwable = null;
	
		public ScopeView computeLookup(ImportCS targetElement, EnvironmentView environmentView, ScopeView scopeView) {
			String name = environmentView.getName();
			if (name != null) {				// Looking for a specific name
				importModel(targetElement, environmentView);
				Element importedElement2 = importedElement;
				if (importedElement2 != null) {
					Resource importedResource = importedElement2.eResource();
					List<Resource.Diagnostic> errors = importedResource.getErrors();
					if (errors.size() == 0) {
						environmentView.addElement(name, importedElement2);		// The name we imported must be a good name for the element
					}
				}
			}
			else {							// looking for all possible names
				Map<String, URI> ePackageNsURIToGenModelLocationMap = EMF_2_9.EcorePlugin.getEPackageNsURIToGenModelLocationMap(false);
				for (String key : ePackageNsURIToGenModelLocationMap.keySet()) {
					environmentView.addElement(key, environmentView.getMetaModelManager().getOclVoidType());
				}
			}
			return null;
		}
	
		public String getMessage() {
			return throwable != null ? throwable.getMessage() : null;
		}
	
		protected void importModel(ImportCS target, EnvironmentView environmentView) {
			String name = environmentView.getName();
			if (name == null) {
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
			try {
				MetaModelManager metaModelManager = environmentView.getMetaModelManager();
				importedElement = metaModelManager.loadResource(uri2, target.getName(), null);				
				Resource importedResource = importedElement.eResource();
				List<Resource.Diagnostic> warnings = importedResource.getWarnings();
				if (warnings.size() > 0) {
					INode node = NodeModelUtils.getNode(target);
					String errorMessage = PivotUtil.formatResourceDiagnostics(warnings, DomainUtil.bind(OCLMessages.WarningsInURI, uri2), "\n\t");
					Resource.Diagnostic resourceDiagnostic = new ValidationDiagnostic(node, errorMessage);
					csResource.getWarnings().add(resourceDiagnostic);
				}
				List<Resource.Diagnostic> errors = importedResource.getErrors();
				if (errors.size() > 0) {
					INode node = NodeModelUtils.getNode(target);
					String errorMessage = PivotUtil.formatResourceDiagnostics(errors, DomainUtil.bind(OCLMessages.ErrorsInURI, uri), "\n\t");
					Resource.Diagnostic resourceDiagnostic = new ValidationDiagnostic(node, errorMessage);
					csResource.getErrors().add(resourceDiagnostic);
				}
			} catch (WrappedException e) {
				throwable = e.exception();
			} catch (Exception e) {
				throwable = e;
			}
		}

		@Override
		public boolean isAdapterForType(Object type) {
			return type == ImportAdapter.class;
		}
	}

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		ImportCS targetElement = (ImportCS)target;
		ImportAdapter adapter = PivotUtil.getAdapter(ImportAdapter.class, targetElement);
		if (adapter == null) {
			adapter = new ImportAdapter();
			targetElement.eAdapters().add(adapter);
		}
		return adapter.computeLookup(targetElement, environmentView, scopeView);
	}

	public @NonNull EReference getEReference() {
		@SuppressWarnings("null") @NonNull EReference importCsNamespace = BaseCSTPackage.Literals.IMPORT_CS__NAMESPACE;
		return importCsNamespace;
	}

	public @Nullable String getMessage(@NonNull EObject context, @NonNull String linkText) {
		ImportAdapter adapter = PivotUtil.getAdapter(ImportAdapter.class, context);
		if (adapter != null) {
			String message = adapter.getMessage();
			return NLS.bind(OCLMessages.UnresolvedImport_ERROR_, linkText, message);
		}
		return null;
	}
}
