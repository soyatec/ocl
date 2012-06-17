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
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreSwitch;
import org.eclipse.ocl.common.OCLCommon;
import org.eclipse.ocl.examples.pivot.Annotation;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.DataType;
import org.eclipse.ocl.examples.pivot.Detail;
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
import org.eclipse.ocl.examples.pivot.UMLReflection;
import org.eclipse.ocl.examples.pivot.ValueSpecification;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.TypeServer;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.util.UMLSwitch;

public class UML2PivotDeclarationSwitch extends UMLSwitch<Object>
{
	public class EcoreUML2PivotDeclarationSwitch extends EcoreSwitch<Object>
	{
		@Override
		public Object caseEAnnotation(EAnnotation eObject) {
			Annotation pivotElement = PivotFactory.eINSTANCE.createAnnotation();
			pivotElement.setName(eObject.getSource());
			converter.setOriginalMapping(pivotElement, eObject);
			doSwitchAll(pivotElement.getOwnedContent(), eObject.getContents(), null);
			EMap<String, String> details = eObject.getDetails();
			for (Map.Entry<String, String> entry : details) {
				String key = entry.getKey();
				Detail pivotDetail = PivotFactory.eINSTANCE.createDetail();
				pivotDetail.setName(key);
				pivotDetail.getValue().add(entry.getValue());
				pivotElement.getOwnedDetail().add(pivotDetail);	// FIXME refreshList
			}
			if (!eObject.getReferences().isEmpty()) {
				converter.queueReference(eObject);
			}
			return pivotElement;
		}

		@Override
		public Element defaultCase(EObject object) {
			converter.error("Unsupported " + object.eClass().getName() + " for EcoreUML2PivotDeclarationSwitch");
			return null;
		}

		public Object doInPackageSwitch(EObject eObject) {
			int classifierID = eObject.eClass().getClassifierID();
			return doSwitch(classifierID, eObject);
		}
	}
	
	protected final EcoreUML2PivotDeclarationSwitch ecoreSwitch = new EcoreUML2PivotDeclarationSwitch();
	protected final UML2Pivot converter;
	protected final MetaModelManager metaModelManager;
	
	public UML2PivotDeclarationSwitch(UML2Pivot converter) {
		this.converter = converter;
		this.metaModelManager = converter.getMetaModelManager();
	}
	
	@Override
	public Object caseAssociation(org.eclipse.uml2.uml.Association umlAssociation) {
		List<org.eclipse.uml2.uml.Property> memberEnds = umlAssociation.getMemberEnds();
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
		org.eclipse.ocl.examples.pivot.Class pivotElement = converter.refreshNamedElement(org.eclipse.ocl.examples.pivot.Class.class, PivotPackage.Literals.CLASS, umlClass);
		copyClassifier(pivotElement, umlClass);
		pivotElement.setIsAbstract(umlClass.isAbstract());			
//		pivotElement.setIsInterface(umlClass.isInterface());			
//		doSwitchAll(umlClass.getSuperClasses());
		doSwitchAll(pivotElement.getOwnedOperation(), umlClass.getOperations(), null);
		converter.addProperties(umlClass.getAttributes(), new UML2Pivot.Predicate<org.eclipse.uml2.uml.Property>()
		{
			public boolean filter(org.eclipse.uml2.uml.Property element) {
				if (element.getAssociation() == null) {
					doSwitch(element);
				}
				return element.getAssociation() == null;
			}
		});
//		doSwitchAll(pivotElement.getOwnedAttribute(), umlClass.getAttributes());
		for (org.eclipse.uml2.uml.Classifier umlType : umlClass.getNestedClassifiers()) {
//			doSwitch(umlType);
			Type pivotObject = (Type) doSwitch(umlType);
			if (pivotObject != null) {
// WIP				metaModelManager.addOrphanClass(pivotObject);
			}
		}
//		doSwitchAll(pivotElement.getOwnedType(), umlClass.getOwnedTypes(), null);
		converter.queueReference(umlClass);				// For superclasses
		return pivotElement;
	}

