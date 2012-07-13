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
 * $Id: RootPackageAttribution.java,v 1.3 2011/04/20 19:02:27 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.attributes;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.scoping.AbstractAttribution;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.scoping.ScopeView;

public class RootAttribution extends AbstractAttribution
{
	public static final RootAttribution INSTANCE = new RootAttribution();

	@Override
	public ScopeView computeLookup(EObject target, EnvironmentView environmentView, ScopeView scopeView) {
		Root targetPackage = (Root)target;
		environmentView.addNamedElements(targetPackage.getNestedPackage());
		environmentView.addRootPackages();
		return scopeView.getParent();
	}
}
