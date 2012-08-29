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

import java.math.BigInteger;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.utilities.ProjectMap;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.delegate.OCLDelegateDomain;
import org.eclipse.ocl.examples.pivot.manager.PackageServer;
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
			s.append(text + "\n");
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

		@Override
		public void reset() {
			super.reset();
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
		assertEquals("<b>Evaluating:\n</b>" + testExpression + "\n<b>Results:\n</b>" + expectedResult, string);
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
		assertConsoleResult(consolePage, englishClass, "self.name", "'EnglishClass'\n");
		assertConsoleResult(consolePage, englishClass, "self.extension_InEnglish.instanceType.name", "'EnglishClass$InEnglish'\n");
	}

	public void testConsole_OCLinEcoreTutorial() throws Exception {
		OCL.initialize(resourceSet);
		OCLDelegateDomain.initialize(resourceSet, OCLDelegateDomain.OCL_DELEGATE_URI_PIVOT);			
		URI testModelURI = getTestModelURI("/model/OCLinEcoreTutorialForPivot.xmi");
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new EcoreResourceFactoryImpl());
		Resource xmiResource = resourceSet.getResource(testModelURI, true);
		EObject xmiLibrary = xmiResource.getContents().get(0);
		EClass ecoreLibrary = xmiLibrary.eClass();
		EStructuralFeature ecoreBooks = ecoreLibrary.getEStructuralFeature("books");
		EStructuralFeature ecoreLoans = ecoreLibrary.getEStructuralFeature("loans");
		EClass ecoreBook = (EClass) ecoreBooks.getEType();
		EClass ecoreLoan = (EClass) ecoreLoans.getEType();
		EStructuralFeature bookName = ecoreBook.getEStructuralFeature("name");
		EStructuralFeature loanBook = ecoreLoan.getEStructuralFeature("book");
		EStructuralFeature bookCopies = ecoreBook.getEStructuralFeature("copies");
		@SuppressWarnings("unchecked")
		List<EObject> xmiBooks = (List<EObject>) xmiLibrary.eGet(ecoreBooks);
		EObject b1Book = null;
		EObject b2Book = null;
		for (EObject xmiBook : xmiBooks) {
			if (xmiBook.eGet(bookName).equals("b1")) {
				b1Book = xmiBook;
			}
			else if (xmiBook.eGet(bookName).equals("b2")) {
				b2Book = xmiBook;
			}
		}
		if (b2Book == null) {
			fail();
			return;
		}
		@SuppressWarnings("unchecked")
		EObject aLoan = ((List<EObject>) xmiLibrary.eGet(ecoreLoans)).get(0);
		//
		assertConsoleResult(consolePage, xmiLibrary, "books->sortedBy(name)", "Book b1\nBook b2\n");
		assertConsoleResult(consolePage, xmiLibrary, "isAvailable()", "<b><error>Parsing failure\n</error></b><error>\n1: Unresolved Operation 'unknown-type::isAvailable()'\n</error>");
		assertConsoleResult(consolePage, b2Book, "isAvailable()", "false\n");
		assertConsoleResult(consolePage, b1Book, "isAvailable()", "true\n");
		aLoan.eSet(loanBook, b1Book);
		assertConsoleResult(consolePage, b2Book, "isAvailable()", "false\n");
		assertConsoleResult(consolePage, b1Book, "isAvailable()", "false\n");
		b2Book.eSet(bookCopies, BigInteger.valueOf(3));
		assertConsoleResult(consolePage, b2Book, "isAvailable()", "true\n");
		assertConsoleResult(consolePage, b1Book, "isAvailable()", "false\n");
		//
		assertConsoleResult(consolePage, ecoreBook, "name", "'Book'\n");
		assertConsoleResult(consolePage, ecoreBook, "copies", "<b><error>Parsing failure\n</error></b><error>\n1: Unresolved Property 'unknown-type::copies'\n</error>");
		assertConsoleResult(consolePage, ecoreBook, "oclType().ownedAttribute->sortedBy(name)",
			"ecore::EClass.EClass\n" + 
			"ecore::EClass.EReference\n" + 
			"ecore::EClass.abstract\n" + 
			"ecore::EClass.eAllAttributes\n" + 
			"ecore::EClass.eAllContainments\n" + 
			"ecore::EClass.eAllGenericSuperTypes\n" + 
			"ecore::EClass.eAllOperations\n" + 
			"ecore::EClass.eAllReferences\n" + 
			"ecore::EClass.eAllStructuralFeatures\n" + 
			"ecore::EClass.eAllSuperTypes\n" + 
			"ecore::EClass.eAttributes\n" + 
			"ecore::EClass.eGenericSuperTypes\n" + 
			"ecore::EClass.eIDAttribute\n" + 
			"ecore::EClass.eOperations\n" + 
			"ecore::EClass.eReferences\n" + 
			"ecore::EClass.eStructuralFeatures\n" + 
			"ecore::EClass.eSuperTypes\n" + 
			"ecore::EClass.interface\n");
	}
}
