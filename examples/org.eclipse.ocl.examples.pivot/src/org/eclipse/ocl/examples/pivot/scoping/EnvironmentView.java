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
 * $Id: EnvironmentView.java,v 1.19 2011/05/20 15:27:24 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.scoping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainElement;
import org.eclipse.ocl.examples.domain.elements.DomainNamedElement;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Package;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.PackageManager;
import org.eclipse.ocl.examples.pivot.manager.PackageServer;
import org.eclipse.ocl.examples.pivot.manager.RootPackageServer;
import org.eclipse.ocl.examples.pivot.manager.TypeServer;
import org.eclipse.ocl.examples.pivot.utilities.IllegalLibraryException;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

/**
 * An EnvironmentView provides a selective view of the environment visible at
 * some CST node.
 * 
 * The selection corresponds to an Environment lookup method as defined by the
 * OCL specification computed in accordance with the the Inherited Attributes.
 * 
 * The selective view is normally for just the single name required by the
 * lookUp, but may be for all names when a Completion Assist is required.
 * 
 * The EnvironmentView is computed on demand, rather than cached, since only
 * small parts of the overall environment are needed and caches may not remain
 * valid for long given the rapid recreation of CST nodes that occurs while
 * editing.
 */
public class EnvironmentView
{
	private static final Logger logger = Logger.getLogger(EnvironmentView.class);

	protected final MetaModelManager metaModelManager;
	protected final EStructuralFeature reference;
	private EClassifier requiredType;
	protected final String name;

	private final Map<String, Object> contentsByName = new HashMap<String, Object>(); // Single
																						// EObject
																						// or
																						// List<EObject>
	private Map<DomainElement, Map<TemplateParameter, ParameterableElement>> templateBindings = null;

	private int contentsSize = 0; // Deep size of contentsByName;

	private List<ScopeFilter> matchers = null;	// Prevailing filters for matching
	private Set<ScopeFilter> resolvers = null;	// Successful filters for resolving

	public EnvironmentView(@NonNull MetaModelManager metaModelManager, @Nullable EStructuralFeature reference, @Nullable String name) {
		this.metaModelManager = metaModelManager;
		this.reference = reference;
		this.requiredType = reference != null ? reference.getEType() : null;
		this.name = name;
	}

	public boolean accepts(@NonNull EClass eClass) {
		return PivotUtil.conformsTo(requiredType, eClass);
	}

	public void addAllContents(@NonNull Type forType, @NonNull ScopeView scopeView, @NonNull Type pivotClass, @Nullable Boolean selectStatic, @NonNull Set<Type> alreadyVisited) {
		addNamedElements(forType, metaModelManager.getLocalOperations(pivotClass, selectStatic));
		addNamedElements(forType, metaModelManager.getLocalProperties(pivotClass, selectStatic));
		alreadyVisited.add(pivotClass);
		for (Type superClass : metaModelManager.getSuperClasses(pivotClass)) {
			if (!alreadyVisited.contains(superClass)) {
				addAllContents(forType, scopeView, DomainUtil.nonNullEntry(superClass), selectStatic, alreadyVisited);
			}
		}
	}

	public void addAllProperties(@NonNull Type type, @Nullable Boolean selectStatic) {
		addAllProperties(type, type, selectStatic, new HashSet<Type>());
	}

	protected void addAllProperties(@NonNull Type forType, @NonNull Type pivotClass, @Nullable Boolean selectStatic, @NonNull Set<Type> alreadyVisited) {
		addNamedElements(metaModelManager.getLocalProperties(pivotClass, selectStatic));
		alreadyVisited.add(pivotClass);
		for (Type superClass : metaModelManager.getSuperClasses(pivotClass)) {
			if (!alreadyVisited.contains(superClass)) {
				addAllProperties(forType, DomainUtil.nonNullEntry(superClass), selectStatic, alreadyVisited);
			}
		}
	}

