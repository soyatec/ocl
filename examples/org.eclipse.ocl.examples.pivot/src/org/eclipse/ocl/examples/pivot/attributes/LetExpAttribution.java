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
 * $Id: LetExpAttribution.java,v 1.2 2011/01/24 21:00:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.attributes;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.LetExp;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.scoping.AbstractAttribution;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.scoping.ScopeView;

public class LetExpAttribution extends AbstractAttribution
{
	public static final LetExpAttribution INSTANCE = new LetExpAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		LetExp targetExpression = (LetExp)target;
		EStructuralFeature containmentFeature = scopeView.getContainmentFeature();
		if (containmentFeature == PivotPackage.Literals.LET_EXP__IN) {
			Variable variable = targetExpression.getVariable();
			if (variable != null) {
				environmentView.addNamedElement(variable);
			}
		}
		return scopeView.getParent();
	}
}
