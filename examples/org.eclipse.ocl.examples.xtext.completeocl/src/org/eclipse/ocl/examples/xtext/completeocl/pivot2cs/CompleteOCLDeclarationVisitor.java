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
 * $Id: OCLinEcoreDeclarationVisitor.java,v 1.8 2011/05/14 10:38:08 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl.pivot2cs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.Namespace;
import org.eclipse.ocl.examples.pivot.OpaqueExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Package;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypedMultiplicityElement;
import org.eclipse.ocl.examples.pivot.UMLReflection;
import org.eclipse.ocl.examples.pivot.ValueSpecification;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrintOptions;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrinter;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTFactory;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ParameterCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PathNameCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedRefCS;
import org.eclipse.ocl.examples.xtext.base.pivot2cs.AliasAnalysis;
import org.eclipse.ocl.examples.xtext.base.pivot2cs.Pivot2CSConversion;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.BodyCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ClassifierContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLCSTPackage;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLDocumentCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ContextConstraintCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ContextSpecificationCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DerCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.InitCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.InvCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OperationContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PackageDeclarationCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PathNameDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PostCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PreCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PropertyContextDeclCS;
import org.eclipse.ocl.examples.xtext.essentialocl.pivot2cs.EssentialOCLDeclarationVisitor;

import com.google.common.collect.Lists;

public class CompleteOCLDeclarationVisitor extends EssentialOCLDeclarationVisitor
{
	public CompleteOCLDeclarationVisitor(@NonNull Pivot2CSConversion context) {
		super(context);
	}

	protected TypedRefCS convertTypeRef(@NonNull TypedMultiplicityElement object) {
		Type type = object.getType();
		if (type == null) {
			return null;
		}
		TypedRefCS typeRef = context.visitReference(TypedRefCS.class, type);
//		int upper = object.getUpper().intValue();
//		if (upper == 1) {
			return typeRef;
//		}
//		int lower = object.getLower().intValue();
//		CollectionTypeCS collectionTypeCS = EssentialOCLCSTFactory.eINSTANCE.createCollectionTypeCS();
//		collectionTypeCS.setOwnedType(typeRef);
//		collectionTypeCS.setName(ElementUtil.getCollectionName(object.isOrdered(), object.isUnique()));
//		return collectionTypeCS;
	}

	protected void gatherPackages(@NonNull List<org.eclipse.ocl.examples.pivot.Package> allPackages, @NonNull List<org.eclipse.ocl.examples.pivot.Package> nestedPackages) {
		allPackages.addAll(nestedPackages);
		for (org.eclipse.ocl.examples.pivot.Package nestedPackage : nestedPackages) {
			List<org.eclipse.ocl.examples.pivot.Package> nestedNestedPackages = nestedPackage.getNestedPackage();
			assert nestedNestedPackages != null;
			gatherPackages(allPackages, nestedNestedPackages);
		}
	}

	protected void importPackage(@NonNull org.eclipse.ocl.examples.pivot.Package aPackage) {
		org.eclipse.ocl.examples.pivot.Package nestingPackage = null;
		while ((nestingPackage = aPackage.getNestingPackage()) != null) {
			aPackage = nestingPackage;
		}
		context.importNamespace(aPackage, null);
	}

	protected void refreshPathNamedElement(@NonNull PathNameDeclCS csDecl, @NonNull NamedElement namedElement, Namespace scope) {
		PathNameCS csPathName = csDecl.getPathName();
		if (csPathName == null) {
			csPathName = BaseCSTFactory.eINSTANCE.createPathNameCS();
			assert csPathName != null;
			csDecl.setPathName(csPathName);
		}
		context.refreshPathName(csPathName, namedElement, scope);
	}

	@Override
	public ElementCS visitClass(@NonNull org.eclipse.ocl.examples.pivot.Class object) {
		return visitType(object);
	}

