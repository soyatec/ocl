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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.utilities.PivotEnvironmentFactory;
import org.eclipse.ocl.examples.xtext.base.ui.wizards.AbstractFileDialog;
import org.eclipse.ocl.examples.xtext.base.ui.wizards.AbstractFileNewWizardPage;
import org.eclipse.ocl.examples.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.examples.xtext.oclinecore.ui.messages.OCLinEcoreUIMessages;

/**
 * Wizard allowing the user to create a new OCLinEcore file.
 */
public class EcoreWithOCLFileNewWizard extends AbstractOCLinEcoreFileNewWizard
{	
	private static final Logger logger = Logger.getLogger(EcoreWithOCLFileNewWizard.class);

	@Override
	protected @NonNull EcoreWithOCLFileDialog createDialog(@NonNull AbstractFileNewWizardPage wizardPage, @Nullable IResource initialSelection) {
		return new EcoreWithOCLFileDialog(this, wizardPage, initialSelection);
	}

	@Override
	public @NonNull
	String getInitialContentsAsString(@NonNull IFile newFile, @NonNull AbstractFileDialog dialog) {
		URI ecoreURI = URI.createPlatformResourceURI(newFile.getFullPath().toString(), true);
		URI oclInEcoreURI = ecoreURI.trimFileExtension().appendFileExtension("oclinecore");
		String initialContentsAsString = super.getInitialContentsAsString(newFile, dialog);
		OCL ocl = OCL.newInstance(new PivotEnvironmentFactory(EPackage.Registry.INSTANCE, new MetaModelManager()));
		MetaModelManager metaModelManager = ocl.getMetaModelManager();
		ResourceSet resourceSet2 = metaModelManager.getExternalResourceSet();
		BaseCSResource csResource = DomainUtil.nonNullState((BaseCSResource) resourceSet2.createResource(oclInEcoreURI));
		try {
			ByteArrayInputStream inputStream = new ByteArrayInputStream(initialContentsAsString.getBytes());
			csResource.load(inputStream, null);
			Resource asResource = ocl.cs2pivot(csResource);
			Resource eResource = ocl.pivot2ecore(asResource, ecoreURI);
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			eResource.save(outputStream, null);
			@SuppressWarnings("null")@NonNull String string = outputStream.toString();
			return string;
		} catch (IOException e) {
			logger.error("Failed to create " + ecoreURI, e);
		}
		return initialContentsAsString;
	}

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