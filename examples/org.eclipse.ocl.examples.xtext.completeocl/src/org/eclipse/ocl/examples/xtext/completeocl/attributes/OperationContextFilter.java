/**
 * <copyright>
 *
 * Copyright (c) 2011, 2012 E.D.Willink and others.
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
 * $Id: OperationContextFilter.java,v 1.2 2011/04/25 19:39:58 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl.attributes;

import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainElement;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.scoping.ScopeFilter;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.baseCST.ParameterCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OperationContextDeclCS;

public class OperationContextFilter implements ScopeFilter
{
	private final @NonNull OperationContextDeclCS csOperationContext;
	
	public OperationContextFilter(@NonNull OperationContextDeclCS csOperationContext) {
		this.csOperationContext = csOperationContext;
	}

	public int compareMatches(@NonNull MetaModelManager metaModelManager, @NonNull DomainElement match1, @Nullable Map<TemplateParameter, ParameterableElement> bindings1, @NonNull DomainElement match2, @Nullable Map<TemplateParameter, ParameterableElement> bindings2) {
		return 0;
	}

	public boolean matches(@NonNull EnvironmentView environmentView, @NonNull DomainElement eObject) {
		if (!(eObject instanceof Operation)) {
			return false;
		}
		Operation candidateOperation = (Operation) eObject;
		MetaModelManager metaModelManager = environmentView.getMetaModelManager();
//		Type context = metaModelManager.getPrimaryType(candidateOperation.getOwningType());
//		if (context != metaModelManager.getPrimaryElement(forType)) {
//			return false;
//		}
		List<ParameterCS> contextParameters = csOperationContext.getParameters();
		List<Parameter> candidateParameters = candidateOperation.getOwnedParameter();
		int iMax = contextParameters.size();
		if (iMax != candidateParameters.size()) {
			return false;
		}
		for (int i = 0; i < iMax; i++) {
			ParameterCS contextParameter = contextParameters.get(i);
			Parameter candidateParameter = candidateParameters.get(i);
			Type contextType = PivotUtil.getPivot(Type.class, contextParameter.getOwnedType());
			Type candidateType = candidateParameter.getType();
			if (contextType != null) {
				contextType = metaModelManager.getPrimaryType(contextType);
			}
			if (candidateType != null) {
				candidateType = metaModelManager.getPrimaryType(candidateType);
			}
// FIXME Need to resolve parameter type pivots first
//			if (contextType != candidateType) {
//				return false;
//			}
		}
		return true;
	}
}