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
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id$
 */

package org.eclipse.ocl.examples.pivot.tests;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.BasicEObjectImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.UnresolvedProxyCrossReferencer;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xml.namespace.XMLNamespacePackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ocl.examples.domain.evaluation.DomainException;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.utilities.ProjectMap;
import org.eclipse.ocl.examples.domain.validation.DomainSubstitutionLabelProvider;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.PivotConstants;
import org.eclipse.ocl.examples.pivot.PivotStandaloneSetup;
import org.eclipse.ocl.examples.pivot.ecore.Pivot2Ecore;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManagerResourceAdapter;
import org.eclipse.ocl.examples.pivot.model.OCLstdlib;
import org.eclipse.ocl.examples.pivot.resource.ASResource;
import org.eclipse.ocl.examples.pivot.utilities.BaseResource;
import org.eclipse.ocl.examples.pivot.utilities.PivotEnvironmentFactory;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.BaseStandaloneSetup;
import org.eclipse.ocl.examples.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.examples.xtext.base.utilities.CS2PivotResourceAdapter;
import org.eclipse.ocl.examples.xtext.completeocl.CompleteOCLStandaloneSetup;
import org.eclipse.ocl.examples.xtext.essentialocl.EssentialOCLStandaloneSetup;
import org.eclipse.ocl.examples.xtext.essentialocl.utilities.EssentialOCLCSResource;
import org.eclipse.ocl.examples.xtext.markup.MarkupStandaloneSetup;
import org.eclipse.ocl.examples.xtext.oclinecore.OCLinEcoreStandaloneSetup;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinecorecs.OCLinEcoreCSPackage;
import org.eclipse.ocl.examples.xtext.oclstdlib.OCLstdlibStandaloneSetup;
import org.eclipse.ocl.examples.xtext.oclstdlib.ui.OCLstdlibUiModule;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.uml2.uml.profile.l2.L2Package;
import org.eclipse.uml2.uml.resource.UML302UMLResource;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.osgi.framework.Bundle;

/**
 * Tests for OclAny operations.
 */
@SuppressWarnings("nls")
public class PivotTestCase extends TestCase
{
	public static final @NonNull String PLUGIN_ID = "org.eclipse.ocl.examples.xtext.tests";
	private static ProjectMap projectMap = null;

	/*
	 * The following may be tweaked to assist debugging.
	 */
	public static boolean DEBUG_GC = false;			// True performs an enmthusuastic resource release and GC at the end of each test 
	public static boolean DEBUG_ID = false;			// TRue prints the start and end of each test.
	{
//		DEBUG_GC = true; 
//		DEBUG_ID = true;
//		MetaModelManager.liveMetaModelManagers = new WeakHashMap<MetaModelManager,Object>();	// Prints the create/finalize of each MetaModelManager
//		ResourceSetImpl.liveResourceSets = new WeakHashMap<ResourceSet,Object>();				// Requires edw-debug privater EMF branch
	}	
	
	public static @NonNull List<Diagnostic> assertDiagnostics(@NonNull String prefix, @NonNull List<Diagnostic> diagnostics, String... messages) {
		Map<String, Integer> expected = new HashMap<String, Integer>();
		for (String message : messages) {
			Integer count = expected.get(message);
			count = count == null ? 1 : count + 1;
			expected.put(message, count);
		}
		StringBuilder s1 = null;
		for (Diagnostic diagnostic : diagnostics) {
			String actual = diagnostic.getMessage();
			Integer expectedCount = expected.get(actual);
			if ((expectedCount == null) || (expectedCount <= 0)) {
				if (s1 == null) {
					s1 = new StringBuilder();
					s1.append("\nUnexpected errors");
				}
				s1.append("\n");
				s1.append(actual);
			}
			else {
				expected.put(actual, expectedCount-1);
			}
		}
		StringBuilder s2 = null;
		for (String key : expected.keySet()) {
			Integer count = expected.get(key);
			while (count-- > 0) {
				if (s2 == null) {
					s2 = new StringBuilder();
					s2.append("\nMissing errors");
				}
				s2.append("\n");
				s2.append(key);
			}
		}
		if (s1 == null) {
			if (s2 != null) {
				fail(s2.toString());
			}
		}
		else {
			if (s2 == null) {
				fail(s1.toString());
			}
			else {
				fail(s1.toString() + s2.toString());
			}
		}
		return diagnostics;
	}

