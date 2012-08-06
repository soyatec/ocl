/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D.Willink and others.
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
package org.eclipse.ocl.examples.xtext.completeocl.cs2pivot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.domain.elements.DomainElement;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Feature;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.Namespace;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.SelfType;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.UMLReflection;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.baseCST.ImportCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.LibraryCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ParameterCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PathElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedRefCS;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2Pivot;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.Continuation;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ClassifierContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLDocumentCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ContextConstraintCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DefCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DefFeatureCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DefOperationCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DefPropertyCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.IncludeCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OperationContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PackageDeclarationCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PropertyContextDeclCS;
import org.eclipse.ocl.examples.xtext.essentialocl.attributes.AbstractOperationFilter;

public class CompleteOCLContainmentVisitor extends AbstractCompleteOCLContainmentVisitor
{
	public class OperationDeclScopeFilter extends AbstractOperationFilter
	{
		private final List<ParameterCS> csParameters;
		
		public OperationDeclScopeFilter(MetaModelManager metaModelManager, Type sourceType, List<ParameterCS> csParameters) {
			super(metaModelManager, sourceType);
			this.csParameters = csParameters;
		}

		public boolean matches(EnvironmentView environmentView, DomainElement eObject) {
			if (eObject instanceof Iteration) {
				return false;
			}
			if (eObject instanceof Operation) {
				Operation candidateOperation = (Operation)eObject;
				List<Parameter> candidateParameters = candidateOperation.getOwnedParameter();
				int iMax = csParameters.size();
				if (iMax != candidateParameters.size()) {
					return false;
				}
				Map<TemplateParameter, ParameterableElement> bindings = getOperationBindings(candidateOperation);
				for (int i = 0; i < iMax; i++) {
					Parameter candidateParameter = candidateParameters.get(i);
					ParameterCS csParameter = csParameters.get(i);
					if (csParameter == null) {
						return false;
					}
					TypedRefCS csType = csParameter.getOwnedType();
					Type pType = PivotUtil.getPivot(Type.class, csType);
					if (pType == null) {
						return false;
					}
					Type candidateType = metaModelManager.getTypeWithMultiplicity(candidateParameter);
					if (candidateType instanceof SelfType) {
						candidateType = candidateOperation.getOwningType();
					}
					pType = PivotUtil.getBehavioralType(pType);			// FIXME make this a general facility
					if (!metaModelManager.conformsTo(pType, candidateType, bindings)) {
						return false;
					}
				}
				if (bindings != null) {
					installBindings(environmentView, eObject, bindings);
				}
				return true;
			}
			else {
				return false;
			}
		}
	}

	public static String getStereotype(String stereotype) {
		if (stereotype == null) {
			return null;
		}
		else if (stereotype.equals("body")) {
			return UMLReflection.BODY;
		}
		else if (stereotype.equals("def")) {
			return UMLReflection.DEFINITION;
		}
		else if (stereotype.equals("derive")) {
			return UMLReflection.DERIVATION;
		}
		else if (stereotype.equals("init")) {
			return UMLReflection.INITIAL;
		}
		else if (stereotype.equals("inv")) {
			return UMLReflection.INVARIANT;
		}
		else if (stereotype.equals("pre")) {
			return UMLReflection.PRECONDITION;
		}
		else if (stereotype.equals("post")) {
			return UMLReflection.POSTCONDITION;
		}
		else {
			return stereotype;
		}
	}
	
	/**
	 * Mapping from the complemented package to the complementing package for each complementing package, excluding
	 * the root complementing model.
	 */
	private Map<org.eclipse.ocl.examples.pivot.Package, org.eclipse.ocl.examples.pivot.Package> modelPackage2contextPackage =
			new HashMap<org.eclipse.ocl.examples.pivot.Package, org.eclipse.ocl.examples.pivot.Package>();
	
	/**
	 * Mapping from the complemented type to the complementing type for each complementing type.
	 */
	private Map<Type, Type> modelType2contextType = new HashMap<Type, Type>();
	
