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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.scoping.AbstractAttribution;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.scoping.ScopeFilter;
import org.eclipse.ocl.examples.pivot.scoping.ScopeView;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.InfixExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.InvocationExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.OperatorCS;

public class InvocationExpCSAttribution extends AbstractAttribution
{
	public static final InvocationExpCSAttribution INSTANCE = new InvocationExpCSAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		InvocationExpCS targetElement = (InvocationExpCS)target;
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
				environmentView.computeLookups(scopeView.getParent());
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

	protected @NonNull ScopeFilter createInvocationFilter(@NonNull MetaModelManager metaModelManager, @NonNull InvocationExpCS targetElement, @Nullable Type type) {
		return new OperationFilter(metaModelManager, type, targetElement);
	}

	protected boolean isRequiredType(EnvironmentView environmentView) {
		EClassifier requiredType = environmentView.getRequiredType();
		EClass operationType = PivotPackage.Literals.OPERATION;
		boolean isRequiredType = (requiredType instanceof EClass) && operationType.isSuperTypeOf((EClass)requiredType);
		return isRequiredType;
	}
}
