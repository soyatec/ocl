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
 * $Id: BasePostOrderVisitor.java,v 1.10 2011/05/20 15:27:24 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.cs2pivot;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Annotation;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Detail;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.OpaqueExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypedMultiplicityElement;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.baseCST.AnnotationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.AnnotationElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ConstraintCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.DetailCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.DocumentationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ImportCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.LambdaTypeCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.LibraryCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.MultiplicityBoundsCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.MultiplicityStringCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.NamedElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.OperationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PackageCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PathElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PathNameCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PrimitiveTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ReferenceCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.RootPackageCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.SpecificationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateBindingCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateParameterCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateParameterSubstitutionCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateSignatureCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateableElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TuplePartCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TupleTypeCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.WildcardTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.util.AbstractExtendingBaseCSVisitor;
import org.eclipse.ocl.examples.xtext.base.util.VisitableCS;

public class BasePostOrderVisitor extends AbstractExtendingBaseCSVisitor<Continuation<?>, CS2PivotConversion>
{
	public static class ListCompletion<CST extends ModelElementCS, P extends NamedElement> extends MultipleContinuation<CST>
	{
		protected final @NonNull Class<P> pivotClass;
		protected final List<P> pivotElements;

		protected ListCompletion(@NonNull CS2PivotConversion context, NamedElement pivotParent, EStructuralFeature pivotFeature,
				@NonNull List<? extends CST> csElements, Dependency[] dependencies, @NonNull Class<P> pivotClass, List<P> pivotElements) {
			super(context, pivotParent, pivotFeature, csElements, dependencies);
			this.pivotClass = pivotClass;
			this.pivotElements = pivotElements;
		}

		@Override
		public BasicContinuation<?> execute() {
			context.refreshPivotList(pivotClass, pivotElements, csElement);
			return null;
		}
	}

	public static class SpecificationCSCompletion extends SingleContinuation<SpecificationCS>
	{
		public SpecificationCSCompletion(@NonNull CS2PivotConversion context, @NonNull SpecificationCS csElement) {
			super(context, null, null, csElement);
		}

		@Override
		public BasicContinuation<?> execute() {
			EStructuralFeature eContainingFeature = csElement.eContainingFeature();
			OpaqueExpression pivotElement = PivotUtil.getPivot(OpaqueExpression.class, csElement);
			if (pivotElement instanceof ExpressionInOCL) {
				ExpressionInOCL pivotElement2 = (ExpressionInOCL) pivotElement;
				if (eContainingFeature == BaseCSTPackage.Literals.CONSTRAINT_CS__MESSAGE_SPECIFICATION) {
					context.refreshContextVariable(pivotElement2);
					context.visitLeft2Right(ExpressionInOCL.class, csElement);
				}
				else {
					context.refreshContextVariable(pivotElement2);
					context.visitLeft2Right(ExpressionInOCL.class, csElement);
					OCLExpression bodyExpression = pivotElement2.getBodyExpression();
					if (bodyExpression != null) {
						pivotElement.setType(bodyExpression.getType());
					}
				}
			}
			return null;
		}
	}
	
	protected final @NonNull MetaModelManager metaModelManager;
	
	public BasePostOrderVisitor(@NonNull CS2PivotConversion context) {
		super(context);
		this.metaModelManager= context.getMetaModelManager();
	}

	protected @Nullable TemplateableElementCS getTemplateableElementContainer(@NonNull ElementCS csElement) {
		for (EObject eObject = csElement; eObject != null; eObject = eObject.eContainer())
			if (eObject instanceof TemplateableElementCS) {
				return (TemplateableElementCS) eObject;
			}
		return null;
	}

	protected <CST extends ModelElementCS, P extends NamedElement> BasicContinuation<?> refreshList(@NonNull NamedElement pivotParent, @NonNull EStructuralFeature pivotFeature,
		final @NonNull Class<P> pivotClass, final @NonNull List<P> pivotElements, @NonNull List<CST> csElements) {
		if (csElements.isEmpty()) {
			context.refreshPivotList(pivotClass, pivotElements, csElements);
			return null;
		}
		else {
			return new ListCompletion<CST, P>(context, pivotParent, pivotFeature, csElements,
				new Dependency[]{new PivotDependencies(csElements)}, pivotClass, pivotElements);
		}
	}

	public Continuation<?> visiting(@NonNull VisitableCS visitable) {
		throw new IllegalArgumentException("Unsupported " + visitable.eClass().getName() + " for CS2Pivot PostOrder pass");
	}