	public static void assertNoDiagnosticErrors(@NonNull String message, @NonNull XtextResource xtextResource) {
		List<Diagnostic> diagnostics = xtextResource.validateConcreteSyntax();
		if (diagnostics.size() > 0) {
			StringBuilder s = new StringBuilder();
			s.append(message);
			for (Diagnostic diagnostic : diagnostics) {
				s.append("\n");
				s.append(diagnostic.toString());
			}
			fail(s.toString());
		}
	}

	public static void assertNoResourceErrors(@NonNull String prefix, @NonNull Resource resource) {
		String message = PivotUtil.formatResourceDiagnostics(DomainUtil.nonNullEMF(resource.getErrors()), prefix, "\n\t");
		if (message != null)
			fail(message);
	}

	public static void assertNoUnresolvedProxies(@NonNull String message, @NonNull Resource resource) {
		Map<EObject, Collection<Setting>> unresolvedProxies = UnresolvedProxyCrossReferencer.find(resource);
		if (unresolvedProxies.size() > 0) {
			StringBuilder s = new StringBuilder();
			s.append(unresolvedProxies.size());
			s.append(" ");	
			s.append(message);
			for (Map.Entry<EObject, Collection<Setting>> unresolvedProxy : unresolvedProxies.entrySet()) {
				s.append("\n");	
				BasicEObjectImpl key = (BasicEObjectImpl) unresolvedProxy.getKey();
				s.append(key.eProxyURI());
				for (Setting setting : unresolvedProxy.getValue()) {
					s.append("\n\t");
					EObject eObject = setting.getEObject();
					s.append(eObject.toString());
				}
			}
			fail(s.toString());
		}
	}

	public static void assertNoValidationErrors(@NonNull String string, @NonNull Resource resource) {
		for (EObject eObject : resource.getContents()) {
			assertNoValidationErrors(string, DomainUtil.nonNullEMF(eObject));
		}
	}

	public static void assertNoValidationErrors(@NonNull String string, @NonNull EObject eObject) {
		Map<Object, Object> validationContext = DomainSubstitutionLabelProvider.createDefaultContext(Diagnostician.INSTANCE);
		Diagnostic diagnostic = Diagnostician.INSTANCE.validate(eObject, validationContext);
		List<Diagnostic> children = diagnostic.getChildren();
		if (children.size() <= 0) {
			return;
		}
		StringBuilder s = new StringBuilder();
		s.append(children.size() + " validation errors");
		for (Diagnostic child : children){
			s.append("\n\t");
			s.append(child.getMessage());
		}
		fail(s.toString());
	}

	public static void assertResourceErrors(@NonNull String prefix, @NonNull Resource resource, String... messages) {
		assertResourceDiagnostics(prefix, DomainUtil.nonNullEMF(resource.getErrors()), messages);
	}

	public static void assertResourceDiagnostics(@NonNull String prefix, @NonNull List<Resource.Diagnostic> resourceDiagnostics, String... messages) {
		Map<String, Integer> expected = new HashMap<String, Integer>();
		for (String message : messages) {
			Integer count = expected.get(message);
			count = count == null ? 1 : count + 1;
			expected.put(message, count);
		}
		StringBuilder s1 = null;
		for (Resource.Diagnostic error : resourceDiagnostics) {
			String actual = error.getMessage();
			Integer expectedCount = expected.get(actual);
			if ((expectedCount == null) || (expectedCount <= 0)) {
				if (s1 == null) {
					s1 = new StringBuilder();
					s1.append("\nUnexpected errors");
				}
				s1.append("\n");
				s1.append(actual);
			}
			else {
				expected.put(actual, expectedCount-1);
			}
		}
		StringBuilder s2 = null;
		for (String key : expected.keySet()) {
			Integer count = expected.get(key);
			while (count-- > 0) {
				if (s2 == null) {
					s2 = new StringBuilder();
					s2.append("\nMissing errors");
				}
				s2.append("\n");
				s2.append(key);
			}
		}
		if (s1 == null) {
			if (s2 == null) {
				return;
			}
			else {
				fail(s2.toString());
			}
		}
		else {
			if (s2 == null) {
				fail(s1.toString());
			}
			else {
				fail(s1.toString() + s2.toString());
			}
		}
	}