	@Override
	public ElementCS visitConstraint(@NonNull Constraint object) {
		String stereotype = object.getStereotype();				// FIXME ByeBye Stereotypes
		if (stereotype == null) {
			EObject eContainer = object.eContainer();
			if (eContainer instanceof Type) {
				stereotype = UMLReflection.INVARIANT;
			}
			else if (eContainer instanceof Operation) {
				stereotype = UMLReflection.BODY;
			}
		}
		ContextConstraintCS csElement = null;
		if (UMLReflection.BODY.equals(stereotype)) {
			csElement = context.refreshNamedElement(BodyCS.class, CompleteOCLCSTPackage.Literals.BODY_CS, object);
		}
		else if (UMLReflection.DERIVATION.equals(stereotype)) {
			csElement = context.refreshNamedElement(DerCS.class, CompleteOCLCSTPackage.Literals.DER_CS, object);
		}
		else if (UMLReflection.INITIAL.equals(stereotype)) {
			csElement = context.refreshNamedElement(InitCS.class, CompleteOCLCSTPackage.Literals.INIT_CS, object);
		}
		else if (UMLReflection.INVARIANT.equals(stereotype)) {
			csElement = context.refreshNamedElement(InvCS.class, CompleteOCLCSTPackage.Literals.INV_CS, object);
		}
		else if (UMLReflection.POSTCONDITION.equals(stereotype)) {
			csElement = context.refreshNamedElement(PostCS.class, CompleteOCLCSTPackage.Literals.POST_CS, object);
		}
		else if (UMLReflection.PRECONDITION.equals(stereotype)) {
			csElement = context.refreshNamedElement(PreCS.class, CompleteOCLCSTPackage.Literals.PRE_CS, object);
		}
		if (csElement != null) {
			csElement.setStereotype(stereotype);
			Namespace namespace = PivotUtil.getNamespace(object);
			ValueSpecification specification = object.getSpecification();
			if ((specification != null) && (namespace != null)) {
				ContextSpecificationCS csSpec = context.refreshElement(ContextSpecificationCS.class, CompleteOCLCSTPackage.Literals.CONTEXT_SPECIFICATION_CS, specification);
				csElement.setSpecification(csSpec);
				if (specification instanceof OpaqueExpression) {
					MetaModelManager metaModelManager = context.getMetaModelManager();
					PrettyPrintOptions.Global prettyPrintOptions = PrettyPrinter.createOptions(null); //metaModelManager.getPrimaryElement(namespace));
					@SuppressWarnings("null")@NonNull ArrayList<String> newArrayList = Lists.newArrayList("body", "context", "def", "endpackage", "inv", "package", "post", "inv");
					prettyPrintOptions.addReservedNames(newArrayList);	// FIXME use grammar
					prettyPrintOptions.setMetaModelManager(metaModelManager);
					Resource resource = object.eResource();
					AliasAnalysis adapter = resource != null ? AliasAnalysis.getAdapter(resource) : null;
					if (adapter != null) {
						for (@SuppressWarnings("null")@NonNull DomainPackage aliased : adapter.getAliases()) {
							DomainPackage primary = metaModelManager.getPrimaryPackage(aliased);
							if (primary instanceof Namespace) {
								String alias = adapter.getAlias((Namespace) primary);
								if (alias != null) {
									prettyPrintOptions.addAliases((Namespace) primary, alias);
								}
							}
						}
					}	
					String expr = PrettyPrinter.print(specification, prettyPrintOptions);		
					csSpec.setExprString("\t" + expr.trim().replaceAll("\\r", "").replaceAll("\\n", "\n\t\t"));
					OpaqueExpression opaqueExpression = (OpaqueExpression)specification;
					String message = PivotUtil.getMessage(opaqueExpression);
					if ((message != null) && (message.length() > 0)) {
						ContextSpecificationCS csMessageElement = context.refreshElement(ContextSpecificationCS.class, CompleteOCLCSTPackage.Literals.CONTEXT_SPECIFICATION_CS, opaqueExpression);
						csMessageElement.setExprString(message);
						csElement.setMessageSpecification(csMessageElement);
					}
				}
			}
		}
		return csElement;
	}

	@Override
	public ElementCS visitOperation(@NonNull Operation object) {
		List<Constraint> ownedRule = object.getOwnedRule();
		if (ownedRule.size() <= 0) {
			return null;
		}
		Type modelType = object.getOwningType();
		org.eclipse.ocl.examples.pivot.Package modelPackage = modelType.getPackage();
		org.eclipse.ocl.examples.pivot.Class savedScope = context.setScope((org.eclipse.ocl.examples.pivot.Class)modelType);
		OperationContextDeclCS csContext = context.refreshElement(OperationContextDeclCS.class, CompleteOCLCSTPackage.Literals.OPERATION_CONTEXT_DECL_CS, object);
		if (csContext != null) {
			refreshPathNamedElement(csContext, object, modelPackage);
//			csContext.getNamespace().add(owningType);
			csContext.setOwnedType(convertTypeRef(object));
			org.eclipse.ocl.examples.pivot.Package owningPackage = object.getOwningType().getPackage();
			if (owningPackage != null) {
				importPackage(owningPackage);
			}
			context.refreshList(csContext.getParameters(), context.visitDeclarations(ParameterCS.class, object.getOwnedParameter(), null));
			context.refreshList(csContext.getRules(), context.visitDeclarations(ContextConstraintCS.class, ownedRule, null));
			context.setScope(savedScope);
		}
		return csContext;
	}