	/**
	 * Add an element with an elementName to the view
	 * 
	 * @param elementName
	 *            name of element
	 * @param element
	 *            the element
	 * @return the number of elements added; 1 if added, 0 if not
	 */
	public int addElement(@NonNull String elementName, @Nullable DomainElement element) {
		return addElement(elementName, null, element);
	}
	public int addElement(@NonNull String elementName, @Nullable Type forType, @Nullable DomainElement element) {
		if (element == null) {
			return 0;
		}		
		if (element instanceof Type) {
			PivotUtil.debugWellContainedness((Type)element);
		}		
		if ((name != null) && !name.equals(elementName)) {
			return 0;
		}
		if (element instanceof PackageServer) {
			element = ((PackageServer)element).getPivotPackage();
		}
		else if (element instanceof DomainPackage) {
			element = metaModelManager.getPackageServer((DomainPackage) element).getPivotPackage();
		}
//		else if (element instanceof org.eclipse.ocl.examples.pivot.Package) {
//			element = ((PackageServer) element).getPrimaryPackage();		// FIXME lose casts
//		}
//		else if (element instanceof TypeServer) {
//			element = ((TypeServer) element).getPrimaryType();		// FIXME lose casts
//		}
		else if ((element instanceof EObject) && (element instanceof DomainElement)) {
			element = (DomainNamedElement) metaModelManager.getPrimaryElement((EObject) element);		// FIXME lose casts
		}
		if ((name != null) && (matchers != null)) {
			for (ScopeFilter filter : matchers) {
				if (!filter.matches(this, forType, element)) {
					return 0;
				}
			}
		}
		/*if (element instanceof PackageServer) {
			element = ((PackageServer) element).getPrimaryPackage();		// FIXME lose casts
		}
		else*/ if (element instanceof TypeServer) {
			element = ((TypeServer) element).getPrimaryType();		// FIXME lose casts
		}
		if (requiredType != null) {
			if (!requiredType.isInstance(element)) {
				return 0;
			}
		}
		if (matchers != null) {
			if (resolvers == null) {
				resolvers = new HashSet<ScopeFilter>();
			}
			resolvers.addAll(matchers);
		}
		Object value = contentsByName.get(elementName);
		if (value == element) {
			;	// Already present
		} else if (value == null) {
			contentsByName.put(elementName, element);
			contentsSize++;
		} else {
			List<DomainElement> values;
			if (value instanceof DomainElement) {
				values = new ArrayList<DomainElement>();
				values.add((DomainElement) value);
				contentsByName.put(elementName, values);
			} else {
				@SuppressWarnings("unchecked")
				List<DomainElement> castValue = (List<DomainElement>) value;
				values = castValue;
			}
			if (!values.contains(element)) {
				values.add(element);
				contentsSize++;
			}
		}
		return 1;
	}

	public int addElements(@Nullable Iterable<? extends DomainElement> elements) {
		return addElements(null, elements);
	}

	public int addElements(@Nullable Type forType, @Nullable Iterable<? extends DomainElement> elements) {
		int additions = 0;
		if (elements != null) {
			for (DomainElement element : elements) {
				if (element instanceof DomainNamedElement) {
					DomainNamedElement namedElement = (DomainNamedElement) element;
					String elementName = namedElement.getName();
					if (elementName != null) {
						additions += addElement(elementName, forType, namedElement);
					}
				}
			}
		}
		return additions;
	}

	public void addElementsOfScope(@Nullable Element element, @NonNull ScopeView scopeView) {
		if (element != null) {
			element = PivotUtil.getLowerBound(element);
			Attribution attribution = PivotUtil.getAttribution(element);
			if (attribution != null) {
				attribution.computeLookup(element, this, scopeView);
			}
		}
	}

	public void addFilter(@NonNull ScopeFilter filter) {
		if (matchers == null) {
			matchers = new ArrayList<ScopeFilter>();
		}
		matchers.add(filter);
	}