	@Override
	public Object caseClassifierTemplateParameter(org.eclipse.uml2.uml.ClassifierTemplateParameter umlTemplateParameter) {
		org.eclipse.uml2.uml.Class umlParameterClass = (org.eclipse.uml2.uml.Class) umlTemplateParameter.getParameteredElement();
		org.eclipse.ocl.examples.pivot.Class pivotElement = converter.refreshNamedElement(org.eclipse.ocl.examples.pivot.Class.class, PivotPackage.Literals.CLASS, umlParameterClass);
//		TypeTemplateParameter pivotTemplateParameter = converter.refreshNamedElement(org.eclipse.ocl.examples.pivot.Class.class, PivotPackage.Literals.CLASS, umlTemplateParameter);
//		setOriginalMapping(pivotElement, umlTemplateParameter);
//		String name = umlTemplateParameter.getName();
//		pivotElement.setName(name);
		TypeTemplateParameter typeTemplateParameter = (TypeTemplateParameter) pivotElement.getTemplateParameter();
		if (typeTemplateParameter == null) {
			typeTemplateParameter = PivotFactory.eINSTANCE.createTypeTemplateParameter();
			typeTemplateParameter.setOwnedParameteredElement(pivotElement);
		}
//		List<EGenericType> eBounds = umlTemplateParameter.getEBounds();
//		if (!eBounds.isEmpty()) {
//			doSwitchAll(eBounds);
//			converter.queueReference(umlTemplateParameter);
//		}
		return typeTemplateParameter;
	}

	@Override
	public Comment caseComment(org.eclipse.uml2.uml.Comment umlComment) {
		Comment pivotElement = converter.refreshElement(Comment.class, PivotPackage.Literals.COMMENT, umlComment);
		pivotElement.setBody(umlComment.getBody());
		copyComments(pivotElement, umlComment);
		return pivotElement;
	}

	@Override
	public Constraint caseConstraint(org.eclipse.uml2.uml.Constraint umlConstraint) {
		Constraint pivotElement = converter.refreshNamedElement(Constraint.class, PivotPackage.Literals.CONSTRAINT, umlConstraint);
		pivotElement.setSpecification((ValueSpecification) doSwitch(umlConstraint.getSpecification()));
		copyNamedElement(pivotElement, umlConstraint);
		if (!umlConstraint.getConstrainedElements().isEmpty()) {
			converter.queueReference(umlConstraint);	// Defer
		}
		else {
			pivotElement.getConstrainedElement().clear();
		}
		return pivotElement;
	}

	@Override
	public DataType caseDataType(org.eclipse.uml2.uml.DataType umlDataType) {
		DataType pivotElement = converter.refreshNamedElement(DataType.class, PivotPackage.Literals.DATA_TYPE, umlDataType);
		copyDataTypeOrEnum(pivotElement, umlDataType);
		return pivotElement;
	}

	@Override
	public Enumeration caseEnumeration(org.eclipse.uml2.uml.Enumeration umlEnumeration) {
		Enumeration pivotElement = converter.refreshNamedElement(Enumeration.class, PivotPackage.Literals.ENUMERATION, umlEnumeration);
		copyDataTypeOrEnum(pivotElement, umlEnumeration);
		doSwitchAll(pivotElement.getOwnedLiteral(), umlEnumeration.getOwnedLiterals(), null);
		return pivotElement;
	}

