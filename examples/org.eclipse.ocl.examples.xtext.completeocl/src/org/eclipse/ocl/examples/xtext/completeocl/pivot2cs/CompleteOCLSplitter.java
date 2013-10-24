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
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.ocl.examples.xtext.completeocl.pivot2cs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.common.utils.ClassUtils;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.Annotation;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.Namespace;
import org.eclipse.ocl.examples.pivot.OpaqueExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.resource.ASResource;
import org.eclipse.ocl.examples.pivot.util.PivotSwitch;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

/**
 * 
 */
public class CompleteOCLSplitter
{
	public static @Nullable ASResource separate(@NonNull MetaModelManager metaModelManager, @NonNull Resource resource) {
		List<Constraint> allConstraints = new ArrayList<Constraint>();
		List<OpaqueExpression> allOpaqueExpressions = new ArrayList<OpaqueExpression>();
		for (TreeIterator<EObject> tit = resource.getAllContents(); tit.hasNext(); ) {
			EObject eObject = tit.next();
			if (eObject instanceof Constraint) {
				allConstraints.add((Constraint) eObject);
			}
			else if (eObject instanceof Operation) {
				OpaqueExpression bodyExpression = ((Operation)eObject).getBodyExpression();
				if (bodyExpression != null) {
					allOpaqueExpressions.add(bodyExpression);
				}
			}
			else if (eObject instanceof Property) {
				OpaqueExpression bodyExpression = ((Property)eObject).getDefaultExpression();
				if (bodyExpression != null) {
					allOpaqueExpressions.add(bodyExpression);
				}
			}
			else if (eObject instanceof Annotation) {
				tit.prune();
			}
		}
		if (allConstraints.isEmpty()) {
			return null;
		}
		URI uri = resource.getURI();
		@SuppressWarnings("null")@NonNull URI oclURI = PivotUtil.getNonASURI(uri).appendFileExtension("ocl");
		URI oclASuri = PivotUtil.getASURI(oclURI);	// xxx.ocl.ocl.oclas
		ASResource oclResource = (ASResource) resource.getResourceSet().createResource(oclASuri, ASResource.COMPLETE_OCL_CONTENT_TYPE);	
		if (oclResource != null) {
			Separator separator = new Separator(metaModelManager, oclResource);
			for (Constraint constraint : allConstraints) {
				separator.doSwitch(constraint);
			}
			for (OpaqueExpression opaqueExpression : allOpaqueExpressions) {
				separator.doSwitch(opaqueExpression);
			}
			metaModelManager.installResource(oclResource);
		}
		return oclResource;
	}
	
	public static class Separator extends PivotSwitch<EObject>
	{
		protected final @NonNull MetaModelManager metaModelManager;
		protected final @NonNull Resource separateResource;
		private final @NonNull Map<NamedElement, NamedElement> map = new HashMap<NamedElement, NamedElement>();

		public Separator(@NonNull MetaModelManager metaModelManager, @NonNull Resource separateResource) {
			this.metaModelManager = metaModelManager;
			this.separateResource = separateResource;
		}

		@Override
		public EObject caseConstraint(Constraint object) {
			NamedElement parent = (NamedElement) object.eContainer();
			NamedElement separateParent = getSeparate(parent);
			EStructuralFeature eContainingFeature = object.eContainingFeature();
			if (!eContainingFeature.isMany()) {
				separateParent.eSet(eContainingFeature, object);
			}
			else {
				@SuppressWarnings("unchecked") List<Constraint> eGet = (List<Constraint>)separateParent.eGet(eContainingFeature);
				eGet.add(object);
			}
			return object;
		}

		@Override
		public EObject caseOpaqueExpression(OpaqueExpression object) {
			NamedElement parent = (NamedElement) object.eContainer();
			NamedElement separateParent = getSeparate(parent);
			if (separateParent instanceof Operation) {
				((Operation)separateParent).setBodyExpression(object);
			}
			if (separateParent instanceof Property) {
				((Property)separateParent).setDefaultExpression(object);
			}
			return object;
		}

		@Override
		public EObject caseOperation(Operation object) {
			Type parent = object.getOwningType();
			Type separateParent = getSeparate(parent);
			List<Operation> separateSiblings = separateParent.getOwnedOperation();
			@SuppressWarnings("serial")
			EcoreUtil.Copier copier = new EcoreUtil.Copier(false, true)
			{
				@Override
				protected void copyContainment(EReference eReference, EObject eObject, EObject copyEObject) {
					if (eReference == PivotPackage.Literals.OPERATION__OWNED_PARAMETER) {
						super.copyContainment(eReference, eObject, copyEObject);
					}
				}				
			};
			Operation clone = (Operation) copier.copy(object);
		    copier.copyReferences();
			separateSiblings.add(clone);
			return clone;
		}