	public void addImportedElement(@NonNull URI baseURI) {
    	if (PivotUtil.isPivotURI(baseURI)) {
    		baseURI = PivotUtil.getNonPivotURI(baseURI);
    	}
		String name = getName();
		if (name != null) {
			URI uri = URI.createURI(name).resolve(baseURI);
			try {
				Element importedElement = metaModelManager.loadResource(uri, null, null);				
				if (importedElement != null) {
					addElement(name, importedElement);
				}
			} catch (Exception e) {
				// if it doesn't load just treat it as unresolved
			}
		}
	}

	public void addInheritedContents(@NonNull org.eclipse.ocl.examples.pivot.Class target, @NonNull ScopeView scopeView) {
		List<Type> superClasses = target.getSuperClass();
		if (superClasses.size() > 0) {
			for (Type superClass : superClasses) {
				addElementsOfScope(superClass, scopeView);
			}
		}
		else {
			Type libType = metaModelManager.getAnyClassifierType();
			addLibContents(libType, scopeView);
		}
	}

	public void addLibContents(@NonNull Type libType, @NonNull ScopeView scopeView) {
		addElementsOfScope(libType, scopeView);
		for (Type superClass : libType.getSuperClass()) {
			if (superClass != null) {
				addLibContents(superClass, scopeView);
			}
		}
	}

	public void addMemberPackages(@NonNull DomainPackage aPackage) {
		PackageServer parentPackageServer = metaModelManager.getPackageServer(aPackage);
		String name2 = name;
		if (name2 != null) {
			PackageServer packageServer = parentPackageServer.getMemberPackage(name2);
			if (packageServer != null) {
				addNamedElement(packageServer);
			}
		}
		else {
			for (PackageServer packageServer : parentPackageServer.getMemberPackages()) {
				if (packageServer != null) {
					addNamedElement(packageServer);
				}
			}
		}
	}

	public int addNamedElement(@Nullable DomainNamedElement namedElement) {
		return addNamedElement(null, namedElement);
	}

	public int addNamedElement(@Nullable Type forType, @Nullable DomainNamedElement namedElement) {
		if (namedElement == null) {
			return 0;
		}
		String elementName = namedElement.getName();
		if (elementName != null) {
			return addElement(elementName, forType, namedElement);
		}
		else {
			return 0;
		}
	}

	public int addNamedElements(@NonNull Iterable<? extends DomainNamedElement> namedElements) {
		return addNamedElements(null, namedElements);
	}

	public int addNamedElements(@Nullable Type forType, @NonNull Iterable<? extends DomainNamedElement> namedElements) {
		int additions = 0;
		for (DomainNamedElement namedElement : namedElements) {
			additions += addNamedElement(forType, DomainUtil.nonNullEntry(namedElement));
		}
		return additions;
	}

	public void addRootPackages() {
		PackageManager packageManager = metaModelManager.getPackageManager();
		String name2 = name;
		if (name2 != null) {
			RootPackageServer rootPackageServer = packageManager.getMemberPackage(name2);
			if (rootPackageServer != null) {
				addNamedElement(rootPackageServer);
			}
			PackageServer packageServer = packageManager.getPackageByURI(name2);
			if (packageServer != null) {
				addElement(name2, packageServer);
			}
		}
		else {
			for (RootPackageServer rootPackageServer : packageManager.getMemberPackages()) {
				if (rootPackageServer != null) {
					addNamedElement(rootPackageServer);
				}
			}
			for (PackageServer packageServer : packageManager.getAllPackagesWithUris()) {
				String nsURI = packageServer.getNsURI();
				if (nsURI != null) {
					addElement(nsURI, packageServer);
				}
			}
		}
	}

	public int computeLookups(@NonNull Element target, EObject child, EStructuralFeature containmentFeature, EReference targetReference) {
		Attribution attribution = PivotUtil.getAttribution(target);
		if (attribution != null) {
			ScopeView pivotScopeView = new PivotScopeView(getMetaModelManager(), target, attribution, child, containmentFeature, targetReference);
			return computeLookups(pivotScopeView);
		}
		else {
			return 0;
		}
	}
	
