/**
 * <copyright>
 *
 * Copyright (c) 2010,2011 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: BaseDeclarationVisitor.java,v 1.8 2011/05/05 17:53:02 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.pivot2cs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.DataType;
import org.eclipse.ocl.examples.pivot.Detail;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.EnumerationLiteral;
import org.eclipse.ocl.examples.pivot.Import;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.Namespace;
import org.eclipse.ocl.examples.pivot.OpaqueExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypeTemplateParameter;
import org.eclipse.ocl.examples.pivot.UMLReflection;
import org.eclipse.ocl.examples.pivot.ValueSpecification;
import org.eclipse.ocl.examples.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.examples.pivot.util.Visitable;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.baseCST.AnnotationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.AttributeCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTFactory;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ConstraintCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.DataTypeCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.DetailCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.EnumerationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.EnumerationLiteralCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ImportCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.OperationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PackageCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ParameterCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PathNameCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ReferenceCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.RootPackageCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.SpecificationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.StructuralFeatureCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateParameterCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateSignatureCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeParameterCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedRefCS;

public class BaseDeclarationVisitor extends AbstractExtendingVisitor<ElementCS, Pivot2CSConversion>
{
	public BaseDeclarationVisitor(@NonNull Pivot2CSConversion context) {
		super(context);		// NB this class is stateless since separate instances exist per CS package
	}

	protected <T extends ConstraintCS> void refreshOperationConstraints(@NonNull Class<T> csConstraintClass, @NonNull List<? super T> csOperationConstraints, @NonNull Operation operation) {
		List<Constraint> preconditions = operation.getPrecondition();
		Constraint bodyExpression = operation.getBodyExpression();
		List<Constraint> postconditions = operation.getPostcondition();
		if ((preconditions.size() > 0) || (bodyExpression != null) || (postconditions.size() > 0)) {
			List<T> csConstraints = new ArrayList<T>();
			if (preconditions.size() > 0) {
				List<T> csPreconditions = context.visitDeclarations(csConstraintClass, preconditions, null);
				for (T csPrecondition : csPreconditions) {
					csPrecondition.setStereotype(UMLReflection.PRECONDITION);
					csConstraints.add(csPrecondition);
				}
			}
			if (bodyExpression != null) {
				T csBodyExpression = context.visitDeclaration(csConstraintClass, bodyExpression);
				if (csBodyExpression != null) {
					csBodyExpression.setStereotype(UMLReflection.BODY);
					csConstraints.add(csBodyExpression);
				}
			}
			if (postconditions.size() > 0) {
				List<T> csPostconditions = context.visitDeclarations(csConstraintClass, postconditions, null);
				for (T csPostcondition : csPostconditions) {
					csPostcondition.setStereotype(UMLReflection.POSTCONDITION);
					csConstraints.add(csPostcondition);
				}
			}
			context.refreshList(csOperationConstraints, csConstraints);
		}
		else {
			csOperationConstraints.clear();
		}
	}

	protected <T extends ConstraintCS> void refreshPropertyConstraints(@NonNull Class<T> csConstraintClass, @NonNull List<? super T> csPropertyConstraints, Property object) {
		T csConstraint = null;
		Constraint derivationExpression = object.getDerivationExpression();
		if (derivationExpression != null) {
			csConstraint = context.visitDeclaration(csConstraintClass, derivationExpression);
		}
		if (csConstraint != null) {
			csConstraint.setStereotype(UMLReflection.DERIVATION);
			context.refreshList(csPropertyConstraints, Collections.singletonList(csConstraint));
		}
		else {
			csPropertyConstraints.clear();
		}
	}

	@Override
	public ElementCS visitAnnotation(@NonNull org.eclipse.ocl.examples.pivot.Annotation object) {
		AnnotationCS csElement = context.refreshNamedElement(AnnotationCS.class, BaseCSTPackage.Literals.ANNOTATION_CS, object);
		context.refreshList(csElement.getOwnedContent(), context.visitDeclarations(ModelElementCS.class, object.getOwnedContent(), null));
		context.refreshList(csElement.getOwnedDetail(), context.visitDeclarations(DetailCS.class, object.getOwnedDetail(), null));
		List<Element> references = object.getReference();
		if (references.size() > 0) {
			List<ModelElementRefCS> csReferences = new ArrayList<ModelElementRefCS>(references.size());
			for (Element reference : references) {
				if (reference != null) {
					ModelElementRefCS csRef = BaseCSTFactory.eINSTANCE.createModelElementRefCS();
					@SuppressWarnings("null") @NonNull PathNameCS csPathName = BaseCSTFactory.eINSTANCE.createPathNameCS();
					csRef.setPathName(csPathName);
					context.refreshPathName(csPathName, reference, context.getScope());
					csReferences.add(csRef);
				}
			}
			context.refreshList(csElement.getOwnedReference(), csReferences);
		}
		else {
			csElement.getOwnedReference().clear();
		}
		return csElement;
	}

	@Override
	public ElementCS visitClass(@NonNull org.eclipse.ocl.examples.pivot.Class object) {
		org.eclipse.ocl.examples.pivot.Class savedScope = context.setScope(object);
		ClassCS csElement = context.refreshClassifier(ClassCS.class, BaseCSTPackage.Literals.CLASS_CS, object);
		context.refreshList(csElement.getOwnedProperty(), context.visitDeclarations(StructuralFeatureCS.class, object.getOwnedAttribute(),
			new Pivot2CS.Predicate<Property>()
			{
				public boolean filter(@NonNull Property element) {
					return !element.isImplicit();
				}
			}));
		context.refreshList(csElement.getOwnedOperation(), context.visitDeclarations(OperationCS.class, object.getOwnedOperation(), null));
		final Type oclElementType = context.getMetaModelManager().getOclElementType();
		context.refreshList(csElement.getOwnedSuperType(), context.visitReferences(TypedRefCS.class, object.getSuperClass(),
			new Pivot2CS.Predicate<Type>()
			{
				public boolean filter(@NonNull Type element) {
					return element != oclElementType;
				}
			}));
		context.refreshQualifiers(csElement.getQualifier(), "abstract", object.isAbstract());
		context.refreshQualifiers(csElement.getQualifier(), "interface", object.isInterface());
		context.setScope(savedScope);
		return csElement;
	}

//	@Override
//	public ElementCS visitComment(Comment object) {
//		ParameterCS pivotElement = context.refreshNamedElement(ParameterCS.class, BaseCSTPackage.Literals.COMMENT_CS, object);
//		return null;
//	}

	@Override
	public ElementCS visitConstraint(@NonNull Constraint object) {
		ConstraintCS csElement = context.refreshNamedElement(ConstraintCS.class, BaseCSTPackage.Literals.CONSTRAINT_CS, object);
		ValueSpecification specification = object.getSpecification();
		csElement.setSpecification(specification != null ? context.visitDeclaration(SpecificationCS.class, specification) : null);
		return csElement;
	}

	@Override
	public ElementCS visitDataType(@NonNull DataType object) {
		DataTypeCS csElement = context.refreshClassifier(DataTypeCS.class, BaseCSTPackage.Literals.DATA_TYPE_CS, object);
		context.refreshQualifiers(csElement.getQualifier(), "serializable", object.isSerializable());
		return csElement;
	}

	@Override
	public ElementCS visitDetail(@NonNull Detail object) {
		DetailCS csElement = context.refreshNamedElement(DetailCS.class, BaseCSTPackage.Literals.DETAIL_CS, object);
		csElement.getValue().clear();
		csElement.getValue().addAll(object.getValue());
		return csElement;
	}

	@Override
	public ElementCS visitEnumeration(@NonNull org.eclipse.ocl.examples.pivot.Enumeration object) {
		EnumerationCS csElement = context.refreshClassifier(EnumerationCS.class, BaseCSTPackage.Literals.ENUMERATION_CS, object);
		context.refreshList(csElement.getOwnedLiterals(), context.visitDeclarations(EnumerationLiteralCS.class, object.getOwnedLiteral(), null));
		context.refreshQualifiers(csElement.getQualifier(), "serializable", object.isSerializable());
		return csElement;
	}

	@Override
	public ElementCS visitEnumerationLiteral(@NonNull EnumerationLiteral object) {
		EnumerationLiteralCS csElement = context.refreshNamedElement(EnumerationLiteralCS.class,
			BaseCSTPackage.Literals.ENUMERATION_LITERAL_CS, object);
		if (object.eIsSet(PivotPackage.Literals.ENUMERATION_LITERAL__VALUE)) {
			csElement.setValue(object.getValue().intValue());
		}
		else {
			csElement.eUnset(BaseCSTPackage.Literals.ENUMERATION_LITERAL_CS__VALUE);
		}
		return csElement;
	}

	@Override
	public ElementCS visitImport(@NonNull Import object) {
		Namespace importedNamespace = object.getImportedNamespace();
		if (importedNamespace != null) {
			context.importNamespace(importedNamespace, object.getName());
		}
		return null;
	}

	@Override
	public ElementCS visitOpaqueExpression(@NonNull OpaqueExpression object) {
		SpecificationCS csElement = context.refreshElement(SpecificationCS.class, BaseCSTPackage.Literals.SPECIFICATION_CS, object);
		String body = PivotUtil.getBody(object);
		csElement.setExprString(body);
		return csElement;
	}

	@Override
	public ElementCS visitOperation(@NonNull Operation object) {
		OperationCS csElement = context.refreshTypedMultiplicityElement(OperationCS.class, BaseCSTPackage.Literals.OPERATION_CS, object);
		TemplateSignature ownedTemplateSignature = object.getOwnedTemplateSignature();
		if (ownedTemplateSignature != null) {
			csElement.setOwnedTemplateSignature(context.visitDeclaration(TemplateSignatureCS.class, ownedTemplateSignature));
		}
		context.refreshList(csElement.getOwnedParameter(), context.visitDeclarations(ParameterCS.class, object.getOwnedParameter(), null));
		context.refreshList(csElement.getOwnedException(), context.visitReferences(TypedRefCS.class, object.getRaisedException(), null));
		//
		refreshOperationConstraints(ConstraintCS.class, csElement.getOwnedConstraint(), object);
		return csElement;
	}

	@Override
	public ElementCS visitPackage(@NonNull org.eclipse.ocl.examples.pivot.Package object) {
		PackageCS csPackage = context.refreshNamedElement(PackageCS.class, BaseCSTPackage.Literals.PACKAGE_CS, object);
		context.refreshList(csPackage.getOwnedType(), context.visitDeclarations(ClassifierCS.class, object.getOwnedType(), null));
		csPackage.setNsPrefix(object.getNsPrefix());
		csPackage.setNsURI(object.getNsURI());
		context.refreshList(csPackage.getOwnedNestedPackage(), context.visitDeclarations(PackageCS.class, object.getNestedPackage(), null));
		return csPackage;
	}

	@Override
	public ElementCS visitParameter(@NonNull Parameter object) {
		ParameterCS csElement = context.refreshTypedMultiplicityElement(ParameterCS.class, BaseCSTPackage.Literals.PARAMETER_CS, object);
		return csElement;
	}

	@Override
	public ElementCS visitProperty(@NonNull Property object) {
		StructuralFeatureCS csElement;
		Type type = object.getType();
		if (type instanceof CollectionType) {
			type = ((CollectionType)type).getElementType();
		}
		if (type instanceof DataType) {
			AttributeCS csAttribute = context.refreshStructuralFeature(AttributeCS.class, BaseCSTPackage.Literals.ATTRIBUTE_CS, object);
			context.refreshQualifiers(csAttribute.getQualifier(), "id", object.isID());
			csElement = csAttribute;
		}
		else {
			ReferenceCS csReference = context.refreshStructuralFeature(ReferenceCS.class, BaseCSTPackage.Literals.REFERENCE_CS, object);
			context.refreshQualifiers(csReference.getQualifier(), "composes", object.isComposite());
			context.refreshQualifiers(csReference.getQualifier(), "resolve", "!resolve", object.isResolveProxies() ? null : Boolean.FALSE);
			Property opposite = object.getOpposite();
			if (opposite != null) {
				if (!opposite.isImplicit()) {
					csReference.setOpposite(opposite);
				}
				else {
					// FIXME BUG 377626
				}
			}
			context.refreshList(csReference.getKeys(), object.getKeys());
			csElement = csReference;
		}
		refreshPropertyConstraints(ConstraintCS.class, csElement.getOwnedConstraint(), object);
		return csElement;
	}

	@Override
	public ElementCS visitRoot(@NonNull Root object) {
		RootPackageCS csElement = context.refreshElement(RootPackageCS.class, BaseCSTPackage.Literals.ROOT_PACKAGE_CS, object);
//		csElement.setNsURI(object.getExternalURI());
		csElement.setNsURI(null);
		context.refreshList(csElement.getOwnedNestedPackage(), context.visitDeclarations(PackageCS.class, object.getNestedPackage(), null));
		context.visitDeclarations(ImportCS.class, object.getImports(), null);
		return csElement;
	}

	@Override
	public ElementCS visitTemplateSignature(@NonNull TemplateSignature object) {
		TemplateSignatureCS csElement = context.refreshElement(TemplateSignatureCS.class, BaseCSTPackage.Literals.TEMPLATE_SIGNATURE_CS, object);
		context.refreshList(csElement.getOwnedTemplateParameter(), context.visitDeclarations(TemplateParameterCS.class, object.getOwnedParameter(), null));
		return csElement;
	}

	@Override
	public ElementCS visitTypeTemplateParameter(@NonNull TypeTemplateParameter object) {
		ParameterableElement parameteredElement = object.getParameteredElement();
		if (parameteredElement == null) {
			return null;
		}
		TypeParameterCS csElement = context.refreshElement(TypeParameterCS.class, BaseCSTPackage.Literals.TYPE_PARAMETER_CS, parameteredElement);
		csElement.setName(((NamedElement) parameteredElement).getName());
		return csElement;
	}

	public ElementCS visiting(@NonNull Visitable visitable) {
		throw new IllegalArgumentException("Unsupported " + visitable.eClass().getName() + " for Pivot2CS Declaration pass");
	}
}