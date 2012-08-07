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
 * $Id: UML2PivotDeclarationSwitch.java,v 1.9 2011/05/02 15:38:54 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.uml;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.common.OCLCommon;
import org.eclipse.ocl.examples.pivot.Annotation;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.DataType;
import org.eclipse.ocl.examples.pivot.DynamicElement;
import org.eclipse.ocl.examples.pivot.DynamicType;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Enumeration;
import org.eclipse.ocl.examples.pivot.EnumerationLiteral;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.Namespace;
import org.eclipse.ocl.examples.pivot.OpaqueExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.PivotConstants;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.PrimitiveType;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypeTemplateParameter;
import org.eclipse.ocl.examples.pivot.TypedMultiplicityElement;
import org.eclipse.ocl.examples.pivot.UMLReflection;
import org.eclipse.ocl.examples.pivot.ValueSpecification;
import org.eclipse.ocl.examples.pivot.delegate.SettingBehavior;
import org.eclipse.ocl.examples.pivot.ecore.Ecore2PivotDeclarationSwitch;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.TypeServer;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.ClassifierTemplateParameter;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLSwitch;

public class UML2PivotDeclarationSwitch extends UMLSwitch<Object>
{
	protected final Ecore2PivotDeclarationSwitch ecoreSwitch;
	protected final UML2Pivot converter;
	protected final MetaModelManager metaModelManager;
	
	public UML2PivotDeclarationSwitch(UML2Pivot converter) {
		this.converter = converter;
		this.ecoreSwitch = new Ecore2PivotDeclarationSwitch(converter);
		this.metaModelManager = converter.getMetaModelManager();
	}
	
	@Override
	public Object caseAssociation(org.eclipse.uml2.uml.Association umlAssociation) {
		@SuppressWarnings("null") @NonNull Association umlAssociation2 = umlAssociation;
		@SuppressWarnings("null") @NonNull List<org.eclipse.uml2.uml.Property> memberEnds = umlAssociation2.getMemberEnds();
		converter.addProperties(memberEnds, null);
		Property firstPivotElement = null;
		for (org.eclipse.uml2.uml.Property umlProperty : memberEnds) {
			Property pivotElement = (Property) doSwitch(umlProperty);
//			converter.copyProperty(pivotElement, umlProperty, null);
//			pivotElement.setImplicit(umlProperty.getAssociation() != null);
//			converter.queueReference(umlAssociation);				// For opposite installation
			if (firstPivotElement == null) {
				firstPivotElement = pivotElement;
			}
			else {
				firstPivotElement.setOpposite(pivotElement);
				pivotElement.setOpposite(firstPivotElement);
			}
		}
		return this;
	}

	@Override
	public org.eclipse.ocl.examples.pivot.Class caseClass(org.eclipse.uml2.uml.Class umlClass) {
		@SuppressWarnings("null") @NonNull org.eclipse.uml2.uml.Class umlClass2 = umlClass;
		org.eclipse.ocl.examples.pivot.Class pivotElement = converter.refreshNamedElement(org.eclipse.ocl.examples.pivot.Class.class, PivotPackage.Literals.CLASS, umlClass2);
		pivotElement.setIsInterface(false);			
		copyClassOrInterface(umlClass2, pivotElement);
		for (org.eclipse.uml2.uml.Classifier umlType : umlClass2.getNestedClassifiers()) {
//			doSwitch(umlType);
			Type pivotObject = (Type) doSwitch(umlType);
			if (pivotObject != null) {
// WIP				metaModelManager.addOrphanClass(pivotObject);
			}
		}
//		doSwitchAll(pivotElement.getOwnedType(), umlClassifier.getOwnedTypes(), null);
		return pivotElement;
	}