	public int computeLookups(@NonNull ScopeView scopeView) {
		ScopeView aScope = scopeView;
		try {
			while ((aScope != null) && !hasFinalResult()) {
				EObject aTarget = aScope.getTarget();
				if (aTarget == null) {
					break;					// The NULLSCOPEVIEW
				}
				Attribution aAttribution = aScope.getAttribution();
				aScope = aAttribution.computeLookup(aTarget, this, aScope);
			}
		}
		catch (IllegalLibraryException e) {
			throw e;
		}
		catch (Exception e) {
			logger.warn("Lookup of '" + name + "' failed", e);
		}
		return resolveDuplicates();
	}

	protected int filterImplicits(@NonNull DomainElement match1, @NonNull DomainElement match2) {
		boolean match1IsImplicit = (match1 instanceof Property) && ((Property)match1).isImplicit();
		boolean match2IsImplicit = (match2 instanceof Property) && ((Property)match2).isImplicit();
		if (!match1IsImplicit) {
			return match2IsImplicit ? 1 : 0;				// match2 inferior			
		}
		else {
			return match2IsImplicit ? 0 : -1;				// match1 inferior			
		}
	}

	protected int filterRedefinitions(@NonNull DomainElement match1, @NonNull DomainElement match2) {
		if ((match1 instanceof Operation) && (match2 instanceof Operation)) {
			Operation operation1 = (Operation)match1;
			Operation operation2 = (Operation)match2;
			if (isRedefinitionOf(operation1, operation2)) {
				return 1;				// match2 inferior			
			}
			if (isRedefinitionOf(operation2, operation1)) {
				return -1;				// match1 inferior			
			}
		}
		else if ((match1 instanceof Property) && (match2 instanceof Property)) {
			Property property1 = (Property)match1;
			Property property2 = (Property)match2;
			if (isRedefinitionOf(property1, property2)) {
				return 1;				// match2 inferior			
			}
			if (isRedefinitionOf(property2, property1)) {
				return -1;				// match1 inferior			
			}
		}
		return 0;
	}

	public @Nullable EObject getContent() {
		if (contentsSize == 0) {
			return null;
		}
		if (contentsSize != 1) {
			logger.warn("Unhandled ambiguous content for '" + name + "'");
		}
		for (Map.Entry<String, Object> entry : contentsByName.entrySet()) {
			Object value = entry.getValue();
			if (value instanceof List<?>) {
				List<?> values = (List<?>) value;
				value = values.get(values.size() - 1);
			}
			if (value instanceof EObject) {
				return (EObject) value;
			}
		}
		return null;
	}

	public @NonNull Set<Map.Entry<String, Object>> getEntries() {
		return DomainUtil.nonNullJava(contentsByName.entrySet());
	}

	public @Nullable String getName() {
		return name;
	}

	public EStructuralFeature getReference() {
		return reference;
	}

	public @Nullable EClassifier getRequiredType() {
		return requiredType;
	}

	public int getSize() {
		return contentsSize;
	}

	@SuppressWarnings("null")
	public @NonNull MetaModelManager getMetaModelManager() {
		return metaModelManager;
	}

	/**
	 * Return true once the EnvironmentView has accumulated sufficient results
	 * to satisfy the lookup criterion for which it was created. i.e. any result
	 * for a non-null name, all results for a null name.
	 */
	public boolean hasFinalResult() {
		if (contentsSize == 0) {
			return false; // Not thing found is not a final result
		}
		if (getName() == null) {
			return false; // No name means search full hierarchy
		}
		return true;
	}

	protected boolean isRedefinitionOf(@NonNull Operation operation1, @NonNull Operation operation2) {
		List<Operation> redefinedOperations = operation1.getRedefinedOperation();
		for (Operation redefinedOperation : redefinedOperations) {
			if (redefinedOperation == operation2) {
				return true;
			}
			if (isRedefinitionOf(DomainUtil.nonNullEntry(redefinedOperation), operation2)) {
				return true;
			}
		}
		return false;
	}

