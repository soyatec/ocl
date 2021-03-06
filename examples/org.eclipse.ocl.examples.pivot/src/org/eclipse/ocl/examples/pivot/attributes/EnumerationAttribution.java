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
 * $Id: EnumerationAttribution.java,v 1.5 2011/04/25 09:50:02 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.attributes;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.scoping.AbstractAttribution;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.scoping.ScopeView;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

public class EnumerationAttribution extends AbstractAttribution
{
	public static final EnumerationAttribution INSTANCE = new EnumerationAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		org.eclipse.ocl.examples.pivot.Enumeration targetEnumeration = (org.eclipse.ocl.examples.pivot.Enumeration) target;
		environmentView.addAllEnumerationLiterals(targetEnumeration);
		environmentView.addAllOperations(targetEnumeration, false);
		environmentView.addAllProperties(targetEnumeration, false);
		environmentView.addElements(PivotUtil.getTemplateParameters(targetEnumeration));
		return scopeView.getParent();
	}
}
