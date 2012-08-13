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

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypedElement;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.MultiplicityElement;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.util.UMLSwitch;

public class UML2PivotReferenceSwitch extends UMLSwitch<Object>
{				
	protected final UML2Pivot converter;
	protected final MetaModelManager metaModelManager;
	
	public UML2PivotReferenceSwitch(UML2Pivot converter) {
		this.converter = converter;
		this.metaModelManager = converter.getMetaModelManager();
	}
	
//	@Override
//	public Object caseEAnnotation(EAnnotation eObject) {
//		Annotation pivotElement = converter.getCreated(Annotation.class, eObject);
//		doSwitchAll(Element.class, pivotElement.getReference(), eObject.getReferences());
//		return null;
//	}

	@Override
	public org.eclipse.ocl.examples.pivot.Class caseClass(org.eclipse.uml2.uml.Class umlClass) {
		@SuppressWarnings("null") @NonNull org.eclipse.uml2.uml.Class umlClass2 = umlClass;
		org.eclipse.ocl.examples.pivot.Class pivotElement = converter.getCreated(org.eclipse.ocl.examples.pivot.Class.class, umlClass2);
		if (pivotElement != null) {
			doSwitchAll(Type.class, pivotElement.getSuperClass(), umlClass2.getSuperClasses());
			if (pivotElement.getSuperClass().isEmpty()) {
				org.eclipse.ocl.examples.pivot.Class oclElementType = metaModelManager.getOclElementType();
				pivotElement.getSuperClass().add(oclElementType);
			}
		}
		return null;
	}

	@Override
	public Constraint caseConstraint(org.eclipse.uml2.uml.Constraint umlConstraint) {
		@SuppressWarnings("null") @NonNull org.eclipse.uml2.uml.Constraint umlConstraint2 = umlConstraint;
		Constraint pivotElement = converter.getCreated(Constraint.class, umlConstraint2);
		if (pivotElement != null) {
			doSwitchAll(Element.class, pivotElement.getConstrainedElement(), umlConstraint2.getConstrainedElements());
		}
		return null;
	}

	@Override
	public org.eclipse.ocl.examples.pivot.Class caseInterface(org.eclipse.uml2.uml.Interface umlInterface) {
		@SuppressWarnings("null") @NonNull Interface umlInterface2 = umlInterface;
		org.eclipse.ocl.examples.pivot.Class pivotElement = converter.getCreated(org.eclipse.ocl.examples.pivot.Class.class, umlInterface2);
		if (pivotElement != null) {
			List<Generalization> umlGeneralizations = umlInterface2.getGeneralizations();
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
		return null;
	}

	@Override
	public Operation caseOperation(org.eclipse.uml2.uml.Operation umlOperation) {
		@SuppressWarnings("null") @NonNull org.eclipse.uml2.uml.Operation umlOperation2 = umlOperation;
		Operation pivotElement = converter.getCreated(Operation.class, umlOperation2);
		if (pivotElement != null) {
			doSwitchAll(Type.class, pivotElement.getRaisedException(), umlOperation2.getRaisedExceptions());
			doSwitchAll(Operation.class, pivotElement.getRedefinedOperation(), umlOperation2.getRedefinedOperations());
			for (org.eclipse.uml2.uml.Parameter umlParameter : umlOperation2.getOwnedParameters()) {
				ParameterDirectionKind direction = umlParameter.getDirection();
				if (direction == ParameterDirectionKind.RETURN_LITERAL) {
					org.eclipse.uml2.uml.Type umlType = umlParameter.getType();
					if (umlType != null) {
						Type pivotType = converter.resolveType(umlType);
						pivotElement.setType(pivotType);
						converter.copyMultiplicityElement(pivotElement, umlParameter);
					}
					else {
						pivotElement.setType(metaModelManager.getOclVoidType());
					}
				}
			}
		}
		return null;
	}

	@Override
	public org.eclipse.ocl.examples.pivot.Package casePackage(org.eclipse.uml2.uml.Package umlPackage) {
		@SuppressWarnings("null") @NonNull org.eclipse.uml2.uml.Package umlPackage2 = umlPackage;
		org.eclipse.ocl.examples.pivot.Package pivotElement = converter.getCreated(org.eclipse.ocl.examples.pivot.Package.class, umlPackage2);
		if (pivotElement != null) {
			doSwitchAll(org.eclipse.ocl.examples.pivot.Package.class, pivotElement.getImportedPackage(), umlPackage2.getImportedPackages());
		}
		return null;
	}

	@Override
	public Property caseProperty(org.eclipse.uml2.uml.Property umlProperty) {
		@SuppressWarnings("null") @NonNull org.eclipse.uml2.uml.Property umlProperty2 = umlProperty;
		Property pivotElement = converter.getCreated(Property.class, umlProperty2);
		if (pivotElement != null) {
			org.eclipse.uml2.uml.Type umlType = umlProperty2.getType();
			if (umlType != null) {
				Type pivotType = converter.resolveType(umlType);
				pivotElement.setType(pivotType);
			}
			doSwitchAll(Property.class, pivotElement.getRedefinedProperty(), umlProperty2.getRedefinedProperties());
	//		doSwitchAll(Property.class, pivotElement.getSubsettedProperty(), umlProperty.getSubsettedProperties());
		}
		return null;
	}

	@Override
	public EObject caseTypedElement(org.eclipse.uml2.uml.TypedElement umlTypedElement) {
		@SuppressWarnings("null") @NonNull org.eclipse.uml2.uml.TypedElement umlTypedElement2 = umlTypedElement;
		TypedElement pivotElement = converter.getCreated(TypedElement.class, umlTypedElement2);
		if (pivotElement != null) {
			org.eclipse.uml2.uml.Type umlType = umlTypedElement2.getType();
			if (umlType != null) {
				Type pivotType = converter.resolveType(umlType);
				if ((umlType instanceof MultiplicityElement) && (pivotType != null)) {
					MultiplicityElement umlMultiplicity = (MultiplicityElement)umlType;
					long upper = umlMultiplicity.getUpper();
					if (upper != 1) {
						long lower = umlMultiplicity.getLower();
						boolean isOrdered = umlMultiplicity.isOrdered();
						boolean isUnique = umlMultiplicity.isUnique();
						pivotType = metaModelManager.getCollectionType(isOrdered, isUnique, pivotType, BigInteger.valueOf(lower), BigInteger.valueOf(upper));
					}
				}
				pivotElement.setType(pivotType);
			}
			else {
				pivotElement.setType(metaModelManager.getOclVoidType());
			}
		}
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

	public <T extends Element> void doSwitchAll(@NonNull Class<T> pivotClass, /*@NonNull*/ Collection<T> pivotElements, /*@NonNull*/ List<? extends EObject> eObjects) {
		assert pivotElements != null;
		assert eObjects != null;
		for (EObject eObject : eObjects) {
			if (eObject != null) {
				T pivotElement = converter.getCreated(pivotClass, eObject);
				pivotElements.add(pivotElement);
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
}