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
 *   E.D.Willink - initial API and implementation
 * 	 E.D.Willink (Obeo) - Bug 416287 - tuple-valued constraints
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.pivot.ecore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.common.utils.StringUtils;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.Annotation;
import org.eclipse.ocl.examples.pivot.Class;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.DataType;
import org.eclipse.ocl.examples.pivot.Detail;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Enumeration;
import org.eclipse.ocl.examples.pivot.EnumerationLiteral;
import org.eclipse.ocl.examples.pivot.Import;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.Namespace;
import org.eclipse.ocl.examples.pivot.OpaqueExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Package;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.PivotConstants;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypeTemplateParameter;
import org.eclipse.ocl.examples.pivot.TypedMultiplicityElement;
import org.eclipse.ocl.examples.pivot.delegate.DelegateInstaller;
import org.eclipse.ocl.examples.pivot.manager.Orphanage;
import org.eclipse.ocl.examples.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.examples.pivot.util.Visitable;

public class Pivot2EcoreDeclarationVisitor
	extends AbstractExtendingVisitor<Object, Pivot2Ecore>
{
	protected final @NonNull DelegateInstaller delegateInstaller;
	
	public Pivot2EcoreDeclarationVisitor(@NonNull Pivot2Ecore context) {
		super(context);
		this.delegateInstaller = context.getDelegateInstaller();
	}

	protected void copyClassifier(@NonNull EClassifier eClassifier, @NonNull Type pivotType) {
		copyNamedElement(eClassifier, pivotType);
		copyTemplateSignature(eClassifier.getETypeParameters(), pivotType);
		safeVisitAll(eClassifier.getEAnnotations(), pivotType.getOwnedAnnotation());
		if (pivotType.eIsSet(PivotPackage.Literals.TYPE__INSTANCE_CLASS_NAME)) {
			eClassifier.setInstanceClassName(pivotType.getInstanceClassName());
		}
		else {
			eClassifier.eUnset(EcorePackage.Literals.ECLASSIFIER__INSTANCE_CLASS_NAME);
		}
//		visitAll(eClassifier.getETypeParameters(), pivotType.getTypeParameters());
		for (Constraint pivotInvariant : pivotType.getOwnedInvariant()) {
			if (!pivotInvariant.isCallable()) {
				safeVisit(pivotInvariant);		// Results are inserted directly
			}
		}
		delegateInstaller.installDelegates(eClassifier, pivotType);
	}


	protected void copyDataTypeOrEnum(@NonNull EDataType eDataType, @NonNull DataType pivotDataType) {
		copyClassifier(eDataType, pivotDataType);
		eDataType.setSerializable(pivotDataType.isSerializable());
	}

	protected void copyDetails(@NonNull EAnnotation eAnnotation, @NonNull Annotation pivotAnnotation) {
		copyModelElement(eAnnotation, pivotAnnotation);
		safeVisitAll(eAnnotation.getEAnnotations(), pivotAnnotation.getOwnedAnnotation());
		for (Detail pivotDetail : pivotAnnotation.getOwnedDetail()) {
			String name = pivotDetail.getName();
			String value = StringUtils.splice(pivotDetail.getValue(), "");
			eAnnotation.getDetails().put(name, value);
		}
	}

	protected void copyModelElement(@NonNull EModelElement eModelElement, @NonNull Element pivotModelElement) {
		context.putCreated(pivotModelElement, eModelElement);
		Pivot2Ecore.copyComments(eModelElement, pivotModelElement);
	}

	protected void copyNamedElement(@NonNull ENamedElement eNamedElement, @NonNull NamedElement pivotNamedElement) {
		copyModelElement(eNamedElement, pivotNamedElement);
		eNamedElement.setName(pivotNamedElement.getName());
	}

	protected void copyTemplateSignature(List<ETypeParameter> eTypeParameters, TemplateableElement pivotElement) {
		TemplateSignature templateSignature = pivotElement.getOwnedTemplateSignature();
		if (templateSignature != null) {
			List<TemplateParameter> parameters = templateSignature.getParameter();
			safeVisitAll(eTypeParameters, parameters);
		}
	}

	protected void copyTypedElement(@NonNull ETypedElement eTypedElement, @NonNull TypedMultiplicityElement pivotTypedElement) {
		copyNamedElement(eTypedElement, pivotTypedElement);
		safeVisitAll(eTypedElement.getEAnnotations(), pivotTypedElement.getOwnedAnnotation());
		context.defer(pivotTypedElement);		// Defer type/multiplicity setting
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

	public EObject visiting(@NonNull Visitable visitable) {
		throw new IllegalArgumentException("Unsupported " + visitable.eClass().getName() + " for Pivot2Ecore Declaration pass");
	}

	@Override
	public EObject visitAnnotation(@NonNull Annotation pivotAnnotation) {
		@SuppressWarnings("null")
		@NonNull EAnnotation eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
		copyDetails(eAnnotation, pivotAnnotation);
		eAnnotation.setSource(pivotAnnotation.getName());
		safeVisitAll(eAnnotation.getContents(), pivotAnnotation.getOwnedContent());
		if (!pivotAnnotation.getReference().isEmpty()) {
			context.defer(pivotAnnotation);
		}
		return eAnnotation;
	}

	@Override
	public EObject visitClass(@NonNull Class pivotClass) {
		if (pivotClass.getTemplateBinding().size() > 0) {
			return null;
		}
		@SuppressWarnings("null")
		@NonNull EClass eClass = EcoreFactory.eINSTANCE.createEClass();
		copyClassifier(eClass, pivotClass);
		eClass.setAbstract(pivotClass.isAbstract());
		eClass.setInterface(pivotClass.isInterface());
		context.defer(pivotClass);		// Defer superclass resolution
		safeVisitAll(eClass.getEOperations(), pivotClass.getOwnedOperation());
		safeVisitAll(eClass.getEStructuralFeatures(), pivotClass.getOwnedAttribute());
		for (Constraint pivotInvariant : pivotClass.getOwnedInvariant()) {
			if (pivotInvariant.isCallable()) {
				EOperation eOperation = Pivot2Ecore.createConstraintEOperation(pivotInvariant, pivotInvariant.getName(), context.isAddInvariantComments());
				eClass.getEOperations().add(eOperation);
				context.putCreated(pivotInvariant, eOperation);
				copyConstraint(eOperation, pivotInvariant);
			}
		}
		return eClass;
	}

	@Override
	public EObject visitConstraint(@NonNull Constraint pivotConstraint) {
		Element eContainer = (Element)pivotConstraint.eContainer();
		if (eContainer != null) {
			EModelElement eModelElement = context.getCreated(EModelElement.class, eContainer);
			if (eModelElement != null) {
				copyConstraint(eModelElement, pivotConstraint);
				return null;
			}
		}
		return null;
	}

	protected @Nullable EAnnotation copyConstraint(@NonNull EModelElement eModelElement, @NonNull Constraint pivotConstraint) {
		EAnnotation eAnnotation = delegateInstaller.createConstraintDelegate(eModelElement, pivotConstraint, context.getEcoreURI());
		if (eAnnotation != null) {
			if (eModelElement instanceof EOperation) {
				Pivot2Ecore.copyAnnotationComments(eAnnotation, pivotConstraint);
			}
			else {
				Pivot2Ecore.copyComments(eAnnotation, pivotConstraint);
			}
		}
		return eAnnotation;
	}

	@Override
	public EObject visitDataType(@NonNull DataType pivotDataType) {
		if (pivotDataType.getTemplateBinding().size() > 0) {
			return null;
		}
		@SuppressWarnings("null")
		@NonNull EDataType eDataType = EcoreFactory.eINSTANCE.createEDataType();
		copyDataTypeOrEnum(eDataType, pivotDataType);
		return eDataType;
	}

	@Override
	public EObject visitEnumeration(@NonNull Enumeration pivotEnumeration) {
		if (pivotEnumeration.getTemplateBinding().size() > 0) {
			return null;
		}
		@SuppressWarnings("null")
		@NonNull EEnum eEnum = EcoreFactory.eINSTANCE.createEEnum();
		copyDataTypeOrEnum(eEnum, pivotEnumeration);
		safeVisitAll(eEnum.getELiterals(), pivotEnumeration.getOwnedLiteral());
		return eEnum;
	}

	@Override
	public EObject visitEnumerationLiteral(@NonNull EnumerationLiteral pivotEnumLiteral) {
		@SuppressWarnings("null")
		@NonNull EEnumLiteral eEnumLiteral = EcoreFactory.eINSTANCE.createEEnumLiteral();
		copyNamedElement(eEnumLiteral, pivotEnumLiteral);
		if (pivotEnumLiteral.eIsSet(PivotPackage.Literals.ENUMERATION_LITERAL__VALUE)) {
			eEnumLiteral.setValue(pivotEnumLiteral.getValue().intValue());
		}
		else {
			eEnumLiteral.eUnset(EcorePackage.Literals.EENUM_LITERAL__VALUE);
		}
		return eEnumLiteral;
	}

	@Override
	public EObject visitOperation(@NonNull Operation pivotOperation) {
		if (pivotOperation.getTemplateBinding().size() > 0) {
			return null;
		}
		@SuppressWarnings("null")
		@NonNull EOperation eOperation = EcoreFactory.eINSTANCE.createEOperation();
		copyTypedElement(eOperation, pivotOperation);
		copyTemplateSignature(eOperation.getETypeParameters(), pivotOperation);
		safeVisitAll(eOperation.getEParameters(), pivotOperation.getOwnedParameter());
//		safeVisitAll(eOperation.getEGenericExceptions(), pivotOperation.getRaisedException());
		OpaqueExpression bodyExpression = pivotOperation.getBodyExpression();
		if (bodyExpression != null) {
			EAnnotation eBodyConstraint = delegateInstaller.createOperationDelegate(eOperation, bodyExpression, context.getEcoreURI());
			if (eBodyConstraint != null) {
//				Pivot2Ecore.copyComments(eBodyConstraint, bodyExpression);
			}
		}
		for (Constraint pivotConstraint : pivotOperation.getPrecondition()) {
			safeVisit(pivotConstraint);		// Results are inserted directly
		}
		for (Constraint pivotConstraint : pivotOperation.getPostcondition()) {
			safeVisit(pivotConstraint);		// Results are inserted directly
		}
		return eOperation;
	}

	@Override
	public EObject visitPackage(@NonNull Package pivotPackage) {
		@SuppressWarnings("null")
		@NonNull EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
		copyNamedElement(ePackage, pivotPackage);
		safeVisitAll(ePackage.getEAnnotations(), pivotPackage.getOwnedAnnotation());
		context.defer(pivotPackage);		// Defer delegate annotation analysis
		if (pivotPackage.eIsSet(PivotPackage.Literals.PACKAGE__NS_PREFIX)) {
			ePackage.setNsPrefix(pivotPackage.getNsPrefix());
		}
		if (pivotPackage.eIsSet(PivotPackage.Literals.PACKAGE__NS_URI)) {
			ePackage.setNsURI(pivotPackage.getNsURI());
		}
		safeVisitAll(ePackage.getESubpackages(), pivotPackage.getNestedPackage());
		safeVisitAll(ePackage.getEClassifiers(), pivotPackage.getOwnedType());
		return ePackage;
	}

	@Override
	public EObject visitParameter(@NonNull Parameter pivotParameter) {
		@SuppressWarnings("null")
		@NonNull EParameter eParameter = EcoreFactory.eINSTANCE.createEParameter();
		copyTypedElement(eParameter, pivotParameter);
		return eParameter;
	}

	@Override
	public EObject visitProperty(@NonNull Property pivotProperty) {
		if (pivotProperty.isImplicit()) {
			return null;
		}
		EStructuralFeature eStructuralFeature;
		Type type = pivotProperty.getType();
		CollectionType ecoreCollectionType = context.isEcoreCollection(type);
		if (ecoreCollectionType != null) {
			type = ecoreCollectionType.getElementType();
		}
		if (type instanceof DataType) {
			EAttribute eAttribute = EcoreFactory.eINSTANCE.createEAttribute();
			eAttribute.setID(pivotProperty.isID());
			eStructuralFeature = eAttribute;
		}
		else {
			EReference eReference = EcoreFactory.eINSTANCE.createEReference();
			if ((pivotProperty.getOpposite() != null) || !pivotProperty.getKeys().isEmpty()) {
				context.defer(pivotProperty);
			}
			eReference.setContainment(pivotProperty.isComposite());
			eReference.setResolveProxies(pivotProperty.isResolveProxies());
			eStructuralFeature = eReference;
		}
		copyTypedElement(eStructuralFeature, pivotProperty);
		eStructuralFeature.setChangeable(!pivotProperty.isReadOnly());
		eStructuralFeature.setDerived(pivotProperty.isDerived());
		eStructuralFeature.setTransient(pivotProperty.isTransient());
		eStructuralFeature.setUnsettable(pivotProperty.isUnsettable());
		eStructuralFeature.setVolatile(pivotProperty.isVolatile());
		if (pivotProperty.eIsSet(PivotPackage.Literals.PROPERTY__DEFAULT)) {
			eStructuralFeature.setDefaultValueLiteral(pivotProperty.getDefault());
		}
		else {
			eStructuralFeature.eUnset(EcorePackage.Literals.ESTRUCTURAL_FEATURE__DEFAULT_VALUE_LITERAL);
		}
		OpaqueExpression defaultExpression = pivotProperty.getDefaultExpression();
		if (defaultExpression != null) {
			delegateInstaller.createPropertyDelegate(eStructuralFeature, defaultExpression, context.getEcoreURI());
		}
		return eStructuralFeature;
	}

	@Override
	public Object visitRoot(@NonNull Root pivotRoot) {
		EModelElement firstElement = null;
		List<EObject> outputObjects = new ArrayList<EObject>();
		for (org.eclipse.ocl.examples.pivot.Package pivotObject : pivotRoot.getNestedPackage()) {
			if (!Orphanage.isTypeOrphanage(pivotObject)) {
				Object ecoreObject = safeVisit(pivotObject);
				if (ecoreObject instanceof EObject) {
					outputObjects.add((EObject) ecoreObject);
					if ((firstElement == null) && (ecoreObject instanceof EModelElement)) {
						firstElement = (EModelElement) ecoreObject;
					}
				}
			}
		}
		List<Import> imports = pivotRoot.getImports();
		if (imports.size() > 0) {
			if (imports.size() > 0) {
				imports = new ArrayList<Import>(imports);
				Collections.sort(imports, new Comparator<Import>()
						{
						public int compare(Import o1, Import o2) {
							String n1 = o1.getName();
							String n2 = o2.getName();
							if (n1 == null) n1 = "";
							if (n2 == null) n1 = "";
							return n1.compareTo(n2);
						}
					}
				);
			}
			EAnnotation importAnnotation = null;
			URI ecoreURI = context.getEcoreURI();
			for (Import anImport : imports) {
				Namespace importedNamespace = anImport.getImportedNamespace();
				if (importedNamespace != null) {
					if (importAnnotation == null) {
						importAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
						importAnnotation.setSource(PivotConstants.IMPORT_ANNOTATION_SOURCE);
					}
					EObject eTarget = importedNamespace.getETarget();
					if (eTarget != null) {
						URI uri = null;
						if ((eTarget instanceof EPackage) && DomainUtil.isRegistered(eTarget.eResource())) {
	 						String nsURI = ((EPackage)eTarget).getNsURI();
							if (nsURI != null) {
								uri = URI.createURI(nsURI);
							}
						}
						if (uri == null) {
							uri = EcoreUtil.getURI(eTarget);
						}
						URI uri2 = uri.deresolve(ecoreURI, true, true, true);
						importAnnotation.getDetails().put(anImport.getName(), uri2.toString());
					}
					else if (importedNamespace instanceof org.eclipse.ocl.examples.pivot.Package) {
						importAnnotation.getDetails().put(anImport.getName(), ((org.eclipse.ocl.examples.pivot.Package)importedNamespace).getNsURI());
					}
					else {
						importAnnotation.getDetails().put(anImport.getName(), importedNamespace.toString());
					}
				}
			}
			if ((firstElement != null) && (importAnnotation != null)) {
				firstElement.getEAnnotations().add(importAnnotation);
			}
		}
		return outputObjects;
	}

	@Override
	public EObject visitTypeTemplateParameter(@NonNull TypeTemplateParameter pivotTypeTemplateParameter) {
		ETypeParameter eTypeParameter = EcoreFactory.eINSTANCE.createETypeParameter();
		eTypeParameter.setName(((Type) pivotTypeTemplateParameter.getParameteredElement()).getName());
		context.putCreated(pivotTypeTemplateParameter, eTypeParameter);
		if (!pivotTypeTemplateParameter.getConstrainingType().isEmpty()) {
			context.defer(pivotTypeTemplateParameter);
		}
		return eTypeParameter;
	}
}
