/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
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
 * $Id: UML2PivotReferenceSwitch.java,v 1.3 2011/01/27 07:02:06 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.uml;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypedElement;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.util.UMLSwitch;

public class UML2PivotReferenceSwitch extends UMLSwitch<Object>
{				
	protected final UML2Pivot converter;
	
	public UML2PivotReferenceSwitch(UML2Pivot converter) {
		this.converter = converter;
	}
	
//	@Override
//	public Object caseEAnnotation(EAnnotation eObject) {
//		Annotation pivotElement = converter.getCreated(Annotation.class, eObject);
//		doSwitchAll(Element.class, pivotElement.getReference(), eObject.getReferences());
//		return null;
//	}

	@Override
	public org.eclipse.ocl.examples.pivot.Class caseClass(org.eclipse.uml2.uml.Class umlClass) {
		org.eclipse.ocl.examples.pivot.Class pivotElement = converter.getCreated(org.eclipse.ocl.examples.pivot.Class.class, umlClass);
		doSwitchAll(Type.class, pivotElement.getSuperClass(), umlClass.getSuperClasses());
		if (pivotElement.getSuperClass().isEmpty()) {
			org.eclipse.ocl.examples.pivot.Class oclElementType = converter.getMetaModelManager().getOclElementType();
			if (oclElementType != null) {
				pivotElement.getSuperClass().add(oclElementType);
			}
		}
		return null;
	}

	@Override
	public Constraint caseConstraint(org.eclipse.uml2.uml.Constraint umlConstraint) {
		Constraint pivotElement = converter.getCreated(Constraint.class, umlConstraint);
		doSwitchAll(Element.class, pivotElement.getConstrainedElement(), umlConstraint.getConstrainedElements());
		return null;
	}

	@Override
	public org.eclipse.ocl.examples.pivot.Class caseInterface(org.eclipse.uml2.uml.Interface umlInterface) {
		org.eclipse.ocl.examples.pivot.Class pivotElement = converter.getCreated(org.eclipse.ocl.examples.pivot.Class.class, umlInterface);
		List<Generalization> umlGeneralizations = umlInterface.getGeneralizations();
		List<Type> newSuperTypes = new ArrayList<Type>(Math.max(1, umlGeneralizations.size()));
		for (org.eclipse.uml2.uml.Generalization umlGeneralization : umlGeneralizations) {
			org.eclipse.uml2.uml.Classifier umlGeneral = umlGeneralization.getGeneral();
			Type pivotGeneral = converter.getCreated(Type.class, umlGeneral);
			if (!newSuperTypes.contains(pivotGeneral)) {
				newSuperTypes.add(pivotGeneral);
			}
		}
		if (newSuperTypes.isEmpty()) {
			org.eclipse.ocl.examples.pivot.Class oclElementType = converter.getMetaModelManager().getOclElementType();
			if (oclElementType != null) {
				newSuperTypes.add(oclElementType);
			}
		}
		PivotUtil.refreshList(pivotElement.getSuperClass(), newSuperTypes);
		return null;
	}

	@Override
	public Operation caseOperation(org.eclipse.uml2.uml.Operation umlOperation) {
		Operation pivotElement = converter.getCreated(Operation.class, umlOperation);
		doSwitchAll(Type.class, pivotElement.getRaisedException(), umlOperation.getRaisedExceptions());
		doSwitchAll(Operation.class, pivotElement.getRedefinedOperation(), umlOperation.getRedefinedOperations());
		for (org.eclipse.uml2.uml.Parameter umlParameter : umlOperation.getOwnedParameters()) {
			ParameterDirectionKind direction = umlParameter.getDirection();
			if (direction == ParameterDirectionKind.RETURN_LITERAL) {
				org.eclipse.uml2.uml.Type umlType = umlParameter.getType();
				if (umlType != null) {
					Type pivotType = converter.resolveType(umlType);
					pivotElement.setType(pivotType);
					converter.copyMultiplicityElement(pivotElement, umlParameter);
				}
			}
		}
		return null;
	}

	@Override
	public org.eclipse.ocl.examples.pivot.Package casePackage(org.eclipse.uml2.uml.Package umlPackage) {
		org.eclipse.ocl.examples.pivot.Package pivotElement = converter.getCreated(org.eclipse.ocl.examples.pivot.Package.class, umlPackage);
		doSwitchAll(org.eclipse.ocl.examples.pivot.Package.class, pivotElement.getImportedPackage(), umlPackage.getImportedPackages());
		return null;
	}

	@Override
	public Property caseProperty(org.eclipse.uml2.uml.Property umlProperty) {
		Property pivotElement = converter.getCreated(Property.class, umlProperty);
		org.eclipse.uml2.uml.Type umlType = umlProperty.getType();
		if (umlType != null) {
			Type pivotType = converter.resolveType(umlType);
			pivotElement.setType(pivotType);
		}
		doSwitchAll(Property.class, pivotElement.getRedefinedProperty(), umlProperty.getRedefinedProperties());
//		doSwitchAll(Property.class, pivotElement.getSubsettedProperty(), umlProperty.getSubsettedProperties());
		return null;
	}

	@Override
	public EObject caseTypedElement(org.eclipse.uml2.uml.TypedElement umlTypedElement) {
		TypedElement pivotElement = converter.getCreated(TypedElement.class, umlTypedElement);
		org.eclipse.uml2.uml.Type umlType = umlTypedElement.getType();
		if (umlType != null) {
			Type pivotType = converter.resolveType(umlType);
			pivotElement.setType(pivotType);
		}
		else {
			// FIXME Void ???
		}
/*		EClassifier eClassifier = eGenericType.getEClassifier();
			if (eClassifier != null) {
				allEClassifiers.add(eClassifier);
				ClassifierCS csClassifier = getCS(eClassifier, ClassifierCS.class);
				csTypeRef.setType(csClassifier);
			}
			else {
				ETypeParameter eTypeParameter = eGenericType.getETypeParameter();
				if (eTypeParameter != null) {
					TypeParameterCS csTypeParameter = (TypeParameterCS) createMap.get(eTypeParameter);
					csTypeRef.setType(csTypeParameter);
				}
//				else {
//					error("Unresolved " + eGenericType + " in pass2");
//				}
			} */
		return null;
	}

//	@Override
//	public Object caseETypeParameter(ETypeParameter eObject) {
//		org.eclipse.ocl.examples.pivot.Class pivotElement = converter.getCreated(org.eclipse.ocl.examples.pivot.Class.class, eObject);
//		TypeTemplateParameter typeTemplateParameter = (TypeTemplateParameter) pivotElement.getTemplateParameter();
//		doSwitchAll(Type.class, typeTemplateParameter.getConstrainingType(), eObject.getEBounds());
//		return null;
//	}

	public Object doInPackageSwitch(EObject eObject) {
		int classifierID = eObject.eClass().getClassifierID();
		return doSwitch(classifierID, eObject);
	}

	public <T extends Element> void doSwitchAll(Class<T> pivotClass, Collection<T> pivotElements, List<? extends EObject> eObjects) {
		for (EObject eObject : eObjects) {
			T pivotElement = converter.getCreated(pivotClass, eObject);
			pivotElements.add(pivotElement);
		}
	}

	public org.eclipse.uml2.uml.Property getOtherEnd(List<org.eclipse.uml2.uml.Property> umlMemberEnds, org.eclipse.uml2.uml.Property umlProperty) {
		for (org.eclipse.uml2.uml.Property umlMemberEnd : umlMemberEnds) {
			if (umlMemberEnd != umlProperty) {
				return umlMemberEnd;
			}
		}
		return null;
	}
}