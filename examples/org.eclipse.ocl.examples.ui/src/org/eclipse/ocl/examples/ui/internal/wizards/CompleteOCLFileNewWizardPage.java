/**
 * <copyright>
 *
 * Copyright (c) 2013 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Obeo - initial API and implementation 
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.ui.internal.wizards;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.ocl.examples.ui.Activator;
import org.eclipse.ocl.examples.ui.internal.messages.ExamplesUIMessages;
import org.eclipse.ocl.examples.ui.internal.ripoffs.ResourceAndContainerGroup;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
import org.eclipse.ui.ide.undo.CreateFileOperation;
import org.eclipse.ui.ide.undo.WorkspaceUndoUtil;

/**
 * Wizard page allowing creation of OCL rule files in the workspace.
 * @since 1.2
 */
public class CompleteOCLFileNewWizardPage extends WizardPage implements Listener
{

	// the current resource selection
	private @Nullable IResource currentSelection;

	// cache of newly-created file
	private IFile newFile;

	private CompleteOCLFileDialog dialog;

	/**
	 * Creates a new complete OCL file creation wizard page. If the initial
	 * resource selection contains exactly one container resource then it will
	 * be used as the default container resource.
	 * 
	 * @param selection
	 *            the current resource selection
	 */
	public CompleteOCLFileNewWizardPage(@Nullable IResource selection) {
		super(ExamplesUIMessages.CompleteOCLFileNewWizardPage_pageName);
		setPageComplete(false);
		setTitle(ExamplesUIMessages.CompleteOCLFileNewWizardPage_completeOCLFile);
		setDescription(ExamplesUIMessages.CompleteOCLFileNewWizardPage_createCompleteOCLFileBasedOnModel);
		this.currentSelection = selection;
	}

	/**
	 * (non-Javadoc) Method declared on IDialogPage.
	 */
	public void createControl(Composite parent) {
		createDialog();
		Composite topLevel = dialog.createControlArea(parent);
		validatePage();
		setControl(topLevel);
	}

	public @NonNull CompleteOCLFileDialog createDialog() {
		CompleteOCLFileDialog dialog2 = new CompleteOCLFileDialog(getShell(), null, currentSelection, this);
		dialog = dialog2;
		return dialog2;
	}

	/**
	 * Creates a file resource handle for the file with the given workspace
	 * path. This method does not create the file resource; this is the
	 * responsibility of <code>createNewFile</code>.
	 * 
	 * @param filePath
	 *            the path of the file resource to create a handle for
	 * @return the new complete OCL file resource handle
	 * @see #createFile
	 */
	protected IFile createFileHandle(IPath filePath) {
		return Activator.getPluginWorkspace().getRoot().getFile(filePath);
	}