	public static @NonNull List<Diagnostic> assertValidationDiagnostics(@NonNull String prefix, @NonNull Resource resource, String... messages) {
		Map<Object, Object> validationContext = DomainSubstitutionLabelProvider.createDefaultContext(Diagnostician.INSTANCE);
		List<Diagnostic> diagnostics = new ArrayList<Diagnostic>();
		for (EObject eObject : resource.getContents()) {
			Diagnostic diagnostic = Diagnostician.INSTANCE.validate(eObject, validationContext);
			diagnostics.addAll(diagnostic.getChildren());
		}
		return assertDiagnostics(prefix, diagnostics, messages);
	}

	/**
	 * Install a platform:/resource/project... mapping for all folders in
	 * $WORKSPACE_LOC/* if defined, or $user.dir/../* otherwise.
	 */
	public static void configurePlatformResources() {
		if (!eclipseIsRunning()) {
			String urlString = System.getProperty("WORKSPACE_LOC");
			File workspaceLoc;
			if (urlString != null) {
				workspaceLoc = new File(urlString);
			}
			else {
				workspaceLoc = new File(System.getProperty("user.dir")).getParentFile();
			}
			File[] files = workspaceLoc.listFiles();
			for (File file : files) {
				if (file.isDirectory()) {
					String name = file.getName();
					EcorePlugin.getPlatformResourceMap().put(name, URI.createFileURI(file.toString() + "/"));
				}
			}
		}
	}
	
	public @NonNull URI createEcoreFile(@NonNull MetaModelManager metaModelManager, @NonNull String fileName, @NonNull String fileContent) throws IOException {
		return createEcoreFile(metaModelManager, fileName, fileContent, false);
	}
	
	@SuppressWarnings("null")
	public @NonNull URI createEcoreFile(@NonNull MetaModelManager metaModelManager, @NonNull String fileName, @NonNull String fileContent, boolean assignIds) throws IOException {
		String inputName = fileName + ".oclinecore";
		createOCLinEcoreFile(inputName, fileContent);
		URI inputURI = getProjectFileURI(inputName);
		URI ecoreURI = getProjectFileURI(fileName + ".ecore");
		CS2PivotResourceAdapter adapter = null;
		try {
			ResourceSet resourceSet2 = metaModelManager.getExternalResourceSet();
			BaseCSResource xtextResource = DomainUtil.nonNullState((BaseCSResource) resourceSet2.getResource(inputURI, true));
			assertNoResourceErrors("Load failed", xtextResource);
			adapter = xtextResource.getCS2ASAdapter(null);
			Resource asResource = adapter.getASResource(xtextResource);
			assertNoUnresolvedProxies("Unresolved proxies", xtextResource);
			assertNoValidationErrors("Pivot validation errors", asResource.getContents().get(0));
			XMLResource ecoreResource = Pivot2Ecore.createResource(metaModelManager, asResource, ecoreURI, null);
			assertNoResourceErrors("To Ecore errors", ecoreResource);
			if (assignIds) {
				for (TreeIterator<EObject> tit = ecoreResource.getAllContents(); tit.hasNext(); ) {
					EObject eObject = tit.next();
					ecoreResource.setID(eObject,  EcoreUtil.generateUUID());
				}
			}
			ecoreResource.save(null);
			return ecoreURI;
		}
		finally {
			if (adapter != null) {
				adapter.dispose();
			}
		}
	}
	
	public void createOCLinEcoreFile(String fileName, String fileContent) throws IOException {
		File file = new File(getProjectFile(), fileName);
		Writer writer = new FileWriter(file);
		writer.append(fileContent);
		writer.close();
	}
	