	@Override
	public ElementCS visitPackage(@NonNull org.eclipse.ocl.examples.pivot.Package object) {
		ElementCS csElement = null;
		assert object.eContainer() != null;
		List<ContextDeclCS> contexts = new ArrayList<ContextDeclCS>();
		for (Type type : object.getOwnedType()) {
			assert type != null;
			ClassifierContextDeclCS classifierContext = context.visitDeclaration(ClassifierContextDeclCS.class, type);
			if (classifierContext !=  null) {
				contexts.add(classifierContext);
			}
			for (Operation operation : type.getOwnedOperation()) {
				assert operation != null;
				OperationContextDeclCS operationContext = context.visitDeclaration(OperationContextDeclCS.class, operation);
				if (operationContext !=  null) {
					contexts.add(operationContext);
				}
			}
			for (Property property : type.getOwnedAttribute()) {
				assert property != null;
				PropertyContextDeclCS propertyContext = context.visitDeclaration(PropertyContextDeclCS.class, property);
				if (propertyContext !=  null) {
					contexts.add(propertyContext);
				}
			}
		}
		if (contexts.size() > 0) {
			PackageDeclarationCS csPackage = context.refreshElement(PackageDeclarationCS.class, CompleteOCLCSTPackage.Literals.PACKAGE_DECLARATION_CS, object);
			if (csPackage != null) {
//				context.refreshList(csPackage.getOwnedType(), context.visitDeclarations(ClassifierCS.class, object.getOwnedType(), null));
				refreshPathNamedElement(csPackage, object, PivotUtil.getContainingNamespace(object));
				importPackage(object);
				context.refreshList(csPackage.getContexts(), contexts);
				csElement = csPackage;
			}
		}
		return csElement;
	}

	@Override
	public ElementCS visitParameter(@NonNull Parameter object) {
//		VariableCS csElement = context.refreshNamedElement(VariableCS.class, EssentialOCLCSTPackage.Literals.VARIABLE_CS, object);
		ParameterCS csElement = context.refreshNamedElement(ParameterCS.class, BaseCSTPackage.Literals.PARAMETER_CS, object);
		csElement.setOwnedType(convertTypeRef(object));
		return csElement;
	}

	@Override
	public ElementCS visitProperty(@NonNull Property object) {
		List<Constraint> ownedRule = object.getOwnedRule();
		if (ownedRule.size() <= 0) {
			return null;
		}
		Type modelType = object.getOwningType();
		org.eclipse.ocl.examples.pivot.Package modelPackage = modelType.getPackage();
		org.eclipse.ocl.examples.pivot.Class savedScope = context.setScope((org.eclipse.ocl.examples.pivot.Class)modelType);
		PropertyContextDeclCS csContext = context.refreshElement(PropertyContextDeclCS.class, CompleteOCLCSTPackage.Literals.PROPERTY_CONTEXT_DECL_CS, object);
		if ((csContext != null) && (modelPackage != null)) {
			refreshPathNamedElement(csContext, object, modelPackage);
	//		csContext.getNamespace().add(owningType);
			csContext.setOwnedType(convertTypeRef(object));
			importPackage(modelPackage);
			context.refreshList(csContext.getRules(), context.visitDeclarations(ContextConstraintCS.class, ownedRule, null));
			context.setScope(savedScope);
		}
		return csContext;
	}

	@Override
	public ElementCS visitRoot(@NonNull Root object) {
		ElementCS csElement;
		assert object.eContainer() == null;
		CompleteOCLDocumentCS csDocument = context.refreshElement(CompleteOCLDocumentCS.class, CompleteOCLCSTPackage.Literals.COMPLETE_OCL_DOCUMENT_CS, object);
		List<org.eclipse.ocl.examples.pivot.Package> allPackages = new ArrayList<org.eclipse.ocl.examples.pivot.Package>();
		List<Package> nestedPackages = object.getNestedPackage();
		assert nestedPackages != null;
		gatherPackages(allPackages, nestedPackages); 
		context.refreshList(csDocument.getPackages(), context.visitDeclarations(PackageDeclarationCS.class, allPackages, null));
		csElement = csDocument;
		return csElement;
	}

	@Override
	public ElementCS visitType(@NonNull Type object) {
		List<Constraint> ownedRule = object.getOwnedRule();
		if (ownedRule.size() <= 0) {
			return null;
		}
		org.eclipse.ocl.examples.pivot.Package objectPackage = object.getPackage();
		ClassifierContextDeclCS csContext = context.refreshElement(ClassifierContextDeclCS.class, CompleteOCLCSTPackage.Literals.CLASSIFIER_CONTEXT_DECL_CS, object);
		if ((csContext != null) && (objectPackage != null)) {
			refreshPathNamedElement(csContext, object, objectPackage);
			importPackage(objectPackage);
			context.refreshList(csContext.getRules(), context.visitDeclarations(ContextConstraintCS.class, ownedRule, null));
		}
		return csContext;
	}
}