	/**
	 * Mapping from the complemented type to the list of complementing operations for each complementing type.
	 */
	private Map<Type, List<Operation>> modelType2contextOperations = new HashMap<Type, List<Operation>>();
	
	/**
	 * Mapping from the complemented type to the list of complementing properties for each complementing type.
	 */
	private Map<Type, List<Property>> modelType2contextProperties = new HashMap<Type, List<Property>>();

	/**
	 * Mapping from the complemented element to the list of constraints for that element.
	 */
	private Map<NamedElement, List<Constraint>> modelElement2constraints = new HashMap<NamedElement, List<Constraint>>();

	public CompleteOCLContainmentVisitor(CS2PivotConversion context) {
		super(context);
	}

	protected void installConstraintContainment(NamedElement contextElement) {
		List<Constraint> constraints = modelElement2constraints.get(contextElement);
		if (constraints == null) {
			contextElement.getOwnedRule().clear();
		}
		else {
			PivotUtil.refreshList(contextElement.getOwnedRule(), constraints);
		}
	}

	protected void installOperationContainment(Type modelType, Type contextType) {
		List<Operation> contextOperations = modelType2contextOperations.get(modelType);
		if (contextOperations == null) {
			contextType.getOwnedOperation().clear();
		}
		else {
			PivotUtil.refreshList(contextType.getOwnedOperation(), contextOperations);
			for (Operation contextOperation : contextOperations) {
				installConstraintContainment(contextOperation);
			}
		}
	}

	protected void installPackageContainment(Root contextRoot) {
		Map<org.eclipse.ocl.examples.pivot.Package, Set<org.eclipse.ocl.examples.pivot.Package>> nestedContextPackageMaps =
				new HashMap<org.eclipse.ocl.examples.pivot.Package, Set<org.eclipse.ocl.examples.pivot.Package>>();
		Set<org.eclipse.ocl.examples.pivot.Package> nestedContextRoots = new HashSet<org.eclipse.ocl.examples.pivot.Package>();
		for (org.eclipse.ocl.examples.pivot.Package modelPackage : modelPackage2contextPackage.keySet()) {
			org.eclipse.ocl.examples.pivot.Package contextPackage = modelPackage2contextPackage.get(modelPackage);
			org.eclipse.ocl.examples.pivot.Package parentModelPackage = modelPackage.getNestingPackage();
			if (parentModelPackage != null) {
				org.eclipse.ocl.examples.pivot.Package parentContextPackage = modelPackage2contextPackage.get(parentModelPackage);
				if (parentContextPackage != null) {
					Set<org.eclipse.ocl.examples.pivot.Package> nestedContextPackages = nestedContextPackageMaps.get(parentContextPackage);
					if (nestedContextPackages == null) {
						nestedContextPackages = new HashSet<org.eclipse.ocl.examples.pivot.Package>();
						nestedContextPackageMaps.put(parentContextPackage, nestedContextPackages);
//						nestedContextPackages.addAll(parentContextPackage.getNestedPackage());
					}
					nestedContextPackages.add(contextPackage);
				}
			}
			else {
				EObject modelPackageContainer = modelPackage.eContainer();
				if (modelPackageContainer instanceof Root) {
					nestedContextRoots.add(contextPackage);
				}
			}
		}
		for (org.eclipse.ocl.examples.pivot.Package parentContextPackage : nestedContextPackageMaps.keySet()) {
			Set<org.eclipse.ocl.examples.pivot.Package> nestedContextPackages = nestedContextPackageMaps.get(parentContextPackage);
			PivotUtil.refreshSet(parentContextPackage.getNestedPackage(), nestedContextPackages);
		}
		PivotUtil.refreshSet(contextRoot.getNestedPackage(), nestedContextRoots);
	}