	@Override
	public Object caseClassifierTemplateParameter(org.eclipse.uml2.uml.ClassifierTemplateParameter umlTemplateParameter) {
		@SuppressWarnings("null") @NonNull ClassifierTemplateParameter umlTemplateParameter2 = umlTemplateParameter;
		@SuppressWarnings("null") @NonNull org.eclipse.uml2.uml.Class umlParameterClass = (org.eclipse.uml2.uml.Class) umlTemplateParameter2.getParameteredElement();
		org.eclipse.ocl.examples.pivot.Class pivotElement = converter.refreshNamedElement(org.eclipse.ocl.examples.pivot.Class.class, PivotPackage.Literals.CLASS, umlParameterClass);
//		TypeTemplateParameter pivotTemplateParameter = converter.refreshNamedElement(org.eclipse.ocl.examples.pivot.Class.class, PivotPackage.Literals.CLASS, umlTemplateParameter);
//		setOriginalMapping(pivotElement, umlTemplateParameter);
//		String name = umlTemplateParameter.getName();
//		pivotElement.setName(name);
		TypeTemplateParameter typeTemplateParameter = (TypeTemplateParameter) pivotElement.getTemplateParameter();
		if (typeTemplateParameter == null) {
			typeTemplateParameter = PivotFactory.eINSTANCE.createTypeTemplateParameter();
			typeTemplateParameter.setOwnedParameteredElement(pivotElement);
			converter.setOriginalMapping(typeTemplateParameter, umlTemplateParameter2);
		}
		converter.setOriginalMapping(pivotElement, umlParameterClass);
//		List<EGenericType> eBounds = umlTemplateParameter.getEBounds();
//		if (!eBounds.isEmpty()) {
//			doSwitchAll(eBounds);
//			converter.queueReference(umlTemplateParameter);
//		}
		return typeTemplateParameter;
	}

	@Override
	public Comment caseComment(org.eclipse.uml2.uml.Comment umlComment) {
		@SuppressWarnings("null") @NonNull org.eclipse.uml2.uml.Comment umlComment2 = umlComment;
		Comment pivotElement = converter.refreshElement(Comment.class, PivotPackage.Literals.COMMENT, umlComment2);
		pivotElement.setBody(umlComment2.getBody());
		copyComments(pivotElement, umlComment2);
		return pivotElement;
	}

	@Override
	public Constraint caseConstraint(org.eclipse.uml2.uml.Constraint umlConstraint) {
		@SuppressWarnings("null") @NonNull org.eclipse.uml2.uml.Constraint umlConstraint2 = umlConstraint;
		Constraint pivotElement = converter.refreshNamedElement(Constraint.class, PivotPackage.Literals.CONSTRAINT, umlConstraint2);
		pivotElement.setSpecification((ValueSpecification) doSwitch(umlConstraint2.getSpecification()));
		copyNamedElement(pivotElement, umlConstraint2);
		if (!umlConstraint2.getConstrainedElements().isEmpty()) {
			converter.queueReference(umlConstraint2);	// Defer
		}
		else {
			pivotElement.getConstrainedElement().clear();
		}
		return pivotElement;
	}

	@Override
	public DataType caseDataType(org.eclipse.uml2.uml.DataType umlDataType) {
		@SuppressWarnings("null") @NonNull org.eclipse.uml2.uml.DataType umlDataType2 = umlDataType;
		DataType pivotElement = converter.refreshNamedElement(DataType.class, PivotPackage.Literals.DATA_TYPE, umlDataType2);
		copyDataTypeOrEnum(pivotElement, umlDataType2);
		@SuppressWarnings("null") @NonNull List<org.eclipse.uml2.uml.Property> umlAttributes = umlDataType2.getAttributes();
		doSwitchAll(umlAttributes);
		converter.addProperties(umlAttributes, null);
		pivotElement.getSuperClass().add(metaModelManager.getOclAnyType());
		return pivotElement;
	}

	@Override
	public Enumeration caseEnumeration(org.eclipse.uml2.uml.Enumeration umlEnumeration) {
		@SuppressWarnings("null") @NonNull org.eclipse.uml2.uml.Enumeration umlEnumeration2 = umlEnumeration;
		Enumeration pivotElement = converter.refreshNamedElement(Enumeration.class, PivotPackage.Literals.ENUMERATION, umlEnumeration2);
		copyDataTypeOrEnum(pivotElement, umlEnumeration2);
		doSwitchAll(pivotElement.getOwnedLiteral(), umlEnumeration2.getOwnedLiterals(), null);
		pivotElement.getSuperClass().add(metaModelManager.getOclAnyType());
		return pivotElement;
	}

