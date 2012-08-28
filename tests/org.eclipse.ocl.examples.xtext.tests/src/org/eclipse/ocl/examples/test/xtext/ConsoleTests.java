/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.utilities.ProjectMap;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.library.StandardLibraryContribution;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.PackageServer;
import org.eclipse.ocl.examples.pivot.model.OCLstdlib;
import org.eclipse.ocl.examples.pivot.tests.PivotTestSuite;
import org.eclipse.ocl.examples.pivot.uml.UML2Pivot;
import org.eclipse.ocl.examples.pivot.utilities.PivotResource;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.console.ColorManager;
import org.eclipse.ocl.examples.xtext.console.OCLConsole;
import org.eclipse.ocl.examples.xtext.console.OCLConsolePage;
import org.eclipse.ocl.examples.xtext.essentialocl.ui.model.BaseDocument;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.IConsoleView;
import org.eclipse.ui.part.IPageBookViewPage;

/**
 * Tests that exercise the Xtext OCL Console.
 */
public class ConsoleTests extends PivotTestSuite
{	
	public static class TestConsole extends OCLConsole
	{
		private static TestConsole instance;

		public static TestConsole getInstance() {
			if (instance == null) {
				instance = new TestConsole();
				ConsolePlugin.getDefault().getConsoleManager().addConsoles(new IConsole[] {instance});
			}			
			return instance;
		}

		private TestConsolePage page;
		
		@Override
		public IPageBookViewPage createPage(IConsoleView view) {
			page = new TestConsolePage(this);
			return page;
		}
		
		public final TestConsolePage getPage() {
			return page;
		}
	}
	
	public static class TestConsolePage extends OCLConsolePage
	{
		private StringBuilder s = new StringBuilder();
		
		public TestConsolePage(TestConsole testConsole) {
			super(testConsole);
		}

		@Override
		protected void append(String text, RGB rgb, boolean bold) {
			super.append(text, rgb, bold);
			String boldTag;
			if (bold) { boldTag = "b"; }
			else { boldTag = null; }
			String rgbTag;
			if (rgb == ColorManager.DEFAULT) { rgbTag = null; }
			else if (rgb == ColorManager.OUTPUT_ERROR) { rgbTag = "error"; }
			else if (rgb == ColorManager.OUTPUT_RESULTS) { rgbTag = null; }
			else { rgbTag = "?"; }
			if (boldTag != null) {
				s.append("<" + boldTag + ">");
			}
			if (rgbTag != null) {
				s.append("<" + rgbTag + ">");
			}
			s.append(text);
			if (rgbTag != null) {
				s.append("</" + rgbTag + ">");
			}
			if (boldTag != null) {
				s.append("</" + boldTag + ">");
			}
		}

		@Override
		public boolean evaluate(String expression) {
			return super.evaluate(expression);
		}

		public String get() {
			return s.toString();
		}

		@Override
		public void refreshSelection(Object selected) {
			super.refreshSelection(selected);
		}

		public void reset() {
			s = new StringBuilder();
		}
	}

	public static void assertConsoleResult(TestConsolePage consolePage, EObject contextObject, String testExpression, String expectedResult) {
		consolePage.reset();
		consolePage.refreshSelection(contextObject);
		flushEvents();
		BaseDocument editorDocument = consolePage.getEditorDocument();
		editorDocument.set(testExpression);
		consolePage.evaluate(testExpression);
		flushEvents();
		String string = consolePage.get();
		assertEquals("<b>Evaluating:</b>" + testExpression + "<b>Results:</b>" + expectedResult, string);
	}

	public static void flushEvents() {
		for (int i = 0; i < 10; i++) {
			IWorkbench workbench = PlatformUI.getWorkbench();
			while (workbench.getDisplay().readAndDispatch());
		}
	}

	public TestConsolePage consolePage;
	
	protected @NonNull TestConsolePage openConsole() {
		flushEvents();
		TestConsole console = TestConsole.getInstance();
		IConsoleManager mgr = ConsolePlugin.getDefault().getConsoleManager();
		mgr.showConsoleView(console);
		flushEvents();
		@Nullable TestConsolePage consolePage = console.getPage();
		for (int i = 0; (consolePage == null) && (i < 100000); i++) {
			flushEvents();
			consolePage = console.getPage();
		}
		assert consolePage != null;
		return consolePage;
	}	

//	@Override
//	protected void setUp() throws Exception {
//		super.setUp();
//		consolePage = openConsole();
//	}
	public PivotResource pivotResource;
	public Type englishClass;
	public Type frenchClass;
	public Type germanClass;
	public Type plainClass;
	public Type englishClassInEnglish;
	public Type inEnglishStereotype;
	public Type inFrenchStereotype;
	public Type inGermanStereotype;
	
    @Override
    protected void setUp() throws Exception {
        super.setUp();
		consolePage = openConsole();
		StandardLibraryContribution.REGISTRY.put(MetaModelManager.DEFAULT_OCL_STDLIB_URI, new OCLstdlib.Cloner());
		ProjectMap.getAdapter(resourceSet);
		OCL.initialize(resourceSet);
		String problem = UML2Pivot.initialize(resourceSet);
		assertNull(problem);
		URI testModelURI = getTestModelURI("model/InternationalizedClasses.uml");
        Resource umlResource = resourceSet.getResource(testModelURI, true);
        pivotResource = ocl.uml2pivot(umlResource);
        Root root = (Root) pivotResource.getContents().get(0);
        org.eclipse.ocl.examples.pivot.Package modelPackage = PivotUtil.getNamedElement(root.getNestedPackage(), "Model");
        englishClass = PivotUtil.getNamedElement(modelPackage.getOwnedType(), "EnglishClass");
        frenchClass = PivotUtil.getNamedElement(modelPackage.getOwnedType(), "FrenchClass");
        germanClass = PivotUtil.getNamedElement(modelPackage.getOwnedType(), "GermanClass");
        plainClass = PivotUtil.getNamedElement(modelPackage.getOwnedType(), "PlainClass");
        PackageServer profile = metaModelManager.getPackageManager().getPackageByURI("http://www.eclipse.org/ocl/examples/Internationalized");
        inEnglishStereotype = profile.getMemberType("InEnglish");
        inFrenchStereotype = profile.getMemberType("InFrench");
        inGermanStereotype = profile.getMemberType("InGerman");
        englishClassInEnglish = PivotUtil.getNamedElement(englishClass.getExtension(), "EnglishClass$InEnglish");
    }

/*	public void testConsole_Ecore() throws Exception {
//		assertConsoleResult(consolePage, EcorePackage.Literals.ECLASS, "self.name", "'EClass'");
//		assertConsoleResult(consolePage, EcorePackage.Literals.ECLASS, "self.name", "'EClass'");
		assertConsoleResult(consolePage, EcorePackage.Literals.ECLASS, "self.instanceType.eAttributes.name", "");
		assertConsoleResult(consolePage, EcorePackage.Literals.ECLASS, "self.ownedAttribute.name->iterate(s : String ; acc : String = '' | acc + ' ' + s)", "' abstract interface'");
	} */

	public void testConsole_UML() throws Exception {
		assertConsoleResult(consolePage, englishClass, "self.name", "'EnglishClass'");
		assertConsoleResult(consolePage, englishClass, "self.extension_InEnglish.instanceType.name", "'EnglishClass$InEnglish'");
	}
}
