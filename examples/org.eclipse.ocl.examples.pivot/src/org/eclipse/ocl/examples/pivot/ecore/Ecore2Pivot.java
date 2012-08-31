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
 * $Id: Ecore2Pivot.java,v 1.13 2011/05/20 15:27:20 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.ecore;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.TreeIterator;
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
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.XMIException;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.PivotConstants;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.model.OCLstdlib;
import org.eclipse.ocl.examples.pivot.utilities.AliasAdapter;
import org.eclipse.ocl.examples.pivot.utilities.PivotObjectImpl;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

public class Ecore2Pivot extends AbstractEcore2Pivot
{
	private static final class Factory implements MetaModelManager.Factory
	{
		private Factory() {
			MetaModelManager.addFactory(this);
		}

		public boolean canHandle(@NonNull EObject eObject) {
			return (eObject instanceof EClassifier) || (eObject instanceof DynamicEObjectImpl);
		}

		public boolean canHandle(@NonNull Resource resource) {
			return isEcore(resource);
		}

		public void configure(@NonNull ResourceSet resourceSet) {}

		public @Nullable URI getPackageURI(@NonNull EObject eObject) {
			if (eObject instanceof EPackage) {
				String uri = ((EPackage)eObject).getNsURI();
				if (uri != null) {
					return URI.createURI(uri);
				}
			}
			return null;
		}

		public <T extends Element> T getPivotOf(@NonNull MetaModelManager metaModelManager, @NonNull Class<T> pivotClass, @NonNull EObject eObject) {
			return metaModelManager.getPivotOfEcore(pivotClass, eObject);
		}

		public @Nullable Element importFromResource(@NonNull MetaModelManager metaModelManager, @NonNull Resource ecoreResource, @Nullable URI uri) {
			Ecore2Pivot conversion = getAdapter(ecoreResource, metaModelManager);
			conversion.setEcoreURI(uri);
			Root pivotRoot = conversion.getPivotRoot();
			String uriFragment = uri != null ? uri.fragment() : null;
			if (uriFragment == null) {
				return pivotRoot;
			}
			else {
				EObject eObject = ecoreResource.getEObject(uriFragment);
				if (eObject == null) {
					return null;
				}
				return conversion.newCreateMap.get(eObject);
			}
		}
	}

	public static MetaModelManager.Factory FACTORY = new Factory();

	public static @Nullable Ecore2Pivot findAdapter(@NonNull Resource resource, @NonNull MetaModelManager metaModelManager) {
		for (Adapter adapter : resource.eAdapters()) {
			if (adapter instanceof Ecore2Pivot) {
				Ecore2Pivot ecore2Pivot = (Ecore2Pivot)adapter;
				if (ecore2Pivot.getMetaModelManager() == metaModelManager) {
					return ecore2Pivot;
				}
			}
		}
		return null;
	}

	public static Ecore2Pivot getAdapter(@NonNull Resource resource, @Nullable MetaModelManager metaModelManager) {
		Ecore2Pivot adapter;
		if (metaModelManager == null) {
			metaModelManager = new MetaModelManager();
		}
		else {
			adapter = findAdapter(resource, metaModelManager);
			if (adapter != null) {
				return adapter;
			}
		}
		adapter = new Ecore2Pivot(resource, metaModelManager);
		List<Adapter> eAdapters = resource.eAdapters();
		eAdapters.add(adapter);
		return adapter;
	}

	/**
	 * Convert an (annotated) Ecore resource to a Pivot Model.
	 * @param alias 
	 * 
	 * @param ecoreResource the annotated Ecore resource
	 * 
	 * @return the Pivot root package
	 */
	public static @NonNull Root importFromEcore(@NonNull MetaModelManager metaModelManager, String alias, @NonNull Resource ecoreResource) {
		Ecore2Pivot conversion = getAdapter(ecoreResource, metaModelManager);
		return conversion.getPivotRoot();
	}