	@Override
	public EnumerationLiteral caseEnumerationLiteral(org.eclipse.uml2.uml.EnumerationLiteral umlEnumLiteral) {
		@SuppressWarnings("null") @NonNull org.eclipse.uml2.uml.EnumerationLiteral umlEnumLiteral2 = umlEnumLiteral;
		EnumerationLiteral pivotElement = converter.refreshNamedElement(EnumerationLiteral.class,
			PivotPackage.Literals.ENUMERATION_LITERAL, umlEnumLiteral2);
		copyNamedElement(pivotElement, umlEnumLiteral2);
//		if (eEnumLiteral.eIsSet(EcorePackage.Literals.EENUM_LITERAL__VALUE)) {
//			pivotElement.setValue(BigInteger.valueOf(eEnumLiteral.getValue()));
//		}
//		else {
//			pivotElement.eUnset(PivotPackage.Literals.ENUMERATION_LITERAL__VALUE);
//		}
//			String literal = basicGet(eObject, EcorePackage.Literals.EENUM_LITERAL__LITERAL, String.class);
//			Enumerator instance = eEnumLiteral.getInstance();
//			if (literal != null) {
/*				AnnotationCS csAnnotation = PivotFactory.eINSTANCE.createAnnotationCS();
				csAnnotation.setIdSource(EcorePackage.eNS_URI);
				DetailCS csDetail = PivotFactory.eINSTANCE.createDetailCS();
				csDetail.setIdName("literal");
				copyDetailLines(csDetail.getValue(), literal);
				csAnnotation.getDetails().add(csDetail);
				pivotElement.getAnnotations().add(csAnnotation); */
//			}
		return pivotElement;
	}

	@Override
	public org.eclipse.ocl.examples.pivot.Class caseInterface(org.eclipse.uml2.uml.Interface umlInterface) {
		@SuppressWarnings("null") @NonNull Interface umlInterface2 = umlInterface;
		org.eclipse.ocl.examples.pivot.Class pivotElement = converter.refreshNamedElement(org.eclipse.ocl.examples.pivot.Class.class, PivotPackage.Literals.CLASS, umlInterface2);
		pivotElement.setIsInterface(true);			
		copyClassOrInterface(umlInterface2, pivotElement);
		return pivotElement;
	}

	@Override
	public OpaqueExpression caseOpaqueExpression(org.eclipse.uml2.uml.OpaqueExpression umlExpression) {
		@SuppressWarnings("null") @NonNull org.eclipse.uml2.uml.OpaqueExpression umlExpression2 = umlExpression;
		OpaqueExpression pivotElement = converter.refreshNamedElement(OpaqueExpression.class, PivotPackage.Literals.OPAQUE_EXPRESSION, umlExpression2);
		pivotElement.getBody().clear();
		pivotElement.getLanguage().clear();
		pivotElement.getBody().addAll(umlExpression2.getBodies());
		pivotElement.getLanguage().addAll(umlExpression2.getLanguages());
		copyNamedElement(pivotElement, umlExpression2);
		return pivotElement;
	}

