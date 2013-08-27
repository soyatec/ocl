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
 * $Id: ContextCSAttribution.java,v 1.11 2011/05/02 09:31:32 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.attributes;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.context.ParserContext;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.resource.BaseResource;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.scoping.ScopeView;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.scoping.AbstractRootCSAttribution;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ContextCS;

public class ContextCSAttribution extends AbstractRootCSAttribution
{
	public static final @NonNull ContextCSAttribution INSTANCE = new ContextCSAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		MetaModelManager metaModelManager = environmentView.getMetaModelManager();
		ContextCS targetElement = (ContextCS)target;
		ExpressionInOCL pivot = PivotUtil.getPivot(ExpressionInOCL.class, targetElement);
		if ((pivot != null) && (pivot.getContextVariable() != null) && (pivot.getContextVariable().getType() != null)) {
			Variable resultVariable = pivot.getResultVariable();
			if (resultVariable != null) {
				environmentView.addNamedElement(resultVariable);
			}
			for (Variable parameterVariable : pivot.getParameterVariable()) {
				assert parameterVariable != null;
				environmentView.addNamedElement(parameterVariable);
			}
			Variable contextVariable = pivot.getContextVariable();
			if (contextVariable != null) {
				environmentView.addNamedElement(contextVariable);
				if (!environmentView.hasFinalResult()) {
					Type type = contextVariable.getType();
					if (type != null) {
						environmentView.addAllElements(type, scopeView);
					}
				}
			}
		}
		else {
			Resource resource = target.eResource();
			if (resource instanceof BaseResource) {
				ParserContext parserContext = ((BaseResource)resource).getParserContext();
				if (parserContext != null) {
					Type contextType = parserContext.getClassContext();
					if (contextType != null) {
						environmentView.computeLookups(contextType, null);
					}
				}
			}
		}
		if (!environmentView.hasFinalResult()) {
			environmentView.addRootPackages();
		}
		if ((pivot != null) && !environmentView.hasFinalResult()) {
			Resource eResource = pivot.eResource();
			if (eResource != null) {
				URI baseURI = eResource.getURI();
				if (baseURI != null) {
					URI nonPivotBaseURI = PivotUtil.getNonASURI(baseURI);
					String nonPivotScheme = nonPivotBaseURI.scheme();
					if ((nonPivotScheme != null) && !"null".equals(nonPivotScheme)) {
						environmentView.addImportedElement(baseURI);
					}
				}
			}
		}
		if (!environmentView.hasFinalResult()) {
			environmentView.addElementsOfScope(metaModelManager.getOclAnyType().getPackage(), scopeView);
		}
		return super.computeLookup(targetElement, environmentView, scopeView);
	}
}