	protected boolean isRedefinitionOf(@NonNull Property property1, @NonNull Property property2) {
		List<Property> redefinedProperties = property1.getRedefinedProperty();
		for (Property redefinedProperty : redefinedProperties) {
			if (redefinedProperty == property2) {
				return true;
			}
			if (isRedefinitionOf(DomainUtil.nonNullEntry(redefinedProperty), property2)) {
				return true;
			}
		}
		return false;
	}

	public void removeFilter(@NonNull ScopeFilter filter) {
		if (matchers != null) {
			matchers.remove(filter);
		}
	}

	public int resolveDuplicates() {
		if ((contentsSize > 1) && (getName() != null)) {
			int newSize = 0;
			for (Map.Entry<String, Object> entry : contentsByName.entrySet()) {
				Object value = entry.getValue();
				if (value instanceof List<?>) {
					@SuppressWarnings("unchecked")
					List<DomainElement> values = (List<DomainElement>) value;
					for (int i = 0; i < values.size()-1;) {
						DomainElement reference = DomainUtil.nonNullEntry(values.get(i));
						Map<TemplateParameter, ParameterableElement> referenceBindings = templateBindings != null ? templateBindings.get(reference) : null;
						for (int j = i + 1; j < values.size();) {
							@NonNull DomainElement reference2 = DomainUtil.nonNullJDT(reference);
							DomainElement candidate = DomainUtil.nonNullEntry(values.get(j));
							int verdict = filterImplicits(reference2, candidate);
							if (verdict == 0) {
								verdict = filterRedefinitions(reference2, candidate);
								if ((verdict == 0) && (resolvers != null)) {
									Map<TemplateParameter, ParameterableElement> candidateBindings = templateBindings != null ? templateBindings.get(candidate) : null;
									for (ScopeFilter filter : resolvers) {
										verdict = filter.compareMatches(DomainUtil.nonNullJDT(reference), referenceBindings, DomainUtil.nonNullJDT(candidate), candidateBindings);
										if (verdict != 0) {
											break;
										}
									}
								}
							}
							if (verdict == 0) {
								j++;
							} else if (verdict < 0) {
								values.remove(i);
								reference = null;
								break;
							} else {
								values.remove(j);
								candidate = null;
							}
						}
						if (reference != null) {
							i++;
						}
					}
					newSize += values.size();
				} else {
					newSize++;
				}
			}
			contentsSize = newSize;
		}
		return getSize();
	}

	public void setBindings(@NonNull DomainElement eObject, @Nullable Map<TemplateParameter, ParameterableElement> bindings) {
		if (templateBindings == null) {
			templateBindings = new HashMap<DomainElement, Map<TemplateParameter, ParameterableElement>>();
		}
		templateBindings.put(eObject, bindings);
	}

	public void setRequiredType(@NonNull EClassifier requiredType) {
		assert PivotUtil.conformsTo(reference.getEType(), requiredType);
		this.requiredType = requiredType;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		if (reference != null) {
			s.append(reference.getName());
			s.append(" : "); //$NON-NLS-1$
//			s.append(reference.getEType().getName());
		}
		if (requiredType != null) {
			s.append(requiredType.getName());
		}
		s.append(" \""); //$NON-NLS-1$
		if (name != null) {
			s.append(name);
		}
		s.append("\" {"); //$NON-NLS-1$
		String prefix = ""; //$NON-NLS-1$
		for (String contentName : contentsByName.keySet()) {
			s.append(prefix);
			s.append(contentName);
			Object content = contentsByName.get(contentName);
			if (content instanceof List<?>) {
				s.append("*");
				s.append(((List<?>) content).size());
			}
			prefix = ","; //$NON-NLS-1$
		}
		s.append("}"); //$NON-NLS-1$
		return s.toString();
	}
}