	@Override
	public Continuation<?> visitAnnotationCS(@NonNull AnnotationCS csAnnotation) {
		Annotation pivotElement = PivotUtil.getPivot(Annotation.class, csAnnotation);
		if (pivotElement != null) {
			context.handleVisitNamedElement(csAnnotation, pivotElement);
			context.refreshPivotList(Detail.class, pivotElement.getOwnedDetail(), csAnnotation.getOwnedDetail());
			context.refreshPivotList(Element.class, pivotElement.getOwnedContent(), csAnnotation.getOwnedContent());
			List<ModelElementRefCS> csReferences = csAnnotation.getOwnedReference();
			if (csReferences.size() > 0) {
				List<Element> references = new ArrayList<Element>(csReferences.size());
				for (ModelElementRefCS csReference : csReferences) {
					Element element = csReference.getElement();
					if (element != null) {
						references.add(element);
					}
				}
				context.refreshList(pivotElement.getReference(), references);
			}
			else {
				pivotElement.getReference().clear();
			}
		}
		return null;
	}

	@Override
	public Continuation<?> visitAnnotationElementCS(@NonNull AnnotationElementCS csAnnotationElement) {
		return null;
	}

	@Override
	public Continuation<?> visitClassifierCS(@NonNull ClassifierCS csClassifier) {
		Type pivotElement = PivotUtil.getPivot(Type.class, csClassifier);
		if (pivotElement != null) {
			context.handleVisitNamedElement(csClassifier, pivotElement);
			context.refreshPivotList(Constraint.class, pivotElement.getOwnedInvariant(), csClassifier.getOwnedConstraint());
		}
		return null;
	}

	@Override
	public Continuation<?> visitConstraintCS(@NonNull ConstraintCS csConstraint) {
		return null;
	}

	@Override
	public Continuation<?> visitDetailCS(@NonNull DetailCS csDetail) {
		Detail pivotElement = PivotUtil.getPivot(Detail.class, csDetail);
		if (pivotElement != null) {
			context.handleVisitNamedElement(csDetail, pivotElement);
//			refreshPivotList(Detail.class, pivotElement.getOwnedDetail(), csDocumentation.getOwnedDetail());
			List<String> newValues = csDetail.getValue();
			List<String> pivotValues = pivotElement.getValue();
			pivotValues.clear();
			pivotValues.addAll(newValues);
		}
		return null;
	}

	@Override
	public Continuation<?> visitDocumentationCS(@NonNull DocumentationCS csDocumentation) {
		Annotation pivotElement = PivotUtil.getPivot(Annotation.class, csDocumentation);
		if (pivotElement != null) {
			context.handleVisitNamedElement(csDocumentation, pivotElement);
			context.refreshPivotList(Detail.class, pivotElement.getOwnedDetail(), csDocumentation.getOwnedDetail());
		}
		return null;
	}

	@Override
	public Continuation<?> visitElementCS(@NonNull ElementCS csElement) {
		return visiting(csElement);
	}

	@Override
	public Continuation<?> visitImportCS(@NonNull ImportCS object) {
		return null;
	}

	@Override
	public Continuation<?> visitLambdaTypeCS(@NonNull LambdaTypeCS object) {
		return null;
	}

	@Override
	public Continuation<?> visitLibraryCS(@NonNull LibraryCS object) {
		return null;
	}

	@Override
	public Continuation<?> visitModelElementCS(@NonNull ModelElementCS csModelElement) {
		return null;
	}

	@Override
	public Continuation<?> visitModelElementRefCS(@NonNull ModelElementRefCS object) {
		Element element = object.getPathName().getElement();
		if (element != null) {
			context.installPivotReference(object, element, BaseCSTPackage.Literals.PIVOTABLE_ELEMENT_CS__PIVOT);
		}
		return null;
	}

	@Override
	public Continuation<?> visitMultiplicityBoundsCS(@NonNull MultiplicityBoundsCS object) {
		return null;
	}

	@Override
	public Continuation<?> visitMultiplicityStringCS(@NonNull MultiplicityStringCS object) {
		return null;
	}

	@Override
	public Continuation<?> visitNamedElementCS(@NonNull NamedElementCS csNamedElement) {
		NamedElement pivotElement = PivotUtil.getPivot(NamedElement.class, csNamedElement);
		if (pivotElement != null) {
			context.handleVisitNamedElement(csNamedElement, pivotElement);
		}
		return null;
	}