	protected void installPropertyContainment(Type modelType, Type contextType) {
		List<Property> contextProperties = modelType2contextProperties.get(modelType);
		if (contextProperties == null) {
			contextType.getOwnedAttribute().clear();
		}
		else {
			PivotUtil.refreshList(contextType.getOwnedAttribute(), contextProperties);
			for (Property contextProperty : contextProperties) {
				installConstraintContainment(contextProperty);
			}
		}
	}

	protected void installTypeContainment() {
		Map<org.eclipse.ocl.examples.pivot.Package, Set<Type>> nestedContextTypeMaps =
				new HashMap<org.eclipse.ocl.examples.pivot.Package, Set<Type>>();
		for (Type modelType : modelType2contextType.keySet()) {
			Type contextType = modelType2contextType.get(modelType);
			org.eclipse.ocl.examples.pivot.Package parentModelPackage = modelType.getPackage();
			org.eclipse.ocl.examples.pivot.Package parentContextPackage = modelPackage2contextPackage.get(parentModelPackage);
			Set<Type> ownedTypes = nestedContextTypeMaps.get(parentContextPackage);
			if (ownedTypes == null) {
				ownedTypes = new HashSet<Type>();
				nestedContextTypeMaps.put(parentContextPackage, ownedTypes);
//				ownedTypes.addAll(parentContextPackage.getOwnedType());
			}
			ownedTypes.add(contextType);
			installOperationContainment(modelType, contextType);
			installPropertyContainment(modelType, contextType);
			installConstraintContainment(contextType);
		}
		for (org.eclipse.ocl.examples.pivot.Package parentContextPackage : nestedContextTypeMaps.keySet()) {
			Set<Type> ownedTypes = nestedContextTypeMaps.get(parentContextPackage);
			PivotUtil.refreshSet(parentContextPackage.getOwnedType(), ownedTypes);
		}
	}

	protected void refreshConstrainedElements(ContextDeclCS csElement, NamedElement constrainedElement) {
		for (ContextConstraintCS csRule : csElement.getRules()) {
			Constraint constraint = PivotUtil.getPivot(Constraint.class, csRule);
			List<Element> constrainedElements = constraint.getConstrainedElement();
			constrainedElements.clear();
			constrainedElements.add(constrainedElement);
			List<Constraint> constraints = modelElement2constraints.get(constrainedElement);
			if (constraints == null) {
				constraints = new ArrayList<Constraint>();
				modelElement2constraints.put(constrainedElement, constraints);
			}
			constraints.add(constraint);
		}
	}

	protected org.eclipse.ocl.examples.pivot.Package refreshContextPackage(org.eclipse.ocl.examples.pivot.Package modelPackage, PackageDeclarationCS csElement) {
		if ((modelPackage == null) || modelPackage.eIsProxy()) {
			return null;
		}
		org.eclipse.ocl.examples.pivot.Package contextPackage = modelPackage2contextPackage.get(modelPackage);
		if (contextPackage == null) {
			contextPackage = context.refreshModelElement(org.eclipse.ocl.examples.pivot.Package.class, PivotPackage.Literals.PACKAGE, csElement);
			contextPackage.setName(modelPackage.getName());
			contextPackage.setNsURI(modelPackage.getNsURI());
			modelPackage2contextPackage.put(modelPackage, contextPackage);
			org.eclipse.ocl.examples.pivot.Package parentModelPackage = modelPackage.getNestingPackage();
			refreshContextPackage(parentModelPackage, null);
		}
		if (csElement != null) {
			context.refreshComments(contextPackage, csElement);
			context.installPivotUsage(csElement, contextPackage);
		}
		return contextPackage;
	}

