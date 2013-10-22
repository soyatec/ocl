/**
 * <copyright>
 *
 * Copyright (c) 2010, 2013 E.D.Willink and others.
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
 * $Id: Pivot2EcoreReferenceVisitor.java,v 1.5 2011/04/27 06:19:59 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.ecore;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.pivot.Annotation;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.DataType;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.PivotConstants;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypeTemplateParameter;
import org.eclipse.ocl.examples.pivot.TypedElement;
import org.eclipse.ocl.examples.pivot.TypedMultiplicityElement;
import org.eclipse.ocl.examples.pivot.VoidType;
import org.eclipse.ocl.examples.pivot.delegate.DelegateInstaller;
import org.eclipse.ocl.examples.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.examples.pivot.util.Visitable;
import org.eclipse.ocl.examples.pivot.utilities.PivotObjectImpl;

public class Pivot2EcoreReferenceVisitor
	extends AbstractExtendingVisitor<EObject, Pivot2Ecore>
{
	private static final Logger logger = Logger.getLogger(Pivot2EcoreReferenceVisitor.class);

	protected final @NonNull Pivot2EcoreTypeRefVisitor typeRefVisitor;
	
	public Pivot2EcoreReferenceVisitor(@NonNull Pivot2Ecore context) {
		super(context);
		typeRefVisitor = new Pivot2EcoreTypeRefVisitor(context);
	}

	public <T extends EObject> void safeVisitAll(List<T> eObjects, List<? extends Element> pivotObjects) {
		for (Element pivotObject : pivotObjects) {
			@SuppressWarnings("unchecked")
			T eObject = (T) safeVisit(pivotObject);
			if (eObject != null) {
				eObjects.add(eObject);
			}
			// else error
		}
	}

	public <T extends EClassifier> void safeVisitAll(Class<?> javaClass, List<EGenericType> eGenericTypes, List<T> eTypes, List<? extends Type> asTypes) {
		if (asTypes.size() > 0) {
			List<EObject> eClasses = new ArrayList<EObject>(asTypes.size());
			typeRefVisitor.safeVisitAll(eClasses, asTypes);
			eTypes.clear();
			eGenericTypes.clear();
			for (EObject superEClass : eClasses) {
				if (superEClass instanceof EGenericType) {
					eGenericTypes.add((EGenericType)superEClass);
				}
				else if (javaClass.isAssignableFrom(superEClass.getClass())){
					@SuppressWarnings("unchecked") T castSuperEClass = (T)superEClass;
					eTypes.add(castSuperEClass);
				}
			}
		}
		else {
			eGenericTypes.clear();
		}
	}

	public EObject visiting(@NonNull Visitable visitable) {
		throw new IllegalArgumentException("Unsupported " + visitable.eClass().getName() + " for Pivot2Ecore Reference pass");
	}

	@Override
	public EObject visitAnnotation(@NonNull Annotation pivotAnnotation) {
		EAnnotation eAnnotation = context.getCreated(EAnnotation.class, pivotAnnotation);
		eAnnotation.getReferences().clear();
		for (Element pivotReference : pivotAnnotation.getReference()) {
			if (pivotReference != null) {
				EObject target = context.getCreated(EObject.class, pivotReference);
				if ((target == null) && (pivotReference instanceof PivotObjectImpl)) {
					target = ((PivotObjectImpl)pivotReference).getTarget();
				}
				if (target != null) {
					eAnnotation.getReferences().add(target);
				}
			}
		}
		return eAnnotation;
	}

	@Override
	public EObject visitClass(@NonNull org.eclipse.ocl.examples.pivot.Class pivotClass) {
		EClass eClass = context.getCreated(EClass.class, pivotClass);
		safeVisitAll(EClass.class, eClass.getEGenericSuperTypes(), eClass.getESuperTypes(), pivotClass.getSuperClass());
		return eClass;
	}

	@Override
	public EObject visitDataType(@NonNull DataType pivotDataType) {
		EDataType eDataType = context.getCreated(EDataType.class, pivotDataType);
		return eDataType;
	}

	@Override
	public EObject visitOperation(@NonNull Operation pivotOperation) {
		EOperation eOperation = context.getCreated(EOperation.class, pivotOperation);
		safeVisitAll(EClassifier.class, eOperation.getEGenericExceptions(), eOperation.getEExceptions(), pivotOperation.getRaisedException());
		return super.visitOperation(pivotOperation);
	}

	@Override
	public EObject visitPackage(@NonNull org.eclipse.ocl.examples.pivot.Package pivotPackage) {
		EPackage ePackage = context.getCreated(EPackage.class, pivotPackage);
		if (ePackage == null) {
			return null;
		}
		boolean needsDelegates = DelegateInstaller.needsDelegates(ePackage);
		if (needsDelegates) {
			context.getDelegateInstaller().installDelegates(ePackage);
		}
		if (context.isPivot(pivotPackage)) {
			EAnnotation eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			eAnnotation.setSource(PivotConstants.AS_METAMODEL_ANNOTATION_SOURCE);
			ePackage.getEAnnotations().add(eAnnotation);
		}
		return null;
	}

	@Override
	public EObject visitProperty(@NonNull Property pivotProperty) {
		if (pivotProperty.isImplicit()) {
			return null;
		}
		EStructuralFeature eStructuralFeature = context.getCreated(EStructuralFeature.class, pivotProperty);
		if (eStructuralFeature instanceof EReference) {
			EReference eReference = (EReference) eStructuralFeature;
			Property pivotOpposite = pivotProperty.getOpposite();
			if (pivotOpposite != null) {
				if (pivotOpposite.isImplicit()) {
					// FIXME Use EAnnotations for non-navigable opposites as identified by an Association
				}
				else {
					EReference eOpposite = context.getCreated(EReference.class, pivotOpposite);
					if (eOpposite != null) {
						eReference.setEOpposite(eOpposite);
					}
				}
			}
			for (Property pivotKey : pivotProperty.getKeys()) {
				if (pivotKey != null) {
					EAttribute eAttribute = context.getCreated(EAttribute.class, pivotKey);
					if (eAttribute != null) {
						eReference.getEKeys().add(eAttribute);
					}
				}
			}
		}
		return super.visitProperty(pivotProperty);
	}

	@Override
	public EObject visitTypeTemplateParameter(@NonNull TypeTemplateParameter pivotTypeTemplateParameter) {
		ETypeParameter eTypeParameter = context.getCreated(ETypeParameter.class, pivotTypeTemplateParameter);
		for (Type constrainingType : pivotTypeTemplateParameter.getConstrainingType()) {
			EGenericType eGenericType = typeRefVisitor.resolveEGenericType(constrainingType);
			eTypeParameter.getEBounds().add(eGenericType);
		}
		return null;
	}

	@Override
	public EObject visitTypedElement(@NonNull TypedElement pivotTypedElement) {
		ETypedElement eTypedElement = context.getCreated(ETypedElement.class, pivotTypedElement);
		Type pivotType = pivotTypedElement.getType();
		if (pivotType == null) {
			return null;				// Occurs for Operation return type
		}
		EObject eObject = typeRefVisitor.safeVisit(pivotType);
		if (eObject instanceof EGenericType) {
			eTypedElement.setEGenericType((EGenericType)eObject);
		}
		else if (eObject instanceof EClassifier) {
			eTypedElement.setEType((EClassifier)eObject);
		}
		else if (eObject instanceof ETypeParameter) {
			EGenericType eGenericType = EcoreFactory.eINSTANCE.createEGenericType();
			eGenericType.setETypeParameter((ETypeParameter)eObject);
			eTypedElement.setEGenericType(eGenericType);
		}
		else {
			@SuppressWarnings("unused")
			EObject eObject2 = typeRefVisitor.safeVisit(pivotType);
//			throw new IllegalArgumentException("Unsupported pivot type '" + pivotType + "' in Pivot2Ecore Reference pass");
		}
		return null;
	}

	@Override
	public EObject visitTypedMultiplicityElement(@NonNull TypedMultiplicityElement pivotTypedElement) {
		ETypedElement eTypedElement = context.getCreated(ETypedElement.class, pivotTypedElement);
		Type pivotType = pivotTypedElement.getType();
		if ((pivotType == null) || (pivotType instanceof VoidType)) {				// Occurs for Operation return type
			eTypedElement.setLowerBound(0);
			eTypedElement.setUpperBound(1);
			eTypedElement.setOrdered(true);
			eTypedElement.setUnique(true);
			return null;
		}
		else if (pivotType instanceof CollectionType) {
			CollectionType collectionType = (CollectionType)pivotType;
			Type elementType = collectionType.getElementType();
			EObject eObject = typeRefVisitor.safeVisit(elementType);
			if (eObject instanceof EGenericType) {
				eTypedElement.setEGenericType((EGenericType)eObject);
			}
			else {
				eTypedElement.setEType((EClassifier)eObject);
			}
			eTypedElement.setOrdered(collectionType.isOrdered());
			eTypedElement.setUnique(collectionType.isUnique());
			IntegerValue lower = collectionType.getLowerValue();
			IntegerValue upper = collectionType.getUpperValue();
			try {
				eTypedElement.setLowerBound(lower.intValue());
			} catch (InvalidValueException e) {
				logger.error("Illegal lower bound", e);
			}
			try {
				eTypedElement.setUpperBound(upper.isUnlimited() ? -1 : upper.intValue());
			} catch (InvalidValueException e) {
				logger.error("Illegal upper bound", e);
			}
			return null;
		}
		else {
			if (pivotTypedElement.isRequired()) {
				eTypedElement.setLowerBound(1);
				eTypedElement.setUpperBound(1);
			}
			else {
				eTypedElement.setLowerBound(0);
				eTypedElement.setUpperBound(1);
			}
			eTypedElement.setUnique(true);
			eTypedElement.setOrdered(true);		// Ecore default
			return visitTypedElement(pivotTypedElement);
		}
	}
	
/*	@Override
	public Object caseEAnnotation(EAnnotation eAnnotation) {
		AnnotationCS csAnnotation = (AnnotationCS) deferMap.get(eAnnotation);
		for (ModelElementCSRef csReference : csAnnotation.getReferences()) {
			EObject eObject = createMap.get(csReference.getRef());
			if (eObject != null) {
				eAnnotation.getReferences().add(eObject);
			}
		}
		return null;
	} */

