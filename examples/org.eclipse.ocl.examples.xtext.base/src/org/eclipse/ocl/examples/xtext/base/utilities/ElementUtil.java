/**
 * <copyright>
 *
 * Copyright (c) 2010,2011 E.D.Willink and others.
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
 * $Id: ElementUtil.java,v 1.10 2011/05/22 21:06:21 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.utilities;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Feature;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.Namespace;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.TemplateBinding;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.AbstractMetaModelManagerResourceAdapter;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManagerResourceSetAdapter;
import org.eclipse.ocl.examples.pivot.scoping.Attribution;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.attributes.RootCSAttribution;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTFactory;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.CollectionTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.MultiplicityCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.NamedElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.OperationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PathElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PathNameCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateBindingCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateParameterSubstitutionCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.WildcardTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2Pivot;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.LibraryDiagnostic;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextSyntaxDiagnostic;

public class ElementUtil
{
	public static @Nullable MetaModelManager findMetaModelManager(@NonNull EObject eObject) {
		EObject eRoot = EcoreUtil.getRootContainer(eObject);
		if (eRoot != null) {
			Resource resource = eRoot.eResource();
			if (resource != null) {
				if (eObject instanceof ElementCS) {
					AbstractMetaModelManagerResourceAdapter<?> adapter = AbstractMetaModelManagerResourceAdapter.findAdapter(resource);
					if (adapter != null) {
						return adapter.getMetaModelManager();
					}
				}
				return findMetaModelManager(resource);
			}
		}
		return null;
	}

	public static @Nullable MetaModelManager findMetaModelManager(@NonNull Resource resource) {
		for (Adapter adapter : resource.eAdapters()) {
			if (adapter instanceof AbstractMetaModelManagerResourceAdapter) {
				return ((AbstractMetaModelManagerResourceAdapter<?>)adapter).getMetaModelManager();
			}
		}
		ResourceSet resourceSet = resource.getResourceSet();
		return resourceSet != null ? findMetaModelManager(resourceSet) : null;
	}

	public static MetaModelManager findMetaModelManager(@NonNull ResourceSet resourceSet) {
		MetaModelManager metaModelManager = MetaModelManager.findAdapter(resourceSet);
		if (metaModelManager != null) {
			return metaModelManager;
		}
		MetaModelManagerResourceSetAdapter adapter = MetaModelManagerResourceSetAdapter.findAdapter(resourceSet);
		if (adapter != null) {
			return adapter.getMetaModelManager();
		}
		return null;
	}

	public static @Nullable String getCollectionTypeName(@NonNull TypedElementCS csTypedElement) {
		TypedRefCS csTypeRef = csTypedElement.getOwnedType();
		if (csTypeRef == null) {
			return null;
		}
		if (csTypeRef instanceof CollectionTypeRefCS) {
			Type csType = ((CollectionTypeRefCS)csTypeRef).getType();
			if (csType instanceof CollectionType) {
				return ((CollectionType)csType).getName();
			}
		}
		//FIXME Obsolete compatibility
		MultiplicityCS csMultiplicity = csTypeRef.getMultiplicity();
		if (csMultiplicity == null) {
			return null;
		}
		int upper = csMultiplicity.getUpper();
		if (upper == 1) {
			return null;
		}
		List<String> qualifiers = csTypedElement.getQualifier();
		boolean isOrdered = true;
		boolean isUnique = true;
		if (qualifiers.contains("!ordered")) { //$NON-NLS-1$
			isOrdered = false;
		}
		else if (qualifiers.contains("ordered")) { //$NON-NLS-1$
			isOrdered = true;
		}
		if (qualifiers.contains("!unique")) { //$NON-NLS-1$
			isUnique = false;
		}
		else if (qualifiers.contains("unique")) { //$NON-NLS-1$
			isUnique = true;
		}
		return getCollectionName(isOrdered, isUnique);
	}

	public static @NonNull String getCollectionName(boolean ordered, boolean unique) {
		if (ordered) {
			return unique ? "OrderedSet" : "Sequence"; //$NON-NLS-1$ //$NON-NLS-2$
		}
		else {
			return unique ? "Set" : "Bag"; //$NON-NLS-1$ //$NON-NLS-2$
		}
	}
	
	public static @Nullable ModelElementCS getCsElement(@NonNull Element obj) {
		Resource resource = obj.eResource();
		if (resource == null) {
			return null;
		}
		ResourceSet resourceSet = resource.getResourceSet();
		if (resourceSet == null) {
			return null;
		}
		CS2Pivot cs2Pivot = CS2Pivot.findAdapter(resourceSet);
		if (cs2Pivot == null) {
			return null;
		}
		return cs2Pivot.getCSElement(obj);
	}
	
	public static @Nullable RootCSAttribution getDocumentAttribution(@NonNull ElementCS context) {
		for (ElementCS target = context, parent; (parent = target.getLogicalParent()) != null; target = parent) {
			Attribution attribution = PivotUtil.getAttribution(parent);
			if (attribution instanceof RootCSAttribution) {
				return (RootCSAttribution) attribution;
			}
		}
		return null;
	}

	public static @Nullable TemplateParameter getFormalTemplateParameter(@NonNull TemplateParameterSubstitutionCS csTemplateParameterSubstitution) {
		TemplateBindingCS csTemplateBinding = csTemplateParameterSubstitution.getOwningTemplateBinding();
		int index = csTemplateBinding.getOwnedParameterSubstitution().indexOf(csTemplateParameterSubstitution);
		if (index < 0) {
			return null;
		}
		TemplateBinding templateBinding = (TemplateBinding) csTemplateBinding.getPivot();
		TemplateSignature templateSignature = templateBinding.getSignature();
		List<TemplateParameter> templateParameters = templateSignature.getOwnedParameter();
		if (templateParameters.size() <= index) {
			return null;
		}
		return templateParameters.get(index);
	}

	public static @Nullable ILeafNode getLeafNode(@NonNull INode node) {
		ILeafNode leafNode = null;
		if (node instanceof ILeafNode) {
			return (ILeafNode) node;
		}
		else {
			for (ILeafNode lNode : node.getLeafNodes()) {
				if (!lNode.isHidden()) {
					leafNode = lNode;
					return leafNode;
				}
			}
		}
		return null;
	}

	public static int getLower(@NonNull TypedElementCS csTypedElement) {
		TypedRefCS csTypeRef = csTypedElement.getOwnedType();
		if (csTypeRef == null) {
			return 0;		// e.g. missing Operation return type
		}
		MultiplicityCS csMultiplicity = csTypeRef.getMultiplicity();
		if (csMultiplicity == null) {
			return 1;
		}
		return csMultiplicity.getLower();
	}

	public static @Nullable <T extends NamedElementCS> T getNamedElementCS(@NonNull Collection<T> namedElements, @NonNull String name) {
		for (T namedElement : namedElements) {
			if (name.equals(namedElement.getName())) {
				return namedElement;
			}
		}
		return null;
	}

	public static boolean getQualifier(@NonNull List<String> qualifiers, @NonNull String trueString, @NonNull String falseString, boolean defaultValue) {
		if (qualifiers.contains(trueString)) {
			return true;
		}
		else if (qualifiers.contains(falseString)) {
			return false;
		}
		else {
			return defaultValue;
		}
	}

	public static String getText(@NonNull ElementCS csElement) {
		ICompositeNode node = NodeModelUtils.getNode(csElement);
		return NodeModelUtils.getTokenText(node);
	}

	public static @Nullable String getText(@NonNull TypedTypeRefCS csElement, @NonNull EReference feature) {
		@NonNull List<INode> nodes = NodeModelUtils.findNodesForFeature(csElement, feature);
//		assert (nodes.size() == 1;
		if (nodes.isEmpty()) {
			return null;
		}
		else if (nodes.size() == 1) {
			return NodeModelUtils.getTokenText(nodes.get(0));
		}
		else {
			StringBuilder s = new StringBuilder();
			for (INode node : nodes) {
				s.append(NodeModelUtils.getTokenText(node));
			}
			return s.toString();
		}
	}

	public static int getUpper(@NonNull TypedElementCS csTypedElement) {
		TypedRefCS csTypeRef = csTypedElement.getOwnedType();
		if (csTypeRef == null) {
			return 1;
		}
		MultiplicityCS csMultiplicity = csTypeRef.getMultiplicity();
		if (csMultiplicity == null) {
			return 1;
		}
		return csMultiplicity.getUpper();
	}

	public static boolean hasSyntaxError(@NonNull List<Diagnostic> diagnostics) {
		for (Diagnostic diagnostic : diagnostics) {
			if (diagnostic instanceof LibraryDiagnostic) {
				return true;
			}
			else if (diagnostic instanceof XtextSyntaxDiagnostic) {
				return true;
			}
		}
		return false;
	}

	public static boolean isInOperation(@NonNull ElementCS csElement) {
		for (EObject eObject = csElement; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof OperationCS) {
				return true;
			}
			else if (eObject instanceof ClassCS) {
				return false;
			}
		}
		return false;
	}

	public static boolean isOrdered(@NonNull TypedElementCS csTypedElement) {
		List<String> qualifiers = csTypedElement.getQualifier();
		assert qualifiers != null;
		return getQualifier(qualifiers, "ordered", "!ordered", false);
	}

	/**
	 * Return true if element is able to be accessed by a qualified path OCLinEcore. Other elements must use a quoted URI.
	 */
	@Deprecated  // find and extensible solution
	public static NamedElement isPathable(@NonNull EObject element) {
		if (element instanceof Feature) {
			return (Feature)element;
		}
		else if (element instanceof Type) {
			return (Type)element;
		}
		else if (element instanceof Namespace) {
			return (Namespace)element;
		}
		else {
			return null;
		}
	}

	public static boolean isUnique(@NonNull TypedElementCS csTypedElement) {
		List<String> qualifiers = csTypedElement.getQualifier();
		assert qualifiers != null;
		return getQualifier(qualifiers, "unique", "!unique", true);
	}

	public static boolean isSpecialization(@NonNull TemplateBindingCS csTemplateBinding) {
		TypedTypeRefCS csTypedTypeRef = csTemplateBinding.getOwningTemplateBindableElement();
		Element type = csTypedTypeRef.getPivot();
		for (TemplateParameterSubstitutionCS csTemplateParameterSubstitution : csTemplateBinding.getOwnedParameterSubstitution()) {
			TypeRefCS ownedActualParameter = csTemplateParameterSubstitution.getOwnedActualParameter();
			if (ownedActualParameter instanceof WildcardTypeRefCS) {
				return true;
			}
			Type actualParameterClass = (Type) ownedActualParameter.getPivot();
			TemplateParameter owningTemplateParameter = actualParameterClass.getOwningTemplateParameter();
			if (owningTemplateParameter == null) {
				return true;
			}
			TemplateSignature signature = owningTemplateParameter.getSignature();
			TemplateableElement template = signature.getTemplate();
			if (template != type) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Assign a sequence of one or more path elements to csPathName that identify element with respect
	 * to scope.
	 * <br>
	 * For example A::B::C::D::E with respect to A::B::C::X::Y is D::E.
	 * <br>
	 * No validation is performed to check that the shortened name resolves to the same
	 * element.
	 * <br>
	 * For example if there is also an A::B::C::X::D::E, the caller must shorten the scope
	 * reference to A::B to avoid the ambiguity.
	 */
	public static void setPathName(@NonNull PathNameCS csPathName, @NonNull Element element, Namespace scope) {
		List<PathElementCS> csPath = csPathName.getPath();
		csPath.clear();		// FIXME re-use
		PathElementCS csSimpleRef = BaseCSTFactory.eINSTANCE.createPathElementCS();
		csPath.add(csSimpleRef);
		csSimpleRef.setElement(element);
		if (isPathable(element) == null) {
			return;
		}
		for (EObject eContainer = element.eContainer(); eContainer instanceof Element; eContainer = eContainer.eContainer()) {
			if (eContainer instanceof Root) {
				return;				// Skip root package
			}
			for (EObject aScope = scope; aScope != null; aScope = aScope.eContainer()) {
				if (aScope == eContainer) { 		// If element ancestor is scope or an ancestor
					return;							// no need for further qualification
				}
			}
			csSimpleRef = BaseCSTFactory.eINSTANCE.createPathElementCS();
			csPath.add(0, csSimpleRef);
			csSimpleRef.setElement((Element) eContainer);
		}
	}
}
