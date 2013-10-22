/**
 * <copyright>
 * 
 * Copyright (c) 2008, 2013 E.D.Willink and others.
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
package org.eclipse.ocl.examples.xtext.tests;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.utilities.ProjectMap;
import org.eclipse.ocl.examples.domain.values.Bag;
import org.eclipse.ocl.examples.domain.values.impl.BagImpl;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.LambdaType;
import org.eclipse.ocl.examples.pivot.LoopExp;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.PivotConstants;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.TupleType;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.VariableExp;
import org.eclipse.ocl.examples.pivot.context.ModelContext;
import org.eclipse.ocl.examples.pivot.delegate.OCLDelegateDomain;
import org.eclipse.ocl.examples.pivot.ecore.Pivot2Ecore;
import org.eclipse.ocl.examples.pivot.library.StandardLibraryContribution;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManagerResourceSetAdapter;
import org.eclipse.ocl.examples.pivot.model.OCLstdlib;
import org.eclipse.ocl.examples.pivot.resource.ASResource;
import org.eclipse.ocl.examples.pivot.tests.PivotTestCase;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.basecs.ModelElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TuplePartCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TupleTypeCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TypeRefCS;
import org.eclipse.ocl.examples.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.examples.xtext.base.utilities.CS2PivotResourceAdapter;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionTypeCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.InfixExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.InvocationExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigatingArgCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigationOperatorCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NestedExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.PrefixExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TypeNameExpCS;
import org.eclipse.xtext.util.EmfFormatter;

public class XtextTestCase extends PivotTestCase
{	
	
	public static interface Normalizer {
		void denormalize();
	}
	
/*	public static class EAnnotationsNormalizer implements Normalizer
	{
		protected final @NonNull EAnnotation eAnnotation;
		protected final List<Entry<String, String>> oldOrder;
		
		public EAnnotationsNormalizer(@NonNull EAnnotation eAnnotation) {
			this.eAnnotation = eAnnotation;
			List<Entry<String, String>> eDetails = eAnnotation.getDetails();
			this.oldOrder = new ArrayList<Entry<String, String>>(eDetails);
			List<Entry<String, String>> newOrder = new ArrayList<Entry<String, String>>(eDetails);
			Collections.sort(newOrder, new Comparator<Entry<String, String>>()
				{
					public int compare(Entry<String, String> o1, Entry<String, String> o2) {
						String n1 = o1.getKey();
						String n2 = o2.getKey();
						return n1.compareTo(n2);
					}
				}
			);
			eDetails.clear();
			eDetails.addAll(newOrder);
		}
		
		@Override
		public void denormalize() {
			EList<Entry<String, String>> eDetails = eAnnotation.getDetails();
			eDetails.clear();
			eDetails.addAll(oldOrder);
		}
	} */
	
	public static class EOperationsNormalizer implements Normalizer
	{
		protected final @NonNull EClass eClass;
		protected final List<EOperation> oldOrder;
		
		public EOperationsNormalizer(@NonNull EClass eClass) {
			this.eClass = eClass;
			EList<EOperation> eOperations = eClass.getEOperations();
			this.oldOrder = new ArrayList<EOperation>(eOperations);
			List<EOperation> newOrder = new ArrayList<EOperation>(eOperations);
			Collections.sort(newOrder, new Comparator<EOperation>()
				{
					public int compare(EOperation o1, EOperation o2) {
						String n1 = o1.getName();
						String n2 = o2.getName();
						return n1.compareTo(n2);
					}
				}
			);
			eOperations.clear();
			eOperations.addAll(newOrder);
		}
		
		@Override
		public void denormalize() {
			EList<EOperation> eOperations = eClass.getEOperations();
			eOperations.clear();
			eOperations.addAll(oldOrder);
		}
	}
	
	public static class ETypedElementNormalizer implements Normalizer
	{
		protected final @NonNull ETypedElement eTypedElement;
		protected final boolean wasOrdered;
		protected final boolean wasUnique;
		
		public ETypedElementNormalizer(@NonNull ETypedElement eTypedElement) {
			this.eTypedElement = eTypedElement;
			this.wasOrdered = eTypedElement.isOrdered();
			this.wasUnique = eTypedElement.isUnique();
			eTypedElement.setOrdered(true);
			eTypedElement.setUnique(true);
		}
		
		@Override
		public void denormalize() {
			eTypedElement.setOrdered(wasOrdered);
			eTypedElement.setUnique(wasUnique);
		}
	}

	@SuppressWarnings("null")
	protected void assertPivotIsValid(URI pivotURI) {
		ResourceSet reloadResourceSet = new ResourceSetImpl();
//		reloadResourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("pivot", new EcoreResourceFactoryImpl());
		Resource reloadedPivotResource = reloadResourceSet.getResource(pivotURI, true);
		MetaModelManager metaModelManager = PivotUtil.getMetaModelManager(reloadedPivotResource);
		assertNoValidationErrors("Pivot reload validation problems", reloadedPivotResource);
		unloadResourceSet(reloadResourceSet);
		metaModelManager.dispose();
	}
	
	public static void assertSameModel(@NonNull Resource expectedResource, @NonNull Resource actualResource) throws IOException, InterruptedException {
		Set<Normalizer> expectedNormalizations = normalize(expectedResource);
		Set<Normalizer> actualNormalizations = normalize(actualResource);
		String expected = EmfFormatter.listToStr(expectedResource.getContents());
		String actual = EmfFormatter.listToStr(actualResource.getContents());
		assertEquals(expected, actual);
		for (Normalizer normalizer : expectedNormalizations) {
			normalizer.denormalize();
		}
		for (Normalizer normalizer : actualNormalizations) {
			normalizer.denormalize();
		}
	}

	protected void doBadLoadFromString(@NonNull String fileName, @NonNull String testFile, @NonNull Bag<String> expectedErrorMessages) throws Exception {
		MetaModelManager metaModelManager = new MetaModelManager();
		metaModelManager.addClassLoader(DomainUtil.nonNullState(getClass().getClassLoader()));
		try {
			MetaModelManagerResourceSetAdapter.getAdapter(DomainUtil.nonNullState(resourceSet), metaModelManager);
			URI libraryURI = getProjectFileURI(fileName);
			BaseCSResource xtextResource = (BaseCSResource) resourceSet.createResource(libraryURI);
			InputStream inputStream = new URIConverter.ReadableInputStream(testFile, "UTF-8");
			xtextResource.load(inputStream, null);
			Bag<String> actualErrorMessages = new BagImpl<String>();
			for (Resource.Diagnostic actualError : xtextResource.getErrors()) {
				actualErrorMessages.add(actualError.getMessage());
			}
			String s = formatMessageDifferences(expectedErrorMessages, actualErrorMessages);
			if (s != null) {
				fail("Inconsistent load errors (expected/actual) message" + s);
			}
		} finally {
			metaModelManager.dispose();
		}
	}

	protected void doLoadFromString(@NonNull String fileName, @NonNull String testFile) throws Exception {
		URI libraryURI = getProjectFileURI(fileName);
		MetaModelManager metaModelManager = new MetaModelManager();
		ResourceSet resourceSet = new ResourceSetImpl();
		MetaModelManagerResourceSetAdapter.getAdapter(resourceSet, metaModelManager);
		BaseCSResource xtextResource = (BaseCSResource) resourceSet.createResource(libraryURI);
		InputStream inputStream = new URIConverter.ReadableInputStream(testFile, "UTF-8");
		xtextResource.load(inputStream, null);
		assertNoResourceErrors("Load failed", xtextResource);
		CS2PivotResourceAdapter adapter = xtextResource.getCS2ASAdapter(metaModelManager);
		Resource asResource = adapter.getASResource(xtextResource);
		assert asResource != null;
		assertNoResourceErrors("File Model", asResource);
		assertNoUnresolvedProxies("File Model", asResource);
		assertNoValidationErrors("File Model", asResource);
//		MetaModelManagerResourceSetAdapter adapter2 = MetaModelManagerResourceSetAdapter.findAdapter(resourceSet);
//		if (adapter2 != null) {
//			MetaModelManager metaModelManager2 = adapter2.getMetaModelManager();
//			if (metaModelManager2 != null) {
//				metaModelManager2.dispose();
//				metaModelManager2 = null;
//			}
//			adapter2 = null;
//		}
		adapter.dispose();
		metaModelManager.dispose();
		metaModelManager = null;
		resourceSet = null;
		adapter = null;
		StandardLibraryContribution.REGISTRY.remove(MetaModelManager.DEFAULT_OCL_STDLIB_URI);
	}

	protected ASResource doLoadASResourceFromString(@NonNull MetaModelManager metaModelManager, @NonNull String fileName, @NonNull String testFile) throws Exception {
		URI libraryURI = getProjectFileURI(fileName);
		ModelContext modelContext = new ModelContext(metaModelManager, libraryURI);
		BaseCSResource xtextResource = (BaseCSResource) modelContext.createBaseResource(testFile);
		assertNoResourceErrors("Load failed", xtextResource);
		CS2PivotResourceAdapter adapter = xtextResource.getCS2ASAdapter(null);
		ASResource asResource = adapter.getASResource(xtextResource);
		assert asResource != null;
		assertNoResourceErrors("File Model", asResource);
		assertNoUnresolvedProxies("File Model", asResource);
		assertNoValidationErrors("File Model", asResource);
		return asResource;
	}

	/**
	 * Return the difference between expectedMessages and actualMessages, or null if no differences.
	 * 
	 * The return is formatted one message per line with a leading new-line followed by
	 * an expected/actual count in parentheses followed by the messages 
	 */
	public static String formatMessageDifferences(Bag<String> expectedMessages, Bag<String> actualMessages) {
		Set<String> allMessages = new HashSet<String>(expectedMessages);
		allMessages.addAll(actualMessages);
		StringBuilder s = null;
		for (String message : allMessages) {
			int actualCount = actualMessages.count(message);
			int expectedCount = expectedMessages.count(message);
			if (actualCount != expectedCount) {
				if (s == null) {
					s = new StringBuilder();
				}
				s.append("\n  (" + expectedCount + "/" + actualCount + ") " + message);
			}
		}
		return s != null ? s.toString() : null;
	}

	protected static boolean hasCorrespondingCS(Element pivotElement) {
		if (!isValidPivot(pivotElement)) {
			return false;
		}
		if (pivotElement instanceof ExpressionInOCL) {
			return false;
		}
		if ((pivotElement instanceof Variable) && (pivotElement.eContainer() instanceof ExpressionInOCL)) {
			return false;
		}
		if ((pivotElement instanceof Variable) && (pivotElement.eContainer() instanceof LoopExp)
				&& Character.isDigit((((Variable)pivotElement).getName().charAt(0)))) {
			return false;
		}
//		if (pivotElement instanceof TemplateBinding) {
//			return false;
//		}
//		if ((pivotElement instanceof TemplateableElement) && (((TemplateableElement)pivotElement).getTemplateBinding().size() > 0)) {
//			return false;
//		}
		return true;
	}