	@Override
	public Operation caseOperation(org.eclipse.uml2.uml.Operation umlOperation) {
		@SuppressWarnings("null") @NonNull org.eclipse.uml2.uml.Operation umlOperation2 = umlOperation;
		Operation pivotElement = converter.refreshNamedElement(Operation.class, PivotPackage.Literals.OPERATION, umlOperation2);
		List<EAnnotation> excludedAnnotations =  null;
		EAnnotation oclAnnotation = OCLCommon.getDelegateAnnotation(umlOperation2);
		if (oclAnnotation != null) {
			excludedAnnotations = new ArrayList<EAnnotation>();
			excludedAnnotations.add(oclAnnotation);
			List<Constraint> constraints = pivotElement.getOwnedRule();
			for (Map.Entry<String,String> entry : oclAnnotation.getDetails().entrySet()) {
				Constraint constraint = PivotFactory.eINSTANCE.createConstraint();
				String key = entry.getKey();
				if (key.equals("body")) {
					constraint.setStereotype(UMLReflection.BODY);
				}
				else if (key.startsWith("body_")) {
					constraint.setStereotype(UMLReflection.BODY);
					constraint.setName(key.substring(5));
				}
				else if (key.equals("pre")) {
					constraint.setStereotype(UMLReflection.PRECONDITION);
				}
				else if (key.startsWith("pre_")) {
					constraint.setStereotype(UMLReflection.PRECONDITION);
					constraint.setName(key.substring(4));
				}
				else if (key.equals("post")) {
					constraint.setStereotype(UMLReflection.POSTCONDITION);
				}
				else if (key.startsWith("post_")) {
					constraint.setStereotype(UMLReflection.POSTCONDITION);
					constraint.setName(key.substring(5));
				}
				else
				{
					converter.error("Unsupported operation constraint " + key);
					constraint = null;
				}
				if (constraint != null) {
					String value = entry.getValue();
					OpaqueExpression specification = PivotFactory.eINSTANCE.createOpaqueExpression();	// FIXME ExpressionInOCL
					specification.getBody().add(value);
					specification.getLanguage().add(PivotConstants.OCL_LANGUAGE);
					constraint.setSpecification(specification);
//						constraint.setExprString(entry.getValue());
					constraints.add(constraint);
				}
			}				
		}
//		converter.copyTypedElement(pivotElement, umlOperation, excludedAnnotations);
		copyNamedElement(pivotElement, umlOperation2);
		copyConstraints(pivotElement, umlOperation2);
//		converter.copyMultiplicityElement(pivotElement, umlOperation);
		for (org.eclipse.uml2.uml.Parameter umlParameter : umlOperation2.getOwnedParameters()) {
			ParameterDirectionKind direction = umlParameter.getDirection();
			if (direction == ParameterDirectionKind.IN_LITERAL) {
				Parameter pivotObject = (Parameter) doSwitch(umlParameter);
				if (pivotObject != null) {
					pivotElement.getOwnedParameter().add(pivotObject);
				}
			}
		}
		copyTemplateSignature(pivotElement, umlOperation2.getOwnedTemplateSignature());
//		doSwitchAll(umlOperation.getEGenericExceptions());
		converter.queueReference(umlOperation2);				// For exceptions
		return pivotElement;
	}

	@Override
	public org.eclipse.ocl.examples.pivot.Package casePackage(org.eclipse.uml2.uml.Package umlPackage) {
		@SuppressWarnings("null") @NonNull org.eclipse.uml2.uml.Package umlPackage2 = umlPackage;
		org.eclipse.ocl.examples.pivot.Package pivotElement = converter.refreshNamedElement(org.eclipse.ocl.examples.pivot.Package.class, PivotPackage.Literals.PACKAGE, umlPackage2);
//		EAnnotation eAnnotation = umlPackage.getEAnnotation(EcorePackage.eNS_URI);
//		List<EAnnotation> exclusions = eAnnotation == null ? Collections.<EAnnotation>emptyList() : Collections.singletonList(eAnnotation);
		copyNamedElement(pivotElement, umlPackage2);
		copyConstraints(pivotElement, umlPackage2);
//		if (umlPackage.eIsSet(EcorePackage.Literals.EPACKAGE__NS_PREFIX)) {
//			pivotElement.setNsPrefix(umlPackage.getNsPrefix());
//		}
//		if (umlPackage.eIsSet(EcorePackage.Literals.EPACKAGE__NS_URI)) {
//			pivotElement.setNsURI(umlPackage.getNsURI());
//		}
		doSwitchAll(pivotElement.getNestedPackage(), umlPackage2.getNestedPackages(), null);
		doSwitchAll(pivotElement.getOwnedType(), umlPackage2.getOwnedTypes(), new UML2Pivot.Predicate<org.eclipse.uml2.uml.Type>()
		{
			public boolean filter(@NonNull org.eclipse.uml2.uml.Type element) {
				return !(element instanceof org.eclipse.uml2.uml.Association);
			}
		});
		for (org.eclipse.uml2.uml.Type type : umlPackage2.getOwnedTypes()) {
			if (type instanceof org.eclipse.uml2.uml.Association) {
				doSwitch(type);
			}
		}
		List<org.eclipse.uml2.uml.Package> importedPackages = umlPackage2.getImportedPackages();
		if (!importedPackages.isEmpty()) {
			converter.addImportedPackages(importedPackages);
			converter.queueReference(umlPackage2);	// Defer
		}
		else {
			pivotElement.getImportedPackage().clear();
		}
		return pivotElement;
	}

