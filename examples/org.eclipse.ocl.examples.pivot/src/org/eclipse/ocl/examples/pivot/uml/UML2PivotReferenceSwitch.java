/**
 * <copyright>
 *
 * Copyright (c) 2011,2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	E.D.Willink - initial API and implementation
 *	E.D.Willink (CEA LIST) - Bug 400744
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.pivot.uml;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Transition;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypedElement;
import org.eclipse.ocl.examples.pivot.Vertex;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.MultiplicityElement;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.util.UMLSwitch;

public class UML2PivotReferenceSwitch extends UMLSwitch<Object>
{				
	protected final @NonNull UML2Pivot converter;
	protected final @NonNull MetaModelManager metaModelManager;
	
	public UML2PivotReferenceSwitch(@NonNull UML2Pivot converter) {
		this.converter = converter;
		this.metaModelManager = converter.getMetaModelManager();
	}
	
//	@Override
//	public Object caseEAnnotation(EAnnotation eObject) {
//		Annotation pivotElement = converter.getCreated(Annotation.class, eObject);
//		doSwitchAll(Element.class, pivotElement.getReference(), eObject.getReferences());
//		return pivotElement;
//	}

	@Override
	public org.eclipse.ocl.examples.pivot.Class caseClass(org.eclipse.uml2.uml.Class umlClass) {
		assert umlClass != null;
		org.eclipse.ocl.examples.pivot.Class pivotElement = converter.getCreated(org.eclipse.ocl.examples.pivot.Class.class, umlClass);
		if (pivotElement != null) {
			doSwitchAll(Type.class, pivotElement.getSuperClass(), umlClass.getSuperClasses());
			if (pivotElement.getSuperClass().isEmpty()) {
				org.eclipse.ocl.examples.pivot.Class oclElementType = metaModelManager.getOclElementType();
				pivotElement.getSuperClass().add(oclElementType);
			}
		}
		return pivotElement;
	}

	@Override
	public Constraint caseConstraint(org.eclipse.uml2.uml.Constraint umlConstraint) {
		assert umlConstraint != null;
		Constraint pivotElement = converter.getCreated(Constraint.class, umlConstraint);
		if (pivotElement != null) {
			doSwitchAll(Element.class, pivotElement.getConstrainedElement(), umlConstraint.getConstrainedElements());
		}
		return pivotElement;
	}

	@Override
	public org.eclipse.ocl.examples.pivot.Class caseInterface(org.eclipse.uml2.uml.Interface umlInterface) {
		assert umlInterface != null;
		org.eclipse.ocl.examples.pivot.Class pivotElement = converter.getCreated(org.eclipse.ocl.examples.pivot.Class.class, umlInterface);
		if (pivotElement != null) {
			List<Generalization> umlGeneralizations = umlInterface.getGeneralizations();
			List<Type> newSuperTypes = new ArrayList<Type>(Math.max(1, umlGeneralizations.size()));
			for (org.eclipse.uml2.uml.Generalization umlGeneralization : umlGeneralizations) {
				org.eclipse.uml2.uml.Classifier umlGeneral = umlGeneralization.getGeneral();
				if (umlGeneral != null) {
					Type pivotGeneral = converter.getCreated(Type.class, umlGeneral);
					if (!newSuperTypes.contains(pivotGeneral)) {
						newSuperTypes.add(pivotGeneral);
					}
				}
			}
			if (newSuperTypes.isEmpty()) {
				org.eclipse.ocl.examples.pivot.Class oclElementType = metaModelManager.getOclElementType();
				newSuperTypes.add(oclElementType);
			}
			PivotUtil.refreshList(pivotElement.getSuperClass(), newSuperTypes);
		}
		return pivotElement;
	}

	@Override
	public Operation caseOperation(org.eclipse.uml2.uml.Operation umlOperation) {
		assert umlOperation != null;
		Operation pivotElement = converter.getCreated(Operation.class, umlOperation);
		if (pivotElement != null) {
			doSwitchAll(Type.class, pivotElement.getRaisedException(), umlOperation.getRaisedExceptions());
			doSwitchAll(Operation.class, pivotElement.getRedefinedOperation(), umlOperation.getRedefinedOperations());
			for (org.eclipse.uml2.uml.Parameter umlParameter : umlOperation.getOwnedParameters()) {
				ParameterDirectionKind direction = umlParameter.getDirection();
				if (direction == ParameterDirectionKind.RETURN_LITERAL) {
					resolveMultiplicity(pivotElement, umlParameter);
				}
			}
		}
		return pivotElement;
	}

	@Override
	public org.eclipse.ocl.examples.pivot.Package casePackage(org.eclipse.uml2.uml.Package umlPackage) {
		assert umlPackage != null;
		org.eclipse.ocl.examples.pivot.Package pivotElement = converter.getCreated(org.eclipse.ocl.examples.pivot.Package.class, umlPackage);
		if (pivotElement != null) {
			doSwitchAll(org.eclipse.ocl.examples.pivot.Package.class, pivotElement.getImportedPackage(), umlPackage.getImportedPackages());
		}
		return pivotElement;
	}

	@Override
	public Property caseProperty(org.eclipse.uml2.uml.Property umlProperty) {
		assert umlProperty != null;
		Property pivotElement = converter.getCreated(Property.class, umlProperty);
		if (pivotElement != null) {
			resolveMultiplicity(pivotElement, umlProperty);
			doSwitchAll(Property.class, pivotElement.getRedefinedProperty(), umlProperty.getRedefinedProperties());
	//		doSwitchAll(Property.class, pivotElement.getSubsettedProperty(), umlProperty.getSubsettedProperties());
		}
		return pivotElement;
	}

	@Override
	public Transition caseTransition(org.eclipse.uml2.uml.Transition umlTransition) {
		assert umlTransition != null;
		Transition pivotElement = converter.getCreated(Transition.class, umlTransition);
		if (pivotElement != null) {
			org.eclipse.uml2.uml.Vertex umlSource = umlTransition.getSource();
			org.eclipse.uml2.uml.Vertex umlTarget = umlTransition.getTarget();
			Vertex pivotSource = umlSource != null ? converter.getCreated(Vertex.class, umlSource) : null;
			Vertex pivotTarget = umlTarget != null ? converter.getCreated(Vertex.class, umlTarget) : null;
			pivotElement.setSource(pivotSource);
			pivotElement.setTarget(pivotTarget);
		}
		return pivotElement;
	}

	@Override
	public EObject caseTypedElement(org.eclipse.uml2.uml.TypedElement umlTypedElement) {
		assert umlTypedElement != null;
		TypedElement pivotElement = converter.getCreated(TypedElement.class, umlTypedElement);
		if (pivotElement != null) {
			resolveMultiplicity(pivotElement, umlTypedElement);
		}
		return pivotElement;
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

	public <T extends Element> void doSwitchAll(@NonNull Class<T> pivotClass, /*@NonNull*/ Collection<T> pivotElements, /*@NonNull*/ List<? extends EObject> eObjects) {
		assert pivotElements != null;
		assert eObjects != null;
		for (EObject eObject : eObjects) {
			if (eObject != null) {
				T pivotElement = converter.getCreated(pivotClass, eObject);
				if (pivotElement == null) {
					Resource eResource = eObject.eResource();
					if (eResource != null) {
						UML2Pivot adapter = UML2Pivot.findAdapter(eResource, metaModelManager);
						if (adapter != null) {
							pivotElement = adapter.getCreated(pivotClass,
								eObject);
						}
					}
				}
				if (pivotElement != null) {
					pivotElements.add(pivotElement);
				}
				else {
					// FIXME log me
				}
			}
		}
	}

	public @Nullable org.eclipse.uml2.uml.Property getOtherEnd(@NonNull List<org.eclipse.uml2.uml.Property> umlMemberEnds, @NonNull org.eclipse.uml2.uml.Property umlProperty) {
		for (org.eclipse.uml2.uml.Property umlMemberEnd : umlMemberEnds) {
			if (umlMemberEnd != umlProperty) {
				return umlMemberEnd;
			}
		}
		return null;
	}

	protected void resolveMultiplicity(@NonNull TypedElement pivotElement, @NonNull org.eclipse.uml2.uml.TypedElement umlTypedElement) {
		boolean isRequired = false;
		org.eclipse.uml2.uml.Type umlType = umlTypedElement.getType();
		if (umlType != null) {
			Type pivotType = converter.resolveType(umlType);
			if ((umlTypedElement instanceof MultiplicityElement) && (pivotType != null)) {
				MultiplicityElement umlMultiplicity = (MultiplicityElement)umlTypedElement;
				int lower = umlMultiplicity.getLower();
				int upper = umlMultiplicity.getUpper();
				if (upper == 1) {
					isRequired = lower == 1;
				}
				else {
					isRequired = true;
					boolean isOrdered = umlMultiplicity.isOrdered();
					boolean isUnique = umlMultiplicity.isUnique();
					IntegerValue lowerValue = ValuesUtil.integerValueOf(lower);
					IntegerValue upperValue = upper == -1 ? ValuesUtil.UNLIMITED_VALUE : ValuesUtil.integerValueOf(upper);
					pivotType = metaModelManager.getCollectionType(isOrdered, isUnique, pivotType, lowerValue, upperValue);
				}
			}
			pivotElement.setType(pivotType);
		}
		else {
			pivotElement.setType(metaModelManager.getOclVoidType());
		}
		pivotElement.setIsRequired(isRequired);
	}
}