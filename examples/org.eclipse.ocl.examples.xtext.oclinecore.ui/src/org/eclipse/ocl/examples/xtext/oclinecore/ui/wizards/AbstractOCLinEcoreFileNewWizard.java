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

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.xtext.base.ui.wizards.AbstractFileDialog;
import org.eclipse.ocl.examples.xtext.base.ui.wizards.AbstractFileNewWizard;
import org.eclipse.ocl.examples.xtext.base.ui.wizards.AbstractFileNewWizardPage;
import org.eclipse.ocl.examples.xtext.oclinecore.ui.OCLinEcoreUiModule;
import org.eclipse.ocl.examples.xtext.oclinecore.ui.messages.OCLinEcoreUIMessages;

/**
 * Wizard allowing the user to create a new OCLinEcore file.
 */
public abstract class AbstractOCLinEcoreFileNewWizard extends AbstractFileNewWizard
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
		StringBuilder s = new StringBuilder();
		List<URI> uris = dialog.getURIs();
		if (uris.size() > 0) {
			URI newURI = URI.createPlatformResourceURI(newFile.getFullPath().toString(), true);
			for (URI uri : uris) {
				@SuppressWarnings("null")@NonNull URI deresolvedURI = uri.deresolve(newURI);
				s.append("import '" + ValuesUtil.oclToString(deresolvedURI) + "';\n");
			}
			s.append("\n");
		}
		s.append("package example : ex = 'http://www.example.org/examples/example.ecore'\n");
		s.append("{\n");
		s.append("	-- Example Class with hierarchical properties and an invariant\n");
		s.append("	class Example\n");
		s.append("	{\n");
		s.append("		property name : String;\n");
		s.append("		property children#parent : Example[*] { composes, ordered } ;\n");
		s.append("		property parent#children : Example[?];\n");
		s.append("		operation ucName() : String {\n");
		s.append("			body: name.toUpperCase();\n");
		s.append("		}\n");
		s.append("		invariant NameIsLowerCase('Expected a lowercase name rather than \'' + name + '\''):\n");
		s.append("			name = name.toLowerCase();\n");
		s.append("	}\n");
		s.append("}\n");
		@SuppressWarnings("null")@NonNull String string = s.toString();
		return string;
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