	/**
	 * Creates a new complete OCL file resource in the selected container and
	 * with the selected name. Creates any missing resource containers along the
	 * path; does nothing if the container resources already exist.
	 * <p>
	 * In normal usage, this method is invoked after the user has pressed Finish
	 * on the wizard; the enablement of the Finish button implies that all
	 * controls on on this page currently contain valid values.
	 * </p>
	 * <p>
	 * Note that this page caches the new complete OCL file once it has been
	 * successfully created; subsequent invocations of this method will answer
	 * the same file resource without attempting to create it again.
	 * </p>
	 * <p>
	 * This method should be called within a workspace modify operation since it
	 * creates resources.
	 * </p>
	 * 
	 * @return the created file resource, or <code>null</code> if the file was
	 *         not created
	 */
	public IFile createNewFile() {
		if (newFile != null) {
			return newFile;
		}

		// create the new complete OCL file and cache it if successful
		IPath newFilePath = getNewFilePath();

		final IFile newFileHandle = createFileHandle(newFilePath);
		newFile = newFileHandle;

		final InputStream initialContents = getInitialContents();

		IRunnableWithProgress op = new IRunnableWithProgress() {

			public void run(IProgressMonitor monitor) {
				CreateFileOperation op = new CreateFileOperation(
					newFileHandle,
					null,
					initialContents,
					ExamplesUIMessages.CompleteOCLFileNewWizardPage_newCompleteOCLFile);
				try {
					op.execute(monitor,
						WorkspaceUndoUtil.getUIInfoAdapter(getShell()));
				} catch (final ExecutionException e) {
					getContainer().getShell().getDisplay()
						.syncExec(new Runnable() {

							public void run() {
								if (e.getCause() instanceof CoreException) {
									ErrorDialog
										.openError(
											getContainer().getShell(),
											ExamplesUIMessages.CompleteOCLFileNewWizardPage_errorTitle,
											null, // no special
											// message
											((CoreException) e.getCause())
												.getStatus());
								} else {
									Activator.log(getClass(),
										"createNewFile()", e.getCause()); //$NON-NLS-1$
									MessageDialog
										.openError(
											getContainer().getShell(),
											ExamplesUIMessages.CompleteOCLFileNewWizardPage_internalErrorTitle,
											NLS.bind(
												ExamplesUIMessages.CompleteOCLFileNewWizardPage_internalErrorTitle,
												e.getCause().getMessage()));
								}
							}
						});
				}
			}
		};
		try {
			getContainer().run(true, true, op);
		} catch (InterruptedException e) {
			return null;
		} catch (InvocationTargetException e) {
			// Execution Exceptions are handled above but we may still get
			// unexpected runtime errors.
			Activator
				.log(getClass(), "createNewFile()", e.getTargetException()); //$NON-NLS-1$
			MessageDialog
				.open(
					MessageDialog.ERROR,
					getContainer().getShell(),
					ExamplesUIMessages.CompleteOCLFileNewWizardPage_internalErrorTitle,
					NLS.bind(
						ExamplesUIMessages.CompleteOCLFileNewWizardPage_internalErrorMessage,
						e.getTargetException().getMessage()), SWT.SHEET);

			return null;
		}

		return newFile;
	}

	/**
	 * Returns the current full path of the containing resource as entered or
	 * selected by the user, or its anticipated initial value.
	 * 
	 * @return the container's full path, anticipated initial value, or
	 *         <code>null</code> if no path is known
	 */
	public IPath getContainerFullPath() {
		return dialog.getGroup().getContainerFullPath();
	}

	/**
	 * Returns the current file name as entered by the user, or its anticipated
	 * initial value. <br>
	 * <br>
	 * The current file name will include the file extension if the
	 * preconditions are met.
	 * 
	 * @see WizardNewFileCreationPage#setFileExtension(String)
	 * 
	 * @return the file name, its anticipated initial value, or
	 *         <code>null</code> if no file name is known
	 */
	public String getFileName() {
		if (newFile != null) {
			return dialog.getGroup().getResource();
		}
		return null;
	}

	/**
	 * Returns a stream containing the initial contents to be given to new
	 * complete OCL file resource instances.
	 * 
	 * @return initial contents to be given to new complete OCL file resource
	 *         instances
	 */
	public InputStream getInitialContents() {
		if (newFile != null && dialog != null && dialog.isURIFieldValid()) {
			return new ByteArrayInputStream(getInitialContentsAsString()
				.getBytes());
		}
		return null;
	}

	/**
	 * Returns a string containing the initial contents to be given to new
	 * complete OCL file resource instances.
	 * 
	 * @return contents to be given to new complete OCL file resource instances
	 */
	public String getInitialContentsAsString() {
		String metamodelNsURI = dialog.getMetamodelNsURI();
		String firstPackageName = "undefined_root_package_name"; //$NON-NLS-1$
		String firstTypeName = "Example";
		String firstPropertyName = "feature";
		EPackage firstPackage = dialog.getFirstPackage();
		if (firstPackage != null) {
			firstPackageName = firstPackage.getName();
			List<EClassifier> eClassifiers = firstPackage.getEClassifiers();
			if (eClassifiers.size() > 0) {
				EClassifier firstType = eClassifiers.get(0);
				firstTypeName = firstType.getName();
				if (firstType instanceof EClass) {
					List<EStructuralFeature> eStructuralFeatures = ((EClass)firstType).getEAllStructuralFeatures();
					if (eStructuralFeatures.size() > 0) {
						EStructuralFeature firstProperty = eStructuralFeatures.get(0);
						firstPropertyName = firstProperty.getName();
					}
				}
			}
		}
		StringBuilder s = new StringBuilder();
		s.append("import '" + metamodelNsURI + "'\n\n");
		s.append("package " + firstPackageName + "\n\n");
		s.append("context " + firstTypeName + "\n");
		s.append("inv NonNull_" + firstPropertyName + "('The \\'" + firstPropertyName + "\\' property of \"' + self.toString() + '\" is null'):\n");
		s.append("\t" + firstPropertyName + " <> null\n\n");
		s.append("endpackage\n");
		return s.toString();
	}

