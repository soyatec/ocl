/**
 * <copyright>
 *
 * Copyright (c) 2011, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.ocl.examples.test.xtext;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.PivotConstants;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.utilities.PivotEnvironmentFactory;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2Pivot;
import org.eclipse.ocl.examples.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.examples.xtext.base.utilities.CS2PivotResourceAdapter;
import org.eclipse.ocl.examples.xtext.base.utilities.PivotDiagnosticConverter;
import org.eclipse.ocl.examples.xtext.base.utilities.PivotResourceValidator;
import org.eclipse.ocl.examples.xtext.completeocl.ui.CompleteOCLUiModule;
import org.eclipse.ocl.examples.xtext.essentialocl.ui.EssentialOCLUiModule;
import org.eclipse.ocl.examples.xtext.oclinecore.ui.OCLinEcoreUiModule;
import org.eclipse.ocl.examples.xtext.oclstdlib.ui.OCLstdlibUiModule;
import org.eclipse.ocl.examples.xtext.tests.XtextTestCase;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.validation.CheckMode;

/**
 * Tests that load a model and verify that there are no unresolved proxies as a result.
 */
@SuppressWarnings("null")
public class EditorTests extends XtextTestCase
{	
	protected FileEditorInput createEcoreFileEditorInput(String projectName, String fileName, String testDocument)throws IOException, CoreException {
		OCL ocl0 = OCL.newInstance(new PivotEnvironmentFactory());
		MetaModelManager metaModelManager0 = ocl0.getMetaModelManager();
		String ecoreString = createEcoreString(metaModelManager0, fileName, testDocument, true);
		InputStream inputStream = new URIConverter.ReadableInputStream(ecoreString, "UTF-8");
		FileEditorInput fileEditorInput = createFileEditorInput(projectName, fileName, inputStream);
		metaModelManager0.dispose();
		return fileEditorInput;
	}

	protected FileEditorInput createFileEditorInput(String projectName, String testFile, InputStream inputStream) throws CoreException {
		IProject project = createProject(projectName);
		IFile file1 = project.getFile(testFile);
		file1.create(inputStream, true, null);
		return new FileEditorInput(file1);
	}

	protected IProject createProject(String projectName) throws CoreException {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot root = workspace.getRoot();
		IProject project = root.getProject(projectName);
		if (!project.exists()) {
			project.create(null);
		}
		project.open(null);
		return project;
	}

	protected void doTearDown(XtextEditor editor) {
		IXtextDocument document = editor.getDocument();
		MetaModelManager metaModelManager = document.modify(new IUnitOfWork<MetaModelManager, XtextResource>() {				// Cancel validation
			@Override
			public MetaModelManager exec(XtextResource state) throws Exception {
				return PivotUtil.findMetaModelManager(state);
			}
		});
		flushEvents();
		editor.close(false);
		flushEvents();
		if (metaModelManager != null) {
			metaModelManager.dispose();
		}
	}

	public void doTestEditor(String editorId, String testFile, String testContent) throws Exception {
		InputStream inputStream = new URIConverter.ReadableInputStream(testContent, "UTF-8");
		FileEditorInput fileEditorInput = createFileEditorInput("test", testFile, inputStream);
		XtextEditor editor = doTestEditor(editorId, fileEditorInput);
		IXtextDocument document = editor.getDocument();
		String content = document.get();
		assertEquals(testContent, content);
		doTearDown(editor);
	}

	protected XtextEditor doTestEditor(String editorId, FileEditorInput fileEditorInput) throws PartInitException, CoreException {
		IFile file = fileEditorInput.getFile();
		IWorkbench workbench = PlatformUI.getWorkbench();
		IWorkbenchWindow activeWorkbenchWindow = workbench.getActiveWorkbenchWindow();
		IWorkbenchPage page = activeWorkbenchWindow.getActivePage();
		XtextEditor editor = (XtextEditor) IDE.openEditor(page, fileEditorInput, editorId, true);
		String languageName = editor.getLanguageName();
		assertEquals(editorId, languageName);
		file.refreshLocal(IResource.DEPTH_INFINITE, null);
		IMarker[] markers = file.findMarkers(null, true, IResource.DEPTH_INFINITE);
		if (markers.length > 0) {
			StringBuilder s = new StringBuilder();
			for (IMarker marker : markers) {
				s.append("\n  ");
				Object location = marker.getAttribute(IMarker.LOCATION);
				if (location != null) {
					s.append(location.toString());
					s.append(": ");
				}
				else {
					Object lineNumber = marker.getAttribute(IMarker.LINE_NUMBER);
					if (lineNumber != null) {
						s.append(lineNumber.toString());
						s.append(": ");
					}
				}
				s.append(marker.getAttribute(IMarker.MESSAGE));
			}
			fail("Markers" + s.toString());
		}
		return editor;
	}