	public static @NonNull Resource cs2ecore(@NonNull OCL ocl, @NonNull String testDocument, @Nullable URI ecoreURI) throws IOException {
		MetaModelManager metaModelManager = ocl.getMetaModelManager();
		InputStream inputStream = new URIConverter.ReadableInputStream(testDocument, "UTF-8");
		URI xtextURI = URI.createURI("test.oclinecore");
		ResourceSet resourceSet = new ResourceSetImpl();
		EssentialOCLCSResource xtextResource = DomainUtil.nonNullState((EssentialOCLCSResource) resourceSet.createResource(xtextURI, null));
		MetaModelManagerResourceAdapter.getAdapter(xtextResource, metaModelManager);
		xtextResource.load(inputStream, null);
		assertNoResourceErrors("Loading Xtext", xtextResource);
		Resource asResource = cs2pivot(ocl, xtextResource, null);
		Resource ecoreResource = pivot2ecore(ocl, asResource, ecoreURI, true);
		return ecoreResource;
	}
	
	public static @NonNull Resource cs2pivot(@NonNull OCL ocl, @NonNull String testDocument) throws IOException {
		MetaModelManager metaModelManager = ocl.getMetaModelManager();
		InputStream inputStream = new URIConverter.ReadableInputStream(testDocument, "UTF-8");
		URI xtextURI = URI.createURI("test.oclinecore");
		ResourceSet resourceSet = new ResourceSetImpl();
		EssentialOCLCSResource xtextResource = DomainUtil.nonNullState((EssentialOCLCSResource) resourceSet.createResource(xtextURI, null));
		MetaModelManagerResourceAdapter.getAdapter(xtextResource, metaModelManager);
		xtextResource.load(inputStream, null);
		assertNoResourceErrors("Loading Xtext", xtextResource);
		Resource asResource = cs2pivot(ocl, xtextResource, null);
		return asResource;
	}
	
	public static @NonNull Resource cs2pivot(@NonNull OCL ocl, @NonNull BaseResource xtextResource, @Nullable URI pivotURI) throws IOException {
		Resource asResource = ocl.cs2pivot(xtextResource);
		assertNoUnresolvedProxies("Unresolved proxies", asResource);
		if (pivotURI != null) {
			asResource.setURI(pivotURI);
			asResource.save(null);
		}
		return asResource;
	}

	public static void doCompleteOCLSetup() {
    	if (!EMFPlugin.IS_ECLIPSE_RUNNING) {
			CompleteOCLStandaloneSetup.doSetup();
    	}
    	else {
			CompleteOCLStandaloneSetup.init();
    	}
	}

	public static void doEssentialOCLSetup() {
		if (!EMFPlugin.IS_ECLIPSE_RUNNING) {
			EssentialOCLStandaloneSetup.doSetup();
		}
		else {
			EssentialOCLStandaloneSetup.init();
		}
	}

	public static void doOCLinEcoreSetup() {
    	if (!EMFPlugin.IS_ECLIPSE_RUNNING) {
    		OCLinEcoreStandaloneSetup.doSetup();
    	}
    	else {
    		OCLinEcoreStandaloneSetup.init();
    	}
	}

	public static void doOCLstdlibSetup() {
    	OCLstdlibUiModule.USE_RUNTIME_CONFIGURATION = EMFPlugin.IS_ECLIPSE_RUNNING;
    	if (!EMFPlugin.IS_ECLIPSE_RUNNING) {
			OCLstdlibStandaloneSetup.doSetup();			// FIXME BUG 382058
    	}
    	else {
			OCLstdlibStandaloneSetup.init();
    	}
	}

	public static boolean eclipseIsRunning() {
		try {
			Class<?> platformClass = Class.forName("org.eclipse.core.runtime.Platform");
			Method isRunningMethod = platformClass.getDeclaredMethod("isRunning");
			return Boolean.TRUE.equals(isRunningMethod.invoke(null));
		} catch (Exception e) {
		}
		return false;
	}