	public static boolean isEcore(@NonNull Resource resource) {
		List<EObject> contents = resource.getContents();
		for (EObject content : contents) {
			if (content instanceof EPackage) {
				return true;
			}
		}
		return false;
	}

/*	public static Ecore2Pivot createConverter(MetaModelManager metaModelManager, Resource ecoreResource) {
		EList<Adapter> eAdapters = ecoreResource.eAdapters();
		Ecore2Pivot conversion = (Ecore2Pivot) EcoreUtil.getAdapter(eAdapters, Ecore2Pivot.class);
		if (conversion == null) {
			conversion = new Ecore2Pivot(metaModelManager);
			eAdapters.add(conversion);
		}
		return conversion;
	} */

	/**
	 * Convert an (annotated) Ecore object to a pivot element. 
	 * 
	 * @param eObject the annotated Ecore object
	 * 
	 * @return the pivot element
	 */
	public static Element importFromEcore(@NonNull MetaModelManager metaModelManager, String alias, @NonNull EObject eObject) {
		Resource ecoreResource = DomainUtil.nonNullEMF(eObject.eResource());
		Ecore2Pivot conversion = getAdapter(ecoreResource, metaModelManager);
		@SuppressWarnings("unused")
		Root pivotRoot = conversion.getPivotRoot();
		return conversion.newCreateMap.get(eObject);
	}

	/**
	 * Mapping of source Ecore objects to their resulting pivot element in a previous conversion.
	 */
	private Map<String, Element> oldIdMap = null;

	/**
	 * Mapping of source Ecore objects to their resulting pivot element in the current conversion.
	 */
	private Map<EObject, Element> newCreateMap = null;

	/**
	 * Set of all Ecore objects requiring further work during the reference pass.
	 */
	private Set<EObject> referencers = null;
	
	/**
	 * Set of all converters used during session.
	 */
	private Set<Ecore2Pivot> allConverters = new HashSet<Ecore2Pivot>();
	
	/**
	 * List of all generic types.
	 */
	private List<EGenericType> genericTypes = null;
	
	private List<Resource.Diagnostic> errors = null;
	
	protected final Resource ecoreResource;					// Set via eAdapters.add()
	
	protected Root pivotRoot = null;						// Set by importResource
	protected final Ecore2PivotDeclarationSwitch declarationPass = new Ecore2PivotDeclarationSwitch(this);	
	protected final Ecore2PivotReferenceSwitch referencePass = new Ecore2PivotReferenceSwitch(this);
	private HashMap<EClassifier, Type> ecore2PivotMap = null;
	private URI ecoreURI = null;
	
	public Ecore2Pivot(@Nullable Resource ecoreResource, @Nullable MetaModelManager metaModelManager) {
		super(metaModelManager != null ? metaModelManager : new MetaModelManager());
		this.ecoreResource = ecoreResource;
		this.metaModelManager.addExternalResource(this);
		this.metaModelManager.addListener(this);
	}
	
	protected void addCreated(EObject eObject, Element pivotElement) {
		@SuppressWarnings("unused")
		Element oldElement = newCreateMap.put(eObject, pivotElement);
//		if (eObject instanceof ENamedElement) {
//			assert (oldElement == null) || (oldElement == pivotElement) || ((oldElement instanceof DataType) && (((DataType)oldElement).getBehavioralType() == pivotElement));
//		}
//		else {
//			assert oldElement == null;
//		}
	}

	@Override
	public void addGenericType(@NonNull EGenericType eObject) {
		genericTypes.add(eObject);
	}
	
	@Override
	public void addMapping(@NonNull EObject eObject, @NonNull Element pivotElement) {
		if (pivotElement instanceof PivotObjectImpl) {
			((PivotObjectImpl)pivotElement).setTarget(eObject);
		}
		Element pivotElement1 = pivotElement;
		if (eObject instanceof EDataType) {
			Type pivotType = getEcore2PivotMap().get(eObject);
			if (pivotType != null) {  		// If eObject is a known synonym such as EString
				pivotElement1 = pivotType;	// remap to the library type
			}
		}
//		Element pivotElement2 = pivotElement;
//		if (pivotElement instanceof DataType) {
//			Type behavioralType = ((DataType)pivotElement).getBehavioralType();
//			if (behavioralType != null) {
//				pivotElement2 = behavioralType;
//			}
//		}
//		assert pivotElement1 == pivotElement2;
		addCreated(eObject, pivotElement1);
	}

