/**
 * <copyright>
 * 
 * Copyright (c) 2013 E.D.Willink and others.
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
package org.eclipse.ocl.examples.build.xtend;

import com.google.common.base.Objects;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.Nameable;
import org.eclipse.ocl.examples.pivot.AnyType;
import org.eclipse.ocl.examples.pivot.AssociativityKind;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Enumeration;
import org.eclipse.ocl.examples.pivot.EnumerationLiteral;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.LambdaType;
import org.eclipse.ocl.examples.pivot.Library;
import org.eclipse.ocl.examples.pivot.Metaclass;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.OpaqueExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.Precedence;
import org.eclipse.ocl.examples.pivot.PrimitiveType;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.TemplateBinding;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.TupleType;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.utilities.AS2Moniker;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.lib.Functions.Function0;

@SuppressWarnings("all")
public abstract class GenerateOCLCommon extends GenerateMetamodelWorkflowComponent
{
	private final @NonNull Map<Element, String> element2moniker = new HashMap<Element, String>();
	
	protected final @NonNull Comparator<Comment> commentComparator = new Comparator<Comment>()
	{
		public int compare(Comment o1, Comment o2) {
			String m1 = o1.getBody(); 
			String m2 = o2.getBody();
			return m1.compareTo(m2);
		}
	};

	protected final @NonNull Comparator<Element> monikerComparator = new Comparator<Element>()
	{
		public int compare(Element o1, Element o2) {
			String m1 = getMoniker(o1); 
			String m2 = getMoniker(o2);
			return m1.compareTo(m2);
		}
	};
	
	protected final @NonNull Comparator<Nameable> nameableComparator = new Comparator<Nameable>()
	{
		public int compare(Nameable o1, Nameable o2) {
			String m1 = o1.getName(); 
			String m2 = o2.getName();
			return m1.compareTo(m2);
		}
	};

	protected Set<CollectionType> getAllCollectionTypes(Root root) {
		Set<CollectionType> allElements = new HashSet<CollectionType>();
		TreeIterator<EObject> tit = root.eAllContents();
		while (tit.hasNext()) {
			EObject eObject = tit.next();
			if (eObject instanceof CollectionType) {
				allElements.add((CollectionType)eObject);
			}
		}
		return allElements;
	}

	protected Set<Enumeration> getAllEnumerations(Root root) {
		Set<Enumeration> allElements = new HashSet<Enumeration>();
		TreeIterator<EObject> tit = root.eAllContents();
		while (tit.hasNext()) {
			EObject eObject = tit.next();
			if (eObject instanceof Enumeration) {
				allElements.add((Enumeration)eObject);
			}
		}
		return allElements;
	}

	protected Set<LambdaType> getAllLambdaTypes(Root root) {
		Set<LambdaType> allElements = new HashSet<LambdaType>();
		TreeIterator<EObject> tit = root.eAllContents();
		while (tit.hasNext()) {
			EObject eObject = tit.next();
			if (eObject instanceof LambdaType) {
				allElements.add((LambdaType)eObject);
			}
		}
		return allElements;
	}

	protected Set<Metaclass<?>> getAllMetaclasses(Root root) {
		Set<Metaclass<?>> allElements = new HashSet<Metaclass<?>>();
		TreeIterator<EObject> tit = root.eAllContents();
		while (tit.hasNext()) {
			EObject eObject = tit.next();
			if (eObject instanceof Metaclass<?>) {
				allElements.add((Metaclass<?>)eObject);
			}
		}
		return allElements;
	}

	protected List<org.eclipse.ocl.examples.pivot.Package> getAllPackages(Root root) {
		Set<org.eclipse.ocl.examples.pivot.Package> allElements = new HashSet<org.eclipse.ocl.examples.pivot.Package>();
		TreeIterator<EObject> tit = root.eAllContents();
		while (tit.hasNext()) {
			EObject eObject = tit.next();
			if (eObject instanceof org.eclipse.ocl.examples.pivot.Package) {
				allElements.add((org.eclipse.ocl.examples.pivot.Package)eObject);
			}
		}
		List<org.eclipse.ocl.examples.pivot.Package> sortedElements = new ArrayList<org.eclipse.ocl.examples.pivot.Package>(allElements);
		Collections.sort(sortedElements, monikerComparator);
		return sortedElements;
	}

	protected Set<Precedence> getAllPrecedences(Root root) {
		Set<Precedence> allElements = new HashSet<Precedence>();
		TreeIterator<EObject> tit = root.eAllContents();
		while (tit.hasNext()) {
			EObject eObject = tit.next();
			if (eObject instanceof Precedence) {
				allElements.add((Precedence)eObject);
			}
		}
		return allElements;
	}

	protected Set<PrimitiveType> getAllPrimitiveTypes(Root root) {
		Set<PrimitiveType> allElements = new HashSet<PrimitiveType>();
		TreeIterator<EObject> tit = root.eAllContents();
		while (tit.hasNext()) {
			EObject eObject = tit.next();
			if (eObject instanceof PrimitiveType) {
				allElements.add((PrimitiveType)eObject);
			}
		}
		return allElements;
	}

	protected List<Property> getAllProperties(Root root) {
		List<Property> allElements = new ArrayList<Property>();
		TreeIterator<EObject> tit = root.eAllContents();
		while (tit.hasNext()) {
			EObject eObject = tit.next();
			if ((eObject instanceof Property) && !(eObject.eContainer() instanceof TupleType) &&
				(((Property)eObject).getOwningType() != null)) {
				allElements.add((Property)eObject);
			}
		}
		return allElements;
	}

	protected Set<TemplateBinding> getAllTemplateBindings(Root root) {
		Set<TemplateBinding> allElements = new HashSet<TemplateBinding>();
		TreeIterator<EObject> tit = root.eAllContents();
		while (tit.hasNext()) {
			EObject eObject = tit.next();
			if (eObject instanceof TemplateBinding) {
				allElements.add((TemplateBinding)eObject);
			}
		}
		return allElements;
	}

	protected Set<TemplateSignature> getAllTemplateSignatures(Root root) {
		Set<TemplateSignature> allElements = new HashSet<TemplateSignature>();
		TreeIterator<EObject> tit = root.eAllContents();
		while (tit.hasNext()) {
			EObject eObject = tit.next();
			if (eObject instanceof TemplateSignature) {
				allElements.add((TemplateSignature)eObject);
			}
		}
		return allElements;
	}

	protected Set<TupleType> getAllTupleTypes(Root root) {
		Set<TupleType> allElements = new HashSet<TupleType>();
		TreeIterator<EObject> tit = root.eAllContents();
		while (tit.hasNext()) {
			EObject eObject = tit.next();
			if (eObject instanceof TupleType) {
				allElements.add((TupleType)eObject);
			}
		}
		return allElements;
	}

	protected Set<Type> getAllTypes(Root root) {
		Set<Type> allElements = new HashSet<Type>();
		TreeIterator<EObject> tit = root.eAllContents();
		while (tit.hasNext()) {
			EObject eObject = tit.next();
			if (eObject instanceof Type) {
				allElements.add((Type)eObject);
			}
		}
		return allElements;
	}

	protected String getMoniker(Element elem) {
		String moniker = element2moniker.get(elem);
		if (moniker == null) {
			moniker = AS2Moniker.toString(elem);
			element2moniker.put(elem, moniker);
		}
		return moniker;
	}

	protected Collection<Type> getOclTypes(Root root) {
		Map<String, Type> allElements = new HashMap<String, Type>();
		TreeIterator<EObject> tit = root.eAllContents();
		while (tit.hasNext()) {
			EObject eObject = tit.next();
			if ((eObject instanceof Type) && !(eObject instanceof Enumeration) && !(eObject instanceof LambdaType) &&
				!(eObject instanceof CollectionType) && !(eObject instanceof PrimitiveType) &&
				!(eObject instanceof Metaclass<?>) && !(eObject instanceof TupleType) &&
				(((Type)eObject).getOwningTemplateParameter() == null)) {
				allElements.put(((Type)eObject).getName(), (Type)eObject);
			}
		}
		if (allElements.containsKey("Boolean")) {
			allElements.remove("Boolean");
			allElements.remove("Integer");
			allElements.remove("OclElement");
			allElements.remove("Real");
			allElements.remove("String");
			allElements.remove("UnlimitedNatural");
		}
		return allElements.values();
	}

	protected org.eclipse.ocl.examples.pivot.Package getOrphanPackage(org.eclipse.ocl.examples.pivot.Package elem) {
		return getOrphanPackage(getRootPackage(elem));
	}

	protected org.eclipse.ocl.examples.pivot.Package getOrphanPackage(Root elem) {
		for (org.eclipse.ocl.examples.pivot.Package pkg : getAllPackages(elem)) {
			if ("$$".equals(pkg.getName())) {
				return pkg;
			}
		}
		return null;
	}

	protected Root getRootPackage(org.eclipse.ocl.examples.pivot.Package elem) {
		EObject eObject = elem;
		while (eObject != null) {
			if (eObject instanceof Root) {
				return (Root)eObject;
			}
			eObject = eObject.eContainer();
		}
		return null;
	}

	protected String getSignature(NamedElement elem) {
		EObject parent = elem.eContainer();
		if (parent != null) {
			return getSignature((NamedElement)parent) + "::" + elem.getName();
		} else {
			return elem.getName();
		}
	}

	protected String getSignature(Operation elem) {
		EObject parent = elem.eContainer();
		if (parent != null) {
			return getSignature((NamedElement)parent) + "::" + elem.getName() + "()";
		} else {
			return elem.getName() + "()";
		}
	}

	protected String getPrefixedSymbolName(EObject elem, String prefix) {
		return NameQueries.getPrefixedSymbolName(prefix, elem);
	}

	protected ResourceSet getResourceSet() {
		if (resourceSet == null) {
			resourceSet = new ResourceSetImpl();
		}
		return resourceSet;
	}

	protected List<CollectionType> getSortedCollectionTypes(Root root) {
		Set<CollectionType> allElements = new HashSet<CollectionType>();
		TreeIterator<EObject> tit = root.eAllContents();
		while (tit.hasNext()) {
			EObject eObject = tit.next();
			if (eObject instanceof CollectionType) {
				allElements.add((CollectionType)eObject);
			}
		}
		List<CollectionType> sortedElements = new ArrayList<CollectionType>(allElements);
		Collections.sort(sortedElements, monikerComparator);
		return sortedElements;
	}

	protected List<Element> getSortedCommentedElements(Root root) {
		Collection<Type> oclTypes = getOclTypes(root);
		Set<Element> allElements = new HashSet<Element>();
		TreeIterator<EObject> tit = root.eAllContents();
		while (tit.hasNext()) {
			EObject eObject = tit.next();
			if ((eObject instanceof Element) && !(eObject instanceof Constraint) &&
				!((eObject instanceof Property) && (((Property)eObject).getOwningType() == null)) &&
				!((eObject instanceof Type) && !oclTypes.contains(eObject))) {
				Element t = (Element)eObject;
				if (t.getOwnedComment().size() > 0) {
					allElements.add(t);
				}
			}
		}
		List<Element> sortedElements = new ArrayList<Element>(allElements);
		Collections.sort(sortedElements, monikerComparator);
		return sortedElements;
	}

	protected List<Comment> getSortedComments(Element element) {
		List<Comment> sortedElements = new ArrayList<Comment>(element.getOwnedComment());
		Collections.sort(sortedElements, commentComparator);
		return sortedElements;
	}

	protected List<Enumeration> getSortedEnumerations(Root root) {
		Set<Enumeration> allElements = new HashSet<Enumeration>();
		TreeIterator<EObject> tit = root.eAllContents();
		while (tit.hasNext()) {
			EObject eObject = tit.next();
			if (eObject instanceof Enumeration) {
				allElements.add((Enumeration)eObject);
			}
		}
		List<Enumeration> sortedElements = new ArrayList<Enumeration>(allElements);
		Collections.sort(sortedElements, monikerComparator);
		return sortedElements;
	}

	protected List<Iteration> getSortedIterations(Root root) {
		Set<Iteration> allElements = new HashSet<Iteration>();
		TreeIterator<EObject> tit = root.eAllContents();
		while (tit.hasNext()) {
			EObject eObject = tit.next();
			if (eObject instanceof Iteration) {
				allElements.add((Iteration)eObject);
			}
		}
		List<Iteration> sortedElements = new ArrayList<Iteration>(allElements);
		Collections.sort(sortedElements, monikerComparator);
		return sortedElements;
	}

	protected List<Iteration> getSortedIterations(Type type, List<Iteration> allIterations) {
		Set<Iteration> allElements = new HashSet<Iteration>();
		for (Operation operation : type.getOwnedOperation()) {
			if (allIterations.contains(operation)) {
				allElements.add((Iteration)operation);
			}
		}
		List<Iteration> sortedElements = new ArrayList<Iteration>(allElements);
		Collections.sort(sortedElements, monikerComparator);
		return sortedElements;
	}

	protected List<LambdaType> getSortedLambdaTypes(Root root) {
		Set<LambdaType> allElements = new HashSet<LambdaType>();
		TreeIterator<EObject> tit = root.eAllContents();
		while (tit.hasNext()) {
			EObject eObject = tit.next();
			if (eObject instanceof LambdaType) {
				allElements.add((LambdaType)eObject);
			}
		}
		List<LambdaType> sortedElements = new ArrayList<LambdaType>(allElements);
		Collections.sort(sortedElements, monikerComparator);
		return sortedElements;
	}

	protected List<Library> getSortedLibraries(Root root) {
		Set<Library> allElements = new HashSet<Library>();
		TreeIterator<EObject> tit = root.eAllContents();
		while (tit.hasNext()) {
			EObject eObject = tit.next();
			if (eObject instanceof Library) {
				allElements.add((Library)eObject);
			}
		}
		List<Library> sortedElements = new ArrayList<Library>(allElements);
		Collections.sort(sortedElements, monikerComparator);
		return sortedElements;
	}

	protected List<Metaclass<?>> getSortedMetaclasses(Root root) {
		Set<Metaclass<?>> allElements = new HashSet<Metaclass<?>>();
		TreeIterator<EObject> tit = root.eAllContents();
		while (tit.hasNext()) {
			EObject eObject = tit.next();
			if (eObject instanceof Metaclass<?>) {
				allElements.add((Metaclass<?>)eObject);
			}
		}
		List<Metaclass<?>> sortedElements = new ArrayList<Metaclass<?>>(allElements);
		Collections.sort(sortedElements, monikerComparator);
		return sortedElements;
	}

	protected List<Type> getSortedOclTypes(org.eclipse.ocl.examples.pivot.Package pkg) {
		List<Type> sortedElements = new ArrayList<Type>(getOclTypes(getRootPackage(pkg)));
		Collections.sort(sortedElements, monikerComparator);
		return sortedElements;
	}

	protected List<Operation> getSortedOperations(Root root) {
		Set<Operation> allElements = new HashSet<Operation>();
		TreeIterator<EObject> tit = root.eAllContents();
		while (tit.hasNext()) {
			EObject eObject = tit.next();
			if ((eObject instanceof Operation) && !(eObject instanceof Iteration) &&
				!isEcoreConstraint((Operation)eObject)) {
				allElements.add((Operation)eObject);
			}
		}
		List<Operation> sortedElements = new ArrayList<Operation>(allElements);
		Collections.sort(sortedElements, monikerComparator);
		return sortedElements;
	}

	protected List<Operation> getSortedOperations(Type type, List<Operation> allOperations) {
		Set<Operation> allElements = new HashSet<Operation>();
		for (Operation operation : type.getOwnedOperation()) {
			if (allOperations.contains(operation)) {
				allElements.add(operation);
			}
		}
		List<Operation> sortedElements = new ArrayList<Operation>(allElements);
		Collections.sort(sortedElements, monikerComparator);
		return sortedElements;
	}

	protected List<Operation> getSortedOperationsWithPrecedence(Root root) {
		Set<Operation> allElements = new HashSet<Operation>();
		TreeIterator<EObject> tit = root.eAllContents();
		while (tit.hasNext()) {
			EObject eObject = tit.next();
			if ((eObject instanceof Operation) && !(eObject instanceof Iteration) &&
				!isEcoreConstraint((Operation)eObject)) {
				Operation operation = (Operation)eObject;
				if (!(operation instanceof Iteration) && !isEcoreConstraint(operation) &&
					(operation.getPrecedence() != null)) {
					allElements.add(operation);
				}
			}
		}
		List<Operation> sortedElements = new ArrayList<Operation>(allElements);
		Collections.sort(sortedElements, monikerComparator);
		return sortedElements;
	}

	protected List<Type> getSortedOwningTypes(List<? extends Operation> operations) {
		Set<Type> allElements = new HashSet<Type>();
		for (Operation operation : operations) {
			if (operation.getOwningType() != null) {
				allElements.add(operation.getOwningType());
			}
		}
		List<Type> sortedElements = new ArrayList<Type>(allElements);
		Collections.sort(sortedElements, monikerComparator);
		return sortedElements;
	}

	protected List<Type> getSortedOwningTypes2(List<? extends Property> properties) {
		Set<Type> allElements = new HashSet<Type>();
		for (Property property : properties) {
			if (property.getOwningType() != null) {
				allElements.add(property.getOwningType());
			}
		}
		List<Type> sortedElements = new ArrayList<Type>(allElements);
		Collections.sort(sortedElements, monikerComparator);
		return sortedElements;
	}

	protected List<org.eclipse.ocl.examples.pivot.Package> getSortedPackages(Root root) {
		Set<org.eclipse.ocl.examples.pivot.Package> allElements = new HashSet<org.eclipse.ocl.examples.pivot.Package>();
		TreeIterator<EObject> tit = root.eAllContents();
		while (tit.hasNext()) {
			EObject eObject = tit.next();
			if (eObject instanceof org.eclipse.ocl.examples.pivot.Package) {
				allElements.add((org.eclipse.ocl.examples.pivot.Package)eObject);
			}
		}
		List<org.eclipse.ocl.examples.pivot.Package> sortedElements = new ArrayList<org.eclipse.ocl.examples.pivot.Package>(allElements);
		Collections.sort(sortedElements, nameableComparator);
		return sortedElements;
	}

	protected List<org.eclipse.ocl.examples.pivot.Package> getSortedPackages(org.eclipse.ocl.examples.pivot.Package pkg) {
		List<org.eclipse.ocl.examples.pivot.Package> sortedElements = new ArrayList<org.eclipse.ocl.examples.pivot.Package>(pkg.getNestedPackage());
		Collections.sort(sortedElements, nameableComparator);
		return sortedElements;
	}

	protected List<Type> getSortedParameterTypes(Root root) {
		Set<Type> allElements = new HashSet<Type>();
		TreeIterator<EObject> tit = root.eAllContents();
		while (tit.hasNext()) {
			EObject eObject = tit.next();
			if (eObject instanceof Type) {
				Type t = (Type)eObject;
				if (t.getOwningTemplateParameter() != null) {
					allElements.add(t);
				}
			}
		}
		List<Type> sortedElements = new ArrayList<Type>(allElements);
		Collections.sort(sortedElements, monikerComparator);
		return sortedElements;
	}

	protected List<Precedence> getSortedPrecedences(Library library) {
		List<Precedence> sortedElements = new ArrayList<Precedence>(library.getOwnedPrecedence());
		Collections.sort(sortedElements, nameableComparator);
		return sortedElements;
	}

	protected List<PrimitiveType> getSortedPrimitiveTypes(Root root) {
		Set<PrimitiveType> allElements = new HashSet<PrimitiveType>();
		TreeIterator<EObject> tit = root.eAllContents();
		while (tit.hasNext()) {
			EObject eObject = tit.next();
			if (eObject instanceof PrimitiveType) {
				allElements.add((PrimitiveType)eObject);
			}
		}
		List<PrimitiveType> sortedElements = new ArrayList<PrimitiveType>(allElements);
		Collections.sort(sortedElements, monikerComparator);
		return sortedElements;
	}

	protected List<Property> getSortedProperties(Root root) {
		List<Property> allElements = new ArrayList<Property>();
		TreeIterator<EObject> tit = root.eAllContents();
		while (tit.hasNext()) {
			EObject eObject = tit.next();
			if ((eObject instanceof Property) && !(eObject.eContainer() instanceof TupleType) &&
				(((Property)eObject).getOwningType() != null)) {
				allElements.add((Property)eObject);
			}
		}
		List<Property> sortedElements = new ArrayList<Property>(allElements);
		Collections.sort(sortedElements, monikerComparator);
		return sortedElements;
	}

	protected List<Property> getSortedProperties(Type type) {
		List<Property> sortedElements = new ArrayList<Property>(type.getOwnedAttribute());
		Collections.sort(sortedElements, nameableComparator);
		return sortedElements;
	}

	protected List<Property> getSortedProperties(Type type, List<Property> allProperties) {
		Set<Property> allElements = new HashSet<Property>();
		for (Property property : type.getOwnedAttribute()) {
			if (allProperties.contains(property)) {
				allElements.add(property);
			}
		}
		List<Property> sortedElements = new ArrayList<Property>(allElements);
		Collections.sort(sortedElements, monikerComparator);
		return sortedElements;
	}

	protected List<TemplateParameter> getSortedTemplateParameters(Root root) {
		Set<TemplateParameter> allElements = new HashSet<TemplateParameter>();
		TreeIterator<EObject> tit = root.eAllContents();
		while (tit.hasNext()) {
			EObject eObject = tit.next();
			if (eObject instanceof TemplateParameter) {
				allElements.add((TemplateParameter)eObject);
			}
		}
		List<TemplateParameter> sortedElements = new ArrayList<TemplateParameter>(allElements);
		Collections.sort(sortedElements, monikerComparator);
		return sortedElements;
	}

	protected List<TemplateSignature> getSortedTemplateSignatures(Root root) {
		Set<TemplateSignature> allElements = new HashSet<TemplateSignature>();
		TreeIterator<EObject> tit = root.eAllContents();
		while (tit.hasNext()) {
			EObject eObject = tit.next();
			if (eObject instanceof TemplateSignature) {
				allElements.add((TemplateSignature)eObject);
			}
		}
		List<TemplateSignature> sortedElements = new ArrayList<TemplateSignature>(allElements);
		Collections.sort(sortedElements, monikerComparator);
		return sortedElements;
	}

	protected List<TemplateableElement> getSortedTemplateableElements(Root root) {
		Set<TemplateableElement> allElements = new HashSet<TemplateableElement>();
		TreeIterator<EObject> tit = root.eAllContents();
		while (tit.hasNext()) {
			EObject eObject = tit.next();
			if ((eObject instanceof TemplateableElement) &&
				(((TemplateableElement)eObject).getTemplateBinding().size() > 0)) {
				allElements.add((TemplateableElement)eObject);
			}
		}
		List<TemplateableElement> sortedElements = new ArrayList<TemplateableElement>(allElements);
		Collections.sort(sortedElements, monikerComparator);
		return sortedElements;
	}

	protected List<Property> getSortedTupleParts(TupleType tupleType) {
		List<Property> sortedElements = new ArrayList<Property>(tupleType.getOwnedAttribute());
		Collections.sort(sortedElements, nameableComparator);
		return sortedElements;
	}

	protected List<TupleType> getSortedTupleTypes(Root root) {
		Set<TupleType> allElements = new HashSet<TupleType>();
		TreeIterator<EObject> tit = root.eAllContents();
		while (tit.hasNext()) {
			EObject eObject = tit.next();
			if (eObject instanceof TupleType) {
				allElements.add((TupleType)eObject);
			}
		}
		List<TupleType> sortedElements = new ArrayList<TupleType>(allElements);
		Collections.sort(sortedElements, monikerComparator);
		return sortedElements;
	}

	protected List<Type> getSuperclassesInPackage(Type type) {
		List<Type> allElements = new ArrayList<Type>();
		for (Type superclass : type.getSuperClass()) {
			if (getRootPackage(superclass.getPackage()) == getRootPackage(type.getPackage())) {
				allElements.add(superclass);
			}
		}
		return allElements;
	}

	protected List<TemplateParameterSubstitution> getTemplateParameterSubstitutions(TemplateableElement element) {
		List<TemplateParameterSubstitution> allElements = new ArrayList<TemplateParameterSubstitution>();
		for (TemplateBinding templateBinding : element.getTemplateBinding()) {
			allElements.addAll(templateBinding.getParameterSubstitution());
		}
		return allElements;
	}

	protected String getSymbolName(EObject elem) {
		return NameQueries.getSymbolName(elem);
	}

	protected Boolean isEcoreConstraint(Operation operation) {
		for (Parameter p : operation.getOwnedParameter()) {
			if (p.getName().equals("diagnostics") && p.getType().getName().equals("EDiagnosticChain")) {
				return true;
			}
		}
		return false;
	}

	protected String javaName(NamedElement element) {
		return NameQueries.rawEncodeName(element.getName(), 0);
	}

	protected String javaName(Object element, String string) {
		return NameQueries.rawEncodeName(string, 0);
	}

	protected String javaString(Comment aComment) {
		return Strings.convertToJavaString(aComment.getBody().trim());
	}

	protected String javaString(OpaqueExpression anExpression) {
		return Strings.convertToJavaString(anExpression.getBody().get(0).trim());
	}
}
