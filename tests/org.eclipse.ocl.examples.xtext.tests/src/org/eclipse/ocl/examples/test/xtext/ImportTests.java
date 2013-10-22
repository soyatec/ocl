/**
 * <copyright>
 *
 * Copyright (c) 2010, 2012 E.D.Willink and others.
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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainCallExp;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.library.AbstractOperation;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.Bag;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.domain.values.impl.BagImpl;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.pivot.library.StandardLibraryContribution;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
import org.eclipse.ocl.examples.xtext.tests.TestCaseAppender;
import org.eclipse.ocl.examples.xtext.tests.XtextTestCase;

/**
 * Tests that load a model and verify that there are no unresolved proxies as a result.
 */
public class ImportTests extends XtextTestCase
{	
	public static class SpacedOut extends AbstractOperation
	{
		public static final SpacedOut INSTANCE = new SpacedOut();

		@Override
		public Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainCallExp callExp,
				@Nullable Object sourceValue, @NonNull Object... argumentValues) {
			String string = sourceValue == null? Value.INVALID_NAME : ValuesUtil.oclToString(sourceValue);
			return string;
		}
	}
	
	protected MetaModelManager metaModelManager = null;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		configurePlatformResources();
//		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(PivotConstants.OCL_AS_FILE_EXTENSION, new XMIResourceFactoryImpl()); //$NON-NLS-1$
	}

	@Override
	protected void tearDown() throws Exception {
//		MetaModelManagerResourceSetAdapter adapter = MetaModelManagerResourceSetAdapter.findAdapter(resourceSet);
//		if (adapter != null) {
//			MetaModelManager metaModelManager = adapter.getMetaModelManager();
//			if (metaModelManager != null) {
//				metaModelManager.dispose();
//			}
//		}
		if (metaModelManager != null) {
			metaModelManager.dispose();
			metaModelManager = null;
		}
		StandardLibraryContribution.REGISTRY.remove(MetaModelManager.DEFAULT_OCL_STDLIB_URI);
		super.tearDown();
	}

	protected void createTestImport_OCLinEcore_Bug353793_Files()
			throws IOException {
		MetaModelManager metaModelManager = new MetaModelManager();
		String testFileA =
				"package A1 : A2 = 'http://A3'{\n" +
				"    class A;\n" +
				"}\n";
		createOCLinEcoreFile("Bug353793A.oclinecore", testFileA);
		String testFileB =
				"package B1 : B2 = 'http://B3'{\n" +
				"    class B;\n" +
				"}\n";
		createOCLinEcoreFile("Bug353793B.oclinecore", testFileB);
		String testFileE =
				"package E1 : E2 = 'http://E3'{\n" +
				"    class E;\n" +
				"}\n";
		createEcoreFile(metaModelManager, "Bug353793E", testFileE);
		String testFileF =
				"package F1 : F2 = 'http://F3'{\n" +
				"    class F;\n" +
				"}\n";
		createEcoreFile(metaModelManager, "Bug353793F", testFileF);
		metaModelManager.dispose();
	}	

	protected String getNoSuchFileMessage() {
		if (isWindows()) {
			return "{0} (The system cannot find the file specified)";
		}
		else {
			return "{0} (No such file or directory)";
		}
	}
	
	public void testImport_CompleteOCL_Ecore() throws Exception {
		TestCaseAppender.INSTANCE.uninstall();
		String testFile =
			"import 'Names.ecore'\n" +
			"package names\n" +
			"context Named\n" +
			"inv Bogus: r.toString() = s.toString()\n" +
			"endpackage\n";
		doLoadFromString("string.ocl", testFile);
	}
	
	public void testImport_CompleteOCL_OCLinEcore() throws Exception {
		TestCaseAppender.INSTANCE.uninstall();
		String testFile =
			"import 'Names.oclinecore'\n" +
			"package EMOF\n" +
			"context Class\n" +
			"inv Bogus: isAbstract\n" +
			"endpackage\n";
		doLoadFromString("string.ocl", testFile);
	}
	
	public void testImport_CompleteOCL_OCLstdlib() throws Exception {
		TestCaseAppender.INSTANCE.uninstall();
		String testFile =
			"library 'minimal.oclstdlib'\n" +
			"import 'Names.ecore'\n" +
			"package names\n" +
			"context Named\n" +
			"inv Bogus: r.toString() and s.toString()\n" +
			"endpackage\n";
		Bag<String> bag = new BagImpl<String>();
		bag.add(DomainUtil.bind(OCLMessages.UnresolvedOperation_ERROR_, "toString", "OclInvalid"));
		bag.add(DomainUtil.bind(OCLMessages.UnresolvedOperation_ERROR_, "toString", "Real"));
		// There are no precedences so =(s) ratherb than =(s.toString())
		bag.add(DomainUtil.bind(OCLMessages.UnresolvedOperationCall_ERROR_, "and", "OclInvalid", "String"));
		doBadLoadFromString("string.ocl", testFile, bag);
	}
	
	public void testImport_CompleteOCL_custom_OCLstdlib() throws Exception {
		TestCaseAppender.INSTANCE.uninstall();
		String customLibrary =
			"library lib {\n" +
			"type Real : PrimitiveType {\n" +
			"operation spacedOut() : String => 'org.eclipse.ocl.examples.test.xtext.ImportTests$SpacedOut';\n" +
			"}\n" +
			"}\n";
		createOCLinEcoreFile("custom.oclstdlib", customLibrary);
		String testFile =
			"library 'minimal.oclstdlib'\n" +
			"library 'custom.oclstdlib'\n" +
			"import 'Names.ecore'\n" +
			"package names\n" +
			"context Named\n" +
			"inv Custom_Real_SpacedOut_Exists: r.spacedOut()\n" +
			"inv Standard_Real_ToString_DoesNotExist: r.toString()\n" +
			"endpackage\n";
		Bag<String> bag = new BagImpl<String>();
		bag.add(DomainUtil.bind(OCLMessages.UnresolvedOperation_ERROR_, "toString", "Real"));
		doBadLoadFromString("string.ocl", testFile, bag);
	}
	
	public void testImport_CompleteOCL_UML() throws Exception {
		TestCaseAppender.INSTANCE.uninstall();
		String testFile =
			"import 'Names.uml'\n" +
			"package unames\n" +
			"context UNamed\n" +
			"inv Bogus: r.toString() = s.toString()\n" +
			"endpackage\n";
		doLoadFromString("string.ocl", testFile);
	}
	
	public void testImport_CompleteOCL_NoSuchFile() throws Exception {
		TestCaseAppender.INSTANCE.uninstall();
		String testFile =
			"import 'NoSuchFile1'\n" + 
			"import 'NoSuchFile2.ocl'\n" +
			"import 'NoSuchFile1'\n";
		Bag<String> bag = new BagImpl<String>();
		String template2 = getNoSuchFileMessage();
		bag.add(DomainUtil.bind(OCLMessages.UnresolvedImport_ERROR_, "NoSuchFile1", DomainUtil.bind(template2, getProjectFileURI("NoSuchFile1").toFileString())));
		bag.add(DomainUtil.bind(OCLMessages.UnresolvedImport_ERROR_, "NoSuchFile1", DomainUtil.bind(template2, getProjectFileURI("NoSuchFile1").toFileString())));
		bag.add(DomainUtil.bind(OCLMessages.UnresolvedImport_ERROR_, "NoSuchFile2.ocl", DomainUtil.bind(template2, getProjectFileURI("NoSuchFile2.ocl").toFileString())));
		doBadLoadFromString("string.ocl", testFile, bag);
	}

	public void testImport_OCLinEcore_Bug353793_Good() throws Exception {
		createTestImport_OCLinEcore_Bug353793_Files();
		String testFileGood =
				"import 'http://www.eclipse.org/emf/2002/Ecore';\n" +
				"import A0 : 'Bug353793A.oclinecore';\n" +
				"import 'Bug353793B.oclinecore';\n" +
				"import 'Bug353793E.ecore';\n" +
				"import F0 : 'Bug353793F.ecore';\n" +
				"import G0 : 'Bug353793F.ecore#/';\n" +
				"package C1 : C2 = 'C3'\n" +
				"{\n" +
				"    class AD01 extends A0::A1::A;\n" +
				"    class BD1 extends B1::B;\n" +
				"    class ED1 extends E1::E;\n" +
				"    class FD01 extends F0::F1::F;\n" +
				"    class GD0 extends G0::F;\n" +
				"}\n";
		doLoadFromString("Bug353793good.oclinecore", testFileGood);
	}

	public void testImport_OCLinEcore_Bug353793_Bad() throws Exception {
		createTestImport_OCLinEcore_Bug353793_Files();
		String testFileBad =
				"import 'http://www.eclipse.org/emf/2002/Ecore';\n" +
				"import A0 : 'Bug353793A.oclinecore';\n" +	// package A1 : A2 = 'http://A3'{ class A; }
				"import 'Bug353793B.oclinecore';\n" +		// package B1 : B2 = 'http://B3'{ class B; }
				"import 'Bug353793E.ecore';\n" +			// package E1 : E2 = 'http://E3'{ class E; }
				"import F0 : 'Bug353793F.ecore';\n" +		// package F1 : F2 = 'http://F3'{ class F; }
				"import G0 : 'Bug353793F.ecore#/';\n" +
				"package C1 : C2 = 'C3'\n" +
				"{\n" +
				"    class AD0 extends A0::A;\n" +
				"    class AD1 extends A1::A;\n" +
				"    class AD2 extends _'http://A3'::A;\n" +
				"    class AD3 extends A2::A;\n" +
				"    class AD4 extends A3::A;\n" +
				"    class AD011 extends A0::A1::A1::A;\n" +
				"    class BD0 extends B0::B;\n" +
				"    class BD01 extends B0::B1::B;\n" +
				"    class BD11 extends B1::B1::B;\n" +
				"    class BD2 extends B2::B;\n" +
				"    class BD3 extends B3::B;\n" +
				"    class GDC extends G0::C1::GD01;\n" +
				"    class GD01 extends G0::F1::F;\n" +
				"}\n";
		Bag<String> bag = new BagImpl<String>();
		// class AD0 extends A0::A;
		bag.add(DomainUtil.bind(OCLMessages.UnresolvedType_ERROR_, "A"));
		// class AD3 extends A2::A;
		bag.add(DomainUtil.bind(OCLMessages.UnresolvedNamespace_ERROR_, "A2"));
		// class AD4 extends A3::A;
		bag.add(DomainUtil.bind(OCLMessages.UnresolvedNamespace_ERROR_, "A3"));
		// class AD011 extends A0::A1::A1::A;
		bag.add(DomainUtil.bind(OCLMessages.UnresolvedNamespace_ERROR_, "A1"));
		// class BD0 extends B0::B;
		bag.add(DomainUtil.bind(OCLMessages.UnresolvedNamespace_ERROR_, "B0"));
		// class BD01 extends B0::B1::B;
		bag.add(DomainUtil.bind(OCLMessages.UnresolvedNamespace_ERROR_, "B0"));
		// class BD11 extends B1::B1::B;
		bag.add(DomainUtil.bind(OCLMessages.UnresolvedNamespace_ERROR_, "B1"));
		// class BD2 extends B2::B;
		bag.add(DomainUtil.bind(OCLMessages.UnresolvedNamespace_ERROR_, "B2"));
		// class BD3 extends B3::B;
		bag.add(DomainUtil.bind(OCLMessages.UnresolvedNamespace_ERROR_, "B3"));
		// class GDC extends G0::C1::GD01;
		bag.add(DomainUtil.bind(OCLMessages.UnresolvedNamespace_ERROR_, "C1"));
		// class GD01 extends G0::F1::F;
		bag.add(DomainUtil.bind(OCLMessages.UnresolvedNamespace_ERROR_, "F1"));
		doBadLoadFromString("Bug353793bad.oclinecore", testFileBad, bag);
	}
	
	public void testImport_OCLinEcore_Ecore() throws Exception {
		TestCaseAppender.INSTANCE.uninstall();
		String testFile =
			"import 'Names.ecore';\n" +
			"import nnnn : 'Names.ecore#/';\n" +
			"package moreNames {\n" +
			"class MoreNames {\n" +
			"attribute n1 : names::Named;\n" +
			"attribute n2 : nnnn::Named;\n" +
			"attribute n3 : xyzzy::Named;\n" +
			"attribute n4 : Named;\n" +
			"}\n" +
			"}\n";
		Bag<String> bag = new BagImpl<String>();
		bag.add(DomainUtil.bind(OCLMessages.UnresolvedNamespace_ERROR_, "xyzzy"));
		bag.add(DomainUtil.bind(OCLMessages.UnresolvedType_ERROR_, "Named"));
		doBadLoadFromString("string.oclinecore", testFile, bag);
	}
	
	public void testImport_OCLinEcore_OCLinEcore() throws Exception {
		TestCaseAppender.INSTANCE.uninstall();
		String testFile =
			"import 'Names.oclinecore';\n" +
//FIXME			"import nnnn : 'Names.oclinecore#/';\n" +
			"package moreNames {\n" +
			"class MoreNames {\n" +
			"attribute n1 : EMOF::Class;\n" +
//			"attribute n2 : nnnn::Class;\n" +
//			"attribute n3 : xyzzy::Named;\n" +
//			"attribute n4 : Named;\n" +
			"}\n" +
			"}\n";
		Bag<String> bag = new BagImpl<String>();
//		bag.add(DomainUtil.bind(OCLMessages.UnresolvedNamespace_ERROR_, "xyzzy"));
//		bag.add(DomainUtil.bind(OCLMessages.UnresolvedType_ERROR_, "Named"));
//		bag.add(DomainUtil.bind(OCLMessages.UnresolvedType_ERROR_, "Named"));
		doBadLoadFromString("string.oclinecore", testFile, bag);
	}
	
	public void testImport_OCLinEcore_NoSuchFile() throws Exception {
		TestCaseAppender.INSTANCE.uninstall();
		String testFile =
			"import 'NoSuchFile1';\n" + 
			"import 'NoSuchFile2.ecore';\n" +
			"import 'NoSuchFile1';\n";
		Bag<String> bag = new BagImpl<String>();
		String template2 = getNoSuchFileMessage();
		bag.add(DomainUtil.bind(OCLMessages.UnresolvedImport_ERROR_, "NoSuchFile1", DomainUtil.bind(template2, getProjectFileURI("NoSuchFile1").toFileString())));
		bag.add(DomainUtil.bind(OCLMessages.UnresolvedImport_ERROR_, "NoSuchFile1", DomainUtil.bind(template2, getProjectFileURI("NoSuchFile1").toFileString())));
		bag.add(DomainUtil.bind(OCLMessages.UnresolvedImport_ERROR_, "NoSuchFile2.ecore", DomainUtil.bind(template2, getProjectFileURI("NoSuchFile2.ecore").toFileString())));
		doBadLoadFromString("string.oclinecore", testFile, bag);
	}
	
	public void testImport_OCLstdlib_OCLstdlib() throws Exception {
		TestCaseAppender.INSTANCE.uninstall();
		String customLibrary =
			"library ocl {\n" +
			"type Complex : PrimitiveType {\n" +
			"operation spacedOut() : String => 'org.eclipse.ocl.examples.test.xtext.ImportTests$SpacedOut';\n" +
			"}\n" +
			"}\n";
		createOCLinEcoreFile("custom.oclstdlib", customLibrary);
		String testFile =
			"import 'http://www.eclipse.org/ocl/3.1.0/OCL.oclstdlib';\n" + 
			"import 'custom.oclstdlib';\n" +
			"library ocl : ocl = 'http://www.eclipse.org/ocl/3.1.0/OCL.oclstdlib' {\n" +
			"type MyType conformsTo OclAny{\n" +
			"operation mixIn(r : Real, z : Complex, t : MyType) : Boolean;\n" +
			"operation mixOut(q : WhatsThis) : Boolean;\n" +
			"}\n" +
			"}\n";
		Bag<String> bag = new BagImpl<String>();
		bag.add(DomainUtil.bind(OCLMessages.UnresolvedType_ERROR_, "WhatsThis"));
		doBadLoadFromString("string.oclstdlib", testFile, bag);
	}
	
	public void testImport_OCLstdlib_NoSuchFile() throws Exception {
		TestCaseAppender.INSTANCE.uninstall();
		String testFile =
			"import 'http://www.eclipse.org/ocl/3.1.0/OCL.oclstdlib';\n" + 
			"import 'NoSuchFile1';\n" + 
			"import 'NoSuchFile2.oclstdlib';\n" +
			"import 'NoSuchFile1';\n" +
			"library anotherOne : xxx = 'http://www.eclipse.org/ocl/3.1.0/OCL.oclstdlib'{}\n";
		Bag<String> bag = new BagImpl<String>();
		String template2 = getNoSuchFileMessage();
		bag.add(DomainUtil.bind(OCLMessages.UnresolvedLibrary_ERROR_, "NoSuchFile1", DomainUtil.bind(template2, getProjectFileURI("NoSuchFile1").toFileString())));
		bag.add(DomainUtil.bind(OCLMessages.UnresolvedLibrary_ERROR_, "NoSuchFile1", DomainUtil.bind(template2, getProjectFileURI("NoSuchFile1").toFileString())));
		bag.add(DomainUtil.bind(OCLMessages.UnresolvedLibrary_ERROR_, "NoSuchFile2.oclstdlib", DomainUtil.bind(template2, getProjectFileURI("NoSuchFile2.oclstdlib").toFileString())));
		doBadLoadFromString("string.oclstdlib", testFile, bag);
	}
	
	public void testImport_OCLstdlib_NoURI() throws Exception {
		TestCaseAppender.INSTANCE.uninstall();
		String testFile =
			"library anotherOne{}\n";
		Bag<String> bag = new BagImpl<String>();
		bag.add(OCLMessages.MissingLibraryURI_ERROR_);
		doBadLoadFromString("string.oclstdlib", testFile, bag);
	}
	
	public void testImport_OCLstdlib_WrongURI() throws Exception {
		TestCaseAppender.INSTANCE.uninstall();
		String testFile =
			"import 'http://www.eclipse.org/ocl/3.1.0/OCL.oclstdlib';\n" + 
			"library anotherOne : xxx = 'http://www.eclipse.org/ocl/3.1/OCL.oclstdlib'{}\n";
		Bag<String> bag = new BagImpl<String>();
		bag.add(OCLMessages.EmptyLibrary_ERROR_);
		bag.add(DomainUtil.bind(OCLMessages.UnresolvedLibrary_ERROR_, "http://www.eclipse.org/ocl/3.1.0/OCL.oclstdlib",
			DomainUtil.bind(OCLMessages.ImportedLibraryURI_ERROR_, "http://www.eclipse.org/ocl/3.1.0/OCL.oclstdlib", "http://www.eclipse.org/ocl/3.1/OCL.oclstdlib")));
		doBadLoadFromString("string.oclstdlib", testFile, bag);
	}
	
	public void testInclude_CompleteOCL() throws Exception {
		TestCaseAppender.INSTANCE.uninstall();
		String moreCompleteOCL =
			"package ocl\n" +
			"context _'Integer'\n" +
			"def: isPositive(z : Integer) : Boolean = true\n" +
			"endpackage\n";
		createOCLinEcoreFile("more.ocl", moreCompleteOCL);
		String testFile =
			"include 'more.ocl'\n" +
			"package ocl\n" +
			"context _'Integer'\n" +
			"def: signum : Integer = 0\n" +
			"context _'UnlimitedNatural'\n" +
			"inv CheckIt: isPositive(1) = signum > 0\n" +
			"endpackage\n";
		doLoadFromString("string.ocl", testFile);
	}
	
	public void testInclude_CompleteOCL_UnresolvedOperation() throws Exception {
		TestCaseAppender.INSTANCE.uninstall();
		String moreCompleteOCL =
			"package ocl\n" +
			"context _'Integer'\n" +
			"def: isPositive() : Boolean = true\n" +
			"endpackage\n";
		createOCLinEcoreFile("more.ocl", moreCompleteOCL);
		String testFile =
			"include 'more.ocl'\n" +
			"package ocl\n" +
			"context _'Integer'\n" +
			"def: signum : Integer = 0\n" +
			"context _'UnlimitedNatural'\n" +
			"inv CheckIt: isPositive() = signum > 0\n" +
			"inv unCheckIt: isNegative() = signum < 0\n" +
			"endpackage\n";
		Bag<String> bag = new BagImpl<String>();
		bag.add(DomainUtil.bind(OCLMessages.UnresolvedOperation_ERROR_, "isNegative", "UnlimitedNatural"));
		doBadLoadFromString("string.ocl", testFile, bag);
	}
}