	protected IPath getNewFilePath() {
		ResourceAndContainerGroup group = dialog.getGroup();
		IPath containerPath = group.getContainerFullPath();
		return containerPath.append(group.getResource());
	}

	/**
	 * The <code>WizardNewFileCreationPage</code> implementation of this
	 * <code>Listener</code> method handles all events and enablements for
	 * controls on this page. Subclasses may extend.
	 */
	public void handleEvent(Event event) {
		setPageComplete(validatePage());
	}

	/**
	 * Returns true if this selected resource would be filtered from view.
	 * 
	 * {@link IWorkspace#validateFiltered(Resource)}
	 */
	private boolean isFilteredByParent() {
		ResourceAndContainerGroup group = dialog.getGroup();
		IPath containerPath = group.getContainerFullPath();
		if (containerPath == null)
			return false;
		String resourceName = group.getResource();
		if (resourceName == null)
			return false;
		if (resourceName.length() > 0) {
			IPath newFolderPath = containerPath.append(resourceName);
			IFile newFileHandle = createFileHandle(newFolderPath);
			IWorkspace workspace = newFileHandle.getWorkspace();
			return !workspace.validateFiltered(newFileHandle).isOK();
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.dialogs.DialogPage#setVisible(boolean)
	 */
	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		if (visible) {
			dialog.getGroup().setFocus();
		}
	}

	/**
	 * Returns whether this page's controls currently all contain valid values.
	 * 
	 * @return <code>true</code> if all controls are valid, and
	 *         <code>false</code> if at least one is invalid
	 */
	protected boolean validatePage() {
		boolean valid = true;
		setMessage(ExamplesUIMessages.CompleteOCLFileNewWizardPage_createCompleteOCLFileBasedOnModel);
		setErrorMessage(null);

		ResourceAndContainerGroup group = dialog.getGroup();
		if (!group.areAllValuesValid()) {
			// if blank name then fail silently
			int problemType = group.getProblemType();
			String problemMessage = group.getProblemMessage();
			if (problemType == ResourceAndContainerGroup.PROBLEM_RESOURCE_EMPTY
				|| problemType == ResourceAndContainerGroup.PROBLEM_CONTAINER_EMPTY) {
				setMessage(problemMessage);
				setErrorMessage(null);
			} else {
				setErrorMessage(problemMessage);
			}
			valid = false;
		}

		String resourceName = group.getResource();
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IStatus result = workspace.validateName(resourceName, IResource.FILE);
		if (!result.isOK()) {
			setErrorMessage(result.getMessage());
			return false;
		}

		if (group.getAllowExistingResources()) {
			String problemMessage = NLS.bind(
				ExamplesUIMessages.CompleteOCLFileNewWizardPage_nameExists,
				getFileName());
			IPath resourcePath = getContainerFullPath().append(getFileName());
			IWorkspaceRoot root = workspace.getRoot();
			if (root.getFolder(resourcePath).exists()) {
				setErrorMessage(problemMessage);
				valid = false;
			}
			if (root.getFile(resourcePath).exists()) {
				setMessage(problemMessage, IMessageProvider.WARNING);
			}
		}

		if (isFilteredByParent()) {
			setMessage(
				ExamplesUIMessages.CompleteOCLFileNewWizardPage_resourceWillBeFilteredWarning,
				IMessageProvider.ERROR);
			valid = false;
		}
		return valid;
	}
}