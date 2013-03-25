/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D.Willink and others.
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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.PivotConstants;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.baseCST.PathElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PathNameCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.AbstractNameExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.InvocationExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigatingArgCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigationOperatorCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigationRole;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.OperatorCS;

public class NavigationUtil
{
	/**
	 * Return the NavigationOperatorCS for which csExp is the left node of the navigation operator's argument tree.
	 */
	public static @Nullable NavigationOperatorCS getNavigationOperator(@NonNull AbstractNameExpCS csExp) {
		EObject eContainer = csExp.eContainer();
		if (eContainer instanceof AbstractNameExpCS) {
			csExp = (AbstractNameExpCS) eContainer;
		}
		for (ExpCS csChild = csExp; true; csChild = csChild.getParent()) {
			OperatorCS csOperator = csChild.getParent();
			if (csOperator == null) {
				return null;
			}
			ExpCS csSource = csOperator.getSource();
			if (csSource == csChild) {									// e.g.    ... -> (X... -> ...)
				;
			}
			else if (csOperator instanceof NavigationOperatorCS) {		// e.g 	   ... -> X
				return (NavigationOperatorCS) csOperator;
			}
			else {														// e.g.    ... and X
				return null;
			}
		}
	}

	/**
	 * Return the source type of a navigation adjusting any implicit collect to the flattened source type, and
	 * and implicit oclAsSet to the Set type.
	 * 
	 */
	public static @Nullable Type getNavigationSourceType(@NonNull MetaModelManager metaModelManager, @NonNull NavigationOperatorCS csOperator) {
		ExpCS csSource = csOperator.getSource();
		if (csSource == null) {
			return null;
		}
		OCLExpression source = PivotUtil.getPivot(OCLExpression.class, csSource);
		if (source == null) {
			return null;
		}
		Type type = source.getType();
		if (type == null) {
			return null;
		}
		String opName = csOperator.getName();
		if (opName.equals(PivotConstants.COLLECTION_NAVIGATION_OPERATOR)) {
			if (type instanceof CollectionType) {		// collection->collection-feature-name...
				return type;
			}
			else {										// object.oclAsSet()->collection-feature-name...
				return metaModelManager.getCollectionType(false, true, type, null, null);
			}
		}
		else {
			if (type instanceof CollectionType) {		// collection->implicit-collect(object-feature-name...)
				while (type instanceof CollectionType) {	// implicit-collect flattens
					type = ((CollectionType)type).getElementType();
				}
				return type;
			}
			else {										// object.object-feature-name...
				return type;
			}
		}
	}

	public static boolean isIteration(@NonNull MetaModelManager metaModelManager, @NonNull InvocationExpCS csInvocationExp, @NonNull CollectionType type) {
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
		for (DomainOperation operation : metaModelManager.getAllOperations(type, false, name)) {
			return operation instanceof Iteration;		// mixed overload are not allowed
		}
		return false;
	}
}
