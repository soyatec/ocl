/**
 * <copyright>
 *
 * Copyright (c) 2010,2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 *   E.D.Willink (CEA LIST) - Bug 388529
 *
 * </copyright>
 *
 * $Id: ClassAttribution.java,v 1.10 2011/05/21 14:56:18 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.attributes;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Metaclass;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.scoping.AbstractAttribution;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.scoping.ScopeView;
import org.eclipse.ocl.examples.pivot.util.Pivotable;

public class ClassAttribution extends AbstractAttribution
{
	public static final ClassAttribution INSTANCE = new ClassAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		org.eclipse.ocl.examples.pivot.Class targetClass = (org.eclipse.ocl.examples.pivot.Class) target;
		assert !(target instanceof Metaclass<?>);
		if (targetClass.getOwningTemplateParameter() != null) {
			MetaModelManager metaModelManager = environmentView.getMetaModelManager();
			org.eclipse.ocl.examples.pivot.Class type = metaModelManager.getOclAnyType(); // WIP use lowerbound
			environmentView.addAllOperations(type, false);
			environmentView.addAllProperties(type, false);
			environmentView.addAllStates(type);
			return null;
		}
		if (targetClass.getTemplateBinding().size() == 0) {
			EObject scopeTarget = scopeView.getTarget();
			if (scopeTarget instanceof Pivotable) {
				Element pivot = ((Pivotable)scopeTarget).getPivot();
				if (pivot == target) {		// Inherited template parameters are invisible.
					environmentView.addAllTypeTemplateParameterables(targetClass);
				}
			}
		}
		environmentView.addAllOperations(targetClass, false);
		environmentView.addAllProperties(targetClass, false);
		environmentView.addAllStates(targetClass);
		if (!environmentView.hasFinalResult()) {
			environmentView.addAllOperations(targetClass, true);
			environmentView.addAllProperties(targetClass, true);
		}
		return scopeView.getParent();
	}
}