	protected @NonNull URI createPivotURI() {
		URI uri = ecoreResource.getURI();
		if (uri == null) {
			throw new IllegalStateException("Missing resource URI");
		}
		return PivotUtil.getPivotURI(uri);
	}

	public void dispose() {
		metaModelManager.removeExternalResource(this);
		Notifier target = getTarget();
		if (target != null) {
			target.eAdapters().remove(this);
		}
	}

	@Override
	public void error(@NonNull String message) {
		if (errors == null) {
			errors = new ArrayList<Resource.Diagnostic>();
		}
		errors.add(new XMIException(message));
	}

	public @Nullable <T extends Element> T getCreated(@NonNull Class<T> requiredClass, @NonNull EObject eObject) {
		return getPivotOfEcore(requiredClass, eObject);
	}

	public @NonNull Map<EClassifier, Type> getEcore2PivotMap() {
		HashMap<EClassifier, Type> ecore2PivotMap2 = ecore2PivotMap;
		if (ecore2PivotMap2 == null) {
			ecore2PivotMap2 = ecore2PivotMap = new HashMap<EClassifier, Type>();
			initializeEcore2PivotMap();
		}
		return ecore2PivotMap2;
	}

	public @Nullable Resource getEcoreResource() {
		return ecoreResource;
	}

	public @Nullable <T extends Element> T getPivotOfEcore(@NonNull Class<T> requiredClass, @NonNull EObject eObject) {
		if (pivotRoot == null) {
			getPivotRoot();
		}
		Element element = newCreateMap.get(eObject);
		if (element == null) {
			return null;
		}
		if (!requiredClass.isAssignableFrom(element.getClass())) {
			throw new ClassCastException(element.getClass().getName() + " is not assignable to " + requiredClass.getName());
		}
		@SuppressWarnings("unchecked")
		T castElement = (T) element;
		return castElement;
	}
	
	public <T extends Element> T getPivotElement(@NonNull Class<T> requiredClass, @NonNull EObject eObject) {
		if (pivotRoot == null) {
			getPivotRoot();
		}
		Element element = newCreateMap.get(eObject);
		if (element == null) {
			Resource resource = eObject.eResource();
			if ((resource != ecoreResource) && (resource != null)) {
				Ecore2Pivot converter = getAdapter(resource, metaModelManager);
				if (allConverters.add(converter)) {
					converter.getPivotRoot();
					for (Map.Entry<EObject, Element> entry : converter.newCreateMap.entrySet()) {
						newCreateMap.put(entry.getKey(), entry.getValue());
					}
				}
			}
			element = newCreateMap.get(eObject);
		}
		if (element == null) {
			error("Unresolved " + eObject);
		}
		else if (!requiredClass.isAssignableFrom(element.getClass())) {
			throw new ClassCastException(element.getClass().getName() + " is not assignable to " + requiredClass.getName());
		}
		@SuppressWarnings("unchecked")
		T castElement = (T) element;
		return castElement;
	}
	
