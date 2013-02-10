/**
 * <copyright>
 *
 * Copyright (c) 2012,2013 E.D.Willink and others.
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
 */
package org.eclipse.ocl.examples.pivot.attributes;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ElementExtension;
import org.eclipse.ocl.examples.pivot.Metaclass;
import org.eclipse.ocl.examples.pivot.ParserException;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.scoping.ScopeView;
import org.eclipse.ocl.examples.pivot.util.Pivotable;

public class ExtensionTypeAttribution extends ClassAttribution
{		// FIXME same as ClassAttribution without the states
	public static final @NonNull ExtensionTypeAttribution INSTANCE = new ExtensionTypeAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		ElementExtension targetClass = (ElementExtension) target;
		MetaModelManager metaModelManager = environmentView.getMetaModelManager();
		if (targetClass.getOwningTemplateParameter() != null) {
			Type type = metaModelManager.getOclAnyType(); // WIP use lowerbound
			environmentView.addAllOperations(type, false);
			environmentView.addAllProperties(type, false);
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
		if (!environmentView.hasFinalResult()) {
			if (!(target instanceof Metaclass)) {
				environmentView.addAllOperations(targetClass, true);
				environmentView.addAllProperties(targetClass, true);
			}
			else {
				Type instanceType = ((Metaclass)target).getInstanceType();
				if ((instanceType != null) && (instanceType.getOwningTemplateParameter() == null)) {		// Maybe null
					environmentView.addAllOperations(instanceType, true);
					environmentView.addAllProperties(instanceType, true);
					if (!environmentView.hasFinalResult()) {
						EObject eTarget = instanceType.getETarget();
						if (eTarget != null) {
							try {
								Element element = environmentView.getMetaModelManager().getPivotOf(Element.class, eTarget.eClass());
								environmentView.addElementsOfScope(element, scopeView);
							} catch (ParserException e) {
								// Ignore parse failure; could be systemic and prolific
							}
						}
					}
				}
			}
		}
		return scopeView.getParent();
	}
}