	@Override
	public Parameter caseParameter(org.eclipse.uml2.uml.Parameter eObject) {
		@SuppressWarnings("null") @NonNull org.eclipse.uml2.uml.Parameter eObject2 = eObject;
		Parameter pivotElement = converter.refreshNamedElement(Parameter.class, PivotPackage.Literals.PARAMETER, eObject2);
		copyTypedElement(pivotElement, eObject2, null);
		converter.copyMultiplicityElement(pivotElement, eObject2);
		return pivotElement;
	}

	@Override
	public PrimitiveType casePrimitiveType(org.eclipse.uml2.uml.PrimitiveType umlPrimitiveType) {
		@SuppressWarnings("null") @NonNull org.eclipse.uml2.uml.PrimitiveType umlPrimitiveType2 = umlPrimitiveType;
		PrimitiveType primaryElement = null;
		String name = umlPrimitiveType2.getName();
		if ("Boolean".equals(name)) {
			primaryElement = metaModelManager.getBooleanType();
		}
		else if ("Integer".equals(name)) {
			primaryElement = metaModelManager.getIntegerType();
		}
		else if ("Real".equals(name)) {
			primaryElement = metaModelManager.getRealType();
		}
		else if ("String".equals(name)) {
			primaryElement = metaModelManager.getStringType();
		}
		else if ("UnlimitedNatural".equals(name)) {
			primaryElement = metaModelManager.getUnlimitedNaturalType();
		}
//		if (pivotElement != null) {
//			converter.addCreated(umlPrimitiveType, pivotElement);
//		}
		PrimitiveType pivotElement = converter.refreshNamedElement(PrimitiveType.class, PivotPackage.Literals.PRIMITIVE_TYPE, umlPrimitiveType2);
		if (primaryElement != null) {
			@SuppressWarnings("unused")
			TypeServer typeServer = metaModelManager.getTypeServer(primaryElement);
		}
		copyClassifier(pivotElement, umlPrimitiveType2);
		return pivotElement;
	}

	@Override
	public Property caseProperty(org.eclipse.uml2.uml.Property umlProperty) {
		@SuppressWarnings("null") @NonNull org.eclipse.uml2.uml.Property umlProperty2 = umlProperty;
		Property pivotElement = converter.refreshNamedElement(Property.class, PivotPackage.Literals.PROPERTY, umlProperty2);
		copyProperty(pivotElement, umlProperty2, null);
		pivotElement.setIsComposite(umlProperty2.isComposite());			
		pivotElement.setImplicit(umlProperty2.getClass_() == null);
//		pivotElement.setIsID(umlProperty.isID());			
//		pivotElement.setIsResolveProxies(umlProperty.isResolveProxies());			
		converter.queueReference(umlProperty2);	// Defer
		return pivotElement;
	}

	protected void copyAnnotatedElement(@NonNull NamedElement pivotElement,
			@NonNull EModelElement umlElement, @Nullable List<EAnnotation> excludedAnnotations) {
		List<Annotation> pivotAnnotations = pivotElement.getOwnedAnnotation();
		for (EAnnotation eAnnotation : umlElement.getEAnnotations()) {
			if ((excludedAnnotations == null) || !excludedAnnotations.contains(eAnnotation)) {
				Annotation pivotAnnotation = (Annotation) doSwitch(eAnnotation);
				pivotAnnotations.add(pivotAnnotation);
			}
		}
	}

