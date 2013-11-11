/**
 * <copyright>
 *
 * Copyright (c) 2012, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 	 E.D.Willink (Obeo) - Bug 416287 - tuple-valued constraints
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.xtext.base.cs2as;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Annotation;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.DataType;
import org.eclipse.ocl.examples.pivot.Detail;
import org.eclipse.ocl.examples.pivot.EnumerationLiteral;
import org.eclipse.ocl.examples.pivot.Import;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.OpaqueExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.PivotConstants;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.basecs.AbstractPackageCS;
import org.eclipse.ocl.examples.xtext.base.basecs.AnnotationCS;
import org.eclipse.ocl.examples.xtext.base.basecs.AnnotationElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage;
import org.eclipse.ocl.examples.xtext.base.basecs.ClassCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ClassifierCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ConstraintCS;
import org.eclipse.ocl.examples.xtext.base.basecs.DataTypeCS;
import org.eclipse.ocl.examples.xtext.base.basecs.DetailCS;
import org.eclipse.ocl.examples.xtext.base.basecs.DocumentationCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ElementRefCS;
import org.eclipse.ocl.examples.xtext.base.basecs.EnumerationCS;
import org.eclipse.ocl.examples.xtext.base.basecs.EnumerationLiteralCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ImportCS;
import org.eclipse.ocl.examples.xtext.base.basecs.LambdaTypeCS;
import org.eclipse.ocl.examples.xtext.base.basecs.LibraryCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ModelElementRefCS;
import org.eclipse.ocl.examples.xtext.base.basecs.MultiplicityBoundsCS;
import org.eclipse.ocl.examples.xtext.base.basecs.MultiplicityStringCS;
import org.eclipse.ocl.examples.xtext.base.basecs.NamedElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.OperationCS;
import org.eclipse.ocl.examples.xtext.base.basecs.PackageCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ParameterCS;
import org.eclipse.ocl.examples.xtext.base.basecs.PathElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.PathNameCS;
import org.eclipse.ocl.examples.xtext.base.basecs.PrimitiveTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.basecs.RootPackageCS;
import org.eclipse.ocl.examples.xtext.base.basecs.SpecificationCS;
import org.eclipse.ocl.examples.xtext.base.basecs.StructuralFeatureCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TemplateBindingCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TemplateParameterCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TemplateParameterSubstitutionCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TemplateSignatureCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TuplePartCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TupleTypeCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TypeRefCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TypedRefCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TypedTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.basecs.WildcardTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.basecs.util.AbstractExtendingBaseCSVisitor;
import org.eclipse.ocl.examples.xtext.base.basecs.util.VisitableCS;
import org.eclipse.ocl.examples.xtext.base.utilities.ElementUtil;

public class BaseCSContainmentVisitor extends AbstractExtendingBaseCSVisitor<Continuation<?>, CS2PivotConversion>
{
	protected final @NonNull MetaModelManager metaModelManager;

	public BaseCSContainmentVisitor(@NonNull CS2PivotConversion context) {
		super(context);
		metaModelManager = context.getMetaModelManager();
	}

	protected void importPackages(@NonNull RootPackageCS csElement) { // FIXME: CS2Pivot.computeRootContainmentFeatures may make this redundant
		for (LibraryCS csLibrary : csElement.getOwnedLibrary()) {
			csLibrary.getPackage();						// Resolve the proxy to perform the import.
		}
		for (ImportCS csImport : csElement.getOwnedImport()) {
			csImport.getNamespace();					// Resolve the proxy to perform the import.
		}
	}


	protected Continuation<?> refreshClass(@NonNull org.eclipse.ocl.examples.pivot.Class pivotElement, @NonNull ClassCS csElement) {
		List<String> qualifiers = csElement.getQualifier();
		pivotElement.setIsAbstract(qualifiers.contains("abstract"));
		pivotElement.setIsInterface(qualifiers.contains("interface"));
		pivotElement.setIsStatic(qualifiers.contains("static"));
		context.refreshPivotList(Property.class, pivotElement.getOwnedAttribute(), csElement.getOwnedProperty());
		context.refreshPivotList(Operation.class, pivotElement.getOwnedOperation(), csElement.getOwnedOperation());
		refreshClassifier(pivotElement, csElement);
		return null;
	}

	protected Type refreshClassifier(@NonNull Type pivotElement, @NonNull ClassifierCS csElement) {
		if (csElement.eIsSet(BaseCSPackage.Literals.CLASSIFIER_CS__INSTANCE_CLASS_NAME)) {
			pivotElement.setInstanceClassName(csElement.getInstanceClassName());
		}
		else {
			pivotElement.eUnset(PivotPackage.Literals.TYPE__INSTANCE_CLASS_NAME);
		}
		String newInstanceClassName = csElement.getInstanceClassName();
		String oldInstanceClassName = pivotElement.getInstanceClassName();
		if ((newInstanceClassName != oldInstanceClassName) && ((newInstanceClassName == null) || !newInstanceClassName.equals(oldInstanceClassName))) {
			pivotElement.setInstanceClassName(newInstanceClassName);
		}
		context.refreshTemplateSignature(csElement, pivotElement);
		context.refreshPivotList(Constraint.class, pivotElement.getOwnedInvariant(), csElement.getOwnedConstraint());
		return pivotElement;
	}

	protected @Nullable <T extends NamedElement> T refreshNamedElement(@NonNull Class<T> pivotClass, /*@NonNull*/ EClass pivotEClass, @NonNull NamedElementCS csElement) {
		T pivotElement = context.refreshModelElement(pivotClass, pivotEClass, csElement);
		String name = csElement.getName();
		if ((pivotElement != null) && (name != null)) {
			context.refreshName(pivotElement, name);
			context.refreshComments(pivotElement, csElement);
		}
		return pivotElement;
	}

	protected <T extends org.eclipse.ocl.examples.pivot.Package> T refreshPackage(@NonNull Class<T> pivotClass, /*@NonNull*/ EClass pivotEClass, @NonNull PackageCS csElement) {
		assert pivotEClass != null;
		Object pivotObject = csElement.getPivot();
		if (pivotObject == null) {
			pivotObject = context.getOldPackageByQualifiedName(csElement);
		}
		String name = csElement.getName();
		if (name == null) {
			throw new IllegalStateException("Null name");
		}
/*		if ((name == null) && (csElement.eContainer() == null)) {
			Resource csResource = csElement.eResource();
			if (csResource != null) {
				URI csURI = csResource.getURI();
				if (csURI != null) {
					name = csURI.lastSegment();
				}
			}
		} */
		if (pivotObject == null) {
			pivotObject = context.getOldPackageBySimpleName(name);
		}
		T pivotElement;
		if (pivotObject == null) {
			pivotElement = metaModelManager.createPackage(pivotClass, pivotEClass, name, csElement.getNsURI());
		}
		else {
			if (!pivotClass.isAssignableFrom(pivotObject.getClass())) {
				throw new ClassCastException();
			}
			@SuppressWarnings("unchecked")
			T pivotElement2 = (T) pivotObject;
			pivotElement = pivotElement2;
			context.refreshName(pivotElement, name);
		}
		context.getConverter().installPivotDefinition(csElement, pivotElement);
		context.refreshComments(pivotElement, csElement);
		String newNsPrefix = csElement.getNsPrefix();
		String oldNsPrefix = pivotElement.getNsPrefix();
		if ((newNsPrefix != oldNsPrefix) && ((newNsPrefix == null) || !newNsPrefix.equals(oldNsPrefix))) {
			pivotElement.setNsPrefix(newNsPrefix);
		}
		String newNsURI = csElement.getNsURI();
		String oldNsURI = pivotElement.getNsURI();
		if ((newNsURI != oldNsURI) && ((newNsURI == null) || !newNsURI.equals(oldNsURI))) {
			pivotElement.setNsURI(newNsURI);
		}
		context.refreshPivotList(org.eclipse.ocl.examples.pivot.Package.class, pivotElement.getNestedPackage(), csElement.getOwnedNestedPackage());
		context.refreshPivotList(Type.class, pivotElement.getOwnedType(), csElement.getOwnedType());
		return pivotElement;
	}

	protected <T extends Root> T refreshRoot(@NonNull Class<T> pivotClass, /*@NonNull*/ EClass pivotEClass, @NonNull AbstractPackageCS csElement) {
		assert pivotEClass != null;
		Resource csResource = csElement.eResource();
		if (csResource == null) {
			throw new IllegalStateException("Null resource for root package");
		}
		Object pivotObject = csElement.getPivot();
		if (pivotObject == null) {
			Resource asResource = context.getConverter().getPivotResource(csResource);
			if (asResource != null) {
				for (EObject oldRoot : asResource.getContents()) {
					if (oldRoot instanceof Root) {
						pivotObject = oldRoot;
						break;
					}
				}
			}
		}
		URI csURI = null;
		String name = csElement.getName();
		if ((name == null) && (csElement.eContainer() == null)) {
			csURI = csResource.getURI();
			if (csURI != null) {
				name = csURI.lastSegment();
			}
		}
		if (name == null) {
			throw new IllegalStateException("Null name for root package");
		}
		T pivotElement;
		if (pivotObject == null) {
			pivotElement = metaModelManager.createRoot(pivotClass, pivotEClass, name, csElement.getNsURI());
		}
		else {
			if (!pivotClass.isAssignableFrom(pivotObject.getClass())) {
				throw new ClassCastException();
			}
			@SuppressWarnings("unchecked")
			T pivotElement2 = (T) pivotObject;
			pivotElement = pivotElement2;
			context.refreshName(pivotElement, name);
		}
		context.getConverter().installPivotDefinition(csElement, pivotElement);
		context.refreshComments(pivotElement, csElement);
		String newNsURI = csElement.eResource().getURI().toString(); //csElement.getNsURI();
		String oldNsURI = pivotElement.getExternalURI();
		if ((newNsURI != oldNsURI) && ((newNsURI == null) || !newNsURI.equals(oldNsURI))) {
			pivotElement.setExternalURI(newNsURI);
		}
		context.refreshPivotList(org.eclipse.ocl.examples.pivot.Package.class, pivotElement.getNestedPackage(), csElement.getOwnedNestedPackage());
		return pivotElement;
	}

	protected void refreshSerializable(DataType pivotElement, ClassifierCS csElement) {
		List<String> qualifiers = csElement.getQualifier();
		pivotElement.setIsSerializable(qualifiers.contains("serializable"));
	}
	
	@Override
	public Continuation<?> visitAnnotationCS(@NonNull AnnotationCS csElement) {
		@SuppressWarnings("null") @NonNull EClass eClass = PivotPackage.Literals.ANNOTATION;
		refreshNamedElement(Annotation.class, eClass, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitAnnotationElementCS(@NonNull AnnotationElementCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitClassCS(@NonNull ClassCS csElement) {
		@SuppressWarnings("null") @NonNull EClass eClass = PivotPackage.Literals.CLASS;
		org.eclipse.ocl.examples.pivot.Class pivotElement = refreshNamedElement(org.eclipse.ocl.examples.pivot.Class.class, eClass, csElement);
		if (pivotElement != null) {
			refreshClass(pivotElement, csElement);
		}
		return null;
	}

	@Override
	public Continuation<?> visitConstraintCS(@NonNull ConstraintCS csElement) {
		@SuppressWarnings("null") @NonNull EClass eClass = PivotPackage.Literals.CONSTRAINT;
		Constraint pivotElement = refreshNamedElement(Constraint.class, eClass, csElement);
		if (pivotElement != null) {
			pivotElement.setSpecification(PivotUtil.getPivot(OpaqueExpression.class, csElement.getSpecification()));
		}
		return null;
	}

	@Override
	public Continuation<?> visitDataTypeCS(@NonNull DataTypeCS csElement) {
		@SuppressWarnings("null") @NonNull EClass eClass = PivotPackage.Literals.DATA_TYPE;
		DataType pivotElement = refreshNamedElement(DataType.class, eClass, csElement);
		if (pivotElement != null) {
			refreshSerializable(pivotElement, csElement);
			refreshClassifier(pivotElement, csElement);
		}
		return null;
	}

	@Override
	public Continuation<?> visitDetailCS(@NonNull DetailCS csElement) {
		@SuppressWarnings("null") @NonNull EClass eClass = PivotPackage.Literals.DETAIL;
		refreshNamedElement(Detail.class, eClass, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitDocumentationCS(@NonNull DocumentationCS csElement) {
		@SuppressWarnings("null") @NonNull EClass eClass = PivotPackage.Literals.ANNOTATION;
		refreshNamedElement(Annotation.class, eClass, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitElementCS(@NonNull ElementCS csElement) {
// FIXME		return visiting(csElement);
		System.out.println("Unsupported " + csElement.eClass().getName() + " for CS2Pivot Containment pass");
		return null;
	}

	@Override
	public Continuation<?> visitElementRefCS(@NonNull ElementRefCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitEnumerationCS(@NonNull EnumerationCS csElement) {
		@SuppressWarnings("null") @NonNull EClass eClass = PivotPackage.Literals.ENUMERATION;
		org.eclipse.ocl.examples.pivot.Enumeration pivotElement = refreshNamedElement(org.eclipse.ocl.examples.pivot.Enumeration.class, eClass, csElement);
		if (pivotElement != null) {
			context.refreshPivotList(EnumerationLiteral.class, pivotElement.getOwnedLiteral(), csElement.getOwnedLiterals());
			refreshSerializable(pivotElement, csElement);
			refreshClassifier(pivotElement, csElement);
		}
		return null;
	}

	@Override
	public Continuation<?> visitEnumerationLiteralCS(@NonNull EnumerationLiteralCS csElement) {
		@SuppressWarnings("null") @NonNull EClass eClass = PivotPackage.Literals.ENUMERATION_LITERAL;
		EnumerationLiteral pivotElement = refreshNamedElement(EnumerationLiteral.class, eClass, csElement);
		if (pivotElement != null) {
			pivotElement.setValue(BigInteger.valueOf(csElement.getValue()));
		}
		return null;
	}

	@Override
	public Continuation<?> visitImportCS(@NonNull ImportCS csElement) {
		Import pivotElement = refreshNamedElement(Import.class, PivotPackage.Literals.IMPORT, csElement);
		if (pivotElement != null) {
			PathNameCS pathName = csElement.getPathName();
			if (pathName != null) {
				CS2Pivot.setElementType(pathName, PivotPackage.Literals.NAMESPACE, csElement, null);
			}
			if (csElement.isAll() && (csElement.getName() != null)) {
				context.addDiagnostic(csElement, "An all-package import cannot have an associated alias name");
			}
		}
		return null;								// FIXME: CS2Pivot.computeRootContainmentFeatures may allow the above now
	}

	@Override
	public Continuation<?> visitLambdaTypeCS(@NonNull LambdaTypeCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitLibraryCS(@NonNull LibraryCS csElement) {
//		csElement.getPackage();						// Resolve the proxy to perform the import.
		return null;								// FIXME: CS2Pivot.computeRootContainmentFeatures may allow the above now
	}

	@Override
	public Continuation<?> visitModelElementRefCS(@NonNull ModelElementRefCS csElement) {
		PathNameCS pathName = csElement.getPathName();
		if (pathName != null) {
			CS2Pivot.setElementType(pathName, PivotPackage.Literals.ELEMENT, csElement, null);
		}
		return null;
	}

	@Override
	public Continuation<?> visitMultiplicityBoundsCS(@NonNull MultiplicityBoundsCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitMultiplicityStringCS(@NonNull MultiplicityStringCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitOperationCS(@NonNull OperationCS csElement) {
		@SuppressWarnings("null") @NonNull EClass eClass = PivotPackage.Literals.OPERATION;
		Operation pivotElement = refreshNamedElement(Operation.class, eClass, csElement);
		if (pivotElement != null) {
			context.refreshTemplateSignature(csElement, pivotElement);
			context.refreshPivotList(Parameter.class, pivotElement.getOwnedParameter(), csElement.getOwnedParameter());
			context.refreshPivotList(Constraint.class, pivotElement.getPrecondition(), csElement.getOwnedPrecondition());
			context.refreshPivotList(Constraint.class, pivotElement.getPostcondition(), csElement.getOwnedPostcondition());
			List<SpecificationCS> csBodyExpressions = csElement.getOwnedBodyExpression();
			SpecificationCS csBodyExpression = csBodyExpressions.size() > 0 ? csBodyExpressions.get(0) : null;
			pivotElement.setBodyExpression(PivotUtil.getPivot(OpaqueExpression.class, csBodyExpression));
		}
		return null;
	}

	@Override
	public Continuation<?> visitPackageCS(@NonNull PackageCS csElement) {
		@SuppressWarnings("null") @NonNull EClass eClass = PivotPackage.Literals.PACKAGE;
		refreshPackage(org.eclipse.ocl.examples.pivot.Package.class, eClass, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitParameterCS(@NonNull ParameterCS csElement) {
		@SuppressWarnings("null") @NonNull EClass eClass = PivotPackage.Literals.PARAMETER;
		refreshNamedElement(Parameter.class, eClass, csElement);
		return null;
	}

	@Override
	public Continuation<?> visitPathElementCS(@NonNull PathElementCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitPathNameCS(@NonNull PathNameCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitPrimitiveTypeRefCS(@NonNull PrimitiveTypeRefCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitRootPackageCS(@NonNull RootPackageCS csElement) {
		importPackages(csElement);
		@SuppressWarnings("null") @NonNull EClass eClass = PivotPackage.Literals.ROOT;
		Root root = refreshRoot(Root.class, eClass, csElement);
		EList<ImportCS> csImports = csElement.getOwnedImport();
		if (csImports.size() > 0) {
			List<Import> newImports = new ArrayList<Import>(csImports.size());
			for (ImportCS csImport : csImports) {
				Import pivotElement = PivotUtil.getPivot(Import.class, csImport);
				if (pivotElement != null) {
					pivotElement.setImportedNamespace(csImport.getNamespace());
				}
				newImports.add(pivotElement);
			}
			context.refreshList(root.getImports(), newImports);
		}
		else {
			root.getImports().clear();
		}
		return null;
	}

	@Override
	public Continuation<?> visitSpecificationCS(@NonNull SpecificationCS csElement) {
		@SuppressWarnings("null") @NonNull EClass eClass = PivotPackage.Literals.OPAQUE_EXPRESSION;
		OpaqueExpression pivotElement = context.refreshModelElement(OpaqueExpression.class, eClass, csElement);
		if (pivotElement != null) {
			pivotElement.getLanguage().add(PivotConstants.OCL_LANGUAGE);
			pivotElement.getBody().add(csElement.getExprString());
		}
		return null;
	}

	@Override
	public Continuation<?> visitStructuralFeatureCS(@NonNull StructuralFeatureCS csElement) {
		@SuppressWarnings("null") @NonNull EClass eClass = PivotPackage.Literals.PROPERTY;
		Property pivotElement = refreshNamedElement(Property.class, eClass, csElement);
		if (pivotElement != null) {
			List<String> qualifiers = csElement.getQualifier();
			pivotElement.setIsComposite(qualifiers.contains("composes"));
			pivotElement.setIsDerived(qualifiers.contains("derived"));
			pivotElement.setIsID(qualifiers.contains("id"));
			pivotElement.setIsReadOnly(qualifiers.contains("readonly"));
			pivotElement.setIsResolveProxies(ElementUtil.getQualifier(qualifiers, "resolve", "!resolve", true));
			pivotElement.setIsStatic(qualifiers.contains("static"));
			pivotElement.setIsTransient(qualifiers.contains("transient"));
			pivotElement.setIsUnsettable(qualifiers.contains("unsettable"));
			pivotElement.setIsVolatile(qualifiers.contains("volatile"));
			if (csElement.eIsSet(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT)) {
				pivotElement.setDefault(csElement.getDefault());
			}
			else {
				pivotElement.eUnset(PivotPackage.Literals.PROPERTY__DEFAULT);
			}
			List<SpecificationCS> csDefaultExpressions = csElement.getOwnedDefaultExpression();
			SpecificationCS csDefaultExpression = csDefaultExpressions.size() > 0 ? csDefaultExpressions.get(0) : null;
			pivotElement.setDefaultExpression(PivotUtil.getPivot(OpaqueExpression.class, csDefaultExpression));
		}
		return null;
	}

	@Override
	public Continuation<?> visitTemplateBindingCS(@NonNull TemplateBindingCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitTemplateParameterCS(@NonNull TemplateParameterCS csElement) {
		@SuppressWarnings("null") @NonNull EClass eClass = PivotPackage.Literals.CLASS;
		org.eclipse.ocl.examples.pivot.Class pivotElement = refreshNamedElement(org.eclipse.ocl.examples.pivot.Class.class, eClass, csElement);
		if (pivotElement != null) {
			TemplateParameter pivotTemplateParameter = pivotElement.getOwningTemplateParameter();
			if (pivotTemplateParameter == null) {
				pivotTemplateParameter = PivotFactory.eINSTANCE.createTypeTemplateParameter();
				pivotTemplateParameter.setOwnedParameteredElement(pivotElement);
			}
		}
		return null;
	}

	@Override
	public Continuation<?> visitTemplateParameterSubstitutionCS(@NonNull TemplateParameterSubstitutionCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitTemplateSignatureCS(@NonNull TemplateSignatureCS csElement) {
		@SuppressWarnings("null") @NonNull EClass eClass = PivotPackage.Literals.TEMPLATE_SIGNATURE;
		TemplateSignature pivotElement = context.refreshModelElement(TemplateSignature.class, eClass, csElement);
		if (pivotElement != null) {
			List<TemplateParameter> newPivotTemplateParameters = new ArrayList<TemplateParameter>();
			List<TemplateParameterCS> csTemplateParameters = csElement.getOwnedTemplateParameter();
			for (TemplateParameterCS csTemplateParameter : csTemplateParameters) {
				org.eclipse.ocl.examples.pivot.Class pivotTemplateParameterClass = PivotUtil.getPivot(org.eclipse.ocl.examples.pivot.Class.class, csTemplateParameter);
				if (pivotTemplateParameterClass != null) {
					TemplateParameter pivotTemplateParameter = pivotTemplateParameterClass.getOwningTemplateParameter();
					newPivotTemplateParameters.add(pivotTemplateParameter);
				}
			}
			PivotUtil.refreshList(pivotElement.getOwnedParameter(), newPivotTemplateParameters);
		}
		return null;
	}

	@Override
	public Continuation<?> visitTuplePartCS(@NonNull TuplePartCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitTupleTypeCS(@NonNull TupleTypeCS csElement) {
		return null;
	}


	@Override
	public Continuation<?> visitTypeRefCS(@NonNull TypeRefCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitTypedRefCS(@NonNull TypedRefCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitTypedTypeRefCS(@NonNull TypedTypeRefCS csElement) {
		PathNameCS pathName = csElement.getPathName();
		if (pathName != null) {
			CS2Pivot.setElementType(pathName, PivotPackage.Literals.TYPE, csElement, null);
		}
		return null;
	}

	@Override
	public Continuation<?> visitWildcardTypeRefCS(@NonNull WildcardTypeRefCS csElement) {
		@SuppressWarnings("null") @NonNull EClass eClass = PivotPackage.Literals.CLASS;
		org.eclipse.ocl.examples.pivot.Class pivotElement = context.refreshModelElement(org.eclipse.ocl.examples.pivot.Class.class, eClass, null);
		if (pivotElement != null) {
			context.installPivotReference(csElement, pivotElement, BaseCSPackage.Literals.PIVOTABLE_ELEMENT_CS__PIVOT);
		}
		return null;
	}

	public Continuation<?> visiting(@NonNull VisitableCS visitable) {
		throw new IllegalArgumentException("Unsupported " + visitable.eClass().getName() + " for CS2Pivot Containment pass");
	}
}