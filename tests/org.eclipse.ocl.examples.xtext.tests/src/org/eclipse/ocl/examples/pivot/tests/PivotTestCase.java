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
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id$
 */

package org.eclipse.ocl.examples.pivot.tests;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.BasicEObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil.UnresolvedProxyCrossReferencer;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xml.namespace.XMLNamespacePackage;
import org.eclipse.ocl.examples.domain.evaluation.DomainException;
import org.eclipse.ocl.examples.domain.utilities.ProjectMap;
import org.eclipse.ocl.examples.domain.validation.DomainSubstitutionLabelProvider;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.PivotStandaloneSetup;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManagerResourceAdapter;
import org.eclipse.ocl.examples.pivot.model.OCLstdlib;
import org.eclipse.ocl.examples.pivot.utilities.BaseResource;
import org.eclipse.ocl.examples.pivot.utilities.PivotEnvironmentFactory;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.BaseStandaloneSetup;
import org.eclipse.ocl.examples.xtext.completeocl.CompleteOCLStandaloneSetup;
import org.eclipse.ocl.examples.xtext.essentialocl.EssentialOCLStandaloneSetup;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLLinkingService;
import org.eclipse.ocl.examples.xtext.essentialocl.utilities.EssentialOCLCSResource;
import org.eclipse.ocl.examples.xtext.markup.MarkupStandaloneSetup;
import org.eclipse.ocl.examples.xtext.oclinecore.OCLinEcoreStandaloneSetup;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreCSTPackage;
import org.eclipse.ocl.examples.xtext.oclstdlib.OCLstdlibStandaloneSetup;
import org.eclipse.ocl.examples.xtext.oclstdlib.ui.OCLstdlibUiModule;
import org.eclipse.uml2.uml.profile.l2.L2Package;
import org.eclipse.uml2.uml.resource.UML302UMLResource;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;

/**
 * Tests for OclAny operations.
 */
@SuppressWarnings("nls")
public class PivotTestCase extends TestCase
{
	public static boolean DEBUG_GC = false;
	public static boolean DEBUG_ID = false;
	public static final String PLUGIN_ID = "org.eclipse.ocl.examples.xtext.tests";
	private static ProjectMap projectMap = null;

