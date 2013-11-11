/**
 * <copyright>
 *
 * Copyright (c) 2010, 2013 E.D.Willink and others.
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
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypedMultiplicityElement;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.basecs.AnnotationCS;
import org.eclipse.ocl.examples.xtext.base.basecs.AnnotationElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage;
import org.eclipse.ocl.examples.xtext.base.basecs.ClassifierCS;
import org.eclipse.ocl.examples.xtext.base.basecs.DetailCS;
import org.eclipse.ocl.examples.xtext.base.basecs.DocumentationCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ImportCS;
import org.eclipse.ocl.examples.xtext.base.basecs.LambdaTypeCS;
import org.eclipse.ocl.examples.xtext.base.basecs.LibraryCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ModelElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ModelElementRefCS;
import org.eclipse.ocl.examples.xtext.base.basecs.MultiplicityBoundsCS;
import org.eclipse.ocl.examples.xtext.base.basecs.MultiplicityStringCS;
import org.eclipse.ocl.examples.xtext.base.basecs.NamedElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.OperationCS;
import org.eclipse.ocl.examples.xtext.base.basecs.PackageCS;
import org.eclipse.ocl.examples.xtext.base.basecs.PackageOwnerCS;
import org.eclipse.ocl.examples.xtext.base.basecs.PathElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.PathNameCS;
import org.eclipse.ocl.examples.xtext.base.basecs.PrimitiveTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ReferenceCS;
import org.eclipse.ocl.examples.xtext.base.basecs.RootPackageCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TemplateBindingCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TemplateParameterCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TemplateParameterSubstitutionCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TemplateSignatureCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TemplateableElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TuplePartCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TupleTypeCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TypedElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TypedTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.basecs.WildcardTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.basecs.util.AbstractExtendingBaseCSVisitor;
import org.eclipse.ocl.examples.xtext.base.basecs.util.VisitableCS;

public class BaseCSPostOrderVisitor extends AbstractExtendingBaseCSVisitor<Continuation<?>, CS2PivotConversion>
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
	
	protected final @NonNull MetaModelManager metaModelManager;
	
	public BaseCSPostOrderVisitor(@NonNull CS2PivotConversion context) {
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
			context.installPivotReference(object, element, BaseCSPackage.Literals.PIVOTABLE_ELEMENT_CS__PIVOT);
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
	public @Nullable
	Continuation<?> visitPackageOwnerCS(@NonNull PackageOwnerCS object) {
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