	protected static Value failOn(@NonNull String expression, @Nullable Throwable e) {
		if (e instanceof DomainException) {
			Throwable eCause = e.getCause();
			if (eCause != null) {
				return failOn(expression, eCause);
			}
			throw new Error("Failed to evaluate \"" + expression + "\"", e);
		}
		else if (e instanceof DomainException) {
			throw new Error("Failed to parse or evaluate \"" + expression + "\"", e);
		}
		else {
	        throw new Error("Failure for \"" + expression + "\"", e);
		}
	}

	protected @NonNull File getProjectFile() {
		String projectName = getProjectName();
		URL projectURL = getTestResource(projectName);	
		assertNotNull(projectURL);
		return new File(projectURL.getFile());
	}
	
	protected @NonNull URI getProjectFileURI(String referenceName) {
		File projectFile = getProjectFile();
		return DomainUtil.nonNullState(URI.createFileURI(projectFile.toString() + "/" + referenceName));
	}
	
	protected @NonNull String getProjectName() {
		return getClass().getPackage().getName().replace('.', '/') + "/models";
	}

	public static @NonNull ProjectMap getProjectMap() {
		ProjectMap projectMap2 = projectMap;
		if (projectMap2 == null) {
			projectMap = projectMap2 = new ProjectMap();
		}
		return projectMap2;
	}
	
	public @NonNull URI getTestModelURI(@NonNull String localFileName) {
		ProjectMap projectMap = getProjectMap();
		String urlString = projectMap.getLocation(PLUGIN_ID).toString();
		TestCase.assertNotNull(urlString);
		return DomainUtil.nonNullEMF(URI.createURI(urlString + localFileName));
	}

	protected @NonNull URL getTestResource(@NonNull String resourceName) {
		URL projectURL = getClass().getClassLoader().getResource(resourceName);
		try {
			if ((projectURL != null) && Platform.isRunning()) {
				try {
					projectURL = FileLocator.resolve(projectURL);
				} catch (IOException e) {
					TestCase.fail(e.getMessage());
					assert false;;
				}
			}
		}
		catch (Throwable e) {}
		return DomainUtil.nonNullState(projectURL);
	}

	public static boolean isWindows() {
		String os = System.getProperty("os.name");
		return (os != null) && os.startsWith("Windows");
	}

	public static @NonNull XtextResource pivot2cs(@NonNull OCL ocl, @NonNull ResourceSet resourceSet, @NonNull ASResource asResource, @NonNull URI outputURI) throws IOException {
		XtextResource xtextResource = DomainUtil.nonNullState((XtextResource) resourceSet.createResource(outputURI, OCLinEcoreCSPackage.eCONTENT_TYPE));
//		ResourceSet csResourceSet = resourceSet; //new ResourceSetImpl();
//		csResourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("cs", new EcoreResourceFactoryImpl());
//		csResourceSet.getPackageRegistry().put(PivotPackage.eNS_URI, PivotPackage.eINSTANCE);
//		Resource csResource = csResourceSet.createResource(uri);
//		URI oclinecoreURI = ecoreResource.getURI().appendFileExtension("oclinecore");
		ocl.pivot2cs(asResource, (BaseResource) xtextResource);
		assertNoResourceErrors("Conversion failed", xtextResource);
//		csResource.save(null);
		//
		//	CS save and reload
		//		
		URI savedURI = DomainUtil.nonNullState(asResource.getURI());
//		asResource.setURI(PivotUtil.getNonPivotURI(savedURI).appendFileExtension(PivotConstants.OCL_AS_FILE_EXTENSION));
		asResource.setURI(outputURI.trimFileExtension().trimFileExtension().appendFileExtension(PivotConstants.OCL_AS_FILE_EXTENSION));
		asResource.save(null);
		asResource.setURI(savedURI);
		
		assertNoDiagnosticErrors("Concrete Syntax validation failed", xtextResource);
		try {
			xtextResource.save(null);
		}
		catch (Exception e) {
			e.printStackTrace();
			URI xmiURI = outputURI.appendFileExtension(".xmi");
			Resource xmiResource = resourceSet.createResource(xmiURI);
			xmiResource.getContents().addAll(xtextResource.getContents());
			xmiResource.save(null);
			fail(e.toString());
		}
		return xtextResource;
	}

