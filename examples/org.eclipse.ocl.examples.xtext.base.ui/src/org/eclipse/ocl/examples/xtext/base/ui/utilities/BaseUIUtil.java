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
 *   E.D.Willink - initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.xtext.base.ui.utilities;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.part.IPageSite;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
import org.eclipse.xtext.ui.editor.outline.impl.EStructuralFeatureNode;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

public class BaseUIUtil
{
	public static @Nullable IXtextDocument getActiveDocument(IPageSite site) {
		try {
			if (site == null) {
				return null;
			}
			IWorkbenchWindow workbenchWindow = site.getWorkbenchWindow();
			if (workbenchWindow == null) {
				return null;
			}
			IWorkbenchPage activePage = workbenchWindow.getActivePage();
			if (activePage == null) {
				return null;
			}
			IEditorPart activeEditor = activePage.getActiveEditor();
			if (!(activeEditor instanceof XtextEditor)) {
				return null;
			}
			IXtextDocument xtextDocument = ((XtextEditor)activeEditor).getDocument();
			return xtextDocument;
		}
		catch (Exception e) {
			return  null;
		}
	}

	public static @Nullable ISelection getActiveSelection(IPageSite site) {
		try {
			if (site == null) {
				return null;
			}
			IWorkbenchWindow workbenchWindow = site.getWorkbenchWindow();
			if (workbenchWindow == null) {
				return null;
			}
			IWorkbenchPage activePage = workbenchWindow.getActivePage();
			if (activePage == null) {
				return null;
			}
			IEditorPart activeEditor = activePage.getActiveEditor();
			if (activeEditor == null) {
				return null;
			}
			IEditorSite editorSite = activeEditor.getEditorSite();
			if (editorSite == null) {
				return null;
			}
			ISelectionProvider selectionProvider = editorSite.getSelectionProvider();
			if (selectionProvider == null) {
				return null;
			}
			return selectionProvider.getSelection();
		}
		catch (Exception e) {
			return  null;
		}
	}

	public static @Nullable Object getXtextOutlineSelection(@NonNull IOutlineNode outlineNodeSelection, IPageSite site) {
		if (outlineNodeSelection instanceof EObjectNode) {
		    final EObjectNode selectedObjectNode = (EObjectNode) outlineNodeSelection;
			IXtextDocument xtextDocument = getActiveDocument(site);
			if (xtextDocument != null) {
				final URI eObjectURI = selectedObjectNode.getEObjectURI();
				if (eObjectURI != null) {
					return xtextDocument.modify(new IUnitOfWork<EObject, XtextResource>()
					{
						public EObject exec(XtextResource resource) throws Exception {
							String fragment = eObjectURI.fragment();
							return fragment != null ? resource.getEObject(fragment) : null;
						}
					});
				}
			}
		}
		else if (outlineNodeSelection instanceof EStructuralFeatureNode) {
//			return null;
		}
		return null;
	}
	
	public static @Nullable Object getXtextTextSelection(final @NonNull ITextSelection textSelection, IPageSite site) {
		IXtextDocument xtextDocument = getActiveDocument(site);
		if (xtextDocument == null) {
			return null;
		}
		return xtextDocument.modify(new IUnitOfWork<EObject, XtextResource>()
		{
			public EObject exec(XtextResource resource) throws Exception {
				if (resource.getContents().size() <= 0) {
					return null;
				}
				EObject rootObject = resource.getContents().get(0);
				INode rootNode = NodeModelUtils.getNode(rootObject);
				if (rootNode == null) {
					return null;
				}
				ILeafNode leafNode = NodeModelUtils.findLeafNodeAtOffset(rootNode, textSelection.getOffset());
				if (leafNode == null) {
					return null;
				}
				return leafNode.getSemanticElement();
			}
		});
	}

}
