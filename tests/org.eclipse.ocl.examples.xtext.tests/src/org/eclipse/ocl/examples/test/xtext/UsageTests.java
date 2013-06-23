/**
 * <copyright>
 *
 * Copyright (c) 2012, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.test.xtext;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.codegen.ecore.generator.Generator;
import org.eclipse.emf.codegen.ecore.generator.GeneratorAdapterFactory;
import org.eclipse.emf.codegen.ecore.genmodel.GenJDKLevel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenBaseGeneratorAdapter;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenModelGeneratorAdapterFactory;
import org.eclipse.emf.codegen.ecore.genmodel.util.GenModelUtil;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.mwe.core.ConfigurationException;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.oclinecore.OCLinEcoreGeneratorAdapterFactory;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.pivot.library.StandardLibraryContribution;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.tests.PivotTestSuite;
import org.eclipse.xtext.diagnostics.ExceptionDiagnostic;

/**
 * Tests that load a model and verify that there are no unresolved proxies as a
 * result.
 */
public class UsageTests
		extends PivotTestSuite// XtextTestCase
{

	private static final class JavaSourceFileObject
			extends SimpleJavaFileObject {

		private JavaSourceFileObject(java.net.URI uri) {
			super(uri, Kind.SOURCE);
		}

		@Override
		public CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException {
			char[] buf = new char[4096];
			StringBuffer s = new StringBuffer();
			Reader reader = new FileReader(new File(uri));
			try {
				int len;
				while ((len = reader.read(buf)) > 0) {
					s.append(buf, 0, len);
				}
			}
			finally {
				reader.close();
			}
			return s.toString();
		}
	}

	public Logger log;

	public MetaModelManager metaModelManager = null;

	/**
	 * Checks all resources in a resource set for any errors or warnings.
	 * 
	 * @param resourceSet
	 * @throws ConfigurationException
	 *             if any error present
	 */
	public void checkResourceSet(ResourceSet resourceSet)
			throws ConfigurationException {
		int errorCount = 0;
		for (Resource aResource : resourceSet.getResources()) {
			List<Resource.Diagnostic> errors = aResource.getErrors();
			if (errors.size() > 0) {
				for (Resource.Diagnostic error : errors) {
					if (error instanceof ExceptionDiagnostic) {
						log.error("Error for '" + aResource.getURI() + "'",
							((ExceptionDiagnostic) error).getException());
					} else {
						log.error(error + " for '" + aResource.getURI() + "'");
					}
					errorCount++;
				}
			}
			List<Resource.Diagnostic> warnings = aResource.getWarnings();
			if (warnings.size() > 0) {
				for (Resource.Diagnostic warning : warnings) {
					if (warning instanceof ExceptionDiagnostic) {
						log.warn("Warning for '" + aResource.getURI() + "'",
							((ExceptionDiagnostic) warning).getException());
					} else {
						log.warn(warning + " for '" + aResource.getURI() + "'");
					}
				}
			}
		}
		if (errorCount > 0) {
			throw new RuntimeException("Errors in ResourceSet");
		}
	}

	protected void getCompilationUnits(@NonNull List<JavaFileObject> compilationUnits,
			@NonNull File directory) throws Exception {
		File[] files = directory.listFiles();
		if (files != null) {
			for (File file : files) {
				if (file.isDirectory()) {
					getCompilationUnits(compilationUnits, file);
				} else if (file.isFile()) {
//					System.out.println("Compiling " + file);
					compilationUnits.add(new JavaSourceFileObject(file.toURI()));
				}
			}
		}
	}

	protected void getCompilationUnits(@NonNull List<JavaFileObject> compilationUnits,
			@NonNull IContainer container) throws CoreException {
		for (IResource member : container.members()) {
			if (member instanceof IContainer) {
				getCompilationUnits(compilationUnits, (IContainer) member);
			} else if ((member instanceof IFile)
				&& member.getFileExtension().equals("java")) {
				java.net.URI locationURI = member.getLocationURI();
//				System.out.println("Compiling " + locationURI);
				compilationUnits.add(new JavaSourceFileObject(locationURI));
			}
		}
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		log = Logger.getLogger(UsageTests.class);
		// AcceleoNature.class.getName(); // Pull in the plugin for Hudson
		doOCLinEcoreSetup();
		configurePlatformResources();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
			.put("pivot", new XMIResourceFactoryImpl()); //$NON-NLS-1$
	}

	@Override
	protected void tearDown()
			throws Exception {
		log = null;
		if (metaModelManager != null) {
			metaModelManager.dispose();
			metaModelManager = null;
		}
		StandardLibraryContribution.REGISTRY
			.remove(MetaModelManager.DEFAULT_OCL_STDLIB_URI);
		uninstall();
		super.tearDown();
	}

	public void createGenModelFile(String fileName, String fileContent)
			throws IOException {
		File file = new File(getProjectFile(), fileName);
		Writer writer = new FileWriter(file);
		writer.append(fileContent);
		writer.close();
	}

	protected boolean doCompile(@NonNull String testProjectName,
			@NonNull String testFileStem)
			throws Exception {
		List<String> compilationOptions = Arrays.asList("-d", "bin", "-source",
			"1.5", "-target", "1.5", "-g");;
		List<JavaFileObject> compilationUnits = new ArrayList<JavaFileObject>();
		Object context = null;
		if (EMFPlugin.IS_ECLIPSE_RUNNING) {
			IWorkspace workspace = ResourcesPlugin.getWorkspace();
			IProject project = workspace.getRoot().getProject(testProjectName);
			if (project != null) {
				getCompilationUnits(compilationUnits, project);
				java.net.URI locationURI = project.getLocationURI();
				compilationOptions.set(1, locationURI + "/bin");
			}
			context = project;
		} else {
			File dir = new File("src-gen/" + testProjectName);
			getCompilationUnits(compilationUnits, dir);
			context = dir;
		}

		DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager stdFileManager = compiler
			.getStandardFileManager(null, Locale.getDefault(), null);

		// System.out.printf("%6.3f getTask\n", 0.001 *
		// (System.currentTimeMillis()-base));
		CompilationTask compilerTask = compiler.getTask(null, stdFileManager,
			diagnostics, compilationOptions, null, compilationUnits);
		// System.out.printf("%6.3f call\n", 0.001 *
		// (System.currentTimeMillis()-base));
		if (!compilerTask.call()) {
			StringBuilder s = new StringBuilder();
			for (javax.tools.Diagnostic<?> diagnostic : diagnostics
				.getDiagnostics()) {
				s.append("\n" + diagnostic);
			}
			if (s.length() > 0) {
				throw new IOException("Failed to compile " + context
					+ s.toString());
			}
			System.out.println("Compilation of " + context
				+ " returned false but no diagnostics");
		}
		// System.out.printf("%6.3f close\n", 0.001 *
		// (System.currentTimeMillis()-base));
		stdFileManager.close(); // Close the file manager which re-opens
								// automatically
		// System.out.printf("%6.3f forName\n", 0.001 *
		// (System.currentTimeMillis()-base));
		// Class<?> testClass = Class.forName(qualifiedName);
		// return testClass;

		return true;
	}

	protected void doDelete(@NonNull String testProjectName) throws Exception {
		if (EMFPlugin.IS_ECLIPSE_RUNNING) {
			suppressGitPrefixPopUp();
			IWorkspace workspace = ResourcesPlugin.getWorkspace();
			IProject project = workspace.getRoot().getProject(testProjectName);
			project.delete(true, true, null);
		} else {
			File dir = new File("src-gen/" + testProjectName);
			if (dir.exists()) {
				doDeleteDirectory(dir);
			}
		}
	}

	protected void doDeleteDirectory(File dir) throws Exception {
		File[] listFiles = dir.listFiles();
		for (File file : listFiles) {
			if (file.isFile()) {
				file.delete();
			} else if (file.isDirectory()) {
				doDeleteDirectory(file);
			}
		}
		dir.delete();
	}

	protected void doGenModel(@NonNull String testProjectName,
			@NonNull String testFileStem, @NonNull String oclinecoreFile,
			@NonNull String genmodelFile)
			throws Exception {
		if (EMFPlugin.IS_ECLIPSE_RUNNING) {
			suppressGitPrefixPopUp();
			IWorkspace workspace = ResourcesPlugin.getWorkspace();
			IProject project = workspace.getRoot().getProject(testProjectName);
			if (!project.exists()) {
				project.create(null);
			}
		}
		MetaModelManager metaModelManager2 = new MetaModelManager();
		metaModelManager = metaModelManager2;
		createEcoreFile(metaModelManager2, testFileStem, oclinecoreFile);
		createGenModelFile(testFileStem + ".genmodel", genmodelFile);
		GeneratorAdapterFactory.Descriptor.Registry.INSTANCE.addDescriptor(
			GenModelPackage.eNS_URI,
			OCLinEcoreGeneratorAdapterFactory.DESCRIPTOR);
		URI fileURI = getProjectFileURI(testFileStem + ".genmodel");
		// System.out.println("Generating Ecore Model using '" + fileURI + "'");
		metaModelManager2.dispose();
		metaModelManager = new MetaModelManager();
		ResourceSet resourceSet = metaModelManager2.getExternalResourceSet();
		resourceSet.getPackageRegistry().put(GenModelPackage.eNS_URI,
			GenModelPackage.eINSTANCE);
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
			.put("genmodel", new EcoreResourceFactoryImpl());
		GeneratorAdapterFactory.Descriptor.Registry.INSTANCE
			.addDescriptor(GenModelPackage.eNS_URI,
				GenModelGeneratorAdapterFactory.DESCRIPTOR);
		GeneratorAdapterFactory.Descriptor.Registry.INSTANCE.addDescriptor(
			GenModelPackage.eNS_URI,
			OCLinEcoreGeneratorAdapterFactory.DESCRIPTOR);
		if (resourceSet instanceof ResourceSetImpl) {
			ResourceSetImpl resourceSetImpl = (ResourceSetImpl) resourceSet;
			Map<URI, Resource> uriResourceMap = resourceSetImpl
				.getURIResourceMap();
			if (uriResourceMap != null) {
				uriResourceMap.clear();
			}
		}
		resourceSet.getResources().clear();
		Resource resource = resourceSet.getResource(fileURI, true);
		// EcoreUtil.resolveAll(resourceSet); -- genModel can fail if
		// proxies resolved here
		// problem arises if genmodel has an obsolete feature for a feature
		// moved up the inheritance hierarchy
		// since the proxy seems to be successfully resolved giving a double
		// feature
		checkResourceSet(resourceSet);
		EObject eObject = resource.getContents().get(0);
		if (!(eObject instanceof GenModel)) {
			throw new ConfigurationException("No GenModel found in '"
				+ resource.getURI() + "'");
		}
		GenModel genModel = (GenModel) eObject;
		genModel.reconcile();
		checkResourceSet(resourceSet);
		// genModel.setCanGenerate(true);
		// validate();

		genModel.setValidateModel(true); // The more checks the better
		// genModel.setCodeFormatting(true); // Normalize layout
		genModel.setForceOverwrite(false); // Don't overwrite read-only
											// files
		genModel.setCanGenerate(true);
		// genModel.setFacadeHelperClass(null); // Non-null gives JDT
		// default NPEs
		// genModel.setFacadeHelperClass(StandaloneASTFacadeHelper.class.getName());
		// // Bug 308069
		// genModel.setValidateModel(true);
		genModel.setBundleManifest(false); // New manifests should be
											// generated manually
		genModel.setUpdateClasspath(false); // New class-paths should be
											// generated manually
		genModel.setComplianceLevel(GenJDKLevel.JDK50_LITERAL);
		// genModel.setRootExtendsClass("org.eclipse.emf.ecore.impl.MinimalEObjectImpl$Container");
		Diagnostic diagnostic = genModel.diagnose();
		if (diagnostic.getSeverity() != Diagnostic.OK) {
			fail(diagnostic.toString());
		}

		/*
		 * JavaModelManager.getJavaModelManager().initializePreferences(); new
		 * JavaCorePreferenceInitializer().initializeDefaultPreferences();
		 * 
		 * GenJDKLevel genSDKcomplianceLevel = genModel.getComplianceLevel();
		 * String complianceLevel = JavaCore.VERSION_1_5; switch
		 * (genSDKcomplianceLevel) { case JDK60_LITERAL: complianceLevel =
		 * JavaCore.VERSION_1_6; case JDK14_LITERAL: complianceLevel =
		 * JavaCore.VERSION_1_4; default: complianceLevel =
		 * JavaCore.VERSION_1_5; } // Hashtable<?,?> defaultOptions =
		 * JavaCore.getDefaultOptions(); //
		 * JavaCore.setComplianceOptions(complianceLevel, defaultOptions); //
		 * JavaCore.setOptions(defaultOptions);
		 */

		Generator generator = GenModelUtil.createGenerator(genModel);
		Monitor monitor = new BasicMonitor();
		diagnostic = generator.generate(genModel,
			GenBaseGeneratorAdapter.MODEL_PROJECT_TYPE, monitor);
		if (diagnostic.getSeverity() != Diagnostic.OK) {
			fail(diagnostic.toString());
		}
	}

	public void testBug370824()
			throws Exception {
		String testFileStem = "Bug370824";
		String testProjectName = "bug370824";
		String testProjectPath = EMFPlugin.IS_ECLIPSE_RUNNING
			? testProjectName
			: "org.eclipse.ocl.examples.xtext.tests";
		String oclinecoreFile = "package bug370824 : bug370824 = 'http://bug370824'\n"
			+ "{\n"
			+ "    class Clase1\n"
			+ "    {\n"
			+ "        invariant : self.name.size() > 0;\n"
			+ "        attribute name : String[?] { ordered };\n"
			+ "    }\n"
			+ "}\n";
		String genmodelFile = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
			+ "<genmodel:GenModel xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:ecore=\"http://www.eclipse.org/emf/2002/Ecore\"\n"
			+ "    xmlns:genmodel=\"http://www.eclipse.org/emf/2002/GenModel\" modelDirectory=\"/"
			+ testProjectPath
			+ "/src-gen\" modelPluginID=\"Bug370824.bug370824\"\n"
			+ "    modelName=\"Bug370824\" importerID=\"org.eclipse.emf.importer.ecore\" complianceLevel=\"5.0\"\n"
			+ "    copyrightFields=\"false\" bundleManifest=\"false\">\n"
			+ "  <foreignModel>Bug370824.ecore</foreignModel>\n"
			+ "  <genPackages prefix=\"Bug370824\" disposableProviderFactory=\"true\" ecorePackage=\"Bug370824.ecore#/\">\n"
			+ "  </genPackages>\n" + "</genmodel:GenModel>\n" + "\n";
		doGenModel(testProjectPath, testFileStem, oclinecoreFile, genmodelFile);
	}

	public void testBug409650()
			throws Exception {
		String testFileStem = "Bug409650";
		String testProjectName = "bug409650";
		String testProjectPath = EMFPlugin.IS_ECLIPSE_RUNNING
			? testProjectName
			: "org.eclipse.ocl.examples.xtext.tests";
		String oclinecoreFile = "package bug409650 : bug409650 = 'http://bug409650'\n"
			+ "{\n"
			+ "    class Clase1\n"
			+ "    {\n"
			+ "        invariant : self.name.size() > 0;\n"
			+ "        attribute name : String[?] { ordered };\n"
			+ "        operation copy(b : Boolean) : Boolean { body: b; }\n"
			+ "        operation complement(b : Boolean) : Boolean { body: not b; }\n"
			+ "        operation myPrefixedName(s1 : String, s2 : String) : String { body: s1 + name + s2; }\n"
			+ "        operation me() : Clase1 { body: self.oclAsType(Clase1); }\n"
			+ "    }\n" + "}\n";
		String genmodelFile = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
			+ "<genmodel:GenModel xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:ecore=\"http://www.eclipse.org/emf/2002/Ecore\"\n"
			+ "    xmlns:genmodel=\"http://www.eclipse.org/emf/2002/GenModel\" modelDirectory=\"/"
			+ testProjectPath
			+ "/src-gen\" modelPluginID=\"Bug409650.bug409650\"\n"
			+ "    modelName=\"Bug409650\" importerID=\"org.eclipse.emf.importer.ecore\" complianceLevel=\"5.0\"\n"
			+ "    operationReflection=\"true\" copyrightFields=\"false\" bundleManifest=\"false\">\n"
			+ "  <genAnnotations source=\"http://www.eclipse.org/OCL/GenModel\">\n"
			+ "    <details key=\"Use Delegates\" value=\"false\"/>\n"
			+ "    <details key=\"Use Null Annotations\" value=\"false\"/>\n"
			+ "  </genAnnotations>\n"
			+ "  <foreignModel>Bug409650.ecore</foreignModel>\n"
			+ "  <genPackages prefix=\"Bug409650\" disposableProviderFactory=\"true\" ecorePackage=\"Bug409650.ecore#/\">\n"
			+ "  </genPackages>\n" + "</genmodel:GenModel>\n" + "\n";
		doDelete(testProjectName);
		doGenModel(testProjectPath, testFileStem, oclinecoreFile, genmodelFile);
		doCompile(testProjectName, testFileStem);
		if (!EMFPlugin.IS_ECLIPSE_RUNNING) { // FIXME find out how to get
												// dynamic project onto
												// classpath
			String qualifiedPackageName = testProjectName + "." + testFileStem
				+ "Package";
			EPackage ePackage = doLoadPackage(qualifiedPackageName);
//			System.out.println("Loaded " + ePackage);
			EClass eClass = (EClass) ePackage.getEClassifier("Clase1");
			EStructuralFeature eStructuralFeature = eClass
				.getEStructuralFeature("name");
			EFactory eFactory = ePackage.getEFactoryInstance();
			//
			EObject eObject = eFactory.create(eClass);
			assertQueryTrue(eObject, "name = null");
			assertQueryTrue(eObject, "complement(true) = false");
			eObject.eSet(eStructuralFeature, "testing");
			assertQueryFalse(eObject, "name = null");
			assertQueryTrue(eObject, "name = 'testing'");
			assertQueryEquals(eObject, "XtestingY",
				"self.myPrefixedName('X', 'Y')");
			assertQueryEquals(eObject, eObject, "self.me()");
		}
	}

	protected EPackage doLoadPackage(@NonNull String qualifiedPackageName)
			throws Exception {
		Class<?> testClass = Class.forName(qualifiedPackageName);
//		System.out.println("Loaded " + testClass.getName());
		Object eInstance = testClass.getDeclaredField("eINSTANCE").get(null);
		return (EPackage) eInstance;
	}

	public void testInitStatics() {
		assertTrue(ValuesUtil.initAllStatics());
		assertFalse(ValuesUtil.initAllStatics());
	}

	/*
	 * public void testType_Parameters() throws Exception { String testFile =
	 * "import ecore : 'http://www.eclipse.org/emf/2002/Ecore#/';\n" +
	 * "package C1 : C2 = 'C3'\n" + "{\n" + "    class A {\n" +
	 * "    	operation opEBigInteger(arg : ecore::EBigInteger) : Boolean {\n" +
	 * "	 	}\n" + "	 }\n" + "    class Test {\n" + "       property a : A;\n" +
	 * "       invariant EBigInteger: a.opEBigInteger(1);\n" + "    }\n" +
	 * "}\n"; doLoadFromString("Type_Parameters.oclinecore", testFile); }
	 */
}