	public static void assertNoDiagnosticErrors(String message, XtextResource xtextResource) {
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

	public static void assertNoResourceErrors(String prefix, Resource resource) {
		String message = PivotUtil.formatResourceDiagnostics(resource.getErrors(), prefix, "\n\t");
		if (message != null)
			fail(message);
	}

	public static void assertNoUnresolvedProxies(String message, Resource resource) {
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

	public static void assertNoValidationErrors(String string, Resource resource) {
		for (EObject eObject : resource.getContents()) {
			assertNoValidationErrors(string, eObject);
		}
	}

	public static void assertNoValidationErrors(String string, EObject eObject) {
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

	public static void assertResourceErrors(String prefix, Resource resource, String... messages) {
		Map<String, Integer> expected = new HashMap<String, Integer>();
		for (String message : messages) {
			Integer count = expected.get(message);
			count = count == null ? 1 : count + 1;
			expected.put(message, count);
		}
		StringBuilder s1 = null;
		for (Resource.Diagnostic error : resource.getErrors()) {
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
	
	public static Resource cs2ecore(OCL ocl, String testDocument, URI ecoreURI) throws IOException {
		MetaModelManager metaModelManager = ocl.getMetaModelManager();
		InputStream inputStream = new URIConverter.ReadableInputStream(testDocument, "UTF-8");
		URI xtextURI = URI.createURI("test.oclinecore");
		ResourceSet resourceSet = new ResourceSetImpl();
		EssentialOCLCSResource xtextResource = (EssentialOCLCSResource) resourceSet.createResource(xtextURI, null);
		MetaModelManagerResourceAdapter.getAdapter(xtextResource, metaModelManager);
		xtextResource.load(inputStream, null);
		assertNoResourceErrors("Loading Xtext", xtextResource);
		Resource pivotResource = cs2pivot(ocl, xtextResource, null);
		Resource ecoreResource = pivot2ecore(ocl, pivotResource, ecoreURI, true);
		return ecoreResource;
	}

	public static Resource cs2pivot(OCL ocl, BaseResource xtextResource, URI pivotURI) throws IOException {
		Resource pivotResource = ocl.cs2pivot(xtextResource);
		assertNoUnresolvedProxies("Unresolved proxies", pivotResource);
		if (pivotURI != null) {
			pivotResource.setURI(pivotURI);
			pivotResource.save(null);
		}
		return pivotResource;
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

	protected static Value failOn(String expression, Throwable e) {
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
	
	public URI getTestModelURI(String localFileName) {
		if (projectMap == null) {
			projectMap = new ProjectMap();
		}
		String urlString = projectMap.getLocation(PLUGIN_ID).toString();
		TestCase.assertNotNull(urlString);
		return URI.createURI(urlString + "/" + localFileName);
	}

	public static XtextResource pivot2cs(OCL ocl, ResourceSet resourceSet, Resource pivotResource, URI outputURI) throws IOException {
		XtextResource xtextResource = (XtextResource) resourceSet.createResource(outputURI, OCLinEcoreCSTPackage.eCONTENT_TYPE);
//		ResourceSet csResourceSet = resourceSet; //new ResourceSetImpl();
//		csResourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("cs", new EcoreResourceFactoryImpl());
//		csResourceSet.getPackageRegistry().put(PivotPackage.eNS_URI, PivotPackage.eINSTANCE);
//		Resource csResource = csResourceSet.createResource(uri);
//		URI oclinecoreURI = ecoreResource.getURI().appendFileExtension("oclinecore");
		ocl.pivot2cs(pivotResource, (BaseResource) xtextResource);
		assertNoResourceErrors("Conversion failed", xtextResource);
//		csResource.save(null);
		//
		//	CS save and reload
		//		
		URI savedURI = pivotResource.getURI();
		pivotResource.setURI(PivotUtil.getNonPivotURI(savedURI).appendFileExtension("pivot"));
		pivotResource.save(null);
		pivotResource.setURI(savedURI);
		
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

	public static Resource pivot2ecore(OCL ocl, Resource pivotResource, URI ecoreURI, boolean validateSaved) throws IOException {
		Resource ecoreResource = ocl.pivot2ecore(pivotResource, ecoreURI != null ? ecoreURI : URI.createURI("test.ecore"));
		if (ecoreURI != null) {
			ecoreResource.save(null);
		}
		if (validateSaved) {
			assertNoValidationErrors("Ecore2Pivot invalid", ecoreResource);
		}
		return ecoreResource;
	}

	public static void unloadResourceSet(ResourceSet resourceSet) {
		for (Resource resource : resourceSet.getResources()) {
			resource.unload();
		}
		resourceSet.eAdapters().clear();
	}
	
	protected static boolean noDebug = false;
	
	public static void debugPrintln(String string) {
		if (!noDebug) {
			System.out.println(string);
		}		
	}
	
	private GlobalStateMemento makeCopyOfGlobalState = null;

	@Override
	protected void setUp() throws Exception {
		EssentialOCLLinkingService.DEBUG_RETRY = true;
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
		private HashMap<EPackage, Object> validatorReg;
		private HashMap<String, Object> epackageReg;
		private HashMap<String, Object> protocolToFactoryMap;
		private HashMap<String, Object> extensionToFactoryMap;
		private HashMap<String, Object> contentTypeIdentifierToFactoryMap;
		private HashMap<String, Object> protocolToServiceProviderMap;
		private HashMap<String, Object> extensionToServiceProviderMap;
		private HashMap<String, Object> contentTypeIdentifierToServiceProviderMap;

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