	public static @NonNull Resource pivot2ecore(@NonNull OCL ocl, @NonNull Resource asResource, @Nullable URI ecoreURI, boolean validateSaved) throws IOException {
		Resource ecoreResource = ocl.pivot2ecore(asResource, ecoreURI != null ? ecoreURI : DomainUtil.nonNullEMF(URI.createURI("test.ecore")));
		if (ecoreURI != null) {
			ecoreResource.save(null);
		}
		if (validateSaved) {
			assertNoValidationErrors("Pivot2Ecore invalid", ecoreResource);
		}
		return ecoreResource;
	}

	private static boolean testedEgitUiBundle = false;
	
	/**
	 * Suppress diagnostics from EGIT
	 * <p>
	 * This was originally necessary to eliminate a model PopUp that locked up the tests (Bug 390479).
	 * <p>
	 * Now it just suppresses a Console Log entry.
	 */
	public static void suppressGitPrefixPopUp() {
        if (!testedEgitUiBundle) {
        	testedEgitUiBundle = true;
        	Bundle egitUiBundle = Platform.getBundle("org.eclipse.egit.ui");
            if (egitUiBundle != null) {
				try {
					Class<?> activatorClass = egitUiBundle.loadClass("org.eclipse.egit.ui.Activator");
					Class<?> preferencesClass = egitUiBundle.loadClass("org.eclipse.egit.ui.UIPreferences");
					Field field = preferencesClass.getField("SHOW_GIT_PREFIX_WARNING");
					String name = (String)field.get(null);
					Method getDefaultMethod = activatorClass.getMethod("getDefault");
					AbstractUIPlugin activator = (AbstractUIPlugin) getDefaultMethod.invoke(null);
					IPreferenceStore store = activator.getPreferenceStore();
					store.setValue(name, false);
				}
				catch (Exception e) {}			// Ignore
			}
        }
	}

	public static void unloadResourceSet(@NonNull ResourceSet resourceSet) {
		for (Resource resource : resourceSet.getResources()) {
			resource.unload();
		}
		resourceSet.eAdapters().clear();
	}
	
	protected static boolean noDebug = false;
	
	public static void debugPrintln(@NonNull String string) {
		if (!noDebug) {
			System.out.println(string);
		}		
	}
	
	private GlobalStateMemento makeCopyOfGlobalState = null;

	@Override
	protected void setUp() throws Exception {
//		EssentialOCLLinkingService.DEBUG_RETRY = true;
		if (DEBUG_GC) {
			XMLNamespacePackage.eINSTANCE.getClass();
			makeCopyOfGlobalState = new GlobalStateMemento();
		}
		super.setUp();
		if (DEBUG_ID) {
			debugPrintln("-----Starting " + getClass().getSimpleName() + "." + getName() + "-----");
		}
		EPackage.Registry.INSTANCE.put(UML302UMLResource.STANDARD_PROFILE_NS_URI, L2Package.eINSTANCE);
	}

	@Override
	protected void tearDown() throws Exception {
		if (DEBUG_GC) {
			uninstall();
			makeCopyOfGlobalState.restoreGlobalState();
			makeCopyOfGlobalState = null;
			System.gc();
			System.runFinalization();
//			MetaModelManagerResourceAdapter.INSTANCES.show();
		}
		if (DEBUG_ID) {
			debugPrintln("==> Finish " + getName());
		}
		super.tearDown();
	}

	protected void uninstall() {
		OCLstdlib.uninstall();
		PivotStandaloneSetup.doTearDown();
		BaseStandaloneSetup.doTearDown();
		CompleteOCLStandaloneSetup.doTearDown();
		EssentialOCLStandaloneSetup.doTearDown();
		MarkupStandaloneSetup.doTearDown();
		OCLinEcoreStandaloneSetup.doTearDown();
		OCLstdlibStandaloneSetup.doTearDown();
		PivotEnvironmentFactory.disposeGlobalRegistryInstance();
	}
	
