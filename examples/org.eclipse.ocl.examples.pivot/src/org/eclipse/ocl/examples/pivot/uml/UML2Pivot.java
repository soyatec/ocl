/**
 * <copyright>
 *
 * Copyright (c) 2010,2011 E.D.Willink and others.
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
 * $Id: UML2Pivot.java,v 1.9 2011/05/20 15:27:20 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.uml;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIException;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.utilities.StandaloneProjectMap;
import org.eclipse.ocl.examples.pivot.AppliedStereotype;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.ParserException;
import org.eclipse.ocl.examples.pivot.PivotConstants;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.StereotypedProperty;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.ecore.AbstractEcore2Pivot;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.model.OCLstdlib;
import org.eclipse.ocl.examples.pivot.utilities.AliasAdapter;
import org.eclipse.ocl.examples.pivot.utilities.PivotObjectImpl;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.eclipse.uml2.uml.resources.util.UMLResourcesUtil;
import org.eclipse.uml2.uml.util.UMLUtil;

public abstract class UML2Pivot extends AbstractEcore2Pivot
{
	private static final Logger logger = Logger.getLogger(UML2Pivot.class);

	private static final class Factory implements MetaModelManager.Factory
	{
		private Factory() {
			MetaModelManager.addFactory(this);
		}

		public boolean canHandle(@NonNull Resource resource) {
			return isUML(resource);
		}

		public void configure(@NonNull ResourceSet resourceSet) {
			OCL.initialize(resourceSet);
		}

		public @Nullable URI getPackageURI(@NonNull EObject eObject) {
			if (eObject instanceof org.eclipse.uml2.uml.Package) {
				String uri = ((org.eclipse.uml2.uml.Package)eObject).getURI();
				if (uri != null) {
					return URI.createURI(uri);
				}
			}
			return null;
		}

		public @Nullable Element importFromResource(@NonNull MetaModelManager metaModelManager, @NonNull Resource umlResource, @Nullable URI uri) throws ParserException {
			UML2Pivot conversion = getAdapter(umlResource, metaModelManager);
			conversion.setUMLURI(uri);
			Root pivotRoot = conversion.getPivotRoot();
			String uriFragment = uri != null ? uri.fragment() : null;
			if (uriFragment == null) {
				return pivotRoot;
			}
			else {
				EObject eObject = umlResource.getEObject(uriFragment);
				if (eObject == null) {
					return null;
				}
				return conversion.getCreated(Element.class, eObject);
			}
		}
	}

	public static MetaModelManager.Factory FACTORY = new Factory();

	public static @Nullable UML2Pivot findAdapter(@NonNull Resource resource, @NonNull MetaModelManager metaModelManager) {
		for (Adapter adapter : resource.eAdapters()) {
			if (adapter instanceof UML2Pivot) {
				UML2Pivot uml2Pivot = (UML2Pivot)adapter;
				if (uml2Pivot.getMetaModelManager() == metaModelManager) {
					return uml2Pivot;
				}
			}
		}
		return null;
	}

	public static @NonNull UML2Pivot getAdapter(@NonNull Resource resource, @Nullable MetaModelManager metaModelManager) {
		UML2Pivot adapter;
		if (metaModelManager == null) {
			metaModelManager = new MetaModelManager();
		}
		else {
			adapter = findAdapter(resource, metaModelManager);
			if (adapter != null) {
				return adapter;
			}
		}
		adapter = new Outer(resource, metaModelManager);
		resource.eAdapters().add(adapter);
		return adapter;
	}

	/**
	 * Convert a UML resource to a Pivot Model.
	 * @param alias 
	 * 
	 * @param umlResource the UML resource
	 * 
	 * @return the Pivot root package
	 * @throws ParserException 
	 */
	public static Root importFromUML(@NonNull MetaModelManager metaModelManager, String alias, Resource umlResource) throws ParserException {
		if (umlResource == null) {
			return null;
		}
		UML2Pivot conversion = getAdapter(umlResource, metaModelManager);
		return conversion.getPivotRoot();
	}

	/**
	 * Convert a UML object to a pivot element. 
	 * 
	 * @param eObject the UML object
	 * 
	 * @return the pivot element
	 * @throws ParserException 
	 */
	public static Element importFromUML(@NonNull MetaModelManager metaModelManager, String alias, EObject eObject) throws ParserException {
		if (eObject == null) {
			return null;
		}
		Resource umlResource = eObject.eResource();
		if (umlResource == null) {
			return null;
		}
		UML2Pivot conversion = getAdapter(umlResource, metaModelManager);
		@SuppressWarnings("unused")
		Root pivotRoot = conversion.getPivotRoot();
		return conversion.getCreated(Element.class, eObject);
	}

	/**
	 * Initialize registries to support OCL and UML usage. This method is
	 * intended for initialization of standalone behaviors for which plugin extension
	 * registrations have not been applied.
	 *<p> 
	 * A null resourceSet may be provided to initialize the global package registry
	 * and global URI mapping registry.
	 *<p> 
	 * A non-null resourceSet may be provided to identify specific package
	 * and global URI mapping registries.
	 * <p>
	 * This method is used to configure the ResourceSet used to load the OCL Standard Library.

	 * @param resourceSet to be initialized or null for global initialization
	 * @return a failure reason, null if successful
	 */
	public static String initialize(ResourceSet resourceSet) {
		UMLResourcesUtil.init(resourceSet);
		final String resourcesPluginId = "org.eclipse.uml2.uml.resources"; //$NON-NLS-1$
		String resourcesLocation = null;
		StandaloneProjectMap projectMap = StandaloneProjectMap.findAdapter(resourceSet);
		if (projectMap != null) {
			URI locationURI = projectMap.getLocation(resourcesPluginId);
			if (locationURI != null) {
				resourcesLocation = locationURI.toString();
				while (resourcesLocation.endsWith("/")) {
					resourcesLocation = resourcesLocation.substring(0, resourcesLocation.length()-1);
				}
			}
		}
		if (resourcesLocation == null)
			return "'" + resourcesPluginId + "' not found on class-path"; //$NON-NLS-1$
		Map<URI, URI> uriMap = resourceSet != null
			? resourceSet.getURIConverter().getURIMap()
			: URIConverter.URI_MAP;		
		uriMap.put(URI.createURI(UMLResource.PROFILES_PATHMAP), URI.createURI(resourcesLocation + "/profiles/")); //$NON-NLS-1$
		uriMap.put(URI.createURI(UMLResource.METAMODELS_PATHMAP), URI.createURI(resourcesLocation + "/metamodels/")); //$NON-NLS-1$
		uriMap.put(URI.createURI(UMLResource.LIBRARIES_PATHMAP), URI.createURI(resourcesLocation + "/libraries/")); //$NON-NLS-1$
		return null;
	}

	public static boolean isUML(@NonNull Resource resource) {
		List<EObject> contents = resource.getContents();
		for (EObject content : contents) {
			if (content instanceof org.eclipse.uml2.uml.Package) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * A UML2Pivot$Inner adapts an unconverted UML resource that has been imported during
	 * the conversion of some other UML resource.
	 */
	public static class Inner extends UML2Pivot
	{		
		protected final @NonNull Outer root;
		
		protected Inner(@NonNull Resource umlResource, @NonNull Outer root) {
			super(umlResource, root.getMetaModelManager());
			this.root = root;
		}
		
		@Override
		public void addCreated(@NonNull EObject umlElement, @NonNull Element pivotElement) {
			root.addCreated(umlElement, pivotElement);
		}

		@Override
		public void addGenericType(@NonNull EGenericType eObject) {
			root.addGenericType(eObject);
		}

		@Override
		public void addImportedPackages(@NonNull List<? extends org.eclipse.uml2.uml.Package> importedPackages) {
			root.addImportedPackages(importedPackages);
		}
		
		@Override
		public void addMapping(@NonNull EObject eObject, @NonNull Element pivotElement) {
			root.addMapping(eObject, pivotElement);
		}

		@Override
		public void addProperties(@NonNull List<org.eclipse.uml2.uml.Property> properties, @Nullable Predicate<org.eclipse.uml2.uml.Property> predicate) {
			root.addProperties(properties, predicate);
		}

		@Override
		public void addStereotypeApplication(@NonNull EObject stereotypeApplication) {
			root.addStereotypeApplication(stereotypeApplication);
		}

		@Override
		public void error(@NonNull String message) {
			root.error(message);
		}	

		@Override
		public <T extends Element> T getCreated(@NonNull Class<T> requiredClass, @NonNull EObject eObject) {
			return root.getCreated(requiredClass, eObject);
		}
		
		@Override
		public @NonNull UML2PivotDeclarationSwitch getDeclarationPass() {
			return root.getDeclarationPass();
		}
		
		@Override
		public @NonNull Root getPivotRoot() throws ParserException {
			Root pivotRoot2 = pivotRoot;
			if (pivotRoot2 == null) {
				pivotRoot2 = root.getPivotRoot();
				Resource pivotResource = pivotRoot.eResource();
				if (pivotResource == null) {
					throw new IllegalStateException("Missing containing resource");
				}
//				installAliases(pivotResource);
				metaModelManager.installResource(pivotResource);
			}
			return pivotRoot2;
		}
		
		@Override
		public @Nullable Type getPivotType(@NonNull EObject eObject) {
			return root.getPivotType(eObject);
		}

		@Override
		public @NonNull Outer getRoot() {
			return root;
		}

		@Override
		public void queueReference(@NonNull EObject umlElement) {
			root.queueReference(umlElement);
		}
	}
	
	/**
	 * A UML2Pivot$Outer adapts an unconverted UML resource and hosts the additional conversions
	 * necessary for imported UML resources.
	 */
	public static class Outer extends UML2Pivot
	{		
		/**
		 * Mapping of source UML objects to their resulting pivot element.
		 */
		private @NonNull Map<EObject, Element> createMap = new HashMap<EObject, Element>();

		/**
		 * Set of all UML objects requiring further work during the reference pass.
		 */
		private @NonNull Set<EObject> referencers = new HashSet<EObject>();
		
		/**
		 * Set of all converters used during session.
		 */
		private @NonNull Set<UML2Pivot> allConverters = new HashSet<UML2Pivot>();
		
		/**
		 * List of all generic types.
		 */
//		private List<EGenericType> genericTypes = new ArrayList<EGenericType>();
		
		/**
		 * List of all specializations for each specializable type.
		 */
//		private Map<TemplateableElement, List<TemplateableElement>> specializations = new HashMap<TemplateableElement, List<TemplateableElement>>();
		
		private List<Resource.Diagnostic> errors = null;

		protected final @NonNull UML2PivotDeclarationSwitch declarationPass = new UML2PivotDeclarationSwitch(this);	

		protected final @NonNull UML2PivotReferenceSwitch referencePass = new UML2PivotReferenceSwitch(this);
		private List<Resource> importedResources = null;

		private @NonNull Set<org.eclipse.uml2.uml.Property> umlProperties = new HashSet<org.eclipse.uml2.uml.Property>();
		private @NonNull List<EObject> eAppliedStereotypes = new ArrayList<EObject>();

		protected Outer(@NonNull Resource umlResource, @NonNull MetaModelManager metaModelManager) {
			super(umlResource, metaModelManager);
		}
		
		@Override
		public void addCreated(@NonNull EObject umlElement, @NonNull Element pivotElement) {
			@SuppressWarnings("unused")
			Element oldElement = createMap.put(umlElement, pivotElement);
//			if ((oldElement != null) && (oldElement != pivotElement)) {
//				System.out.println("Reassigned : " + umlElement);
//			}
//			else if (umlElement instanceof EAnnotation) {
//				System.out.println("Assigned : " + umlElement);
//			}
		}

		@Override
		public void addGenericType(@NonNull EGenericType eObject) {
//			throw new UnsupportedOperationException();				// FIXME		
		}

		@Override
		public void addImportedPackages(@NonNull List<? extends org.eclipse.uml2.uml.Package> importedPackages) {
			for (org.eclipse.uml2.uml.Package importedPackage : importedPackages) {
				EObject rootContainer = EcoreUtil.getRootContainer(importedPackage);
				Resource importedResource = DomainUtil.nonNullEMF(rootContainer.eResource());
				addImportedResource(importedResource);
			}
		}

		protected void addImportedResource(@NonNull Resource importedResource) {
			if (importedResource != umlResource) {
				if (importedResources == null) {
					importedResources = new ArrayList<Resource>();
				}
				if (!importedResources.contains(importedResource)) {
					importedResources.add(importedResource);
				}
			}
		}
		
		@Override
		public void addMapping(@NonNull EObject eObject, @NonNull Element pivotElement) {
			if (pivotElement instanceof PivotObjectImpl) {
				((PivotObjectImpl)pivotElement).setTarget(eObject);
			}
/*			if (eObject instanceof EClassifier) {
				Type pivotType = getEcore2PivotMap().get(eObject);
				if (pivotType != null) {  		// If eObject is a known synonym such as EString
					pivotElement = pivotType;	// remap to the library type
				}
			} */
			addCreated(eObject, pivotElement);
		}

		@Override
		public void addProperties(@NonNull List<org.eclipse.uml2.uml.Property> properties, @Nullable Predicate<org.eclipse.uml2.uml.Property> predicate) {
			for (org.eclipse.uml2.uml.Property umlProperty : properties) {
//				if ("executionSpecification".equals(umlProperty.getName())) {
//					System.out.println("Add " + umlProperty);
//				}
				if ((umlProperty != null) && ((predicate == null) || predicate.filter(umlProperty))) {
					umlProperties.add(umlProperty);
				}
			}
		}

		@Override
		public void addStereotypeApplication(@NonNull EObject eAppliedStereotype) {
			eAppliedStereotypes.add(eAppliedStereotype);
			EClass eClass = eAppliedStereotype.eClass();
			EPackage ePackage = eClass.getEPackage();
//			System.out.println("Stereotype nsURI " + ePackage.getName() + " = " + ePackage.getNsURI());
//			System.out.println("  name " + eClass.getName());
//			for (EStructuralFeature eFeature : eClass.getEStructuralFeatures()) {
//				Object o = eAppliedStereotype.eGet(eFeature);
//				System.out.println("  feature name " + eFeature.getName() + " = " + o);
//			}
			addImportedResource(DomainUtil.nonNullEMF(ePackage.eResource()));
		}

		@Override
		public void error(@NonNull String message) {
			if (errors == null) {
				errors = new ArrayList<Resource.Diagnostic>();
			}
			errors.add(new XMIException(message));
		}

		@Override
		public <T extends Element> T getCreated(@NonNull Class<T> requiredClass, @NonNull EObject eObject) {
			Element element = createMap.get(eObject);
			if (element == null) {
				return null;
			}
			if (!requiredClass.isAssignableFrom(element.getClass())) {
				logger.error("UML " + element.getClass().getName() + "' element is not a '" + requiredClass.getName() + "'"); //$NON-NLS-1$
				return null;
			}
			@SuppressWarnings("unchecked")
			T castElement = (T) element;
			return castElement;
		}
		
		@Override
		public final @NonNull UML2PivotDeclarationSwitch getDeclarationPass() {
			return declarationPass;
		}
		
		public @Nullable List<Resource> getImportedResources() {
			return importedResources;
		}
		
		@Override
		public @NonNull Root getPivotRoot() throws ParserException {
			Root pivotRoot2 = pivotRoot;
			if (pivotRoot2 == null) {
				URI pivotURI = createPivotURI();
				Resource pivotResource = metaModelManager.createResource(pivotURI, PivotPackage.eCONTENT_TYPE);
				try {
					pivotRoot2 = installDeclarations(pivotResource);					
//					Map<String, Type> resolvedSpecializations = new HashMap<String, Type>();
//					for (EGenericType eGenericType : genericTypes) {
//						Type pivotType = resolveType(resolvedSpecializations, eGenericType);
//						createMap.put(eGenericType, pivotType);
//					}
//					for (List<TemplateableElement> pivotElements : specializations.values()) {
//						for (TemplateableElement pivotElement : pivotElements) {
//							metaModelManager.addOrphanType((Type)pivotElement);
//						}
//					}
					installImports();
					if (eAppliedStereotypes.size() > 0) {
						if (metaModelManager.getLibraryResource() == OCLstdlib.getDefault()) {
							throw new IllegalStateException("Stereotypes can only be applied to a copied OCL Standard Library");
						}
						installStereotypes();
					}
					installProperties();
					installReferences();
				}
				catch (Exception e) {
//					if (errors == null) {
//						errors = new ArrayList<Resource.Diagnostic>();
//					}
//					errors.add(new XMIException("Failed to load '" + pivotURI + "' : " + e.getMessage()));
					throw new ParserException("Failed to load '" + pivotURI + "' : " + e.getMessage(), e);
				}
				if (errors != null) {
					pivotResource.getErrors().addAll(errors);
				}
				installAliases(pivotResource);
				metaModelManager.installResource(pivotResource);
			}
			return pivotRoot2;
		}
		
		@Override
		public Type getPivotType(@NonNull EObject eObject) {
			Element pivotElement = createMap.get(eObject);
			if (pivotElement == null) {
				Resource resource = eObject.eResource();
				if ((resource != umlResource) && (resource != null)) {
					UML2Pivot converter = getAdapter(resource, metaModelManager);
					if (allConverters.add(converter)) {
						try {
							converter.getPivotRoot();
						} catch (ParserException e) {
							@SuppressWarnings("null") @NonNull String message = e.getMessage();
							error(message);
						}
//						allEClassifiers.addAll(converter.allEClassifiers);
//						allNames.addAll(converter.allNames);
//						for (Map.Entry<EModelElement, Element> entry : converter.createMap.entrySet()) {
//							createMap.put(entry.getKey(), entry.getValue());
//						}
					}
				}
				pivotElement = createMap.get(eObject);
			}
			if (pivotElement == null) {
				error("Unresolved " + eObject);
			}
			else if (!(pivotElement instanceof Type)) {
				error("Incompatible " + eObject);
			}
			else {
				return (Type) pivotElement;
			}
			return null;
		}
		protected void installAliases(@NonNull Resource pivotResource) {
			AliasAdapter umlAdapter = AliasAdapter.findAdapter(umlResource);
			if (umlAdapter != null) {
				Map<EObject, String> umlAliasMap = umlAdapter.getAliasMap();
				AliasAdapter pivotAdapter = AliasAdapter.getAdapter(pivotResource);
				Map<EObject, String> pivotAliasMap = pivotAdapter.getAliasMap();
				for (EObject eObject : umlAliasMap.keySet()) {
					String alias = umlAliasMap.get(eObject);
					Element element = createMap.get(eObject);
					pivotAliasMap.put(element, alias);
				}
			}
		}

		protected void installImports() throws ParserException {
			if (importedResources != null) {
				for (int i = 0; i < importedResources.size(); i++) {			// List may grow re-entrantly
					Resource importedResource = importedResources.get(i);
					if (importedResource != null) {
						if (!FACTORY.canHandle(importedResource)) {
							metaModelManager.loadResource(importedResource, null);
						}
						else {
							UML2Pivot adapter = UML2Pivot.findAdapter(importedResource, metaModelManager);
							if (adapter == null) {
								Inner importedAdapter = new Inner(importedResource, this);
								importedResource.eAdapters().add(importedAdapter);
								URI pivotURI = importedAdapter.createPivotURI();
								Resource pivotResource = metaModelManager.createResource(pivotURI, PivotPackage.eCONTENT_TYPE);
								importedAdapter.installDeclarations(pivotResource);
								adapter = importedAdapter;
							}
	//					adapter.getPivotRoot();
						}
					}
				}
			}
		}

		protected void installProperties() {
			Map<Type, List<org.eclipse.uml2.uml.Property>> typeProperties = new HashMap<Type, List<org.eclipse.uml2.uml.Property>>();
			List<org.eclipse.uml2.uml.Property> sortedList = new ArrayList<org.eclipse.uml2.uml.Property>(umlProperties);
			Collections.sort(sortedList, new Comparator<org.eclipse.uml2.uml.Property>() {

				public int compare(org.eclipse.uml2.uml.Property o1, org.eclipse.uml2.uml.Property o2) {
					String n1 = o1.getName();
					String n2 = o2.getName();
					return n1 == n2 ? 0 : (n1 != null) && (n2 != null) ? n1.compareTo(n2) : n2 == null ? 1 : -1;
				}
				
			});
			for (org.eclipse.uml2.uml.Property umlProperty : sortedList) {
//				if ("executionSpecification".equals(umlProperty.getName())) {
//					System.out.println("Install " + umlProperty);
//				}
				Type pivotType = null;
				EObject umlOwner = DomainUtil.nonNullEMF(umlProperty.eContainer());
				if (umlOwner instanceof org.eclipse.uml2.uml.Association) {
					org.eclipse.uml2.uml.Property opposite = umlProperty.getOtherEnd();
					if (opposite != null) {
						pivotType = getCreated(Type.class, DomainUtil.nonNullModel(opposite.getType()));
					}
					else {
//						System.out.println("*****************Missing opposite");
					}
				}
				else {
					pivotType = getCreated(Type.class, umlOwner);
				}
				if (pivotType != null) {
					List<org.eclipse.uml2.uml.Property> someProperties = typeProperties.get(pivotType);
					if (someProperties == null) {
						someProperties = new ArrayList<org.eclipse.uml2.uml.Property>();
						typeProperties.put(pivotType, someProperties);
					}
					String name = umlProperty.getName();
					if (name == null) {
//						System.out.println("Unnamed " + pivotType.getName() + "::" + umlProperty.getName());
						name = umlProperty.getType().getName();
					}
					else {
/*						for (org.eclipse.uml2.uml.Property aProperty : someProperties) {
							String aName = aProperty.getName();
							if (name.equals(aName)) {
								System.out.println("Ambiguous " + pivotType.getName() + "::" + umlProperty.getName());
								org.eclipse.uml2.uml.Property opp1 = umlProperty.getOtherEnd();
								if (opp1 != null) {
									System.out.println("  opposite " + umlProperty.getType().getName() + "::" + opp1.getName() + " " + (umlProperty.getClass_() != null));
								}
								org.eclipse.uml2.uml.Property opp2 = aProperty.getOtherEnd();
								if (opp2 != null) {
									System.out.println("  opposite " + umlProperty.getType().getName() + "::" + opp2.getName() + " " + (aProperty.getClass_() != null));
								}
							}
						} */
						someProperties.add(umlProperty);
					}
				}
				else {
					org.eclipse.uml2.uml.Property opposite = umlProperty.getOtherEnd();
					if (opposite != null) {
						org.eclipse.uml2.uml.Type oppositeType = DomainUtil.nonNullEMF(opposite.getType());
						pivotType = getCreated(Type.class, oppositeType);
					}
//					System.out.println("*****************Missing opposite type");
				}
			}			
			for (Type pivotType : typeProperties.keySet()) {
				List<org.eclipse.uml2.uml.Property> umlProperties = typeProperties.get(pivotType);
				List<Property> pivotProperties = new ArrayList<Property>(umlProperties.size());
				for (org.eclipse.uml2.uml.Property umlProperty : umlProperties) {
					if (umlProperty != null) {
						Property pivotProperty = getCreated(Property.class, umlProperty);
						if (pivotProperty != null) {
							pivotProperties.add(pivotProperty);
						}
					}
				}
				refreshList(DomainUtil.nonNullEMF(pivotType.getOwnedAttribute()), pivotProperties);
			}
		}

		protected void installStereotypes() {
			Map<Element,List<EObject>> element2eAppliedStereotypes = new HashMap<Element,List<EObject>>();
			for (EObject eAppliedStereotype : eAppliedStereotypes) {
				try {
					EClass eClass = eAppliedStereotype.eClass();
					for (EStructuralFeature eStructuralFeature : eClass.getEStructuralFeatures()) {
						String featureName = eStructuralFeature.getName();
						if ((featureName != null) && featureName.startsWith("base_") && (eStructuralFeature instanceof EReference) && eAppliedStereotype.eIsSet(eStructuralFeature)) {
							EReference eReference = (EReference) eStructuralFeature;
							Object eStereotyped = eAppliedStereotype.eGet(eReference);
							if (eStereotyped instanceof EObject) {
								Element pivotElement = getCreated(Element.class, (EObject)eStereotyped);
								if (pivotElement != null) {	
									List<EObject> eAppliedStereotypes = element2eAppliedStereotypes.get(pivotElement);
									if (eAppliedStereotypes == null) {
										eAppliedStereotypes = new ArrayList<EObject>();
										element2eAppliedStereotypes.put(pivotElement, eAppliedStereotypes);
									}
									eAppliedStereotypes.add(eAppliedStereotype);
								}
								else {		// FIXME Template Parameters
									logger.error("Unsupported apply stereotype : " + eAppliedStereotype);
								}
							}
						}
					}
				}
				catch (RuntimeException e) {
					logger.error("Failed to apply stereotype : " + eAppliedStereotype, e);
				}
			}	
						
			for (Element stereotypedElement : element2eAppliedStereotypes.keySet()) {
				List<EObject> eAppliedStereotypes = element2eAppliedStereotypes.get(stereotypedElement);
				List<AppliedStereotype> oldAppliedStereotypes = stereotypedElement.getAppliedStereotype();
				List<AppliedStereotype> newAppliedStereotypes = new ArrayList<AppliedStereotype>(eAppliedStereotypes.size());
				for (EObject eAppliedStereotype : eAppliedStereotypes) {
					EClass eClass = eAppliedStereotype.eClass();
					List<EStructuralFeature> eStructuralFeatures = eClass.getEStructuralFeatures();
					Type pivotStereotype = getCreated(Type.class, eClass);
					if (pivotStereotype == null) {
						pivotStereotype = metaModelManager.getPivotOfEcore(Type.class, eClass);
					}
					AppliedStereotype newAppliedStereotype = null;
					for (AppliedStereotype oldAppliedStereotype : oldAppliedStereotypes) {
						if (oldAppliedStereotype.getReferredType() == pivotStereotype) {
							newAppliedStereotype = oldAppliedStereotype;
						}
					}
					if (newAppliedStereotype == null) {
						newAppliedStereotype = PivotFactory.eINSTANCE.createAppliedStereotype();
						newAppliedStereotype.setReferredType(pivotStereotype);
					}
					List<StereotypedProperty> oldProperties = newAppliedStereotype.getStereotypedProperty();
					List<StereotypedProperty> newProperties = new ArrayList<StereotypedProperty>(eAppliedStereotypes.size());
					if (pivotStereotype != null) {
						for (Property referenceProperty : pivotStereotype.getOwnedAttribute()) {
							StereotypedProperty newProperty = null;
							for (StereotypedProperty oldProperty : oldProperties) {
								if (referenceProperty == oldProperty.getReferredProperty()) {
									newProperty = oldProperty;
								}
							}
							if (newProperty == null) {
								newProperty = PivotFactory.eINSTANCE.createStereotypedProperty();
								newProperty.setReferredProperty(referenceProperty);
							}
							String defaultValue = referenceProperty.getDefault();
							String name = referenceProperty.getName();
							if (name != null) {
								for (int i = 0; i < eStructuralFeatures.size(); i++) {
									EStructuralFeature eFeature = eStructuralFeatures.get(i);
									if (name.equals(eFeature.getName())) {
										defaultValue = eFeature.getDefaultValueLiteral();			// FIXME ValueSpecifications
									}
								}
							}
							newProperty.setDefault(defaultValue);
							newProperties.add(newProperty);
						}
					}
					refreshList(DomainUtil.nonNullEMF(newAppliedStereotype.getStereotypedProperty()), newProperties);
					newAppliedStereotypes.add(newAppliedStereotype);
				}
//				System.out.println("Applying stereotypes to " + stereotypedElement);
				refreshList(DomainUtil.nonNullEMF(stereotypedElement.getAppliedStereotype()), newAppliedStereotypes);
			}
		}

		protected void installReferences() {
			for (EObject eObject : referencers) {
				referencePass.doSwitch(eObject);
			}
		}

		@Override
		public void queueReference(@NonNull EObject umlElement) {
			referencers.add(umlElement);
		}

		@Override
		public @NonNull Outer getRoot() {
			return this;
		}
	}
	
	protected final @NonNull Resource umlResource;	
	protected Root pivotRoot = null;	// Set by installDeclarations
	private URI umlURI = null;;
	
	protected UML2Pivot(@NonNull Resource umlResource, @NonNull MetaModelManager metaModelManager) {
		super(metaModelManager);
		this.umlResource = umlResource;
		metaModelManager.addExternalResource(this);
		metaModelManager.addListener(this);
	}
	
	public abstract void addCreated(@NonNull EObject umlElement, @NonNull Element pivotElement);

	public abstract void addImportedPackages(@NonNull List<? extends org.eclipse.uml2.uml.Package> importedPackages);

	public abstract void addProperties(@NonNull List<org.eclipse.uml2.uml.Property> properties, @Nullable Predicate<org.eclipse.uml2.uml.Property> predicate);

	public abstract void addStereotypeApplication(@NonNull EObject stereotypeApplication);

/*	protected void copyMultiplicityElement(@NonNull TypedMultiplicityElement pivotElement, @NonNull org.eclipse.uml2.uml.MultiplicityElement umlMultiplicityElement) {
		int lower = umlMultiplicityElement.getLower();
		int upper = umlMultiplicityElement.getUpper();		// FIXME Obsolete
		pivotElement.setLower(BigInteger.valueOf(lower));
		pivotElement.setUpper(BigInteger.valueOf(upper));
		pivotElement.setIsOrdered(umlMultiplicityElement.isOrdered());			
		pivotElement.setIsUnique(umlMultiplicityElement.isUnique());			
	} */

	protected @NonNull URI createPivotURI() {
		URI uri = umlResource.getURI();
		if (uri == null) {
			throw new IllegalStateException("Missing resource URI");
		}
		return PivotUtil.getPivotURI(uri);
	}

	public void dispose() {
		metaModelManager.removeExternalResource(this);
		getTarget().eAdapters().remove(this);
	}
	
	@Override
	public abstract void error(@NonNull String message);

	public abstract @Nullable <T extends Element> T getCreated(@NonNull Class<T> requiredClass, @NonNull EObject eObject);
	
	public abstract @NonNull UML2PivotDeclarationSwitch getDeclarationPass();
	
	public abstract @NonNull Root getPivotRoot() throws ParserException;
	
	public abstract @Nullable Type getPivotType(@NonNull EObject eObject);

	public @NonNull Resource getResource() {
		return umlResource;
	}
	
	public abstract @NonNull Outer getRoot();

	public @NonNull Notifier getTarget() {
		return umlResource;
	}

	public @NonNull URI getURI() {
		return DomainUtil.nonNullState(umlResource.getURI());
	}

	protected @NonNull Root installDeclarations(@NonNull Resource pivotResource) {
		URI pivotURI = pivotResource.getURI();
		Root pivotRoot2 = pivotRoot = metaModelManager.createRoot(pivotURI.lastSegment(), umlURI != null ? umlURI.toString() : pivotURI.toString());
		pivotResource.getContents().add(pivotRoot2);
		UML2PivotDeclarationSwitch declarationPass = getDeclarationPass();
		List<org.eclipse.ocl.examples.pivot.Package> rootPackages = new ArrayList<org.eclipse.ocl.examples.pivot.Package>();
		for (EObject eObject : umlResource.getContents()) {
			Object pivotElement = declarationPass.doSwitch(eObject);
			if (pivotElement instanceof org.eclipse.ocl.examples.pivot.Package) {
				rootPackages.add((org.eclipse.ocl.examples.pivot.Package) pivotElement);
			}
			else if (pivotElement != null) {			// Ignore stereotypes 
				error("Bad UML content : " + eObject.eClass().getName());
			}
		}
		PivotUtil.refreshList(pivotRoot2.getNestedPackage(), rootPackages);
		return pivotRoot2;
	}

	public boolean isAdapterFor(@NonNull MetaModelManager metaModelManager) {
		return this.metaModelManager == metaModelManager;
	}

	public boolean isAdapterForType(Object type) {
		return type == UML2Pivot.class;
	}

	protected boolean isPivot(@NonNull Collection<EObject> umlContents) {
		if (umlContents.size() != 1) {
			return false;
		}
		EObject umlRoot = umlContents.iterator().next();
		if (!(umlRoot instanceof EPackage)) {
			return false;
		}
		EPackage umlPackage = (EPackage) umlRoot;
		if (umlPackage.getEClassifier(PivotPackage.Literals.ENUMERATION_LITERAL.getName()) == null) {
			return false;
		}
		if (umlPackage.getEClassifier(PivotPackage.Literals.EXPRESSION_IN_OCL.getName()) == null) {
			return false;
		}
		if (umlPackage.getEClassifier(PivotPackage.Literals.OPERATION_CALL_EXP.getName()) == null) {
			return false;
		}
		if (umlPackage.getEClassifier(PivotPackage.Literals.TEMPLATE_PARAMETER_SUBSTITUTION.getName()) == null) {
			return false;
		}
		return true;
	}

	public void metaModelManagerDisposed(@NonNull MetaModelManager metaModelManager) {
		dispose();
	}

	public void notifyChanged(Notification notification) {}

/*	protected void refreshAnnotation(NamedElement pivotElement, String key, String value) {
		String source = PIVOT_URI;
		Annotation pivotAnnotation = null;
		for (Annotation annotation : pivotElement.getOwnedAnnotation()) {
			if (annotation.getName().equals(source)) {
				pivotAnnotation = annotation;
				break;
			}
		}
		if (pivotAnnotation == null) {
			pivotAnnotation = PivotFactory.eINSTANCE.createAnnotation();
			pivotAnnotation.setName(source);
			pivotElement.getOwnedAnnotation().add(pivotAnnotation);
		}
		Detail pivotDetail = PivotFactory.eINSTANCE.createDetail();
		pivotDetail.setName(key);
		pivotDetail.getValue().add(value);
		pivotAnnotation.getOwnedDetail().add(pivotDetail);
	} */

	protected <T extends Element> T refreshElement(@NonNull Class<T> pivotClass, /*@NonNull*/ EClass pivotEClass, @NonNull EObject umlElement) {
		assert pivotEClass != null;
		EFactory eFactoryInstance = pivotEClass.getEPackage().getEFactoryInstance();
		EObject pivotElement = eFactoryInstance.create(pivotEClass);
		if (!pivotClass.isAssignableFrom(pivotElement.getClass())) {
			throw new ClassCastException();
		}
		@SuppressWarnings("unchecked")
		T castElement = (T) pivotElement;
		return castElement;
	}

	protected @NonNull <T extends NamedElement> T refreshNamedElement(@NonNull Class<T> pivotClass,
			/*@NonNull*/ EClass pivotEClass, @NonNull org.eclipse.uml2.uml.NamedElement umlNamedElement) {
		assert pivotEClass != null;
		EFactory eFactoryInstance = pivotEClass.getEPackage().getEFactoryInstance();
		EObject pivotElement = eFactoryInstance.create(pivotEClass);
		if (!pivotClass.isAssignableFrom(pivotElement.getClass())) {
			throw new ClassCastException();
		}
		@SuppressWarnings("unchecked")
		T castElement = (T) pivotElement;
		castElement.setName(umlNamedElement.getName());
		return castElement;
	}
	
	protected @Nullable Type resolveDataType(@NonNull EGenericType eGenericType) {
		assert eGenericType.getETypeArguments().isEmpty();
		EDataType eClassifier = (EDataType) eGenericType.getEClassifier();
		Type pivotType = null;
		if (eClassifier.getEPackage() == EcorePackage.eINSTANCE) {
			if (eClassifier == EcorePackage.Literals.EBOOLEAN) {
				pivotType = metaModelManager.getBooleanType();
			}
			else if (eClassifier == EcorePackage.Literals.EBIG_INTEGER) {
				pivotType = metaModelManager.getIntegerType();
			}
			else if (eClassifier == EcorePackage.Literals.EBIG_DECIMAL) {
				pivotType = metaModelManager.getRealType();
			}
			else if (eClassifier == EcorePackage.Literals.ESTRING) {
				pivotType = metaModelManager.getStringType();
			}
//			if (primitiveTypeName != null) {
//				PrimitiveTypeRefCS csTypeRef = BaseCSTFactory.eINSTANCE.createPrimitiveTypeRefCS();
//				csTypeRef.setName(primitiveTypeName);
//				setOriginalMapping(csTypeRef, eObject);
//				return csTypeRef;
//			}
		}
		if (pivotType == null) {
			pivotType = getPivotType(eClassifier);
		}
		return pivotType;
	}

/*	protected Type resolveGenericType(Map<String, Type> resolvedSpecializations, EGenericType eGenericType) {
		List<EGenericType> eTypeArguments = eGenericType.getETypeArguments();
		assert !eGenericType.getETypeArguments().isEmpty();
		EClassifier eClassifier = eGenericType.getEClassifier();
		List<ETypeParameter> eTypeParameters = eClassifier.getETypeParameters();
		assert eTypeParameters.size() == eTypeArguments.size();
		Type specializedPivotElement;
		Type unspecializedPivotType = getPivotType(eClassifier);
		if (unspecializedPivotType instanceof DataType) {
			specializedPivotElement = refreshNamedElement(DataType.class, PivotPackage.Literals.DATA_TYPE, null);
		}
		else {
			specializedPivotElement = refreshNamedElement(org.eclipse.ocl.examples.pivot.Class.class, PivotPackage.Literals.CLASS, null);
		}
		specializedPivotElement.setName(unspecializedPivotType.getName());
		TemplateBinding templateBinding = PivotFactory.eINSTANCE.createTemplateBinding();
		TemplateSignature templateSignature = unspecializedPivotType.getOwnedTemplateSignature();
		templateBinding.setSignature(templateSignature);
		specializedPivotElement.getTemplateBinding().add(templateBinding);
		for (int i = 0; i < eTypeParameters.size(); i++) {
			TemplateParameterSubstitution templateParameterSubstitution = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
			templateParameterSubstitution.setFormal(templateSignature.getParameter().get(i));
			EGenericType eTypeArgument = eTypeArguments.get(i);
			Type typeArgument = resolveType(resolvedSpecializations, eTypeArgument);
			if (typeArgument.eContainer() == null) {
				templateParameterSubstitution.setOwnedActual(typeArgument);
			}
			else {
				templateParameterSubstitution.setActual(typeArgument);
			}
			templateBinding.getParameterSubstitution().add(templateParameterSubstitution);
		}
		//
		//	Cache the pivot specialization
		//
		List<TemplateableElement> specializationList = specializations.get(unspecializedPivotType);
		if (specializationList == null) {
			specializationList = new ArrayList<TemplateableElement>();
			specializations.put(unspecializedPivotType, specializationList);
		}
		specializationList.add(specializedPivotElement);
		return specializedPivotElement;
	} */

	protected @Nullable Type resolveSimpleType(@NonNull EGenericType eGenericType) {
		assert eGenericType.getETypeArguments().isEmpty();
		EClassifier eClassifier = DomainUtil.nonNullEMF(eGenericType.getEClassifier());
		Type pivotType = getPivotType(eClassifier);
//		if (eClassifier != null) {
/*			TypedTypeRefCS csTypeRef = BaseCSTFactory.eINSTANCE.createTypedTypeRefCS();
			setOriginalMapping(csTypeRef, eObject);
			deferred.add(csTypeRef);		// defer eGenericType.getETypeParameter()
//			doSwitchAll(csTypeRef.getTypeArguments(), eGenericType.getETypeArguments());
			return csTypeRef;
		}
		else {
			ETypeParameter eTypeParameter = eObject.getETypeParameter();
			if (eTypeParameter != null) {
				TypedTypeRefCS csTypeRef = BaseCSTFactory.eINSTANCE.createTypedTypeRefCS();
				setOriginalMapping(csTypeRef, eObject);
				deferred.add(csTypeRef);		// defer eGenericType.getETypeParameter()
				return csTypeRef;				
			}
			else {
				WildcardTypeRefCS csTypeRef = BaseCSTFactory.eINSTANCE.createWildcardTypeRefCS();
				setOriginalMapping(csTypeRef, eObject);
//				csTypeRef.setExtends(doSwitchAll(eGenericType.getExtends()));
//				csTypeRef.setSuper(doSwitchAll(eGenericType.getSuper()));
				return csTypeRef;
			}*/
//		}
		return pivotType;
	}

	protected @Nullable Type resolveType(@NonNull org.eclipse.uml2.uml.Type umlType) {
		Type pivotType = getCreated(Type.class, umlType);
		if (pivotType != null) {
			return pivotType;
		}
/*		EClassifier eClassifier = eGenericType.getEClassifier();
		ETypeParameter eTypeParameter = eGenericType.getETypeParameter();
		List<EGenericType> eTypeArguments = eGenericType.getETypeArguments();
		if (eTypeParameter != null) {
			pivotType = resolveTypeParameter(eGenericType);
		}
		else if (eClassifier == null) {
			pivotType = resolveWildcardType(eGenericType);
		}
		else if (!eTypeArguments.isEmpty()) {
			String ecoreMoniker = UML2Moniker.toString(eGenericType);
			pivotType = resolvedSpecializations.get(ecoreMoniker);
			if (pivotType == null) {
				pivotType = resolveGenericType(resolvedSpecializations, eGenericType);
				resolvedSpecializations.put(ecoreMoniker, pivotType);
			}
		}
		else if (eClassifier instanceof EDataType) {
			pivotType = resolveDataType(eGenericType);
		}
		else { 
			pivotType = resolveSimpleType(eGenericType);
		}
		createMap.put(eGenericType, pivotType); */
		if (umlType instanceof org.eclipse.uml2.uml.PrimitiveType) {
			if (UMLUtil.isBoolean(umlType)) {
				return metaModelManager.getBooleanType();
			}
			else if (UMLUtil.isInteger(umlType)) {
				return metaModelManager.getStringType();
			}
			else if (UMLUtil.isReal(umlType)) {
				return metaModelManager.getStringType();
			}
			else if (UMLUtil.isString(umlType)) {
				return metaModelManager.getStringType();
			}
			else if (UMLUtil.isUnlimitedNatural(umlType)) {
				return metaModelManager.getStringType();
			}
//			org.eclipse.uml2.uml.Package umlPackage = umlType.getPackage();
//			Resource umlResource = umlType.eResource();
//			if ((umlPackage instanceof org.eclipse.uml2.uml.Model) && "EcorePrimitiveTypes".equals(umlPackage.getName())			// No nsURI available
//					&& (umlResource != null) && UMLResource.ECORE_PRIMITIVE_TYPES_LIBRARY_URI.equals(umlResource.getURI())) {
//				
//			}
		}
		return pivotType;
	}

	protected @Nullable Type resolveTypeParameter(@NonNull EGenericType eGenericType) {
		EClassifier eClassifier = eGenericType.getEClassifier();
		ETypeParameter eTypeParameter = eGenericType.getETypeParameter();
		if (eTypeParameter != null) {
			List<EGenericType> eTypeArguments = eGenericType.getETypeArguments();
			assert eClassifier == null;
			assert eTypeArguments.isEmpty();
			Type pivotType = getCreated(Type.class, eTypeParameter);
			return pivotType;
		}
		else {
			return null;
		}
	}

	protected @Nullable Type resolveWildcardType(@NonNull EGenericType eGenericType) {
		assert eGenericType.getETypeArguments().isEmpty();
		assert eGenericType.getEClassifier() == null;
		EClassifier eClassifier = eGenericType.getERawType();
		assert eClassifier == EcorePackage.Literals.EJAVA_OBJECT;
/*			WildcardTypeRefCS csTypeRef = BaseCSTFactory.eINSTANCE.createWildcardTypeRefCS();
			setOriginalMapping(csTypeRef, eObject);
//			csTypeRef.setExtends(doSwitchAll(eGenericType.getExtends()));
//			csTypeRef.setSuper(doSwitchAll(eGenericType.getSuper()));
			return csTypeRef; */
		org.eclipse.ocl.examples.pivot.Class pivotElement = PivotFactory.eINSTANCE.createClass();
		String name = PivotConstants.WILDCARD_NAME;
		EStructuralFeature eFeature = eGenericType.eContainmentFeature();
		if ((eFeature != null) && eFeature.isMany()) {
			EObject eContainer = eGenericType.eContainer();
			List<?> list = (List<?>)eContainer.eGet(eGenericType.eContainingFeature());
			int index = list.indexOf(eGenericType);
			if (index != 0) {
				name += index;
			}
		}
		pivotElement.setName(name);		
		return pivotElement;
	}

	protected void setOriginalMapping(@NonNull Element pivotElement, @NonNull EModelElement umlElement) {
		((PivotObjectImpl)pivotElement).setTarget(umlElement);
/*			csModelElement.setOriginalObject(eModelElement);
			if (umlResource instanceof XMLResource) {
				String xmiId = ((XMLResource)umlResource).getID(eModelElement);
				if (xmiId != null) {
					csModelElement.setOriginalXmiId(xmiId);
				}
			} */
		addCreated(umlElement, pivotElement);
	}

	public void setTarget(Notifier newTarget) {
		assert (newTarget == null) || (newTarget == umlResource);
	}

	public void setUMLURI(URI umlURI) {
		this.umlURI  = umlURI;
	}

	public void unsetTarget(Notifier oldTarget) {
		assert (oldTarget == umlResource);
	}
}