	protected void copyClassOrInterface(@NonNull org.eclipse.uml2.uml.Classifier umlClassifier, @NonNull org.eclipse.ocl.examples.pivot.Class pivotElement) {
		copyClassifier(pivotElement, umlClassifier);
		pivotElement.setIsAbstract(umlClassifier.isAbstract());			
//		doSwitchAll(umlClass.getSuperClasses());
		doSwitchAll(pivotElement.getOwnedOperation(), umlClassifier.getOperations(), null);
		@SuppressWarnings("null") @NonNull List<org.eclipse.uml2.uml.Property> umlAttributes = umlClassifier.getAttributes();
		converter.addProperties(umlAttributes, new UML2Pivot.Predicate<org.eclipse.uml2.uml.Property>()
		{
			public boolean filter(@NonNull org.eclipse.uml2.uml.Property element) {
				if (element.getAssociation() == null) {
					doSwitch(element);
				}
				return element.getAssociation() == null;
			}
		});
//		doSwitchAll(pivotElement.getOwnedAttribute(), umlClassifier.getAttributes());
		converter.queueReference(umlClassifier);				// For superclasses
	}

	protected void copyClassifier(@NonNull org.eclipse.ocl.examples.pivot.Class pivotElement, @NonNull org.eclipse.uml2.uml.Classifier umlClassifier) {
		List<EAnnotation> excludedAnnotations =  null;
		EMap<String, String> oclAnnotationDetails = null;
		EAnnotation oclAnnotation = OCLCommon.getDelegateAnnotation(umlClassifier);
		if (oclAnnotation != null) {
			excludedAnnotations = new ArrayList<EAnnotation>();
			excludedAnnotations.add(oclAnnotation);
			List<Constraint> constraints = pivotElement.getOwnedRule();
			oclAnnotationDetails = oclAnnotation.getDetails();
			for (Map.Entry<String,String> entry : oclAnnotationDetails.entrySet()) {
				Constraint constraint = PivotFactory.eINSTANCE.createConstraint();
				constraint.setStereotype(UMLReflection.INVARIANT);
				constraint.setName(entry.getKey());
				String value = entry.getValue();
				OpaqueExpression specification = PivotFactory.eINSTANCE.createOpaqueExpression();	// FIXME ExpressionInOCL
				specification.getBody().add(value);
				specification.getLanguage().add(PivotConstants.OCL_LANGUAGE);
				constraint.setSpecification(specification);
				constraints.add(constraint);
			}				
		}
		EAnnotation ecoreAnnotation = umlClassifier.getEAnnotation(EcorePackage.eNS_URI);
		if (ecoreAnnotation != null) {
			if (excludedAnnotations == null) {
				excludedAnnotations = new ArrayList<EAnnotation>();
			}
			excludedAnnotations.add(ecoreAnnotation);
			String constraintNameList = ecoreAnnotation.getDetails().get("constraints");
			if (constraintNameList != null) {
				List<Constraint> constraints = pivotElement.getOwnedRule();
				String[] constraintNames = constraintNameList.split(" ");
				for (String constraintName : constraintNames) {
					if ((oclAnnotationDetails == null) || (oclAnnotationDetails.get(constraintName) == null)) {
						Constraint constraint = PivotFactory.eINSTANCE.createConstraint();
						constraint.setStereotype(UMLReflection.INVARIANT);
						constraint.setName(constraintName);
						OpaqueExpression specification = PivotFactory.eINSTANCE.createOpaqueExpression();
						constraint.setSpecification(specification);
						constraints.add(constraint);
					}
				}
			}
		}
		copyNamedElement(pivotElement, umlClassifier);
		copyConstraints(pivotElement, umlClassifier);
//		if (umlClassifier.eIsSet(EcorePackage.Literals.ECLASSIFIER__INSTANCE_CLASS_NAME)) {
//			pivotElement.setInstanceClassName(umlClassifier.getInstanceClassName());
//		}
//		else {
//			pivotElement.eUnset(PivotPackage.Literals.TYPE__INSTANCE_CLASS_NAME);
//		}
		copyTemplateSignature(pivotElement, umlClassifier.getOwnedTemplateSignature());
	}