	public static class GlobalStateMemento
	{
		private @NonNull HashMap<EPackage, Object> validatorReg;
		private @NonNull HashMap<String, Object> epackageReg;
		private @NonNull HashMap<String, Object> protocolToFactoryMap;
		private @NonNull HashMap<String, Object> extensionToFactoryMap;
		private @NonNull HashMap<String, Object> contentTypeIdentifierToFactoryMap;
		private @NonNull HashMap<String, Object> protocolToServiceProviderMap;
		private @NonNull HashMap<String, Object> extensionToServiceProviderMap;
		private @NonNull HashMap<String, Object> contentTypeIdentifierToServiceProviderMap;

		public GlobalStateMemento() {
			validatorReg = new HashMap<EPackage, Object>(EValidator.Registry.INSTANCE);
			epackageReg = new HashMap<String, Object>(EPackage.Registry.INSTANCE);
			protocolToFactoryMap = new HashMap<String, Object>(Resource.Factory.Registry.INSTANCE.getProtocolToFactoryMap());
			extensionToFactoryMap = new HashMap<String, Object>(Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap());
			contentTypeIdentifierToFactoryMap = new HashMap<String, Object>(Resource.Factory.Registry.INSTANCE.getContentTypeToFactoryMap());

			protocolToServiceProviderMap = new HashMap<String, Object>(IResourceServiceProvider.Registry.INSTANCE.getProtocolToFactoryMap());
			extensionToServiceProviderMap = new HashMap<String, Object>(IResourceServiceProvider.Registry.INSTANCE.getExtensionToFactoryMap());
			contentTypeIdentifierToServiceProviderMap = new HashMap<String, Object>(IResourceServiceProvider.Registry.INSTANCE.getContentTypeToFactoryMap());
		}
	
		public void restoreGlobalState() {
			clearGlobalRegistries();
			EValidator.Registry.INSTANCE.putAll(validatorReg);
			EPackage.Registry.INSTANCE.putAll(epackageReg);
			
			Resource.Factory.Registry.INSTANCE.getProtocolToFactoryMap().putAll(protocolToFactoryMap);
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().putAll(extensionToFactoryMap);
			Resource.Factory.Registry.INSTANCE.getContentTypeToFactoryMap().putAll(contentTypeIdentifierToFactoryMap);
			
			IResourceServiceProvider.Registry.INSTANCE.getProtocolToFactoryMap().putAll(protocolToServiceProviderMap);
			IResourceServiceProvider.Registry.INSTANCE.getExtensionToFactoryMap().putAll(extensionToServiceProviderMap);
			IResourceServiceProvider.Registry.INSTANCE.getContentTypeToFactoryMap().putAll(contentTypeIdentifierToServiceProviderMap);
		}
		
		public static void clearGlobalRegistries() {
//			Registry eValidatorRegistry = EValidator.Registry.INSTANCE;
//			for (EPackage key : eValidatorRegistry.keySet()) {
//				Object object = eValidatorRegistry.get(key);
//				System.out.println("key : " + key.getNsURI() + " => " + object.getClass().getName());
//			}
			EValidator.Registry.INSTANCE.clear();
			EPackage.Registry.INSTANCE.clear();
			Resource.Factory.Registry.INSTANCE.getProtocolToFactoryMap().clear();
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().clear();
			Resource.Factory.Registry.INSTANCE.getContentTypeToFactoryMap().clear();
			
			IResourceServiceProvider.Registry.INSTANCE.getProtocolToFactoryMap().clear();
			IResourceServiceProvider.Registry.INSTANCE.getExtensionToFactoryMap().clear();
			IResourceServiceProvider.Registry.INSTANCE.getContentTypeToFactoryMap().clear();
			initializeDefaults();
		}
		
		public static void initializeDefaults() {
			//EMF Standalone setup
			if (!Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().containsKey("ecore"))
				Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
					"ecore", new EcoreResourceFactoryImpl());
			if (!Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().containsKey("xmi"))
				Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
					"xmi", new XMIResourceFactoryImpl());
			if (!EPackage.Registry.INSTANCE.containsKey(EcorePackage.eNS_URI))
				EPackage.Registry.INSTANCE.put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
			if (!EPackage.Registry.INSTANCE.containsKey(XtextPackage.eNS_URI))
				EPackage.Registry.INSTANCE.put(XtextPackage.eNS_URI, XtextPackage.eINSTANCE);
		}
	}
}
