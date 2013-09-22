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
package org.eclipse.ocl.examples.test.xtext;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ocl.examples.test.xtext.models.ParserModels;
import org.eclipse.ocl.examples.xtext.base.ui.messages.BaseUIMessages;
import org.eclipse.ocl.examples.xtext.base.ui.wizards.AbstractFileNewWizardPage;
import org.eclipse.ocl.examples.xtext.completeocl.ui.messages.CompleteOCLUIMessages;
import org.eclipse.ocl.examples.xtext.completeocl.ui.wizards.CompleteOCLFileDialog;
import org.eclipse.ocl.examples.xtext.completeocl.ui.wizards.CompleteOCLFileNewWizard;
import org.eclipse.ocl.examples.xtext.completeocl.utilities.CompleteOCLPlugin;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWizard;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.junit.Test;

/**
 * Tests that exercise the new complete OCL creation wizard page.
 */
public class CompleteOCLFileNewWizardTest extends TestCase
{
	private static final String PAGE_NAME = BaseUIMessages.NewWizardPage_pageName;

	private static final String TEST_ECORE_NAME = "Test.ecore";
	private static final String TEST_PROJECT_NAME = "test-project";
	private static final String TEST_ECORE_PATH = "/" + TEST_PROJECT_NAME + "/" + TEST_ECORE_NAME;

	private static final String EXPECTED_OCL_NAME = "Test.ocl";
	private static final String EXPECTED_PACKAGE_NAME = "test_package";
	private static final String EXPECTED_CLASS_NAME = "TestClass";
	private static final String EXPECTED_FEATURE_NAME = "testFeature";

	private IProject project = null;

	private IFile modelFile = null;

	public static String getExpectedContents() {
		StringBuilder s = new StringBuilder();
		s.append("import '" + TEST_ECORE_NAME + "'\n\n");
		s.append("package " + EXPECTED_PACKAGE_NAME + "\n\n");
		s.append("context " + EXPECTED_CLASS_NAME + "\n");
		s.append("--\n");
		s.append("-- example invariant with a custom error message to verify that\n");
		s.append("-- the '" + EXPECTED_FEATURE_NAME + "' property of all '" + EXPECTED_PACKAGE_NAME + "::" + EXPECTED_CLASS_NAME + "' instances is non-null\n");
		s.append("--\n");
		s.append("inv NonNull_" + EXPECTED_FEATURE_NAME + "('The \\'" + EXPECTED_FEATURE_NAME + "\\' property of \"' + self.toString() + '\" is null'):\n");
		s.append("\t" + EXPECTED_FEATURE_NAME + " <> null\n\n");
		s.append("endpackage\n");
		return s.toString();
	}

	public CompleteOCLFileNewWizardTest(String name) {
		super(name);
	}

	/**
	 * Create the wizard dialog, open it and press Finish.
	 */
	protected int createAndFinishWizardDialog(@NonNull IWorkbenchWizard wizard) {
		WizardDialog dialog = new WizardDialog(new Shell(), wizard)
		{
			@Override
			public int open() {
				final Thread thread = new Thread("Press Finish")
				{
					@Override
					public void run() {
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {}
						getShell().getDisplay().asyncExec(new Runnable()
						{
							@Override
							public void run() {
								finishPressed();
							}
						});
					}			
				};
				thread.start();
				return super.open();
			}
		};
		return dialog.open();
	}