	public Type getPivotType(@NonNull EObject eObject) {
		Element pivotElement = newCreateMap.get(eObject);
		if (pivotElement == null) {
			Resource resource = eObject.eResource();
			if ((resource != ecoreResource) && (resource != null)) {
				Ecore2Pivot converter = getAdapter(resource, metaModelManager);
				if (allConverters.add(converter)) {
					converter.getPivotRoot();
//					allEClassifiers.addAll(converter.allEClassifiers);
//					allNames.addAll(converter.allNames);
					for (Map.Entry<EObject, Element> entry : converter.newCreateMap.entrySet()) {
						newCreateMap.put(entry.getKey(), entry.getValue());
					}
				}
			}
			pivotElement = newCreateMap.get(eObject);
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
	
	public @NonNull Root getPivotRoot() {
		Root pivotRoot2 = pivotRoot;
		if (pivotRoot2 == null) {
			pivotRoot2 = pivotRoot = importObjects(DomainUtil.nonNullEMF(ecoreResource.getContents()), createPivotURI());
			@SuppressWarnings("null") @NonNull Resource pivotResource = pivotRoot2.eResource();
			AliasAdapter ecoreAdapter = AliasAdapter.findAdapter(ecoreResource);
			if (ecoreAdapter != null) {
				Map<EObject, String> ecoreAliasMap = ecoreAdapter.getAliasMap();
				AliasAdapter pivotAdapter = AliasAdapter.getAdapter(pivotResource);
				Map<EObject, String> pivotAliasMap = pivotAdapter.getAliasMap();
				for (EObject eObject : ecoreAliasMap.keySet()) {
					String alias = ecoreAliasMap.get(eObject);
					Element element = newCreateMap.get(eObject);
					pivotAliasMap.put(element, alias);
				}
			}
			metaModelManager.installResource(pivotResource);
		}
		return pivotRoot2;
	}

	public @Nullable Resource getResource() {
		return ecoreResource;
	}

	public @Nullable Notifier getTarget() {
		return ecoreResource;
	}

	public @NonNull URI getURI() {
		return DomainUtil.nonNullEMF(ecoreResource.getURI());
	}

	public @NonNull Root importObjects(@NonNull Collection<EObject> ecoreContents, @NonNull URI pivotURI) {
		@NonNull Resource pivotResource = metaModelManager.createResource(pivotURI, PivotPackage.eCONTENT_TYPE);
//		try {
			if ((metaModelManager.getLibraryResource() == null) && isPivot(ecoreContents)) {
				String nsURI = ((EPackage)ecoreContents.iterator().next()).getNsURI();
				if (nsURI != null) {
					String stdlibUri = OCLstdlib.STDLIB_URI;
					OCLstdlib library = OCLstdlib.create(stdlibUri, "ocl", "ocl", nsURI);
					metaModelManager.installResource(library);
//					metaModelManager.installAs(nsURI, OCLstdlibTables.PACKAGE);
				}
			}
			URI uri = ecoreURI != null ? ecoreURI : ecoreResource.getURI();
			Root pivotRoot2 = pivotRoot = metaModelManager.createRoot(pivotURI.lastSegment(), uri.toString());
			update(pivotResource, ecoreContents);
//		}
//		catch (Exception e) {
//			if (errors == null) {
//				errors = new ArrayList<Resource.Diagnostic>();
//			}
//			errors.add(new XMIException("Failed to load '" + pivotURI + "'", e));
//		}
		if (errors != null) {
			pivotResource.getErrors().addAll(errors);
		}
		return pivotRoot2;
	}

	public void initializeEcore2PivotMap() {
		ecore2PivotMap.put(EcorePackage.Literals.EBOOLEAN, metaModelManager.getBooleanType());
		ecore2PivotMap.put(EcorePackage.Literals.EBIG_INTEGER, metaModelManager.getIntegerType());
		ecore2PivotMap.put(EcorePackage.Literals.EBIG_DECIMAL, metaModelManager.getRealType());
		ecore2PivotMap.put(EcorePackage.Literals.ESTRING, metaModelManager.getStringType());
	}

	public boolean isAdapterFor(@NonNull MetaModelManager metaModelManager) {
		return this.metaModelManager == metaModelManager;
	}

	public boolean isAdapterForType(Object type) {
		return type == Ecore2Pivot.class;
	}

	protected boolean isPivot(@NonNull Collection<EObject> ecoreContents) {
		if (ecoreContents.size() != 1) {
			return false;
		}
		EObject ecoreRoot = ecoreContents.iterator().next();
		if (!(ecoreRoot instanceof EPackage)) {
			return false;
		}
		EPackage ecorePackage = (EPackage) ecoreRoot;
		if (ecorePackage.getEClassifier(PivotPackage.Literals.ENUMERATION_LITERAL.getName()) == null) {
			return false;
		}
		if (ecorePackage.getEClassifier(PivotPackage.Literals.EXPRESSION_IN_OCL.getName()) == null) {
			return false;
		}
		if (ecorePackage.getEClassifier(PivotPackage.Literals.OPERATION_CALL_EXP.getName()) == null) {
			return false;
		}
		if (ecorePackage.getEClassifier(PivotPackage.Literals.TEMPLATE_PARAMETER_SUBSTITUTION.getName()) == null) {
			return false;
		}
		return true;
	}

	public void metaModelManagerDisposed(@NonNull MetaModelManager metaModelManager) {
		dispose();
	}

	public void notifyChanged(Notification notification) {}

	@Override
	public void queueReference(@NonNull EObject eObject) {
		referencers.add(eObject);
	}

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

	@Override
	public @NonNull <T extends NamedElement> T refreshElement(@NonNull Class<T> pivotClass, EClass pivotEClass, @NonNull EModelElement eModelElement) {
		EObject pivotElement = null;
		if (oldIdMap != null) {
			String id = ((XMLResource)eModelElement.eResource()).getID(eModelElement);
			if (id != null) {
				pivotElement = oldIdMap.get(id);
				if ((pivotElement != null) && (pivotElement.eClass() != pivotEClass)) {
					pivotElement = null;
				}
			}
		}
		if (pivotElement == null) {
			EFactory eFactoryInstance = pivotEClass.getEPackage().getEFactoryInstance();
			pivotElement = eFactoryInstance.create(pivotEClass);
		}
		if (!pivotClass.isAssignableFrom(pivotElement.getClass())) {
			throw new ClassCastException();
		}
		@SuppressWarnings("unchecked")
		T castElement = (T) pivotElement;
		Element oldElement = newCreateMap.put(eModelElement, castElement);
		assert oldElement == null;
		return castElement;
	}
	
	protected Type resolveDataType(@NonNull EDataType eClassifier) {
		Type pivotType = getEcore2PivotMap().get(eClassifier);
		if (pivotType == null) {
			pivotType = getPivotType(eClassifier);
		}
		return pivotType;
	}

	protected Type resolveGenericType(@NonNull Map<String, Type> resolvedSpecializations, @NonNull EGenericType eGenericType) {
		List<EGenericType> eTypeArguments = eGenericType.getETypeArguments();
		assert !eGenericType.getETypeArguments().isEmpty();
		EClassifier eClassifier = eGenericType.getEClassifier();
		List<ETypeParameter> eTypeParameters = eClassifier.getETypeParameters();
		assert eTypeParameters.size() == eTypeArguments.size();
		Type unspecializedPivotType = getPivotType(eClassifier);
		if (unspecializedPivotType == null) {
			return null;
		}
 		List<Type> templateArguments = new ArrayList<Type>();
		for (EGenericType eTypeArgument : eTypeArguments) {
			if (eTypeArgument != null) {
				Type typeArgument = resolveType(resolvedSpecializations, eTypeArgument);
				templateArguments.add(typeArgument);
			}
		}
		return metaModelManager.getLibraryType(unspecializedPivotType, templateArguments);
	}

	protected Type resolveSimpleType(@NonNull EClassifier eClassifier) {
		return getPivotType(eClassifier);
	}

	protected Type resolveType(@NonNull Map<String, Type> resolvedSpecializations, @NonNull EGenericType eGenericType) {
		Type pivotType = getCreated(Type.class, eGenericType);
		if (pivotType != null) {
			return pivotType;
		}
		EClassifier eClassifier = eGenericType.getEClassifier();
		ETypeParameter eTypeParameter = eGenericType.getETypeParameter();
		List<EGenericType> eTypeArguments = eGenericType.getETypeArguments();
		if (eTypeParameter != null) {
			pivotType = resolveTypeParameter(eGenericType);
		}
		else if (eClassifier == null) {
			pivotType = resolveWildcardType(eGenericType);
		}
		else if (!eTypeArguments.isEmpty()) {
			String ecoreMoniker = Ecore2Moniker.toString(eGenericType);
			pivotType = resolvedSpecializations.get(ecoreMoniker);
			if (pivotType == null) {
				pivotType = resolveGenericType(resolvedSpecializations, eGenericType);
				resolvedSpecializations.put(ecoreMoniker, pivotType);
			}
		}
		else if (eClassifier instanceof EDataType) {
			assert eGenericType.getETypeArguments().isEmpty();
			pivotType = resolveDataType((EDataType) eClassifier);
		}
		else { 
			assert eGenericType.getETypeArguments().isEmpty();
			pivotType = resolveSimpleType(eClassifier);
		}
		newCreateMap.put(eGenericType, pivotType);
		return pivotType;
	}

	protected Type resolveTypeParameter(@NonNull EGenericType eGenericType) {
		EClassifier eClassifier = eGenericType.getEClassifier();
		ETypeParameter eTypeParameter = eGenericType.getETypeParameter();
		List<EGenericType> eTypeArguments = eGenericType.getETypeArguments();
		assert eClassifier == null;
		assert eTypeArguments.isEmpty();
		Type pivotType = eTypeParameter != null ? getCreated(Type.class, eTypeParameter) : null;
		return pivotType;
	}

	protected Type resolveWildcardType(@NonNull EGenericType eGenericType) {
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

	public void setEcoreURI(URI ecoreURI) {
		this.ecoreURI = ecoreURI;
	}

	public void setTarget(Notifier newTarget) {
		assert (newTarget == null) || (newTarget == ecoreResource);
	}

	public void unsetTarget(Notifier oldTarget) {
		assert (oldTarget == ecoreResource);
	}

	public void update(@NonNull Resource pivotResource, @NonNull Collection<EObject> ecoreContents) {
		newCreateMap = new HashMap<EObject, Element>();
		referencers = new HashSet<EObject>();
		genericTypes = new ArrayList<EGenericType>();
		PivotUtil.refreshList(pivotResource.getContents(), Collections.singletonList(pivotRoot));
		List<org.eclipse.ocl.examples.pivot.Package> newPackages = new ArrayList<org.eclipse.ocl.examples.pivot.Package>();
		for (EObject eObject : ecoreContents) {
			Object pivotElement = declarationPass.doInPackageSwitch(eObject);
			if (pivotElement instanceof org.eclipse.ocl.examples.pivot.Package) {
				newPackages.add((org.eclipse.ocl.examples.pivot.Package) pivotElement);
			}
			else {
				error("Bad ecore content");
			}
		}
		PivotUtil.refreshList(pivotRoot.getNestedPackage(), newPackages);
		Map<String, Type> resolvedSpecializations = new HashMap<String, Type>();
		for (EGenericType eGenericType : genericTypes) {
			if (eGenericType != null) {
				Type pivotType = resolveType(resolvedSpecializations, eGenericType);
				newCreateMap.put(eGenericType, pivotType);
			}
		}
		for (EObject eObject : referencers) {
			referencePass.doInPackageSwitch(eObject);
		}
		for (EObject eObject : referencers) {
			if (eObject instanceof EReference) {
				Property pivotElement = getCreated(Property.class, eObject);		
				if (pivotElement != null) {
					Property oppositeProperty = pivotElement.getOpposite();
					if ((oppositeProperty == null) && (eObject.eContainer() instanceof EClass)) {		// Skip annotation references
						metaModelManager.installPropertyDeclaration(pivotElement);
					}
				}				
			}
		}
		referencers = null;
		genericTypes = null;
		oldIdMap = new HashMap<String, Element>();
		for (EObject ecoreContent : ecoreContents) {
			Resource resource = ecoreContent.eResource();
			if (resource instanceof XMLResource) {
				XMLResource xmlResource = (XMLResource) resource;
				String id = xmlResource.getID(ecoreContent);
				if (id != null) {
					Element element = newCreateMap.get(ecoreContent);
					if (element != null) {
						oldIdMap.put(id, element);
					}
				}
				for (TreeIterator<EObject> tit = ecoreContent.eAllContents(); tit.hasNext(); ) {
					EObject eObject = tit.next();
					id = xmlResource.getID(eObject);
					if (id != null) {
						Element element = newCreateMap.get(eObject);
						if (element != null) {
							oldIdMap.put(id, element);
						}
					}
				}
			}
		}
	}
}