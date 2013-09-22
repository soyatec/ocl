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
package org.eclipse.ocl.examples.xtext.oclinecore.ui.wizards;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.xtext.oclinecore.ui.messages.OCLinEcoreUIMessages;

/**
 * Wizard allowing the user to create a new OCLinEcore file.
 */
public class EcoreWithOCLFileNewWizard extends AbstractOCLinEcoreFileNewWizard
{

	@Override
	public @NonNull String getNewFileExtension() {
		return "ecore";
	}

	@SuppressWarnings("null")
	@Override
	public @NonNull String getNewFileLabel() {
		return OCLinEcoreUIMessages.Ecore_NewWizardPage_fileNameLabel;
	}
	
	@SuppressWarnings("null")
	@Override
	public @NonNull String getPageDescription() {
		return OCLinEcoreUIMessages.Ecore_NewWizardPage_pageDescription;
	}

	@SuppressWarnings("null")
	@Override
	public @NonNull String getPageSummary() {
		return OCLinEcoreUIMessages.Ecore_NewWizardPage_pageSummary;
	}

	@SuppressWarnings("null")
	@Override
	public @NonNull String getPageTitle() {
		return OCLinEcoreUIMessages.Ecore_NewWizardPage_pageTitle;
	}
}