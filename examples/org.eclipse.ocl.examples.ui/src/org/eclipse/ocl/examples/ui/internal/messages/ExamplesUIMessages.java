/**
 * <copyright>
 *
 * Copyright (c) 2013 Obeo and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Obeo - Initial API and implementation
 * </copyright>
 *
 * $Id$
 */

package org.eclipse.ocl.examples.ui.internal.messages;

import org.eclipse.osgi.util.NLS;

/**
 * An accessor class for externalized strings.
 * @since 1.2
 */
public class ExamplesUIMessages
{	
	static {
		NLS.initializeMessages(ExamplesUIMessages.class.getName(), ExamplesUIMessages.class);
	}

	public static String CompleteOCLFileNewWizardPage_newCompleteOCLFile;
	public static String CompleteOCLFileNewWizardPage_completeOCLFile;
	public static String CompleteOCLFileNewWizardPage_fileExtension;
	public static String CompleteOCLFileNewWizardPage_fileName;
	public static String CompleteOCLFileNewWizardPage_file;
	public static String CompleteOCLFileNewWizardPage_createCompleteOCLFileBasedOnModel;
	public static String CompleteOCLFileNewWizardPage_oclFileNameLabel;
	public static String CompleteOCLFileNewWizardPage_errorTitle;
	public static String CompleteOCLFileNewWizardPage_internalErrorTitle;
	public static String CompleteOCLFileNewWizardPage_internalErrorMessage;
	public static String CompleteOCLFileNewWizardPage_nameExists;
	public static String CompleteOCLFileNewWizardPage_pageName;
	public static String CompleteOCLFileNewWizardPage_resourceWillBeFilteredWarning;
	public static String CompleteOCLFileNewWizardPage_browseRegisteredPackages_label;
	public static String CompleteOCLFileNewWizardPage_browseTargetPlatformPackages_label;
	public static String CompleteOCLFileNewWizardPage_selectRegisteredPackageURI;
	public static String CompleteOCLFileNewWizardPage_packageSelection_label;
	public static String CompleteOCLFileNewWizardPage_developmentTimeVersion_label;
	public static String CompleteOCLFileNewWizardPage_runtimeVersion_label;
	public static String CompleteOCLFileNewWizardPage_runtimePackageDetail_message;
	public static String CompleteOCLFileNewWizardPage_information_title;
	public static String CompleteOCLFileNewWizardPage_runtimePackageHeader_message;
	public static String CompleteOCLFileNewWizardPage_resourceURI_label;
	public static String CompleteOCLFileNewWizardPage_resourceURIs_label;
	public static String CompleteOCLFileNewWizardPage_browseFileSystem_label;
	public static String CompleteOCLFileNewWizardPage_browseWorkspace_label;
	
	public static String CompleteOCLFileNewWizardPage_newFileWizardContextId;

	// source IDEWorkbenchMessages	
	public static String ContainerGroup_message;
	public static String ContainerGroup_selectFolder;

	public static String ResourceGroup_resource;
	public static String ResourceGroup_nameExists;
	public static String ResourceGroup_folderEmpty;
	public static String ResourceGroup_noProject;
	public static String ResourceGroup_emptyName;
	public static String ResourceGroup_invalidFilename;
	public static String ResourceGroup_pathOccupied;
}