	@Override
	public EnumerationLiteral caseEnumerationLiteral(org.eclipse.uml2.uml.EnumerationLiteral umlEnumLiteral) {
		EnumerationLiteral pivotElement = converter.refreshNamedElement(EnumerationLiteral.class,
			PivotPackage.Literals.ENUMERATION_LITERAL, umlEnumLiteral);
		copyNamedElement(pivotElement, umlEnumLiteral);
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
	public OpaqueExpression caseOpaqueExpression(org.eclipse.uml2.uml.OpaqueExpression umlExpression) {
		OpaqueExpression pivotElement = converter.refreshNamedElement(OpaqueExpression.class, PivotPackage.Literals.OPAQUE_EXPRESSION, umlExpression);
		pivotElement.getBody().clear();
		pivotElement.getLanguage().clear();
		pivotElement.getBody().addAll(umlExpression.getBodies());
		pivotElement.getLanguage().addAll(umlExpression.getLanguages());
		copyNamedElement(pivotElement, umlExpression);
		return pivotElement;
	}

	@Override
	public Operation caseOperation(org.eclipse.uml2.uml.Operation umlOperation) {
		Operation pivotElement = converter.refreshNamedElement(Operation.class, PivotPackage.Literals.OPERATION, umlOperation);
		List<EAnnotation> excludedAnnotations =  null;
		EAnnotation oclAnnotation = OCLCommon.getDelegateAnnotation(umlOperation);
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
		copyNamedElement(pivotElement, umlOperation);
		copyConstraints(pivotElement, umlOperation);
//		converter.copyMultiplicityElement(pivotElement, umlOperation);
		for (org.eclipse.uml2.uml.Parameter umlParameter : umlOperation.getOwnedParameters()) {
			ParameterDirectionKind direction = umlParameter.getDirection();
			if (direction == ParameterDirectionKind.IN_LITERAL) {
				Parameter pivotObject = (Parameter) doSwitch(umlParameter);
				if (pivotObject != null) {
					pivotElement.getOwnedParameter().add(pivotObject);
				}
			}
		}
		copyTemplateSignature(pivotElement, umlOperation.getOwnedTemplateSignature());
//		doSwitchAll(umlOperation.getEGenericExceptions());
		converter.queueReference(umlOperation);				// For exceptions
		return pivotElement;
	}

	@Override
	public org.eclipse.ocl.examples.pivot.Package casePackage(org.eclipse.uml2.uml.Package umlPackage) {
		org.eclipse.ocl.examples.pivot.Package pivotElement = converter.refreshNamedElement(org.eclipse.ocl.examples.pivot.Package.class, PivotPackage.Literals.PACKAGE, umlPackage);
		metaModelManager.addPackage(pivotElement);
		EAnnotation eAnnotation = umlPackage.getEAnnotation(EcorePackage.eNS_URI);
		List<EAnnotation> exclusions = eAnnotation == null ? Collections.<EAnnotation>emptyList() : Collections.singletonList(eAnnotation);
		copyNamedElement(pivotElement, umlPackage);
		copyConstraints(pivotElement, umlPackage);
//		if (umlPackage.eIsSet(EcorePackage.Literals.EPACKAGE__NS_PREFIX)) {
//			pivotElement.setNsPrefix(umlPackage.getNsPrefix());
//		}
//		if (umlPackage.eIsSet(EcorePackage.Literals.EPACKAGE__NS_URI)) {
//			pivotElement.setNsURI(umlPackage.getNsURI());
//		}
		doSwitchAll(pivotElement.getNestedPackage(), umlPackage.getNestedPackages(), null);
		doSwitchAll(pivotElement.getOwnedType(), umlPackage.getOwnedTypes(), new UML2Pivot.Predicate<org.eclipse.uml2.uml.Type>()
		{
			public boolean filter(org.eclipse.uml2.uml.Type element) {
				return !(element instanceof org.eclipse.uml2.uml.Association);
			}
		});
		for (org.eclipse.uml2.uml.Type type : umlPackage.getOwnedTypes()) {
			if (type instanceof org.eclipse.uml2.uml.Association) {
				doSwitch(type);
			}
		}
		List<org.eclipse.uml2.uml.Package> importedPackages = umlPackage.getImportedPackages();
		if (!importedPackages.isEmpty()) {
			converter.addImportedPackages(importedPackages);
			converter.queueReference(umlPackage);	// Defer
		}
		else {
			pivotElement.getImportedPackage().clear();
		}
		return pivotElement;
	}

	@Override
	public Parameter caseParameter(org.eclipse.uml2.uml.Parameter eObject) {
		Parameter pivotElement = converter.refreshNamedElement(Parameter.class, PivotPackage.Literals.PARAMETER, eObject);
		converter.copyTypedElement(pivotElement, eObject, null);
		converter.copyMultiplicityElement(pivotElement, eObject);
		return pivotElement;
	}

	@Override
	public PrimitiveType casePrimitiveType(org.eclipse.uml2.uml.PrimitiveType umlPrimitiveType) {
		PrimitiveType primaryElement = null;
		String name = umlPrimitiveType.getName();
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
		PrimitiveType pivotElement = converter.refreshNamedElement(PrimitiveType.class, PivotPackage.Literals.PRIMITIVE_TYPE, umlPrimitiveType);
		if (primaryElement != null) {
			TypeServer typeServer = metaModelManager.getTypeServer(primaryElement);
			typeServer.addSecondaryType(pivotElement);
		}
		copyClassifier(pivotElement, umlPrimitiveType);
		return pivotElement;
	}

	@Override
	public Property caseProperty(org.eclipse.uml2.uml.Property umlProperty) {
		Property pivotElement = converter.refreshNamedElement(Property.class, PivotPackage.Literals.PROPERTY, umlProperty);
		converter.copyProperty(pivotElement, umlProperty, null);
		pivotElement.setIsComposite(umlProperty.isComposite());			
		pivotElement.setImplicit(umlProperty.getClass_() == null);
//		pivotElement.setIsID(umlProperty.isID());			
//		pivotElement.setIsResolveProxies(umlProperty.isResolveProxies());			
		copyNamedElement(pivotElement, umlProperty);
		converter.queueReference(umlProperty);	// Defer
		return pivotElement;
	}

	protected void copyClassifier(org.eclipse.ocl.examples.pivot.Class pivotElement, org.eclipse.uml2.uml.Classifier umlClassifier) {
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

	protected void copyComments(Element pivotElement, org.eclipse.uml2.uml.Element umlElement) {
		doSwitchAll(pivotElement.getOwnedComment(), umlElement.getOwnedComments(), null);
	}

	protected void copyConstraints(Namespace pivotElement, org.eclipse.uml2.uml.Namespace umlElement) {
		doSwitchAll(pivotElement.getOwnedRule(), umlElement.getOwnedRules(), null);
	}

	protected void copyDataTypeOrEnum(DataType pivotElement, org.eclipse.uml2.uml.DataType umlDataType) {
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

	public void copyNamedElement(NamedElement pivotElement, org.eclipse.uml2.uml.NamedElement umlElement) {
		converter.copyNamedElement(pivotElement, umlElement);
		converter.copyAnnotatedElement(pivotElement, umlElement, null);
		copyComments(pivotElement, umlElement);
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

	@Override
	public Element defaultCase(EObject object) {
		converter.error("Unsupported " + object.eClass().getName() + " for UML2PivotDeclarationSwitch");
		return null;
	}

	public Object doInPackageSwitch(EObject eObject) {
		int classifierID = eObject.eClass().getClassifierID();
		return doSwitch(classifierID, eObject);
	}

	@Override
	public Object doSwitch(EObject eObject) {
		EClass eClass = eObject.eClass();
		EPackage ePackage = eClass.getEPackage();
		if (ePackage == EcorePackage.eINSTANCE) {
			return ecoreSwitch.doInPackageSwitch(eObject);
		}
		else {
			return doInPackageSwitch(eObject);
		}
	}

	public <T extends Element, V extends EObject> void doSwitchAll(Collection<T> pivotObjects, List<V> eObjects, UML2Pivot.Predicate<V> predicate) {
		for (V eObject : eObjects) {
			if ((predicate == null) || predicate.filter(eObject)) {
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
