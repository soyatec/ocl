/**
 * <copyright>
 *
 * Copyright (c) 2010, 2012 E.D.Willink and others.
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
 * $Id: CS2Moniker.java,v 1.9 2011/05/22 21:06:21 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.utilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.Nameable;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.utilities.Abstract2Moniker;
import org.eclipse.ocl.examples.xtext.base.baseCST.ConstraintCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ParameterCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateBindingCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateParameterCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateParameterSubstitutionCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateSignatureCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateableElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor;
import org.eclipse.ocl.examples.xtext.base.util.VisitableCS;

public class CS2Moniker extends Abstract2Moniker
{
	public static interface Factory
	{
		public abstract @NonNull BaseCSVisitor<?> create(@NonNull CS2Moniker moniker);
	}

	public static synchronized void addFactory(/*@NonNull*/ EPackage ePackage, @NonNull Factory factory) {
		assert ePackage != null;
		csFactoryMap.put(ePackage, factory);
	}

	public static @NonNull String toString(@NonNull ElementCS csElement) {
		CS2Moniker moniker = new CS2Moniker(csElement);
		moniker.appendElementCS(csElement);
		String string = moniker.toString();
		assert !"".equals(string);
		assert string != null;
		return string;
	}

	/**
	 * The registry of Moniker Visitor Factories for supported EPackages.
	 */
	private static @NonNull Map<EPackage, Factory> csFactoryMap = new HashMap<EPackage, Factory>();

	/**
	 * The template parameters defined by csScope and its ancestors. This is
	 * computed lazily by computeTemplateParameters.
	 */
	private List<TemplateParameterCS> csTemplateParameters = null;

	/**
	 * CS TemplateParameters that already appear in the result and do not need
	 * re-qualification.
	 */
	private List<TemplateParameterCS> csEmittedParameters = null;

	/**
	 * The Moniker Visitors created for each required EPackage.
	 */
	private @NonNull Map<EPackage, BaseCSVisitor<?>> csVisitorMap = new HashMap<EPackage, BaseCSVisitor<?>>();

	public CS2Moniker(@NonNull ElementCS target) {
		super(target);
	}

	public void appendConstraintCSDisambiguator(@NonNull ConstraintCS csConstraint) {
		String csConstraintStereotype = csConstraint.getStereotype();
		EObject csContainer = csConstraint.eContainer();
		if (csContainer == null) {
			return;
		}
		Object container = csContainer.eGet(csConstraint.eContainingFeature());
		if (container instanceof List<?>) {
			int index = 0;
			String name2 = csConstraint.getName();
			for (Object content : (List<?>)container) {
				if (content == csConstraint) {
					break;
				}
				if (content instanceof ConstraintCS) {
					ConstraintCS sibling = (ConstraintCS) content;
					String siblingStereotype = sibling.getStereotype();
					if ((siblingStereotype != null) && siblingStereotype.equals(csConstraintStereotype)) {
						String name1 = sibling.getName();
						if (name1 != name2) {
							if ((name1 == null) || !name1.equals(name2)) {
								break;
							}
						}
						index++;
					}
				}
			}
			append(MONIKER_OPERATOR_SEPARATOR);
			if (name2 != null) {
				append(name2);
			}
			if (index != 0) {
				append(MONIKER_OPERATOR_SEPARATOR);
				append(index);
			}
		}
	}

	public void appendElementCS(@NonNull VisitableCS csVisitable) {
		int oldSize = length();
		EPackage ePackage = csVisitable.eClass().getEPackage();
		assert ePackage != null;
		BaseCSVisitor<?> monikerVisitor = getVisitor(ePackage);
		csVisitable.accept(monikerVisitor);
		assert length() > oldSize;
	}

	protected void appendMultiplicityCS(@NonNull TypedElementCS csTypedElement) {
		int lower = ElementUtil.getLower(csTypedElement);
		int upper = ElementUtil.getUpper(csTypedElement);
		if (upper != 1) {
			append("[");
			append(lower);
			append(ElementUtil.isOrdered(csTypedElement) ? "S" : "s");
			append(ElementUtil.isUnique(csTypedElement) ? "U" : "u");
			append(upper);
			append("]");
		}
	}

	public void appendNameCS(@Nullable Nameable csNamedElement) {
		append(csNamedElement != null
			? csNamedElement.getName()
			: null);
	}

	public void appendParametersCS(List<ParameterCS> csIterators,
			List<ParameterCS> csAccumulators, List<ParameterCS> csParameters) {
		append(PARAMETER_PREFIX);
		String prefix = ""; //$NON-NLS-1$
		if (csIterators != null) {
			for (ParameterCS csIterator : csIterators) {
				append(prefix);
				TypedRefCS ownedType = csIterator.getOwnedType();
				if (ownedType != null) {
					appendElementCS(ownedType);
				}
				appendMultiplicityCS(csIterator);
				prefix = PARAMETER_SEPARATOR;
			}
			prefix = ACCUMULATOR_SEPARATOR;
		}
		if ((csAccumulators != null) && (csAccumulators.size() > 0)) {
			prefix = ITERATOR_SEPARATOR;
			for (ParameterCS csAccumulator : csAccumulators) {
				append(prefix);
				TypedRefCS ownedType = csAccumulator.getOwnedType();
				if (ownedType != null) {
					appendElementCS(ownedType);
				}
				appendMultiplicityCS(csAccumulator);
				prefix = PARAMETER_SEPARATOR;
			}
			prefix = ACCUMULATOR_SEPARATOR;
		}
		for (ParameterCS csParameter : csParameters) {
			append(prefix);
			TypedRefCS ownedType = csParameter.getOwnedType();
			if (ownedType != null) {
				appendElementCS(ownedType);
				appendMultiplicityCS(csParameter);
			}
			prefix = PARAMETER_SEPARATOR;
		}
		append(PARAMETER_SUFFIX);
	}

	public void appendParentCS(ElementCS csElement, String parentSeparator) {
		EObject parent = csElement != null ? csElement.eContainer() : null;
		appendParentElementCS(parent, parentSeparator);
	}

	public void appendParentElementCS(EObject parent, String parentSeparator) {
		if (toString().length() >= MONIKER_OVERFLOW_LIMIT) {
			append(OVERFLOW_MARKER);
		} else if (parent instanceof VisitableCS) {
			appendElementCS((VisitableCS) parent);
		}
		append(parentSeparator);
	}

	public void appendRoleCS(ElementCS object) {
		EReference eFeature = object.eContainmentFeature();
		appendRoleCS(eFeature);
		if (eFeature.isMany()) {
			int index = ((List<?>) object.eContainer().eGet(
				object.eContainingFeature())).indexOf(object);
			append(index);
		}
	}

	public void appendRoleCS(EStructuralFeature eFeature) {
		String roleName = roleNames.get(eFeature);
		if (roleName == null) {
			roleName = eFeature.getName();
		}
		append(roleName);
	}

	public void appendTemplateBindingsCS(TypedTypeRefCS typeRef) {
		TemplateBindingCS templateBinding = typeRef.getOwnedTemplateBinding();
		if (templateBinding != null) {
			append(TEMPLATE_BINDING_PREFIX);
			List<TemplateParameterSubstitutionCS> templateParameterSubstitutions = templateBinding
				.getOwnedParameterSubstitution();
			if (!templateParameterSubstitutions.isEmpty()) {
				String prefix = ""; //$NON-NLS-1$
				for (TemplateParameterSubstitutionCS templateParameterSubstitution : templateParameterSubstitutions) {
					append(prefix);
					if (templateParameterSubstitution != null) {
						TypeRefCS ownedActualParameter = templateParameterSubstitution.getOwnedActualParameter();
						if (ownedActualParameter != null) {
							appendElementCS(ownedActualParameter);
						}
					}
					prefix = TEMPLATE_BINDING_SEPARATOR;
				}
			}
			append(TEMPLATE_BINDING_SUFFIX);
		}
	}

	public void appendTemplateParametersCS(
			TemplateableElementCS csTemplateableElement) {
		TemplateSignatureCS csTemplateSignature = csTemplateableElement
			.getOwnedTemplateSignature();
		if (csTemplateSignature != null) {
			List<TemplateParameterCS> csTemplateParameters = csTemplateSignature
				.getOwnedTemplateParameter();
			if (!csTemplateParameters.isEmpty()) {
				append(TEMPLATE_SIGNATURE_PREFIX);
				String prefix = ""; //$NON-NLS-1$
				for (TemplateParameterCS csTemplateParameter : csTemplateParameters) {
					append(prefix);
					emittedTemplateParameterCS(csTemplateParameter);
					// appendTemplateParameter((TemplateParameter)
					// csTemplateParameter.getPivot());
					appendNameCS(csTemplateParameter);
					prefix = TEMPLATE_SIGNATURE_SEPARATOR;
				}
				append(TEMPLATE_SIGNATURE_SUFFIX);
			}
		}
	}

	private void computeTemplateParametersCS(EObject csElement) {
		if (csTemplateParameters != null) {
			return;
		}
		EObject parent = csElement != null
			? csElement.eContainer()
			: null;
		if (parent != null) {
			computeTemplateParametersCS(parent);
		} else {
			csTemplateParameters = Collections.emptyList();
		}
		if (csElement instanceof TemplateableElementCS) {
			TemplateSignatureCS ownedTemplateSignature = ((TemplateableElementCS) csElement)
				.getOwnedTemplateSignature();
			if (ownedTemplateSignature != null) {
				if (csTemplateParameters.isEmpty()) {
					csTemplateParameters = new ArrayList<TemplateParameterCS>();
				}
				csTemplateParameters.addAll(ownedTemplateSignature
					.getOwnedTemplateParameter());
			}
		}
	}

	public @NonNull BaseCSVisitor<?> getVisitor(/*@NonNull*/ EPackage ePackage) {
		assert ePackage != null;
		BaseCSVisitor<?> monikerVisitor = csVisitorMap.get(ePackage);
		if (monikerVisitor == null) { //&& !csVisitorMap.containsKey(ePackage)) {
			Factory factory = csFactoryMap.get(ePackage);
			if (factory == null) {
				throw new IllegalStateException("No Moniker Visitor created for " + ePackage.getName());
			}
			monikerVisitor = factory.create(this);
			csVisitorMap.put(ePackage, monikerVisitor);
		}
		return monikerVisitor;
	}

	protected void emittedTemplateParameterCS(
			TemplateParameterCS csTemplateParameter) {
		if (csEmittedParameters == null) {
			csEmittedParameters = new ArrayList<TemplateParameterCS>();
		}
		csEmittedParameters.add(csTemplateParameter);
	}

	public TemplateParameterCS getTemplateParameterCS(String text) {
		for (TemplateParameterCS templateParameter : getTemplateParametersCS()) {
			if (templateParameter.getName().equals(text)) {
				return templateParameter;
			}
		}
		return null;
	}

	public List<TemplateParameterCS> getTemplateParametersCS() {
		if (csTemplateParameters == null) {
			computeTemplateParametersCS(target);
		}
		return csTemplateParameters;
	}

	public boolean hasEmittedCS(TemplateParameterCS csTemplateParameter) {
		if (csEmittedParameters != null) {
			if (csEmittedParameters.contains(csTemplateParameter)) {
				return true;
			}
		}
		Element pivot = csTemplateParameter.getPivot();
		if (pivot instanceof TemplateParameter) {
			if (hasEmitted((TemplateParameter) pivot)) {
				return true;
			}
		}
		return false;
	}

	public boolean isTemplateParameterCS(TemplateParameterCS object) {
		return getTemplateParametersCS().contains(object);
	}

	// public void popBindings(int oldSize) {
	// while (substitutions.size() > oldSize) {
	// substitutions.remove(substitutions.size()-1);
	// }
	// }

	// public int pushBindings(ParameterizedTypeRefCS templateBindable) {
	// if (substitutions == null) {
	// substitutions = new ArrayList<TemplateParameterSubstitutionCS>();
	// }
	// int size = substitutions.size();
	// TemplateBindingCS ownedTemplateBinding =
	// templateBindable.getOwnedTemplateBinding();
	// if (ownedTemplateBinding != null) {
	// substitutions.addAll(ownedTemplateBinding.getOwnedParameterSubstitution());
	// }
	// return size;
	// }
}