	@Override
	public Continuation<?> visitOperationCS(@NonNull OperationCS csElement) {
		Operation pivotOperation = PivotUtil.getPivot(Operation.class, csElement);
		if (pivotOperation != null) {
			context.refreshList(Type.class, pivotOperation.getRaisedException(), csElement.getOwnedException());
		}
		return super.visitOperationCS(csElement);
	}

	@Override
	public Continuation<?> visitPackageCS(@NonNull PackageCS csPackage) {
		org.eclipse.ocl.examples.pivot.Package pivotElement = PivotUtil.getPivot(org.eclipse.ocl.examples.pivot.Package.class, csPackage);
		if (pivotElement != null) {
			context.handleVisitNamedElement(csPackage, pivotElement);
		}
		return null;
	}

	@Override
	public Continuation<?> visitPathElementCS(@NonNull PathElementCS object) {
		return null;
	}

	@Override
	public Continuation<?> visitPathNameCS(@NonNull PathNameCS object) {
		return null;
	}

	@Override
	public Continuation<?> visitPrimitiveTypeRefCS(@NonNull PrimitiveTypeRefCS csPrimitiveTypeRef) {
		return null;
	}

	@Override
	public Continuation<?> visitReferenceCS(@NonNull ReferenceCS csReference) {
		Property pivotElement = PivotUtil.getPivot(Property.class, csReference);
		if (pivotElement != null) {
			Property pivotOpposite = csReference.getOpposite();
			if ((pivotOpposite != null) && pivotOpposite.eIsProxy()) {
				pivotOpposite = null;
			}
			pivotElement.setOpposite(pivotOpposite);
			context.refreshList(pivotElement.getKeys(), csReference.getKeys());
			BasicContinuation<?> continuation = visitTypedElementCS(csReference);
			assert continuation == null;
			if (pivotOpposite == null) {
				List<Property> ambiguousOpposites = metaModelManager.installPropertyDeclaration(pivotElement);
				// FIXME accumulate, prune ambiguousOpposites
			}
		}
		return super.visitReferenceCS(csReference);
	}

	@Override
	public Continuation<?> visitRootPackageCS(@NonNull RootPackageCS csPackage) {
		Root pivotElement = PivotUtil.getPivot(Root.class, csPackage);
		if (pivotElement != null) {
			context.handleVisitNamedElement(csPackage, pivotElement);
		}
		return null;
	}

	@Override
	public Continuation<?> visitSpecificationCS(@NonNull SpecificationCS csSpecification) {
		OpaqueExpression pivotElement = PivotUtil.getPivot(OpaqueExpression.class, csSpecification);
		if (pivotElement != null) {
			return new SpecificationCSCompletion(context, csSpecification);
		}
		return null;
	}

	@Override
	public Continuation<?> visitTemplateBindingCS(@NonNull TemplateBindingCS csTemplateBinding) {
		return null;
	}

	@Override
	public Continuation<?> visitTemplateParameterCS(@NonNull TemplateParameterCS csTemplateParameter) {
		return null;
	}

	@Override
	public Continuation<?> visitTemplateParameterSubstitutionCS(@NonNull TemplateParameterSubstitutionCS csTemplateParameterSubstitution) {
		return null;
	}
	
	@Override
	public Continuation<?> visitTemplateSignatureCS(@NonNull TemplateSignatureCS csTemplateSignature) {
		return null;
	}

	@Override
	public Continuation<?> visitTuplePartCS(@NonNull TuplePartCS object) {
		return null;
	}

	@Override
	public Continuation<?> visitTupleTypeCS(@NonNull TupleTypeCS object) {
		return null;
	}

	@Override
	public BasicContinuation<?> visitTypedElementCS(@NonNull TypedElementCS csTypedElement) {
		TypedMultiplicityElement pivotElement = PivotUtil.getPivot(TypedMultiplicityElement.class, csTypedElement);
		if (pivotElement != null) {
			context.handleVisitNamedElement(csTypedElement, pivotElement);
			context.refreshRequiredType(pivotElement, csTypedElement);
		}
		return null;
	}

	@Override
	public Continuation<?> visitTypedTypeRefCS(@NonNull TypedTypeRefCS object) {
		return null;
	}

	@Override
	public Continuation<?> visitWildcardTypeRefCS(@NonNull WildcardTypeRefCS object) {
		return null;
	}
}