/*	@Override
	public Object caseEGenericType(EGenericType eGenericType) {
		TypedTypeRefCS csTypeRef = (TypedTypeRefCS) deferMap.get(eGenericType);
		TypeCS typeRef = csTypeRef.getType();
		if (typeRef != null) {
			EModelElement eType = (EModelElement) createMap.get(typeRef);
			if (eType == null) {
				eGenericType.setEClassifier((EClassifier) ((ModelElementCS)typeRef).getOriginalObject());
			}
			else if (eType instanceof EClassifier) {
				eGenericType.setEClassifier((EClassifier) eType);
			}
			else if (eType instanceof ETypeParameter) {
				eGenericType.setETypeParameter((ETypeParameter) eType);
			}
		}
		return null;
	} */

/*	@Override
	public Object caseEReference(EReference eReference) {
		OCLinEcoreReferenceCS csReference = (OCLinEcoreReferenceCS) deferMap.get(eReference);
		ReferenceCSRef csOpposite = csReference.getOpposite();
		if (csOpposite != null) {
			EReference eOpposite = (EReference) createMap.get(csOpposite.getRef());
			if (eOpposite != null) {
				eReference.setEOpposite(eOpposite);
			}
		}
		for (AttributeCSRef csKey : csReference.getKeys()) {
			EAttribute eAttribute = (EAttribute) createMap.get(csKey.getRef());
			if (eAttribute != null) {
				eReference.getEKeys().add(eAttribute);
			}
		}
		return null;
	} */

//	@Override
//	public Object caseETypeParameter(ETypeParameter eTypeParameter) {
//		TypeParameterCS csTypeParameter = (TypeParameterCS) deferMap.get(eTypeParameter);
/*			ClassifierRef classifierRef = csTypedElement.getType();
		if (classifierRef != null) {
			EClassifier eClassifier = resolveClassifierRef(classifierRef);
			if (eClassifier != null) {
				eTypedElement.setEType(eClassifier);
			}
		} */
//		return null;
//	}
	
}