/**
 * <copyright>
 *
 * Copyright (c) 2012, 2013 E.D.Willink and others.
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
package org.eclipse.ocl.examples.xtext.completeocl.ui.commands;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceStatus;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.ui.dialogs.DiagnosticDialog;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.ui.action.LoadResourceAction.LoadResourceDialog;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManagerResourceSetAdapter;
import org.eclipse.ocl.examples.pivot.utilities.BaseResource;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.pivot.validation.PivotEObjectValidator;
import org.eclipse.ocl.examples.xtext.completeocl.CompleteOCLStandaloneSetup;
import org.eclipse.ocl.examples.xtext.completeocl.ui.CompleteOCLUiModule;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISources;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.part.ResourceTransfer;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;


/**
 * A LoadCompleteOCLResourceHandler supports the Load Complete OCL Resource command.
 * 
 * It provides a pop-up dialog with DND capability for a Complete OCL document to be installed in the
 * ResourceSet associatied with the invoking selection.
 */
public class LoadCompleteOCLResourceHandler extends AbstractHandler
{
	protected class ResourceDialog extends LoadResourceDialog
	{
		public class URIDropTargetListener extends DropTargetAdapter
		{
			@Override
			public void dragEnter(DropTargetEvent e) {
				e.detail = DND.DROP_LINK;
			}

			@Override
			public void dragOperationChanged(DropTargetEvent e) {
				e.detail = DND.DROP_LINK;
			}

			@Override
			public void drop(DropTargetEvent event) {
				Object data = event.data;
				if (data == null) {
					event.detail = DND.DROP_NONE;
					return;
				}
				if (data instanceof IResource[]) {
					StringBuilder s = new StringBuilder();
					for (IResource resource : (IResource[])data) {
						if (s.length() > 0) {
							s.append(" ");
						}
						s.append(URI.createPlatformResourceURI(resource.getFullPath().toString(), true));
					}
					uriField.setText(s.toString());
				}
				else if (data instanceof String[]) {
					StringBuilder s = new StringBuilder();
					for (String resource : (String[])data) {
						if (s.length() > 0) {
							s.append(" ");
						}
						s.append(URI.createFileURI(resource));
					}
					uriField.setText(s.toString());
				}
				else {
					uriField.setText(((String) data));
				}
			}
		}

		protected final Shell parent;
		protected final @NonNull ResourceSet resourceSet;
		private DropTarget target;
		
		protected ResourceDialog(Shell parent, EditingDomain domain, @NonNull ResourceSet resourceSet) {
			super(parent, domain);
			this.parent = parent;
			this.resourceSet = resourceSet;
			int shellStyle = getShellStyle();
			int newShellStyle = shellStyle & ~(SWT.APPLICATION_MODAL | SWT.PRIMARY_MODAL | SWT.SYSTEM_MODAL);
			setShellStyle(newShellStyle);
		}

		@Override
		protected void configureShell(Shell shell) {
			super.configureShell(shell);
			shell.setText("Load Complete OCL Resource");
		}

		@Override
		protected Control createContents(Composite parent) {
			Control control = super.createContents(parent);
			int operations = /*DND.DROP_MOVE |*/ DND.DROP_COPY | DND.DROP_LINK;
			target = new DropTarget(uriField, operations);
			target.setTransfer(new Transfer[] {ResourceTransfer.getInstance(), FileTransfer.getInstance()});
			target.addDropListener(new URIDropTargetListener());
			return control;
		}

		@Override
		protected Control createDialogArea(Composite parent) {
			Composite createDialogArea = (Composite) super.createDialogArea(parent);
			
			Label helpLabel = new Label(createDialogArea, SWT.CENTER);
		    helpLabel.setText("You may Drag and Drop from an Eclipse or Operating System Explorer.");
		    {
		      FormData data = new FormData();
		      data.top = new FormAttachment(uriField, 2 * CONTROL_OFFSET);	// Separator is at 1 * CONTROL_OFFSET
		      data.left = new FormAttachment(0, CONTROL_OFFSET);
		      data.right = new FormAttachment(100, -CONTROL_OFFSET);
		      helpLabel.setLayoutData(data);
		    }
			
			return createDialogArea;
		}