	protected void copyComments(@NonNull Element pivotElement, @NonNull org.eclipse.uml2.uml.Element umlElement) {
		doSwitchAll(pivotElement.getOwnedComment(), umlElement.getOwnedComments(), null);
	}

	protected void copyConstraints(@NonNull Namespace pivotElement, @NonNull org.eclipse.uml2.uml.Namespace umlElement) {
		doSwitchAll(pivotElement.getOwnedRule(), umlElement.getOwnedRules(), null);
	}

	protected void copyDataTypeOrEnum(@NonNull DataType pivotElement, @NonNull org.eclipse.uml2.uml.DataType umlDataType) {
		copyClassifier(pivotElement, umlDataType);
//		pivotElement.setIsSerializable(umlDataType.isSerializable());
	}

/*		public void copyDetailLines(List<String> lines, String value) {
			String[] splitLines = value.split("\n");
			for (int i = 0; i < splitLines.length-1; i++) {
				lines.add(splitLines[i] + '\n');
			}
			if (splitLines.length > 0) {
				lines.add(splitLines[splitLines.length-1]);
			}
		} */

	protected void copyModelElement(@NonNull Element pivotElement, @NonNull org.eclipse.uml2.uml.Element umlElement) {
		converter.setOriginalMapping(pivotElement, umlElement);
	}

	public void copyNamedElement(@NonNull NamedElement pivotElement, @NonNull org.eclipse.uml2.uml.NamedElement umlNamedElement) {
		copyModelElement(pivotElement, umlNamedElement);
		String name = umlNamedElement.getName();
		pivotElement.setName(name);
		copyAnnotatedElement(pivotElement, umlNamedElement, null);
		copyComments(pivotElement, umlNamedElement);
	}

	protected void copyProperty(@NonNull Property pivotElement, @NonNull org.eclipse.uml2.uml.Property umlProperty, List<EAnnotation> excludedAnnotations) {
		EAnnotation oclAnnotation = OCLCommon.getDelegateAnnotation(umlProperty);
		if (oclAnnotation != null) {
			excludedAnnotations = new ArrayList<EAnnotation>();
			excludedAnnotations.add(oclAnnotation);
			List<Constraint> constraints = pivotElement.getOwnedRule();
			for (Map.Entry<String,String> entry : oclAnnotation.getDetails().entrySet()) {
				Constraint constraint = PivotFactory.eINSTANCE.createConstraint();
				String key = entry.getKey();
				if (key.equals(SettingBehavior.DERIVATION_CONSTRAINT_KEY)) {
					constraint.setStereotype(UMLReflection.DERIVATION);
				}
				else if (key.equals(SettingBehavior.INITIAL_CONSTRAINT_KEY)) {
					constraint.setStereotype(UMLReflection.INITIAL);
				}
				else
				{
					converter.error("Unsupported feature constraint " + key);
					constraint = null;
				}
				if (constraint != null) {
					String value = entry.getValue();
					OpaqueExpression specification = PivotFactory.eINSTANCE.createOpaqueExpression();	// FIXME ExpressionInOCL
					specification.getBody().add(value);
					specification.getLanguage().add(PivotConstants.OCL_LANGUAGE);
					constraint.setSpecification(specification);
//						constraint.setExprString(entry.getValue());
					constraints.add(constraint);
				}
			}				
		}
		copyTypedElement(pivotElement, umlProperty, excludedAnnotations);
		converter.copyMultiplicityElement(pivotElement, umlProperty);
		pivotElement.setIsReadOnly(umlProperty.isReadOnly());			
		pivotElement.setIsDerived(umlProperty.isDerived());			
//		pivotElement.setIsTransient(umlProperty.isTransient());			
//		pivotElement.setIsUnsettable(umlProperty.isUnsettable());			
//		pivotElement.setIsVolatile(umlProperty.isVolatile());			
//		if (umlProperty.eIsSet(EcorePackage.Literals.ESTRUCTURAL_FEATURE__DEFAULT_VALUE_LITERAL)) {
//			pivotElement.setDefault(eObject.getDefaultValueLiteral());
//		}
//		else {
//			pivotElement.eUnset(PivotPackage.Literals.PROPERTY__DEFAULT);
//		}
	}

