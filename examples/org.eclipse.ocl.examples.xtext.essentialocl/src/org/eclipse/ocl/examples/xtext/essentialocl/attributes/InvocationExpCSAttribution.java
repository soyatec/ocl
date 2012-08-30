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
 */
package org.eclipse.ocl.examples.xtext.essentialocl.attributes;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.pivot.CallExp;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.IterateExp;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.LoopExp;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.PivotConstants;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.scoping.AbstractAttribution;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.scoping.ScopeFilter;
import org.eclipse.ocl.examples.pivot.scoping.ScopeView;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PathElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PathNameCS;
import org.eclipse.ocl.examples.xtext.base.scoping.BaseScopeView;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.InfixExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.InvocationExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigatingArgCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigationOperatorCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigationRole;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.OperatorCS;

public class InvocationExpCSAttribution extends AbstractAttribution
{
	public static final InvocationExpCSAttribution INSTANCE = new InvocationExpCSAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		InvocationExpCS targetElement = (InvocationExpCS)target;
		EObject fromArgument = scopeView.getChild();
		if (fromArgument instanceof NavigatingArgCS) {
			if (((NavigatingArgCS)fromArgument).getRole() == NavigationRole.EXPRESSION) {
				CallExp pivot = PivotUtil.getPivot(CallExp.class, targetElement);
				if (pivot instanceof LoopExp) {				// FIXME This is null for nested iteration
					for (Variable iterator : ((LoopExp)pivot).getIterator()) {
						if (iterator.isImplicit()) {
							environmentView.addElementsOfScope(iterator.getType(), scopeView);
						}
						else {
							environmentView.addNamedElement(iterator);
						}
						if (environmentView.hasFinalResult()) {
							return null;
						}
					}
					if (pivot instanceof IterateExp) {
						Variable result = ((IterateExp)pivot).getResult();
						if (result.isImplicit()) {
							environmentView.addElementsOfScope(result.getType(), scopeView);
						}
						else {
							environmentView.addNamedElement(result);
						}
						if (environmentView.hasFinalResult()) {
							return null;
						}
					}
				}
				else if (pivot == null) {
					OperatorCS csParent = targetElement.getParent();
					if (csParent instanceof NavigationOperatorCS) {
						NavigationOperatorCS csNavigationOperator = (NavigationOperatorCS)csParent;
						ExpCS csSource = csNavigationOperator.getSource();
						OCLExpression source = PivotUtil.getPivot(OCLExpression.class, csSource);
						if (source != null) {
							Type type = source.getType();
							if (csNavigationOperator.getName().equals(PivotConstants.COLLECTION_NAVIGATION_OPERATOR)) {
								if (type instanceof CollectionType) {		// collection->collection-operation(name...
									ExpCS csArgument = csNavigationOperator.getArgument();
									if ((csArgument != null) && isIteration(environmentView.getMetaModelManager(), csArgument, type)) {
										environmentView.addElementsOfScope(((CollectionType)type).getElementType(), scopeView);
									}
								}
							}
							return scopeView.getParent();
						}
					}
				}
			}
			else if (((NavigatingArgCS)fromArgument).getRole() == NavigationRole.ITERATOR) {			// Happens during save
				CallExp pivot = PivotUtil.getPivot(CallExp.class, targetElement);
				if (pivot instanceof LoopExp) {
					List<Variable> iterators = ((LoopExp)pivot).getIterator();
					assert iterators != null;
					environmentView.addNamedElements(iterators);
				}
			}
			else if (((NavigatingArgCS)fromArgument).getRole() == NavigationRole.ACCUMULATOR) {
				CallExp pivot = PivotUtil.getPivot(CallExp.class, targetElement);
				if (pivot instanceof IterateExp) {
					Variable result = ((IterateExp)pivot).getResult();
					if (result != null) {
						environmentView.addNamedElement(result);
					}
				}
			}
			ElementCS parent = targetElement.getLogicalParent();
			if (parent != null) {
				BaseScopeView.computeLookups(environmentView, parent, target, PivotPackage.Literals.OPERATION_CALL_EXP__ARGUMENT, null);
			}
			return null;
		}
		else {
			ExpCS explicitSource = null;
			ElementCS scopeTarget = null;	// Note that parent is null during PreOrder namespace resolution
			if (target.eContainer() instanceof InfixExpCS) {
				OperatorCS csOperator = targetElement.getParent();
				if (csOperator != null) {
					ExpCS csSource = csOperator.getSource();
					if (csSource != target) {
						scopeTarget = csOperator;
						explicitSource = csSource;
					}
				}
			}
			if (scopeTarget == null) {
				scopeTarget = targetElement.getLogicalParent();
			}
			Type type = null;
			if (explicitSource != null) {
				OCLExpression source = PivotUtil.getPivot(OCLExpression.class, explicitSource);
				if (source != null) {
					type = source.getType();
				}
			}
			if ((scopeTarget != null) && isRequiredType(environmentView)) {
				ScopeFilter filter = createInvocationFilter(environmentView.getMetaModelManager(), targetElement, type);
				try {
					environmentView.addFilter(filter);
					BaseScopeView.computeLookups(environmentView, scopeTarget, target, PivotPackage.Literals.OPERATION_CALL_EXP__REFERRED_OPERATION, null);
					return null;
				}
				finally {
					environmentView.removeFilter(filter);
				}
			}
			else {
				return scopeView.getParent();
			}
		}
	}

	protected @NonNull ScopeFilter createInvocationFilter(@NonNull MetaModelManager metaModelManager, @NonNull InvocationExpCS targetElement, @Nullable Type type) {
		return new OperationFilter(metaModelManager, type, targetElement);
	}

	public static boolean isIteration(@NonNull MetaModelManager metaModelManager, @NonNull ExpCS csExp, @NonNull Type type) {
		if (!(csExp instanceof InvocationExpCS)) {
			return false;
		}
		InvocationExpCS csInvocationExp = (InvocationExpCS)csExp;
		for (NavigatingArgCS csArg : csInvocationExp.getArgument()) {
			if (csArg.getRole() != NavigationRole.EXPRESSION) {
				return true;
			}
		}
		PathNameCS pathName = csInvocationExp.getPathName();
		List<PathElementCS> path = pathName.getPath();
		if (path.size() != 1) {
			return false;
		}
		PathElementCS csPathElement = path.get(0);
		Element unresolvedElement = csPathElement.basicGetElement();
		if ((unresolvedElement != null) && !unresolvedElement.eIsProxy()) {
			return unresolvedElement instanceof Iteration;
		}
		String name = csPathElement.toString();
		assert name != null;
		for (DomainOperation operation : metaModelManager.getAllOperations(type, Boolean.FALSE, name)) {
			return operation instanceof Iteration;		// mixed overload are not allowed
		}
		return false;
	}

	protected boolean isRequiredType(EnvironmentView environmentView) {
		EClassifier requiredType = environmentView.getRequiredType();
		EClass operationType = PivotPackage.Literals.OPERATION;
		boolean isRequiredType = (requiredType instanceof EClass) && operationType.isSuperTypeOf((EClass)requiredType);
		return isRequiredType;
	}
}