		/**
		 * Generate a popup to display a primaryMessage and optionally a detailMessage too.
		 * @param primaryMessage
		 * @param detailMessage
		 * @return
		 */
		protected boolean error(@NonNull String primaryMessage, @Nullable String detailMessage) {
			Shell shell = parent;
		    if (detailMessage != null) {
		    	Diagnostic diagnostic = new BasicDiagnostic(Diagnostic.ERROR, "source", 0, detailMessage, null);
		    	DiagnosticDialog.open(shell, title, primaryMessage, diagnostic);
		    }
		    else {
		    	MessageDialog.openInformation(shell, title, primaryMessage);
		    }
			return false;
		}

		/**
		 * Load the Xtext resource from oclURI, then convert it to a pivot representation and return it.
		 * Return null after invoking error() to display any errors in a pop-up.
		 */
		public Resource loadResource(@NonNull ResourceSet resourceSet,
				@NonNull MetaModelManager metaModelManager, @NonNull URI oclURI) {
			BaseResource xtextResource = null;
			CompleteOCLStandaloneSetup.init();
			try {
				xtextResource = (BaseResource) resourceSet.getResource(oclURI, true);
			}
			catch (WrappedException e) {
				URI retryURI = null;
				Throwable cause = e.getCause();
				if (cause instanceof CoreException) {
					IStatus status = ((CoreException)cause).getStatus();
					if ((status.getCode() == IResourceStatus.RESOURCE_NOT_FOUND) && status.getPlugin().equals(ResourcesPlugin.PI_RESOURCES)) {
						if (oclURI.isPlatformResource()) {
							retryURI = URI.createPlatformPluginURI(oclURI.toPlatformString(false), false);
						}
					}
				}
				if (retryURI != null) {
					xtextResource = (BaseResource) resourceSet.getResource(retryURI, true);			
				}
				else {
					throw e;
				}
			}
			List<org.eclipse.emf.ecore.resource.Resource.Diagnostic> errors = xtextResource.getErrors();
			assert errors != null;
			String message = PivotUtil.formatResourceDiagnostics(errors, "", "\n");
			if (message != null) {
				error("Failed to load '" + oclURI, message);
				return null;
			}
			Resource pivotResource = xtextResource.getPivotResource(metaModelManager);
			errors = pivotResource.getErrors();
			assert errors != null;
			message = PivotUtil.formatResourceDiagnostics(errors, "", "\n");
			if (message != null) {
				error("Failed to load Pivot from '" + oclURI, message);
				return null;
			}
			return pivotResource;
		}

		@Override
		public int open() {
			try {
				return super.open();
			}
			catch (Throwable e) {
				@SuppressWarnings("null")@NonNull String primaryMessage = String.valueOf(e.getMessage());
				error(primaryMessage, null);
				return CANCEL;
			}
			finally {
				if (target != null) {
					target.dispose();
					target = null;
				}
			}
		}

		@Override
		protected boolean processResources() {
			URI theURI = null;
			try {
				MetaModelManagerResourceSetAdapter adapter = MetaModelManagerResourceSetAdapter.getAdapter(resourceSet, null);	// ?? Shared global MMM
				MetaModelManager metaModelManager = adapter.getMetaModelManager();
				Set<EPackage> mmPackages = new HashSet<EPackage>();
				//
				//	Load all the documents
				//
				for (URI oclURI : getURIs()) {
					assert oclURI != null;
					theURI = oclURI;
					Resource resource = loadResource(resourceSet, metaModelManager, oclURI);
					if (resource == null) {
						return false;
					}
					//
					//	Identify the packages which the Complete OCL document complements.
					//
					for (TreeIterator<EObject> tit = resource.getAllContents(); tit.hasNext(); ) {
						EObject eObject = tit.next();
						if (eObject instanceof org.eclipse.ocl.examples.pivot.Package) {
							DomainPackage aPackage = metaModelManager.getPrimaryPackage((org.eclipse.ocl.examples.pivot.Package)eObject);
							if (eObject instanceof org.eclipse.ocl.examples.pivot.Package) {
								EPackage mmPackage = (EPackage) ((org.eclipse.ocl.examples.pivot.Package)aPackage).getETarget();
								if (mmPackage != null) {
									mmPackages.add(mmPackage);
								}
							}
						}
						else if (eObject instanceof Type) {
							tit.prune();
						}
					}
				}
				//
				//	Install validation for all the complemented packages
				//
				PivotEObjectValidator.install(resourceSet, metaModelManager);
			    for (EPackage mmPackage : mmPackages) {
			    	assert mmPackage != null;
			    	PivotEObjectValidator.install(mmPackage);
			    }
				return true;
			}
			catch (Throwable e) {
				IStatus status = new Status(IStatus.ERROR, CompleteOCLUiModule.PLUGIN_ID, e.getLocalizedMessage(), e);
				ErrorDialog.openError(parent, "Load Complete OCL Resource Failure", "Failed to load '" + theURI + "'", status);
				return false;
			}
		}