	/**
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();

		IEclipsePreferences prefs = InstanceScope.INSTANCE.getNode(ResourcesPlugin.PI_RESOURCES);
		prefs.putBoolean(ResourcesPlugin.PREF_LIGHTWEIGHT_AUTO_REFRESH, true);

		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		final IWorkspaceRoot root = workspace.getRoot();
		IProjectDescription description = workspace.newProjectDescription(TEST_PROJECT_NAME);
		project = root.getProject(description.getName());
		NullProgressMonitor nullMonitor = new NullProgressMonitor();
		if (project.exists()) {
			project.delete(true, true, nullMonitor);
		}
		project.create(description, nullMonitor);
		assertTrue(project.exists());
		project.open(nullMonitor);
		URL url = ParserModels.class.getResource(TEST_ECORE_NAME);
		assertNotNull(url);
		project.getFile(TEST_ECORE_NAME).create(url.openStream(), true,nullMonitor);
		modelFile = project.getFile(TEST_ECORE_NAME);
		assertTrue(modelFile.exists());
	}

	/**
	 * @see junit.framework.TestCase#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		if (project.exists()) {
			project.delete(true, true, new NullProgressMonitor());
		}
	}

	@Test
	public void test_CompleteOCLFile_Dialog() {
		CompleteOCLFileNewWizard wizard = new CompleteOCLFileNewWizard();
		AbstractFileNewWizardPage wizardPage = wizard.createNewWizardPage(modelFile);
		CompleteOCLFileDialog dialog = new CompleteOCLFileDialog(wizard, wizardPage, modelFile);
		dialog.createDialogArea(new Shell());
		assertEquals("ocl", wizard.getNewFileExtension());
		assertEquals(CompleteOCLUIMessages.NewWizardPage_fileNameLabel, wizard.getNewFileLabel());
		assertEquals("/" + TEST_PROJECT_NAME + "/" + EXPECTED_OCL_NAME, dialog.getNewFilePath().toString());
		List<URI> uris = new ArrayList<URI>();
		uris.add(URI.createPlatformResourceURI(TEST_ECORE_PATH, true));
		assertEquals(uris, dialog.getURIs());
		wizard.dispose();
	}

	@Test
	public void test_CompleteOCLFile_NewWizardPage() {
		CompleteOCLFileNewWizard wizard = new CompleteOCLFileNewWizard();
		AbstractFileNewWizardPage wizardPage = wizard.createNewWizardPage(modelFile);
		assertEquals(PAGE_NAME, wizardPage.getName());
		assertEquals(CompleteOCLUIMessages.NewWizardPage_pageSummary, wizardPage.getTitle());
		assertEquals(CompleteOCLUIMessages.NewWizardPage_pageDescription, wizardPage.getDescription());
		assertNull(wizardPage.getErrorMessage());
		wizard.dispose();
	}

/*	@Test
	public void test_CompleteOCLFile_NewWizardPage_FileContent() {
		CompleteOCLFileNewWizard wizard = new CompleteOCLFileNewWizard();
		AbstractFileNewWizardPage wizardPage = wizard.createNewWizardPage(modelFile);
		AbstractFileDialog dialog = wizardPage.initDialog(modelFile);
//		dialog.fillContentsFromWorkspacePath(modelFile.getFullPath().toString());
		String expectedContents = getExpectedContents();
		String actualContents = wizard.getInitialContentsAsString(modelFile, dialog);
		assertEquals(expectedContents, actualContents);
	} */

	@Test
	public void test_CompleteOCLFile_NewWizardPage_FileCreation() throws Exception {
		IWorkbenchWizard wizard = new CompleteOCLFileNewWizard();
		wizard.init(PlatformUI.getWorkbench(), new StructuredSelection(modelFile));
		createAndFinishWizardDialog(wizard);

		IFile oclFile = project.getFile(EXPECTED_OCL_NAME);
		assertTrue(oclFile.exists());
		InputStream inputStream = oclFile.getContents();
		Reader reader = new InputStreamReader(inputStream);
		StringBuilder s = new StringBuilder();
		char[] cbuf = new char[4096];
		for (int len = 0; (len = reader.read(cbuf)) > 0; ) {
			s.append(cbuf, 0, len);
		}
		reader.close();
		String expectedContents = getExpectedContents();
		String actualContents = s.toString();
		assertEquals(expectedContents, actualContents);
		IWorkbenchPage currentPage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		XtextEditor activeEditor = (XtextEditor)currentPage.getActiveEditor();
		assertEquals(CompleteOCLPlugin.LANGUAGE_ID, activeEditor.getLanguageName());
		activeEditor.close(false);
	}
}
