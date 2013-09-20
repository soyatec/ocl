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

import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ocl.examples.ui.Activator;
import org.eclipse.ocl.examples.ui.internal.messages.ExamplesUIMessages;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;

/**
 * Wizard allowing the user to create a new OCL rule file.
 * @since 1.2
 */
@SuppressWarnings({"rawtypes"})	// FIXME - remove after LunaM2 when Platform reverts experimental genercs
public class CompleteOCLFileNewWizard
		extends Wizard
		implements INewWizard {

	/** The only page contributing to the wizard */
	protected CompleteOCLFileNewWizardPage page;

	/**
	 * Constructor
	 */
	public CompleteOCLFileNewWizard() {
		super();
		setWindowTitle(ExamplesUIMessages.CompleteOCLFileNewWizardPage_newCompleteOCLFile);
		setDefaultPageImageDescriptor(Activator
			.getImageDescriptor("icons/OCLModelFile.gif"));
	}

	/**
	 * Performs finish action of this wizard.
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		final IFile file = page.createNewFile();

		try {
			openCreatedFile(file);
		} catch (PartInitException e) {
			Activator.log(e);
			return false;
		} 

		return true;
	}

	/**
	 * Opens file in the Editor
	 * @param the file to open
	 * @throws PartInitException
	 */
	private void openCreatedFile(IFile file) throws PartInitException {
		IWorkbenchPage currentPage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IDE.openEditor(currentPage, file, true);
	}

	/**
	 * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench,
	 *      org.eclipse.jface.viewers.IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		IResource selectedResource = null;
		Iterator it = selection.iterator();
		if (it.hasNext()) {
			Object object = it.next();
			if (object instanceof IResource) {
				selectedResource = (IResource) object;
			} else if (object instanceof IAdaptable) {
				selectedResource = (IResource) ((IAdaptable) object).getAdapter(IResource.class);
			}
		}
		init(selectedResource);
	}
	public void init(@Nullable IResource selectedResource) {
		page = new CompleteOCLFileNewWizardPage(selectedResource);
		addPage(page);
	}
}