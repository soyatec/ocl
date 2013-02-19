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
 * $Id: PackageAttribution.java,v 1.4 2011/04/20 19:02:27 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.attributes;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.scoping.AbstractAttribution;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.scoping.ScopeView;

public class PackageAttribution extends AbstractAttribution
{
	public static final PackageAttribution INSTANCE = new PackageAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		org.eclipse.ocl.examples.pivot.Package targetPackage = (org.eclipse.ocl.examples.pivot.Package)target;
		if (targetPackage.getImportedPackage().size() > 0) {
			Set<org.eclipse.ocl.examples.pivot.Package> allPackages = new HashSet<org.eclipse.ocl.examples.pivot.Package>();
			gatherAllPackages(allPackages, targetPackage);
			for (@SuppressWarnings("null")@NonNull org.eclipse.ocl.examples.pivot.Package aPackage : allPackages) {
				environmentView.addAllPackages(aPackage);
				environmentView.addAllTypes(aPackage);
			}
		}
		else {
			environmentView.addAllPackages(targetPackage);
			environmentView.addAllTypes(targetPackage);
		}
		return scopeView.getParent();
	}

	private void gatherAllPackages(@NonNull Set<org.eclipse.ocl.examples.pivot.Package> allPackages,
			@NonNull org.eclipse.ocl.examples.pivot.Package targetPackage) {
		if (allPackages.add(targetPackage)) {
			for (@SuppressWarnings("null")@NonNull org.eclipse.ocl.examples.pivot.Package importedPackage : targetPackage.getImportedPackage()) {
				gatherAllPackages(allPackages, importedPackage);
			}
		}
	}
}