//	protected static boolean hasOptionalCS(MonikeredElement pivotElement) {
//		if ((pivotElement instanceof LetExp) && (pivotElement.eContainer() instanceof LetExp)) {
//			return false;
//		}
//		return true;
//	}

	protected static boolean hasCorrespondingPivot(ModelElementCS csElement) {
		if (csElement instanceof TupleTypeCS) {
			return true;
		}
		if (csElement instanceof TuplePartCS) {		// FIXME orphanage ambiguity
			return false;
		}
//		if (csElement instanceof TypeRefCS) {
//			return false;
//		}
		if (csElement instanceof InfixExpCS) {
			return false;
		}
		if (csElement instanceof NestedExpCS) {
			return false;
		}
		if (csElement instanceof PrefixExpCS) {
			return false;
		}
		if (csElement instanceof NavigatingArgCS) {
			return false;
		}
		if (csElement instanceof InvocationExpCS) {
			return false;
		}
		if (csElement instanceof NavigationOperatorCS) {
			return false;
		}
		if (csElement instanceof CollectionTypeCS) {
			return false;
		}
		if (csElement instanceof TypeNameExpCS) {
			return false;
		}
		return true;
	}

	protected static boolean hasUniqueMoniker(ModelElementCS csElement) {
		if (csElement instanceof TupleTypeCS) {
			return false;
		}
		if (csElement instanceof TypeRefCS) {
			return false;
		}
		if (csElement instanceof InfixExpCS) {
			return false;
		}
		if (csElement instanceof NestedExpCS) {
			return false;
		}
		if (csElement instanceof PrefixExpCS) {
			return false;
		}
		if (csElement instanceof InvocationExpCS) {
			return false;
		}
		if (csElement instanceof NavigationOperatorCS) {
			return false;
		}
		if (csElement instanceof CollectionTypeCS) {
			return false;
		}
		return true;
	}
	
	protected static boolean isValidPivot(Element pivotElement) {
		if (pivotElement instanceof org.eclipse.ocl.examples.pivot.Package) {
			if ((pivotElement.eContainer() == null) && PivotConstants.ORPHANAGE_NAME.equals(((NamedElement) pivotElement).getName())) {
				return false;
			}
		}
		if ((pivotElement instanceof TemplateableElement) && (((TemplateableElement)pivotElement).getTemplateBinding().size() > 0)) {
			return false;
		}
		if (pivotElement instanceof LambdaType) {
			return false;
		}
		if (pivotElement instanceof TupleType) {
			return PivotUtil.isLibraryType((TupleType)pivotElement);
		}
		if (pivotElement instanceof Type) {
			EObject eContainer = pivotElement.eContainer();
			if ((eContainer instanceof org.eclipse.ocl.examples.pivot.Package) && (eContainer.eContainer() == null)
					&& PivotConstants.ORPHANAGE_NAME.equals(((NamedElement) pivotElement).getName())
					&& PivotConstants.ORPHANAGE_NAME.equals(((NamedElement) eContainer).getName())) {
				return false;
			}
		}
		if ((pivotElement instanceof Property) && (pivotElement.eContainer() instanceof TupleType)) {
			return false;
		}
		if ((pivotElement instanceof VariableExp) && (pivotElement.eContainer() instanceof OperationCallExp)) {
			return false;
		}
		return true;
	}
	
	public static Set<Normalizer> normalize(Resource resource) {
		Set<Normalizer> normalizers = new HashSet<Normalizer>();
		for (TreeIterator<EObject> tit = resource.getAllContents(); tit.hasNext(); ) {
			EObject eObject = tit.next();
			if (eObject instanceof ETypedElement) {
				ETypedElement eTypedElement = (ETypedElement) eObject;
				if (eTypedElement.getUpperBound() == 1) {
					if (!eTypedElement.isOrdered() || !eTypedElement.isUnique()) {
						normalizers.add(new ETypedElementNormalizer(eTypedElement));
					}
				}
			}
			if (eObject instanceof EClass) {
				EClass eClass = (EClass) eObject;
				if (eClass.getEOperations().size() >= 2) {
					normalizers.add(new EOperationsNormalizer(eClass));		// FIXME Until Pivot2Ecore has consistent ops/inv ordering
				}
			}
/*			if (eObject instanceof EAnnotation) {
				EAnnotation eAnnotation = (EAnnotation) eObject;
				if (eAnnotation.getDetails().size() >= 2) {
					normalizers.add(new EAnnotationsNormalizer(eAnnotation));
				}
				tit.prune();				// Avoid CME
			} */
		}
		return normalizers;
	}
	
	protected ResourceSet resourceSet;
	
	@SuppressWarnings("null")
	public @NonNull String createEcoreString(@NonNull MetaModelManager metaModelManager, @NonNull String fileName, @NonNull String fileContent, boolean assignIds) throws IOException {
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
			Writer writer = new StringWriter();
			ecoreResource.save(writer, null);
			return DomainUtil.nonNullState(writer.toString());
		}
		finally {
			if (adapter != null) {
				adapter.dispose();
			}
		}
	}

	@SuppressWarnings("null")
	protected Resource loadEcore(@NonNull URI inputURI) {
		Resource ecoreResource = resourceSet.getResource(inputURI, true);
		mapOwnURI(ecoreResource);
//		List<String> conversionErrors = new ArrayList<String>();
//		RootPackageCS documentCS = Ecore2OCLinEcore.importFromEcore(resourceSet, null, ecoreResource);
//		Resource eResource = documentCS.eResource();
		assertNoResourceErrors("Load failed", ecoreResource);
//		Resource xtextResource = resourceSet.createResource(outputURI, OCLinEcoreCSPackage.eCONTENT_TYPE);
//		XtextResource xtextResource = (XtextResource) resourceSet.createResource(outputURI);
//		xtextResource.getContents().add(documentCS);
		return ecoreResource;
	}

	/**
	 * Some example files have inconsistent self references so map the URI back to
	 * the resource.
	 */
	protected void mapOwnURI(Resource resource) {
		List<EObject> contents = resource.getContents();
		if (contents.size() == 1) {
			EObject root = contents.get(0);
			if (root instanceof EPackage) {
				EPackage rootPackage = (EPackage) root;
				String nsURI = rootPackage.getNsURI();
				if (nsURI != null) {
					Map<URI, Resource> uriResourceMap = ((ResourceSetImpl)resourceSet).getURIResourceMap();
					if (uriResourceMap == null) {
						uriResourceMap = new HashMap<URI, Resource>();
						((ResourceSetImpl)resourceSet).setURIResourceMap(uriResourceMap);
					}
					uriResourceMap.put(URI.createURI(nsURI), resource);
				}
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	@Override
	protected void setUp() throws Exception {
		super.setUp();
    	TestCaseAppender.INSTANCE.install();
    	if (!EMFPlugin.IS_ECLIPSE_RUNNING) {
    		OCL.initialize(null);
    	}
		doCompleteOCLSetup();
		doOCLinEcoreSetup();
		doOCLstdlibSetup();
		resourceSet = new ResourceSetImpl();
		ProjectMap.initializeURIResourceMap(resourceSet);
		Map<URI, URI> uriMap = resourceSet.getURIConverter().getURIMap();
    	if (EMFPlugin.IS_ECLIPSE_RUNNING) {
    		uriMap.putAll(EcorePlugin.computePlatformURIMap());
    	}
//		for (Map.Entry<URI,URI> entry : uriMap.entrySet()) {
//			System.out.println(entry.getKey() + " => " + entry.getValue());
//		}
//		URI platformOCLstdlibURI = URI.createURI(StandardDocumentAttribution.OCLSTDLIB_URI);
//		URI projectURI = getProjectFileURI("dummy");
//		URI projectOCLstdlibURI = URI.createURI("oclstdlib.oclstdlib").resolve(projectURI);
//		uriMap.put(platformOCLstdlibURI, projectOCLstdlibURI);
		StandardLibraryContribution.REGISTRY.put(MetaModelManager.DEFAULT_OCL_STDLIB_URI, new OCLstdlib.Loader());
        OCLDelegateDomain.initialize(null);
	}

	@Override
	protected void tearDown() throws Exception {
		if (resourceSet != null) {
			for (Resource resource : resourceSet.getResources()) {
				resource.unload();
			}
			resourceSet.getResources().clear();
			resourceSet = null;
		}
		super.tearDown();
	}
}
