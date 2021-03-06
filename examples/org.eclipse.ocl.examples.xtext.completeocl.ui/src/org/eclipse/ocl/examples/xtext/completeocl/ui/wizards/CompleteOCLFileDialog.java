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
 *   		references WizardNewFileCreationPage, ResourceDialog and ExtendedLoadResourceDialog
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.xtext.completeocl.ui.wizards;

import org.eclipse.core.resources.IResource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.xtext.base.ui.wizards.AbstractFileDialog;
import org.eclipse.ocl.examples.xtext.base.ui.wizards.AbstractFileNewWizardPage;

public class CompleteOCLFileDialog extends AbstractFileDialog
{
	/**
	 * Creates an extended new complete OCL file creation dialog. If the initial
	 * resource selection contains exactly one container resource then it will
	 * be used as the default container resource.
	 * 
	 * @param parent
	 *            composite widget to parent the group
	 * @param domain
	 * @param selection
	 *            the current resource selection
	 * @param listener
	 *            object interested in changes to the group's fields value
	 */
	public CompleteOCLFileDialog(@NonNull CompleteOCLFileNewWizard wizard, @NonNull AbstractFileNewWizardPage wizardPage, @Nullable IResource initialSelection) {
		super(wizard, wizardPage, initialSelection);
	}
}