	private String doTestEditor(String editorId, URI testFile) throws CoreException, PartInitException {
		IEditorInput input = new EMFURIEditorInput(testFile);
		IWorkbench workbench = PlatformUI.getWorkbench();
		IWorkbenchWindow activeWorkbenchWindow = workbench.getActiveWorkbenchWindow();
		IWorkbenchPage page = activeWorkbenchWindow.getActivePage();
		XtextEditor editor = (XtextEditor) IDE.openEditor(page, input, editorId, true);
		String languageName = editor.getLanguageName();
		assertEquals(editorId, languageName);
		XtextDocument document = (XtextDocument) editor.getDocument();
		document.modify(new IUnitOfWork<Object, XtextResource>()
		{
			@Override
			public Object exec(XtextResource resource) throws Exception {
				resource.setValidationDisabled(false);
				PivotResourceValidator resourceValidator = new PivotResourceValidator();
				resourceValidator.setDiagnostician(Diagnostician.INSTANCE);
				resourceValidator.setDiagnosticConverter(new PivotDiagnosticConverter());
				resourceValidator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);
				return null;
			}
		});
		document.readOnly(new IUnitOfWork<Object, XtextResource>()
		{
			@Override
			public Object exec(XtextResource resource) throws Exception {
				assertNoResourceErrors("Loaded CS", resource);
				CS2Pivot cs2Pivot = PivotUtil.getAdapter(CS2Pivot.class, resource);		// FIXME Wrong class
				if (cs2Pivot != null) {
					Resource pivotResource = cs2Pivot.getPivotResource(resource);
					assertNoResourceErrors("Loaded pivot", pivotResource);
				}
				return null;
			}
		});
		try {
			return document.get();
		}
		finally {
			doTearDown(editor);
		}
	}	

	protected void flushEvents() {
		IWorkbench workbench = PlatformUI.getWorkbench();
		while (workbench.getDisplay().readAndDispatch());
	}

	protected Set<EObject> indexPivotContent(XtextDocument document, final String prefix) {
		@SuppressWarnings("unused") String doc = document.get();
		final Set<EObject> pivotContent = new HashSet<EObject>();
		document.readOnly(new IUnitOfWork<Object, XtextResource>()
		{
			@Override
			public Object exec(XtextResource resource) throws Exception {
//				assertNoResourceErrors("Loaded CS", resource);
				CS2PivotResourceAdapter cs2Pivot = PivotUtil.getAdapter(CS2PivotResourceAdapter.class, resource);
				if (cs2Pivot != null) {
					Resource pivotResource = cs2Pivot.getPivotResource((BaseCSResource) resource);
					assertNoResourceErrors(prefix, pivotResource);
					for (TreeIterator<EObject> tit = pivotResource.getAllContents(); tit.hasNext(); ) {
						EObject eObject = tit.next();
//						System.out.println(PivotUtil.debugSimpleName(eObject));
						pivotContent.add(eObject);
					}
				}
				return null;
			}
		});
		return pivotContent;
	}	
	
	@Override
	protected void setUp() throws Exception {
		suppressGitPrefixPopUp();    		
		super.setUp();
	}

	public void testEditor_OpenCompleteOCLEditor() throws Exception {
		doTestEditor(CompleteOCLUiModule.EDITOR_ID, "test.ocl",
			"import ecore : 'http://www.eclipse.org/emf/2002/Ecore#/'\n"+
			"package ecore\n"+
			"endpackage");
	}	
	
	public void testEditor_OpenCompleteOCLEditor4Pivot_OCL() throws Exception {
		URI uri = URI.createPlatformPluginURI("org.eclipse.ocl.examples.pivot/model/Pivot.ocl", true);
		String documentText = doTestEditor(CompleteOCLUiModule.EDITOR_ID, uri);
		assertTrue(documentText.contains("inv CollectNestedTypeIsBag: name = 'collectNested' implies type.oclIsKindOf(BagType)"));
	}	
	
	public void testEditor_OpenCompleteOCLEditor4Fruit_OCL() throws Exception {
		URI uri = URI.createPlatformPluginURI("org.eclipse.ocl.examples.xtext.tests/src/org/eclipse/ocl/examples/test/xtext/models/Fruit.ocl", true);
		String documentText = doTestEditor(CompleteOCLUiModule.EDITOR_ID, uri);
		assertTrue(documentText.contains("body: Color::red"));
	}	
	
	public void testEditor_OpenEssentialOCLEditor() throws Exception {
		doTestEditor(EssentialOCLUiModule.EDITOR_ID, "test.essentialocl", "1 + 4");
	}	
	
	public void testEditor_OpenOCLinEcoreEditor() throws Exception {
		doTestEditor(OCLinEcoreUiModule.EDITOR_ID, "test.oclinecore", "package test : test = 'test' { }");
	}	
	
	public void testEditor_OpenOCLinEcoreEditor4Ecore() throws Exception {
		doTestEditor(OCLinEcoreUiModule.EDITOR_ID, "test.ecore", "package test : test = 'test' { }");
	}	
	
	public void testEditor_OpenOCLStdLibEditor() throws Exception {
		doTestEditor(OCLstdlibUiModule.EDITOR_ID, "test.oclstdlib",
			"import 'http://www.eclipse.org/ocl/3.1.0/OCL.oclstdlib';\n" + 
			"library test : xxx = 'http://www.eclipse.org/ocl/3.1.0/OCL.oclstdlib' { }");
	}	
	
	public void testEditor_OpenOCLStdLibEditor4OCL_OCLstdlib() throws Exception {
		URI uri = URI.createPlatformPluginURI("org.eclipse.ocl.examples.library/model/OCL-2.4.oclstdlib", true);
		String documentText = doTestEditor(OCLstdlibUiModule.EDITOR_ID, uri);
		assertTrue(documentText.contains("type UniqueCollection(T) : CollectionType conformsTo Collection(T) {"));
	}	
	
	public void testEditor_OpenOCLinEcoreEditor4Ecore_Ecore() throws Exception {
		URI uri = URI.createPlatformPluginURI("org.eclipse.emf.ecore/model/Ecore.ecore", true);
		String documentText = doTestEditor(OCLinEcoreUiModule.EDITOR_ID, uri);
		assertTrue(documentText.contains("abstract class ETypedElement extends ENamedElement"));		// No ecore:: qualification
	}	
	
	public void testEditor_OpenOCLinEcoreEditor4Pivot_Ecore() throws Exception {
		URI uri = URI.createPlatformPluginURI(PivotConstants.PIVOT_ECORE, true);
		String documentText = doTestEditor(OCLinEcoreUiModule.EDITOR_ID, uri);
		assertTrue(documentText.contains("abstract class Visitable : 'org.eclipse.ocl.examples.pivot.util.Visitable' { interface };"));
		assertTrue(documentText.contains("reference Type::ownedAttribute"));							// Tests Bug 363141 EAnnotation reference
	}	
	
	// FIXME Bug 399762 fails on Hudson
	public void zztestEditor_OpenOCLinEcoreEditor4Test_Ecore_Update() throws Exception {
		String testDocument = 
			"package tutorial : tuttut = 'http://www.eclipse.org/mdt/ocl/oclinecore/tutorial'\n" +
			"{\n" +
			"	class Library\n" +
			"	{\n" +
			"		property books#library : Book[*] { composes };\n" +
			"	}\n" +
			"	class Book\n" +
			"	{\n" +
			"		property library#books : Library[?];\n" +
			"	}\n" +
			"}\n";
		FileEditorInput fileEditorInput = createEcoreFileEditorInput("test", "RefreshTest.ecore", testDocument);
		XtextEditor editor = doTestEditor(OCLinEcoreUiModule.EDITOR_ID, fileEditorInput);
		XtextDocument document = (XtextDocument) editor.getDocument();
		Set<EObject> oldPivotContent = indexPivotContent(document, "Loaded pivot");
		oldPivotContent.toString();
		IProject iProject = createProject("test");
		IFile iFile = iProject.getFile("RefreshTest.ecore");
		Reader reader = new InputStreamReader(iFile.getContents());
		char[] cbuf = new char[4096];
		StringBuilder s = new StringBuilder();
		for (int i; (i = reader.read(cbuf)) > 0; ) {
			s.append(cbuf, 0, i);
		}
		String updatedDocument = s.toString().replace("tuttut", "tut");
		iFile.setContents(new URIConverter.ReadableInputStream(updatedDocument, "UTF-8"), true, false, null);
		flushEvents();
		@SuppressWarnings("unused") String newDoc = document.get();
		Set<EObject> newPivotContent = indexPivotContent(document, "Loaded pivot");
		assertEquals(oldPivotContent.size(), newPivotContent.size());
		flushEvents();
		assertEquals(oldPivotContent, newPivotContent);
		flushEvents();
		doTearDown(editor);
	}		
}