	protected Type refreshContextType(Type modelClassifier, ClassifierContextDeclCS csElement) {
		if ((modelClassifier == null) || modelClassifier.eIsProxy()) {
			return null;
		}
		Type contextClassifier = modelType2contextType.get(modelClassifier);
		if (contextClassifier == null) {
			contextClassifier = context.refreshModelElement(org.eclipse.ocl.examples.pivot.Class.class, PivotPackage.Literals.CLASS, csElement);
			contextClassifier.setName(modelClassifier.getName());
			modelType2contextType.put(modelClassifier, contextClassifier);
			refreshContextPackage(modelClassifier.getPackage(), null);
		}
		if (csElement != null) {
			context.refreshComments(contextClassifier, csElement);
			context.installPivotUsage(csElement, contextClassifier);
		}
		return contextClassifier;
	}

	protected void registerOperation(Type modelClassifier, Operation pivotElement) {
		List<Operation> contextOperations = modelType2contextOperations.get(modelClassifier);
		if (contextOperations == null) {
			contextOperations = new ArrayList<Operation>();
			modelType2contextOperations.put(modelClassifier, contextOperations);
		}
		contextOperations.add(pivotElement);
	}

	protected void registerProperty(Type modelClassifier, Property pivotElement) {
		List<Property> contextProperties = modelType2contextProperties.get(modelClassifier);
		if (contextProperties == null) {
			contextProperties = new ArrayList<Property>();
			modelType2contextProperties.put(modelClassifier, contextProperties);
		}
		contextProperties.add(pivotElement);
	}

	@Override
	public Continuation<?> visitClassifierContextDeclCS(ClassifierContextDeclCS csElement) {
		Type modelClassifier = csElement.getClassifier();
		Type contextClassifier = refreshContextType(modelClassifier, csElement);
		refreshConstrainedElements(csElement, contextClassifier);
		return null;
	}

	@Override
	public Continuation<?> visitCompleteOCLDocumentCS(CompleteOCLDocumentCS csElement) {
		for (IncludeCS csInclude : csElement.getOwnedInclude()) {
			csInclude.getNamespace();					// Resolve the proxy to perform the import.
		}
		Root contextRoot = refreshRoot(Root.class, PivotPackage.Literals.ROOT, csElement);
		List<Root> modelRoots = new ArrayList<Root>();
		for (org.eclipse.ocl.examples.pivot.Package modelPackage : modelPackage2contextPackage.keySet()) {
			org.eclipse.ocl.examples.pivot.Package parentModelPackage = modelPackage.getNestingPackage();
			if (parentModelPackage == null) {
				modelRoots.add((Root) modelPackage.eContainer());
			}
		}
		installTypeContainment();
		installPackageContainment(contextRoot);
		return null;
	}

	@Override
	public Continuation<?> visitContextConstraintCS(ContextConstraintCS csElement) {
		Constraint pivotElement = refreshNamedElement(Constraint.class, PivotPackage.Literals.CONSTRAINT, csElement);
		String newStereotype = csElement.getStereotype();
		String stereotype = getStereotype(newStereotype);
		pivotElement.setStereotype(stereotype);
		return null;
	}

	@Override
	public Continuation<?> visitDefCS(DefCS csElement) {
		Constraint pivotElement = refreshNamedElement(Constraint.class, PivotPackage.Literals.CONSTRAINT, csElement);
		DefFeatureCS csFeature = csElement.getFeature();
		pivotElement.setStereotype(csFeature instanceof DefOperationCS ? UMLReflection.BODY : UMLReflection.INITIAL);
		Feature pivotFeature = PivotUtil.getPivot(Feature.class, csFeature);
		pivotFeature.setIsStatic(csElement.isStatic());
		PivotUtil.refreshList(pivotFeature.getOwnedRule(), Collections.singletonList(pivotElement));
		return null;
	}

	@Override
	public Continuation<?> visitDefOperationCS(DefOperationCS csElement) {
		ClassifierContextDeclCS csClassifierContextDecl = (ClassifierContextDeclCS) csElement.getDef().getContextDecl();
		Type modelClassifier = csClassifierContextDecl.getClassifier();
		Operation pivotElement = refreshNamedElement(Operation.class, PivotPackage.Literals.OPERATION, csElement);
		registerOperation(modelClassifier, pivotElement);
		context.refreshPivotList(Parameter.class, pivotElement.getOwnedParameter(), csElement.getParameters());
		return null;
	}