	protected void copyTemplateSignature(TemplateableElement pivotElement, org.eclipse.uml2.uml.TemplateSignature umlTemplateSignature) {
		if (umlTemplateSignature != null) {
			List<org.eclipse.uml2.uml.TemplateParameter> umlTemplateParameters = umlTemplateSignature.getOwnedParameters();
			if (!umlTemplateParameters.isEmpty()) {
				TemplateSignature pivotTemplateSignature = PivotFactory.eINSTANCE.createTemplateSignature();
				pivotElement.setOwnedTemplateSignature(pivotTemplateSignature);
				doSwitchAll(pivotTemplateSignature.getOwnedParameter(), umlTemplateParameters, null);
			}
		}
	}

	protected void copyTypedElement(@NonNull TypedMultiplicityElement pivotElement, @NonNull org.eclipse.uml2.uml.TypedElement umlTypedElement, List<EAnnotation> excludedAnnotations) {
		copyNamedElement(pivotElement, umlTypedElement);
		org.eclipse.uml2.uml.Type umlType = umlTypedElement.getType();
		if (umlType != null) {
			converter.queueReference(umlTypedElement);
		}
	}

	@Override
	public Element defaultCase(EObject umlObject) {
		DynamicElement pivotElement;
		if (umlObject instanceof org.eclipse.uml2.uml.Type) {
			pivotElement = converter.refreshElement(DynamicType.class, PivotPackage.Literals.DYNAMIC_TYPE, umlObject);
			((DynamicType)pivotElement).setName(((org.eclipse.uml2.uml.Type)umlObject).getName());
		}
		else if (umlObject instanceof org.eclipse.uml2.uml.Element) {
			pivotElement = converter.refreshElement(DynamicElement.class, PivotPackage.Literals.DYNAMIC_ELEMENT, umlObject);
		}
		else {
			converter.error("Unsupported " + umlObject.eClass().getName() + " for UML2PivotDeclarationSwitch");
			return null;
		}
		EClass umlMetaClass = umlObject.eClass();
		Type metaType = metaModelManager.getPivotOfEcore(Type.class, umlMetaClass);
		pivotElement.setMetaType(metaType);
		return pivotElement;
	}

	public Object doInPackageSwitch(EObject eObject) {
		int classifierID = eObject.eClass().getClassifierID();
		return doSwitch(classifierID, eObject);
	}

	@Override
	public Object doSwitch(EObject eObject) {
		EClass eClass = eObject.eClass();
		EPackage ePackage = eClass.getEPackage();
		if (ePackage == UMLPackage.eINSTANCE) {
			return doInPackageSwitch(eObject);
		}
		else if (ePackage == EcorePackage.eINSTANCE) {
			return ecoreSwitch.doInPackageSwitch(eObject);
		}
		else {
			converter.addStereotypeApplication(eObject);
			return null;
		}
	}

	public <T extends Element, V extends EObject> void doSwitchAll(/*@NonNull*/ Collection<T> pivotObjects, /*@NonNull*/ List<V> eObjects, @Nullable UML2Pivot.Predicate<V> predicate) {
		for (V eObject : eObjects) {
			if ((eObject != null) && ((predicate == null) || predicate.filter(eObject))) {
				@SuppressWarnings("unchecked")
				T pivotObject = (T) doSwitch(eObject);
				if (pivotObject != null) {
					pivotObjects.add(pivotObject);
				}
			}
		}
	}

	public <T extends Element> void doSwitchAll(List<? extends EObject> eObjects) {
		for (EObject eObject : eObjects) {
			doSwitch(eObject);
		}
	}
}