		@Override
		protected boolean processResource(Resource resource) {
			throw new UnsupportedOperationException();		// Never happens since processResources overridden.
		}
	}

	public @Nullable Object execute(ExecutionEvent event) throws ExecutionException {
		Object applicationContext = event.getApplicationContext();
		EditingDomain editingDomain = getEditingDomain(applicationContext);
		ResourceSet resourceSet = getResourceSet(applicationContext);
//		System.out.println("execute " + event);
		Object shell = HandlerUtil.getVariable(applicationContext, ISources.ACTIVE_SHELL_NAME);
		if (!(shell instanceof Shell)) {
			return null;
		}
		if (resourceSet != null) {
			ResourceDialog dialog = new ResourceDialog((Shell)shell, editingDomain, resourceSet);
			dialog.open();
		}
		return null;
	}
	
	public static @Nullable EditingDomain getEditingDomain(@Nullable Object evaluationContext) {
		Object o = HandlerUtil.getVariable(evaluationContext, ISources.ACTIVE_EDITOR_NAME);
		if (!(o instanceof IEditorPart)) {
			return null;
		}
		IEditingDomainProvider editor = (IEditingDomainProvider) ((IEditorPart)o).getAdapter(IEditingDomainProvider.class);
		if (editor == null) {
			return null;
		}
		EditingDomain editingDomain = editor.getEditingDomain();
		if (editingDomain == null) {
			return null;
		}
		return editingDomain;
	}
	
	public static @Nullable ResourceSet getResourceSet(@Nullable Object evaluationContext) {
		Object o = HandlerUtil.getVariable(evaluationContext, ISources.ACTIVE_EDITOR_NAME);
		if (!(o instanceof IEditorPart)) {
			return null;
		}
		IEditingDomainProvider editingDomainProvider = (IEditingDomainProvider) ((IEditorPart)o).getAdapter(IEditingDomainProvider.class);
		if (editingDomainProvider != null) {
			EditingDomain editingDomain = editingDomainProvider.getEditingDomain();
			if (editingDomain == null) {
				return null;
			}
			ResourceSet resourceSet = editingDomain.getResourceSet();
			return resourceSet;
		}
		XtextEditor xtextEditor = (XtextEditor) ((IEditorPart)o).getAdapter(XtextEditor.class);
		if (xtextEditor != null) {
			IXtextDocument document = xtextEditor.getDocument();
			ResourceSet resourceSet = document.readOnly(new IUnitOfWork<ResourceSet, XtextResource>() {
				public ResourceSet exec(XtextResource xtextResource) {
					if (xtextResource == null) {
						return null;
					}
					MetaModelManager metaModelManager = PivotUtil.findMetaModelManager(xtextResource);
					if (metaModelManager != null) {
						return metaModelManager.getExternalResourceSet();
					}
					else {
						return xtextResource.getResourceSet();
					}
				}					
			});
			return resourceSet;
		}
		return null;
	}

	@Override
	public void setEnabled(Object evaluationContext) {
//		System.out.println("setEnabled " + evaluationContext);
		setBaseEnabled(getResourceSet(evaluationContext) != null);
	}
}