		@Override
		public EObject casePackage(org.eclipse.ocl.examples.pivot.Package object) {
			String name = object.getName();
			EObject container = object.eContainer();
			assert container instanceof Namespace;
			Namespace parent = (Namespace) container;
			Namespace separateParent = (Namespace) map.get(parent);
			if (separateParent == null) {
				separateParent = (Namespace) doSwitch(parent);
				map.put(parent, separateParent);
			}
			List<org.eclipse.ocl.examples.pivot.Package> separateSiblings;
			if (separateParent instanceof Root) {
				separateSiblings = ((Root)separateParent).getNestedPackage();
			}
			else {
				separateSiblings = ((org.eclipse.ocl.examples.pivot.Package)separateParent).getNestedPackage();
			}
			org.eclipse.ocl.examples.pivot.Package separateObject = DomainUtil.getNamedElement(separateSiblings, name);
			if (separateObject == null) {
				separateObject = (org.eclipse.ocl.examples.pivot.Package) object.eClass().getEPackage().getEFactoryInstance().create(object.eClass());
				separateObject.setName(name);
				separateObject.setNsURI(object.getNsURI());
				separateObject.setNsPrefix(object.getNsPrefix());
				separateSiblings.add(separateObject);
			}
			return separateObject;
		}

		@Override
		public EObject caseProperty(Property object) {
			Type parent = object.getOwningType();
			Type separateParent = getSeparate(parent);
			List<Property> separateSiblings = separateParent.getOwnedAttribute();
			@SuppressWarnings("serial")
			EcoreUtil.Copier copier = new EcoreUtil.Copier(false, true)
			{
				@Override
				protected void copyContainment(EReference eReference, EObject eObject, EObject copyEObject) {
				}
			};
			Property clone = (Property) copier.copy(object);
		    copier.copyReferences();
			separateSiblings.add(clone);
			return clone;
		}

		@Override
		public EObject caseRoot(Root object) {
			String name = object.getName();
			EObject container = object.eContainer();
			assert container == null;
			List<EObject> separateSiblings = separateResource.getContents();
			Root separateObject = (Root) getElementByName(separateSiblings, name);
			if (separateObject == null) {
				separateObject = PivotFactory.eINSTANCE.createRoot();
				separateObject.setName(name);
				separateObject.setExternalURI(separateResource.getURI().toString());
				separateSiblings.add(separateObject);
//				metaModelManager.addRoot(separateObject);
			}
			return separateObject;
		}

		@Override
		public EObject caseType(Type object) {
			org.eclipse.ocl.examples.pivot.Package parent = object.getPackage();
			org.eclipse.ocl.examples.pivot.Package separateParent = getSeparate(parent);
			List<Type> separateSiblings = separateParent.getOwnedType();
			return cloneNamedElement(separateSiblings, object);
		}

		protected <T extends NamedElement> T cloneNamedElement(List<T> separateSiblings, T object) {
			String name = object.getName();
			T separateObject = DomainUtil.getNamedElement(separateSiblings, name);
			if (separateObject == null) {
				@SuppressWarnings("unchecked")
				T castObject = (T) object.eClass().getEPackage().getEFactoryInstance().create(object.eClass());
				separateObject = castObject;
				separateObject.setName(name);
				separateSiblings.add(separateObject);
			}
			return separateObject;
		}

		public NamedElement getElementByName(Iterable<? extends EObject> elements, String name) {
			if (elements == null)
				return null;
			for (EObject element : elements)
				if ((element instanceof NamedElement) && ClassUtils.equals(name, ((NamedElement)element).getName()))
					return (NamedElement)element;
			return null;				
		}

		protected <T extends NamedElement> T getSeparate(T element) {
			NamedElement separate = map.get(element);
			if (separate == null) {
				separate = (NamedElement) doSwitch(element);
				map.put(element, separate);
			}
			@SuppressWarnings("unchecked")
			T castSeparate = (T) separate;
			return castSeparate;
		}		

		protected org.eclipse.ocl.examples.pivot.Package getSeparatePackage(org.eclipse.ocl.examples.pivot.Package element) {
			org.eclipse.ocl.examples.pivot.Package separate = (org.eclipse.ocl.examples.pivot.Package) map.get(element);
			if (separate == null) {
				separate = (org.eclipse.ocl.examples.pivot.Package) doSwitch(element);
				map.put(element, separate);
			}
			return separate;
		}
	}
}
