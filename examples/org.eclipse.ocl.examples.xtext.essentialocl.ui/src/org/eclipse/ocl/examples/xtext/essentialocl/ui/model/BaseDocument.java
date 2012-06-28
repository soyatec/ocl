/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
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
 * $Id: BaseDocument.java,v 1.8 2011/03/18 18:19:06 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.ui.model;

import java.util.Map;

import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.examples.pivot.attributes.RootAttribution;
import org.eclipse.ocl.examples.pivot.context.EInvocationContext;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.scoping.Attribution;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS;
import org.eclipse.ocl.examples.xtext.base.utilities.CS2PivotResourceAdapter;
import org.eclipse.ocl.examples.xtext.base.utilities.ElementUtil;
import org.eclipse.ocl.examples.xtext.essentialocl.utilities.EssentialOCLCSResource;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.DocumentTokenSource;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.ui.editor.model.edit.ITextEditComposer;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;

public class BaseDocument extends XtextDocument implements ConsoleContext
{
	public class BaseDocumentLocker extends XtextDocumentLocker
	{
		public boolean isWriteLocked() {
			return rwLock.isWriteLocked();
		}
	}

	@Inject
	public BaseDocument(DocumentTokenSource tokenSource, ITextEditComposer composer) {
		super(tokenSource, composer);
	}

	private EObject context;
    private Map<String, EClassifier> parameters;
	private BaseDocumentLocker myStateAccess;

	@Override
	protected XtextDocumentLocker createDocumentLocker() {
		myStateAccess = new BaseDocumentLocker();
		return myStateAccess;
	}

	protected RootAttribution getDocumentAttribution() {
		return readOnly(new IUnitOfWork<RootAttribution, XtextResource>()
			{
				public RootAttribution exec(XtextResource resource) throws Exception {
					if (!resource.getContents().isEmpty()) {
						ElementCS csElement = (ElementCS) resource.getContents().get(0);
						Attribution attribution = PivotUtil.getAttribution(csElement);
						if (attribution != null) {
							return ElementUtil.getDocumentAttribution(csElement);
						}
					}
					return null;
				}
			});
	}

    public EObject getOCLContext() {
        return context;
    }

    public Map<String, EClassifier> getOCLParameters() {
		return parameters;
	}

	public ResourceSet getResourceSet() {
		return readOnly(new IUnitOfWork<ResourceSet, XtextResource>()
			{
				public ResourceSet exec(XtextResource resource) throws Exception {
					return resource.getResourceSet();
				}
			});
	}

	@Override
	public <T> T readOnly(IUnitOfWork<T, XtextResource> work) {
		if (myStateAccess.isWriteLocked()) {
//			CS2Pivot.printDiagnostic(getClass().getSimpleName() + ".readOnly skip " + work.getClass().getName(), false, 0);
			Class<?> workClass = work.getClass();
			String workClassName = workClass.getName();
			if (workClassName.startsWith("org.eclipse.xtext.ui.editor.hover.AbstractEObjectHover")) {
				return null;
			}
			if (workClassName.startsWith("org.eclipse.xtext.ui.editor.outline.impl.AbstractOutlineNode")) {
				return null;
			}
			if (workClassName.startsWith("org.eclipse.xtext.ui.editor.folding.DefaultFoldingRegionProvider")) {
				throw new OperationCanceledException();
			}
			if (workClassName.equals("org.eclipse.xtext.ui.editor.contentassist.CompletionProposalComputer")) {
				throw new OperationCanceledException();
			}
			if (workClassName.startsWith("org.eclipse.xtext.ui.editor.validation.ValidationJob")) {
				throw new OperationCanceledException();
			}
			return null;
		}
//		CS2Pivot.printDiagnostic(getClass().getSimpleName() + ".readOnly start " + work.getClass().getName(), false, +1);
		try {
			return super.readOnly(work);
		}
		finally {
//			CS2Pivot.printDiagnostic(getClass().getSimpleName() + ".readOnly end " + work.getClass().getName(), false, -1);
		}
	}

/*	@Override
	public <T> T modify(IUnitOfWork<T, XtextResource> work) {
		CS2Pivot.printDiagnostic(getClass().getSimpleName() + ".modify start " + work.getClass().getName(), false, +1);
		try {
			return super.modify(work);
		}
		finally {
			CS2Pivot.printDiagnostic(getClass().getSimpleName() + ".modify end " + work.getClass().getName(), false, -1);
		}
	} */

/*	@Override
	public <T> T internalModify(IUnitOfWork<T, XtextResource> work) {
		if (myStateAccess.isWriteLocked()) {
			CS2Pivot.printDiagnostic(getClass().getSimpleName() + ".internalModify skip " + work.getClass().getName(), false, 0);
			Class<?> workClass = work.getClass();
			String workClassName = workClass.getName();
			if (workClassName.equals("org.eclipse.xtext.ui.editor.reconciler.XtextReconcilerUnitOfWork")) {
//				throw new OperationCanceledException();
			}
//			return null;
		}
		CS2Pivot.printDiagnostic(getClass().getSimpleName() + ".internalModify start " + work.getClass().getName(), false, +1);
		try {
			return super.internalModify(work);
		}
		finally {
			CS2Pivot.printDiagnostic(getClass().getSimpleName() + ".internalModify end " + work.getClass().getName(), false, -1);
		}
	} */

	public void setContext(final EClassifier ecoreContext, final Map<String, EClassifier> ecoreParameters) {
		modify(new IUnitOfWork<Object, XtextResource>()
		{
			public Object exec(XtextResource resource) throws Exception {
				return setContext((EssentialOCLCSResource) resource, ecoreContext, ecoreParameters);
			}
		});

        this.context = ecoreContext;
        this.parameters = ecoreParameters;
    }

	public Object setContext(EssentialOCLCSResource resource, EClassifier ecoreContext, Map<String, EClassifier> ecoreParameters) {
		CS2PivotResourceAdapter csAdapter = CS2PivotResourceAdapter.getAdapter(resource, null);
		MetaModelManager metaModelManager = csAdapter.getMetaModelManager();
		resource.setParserContext(new EInvocationContext(metaModelManager, resource.getURI(), ecoreContext, ecoreParameters));
		return null;
	}
}