	@Override
	public Continuation<?> visitDefPropertyCS(DefPropertyCS csElement) {
		ClassifierContextDeclCS csClassifierContextDecl = (ClassifierContextDeclCS) csElement.getDef().getContextDecl();
		Type modelClassifier = csClassifierContextDecl.getClassifier();
		Property pivotElement = refreshNamedElement(Property.class, PivotPackage.Literals.PROPERTY, csElement);
		registerProperty(modelClassifier, pivotElement);
		pivotElement.setIsDerived(true);
		pivotElement.setIsReadOnly(true);
		pivotElement.setIsTransient(true);
		pivotElement.setIsVolatile(true);
		pivotElement.setIsResolveProxies(false);
		return null;
	}

	@Override
	public Continuation<?> visitImportCS(ImportCS csElement) {
		Namespace namespace = csElement.getNamespace();													// Resolve the proxy to perform the import.
		if ((namespace != null) && !namespace.eIsProxy()) {
			context.installPivotUsage(csElement, namespace);
		}
		return null;
	}

	@Override
	public Continuation<?> visitIncludeCS(IncludeCS csElement) {
		return null;		// Suppressed here to avoid reversed post-order
	}

	@Override
	public Continuation<?> visitLibraryCS(LibraryCS csElement) {
		org.eclipse.ocl.examples.pivot.Package pPackage = csElement.getPackage();						// Resolve the proxy to perform the import.
		if ((pPackage != null) && !pPackage.eIsProxy()) {
			context.installPivotUsage(csElement, pPackage);
		}
		return null;
	}

	@Override
	public Continuation<?> visitOperationContextDeclCS(OperationContextDeclCS csElement) {
		List<ParameterCS> csParameters = csElement.getParameters();
		CS2Pivot.setElementType(csElement.getPathName(), PivotPackage.Literals.OPERATION, csElement,
			new OperationDeclScopeFilter(metaModelManager, null, csParameters));
		/*
		 * Types have not yet been resolved so operation overloads are not resolvaeable.
		 *
		Operation modelOperation = csElement.getOperation(); */
		List<PathElementCS> path = csElement.getPathName().getPath();
		int pathSize = path.size();
		Element modelParent = pathSize >= 2 ? path.get(pathSize-2).getElement() : null;
		Operation pivotElement = context.refreshModelElement(Operation.class, PivotPackage.Literals.OPERATION, csElement);
		if (modelParent instanceof Type) {
			Type modelClassifier = (Type) modelParent;
			refreshContextType(modelClassifier, null);
			registerOperation(modelClassifier, pivotElement);
		}
		context.refreshPivotList(Parameter.class, pivotElement.getOwnedParameter(), csParameters);
		context.refreshComments(pivotElement, csElement);
		refreshConstrainedElements(csElement, pivotElement);
		return null;
	}

	@Override
	public Continuation<?> visitPackageDeclarationCS(PackageDeclarationCS csElement) {
		org.eclipse.ocl.examples.pivot.Package modelPackage = csElement.getPackage();
		refreshContextPackage(modelPackage, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitPropertyContextDeclCS(PropertyContextDeclCS csElement) {
		Property modelProperty = csElement.getProperty();
		Property contextProperty = context.refreshModelElement(Property.class, PivotPackage.Literals.PROPERTY, csElement);
		if ((modelProperty != null) && !modelProperty.eIsProxy()) {
			contextProperty.setName(modelProperty.getName());
			contextProperty.setType(modelProperty.getType());
			Type modelClassifier = modelProperty.getOwningType();
			if (modelClassifier != null) {
				refreshContextType(modelClassifier, null);
				registerProperty(modelClassifier, contextProperty);
			}
		}
		context.refreshComments(contextProperty, csElement);
		refreshConstrainedElements(csElement, contextProperty);
		return null;
	}
}
