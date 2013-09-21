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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.xtext.base.ui.wizards.AbstractFileDialog;
import org.eclipse.ocl.examples.xtext.base.ui.wizards.AbstractFileNewWizard;
import org.eclipse.ocl.examples.xtext.base.ui.wizards.AbstractFileNewWizardPage;
import org.eclipse.ocl.examples.xtext.oclinecore.ui.OCLinEcoreUiModule;
import org.eclipse.ocl.examples.xtext.oclinecore.ui.messages.OCLinEcoreUIMessages;

/**
 * Wizard allowing the user to create a new OCLinEcore file.
 */
public class OCLinEcoreFileNewWizard extends AbstractFileNewWizard
{
	@Override
	protected @NonNull OCLinEcoreFileDialog createDialog(@NonNull AbstractFileNewWizardPage wizardPage, @Nullable IResource initialSelection) {
		return new OCLinEcoreFileDialog(this, wizardPage, initialSelection);
	}

	@Override
	protected String getEditorId() {
		return OCLinEcoreUiModule.EDITOR_ID;
	}

	@Override
	public @NonNull String getInitialContentsAsString(@NonNull IFile newFile, @NonNull AbstractFileDialog dialog) {
/*		String metamodelNsURI = dialog.getMetamodelNsURI();
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
		} */
		StringBuilder s = new StringBuilder();
/*		s.append("import '" + metamodelNsURI + "'\n\n");
		s.append("package " + firstPackageName + "\n\n");
		s.append("context " + firstTypeName + "\n");
		s.append("inv NonNull_" + firstPropertyName + "('The \\'" + firstPropertyName + "\\' property of \"' + self.toString() + '\" is null'):\n");
		s.append("\t" + firstPropertyName + " <> null\n\n"); */
		s.append("endpackage\n");
		@SuppressWarnings("null")@NonNull String string = s.toString();
		return string;
	}

	@Override
	public @NonNull String getNewFileExtension() {
		return "oclinecore";
	}

	@SuppressWarnings("null")
	@Override
	public @NonNull String getNewFileName() {
		return OCLinEcoreUIMessages.NewWizardPage_defaultFileName;
	}

	@SuppressWarnings("null")
	@Override
	public @NonNull String getNewFileLabel() {
		return OCLinEcoreUIMessages.NewWizardPage_fileNameLabel;
	}
	
	@SuppressWarnings("null")
	@Override
	public @NonNull String getPageDescription() {
		return OCLinEcoreUIMessages.NewWizardPage_pageDescription;
	}

	@SuppressWarnings("null")
	@Override
	public @NonNull String getPageSummary() {
		return OCLinEcoreUIMessages.NewWizardPage_pageSummary;
	}

	@SuppressWarnings("null")
	@Override
	public @NonNull String getPageTitle() {
		return OCLinEcoreUIMessages.NewWizardPage_pageTitle;
	}
}