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

package org.eclipse.ocl.examples.xtext.completeocl.ui.messages;

import org.eclipse.osgi.util.NLS;

/**
 * An accessor class for externalized strings.
 */
public class CompleteOCLUIMessages
{	
	static {
		NLS.initializeMessages(CompleteOCLUIMessages.class.getName(), CompleteOCLUIMessages.class);
	}

	public static String NewWizardPage_defaultFileName;
	public static String NewWizardPage_fileNameLabel;
	public static String NewWizardPage_pageDescription;
	public static String NewWizardPage_pageSummary;
	public static String NewWizardPage_pageTitle;
}